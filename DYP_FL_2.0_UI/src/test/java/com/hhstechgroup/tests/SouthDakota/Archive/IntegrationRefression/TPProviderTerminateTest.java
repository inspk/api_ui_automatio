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
 *  This test class verifies the TP Enrollment Termination workflow
 */
@Listeners(VideoListener.class)
public class TPProviderTerminateTest extends BaseClassUI {


    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test terminates a TP Provider.
     * @param testEnvironment
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param provideEmailID
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateTPProvider(String testEnvironment, String enrollmentType, String firstName, String lastName, String provideEmailID, String trackingNum) throws Exception {

        requestStatusChange.providerStatusChange(enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, provideEmailID, providerEmailPassword, Data.TEXT_TERMINATE, enrollmentFormElements);
    }
}
