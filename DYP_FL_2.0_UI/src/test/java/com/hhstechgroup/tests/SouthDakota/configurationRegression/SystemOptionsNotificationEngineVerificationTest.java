package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 *  This class contains tests for Notification Engine configuration under System Options
 */
@Listeners(VideoListener.class)
public class SystemOptionsNotificationEngineVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void notificationEngineConfiguration() throws Exception {

        //Verify Notifications System Option configuration
        verifyConfiguration.verifyNotificationSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_NOTIFICATION_ENGINE);
    }
}
