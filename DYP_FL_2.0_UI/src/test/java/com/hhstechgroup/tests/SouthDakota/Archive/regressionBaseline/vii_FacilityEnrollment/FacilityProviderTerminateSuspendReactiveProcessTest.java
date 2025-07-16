package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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
 * This test class verifies the suspension/reactivation of a Facility Provider and the termination and reactivation of a
 * Facility Provider.
 */
@Listeners(VideoListener.class)
public class FacilityProviderTerminateSuspendReactiveProcessTest extends BaseClassUI {
    String enrollmentType ="Facility" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Facility enrollment with 'Approved' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, suspends the enrollment, verifies the status of the
     * enrollment, logs out as the Internal User, logs into DyP as the Facility Provider, verifies the status of the
     * enrollment, logs out as the Facility Provider, logs into DyP as an Internal User, executes a search for the
     * enrollment, reactivates the enrollment, logs out as the Internal User and writes the status of the enrollment
     * to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getFacilityProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class,  priority = 1)
    public void suspendAndReactiveProvider(String testEnvironment, String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.suspendTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusSuspended);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityApplication, firstName, lastName, Data.applicationStatusSuspended);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusSuspended);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityApplication,firstName,lastName,Data.applicationStatusActive);
        excel.readExcel();
    }

    /**
     * This test method retrieves a Facility enrollment with 'Approved' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, terminates the enrollment, verifies the status of the
     * enrollment, logs out as the Internal User, logs into DyP as the Facility Provider, verifies the status of the
     * enrollment, logs out as the Facility Provider, logs into DyP as an Internal User, executes a search for the
     * enrollment, reactivates the enrollment, verifies the status of the enrollment, logs out as the Internal User and
     * writes the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getFacilityProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class, priority = 2)
    public void terminateReactiveProvider(String testEnvironment, String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityApplication, firstName, lastName, Data.applicationStatusTerminated);
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
        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityApplication,firstName,lastName,Data.applicationStatusActive);
    }
}
