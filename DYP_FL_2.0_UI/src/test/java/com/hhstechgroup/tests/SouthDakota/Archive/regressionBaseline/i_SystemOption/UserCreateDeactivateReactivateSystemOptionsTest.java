package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 *  This class contains tests for User Deactivation and Reactivation processes under System Options.
 */
public class UserCreateDeactivateReactivateSystemOptionsTest extends BaseClassUI {
    public String emailId = HomePage.generateEmail("sanity.test.provider", "gmail.com");
    public String firstName = HomePage.generateFirstName();
    public String lastName = HomePage.generateLastName();

    /**
     * This method logs in as super Admin. Goes to System Options and clicks on Deactivation Title.Create a New Internal User
     * and Logs in through as that User.Logs out and Logs back in as the Super Admin. Go to the System Options and deactivates
     * the newly created Users and Logs out. Then Logs in as deactivated user and Verify the message on the screen.
     *
     * Logs in Back as super Admin and Activates the uses and Logs out. Logs in as internal Users and verifies it
     */
    @Video
    @Test
    public void userCreateDeactivateReactivate() {

        email.deleteEmails();
        Reports.log("Go to Environment");
        driver.get(environmentUrl);

        // Login as an Internal user and create a new user
        Reports.log("This test for multiple User creation ");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.createUser(firstName, lastName, emailId, "Provider Specialist");
        enrollmentPageInternalUser.logOut();
        homePage.javaWaitSec(3);

        email.openGmailWithoutRegistration();
        email.findAndClickRegistrationLinkOnGmailInternalUser(emailId);
        email.setPasswordForNewEmailRegistration(providerEmailPassword);

        //login as a new user
        Reports.log("Login in as a new user");
        homePage.signInToApp(emailId, providerEmailPassword);
        homePage.javaWaitSec(3);

        // Verify all the Tabs are present for the user
        homePage.verifyAllTabsAreDisplayedForNewUser();
        enrollmentPageInternalUser.logOut();

        //login as a Internal user an deactivate new user
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToUserOption();

        //Search the user which is active by entering the email
        email.searchUserByEmail(emailId);

        //Select deactivate option
        systemOptionsIE.userCreateDeactivateInactivate(Data.TEXT_DEACTIVATE, Data.TEXT_DEACTIVATE);
        enrollmentPageInternalUser.logOut();

        //login as a deactivated user
        Reports.log("Click Sign in / Register button");

        enrollmentPageProvider.clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
        Reports.log("Type username: " + emailId);
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(emailId);

        Reports.log("Type password: " + providerEmailPassword);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD_LOGIN).sendKeys(providerEmailPassword);

        coc.javaWaitSec(3);
        Reports.log("Click login button");
        enrollmentPageProvider.clickAnyButton(Data.TEXT_LOGIN);
        coc.javaWaitSec(1);

        //******************************************
        //Workaround
        //This is a workaround to get the error message attached to DOM when an inactivate user tries to login
        //The flow is: click on register button and click anywhere in the page and click on Sign In/Register button
        homePage.clickAnyButton(Data.TEXT_REGISTER, 1);
        coc.javaWaitSec(1);
        driver.findElement(By.xpath("//div[@aria-label='Registration']")).click();
        coc.javaWaitSec(1);
        enrollmentPageProvider.clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
        WebElement errorMeesage = driver.findElement(By.xpath("//div[contains(@class,'utils_field-errors')]/div"));
        Reports.log("Message is displayed as : " + errorMeesage.getText());
        driver.navigate().refresh();
        //******************************************

        //login as Internal user and inactivate user
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToUserOption();

        //Search the user which is active by entering the email
        email.searchUserByEmail(emailId);

        //Select activate option
        systemOptionsIE.userCreateDeactivateInactivate(Data.TEXT_UPPERCASE_REACTIVATE, Data.TEXT_UPPERCASE_REACTIVATE);
        enrollmentPageInternalUser.logOut();

        //login again as an active new user
        Reports.log("Login in as an active user");
        homePage.signInToApp(emailId,providerEmailPassword);
        homePage.javaWaitSec(3);

        // Verify all the Tabs are present for the user
        homePage.verifyAllTabsAreDisplayedForNewUser();
        enrollmentPageInternalUser.logOut();
    }
}
