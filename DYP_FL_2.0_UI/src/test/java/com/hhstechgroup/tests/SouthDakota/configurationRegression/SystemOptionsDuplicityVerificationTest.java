package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 *  This class contains tests for Duplicity configuration under System Options.
 */
@Listeners(VideoListener.class)
public class SystemOptionsDuplicityVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void duplicityConfiguration() throws Exception {

        //Verify System Option configuration
        verifyConfiguration.verifyDuplicitySO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_DUPLICITY);

    }
}
