package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 *  This class contains tests for User Deactivation under System Options.
 */
@Listeners(VideoListener.class)
public class SystemOptionsUserDeactivationVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void userDeactivationConfiguration() throws Exception {

        //Verify User Deactivation System Option configuration
        verifyConfiguration.verifyUserDeactivationSO(internalUserEmail, internalUserPassword, "User Deactivation");

    }
}
