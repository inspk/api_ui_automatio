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
public class IndividualServicingEnrollmentStatusesChangeAndApprove extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String enrollmentType = Data.SERVICING_PROVIDER ;

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getIndServicingProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitIndividualEnrollmentAsServicingProvider",
            groups = "ChangeEnrollmentStatues")
    public void verifyAndChangeEnrollmentStatusTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
        iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);

//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
//        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);
//
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,Data.pendingReviewStatus);
        excel.readExcel();
    }

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getServicingProviderNameAndEmailWithStatusPendingReview",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "ChangeEnrollmentStatues", groups = "SiteVisitVerification")
    public void verifyCreateAndWaiveSiteVisitTest(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingNum,5);
        iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);

        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,Data.pendingReviewStatus);
        excel.readExcel();
    }

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getServicingProviderNameAndEmailWithStatusPendingReview",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "SiteVisitVerification", groups = "ApproveEnrollmentApplication")
    public void approveIndividualServicingEnrollmentTest(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingNum,5);

        //Fingerprinting Workflow
        iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

        //Pending Review Workflow
        iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName,lastName);

        //PENDING APPROVAL
        iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);

        String statusOfApplication = iuEnrollmentPage.getApplicationStatus() ;
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,statusOfApplication);
        excel.readExcel();

        //Login Application as provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();
        //Verify all the tabs
        dashboardPage.verifyProviderTabsOnDashboard();
        dashboardPage.logOut();

    }
}
