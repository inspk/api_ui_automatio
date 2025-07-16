package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test verifies the Reminders To Reviewers system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsRemindersToReviewersVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void remindersNotificationConfiguration() throws Exception{

        //Verify Reminder to Reviewers System Option configurations
        verifyConfiguration.verifyRemindersSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_REMINDERS_TO_REVIEWERS);
    }
}