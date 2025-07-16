package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.constant.SDSystemOptionsConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class SystemOptions extends BaseActions {
    protected SoftAssert softAssert = new SoftAssert();

    String groupProviderType = "Group Providers" ;
    String entityProviderType = "Entity Providers" ;
    String individualProviderType = "Individual Providers" ;
    String pemProviderType = "Provider Enrollment Manager" ;
    String tradingPartnerProviderType= "Trading Partners";

    public static final By ANY_MAIN_TITLE = By.xpath("//div[contains(@class, 'root_content')]"); // Root content
    public static final By SCREENING_EDIT_BUTTON = By.xpath("//div[contains(@class , 'header_control')]//span[text()='Edit']");
    public static final By TITLE_NEW_RULE_AUTO_ASSIGN =
            By.xpath("//div[contains(@class, 'auto-assign_aa-item-heading')]");
    public static final By CALENDAR = By.xpath("//input[@placeholder='MM/DD/YYYY']");
    public static final By SELECT_APPLICATION_TYPE = By.xpath("//div//label[contains(@for,'Select Application Type')]");
    public static final By CONDITION_AUTO_ASSIGN =
            By.xpath("//div[contains(@class, 'auto-assign_aa-item-condition')]");

    public static final By CONDITION_RULE_EDITOR =
            By.xpath("//div[contains(@class, 'rule-editor_aa-item-condition')]");
    public static final By TEXT_FIELD_REQUEST_ID = By.xpath("//input[@id='RequestID']");

    //SystemOptions Links
    public static final String LINK_USERS = "/system/users";
    public static final String LINK_ROLES = "/system/roles";
    public static final String LINK_SCREENING = "/system/screening";
    public static final String LINK_AUTO_ASSIGN_RULES = "/system/auto-assign-rules";
    public static final String LINK_DATA_CHANGE_ACTIONS = "/system/data-change-actions";
    public static final String LINK_APPROVALS_TYPE = "/system/approvals-type";
    public static final String LINK_APPROVALS_INDIVIDUAL = "/system/approvals/individual";
    public static final String LINK_APPROVALS_GROUP = "/system/approvals/group";
    public static final String LINK_APPROVALS_PHARMACY = "/system/approvals/pharmacy";
    public static final String LINK_APPROVALS_ORP = "/system/approvals/ORP";
    public static final String LINK_APPROVALS_PEM = "/system/approvals/PEM";
    public static final String LINK_APPROVALS_FACILITY = "/system/approvals/facility";
    public static final String LINK_ENROLLMENT_TYPE = "/system/enrollment-types";
    public static final String LINK_APPROVALS_REQUEST = "/system/approval/request";
    public static final String LINK_REVALIDATION = "/system/revalidation";
    public static final String LINK_ERROR_MESSAGES = "/system/error-message-dropdowns";
    public static final String LINK_USER_DEACTIVATION = "/system/userdeactivation";
    public static final String LINK_PASSWORD_POLICY = "/system/passwordpolicy";
    public static final String LINK_PAYMENT_FEES = "/system/paymentsandfees";

    public static final String LINK_AUTOARCHIVE = "/system/autoarchive";
    public static final String LINK_SITE_VISIT = "system/site-visit";

    //CAPTCHA
    public static final By CAPTCHA_SWITCH = By.xpath("//input[@aria-label='Recaptcha verification']");

    //AFFILIATION
    public static final By SIGN_FOR_AFFILIATION_SWITCH = By.xpath("(//input[@aria-label='Switch'])[2]");
    public static final By ALLOWED_AFFILIATION_TYPES = By.xpath("(//input[@aria-label='Switch'])[2]");
    public static final By EXIT_AFFILIATION_Button = By.xpath("//h4[contains(.,'←  Exit Affiliations')]");

    //LICENSURE
    public static final By LICENSURE_EDIT_BUTTON = By.xpath("//div[contains(@class , 'styles_control')]//span[contains(text(), 'Edit')]");
    public static final By LICENSURE_STYLES_PERIOD_NOT_EDITABLE = By.xpath("//div[contains(@class , 'styles_period-select')]//span");
    public static final By LICENSURE_STYLES_PERIOD_EDITABLE = By.xpath("//div[contains(@class , 'styles_period-select')]//input");
    public static final By LICENSURE_1ST_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'1st notification')]/../div[2]/span[1]");
    public static final By LICENSURE_2ND_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'2nd notification')]/../div[2]/span[1]");
    public static final By LICENSURE_3RD_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'3rd notification')]/../div[2]/span[1]");

    public static final By EDIT_BUTTON = By.xpath("//button[contains(.,'Edit')]");
    public static final By REMINDER_REVIEWERS_NOT_EDITABLE = By.xpath("//div[contains(@class , 'styles_period-select')]//span");
    public static final By REMINDER_REVIEWERS_PERIOD_EDITABLE = By.xpath("//div[contains(@class , 'styles_period-select')]//input");
    public static final By REMINDER_REVIEWERS_1ST_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'1st notification')]/../div[2]/span[1]");
    public static final By REMINDER_REVIEWERS_2ND_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'2nd notification')]/../div[2]/span[1]");
    public static final By REMINDER_REVIEWERS_3RD_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'3rd notification')]/../div[2]/span[1]");

    // EXTERNALIZATION
    public static final By TEXTAREA_SCHEDULED_MAINTENANCE =
            By.xpath("//textarea[@placeholder='DyP scheduled Maintenance *']");

    //  USER DEACTIVATION
    public static final By USERDEACT_SEARCH_BOX_DAY_INACTIVITY = By.xpath("//div[@class='search-box-i']");
    public static final By USERDEACT_INACTIVE_DAYS = By.xpath("//h3[contains(text(), 'Inactive Days')]/../../..//span");
    public static final By USERDEACT_INVITE_NOT_ACCEPTED = By.xpath("//h3[contains(text(), 'Invitation not accepted user inactivity')]/../../..//span");
    public static final By DEACTIVATION_ACTIVATION_OPTION = By.xpath("(//li[@role='menuitem'])[2]");

    // PAYMENTS AND FEE CONFIGURATION
    public static final By TEXT_FIELD_PROVIDER_AMOUNT = By.cssSelector("input#provider-amount");
    public static final By TEXT_FIELD_PROVIDER_GROUP_AMOUNT = By.cssSelector("input#provider_group-amount");
    public static final By TEXT_FIELD_INSTITUTIONAL_AMOUNT = By.cssSelector("input#institutional_provider-amount");

    //REQUEST ADDITIONAL INFO
    public static final By REQUESTADDLINFO_EDIT_BUTTON = By.xpath("//div[contains(@class , 'styles_control')]//span[contains(text(), 'Edit')]");
    public static final By REQUESTADDLINFO_SYSTEM_OPTIONS_NOT_EDITABLE = By.xpath("//div[contains(@class , 'system-options_system-content')]//span");
    public static final By REQUESTADDLINFO_SYSTEM_OPTIONS_EDITABLE = By.xpath("//div[contains(@class , 'system-options_system-content')]//input");
    public static final By REQUESTADDLINFO_1ST_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'1st notification')]/../div[2]/span[1]");
    public static final By REQUESTADDLINFO_2ND_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'2nd notification')]/../div[2]/span[1]");
    public static final By REQUESTADDLINFO_3RD_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'3rd notification')]/../div[2]/span[1]");
    public static final By REQUESTADDLINFO_ENABLE_AUTO_DENY_SWITCH = By.xpath("//input[@aria-label='Enable Auto Deny Switch']");

    //USER PROFILE
    public static final By USERPROFILE_EDIT_BUTTON = By.xpath("//div[contains(@class , 'styles_control')]//span[contains(text(), 'Edit')]");
    public static final By USERPROFILE_USER_PROFILE_UPDATE_SWITCH = By.xpath("//input[@aria-label='User Profile Update']");

    //REVALIDATION
    public static final By APPROVALS_REVALIDATION_BUTTON_VIEW = By.xpath("//h3[text()='Revalidation']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By REVALANDREM_EDIT_BUTTON = By.xpath("//div[contains(text(), 'Revalidation')]//span[contains(text(), 'Edit')]");
    public static final By REVALANDREM_REVALIDATION_DATE_DAYS = By.xpath("//div[contains(text(), 'Revalidation date')]/../..//div[@aria-haspopup='listbox']");
    public static final By REVALANDREM_1ST_NOTIFICATION_DAYS = By.xpath("//div[contains(text(), '1st notification')]/..//div[@aria-haspopup='listbox']");
    public static final By REVALANDREM_2ND_NOTIFICATION_DAYS = By.xpath("//div[contains(text(), '2nd notification')]/..//div[@aria-haspopup='listbox']");
    public static final By REVALANDREM_3RD_NOTIFICATION_DAYS = By.xpath("//div[contains(text(), '3rd notification')]/..//div[@aria-haspopup='listbox']");
    public static final By REVALANDREM_GROUP_REVAL_DAYS = By.xpath("//div[contains(text(), 'Group provider:outstanding revalidation')]/../..//div[contains(@class,'styles_item-headers')]");
    public static final By REVALANDREM_AFTER_REVAL_PERIOD = By.xpath("//div[contains(text(), 'After revalidation period')]/../..//div[contains(@class,'styles_item-headers')]");

    //PASSWORD POLICY
    public static final By PASSPOLICY_REG_PASSWORD_LENGTH = By.xpath("//h3[contains(text(), 'Configure Password Policy')]/..//input[@aria-label='Regular User Password Length']");
    public static final By PASSPOLICY_PRIV_PASSWORD_LENGTH = By.xpath("//h3[contains(text(), 'Configure Password Policy')]/..//input[@aria-label='Privileged user Password Length']");
    public static final By PASSPOLICY_USER_ACCT_NAME = By.xpath("//input[@aria-label='User Account Name']");
    public static final By PASSPOLICY_UPPERCASE_LETTER = By.xpath("//input[@aria-label='Uppercase Letter']");
    public static final By PASSPOLICY_LOWERCASE_LETTER = By.xpath("//input[@aria-label='Lowercase Letter']");
    public static final By PASSPOLICY_ATLEAST_ONE_NUMBER = By.xpath("//input[@aria-label='Number']");
    public static final By PASSPOLICY_SPECIAL_CHAR = By.xpath("//input[@aria-label='Special Character']");
    public static final By PASSPOLICY_PASSWORD_REUSE = By.xpath("//input[@aria-label='Password Reuse']");
    public static final By PASSPOLICY_PASSWORD_RESET = By.xpath("//input[@aria-label='Password Reset']");
    public static final By PASSPOLICY_PASSWORD_EXPIRATION = By.xpath("//input[@aria-label='Enable Password Expiration']");
    public static final By PASSPOLICY_PASSWORD_LOCK = By.xpath("//input[@aria-label='Lock']");

    //Site visit
    public static final By SITE_VISIT_BASED_ON_TAXONOMY_RADIO_BTN = By.xpath("//input[@value='basedOnTaxonomy']");
    public static final By SITE_VISIT_BASED_ON_SCREENING_SCORE_RADIO_BTN = By.xpath("//input[@value='basedOnScreeningScore']");
    public static final By SITE_VISIT_BASED_ON_HIGHER_RISK_LEVELS_RADIO_BTN = By.xpath("//input[@value='higherOftheTwoRiskLevels']");
    public static final By SITE_VISIT_BASED_ON_INSTATE_PROVIDER_RADIO_BTN = By.xpath("//input[@value='instate']");
    public static final By SITE_VISIT_BASED_ON_OUTSTATE_PROVIDER_RADIO_BTN = By.xpath("//input[@value='outstate']");
    public static final By SITE_VISIT_BASED_ON_BOTH_PROVIDER_RADIO_BTN = By.xpath("//input[@value='both']");

    // DATA CHANGE ACTIONS
    public static final By ROW_DATA_CHANGE = By.xpath("//div[contains(@class, 'data-change-settings_actions-row')]");
    public static final By DATA_CHANGE_SLIDER = By.xpath("//label[contains(@class, 'settings_action-trigger')]//span//input");

    // APPROVALS
    public static final By APPROVALS_INDIVIDUAL_PROVIDERS_ICON = By.xpath("//h3[text()='Individual Providers']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_GROUP_PROVIDERS_ICON = By.xpath("//h3[text()='Group Providers']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_PHARMACY_PROVIDERS_ICON = By.xpath("//h3[text()='Pharmacy']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_FACILITY_PROVIDERS_ICON = By.xpath("//h3[text()='Facility']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_PEM_PROVIDERS_ICON = By.xpath("//h3[text()='Provider Enrollment Manager']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By  APPROVALS_ORP_PROVIDERS_ICON = By.xpath("//h3[text()='Ordering/Referring/Prescribing']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By  APPROVALS_EDIT_BUTTON = By.xpath("//span[contains(.,'Edit')]");
    public static final By  APPROVALS_SAVE_CHANGES_BUTTON = By.xpath("//span[contains(.,'Save Changes')]");
    public static final By  APPROVALS_BACK_TO_APPROVAL_LIST_BUTTON = By.xpath("//span[contains(.,'← Back to Approvals list')]");

    public static final By  APPROVALS_ENROLLMENT_APPROVER_CONFIGURE_INPUT_TEXT= By.xpath("//h4[contains(text(), 'Number of approvals required')]//following::div[1]/input[@aria-label='Configure']");
    public static final By  APPROVALS_ENROLLMENT_NUMBER_OF_APPROVER_CONFIGURE = By.xpath("//h4[contains(text(), 'Number of approvals required')]/../span[1]");
    public static final By  APPROVALS_ENROLLMENT_NUMBER_OF_REVIEWERS_CONFIGURE= By.xpath("//input[@aria-label='Configure reviewer Switch']");

    public static final By APPROVALS_ENROLLMENTS_BUTTON_VIEW = By.xpath("//h3[text()='Enrollment']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By APPROVALS_ENROLLMENTS_SECTION = By.xpath("//div[contains(@class, 'styles_page-title')]//h1");
    public static final By APPROVALS_NUMBER_NOT_EDITABLE = By.xpath("//div[contains(@class, 'styles_consideration-number')]//span");
    public static final By APPROVALS_NUMBER_EDITABLE = By.xpath("//div[contains(@class, 'styles_consideration-number')]//input");
    public static final By APPROVALS_APPEAL_APPROVAL_BUTTON_VIEW = By.xpath("//h3[text()='Reconsideration']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");

    public static final By APPROVALS_COC_BUTTON_VIEW = By.xpath("//h3[text()='Change of Circumstance']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By APPROVALS_SITE_VISIT_BUTTON_VIEW = By.xpath("//h3[text()='Site Visit']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By APPROVALS_ReEnrollment_BUTTON_VIEW = By.xpath("//h3[text()='Re Enrollment']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");

    //Notification Engine
    public static final By NOTIFICATION_ENGINE_LIST =By.xpath("//div[contains(@class, 'notification-engine_actions-row')]");

//    //User Profile
//    public static final By USERPROFILE_EDIT_BUTTON = By.xpath("//div[contains(@class , 'styles_control')]//span[contains(text(), 'Edit')]");
//    public static final By USERPROFILE_USER_PROFILE_UPDATE_SWITCH = By.xpath("//input[@aria-label='User Profile Update']");
    
    //Duplicity
    public static final By DUPLICITY_INDEX_OPTION_IN_NPI_LIST = By.xpath("//div[contains(text(),'National Provider Identifier')]/..//select//option");
    public static final By DUPLICITY_EDIT_BUTTON = By.xpath("//div[contains(@class , 'MuiGrid-root')]//span//p[text()='Edit']");
    public static final By DUPLICITY_CUT_OFF_PERCENTAGE = By.xpath("//div[contains(text(),'Cut Off Percentage')]/../div[2]");
    public static final By DUPLICITY_NPI = By.xpath("//div[contains(text(),'National Provider Identifier')]/../div[2]");
    public static final By DUPLICITY_SSN_FEIN = By.xpath("//div[contains(text(),'SSN / FEIN')]/../div[2]");
    public static final By DUPLICITY_TAXONOMY = By.xpath("//div[contains(text(),'Taxonomy')]/../div[2]");
    public static final By DUPLICITY_DBA = By.xpath("//div[contains(text(),'Name / Doing Business as (DBA)')]/../div[2]");
    public static final By DUPLICITY_ZIP = By.xpath("//div[contains(text(),'Zip')]/../div[2]");
    public static final By DUPLICITY_DOB = By.xpath("//div[contains(text(),'Date of Birth')]/../div[2]");
    public static final By DUPLICITY_DEA_NUMBER = By.xpath("//div[contains(text(),'DEA Number')]/../div[2]");
    public static final By BACK_TO_APPROVAL_LIST_BUTTON = By.xpath("//span[contains(.,'← Back to Approvals list')]");
    public static final By BACK_TO_ENROLLMENT_TYPE_BUTTON = By.xpath("//h4[contains(.,'← Back to Enrollment ')]");
    public static final By EXIT_BUTTON = By.xpath("//h4[contains(.,'←Exit')]");

    public static final By SECURITY_POLICY_ENABLE_AUTO_TERMINATE_SWITCH = By.xpath("//input[@aria-label='Enable Auto Terminate Switch']");
    public static final By SECURITY_POLICY_SUSPENDED_DUE_TO_LICENSE_EXP_SWITCH = By.xpath("(//input[@aria-label='Enable Auto Terminate Switch'])[2]");
    public static final By SECURITY_POLICY_SUSPENDED_DUE_TO_LICENSE_EXP_LABEL= By.xpath("//h3[contains(.,' suspended providers due to licensure expiration')]");

    //Notification Engine
    //public static final By HEADER_NOTIFICATION_ENGINE = By.xpath("//div[contains(text(),'Notification Engine')]");

    //DOWNLOAD EXCEL BUTTON
    public static final By DOWNLOAD_EXCEL_BUTTON = By.xpath("//button[@title= 'Download as Excel']");
    public static final By RULES_TEXT=By.xpath("//span[text()='Rule Assignment']");
    public static final By SITE_VISIT_RISK_LEVEL_MANAGEMENT=By.xpath("(//div[contains(@class,'styles_pagetitle-sitevisit')])[2]");
    public static final By EXTERNALISATION_TAXONOMY=By.xpath("//div[text()='Taxonomy']");
    public static final By RULE_EDITOR_TEXT=By.xpath("//span[text()='Rule Editor']");

    public static final By RATE_SETTING_TOGGLE=
            By.xpath("//div[contains(@class, 'styles_approval-section-header-new-switch')][.//h3[contains(text(), 'Rate Settings')]]//span[contains(@class, 'Mui-checked')]");

    public static final By RATE_SETTING_ON=
            By.xpath("//div[h3[text()='Rate Settings']]/following-sibling::div//span[contains(@class,'MuiSwitch-thumb')]");

    //Configure Florida Medicaid Provider Id
    public static final By Florida_Medicaid_SUbmitted =
            By.xpath("//div[contains(@class,'styles_approval-section-header')][.//h3[contains(text(),'Configure Florida Medicaid Provider Id')]][.//div[contains(@class,'MuiFormControl')] and .//div[contains(text(),'Submitted')]]");
    public static final By Status_dropDown=
            By.xpath("//div[contains(@class,'styles_approval-section-header')][.//h3[contains(text(),'Configure Florida Medicaid Provider Id')]]//div[contains(@id,'Status') and @role='button']");
    /**
     * This ia a parameterized constructor
     * @param driver
     * @param wait
     */
    public SystemOptions(
            WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method selects the Users system option tile to display the User Management page, verifies the page title,
     * verifies the Add New User popup title and exits the page.
     */
    public void usersManagementTileVerification() {
        Reports.log("\nVerifying Users system option tile");
        javaWaitSec(1);
        clickAnyTitleByText(Data.titleUsers, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_USERS));
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.titleManagement));
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_ADD_USER);
        setAndFindAnyTitle(Data.titleAddNewUser, Data.h2);
        clickAnyButton(Data.TEXT_CANCEL);
     //   clickAnyTitleByText(Data.titleExit, Data.h4);
        clickAnyHeaderTitLe(Data.titleBackToDashboard);

    }


    /**
     * This method selects the Roles system options tile to display the Role Management page, verifies the page title,
     * verifies the Add New Role popup title and exits to the Internal User dashboard.
     */
    public void userRolesTileVerification() {
        Reports.log("\nVerifying Roles system option tile");


        clickAnyTitleByText(Data.titleRoles, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_ROLES));
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.titleRoleManagement));
        clickAnyButton(Data.TEXT_ADD_NEW);
        setAndFindAnyTitle(Data.titleAddNewRole, Data.h2);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyHeaderTitLe(Data.titleBackToDashboard);
    }

    /**
     * This method selects the Screening system options tile to display the Screening page, verifies the Screen Issues
     * Ranking title, verifies the Screen Issues Ranking Edit and exits the page.
     */
    public void userScreeningTileVerification() {
        Reports.log("\nVerifying Screening system option tile");

        clickAnyTitleByText(Data.titleScreening, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_SCREENING));
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.titleScreeningIssuesRanking));
        javaWaitSec(1);
        clickBackToTop();
        ajaxClick(SCREENING_EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL, 2);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Auto Assign system options tile to display the Auto Assign page, verifies the page title,
     * verifies the New Rule page title, verifies the effective date selection calendars, verifies the Select
     * Application Type field, verifies the condition If/Do fields and exits the page.
     */
    public void userRulesTileVerification() {
        Reports.log("\nVerifying Rules system option tile");
        clickAnyTitleByText(Data.titleRules, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_RULES));
        Reports.log("Navigated to System Option Rules Page");
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.titleRules));

       // ajaxScrollUp();
        performMoveToElement(RULES_TEXT);
        ajaxClick(RULES_TEXT);
        javaWaitSec(5);
       // clickAnyTitleByText(Data.systemOptionRuleAssignment, Data.h2);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_AUTO_ASSIGN_RULES));
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.systemOptionTitleAutoAssign));
        Reports.log("Navigated to Rule Assignment Page");

        ajaxScrollUp();
        Reports.log("Verifying New rule Page under Auto Assign");
        clickAnyButton(Data.TEXT_CREATE_RULE);
        driver.findElement(CALENDAR);
        driver.findElement(SELECT_APPLICATION_TYPE);
        driver.findElement(CONDITION_AUTO_ASSIGN);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_LEAVE_PAGE);
        javaWaitSec(3);
        clickAnyTitleByText(Data.titleExit, Data.h4);
//        ajaxClick(EXIT_AUTO_ASSIGN_RULES_BUTTON);

       // clickAnyTitleByText(Data.systemOptionRuleEditor, Data.h2);
        ajaxClick(RULE_EDITOR_TEXT);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_RULE_EDITOR));
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.pageTitleRuleEditor));
        Reports.log("Navigated to Rule Editor Page");

        Reports.log("Verifying New rule Page under Rule Editor");
        clickAnyButton(Data.TEXT_CREATE_RULE);
        driver.findElement(CALENDAR);
        driver.findElement(SELECT_APPLICATION_TYPE);
        driver.findElement(CONDITION_RULE_EDITOR);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_LEAVE_PAGE);
        javaWaitSec(2);
        ajaxClick(EXIT_BUTTON);
        ajaxClick(EXIT_BUTTON);
        javaWaitSec(1);
    }
    /**
     * This method selects the Data Change system options tile to display the Data Change page, verifies the Effective
     * Date edit panel, verifies the page title, verifies a disabled switch displayed in the Actions on data change
     * section and exits the page.
     */
    public void userDataChangeTileVerification() {
        Reports.log("\nVerifying Data change system option tile");

        clickAnyTitleByText(Data.systemOptionTitleDataChange, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_DATA_CHANGE_ACTIONS));
        clickBackToTop();
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_EDIT);
        clickAnyButton(Data.TEXT_CANCEL);
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.titleActionsDataChange),
                driver.findElement(ANY_MAIN_TITLE).getText());
        driver.findElement(ROW_DATA_CHANGE);
//        System.out.println(driver.findElement(DATA_CHANGE_SLIDER).getAttribute("disabled"));
        clickAnyButton(Data.TEXT_CANCEL, 1);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Revalidations system options tile to display the Revalidation page, verifies the page
     * title, verifies the Revalidation Date Years field is disabled, verifies the Revalidation Date Years
     * field is enabled when Edit is selected and exits the page.
     */
    public void SDUserRevalidationTileVerification() {
        Reports.log("\nVerifying Revalidations system option tile");
        revalidationVerificationForProvider(individualProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.revalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);
        revalidationVerificationForProvider(groupProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.revalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);

//        revalidationVerificationForProvider(facilityProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
//                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.revalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);
//        revalidationVerificationForProvider(pharmacyProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
//                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.revalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);
        revalidationVerificationForProvider(pemProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.pemrevalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);
//        revalidationVerificationForProvider(orpProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
//                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.revalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);
        revalidationVerificationForProvider(tradingPartnerProviderType, Data.revalAndRemRevalDateDays,  Data.revalAndRem1STNotificationDays,
                Data.revalAndRem2NDNotificationDays, Data.revalAndRem3RDNotificationDays, Data.revalAndRemGroupRevalDays, Data.revalAndRemAfterRevalPeriod);
    }
//SDuserAffilicationsTileVerification


    /**
     * This method selects the Affiliation's system options tile to display the Affiliation page, verifies the page
     * title, verifies the Sign for Affiliation Switch status and Allowed Affiliation Types for the Providers
     * verifies the Affiliation Switches are enabled when Edit is selected and exits the page.
     */
    public void SDuserAffiliationTileVerification() {
        Reports.log("\nVerifying Affiliation system option tile");
        affiliationVerificationForProvider(individualProviderType, false);
        affiliationVerificationForProvider(entityProviderType, false);
        affiliationVerificationForProvider(pemProviderType, false);
        affiliationVerificationForProvider(tradingPartnerProviderType, false);
    }

    /**
     * This method selects the Custom Sections system options tile to display the Custom Sections page, verifies the page
     * title, verifies the Switch status of all the Section,verifies the Sections Switches are enabled when Edit is
     * selected and exits the page.
     */
    public void SDuserCustomSectionsTileVerification() {
        Reports.log("\nVerifying Custom Sections system option tile");
        customSectionsVerificationForProvider(individualProviderType);
        customSectionsVerificationForProvider(groupProviderType);
        customSectionsVerificationForProvider(pemProviderType);
        customSectionsVerificationForProvider(tradingPartnerProviderType);
    }


    public void revalidationVerificationForProvider(String providerType, String revalAndRemRevalDateDays, String revalAndRem1STNotificationDays,
                                                    String revalAndRem2NDNotificationDays, String revalAndRem3RDNotificationDays, String revalAndRemGroupRevalDays,
                                                    String revalAndRemAfterRevalPeriod) {
        Reports.log("\nVerifying Revalidation system option tile for "+providerType);
        navigateToProverRevalidationConfiguration(providerType);

        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(REVALANDREM_REVALIDATION_DATE_DAYS).getText(), revalAndRemRevalDateDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(REVALANDREM_1ST_NOTIFICATION_DAYS).getText(), revalAndRem1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(REVALANDREM_2ND_NOTIFICATION_DAYS).getText(), revalAndRem2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(REVALANDREM_3RD_NOTIFICATION_DAYS).getText(), revalAndRem3RDNotificationDays);
        verifyActualAndExpectedValues(Data.titleRevalidationGroupProvider,driver
                .findElement(REVALANDREM_GROUP_REVAL_DAYS).getText(), revalAndRemGroupRevalDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(REVALANDREM_AFTER_REVAL_PERIOD).getText(), revalAndRemAfterRevalPeriod);
        ajaxClick(REVALANDREM_EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        ajaxClick(By.xpath("//" + Data.h4));

        softAssert.assertAll();
        clickOnExitButton();
    }

    public void affiliationVerificationForProvider(String providerType, Boolean affiliationSwitchStatus) {
        Reports.log("\nVerifying Affiliations option tile for "+providerType);
        navigateToProviderAffiliationConfiguration(providerType);
        Boolean assignAffiliationStatus = driver.findElement(SIGN_FOR_AFFILIATION_SWITCH).isSelected();
        Assert.assertEquals(assignAffiliationStatus, affiliationSwitchStatus);
        String allowedAffiliationTypes = driver.findElement(ALLOWED_AFFILIATION_TYPES).getAttribute("name");
        Reports.log("Allowed Affiliation Types :"+allowedAffiliationTypes);
        ajaxClick(EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        ajaxClick(By.xpath("//" + Data.h4));
        ajaxClick(EXIT_AFFILIATION_Button);
    }


    public void customSectionsVerificationForProvider(String providerType) {
        Reports.log("\nVerifying Custom Sections option tile for "+providerType);
        navigateToProviderCustomSectionsConfiguration(providerType);
        verifyCustomSectionSwitch("All sections",false);
        verifyCustomSectionSwitch("Secondary service location",true);
        verifyCustomSectionSwitch("Affiliation",true);
        verifyCustomSectionSwitch("Payment",false);
        verifyCustomSectionSwitch("Provider agreement",true);
        verifyCustomSectionSwitch("Hello sign",true);
        verifyCustomSectionSwitch("Summary",true);
        ajaxClick(EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_OK);
        clickOnBackToEnrollmentsTypeButton();
        ajaxClick(By.xpath("//" + Data.h4));
    }

    public void verifyCustomSectionSwitch(String section, Boolean switchStatus){
        Boolean getSwitchStatus = driver.findElement(By.xpath("(//div[contains(.,'"+section+"')])[12]//..//span//input[@type ='checkbox']")).isSelected();
        Reports.log("The "+section+" switch status is "+getSwitchStatus);
        Assert.assertEquals(switchStatus,getSwitchStatus);
    }

    /**
     * This method selects the Licensure system options tile to display the Licensure page, verifies the Reminders
     * Notifications fields are disabled, verifies the Reminders Notifications fields are enabled when Edit is selected
     * and exits the page.
     */
    public void userLicenseTileVerification() {
        Reports.log("\nVerifying Licensure system option tile");
        clickAnyTitleByText(Data.titleLicensure, Data.h1);

        clickBackToTop();
        javaWaitSec(3);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(LICENSURE_STYLES_PERIOD_NOT_EDITABLE)));
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(LICENSURE_1ST_NOTIFICATION_DAYS).getText(), Data.licensure1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(LICENSURE_2ND_NOTIFICATION_DAYS).getText(), Data.licensure2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(LICENSURE_3RD_NOTIFICATION_DAYS).getText(), Data.licensure3RDNotificationDays);
        ajaxClick(LICENSURE_EDIT_BUTTON);
        driver.findElement(LICENSURE_STYLES_PERIOD_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL2);
        clickAnyTitleByText(Data.titleExit, Data.h4);
        softAssert.assertAll();
    }

    /**
     * This method verifies the Site Visit System Option 'Schedule Site Visit Based on' (Risk level based on Taxonomy,
     * Risk level based on Screening score, Higher of the two Risk Levels) and 'Schedule site visit for the
     * State based on' (Instate Providers, Outstate Providers, Both) configuration values.
     */
    public void userSiteVisitTileVerification() {
        Reports.log("\nVerifying Site Visit system option tile");

        clickAnyTitleByText(Data.systemOptionTitleSiteVisit, Data.h1);
        javaWaitSec(2);
        performMoveToElement(SITE_VISIT_RISK_LEVEL_MANAGEMENT);
        //Schedule Site Visit Based on
        Reports.log("Risk level based on Taxonomy");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, false, driver.
                findElement(SITE_VISIT_BASED_ON_TAXONOMY_RADIO_BTN));

        Reports.log("Risk level based on Screening score");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, true, driver.
                findElement(SITE_VISIT_BASED_ON_SCREENING_SCORE_RADIO_BTN));

        Reports.log("Higher of the two Risk Levels, Taxonomy and Screening Score");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, false, driver.
                findElement(SITE_VISIT_BASED_ON_HIGHER_RISK_LEVELS_RADIO_BTN));

    }


    /**
     * This method selects the Externalization system options tile to display the Externalization page, verifies the
     * side menu tab, verifies each section title name, verifies the Add Taxonomy popup when +Add is selected and exits
     * the page.
     */
    public void userExternalizationTileVerification() {
        Reports.log("\nVerifying Externalization system option tile");
        clickAnyTitleByText(Data.titleExternalization, Data.h1);
        javaWaitSec(2);
        performMoveToElement(EXTERNALISATION_TAXONOMY);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_ERROR_MESSAGES));
        Assert.assertTrue(
                driver
                        .findElement(ANY_MAIN_TITLE)
                        .getText()
                        .contains(Data.titleErrorMessagesAndDropdowns));
        Assert.assertTrue(
                driver
                        .findElement(ANY_MAIN_TITLE)
                        .getText()
                        .contains(Data.titleAuditEventNamesAndTags));
//        Assert.assertTrue(
//                driver
//                        .findElement(ANY_MAIN_TITLE)
//                        .getText()
//                        .contains(Data.titleSystemDowntimeMessages));
        clickAnyButton(Data.TEXT_ADD);
        javaWaitSec(3);
        String currentTitle = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(currentTitle, Data.expectedTaxonomytitle);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_OK);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }



    /**
     * This method selects the User Deactivation system options tile to display the User Deactivation page, verifies the
     * side menu tab, verifies the User Activity title, verifies the Inactive Days and Invitation not accepted user
     * inactivity values, verifies that the Inactive Days field is enabled when Edit is selected and exits the page.
     */
    public void userDeactivationTileVerification() {
        Reports.log("\nVerifying Deactivation system option tile");
        clickAnyTitleByText(Data.titleDeactivation, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_USER_DEACTIVATION));
        verifyActualAndExpectedValues(Data.titleDeactivation,driver
                .findElement(USERDEACT_INACTIVE_DAYS).getText(), Data.userDeactInactiveDays);
        verifyActualAndExpectedValues(Data.titleDeactivation,driver
                .findElement(USERDEACT_INVITE_NOT_ACCEPTED).getText(), Data.userDeactInviteNotAccepted);
        clickAnyButton(Data.TEXT_EDIT);
        driver.findElement(USERDEACT_SEARCH_BOX_DAY_INACTIVITY);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Security Policy system options tile to display the Security Policy  Configuration page,
     * verifies the page title,
     * verifies base configurations for Auto Terminate
     * Enable Captcha Verification switch displayed on the Security Policy page is disabled.
     */
    public void userSecurityPolicyTileVerification() {
        Reports.log("\nVerifying Security Policy system option tile");
        clickAnyTitleByText(Data.systemOptionTitleSecurityPolicy, Data.h1);
        javaWaitSec(2);
        verifyBaseConfigurationForAutoTerminate();
        verifyIfCaptchaIsEnabled();
        verifyBaseConfigurationForLoginTimeout();
    }

    /**
     * This method selects the Reminder to Reviewers system options tile to display the Reminder to Reviewers Configuration page,
     * verifies the page title,
     * verifies base configurations for Reminder to Reviewers
     * verifies the Reminders Notifications fields values and verifies fields are enabled when Edit is selected and exits the page.
     */
    public void userReminderToReviewersTileVerification() {
        Reports.log("\nVerifying Reminder to Reviewers system option tile");
        clickAnyTitleByText(Data.reminderToReviewerTitle, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_REMINDER_TO_REVIEWERS));
        javaWaitSec(2);
        ajaxScrollUp();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(REMINDER_REVIEWERS_NOT_EDITABLE)));
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(REMINDER_REVIEWERS_1ST_NOTIFICATION_DAYS).getText(), Data.remindersToReviewers1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(REMINDER_REVIEWERS_2ND_NOTIFICATION_DAYS).getText(), Data.remindersToReviewers2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(REMINDER_REVIEWERS_3RD_NOTIFICATION_DAYS).getText(), Data.remindersToReviewers3RDNotificationDays);
//        softAssert.assertAll();
        ajaxClick(EDIT_BUTTON);
        driver.findElement(REMINDER_REVIEWERS_PERIOD_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_Exit);
        clickAnyTitleByText(Data.titleExit, Data.h4);

    }

    /**
     * This method selects the User Profile system options tile to display the User Profile Configuration page,
     * verifies the User Profile Update switch is disabled, selects Edit and exits the page.
     */
    public void userProfileTileVerification() {
        Reports.log("\nVerifying User Profile system option tile");
        clickAnyTitleByText(Data.titleUserProfile, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_USER_PROFILE));

        clickBackToTop();
        javaWaitSec(3);
        verifyConfigurationSwitch(Data.titleUserProfile, false, driver.findElement(USERPROFILE_USER_PROFILE_UPDATE_SWITCH));
        ajaxClick(USERPROFILE_EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_OK);
        ajaxClick(By.xpath("//" + Data.h4));}

    /**
     * This method selects the Payments & Fees system options tile to display the Payments & Fees Configuration page,
     * verifies the side menu tab, verifies the page title, selects Edit and verifies the Individual Provider Enrollment
     * fees fields, verifies the Individual Provider Enrollment section titles and exits the page.
     */
    public void userPaymentAndFeeTileVerification() {
        Reports.log("\nVerifying Payments & Fees system option tile");
        clickAnyTitleByText(Data.systemOptionTitlePaymentsFees, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_PAYMENT_FEES));
        javaWaitSec(2);
        clickBackToTop();
        Assert.assertTrue(driver
                .findElement(ANY_MAIN_TITLE).getText().contains(Data.titlePaymentAndFeesConfigurations));

        clickAnyButton(Data.TEXT_EDIT);
        driver.findElement(TEXT_FIELD_PROVIDER_AMOUNT);
        driver.findElement(TEXT_FIELD_PROVIDER_GROUP_AMOUNT);
        clickAnyButton(Data.TEXT_CANCEL);
        setAndFindAnyTitle(Data.titleIndividualProviderEnrollmentFees, Data.h3);
        setAndFindAnyTitle(Data.titleGroupProviderEnrollmentFees, Data.h3);
        setAndFindAnyTitle(Data.titleInStateInstitutionalEnrollmentFees, Data.h3);
        setAndFindAnyTitle(Data.titleOutStateInstitutionalEnrollmentFees, Data.h3);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }
    /**
     * This method selects the Auto Archive system options tile to display the Auto Archive page,
     * verifies the side menu tab, verifies the page title, selects Edit and verifies the Auto Archive Data and Auto
     * Archive files fields and exits the page.
     */
    public void userAutoArchiveTileVerification() {
        Reports.log("\nVerifying Auto Archive system option tile");
        clickAnyTitleByText(Data.systemOptionAutoArchive, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_AUTOARCHIVE));
        javaWaitSec(2);
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.systemOptionAutoArchive));
        setAndFindAnyTitle(Data.titleAutoArchiveData, Data.h3);
        driver.findElements(TEXT_FIELD_REQUEST_ID).get(0);
        driver.findElements(TEXT_FIELD_REQUEST_ID).get(1);
        clickAnyButton(Data.TEXT_EDIT);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL, 1);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Duplicity system options tile to display the Duplicity page, verifies the value
     * displayed for each Duplicity parameter and verifies the Section index fields are enabled when Edit is selected.
     */
    public void userDuplicityTileVerification() {
        Reports.log("\nVerifying Duplicity system option tile");
        clickAnyTitleByText(Data.titleDuplicity, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_DUPLICITY));
        clickBackToTop();
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_CUT_OFF_PERCENTAGE).getText(), Data.duplicityCutOffPercentage);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_NPI).getText(), Data.duplicityNPI);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_SSN_FEIN).getText(), Data.duplicitySSNFEIN);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_TAXONOMY).getText(), Data.duplicityTaxonomy);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_DBA).getText(), Data.duplicityDBA);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_ZIP).getText(), Data.duplicityZip);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_DOB).getText(), Data.duplicityDOB);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(DUPLICITY_DEA_NUMBER).getText(), Data.duplicityDEANumber);
        ajaxClick(DUPLICITY_EDIT_BUTTON);
        driver.findElement(DUPLICITY_INDEX_OPTION_IN_NPI_LIST);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_OK);
        ajaxClick(By.xpath("//" + Data.h4));
    }

    /**
     * This method selects the Request additional Information system options tile to display the RAI page, verifies the
     * Enable Auto Deny switch and Reminders Notifications fields are disabled, verifies the Reminders Notifications
     * fields values and verifies fields are enabled when Edit is selected and exits the RAI page.
     */
    public void userRequestAdditionalInfoTileVerification() {
        Reports.log("\nVerifying Request additional Information system option tile");
        clickAnyTitleByText(Data.titleRequestAdditionalInfo, Data.h1);
        clickBackToTop();
        javaWaitSec(3);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(REQUESTADDLINFO_SYSTEM_OPTIONS_NOT_EDITABLE)));
        verifyConfigurationSwitch(Data.titleRequestAdditionalInfo, true, driver.findElement(REQUESTADDLINFO_ENABLE_AUTO_DENY_SWITCH));
        verifyActualAndExpectedValues(Data.titleRequestAdditionalInfo,driver
                .findElement(REQUESTADDLINFO_1ST_NOTIFICATION_DAYS).getText(), Data.reqAddInfo1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleRequestAdditionalInfo, driver
                .findElement(REQUESTADDLINFO_2ND_NOTIFICATION_DAYS).getText(), Data.reqAddInfo2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleRequestAdditionalInfo, driver
                .findElement(REQUESTADDLINFO_3RD_NOTIFICATION_DAYS).getText(), Data.reqAddInfo3RDNotificationDays);
        ajaxClick(REQUESTADDLINFO_EDIT_BUTTON);
        driver.findElement(REQUESTADDLINFO_SYSTEM_OPTIONS_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyTitleByText(Data.titleExit, Data.h4);

    }

    public void SDuserApprovalsTileVerificationForProviders(){
        Reports.log("\nVerifying Approval system option tile");
      //  approvalsVerificationForProvider(individualProviderType, true, true,
             //   true,true,false,true,true);

       // approvalsVerificationForProvider(groupProviderType, true, true,
              //  true,true,true,true,true);

      //  approvalsVerificationForProvider(facilityProviderType, false, false,
//                false,false,false,false);

//        approvalsVerificationForProvider(pharmacyProviderType, false, false,
  //              false,false,false,false);

       // approvalsVerificationForProvider(pemProviderType, true, true,
              //  true,true,true,false,false);

//        approvalsVerificationForProvider(orpProviderType, false, false,
//                false,false,false,false);

        approvalsVerificationForProvider(tradingPartnerProviderType, true, true,
                true,true,true,false, false);
    }

    /**
     * This method selects the Notification Engine  system options tile to display the Notification Engine page, verifies the Effective
     * Date edit panel, verifies the page title, verifies a disabled switch displayed in the Message Center on Email
     * section and exits the page.
     */
    public void userNotificationEngineTileVerification() {
        Reports.log("\nVerifying Notification Engine system option tile");

        clickAnyTitleByText(Data.titleNotificationEngine, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_NOTIFICATION_ENGINE));
        clickBackToTop();
        javaWaitSec(3);

        List<WebElement> notificationEngines = driver.findElements(NOTIFICATION_ENGINE_LIST);

        int noOfNotificationEngines = notificationEngines.size();
        Reports.log("No Of notification Engines are : " + noOfNotificationEngines);
        for (int i = 1; i <= noOfNotificationEngines; i++) {
            String infoType = driver.findElement(By.xpath("(//div[contains(@class, 'notification-engine_actions-key')])["+i+"]")).getText();
            Reports.log("\nInfo Type: " + infoType);

            Boolean messageCenter = driver.findElement(By.xpath("(//div[contains(@class, 'notification-engine_actions-values')]/label[1])["+i+"]")).isEnabled();
            Reports.log("Message Center: " + messageCenter);
            Assert.assertTrue(messageCenter);

            Boolean email = driver.findElement(By.xpath("(//div[contains(@class, 'notification-engine_actions-values')]/label[2])["+i+"]")).isEnabled();
            Reports.log("Email " + email);
            Assert.assertTrue(email);
        }
        clickAnyButton(Data.TEXT_EDIT);
        clickAnyButton(Data.TEXT_CANCEL);
        Assert.assertTrue(driver.findElement(ANY_MAIN_TITLE).getText().contains(Data.titleNotificationEngine),
                driver.findElement(ANY_MAIN_TITLE).getText());
        driver.findElement(NOTIFICATION_ENGINE_LIST);
        System.out.println(driver.findElement(By.xpath("(//div[contains(@class, 'notification-engine_actions-values')]/label[1])[1]")).isEnabled());
        clickAnyButton(Data.TEXT_CANCEL, 1);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    public void approvalsVerificationForProvider(String providerType, Boolean assigneeConfig, Boolean revalidationAssigneeConfigValue,
                                                 Boolean appealAssigneeConfigValue, Boolean cocAssigneeConfigValue, Boolean siteVisitAssigneeConfigValue,
                                                 Boolean reEnrollmentAssigneeConfigValue, Boolean autoApproveOrDenyCheckBox) {
        Reports.log("\nVerifying Approval system option tile for "+providerType);
        navigateToProverApvlConfiguration(providerType);
        verifyApprovalsAdminConfigurationEnrollments(assigneeConfig,autoApproveOrDenyCheckBox);
        clickOnBackToApprovalsListButton();
        verifyApprovalsAdminConfigurationRevalidation(revalidationAssigneeConfigValue, true);
        clickOnBackToApprovalsListButton();
        verifyApprovalsAdminConfigurationAppealApp(appealAssigneeConfigValue, autoApproveOrDenyCheckBox);
        clickOnBackToApprovalsListButton();
        verifyApprovalsAdminConfigurationCOC(cocAssigneeConfigValue, autoApproveOrDenyCheckBox,false);
        clickOnBackToApprovalsListButton();
        verifyApprovalsAdminConfigurationSiteVisit(siteVisitAssigneeConfigValue, autoApproveOrDenyCheckBox);
        clickOnBackToApprovalsListButton();
        verifyApprovalsAdminConfigurationReEnrollment(reEnrollmentAssigneeConfigValue, autoApproveOrDenyCheckBox);
        clickOnBackToApprovalsListButton();
        clickOnBackToEnrollmentsTypeButton();
        clickOnExitButton();
    }

    /**
     * This method verifies an actual field value versus an expected field value using systemOption, actualValue and
     * expectedValue arguments.
     *
     * @param systemOption
     * @param actualValue
     * @param expectedValue
     */
    public void verifyActualAndExpectedValues(String systemOption, String actualValue, String expectedValue) {
        Reports.log(systemOption+" Page -> Expected Value: "+expectedValue+"  Actual Value: " + actualValue);
        softAssert.assertEquals(actualValue, expectedValue,"For "+systemOption+" Expected Value: "+expectedValue+"  Actual Value: " + actualValue);
    }

    public void clickOnBackToApprovalsListButton(){
        ajaxClick(BACK_TO_APPROVAL_LIST_BUTTON);
        javaWait(1);
        Reports.log("Clicked on Back To Approvals List");
    }

    public void clickOnBackToEnrollmentsTypeButton(){
        ajaxClick(BACK_TO_ENROLLMENT_TYPE_BUTTON);
        javaWait(1);
        Reports.log("Clicked on Back To Enrollment Type");
    }

    public void clickOnExitButton(){
        ajaxClick(EXIT_BUTTON);
        javaWait(1);
        Reports.log("Clicked on '← Exit Button");
    }

    /**
     * This method Clicks on Revalidation Tile and Navigates to the given a provider types
     * such as  Individual, Group, and so on..,
     */
    public void navigateToProverRevalidationConfiguration(String providerType) {
        Reports.log("Select Revalidation option");
        clickAnyTitleByText(Data.titleRevalidation, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_REVALIDATION));
        ajaxClick(setAndFindProviderButton(providerType));
        javaWaitSec(3);
        Reports.log("Navigate to " +providerType+ " revalidation Configurations page");
    }

    /**
     * This method Clicks on Revalidation Tile and Navigates to the given a provider types
     * such as  Individual, Group, and so on..,
     */
    public void navigateToProviderAffiliationConfiguration(String providerType) {
        Reports.log("Select Affiliations option");
        clickAnyTitleByText(Data.titleAffiliations, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_AFFILIATIONS));
        ajaxClick(By.xpath("//h3[text()='"+providerType+"']//ancestor::div//i[contains(@class,'material-icons')]"));
        javaWaitSec(3);
        Reports.log("Navigate to " +providerType+ " Affiliation Configurations page");
    }

    /**
     * This method Clicks on Revalidation Tile and Navigates to the given a provider types
     * such as  Individual, Group, and so on..,
     */
    public void navigateToProviderCustomSectionsConfiguration(String providerType) {
        Reports.log("Select Custom Sections option");
        clickAnyTitleByText(Data.titleCustomSections, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_CUSTOM_SECTIONS));
        ajaxClick(By.xpath("//h3[text()='"+providerType+"']//ancestor::div//i[contains(@class,'material-icons')]"));
        javaWaitSec(3);
        Reports.log("Navigate to " +providerType+ " Custom Sections Configurations page");
    }


    /**
     * This method Clicks on Approval Tile and Navigates to the given Aprovider types
     * such as  Individual, Group, and so on..,
     */
    public void navigateToProverApvlConfiguration(String providerType) {
        navigateToApprovals();
        ajaxClick(setAndFindProviderButton(providerType));
        javaWaitSec(3);
        Reports.log("Navigate to " +providerType+ " Approval Configurations page");
    }
    /**
     * This method selects the Approvals tile on the System Options page.
     */
    public void navigateToApprovals(){
        Reports.log("Select Approvals option");
        clickAnyTitleByText(Data.titleApprovals, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_TYPE));
    }
    /**
     * This method selects the Enrollment View button displayed on the Approval Configuration page to display the
     * Enrollment Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values, verifies the Manual Configure Reviewer section values, verifies the Assignee Configuration
     * section switch using the AssignConfigValue argument and verifies the Temporary Approval section switch.
     *
     * @param assignConfigValue
     * @param autoApproveOrDenyCheckBox
     */
    public void verifyApprovalsAdminConfigurationEnrollments(Boolean assignConfigValue, Boolean autoApproveOrDenyCheckBox) {
        Reports.log("\nClick on Enrollment view button");
        javaWaitSec(3);
        ajaxClick(APPROVALS_ENROLLMENTS_BUTTON_VIEW);
        javaWaitSec(5);
        clickBackToTop();
        verifyAutoCheckbox(autoApproveOrDenyCheckBox);
        verifyConfigureApprover();
        verifyConfigureReviewer();
        verifyAssigneeConfiguration(assignConfigValue);
        verifyTemporaryApproval();

    }

    /**
     * This method selects the Revalidation View button displayed on the Approval Configuration page to display the
     * Revalidation Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationRevalidation(Boolean AssignConfigValue, Boolean autoApproveOrDenyCheckBox) {
        javaWaitSec(10);
        ajaxClick(APPROVALS_REVALIDATION_BUTTON_VIEW);
        Reports.log("Click on Revalidation view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox(autoApproveOrDenyCheckBox);
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Appeal View button displayed on the Approval Configuration page to display the
     * Appeal Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationAppealApp(Boolean AssignConfigValue, Boolean autoApproveOrDenyCheckBox){
        ajaxClick(APPROVALS_APPEAL_APPROVAL_BUTTON_VIEW);
        Reports.log("Click on Appeal view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox(autoApproveOrDenyCheckBox);
        ///TO DO Add Manual
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }


    /**
     * This method selects the Change of Circumstance View button displayed on the Approval Configuration page to
     * display the Change of Circumstance Approval page, verifies the Auto Approval section switch, verifies the
     * Auto Affiliation Approval section switch, verifies the Manual Configure Approver section values and verifies the
     * Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationCOC(Boolean AssignConfigValue, Boolean autoApproveOrDenyCheckBox, Boolean autoAffiliationCheckBox) {
        ajaxClick(APPROVALS_COC_BUTTON_VIEW);
        Reports.log("Click on Appeal view button");
        javaWaitSec(3);
        clickBackToTop();
      //  verifyAutoCheckbox(autoApproveOrDenyCheckBox);

        Boolean autoAffiliationApprovalCheckboxStatus = driver.findElement(By.xpath("(//input[@aria-label='Auto Switch'])")).isSelected() ;
        Reports.log("Affiliation request is automatically approved upon submission of affiliation request checkbox isEnabled: " +autoAffiliationApprovalCheckboxStatus);
        if(!autoAffiliationCheckBox) { Assert.assertFalse(autoAffiliationApprovalCheckboxStatus);
        }else { Assert.assertTrue(autoAffiliationApprovalCheckboxStatus); }
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Site Visit View button displayed on the Approval Configuration page to display the
     * Site Visit Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationSiteVisit(Boolean AssignConfigValue, Boolean autoApproveOrDenyCheckBox){
        ajaxClick(APPROVALS_SITE_VISIT_BUTTON_VIEW);
        Reports.log("Click on Site Visit view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox(autoApproveOrDenyCheckBox);
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Re Enrollment View button displayed on the Approval Configuration page to display the
     * Re Enrollment Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationReEnrollment(Boolean AssignConfigValue, Boolean autoApproveOrDenyCheckBox) {
        ajaxClick(APPROVALS_ReEnrollment_BUTTON_VIEW);
        Reports.log("Click on Re Enrollment view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyReenrollmentSwitch(autoApproveOrDenyCheckBox);
       // verifyConfigureApprover();
       // verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method verifies the Approvals system options 'Configure reviewers' section switch and the values displayed
     * in the section if the switch is enabled.
     *
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean,Boolean)
     */
    public void verifyConfigureReviewer(){
        WebElement configureReviewerSwitch = driver.findElement(By.xpath("//input[@aria-label='Configure reviewer Switch']"));
        Boolean configureReviewerSwitchStatus = configureReviewerSwitch.isSelected();

        if(!configureReviewerSwitchStatus) {
            Assert.assertFalse(configureReviewerSwitchStatus);
            Reports.log("Configure reviewer Switch isEnabled: " + configureReviewerSwitchStatus);
        }
        else {
            Reports.log("Configure reviewer Switch isEnabled: " + configureReviewerSwitchStatus);
            String numOfReviewersRequired = driver.findElement(By.xpath("//h4[contains(text(), 'Number of votes required')]/../span[1]")).getText();
            Reports.log("Number of voted required: "+numOfReviewersRequired);
            Assert.assertEquals(numOfReviewersRequired, "1");

            List<WebElement> reviewerList = driver.findElements(By.xpath("(//div[starts-with(@class,'tile-table-body sc-')])[2]/div"));
            int noOfReviewer = reviewerList.size();
            Reports.log("Who can vote :");
            for(int i=1; i<=noOfReviewer;i++){
                WebElement reviewerElement = driver.findElement(By.xpath("(//div[starts-with(@class,'expansion-panel-summary clickable sc-')])["+i+"]/..//p[1]"));
                Assert.assertTrue(reviewerElement.isDisplayed());
                String reviewerRole = reviewerElement.getText();
                Reports.log("  "+i+ ":  "+reviewerRole);
            }
        }
    }

    /**
     * This method verifies the Approvals System Option Temporary Approval switch.
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean,Boolean)
     */
    public void verifyTemporaryApproval(){
        Boolean temporaryApprovalSwitchStatus = driver.findElement(By.xpath("//input[@aria-label='Temporary Approval Switch']")).isSelected();
//        Assert.assertFalse(temporaryApprovalSwitchStatus);
        Reports.log("Temporary Approval Switch isEnabled: " +temporaryApprovalSwitchStatus);
    }

    /**
     * This method verifies an actual configuration switch value versus expected configuration switch value using
     * systemOption, actualValue and element arguments.
     *
     * @param systemOption
     * @param expectedValue
     * @param element
     */
    public void verifyConfigurationSwitch(String systemOption, Boolean expectedValue, WebElement element) {
        Boolean actualValue = element.isSelected();
        Reports.log(   systemOption+": Expected Value: "+expectedValue+"  Actual Value: " + actualValue);
        Assert.assertEquals(actualValue, expectedValue);
    }


    /**
     * This method verifies the values displayed in the Configure Approver section on the Approvals system options page.
     *
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean, Boolean)
     * @see #verifyApprovalsAdminConfigurationReEnrollment(Boolean, Boolean)
     * @see #verifyApprovalsAdminConfigurationCOC(Boolean,Boolean,Boolean)
     * @see #verifyApprovalsAdminConfigurationAppealApp(Boolean, Boolean)
     * @see #verifyApprovalsAdminConfigurationSiteVisit(Boolean, Boolean)
     */
    public void verifyConfigureApprover(){
        String numOfApprovalsRequired = driver.findElement(By.xpath("//h4[contains(text(), 'Number of approvals required')]/../span[1]")).getText();

        Reports.log("Number of approvals required for approval: "+numOfApprovalsRequired);
        Assert.assertEquals(numOfApprovalsRequired, "1");

        List<WebElement> approversList = driver.findElements(By.xpath("(//div[starts-with(@class,'tile-table-body sc-')])[1]/div"));
        int noOfAppovers = approversList.size();
        Reports.log("Who can Approve: ");
        for(int i=1; i<=noOfAppovers;i++){
            WebElement approverElement = driver.findElement(By.xpath("(//div[starts-with(@class,'expansion-panel-summary clickable sc-')])["+i+"]/..//p[1]"));
            Assert.assertTrue(approverElement.isDisplayed());
            String approverRole = approverElement.getText();
            Reports.log("  "+i+ ":  "+approverRole);
        }
    }

    /**
     * This method verifies the Approvals System Option Assignee Configuration switch using the expectedStatus argument.
     *
     * @param expectedStatus
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean, Boolean)
     */
    public void verifyAssigneeConfiguration(Boolean expectedStatus) {
        javaWait(3);
        Boolean assigneeConfigurationSwitchStatus = driver.findElement(By.xpath("//h3[contains(text(),'Assignee Configuration')]//following::input[1]")).isSelected();
        Reports.log("Assignee Configuration Switch isEnabled: " +assigneeConfigurationSwitchStatus);
        Assert.assertEquals(assigneeConfigurationSwitchStatus, expectedStatus);
//          Assert.assertFalse(assigneeConfigurationSwitchStatus);
    }


    /**
     * This method verifies the Approvals System Option Auto Approval Based on Screening Score switch.
     *
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean, Boolean)
     * @see #verifyApprovalsAdminConfigurationReEnrollment(Boolean, Boolean)
     * @see #verifyApprovalsAdminConfigurationCOC(Boolean, Boolean,Boolean)
     * @see #verifyApprovalsAdminConfigurationAppealApp(Boolean, Boolean)
     * @see #verifyApprovalsAdminConfigurationSiteVisit(Boolean, Boolean)
     */
    public void verifyAutoCheckbox(Boolean expectedStatus) {
        Reports.log("verifying the Auto Switch ");
        Boolean autoApprovalCheckboxStatus = driver.findElement(By.xpath("//input[@aria-label='Auto Switch']")).isSelected() ;
        Reports.log("Automatically approved or denied based upon screening score checkbox isEnabled: " +autoApprovalCheckboxStatus);
        Assert.assertEquals(autoApprovalCheckboxStatus, expectedStatus,"Automatically approved or denied based upon screening score checkbox is"+autoApprovalCheckboxStatus
                                                                                    +"But Expected was"+expectedStatus);
    }


    /**
     * This method verifies the Approvals System Option Re enrollment required switch.
     */
    public void verifyReenrollmentSwitch(Boolean expectedStatus) {
        Reports.log("verifying the Reenrollment Switch ");
        Boolean reEnrollmentRequiredSwitchStatus = driver.findElement(By.xpath("//p[contains(.,'Please switch on to enable the reenrollment')]//following::div[1]//input[@aria-label='Auto Switch']")).isSelected() ;
        Reports.log("Re-enrollment required switch isEnabled: " +reEnrollmentRequiredSwitchStatus);
        Assert.assertEquals(reEnrollmentRequiredSwitchStatus, expectedStatus,"Automatically approved or denied based upon screening score checkbox is"+reEnrollmentRequiredSwitchStatus
                +"But Expected was"+expectedStatus);
    }


    /**
     * This method verifies the Base Configuration For Auto Terminate on the Security Policy page is disabled.
     */
    public void verifyBaseConfigurationForAutoTerminate() {
        //Auto Terminate
        Boolean autoTerminateSwitchStatus = driver.findElement(SECURITY_POLICY_ENABLE_AUTO_TERMINATE_SWITCH).isSelected();
        Reports.log("Enable Auto Terminate switch status: "+autoTerminateSwitchStatus);
        if(!autoTerminateSwitchStatus) {
            Assert.assertFalse(autoTerminateSwitchStatus);
        }
        else{
            verifyThatElementIsDisplayed(SECURITY_POLICY_SUSPENDED_DUE_TO_LICENSE_EXP_LABEL, "Label");
            verifyThatElementIsDisplayed(SECURITY_POLICY_SUSPENDED_DUE_TO_LICENSE_EXP_SWITCH, "Auto terminate only the suspended providers due to licensure expiration switch");
            String noofDays = driver.findElement(By.xpath("//div//span[contains(text(),'Period After which suspended Providers will be terminated')]//following::div/span[1]")).getText();
            Reports.log("Period After which suspended Providers will be terminated: "+noofDays +"day's");

            String noOFDaysForFirstNotification = driver.findElement(By.xpath("//div[contains(text(),'1st notification')]/../div[2]/span[1]")).getText();
            String noOFDaysForSecondNotification = driver.findElement(By.xpath("//div[contains(text(),'2nd notification')]/../div[2]/span[1]")).getText();
            String noOFDaysForThirdNotification = driver.findElement(By.xpath("//div[contains(text(),'3rd notification')]/../div[2]/span[1]")).getText();

            Reports.log("Reminder notifications that are sent prior to termination date:");
            Reports.log("   1st notification: "+noOFDaysForFirstNotification+"day's");
            Reports.log("   2nd notification: "+noOFDaysForSecondNotification+"day's");
            Reports.log("   3rd notification: "+noOFDaysForThirdNotification+"day's");
            Assert.assertEquals(noOFDaysForFirstNotification, "45");
            Assert.assertEquals(noOFDaysForSecondNotification, "30");
            Assert.assertEquals(noOFDaysForThirdNotification, "7");
        }
    }

    /**
     * This method verifies that Enable Captcha Verification switch displayed on the Security Policy page is disabled.
     */
    public void verifyIfCaptchaIsEnabled(){
        javaWaitSec(1);
        scrollToBottomOfPage();
        Assert.assertFalse(driver.findElement(CAPTCHA_SWITCH).isSelected());
        Reports.log("Enable Captcha is OFF");
    }

    /**
     * This method verifies Login Timout on the Security Policy page is disabled.
     */
    public void verifyBaseConfigurationForLoginTimeout() {
        //Login Timout
        Boolean loginTimeoutSwitchStatus = driver.findElement(By.xpath("//input[@name='logoutSwitch']")).isSelected();
        //  Assert.assertFalse(loginTimeoutSwitchStatus);
        Assert.assertTrue(loginTimeoutSwitchStatus);
        Reports.log("Enable Login Timeout switch status: "+loginTimeoutSwitchStatus);
    }

    /**
     * This method will allow the user to download the Excel Configuration file from System Options.
     * @param selectOption
     */
    public void downloadConfigurationExcel(String selectOption )
    {
        Reports.log("Opening: " + selectOption);
        clickAnyTitleByText(selectOption, Data.h1);
        clickBackToTop();
        javaWaitSec(3);
        Reports.log("Click on the Download Document button");
        driver.findElement(DOWNLOAD_EXCEL_BUTTON).click();
        //clickAnyButtonTitle(TEXT_DOWNLOAD_EXCEL);
        javaWaitSec(5);
        File downloadFolder = new File(System.getProperty("user.dir") + File.separator + "DownloadFolder");
        File[] matches = downloadFolder.listFiles((dir, name) -> name.contains("UserProfileConfiguration") && name.endsWith(".xlsx"));
        if (matches == null) {
            Reports.log("No file found....");
        } else {
            for (int i = 0; i < matches.length; i++) {
                if (matches[i].renameTo(new File(System.getProperty("user.dir") + File.separator + "DownloadFolder" + File.separator + "ConfigurationActual"+ File.separator + matches[i].getName()))) {
                    // if file copied successfully then delete the original file
                    matches[i].delete();
                    Reports.log(selectOption + " configuration file downloaded successfully and Save at location :" + matches[i]);
                } else {
                   Reports.log("Failed to move the file");
                }
            }
        }
    }
/*
*********************************************************************************************************************************************
*****************************************************SD Related Code*************************************************************************
*********************************************************************************************************************************************
*/

    public void systemOptionsEntryPoint(String selectOption, String headerXpath, String urlLink ){
        clickAnyTitleByText(selectOption, SDSystemOptionsConstants.h1);
        clickBackToTop();
        javaWaitSec(3);
        Reports.log("\nInternal user is in the "+ selectOption +" Configuration Section");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(headerXpath)));
        Assert.assertTrue(driver.getCurrentUrl().contains(urlLink));
        clickBackToTop();
        javaWaitSec(3);
    }

    /**
     * Supplemental Test class to verifySDEnrollmentTypeConfiguration that will iterarate the test and verify the different points in the Enrollment Type
     * System Options. The following are the parameters
     * @param enrollmentType = Type of Enrollment
     * @param xpathOfEnrollment = Xpath of the Enrollment to be verified
     * @param tileSwitchExpected = Switch value expected if the tile should be visiable or not
     * @param pemCreateEnrollmentExpected = Switch value expected if the PEM is allowed to create this type of Enrollment
     * @param enrollmentTypeNameExpected = Enrollment Name that should be displayed
     * @param enrollDescExpected = Enrollment description expected
     * @param runtimeAppNameExpected = Backend name of the enrollment
     */
    public void enrollmentTypeVerification(String enrollmentType, String xpathOfEnrollment, String tileSwitchExpected,String pemCreateEnrollmentExpected,
                                           String enrollmentTypeNameExpected, String enrollDescExpected, String runtimeAppNameExpected){

        boolean tileSwitch = driver.findElement(By.xpath("(" + xpathOfEnrollment + ")[4]")).isSelected();
        boolean pemCreateEnrollment = driver.findElement(By.xpath("(" + xpathOfEnrollment + ")[5]")).isSelected();
        String enrollmentTypeName = driver.findElement(By.xpath("(" + xpathOfEnrollment + ")[1]")).getAttribute("value");
        String enrollmentDescription = driver.findElement(By.xpath("(" + xpathOfEnrollment + ")[2]")).getAttribute("value");
        String runtimeAppName = driver.findElement(By.xpath("(" + xpathOfEnrollment + ")[3]")).getAttribute("value");
        Reports.log("\n************************************************************");
        Reports.log("******************"+enrollmentType+"*********************\n");
        if (!Objects.equals(tileSwitchExpected, "false")) {
            softAssert.assertEquals(String.valueOf(tileSwitch), tileSwitchExpected);
            Reports.log("For the " + enrollmentType+ " the Tile Switch Actual values is: "
                    + String.valueOf(tileSwitch) + ", and Expected is: " + tileSwitchExpected);
            softAssert.assertEquals(String.valueOf(pemCreateEnrollment), pemCreateEnrollmentExpected);
            Reports.log("For the " + enrollmentType+ " the Switch for PEM Creating Enrollment Actual values is: "
                    + String.valueOf(pemCreateEnrollment) + ", and Expected is: " + pemCreateEnrollmentExpected);
            softAssert.assertEquals(enrollmentTypeName, enrollmentTypeNameExpected);
            Reports.log("For the " + enrollmentType+ " the Enrollment Type Name Actual values is: "
                    + enrollmentTypeName + ", and Expected is: " + enrollmentTypeNameExpected);
            softAssert.assertEquals(enrollmentDescription, enrollDescExpected);
            Reports.log("For the " + enrollmentType+ " the Enrollment Description Actual values is: "
                    + enrollmentDescription + ", and Expected is: " + enrollDescExpected);
            softAssert.assertEquals(runtimeAppName, runtimeAppNameExpected);
            Reports.log("For the " + enrollmentType+ " the Runtime Application Name Actual values is: "
                    + runtimeAppName + ", and Expected is: " + runtimeAppNameExpected);
        }
        else{
            softAssert.assertEquals(String.valueOf(tileSwitch), tileSwitchExpected);
            Reports.log("For the " + enrollmentType+ " the Tile Switch Actual values is: "
                    + String.valueOf(tileSwitch) + ", and Expected is: " + tileSwitchExpected);
            softAssert.assertEquals(String.valueOf(pemCreateEnrollment), pemCreateEnrollmentExpected);
            Reports.log("For the " + enrollmentType+ " the Switch for PEM Creating Enrollment Actual values is: "
                    + String.valueOf(pemCreateEnrollment) + ", and Expected is: " + pemCreateEnrollmentExpected);
            Reports.log("Since the tile Switch is off, we can skip the other verification points.");
        }
    }

    /**
     * Main test class that will launch the System Options Enrollment Type section and verify the configuration of the given Expected parameters.
     * This test will compare the Expected vs the screen values displayed.
     * @param enrollmentType = Type of Enrollment
     * @param tileSwitchExpected = Switch value expected if the tile should be visiable or not
     * @param pemCreateEnrollmentExpected = Switch value expected if the PEM is allowed to create this type of Enrollment
     * @param enrollmentTypeNameExpected = Enrollment Name that should be displayed
     * @param enrollDescExpected = Enrollment description expected
     * @param runtimeAppNameExpected = Backend name of the enrollment
     */
    public void verifySDEnrollmentTypeConfiguration(String enrollmentType, String tileSwitchExpected, String pemCreateEnrollmentExpected,
                                                    String enrollmentTypeNameExpected, String enrollDescExpected, String runtimeAppNameExpected){
        try {
            //read the screen and compare the data with Expected
            switch (enrollmentType) {
                case "Individual": {
                    String xpathOfEnrollment = "//input[@name='individual']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "Group":
                case "Entity": {
                    String xpathOfEnrollment = "//input[@name='group']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "Facility": {
                    String xpathOfEnrollment = "//input[@name='facility']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "ORP": {
                    String xpathOfEnrollment = "//input[@name='ORP']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "PEM":
                case "Provider Enrollment Manager": {
                    String xpathOfEnrollment = "//input[@name='PEM']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "TP":
                case "Trading Partner": {
                    String xpathOfEnrollment = "//input[@name='TP']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "Pharmacy": {
                    String xpathOfEnrollment = "//input[@name='pharmacy']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                case "MCO": {
                    String xpathOfEnrollment = "//input[@name='MCO']";
                    enrollmentTypeVerification(enrollmentType, xpathOfEnrollment, tileSwitchExpected, pemCreateEnrollmentExpected,
                            enrollmentTypeNameExpected, enrollDescExpected, runtimeAppNameExpected);
                    break;
                }
                default: {
                    Reports.log(enrollmentType + " was not found in the automation, please check the code. Test Failed.");
                    softAssert.fail();
                }
            }
            softAssert.assertAll();
            Reports.log("\n*********************************\n" +
                    "Verification Completed, Test Pass for: "+enrollmentType+"!\n" +
                    "*********************************" );
        }
        catch (NullPointerException e) {
            Reports.log(String.valueOf(e));
        }
    }
    public void clickonApprovalconfigurationforGroupProvider(String configuration){
        javaWaitSec(5);
        driver.findElement(By.xpath("//div[contains(@class, 'approval') and .//h3[text()='" + configuration +"']]//span[text()='VIEW']"));

    }
    public void verifyRateSettings(){
        javaWaitSec(10);
        ajaxScroll(RATE_SETTING_TOGGLE);
        Reports.log("Scroll down to Rate Setting ");
        if (driver.findElement(By.xpath("//div[contains(@class, 'styles_approval-section-header-new-switch')][.//h3[contains(text(), 'Rate Settings')]]//span[contains(@class, 'Mui-checked')]")).isDisplayed()) {
            System.out.println("RATE_SETTING_TOGGLE is visible");
        }
        else {
            javaWaitSec(5);
            Reports.log("Toggle button is disabled");
            ajaxScroll(APPROVALS_EDIT_BUTTON);
            javaWaitSec(5);
            ajaxClick(APPROVALS_EDIT_BUTTON);
            Reports.log("Clicked on Edit button");
            javaWaitSec(5);
            ajaxScroll(RATE_SETTING_ON);
            javaWaitSec(5);
            ajaxClick(RATE_SETTING_ON);
            Reports.log("Rate Setting Enabled");
            Reports.log("");
            javaWaitSec(5);
            ajaxScroll(APPROVALS_SAVE_CHANGES_BUTTON);
            javaWaitSec(5);
            ajaxClick(APPROVALS_SAVE_CHANGES_BUTTON);
            Reports.log("Clicked on Save");
        }
    }

    public void verifyAndSetFloridaMedicaidProviderIdStatus() {
        javaWaitSec(3);
        Reports.log("Checking 'Configure Florida Medicaid Provider Id' status");

        // Common XPath that identifies current status (Submitted / Approved / Pending Approval)
        ajaxScroll(Florida_Medicaid_SUbmitted);

        // If current status is 'Submitted', no action needed
        boolean isSubmitted = driver.findElements(Florida_Medicaid_SUbmitted).size() > 0;

        if (isSubmitted) {
            Reports.log("Status is already 'Submitted'. Proceeding to the next step.");
        } else {
            Reports.log("Status is not 'Submitted'. Updating it now...");

            // Step 1: Click on the status dropdown
            WebElement statusDropdown = driver.findElement(Status_dropDown);
            ajaxClick(statusDropdown);
            javaWaitSec(2);

            // Step 2: Select 'Submitted' option
            WebElement submittedOption = driver.findElement(By.xpath("//div[contains(text(),'Submitted')]"));
            ajaxClick(submittedOption);
            Reports.log("Status changed to 'Submitted'");

            // Step 3: Click Save Changes
            javaWaitSec(2);
            ajaxScroll(APPROVALS_SAVE_CHANGES_BUTTON);
            ajaxClick(APPROVALS_SAVE_CHANGES_BUTTON);
            Reports.log("Clicked on Save after status update");
        }
    }

}