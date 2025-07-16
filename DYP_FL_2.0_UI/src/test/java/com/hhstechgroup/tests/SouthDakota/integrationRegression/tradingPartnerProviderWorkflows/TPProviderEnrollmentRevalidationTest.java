package com.hhstechgroup.tests.SouthDakota.integrationRegression.tradingPartnerProviderWorkflows;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Test;


public class TPProviderEnrollmentRevalidationTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";


    /**
     * This test revalidates Entity Provider.
     *
     * @param testEnvironment
     * @param applicationType
     * @param providerEmailId
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void revalidateTPProvider(String testEnvironment, String applicationType, String firstName, String lastName,
                                                String providerEmailId, String trackingNum) throws Exception {

        requestStatusChange.setToRevalidationStatus(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword, firstName, lastName,trackingNum,
                providerEmailId,providerEmailPassword, Data.ApplicationStatusApprove);

        applicationType = Data.TRADING_PARTNER_REVALIDATION;
        requestSubmission.submitRevalidationEnrollment(testEnvironment,applicationType, firstName, lastName, providerEmailId,providerEmailPassword,
                Data.APPLICATION_STATUS_ACTIVE);

        String revalidation_RequestID =  ProviderInformation.getTrackingNumber(providerInfoSheet, applicationType, Data.APPLICATION_STATUS_SUBMITTED);

        //IU approves the Revalidation request
        requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, revalidation_RequestID,  screeningType, providerEmailId, providerEmailPassword,
                Data.APPLICATION_STATUS_APPROVE_REVALIDATION, enrollmentFormElements);
    }
}
