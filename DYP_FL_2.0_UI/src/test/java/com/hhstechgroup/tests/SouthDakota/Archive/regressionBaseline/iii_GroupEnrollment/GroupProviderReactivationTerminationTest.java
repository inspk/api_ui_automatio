package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This test class verifies the changing of a Group enrollment status from 'Reactivated' to 'Terminated'.
 */
public class GroupProviderReactivationTerminationTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);

    /**
     * This test method retrieves a Group enrollment with 'Reactivated' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, terminates the enrollment, logs out as the Internal
     * User and writes the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithReactivatedStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void reactivateTerminateProvider(String testEnvironment,String firstName, String lastName, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Select Reactivated enrollment
        03. Terminate the enrollment
        04. Search provider by name
        05. Select Terminated enrollment for Status verification
    */
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.searchProviderInProviders(firstName + " " + lastName);
        enrollmentPageInternalUser.searchSpecificEnrollmentAndClick(15, Data.APPLICATION_STATUS_ACTIVE);

        //Terminate Enrollment
        enrollmentPageInternalUser.terminateTheEnrollmentApplication();

        //Search For Terminated Enrollment
        enrollmentPageInternalUser.clickProvidersTab();

        enrollmentPageInternalUser.searchProviderInProviders(firstName + " " + lastName);
        enrollmentPageInternalUser.searchSpecificEnrollmentAndClick(5,Data.APPLICATION_STATUS_TERMINATED);

        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_TERMINATED);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet, Data.groupApplication,firstName,lastName,Data.APPLICATION_STATUS_TERMINATED);
        excel.readExcel();

    }

 }
