package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption.approvalsAdminConfigurations;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This class contains tests for Approval Admin Base configurations For Pharmacy Provider under system Options.
 */
public class ConfigurationForPharmacy extends BaseClassUI {
    String providerType = "Pharmacy" ;
    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Pharmacy Enrollments
     */
    @Test
    public void verifyConfigurationForPharmacyEnrollmentsTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Pharmacy Enrollments under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationEnrollments(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Pharmacy Revalidation
     */
    @Test
    public void verifyConfigurationForPharmacyRevalidationTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Pharmacy Revalidation under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationRevalidation(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Pharmacy Appeal approval
     */
    @Test
    public void verifyConfigurationForPharmacyAppealApprovalTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Pharmacy Appeal under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationAppealApp(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Pharmacy CoC
     */
    @Test
    public void verifyConfigurationForIPharmacyCOCTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Pharmacy COC under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationCOC(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Pharmacy Site Visit
     */
    @Test
    public void verifyConfigurationForPharmacySiteVisitTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Pharmacy Site Visit under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationSiteVisit(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Pharmacy ReEnrollments
     */
    @Test
    public void verifyConfigurationForPharmacyReEnrollmentTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Pharmacy Re Enrollment under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationReEnrollment(true);
    }
}
