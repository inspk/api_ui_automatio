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

/**
 * This test class verifies the Facility enrollment fingerprint work flow.
 */
@Listeners(VideoListener.class)
public class FacilityEnrollmentVerifyFingerPrintProcessAndApproveTest extends BaseClassUI {
    String applicationType = Data.facilityApplication;
    String paymentOption = "Offline" ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);


    /**
     * This test method retrieves a Facility enrollment with 'Pending Review' status from ProviderInfo.xlsx, logs into
     * DyP as an Internal User, executes a search for the enrollment, verifies fingerprinting, approves the
     * enrollment, writes the enrollment information to ProviderInfo.xlsx and logs out as the Internal User.
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
            dependsOnGroups = "FacilityScreening",  groups = "FingerPrintVerification"  )
    public void VerifyApplication(String testEnvironment, String firstName, String lastName, String emailID,
                                  String taxonomy, String npi, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName, lastName, "PENDING REVIEW", trackingNum);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {


            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstName, lastName, trackingNum);

//Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            //review and vote for this request
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName, lastName);

            //Pending Approval
            //Verify Payment
            if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
                if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                    enrollmentPageInternalUser.verifyPaymentForFacility(firstName, lastName);
                }
                enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
            }
        }

        ProviderInformation.updateProviderData(providerInfoSheet, applicationType,firstName,lastName,enrollmentPageInternalUser.getApplicationStatus());
        excel.readExcel();
        enrollmentPageInternalUser.logOut();
    }
}
