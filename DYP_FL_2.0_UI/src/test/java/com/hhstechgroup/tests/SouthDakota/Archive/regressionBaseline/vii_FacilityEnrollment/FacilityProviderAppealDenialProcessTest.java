package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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
 * This test class verifies denying the appeal of a denied Facility enrollment.
 */
@Listeners(VideoListener.class)
public class FacilityProviderAppealDenialProcessTest extends BaseClassUI {

    /**
     * This test method retrieves a Facility enrollment with 'Denied' status from ProviderInfo.xlsx, logs into DyP as
     * the Facility Provider, creates an enrollment appeal request, logs out as the Facility Provider, logs into DyP as
     * an Internal User, executes a search for the enrollment appeal request, denies the enrollment appeal request,
     * verifies the status of the denied enrollment appeal request and logs out as the Internal User.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getFacilityProviderInfoWithStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = {"DenialFacilityEnrollment"})
    public void facilityEnrollmentAppealAndDeny(String testEnvironment, String firstName, String lastName, String emailID,String trackingNum) throws IOException {

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
