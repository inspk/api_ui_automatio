package com.hhstechgroup.tests.SouthDakota.integrationRegression.pemProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test class verifies the PEM CoC Approval workflow
 */
@Listeners(VideoListener.class)

public class PEMEnrollmentCoCDenialTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";

    /**
     * This test creates a CoC for an active Provider and denies it
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param provideEmailID
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getPEMProviderNameEMailTypeActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void denyPEMCoC(String testEnvironment, String enrollmentType, String firstName, String lastName,
                           String provideEmailID, String trackingId) throws Exception {

        //Define a list of the tabs to be selected
        String[] categoryList = {Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_ADDRESS};

        //Reset the enrollmentType written to the Provider Info sheet
        enrollmentType = Data.PEM_PROVIDER_COC;

        //Submit the CoC request
        requestSubmission.submitCoC(testEnvironment, enrollmentType, provideEmailID, providerEmailPassword, firstName,
                lastName, categoryList);

        //Get the ID of the submitted CoC from the Provider Info sheet
        String cocID =  ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_SUBMITTED);

        //Set the status of the CoC to 'Denied'
        requestStatusChange.cocStatusChange(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, cocID, provideEmailID, providerEmailPassword, Data.ApplicationStatusDenied);

    }
}
