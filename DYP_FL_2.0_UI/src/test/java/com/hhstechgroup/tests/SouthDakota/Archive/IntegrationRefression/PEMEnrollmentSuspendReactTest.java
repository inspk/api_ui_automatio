package com.hhstechgroup.tests.SouthDakota.Archive.IntegrationRefression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * This test class verifies the PEM Enrollment Suspension workflow
 */

@Listeners(VideoListener.class)
public class PEMEnrollmentSuspendReactTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test suspends and reactivates PEM Provider.
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
    @Test(dataProvider = "getPEMProviderNameEMailTypeActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void suspendReactivatePEMProvider(String testEnvironment, String applicationType, String firstName, String lastName,
                                     String email, String trackingNum) throws Exception {

        requestStatusChange.providerStatusChange(applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingNum, email, providerEmailPassword, Data.APPLICATION_STATUS_SUSPENDED, enrollmentFormElements);

        requestStatusChange.providerStatusChange(applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingNum, email, providerEmailPassword, Data.APPLICATION_STATUS_REACTIVATE_SUSPENDED, enrollmentFormElements);

    }
}
