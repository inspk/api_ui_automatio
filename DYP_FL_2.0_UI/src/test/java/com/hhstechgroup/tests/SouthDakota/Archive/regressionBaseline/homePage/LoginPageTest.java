package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.homePage;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class contains a tests that verifies Login and Password Reset functionalities
 */
public class LoginPageTest extends BaseClassUI {

    String testEmailAccount ;
    String newPassword = "Password2!" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method creates the "Provider Registration" DataProvider containing the following:
     * {testEmailAccount, HomePage.generateEmail("gmail.com"),
     * HomePage.generateFirstName(),HomePage.generateLastName(),
     * @param context
     * @return  Data Object
     */


    @DataProvider(name = "Provider Registration")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{
                {testEmailAccount, HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(),
                        HomePage.generateLastName()},
        };}


    /**
     * This method goes to the DYP application, Clicks on Sign-in Page. Enters invalid email and Verifies the error message.
     * Then Registers a new Provider. and Logs in as newly registered provider and Logs out. Clicks on Forget Password link.
     * Goes to the email and clicks on the link. Resets the password. Then logs the application with new Password
     */

    @Video
    @Test(dataProvider = "Provider Registration")
    public void verifyErrorMsgForInvalidLoginCredentials(String testEmailAccount, String newEmail, String firstName, String lastName) {
        Reports.log("This test is to ");
        homePage.enterLoginCredentials(Data.invalidEmailId, Data.invalidPassword);
        // String displayedErrorMessage = homePage.getAlertErrorMessage();
        // homePage.verifyTheAlertMessage(displayedErrorMessage, Data.invalidLoginErrorMessage);

        //Gmail Delete
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        Reports.log("Go to Environment and Start Registration of Provider");
        driver.get(environmentUrl);
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
        enrollmentPageInternalUser.logOut();
        homePage.clickOnSignInOrRegisterButton();
        homePage.enterUserName(newEmail);

        //Click on Forgot Password link
        homePage.clickOnForgotPassword();
        homePage .enterEmailIdAndClickOnResetPwdBtn(newEmail);
        email.openGmailAndClickResetPasswordLink(newEmail);

        //Change password
        homePage.enterNewPasswordAndConfirmPassword(newPassword);
        homePage.signInToApp(newEmail, newPassword);
        Reports.log("Application successfully login with new password :"+newPassword);
    }

}
