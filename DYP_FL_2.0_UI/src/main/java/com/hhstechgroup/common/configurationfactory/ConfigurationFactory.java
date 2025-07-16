package com.hhstechgroup.common.configurationfactory;

import com.hhstechgroup.Pages.DashboardPage;
import com.hhstechgroup.common.configurationfactory.SOApprovals.*;
import com.hhstechgroup.common.configurationfactory.SORoles.*;
import com.hhstechgroup.constant.SDConfigurationConstants;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

/**
 * This class utilizes Systems Options class objects created by the {@link ConfigurationVerifier} class to verify a
 * System Option configuration
 */
public class ConfigurationFactory {

    private final SoftAssert softAssert = new SoftAssert();

    /**
     * This method verifies a configuration based on the System Option specified by creating a Systems Options
     * object from one of the following classes and calling the object's verify system option method:
     * {@link SOAffiliations} {@link SOIndividualApprovals} {@link SOGroupApprovals} {@link SOTradingPartnerApprovals}
     * {@link SOPEMApprovals} {@link SOAutoArchive} {@link SOBuilder}
     * {@link SOCustomSections} {@link SODataChange} {@link SODuplicity} {@link SOEnrollmentTypes}
     * {@link SOExternalization} {@link SOLicensure} {@link SONotification} {@link SOPaymentsFees}
     * {@link SORai} {@link SOReminders} {@link SORevalidation} {@link SORolesProviderAdmin}
     * {@link SORolesProviderSpecialist} {@link SORolesCallCenterAgent} {@link SORules}
     * {@link SOScreening} {@link SOSecurityPolicy} {@link SOSiteVisit} {@link SOUserDeactivation}
     * {@link SOUserProfile} {@link SOUsers}
     *
     * @param driver = driver
     * @param systemOption = systemOptions parameter
     * @throws Exception = exceptions
     */
    public void verifySystemOption(WebDriver driver, String systemOption, DashboardPage dashboardPage) throws Exception {

        switch(systemOption) {
            case SDConfigurationConstants.TITLE_AFFILIATIONS:
                SOAffiliations affiliationsSystemOptions = new SOAffiliations();
                affiliationsSystemOptions.verifyAffiliationsSO(driver, dashboardPage, softAssert);
                break;
            case SDConfigurationConstants.TITLE_APPROVALS:
                SOIndividualApprovals individualApprovalsSystemOptions = new SOIndividualApprovals();
                individualApprovalsSystemOptions.verifyApprovalsSO(driver, dashboardPage, softAssert);
                SOGroupApprovals GroupApprovalsSystemOptions = new SOGroupApprovals();
                GroupApprovalsSystemOptions.verifyApprovalsSO(driver, dashboardPage, softAssert);
                SOTradingPartnerApprovals TradingPartnerApprovalsSystemOptions = new SOTradingPartnerApprovals();
                TradingPartnerApprovalsSystemOptions.verifyApprovalsSO(driver, dashboardPage, softAssert);
                SOPEMApprovals PEMApprovalsSystemOptions = new SOPEMApprovals();
                PEMApprovalsSystemOptions.verifyApprovalsSO(driver, dashboardPage, softAssert);
                break;
            case "Auto Archive":
                SOAutoArchive autoArchiveSystemOptions = new SOAutoArchive();
                autoArchiveSystemOptions.verifyAutoArchiveSO(driver);
                break;
            case "Builder":
                SOBuilder builderSystemOptions = new SOBuilder();
                builderSystemOptions.verifyBuilderSO(driver);
                break;
            case SDConfigurationConstants.TITLE_CUSTOM_SECTIONS:
                SOCustomSections customSectionsSystemOptions = new SOCustomSections();
                customSectionsSystemOptions.verifyCustomSectionsSO(driver, dashboardPage, softAssert);
                break;
            case SDConfigurationConstants.TITLE_DATA_CHANGE:
                SODataChange dataChangeSystemOptions = new SODataChange();
                dataChangeSystemOptions.verifyDataChangeSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_DUPLICITY:
                SODuplicity duplicitySystemOptions = new SODuplicity();
                duplicitySystemOptions.verifyDuplicitySO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_ENROLLMENT_TYPES:
                SOEnrollmentTypes enrollmentTypesSystemOptions = new SOEnrollmentTypes();
                enrollmentTypesSystemOptions.verifyEnrollmentTypesSO(driver, softAssert);
                break;
            case "Externalization":
                SOExternalization externalizationSystemOptions = new SOExternalization();
                externalizationSystemOptions.verifyExternalizationSO(driver);
                break;
            case SDConfigurationConstants.TITLE_LICENSURE:
                SOLicensure licensureSystemOptions = new SOLicensure();
                licensureSystemOptions.verifyLicensureSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_NOTIFICATION_ENGINE:
                SONotification verifyNotificationSO = new SONotification();
                verifyNotificationSO.verifyNotificationSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_PAYMENTS_FEES:
                SOPaymentsFees paymentsFeesSystemOptions = new SOPaymentsFees();
                paymentsFeesSystemOptions.verifyPaymentsFeesSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_REQUEST_ADDITIONAL_INFO:
                SORai raiSystemOptions = new SORai();
                raiSystemOptions.verifyRaiSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_REMINDERS_TO_REVIEWERS:
                SOReminders rtrSystemOptions = new SOReminders();
                rtrSystemOptions.verifyRemindersSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_REVALIDATION:
                SORevalidation revalidationSystemOptions = new SORevalidation();
                revalidationSystemOptions.verifyRevalidationSO(driver,dashboardPage, softAssert);
                break;
            case SDConfigurationConstants.TITLE_ROLES:
                SORolesController rolesController = new SORolesController();
                rolesController.rolesSystemOptions(driver, dashboardPage,softAssert);
                break;
            case "Rules":
                SORules rulesSystemOptions = new SORules();
                rulesSystemOptions.verifyRulesSO(driver);
                break;
            case SDConfigurationConstants.TITLE_SCREENING:
                SOScreening screeningSystemOptions = new SOScreening();
                screeningSystemOptions.verifyScreeningSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_SECURITY_POLICY:
                SOSecurityPolicy securityPolicySystemOptions = new SOSecurityPolicy();
                securityPolicySystemOptions.verifySecurityPolicySO(driver,softAssert);
                break;
            case SDConfigurationConstants.TITLE_SITE_VISIT:
                SOSiteVisit siteVisitSystemOptions = new SOSiteVisit();
                siteVisitSystemOptions.verifySiteVisitSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_USER_DEACTIVATION:
                SOUserDeactivation userDeactivationSystemOptions = new SOUserDeactivation();
                userDeactivationSystemOptions.verifyUserDeactivationSO(driver, softAssert);
                break;
            case SDConfigurationConstants.TITLE_USER_PROFILE:
                SOUserProfile userProfileSystemOptions = new SOUserProfile();
                userProfileSystemOptions.verifyUserProfileSO(driver,softAssert);
                break;
            case "Users":
                SOUsers usersSystemOptions = new SOUsers();
                usersSystemOptions.verifyUsersSO(driver);
                break;
        }
        softAssert.assertAll();
    }

}
