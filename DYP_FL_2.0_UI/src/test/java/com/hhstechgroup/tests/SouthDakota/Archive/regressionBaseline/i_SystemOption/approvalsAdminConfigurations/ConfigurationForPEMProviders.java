package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption.approvalsAdminConfigurations;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 * This class contains tests for Approval Admin Base configurations For PEM Provider under system Options.
 */
public class ConfigurationForPEMProviders extends BaseClassUI {
    String providerType = "Provider Enrollment Manager" ;

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For PEM Enrollments
     */
    @Test
    public void verifyConfigurationForPEMEnrollmentsTest() {
        Reports.log("This test is to verify  Approval Admin Base configurations For PEM Enrollments under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationEnrollments(true);
    }


    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For PEM Revalidation
     */
    @Test
    public void verifyConfigurationForPEMRevalidationTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For PEM Revalidation under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationRevalidation(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For PEM Appeal Approval
     */
    @Test
    public void verifyConfigurationForPEMAppealApprovalTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For PEM Appeal under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationAppealApp(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For PEM CoC
     */
    @Test
    public void verifyConfigurationForPEMCOCTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For PEM COC under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationCOC(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For PEM Site Visit
     */
    @Test
    public void verifyConfigurationForPEMSiteVisitTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For PEM Site Visit under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationSiteVisit(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For PEM Re-Enrollments
     */
    @Test
    public void verifyConfigurationForPEMReEnrollmentTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For PEM Re Enrollment under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationReEnrollment(true);
    }
}
