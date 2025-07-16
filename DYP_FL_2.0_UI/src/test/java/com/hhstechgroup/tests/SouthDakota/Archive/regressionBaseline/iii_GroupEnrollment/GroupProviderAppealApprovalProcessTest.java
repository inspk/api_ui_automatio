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
 * This test class verifies approving the appeal of a denied Group enrollment.
 */
public class GroupProviderAppealApprovalProcessTest extends BaseClassUI {

    String statusOfApplication;

    /**
     * This test method retrieves a denied Group enrollment from ProviderInfo.xlsx, logs into DyP as the Group Provider,
     * creates an enrollment appeal request, logs out as the Group Provider, logs into DyP as an Internal User,
     * executes a search for the enrollment appeal request, approves the enrollment appeal request and logs out as
     * the Internal User.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void groupEnrollmentAppealAndApprove(String testEnvironment, String firstName, String lastName, String emailID,String trackingNum) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        statusOfApplication = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
        enrollmentPageInternalUser.logOut();
    }
}
