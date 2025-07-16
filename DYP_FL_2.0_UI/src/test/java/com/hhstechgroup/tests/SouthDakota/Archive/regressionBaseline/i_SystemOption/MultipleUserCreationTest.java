package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 *  This class contains tests for creating Multiple users under System Options.
 */

public class MultipleUserCreationTest extends BaseClassUI {
    public String emailId;
    public String firstName;
    public String lastName;

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Users Tile and
     * Create a super Admin user. Logs out and Logs in as Newly created Super Admin and
     * Verifies if all the Tabs are displayed correctly.
     */
    @Video
    @Test
    public void CreateSuperAdminUser() {
        Reports.log("This test is for creating Super Admin user");
        emailId = HomePage.generateEmail("sanity.test.provider", "gmail.com");
        firstName = HomePage.generateFirstName();
        lastName = HomePage.generateLastName();
        Reports.log("Deleting the emails");
        email.deleteEmails();
        Reports.log("Go to Environment");
        driver.get(environmentUrl);

        // Login as an Internal user and create a new user
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.createUser(firstName, lastName, emailId, Data.SUPER_ADMIN_ROLE);
        enrollmentPageInternalUser.logOut();
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
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Users Tile and
     * Create a Supervisor user. Logs out and Logs in as Newly created Supervisor and
     * Verifies if all the Tabs are displayed correctly.
     */
    @Video
    @Test
    public void CreateEnrollmentSupervisorUser() {
        Reports.log("This test is for creating Enrollment Supervisor user");
        emailId = HomePage.generateEmail("sanity.test.provider", "gmail.com");
        firstName = HomePage.generateFirstName();
        lastName = HomePage.generateLastName();
        Reports.log("Deleting the emails");
        email.deleteEmails();
        Reports.log("Go to Environment");
        driver.get(environmentUrl);

        // Login as an Internal user and create a new user
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.createUser(firstName, lastName, emailId, Data.Enrollment_SUPERVISOR_ROLE);
        enrollmentPageInternalUser.logOut();

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
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Users Tile and
     * Create a  Call Center Supervisor user. Logs out and Logs in as Newly created  Call Center Supervisor and
     * Verifies if all the Tabs are displayed correctly.
     */
    @Video
    @Test
    public void CreateCallCenterSupervisorUser() {
        Reports.log("This test is for creating Call Center Supervisor user");
        emailId = HomePage.generateEmail("sanity.test.provider", "gmail.com");
        firstName = HomePage.generateFirstName();
        lastName = HomePage.generateLastName();
        Reports.log("Deleting the emails");
        email.deleteEmails();
        Reports.log("Go to Environment");
        driver.get(environmentUrl);

        // Login as an Internal user and create a new user
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.createUser(firstName, lastName, emailId, Data.CALL_CENTER_SUPERVISOR_ROLE);
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
    }
}


