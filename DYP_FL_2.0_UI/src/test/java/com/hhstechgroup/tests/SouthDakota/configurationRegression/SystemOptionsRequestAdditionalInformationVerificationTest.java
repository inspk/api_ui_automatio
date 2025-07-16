package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * This test verifies the Request Additional Information system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsRequestAdditionalInformationVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void raiNotificationConfiguration() throws Exception{

        //Verify RAI System Option configurations
        verifyConfiguration.verifyRAISO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_REQUEST_ADDITIONAL_INFO);
    }
}
