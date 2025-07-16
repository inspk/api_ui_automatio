package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class LoginPageVerificationTest extends BaseClassUI {

    /**
     * This test method verifies the Img and all the links on the webPage
     */

    @JiraDefectCreateIssue(isCreateIssue = true)
    @Video
//    @Test
    public void verifyLinksOnLoginPage() throws Exception {

        //Verify Img
        Reports.log("\nVerifying DSS Image logo on the Login page");
        loginPage.verifyVisibilityOfImg(Data.LOGO);

        //Verify links
        Reports.log("Verifying Links on the Login page");
        loginPage.verifyTheLink(Data.PROVIDER_SEARCH);
        loginPage.verifyTheLink(Data.CREATE_ACCOUNT);
        loginPage.verifyTheLink(Data.FORGOT_PASSWORD);
        loginPage.verifyTheLink(Data.SHOW_MORE);
        //Verify Support Email
        loginPage.verifyTheLink(Data.SUPPORT_EMAIL);

        loginPage.verifyKeyResourcesLinks();
        loginPage.verifyFooterLinksOnLoginPage();

    }

    @Video
    @JiraDefectCreateIssue(isCreateIssue = true)
    @Test
    public void verifyLinksOnProviderSearchPage() throws Exception{
        //Verify links in provider search page
        loginPage.verifyAndClickOnLink(Data.PROVIDER_SEARCH, Data.PROVIDER_SEARCH, Data.PROVIDER_SEARCH_URL);
        loginPage.verifyProviderSearchPageLink(Data.HOME);
        loginPage.verifyTheLink(Data.CREATE_ACCOUNT);
        loginPage.verifyFooterLinksOnLoginPage();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1928");
    }
}



