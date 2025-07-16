package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * This class contains a test which uses a data provider to get an Active Individual Provider,verifies the changing of a Individual Provider status from
 * 'Suspend to Reactive' and 'Terminate to Reactive'.
 */
@Listeners(VideoListener.class)
public class IndividualProviderTerminateSuspendReactiveProcessTest extends BaseClassUI {
    String enrollmentType ="Individual" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Individual provider with 'Approved' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, Suspend. Logs out and Logs in as the suspended Provider
     * and Verifies the Status, logs out and logs in as the Internal then Reactivates the Provider and Verifies the status
     * updates the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "ApproveIndividualEnrollment", priority = 1)
    public void suspendAndReactiveProvider(String testEnvironment,String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.suspendTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusSuspended);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusSuspended);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusSuspended);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusActive);
        excel.readExcel();
    }

    /**
     * This test method retrieves a Individual provider with 'Approved' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, Terminates. Logs out and Logs in as the Terminates Provider
     * and Verifies the Status, logs out and logs in as the Internal then Reactivates the Provider and Verifies the status
     * updates the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class, priority = 2)
    public void terminateReactiveProvider(String testEnvironment,String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusTerminated);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusTerminated);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusActive);
    }
}
