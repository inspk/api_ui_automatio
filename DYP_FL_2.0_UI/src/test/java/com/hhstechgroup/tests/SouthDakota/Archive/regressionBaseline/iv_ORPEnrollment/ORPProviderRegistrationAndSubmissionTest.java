package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to register a new Provider and, creates and submits an ORP enrollment.
 */
public class ORPProviderRegistrationAndSubmissionTest extends BaseClassUI {
    String npi;
    String zipCode;
    String testEmailAccount;
    String statusOfApplication ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method creates the "Enrollment Application Data" DataProvider containing the following:
     *  {testEmailAccount, Data.[Application Type],HomePage.generateEmail("gmail.com"),
     *  HomePage.generateFirstName(),HomePage.generateLastName(),"[Payment Method]",
     *  [Only used for PEM for affiliation purposes (Not built all the way at this time)],
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
                {testEnvironment,testEmailAccount,Data.orpApplication, HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(), HomePage.generateLastName(), "Offline", "No", Data.specialityAudiology, "231H00000X"},
        };
    }

    /**
     * This method registers a new Provider and creates and submits an ORP enrollment. The flow is first deletes all
     * the exiting emails in gmail, then opens registration page, fills all the fields. Opens gmail, clicks on
     * registration link and confirm. Logs in with the email, selects the enrollment type (ORP enrollment), completes all
     * the sections and signs the enrollment. At the end the info writes out to ProviderInfo.xlsx
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
    @Test(dataProvider = "Enrollment type", groups =  {"RegisterAndSubmitORPEnrollment"}, priority = 0)
    public void registerAndSubmitORPEnrollment(String testEnvironment,String testEmailAccount,String enrollmentType, String newEmail, String firstName, String lastName,
                                               String paymentOption, String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {
        /*
         Provider operations:
         Fill in required sections and fields
         Can switch Offline and Online payments
         Can select Approve and Deny
         Select index of internal user for next test cases: Coc, Appeals and Group Affiliation
          */

        //Gmail Delete
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        Reports.log("Go to Environment and Start Registration of Provider");
        driver.get(environmentUrl);
        npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
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

        //Confirm Email
        email.openGmailAndClickRegistrationLink(newEmail);

        //Start Enrollment Application
        Reports.log("Starting Enrollment Process");
        homePage.signInToApp(newEmail, providerEmailPassword);
        homePage.clickAnyTitleByText(enrollmentType, Data.h2);

        //Identifying Information
        enrollmentPageProvider.fillInIndividualIdentifyingInformation(
                firstName, lastName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                Data.ssn, Data.profitStatusNonProfit, enrollmentType);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail Section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode, Data.inState);

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Payment Section
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        enrollmentPageProvider.javaWaitSec(10);

        // enrollmentPageProvider.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);
        enrollmentPageProvider.ajaxClick(Locators.LINK_DASHBOARD);
        enrollmentPageProvider.javaWaitSec(10);
        driver.navigate().refresh();
        enrollmentPageProvider.javaWaitSec(10);
        statusOfApplication = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
        Reports.log("Status of application is: " + statusOfApplication);
        String trackingNumber=enrollmentPageProvider.getTrackingNumber();
        enrollmentPageProvider.javaWaitSec(20);
        // enrollmentPageInternalUser.logOut();
        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi, Data.APPLICATION_STATUS_SUBMITTED,trackingNumber);
        excel.readExcel();
    }
}
