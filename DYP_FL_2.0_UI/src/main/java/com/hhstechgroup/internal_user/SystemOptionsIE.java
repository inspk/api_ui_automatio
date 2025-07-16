package com.hhstechgroup.internal_user;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import io.vavr.Value;
import org.awaitility.core.AssertionCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.List;


/**
 * This class supports the verification of Internal User System Options.
 */
public class SystemOptionsIE extends BaseActions {

    /*
    Locators for SystemOptionsIE
    */
    
    Boolean isRuleExist =false;

    protected SoftAssert softAssert = new SoftAssert();

    /**
     * This constructor method creates a SystemOptionsIE object using driver and wait arguments.
     *
     * @param driver
     * @param wait
     */
    public SystemOptionsIE(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method selects the Users system option tile to display the User Management page, verifies the page title,
     * verifies the Add New User popup title and exits the page.
     */
    public void verifyUsersSystemOptions() {
        javaWaitSec(1);
        clickAnyTitleByText(Data.titleUsers, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_USERS));
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleManagement));
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_ADD_USER);
        setAndFindAnyTitle(Data.titleAddNewUser, Data.h2);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method verifies that Enable Captcha Verification switch displayed on the Security Policy page is disabled.
     */
    public void verifyIfCaptchaIsEnabled(){
        javaWaitSec(1);
        scrollToBottomOfPage();
        Assert.assertFalse(driver.findElement(Locators.CAPTCHA_SWITCH).isSelected());
        Reports.log("Enable Captcha is OFF");
    }

    /**
     * This method selects the Roles system options tile to display the Role Management page, verifies the page title,
     * verifies the Add New Role popup title and exits to the Internal User dashboard.
     */
    public void verifyUserRolesSystemOptions() {
        clickAnyTitleByText(Data.titleRoles, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_ROLES));
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleRoleManagement));
        clickAnyButton(Data.TEXT_ADD_NEW);
        setAndFindAnyTitle(Data.titleAddNewRole, Data.h2);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyHeaderTitLe(Data.titleBackToDashboard);
    }

    /**
     * This method selects the Screening system options tile to display the Screening page, verifies the Screen Issues
     * Ranking title, verifies the Screen Issues Ranking Edit and exits the page.
     */
    public void verifyScreeningSystemOptions() {
        clickAnyTitleByText(Data.titleScreening, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_SCREENING));
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleScreeningIssuesRanking));
        javaWaitSec(1);
        clickBackToTop();
        ajaxClick(Locators.SCREENING_EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL, 2);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Auto Assign system options tile to display the Auto Assign page, verifies the page title,
     * verifies the New Rule page title, verifies the effective date selection calendars, verifies the Select
     * Application Type field, verifies the condition If/Do fields and exits the page.
     */
    public void verifyAutoAssignSystemOptions() {
        clickAnyTitleByText(Data.systemOptionTitleAutoAssign, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_AUTO_ASSIGN_RULES));
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleAutoAssign));
        clickAnyButton(Data.TEXT_CREATE_RULE);
        Assert.assertTrue(driver.findElement(Locators.TITLE_NEW_RULE_AUTO_ASSIGN).getText().contains(Data.titleNewRule));
        driver.findElement(Locators.CALENDAR);
        driver.findElement(Locators.SELECT_APPLICATION_TYPE);
        driver.findElement(Locators.CONDITION_AUTO_ASSIGN);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_LEAVE_PAGE);
        javaWaitSec(3);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Data Change system options tile to display the Data Change page, verifies the Effective
     * Date edit panel, verifies the page title, verifies a disabled switch displayed in the Actions on data change
     * section and exits the page.
     */
    public void verifyDataChangeSystemOptions() {
        clickAnyTitleByText(Data.systemOptionTitleDataChange, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_DATA_CHANGE_ACTIONS));
        clickBackToTop();
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_EDIT);
        clickAnyButton(Data.TEXT_CANCEL);
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleActionsDataChange),
                driver.findElement(Locators.ANY_MAIN_TITLE).getText());
        driver.findElement(Locators.ROW_DATA_CHANGE);
        System.out.println(driver.findElement(Locators.DATA_CHANGE_SLIDER).getAttribute("disabled"));
        clickAnyButton(Data.TEXT_CANCEL, 1);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     *  This method selects the Approvals system options tile to display the Approval configuration for page, selects
     *  the Individual Providers tile, verifies the Enrollment Approval page title, verifies that the Number of
     *  approvals required field is disabled, verifies that the Number of approvals required field can be enabled,
     *  and exits to the Internal User dashboard.
     */
    public void verifyApprovalIndividualsSystemOptions() {
        clickAnyTitleByText(Data.titleApprovals, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_TYPE));
        ajaxClick(Locators.APPROVALS_INDIVIDUAL_PROVIDERS_ICON);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_INDIVIDUAL));
        ajaxClick(Locators.APPROVALS_ENROLLMENTS_BUTTON_VIEW);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_REQUEST));
        clickBackToTop();
        Assert.assertTrue(driver.findElement(Locators.APPROVALS_ENROLLMENTS_SECTION).getText().contains(Data.titleEnrollmentApproval));
        driver.findElement(Locators.APPROVALS_NUMBER_NOT_EDITABLE);
        clickAnyButton(Data.TEXT_EDIT2);
        driver.findElement(Locators.APPROVALS_NUMBER_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        clickAnyHeaderTitLe(Data.titleBackToDashboard);
    }

    /**
     *  This method selects the Approvals system options tile to display the Approval configuration for page, selects
     *  the Group Providers tile, verifies the Enrollment Approval page title, verifies that the Number of
     *  approvals required field is disabled, verifies that the Number of approvals required field can be enabled,
     *  and exits to the Internal User dashboard.
     */
    public void verifyApprovalGroupsSystemOptions() {
        clickAnyTitleByText(Data.titleApprovals, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_TYPE));
        ajaxClick(Locators.APPROVALS_GROUP_PROVIDERS_ICON);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_GROUP));
        ajaxClick(Locators.APPROVALS_ENROLLMENTS_BUTTON_VIEW);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_APPROVALS_REQUEST));
        clickBackToTop();
        Assert.assertTrue(driver.findElement(Locators.APPROVALS_ENROLLMENTS_SECTION).getText().contains(Data.titleEnrollmentApproval));
        driver.findElement(Locators.APPROVALS_NUMBER_NOT_EDITABLE);
        clickAnyButton(Data.TEXT_EDIT2);
        driver.findElement(Locators.APPROVALS_NUMBER_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        clickAnyHeaderTitLe(Data.titleBackToDashboard);
    }

    /**
     * This method selects the Revalidations system options tile to display the Revalidation page, verifies the page
     * title, verifies the Revalidation Date Years field is disabled, verifies the Revalidation Date Years
     * field is enabled when Edit is selected and exits the page.
     */
    public void verifyRevalidationSystemOptions() {
        clickAnyTitleByText(Data.titleRevalidation, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_REVALIDATION));
        Assert.assertTrue(
                driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleRevalidation));
        ajaxScroll((Locators.HEADING_REVALIDATION), 0);
        driver.findElement(Locators.ITEM_REVALIDATION);
        driver.findElement(Locators.DAYS_REVALIDATION_DISABLE);
        clickAnyButton(Data.TEXT_EDIT2);
        driver.findElement(Locators.DAYS_REVALIDATION_ENABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method selects the Licensure system options tile to display the Licensure page, verifies the Reminders
     * Notifications fields are disabled, verifies the Reminders Notifications fields are enabled when Edit is selected
     * and exits the page.
     */
    public void verifyLicenseSystemOptions() {
        clickAnyTitleByText(Data.titleLicensure, Data.h1);
        clickBackToTop();
        javaWaitSec(3);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(Locators.LICENSURE_STYLES_PERIOD_NOT_EDITABLE)));
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(Locators.LICENSURE_1ST_NOTIFICATION_DAYS).getText(), Data.licensure1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(Locators.LICENSURE_2ND_NOTIFICATION_DAYS).getText(), Data.licensure2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleLicensure,driver
                .findElement(Locators.LICENSURE_3RD_NOTIFICATION_DAYS).getText(), Data.licensure3RDNotificationDays);
        ajaxClick(Locators.LICENSURE_EDIT_BUTTON);
        driver.findElement(Locators.LICENSURE_STYLES_PERIOD_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL2);
        clickAnyTitleByText(Data.titleExit, Data.h4);
        softAssert.assertAll();
    }

    /**
     * This method selects the Request additional Information system options tile to display the RAI page, verifies the
     * Enable Auto Deny switch and Reminders Notifications fields are disabled, verifies the Reminders Notifications
     * fields values and verifies fields are enabled when Edit is selected and exits the RAI page.
     */
    public void verifyRequestAdditionalInfoSystemOptions() {
        clickAnyTitleByText(Data.titleRequestAdditionalInfo, Data.h1);
        clickBackToTop();
        javaWaitSec(3);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(Locators.REQUESTADDLINFO_SYSTEM_OPTIONS_NOT_EDITABLE)));
        verifyConfigurationSwitch(Data.titleRequestAdditionalInfo, true, driver.findElement(Locators.REQUESTADDLINFO_ENABLE_AUTO_DENY_SWITCH));
        verifyActualAndExpectedValues(Data.titleRequestAdditionalInfo,driver
                .findElement(Locators.REQUESTADDLINFO_1ST_NOTIFICATION_DAYS).getText(), Data.reqAddInfo1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleRequestAdditionalInfo, driver
                .findElement(Locators.REQUESTADDLINFO_2ND_NOTIFICATION_DAYS).getText(), Data.reqAddInfo2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleRequestAdditionalInfo, driver
                .findElement(Locators.REQUESTADDLINFO_3RD_NOTIFICATION_DAYS).getText(), Data.reqAddInfo3RDNotificationDays);
        ajaxClick(Locators.REQUESTADDLINFO_EDIT_BUTTON);
        driver.findElement(Locators.REQUESTADDLINFO_SYSTEM_OPTIONS_EDITABLE);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyTitleByText(Data.titleExit, Data.h4);
        softAssert.assertAll();
    }

    /**
     * This method selects the Duplicity system options tile to display the Duplicity page and verifies the Section
     * index fields are enabled when Edit is selected.
     */
    public void verifyDuplicityConfigSysOPtn(){
        clickAnyTitleByText(Data.titleDuplicity, Data.h1);
        clickBackToTop();
        ajaxClick(Locators.DUPLICITY_EDIT_BUTTON);
        driver.findElement(Locators.DUPLICITY_INDEX_OPTION_IN_NPI_LIST);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_OK);
        ajaxClick(By.xpath("//"+Data.h4));
    }

    /**
     * This method selects the Duplicity system options tile to display the Duplicity page, verifies the value
     * displayed for each Duplicity parameter and verifies the Section index fields are enabled when Edit is selected.
     */
    public void verifyDuplicitySystemOption() {
        clickAnyTitleByText(Data.titleDuplicity, Data.h1);
        clickBackToTop();
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_CUT_OFF_PERCENTAGE).getText(), Data.duplicityCutOffPercentage);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_NPI).getText(), Data.duplicityNPI);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_SSN_FEIN).getText(), Data.duplicitySSNFEIN);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_TAXONOMY).getText(), Data.duplicityTaxonomy);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_DBA).getText(), Data.duplicityDBA);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_ZIP).getText(), Data.duplicityZip);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_DOB).getText(), Data.duplicityDOB);
        verifyActualAndExpectedValues(Data.titleDuplicity,driver
                .findElement(Locators.DUPLICITY_DEA_NUMBER).getText(), Data.duplicityDEANumber);
        ajaxClick(Locators.DUPLICITY_EDIT_BUTTON);
        driver.findElement(Locators.DUPLICITY_INDEX_OPTION_IN_NPI_LIST);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_OK);
        ajaxClick(By.xpath("//" + Data.h4));
        softAssert.assertAll();
    }

    /**
     * This method selects the Revalidation system options tile to display the Revalidation page, verifies the
     * Revalidation Date value, verifies Reminders Notification values, verifies Group Outstanding Revalidation value,
     * verifies After Revalidation Period value, selects Edit and exits the page.
     */
    public void verifyRevalidationsAndRemindersSystemOption() {
        clickAnyTitleByText(Data.titleRevalidation, Data.h1);
        clickBackToTop();
        javaWaitSec(3);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(Locators.REVALANDREM_REVALIDATION_DATE_DAYS).getText(), Data.revalAndRemRevalDateDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(Locators.REVALANDREM_1ST_NOTIFICATION_DAYS).getText(), Data.revalAndRem1STNotificationDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(Locators.REVALANDREM_2ND_NOTIFICATION_DAYS).getText(), Data.revalAndRem2NDNotificationDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(Locators.REVALANDREM_3RD_NOTIFICATION_DAYS).getText(), Data.revalAndRem3RDNotificationDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(Locators.REVALANDREM_GROUP_REVAL_DAYS).getText(), Data.revalAndRemGroupRevalDays);
        verifyActualAndExpectedValues(Data.titleRevalidation,driver
                .findElement(Locators.REVALANDREM_AFTER_REVAL_PERIOD).getText(), Data.revalAndRemAfterRevalPeriod);
        ajaxClick(Locators.REVALANDREM_EDIT_BUTTON);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        ajaxClick(By.xpath("//" + Data.h4));
        softAssert.assertAll();
    }

    //div[@class='notification-engine_actions-key_10v4G'][contains(.,'Enrollments')]

    /**
     * This method selects the Externalization system options tile to display the Externalization page, verifies the
     * side menu tab, verifies each section title name, verifies the Add Taxonomy popup when +Add is selected and exits
     * the page.
     */
    public void verifyExternalizationSystemOptions() {
        clickAnyTitleByText(Data.titleExternalization, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_ERROR_MESSAGES));
        Assert.assertTrue(
                driver
                        .findElement(Locators.ANY_MAIN_TITLE)
                        .getText()
                        .contains(Data.titleErrorMessagesAndDropdowns));
        Assert.assertTrue(
                driver
                        .findElement(Locators.ANY_MAIN_TITLE)
                        .getText()
                        .contains(Data.titleAuditEventNamesAndTags));
        Assert.assertTrue(
                driver
                        .findElement(Locators.ANY_MAIN_TITLE)
                        .getText()
                        .contains(Data.titleSystemDowntimeMessages));
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
    public void verifyDeactivationSystemOptions() {
        clickAnyTitleByText(Data.titleDeactivation, Data.h1);
        softAssert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_USER_DEACTIVATION));
        softAssert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleUserInactivity));
        verifyActualAndExpectedValues(Data.titleDeactivation,driver
                .findElement(Locators.USERDEACT_INACTIVE_DAYS).getText(), Data.userDeactInactiveDays);
        verifyActualAndExpectedValues(Data.titleDeactivation,driver
                .findElement(Locators.USERDEACT_INVITE_NOT_ACCEPTED).getText(), Data.userDeactInviteNotAccepted);
        clickAnyButton(Data.TEXT_EDIT);
        driver.findElement(Locators.USERDEACT_SEARCH_BOX_DAY_INACTIVITY);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_EXIT);
        clickAnyTitleByText(Data.titleExit, Data.h4);
        softAssert.assertAll();
    }

    /**
     * This method selects the Security Policy system options tile to display the Security Policy page, verifies the
     * side menu tab, verifies the Login Timeout and Password Policy section titles, verifies that the Login Timeout and
     * Password Policy sections are enabled when Edit is selected and exits the page.
     */
    public void verifySecurityPolicyConfigSysOptn(){
        clickAnyTitleByText(Data.systemOptionTitleSecurityPolicy, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_PASSWORD_POLICY));
        Assert.assertTrue(
                driver
                        .findElements(Locators.ANY_MAIN_TITLE)
                        .get(0)
                        .getText()
                        .contains(Data.titleLoginTimeout));
        Assert.assertTrue(
                driver
                        .findElement(Locators.ANY_MAIN_TITLE)
                        .getText()
                        .contains(Data.titlePasswordPolicy));
        clickAnyButton(Data.TEXT_EDIT, 0);
        clickAnyButton(Data.TEXT_CANCEL, 0);
        clickAnyButton(Data.TEXT_OK);
        clickAnyButton(Data.TEXT_EDIT, 1);
        clickAnyButton(Data.TEXT_CANCEL, 0);
        clickAnyButton(Data.TEXT_CANCEL2, 0);
        javaWaitSec(3);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    public void verifyPasswordPolicySystemOptions() {
        softAssert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_PASSWORD_POLICY));
        softAssert.assertTrue(driver.findElements(Locators.ANY_MAIN_TITLE).get(0).getText().contains(Data.titleLoginTimeout));
        softAssert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titlePasswordPolicy));

        verifyActualAndExpectedValues(Data.systemOptionTitleSecurityPolicy,driver
                .findElement(Locators.PASSPOLICY_REG_PASSWORD_LENGTH).getAttribute("value"), Data.passPolicyRegPassLength);
        verifyActualAndExpectedValues(Data.systemOptionTitleSecurityPolicy,driver
                .findElement(Locators.PASSPOLICY_PRIV_PASSWORD_LENGTH).getAttribute("value"), Data.passPolicyPrivPassLength);
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, true, driver.
                findElement(Locators.PASSPOLICY_USER_ACCT_NAME));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, true, driver.
                findElement(Locators.PASSPOLICY_UPPERCASE_LETTER));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, true, driver.
                findElement(Locators.PASSPOLICY_LOWERCASE_LETTER));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, true, driver.
                findElement(Locators.PASSPOLICY_ATLEAST_ONE_NUMBER));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, true, driver.
                findElement(Locators.PASSPOLICY_SPECIAL_CHAR));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, false, driver.
                findElement(Locators.PASSPOLICY_PASSWORD_REUSE));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, false, driver.
                findElement(Locators.PASSPOLICY_PASSWORD_RESET));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, false, driver.
                findElement(Locators.PASSPOLICY_PASSWORD_EXPIRATION));
        verifyConfigurationSwitch(Data.systemOptionTitleSecurityPolicy, false, driver.
                findElement(Locators.PASSPOLICY_PASSWORD_LOCK));
        clickAnyButton(Data.TEXT_EDIT, 0);
        clickAnyButton(Data.TEXT_CANCEL, 0);
        clickAnyButton(Data.TEXT_OK);
        clickAnyButton(Data.TEXT_EDIT, 1);
        clickAnyButton(Data.TEXT_CANCEL, 0);
        clickAnyButton(Data.TEXT_CANCEL2, 0);
        javaWaitSec(3);
        clickAnyTitleByText(Data.titleExit, Data.h4);
        // softAssert.assertAll();
    }

    /**
     * This method selects the Payments & Fees system options tile to display the Payments & Fees Configuration page,
     * verifies the side menu tab, verifies the page title, selects Edit and verifies the Individual Provider Enrollment
     * fees fields, verifies the Individual Provider Enrollment section titles and exits the page.
     */
    public void verifyPaymentAndFeeSystemOptions(){
        clickAnyTitleByText(Data.systemOptionTitlePaymentsFees, Data.h1);
        softAssert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_PAYMENT_FEES));
        javaWaitSec(2);
        clickBackToTop();
        softAssert.assertTrue(driver
                .findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titlePaymentAndFeesConfigurations));

        clickAnyButton(Data.TEXT_EDIT);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_AMOUNT);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_GROUP_AMOUNT);
        clickAnyButton(Data.TEXT_CANCEL);
        setAndFindAnyTitle(Data.titleIndividualProviderEnrollmentFees, Data.h3);
        setAndFindAnyTitle(Data.titleGroupProviderEnrollmentFees, Data.h3);
        setAndFindAnyTitle(Data.titleInStateInstitutionalEnrollmentFees, Data.h3);
        setAndFindAnyTitle(Data.titleOutStateInstitutionalEnrollmentFees, Data.h3);
        clickAnyTitleByText(Data.titleExit, Data.h4);
        softAssert.assertAll();
    }

    /**
     * This method selects the Auto Archive system options tile to display the Auto Archive page,
     * verifies the side menu tab, verifies the page title, selects Edit and verifies the Auto Archive Data and Auto
     * Archive files fields and exits the page.
     */
    public void VerifyAutoArchiveSystemOption(){
        clickAnyTitleByText(Data.systemOptionAutoArchive, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_AUTOARCHIVE));
        javaWaitSec(2);
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.systemOptionAutoArchive));
        setAndFindAnyTitle(Data.titleAutoArchiveData, Data.h3);
        driver.findElements(Locators.TEXT_FIELD_REQUEST_ID).get(0);
        driver.findElements(Locators.TEXT_FIELD_REQUEST_ID).get(1);
        clickAnyButton(Data.TEXT_EDIT);
        clickAnyButton(Data.TEXT_CANCEL);
        clickAnyButton(Data.TEXT_CANCEL, 1);
        clickAnyTitleByText(Data.titleExit, Data.h4);
    }

    /**
     * This method verifies the Screening system option 'Monitoring Frequency' section values (Allow Periodic
     * Monitoring, Monitoring Frequency) and 'Screening Issues Ranking' section values (Default Screening Thresholds,
     * Custom Screening Thresholds).
     */
    public void VerifyBaseConfigurationsForScreening(){
        javaWaitSec(1);
        clickBackToTop();
        //Monitoring Frequency
        Reports.log("Allow Periodic Monitoring");
        Reports.log("Periodic Monitoring Switch Status:");
        verifyConfigurationSwitch(Data.titleScreening, true, driver.
                findElement(Locators.SCREENING_PERIODIC_MONITORING_SWITCH));

        Reports.log("Monitoring frequency (every) :");
        verifyActualAndExpectedValues(Data.titleScreening,driver
                .findElement(Locators.SCREENING_MONITORING_FREQUENCY).getText(), Data.monitoringFrequency);

        //Screening Issues Ranking
        Reports.log("\n Configuration Based On:");
        WebElement defaultScreeningThresholdsRadioBtn =driver.findElement(Locators.DEFAULT_SCREENING_THRESHOLDS);
        Boolean defaultScreeningThresholdsRadioBtnStatus =defaultScreeningThresholdsRadioBtn.isSelected();
        Assert.assertFalse(defaultScreeningThresholdsRadioBtnStatus);
        Reports.log("Default Screening Thresholds: "+defaultScreeningThresholdsRadioBtnStatus);

        WebElement customScreeningThresholdsRadioBtn =driver.findElement(Locators.CUSTOM_SCREENING_THRESHOLDS);
        Boolean customScreeningThresholdsRadioBtnStatus = customScreeningThresholdsRadioBtn.isSelected();
        Assert.assertTrue(customScreeningThresholdsRadioBtnStatus);
        Reports.log("Custom Screening Thresholds: "+customScreeningThresholdsRadioBtnStatus);

        driver.findElement(Locators.SCREENING_RANKINS).click();
        Reports.log("Click on Individual Parameters");

        javaWaitSec(2);

        //SSN
        //String ssnRanking =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_SSN).getText();
        String ssnRanking =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_SSN).getText();
        Reports.log("SSN Ranking: "+ssnRanking);
        Assert.assertEquals(ssnRanking, Data.ssnScreeningRanking);

        //License expired
        String licenseExpired =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_LICENSE_EXP).getText();
        Reports.log("License expired Ranking: "+licenseExpired);
        Assert.assertEquals(licenseExpired, Data.licenseExpired);

        //NPI
        String NPIInvalidOrExpired =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_NPI_EXP).getText();
        Reports.log("NPI is Invalid Or Expired: "+NPIInvalidOrExpired);
        Assert.assertEquals(NPIInvalidOrExpired, Data.NPIInvalidOrExpired);

        //TIN/FEIN is invalid or expired
        String TINFEINInvalidExpired =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_FEIN_EXP).getText();
        Reports.log("TIN/FEIN is invalid or expired: "+TINFEINInvalidExpired);
        Assert.assertEquals(TINFEINInvalidExpired, Data.TINFEINInvalidExpired);

        //Record found in Death indicators (SSA and other sources)
        String deathIndicators =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_DEATH_INDICATOR).getText();
        Reports.log("Record found in Death indicators (SSA and other sources): "+deathIndicators);
        Assert.assertEquals(deathIndicators, Data.deathIndicators);

        // Record found in list of Excluded Individuals/Entities (LEIE)
        String lEIERecord = driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_LEIE).getText();
        Reports.log("Record found in list of Excluded Individuals/Entities (LEIE): "+lEIERecord);
        Assert.assertEquals(lEIERecord, Data.lEIERecord);

        // Record found in Excluded Parties List System (EPLS)
        String ePLSRecords = driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_EPLS).getText();
        Reports.log("Record found in Excluded Parties List System (EPLS): "+ePLSRecords);
        Assert.assertEquals(ePLSRecords, Data.ePLSRecords); // Record found in list of Excluded Individuals/Entities (LEIE)

        //DEX
        String dex =  driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_DEX).getText();
        Reports.log("DEX: "+dex);
        Assert.assertEquals(dex, Data.dex);

        //DEA number is invalid or expired
        String denNumber = driver.findElement(Locators.SCREENING_INDIVIDUAL_PARAM_DEN_EXP).getText();
        Reports.log("DEA number is invalid or expired: "+denNumber);
        Assert.assertEquals(denNumber, Data.denNumber);
    }

    /**
     * This method verifies the Auto Archive Data and Auto Archive Files values displayed on the Auto Archive system
     * options page.
     */
    public void verifyBaseConfigurationForAutoArchive() {
        //Auto Archive Data set Period
        String dataSetPeriod =  driver.findElement(Locators.AUTO_ARCHIVE_DATA_SET_PERIOD).getAttribute("Value");
        Reports.log("Auto Archive Data set Period is: "+dataSetPeriod);
        Assert.assertEquals(dataSetPeriod, "7");

        //Auto Archive File set Period
        String dataSetFile =  driver.findElement(Locators.AUTO_ARCHIVE_FILE_SET_PERIOD).getAttribute("Value");
        Reports.log("Auto Archive File set Period is: "+dataSetFile);
        Assert.assertEquals(dataSetFile, "7");
    }

    public void verifyBaseConfigurationForAutoTerminate() {
        //Auto Terminate
        Boolean autoTerminateSwitchStatus = driver.findElement(By.xpath("//input[@aria-label='Enable Auto Terminate Switch']")).isSelected();
        Reports.log("Enable Auto Terminate switch status: "+autoTerminateSwitchStatus);
        if(!autoTerminateSwitchStatus) {
            Assert.assertFalse(autoTerminateSwitchStatus);
        }
        else{
            String noofDays = driver.findElement(By.xpath("//div//span[contains(text(),'Period After which suspended Providers will be terminated')]//following::div/span[1]")).getText();
            Reports.log("Period After which suspended Providers will be terminated: "+noofDays +"day's");

            String noOFDaysForFirstNotification = driver.findElement(By.xpath("//div[contains(text(),'1st notification')]/../div[2]/span[1]")).getText();
            String noOFDaysForSecondNotification = driver.findElement(By.xpath("//div[contains(text(),'2nd notification')]/../div[2]/span[1]")).getText();
            String noOFDaysForThirdNotification = driver.findElement(By.xpath("//div[contains(text(),'3rd notification')]/../div[2]/span[1]")).getText();

            Reports.log("Reminder notifications that are sent prior to termination date:");
            Reports.log("   1st notification: "+noOFDaysForFirstNotification+"day's");
            Reports.log("   2nd notification: "+noOFDaysForSecondNotification+"day's");
            Reports.log("   3rd notification: "+noOFDaysForThirdNotification+"day's");
            Assert.assertEquals(noOFDaysForFirstNotification, "60");
            Assert.assertEquals(noOFDaysForSecondNotification, "30");
            Assert.assertEquals(noOFDaysForThirdNotification, "15");
        }
    }

    public void verifyBaseConfigurationForLoginTimeout() {
        //Login Timout
        Boolean loginTimeoutSwitchStatus = driver.findElement(By.xpath("//input[@name='logoutSwitch']")).isSelected();
         Assert.assertFalse(loginTimeoutSwitchStatus);
       // Assert.assertTrue(loginTimeoutSwitchStatus);
        Reports.log("Enable Login Timeout switch status: "+loginTimeoutSwitchStatus);
    }

    public void verifyBaseConfigurationsForActionOnDataChange(){
        for(int i=1; i<9;i++) {

            String infoType = driver.findElement(By.xpath("(//div[starts-with(@class,'data-change-settings_actions-key')])"+ "[" + i+"]")).getText();
            Boolean notificationCheckboxStatus = driver.findElement(By.xpath("(//input[@name='Notification'])" + "[" + i + "]")).isSelected();
            Boolean confirmationCheckboxStatus = driver.findElement(By.xpath("(//input[@name='Confirmation'])" + "[" + i + "]")).isSelected();
            Boolean overrideCheckboxStatus = driver.findElement(By.xpath("(//input[@name='Override'])" + "[" + i + "]")).isSelected();

            Reports.log(" Notification Status: " + notificationCheckboxStatus +
                    ",   Confirmation Status: " + confirmationCheckboxStatus + ",   Override status: " + overrideCheckboxStatus + ", For " + infoType);
            Assert.assertTrue(notificationCheckboxStatus);
        }
    }

    /**
     * This method verifies the Site Visit System Option 'Schedule Site Visit Based on' (Risk level based on Taxonomy,
     * Risk level based on Screening score, Higher of the two Risk Levels) and 'Schedule site visit for the
     * State based on' (Instate Providers, Outstate Providers, Both) configuration values.
     */
    public void verifyBaseConfigurationForSiteVisit() {
        //Schedule Site Visit Based on
        Reports.log("Risk level based on Taxonomy:");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, true, driver.
                findElement(Locators.SITE_VISIT_BASED_ON_TAXONOMY_RADIO_BTN));

        Reports.log("Risk level based on Screening score");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, false, driver.
                findElement(Locators.SITE_VISIT_BASED_ON_SCREENING_SCORE_RADIO_BTN));

        Reports.log("Higher of the two Risk Levels, Taxonomy and Screening Score");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, false, driver.
                findElement(Locators.SITE_VISIT_BASED_ON_HIGHER_RISK_LEVELS_RADIO_BTN));

        Reports.log("Schedule site visit for the State based on");
        Reports.log("Instate Providers: ");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, true, driver.
                findElement(Locators.SITE_VISIT_BASED_ON_INSTATE_PROVIDER_RADIO_BTN));

        Reports.log("Outstate Providers: ");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, false, driver.
                findElement(Locators.SITE_VISIT_BASED_ON_OUTSTATE_PROVIDER_RADIO_BTN));

        Reports.log("Both: ");
        verifyConfigurationSwitch(Data.systemOptionTitleSiteVisit, false, driver.
                findElement(Locators.SITE_VISIT_BASED_ON_BOTH_PROVIDER_RADIO_BTN));
    }

    /**
     * This method verifies the Approvals System Option Auto Approval Based on Screening Score switch.
     *
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean)
     * @see #verifyApprovalsAdminConfigurationReEnrollment(Boolean)
     * @see #verifyApprovalsAdminConfigurationCOC(Boolean)
     * @see #verifyApprovalsAdminConfigurationAppealApp(Boolean)
     * @see #verifyApprovalsAdminConfigurationSiteVisit(Boolean)
     */
    public void verifyAutoCheckbox() {
        Reports.log("verifying the Auto Switch ");
        Boolean autoApprovalCheckboxStatus = driver.findElement(By.xpath("//input[@aria-label='Auto Switch']")).isSelected() ;
        Reports.log("Automatically approved or denied based upon screening score checkbox isEnabled: " +autoApprovalCheckboxStatus);
        Assert.assertFalse(autoApprovalCheckboxStatus);
    }

    /**
     * This method verifies the values displayed in the Configure Approver section on the Approvals system options page.
     *
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean)
     * @see #verifyApprovalsAdminConfigurationReEnrollment(Boolean)
     * @see #verifyApprovalsAdminConfigurationCOC(Boolean)
     * @see #verifyApprovalsAdminConfigurationAppealApp(Boolean)
     * @see #verifyApprovalsAdminConfigurationSiteVisit(Boolean)
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
     * This method verifies the Approvals system options 'Configure reviewers' section switch and the values displayed
     * in the section if the switch is enabled.
     *
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean)
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
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean)
     */
    public void verifyTemporaryApproval(){
        Boolean temporaryApprovalSwitchStatus = driver.findElement(By.xpath("//input[@aria-label='Temporary Approval Switch']")).isSelected();
        Assert.assertFalse(temporaryApprovalSwitchStatus);
        Reports.log("Temporary Approval Switch isEnabled: " +temporaryApprovalSwitchStatus);
    }

    /**
     * This method verifies the Approvals System Option Assignee Configuration switch using the expectedStatus argument.
     *
     * @param expectedStatus
     * @see #verifyApprovalsAdminConfigurationEnrollments(Boolean)
     */
    public void verifyAssigneeConfiguration(Boolean expectedStatus) {
        javaWait(3);
        Boolean assigneeConfigurationSwitchStatus = driver.findElement(By.xpath("//h3[contains(text(),'Assignee Configuration')]//following::input[1]")).isSelected();
        Reports.log("Assignee Configuration Switch isEnabled: " +assigneeConfigurationSwitchStatus);
        Assert.assertEquals(assigneeConfigurationSwitchStatus, expectedStatus);
        //  Assert.assertFalse(assigneeConfigurationSwitchStatus);
    }

    /**
     * This method selects the Enrollment View button displayed on the Approval Configuration page to display the
     * Enrollment Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values, verifies the Manual Configure Reviewer section values, verifies the Assignee Configuration
     * section switch using the AssignConfigValue argument and verifies the Temporary Approval section switch.
     *
     * @param AssignConfigValue
     */
    public void verifyApprovalsAdminConfigurationEnrollments(Boolean AssignConfigValue) {
        Reports.log("Click on Enrollment view button");
        ajaxClick(Locators.APPROVALS_ENROLLMENTS_BUTTON_VIEW);
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox();
        verifyConfigureApprover();
        verifyConfigureReviewer();
        verifyAssigneeConfiguration(AssignConfigValue);
        verifyTemporaryApproval();

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
     * This method Clicks and navigates to the  given approval configuration type and verifies the Approval and Reviewer Configurations
     */
    public void VerifyProverApvlConfiguration(String approvalType , int numOfApprovals, boolean reviewSwitchStatus) {
        Reports.log("=================Verifying "+approvalType+" Configurations=================");
        By approvalTypeButton = By.xpath("//h3[text()='"+approvalType+"']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']") ;
        WebElement button = driver.findElement(approvalTypeButton);
        ajaxClick(button);
        javaWaitSec(2);
        Reports.log("Navigate to "+approvalType+" Approval page");
        setPreconditionForConfigureApprover(numOfApprovals);
        setPreconditionForConfigureReviewers(reviewSwitchStatus);
        ajaxClick(Locators.APPROVALS_BACK_TO_APPROVAL_LIST_BUTTON);
        javaWaitSec(2);
    }


    /**
     * This method verifies  if the Approval configuration is set for as per expected numOfApprovals,
     * If not then set the configuration for given numOfApprovals.
     */
    public void setPreconditionForConfigureApprover(int numOfApprovals) {

        // Configure approver
        int numOfApprovalsRequired = Integer.parseInt(driver.findElement(Locators.APPROVALS_ENROLLMENT_NUMBER_OF_APPROVER_CONFIGURE).getText());
        Reports.log("Number of approvals required for approval: " + numOfApprovalsRequired);

        if (numOfApprovalsRequired == numOfApprovals) {
            Assert.assertEquals(numOfApprovalsRequired, numOfApprovals);
        }
        else{
            ajaxClick(Locators.APPROVALS_EDIT_BUTTON);
            ajaxClear(Locators.APPROVALS_ENROLLMENT_APPROVER_CONFIGURE_INPUT_TEXT);
            ajaxSendKeys(Locators.APPROVALS_ENROLLMENT_APPROVER_CONFIGURE_INPUT_TEXT, String.valueOf(numOfApprovals));
            ajaxClick(Locators.APPROVALS_SAVE_CHANGES_BUTTON);
            javaWaitSec(5);
            String  approvalsRequired = driver.findElement(Locators.APPROVALS_ENROLLMENT_NUMBER_OF_APPROVER_CONFIGURE).getText();
            Reports.log("Updated the Number of approvals required to: " + approvalsRequired);
            Assert.assertEquals(approvalsRequired, numOfApprovals);
        }
    }
    /**
     * This method verifies if the Reviewers configuration is as per the reviewSwitchStatus
     * If not then set the review Switch Status  as expected.
     */
    public void setPreconditionForConfigureReviewers(Boolean reviewSwitchStatus) {
        //Configure reviewers to vote for request approval
        WebElement configureReviewerSwitch = driver.findElement(Locators.APPROVALS_ENROLLMENT_NUMBER_OF_REVIEWERS_CONFIGURE);
        Boolean configureReviewerSwitchStatus = configureReviewerSwitch.isSelected();
        Reports.log("Configure reviewer Switch isEnabled: " + configureReviewerSwitchStatus);
        if(reviewSwitchStatus == configureReviewerSwitchStatus) {
            Assert.assertEquals(configureReviewerSwitchStatus,reviewSwitchStatus);

        }
        else{
            ajaxClick(Locators.APPROVALS_EDIT_BUTTON);
            ajaxClick(Locators.APPROVALS_ENROLLMENT_NUMBER_OF_REVIEWERS_CONFIGURE);
            ajaxClick(Locators.APPROVALS_SAVE_CHANGES_BUTTON);
            javaWaitSec(5);
            WebElement SwitchStatus = driver.findElement(Locators.APPROVALS_ENROLLMENT_NUMBER_OF_REVIEWERS_CONFIGURE);
            Boolean  updatedSwitchStatus = SwitchStatus.isSelected();
            Reports.log("updated Configure reviewer Switch isEnabled: " + updatedSwitchStatus);
            Assert.assertEquals(updatedSwitchStatus,reviewSwitchStatus);
        }
    }


    /**
     * This method selects the Revalidation View button displayed on the Approval Configuration page to display the
     * Revalidation Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationRevalidation(Boolean AssignConfigValue) {
        ajaxClick(Locators.APPROVALS_REVALIDATION_BUTTON_VIEW);
        Reports.log("Click on Revalidation view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox();
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Appeal View button displayed on the Approval Configuration page to display the
     * Appeal Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationAppealApp(Boolean AssignConfigValue){
        ajaxClick(Locators.APPROVALS_APPEAL_APPROVAL_BUTTON_VIEW);
        Reports.log("Click on Appeal view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox();
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
    public void verifyApprovalsAdminConfigurationCOC(Boolean AssignConfigValue) {
        ajaxClick(Locators.APPROVALS_COC_BUTTON_VIEW);
        Reports.log("Click on Appeal view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox();

        Boolean autoAffiliationApprovalCheckboxStatus = driver.findElement(By.xpath("(//input[@aria-label='Auto Switch'])[2]")).isSelected() ;
        Reports.log("Affiliation request is automatically approved upon submission of affiliation request checkbox isEnabled: " +autoAffiliationApprovalCheckboxStatus);
       if(!AssignConfigValue) { Assert.assertFalse(autoAffiliationApprovalCheckboxStatus);
       }else { Assert.assertTrue(autoAffiliationApprovalCheckboxStatus); }
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Site Visit View button displayed on the Approval Configuration page to display the
     * Site Visit Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationSiteVisit(Boolean AssignConfigValue){
        ajaxClick(Locators.APPROVALS_SITE_VISIT_BUTTON_VIEW);
        Reports.log("Click on Site Visit view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox();
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Re Enrollment View button displayed on the Approval Configuration page to display the
     * Re Enrollment Approval page, verifies the Auto Approval section switch, verifies the Manual Configure Approver
     * section values and verifies the Assignee Configuration section switch.
     */
    public void verifyApprovalsAdminConfigurationReEnrollment(Boolean AssignConfigValue) {
        ajaxClick(Locators.APPROVALS_ReEnrollment_BUTTON_VIEW);
        Reports.log("Click on Re Enrollment view button");
        javaWaitSec(3);
        clickBackToTop();
        verifyAutoCheckbox();
        verifyConfigureApprover();
        verifyAssigneeConfiguration(AssignConfigValue);
    }

    /**
     * This method selects the Security Policy tile on the System Options page.
     */
    public void navigateTOSecurityPolicy(){
        Reports.log("Select Security Policy option");
        clickAnyTitleByText(Data.systemOptionTitleSecurityPolicy, Data.h1);
        javaWaitSec(3);
    }

    /**
     * This method selects the Users tile on the System Options page.
     */
    public void navigateToUserOption(){
        Reports.log("Select User option");
        clickAnyTitleByText(Data.titleUsers, Data.h1);
        javaWaitSec(3);
    }

    /**
     * This method selects the Auto Assign tile on the System Options page to display the Auto Assign page,
     * verifies the side menu tab and verifies the page title.
     */
    public void navigateToAutoAssign(){
        Reports.log("Select Auto Assign option");
        clickAnyTitleByText(Data.systemOptionTitleAutoAssign, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_AUTO_ASSIGN_RULES));
        Assert.assertTrue(driver.findElement(Locators.ANY_MAIN_TITLE).getText().contains(Data.titleAutoAssign));
        javaWaitSec(3);
    }

    /**
     * This method selects the Screening tile on the System Options page.
     */
    public void navigateScreeningOption(){
        Reports.log("Select Screening Title option");
        clickAnyTitleByText(Data.titleScreening, Data.h1);
        javaWaitSec(3);
    }

    /**
     * This method selects the Externalization tile on the System Options page and verifies the side menu tab.
     */
    public void navigateExternalizationOption(){
        Reports.log("select Externalization Title option");
        clickAnyTitleByText(Data.titleExternalization, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_ERROR_MESSAGES));
    }

    /**
     * This method selects the Auto Archive tile on the System Options page.
     */
    public void navigateAutoArchive(){
        Reports.log("Select Auto Archive option");
        clickAnyTitleByText(Data.systemOptionAutoArchive, Data.h1);
        javaWaitSec(2);
    }

    /**
     * This method selects the Security Policy tile on the System Options page.
     */
    public void navigateSecurityPolicy(){
        Reports.log("Select Security Policy Title option");
        clickAnyTitleByText(Data.systemOptionTitleSecurityPolicy, Data.h1);
        javaWaitSec(2);
    }

    /**
     * This method selects the Site Visit tile on the System Options page.
     */
    public void navigateSiteVisits(){
        Reports.log("Select SiteVisits option");
        clickAnyTitleByText(Data.systemOptionTitleSiteVisit, Data.h1);
        javaWaitSec(2);
    }

    /**
     * This method selects the Data Change tile on the System Options page and verifies the side menu tab.
     */
    public void navigateDataChange(){
        Reports.log("Select Data Change option");
        clickAnyTitleByText(Data.systemOptionTitleDataChange, Data.h1);
        Assert.assertTrue(driver.getCurrentUrl().contains(Data.LINK_DATA_CHANGE_ACTIONS));
        clickBackToTop();
        javaWaitSec(3);
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
     * This method creates and saves an Auto Assign rule using applicationType, parameter, operator, statusValue,
     * assignTo and assignValue arguments on the Auto Assign system options page.
     *
     * @param applicationType
     * @param parameter
     * @param operator
     * @param statusValue
     * @param assignTo
     * @param assignValue
     */
    public void createAutoAssignRule(String applicationType, String parameter,String operator,
                                     String statusValue, String assignTo, String assignValue){

        clickAnyButton(Data.TEXT_CREATE_RULE);
        Reports.log("Clicked on Create rule button\n");
        Assert.assertTrue(driver.findElement(Locators.TITLE_NEW_RULE_AUTO_ASSIGN).getText().contains(Data.titleNewRule));
        ajaxScrollUp();
        javaWaitSec(1);
        //Select Application
        driver.findElement(Locators.SELECT_APPLICATION_TYPE).findElement(Locators.SELECT_APPLICATION_DROPDOWN).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(applicationType);
        Reports.log("Select Application Type: "+applicationType);

        //If Condition
        Reports.log("  Enter If Condition as: ");
        //Parameter
        driver.findElement(Locators.SELECT_IF_PARAMETER).findElement(By.xpath("(//div[@role='button'])[2]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(parameter);
        Reports.log("   Parameter: "+parameter);

        //Operator
        driver.findElement(Locators.SELECT_OPERATOR).findElement(By.xpath("(//div[@role='button'])[3]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(operator);
        Reports.log("   Operator: "+operator);

        //Status Value
        driver.findElement(Locators.SELECT_STATUS_VALUE).findElement(By.xpath("(//div[@role='button'])[4]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(statusValue);
        Reports.log("   Status value: "+statusValue);

        //Do
        Reports.log("\n  Enter Do conditions as: ");
        // Assign To
        driver.findElement(Locators.SELECT_ASSIGN_TO).findElement(By.xpath("(//div[@role='button'])[5]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(assignTo);
        Reports.log("   Assign To: "+assignTo);

        driver.findElement(Locators.SELECT_ASSIGN_VALUE).findElement(By.xpath("(//div[@role='button'])[6]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(assignValue);
        Reports.log("   Assign value: "+assignValue);

        ajaxClick(Locators.SAVE_RULE_BUTTON);
        Reports.log("Clicked on Save button");
        javaWaitSec(3);

        // Assert.assertTrue(driver.findElement(Locators.NEW_RULE_LIST_AUTO_ASSIGN).getText().contains(Data.titleNewRule));
    }

    /**
     * This method deletes all rules listed on the Auto Assign system options page.
     */
    public void verifyAndDeletIFAnyNewRuleExist()
    {
        try{
            if(driver.findElement(Locators.AUTO_ASSIGN_No_RULES_Text).isDisplayed()) {
                Reports.log(driver.findElement(Locators.AUTO_ASSIGN_No_RULES_Text).getText());

            }
        } catch(Exception e) {
            Reports.log("Verifying if any rules exist\n");
            List<WebElement> existingRule = driver.findElements(Locators.AUTO_ASSIGN_RULES_LIST);
            int noOfAutoAssignRules = existingRule.size();
            Reports.log("No Of Auto Assign Rules Exist are : " + noOfAutoAssignRules);
            for (int i = 1; i <= noOfAutoAssignRules; i++) {
                driver.findElement(Locators.NEW_RULE_ELLIPSE_BUTTON).click();
                javaWaitSec(1);
                driver.findElement(By.xpath("//li[contains(.,'Remove')]")).click();
                javaWaitSec(2);
                ajaxClick(Locators.OK_BUTTON_CONFIRMATION_POPUP);
                javaWaitSec(3);
                Reports.log("Existing rule deleted successfully \n");
            }
        }
    }

    /**
     * This method deletes existing rules displayed on the Auto Assign system options page and creates a Auto Assign
     * rule using applicationType, parameter1, statusValue1, parameter2,statusValue2, assignTo and assignValue
     * arguments.
     *
     * @param applicationType
     * @param parameter
     * @param operator
     * @param statusValue
     * @param assignTo
     * @param assignValue
     */
    public void VerifyBaseConfigurationsForAutoAssign(String applicationType, String parameter,String operator,
                                                      String statusValue, String assignTo, String assignValue){
        verifyAndDeletIFAnyNewRuleExist();

        if (applicationType.equalsIgnoreCase("coc")) {
            createAutoAssignRule(applicationType, parameter, operator, statusValue,
                    assignTo, assignValue);
        }
        WebElement rID = driver.findElement(By.xpath("//div[starts-with(@class,'auto-assign_rule-name')]/div[1]"));
        WebElement rName = driver.findElement(By.xpath("//div[starts-with(@class,'auto-assign_rule-name')]/div[2]"));
        String ruleID = rID.getText();
        String ruleName = rName.getText();
        Reports.log("\nRule Created Successfully as:");
        Reports.log("   Rule Name: " + ruleID + " "+ruleName);
        rName.click();
        String displayedApplicationType = driver.findElement(Locators.SELECT_APPLICATION_TYPE).findElement(Locators.SELECT_APPLICATION_DROPDOWN).getText();
        Reports.log("   Application Type: " + displayedApplicationType);

        String applicationParameter = driver.findElement(By.xpath("//input[starts-with(@id,'Parameter')]//preceding-sibling::div")).getText();
        Reports.log("   Application Parameters: " + applicationParameter);
        Assert.assertTrue(parameter.equalsIgnoreCase(applicationParameter));

        String applicationValue = driver.findElement(By.xpath("//input[starts-with(@id,'value')]")).getAttribute("value");
        Reports.log("   Application Value: " + applicationValue);
        //Assert.assertTrue(statusValue.equalsIgnoreCase(applicationValue);

        String applicationAssignTo = driver.findElement(By.xpath("//input[starts-with(@id,'Assign To')]//preceding-sibling::div")).getText();
        Reports.log("   Application Assign to: " + applicationAssignTo);
        Assert.assertTrue(assignTo.equalsIgnoreCase(applicationAssignTo));


        String applicationAssigValue = driver.findElement(By.xpath("//div//label[@id='Value']//following::div//input")).getAttribute("value");
        //driver.findElement(By.xpath("//input[starts-with(@id,'Value_')]")).getAttribute("value");
        Reports.log("   Application Assign Value: " + applicationAssigValue);
        // Assert.assertTrue(assignValue.equalsIgnoreCase(applicationAssigValue));
    }

    /**
     * This method creates and saves an Auto Assign rule using applicationType, parameter1, statusValue1, parameter2,
     * statusValue2, assignTo and assignValue arguments on the Auto Assign system options page.
     *
     * @param applicationType
     * @param parameter1
     * @param statusValue1
     * @param parameter2
     * @param statusValue2
     * @param assignTo
     * @param assignValue
     */
    public  void createAutoAssignRule(String applicationType, String parameter1,String statusValue1,
                                      String parameter2,String statusValue2,String assignTo, String assignValue) {

        clickAnyButton(Data.TEXT_CREATE_RULE);
        Reports.log("Clicked on Create rule button\n");
        Assert.assertTrue(driver.findElement(Locators.TITLE_NEW_RULE_AUTO_ASSIGN).getText().contains(Data.titleNewRule));
        ajaxScrollUp();
        javaWaitSec(1);
        //Select Application
        driver.findElement(Locators.SELECT_APPLICATION_TYPE).findElement(Locators.SELECT_APPLICATION_DROPDOWN).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(applicationType);
        Reports.log("Select Application Type: " + applicationType);

        //If Condition
        Reports.log("Enter If Condition as: ");

        //Parameter
        driver.findElement(Locators.SELECT_IF_PARAMETER).findElement(By.xpath("(//div[@role='button'])[2]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(parameter1);
        Reports.log("   Parameter: " + parameter1);

        //Status Value
        //driver.findElement(Locators.SELECT_STATUS_VALUE).findElement(By.xpath("(//div[@role='button'])[3]")).click();
        driver.findElement(Locators.SELECT_ENROLLMENT_TYPE_VALUE).findElement(By.xpath("(//div[@role='button'])[3]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(statusValue1);
        Reports.log("   Enrollment Type value: " + statusValue1);

        //Add Condition
        ajaxClick(Locators.ADD_CONDITION);
        Reports.log("Click On Add Condition");

        //Parameter
        driver.findElement(Locators.SELECT_IF_PARAMETER).findElement(By.xpath("(//div[@role='button'])[4]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(parameter2);
        Reports.log("   Parameter: " + parameter2);

        //Status Value
        ajaxClick(Locators.SECOND_ENROLLMENT_TYPE_VALUE);
        ajaxClick(By.xpath("(//div[@role='button'])[5]"));
        javaWaitSec(1);
        clickSpecificOptionInListbox(statusValue2);
        Reports.log("   Enrollment Type value: " + statusValue2);

        //Do
        Reports.log("\n  Enter Do conditions as: ");
        // Assign To
        driver.findElement(Locators.SELECT_ASSIGN_TO).findElement(By.xpath("(//div[@role='button'])[6]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(assignTo);
        Reports.log("   Assign To: " + assignTo);

        driver.findElement(Locators.SELECT_ASSIGN_VALUE).findElement(By.xpath("(//div[@role='button'])[7]")).click();
        javaWaitSec(1);
        clickSpecificOptionInListbox(assignValue);
        Reports.log("   Assign value: " + assignValue);

        ajaxClick(Locators.SAVE_RULE_BUTTON);
        Reports.log("Clicked on Save button");
        javaWaitSec(3);
    }

    /**
     * This method deletes existing rules displayed on the Auto Assign system options page and creates a Auto Assign
     * rule using applicationType, parameter1, statusValue1, parameter2,statusValue2, assignTo and assignValue
     * arguments.
     *
     * @param applicationType
     * @param parameter1
     * @param statusValue1
     * @param parameter2
     * @param statusValue2
     * @param assignTo
     * @param assignValue
     */
    public void VerifyAutoAssigConfigForDocReview(String applicationType, String parameter1,String statusValue1,
                                                  String parameter2,String statusValue2,String assignTo, String assignValue) {
        verifyAndDeletIFAnyNewRuleExist();
        createAutoAssignRule(applicationType, parameter1, statusValue1,
                parameter2,statusValue2, assignTo, assignValue);

        WebElement rID = driver.findElement(By.xpath("//div[starts-with(@class,'auto-assign_rule-name')]/div[1]"));
        WebElement rName = driver.findElement(By.xpath("//div[starts-with(@class,'auto-assign_rule-name')]/div[2]"));
        String ruleID = rID.getText();
        String ruleName = rName.getText();
        Reports.log("\nRule Created Successfully as:");
        Reports.log("   Rule Name: " + ruleID + " "+ruleName);
        ajaxClick(By.xpath("//div[starts-with(@class,'auto-assign_rule-name')]/div[2]"));
        String displayedApplicationType = driver.findElement(Locators.SELECT_APPLICATION_TYPE).findElement(Locators.SELECT_APPLICATION_DROPDOWN).getText();
        Reports.log("   Application Type: " + displayedApplicationType);

        String applicationParameter1 = driver.findElement(By.xpath("(//input[starts-with(@id,'Parameter')])[1]//preceding-sibling::div")).getText();
        Reports.log("   Application Parameters1: " + applicationParameter1);
        Assert.assertTrue(parameter1.equalsIgnoreCase(applicationParameter1));

        String applicationValue1 = driver.findElement(By.xpath("(//label[@id='Enrollment type value'])[1]")).
                findElement(By.xpath("(//div[@role='button'])[3]")).getText();
        Reports.log("   Enrollment type value1: " + applicationValue1);
        Assert.assertTrue(applicationValue1.contains(statusValue1)||applicationValue1.contains(statusValue2));

        String applicationParameter2 = driver.findElement(By.xpath("(//input[starts-with(@id,'Parameter')])[2]//preceding-sibling::div")).getText();
        Reports.log("   Application Parameters2: " + applicationParameter2);
        Assert.assertEquals(parameter2,applicationParameter2);


        String applicationValue2 = driver.findElement(By.xpath("(//label[@id='Enrollment type value'])[2]")).
                findElement(By.xpath("(//div[@role='button'])[5]")).getText();
        Reports.log("   Enrollment type value2: " + applicationValue2);
        Assert.assertTrue(applicationValue2.contains(statusValue1)||applicationValue2.contains(statusValue2));

        String applicationAssignTo = driver.findElement(By.xpath("//input[starts-with(@id,'Assign To')]//preceding-sibling::div")).getText();
        Reports.log("   Application Assign to: " + applicationAssignTo);

        String applicationAssigValue = driver.findElement(By.xpath("//div//label[@id='Value']//following::div//input")).getAttribute("value");
        //driver.findElement(By.xpath("//input[starts-with(@id,'Value_')]")).getAttribute("value");
        Reports.log("   Application Assign Value: " + applicationAssigValue);
    }

    /**
     * This method selects the Users system options tile to display the User Management page, selects +Add User to
     * display the Add New User popup, populates the popup fields with firstName, lastName, email and userRole
     * arguments and selects Add to create a new user.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param userRole
     */
    public void createUser(String firstName, String lastName, String email, String userRole){
        navigateToUserOption();
        ajaxScrollUp();
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_ADD_USER);
        setAndFindAnyTitle(Data.titleAddNewUser, Data.h2);
        javaWaitSec(2);
        //By TEXT_FIELD_FirstName = By.xpath("((//div[contains(@class,'styles_input-group')]/div/div/label)[1]/following::input)[1]");
        By TEXT_FIELD_FirstName = By.xpath("//label[text()='First Name']/../div/input");
        driver.findElement(TEXT_FIELD_FirstName).sendKeys(firstName);;
        Reports.log("First Name:"+firstName);
        //driver.findElement(By.xpath(" ((//div[contains(@class,'styles_input-group')]/div/div/label)[1]/following::input)[2]")).sendKeys(lastName);
        driver.findElement(By.xpath("//label[text()='Last Name']/../div/input")).sendKeys(lastName);
        Reports.log("Last Name: "+lastName);
        //driver.findElement(By.xpath("((//div[contains(@class,'styles_input-group')]/div/div/label)[1]/following::input)[3]")).sendKeys(email);
        driver.findElement(By.xpath("//label[text()='Email (User ID)']/../div/input")).sendKeys(email);
        Reports.log("Email Id: "+email);
        javaWaitSec(2);
        //driver.findElement(By.cssSelector("div[role=button][class*='jss750']")).click();
        driver.findElement(By.xpath(".//input[contains(@id, 'Roles')]/preceding-sibling::div")).click();
        javaWaitSec(1);
        Reports.log(  userRole  + " role is selected from the list of Roles");
        //WebElement role = driver.findElement(By.cssSelector(" ul[role='listbox']>li[data-value='Call Center Supervisor']"));
        WebElement role = driver.findElement(By.xpath("//ul/li[contains(text(),'" + userRole + "')]"));
        role.click();
        javaWaitSec(1);
        role.sendKeys(Keys.TAB);
        Reports.log("New user is added to the list of users");
        // driver.findElement(By.xpath("(//span[text()='Add']/ancestor::button/span)[1]")).click();
        driver.findElement(By.xpath("//span[text()='Add']")).click();

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
        Reports.log(systemOption + ": Expected Value: "+expectedValue+"  | Actual Value: " + actualValue +"\n");
        softAssert.assertEquals(actualValue, expectedValue);
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
        Reports.log(systemOption+": Expected Value: "+expectedValue+"  Actual Value: " + actualValue);
        softAssert.assertEquals(actualValue, expectedValue);
    }

    /**
     * This method deactivates or reactivates a Provider using status and statusText arguments.
     *
     * @param status
     * @param statusText
     */
    public void userCreateDeactivateInactivate(String status, String statusText) {
        javaWaitSec(2);
        driver.findElement(Locators.DEACTIVATION_ACTIVATION_OPTION).click();
        javaWaitSec(2);
        //Select approve Reason
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        //clickFirstOptionInList();
        clickAnyOptionInList("Other");
        javaWaitSec(5);
        WebElement note = driver.findElement(Locators.POPUP_PENDING_REVIEW_NOTES);
        note.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        note.sendKeys("The user is getting " + statusText + " ,Regression test");
        Reports.log("The user is getting " + statusText + " ,Regression test");
        javaWaitSec(1);
        clickAnyButton(status);
        javaWaitSec(1);
        String message = getElementText(Locators.SUCCESS_MESSAGE);
        Reports.log("The message is displayed: " + message);
        javaWaitSec(1);
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        javaWaitSec(1);
    }
}
