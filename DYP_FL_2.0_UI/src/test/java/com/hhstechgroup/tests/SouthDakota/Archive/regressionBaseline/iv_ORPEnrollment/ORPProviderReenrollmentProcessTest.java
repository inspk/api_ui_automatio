package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

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

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved ORP provider, Terminates, re-enrolls and approves the enrollment
 */
public class ORPProviderReenrollmentProcessTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String enrollmentType = "ORP";
    String paymentOption = "Offline";

    /**
     * This method logs in as an internal user, clicks on provider tab and searches for the approved ORP provider.
     * Clicks on the row in search result. Verifies the application status is "Active". Clicks on 3 dots and select
     * "Terminate" option from the list and selects a reason and clicks on terminate and then ok. For verification
     * checks the status to see if it is "Terminated". Logs in as terminated provider, verifies the status is "Terminated" and
     * clicks on re-enrollment button, fills in required section and signs the enrollment. Logs in as an internal user and changes
     * the status from "Pending Approval" to "Approved" and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingId
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getORPProviderNameWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void terminateReEnrollAndApproveProvider(String testEnvironment,String firstName, String lastName, String emailID, String trackingId) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType, firstName + " " + lastName);
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusActive);

        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication(Data.applicationStatusTerminated);
        enrollmentPageInternalUser.logOut();

        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyProviderEnrollmentStatusIs(Data.applicationStatusTerminated);
        enrollmentPageProvider.clickOnReEnrollmentApplBtn();

        enrollmentsAndCoc.fillInExclusionAndSanctionSection();
        enrollmentPageProvider.uploadDocumentSection(Data.orpApplication);
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        driver.navigate().refresh();
        enrollmentPageProvider.javaWaitSec(5);
        String trackingNum = enrollmentPageProvider.getTrackingNumberInReEnrollment();
        enrollmentPageInternalUser.logOut();

        //Login as internal user and Deny the application
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.statusPendingApproval);

        //Adding Pending Review Flow Per Configuration
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName, lastName,"PENDING APPROVAL", trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName, lastName);
        }
        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
        }
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication, firstName, lastName, Data.applicationStatusActive);
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }
}