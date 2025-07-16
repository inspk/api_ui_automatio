package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption.approvalsAdminConfigurations;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
/**
 * This class contains tests for Approval Admin Base configurations For Facility Provider under system Options.
 */
public class ConfigurationForFacilityProviders extends BaseClassUI {
    String providerType = "Facility" ;
/**
 * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
 * verifies  Approval Admin Base configurations For Facility Enrollments
 */
@Video
    @Test
    public void verifyConfigurationForFacilityEnrollmentsTest() {
        Reports.log("This test is to verify  Approval Admin Base configurations For Facility Enrollments under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationEnrollments(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies  Approval Admin Base configurations For Facility Revalidation
     */
    @Video
    @Test
    public void verifyConfigurationForFacilityRevalidationTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Facility Revalidation under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationRevalidation(true);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies  Approval Admin Base configurations For Facility Appeal Approvals
     */
    @Video
    @Test
    public void verifyConfigurationForFacilityAppealApprovalTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Facility Appeal under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationAppealApp(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies  Approval Admin Base configurations For Facility CoC
     */
    @Video
    @Test
    public void verifyConfigurationForFacilityCOCTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Facility COC under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationCOC(false);
    }
    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies  Approval Admin Base configurations For Facility Site Visits
     */
    @Video
    @Test
    public void verifyConfigurationForFacilitySiteVisitTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Facility Site Visit under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationSiteVisit(false);
    }

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Approvals and
     * verifies  Approval Admin Base configurations For Facility ReEnrollment
     */
    @Video
    @Test
    public void verifyConfigurationForFaciliryReEnrollmentTest() {
        Reports.log("This test is to verify if Approval Admin Base configurations For Facility Re Enrollment under system Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.verifyApprovalsAdminConfigurationReEnrollment(true);
    }
}
