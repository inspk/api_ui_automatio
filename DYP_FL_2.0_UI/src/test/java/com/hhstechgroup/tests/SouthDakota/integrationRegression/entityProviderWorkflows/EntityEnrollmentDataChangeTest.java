package com.hhstechgroup.tests.SouthDakota.integrationRegression.entityProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class EntityEnrollmentDataChangeTest extends BaseClassUI {
    @Video
    @Test(dataProvider = "getEntityProviderNameEmailTypeWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class, priority = 3)
    public void modifyProviderDataAndVerify(String testEnvironment, String enrollmentType, String firstName, String lastName, String emailID, String trackingNum) throws Exception {

        requestSubmission.submitProviderDataChange(enrollmentType, internalUserEmail, internalUserPassword, firstName,
                lastName, emailID, providerEmailPassword, trackingNum);
    }
}
