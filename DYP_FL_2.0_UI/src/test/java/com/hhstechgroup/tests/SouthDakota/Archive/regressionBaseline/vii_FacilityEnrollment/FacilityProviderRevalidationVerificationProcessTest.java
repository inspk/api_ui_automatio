package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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

/**
 * This test class verifies the Revalidation of a Facility Provider.
 */
@Listeners(VideoListener.class)
public class FacilityProviderRevalidationVerificationProcessTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String enrollmentType = "Facility";
    String taxonomy =   Data.HomeHealthRequiredPaymentTaxonomy ;
    String statusOfApplication = "Approved";
    String revalidationTimePeriod =  Data.timeToRevalidationPlus30d;
    //  String revalidationDate = changeDayInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus30d));
    // String revalidationYear = changeYearInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus5y));


    /**
     * This method logs in as an internal user and searches for an approved Facility provider, Collects the cookies and gets the id.
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
    @Video
    @Test(dataProvider = "getFacilityProviderInfoWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void facilityProviderRevalidation(String testEnvironment, String firstName, String lastName, String emailID, String trackingId) throws IOException {
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

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.searchProvider(firstName + " " + lastName,trackingNum);
        String requestId = String.valueOf(enrollmentPageInternalUser.getRequestIdFromSpecificEnrollment(15, Data.APPLICATION_STATUS_DOCUMENT_REVIEW));


        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName, trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstName,lastName,trackingNum);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
            }
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }

        enrollmentPageInternalUser.searchAndNavigateToProvidersPage(firstName + " " + lastName);
        enrollmentPageInternalUser.navigateAndVerifyTheProviderHistoryInfo("Revalidation", changeDayInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus30d)), requestId );
        enrollmentPageInternalUser.navigateAndVerifyProvidersTimeLineRevalidationStatus("APPROVED",requestId);
        enrollmentPageInternalUser.navigateAndVerifyProvidersNextRevalidationStatus(changeYearInCurrentDate(Integer.parseInt(Data.timeToRevalidationPlus5y)));
        enrollmentPageInternalUser.logOut();

        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType,firstName,lastName,Data.applicationStatusActive);
    }
}
