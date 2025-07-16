package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This class contains a test which uses a data provider to get a submitted Individual enrollment and approve the enrollment retroactively.
 */

@Listeners(VideoListener.class)
public class IndividualProviderRetroActiveAdjustmentApprovalTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String enrollmentType = "Individual";

    /**
     * This method signs in as an internal user and clicks on enrollment tab, searches for the provider and does
     * the document review and under screening and changes the status from "Pending Approval" to "Approved" and clicks on "yes" to
     * "Do you want to be approved retroactively?" and select the effect date and reason and then clicks apply button. For verification
     * clicks on provider tab and find the provider and clicks on "Enrollment Span" button to see if the effective from date
     * in Enrollment span section has been changed as defined.
     *
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */

    @Video
    @Test(dataProvider = "getIndProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = "RetroActiveRegisterAndSubmitIndividualEnrollment", groups = "RetroActiveApproveIndividualEnrollment")
    public void approveIndividualEnrollmentApplication(String testEnvironment,String firstName, String lastName, String trackingNum) throws Exception {

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,Data.pendingReviewStatus,trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }
        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollmentRetroActive(Data.ApplicationStatusApprove);
        }
        enrollmentPageInternalUser.javaWaitSec(5);
        driver.navigate().refresh();

        //Verify the Enrollment Span of the Provider in the Provider Tab
        enrollmentPageInternalUser.clickEnrollmentSpanInProvidersTab(enrollmentType,firstName, lastName);
        enrollmentPageInternalUser.navigateAndVerifyProvidersEnrollmentSpanStatus(enrollmentType,Locators.AFFILIATION_Note_LIST,-7);

        enrollmentPageInternalUser.logOut();
    }
}
