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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This test class changes the status of a Pharmacy enrollment from 'Pending Review' to 'Denied'.
 */

public class PharmacyProviderDenyEnrollmentTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String paymentOption = "Offline";

    /**
     * This test method retrieves a Pharmacy enrollment with 'Pending Review' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, denies the enrollment, logs out as the Internal User
     * and writes the status of the enrollment to ProviderInfo.xlsx.
     * @param firstName
     * @param lastName
     * @param email
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getPharmacyProviderNameEmailTaxNPIWithPendingReviewStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void denyPharmacyEnrollment (String testEnvironment,String firstName, String lastName, String email, String taxonomy, String npi, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "PENDING REVIEW"
        04. Approve or Deny application
        05. If test has "Offline" option, click "Verify payment" and approve it
        06. Verify that application has status "Denied"
        07. Save first name, last, name, email and NPI to data file for next test cases
     */

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //Adding Pending Review Flow Per Configuration
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, Data.ApplicationStatusPendingReview,trackingNumber);

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
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.pharmacyApplication,firstName,lastName,Data.ApplicationStatusDenied);
        excel.readExcel();

    }
}
