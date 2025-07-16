package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This test class verifies the denial of a Facility enrollment following a Request For Additional Information.
 */
@Listeners(VideoListener.class)
public class FacilityEnrollmentRequestForAdditionalInfoAndDenyApplication extends BaseClassUI {
    String applicationType = Data.facilityApplication;
    String paymentOption = "Offline" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);


    /**
     * This test method retrieves a Facility enrollment with 'Pending Review' status from ProviderInfo.xlsx,
     * logs into DyP as an Internal User, executes a search for the enrollment, updates the enrollment status to
     * 'Request for Additional Information', logs out as the Internal user, logs into DyP as the
     * Facility Provider, completes and re-submits the enrollment, logs out as the Facility Provider, logs into DyP as
     * an Internal User, screens and denies the enrollment, writes the status of the Identity Information CoC request
     * to ProviderInfo.xlsx and logs out as the Internal User.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getFacilityProviderInfoWithStatusPendingReview", dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "FacilityScreening",  groups = "RequestForAdditionalInfoAndDenyApplication"  )
    public void requestForAdditionalInfoAndDenyApplication(String testEnvironment, String firstName, String lastName, String emailID,
                                                           String taxonomy, String npi, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstName,lastName,trackingNum);

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }
        if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
            enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
        }

        enrollmentPageInternalUser.javaWaitSec(5);
        enrollmentPageInternalUser.clickAnyButton(Data.optionChangeStatus);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
        enrollmentPageInternalUser.clickAnyOptionInList("Requested Additional Information");
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        enrollmentPageInternalUser.clickFirstOptionInList();
        enrollmentPageInternalUser.clickAnyButton(Data.TEXT_APPLY);
        enrollmentPageInternalUser.javaWaitSec(20);
        driver.navigate().refresh();
        enrollmentPageInternalUser.javaWaitSec(10);
        String enrollmentStatus = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
        Reports.log(" Application Status :" + enrollmentStatus);
        Assert.assertEquals(enrollmentStatus,Data.ApplicationStatusReqAdditionalInfo);
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,enrollmentStatus);
        excel.readExcel();

        enrollmentPageInternalUser.logOut();

        // Login to the Application as provider and resubmit the application
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusReqAdditionalInfo);
        enrollmentPageProvider.ClickOnContinueBtn();
        enrollmentPageProvider.signInProviderAgreementForm(applicationType, firstName, lastName);
        enrollmentPageProvider.fillInPaymentSection(applicationType, paymentOption);
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        enrollmentPageInternalUser.logOut();

        //Login as internal user and Deny the application
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, Data.ApplicationStatusPendingReview, trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstName,lastName,trackingNum);

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }
        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("Denied")) {
            if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
            }
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,enrollmentPageInternalUser.getApplicationStatus());
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }
}
