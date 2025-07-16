package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualServicingProviderWorkflows;

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
public class ServicingReenrollmentApprovalTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getServicingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void reEnrollApprovalServicingEnrollment(String testEnvironment, String applicationType, String firstName, String lastName, String newEmail, String trackingNum) throws Exception {


        //Reset the enrollmentType written to Provider Info sheet
        applicationType = Data.SERVICING_RE_ENROLLMENT;

        String terminateSuspendDays = "0";
        addElements.put(Data.DAYS_TO_TERMINATE_SUSPEND, terminateSuspendDays);
        enrollmentFormElements.setFormElements(addElements);

        requestStatusChange.providerStatusChange(applicationType,internalUserEmail,internalUserPassword, firstName, lastName, trackingNum, newEmail,
                providerEmailPassword, Data.TEXT_TERMINATE, enrollmentFormElements);

        // This has been blocked, as it is not receiving the affiliations Notifications/Mails for Entity provider. TO-DO later when the issue got fixed.

        // Login as Provider and Submit Reconsideration or Appeal
        requestSubmission.submitReEnrollment(testEnvironment,applicationType, firstName, lastName, newEmail,providerEmailPassword, Data.APPLICATION_STATUS_SUBMITTED, enrollmentFormElements);

        //This gets the reEnrollment tracking or request ID
        String reEnrollment_RequestID =  ProviderInformation.getTrackingNumber(providerInfoSheet, applicationType, Data.APPLICATION_STATUS_SUBMITTED);

        //IU approves the Reenrollment request
        requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, reEnrollment_RequestID,  screeningType,newEmail, providerEmailPassword, Data.APPLICATION_STATUS_APPROVE_RE_ENROLLMENT, enrollmentFormElements);
    }


}