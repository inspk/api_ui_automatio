package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Test;


public class FacilityEnrollmentVerifyingNewDelayStatusAndDenyTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as a Internal user, Executes a search for the enrollment,changes the status of a
     * enrollment from "Document Review" to " Pending Approved" and verifies the New Delay statuses (Pending W9 Processing,
     * Pending Agency Review,Pending Provider Information,Pending Provider Payment) changing the
     * one statuses to another. At last Approves the enrollments and logs out. Updates the
     * respective Status values in ProviderInfo.xlsx
     * @param testEnvironment testEnvironment column value  from ProviderInfo.xlsx
     * @param firstName firstName column value  from ProviderInfo.xlsx
     * @param lastName lastName column value  from ProviderInfo.xlsx
     * @param trackingNum trackingNum column value  from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider="getFacilityProviderInfoWithStatusPendingReview", dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "FacilityScreening",  groups = "FingerPrintVerification")
    public void verifyNewDelayStatusAndDenyFacilityEnrollment(String testEnvironment,String firstName, String lastName,
                                                              String emailID, String taxonomy, String npi, String trackingNum) throws Exception {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName, lastName, "PENDING REVIEW", trackingNum);

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
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
            }

            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusPendingAW9Processing);
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusPendingAgencyReview);
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusPendingProviderInformation);
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusPendingProviderPayment);
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,Data.facilityApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }

}
