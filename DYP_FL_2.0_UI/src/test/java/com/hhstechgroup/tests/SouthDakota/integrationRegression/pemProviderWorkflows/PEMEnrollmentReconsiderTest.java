package com.hhstechgroup.tests.SouthDakota.integrationRegression.pemProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class PEMEnrollmentReconsiderTest extends BaseClassUI {
    String testEmailAccount;
    String zipCode;
    String npi;
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor Excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);


    @JiraDefectCreateIssue(isCreateIssue = true)
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusDenied", dataProviderClass = DataProviderForProviderInfo.class)
    public void reconsiderApprovalPEMEnrollment(String testEnvironment, String applicationType, String firstName, String lastName, String newEmail, String trackingNum) throws Exception {

        //Capture the Tracking Number and Application Type of the Denied Provider retrieved from the Provider
        //Info sheet.  These values will be used to update the status of the Provider in the Provider Info
        //Sheet following the Approval of the Reconsideration
        Data.ENROLLMENT_REQUEST_NO = trackingNum;
        Data.ENROLLMENT_APPLICATION_TYPE = applicationType;

        //Reset the enrollmentType written to Provider Info sheet
        applicationType = Data.PEM_PROVIDER_RECONSIDERATION;

        //Submit the Reconsideration
        requestSubmission.submitReconsideration(testEnvironment,applicationType, firstName, lastName, newEmail,
                providerEmailPassword, Data.APPLICATION_STATUS_SUBMITTED);

        //Retrieve the Request ID of the submitted Reconsideration from the Provider Info sheet
        String reconsideration_RequestID =  ProviderInformation.getTrackingNumber(providerInfoSheet, applicationType, Data.APPLICATION_STATUS_SUBMITTED);

        //Approve the Reconsideration request
        requestStatusChange.reconsiderationStatusChange(testEnvironment, environmentUrl, applicationType,
                internalUserEmail, internalUserPassword, firstName, lastName, reconsideration_RequestID, newEmail,
                providerEmailPassword, Data.ApplicationStatusApprove);
    }
}
