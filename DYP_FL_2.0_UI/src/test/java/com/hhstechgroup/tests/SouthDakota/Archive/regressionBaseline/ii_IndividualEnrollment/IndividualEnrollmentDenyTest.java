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
@Listeners(VideoListener.class)
/**
 * This class contains a test that uses a data provider to get a submitted Individual Enrollment and Denies it.
 */
public class IndividualEnrollmentDenyTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    /**
     * This method logs in as a Internal user. Executes a search for the enrollment,changes the status of a
     * enrollment from "Document Review" to "Denied".logs out as the Internal User and updates the
     * respective Status values in ProviderInfo.xlsx     * @param firstName firstName column value  from ProviderInfo.xlsx
     * @param lastName lastName column value  from ProviderInfo.xlsx
     * @param trackingId trackingId column value  from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getIndProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "RegisterAndSubmitIndividualEnrollment", groups = "DenyIndividualEnrollment")
    public void denyIndividualEnrollmentApplication(String testEnvironment,String firstName, String lastName, String trackingId) throws Exception {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingId);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment, environmentUrl,firstName,lastName,trackingId,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingId);

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

        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.individualApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}
