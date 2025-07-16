package com.hhstechgroup.common.configurationfactory;

import com.hhstechgroup.common.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the system option configuration.
 */
public class SOSecurityPolicy extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";

    //******************************************************************************************************************
    //
    //                                  MISC XPATH STRINGS DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String ATTRIBUTE_VALUE = "value";

    //******************************************************************************************************************
    //
    // CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String SECURITY_POLICY_LOGOUT_SWITCH = "Enable Login Timeout_true_//input[@name='logoutSwitch']";
    private static final String SECURITY_POLICY_LOGOUT_DAYS = "Login Timeout Period_20_//input[@aria-label='Login Timeout Period']";
    private static final String SECURITY_POLICY_ENABLE_AUTO_TERMINATE_SWITCH = "Enable Auto Terminate_true_(//input[@aria-label='Enable Auto Terminate Switch'])[1]";
    private static final String SECURITY_POLICY_AUTO_TERMINATE_FOR_SUSPENDED_PROVIDER_SWITCH = "Auto Terminate for Suspended Provider_true_(//input[@aria-label='Enable Auto Terminate Switch'])[2]";
    private static final String SECURITY_POLICY_PERIOD_AFTER_SUSPEND_PROVIDER = "Period After which suspended Providers will be terminated_60_//div//span[contains(text(),'Period After which suspended Providers will be terminated')]//following::div/span[1]";
    private static final String SECURITY_POLICY_FIRST_NOTIFICATION = "1st Notification Reminder sent prior to termination date_45_//div[contains(text(),'1st notification')]/../div[2]/span[1]";
    private static final String SECURITY_POLICY_SECOND_NOTIFICATION = "2nd Notification Reminder sent prior to termination date_30_//div[contains(text(),'2nd notification')]/../div[2]/span[1]";
    private static final String SECURITY_POLICY_THIRD_NOTIFICATION = "3rd Notification Reminder sent prior to termination date_7_//div[contains(text(),'3rd notification')]/../div[2]/span[1]";
    private static final String SECURITY_POLICY_REGULAR_USER_TEXT = "Regular Users_8_//input[@aria-label='Regular User Password Length']";
    private static final String SECURITY_POLICY_PRIVILEGED_USER_TEXT = "Privileged Users_8_//input[@aria-label='Privileged user Password Length']";
    private static final String SECURITY_POLICY_USER_ACCOUNT_NAME_CHECKBOX = "Must not contain the user's account_true_//input[@aria-label='User Account Name']";
    private static final String SECURITY_POLICY_UPPER_CASE_LETTER_CHECKBOX = "Require at least one uppercase letter_true_//input[@aria-label='Uppercase Letter']";
    private static final String SECURITY_POLICY_LOWERCASE_LETTER_CHECKBOX = "Require at least one lowercase letter_true_//input[@aria-label='Lowercase Letter']";
    private static final String SECURITY_POLICY_NUMBER_CHECKBOX = "Require at least one number_true_//input[@aria-label='Number']";
    private static final String SECURITY_POLICY_SPECIAL_CHARACTER_CHECKBOX = "Require at least one non-alphanumeric or special character_true_//input[@aria-label='Special Character']";
    private static final String SECURITY_POLICY_PASSWORD_REUSE_CHECKBOX = "Password Reuse Checkbox_true_//input[@aria-label='Password Reuse']";
    private static final String SECURITY_POLICY_PREVENT_PASSWORD_REUSE_TEXT = "Prevent Password Reuse_24_//input[@aria-label='Prevent Password Reuse']";
    private static final String SECURITY_POLICY_PASSWORD_RESET_CHECKBOX = "Prevent successive password resets_true_//input[@aria-label='Password Reset']";
    private static final String SECURITY_POLICY_PASSWORD_RESET_TEXT = "After last password change, disable password reset for_12_//input[@aria-label='Password reset']";
    private static final String SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_CHECKBOX = "Enable Password expiration_true_(//input[@aria-label='Enable Password Expiration'])[1]";
    private static final String SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_REGULAR_TEXT = "Enable Password Expiration for Regular Users_90_(//input[@aria-label='Enable Password Expiration'])[2]";
    private static final String SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_PRIVILEGED_TEXT = "Enable Password Expiration for Privileged Users_90_//input[@aria-label='Password Expiration Privileged']";
    private static final String SECURITY_POLICY_ENABLE_TEMPORARY_PASSWORD_EXPIRATION_CHECKBOX = "Enable Temporary Password Expiration_true_(//input[@aria-label='Enable Temporary Password Expiration'])[1]";
    private static final String SECURITY_POLICY_ENABLE_TEMPORARY_PASSWORD_EXPIRATION_TEXT = "Temporary Password expiration period_30_(//input[@aria-label='Enable Temporary Password Expiration'])[2]";
    private static final String SECURITY_POLICY_PRIVILEGED_LOCK_CHECKBOX = "Enable account lock for failed login attempts_true_(//input[@aria-label='Lock'])[1]";
    private static final String SECURITY_POLICY_PRIVILEGED_LOCK_TEXT = "Enable account lock for failed login attempts count_10_(//input[@aria-label='Lock'])[2]";
    private static final String SECURITY_POLICY_ACCOUNT_LOCKOUT_PERIOD_TEXT = "Account Lockout Period_20_//input[@aria-label='Account Lockout Period']";
    private static final String SECURITY_POLICY_CAPTCHA_SWITCH = "Enable Captcha Verification_true_//input[@aria-label='Recaptcha verification']";
    private static final String SECURITY_POLICY_MFA_SWITCH = "Enable Multi-Factor Authentication_false_//input[@aria-label='Multi-Factor Authentication']";

    /**
     * This method verifies the Security Policy System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifySecurityPolicySO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Security Policy Configuration");
        Reports.log("********************************************************");

        for (ArrayList<String> strings : parameterList) {

            //Retrieve Configuration and expected value from the ArrayList
            String configurationString = String.valueOf(strings.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            configurationNameParse = configurationStringParts[0];
            expectedValueParse = configurationStringParts[1];
            xpathParse = configurationStringParts[2];

            //Execute configuration verification cases
            switch (configurationString) {
                case SECURITY_POLICY_LOGOUT_SWITCH:
                case SECURITY_POLICY_ENABLE_AUTO_TERMINATE_SWITCH:
                case SECURITY_POLICY_AUTO_TERMINATE_FOR_SUSPENDED_PROVIDER_SWITCH:
                case SECURITY_POLICY_USER_ACCOUNT_NAME_CHECKBOX:
                case SECURITY_POLICY_UPPER_CASE_LETTER_CHECKBOX:
                case SECURITY_POLICY_LOWERCASE_LETTER_CHECKBOX:
                case SECURITY_POLICY_NUMBER_CHECKBOX:
                case SECURITY_POLICY_SPECIAL_CHARACTER_CHECKBOX:
                case SECURITY_POLICY_PASSWORD_REUSE_CHECKBOX:
                case SECURITY_POLICY_PASSWORD_RESET_CHECKBOX:
                case SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_CHECKBOX:
                case SECURITY_POLICY_ENABLE_TEMPORARY_PASSWORD_EXPIRATION_CHECKBOX:
                case SECURITY_POLICY_PRIVILEGED_LOCK_CHECKBOX:
                case SECURITY_POLICY_CAPTCHA_SWITCH:
                case SECURITY_POLICY_MFA_SWITCH:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case SECURITY_POLICY_LOGOUT_DAYS:
                case SECURITY_POLICY_REGULAR_USER_TEXT:
                case SECURITY_POLICY_PRIVILEGED_USER_TEXT:
                case SECURITY_POLICY_PREVENT_PASSWORD_REUSE_TEXT:
                case SECURITY_POLICY_PASSWORD_RESET_TEXT:
                case SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_REGULAR_TEXT:
                case SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_PRIVILEGED_TEXT:
                case SECURITY_POLICY_ENABLE_TEMPORARY_PASSWORD_EXPIRATION_TEXT:
                case SECURITY_POLICY_PRIVILEGED_LOCK_TEXT:
                case SECURITY_POLICY_ACCOUNT_LOCKOUT_PERIOD_TEXT:
                    stringTextCompareWithAttribute(driver, xpathParse, ATTRIBUTE_VALUE, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case SECURITY_POLICY_PERIOD_AFTER_SUSPEND_PROVIDER:
                case SECURITY_POLICY_FIRST_NOTIFICATION:
                case SECURITY_POLICY_SECOND_NOTIFICATION:
                case SECURITY_POLICY_THIRD_NOTIFICATION:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }
    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyScreeningSystemOptions()
     *
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildParameterList () {
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_LOGOUT_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_LOGOUT_DAYS)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ENABLE_AUTO_TERMINATE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_AUTO_TERMINATE_FOR_SUSPENDED_PROVIDER_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PERIOD_AFTER_SUSPEND_PROVIDER)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_FIRST_NOTIFICATION)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_SECOND_NOTIFICATION)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_THIRD_NOTIFICATION)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_REGULAR_USER_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PRIVILEGED_USER_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_USER_ACCOUNT_NAME_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_UPPER_CASE_LETTER_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_LOWERCASE_LETTER_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_NUMBER_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_SPECIAL_CHARACTER_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PASSWORD_REUSE_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PREVENT_PASSWORD_REUSE_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PASSWORD_RESET_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PASSWORD_RESET_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_REGULAR_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ENABLE_PASSWORD_EXPIRATION_PRIVILEGED_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ENABLE_TEMPORARY_PASSWORD_EXPIRATION_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ENABLE_TEMPORARY_PASSWORD_EXPIRATION_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PRIVILEGED_LOCK_CHECKBOX)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_PRIVILEGED_LOCK_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_ACCOUNT_LOCKOUT_PERIOD_TEXT)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_CAPTCHA_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(SECURITY_POLICY_MFA_SWITCH)));
        return parameterList;
    }
}

