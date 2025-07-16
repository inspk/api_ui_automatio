package com.hhstechgroup.constant;

import org.openqa.selenium.By;

/**
 * sdSystemOptionsConstants class contains all the Constants for all Tests under the configuration Regression,
 * under - com.hhstechgroup.tests.SouthDakota.configurationRegression
 */

public class SDConfigurationConstants {

    //****************************************************************************************************
    //***************************************  Configuration Constants ***********************************
    //****************************************************************************************************

    //****************************************************************************************************
    // TEXT OF BUTTONS
    public static final String TEXT_CANCEL = "Cancel";
    public static final String TEXT_OK = "OK";
    public static final String TITLE_EXIT = "Exit";
    public static final String titleBack = "Back to";
    public static final String titleArrowBackTo = "← Back to list";

    //****************************************************************************************************
    // ANY TITLE
    public static final String h1 = "h1";
    public static final String h2 = "h2";
    public static final String h3 = "h3";
    public static final String h4 = "h4";
    public static final String h6 = "h6";

    //System Options - Security Policy

    //****************************************************************************************************
    //System Options - Affiliations

    public static final String TITLE_AFFILIATIONS = "Affiliations";
    public static final String AFFILIATIONS_TITLE_XPATH = "//h4[contains(text(),'Affiliations')]";

    public static final String LINK_AFFILIATIONS = "/system/affiliations";

    //****************************************************************************************************
    //System Options - Approvals
    public static final String TITLE_APPROVALS = "Approvals";
    public static final String APPROVALS_TITLE_XPATH = "//h4[contains(text(),'Approvals')]";
    public static final String LINK_APPROVALS = "/system/approvals-type";

    //****************************************************************************************************
    //System Options - Auto Archive

    //****************************************************************************************************
    //System Options - Custom Sections
    public static final String TITLE_CUSTOM_SECTIONS = "Custom Sections";
    public static final String CUSTOM_SECTIONS_TITLE_XPATH = "//h4[contains(text(),'Custom Sections')]";
    public static final String LINK_CUSTOM_SECTIONS = "/system/custom-sections";

    //****************************************************************************************************
    //System Options - Data Change

    public static final String TITLE_DATA_CHANGE = "Data Change";
    public static final String LINK_DATA_CHANGE_ACTIONS = "/system/data-change-actions";
    public static final String DATA_CHANGE_TITLE_XPATH = "//div[contains(text(),'Actions on data change')]";
    public static final By ROW_DATA_CHANGE = By.xpath("//div[contains(@class, 'data-change-settings_actions-row')]");
    public static final By DATA_CHANGE_SLIDER = By.xpath("//label[contains(@class, 'settings_action-trigger')]//span//input");

    //****************************************************************************************************
    //System Options - Duplicity
    public static final String TITLE_DUPLICITY = "Duplicity";
    public static final String DUPLICITY_TITLE_XPATH = "//div[contains(text(),'Duplicity')]/../h4";
    public static final String LINK_DUPLICITY = "/system/duplicity";


    //****************************************************************************************************
    //System Options - Enrollment Type
    public static final String TITLE_ENROLLMENT_TYPES = "Enrollment Types";
    public static final String ENROLLMENT_TYPES_TITLE_XPATH = "//h4[contains(text(),'Enrollment types')]";
    public static final String LINK_ENROLLMENT_TYPES = "/system/enrollment-types";

    //****************************************************************************************************
    //System Options - Externalization

    //****************************************************************************************************
    //System Options - Licensure
    public static final String TITLE_LICENSURE = "Licensure";
    public static final String LINK_lICENSURE = "system/licensure";
    public static final String LICENSURE_TITLE_XPATH= "//div[contains(text(),'Licensure')]";

    //****************************************************************************************************
    //System Options - Notification Engine
    public static final String TITLE_NOTIFICATION_ENGINE = "Notification Engine";
    public static final String NOTIFICATION_TITLE_XPATH = "//h4[contains(text(),'Notification')]";
    public static final String LINK_NOTIFICATION = "/system/notification-Engine-actions";

    //****************************************************************************************************
    //System Options - Payment and Fees
    public static final String TITLE_PAYMENTS_FEES = "Payments & Fees";
    public static final String PAYMENT_FEES_TILE_XPATH = "//div[contains(text(),'Payments and Fees Configuration')]";

    public static final String LINK_PAYMENT_FEES = "/system/paymentsandfees";

    //****************************************************************************************************
    //System Options - Reminders to reviewers
    public static final String TITLE_REMINDERS_TO_REVIEWERS = "Reminders to Reviewers";
    public static final String REMINDERS_TO_REVIEWERS_TITLE_XPATH= "//p[contains(text(),'Reminders to Reviewers')]";
    public static final String LINK_REMINDERS_TO_REVIEWERS = "system/reminders-to-reviewers";

    //****************************************************************************************************
    //System Options - Request additional information
    public static final String TITLE_REQUEST_ADDITIONAL_INFO = "Request additional Information";
    public static final String REQUEST_ADDITIONAL_INFORMATION_TITLE_XPATH= "//div[contains(text(),'Additional Information Reminders')]";
    public static final String LINK_REQUEST_ADDITIONAL_INFO = "system/requestaddionalInfo";

    //****************************************************************************************************
    //System Options - Revalidation
    public static final String TITLE_REVALIDATION = "Revalidation";
    public static final String REVALIDATION_TITLE_XPATH = "//div[contains(text(),'Revalidation')]";
    public static final String LINK_REVALIDATION= "/system/revalidation";

    //****************************************************************************************************
    //System Options - Roles
    public static final String TITLE_ROLES = "Roles";
    public static final String ROLES_TITLE_XPATH = "//div[contains(text(),'Role Management')]";
    public static final String LINK_ROLES = "/system/roles";

    //****************************************************************************************************
    //System Options - Rules

    //****************************************************************************************************
    //System Options - Screening
    public static final String TITLE_SCREENING = "Screening";
    public static final String SCREENING_TITLE_XPATH = "//h4[contains(text(),'Screening')]";
    public static final String LINK_SCREENING = "/system/screening";

    //****************************************************************************************************
    //System Options - Security Policy

    public static final String TITLE_SECURITY_POLICY = "Security Policy";
    public static final String TITLE_SECURITY_POLICY_XPATH = "//h4[contains(text(),'Security Policy')]";
    public static final String LINK_SECURITY_POLICY = "/system/passwordpolicy";
    //****************************************************************************************************
    //System Options - Site Visits
    public static final String TITLE_SITE_VISIT = "Site Visit";
    public static final String SYSTEM_OPTION_TITLE_SITE_VISIT_XPATH = "//pre[contains(text(),'Site Visit')]";
    public static final String LINK_SITE_VISIT = "system/site-visit";
    //****************************************************************************************************
    //System Options - User Deactivation
    public static final String TITLE_USER_DEACTIVATION = "User Deactivation";
    public static final String USER_DEACTIVATION_TITLE_XPATH = "//div[text() = 'User Inactivity']";
    public static final String LINK_USER_DEACTIVATION = "/system/userdeactivation";
    //****************************************************************************************************
    //System Options - User Profile
    public static final String TITLE_USER_PROFILE = "User Profile";
    public static final String USER_PROFILE_EXPECTED_SWITCH_VALUE = "true";
    public static final int USER_PROFILE_EXPECTED_DAYS_VALUE = 1;
    public static final String USER_PROFILE_TITLE_XPATH= "//div[text()='User Profile Configuration']";
    public static final String LINK_USER_PROFILE = "system/userprofile";

    private SDConfigurationConstants() {
    }

}
