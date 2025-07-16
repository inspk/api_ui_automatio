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
 * This test class changes the status of a Group enrollment from 'Active' to 'Suspended', then reactivates
 * the enrollment.
 */
public class GroupProviderSuspensionReactivationTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test method retrieves a Group enrollment with 'Active' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, suspends the enrollment, verifies the enrollment
     * status, reactivates the enrollment, verifies the enrollment status, logs out as the Internal User and writes the
     * status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithActiveStatus",
          dataProviderClass = DataProviderForProviderInfo.class)
    public void suspendReactivateProvider(String testEnvironment,String firstName, String lastName, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Select Active enrollment
        03. Suspend the enrollment
        04. Search provider by name
        05. Reactivate the enrollment
        06. Search provider by name
        07. Select Active enrollment for Status verification
    */

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.searchProviderInProviders(firstName + " " + lastName);

        enrollmentPageInternalUser.searchSpecificEnrollmentAndClick(15,Data.APPLICATION_STATUS_ACTIVE);

        //Suspend Enrollment
        enrollmentPageInternalUser.suspendTheEnrollmentApplication();

        //Search For Suspended Enrollment
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.searchProviderInProviders(firstName + " " + lastName);

        enrollmentPageInternalUser.searchSpecificEnrollmentAndClick(5,Data.APPLICATION_STATUS_SUSPENDED);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_SUSPENDED);

        //Reactivate Enrollment
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();

        //Search For Reactivated Enrollment
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.searchProviderInProviders(firstName + " " + lastName);
        enrollmentPageInternalUser.searchSpecificEnrollmentAndClick(5,Data.APPLICATION_STATUS_ACTIVE);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.groupApplication,firstName,lastName,Data.APPLICATION_STATUS_REACTIVATED);
        excel.readExcel();
    }
 }
