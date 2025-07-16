package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.Pages.ReconsiderationPage;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class InternalUserModulesSearchVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void verifyInternalUserModulesSearch() {

        //Login as Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Verify search result in provider page
        landingPage.clickProvidersTab();
        providersPage.verifySearchResult();

        //Verify search result in enrollment page
        landingPage.clickEnrollmentTab();
        providerEnrollingPage.verifySearchResult();

        //Verify search result in Coc page
        landingPage.clickCocTab();
        cocPage.verifySearchResult();

//        //Verify search result in Reconsideration page
//        landingPage.clickReconsiderationTab();
//        ReconsiderationPage.


        //Verify search result in Audit page
        landingPage.clickAuditTab();
        auditPage.verifySearchResult();

        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1927");
    }
}