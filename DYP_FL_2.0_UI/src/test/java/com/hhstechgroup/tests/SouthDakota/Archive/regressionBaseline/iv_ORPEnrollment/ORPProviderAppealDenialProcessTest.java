package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)
/**
 * This class contains a test which uses a data provider to get a denied ORP and appeals and deny it.
 */


public class ORPProviderAppealDenialProcessTest extends BaseClassUI {

    /**
     * This method logs in as a denied ORP provider. Clicks on appeal button, fills in the section, uploads document
     * and submits. Then logs in as an internal user, changes the status of appeal to deny and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getORPProviderNameWithStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class)
    //, dependsOnGroups = {"RegisterAndSubmitORPEnrollment","ORPAdditionalInfoAndDenyApplication"})
    public void orpEnrollmentAppealAndDeny(String testEnvironment,String firstName, String lastName, String emailID,String trackingNum) throws IOException {

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
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider("", requestID);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusDenied);

        //Search For Denied Appeal
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider("", requestID);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_DENIED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_DENIED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();
    }
}
