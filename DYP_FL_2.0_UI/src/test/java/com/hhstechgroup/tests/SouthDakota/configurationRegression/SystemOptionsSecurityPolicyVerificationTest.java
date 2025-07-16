package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test verifies the Security Policy system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsSecurityPolicyVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void securityPolicyConfiguration() throws Exception{

        //Verify Security Policy System Option configuration
        verifyConfiguration.verifySecurityPolicySO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_SECURITY_POLICY);
    }
}
