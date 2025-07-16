package com.hhstechgroup.tests.SouthDakota.Archive.regression.IndividualEnrollment;

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
public class IndividualEnrollmentCreateSIteVisitAndWaiveTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getIndBillingProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitIndividualBillingProvider",
            groups = "ChangeEnrollmentStatues")
    public void verifyCreateAndWaiveSiteVisitOnSiteVisitPopUpTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);

        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.pendingReviewStatus);

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingId, 5);
        iuEnrollmentPage.waveSiteVisitOnEnrollmentPage("Create Site Visit");

        //Fingerprinting Workflow
        iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

        //Pending Review Workflow
        iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);

        //PENDING APPROVAL
       // iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);

        String statusOfApplication = iuEnrollmentPage.getApplicationStatus();
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication, firstName, lastName, statusOfApplication);
        excel.readExcel();
    }

}
