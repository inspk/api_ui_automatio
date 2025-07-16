package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption.approvalsAdminConfigurations;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This class contains tests for Approval Admin Base configurations For Individual Provider under system Options.
 */
public class ConfigurationForIndividualProviders extends BaseClassUI {
    String providerType = "Individual Providers" ;
    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Individual Enrollments
     */
    @Test
    public void verifyConfigurationForIndividualEnrollmentsTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Individual Enrollments under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationEnrollments(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Individual Revalidation
     */
    @Test
    public void verifyConfigurationForIndividualRevalidatioTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Individual Revalidation under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationRevalidation(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Individual Appeal Approval
     */
    @Test
    public void verifyConfigurationForIndividualAppealApprovalTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Individual Appeal under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationAppealApp(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Individual Coc
     */
    @Test
    public void verifyConfigurationForIndividualCOCTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Individual COC under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationCOC(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Individual Site Visit
     */
    @Test
    public void verifyConfigurationForIndividualSiteVisitTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Individual Site Visit under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationSiteVisit(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Individual ReEnrollments
     */
    @Test
    public void verifyConfigurationForIndividualReEnrollmentTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Individual Re Enrollment under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationReEnrollment(true);
    }
}
