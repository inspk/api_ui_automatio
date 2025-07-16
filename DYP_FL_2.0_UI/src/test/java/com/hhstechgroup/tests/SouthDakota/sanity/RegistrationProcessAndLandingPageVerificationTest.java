package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.*;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class RegistrationProcessAndLandingPageVerificationTest extends BaseClassUI {

    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.IndividualApplication,
     * HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(),
     * HomePage.generateLastName(),"[Payment Method]", "[Answer to the question, are you an enrolled Medicare Provider?
     * (Yes or No)]", Data.specialityInterpreter, Data.interpreterTaxonomy.
     *
     * @param context
     * @return Data object
     */
    @DataProvider(name = "Provider Registration")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");
        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{
                {testEmailAccount,HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName()},

        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, verifies the tiles containing all the enrollment types and verifies help center availability.
     * @param testEmailAccount
     * @param newEmail
     * @param firstName
     * @param lastName
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Provider Registration")
    public void registerProvider(String testEmailAccount,
                                                  String newEmail, String firstName, String lastName) throws Exception {

        /*
         Provider operations:
         Fill in required sections and fields
         Can switch Offline and Online payments
         Can select Approve and Deny
         Select index of internal user for next test cases: Coc, Appeals and Group Affiliation
          */

        //Gmail Delete
        email.deleteTestAccountEmails(testEmailAccount);
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");

        driver.get(environmentUrl);
        Reports.log("Go to Environment and Start Registration of Provider");
        providerRegistrationPage.openRegistrationPage();
        providerRegistrationPage.createNewProviderAccount(
                newEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                BaseActions.generateNewNumber(10));

        //Confirm Email
        email.openGmailAndClickConformAccountLink(newEmail);

        //Start Enrollment Application
        loginPage.signInToApp(newEmail, providerEmailPassword);

        //Verify secure message, Authorize message
       //landingPage.VerifySecureMessages();

        // Verify Agree and disagree buttons
        landingPage.verifyAgreeDisagreeButtons();

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        // Verify tiles
        dashboardPage.verifyTiles();

        //Verify Help center Availability
        dashboardPage.verifyHelpCenter();

        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1932");
    }
}
