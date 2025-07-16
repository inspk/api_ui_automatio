package com.hhstechgroup.tests.SouthDakota.integrationRegression.entityProviderWorkflows;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Test;


public class EntityEnrollmentRevalidationTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    String taxonomy = Data.interpreterTaxonomy ;
    String statusOfApplication = Data.ApplicationStatusApprove ;


    /**
     * This test revalidates Entity Provider.
     *
     * @param testEnvironment
     * @param applicationType
     * @param email
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getEntityProviderNameEmailTypeWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void revalidateEntityProvider(String testEnvironment, String applicationType, String firstName, String lastName,
                                                String email, String trackingNum) throws Exception {

        requestStatusChange.setToRevalidationStatus(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword, firstName, lastName,trackingNum, email,providerEmailPassword, Data.ApplicationStatusApprove);

        applicationType = Data.ENTITY_REVALIDATION;
        requestSubmission.submitRevalidationEnrollment(testEnvironment,applicationType, firstName, lastName, email,providerEmailPassword, Data.APPLICATION_STATUS_ACTIVE);
        String revalidation_RequestID =  ProviderInformation.getTrackingNumber(providerInfoSheet, applicationType, Data.APPLICATION_STATUS_SUBMITTED);

        //IU approves the Revalidation request
        requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, revalidation_RequestID, screeningType, email, providerEmailPassword, Data.APPLICATION_STATUS_APPROVE_REVALIDATION, enrollmentFormElements);
    }
}
