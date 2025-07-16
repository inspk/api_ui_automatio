package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

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
@Listeners(VideoListener.class)
/**
 * This test class changes the status of a Group enrollment from 'Pending Review' to 'Denied'.
 */
public class GroupProviderDenyEnrollmentTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Group enrollment with 'Pending Review' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, denies the enrollment, logs out as the Internal User
     * and writes the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameEmailTaxNPIWithPendingReviewStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void denyGroupEnrollment (String testEnvironment, String firstName, String lastName, String email, String taxonomy, String npi, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "PENDING REVIEW"
        04. Approve or Deny application
        05. If test has "Offline" option, click "Verify payment" and approve it
        06. Verify that application has status "DENIED"
        07. Save first name, last, name, email and NPI to data file for next test cases
     */

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //Adding Pending Review Flow Per Configuration
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName, "PENDING REVIEW",trackingNumber);

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

            //Deny Enrollment
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.groupApplication,firstName,lastName,Data.ApplicationStatusDenied);
        excel.readExcel();
    }
}