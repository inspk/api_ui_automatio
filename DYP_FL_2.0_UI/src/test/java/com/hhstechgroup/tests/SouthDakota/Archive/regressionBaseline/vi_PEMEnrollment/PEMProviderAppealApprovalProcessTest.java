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
 * This class contains a test which uses a data provider to get a denied PEM and appeals and approves it.
 */
public class PEMProviderAppealApprovalProcessTest extends BaseClassUI {
    /**
     * This method logs in as a denied PEM and clicks on appeal button and fills in the section and uploads document
     * and submits and logs in as an internal user and changes the status of appeal to approve and updates ProviderInfo.xlsx
     */
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    @Video
    @Test(dataProvider="getPemProviderNameAndEmailWithStatusDenied"  ,
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"RegisterAndSubmitPEMEnrollment","DenyPemEnrollment"})
    public void pemEnrollmentAppealAndApprove(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum ) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus();
        enrollmentPageInternalUser.logOut();

        ProviderInformation.updateProviderData(providerInfoSheet, Data.pemApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}
