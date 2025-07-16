package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * This test verifies the Site Visits system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsSiteVisitVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void siteVisitConfiguration() throws Exception {

        //Verify Site Visit System Option configurations
        verifyConfiguration.verifySiteVisitSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_SITE_VISIT);

    }
}
