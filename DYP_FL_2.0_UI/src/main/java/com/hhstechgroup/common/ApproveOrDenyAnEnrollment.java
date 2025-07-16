package com.hhstechgroup.common;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import com.hhstechgroup.utility.ProviderInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApproveOrDenyAnEnrollment extends BaseActions {
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    public IUEnrollmentPage iuEnrollmentPage = new IUEnrollmentPage(driver, wait);
    public LoginPage loginPage = new LoginPage(driver, wait);
    public LandingPage landingPage = new LandingPage(driver, wait);
    public DashboardPage dashboardPage = new DashboardPage(driver, wait);
    ;
    public ProviderEnrollingPage providerEnrollingPage = new ProviderEnrollingPage(driver, wait);
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    public Helper Helper = new Helper();

    /**
     * This is a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public ApproveOrDenyAnEnrollment(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void changeEnrollmentStatus(String testEnvironment, String environmentUrl, String enrollmentType,
                                       String internalUserEmail, String internalUserPassword,
                                       String firstName, String lastName, String trackingId,
                                       String providerEmailId, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        //Change Status from New to Document Review
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);

        if(applicationStatus.equalsIgnoreCase(Data.REQUESTED_ADDITIONAL_INFORMATION)) {
            iuEnrollmentPage.searchProvider(firstName + " " + lastName, trackingId);
            iuEnrollmentPage. searchSpecificEnrollmentAndClick(3, Data.APPLICATION_STATUS_DOCUMENT_REVIEW);
            javaWaitSec(3);
        }
        else{

            //Change Status from Document Review to Document Review Approve
            iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);

            //Change Status from Document Review to Document Review Approve
            iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);

            //UnderScreening process
            if (enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER)) {
                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);
            } else {
                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.pendingReviewStatus);
            }
            iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);

            //Fingerprinting Workflow
            iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);
        }
        //PENDING APPROVAL
        iuEnrollmentPage.changeStatusOfEnrollment(applicationStatus);
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus();

        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, statusOfApplication);
        excel.readExcel();

        if(!applicationStatus.equalsIgnoreCase(Data.REQUESTED_ADDITIONAL_INFORMATION)) {
            //Login Application as provider
            loginPage.signInToApp(providerEmailId, providerPwd);
            //confirmAgreeAndSecureMessages();
            landingPage.confirmAgreeAndSecureMessages();
            dashboardPage.VerifyProviderApplicationStatusIs(applicationStatus);
            dashboardPage.logOut();
        }
    }
}
