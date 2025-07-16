package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get a submitted ORP enrollment and approves the enrollment retroactively.
 */
public class ORPProviderRetroActiveAdjustmentApprovalTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);
    String enrollmentType = "ORP";

    /**
     * This method signs in as an internal user, clicks on enrollment tab, searches for the provider, does
     * the document review and under screening. Then changes the status from "Pending Approval" to "Approved", clicks on "yes" to
     * the question "Do you want to be approved retroactively?". Selects the effect date and reason and then clicks apply button.
     * For verification clicks on provider tab and find the provider and clicks on "Enrollment Span" button to see if the effective from date
     * in Enrollment span section has been changed as defined.
     *
     * @param firstName
     * @param lastName
     * @param trakingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getORPProviderNameWithStatusSubmitted",
          dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = "RetroActiveRegisterAndSubmitORPEnrollment")
    public void verifyORPApproveRetroActiveAdjustment (String testEnvironment,String firstName, String lastName,String trakingNumber) throws Exception {

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trakingNumber);

        //SCREEN ENROLLMENT
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trakingNumber, Data.statusPendingApproval);
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING APPROVAL",trakingNumber);
        enrollmentPageInternalUser.changeStatusOfEnrollmentRetroActive(Data.ApplicationStatusApprove);
        enrollmentPageInternalUser.javaWaitSec(5);
        driver.navigate().refresh();

        //Verify the Enrollment Span of the Provider in the Provider Tab
        enrollmentPageInternalUser.clickEnrollmentSpanInProvidersTab(enrollmentType,firstName, lastName);
        enrollmentPageInternalUser.navigateAndVerifyProvidersEnrollmentSpanStatus(enrollmentType,Locators.AFFILIATION_Note_LIST,-7);

        enrollmentPageInternalUser.logOut();
    }
}