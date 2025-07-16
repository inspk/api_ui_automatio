package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get a pharmacy enrollment with "Pending review" status
 * , requests for additional information and denies the enrollment
 */
public class PharmacyProviderRequestForAdditionalInfoDenyTest extends BaseClassUI {

    String applicationType = Data.pharmacyApplication;
    String paymentOption = "Offline" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method signs in an internal user and clicks on enrollment, searches for the pharmacy enrollment with the
     * status of "Pending Review", clicks on the row in search result. clicks on change status button and selects
     * "Requested Additional Information" option from the list, selects the reason and clicks on apply button. For verification
     * gets the application status to see if it is "REQUESTED ADDITIONAL INFORMATION" and logs out. Logs in as the provider
     * and verifies the application status. Clicks on continue button, signs the provider agreement, signs the enrollment and logs out.
     * Logs in as an internal user and does the document review and under screening. Then change the status from "Pending Approval" to "Denied".
     * At the end the info writes out to ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param email
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPharmacyProviderNameEmailTaxNPIWithPendingReviewStatus", dataProviderClass = DataProviderForProviderInfo.class)
    public void requestForAdditionalInfoAndDenyApplication(String testEnvironment, String firstName, String lastName, String email,
                                                           String taxonomy, String npi, String trackingNumber) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //Adding Pending Review Flow Per Configuration
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName, lastName, Data.ApplicationStatusPendingReview,trackingNumber);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit", taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        //Verify Payment
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            if (paymentOption.contains("Offline")) {
                enrollmentPageInternalUser.clickAnyButton(Data.TEXT_VERIFY_PAYMENT);
                driver.findElement(Locators.POP_UP_DOCUMENT).findElement(Locators.POPUP_IS_PAYMENT_RECEIVED).click();
                enrollmentPageInternalUser.fillInCalendar("03/20/2020", Data.datepaymentreceived);
                driver.findElement(By.xpath("//label[text()='" + Data.datepaymentreceived + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(Keys.TAB);
                enrollmentPageInternalUser.clickAnyButton(Data.TEXT_VERIFY);
            }
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

        enrollmentPageInternalUser.logOut();

        // Login to the Application as provider and resubmit the application
        homePage.signInToApp(email, providerEmailPassword);
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

        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNumber);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingNumber,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, Data.ApplicationStatusPendingReview,trackingNumber);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit", taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        //Deny Enrollment
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,enrollmentPageInternalUser.getApplicationStatus());
        excel.readExcel();

        //Logout
        enrollmentPageInternalUser.logOut();
    }
}
