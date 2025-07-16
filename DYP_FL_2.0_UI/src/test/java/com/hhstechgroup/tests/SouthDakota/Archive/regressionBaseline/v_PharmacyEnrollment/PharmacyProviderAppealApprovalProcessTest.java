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
 * This class contains a test which uses a data provider to get a denied pharmacy and appeals and approves it.
 */
public class PharmacyProviderAppealApprovalProcessTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as a denied pharmacy enrollment, clicks on appeal button, fills in the section, uploads document
     * and submits. Then logs in as an internal user and changes the status of appeal to approve and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trakingNumber
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPharmacyProviderNameWithDeniedStatus"  ,
            dataProviderClass = DataProviderForProviderInfo.class)
    public void PharmacyEnrollmentAppealAndApprove(String testEnvironment,String firstName, String lastName, String emailID,  String trakingNumber ) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageProvider.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);
        enrollmentPageProvider.javaWaitSec(5);
        String requestID = enrollmentPageProvider.getRequestID();
        System.out.print(requestID);
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName+" "+lastName,requestID);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus();

        //Search For Active Enrollment
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.searchProviderInProviders(firstName + " " + lastName);
        enrollmentPageInternalUser.searchSpecificEnrollmentAndClick(5,Data.APPLICATION_STATUS_ACTIVE);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);

        //logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet, Data.pharmacyApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}
