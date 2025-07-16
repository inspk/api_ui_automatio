package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)
public class IndividualEnrollmentProviderStatusesChangeAndApprove extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String enrollmentType = Data.BILLING_PROVIDER ;

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getIndBillingProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitIndividualBillingProvider",
            groups = "ChangeEnrollmentStatues")
    public void verifyAndChangeEnrollmentStatusTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);

        iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);

        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_UNDER_CLEARING_HOUSE_CHECK, Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED);
//        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingApproval, trackingId, 10);
//        String statusOfApplication = iuEnrollmentPage.getApplicationStatus() ;
//        dashboardPage.logOut();
//        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,Data.pendingReviewStatus);
//        excel.readExcel();
    }
//    @JiraDefectCreateIssue(isCreateIssue=true)
//    @Video
//    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusPendingReview",
//            dataProviderClass = DataProviderForProviderInfo.class,
//            dependsOnGroups = "ChangeEnrollmentStatues", groups = "SiteVisitVerification")
//    public void verifyCreateAndWaiveSiteVisitTest(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
//        loginPage.signInToApp(internalUserEmail, internalUserPassword);
//        landingPage.confirmAgreeAndSecureMessages();
//
//        dashboardPage.clickEnrollTab();
//        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingNum,5);
//        iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);
//
//        //iuEnrollmentPage.verifyAndCreateSiteVisitForAnEnrollment("Create Site Visit",firstName, lastName);
////       siteVisitsPage.searchForProviderSiteVisitAndWave(firstName, lastName);
////       iuEnrollmentPage.navigateBackToEnrollment();
//        dashboardPage.logOut();
//        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,Data.pendingReviewStatus);
//        excel.readExcel();
//    }
//
//    @JiraDefectCreateIssue(isCreateIssue=true)
//    @Video
//    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusPendingReview",
//            dataProviderClass = DataProviderForProviderInfo.class,
//            dependsOnGroups = "SiteVisitVerification", groups = "ApproveIndividualBillingEnrollment")
//    public void approveIndividualBillingEnrollmentTest(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
//        loginPage.signInToApp(internalUserEmail, internalUserPassword);
//        landingPage.confirmAgreeAndSecureMessages();
//
//        dashboardPage.clickEnrollTab();
//        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingNum,5);
//
//        //Fingerprinting Workflow
////        iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);
//
//        //Pending Review Workflow
//        iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName,lastName);
//
//        //PENDING APPROVAL
//        iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
//
//        String statusOfApplication = iuEnrollmentPage.getApplicationStatus() ;
//
//
//        //Set the status written to Provider Info based on the original applicationStatus and
//        //the statusOfApplication displayed on the enrollment.  It addresses the need to have an
//        //Active status written to ProviderInfo if needed
//        String providerInfoStatus = dashboardPage.setProviderInfoStatus(statusOfApplication, Data.ApplicationStatusApprove);
//
//        //Logout and write the enrollment information to Provider info
//        dashboardPage.logOut();
//        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, providerInfoStatus);
//        excel.readExcel();
//
//        //Verify the status displayed on the Provider dashboard
//        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage, enrollmentType,
//                emailID, providerPassword, providerInfoStatus, statusOfApplication);
//
//    }
}
