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

import static com.hhstechgroup.common.BaseActions.changeDayInCurrentDate;
import static com.hhstechgroup.common.BaseActions.changeYearInCurrentDate;

@Listeners(VideoListener.class)
public class IndividualProviderRevalidationProcessTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String enrollmentType =Data.individualApplication;
    String taxonomy = Data.interpreterTaxonomy ;
    String statusOfApplication = Data.ApplicationStatusApprove ;
    String revalidationTimePeriod =  Data.timeToRevalidationPlus30d;

    @Video
    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void individualProviderRevalidation(String testEnvironment, String firstName, String lastName, String emailID, String trackingId) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);

        // Navigates to Providers tab, Search and opens for a specific Provider.
        enrollmentPageInternalUser.searchAndNavigateToProvidersPage(firstName + " " + lastName);
        String providerDataId = enrollmentPageInternalUser.getProviderDataId();
        String cookies = enrollmentPageInternalUser.collectCookies(environmentUrl.replace("https://", ""));

        enrollmentPageInternalUser.changeRevalidationDateAndVerify(environmentUrl, providerDataId, revalidationTimePeriod, cookies, changeDayInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus30d)));
        enrollmentPageInternalUser.scheduleUpcomingReValidationsAndVerifyStatus(environmentUrl, cookies);

        //Logout
        enrollmentPageInternalUser.logOut();
        homePage.signInToApp(emailID, providerPassword);

        enrollmentPageProvider.clicksOnCreateRevalidationButton();
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, "Offline");

        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getTrackingNumberInReEnrollment();
        enrollmentPageInternalUser.logOut();


        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        enrollmentPageInternalUser.searchProvider(firstName + " " + lastName,trackingNum);
        String requestId = String.valueOf(enrollmentPageInternalUser.getRequestIdFromSpecificEnrollment(15, Data.APPLICATION_STATUS_DOCUMENT_REVIEW));

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, "PENDING REVIEW", trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName,lastName);

            //Verify Payment Workflow
            enrollmentPageProvider.VerifyPaymentButton(firstName,lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit",taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.javaWaitSec(3);
            //Verify Payment Workflow
            enrollmentPageProvider.VerifyPaymentButton(firstName, lastName);
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }

        enrollmentPageInternalUser.searchAndNavigateToProvidersPage(firstName + " " + lastName);
        enrollmentPageInternalUser.navigateAndVerifyTheProviderHistoryInfo("Revalidation", changeDayInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus30d)), requestId );
        enrollmentPageInternalUser.navigateAndVerifyProvidersTimeLineRevalidationStatus("APPROVED",requestId);
        enrollmentPageInternalUser.navigateAndVerifyProvidersNextRevalidationStatus(changeYearInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus5y)));
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType ,firstName,lastName,Data.APPLICATION_STATUS_ACTIVE);
    }
}

