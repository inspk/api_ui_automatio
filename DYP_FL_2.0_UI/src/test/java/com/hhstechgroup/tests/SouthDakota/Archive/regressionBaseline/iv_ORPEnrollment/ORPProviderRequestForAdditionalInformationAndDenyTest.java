package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
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
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an ORP provider enrollment and requests for additional information
 * and denies the enrollment
 */
public class ORPProviderRequestForAdditionalInformationAndDenyTest extends BaseClassUI {
    String applicationType = Data.orpApplication;
    String paymentOption = "Offline" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method signs in an internal user and clicks on enrollment, searches for the ORP enrollment with the
     * status of "Pending Approval" and clicks on the row in search result. clicks on change status button, selects
     * "Requested Additional Information" option from the list, selects the reason and clicks on apply button. For verification
     * gets the application status to see if it is "REQUESTED ADDITIONAL INFORMATION" and logs out. Logs in as the provider
     * and verifies the application status. Clicks on continue button, signs the provider agreement, signs the enrollment and logs out.
     * Logs in as an internal user and change the status from "Pending Approval" to "Denied". At the end the info writes out to ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trakingNumber
     * @throws IOException
     */
    @Test(dataProvider="getORPProviderNameWithStatusPendingApproval", dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = "ORPScreening", groups = "ORPAdditionalInfoAndDenyApplication")
    public void requestForAdditionalInfoAndDenyApplication(String testEnvironment,String firstName, String lastName, String emailID,String trakingNumber) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING APPROVAL",trakingNumber);
        enrollmentPageInternalUser.javaWaitSec(5);
        enrollmentPageInternalUser.clickAnyButton(Data.optionChangeStatus);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
        enrollmentPageInternalUser.clickAnyOptionInList("Requested Additional Information");
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        enrollmentPageInternalUser.clickFirstOptionInList();
        enrollmentPageInternalUser.clickAnyButton(Data.TEXT_APPLY);
        enrollmentPageInternalUser.javaWaitSec(20);
        driver.navigate().refresh();
        enrollmentPageInternalUser.javaWaitSec(20);
        String enrollmentStatus = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
        Assert.assertEquals(enrollmentStatus,Data.ApplicationStatusReqAdditionalInfo);
        Reports.log(" Application Status :" + enrollmentStatus);
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,enrollmentStatus);

        enrollmentPageInternalUser.logOut();

        // Login to the Application as provider and resubmit the application
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusReqAdditionalInfo);
        enrollmentPageProvider.ClickOnContinueBtn();
        enrollmentPageProvider.signInProviderAgreementForm(applicationType, firstName, lastName);
        enrollmentPageProvider.ajaxScroll(Locators.SECTION_PAYMENT);
        driver.findElement(Locators.SECTION_PAYMENT).isDisplayed();
        enrollmentPageProvider.javaWaitSec(3);
        enrollmentPageProvider.ajaxClick(Locators.SECTION_PAYMENT);
        enrollmentPageProvider.ajaxClick(Locators.BUTTON_NEXT_PROVIDERDETAILS);
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        enrollmentPageInternalUser.logOut();

        //Login as internal user and Deny the application
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trakingNumber);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trakingNumber,Data.statusPendingApproval);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING APPROVAL",trakingNumber);

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("Denied")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        String StatusOfApplication = enrollmentPageInternalUser.getApplicationStatus();
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,StatusOfApplication);
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }

}

