package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This test class verifies the re-enrollment of a Facility Provider.
 */
@Listeners(VideoListener.class)
public class FacilityProviderReenrollmentProcessTest extends BaseClassUI {
    ExcelWrite excel =
            new ExcelWrite(providerInfoSheet, 0);
    String enrollmentType = "Facility";
    String paymentOption = "Offline";
    String taxonomy = "Data.HomeHealthRequiredPaymentTaxonomy";
    String statusOfApplication = Data.ApplicationStatusApprove;

    /**
     * This test method retrieves a Facility enrollment with 'Approved' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, verifies the enrollment status, terminates the
     * enrollment, verifies the enrollment status, logs out as the Internal User, logs into DyP as the
     * Facility Provider, verifies the enrollment status, completes and submits the re-enrollment, logs into DyP
     * as an Internal User, screens and approves the re-enrollment and logs out as the Internal User.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingId
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getFacilityProviderInfoWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateReEnrollAndApproveProvider(String testEnvironment,String firstName, String lastName, String emailID, String trackingId) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType, firstName + " " + lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityApplication, firstName, lastName, Data.applicationStatusTerminated);

        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusTerminated);
        enrollmentPageProvider.clickOnReEnrollmentApplBtn();

        enrollmentsAndCoc.fillInExclusionAndSanctionSection();
        enrollmentPageProvider.uploadDocumentSection(Data.facilityApplication);
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        driver.navigate().refresh();
        enrollmentPageProvider.javaWaitSec(5);
        String trackingNum = enrollmentPageProvider.getTrackingNumberInReEnrollment();
        System.out.println(trackingNum);
        enrollmentPageInternalUser.logOut();


        //Login as internal user and Deny the application
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName, lastName, trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl, firstName, lastName, trackingNum,Data.pendingReviewStatus);


        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstName, lastName, trackingNum);

            //Pending Review Workflow
            //review and vote for this request
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName, lastName);

            //Pending Approval
            //Verify Payment
            if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
                enrollmentPageInternalUser.verifyPaymentForFacility(firstName, lastName);
                enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
            }
        }


        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityApplication, firstName, lastName, enrollmentPageInternalUser.getApplicationStatus());
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }

}