package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption.approvalsAdminConfigurations;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This class contains tests for Approval Admin Base configurations For Group Provider under system Options.
 */

public class ConfigurationForGroupProviders extends BaseClassUI {
    String providerType = "Group Providers" ;
    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Group Enrollments
     */
    @Test
    public void verifyConfigurationForGroupEnrollmentsTest() {
        Reports.log("This test is to verify  Approval Admin Base configurations For Group Enrollments under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);


        systemOptionsIE.verifyApprovalsAdminConfigurationEnrollments(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Group Revalidation
     */
    @Test
    public void verifyConfigurationForGroupRevalidationTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Group Revalidation under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);;
        systemOptionsIE.verifyApprovalsAdminConfigurationRevalidation(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Group Appeal Approvals
     */
    @Test
    public void verifyConfigurationForGroupAppealApprovalTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Group Appeal under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationAppealApp(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Group CoC
     */
    @Test
    public void verifyConfigurationForGroupCOCTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Group COC under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationCOC(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Group Site Visits
     */
    @Test
    public void verifyConfigurationForGroupSiteVisitTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Group Site Visit under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationSiteVisit(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies Approval Admin Base configurations For Group ReEnrollments
     */
    @Test
    public void verifyConfigurationForGroupReEnrollmentTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Group Re Enrollment under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationReEnrollment(true);
    }
}