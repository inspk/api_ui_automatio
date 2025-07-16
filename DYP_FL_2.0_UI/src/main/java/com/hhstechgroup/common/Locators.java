package com.hhstechgroup.common;

import org.openqa.selenium.By;

/**
 * Locators class contains all the locators in DYP application through multiple ways of locating an element such as xpath, cssSelector.
 */
public class Locators {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SD Locators~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static final By LINK_TEXT_CREATE_ACCOUNT = By.xpath("//a[contains(.,'Create Account')]");
    public static final By TEXT_INPUT_USERNAME = By.xpath("//input[@id='username']");
    public static final By TEXT_INPUT_PASSWORD = By.xpath("//input[@id='password']");
    //public static final By  LINK_TEXT_FORGOT_PASSWORD = By.xpath("//a[@href='/reset-password'][contains(.,'Forgot password?')]");
    public static final By TEXT_INPUT_EMAIL = By.xpath("//input[@id='email']");
    public static final By TEXT_FIELD_PASSWORD = By.xpath("//input[@id='password']");
    public static final By BUTTON_CONTINUE = By.xpath("//button[@type='button'][contains(.,'CONTINUE')]");
    public static final By BUTTON_CREATE_ACCOUNT = By.xpath("//button[contains(.,'CREATE ACCOUNT')]");

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Wyoming Locators~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // com.hhstechgroup.common.HomePage
    public static final By TEXT_FIELD_USERNAME = By.cssSelector("input#username");
    public static final By TEXT_FIELD_PASSWORD_LOGIN = By.xpath("//div[contains(@class, 'login')]//input[@autocomplete='current-password']");
    public static final By  LINK_TEXT_FORGOT_PASSWORD = By.xpath("//a[@href='/reset-password'][contains(.,'Forgot password?')]");
    public static final By TEXT_FIELD_PASSWORD_REGISTRATION = By.xpath("//div[contains(@class, 'registration_registration')]//input[@autocomplete='current-password']");
    public static final By BUTTON_REGISTRATION = By.xpath("//div[contains(@class, 'registration_registration')]//span[text() = 'Register']");
   // public static final By ERROR_ALERT_DIALOG_MESSAGE = By.xpath("//span[contains(.,'Incorrect email address or password')]");

    //Reset Password
    public static final By TEXT_FIELD_RESET_EMAIL = By.xpath("//input[@id='email']");
    public static final By BUTTON_RESET_PASSWORD= By.xpath("//span[contains(.,'Reset Password')]");

    public static final By TEXT_FIELD_NEW_PASSWORD = By.xpath("//input[@id='newPassword']");
    public static final By TEXT_FIELD_COMPARE_PASSWORD = By.xpath("//input[@id='newPasswordToCompare']");
    public static final By BUTTON_CHANGE_PASSWORD = By.xpath("//button[@type='submit']");
    public static final By BUTTON_PWD_RESET_SUCCESSFUL_BACKTOLOGIN = By.xpath("//span[contains(.,'BACK TO LOG IN')]");

    public static final By ERROR_ALERT_DIALOG_MESSAGE = By.xpath("//div[@role='alertdialog']//div[1]//span");
    public static final By ERROR_MESSAGE_FOR_INVALID_CREDENTIALS= By.xpath("//div[starts-with(@class,'utils_field-errors_')]//div");

    // REGISTRATION
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_VALIDATE_PASSWORD = By.cssSelector("input#passwordToCompare");
    public static final By TEXT_FIELD_ORG_NAME = By.cssSelector("input#orgName");
    public static final By TEXT_FIELD_FIRST_NAME = By.cssSelector("input#firstName");
    public static final By TEXT_FIELD_LAST_NAME = By.cssSelector("input#lastName");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input#phone");
    public static final By SECTION_IDENTIFYING_INFORMATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Identifying Information']");
    public static final By SECTION_SUMMARY = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Summary']");
    // public static final By SECTION_PAYMENT = By.xpath("//span[text()='Payment']/..//../div[contains(@class, 'menu')]");
    public static final By SECTION_PAYMENT = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Payment']");
    public static final By SECTION_PAYMENT_RED = By.xpath("//div[@data-for='Payment']//div[contains(@class, 'menu_red')]");
    public static final By SECTION_TAXONOMY = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), 'Taxonomy')]");
    public static final By SECTION_PROVIDER_IDENTIFIER_NUMBER = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider Identifier Number']");
    public static final By SECTION_PROVIDER_IDENTIFIER_NUMBER_GROUP = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider identifier number']");

    public static final By SECTION_PROVIDER_IDENTIFIERS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider Identifiers']");
    public static final By SECTION_PROVIDER_ADDRESS_DETAILS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Address Details']");
    public static final By SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Primary Service Location Information']");
    public static final By SECTION_PROVIDER_SECONDARY_SERVICE_LOCATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Secondary Service Location Information']");
    public static final By SECTION_PROVIDER_KEY_PERSONNEL = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Key Personnel']");
    public static final By SECTION_PROVIDER_OWNERSHIP = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Ownership']");
    public static final By SECTION_PROVIDER_EXCLUSION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Exclusion/Sanction Information']");
    public static final By SECTION_PROVIDER_AUTHORIZED_SIGNATURE = By.xpath("//span[text()='Authorized Signature']/..//../div[contains(@class, 'menu')]");
    public static final By SECTION_PROVIDER_PROVIDER_AGREEMENT = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider Agreement']");
    public static final By SECTION_UPLOAD_DOCUMENTS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Upload Documents']");
    public static final By INPUT_UPLOAD_DOCUMENTS = By.xpath(".//input[@type=\'file\']");
    public static final By LINK_DASHBOARD = By.xpath("//a[@href='/dashboard']");
    public static final By BUTTON_BACKTOLOGIN = By.xpath("//span[contains(@class, 'jss136')]");
    public static final By ENROLLMENT_FEE = By.xpath("//div[contains(@class, 'section_section-header')]//b");

    public static final By SECTION_COMMUNICATION_PREFRENCES = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Communication Preference']");
    public static final By SECTION_AFFILIATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Affiliation']");
    public static final By TABLE_AFFILIATION = By.xpath("//div[contains(@class, 'affiliation_table')]");
    public static final By SECTION_REQUEST_RETROACTIVE_ADJUSTMENT = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Request Retroactive Adjustment']");
    public static final By JUSTIFICATION_REQUEST_RETROACTIVE_ADJUSTMENT = By.xpath("//input[contains(@id,'Justification for Retroactive Request')]");
    public static final By CALANDER_REQUEST_RETROACTIVE_ADJUSTMENT = By.xpath("//input[@name='datepicker']");


    public static final By SECTION_TRAINING_REQUIRED =
            By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Training Required']");
    public static final By HEADING_AUTHORIZED_SIGNATURE = By.xpath("//h4[text()='Authorized Signature']");

    //CONTACT PERSON//div[contains(@class, 'section_section-header')]//b
    public static final By TEXT_FIELD_CONTACT_FIRST_NAME = By.xpath("//input[contains(@id, 'First Name')]");
    public static final By TEXT_FIELD_CONTACT_LAST_NAME = By.xpath("//input[contains(@id, 'Last Name')]");
    public static final By TEXT_FIELD_CONTACT_PHONE = By.xpath("//div[@data-for='Phone']//input[contains(@placeholder, '(___)___-____')]");
    public static final By TEXT_FIELD_CONTACT_PERSON_EMAIL = By.xpath("//input[contains(@id, 'Email')]");


    //SERVICE LOCATION
    public static final By TEXT_FIELD_SERVICE_LOCATION_ADDRESS_LINE1 = By.xpath("//input[contains(@id, 'Service Location Address Line 1')]");
    public static final By TEXT_FIELD_SERVICE_LOCATION_ZIP = By.xpath("//div[contains(@data-for, 'Service Location ZIP')]//input");
    public static final By TEXT_FIELD_SERVICE_LOCATION_COUNTY_CODE = By.xpath("//div[@data-for='Primary Service Location County Code']//input");
    public static final By DROP_DOWN_PRIMARY_SERVICE_LOCATION_STATE = By.xpath("//label[text()='Primary Service Location State']//ancestor::div[@role='combobox']//input");

    //SECONDARY SERVICE LOCATION
    public static final By TEXT_FIELD_FIRST_NAME_ENROLLMENT = By.xpath("//input[contains(@id, 'First Name')]");
    public static final By TEXT_FIELD_LAST_NAME_ENROLLMENT = By.xpath("//input[contains(@id, 'Last Name')]");

    //AUTHORIZED SIGNATURE
    public static final By TEXT_FIELD_TITLE_OF_PERSON = By.xpath("//input[contains(@id, 'Title of person')]");
    public static final By TEXT_FIELD_NAME_OF_AUTHORIZED = By.xpath("//input[contains(@id, 'Name of Authorized')]");

    // PAYMENT
    public static final By BUTTON_GO_TO_PAYMENT = By.xpath("//span[contains(.,'Go To Payment')]");


    public static final By TEXT_FIELD_BILLING_EMAIL = By.xpath("//span//input[@id='email']");
    public static final By TEXT_FIELD_BILLING_ZIP = By.xpath("//span//input[@id='billingPostalCode']");
    public static final By TEXT_FIELD_CARD_NUMBER = By.xpath("//span//input[@id='cardNumber']");
    public static final By TEXT_FIELD_CVC = By.xpath("//span//input[@id='cardCvc']");
    public static final By TEXT_FIELD_EXPIRATION_DATE = By.xpath("//span//input[@id='cardExpiry']");
    public static final By TEXT_FIELD_FULL_NAME_ON_CARD = By.xpath("//span//input[@id='billingName']");
    public static final By BUTTON_SUBMIT_CREDIT_CARD = By.xpath("//div[@class='SubmitButton-IconContainer']");


    // MainPage (internal user)
    public static final By ANY_HEADER_MAIN_TAB =
            By.xpath("//div[contains(@class, 'header_header')]//ul/li/a");
    public static final By HELPTOUR_USER =
            By.xpath(".//div[contains(@class, 'header_user_')]/div");
    //  public static final By PART_OF_ENROLLMENT_INFO  = By.xpath("//p[@class='sc-kEYyzF kBaplW']");
    public static final By PART_OF_ENROLLMENT_INFO =
            By.xpath("//div[contains(@class, 'tile-table-column')]//p");
    public static final By PART_OF_ENROLLMENT_INFO_STATUS =By.xpath("(//div[contains(@class, 'tile-table-column')]//p)[4]");
    public static final By PART_OF_ENROLLMENT_PENDING_REVIEW =
            By.xpath("//div[contains(@class, 'tile-table-column')]//p[contains(text(), 'PENDING REVIEW')]");

    public static final By ENROLLMENT_ROW = By.xpath("//div[@class='sc-hrWEMg bQMpRx']");
    public static final By HELPCENTER_TITLE = By.xpath("//a[@title='Help Center']");
    //UPDATED on 8/17 per new configuration from Sprint 20.
    public static final By BACK_TO_PROVIDER_PORTAL = By.xpath("//a[text()='Back to Provider portal']");
    public static final By CSDN_IFRAME = By.xpath("//iframe[@title='C-SDN']");
    public static final By BUTTON_ADANCED = By.xpath("//label[@for='search-input']//button");
    public static final By SPAN_IN_TABLE = By.xpath("//table//td//span");

    // On many pages
//  public static final By ANY_MAIN_TITLE = By.xpath("//div[contains(@class, 'sc-gJWqzi kAqiOe')]");
    public static final By ANY_MAIN_TITLE = By.xpath("//div[contains(@class, 'root_content')]"); // Root content
    public static final By REPORTS_TITLE = By.xpath("//div[contains(text(),'Reports')]");
    public static final By VOTING_TITLE = By.xpath("//div[contains(text(),'Voting requests')]");
    public static final By DOCUMENTS_TITLE = By.cssSelector("input#search-input");
    public static final By TEXT_FIELD_PROVIDER_NAME = By.cssSelector("input#providerName");
    public static final By TEXT_FIELD_PROVIDER_ID = By.xpath("//input[@id='ProviderID']");
    public static final By TEXT_FIELD_REQUEST_ID = By.xpath("//input[@id='RequestID']");
            //By.xpath("input#RequestID");
            // By.cssSelector("input#ProviderID");
    public static final By TEXT_FIELD_USER_NAME = By.cssSelector("input#userName");
    public static final By TEXT_FIELD_PAYMENT_ID = By.cssSelector("input#paymentId");
    public static final By TEXT_FIELD_TCN = By.cssSelector("input#tcn");
    public static final By TEXT_FIELD_PROVIDER_ID_1099 = By.cssSelector("input#providerId");
    public static final By TITLE_H1 = By.xpath("//h1");
    public static final By SPAN_ICON = By.xpath("//span//i");
    public static final By BUTTON_SEARCH = By.xpath("//button[contains(@class, 'search-box-action')]");
    public static final By POP_UP_DOCUMENT = By.xpath("(//div[@role='dialog'])[2]");
    public static final By TEXT_FIELD_ENROLLMENT_Type= By.xpath("//label[contains(text(),'Enrollment type')]");


    // ENROLLMENTS

    public static final By BUTTON_MORE_MENU = By.xpath("//button[@aria-label='More']");
    public static final By BUTTON_MORE = By.xpath("//svg[@aria-hidden='true']");

    public static final By POPUP_INNER_ENROLLMENT_STATUS = By.xpath("//div[contains(@class, 'requests_popup-inner')]");
    public static final By POPUP_CHANGE_STATUS = By.xpath("(//div[@role='button'])[2]");

    public static final By POPUP_PENDING_REVIEW_REASON = By.xpath("(//div[@role='button'])[2]");
 //   public static final By POPUP_PENDING_REVIEW_REASON = By.xpath("//div[@role='button']");


    public static final By POPUP_PENDING_REVIEW_NOTES = By.xpath("//textarea[@type='text']");
    public static final By PENDING_REVIEW_BUTTON = By.xpath("//span[contains(text() ,'Approve')]/..");
    public static final By APPROVE_BUTTON = By.xpath("//span[contains(text() ,'Approve')]//ancestor::button");
    public static final By APPROVE_BUTTON_REASON = By.xpath("(//span[contains(text() ,'Approve')]//ancestor::button)[2]");

    public static final By OPTION_PENDING_APPROVAL = By.xpath("//div[text()='Pending approval']");
    public static final By OPTION_PENDING_REVIEW = By.xpath("//div[text()='Pending Review']");
    public static final By REQUEST_TERMINATION_NOTE = By.xpath("//textarea[3]");
    public static final By REQUEST_TERMINATION_FROM_DATE = By.xpath("//input[@name='datepicker']");


    //option
    // public static final By POPUP_SITEVISIT_REASON = By.xpath("//label[contains(text(), 'Reason')]/..//../div[contains(@role,'button')]");
    public static final By ADDAffiliation_ENROLLPROVIDER_BUTTON = By.xpath("//span[contains(.,'+ Enroll Provider')]");
    public static final By PEMAFFILIATION_BACKTODASHBOARD_BUTTON = By.xpath("//*[@id='root']/div/div[2]/div/div[1]/span[3]/a");

    public static final By PROVIDERINFO_POPUP_Email = By.xpath("(//textarea[@type='text'])[1]");
    public static final By PROVIDERINFO_POPUP_FirstName = By.xpath("(//textarea[@type='text'])[2]");
    public static final By PROVIDERINFO_POPUP_LastName = By.xpath("(//textarea[@type='text'])[3]");
    public static final By PROVIDERINFO_POPUP_ProceedButton = By.xpath("//button[contains(.,'Proceed')]");


    // SITE VISITS

    public static final By BUTTON_SITEVISIT =By.xpath("//span[contains(.,'Site visit')]") ;
    public static final By BUTTON_CREATE_SITEVISIT_POPUP = By.xpath("//span[contains(.,'Create')]");
    public static final By TEXTBOX_POPUP_CREATESITEVISIT_PROVIDERID=By.xpath("//input[@id='provider']");
    public static final By BUTTON_APPROVE_REASON = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");
    public static final By POPUP_IS_PAYMENT_RECEIVED = By.xpath("//input[contains(@name, 'paymentVerification')]");
    public static final By POPUP_SITEVISIT_DATE =By.xpath("//input[@name='datepicker']");
  //  public static final By POPUP_SITEVISIT_REASON = By.xpath("(//div[contains(@tabindex,'0')])[3]");
    public static final By POPUP_SITEVISIT_REASON = By.xpath("(//div[contains(@role,'button')])[2]");
    public static final By POPUP_Waive_SITEVISIT_REASON = By.xpath("(//div[contains(@role,'button')])[6]");
    public static final By TEXT_FIELD_PROVIDER_SITE_VISITS = By.cssSelector("input#ProviderSiteVisit");
    public static final By TABLETITLE_SCHEDULEDATE_SORTBUTTON = By.xpath("//span[contains(.,'Scheduled Date')]");
    public static final By ELLIPSE_BUTTON = By.xpath("//div[contains(@class, 'tile-table-body')]//button[@aria-label='More']");
    public static final By SELECT_APPEAL_OPTION = By.xpath("(//li[@role='menuitem'])[3]");
    public static final By APPLYBUTTON_WAVIE_POPUP = By.xpath("//button[contains(.,'Apply')]");
    public static final By OK_BUTTON_CONFIRMATION_POPUP = By.xpath("//button[contains(.,'OK')]");
    public static final By SELECT_WAVIE_OPTION = By.xpath("(//li[@role='menuitem'])[4]");
    public static final By SELECT_VIEW_OPTION = By.xpath("(//li[@role='menuitem'])[1]");
    public static final By BUTTON_NEXT_PROVIDERDETAILS = By.xpath("(//span[contains(.,'Next')])");
    public static final By BUTTON_UPLOAD_DOCUMNETS_APPLICATION = By.xpath("(//span[contains(.,'Upload Documents')])[2]");

    //Dashboard
    public static final By PROVIDER_DASHBOARD_STATUS =  By.xpath("//span[contains(.,'Status')]//following::div") ;
    public static final By PROVIDER_DASHBOARD_APPEAL_BUTTON =  By.xpath("//span[contains(.,'Appeal')]") ;
    public static final By PROVIDER_DASHBOARD_REENROLLMENT_APPLICATION_BUTTON =  By.xpath("//button[contains(.,'RE-ENROLLMENT APPLICATION')]") ;

    // Provider side Enrollment info
    public static final By ENROLLMENT_INFO_STATUS =  By.xpath("//span[contains(.,'Status:')]//following::span[1]") ;

    public static final By PROVIDER_ENROLLMENT_STATUS =  By.xpath("//span[contains(.,'Status:')]//following::span") ;
    public static final By PROVIDER_TRACKING_NUMBER =  By.xpath("//span[contains(.,'Tracking number')]//following::div") ;
    public static final By PROVIDER_COC_ID =  By.xpath("//div[contains(@class, 'table-text_tooltip')]//p") ;
    public static final String ENROLLMENT_SPAN =  "//span[text()='Enrollment Span']//ancestor::button" ;
    public static final By ENROLLMENT_SPAN_REASON =  By.xpath("(//div[contains(@class, 'table-text_tooltip')]//p)[4]") ;

    // INBOX
    public static final By MESSAGE_INBOX = By.xpath("//a[contains(@href, '/inbox')]//button");
    public static final By ONE_MESSAGE = By.xpath("//div[contains(@class, 'helptour_messagebox')]//span[text()='1']");
    public static final By TWO_MESSAGES = By.xpath("//div[contains(@class, 'helptour_messagebox')]//span[text()='2']");
    public static final By PART_OF_ROW_MESSAGE = By.xpath("//div[contains(@class, 'message-center_inner')]");
    public static final By MESSAGE_GROUP_AFFILIATION = By.xpath("//div[contains(@class, 'message-center_inner')]//div[text()='Confirm you affiliation to the group']");
    public static final By MESSAGE_SITE_VISIT = By.xpath("//div[contains(@class, 'message-center_inner')]//div[text()='Sign site visit application']");
    public static final By First_MESSAGE_IN_INBOX = By.xpath("(//div[contains(@class, 'letter-buttons')]//button[@aria-label='More'])[1]");
    public static final By MESSAGE_CONTENT_InBOX = By.xpath("(//div[contains(@class,'message-center')]/following::a)[1]");

    // MY ACCOUNT
    public static final By BLOCK_SYSTEM_INFORMATION_MY_ACCOUNT =
            By.xpath("//div[contains(@class, 'my-account_system')]");

    // SCREENING
    public static final By SCREENING_RANKINS = By.xpath("//div[contains(@class, 'content_content-summary')]");
    public static final By SCREENING_EDIT_BUTTON = By.xpath("//div[contains(@class , 'header_control')]//span[text()='Edit']");
    public static final By SCREENING_PERIODIC_MONITORING_SWITCH = By.xpath("//input[@aria-label='Monitoring Frequency']");
    public static final By SCREENING_MONITORING_FREQUENCY = By.xpath("//h3[contains(.,'Monitoring frequency (every)')]//following::h2/span[1]");
    public static final By DEFAULT_SCREENING_THRESHOLDS = By.xpath("//span[contains(.,'Default Screening Thresholds')]//preceding::input[1]");
    public static final By CUSTOM_SCREENING_THRESHOLDS = By.xpath("//label[contains(.,'Custom Screening Thresholds')]//preceding::input[2]");
    public static final By SCREENING_INDIVIDUAL_PARAM_SSN = By.xpath("//div[contains(.,'SSN (and other improperly associated SSN)')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_LICENSE_EXP= By.xpath("//div[contains(.,'License expired')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_NPI_EXP= By.xpath("//div[contains(.,'NPI is invalid or expired')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_FEIN_EXP= By.xpath("//div[contains(.,'TIN/FEIN is invalid or expired')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_DEATH_INDICATOR= By.xpath("//div[contains(.,'Record found in Death indicators (SSA and other sources)')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_LEIE= By.xpath("//div[contains(.,'Record found in list of Excluded Individuals/Entities (LEIE)')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_EPLS = By.xpath("//div[contains(.,'Record found in Excluded Parties List System (EPLS)')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_DEX = By.xpath("//div[contains(.,'DEX')]/following-sibling::div");
    public static final By SCREENING_INDIVIDUAL_PARAM_DEN_EXP = By.xpath("//div[contains(.,'DEA number is invalid or expired')]/following-sibling::div");

    // DATA CHANGE ACTIONS
    public static final By ROW_DATA_CHANGE = By.xpath("//div[contains(@class, 'data-change-settings_actions-row')]");
    public static final By DATA_CHANGE_SLIDER = By.xpath("//label[contains(@class, 'settings_action-trigger')]//span//input");

    // AUTO ASSIGN
    public static final By AUTO_ASSIGN_No_RULES_Text = By.xpath("//div[starts-with(@class,'auto-assign_empty')]/h3");
  //  public static final By AUTO_ASSIGN_RULES_LIST = By.xpath("//div[starts-with(@class,'auto-assign_aa-list-head')]//div");
    public static final By AUTO_ASSIGN_RULES_LIST = By.xpath("//div[starts-with(@class,'auto-assign_aa-list-itme-inner')]");

    public static final By NEW_RULE_ELLIPSE_BUTTON = By.xpath("//div[starts-with(@class,'auto-assign_aa-list-item')]//following-sibling::div/button[@aria-label='More']");


    public static final By CREATE_RULE_BUTTON = By.xpath("//span[contains(.,'Create rule')]");
    public static final By BACK_TO_lIST_BUTTON = By.xpath("//span[contains(.,'← Back to list')]");
    public static final By CALENDAR = By.xpath("//input[@placeholder='MM/DD/YYYY']");
    public static final By LABEL_APPLICATION_TYPE = By.xpath("//div//label[@text() =‘Select Application Type']");
    public static final By SELECT_APPLICATION_TYPE = By.xpath("//div//label[starts-with(@id,'Select Application Type')]");
    public static final By SELECT_APPLICATION_DROPDOWN = By.xpath("(//div[@role='button'])[1]");
    public static final By SELECT_STATUS_VALUE = By.xpath("//div//label[@id='Status value']");
    public static final By SELECT_ENROLLMENT_TYPE_VALUE = By.xpath("//div//label[@id='Enrollment type value']");
    public static final By SECOND_ENROLLMENT_TYPE_VALUE = By.xpath("(//label[@id='Enrollment type value'])[2]");
    public static final By SELECT_IF_PARAMETER = By.xpath("//div//label[@id='Parameter']");
    public static final By SELECT_OPERATOR = By.xpath("//div//label[@id='Operator']");
    public static final By SELECT_ASSIGN_TO = By.xpath("//div//label[@id='Assign To']");
    public static final By SELECT_ASSIGN_VALUE = By.xpath("//div//label[@id='Value']");
    public static final By SAVE_RULE_BUTTON = By.xpath("//span[contains(.,'Save')]");
    public static final By ADD_CONDITION = By.xpath("//a[contains(.,'Add condition')]");

    public static final By CONDITION_AUTO_ASSIGN =
            By.xpath("//div[contains(@class, 'auto-assign_aa-item-condition')]");
    public static final By TITLE_NEW_RULE_AUTO_ASSIGN =
            By.xpath("//div[contains(@class, 'auto-assign_aa-item-heading')]");

    public static final By NEW_RULE_LIST_AUTO_ASSIGN =
            By.xpath("//div[starts-with(@class, 'auto-assign_aa-item-head_')]");
    public static final By ITEM_AUTO_ASSIGN =
            By.xpath(
                    "//div[contains(@class, 'system-options_system-content-wrapper')]//div[contains(@class, 'auto-assign_aa-list-item')]");
    public static final By EXPAND_INDIVIDUAL_PARAMETERS = By.xpath("//div[contains(.,'Individual Parameters')]//following::div");


    // APPROVALS
    public static final By APPROVALS_INDIVIDUAL_PROVIDERS_ICON = By.xpath("//h3[text()='Individual Providers']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_GROUP_PROVIDERS_ICON = By.xpath("//h3[text()='Group Providers']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_PHARMACY_PROVIDERS_ICON = By.xpath("//h3[text()='Pharmacy']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_FACILITY_PROVIDERS_ICON = By.xpath("//h3[text()='Facility']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By APPROVALS_PEM_PROVIDERS_ICON = By.xpath("//h3[text()='Provider Enrollment Manager']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By  APPROVALS_ORP_PROVIDERS_ICON = By.xpath("//h3[text()='Ordering/Referring/Prescribing']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
    public static final By  APPROVALS_EDIT_BUTTON = By.xpath("//span[contains(.,'Edit')]");
    public static final By  APPROVALS_SAVE_CHANGES_BUTTON = By.xpath("//span[contains(.,'Save changes')]");
    public static final By  APPROVALS_BACK_TO_APPROVAL_LIST_BUTTON = By.xpath("//span[contains(.,'← Back to Approvals list')]");

    public static final By  APPROVALS_ENROLLMENT_APPROVER_CONFIGURE_INPUT_TEXT= By.xpath("//h4[contains(text(), 'Number of approvals required')]//following::div[1]/input[@aria-label='Configure']");
    public static final By  APPROVALS_ENROLLMENT_NUMBER_OF_APPROVER_CONFIGURE = By.xpath("//h4[contains(text(), 'Number of approvals required')]/../span[1]");
    public static final By  APPROVALS_ENROLLMENT_NUMBER_OF_REVIEWERS_CONFIGURE= By.xpath("//input[@aria-label='Configure reviewer Switch']");

    public static final By APPROVALS_ENROLLMENTS_BUTTON_VIEW = By.xpath("//h3[text()='Enrollment']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By APPROVALS_ENROLLMENTS_SECTION = By.xpath("//div[contains(@class, 'styles_page-title')]//h1");
    public static final By APPROVALS_NUMBER_NOT_EDITABLE = By.xpath("//div[contains(@class, 'styles_consideration-number')]//span");
    public static final By APPROVALS_NUMBER_EDITABLE = By.xpath("//div[contains(@class, 'styles_consideration-number')]//input");
    public static final By APPROVALS_APPEAL_APPROVAL_BUTTON_VIEW = By.xpath("//h3[text()='Appeal']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");

    public static final By APPROVALS_COC_BUTTON_VIEW = By.xpath("//h3[text()='Change of Circumstance']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By APPROVALS_SITE_VISIT_BUTTON_VIEW = By.xpath("//h3[text()='Site Visit']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By APPROVALS_ReEnrollment_BUTTON_VIEW = By.xpath("//h3[text()='Re Enrollment']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");

    // REVALIDATION
    public static final By APPROVALS_REVALIDATION_BUTTON_VIEW = By.xpath("//h3[text()='Revalidation']//ancestor::div[contains(@class, 'styles_approval')]//span[text()='VIEW']");
    public static final By HEADING_REVALIDATION = By.xpath("//div[contains(text(), 'Revalidation')]");
    public static final By ITEM_REVALIDATION = By.xpath("//div[contains(@class, 'styles_item')]");
    public static final By DAYS_REVALIDATION_DISABLE =
            By.xpath(
                    "//div[contains(@class, 'sc-bxivhb')]//div[contains(@class, 'styles_disableSel')]");
    public static final By DAYS_REVALIDATION_ENABLE =
            By.xpath("//div[contains(@class, 'sc-bxivhb')]//div[contains(@class, 'styles_enableSel')]");
    public static final By CREATE_REVALIDATION_BUTTON = By.xpath("//span[contains(.,'CREATE REVALIDATION')]");

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

    public static final By PYMTFEES_INDIV_EDIT_BUTTON = By.xpath("//span[contains(text() , 'Collect Fees For Individual')]/../../../../..//span[text()='Edit']");
    public static final By PYMTFEES_GROUP_EDIT_BUTTON = By.xpath("//span[contains(text() , 'Collect Fees For Group')]/../../../../..//span[text()='Edit']");
    public static final By PYMTFEES_FACILITY_EDIT_BUTTON = By.xpath("//span[contains(text() , 'Collect Fees For Facility')]/../../../../..//span[text()='Edit']");
    public static final By PYMTFEES_PHARMACY_EDIT_BUTTON = By.xpath("//span[contains(text() , 'Collect Fees For Pharmacy')]/../../../../..//span[text()='Edit']");
    public static final By PYMTFEES_PEM_EDIT_BUTTON = By.xpath("//span[contains(text() , 'Collect Fees For Provider Enrollment Manager')]/../../../../..//span[text()='Edit']");
    public static final By PYMTFEES_ORP_EDIT_BUTTON = By.xpath("//span[contains(text() , 'Collect Fees For Ordering/Referring/Prescribing Provider Enrollment')]/../../../../..//span[text()='Edit']");

    public static final By PYMTFEES_INDIV_COLLECT_FEES = By.xpath("//input[@name='Individual Provider']");
    public static final By PYMTFEES_GROUP_COLLECT_FEES = By.xpath("//input[@name='Facility Provider']");
    public static final By PYMTFEES_FACILITY_COLLECT_FEES = By.xpath("//input[@name='Group Provider']");
    public static final By PYMTFEES_PHARMACY_COLLECT_FEES = By.xpath("//input[@name='Pharmacy']");
    public static final By PYMTFEES_PEM_COLLECT_FEES = By.xpath("//input[@name='Provider Enrollment Manager']");
    public static final By PYMTFEES_ORP_COLLECT_FEES = By.xpath("//input[@name='Ordering/Referring/Prescribing Provider']");

    public static final By PYMTFEES_INDIV_FEE_CHARGED = By.xpath("//h3[contains(text(), 'Individual Provider Enrollment Fees')]/../../..//input[@id='provider-amount']");
    public static final By PYMTFEES_GROUP_FEE_CHARGED = By.xpath("//h3[contains(text(), 'Group Provider Enrollment Fees')]/../../..//input[@id='provider_group-amount']");
    public static final By PYMTFEES_FACILITY_FEE_CHARGED = By.xpath("//h3[contains(text(), 'Facility Provider Enrollment Fees')]/../../..//input[@id='facility-amount']");
    public static final By PYMTFEES_PHARMACY_FEE_CHARGED = By.xpath("//h3[contains(text(), 'Pharmacy Enrollment Fees')]/../../..//input[@id='pharmacy-amount']");
    public static final By PYMTFEES_PEM_FEE_CHARGED = By.xpath("//h3[contains(text(), 'Provider Enrollment Manager Enrollment Fees')]/../../..//input[@id='provider_enrollment_manager-amount']");
    public static final By PYMTFEES_ORP_FEE_CHARGED = By.xpath("//h3[contains(text(), 'Ordering/Referring/Prescribing Provider Enrollment Fees')]/../../..//input[@id='orp-amount']");

    public static final By PYMTFEES_INDIV_INSTATE = By.xpath("//h3[contains(text(), 'Individual Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'In-State')]/../../..//input[@id='provider-amount']");
    public static final By PYMTFEES_GROUP_INSTATE = By.xpath("//h3[contains(text(), 'Group Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'In-State')]/../../..//input[@id='provider_group-amount']");
    public static final By PYMTFEES_FACILITY_INSTATE = By.xpath("//h3[contains(text(), 'Facility Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'In-State')]/../../..//input[@id='facility-amount']");
    public static final By PYMTFEES_PHARMACY_INSTATE = By.xpath("//h3[contains(text(), 'Pharmacy Enrollment Fees')]/../../../../..//h3[contains(text(), 'In-State')]/../../..//input[@id='pharmacy-amount']");
    public static final By PYMTFEES_PEM_INSTATE = By.xpath("//h3[contains(text(), 'Provider Enrollment Manager Enrollment Fees')]/../../../../..//h3[contains(text(), 'In-State')]/../../..//input[@id='provider_enrollment_manager-amount']");
    public static final By PYMTFEES_ORP_INSTATE = By.xpath("//h3[contains(text(), 'Ordering/Referring/Prescribing Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'In-State')]/../../..//input[@id='orp-amount']");


    public static final By PYMTFEES_INDIV_OUTOFSTATE = By.xpath("//h3[contains(text(), 'Individual Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'Out of state')]/../../..//input[@id='provider-amount']");
    public static final By PYMTFEES_GROUP_OUTOFSTATE = By.xpath("//h3[contains(text(), 'Group Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'Out of state')]/../../..//input[@id='provider_group-amount']");
    public static final By PYMTFEES_FACILITY_OUTOFSTATE = By.xpath("//h3[contains(text(), 'Facility Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'Out of state')]/../../..//input[@id='facility-amount']");
    public static final By PYMTFEES_PHARMACY_OUTOFSTATE = By.xpath("//h3[contains(text(), 'Pharmacy Enrollment Fees')]/../../../../..//h3[contains(text(), 'Out of state')]/../../..//input[@id='pharmacy-amount']");
    public static final By PYMTFEES_PEM_OUTOFSTATE = By.xpath("//h3[contains(text(), 'Provider Enrollment Manager Enrollment Fees')]/../../../../..//h3[contains(text(), 'Out of state')]/../../..//input[@id='provider_enrollment_manager-amount']");
    public static final By PYMTFEES_ORP_OUTOFSTATE = By.xpath("//h3[contains(text(), 'Ordering/Referring/Prescribing Provider Enrollment Fees')]/../../../../..//h3[contains(text(), 'Out of state')]/../../..//input[@id='orp-amount']");

    // AUTOARCHIVE

  //  public static final By TEXT_FIELD_REQUEST_ID = By.cssSelector("input#RequestID");
    public static final By AUTO_ARCHIVE_DATA_SET_PERIOD = By.xpath("(//input[@aria-label='Auto archive Data'])[1]");
    public static final By AUTO_ARCHIVE_FILE_SET_PERIOD = By.xpath("(//input[@aria-label='Auto archive Data'])[2]");


    //DUPLICITY
    public static final By DUPLICITY_INDEX_OPTION_IN_NPI_LIST = By.xpath("//div[contains(text(),'National Provider Identifier')]/..//select//option");
    public static final By DUPLICITY_EDIT_BUTTON = By.xpath("//div[contains(@class , 'style_control')]//span//p[text()='Edit']");
    public static final By DUPLICITY_CUT_OFF_PERCENTAGE = By.xpath("//div[contains(text(),'Cut Off Percentage')]/../div[2]");
    public static final By DUPLICITY_NPI = By.xpath("//div[contains(text(),'National Provider Identifier')]/../div[2]");
    public static final By DUPLICITY_SSN_FEIN = By.xpath("//div[contains(text(),'SSN / FEIN')]/../div[2]");
    public static final By DUPLICITY_TAXONOMY = By.xpath("//div[contains(text(),'Taxonomy')]/../div[2]");
    public static final By DUPLICITY_DBA = By.xpath("//div[contains(text(),'Name / Doing Business as (DBA)')]/../div[2]");
    public static final By DUPLICITY_ZIP = By.xpath("//div[contains(text(),'Zip')]/../div[2]");
    public static final By DUPLICITY_DOB = By.xpath("//div[contains(text(),'Date of Birth')]/../div[2]");
    public static final By DUPLICITY_DEA_NUMBER = By.xpath("//div[contains(text(),'DEA Number')]/../div[2]");


    //LICENSURE
    public static final By LICENSURE_EDIT_BUTTON = By.xpath("//div[contains(@class , 'styles_control')]//span[contains(text(), 'Edit')]");
    public static final By LICENSURE_STYLES_PERIOD_NOT_EDITABLE = By.xpath("//div[contains(@class , 'styles_period-select')]//span");
    public static final By LICENSURE_STYLES_PERIOD_EDITABLE = By.xpath("//div[contains(@class , 'styles_period-select')]//input");
    public static final By LICENSURE_1ST_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'1st notification')]/../div[2]/span[1]");
    public static final By LICENSURE_2ND_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'2nd notification')]/../div[2]/span[1]");
    public static final By LICENSURE_3RD_NOTIFICATION_DAYS = By.xpath("//div[contains(text(),'3rd notification')]/../div[2]/span[1]");


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


    //REVALIDATION AND REMINDERS
    public static final By REVALANDREM_EDIT_BUTTON = By.xpath("//div[contains(text(), 'Revalidation')]//span[contains(text(), 'Edit')]");
    public static final By REVALANDREM_REVALIDATION_DATE_DAYS = By.xpath("//div[contains(text(), 'Revalidation date')]/../..//div[@aria-haspopup='true']");
    public static final By REVALANDREM_1ST_NOTIFICATION_DAYS = By.xpath("//div[contains(text(), '1st notification')]/..//div[@aria-haspopup='true']");
    public static final By REVALANDREM_2ND_NOTIFICATION_DAYS = By.xpath("//div[contains(text(), '2nd notification')]/..//div[@aria-haspopup='true']");
    public static final By REVALANDREM_3RD_NOTIFICATION_DAYS = By.xpath("//div[contains(text(), '3rd notification')]/..//div[@aria-haspopup='true']");
    public static final By REVALANDREM_GROUP_REVAL_DAYS = By.xpath("//div[contains(text(), 'Group provider:outstanding revalidation')]/../..//div[@aria-haspopup='true']");
    public static final By REVALANDREM_AFTER_REVAL_PERIOD = By.xpath("//div[contains(text(), 'After revalidation period')]/../..//div[@aria-haspopup='true']");

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


    //CAPTCHA
    public static final By CAPTCHA_SWITCH = By.xpath("//input[@aria-label='Recaptcha verification']");

    //public static final By PASSPOLICY_REG_PASSWORD_LENGTH = By.xpath("//h3[contains(text(), 'Configure Password Policy')]/../input[1]");

    // PROVIDER ENROLLMENT
    public static final By TEXT_FIELD_FIRST_NAME_PROVIDER = By.xpath("//input[contains(@id, 'First Name')]");
    public static final By TEXT_FIELD_LAST_NAME_PROVIDER = By.xpath("//input[contains(@id, 'Last Name')]");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_EMAIL = By.xpath("//input[contains(@id, 'Application')]");
    public static final By COMBOBOX_GENDER = By.xpath("//label[text()='Gender']//ancestor::div[@role='combobox']//input");
    public static final By DROP_DOWN_COUNTRY_OF_BIRTH = By.xpath("//label[text()='Country of birth']//ancestor::div[@role='combobox']//input");
    public static final By DROP_DOWN_BIRTH_USA = By.xpath("//div[@id='react-autowhatever-1']//li[@id='react-autowhatever-1--item-0']");
    public static final By DROP_DOWN_STATE_OF_BIRTH = By.xpath("//label[text()='State of birth']//ancestor::div[@role='combobox']//input");
    public static final By DROP_DOWN_STATE = By.xpath("//ul[@role='listbox']//li[@id='react-autowhatever-1--item-49']//strong[text()='Wyoming']");

    public static final By TEXT_FIELD_SSN = By.xpath("//div[@label='SSN']//input");
    public static final By TEXT_FIELD_SSN_PHARMACY = By.xpath("//div[@data-for='SSN']//input");
    public static final By COMBOBOX_TYPE_BUSINESS = By.xpath("//label[contains(text(), 'business')]//ancestor::div[@role='combobox']");
    public static final By OPTION_GENDER = By.xpath("//ul[@role='listbox']//li");
    public static final By CALENDAR_DOB = By.xpath("//label[text()='Date of birth *']/following::div/input[@placeholder='MM/DD/YYYY']");
    public static final By COMBOBOX_PROVIDER_TYPE = By.xpath("//label[text()='Provider type']//ancestor::div[contains(@role, 'combobox')]//input");
    public static final By RADIOBUTTON_INDIVIDUAL = By.xpath("//input[@value='Individual']");

    public static final By RADIOBUTTON_NPI_NUMBER = By.xpath("//input[contains(@name, 'NPI')][@value='true']");
    public static final By COMBOBOX_TAXONOMY = By.xpath("//label[text()='Primary Taxonomy']//ancestor::div[@role='combobox']//input");
    public static final By COMBOBOX_TAXONOMY_PHARAMACY = By.xpath("//label[contains(text(),'Primary Taxonomy')]//ancestor::div[@role='combobox']//input");
    public static final By TEXT_FIELD_LICENSE_NUMBER = By.xpath("//input[contains(@id, 'License Number')]");
    public static final By TEXT_FIELD_CERTIFICATION_NUMBER = By.xpath("//input[contains(@id, 'Certification Number')]");
    public static final By DROP_DOWN_LICENSE_TYPE = By.xpath("//label[@id ='License Type']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By DROP_DOWN_LICENSE_ISSUE_STATE = By.xpath("//label[@id ='License Issued State']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By CALENDER_LICENSE_EFFECTIVE_DATE2 = By.xpath("//label[contains(text(), 'License Effective Date')]/../div//div//button[@type='button']");
    public static final By CALENDER_CERTIFICATION_EFFECTIVE_DATE = By.xpath("//label[text()='Certification Effective Date *']/../div//div//button[@type='button']");
    public static final By CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE = By.xpath("//button[@tabindex='0']//span[text()='1']");
    public static final By CALENDER_LICENSE_EXPIRATION_DATE = By.xpath("//label[text()='License Expiration Date *']/../div//div//button[@type='button']");
    public static final By CALENDER_LICENSE_EXPIRATION_DATE2 = By.xpath("//label[contains(text(), 'License Expiration Date')]/../div//div//button[@type='button']");
    public static final By CALENDER_SELECT_28_LICENSE_EXPIRATION_DATE = By.xpath("//button[@tabindex='0']//span[text()='28']");
    public static final By TEXT_FIELD_MANAGING_EMPLOYEE_TYPE = By.xpath("//label[@id ='Managing Employee Type']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By TEXT_FIELD_LICENSE_FIRST_NAME = By.xpath("//input[contains(@id, 'First Name')]");
    public static final By TEXT_FIELD_LICENSE_LAST_NAME = By.xpath("//input[contains(@id, 'Last Name')]");
    public static final By TEXT_FIELD_COUNTRY_OF_BIRTH = By.xpath("//label[@id ='Country of Birth']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By COMBOBOX_TYPE_IDENTIFIERS = By.xpath("//label[@id='Type']//ancestor::div[contains(@class, 'sc-bdVaJa')]//div[@role='button']");
    public static final By TEXT_FIELD_IDENTIFIER = By.xpath("//input[contains(@id, 'Identifier')]");
    public static final By COMBOBOX_TAXONOMY_DESCRIPTION = By.xpath("//label[text()='Taxonomy Description']//ancestor::div[@role='combobox']//input");
    public static final By RADIOBOX_REQUEST_RETROACTIVE = By.xpath("//span//input[@value ='true']");
    public static final By RADIOBUTTON_EXCLUSION_CRIMINAL_OFFENCE = By.xpath("//input[contains(@name, 'criminal offense')][@value='false']");
    public static final By RADIOBUTTON_EXCLUSION_LICENSE_SANCTIONED = By.xpath("//input[contains(@name, 'license sanctioned')][@value='false']");
    public static final By RADIOBUTTON_EXCLUSION_CIVIL_MONEY_PENALTIES = By.xpath("//input[contains(@name, 'civil money penalties')][@value='false']");
    public static final By RADIOBUTTON_EXCLUSION_DEBARRED = By.xpath("//input[contains(@name, 'debarred')][@value='false']");


    public static final By OPTION_FROM_LISTBOX = By.xpath("//ul[@role='listbox']//li//strong");

    public static final By COMBOBOX_PROGRAM_PARTICIPATION =
            By.xpath(
                    "//label[text()='Program participation']//ancestor::div[contains(@role, 'combobox')]//input");
    public static final By TEXT_FIELD_NPI = By.xpath("//input[contains(@id, 'National provider identification')]");
    public static final By TEXT_FIELD_NEW_NPI = By.xpath("//input[contains(@id, 'NPI')]");
    public static final By TEXT_FIELD_NCPDP = By.xpath("//input[contains(@id, 'NCPDP')]");
    public static final By RADIOBUTTON_DEA_NUMBER = By.xpath("//input[contains(@name, 'DEA')][@value='false']");
    public static final By RADIOBUTTON_BILL_LABORATORY_SERVICES = By.xpath("//input[contains(@name,'laboratory')][@value='false']");
    public static final By RADIOBUTTON_MEDICAL_SERVICES = By.xpath("//input[contains(@name,'Medical')][@value='true']");
    public static final By RADIOBUTTON_TREATING_PROVIDER = By.xpath("//input[contains(@name,'Treating')][@value='true']");
    public static final By RADIOBUTTON_ELECTRONIC_DATA_INTERCHANGE = By.xpath("//input[contains(@name,'Electronic Data Interchange')][@value='true']");
    public static final By RADIOBUTTON_OTHER_MEDICAID_STATE = By.xpath("//input[contains(@name,'Medicaid')][@value='true']");

    //ADDRESSES
    public static final By TEXT_FIELD_PHYSICAL_ADDRESS =
            By.xpath("//input[contains(@id, 'Physical Address')]");
    public static final By TEXT_FIELD_BUILDING_SUITE =
            By.xpath("//input[contains(@id, 'Building, Suite')]");
    public static final By TEXT_FIELD_ZIP_CODE1 = By.xpath("//input[@id='zipPlusFour']");
    public static final By TEXT_FIELD_ZIP_CODE2 = By.xpath("//div[@label='Mailing - Service Location Zip']//input");
    public static final By TEXT_COUNTY_CODE = By.xpath("//label[contains(text(), 'County')]//ancestor::div[@role ='combobox']//input");
    public static final By TEXT_FIELD_EXTENSION = By.xpath("//input[contains(@id, 'Extension')]");
    public static final By TEXT_FIELD_MIDDLE_NAME = By.xpath("//input[contains(@id, 'Middle Name')]");
    public static final By TEXT_FIELD_EMAIL_ADDRESS = By.xpath("//input[contains(@id, 'Email')]");
    public static final By TEXT_FIELD_ALTERNATE_EMAIL_ADDRESS = By.xpath("//input[contains(@id, 'Alternate Email')]");
    public static final By TEXT_FIELD_FIRST_NAME_ADDRESS = By.xpath("//input[contains(@id, 'First Name')]");
    public static final By TEXT_FIELD_LAST_NAME_ADDRESS = By.xpath("//input[contains(@id, 'Last Name')]");
    public static final By TEXT_FIELD_PHONE_ADDRESS = By.xpath("//div[@label='Phone']//input");
    public static final By TEXT_FIELD_MEDICAL_DIRECTOR = By.xpath("//input[contains(@id, 'Medical Director')]");
    //SP26
    public static final By TEXT_FIELD_ADDRESS = By.xpath("//div[@data-for ='Address Line 1']//input");
    public static final By TEXT_FIELD_ADDRESS1 = By.xpath("//div[@data-for ='Address Line 1']//div[1]");

    public static final By TEXT_FIELD_ADDRESS_CITY = By.xpath("//input[@id ='city']");
    public static final By DROP_DOWN_MAILING_ADDRESS_STATE = By.xpath("//div[@data-for='State']//input");

    // GROUP ENROLLMENT
    public static final By TEXT_FIELD_GROUP_PROVIDER_NAME = By.xpath("//input[contains(@id, 'Provider Name')]");
    //MODIFIED on 08/14 PER NEW CONFIGURATIONS
    public static final By TEXT_FIELD_GROUP_FEIN = By.xpath("//div[contains(@label,'FEIN Number')]//input[contains(@placeholder, '__-_______')]");
    //By.xpath("//input[contains(@id, 'FEIN')]");
    public static final By TEXT_FIELD_CONTACT_EMAIL = By.xpath("//input[contains(@id, 'Application')]");
    public static final By TEXT_FIELD_NPI_AFFILIATION = By.xpath("//div[contains(@class, 'affiliation_provider-search')]//following::input");
   // public static final By BUTTON_SEARCH_NPI_AFFILIATION = By.xpath("(//label[contains(text(), 'NPI/FEIN')]//ancestor::div[contains(@class, 'affiliation_provider-search')]//button)[1]");
    public static final By BUTTON_SEARCH_NPI_AFFILIATION = By.xpath("(//input[@id='inbox-search']/following::button)[1]");
    public static final By TEXT_FIELD_TAX_ENTITY_TYPE = By.xpath("//label[text()='Tax Entity Type']//ancestor::div[@role='combobox']//input");
    public static final By BUTTON_ADD_NPI_AFFILIATION = By.xpath("//label[contains(text(), 'NPI/FEIN')]//ancestor::div[contains(@class, 'affiliation_provider-search')]//span[text()='Add']");
    public static final By BUTTON_AFFILIATION_TYPE = By.xpath("//label[text()='Affiliation type']//ancestor::div[@role='document']//div[@role='button']");
    public static final By BUTTON_AFFILIATION_PEMTOINDIV = By.xpath("//ul/li[@data-value='PEM_TO_INDIVIDUAL']");
    public static final By ROW_ADDED_AFFILIATION = By.xpath("//div[contains(@class, 'affiliation_provider-list-item')]");
    public static final By BUTTON_ADD_AFFILIATION = By.xpath("//div[contains(@class, 'dialog-popup dashed')]//button//span[text()='Add']");

    // POP UPS
    public static final By BUTTON_CLOSE_UPDATE_PROFILE =
            By.xpath(
                    "//h2[text()='Update your profile']//ancestor::div[contains(@class, 'registration_title')]//button[contains(@class, 'registration_btn-close')]");
    public static final By POP_UP_UPDATE_PROFILE = By.xpath("//h2[text()='Update your profile']");

    // HELLO SIGN
    public static final By TEXT_FIELD_FIRST_NAME_HELLO_SIGN = By.xpath("//div//textarea[@placeholder='Full Name']");
    public static final By SECTION_TYPE_IN = By.xpath("//ol//li[@title='Type it in']");
    public static final By SECTION_TYPE_SIGNATURE = By.xpath("//div[@data-qa-ref='hello-modal']//input");
    public static final By BUTTON_INSERT_HELLO_SIGN = By.xpath("//button[@data-qa-ref='singing-modal--insert-btn']");


    //PROVIDER PORTAL
    public static final By MODAL_WINDOW_REVALIDATION = By.xpath("//div[contains(@class, 'styles_revalidation')]");
    public static final By MODAL_WINDOW_ENROLLMENT = By.xpath("//div[contains(@class, 'styles_enrollment-info')]");
    public static final By BUTTON_CLOSE_HELPTOUR = By.xpath("//div[contains(@class, 'joyride-tooltip-')]//button[@data-type='close']");


    //Gmail
    public static final By PASSWORD_GMAIL = By.xpath("//input[contains(@name, 'password')]");
    public static final By EMAIL_GMAIL = By.xpath(".//input[contains(@id, 'identifierId')]");
    public static final By EMAIL_NEXT_BUTTON = By.xpath(".//div[contains(@id, 'identifierNext')]");
    public static final By PASSWORD_NEXT_BUTTON = By.xpath(".//div[contains(@id, 'passwordNext')]");
    public static final By GOOGLE_APPS = By.xpath(".//a[@aria-label='Google apps']/../a");
    public static final By GOOGLE_APPS_IFRAME = By.xpath("//iframe[contains(@id, 'I0')]");
    public static final By GMAIL_ICON = By.xpath("//span[@pid='23']");
    public static final By SEARCH_INPUT = By.xpath(".//form[@role='search']//input[@type='text']/../input");
    public static final By SEARCH_BUTTON = By.xpath(".//button[@aria-label='Search mail']");
    public static final By SELECT_CHECKBOX = By.xpath("//div[contains(@aria-label,'Select')]//span[contains(@role,'checkbox')]");
    public static final By DELETE_BUTTON = By.xpath("//div[contains(@aria-label,'Delete')]");


    //ENROLLMENT TAB
    public static final By ENROLLMENT_TAB = By.xpath("//ul/li/a[text()='Enrollment']");
    public static final By ROW_IN_TABLE = By.xpath("//div[contains(@class, 'tile-table-row')]");
    public static final By INDIVIDUAL_TYPE_ENROLLMENT_ROW = By.xpath("//div[contains(@class, 'tile-table-row')]");


    //PROVIDERS DETAILS IN INTERNAL USER PORTAL
    public static final By FIRST_NAME_PROVIDER_DETAILS = By.xpath("//div[contains(@class, 'detailed-panel-head')]//h1");
    public static final By DOB_PROVIDER_DETAILS = By.xpath("//h4[text()='Date of birth']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p");
    public static final By SPECIALITY_PROVIDER_DETAILS = By.xpath("//h2[text()='Speciality']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p");
    //public static final By ID_PROVIDER_DETAILS = By.xpath("//h4[contains(.,'Provider ID')]//following-sibling::p");


      public static final By ID_PROVIDER_DETAILS = By.xpath("//h2[text()='Provider ID']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p");
    public static final By GENDER_PROVIDER_DETAILS = By.xpath("//h4[text()='Gender']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p");
    public static final By TYPE_PROVIDER_DETAILS = By.xpath("//h2[text()='Type']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p");
    public static final By DETAILED_MENU_PROVIDER_DETAILS = By.xpath("//div[contains(@class, 'detailed-panel-menu')]//button");
    public static final By EMAIL_PROVIDER_DETAILS = By.xpath("//h4[text()='Registered email']//ancestor::div[contains(@class, 'detailed-panel-column col')]//p");
    public static final By STATUS_PROVIDER_DETAILS = By.xpath("(//div[contains(@class, 'detailed-panel-head')]//ancestor::span)[1]");

    //SUSPENDED FORM
    public static final By TEXT_FIELDS_DATES_SUSPENDED_FORM = By.xpath("//label[contains(text(), 'Suspended from')]//ancestor::div[contains(@class, 'search-box')]//input[@placeholder='MM/DD/YYYY']");


    //PROVIDERS Tab
    public static final By SEARCH_BOX = By.xpath("//div[contains(@class, 'search-box')]");
    public static final By TEXT_FIELD_ENROLLMENT_TYPE = By.xpath("//input[contains(@id, 'Enrollment Type')]/preceding-sibling::div");
    public static final By TEXT_FIELD_PROVIDER_STATUS = By.xpath("//input[contains(@id, 'Provider Status')]/preceding-sibling::div");
    public static final By TEXT_FIELD_PROVIDER_NAME_ID = By.cssSelector("input#providerName");
    public static final By TEXT_FIELD_NPI_PROVIDERS = By.cssSelector("input#npi");
    public static final By TEXT_FIELD_PROVIDER_ADDRESS = By.xpath("//input[@id='address']");




    //Provider Identifier Number, ENROLLMENTS DETAILS IN INTERNAL USER PORTAL
    public static final By ENROLLMENT_SECTION = By.xpath("//div[contains(@class,'section_section-inner')]");
    public static final By FIRST_NAME_ENROLLMENT_DETAILS = By.xpath("//h4[text()='First Name']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]");
    public static final By LAST_NAME_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Last Name']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]");
    public static final By CONTACT_EMAIL_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Application contact email']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]");
    public static final By GENDER_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Gender']//ancestor::div[contains(@class, 'field_readonly-field')]//div[@class='sc-cQFLBn iOTJNd']");
    public static final By DOB_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Date of birth']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]");
    //public static final By TITLE_OR_DEGREE_ENROLLMENT_DETAILS = By.xpath("//div[@class='sc-jTzLTM kpNmsY']");
    public static final By TITLE_OR_DEGREE_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Title or Degree']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-jTzLTM')]");
    public static final By GENDER_SERVED_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Gender served']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]");
    public static final By INPUT_TITLE_OR_DEGREE_ENROLLMENT_DETAILS = By.xpath("//h2[contains(.,'Degree')]");
    public static final By INPUT_GENDER_SERVED_ENROLLMENT_DETAILS = By.xpath("//label[text()='Gender served']//ancestor::div[contains(@role, 'combobox')]//input");
  // public static final By STATUS_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Status']/..//div[contains(@class,'main-info-panel_value')]");
   public static final By STATUS_ENROLLMENT_DETAILS = By.xpath("((//span[contains(.,'Status')])[2]/../..//div//div)[1]");

    //LICENSURE, ENROLLMENTS DETAILS IN INTERNAL USER PORTAL
    public static final By ENROLLMENT_TYPE_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Please Chose Type of Enrollment']//ancestor::div[contains(@class, 'field_readonly-field')]//div[@class='sc-cQFLBn iOTJNd']");
    public static final By TAXONOMY_ENROLLMENT_DETAILS = By.xpath("//h4[text()='Taxonomy']//ancestor::div[contains(@class, 'field_readonly-field')]//div[@class='sc-cQFLBn iOTJNd']");


    //Address Details, ENROLLMENTS DETAILS IN INTERNAL USER PORTAL
    public static final By ANY_ADDRESS1_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'Physical Address')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn fePwqn')]");
    public static final By BUILDING_SUITE_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'Building, Suite')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-ex')]");
    public static final By ZIP_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'Zip')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-ex')]");
    public static final By EMAIL_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'Email')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-c')]");
    public static final By FIRST_NAME_IN_ADDRESS_DETAILS = By.xpath("//h4[contains(text(),'First Name')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-c')]");
    public static final By LAST_NAME_IN_ADDRESS_DETAILS = By.xpath("//h4[contains(text(),'Last Name')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-c')]");
    public static final By ZIP_IN_ADDRESS_DETAILS = By.xpath("//h4[contains(text(),'Zip')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-c')]");
    public static final By PHONE_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'Phone')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-ex')]");
    public static final By FIRST_NAME_ADDRESS_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'First Name')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-ex')]");
    public static final By LAST_NAME_ADDRESS_ENROLLMENT_DETAILS = By.xpath("//h4[contains(text(),'Last Name')]//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-ex')]");
    public static final By ENROLLMENT_INFORMATION = By.xpath("//span[text()='Enrollment Information']");
    public static final By NPI_NUMBER_DETAILS = By.xpath(" (//div[contains(@class,'field_readonly-field')])[2]//descendant::div/div");



    //Affiliations

    public static final By AFFILIATION_TAB = By.xpath("//ul//li//a[contains(@href, '/affiliations')]");
    public static final By AFFILIATION_PROVIDERINFO_TEXTBOX = By.xpath("//input[@id='providerNameNpi']");
    public static final By AFFILIATION_INFRMATION_TABLE = By.xpath("(//div[contains(@class, 'table-text_tooltip')]//p)[2]");
    public static final By AFFILIATION_SUBMIT_SIGN = By.xpath("//*[text()='SIGN / SUBMIT']");
    public static final By AFFILIATION_TABLE = By.xpath("//div[contains(@class,'tile-table')]");
    public static final By AFFILIATION_LIST= By.xpath("//div[starts-with(@class,'affiliation_table')]/div");
    public static final By AFFILIATION_REASON_LIST= By.xpath("((//div[@role='document'])[2]/ul/li)[4]");
    public static final By AFFILIATION_Note_LIST= By.xpath("(//div[contains(@class, 'table-text_tooltip')]//p)[5]");




   //POP UPS
    public static final By BUTTON_CLOSE_INFO_MESSAGE = By.xpath("//button[contains(@data-type,'close')]");
    public static final By BUTTON_CLOSE_INFO_MESSAGE2 = By.xpath("//div[@role='document']//button]");
    public static final By BUTTON_CLOSE_INFO_MESSAGE3 = By.xpath("//button[contains(@class,'alert_close-btn')]");
    public static final By SKIP_HELP_TOUR = By.xpath("//div[contains(@class, 'joyride-tooltip-')]//button[@data-type='skip' and text() = 'Skip']");
    public static final By CLOSE_HELP_TOUR = By.xpath("//div[contains(@class, 'joyride-tooltip-')]//button[@data-type='skip' and text() = 'Skip']");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[contains(@class,'requests_title')]/following::h2");


    //COC
    public static final By CHECKBOX_TAXONOMY_SPECIALTY = By.xpath("//label[contains(text(), 'Specialty - Individual')]/../div//input");
    public static final By COC_SECTION = By.xpath("//div[contains(@class,'coc_content')]");
    public static final By COC_TAB = By.xpath("//ul//li//a[@href='/coc-list']");
    public static final By COC_REQUEST_STATUS = By.xpath("//input[contains(@id, 'Request status')]/preceding-sibling::div");


    //APPEALS
    public static final By APPEALS_TAB = By.xpath("//ul//li//a[contains(@href, '/appeal')]");
    public static final By APPEALS_ROW = By.xpath("//div[contains(@class, 'appeals_row')]/div[1]/span/../parent::div//span[contains(text(), 'Appeal')]");
    public static final By UPLOAD_INPUT = By.xpath(".//h4[contains(text(), 'Appeal')]/parent::div/..//input[@type='file']");
    public static final By TEXT_FIELD_APPEAL_REASON = By.xpath("//input[contains(@id, 'Reason')]");
    public static final By TEXT_FIELD_APPEAL_FIRST_NAME = By.xpath(".//input[contains(@id, 'First name')]");
    public static final By TEXT_FIELD_APPEAL_LAST_NAME = By.xpath(".//input[contains(@id, 'Last name')]");
    public static final By CHECKBOX_AGREEMENT = By.xpath(".//input[@type='checkbox']");
    public static final By APPEAL_STATUS = By.xpath("//span[text()='Enrollment appeal request']//following::div[contains(@class,'main-info-panel_content')]");

   //AUDIT
   public static final By AUDIT_TAB = By.xpath("//ul/li/a[text()='Audit']");

   //REPORTS
    public static final By REPORTS_TAB = By.xpath("//ul/li/a[text()='Reports']");

    //SITE VISITS
    public static final By SITE_VISITIS_TAB = By.xpath("//ul/li/a[text()='Site visits']");
    public static final By TEXT_FIELD_NPI_SITE_VISITS = By.xpath("//div[@role='document']//input[contains(@id, 'provider')]");
    public static final By TEXT_FIELD_PROVIDER_SITE_VISIT = By.cssSelector("input#ProviderSiteVisit");
    public static final By BUTTON_CREATE_NPI_SITE_VISITS = By.xpath("//div[@role='document']//span[contains(text(), 'Create')]");
    public static final By TEXT_FIELD_PRACTICE_LOCATION_SITE_VISITS = By.xpath("//input[contains(@id, 'Practice Location')]");
    public static final By SECTION_CHECKLIST_INSTRUCTIONS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), 'Checklist')]");
    public static final By SECTION_PROVIDER_DETAILS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), 'Provider Details')]");
    public static final By SECTION_INITIAL_ASSESMENT = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), 'Initial Assessment')]");
    public static final By SECTION_2ND_SITE_VISIT = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), '2nd Site Visit')]");

    //VOTING
    public static final By VOTING_TAB = By.xpath("//ul/li/a[text()='Voting']");

    //HELP CENTER
    public static final By HELPING_CENTER_TAB = By.xpath("//ul/li/a[text()='Help center']");

    //DOCUMENTS
    public static final By DOCUMENTS_TAB = By.xpath("//div[contains(@class, 'header_header')]//ul/li/a[text()='Documents']");
    public static final By BUTTON_FILES_MANAGEMENT = By.xpath("//a[@href='/files-management']");
    public static final By BUTTON_FILES_ACTIVITY = By.xpath("//a[@href='/files-activity']");
    public static final By BUTTON_ARCHIVED_FILES = By.xpath("//a[@href='/files-bin']");
    public static final By TEXT_FIELD_SEARCH_DOCUMENTS = By.xpath("//input[@id='search-input']");
    public static final By BUTTON_FILES_ACTION = By.xpath("//div[contains(@class, 'slide-entered')]//button");
    public static final By ICON_OPEN_ROOT_FOLDERS = By.xpath("//i[contains(@class, 'icon-box flip light')]");
  // public static final By EXPAND_ROOT_FOLDERS = By.xpath("//svg[@stroke='currentColor']");
    public static final By EXPAND_ROOT_FOLDERS = By.cssSelector(".ePpqvl > svg");
//public static final By EXPAND_ROOT_FOLDERS =By.xpath("//svg[@stroke='currentColor']");
//public static final By EXPAND_ROOT_FOLDERS =By.xpath("//div[@class='sc-gqjmRU ePpqvl']");

    // PHARMACY
    public static final By TEXT_FIELD_LICENSE_NUMBER1_PHARMACY = By.xpath("(//input[contains(@id, 'License Number')])[1]");
    public static final By DROP_DOWN_LICENSE_TYPE1_PHARMACY = By.xpath("(//input[@class='jss339 jss623'])[2]");
    public static final By DROP_DOWN_LICENSE_ISSUE_STATE1_PHARMACY = By.xpath("(//input[@class='jss339 jss623'])[3]");
    public static final By DROP_DOWN_LICENSE_EFFECTIVE_DATE1_PHARMACY = By.xpath("(//label[text()='License Effective Date *']/../div//div//button[@type='button'])[1]");
    public static final By DROP_DOWN_LICENSE_EXPIRY_DATE1_PHARMACY = By.xpath("(//label[text()='License Expiration Date *']/../div//div//button[@type='button'])[1]");
    public static final By TEXT_FIELD_LICENSE_NUMBER2_PHARMACY = By.xpath("(//input[contains(@id, 'License Number')])[2]");
    public static final By DROP_DOWN_LICENSE_ISSUE_STATE2_PHARMACY = By.xpath(".//label[contains(text(), 'State')]/parent::div//input/preceding-sibling::div");
    public static final By DROP_DOWN_LICENSE_EFFECTIVE_DATE2_PHARMACY = By.xpath("(//label[text()='License Effective Date *']/../div//div//button[@type='button'])[2]");
    public static final By DROP_DOWN_LICENSE_EXPIRY_DATE2_PHARMACY = By.xpath("(//label[text()='License Expiration Date *']/../div//div//button[@type='button'])[2]");
    public static final By CALENDER_SELECT_27_LICENSE_EFFECTIVE_DATE = By.xpath("//button[@tabindex='0']//span[text()='27']");

    //BUILDER
    public static final By BUILDER_PRIMARY_TAXONOMY_SECTION = By.xpath("//span[text() = 'Taxonomies']");
    public static final By BUILDER_PRIMARY_TAXONOMY_OPTIONS = By.xpath("//div//textarea");
    public static final By BUILDER_PRIMARY_TAXONOMY_THERAPY = By.xpath("(//span[text() = 'Primary Taxonomy'])[13]");
    public static final By BUILDER_PRIMARY_TAXONOMY_THERAPY_SELECTION = By.xpath("//div[text() = 'Therapy']");
    public static final By BUILDER_PRIMARY_TAXONOMY_PODIATRY = By.xpath("(//span[text() = 'Primary Taxonomy'])[11]");
    public static final By BUILDER_PRIMARY_TAXONOMY_PODIATRY_SELECTION = By.xpath("//div[text() = 'Podiatry']");
    public static final By BUILDER_PRIMARY_TAXONOMY_PHYSICIAN = By.xpath("(//span[text() = 'Primary Taxonomy'])[10]");
    public static final By BUILDER_PRIMARY_TAXONOMY_PHYSICIAN_SELECTION = By.xpath("//div[text() = 'Physician']");
    public static final By BUILDER_PRIMARY_TAXONOMY_VISION = By.xpath("(//span[text() = 'Primary Taxonomy'])[13]");
    public static final By BUILDER_PRIMARY_TAXONOMY_VISION_SELECTION = By.xpath("//div[text() = 'Vision']");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_THERAPY = By.xpath("(//span[text() = 'Primary Taxonomy'])[9]");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_THERAPY_SELECTION = By.xpath("//div[text() = 'Therapy']");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_PODIATRY = By.xpath("(//span[text() = 'Primary Taxonomy'])[8]");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_PODIATRY_SELECTION = By.xpath("//div[text() = 'Podiatry']");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_PHYSICIAN = By.xpath("(//span[text() = 'Primary Taxonomy'])[7]");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_PHYSICIAN_SELECTION = By.xpath("//div[text() = 'Physician']");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_VISION = By.xpath("(//span[text() = 'Primary Taxonomy'])[10]");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_VISION_SELECTION = By.xpath("//div[text() = 'Vision']");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_PHARMACIST = By.xpath("(//span[text() = 'Primary Taxonomy'])[6]");
    public static final By BUILDER_PRIMARY_TAXONOMY_ORP_PHARMACIST_SELECTION = By.xpath("//div[text() = 'Pharmacist']");
    public static final By BUILDER_PRIMARY_TAXONOMY_FACILITY_AMBULANCE = By.xpath("(//span[text() = 'Primary Taxonomy'])[1]");
    public static final By BUILDER_PRIMARY_TAXONOMY_FACILITY_AMBULANCE_SELECTION = By.xpath("//div[text() = 'Ambulance']");
    public static final By BUILDER_PRIMARY_TAXONOMY_FACILITY_DHCF_ALLOWANCE = By.xpath("(//span[text() = 'Primary Taxonomy'])[2]");
    public static final By BUILDER_PRIMARY_TAXONOMY_FACILITY_DHCF_ALLOWANCE_SELECTION = By.xpath("//div[text() = 'DHCF Allowances']");
    public static final By BUILDER_PRIMARY_TAXONOMY_FACILITY_SPECIALTY_CLINIC = By.xpath("(//span[text() = 'Primary Taxonomy'])[10]");
    public static final By BUILDER_PRIMARY_TAXONOMY_FACILITY_SPECIALTY_CLINIC_SELECTION = By.xpath("//div[text() = 'Specialty Clinic']");

    //TAXONOMY
    public static final By BUILDER_225100001X_Physical_Therapist = By.xpath("//div[contains(@title, '225100001X')]");
    public static final By BUILDER_213E00001X_Podiatrist = By.xpath("//div[contains(@title, '213E00001X')]");
    public static final By BUILDER_207L00001X_Anesthesiology = By.xpath("//div[contains(@title, '207L00001X')]");
    public static final By BUILDER_156FX1801X_Optician = By.xpath("//div[contains(@title, '156FX1801X')]");
    public static final By BUILDER_1835P2202X_Pharmacist = By.xpath("//div[contains(@title, '1835P2202X')]");
    public static final By BUILDER_341600001X_Ambulance = By.xpath("//div[contains(@title, '341600001X')]");
    public static final By BUILDER_251K00001X_Public_Health = By.xpath("//div[contains(@title, '251K00001X')]");
    public static final By BUILDER_261QA1904X_Ambulatory_Surgical_Center = By.xpath("//div[contains(@title, '261QA1904X')]");

    //FINGERPRINTING
    public static final By RADIOBUTTON_FINGERPRINTING_YES = By.xpath("//input[contains(@value ,'true')]");
    public static final By RADIOBUTTON_FINGERPRINTING_NO = By.xpath("//input[contains(@value ,'false')]");
    public static final By RADIOBUTTON_FINGERPRINTING_NOT_APPLICABLE = By.xpath("//input[contains(@value ,'na')]");

    //TrackingNumber
    public static final By Tracking_Number = By.xpath("//span[contains(.,'Tracking number')]//following::div");
    public static final By Tracking_Number_ReEnrollment = By.xpath("(//span[text()='Tracking Number']/following::div)[1]");
    public static final By REQUEST_ID = By.xpath("//span[contains(.,'Request ID')]//following::div");


    public static final By identifying_information = By.xpath("//div[contains(@class,'menu_menu-item')]/span[text()='Identifying Information']");
    public static final String first_name = "//input[contains(@id,'First Name')]";
    public static final String last_name = "//input[contains(@id,'Last Name')]";
    public static final By Provider_Name = By.xpath("//input[contains(@id,'Provider Name')]");


    public static final By BACKTOPORTAL_BUTTON = By.xpath("//span[contains(@class,'header_backtoportal')]");
    public static final String FNAME= "//div/label[contains(.,'Last Name')]";
    public static final By POPUp = By.xpath("//div[contains(@class, 'styles_content')]");
    public static final By TXT_BOX_TITLE = By.xpath(".//div[@ data-field='Title']//textarea[@placeholder='Title']");
    public static final By BTN_CONTINUE = By.xpath(".//button[@data-btn='common']/span['Continue']");
    public static final By BTN_AGREE = By.xpath(".//button[@data-qa-ref='button-agree']");
    public static final By BTN_NEXT= By.xpath(".//div[contains(@class,'root_content')]/div/div/div[4]/button['Next']");
}
