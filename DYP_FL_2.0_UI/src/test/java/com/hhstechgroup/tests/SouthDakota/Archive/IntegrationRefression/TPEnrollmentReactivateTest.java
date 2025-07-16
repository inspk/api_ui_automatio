package com.hhstechgroup.tests.SouthDakota.Archive.IntegrationRefression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 *  * This test class verifies the TP Enrollment Termination workflow
 */
@Listeners(VideoListener.class)
public class TPEnrollmentReactivateTest extends BaseClassUI {


    protected String providerInfoSheet = "ProviderInfo.xlsx";
    public TPEnrollmentReactivateTest() throws IOException {
    }

    /**
     * This test reactivates a terminated TP Provider.
     * @param testEnvironment
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param provideEmailID
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusTerminated", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateAndActivateProvider(String testEnvironment, String enrollmentType, String firstName,String lastName, String provideEmailID, String trackingNum) throws Exception {

        String trackingId =  ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_TERMINATED);
        System.out.println(trackingId);


        requestStatusChange.providerStatusChange(enrollmentType,internalUserEmail,
                internalUserPassword, firstName, lastName,trackingId, provideEmailID,  providerEmailPassword, Data.APPLICATION_STATUS_REACTIVATE_TERMINATED, enrollmentFormElements);


    }
}
