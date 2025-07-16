package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualServicingProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(VideoListener.class)
public class ServicingEnrollmentDataChangeTest extends BaseClassUI {
    @Video
    @Test(dataProvider = "getServicingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void modifyProviderDataAndVerify(String testEnvironment, String enrollmentType, String firstName, String lastName, String providerEmailId, String trackingNum) throws Exception {

        requestSubmission.submitProviderDataChange(enrollmentType, internalUserEmail, internalUserPassword, firstName,
                lastName, providerEmailId, providerEmailPassword, trackingNum);
    }
}
