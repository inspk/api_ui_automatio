package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
/**
 * This test verifies the Payment and Fees system option configuration
 */
@Listeners(VideoListener.class)
public class SystemOptionsPaymentAndFeesVerificationTest extends BaseClassUI {

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void paymentAndFeesConfiguration() throws Exception {

        //Verify Payment and Fees System Option configurations
        verifyConfiguration.verifyPaymentFeesSO(internalUserEmail, internalUserPassword, SDConfigurationConstants.TITLE_PAYMENTS_FEES);
    }
}
