package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

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
 * This test class verifies denying the appeal of a denied Group enrollment.
 */
public class GroupProviderAppealDenialProcessTest extends BaseClassUI {

    /**
     * This test method retrieves a Group enrollment with 'Denied' status from ProviderInfo.xlsx, logs into DyP as the
     * Group Provider, creates an enrollment appeal request, logs out as the Group Provider, logs into DyP as an
     * Internal User, executes a search for the enrollment appeal request, denies the enrollment appeal request,
     * verifies the status of the denied enrollment appeal request and logs out as the Internal User.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void groupEnrollmentAppealAndDeny(String testEnvironment,String firstName, String lastName, String emailID,String trackingNum) throws IOException {

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
