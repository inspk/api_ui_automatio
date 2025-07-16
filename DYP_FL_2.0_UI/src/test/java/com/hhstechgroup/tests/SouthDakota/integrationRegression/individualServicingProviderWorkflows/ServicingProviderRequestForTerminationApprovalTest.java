package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualServicingProviderWorkflows;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Test;

public class ServicingProviderRequestForTerminationApprovalTest extends BaseClassUI {
    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test terminates and reactivates Billing Provider.
     *
     * @param testEnvironment
     * @param applicationType
     * @param email
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue = true)
    @Video
    @Test(dataProvider = "getServicingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void providerRequestTerminateReactivateServicingProvider(String testEnvironment, String applicationType, String firstName, String lastName,
                                                                 String email, String trackingNum) throws Exception {
        Data.ENROLLMENT_REQUEST_NO = trackingNum;
        Data.ENROLLMENT_APPLICATION_TYPE = applicationType;

        //Reset the enrollmentType written to Provider Info sheet
        applicationType = Data.SERVICING_PROVIDER_REQUEST_TERMINATION;

//         Login as Provider and Submit Request for Termination
        requestSubmission.submitProviderTerminationRequest(testEnvironment,applicationType, firstName, lastName, email,providerEmailPassword, Data.APPLICATION_STATUS_SUBMITTED);

        String termination_request_ID =  ProviderInformation.getTrackingNumber(providerInfoSheet, applicationType, Data.APPLICATION_STATUS_SUBMITTED);

//        Login as Internal user and approve the Termination Request
        requestStatusChange.approveProviderTerminationRequest(testEnvironment, environmentUrl, applicationType,
                internalUserEmail, internalUserPassword, firstName, lastName, email,providerEmailPassword,termination_request_ID, Data.TEXT_TERMINATE);

        //Login as Internal User and reactivate the Terminated Provider
        requestStatusChange.reactivateTerminatedProvider(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, email, providerEmailPassword, Data.APPLICATION_STATUS_ACTIVE);
    }
}
