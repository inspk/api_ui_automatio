package com.hhstechgroup.tests.SouthDakota.integrationRegression.tradingPartnerProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)
public class TPProviderEnrollmentCoCDenialTest extends BaseClassUI {


    protected String providerInfoSheet = "ProviderInfo.xlsx";

    public TPProviderEnrollmentCoCDenialTest() throws IOException {
    }

    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void denialAndVerifyingTPCoC(String testEnvironment, String enrollmentType, String firstName,String lastName, String provideEmailID, String trackingNum) throws Exception {

        //Define a list of the tabs to be selected
        String[] categoryList = {Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_KEY_PERSONNEL};

        //Reset the enrollmentType written to the Provider Info sheet
        enrollmentType = Data.TRADING_PARTNER_COC;

        requestSubmission.submitCoC( testEnvironment ,enrollmentType, provideEmailID, providerEmailPassword, firstName, lastName, categoryList );

        //Get the ID of the submitted CoC from the Provider Info sheet
        String cocID = ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_SUBMITTED);

        //Set the status of the CoC to 'Denied'
        requestStatusChange.cocStatusChange(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, cocID, provideEmailID, providerEmailPassword, Data.ApplicationStatusDenied);

    }
}
