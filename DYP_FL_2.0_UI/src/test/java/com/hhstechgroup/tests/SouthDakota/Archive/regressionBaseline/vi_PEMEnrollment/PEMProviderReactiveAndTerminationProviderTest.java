package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

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
 * This class contains a test which uses a data provider to get an active PEM and terminates and reactive.
 */
public class PEMProviderReactiveAndTerminationProviderTest extends BaseClassUI {
    String enrollmentType ="Provider Enrollment Manager" ;
    ExcelWrite excel =
            new ExcelWrite(providerInfoSheet, 0);

    /**
     * This method logs in as an internal user and searches for the provider and verifies the status is active and
     * clicks on the provider and terminates.For verification it searches for provider and verifies the status is "Terminated".
     * Then clicks on the provider and reactive by filling the date and the reason.For verification checks the status to see if the status is active.
     * At the end ProviderInfo.xlsx will be updated
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusActive",
            dataProviderClass = DataProviderForProviderInfo.class , dependsOnGroups = {"suspendReactivate"})
    public void verifyPemEnrollmentTerminateAndReactive(String testEnvironment,String firstName, String lastName , String emailID, String trackingNum) throws IOException {
        Reports.log("This test is to  verify request by PEM termination and reactivation ");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType, firstName + " " + lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType, firstName + " " + lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_TERMINATED);
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
        enrollmentPageInternalUser.logOut();

       ProviderInformation.updateProviderData(providerInfoSheet, Data.pemApplication,firstName,lastName,Data.applicationStatusActive);
       excel.readExcel();
    }
}

