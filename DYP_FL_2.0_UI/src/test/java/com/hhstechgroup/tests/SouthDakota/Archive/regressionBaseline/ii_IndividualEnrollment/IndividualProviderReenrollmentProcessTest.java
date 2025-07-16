package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

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
 * This class contains a test which uses a data provider to get an Approved Individual provider and Terminates it, ReEnrolls the Terminated provider and Approves it.
 */
@Listeners(VideoListener.class)
public class IndividualProviderReenrollmentProcessTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String enrollmentType ="Individual" ;
    String paymentOption = "Offline" ;

    /**
     * This method logs in as an internal user and searches for the provider and verifies the status is active and clicks on the provider and terminates.
     * For verification it searches for provider and verifies the status if is "Terminated".Then logs in as Terminated provider and
     * Click on Re-Enroll and fills in the Section, uploads the Documents, fills in Authorized Signature Section, SignIn Provider Agreement Form
     * and signIn Hello Sign and submit. Gets the trackingId and logs out.
     * Logs in as Internal User, Changes the Application status from Documents Review to Under Screening. Performs Screen and
     *  Approves it and At the end ProviderInfo.xlsx will be updated
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingId
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateReEnrollAndApproveProvider(String testEnvironment,String firstName, String lastName, String emailID, String trackingId) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusTerminated);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusTerminated);
        enrollmentPageProvider.clickOnReEnrollmentApplBtn();

        enrollmentsAndCoc.fillInExclusionAndSanctionSection();
        enrollmentPageProvider.uploadDocumentSection(Data.individualApplication);
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getTrackingNumberInReEnrollment();
        enrollmentPageInternalUser.logOut();

        //Login as internal user and Deny the application
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
        }
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusActive);
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }

    /**
     * This method logs in as an internal user and searches for the provider and verifies the status is active and clicks on the provider and terminates.
     * For verification it searches for provider and verifies the status if is "Terminated".Then logs in as Terminated provider and
     * Click on Re-Enroll and fills in the Section, uploads the Documents, fills in Authorized Signature Section, SignIn Provider Agreement Form
     * and signIn Hello Sign and submit. Gets the trackingId and logs out.
     * Logs in as Internal User, Changes the Application status from Documents Review to Under Screening. Performs Screen and
     *  Deny it and At the end ProviderInfo.xlsx will be updated
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingId
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateReEnrollAndDenyProvider(String testEnvironment,String firstName, String lastName, String emailID, String trackingId) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusTerminated);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusTerminated);
        enrollmentPageProvider.clickOnReEnrollmentApplBtn();
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();
        enrollmentPageProvider.uploadDocumentSection(Data.individualApplication);
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum =enrollmentPageProvider.getTrackingNumberInReEnrollment();
        enrollmentPageInternalUser.logOut();

        //Login as internal user and Deny the application
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, Data.ApplicationStatusPendingReview,trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }
        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,Data.applicationStatusActive);
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }
}
