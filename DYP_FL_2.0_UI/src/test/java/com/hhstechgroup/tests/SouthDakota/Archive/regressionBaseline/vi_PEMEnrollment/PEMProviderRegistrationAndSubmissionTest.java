package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to register a new Provider and, creates and submits a PEM enrollment
 */
public class PEMProviderRegistrationAndSubmissionTest extends BaseClassUI {
    DataFiles dataFiles = new DataFiles();
    String zipCode;
    String testEmailAccount;
    public String providerEmail;
    private Object String;
    String ProviderFirstName;
    String ProviderLastName;
    String statusOfApplication ;
    ExcelWrite excel =
            new ExcelWrite( "ProviderInfo.xlsx",0);

    /**
     * This method creates the "Enrollment Application Data" DataProvider containing the following:
     * {testEmailAccount, Data.[Application Type],HomePage.generateEmail("gmail.com"),
     * HomePage.generateFirstName(),HomePage.generateLastName(),"[Payment Method]",
     * [Only used for PEM for affiliation purposes (Not built all the way at this time)],
     * "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
     * @param context
     * @return
     */
    @DataProvider(name = "Enrollment type")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");

        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{
                {testEnvironment, testEmailAccount,Data.pemApplication, HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(), HomePage.generateLastName(), "Offline", "No", Data.specialityInterpreter, Data.interpreterTaxonomy},
        };
    }
    /**
     * This method registers a new Provider and creates and submits a PEM enrollment. The flow is first deletes
     * all the exiting emails in gmail and then open registration page and fills all the fields. Opens gmail and clicks on registration link and confirm.
     * Logs in with the email and selects the enrollment type (PEM) and completes all the sections and signs the enrollment. At the end the info writes out to ProviderInfo.xlsx
     *
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @param firstName
     * @param lastName
     * @param paymentOption
     * @param medicareParticipant
     * @param taxonomyCategory
     * @param taxonomy
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "Enrollment type", groups = "RegisterAndSubmitPEMEnrollment")
    public void registerPemEnrollment(String testEnvironment,String testEmailAccount,String enrollmentType,
                                      String newEmail, String firstName, String lastName,
                                      String paymentOption, String medicareParticipant,
                                      String taxonomyCategory, String taxonomy) throws Exception {

        ProviderFirstName = firstName;
        ProviderLastName = lastName;

     /*
     Provider operations:
     Fill in required sections and fields
     Can switch Offline and Online payments
     Can select Approve and Deny
     Select index of internal user for next test cases: Coc, Appeals and Group Affiliation
      */

        email.deleteTestAccountEmails(testEmailAccount);
        driver.get(environmentUrl);

        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);

        homePage.openRegistrationPage();
        homePage.fillInNewRegistrationPage(
                newEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                homePage.generateNewNumber(10));
        providerEmail = newEmail;

        email.openGmailAndClickRegistrationLink(newEmail);

        homePage.signInToApp(newEmail, providerEmailPassword);
        homePage.clickAnyTitleByText(enrollmentType, Data.h2);

        //Identifying Information
        enrollmentPageProvider.fillInIndividualIdentifyingInformation(firstName, lastName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                Data.ssn, Data.profitStatusNonProfit, enrollmentType);

        // Address
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);

        //Provider  Agreement
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary
        enrollmentPageProvider.summarySectionProceedToSignIn();

        //HelloSign
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getProviderTrackingNumber();
        Reports.log("Provider Enrollment Manager has successfully submitted the application");

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,"", statusOfApplication, trackingNum);
        excel.readExcel();
        enrollmentPageInternalUser.logOut();

    }
}
