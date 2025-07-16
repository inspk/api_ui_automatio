package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.*;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * This class contains a test which uses a data provider to register a new Provider and, creates and submits a PEM enrollment and approve as Internal user
 */
@Listeners(VideoListener.class)
public class PEMEnrollmentProviderTest extends BaseClassUI {
    String zipCode;
    String testEmailAccount;
    String npi;
    ExcelWrite excel =
            new ExcelWrite(providerInfoSheet, 0);
    String trackingNum;

    /**
     * This method creates the "Enrollment Application Data" DataProvider containing the following:
     * {testEmailAccount, Data.[Application Type],HomePage.generateEmail("gmail.com"),
     * HomePage.generateFirstName(),HomePage.generateLastName(),"[Payment Method]",
     * [Only used for PEM for affiliation purposes (Not built all the way at this time)],
     * "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
     *
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
                {testEnvironment, testEmailAccount, Data.pemApplication, HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.middleName},
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
     * @throws Exception
     */
    @Video
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Test(dataProvider = "Enrollment type", groups = "RegisterAndSubmitPEMEnrollment")
    public void registerPemEnrollment(String testEnvironment, String testEmailAccount, String enrollmentType,
                                      String newEmail, String firstName, String lastName, String middleName) throws Exception {

        //Gmail Delete
        email.deleteTestAccountEmails(testEmailAccount);
        driver.get(environmentUrl);

        //Registration
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        Reports.log("New NPI: " + npi);
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        Reports.log("New Zip: " + zipCode);
        String ssnNum = sdhomePage.generateANumberOfLength(10);
        Reports.log("SSN Number: " + ssnNum);

        driver.get(environmentUrl);
        Reports.log("\nGo to Environment and Start Registration of Provider");
        providerRegistrationPage.openRegistrationPage();
        providerRegistrationPage.createNewProviderAccount(
                newEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                sdhomePage.generateNewNumber(10));

        //Confirm Email
        email.openGmailAndClickConformAccountLink(newEmail);

        //Login Application with newly Registered provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Starting PEM Enrollment Process
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        //Identifying Information
        providerEnrollingPage.fillInProviderIdentifyingInformationPEM(
                firstName, lastName, Data.phone, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                ssnNum, Data.profitStatusNonProfit, enrollmentType);

        //Service Location
        providerEnrollingPage.fillInServiceLocationSectionforPEM(enrollmentType,newEmail,zipCode,Data.TAXONOMY_PHYSICAL_THERAPIST,Data.PHYSICAL_THERAPIST_SPECIALITY);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformationForPEM(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD,newEmail);

//        //Provider Agreement Section
//       providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
//        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        providerEnrollingPage.summarySection(firstName,lastName);
//        dashboardPage.HelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, newEmail, providerEmailPassword, "", npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        excel.readExcel();

        Data.ProviderID= trackingNum;


        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1930");
    }
}

