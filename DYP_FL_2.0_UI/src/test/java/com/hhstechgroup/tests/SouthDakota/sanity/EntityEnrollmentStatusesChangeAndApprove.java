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
public class EntityEnrollmentStatusesChangeAndApprove extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    @JiraDefectCreateIssue(isCreateIssue=true)

    @Video
    @Test(dataProvider = "getEntityProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitEntityProvider",
            groups = "ChangeEnrollmentStatues")
    public void verifyAndChangeEnrollmentStatusTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
        iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_UNDER_CLEARING_HOUSE_CHECK, Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED);
//        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingApproval, trackingId, 10);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingApproval, trackingId, 10);

        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,Data.ENTITY_PROVIDER,firstName,lastName,Data.pendingReviewStatus);
        excel.readExcel();
    }


    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getEntityProviderNameAndEmailWithStatusPendingReview",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "ChangeEnrollmentStatues", groups = "ApproveEntityEnrollmentApplication")
    public void approveEntityEnrollmentTest(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingNum,5);

        iuEnrollmentPage.waveSiteVisitOnEnrollmentPage("Create Site Visit");

        //Fingerprinting Workflow
        iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

        //Pending Review Workflow
        iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName,lastName);

        //PENDING APPROVAL
        iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);

        String statusOfApplication = iuEnrollmentPage.getApplicationStatus() ;
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,Data.ENTITY_PROVIDER,firstName,lastName,statusOfApplication);
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
