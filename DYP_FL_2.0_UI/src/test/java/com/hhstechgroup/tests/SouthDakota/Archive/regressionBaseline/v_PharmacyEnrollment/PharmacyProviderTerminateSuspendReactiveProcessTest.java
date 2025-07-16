package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

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
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved pharmacy,suspends, terminates and reactive.
 */
public class PharmacyProviderTerminateSuspendReactiveProcessTest extends BaseClassUI {
    String enrollmentType ="Pharmacy" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as an internal user. Searches for the provider and verifies the status is active. Clicks on the provider
     * and suspends. For verification it searches for provider and verifies the status is "Suspended".
     * Then clicks on the provider and reactive by filling the date and the reason.For verification checks the status to see if
     * the status is active. At the end ProviderInfo.xlsx will be updated
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPharmacyProviderNameWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class,  priority = 1)
    public void suspendAndReactiveProvider(String testEnvironment,String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.suspendTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusSuspended);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusSuspended);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.pharmacyApplication,firstName,lastName,Data.applicationStatusActive);
        excel.readExcel();
    }

    /**
     * This method logs in as an internal user and searches for the provider and verifies the status is active and
     * clicks on the provider and terminates.For verification it searches for provider and verifies the status is "Terminated".
     * Then clicks on the provider and reactive by filling the date and the reason.For verification checks the status to see if
     * the status is active. At the end ProviderInfo.xlsx will be updated
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPharmacyProviderNameWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class, priority = 2)
    public void terminateReactiveProvider(String testEnvironment, String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
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
        ProviderInformation.updateProviderData(providerInfoSheet, Data.pharmacyApplication,firstName,lastName,Data.applicationStatusActive);
    }
}
