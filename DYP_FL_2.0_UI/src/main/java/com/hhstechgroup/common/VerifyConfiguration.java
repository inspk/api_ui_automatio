package com.hhstechgroup.common;

import com.hhstechgroup.Pages.DashboardPage;
import com.hhstechgroup.Pages.LandingPage;
import com.hhstechgroup.Pages.LoginPage;
import com.hhstechgroup.Pages.SystemOptions;
import com.hhstechgroup.common.configurationfactory.ConfigurationVerifier;
import com.hhstechgroup.common.configurationfactory.ConfigurationFactory;
import com.hhstechgroup.constant.SDConfigurationConstants;
import com.hhstechgroup.constant.SDSystemOptionsConstants;
import com.hhstechgroup.internal_user.EnrollmentPageInternalUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class contains Configuration verification methods called by the {@link ConfigurationVerifier} class
 */
public class VerifyConfiguration extends BaseActions {
    ConfigurationFactory factory = new ConfigurationFactory();
    ConfigurationVerifier configurationVerifier = new ConfigurationVerifier((factory));
    public SystemOptions systemOptions = new SystemOptions(driver, wait);
    public LoginPage loginPage = new LoginPage(driver, wait);
    public LandingPage landingPage = new LandingPage(driver, wait);
    public DashboardPage dashboardPage = new DashboardPage(driver, wait);
    protected EnrollmentPageInternalUser enrollmentPageInternalUser;
    /**
     * This is a parameterized constructor
     *
     * @param driver driver
     * @param wait wait
     */
    public VerifyConfiguration(WebDriver driver, WebDriverWait wait) {super(driver, wait);}

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Affiliation System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyAffiliationSO(String internalUserEmail, String internalUserPassword,
                                    String systemOption, DashboardPage dashboardPage) throws Exception {

        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Affiliations tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_AFFILIATIONS,
                SDConfigurationConstants.AFFILIATIONS_TITLE_XPATH, SDConfigurationConstants.LINK_AFFILIATIONS);

        Reports.log("Verifying Affiliations configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Approvals System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyApprovalsSO(String internalUserEmail, String internalUserPassword,
                                  String systemOption, DashboardPage dashboardPage) throws Exception {
        Reports.log("The Test will verify the configuration of System Options -> Approvals");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Approvals tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_APPROVALS,
                SDConfigurationConstants.APPROVALS_TITLE_XPATH, SDConfigurationConstants.LINK_APPROVALS);

        Reports.log("Verifying Approvals configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Auto Archive System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyAutoArchiveSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {}

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Builder System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyBuilderSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {}

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Custom Sections System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyCustomSectionsSO(String internalUserEmail, String internalUserPassword,
                                       String systemOption, DashboardPage dashboardPage) throws Exception {

        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Custom Sections tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_CUSTOM_SECTIONS,
                SDConfigurationConstants.CUSTOM_SECTIONS_TITLE_XPATH, SDConfigurationConstants.LINK_CUSTOM_SECTIONS);

        Reports.log("Verifying Custom Sections configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Data Change System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyDataChangeSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("The Test will verify the configuration of System Options -> Data Change");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Data Change tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_DATA_CHANGE,
                SDConfigurationConstants.DATA_CHANGE_TITLE_XPATH, SDConfigurationConstants.LINK_DATA_CHANGE_ACTIONS);

        Reports.log("Verifying Data Change configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Duplicity System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyDuplicitySO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {

        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Duplicity tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_DUPLICITY,
                SDConfigurationConstants.DUPLICITY_TITLE_XPATH, SDConfigurationConstants.LINK_DUPLICITY);

        Reports.log("Verifying Duplicity configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption,dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Enrollment Types System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyEnrollmentTypesSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Enrollment Types tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_ENROLLMENT_TYPES,
                SDConfigurationConstants.ENROLLMENT_TYPES_TITLE_XPATH, SDConfigurationConstants.LINK_ENROLLMENT_TYPES);

        Reports.log("Verifying Enrollment Types configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption,dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Externalization System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyExternalizationSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {}

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Licensure System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyLicensureSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("The Test will verify the configuration of System Options -> Licensure");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Licensure tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_LICENSURE,
                SDConfigurationConstants.LICENSURE_TITLE_XPATH, SDConfigurationConstants.LINK_lICENSURE);

        Reports.log("Verifying Licensure configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Notification Engine System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyNotificationSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Notification Engine tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_NOTIFICATION_ENGINE,
                SDConfigurationConstants.NOTIFICATION_TITLE_XPATH, SDConfigurationConstants.LINK_NOTIFICATION);

        Reports.log("Verifying Notification Engine configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Payment & Fees System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyPaymentFeesSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {

        Reports.log("The Test will verify the configuration of System Options -> Payment & Fees");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Payment & Fees tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_PAYMENTS_FEES,
                SDConfigurationConstants.PAYMENT_FEES_TILE_XPATH, SDConfigurationConstants.LINK_PAYMENT_FEES);

        Reports.log("Verifying Notification Engine configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * RAI System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyRAISO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("The Test will verify the configuration of System Options -> Request Additional Information");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Request Additional Information tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_REQUEST_ADDITIONAL_INFO,
                SDConfigurationConstants.REQUEST_ADDITIONAL_INFORMATION_TITLE_XPATH, SDConfigurationConstants.LINK_REQUEST_ADDITIONAL_INFO);

        Reports.log("Verifying Request Additional Information configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Reminders System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyRemindersSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {

        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Reminders to reviewers tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_REMINDERS_TO_REVIEWERS,
                SDConfigurationConstants.REMINDERS_TO_REVIEWERS_TITLE_XPATH, SDConfigurationConstants.LINK_REMINDERS_TO_REVIEWERS);

        Reports.log("Verifying Reminders to reviewers configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Revalidation System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyRevalidationSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {

        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Revalidation tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_REVALIDATION,
                SDConfigurationConstants.REVALIDATION_TITLE_XPATH, SDConfigurationConstants.LINK_REVALIDATION);

        Reports.log("Verifying Revalidation configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Roles System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyRolesSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Roles tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_ROLES,
                SDConfigurationConstants.ROLES_TITLE_XPATH, SDConfigurationConstants.LINK_ROLES);

        Reports.log("Verifying Roles configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Rules System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyRulesSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {}

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Screening System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyScreeningSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {

        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Screening tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_SCREENING,
                SDConfigurationConstants.SCREENING_TITLE_XPATH, SDConfigurationConstants.LINK_SCREENING);

        Reports.log("Verifying Screening configuration values");
        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        clickAnyTitleByText(SDSystemOptionsConstants.TITLE_EXIT, SDSystemOptionsConstants.h4);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Security Policy System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifySecurityPolicySO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Screening tile");
        systemOptions.systemOptionsEntryPoint(systemOption, SDConfigurationConstants.TITLE_SECURITY_POLICY_XPATH, SDConfigurationConstants.LINK_SECURITY_POLICY);

        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Site Visit System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifySiteVisitSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("The Test will verify the configuration of System Options -> Site Visits");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting Site Visits tile");
        systemOptions.systemOptionsEntryPoint(systemOption, SDConfigurationConstants.SYSTEM_OPTION_TITLE_SITE_VISIT_XPATH, SDConfigurationConstants.LINK_SITE_VISIT);

        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * User Deactivation System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyUserDeactivationSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting User Deactivation tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_USER_DEACTIVATION,
                SDConfigurationConstants.USER_DEACTIVATION_TITLE_XPATH, SDConfigurationConstants.LINK_USER_DEACTIVATION);

        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * User Profile System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyUserProfileSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        Reports.log("Go to System Options");
        dashboardPage.openSystemOptions();

        Reports.log("Selecting User Profile tile");
        systemOptions.systemOptionsEntryPoint(SDConfigurationConstants.TITLE_USER_PROFILE,
                SDConfigurationConstants.USER_PROFILE_TITLE_XPATH, SDConfigurationConstants.LINK_USER_PROFILE);

        configurationVerifier.verifySystemOption(driver, systemOption, dashboardPage);

        dashboardPage.logOut();
    }

    /**
     * This method is called by the {@link ConfigurationVerifier} class and executes the workflow that verifies the
     * Users System Option configuration values
     *
     * @param internalUserEmail Internal user email address for log-in
     * @param internalUserPassword Internal user password for Log-in
     * @param systemOption System Options value
     * @throws Exception Exception
     */
    public void verifyUsersSO(String internalUserEmail, String internalUserPassword, String systemOption) throws Exception {}


}
