package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test verifies the Affiliations system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsAffiliationsVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void affiliationConfiguration() throws Exception {

        //Verify System Option configuration
        verifyConfiguration.verifyAffiliationSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_AFFILIATIONS, dashboardPage);

    }
}
