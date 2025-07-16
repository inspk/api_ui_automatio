package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

import com.automation.remarks.testng.VideoListener;
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

/**
 * This class contains a method to do revalidation through API, a Group provider completes the revalidation,
 * Then gets submitted by an internal user.
 *
 */
public class GroupProviderRevalidationVerification extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String enrollmentType =  Data.groupApplication ;
    String taxonomy =    Data.interpreterTaxonomy;
    String statusOfApplication = Data.ApplicationStatusApprove ;
    String revalidationTimePeriod =  Data.timeToRevalidationPlus30d;
    // String revalidationDate = changeDayInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus30d));
   // String revalidationYear = changeYearInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus5y));

    /**
     * This method logs in as an internal user and searches for an approved Group provider, Collects the cookies and gets the id.
     * Does the revalidation by sending request(post) including revalidation time which is 30 days and provider's id. Then gets 200
     * response code. For verification searches for the provider and check the revalidation date which should be 30 days from current date.
     * Then sends API Get requests to notify the provider to do the revalidation. For verification searches for the provider and
     * checks the revalidation status which should be "3rd notification". Logs in as provider and completes the revalidation. Logs in as
     * internal user and approves the application. For verification searches for the provider and checks the history and timeline to see the
     * revalidation status.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingId
     * @throws IOException
     */
    @Test(dataProvider = "getGroupProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void groupProviderRevalidation(String testEnvironment, String firstName, String lastName, String emailID, String trackingId) throws IOException {
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
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
      //  enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
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
