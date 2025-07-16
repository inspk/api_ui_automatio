package com.hhstechgroup.tests.SouthDakota.Archive.IntegrationRefression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * This test class verifies the Individual Billing Enrollment Suspension workflow
 */

@Listeners(VideoListener.class)
public class BillingEnrollmentManualTerminateAndReactiveTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test suspends and reactivates TP Provider.
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param provideEmailID
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getBillingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateIndividualProvider(String testEnvironment, String enrollmentType, String firstName, String lastName, String provideEmailID, String trackingNum) throws Exception {

        requestStatusChange.providerStatusChange(enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, provideEmailID, providerEmailPassword, Data.TEXT_TERMINATE, enrollmentFormElements);

        String trackingId =  ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_TERMINATED);

        requestStatusChange.providerStatusChange(enrollmentType,internalUserEmail,
                internalUserPassword, firstName, lastName,trackingId, provideEmailID,  providerEmailPassword, Data.APPLICATION_STATUS_REACTIVATE_TERMINATED, enrollmentFormElements);
    }
}
