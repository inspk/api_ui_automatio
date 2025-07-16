package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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
 * This test class verifies the Facility Provider enrollment span.
 */
@Listeners(VideoListener.class)
public class FacilityProviderRetroActiveAdjustmentApprovalTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);
    String enrollmentType = "Facility";
    String taxonomy = Data.HomeHealthRequiredPaymentTaxonomy;


    /**
     * This test method retrieves a Facility enrollment with 'Submitted' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, screens the enrollment, approves the enrollment,
     * executes a search for the approved Facility Provider, verifies the Provider enrollment span and logs out as the
     * Internal User.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getFacilityProviderNameEmailWithSubmitted",
          dataProviderClass = DataProviderForProviderInfo.class )
    //,dependsOnGroups = "RetroActiveRegisterAndSubmitFacilityEnrollment")
    public void verifyFacilityApproveRetroActiveAdjustment (String testEnvironment,String firstName, String lastName, String emailID, String trackingNumber) throws Exception {

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.javaWaitSec(3);

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNumber);

        //SCREEN ENROLLMENT
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNumber,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNumber);

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstName,lastName,trackingNumber);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
            }
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