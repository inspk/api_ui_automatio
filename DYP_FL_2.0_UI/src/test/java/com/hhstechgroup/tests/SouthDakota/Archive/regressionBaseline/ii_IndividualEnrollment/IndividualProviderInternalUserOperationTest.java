package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

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
 *  This class contains a multiple test that uses the data provider to get a submitted Individual provider, Performs screens for that Individual provider and
 *  Changes Status of application to Request for Additional Information, Provider Re-submit the enrollment and Internal User Denies it
 */
@Listeners(VideoListener.class)
public class IndividualProviderInternalUserOperationTest extends BaseClassUI{
    String applicationType = Data.individualApplication;
    String paymentOption = "Offline" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logins as internal users. Navigates to Provider tab and searches for the provider using trackingNum. Changes the Status of the application from
     * Document Review to under screening. Performs the Screening. Gets the Applications status and updates to ProviderInfo.xlsx
     * screens a Individual enrollment
     * @param firstName firstName column value  from ProviderInfo.xlsx
     * @param lastName lastName column value  from ProviderInfo.xlsx
     * @param trackingId trackingNum column value  from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider="getIndProviderNameWithStatusSubmitted", dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitIndividualEnrollment", priority = 1)
    public void screeningVerificationTest(String testEnvironment,String firstName, String lastName, String trackingId) throws IOException {

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingId);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingId);
        String applicationStatus = enrollmentPageInternalUser.getApplicationStatus();

        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,applicationStatus);
        excel.readExcel();
    }

    @Video
    /**
     * This method logins as internal users. Navigates to Provider tab and searches for the provider using trackingNum. Changes Status of application from PENDING REVIEW to
     * Request for Additional Information. Provider logins the Application, Fill in section and Re-submits the Application and logs out. logs in as Internal User and
     * Denies the application and updates ProviderInfo.xlsx.
     * @param firstName firstName column value  from ProviderInfo.xlsx
     * @param lastName lastName column value  from ProviderInfo.xlsx
     * @param emailID emailID column value  from ProviderInfo.xlsx
     * @param trackingNum trackingNum column value  from ProviderInfo.xlsx
     *
     * @throws Exception
     */
   // @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusPendingReview", dataProviderClass = DataProviderForProviderInfo.class, groups = "requestForAdditionalInfo",
            dependsOnGroups = "RegisterAndSubmitIndividualEnrollment", dependsOnMethods ={"screeningVerificationTest"},  priority = 2)
    public void requestForAdditionalInfoAndDenyApplication(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
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
        Assert.assertEquals(enrollmentStatus,Data.ApplicationStatusReqAdditionalInfo);
        Reports.log(" Application Status :" + enrollmentStatus);
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

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName, trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, Data.ApplicationStatusPendingReview,trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,enrollmentPageInternalUser.getApplicationStatus());
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }
}
