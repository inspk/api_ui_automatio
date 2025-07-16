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

@Listeners(VideoListener.class)
public class EntityEnrollmentSuspendReactivateTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test suspends and reactivates Entity Provider.
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param email
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getEntityProviderNameEmailTypeWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void suspendReactivateEntityProvider(String testEnvironment, String enrollmentType, String firstName, String lastName,
                                             String email, String trackingNum) throws Exception {

        requestStatusChange.providerStatusChange(enrollmentType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingNum, email, providerEmailPassword, Data.APPLICATION_STATUS_SUSPENDED, enrollmentFormElements );

        requestStatusChange.providerStatusChange(enrollmentType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingNum, email, providerEmailPassword, Data.APPLICATION_STATUS_REACTIVATE_SUSPENDED,enrollmentFormElements );
    }
}


