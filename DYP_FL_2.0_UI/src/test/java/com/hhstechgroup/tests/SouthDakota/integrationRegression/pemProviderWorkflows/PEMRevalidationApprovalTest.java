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
 * This test class verifies the PEM Revalidation Approval workflow
 */
@Listeners(VideoListener.class)

public class PEMRevalidationApprovalTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";

    /**
     * This test creates a PEM Revalidation Request and approves it
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param email
     * @param trackingNum
     *
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getPEMProviderNameEMailTypeActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void approvePEMRevalidation(String testEnvironment, String enrollmentType, String firstName, String lastName,
                                          String email, String trackingNum) throws Exception {

        //Set the Revalidation status of the enrollment
        requestStatusChange.setToRevalidationStatus(testEnvironment, environmentUrl, enrollmentType, internalUserEmail,
                internalUserPassword, firstName, lastName, trackingNum, email, providerEmailPassword, Data.ApplicationStatusApprove);

        //Reset the enrollmentType written to the Provider Info sheet
        enrollmentType = Data.PEM_PROVIDER_REVALIDATION;

        //Submit the Revalidation
        requestSubmission.submitRevalidationEnrollment(testEnvironment, enrollmentType, firstName, lastName, email,
                providerEmailPassword, Data.APPLICATION_STATUS_ACTIVE);

        //Retrieve the Request ID of the submitted Revalidation from the Provider Info sheet
        String revalidation_RequestID = ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType,
                Data.APPLICATION_STATUS_SUBMITTED);

        //Approve the Revalidation request
        requestStatusChange.enrollmentStatusChange(testEnvironment, environmentUrl, enrollmentType, internalUserEmail,
                internalUserPassword, firstName, lastName, revalidation_RequestID, screeningType, email, providerEmailPassword,
                Data.APPLICATION_STATUS_APPROVE_REVALIDATION, enrollmentFormElements);

    }
}
