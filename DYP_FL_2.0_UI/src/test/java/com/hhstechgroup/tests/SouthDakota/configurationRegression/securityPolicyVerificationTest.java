package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)
public class securityPolicyVerificationTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Security policy and
     * verifies base configurations for Login Time out
     * verifies base configurations for Auto Terminate
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void enableAutoTerminateSwitchVerificationTest() {
        Reports.log("The following Stories will be covered as part of this Test:\nPECS-990");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        dashboardPage.openSystemOptions();
        systemOptions.userSecurityPolicyTileVerification();
    }
}
