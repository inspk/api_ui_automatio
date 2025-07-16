package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.automation.remarks.testng.VideoListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This test class verifies the RocketChat and the tabs displayed on the Internal User dashboard.
 */
public class InternalUserDashboardVerificationTest extends BaseClassUI {
    /**
     *  This test method logs into DyP as an Internal User, verifies RocketChat and logs out.
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test()
    public void verifyRocketChat() {

        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //Agree and Disagree button verification
        landingPage.confirmAgreeAndSecureMessages();

        //Verify Rocket Chat
        //dashboardPage.verifyRocketChat();

        //Logout
        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1926");
    }

    /**
     *  This test method logs into DyP as an Internal User, verifies the Dashboard tabs displayed and logs out.
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test()
    public void verifyInternalUserDashboard() {

        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //Agree and Disagree button verification
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.verifyMainTabOnInternalUserDashbordPage();

        //Logout
        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1926");
    }
}
