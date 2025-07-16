package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This class contains a test which uses a data provider to get a denied pharmacy, appeals and deny it.
  */
@Listeners(VideoListener.class)
public class PharmacyProviderAppealDenialProcessTest extends BaseClassUI {

    /**
     * This method logs in as a denied pharmacy enrollment, clicks on appeal button and fills in the
     * section, uploads document and submits.Then logs in as an internal user, changes the status
     * of appeal to deny and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getPharmacyProviderNameWithDeniedStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void pharmacyEnrollmentAppealAndDeny(String testEnvironment, String firstName, String lastName, String emailID,String trackingNum) throws IOException {

        //Create and submit Appeal
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageProvider.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);

        //Get Request ID
        String requestID = enrollmentPageProvider.getRequestID(Locators.REQUEST_ID);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of Appeal to Denied
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName+" "+lastName, requestID);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusDenied);

        //Search For Denied Appeal
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName+" "+lastName, requestID);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_DENIED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_DENIED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();
    }
}
