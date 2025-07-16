package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)
public class PEMEnrollmentStatusesChangeAndApproveTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This method logs in as an internal user and clicks on enrollment tab. Then searches for the provider and clicks
     * on the row in search result. Clicks on change status and selects "Approved" to change the status of a PEM enrollment
     * from "PENDING APPROVAL" to "Approved" and updates ProviderInfo.xlsx
     *
     * @param firstName
     * @param lastName
     * @param trackingId
     * @throws IOException
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"RegisterAndSubmitPEMEnrollment"},
            groups = {"ApprovePemEnrollment"})
    public void approvePEMEnrollmentTest(String testEnvironment, String firstName, String lastName, String emailID, String trackingId) throws IOException {

        // Login Application as an internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        landingPage.clickEnrollmentTab();

        //Change the status of application from "New" to "Document Review" then "Document Review Approved" and "Approved"
//            iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
//            iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
//            iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.statusPendingApproval, trackingId, 5);
//            if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
//                iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
//            }

        iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);

        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_UNDER_CLEARING_HOUSE_CHECK, Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED);
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.statusPendingApproval, trackingId, 5);
//            iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.pendingApproval, trackingId, 10);


        //Pending Review Workflow
        iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName,lastName);


        //PENDING APPROVAL
        iuEnrollmentPage.changeStatusOfEnrollment(Data.ApplicationStatusApprove);

        //Write To ProviderInfo
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus();
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.pemApplication, firstName, lastName, statusOfApplication);
        excel.readExcel();

        //Login Application as provider and confirmAgreeAndSecureMessages
        loginPage.signInToApp(emailID, providerPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //Verify all the tabs
        dashboardPage.verifyProviderTabsOnDashboard();
        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1929");
    }
}




