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
 * This class contains a test which uses a data provider, approves pharmacy enrollment
 */

public class PharmacyProviderApproveEnrollmentTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String paymentOption = "Offline";

    /**
     * This method logs in as an internal user, clicks on enrollment tab. Then searches for the provider and clicks
     * on the row in search result. Clicks on change status, selects "Approved" to change the status of a pharmacy enrollment
     * from "PENDING APPROVAL" to "Approved" and updates ProviderInfo.xlsx
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
    public void approvePharmacyEnrollment (String testEnvironment,String firstName, String lastName, String email, String taxonomy, String npi, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "PENDING REVIEW"
        04. Approve or Deny application
        05. If test has "Offline" option, click "Verify payment" and approve it
        06. Verify that application has status "APPROVED"
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
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
        }
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.pharmacyApplication,firstName,lastName,Data.APPLICATION_STATUS_ACTIVE);
        excel.readExcel();

    }
}
