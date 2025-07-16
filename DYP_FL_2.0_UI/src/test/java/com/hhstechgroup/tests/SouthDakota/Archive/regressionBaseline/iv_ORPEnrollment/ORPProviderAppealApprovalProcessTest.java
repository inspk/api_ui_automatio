package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get a denied ORP and appeals and approves it.
 */
public class ORPProviderAppealApprovalProcessTest extends BaseClassUI {
    String enrollmentType = Data.ORP_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as a denied ORP provider. Clicks on appeal button, fills in the section, uploads document
     * and submits. Then logs in as an internal user, changes the status of appeal to approve and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trakingNumber
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getORPProviderNameWithStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"RegisterAndSubmitORPEnrollment","ORPAdditionalInfoAndDenyApplication"},groups={"ORPAppealApprove"})
    public void ORPEnrollmentAppealAndApprove(String testEnvironment, String firstName, String lastName, String emailID,  String trakingNumber ) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageProvider.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);
        enrollmentPageProvider.javaWaitSec(5);
        String requestID = enrollmentPageProvider.getRequestID(Locators.REQUEST_ID);
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName+" "+lastName + requestID);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus();
        enrollmentPageProvider.javaWaitSec(5);
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.PROVIDER_TYPE_ORP,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageInternalUser.verifyTheStatusOfApplication();

        ProviderInformation.updateProviderData(providerInfoSheet, Data.orpApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}
