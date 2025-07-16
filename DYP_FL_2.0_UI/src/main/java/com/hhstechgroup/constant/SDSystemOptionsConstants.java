package com.hhstechgroup.constant;

import org.openqa.selenium.By;

/**
 * sdSystemOptionsConstants class contains all the Constants for SystemOptions.java, under - com.hhstechgroup.Pages
 */
public class SDSystemOptionsConstants {
    //****************************************************************************************************
    //***********************************  System Options Constants **************************************
    //****************************************************************************************************

    //****************************************************************************************************
    //SYSTEM OPTION TITLES
    public static final String SYSTEM_OPTION_TITLE_USERS = "Users";
    public static final String SYSTEM_OPTION_TITLE_RULES = "Rules";
    public static final String SYSTEM_OPTION_TITLE_AUTO_ASSIGN = "Auto Assign";
    public static final String SYSTEM_OPTION_TITLE_AUTO_ARCHIVE = "Auto Archive";
    public static final String SYSTEM_OPTION_TITLE_APPROVALS = "Approvals";
    public static final String SYSTEM_OPTION_TITLE_EXTERNALIZATION = "Externalization";

    //****************************************************************************************************
    // TEXT OF BUTTONS
    public static final String TEXT_CANCEL = "Cancel";
    public static final String TEXT_OK = "OK";
    public static final String TITLE_EXIT = "Exit";

    //****************************************************************************************************
    // ANY TITLE
    public static final String h1 = "h1";
    public static final String h2 = "h2";
    public static final String h3 = "h3";
    public static final String h4 = "h4";
    public static final String h6 = "h6";

    //****************************************************************************************************
    //SystemOptions Links
    public static final String LINK_USERS = "/system/users";
    public static final String LINK_RULE_EDITOR = "/system/rule-editor";
    public static final String LINK_AUTO_ASSIGN_RULES = "/system/auto-assign-rules";
    public static final String LINK_RULES = "/system/rules";
    public static final String LINK_DUPLICITY = "/system/duplicity";
    public static final String LINK_NOTIFICATION_ENGINE = "/system/notification-Engine-actions";
    public static final String LINK_APPROVALS_TYPE = "/system/approvals-type";
    public static final String LINK_APPROVALS_INDIVIDUAL = "/system/approvals/individual";
    public static final String LINK_APPROVALS_GROUP = "/system/approvals/group";
    public static final String LINK_APPROVALS_PHARMACY = "/system/approvals/pharmacy";
    public static final String LINK_APPROVALS_ORP = "/system/approvals/ORP";
    public static final String LINK_APPROVALS_PEM = "/system/approvals/PEM";
    public static final String LINK_APPROVALS_FACILITY = "/system/approvals/facility";

    public static final String LINK_APPROVALS_REQUEST = "/system/approval/request";
    public static final String LINK_ERROR_MESSAGES = "/system/error-message-dropdowns";
    public static final String LINK_AUTOARCHIVE = "/system/autoarchive";

    //USER PROFILE
    public static final String LINK_USER_PROFILE = "/system/userprofile";
    public static final By USERPROFILE_EDIT_BUTTON = By.xpath("//div[contains(@class , 'styles_control')]//span[contains(text(), 'Edit')]");
    public static final By USERPROFILE_USER_PROFILE_UPDATE_SWITCH = By.xpath("//input[@aria-label='User Profile Update']");
    public static final By USERPROFILE_DAYS = By.xpath("//div/input[contains(@aria-label, 'Days')]");

    //Site visit
    public static final By SITE_VISIT_BASED_ON_TAXONOMY_RADIO_BTN = By.xpath("//input[@value='basedOnTaxonomy']");
    public static final By SITE_VISIT_BASED_ON_SCREENING_SCORE_RADIO_BTN = By.xpath("//input[@value='basedOnScreeningScore']");
    public static final By SITE_VISIT_BASED_ON_HIGHER_RISK_LEVELS_RADIO_BTN = By.xpath("//input[@value='higherOftheTwoRiskLevels']");
    public static final By SITE_VISIT_BASED_ON_INSTATE_PROVIDER_RADIO_BTN = By.xpath("//input[@value='instate']");
    public static final By SITE_VISIT_BASED_ON_OUTSTATE_PROVIDER_RADIO_BTN = By.xpath("//input[@value='outstate']");
    public static final By SITE_VISIT_BASED_ON_BOTH_PROVIDER_RADIO_BTN = By.xpath("//input[@value='both']");


    //Notification Engine
    public static final By NOTIFICATION_ENGINE_LIST =By.xpath("//div[contains(@class, 'notification-engine_actions-row')]");
    public static final By NOTIFICATION_ENGINE_INFO_TYPE = By.xpath("//div[contains(@class, 'notification-engine_actions-key')]");
    public static final By NOTIFICATION_ENGINE_MESSAGE_CENTER = By.xpath("//div[contains(@class, 'notification-engine_actions-values')]/label[1]");
    public static final By NOTIFICATION_ENGINE_EMAIL = By.xpath("//div[contains(@class, 'notification-engine_actions-values')]/label[2]");

    //LICENSURE

    public static final By EDIT_BUTTON = By.xpath("//button[contains(.,'Edit')]");

    }
