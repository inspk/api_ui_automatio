package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * This test verifies the Roles system option configuration
 * @throws Exception
 */
@Listeners(VideoListener.class)
public class SystemOptionsRolesVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void rolesConfigurationTest() throws Exception{
        Reports.log("The Test will verify the configuration of the System Options -> Roles");

        //Verify System Option configuration
        verifyConfiguration.verifyRolesSO(internalUserEmail, internalUserPassword, "Roles");

    }
}
