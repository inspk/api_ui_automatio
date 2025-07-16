package com.hhstechgroup.tests.SouthDakota.Archive.regression.IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)
public class InternalUserOperationalVerification extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    @Video
    @Test(dataProvider="getIndBillingProviderNameWithStatusSubmitted", dataProviderClass = DataProviderForProviderInfo.class)
    public void noteVerificationOnChangeStatusPopUpTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {

        Reports.log("The following Stories will be covered as part of this Test: \nPECS-762");
        //Internal user Operations....
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //DOCUMENT REVIEW
        dashboardPage.clickEnrollTab();

        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);

        //Verify the Note to provider and change the status
        iuEnrollmentPage.changeStatusPopupNoteFieldVerification(firstName,lastName,trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);
        iuEnrollmentPage.verifyAndCreateSiteVisitForAnEnrollment("Create Site Visit",firstName, lastName);
        siteVisitsPage.searchForProviderSiteVisitAndWave(firstName, lastName);
        iuEnrollmentPage.navigateBackToEnrollment();
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingId,5);

        //Pending Review Workflow
        iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName,lastName);
        iuEnrollmentPage.navigateBackToEnrollment();
        iuEnrollmentPage.changeStatusPopupNoteFieldVerification(firstName,lastName,trackingId, Data.statusPendingApproval, Data.ApplicationStatusDenied);
        iuEnrollmentPage.navigateBackToEnrollment();
        iuEnrollmentPage.changeStatusPopupNoteFieldVerification(firstName,lastName,trackingId, Data.statusPendingApproval, Data.REQUESTED_ADDITIONAL_INFORMATION);
        iuEnrollmentPage.navigateBackToEnrollment();
        iuEnrollmentPage.changeStatusPopupNoteFieldVerification(firstName,lastName,trackingId, Data.statusPendingApproval, Data.ApplicationStatusApprove);
        iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);

        String applicationStatus = enrollmentPageInternalUser.getApplicationStatus();

        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,applicationStatus);
        excel.readExcel();
    }
}
