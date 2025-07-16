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
 * This test class verifies the PEM Enrollment Termination workflow
 */

@Listeners(VideoListener.class)
public class PEMEnrollmentTerminateTest extends BaseClassUI {

    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test terminates a PEM Provider.
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
    public void terminatePEMProvider(String testEnvironment, String applicationType, String firstName, String lastName,
                                     String email, String trackingNum) throws Exception {

        requestStatusChange.providerStatusChange(applicationType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingNum, email, providerEmailPassword, Data.TEXT_TERMINATE, enrollmentFormElements);

    }
}
