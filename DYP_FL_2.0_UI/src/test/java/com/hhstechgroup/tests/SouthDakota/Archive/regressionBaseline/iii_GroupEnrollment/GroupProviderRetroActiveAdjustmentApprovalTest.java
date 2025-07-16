package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

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
 * This test class verifies the Group Provider enrollment span.
 */
public class GroupProviderRetroActiveAdjustmentApprovalTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String enrollmentType = "Group";
    String taxonomy=Data.interpreterTaxonomy;

    /**
     * This test method retrieves a Group enrollment with 'Submitted' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, screens the enrollment, approves the enrollment,
     * executes a search for the approved Group Provider, verifies the Provider enrollment span and logs out as the
     * Internal User.
     *
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void approveGroupEnrollment (String testEnvironment, String firstName, String lastName, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "PENDING REVIEW"
        04. Approve or Deny application
        05. If test has "Offline" option, click "Verify payment" and approve it
        06. Verify that application has status "APPROVED"
        07. Save first name, last, name, email and NPI to data file for next test cases
     */

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.javaWaitSec(3);

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNumber);

        //SCREEN ENROLLMENT
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNumber,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, "PENDING REVIEW", trackingNumber);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName,lastName);

            //Verify Payment Workflow
            enrollmentPageProvider.VerifyPaymentButton(firstName,lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit",taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.javaWaitSec(3);
            //Verify Payment Workflow
            enrollmentPageProvider.VerifyPaymentButton(firstName, lastName);
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