package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 *  This class contains tests for Data Change configuration under System Options.
 * @throws Exception
 */
@Listeners(VideoListener.class)
public class SystemOptionsDataChangeVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void dataChangeConfiguration() throws Exception {
        verifyConfiguration.verifyDataChangeSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_DATA_CHANGE);
    }
}
