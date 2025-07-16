package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualBillingProviderWorkflows;

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

@Listeners(VideoListener.class)
public class BillingReenrollmentApprovalTest extends BaseClassUI {

    String testEmailAccount;
    String zipCode;
    String npi;
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getBillingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void reEnrollApprovalBillingEnrollment(String testEnvironment, String applicationType, String firstName, String lastName, String newEmail, String trackingNum) throws Exception {


        //Reset the enrollmentType written to Provider Info sheet
        applicationType = Data.BILLING_RE_ENROLLMENT;

        String terminateSuspendDays = "0";
        addElements.put(Data.DAYS_TO_TERMINATE_SUSPEND, terminateSuspendDays);
        enrollmentFormElements.setFormElements(addElements);

        requestStatusChange.providerStatusChange(applicationType,internalUserEmail,internalUserPassword, firstName, lastName, trackingNum, newEmail,
                providerEmailPassword, Data.TEXT_TERMINATE, enrollmentFormElements);

        // Login as Provider and Submit Reconsideration or Appeal
        requestSubmission.submitReEnrollment(testEnvironment,applicationType, firstName, lastName, newEmail,providerEmailPassword, Data.APPLICATION_STATUS_SUBMITTED, enrollmentFormElements);

        //This gets the reEnrollment tracking or request ID
        String reEnrollment_RequestID =  ProviderInformation.getTrackingNumber(providerInfoSheet, applicationType, Data.APPLICATION_STATUS_SUBMITTED);

        //IU approves the Reenrollment request
        requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, reEnrollment_RequestID,  screeningType, newEmail, providerEmailPassword, Data.APPLICATION_STATUS_APPROVE_RE_ENROLLMENT, enrollmentFormElements);
    }


}
