package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

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
 * This class contains a test that uses a data provider to get a Denied Individual provider, Creates an appeal request for that provider and Denies it.
 */
public class IndividualProviderAppealDenialProcessTest extends BaseClassUI {
    /**
     * This method logs in as a Denied Individual provider. Creates an Appeal request by clicking on the on appeal button. Fills in the section, uploads document
     *  and submits the application. Logs in as Internal user. Navigates to Appeal tabs, search for the provider
     * and changes the status of appeal to Denied and updates ProviderInfo.xlsx
     * @param firstName firstName column value from ProviderInfo.xlsx
     * @param lastName lastName column value from ProviderInfo.xlsx
     * @param emailID email column value from ProviderInfo.xlsx
     * @param trackingNum trackingNum column value from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = {"DenyIndividualEnrollment"})
    public void individualEnrollmentAppealAndDeny(String testEnvironment,String firstName, String lastName, String emailID,String trackingNum) throws IOException {

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
