package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test verifies the Auto Archive system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsAutoArchiveVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void autoArchiveConfiguration() throws Exception {

        //Verify System Option configuration
        verifyConfiguration.verifyAutoArchiveSO(internalUserEmail, internalUserPassword, "Auto Archive");

    }
}
