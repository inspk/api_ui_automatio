package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test verifies the User Profile system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsUserProfileVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void userProfileConfiguration() throws Exception {

        //Verify User Profile System Option configurations
        verifyConfiguration.verifyUserProfileSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_USER_PROFILE);

    }
}
