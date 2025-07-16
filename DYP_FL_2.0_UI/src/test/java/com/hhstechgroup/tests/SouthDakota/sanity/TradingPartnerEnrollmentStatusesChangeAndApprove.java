package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Test;

import java.io.IOException;

public class TradingPartnerEnrollmentStatusesChangeAndApprove extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    @JiraDefectCreateIssue(isCreateIssue=false)
    @Video
    @Test(dataProvider = "getTPNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitTradingPartnerProvider",
            groups = "ChangeEnrollmentStatues")
    public void verifyAndChangeEnrollmentStatusTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
//        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);

        iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_UNDER_CLEARING_HOUSE_CHECK, Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED);

        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName,lastName,trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.statusPendingApproval);
        iuEnrollmentPage.getApplicationStatus() ;
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,Data.TRADING_PARTNER,firstName,lastName,Data.statusPendingApproval);
        excel.readExcel();
    }

    @JiraDefectCreateIssue(isCreateIssue=false)
    @Video
    @Test
            (dataProvider = "getTPNameAndEmailWithStatusPendingApproval",
                    dataProviderClass = DataProviderForProviderInfo.class,
                    dependsOnGroups = "ChangeEnrollmentStatues",
                    groups = "ApproveTPEnrollment")
    public void approveTPEnrollmentTest(String testEnvironment, String applicationType, String firstName, String lastName, String email,
                                        String trackingNum) throws IOException {
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.pendingReviewFlowConfigaration(firstName, lastName, Data.statusPendingApproval, trackingNum, 5);

        iuEnrollmentPage.changeApplicationStatus(Data.ApplicationStatusApprove, applicationType);
        String applicationStatus = iuEnrollmentPage.getApplicationStatus();
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,applicationStatus);
        excel.readExcel();

        //Login Application as provider
        loginPage.signInToApp(email, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();
        //Verify all the tabs
        dashboardPage.verifyProviderTabsOnDashboard();
        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1935");
    }
}
