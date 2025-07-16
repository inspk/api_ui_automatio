package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class
SystemOptionsVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void systemOptionsModuleVerification() {
        //Login Application as Internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        dashboardPage.openSystemOptions();

        systemOptions.usersManagementTileVerification();
        dashboardPage.openSystemOptions();
        systemOptions.userRolesTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userScreeningTileVerification();
       systemOptions.userRulesTileVerification();
        systemOptions.userDataChangeTileVerification();

        systemOptions.SDuserApprovalsTileVerificationForProviders();
        systemOptions.userDuplicityTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.SDUserRevalidationTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userLicenseTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userSiteVisitTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userExternalizationTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userAutoArchiveTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userDeactivationTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userSecurityPolicyTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userPaymentAndFeeTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userProfileTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userReminderToReviewersTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userRequestAdditionalInfoTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.userNotificationEngineTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.SDuserAffiliationTileVerification();

        dashboardPage.openSystemOptions();
        systemOptions.SDuserCustomSectionsTileVerification();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1933");
    }

}
