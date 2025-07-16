package com.hhstechgroup.Pages;


import com.hhstechgroup.common.*;
import com.hhstechgroup.utility.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


import static com.hhstechgroup.common.Data.FEIN;
import static com.hhstechgroup.common.Data.email;
import static org.openqa.selenium.Keys.TAB;


public class ProviderEnrollingPage extends BaseActions {
    protected SoftAssert softAssert = new SoftAssert();
    Boolean sectionDisplayed;


    // PROVIDER ENROLLMENT


    public static final By REASON_CODE_LIST = By.xpath("//input[@name='Reason Code']/following::div//ul[@role='listbox']//li");
//    public static final By COMBOBOX_REASON_CODE = By.xpath(".//label[text()='Reason Code']/parent::div//input");


    public static final By COMBOBOX_REASON_CODE = By.xpath("//label[contains(.,'Reason Code')]//ancestor::div[@role='combobox']//input");
    public static final By COMBOBOX_TITLE_PROVIDER = By.xpath("//input[@name='Title']");
    public static final By TEXT_FIELD_FIRST_NAME_PROVIDER = By.xpath("//input[contains(@aria-label, 'First Name')]");
    public static final By FIRST_NAME_SUMMARY=By.xpath("//input[contains(@aria-label, 'First Name')]");
    public static final By TEXT_FIELD_LAST_NAME_PROVIDER = By.xpath("//input[contains(@aria-label, 'Last Name')]");
    public static final By TEXT_FIELD_MIDDLE_NAME_PROVIDER = By.xpath("//input[contains(@aria-label, 'Middle Name')]");
    public static final By TEXT_FIELD_PROVIDER_NAME=By.xpath("//input[@aria-label='Provider name']");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_EMAIL = By.xpath("//input[contains(@aria-label, 'Email')]");
    public static final By APPLICATION_CONTACT_EMAIL_Email = By.xpath("//input[contains(@aria-label, 'email')]");
    public static final By APPLICATION_CONTACT_PHONE=By.xpath("//div[@data-for='Application Contact Phone']//input");


    public static final By TEXT_FIELD_APPLICATION_CONTACT_NAME=By.xpath("//input[contains(@aria-label, 'Contact Name')]");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_NUM=By.xpath("//div[contains(@data-for,'Application Contact Number')]//input");


    public static final By COMBOBOX_GENDER = By.xpath("//label[text()='Gender']//ancestor::div[@role='combobox']//input");
    public static final By GENDER=By.xpath("//div[contains(@id,'Gender')]");
    public static final By DROP_DOWN_COUNTRY_OF_BIRTH = By.xpath("//label[text()='Country of Birth']//ancestor::div[@role='combobox']//input");
    public static final By DROP_DOWN_BIRTH_USA = By.xpath("//div[@id='react-autowhatever-1']//li[@id='react-autowhatever-1--item-0']");
    public static final By DROP_DOWN_STATE_OF_BIRTH = By.xpath("//label[text()='State of Birth']//ancestor::div[@role='combobox']//input");
    public static final By DROP_DOWN_STATE_OF_BIRTH2 = By.xpath("//label[contains(., 'State of Birth')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By RACE=By.xpath("//div[contains(@id,'Race')]");
    public static final By DROP_DOWN_STATE = By.xpath("//ul[@role='listbox']//li[@id='react-autowhatever-1--item-49']//strong[text()='Wyoming']");


    public static final By TEXT_FIELD_SSN = By.xpath("//div[@data-for='SSN']//input");


    public static final By RADIO_BTN_1099_TAX_EXEMPT_YES = By.xpath("(//input[contains(@name,'Are you 1099 tax exempt?')])[1]");
    public static final By RADIO_BTN_1099_TAX_EXEMPT_NO = By.xpath("(//input[contains(@name,'Are you 1099 tax exempt?')])[2]");
    public static final By TEXT_FIELD_LEGAL_BUSINESS_NAME = By.xpath("//input[contains(@aria-label,'Legal Business Name')]");
    public static final By LABEL_CLAIM_SUBMISSION_METHOD = By.xpath("//input[@name='What claim submission(s) do you use?']");
    public static final By CLAIM_SUBMISSION_COMBOBOX_LIST = By.xpath("//input[@name='What claim submission(s) do you use?']/following::div//ul[@role='listbox']//li");
    //    public static final By COMBOBOX_CLAIM_SUBMISSION_METHOD = By.xpath("//span[@data-for = 'What claim Submission(s) do you use?']//following::div//input");
    public static final By COMBOBOX_CLAIM_SUBMISSION_METHOD = By.xpath(".//label[contains(text(), 'claim')]/parent::div//input/..//div");
//    public static final By COMBOBOX_CLAIM_SUBMISSION_METHOD = By.xpath("//span[@data-for = 'What claim Submission(s) do you use?']");


    // public static final By COMBOBOX_CLAIM_SUBMISSION_METHOD = By.xpath("//label[text()='What claim submission(s) do you use?']//ancestor::div[@role='combobox']//input");
    public static final By TEXT_COUNTY_CODE = By.xpath("//input[contains(@aria-label,'County')]");
    public static final By EXCLUSION_SANCTION_UPLOAD_DOC_LABEL = By.xpath(".//h2[text() = 'Exclusion/Sanction Documents']");
    public static final By EXCLUSION_SANCTION_UPLOAD_DOC_BTN = By.xpath(".//h2[text() = 'Exclusion/Sanction Documents']/../../div[contains(@class, 'upload_upload-controls')]//following::span[2]");
    public static final By EXCLUSION_SANCTION_UPLOAD_DOC_ERROR_MSG = By.xpath(".//h2[text() = 'Exclusion/Sanction Documents']/../../div[contains(@class, 'upload_upload-controls')]//following::li");


    public static final By SECTION_PAYMENT = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Payment']");
    public static final By SECTION_PAYMENT_RED = By.xpath("//div[@data-for='Payment']//div[contains(@class, 'menu_red')]");
    public static final By SECTION_TAXONOMY = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), 'Taxonomy')]");
    public static final By SECTION_PROVIDER_IDENTIFIER_NUMBER = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider Identifier Number']");
    public static final By SECTION_PROFESSIONAL_LIABILITY_INSURENCE=By.xpath("//div[contains(@class, 'menu')]//span[text() ='Professional Liability Insurance']");
    public static final By SECTION_PROFESSIONAL_LIABILITY_INSURENCE_INFO = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Professional Liability Insurance Information']");
    public static final By SECTION_PROVIDER_IDENTIFIER_NUMBER_GROUP = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider identifier number']");
    public static final By SECTION_PROVIDER_IDENTIFIER_ADDITIONAL_INFO_GENERAL_LIABILITY_NO_RADIO_BTN = By.xpath("(//input[contains(@name,'Do you have malpractice or general liability insurance?')])[2]");
    public static final By DROP_DOWN_CLAIM_SUBMISSION_METHOD = By.xpath("(//li[contains(@role,'option')])[2]");
    public static final By DROP_DOWN_CLAIM_SUBMISSION_METHOD_FOR_GRP = By.xpath("(//li[contains(@role,'option')])[1]");
    public static final By SECTION_PROVIDER_IDENTIFIERS = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Provider Identifiers']");
    public static final By SECTION_PROVIDER_ADDRESS_DETAILS = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Address Details']");
    public static final By SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Primary Service Location Information']");


    public static final By SECTION_PROVIDER__SERVICE_LOCATION = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Service Location']");


    public static final By SECTION_PROVIDER_SECONDARY_SERVICE_LOCATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Secondary Service Location Information']");
    public static final By SECTION_PROVIDER_KEY_PERSONNEL = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Key Personnel']");
    public static final By SECTION_PROVIDER_OWNERSHIP = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Ownership']");
    public static final By SECTION_TAXONOMY_SPECIALITY=By.xpath("//span[text()='Taxonomy / Specialty / Provider Type Information']");
    public static final By CLICK_TAXANOMY=By.xpath("//input[@name='Please select Taxonomy and Description']");
    public static final By NEXT_BUTTON=By.xpath("//span[text()='Next']");
    public static final By SELECT_TAXONOMY=By.xpath("//strong[text()='104100000X - SOCIAL WORKER']");
    public static final By SECTION_PROVIDER_EXCLUSION = By.xpath("//div[contains(@class, 'menu')]//span[contains(text(),'Exclusion/Sanction')]");
    public static final By SECTION_Classification = By.xpath(" //div[contains(@class, 'menu_menu-item')]//span[text() ='Classification']");
    public static final By SECTION_PROVIDER_PROGRAM_PARTICIPATION = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Taxonomy / Specialty / Provider Type / License Certification Information']");
    public static final By ADD_TAXONOMY=By.xpath("//button[@id='ppButton']");
    public static final By SECTION_PCP_ADDENDUM = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='PCP Addendum']");
    public static final By SECTION_AFFILIATION = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Affiliation']");
    public static final By ADD_AFFILIATION_BTN = By.xpath("//span[contains(.,'ADD AFFILIATION')]");
    public static final By AFFILIATION_PROVIDER_NAME_INPUT = By.xpath("//input[@id='providerNameNpi']");
    public static final By AFFILIATION_SEARCH_BTN = By.xpath("//button[contains(.,'Search')]");
    public static final By AFFILIATION_ADD_BTN = By.xpath("//button[@tabindex='0'][contains(.,'Add')]");
    public static final By AFFILIATION_TYPE_DROPDOWN = By.xpath("//label[contains(.,'Affiliation type')]//following::div[@role='button']");
    public static final String AFFILIATION_TYPE_DROPDOWN_LIST ="//li[contains(.,'%s')]";
    public static final By YES_RADIOBTN_FOR_PRIMARY_SERVICE_LOC = By.xpath("//span[contains(.,'Do you want to affiliate with Primary service location ?')]//following::div//input[contains(@value,'true')]");
    public static final By SELECT_PROGRAM_CHECKBOX = By.xpath("//input[contains(@value,'Program')]");
    public static final By YES_RADIOBTN_FOR_HOMELOCATION = By.xpath("(//input[@name='onlyHomeLocation'])[1]");
    public static final By YES_RADIOBTN_FOR_ACCEPTING_NEW_PATIENTS = By.xpath("(//input[@name='newPatient'])[1]");


    public static final By MANNER_OF_SERVICES_DROPDOWN = By.xpath("//label[contains(.,'Manner of services')]//following-sibling::div") ;
    public static final By AFFILIATION_POPUP_ADD_BUTTON = By.xpath("(//button[contains(.,'Add')])[2]") ;
    public static final By NEXT_AFFILIATION_Button = By.xpath("//*[text()='Next']");


    public static final By ADD_PROGRAM_PARTICIPATION_BUTTON = By.xpath("//button[contains(.,'ADD PROGRAM PARTICIPATION')]");
    public static final By ADD_PROGRAM_PARTICIPATION_LINK_BUTTON = By.xpath("//a[contains(.,'Add Specialty/Taxonomy')]");
    public static final By SELECT_PROGRAM_PARTICIPATION_DROPDOWN_LOCATION = By.xpath("//label[contains(.,'Select Specialty *')]/..//div");
    //    public static final String SELECT_TAXONOMY_CHECKBOX = " //div[contains(text(),'225100000X - PHYSICAL THERAPIST')]/..//input[@type='checkbox']";
//    public static final String SELECT_TAXONOMY_CHECKBOX = " //div[contains(text(),'Trading partner - 99')]/..//input[@type='checkbox']";
    public static final String SELECT_TAXONOMY_CHECKBOX = "//div[contains(@class,'sc-')]//input[contains(@type,'checkbox')]";
    //div[starts-with(@class,'sc-')][contains(.,'%s')]//input[contains(@type,'checkbox')]




    public static final By SELECT_PROGRAM_PARTICIPATION_DROPDOWN = By.xpath("//label[contains(text(),'Select Program Participation')]/following-sibling::div/div");
    public static final By SELECT_SPECIALITY_DROPDOWN = By.xpath("//label[contains(text(),'Select Specialty')]/following-sibling::div/div");
    public static final By ADD_LOCATION_BUTTON = By.xpath("//button[contains(.,'Add Location')]");
    public static final By LOCATION_NAME_TEXT_FIELD = By.xpath("//input[contains(@id,'lName')]");
    public static final By ADDRESS_LINE_TEXT_FIELD = By.xpath("//input[contains(@id,'line1')]");
    public static final By SERVICES_LOCATION_STATE_DROPDOWN = By.xpath("//label[contains(text(), 'State')]//following::div");


    public static final By SERVICES_LOCATION_CITY_TEXT_FIELD = By.xpath("//input[@id ='city']");
    public static final By SERVICES_LOCATION_ZIP_CODE_TEXT_FIELD = By.xpath("//input[contains(@id,'zip')]");
    public static final By SERVICES_LOCATION_COUNTY_CODE_TEXT_FIELD = By.xpath("//input[contains(@name,'County')]");
    public static final By CONTACT_ATTENTION_LINE_TEXT_FIELD = By.xpath("//input[contains(@id,'attLine')]");
    public static final By ATTENTION_LINE_IN_ADDRESS_DETAILS_SECTION=By.xpath("//input[contains(@aria-label,'Attention Line')]");
    public static final By CONTACT_PERSON_EMAIL_TEXT_FIELD = By.xpath("//label[contains(., 'Email')]//following::div//input");
    public static final By CONTACT_PHONE_TEXT_FIELD = By.xpath("//input[contains(@id,'phone')]");
    public static final By PHONE_IN_ADDRESS_DETAILS_SECTION=By.xpath("//div[@data-for='Phone']//input");
    public static final By PHONE_NUMBER_TEXT_FIELD = By.xpath("//input[contains(@id,'patientphone')]");
    public static final By MANNER_OF_SERVICES = By.xpath("//label[contains(., 'Manner of services')]//following::div");
    public static final By MAILING_ADDRESS=By.xpath("(//span[contains(text(),'Is the Mailing Address is same as the Service Location Address? *')]/..//following-sibling::div//div//div//label//span//span//input[@value='Yes'])[1]");


    //label[contains(@id, 'Manner of services')]//following::div
    public static final By MAILING_ADDRESS_CONTACT_DETAILS=By.xpath("//span[contains(text(),' Address Contact Details same as the Service Location Contact Information? *')]/..//following-sibling::div//div//div//label//span//span//input[@value='Yes']");
    public static final By NO_RADIOBTN_TO_CLAIM_INCLUDE_PRIOR_AUTHZTN = By.xpath("//span[contains(., 'Does your claim include prior authorization')]//following::div//label//input[@value = 'No']");
    public static final By LANGUAGE_SUPPORT_DROP_DOWN = By.xpath("(//label[contains(.,'Language Supported')]//..)[1]");
    public static final By GENDER_SERVED_DROP_DOWN = By.xpath("//label[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'gender served')]");
    public static final By ALL_AGE_CHECKBOX = By.xpath("//input[@name='allage']");
    public static final By NO_RADIOBTN_ACCEPTING_NEW_PATIENTS = By.xpath("//p[contains(., 'Accepting new patients')]//following-sibling::div//label//input[@value = 'No']");


    //  public static final By NO_RADIOBTN_ONLY_HOME_LOCATION = By.xpath("(//input[@name='onlyHomeLocation'])[2]");
    public static final By NO_RADIOBTN_ONLY_HOME_LOCATION = By.xpath("//div[contains(@class,'secondaryService_tax-question')]/following::div//input[@value='No']");


    public static final By COUNTY_RADIOBTN = By.xpath("//p[contains(., 'County')]//following-sibling::div//label//input[@value ='allCounty']");
    public static final By NO_RADIOBTN_LOCATION_TTD_EQUIPPED = By.xpath("//p[contains(., 'Is this location TTD/TTY equipped')]//following-sibling::div//label//input[@value = 'No']");
    public static final By YES_RADIOBTN_OPEN_LOCATION_24HOURS = By.xpath("//p[contains(., 'Is this location Open 24 Hours')]//following-sibling::div//label//input[@value = 'Yes']");
    public static final By YES_RADIOBTN_STORES_PATIENT_RECORDS = By.xpath("//p[contains(., 'Do you store patient records')]//following-sibling::div//label//input[@value = 'Yes']");
    public static final By YES_RADIOBTN_STORES_PERSONAL_RECORDS = By.xpath("//p[contains(text(),'Do you store employee and or privacy records at this location?')]/..//following-sibling::div//label[1]//span//span//input[@value='Yes']");
    public static final By NO_RADIOBTN_PROVIDER_EMERGANCY_SERVICES_24HRS = By.xpath("//p[contains(., 'Does this location provide urgent care')]//following-sibling::div//label//input[@value = 'No']");
    public static final By NO_RADIOBTN_WHEELCHAIR_ACCESSABILITY=By.xpath("(//p[contains(text(),'Does this location have wheelchair accessibility features like ramps, elevators, and wide doors? *')]/..//following-sibling::div//label[2]//span//span//input[@value='No'])[1]");
    public static final By NO_RADIOBTN_PARKING_SPACE=By.xpath("(//p[contains(text(),'Does this location have wheelchair accessibility features like ramps, elevators, and wide doors? *')]/..//following-sibling::div//label[2]//span//span//input[@value='No'])[2]");
    public static final By NO_RADIOBTN_ASSISITIVE_SERVICES=By.xpath("(//p[contains(text(),'Does this location have wheelchair accessibility features like ramps, elevators, and wide doors? *')]/..//following-sibling::div//label[2]//span//span//input[@value='No'])[3]");
    public static final By NO_RADIOBTN_ACCESIBLE_EXAM_ROOMS=By.xpath("(//p[contains(text(),'Does this location have wheelchair accessibility features like ramps, elevators, and wide doors? *')]/..//following-sibling::div//label[2]//span//span//input[@value='No'])[4]");
    //    public static final By ADD_TAXONOMY_BUTTON = By.xpath("//button[contains(.,'Add Taxonomy')]");
    public static final By ADD_TAXONOMY_BUTTON = By.xpath("//button[contains(.,'ADD TAXONOMY')]");
    public static final By ADD_LICENSE_BUTTON = By.xpath("//span[contains(.,'Add License/Certificate')]");
    public static final By LICENSE_TYPE_DROPDOWN = By.xpath("//label[contains(text(),'License/Certificate Type*')]/..//div//div");
    public static final By LICENSE_ISSUER_DROPDOWN = By.xpath("//label[contains(.,'Issuer')]//..");
    public static final By LICENSE_NUMBER_INPUT = By.xpath("//input[contains(@id,'lNum')]");
//    public static final By UPLOAD_LICENSE_BUTTON = By.xpath("//label[@for='licenseAddAttachments']//span[contains(.,'Upload')]");
    public static final By UPLOAD_LICENSE_BUTTON = By.xpath("(//label[@for='licenseAddAttachments']//span[contains(.,'Upload')])[2]");
    public static final By ADD_BUTTON = By.xpath("//div[contains(@class, 'add-license-footer')]//div[2]//button//span[text()='Add']");
    public static final By UPLOAD_ADDITIONAL_DOC=By.xpath("//div[contains(@data-for,'Additional Documents')]//span//span[contains(text(),'Upload Files')]");
    public static final By UPLOAD_DOC_FOR_PROFESSIONAL_TRAINING=By.xpath("//div[@data-for='Upload Training Document']//span[contains(.,'Upload')]");
    public static final By CONFIRM_BUTTON = By.xpath("//span[contains(.,'Confirm')]");
    public static final By PROGRAM_PARTICIPATION_SAVE_BUTTON2 = By.xpath("(//span[contains(.,'Save')])[2]");
    public static final By PROGRAM_PARTICIPATION_SAVE_BUTTON_IN_SERVICE_LOCATION = By.xpath("(//span[contains(.,'Save')])[3]");
    public static final By SAVE_BUTTON_INDEX1 = By.xpath("(//span[contains(.,'Save')])[1]");




    public static final By PROGRAM_ADD_LINE_SAVE = By.xpath("//td//div//div//span[contains(.,'Save')]");


    public static final By PROGRAM_PARTICIPATION_SAVE_BUTTON = By.xpath("(//span[contains(.,'Save')])[2]");
    public static final By UPLOAD_CLAIM_DOCUMENTS_BUTTON = By.xpath("//h1[contains(.,'Claims Documents')]//following::div//span[contains(.,'Upload')]");


    //    public static final By LICENSE_EFFECTIVE_START_DATE = By.xpath("(//label[contains(text(),'Effective start Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY'])[2]");
    public static final By LICENSE_EFFECTIVE_START_DATE = By.xpath("//label[contains(text(),'Licensure Effective start Date *')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    //    public static final By TAXONOMY_EFFECTIVE_START_DATE=By.xpath("//label[contains(text(),'Effective start Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");
    public static final By TAXONOMY_EFFECTIVE_START_DATE=By.xpath("//label[contains(text(),'Effective Start Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    //    public static final By TAXONOMY_EFFECTIVE_END_DATE=By.xpath("//label[contains(text(),'Effective end Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");
    public static final By TAXONOMY_EFFECTIVE_END_DATE=By.xpath("//label[contains(text(),'Effective End Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    //    public static final By LICENSE_EFFECTIVE_END_DATE = By.xpath("(//label[contains(text(),'Effective end Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY'])[2]");
    public static final By LICENSE_EFFECTIVE_END_DATE = By.xpath("//label[contains(text(),'Licensure Effective end Date *')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    public static final By EFFECTIVE_START_DATE=By.xpath("//label[contains(text(),'Effective Start Date *')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");
    public static final By EFFECTIVE_END_DATE=By.xpath("//label[contains(text(),'Effective End Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    //License/Certificate Number
    public static final By SELECT_TAXONOMY_DROPDOWN = By.xpath("//label[contains(.,'Select Taxonomy/Description')]//..");


    public static final By MANDATORY_FIELD = By.xpath("//span[contains(text(),'*')]");




    //Provider Identifiers Section
    public static final By SECTION_PROVIDER_IDENTIFIERS_LABEL = By.xpath("//h2[contains(.,'Provider Identifiers')]");
    public static final By SUB_SECTION_OTHER_MEDICAID_STATE_LABEL = By.xpath("//h2[contains(.,'Provider Identifiers')]");


    public static final By SECTION_OTHER_MEDICAID_STATE_LABEL = By.xpath("//h2[contains(.,'Other Medicaid State')]");
    public static final By SECTION_OTHER_MEDICAID_ERROR_POP_CLOSE_BTN = By.xpath("//span[text()='Close']");
    public static final By SECTION_ADDITIONAL_INFO_LABEL = By.xpath("//h2[contains(.,'Additional Information')]");
    public static final By NPI_TEXT_LABEL = By.xpath("//label[contains(.,'Do you have an NPI? *')]");


    public static final By PARTICIPANT_IN_MEDICARE_QUESTION = By.xpath("//label[contains(.,'Are you a participant in Medicare?')]");
    public static final By PARTICIPANT_IN_MEDICARE_QUESTION_RADIO_BTNS = By.xpath("//label[contains(.,'Are you a participant in Medicare?')]/following::div");


    public static final By MEDICAID_STATE_QUESTION = By.xpath("//label[contains(.,'enrolled in Medicaid or CHIP in your home state?')]");
    public static final By MEDICAID_STATE_QUESTION_RADIO_BTN = By.xpath("//label[contains(.,' enrolled in Medicaid or CHIP in your home state?')]/following::div");
    public static final By TEACHING_PROVIDER_QUESTION = By.xpath("//label[contains(.,'Are you a Teaching Provider?')]");
    public static final By TEACHING_PROVIDER_QUESTION_RADIO_BTN = By.xpath("//label[contains(.,'Are you a Teaching Provider?')]/following::div");
    public static final By TREATING_PROVIDER_QUESTION = By.xpath("//label[contains(.,'Are you a Treating Provider?')]");
    public static final By TREATING_PROVIDER_QUESTION_RADIO_BTN = By.xpath("//label[contains(.,'Are you a Treating Provider?')]/following::div");


    public static final By TEACHING_FACILITY_QUESTION_RADIO_BTN = By.xpath("//label[contains(.,'Are you a Teaching Facility?')]/following::div");
    public static final By TEACHING_FACILITY_QUESTION = By.xpath("//label[contains(.,'Are you a Teaching Facility?')]");


    public static final By INDIAN_HEALTH_SERVICES_QUESTION = By.xpath("//label[contains(.,'Are you in Indian Health Services (IHS)')]");
    public static final By INDIAN_HEALTH_SERVICES_RADIO_BTN = By.xpath("//label[contains(.,'Are you in Indian Health Services (IHS)')]/following::div");


    public static final By NPI_RADIO_BTNS = By.xpath("//label[contains(.,'Do you have an NPI? *')]/following::div");
    public static final By NPI_RADIO_BTN_ERROR_MESG = By.xpath("//label[contains(.,'Do you have an NPI? *')]/following::li[contains(.,'This field is required')]");
    public static final By PARTICIPANT_MEDICARE_ADD_LINE_TABLE = By.xpath("(//span[contains(.,'+ Add Line')])[1]");
    public static final By PARTICIPANT_MEDICARE_ADD_LINE_BUTTON = By.xpath("(//span[contains(.,'+ Add Line')])[2]");
    public static final By PARTICIPANT_MEDICARE_ID_INPUT = By.xpath("//input[contains(@id,'Medicare Id')]");
    public static final By PARTICIPANT_MEDICAID_STATE_ADD_LINE_BUTTON = By.xpath("//div[@class='assist-table-add-btn']//button");
    public static final By PARTICIPANT_OTHER_MEDICAID_STATE_PRGM_DROPDOWN = By.xpath("//input[contains(@id,'Other Medicaid State')]/..//div[@role='button']");
    public static final By PARTICIPANT_MEDICARE_SAVE_BTN = By.xpath("//span[contains(text() ,'Save')]");
    public static final By VALIDATION_ERRORS_ON_POPUP_WINDOW = By.xpath("//span[contains(.,'Validation Errors')]//following::div[1]");
    public static final By PARTICIPANT_MEDICAID_STATE_PRGM_DROPDOWN = By.xpath("//input[contains(@id,'State Program')]/..//div[@role='button']");
    public static final By PARTICIPANT_DROPDOWN_LIST = By.xpath("//ul[contains(@role,'listbox')]//li");


    public static final By SELECT_APPLICATION_TYPE_DETERMINATION = By.xpath(".//input[@value='To ONLY bill for services and receive payment directly from Medicaid. **']");
    public static final By APPLICATION_TYPE_DET_FIRST = By.xpath(".//input[contains(@value, 'To ONLY participate in the network of a Medicaid health plan')]");
    public static final By SELECT_PRACTICE_TYPE = By.xpath(".//input[@value='SOLE PROPRIETOR']");


    // public static final By SECTION_PROVIDER_EXCLUSION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Exclusion/Sanction Information']");
    public static final By SECTION_EFT_Information = By.xpath("//div[contains(@class, 'menu')]//span[text() ='EFT Information']");
    public static final By SECTION_IDENTIFYING_INFORMATION = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Identifying Information']");
    public static final By SECTION_PROVIDER_AUTHORIZED_SIGNATURE = By.xpath("//span[contains(text(),'Authorized')]/..//../div[contains(@class, 'menu')]");
    //    public static final By SECTION_PROVIDER_PROVIDER_AGREEMENT = By.xpath("//div[contains(@class, 'menu')]//span[contains(text(),'Agreement')]");
    public static final By SECTION_PROVIDER_PROVIDER_AGREEMENT = By.xpath("//*[@type='checkbox']");
    public static final By SECTION_UPLOAD_DOCUMENTS = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Upload Documents']");
    public static final By INPUT_UPLOAD_DOCUMENTS = By.xpath(".//input[@type='file']");
    public static final By LINK_DASHBOARD = By.xpath("//a//button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'navigate to dashboard')]");
    public static final By BUTTON_BACKTOLOGIN = By.xpath("//span[contains(@class, 'jss136')]");
    public static final By ENROLLMENT_FEE = By.xpath("//div[contains(@class, 'section_section-header')]//b");
    public static final By OPTION_FROM_LISTBOX = By.xpath("//ul[@role='listbox']//li//strong");


    public static final By COMBOBOX_PROGRAM_PARTICIPATION = By.xpath("//label[text()='Program participation']//ancestor::div[contains(@role, 'combobox')]//input");
    public static final By TEXT_FIELD_NPI = By.xpath("//input[contains(@id, 'National provider identification')]");
    //    public static final By TEXT_FIELD_NEW_NPI = By.xpath("//input[contains(@id, 'NPI')]");
    public static final By TEXT_FIELD_NEW_NPI = By.xpath("//input[starts-with(@id,'NPI')]");
    public static final By NPI_FOR_TABLE=By.xpath("//input[contains(@aria-label,'NPI')]");
    //    public static final By NPI_IN_KEY_PERSONAL=By.xpath("//input[@aria-label='NPI']");
    public static final By NPI_IN_KEY_PERSONAL=By.xpath("//*[contains(@id, 'NPI-')]");
    public static final By LABEL_FIELD_NPI_NUM = By.xpath("(//label[contains(.,'NPI Number *')])[2]");


    public static final By TEXT_FIELD_NCPDP = By.xpath("//input[contains(@id, 'NCPDP')]");
    public static final By RADIOBUTTON_DEA_NUMBER = By.xpath("//input[contains(@name, 'DEA')][@value='false']");
    public static final By RADIOBUTTON_BILL_LABORATORY_SERVICES = By.xpath("//input[contains(@name,'laboratory')][@value='false']");
    public static final By RADIOBUTTON_MEDICAL_SERVICES = By.xpath("//input[contains(@name,'Medical')][@value='true']");
    public static final By RADIOBUTTON_TREATING_PROVIDER = By.xpath("//input[contains(@name,'Treating')][@value='true']");
    public static final By RADIOBUTTON_ELECTRONIC_DATA_INTERCHANGE = By.xpath("//input[contains(@name,'Electronic Data Interchange')][@value='true']");
    public static final By RADIOBUTTON_OTHER_MEDICAID_STATE = By.xpath("//input[contains(@name,'Medicaid')][@value='true']");


    public static final By TEXT_FIELD_SSN_PHARMACY = By.xpath("//div[@data-for='SSN']//input");
    public static final By TEXT_FIELD_SSN_ENTITY = By.xpath("(//input[@aria-invalid='false'])[4]");
    public static final By COMBOBOX_TYPE_BUSINESS = By.xpath("//label[contains(text(), 'business')]//ancestor::div[@role='combobox']");
    public static final By OPTION_GENDER = By.xpath("//ul[@role='listbox']//li");
    public static final By CALENDAR_DOB = By.xpath("//label[text()='Date of Birth *']/following::div/input[@placeholder='MM/DD/YYYY']");
    public static final By COMBOBOX_PROVIDER_TYPE = By.xpath("//label[text()='Provider type']//ancestor::div[contains(@role, 'combobox')]//input");
    public static final By RADIOBUTTON_INDIVIDUAL = By.xpath("//input[@value='Individual']");


    public static final By YES_RADIOBUTTON_NPI_NUMBER = By.xpath("//input[contains(@name, 'NPI')][@value='true']");
    public static final By DO_YOU_HAVE_NPI_YES_RADIO = By.xpath("//input[contains(@name, 'NPI')][@value='Yes']");


    public static final By NO_RADIOBUTTON_NPI_NUMBER = By.xpath("//input[contains(@name, 'NPI')][@value='false']");
    public static final String RADIOBUTTON_NPI_NUMBER = "//input[contains(@name, 'NPI')][@value='%s']";
    public static final String RADIOBUTTON_ARE_YOU_TEACHING_FACILITY = "//input[contains(@name,'Are you a Teaching Facility?')][@value='%s']";


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
    public static final By TEXT_FIELD_MANAGING_EMPLOYEE_TYPE = By.xpath(".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div");
    public static final By SELECT_TEXT_FIELD_MANAGING_EMPLOYEE_TYPE=By.xpath("//ul[@role='listbox']/li[@data-value ='Director']");
    //    public static final By TEXT_FIELD_MANAGING_EMPLOYEE_TYPE = By.xpath(".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div");
    public static final By BED_TYPE = By.xpath("//label[@id ='Bed Type']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By NO_OF_BEDS = By.xpath("//input[contains(@id, 'No of Beds')]");


    public static final By NO_OF_BEDS_SECTION = By.xpath("//p[contains(text(),'Select the types of beds')]");




    public static final By TEXT_FIELD_LICENSE_FIRST_NAME = By.xpath("//input[contains(@aria-label, 'First Name')]");
    public static final By TEXT_FIELD_LICENSE_LAST_NAME = By.xpath("//input[contains(@aria-label, 'Last Name')]");
    public static final By TEXT_FIELD_COUNTRY_OF_BIRTH = By.xpath("//label[contains(., 'Country of Birth')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By TEXT_FIELD_STATE_OF_BIRTH = By.xpath("//label[@id ='State of Birth']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By COMBOBOX_TYPE_IDENTIFIERS = By.xpath("//label[@id='Type']//ancestor::div[contains(@class, 'sc-bdVaJa')]//div[@role='button']");
    public static final By TEXT_FIELD_IDENTIFIER = By.xpath("//input[contains(@id, 'Identifier')]");
    public static final By COMBOBOX_TAXONOMY_DESCRIPTION = By.xpath("//label[text()='Taxonomy Description']//ancestor::div[@role='combobox']//input");
    public static final By RADIOBOX_REQUEST_RETROACTIVE = By.xpath("//span//input[@value ='true']");


    public static final String RADIOBUTTON_EXCLUSION_FRAUD_THEFT = "//input[contains(@name, 'Fraud, theft, embezzlement')][@value='%s']";




    //    public static final By RADIOBUTTON_EXCLUSION_FRAUD_THEFT = By.xpath("//input[contains(@name, 'Fraud, theft, embezzlement')][@value='false']");
    public static final String YES_RADIOBUTTON_EXCLUSION_FRAUD_THEFT = "//input[contains(@name, 'Fraud, theft, embezzlement')][@value='%s']";


    public static final String RADIOBUTTON_EXCLUSION_FINANCIAL_MISCONDUCT = "//input[contains(@name, 'Financial misconduct')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_PERJURY = "//input[contains(@name, 'Perjury')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_ABUSE_NEGLECT = "//input[contains(@name, 'Abuse or neglect of a patient')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_OBSTRUCTION_CRIMINIAL = "//input[contains(@name, 'Obstruction of a criminal investigation')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_UNLAWFUL_MANUFACTURE = "//input[contains(@name, 'Unlawful manufacture')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_HEALTHCARE_RELATED_CRIME = "//input[contains(@name, 'Health care related crime')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_CONVICTED_FELONY="//input[contains(@name, 'Been convicted of a felony, had adjudication withheld on a felony, pled nolo contendere to a felony')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_FAILED_GRANT_ACCESS = "//input[contains(@name, 'Failed to grant immediate access')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_REVOCATION_OR_SUSPENSION="//input[contains(@name, 'Revocation or suspension of accreditation')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_REVOCATION_OR_SUSPENSION_OF_A_LICENSE="//input[contains(@name, 'Revocation or suspension of a license to provide health care')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_SUSPENSION_EXCLUSION_DEBARMENT="//input[contains(@name, 'Suspension, exclusion, debarment, or sanction from participation by a Federal')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_CURRENT_PAYMENT_SUSPENSION="//input[contains(@name, 'Current payment suspension with Medicare or another State Medicaid agency')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_CURRENT_OVERPAYMENT="//input[contains(@name, 'Current overpayment with Medicare or another State Medicaid agency exceeding $1,500')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_FAILED_DISCLOSURE_INFORMATION = "//input[contains(@name, 'Failed to provide disclosure information')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_CONVICTES_FELONY = "//input[contains(@name, 'Revocation or suspension of a license to provide health care')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_REVOCATION_SUSPENSION_ACCREDITATION = "//input[contains(@name, 'Revocation or suspension of accreditation')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_SANCTION_SUSPENDED_PAYMENTS_FROM_MEDICARE = "//input[contains(@name, 'been employed by a corporation, business or professional association that has ever been suspended')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_SANCTION_DENIED_ENROLLMENT="//input[contains(@name, 'Had suspended payments from Medicare or Medicaid in any state, or been employed by a corporatio')][@value='%s']";
    public static final String RADIOBUTTON_EXCLUSION_DISCIPLINARY_ACTION = "//input[contains(@name, '3. Had any disciplinary action taken against any business')][@value='No']";
    public static final String RADIOBUTTON_EXCLUSION_JUDGEMENT_FALSE_CLAIMS_ACT = "//input[contains(@name, 'under the False Claims')][@value='%s']";
    //    public static final String RADIOBUTTON_EXCLUSION_JUDGEMENT_FALSE_CLAIMS_ACT = "//input[contains(@name, 'Judgment under the False Claims')][@value='%s']";




    public static final String RADIOBUTTON_EXCLUSION_OWES_MONEY = "//input[contains(@name, 'Owes money to Medicaid or Medicare that has not been paid?')][@value='%s']";


    public static final By INPUT_SELECT_OWNERSHIP_SECTION = By.xpath("//input[contains(@name,'1. Select Ownership Code')]");
    public static final By RADIOBUTTON_OWNERSHIP_OWNERSHIP_ORGANIZATION = By.xpath("//input[contains(@name, 'ownership in any organization that has billed')][@value='false']");
    public static final By GOVT_CITY=By.xpath("//strong[text()='Government - City']");
    public static final By RADIOBUTTON_OWNERSHIP_Managed_directed = By.xpath("//input[contains(@name, 'managed or directed any organization')][@value='false']");
    public static final By RADIOBUTTON_OWNERSHIP_INTEREST = By.xpath("//input[contains(@name, 'ownership interest of 5% or greater')][@value='false']");
    public static final By RADIOBUTTON_OWNERSHIP_IMMIDIATE_FAMILY = By.xpath("//input[contains(@name, 'members of your immediate family')][@value='false']");
    public static final By RADIOBUTTON_OWNERSHIP_RELATIONSHIP_AGREEMENT = By.xpath("//input[contains(@name, 'relationship or agreement')][@value='false']");
    public static final By RADIOBUTTON_OWNERSHIP_OWNERSHIP_ENTITY = By.xpath("//input[contains(@name, 'ownership in any entity that has billed')][@value='No']");
    public static final By RADIOBUTTON_OWNERSHIP_MANAGED_DIRECTED_BY_ENTITY = By.xpath("//input[contains(@name, 'managed, directed, or controlled any entity')][@value='No']");


    public static final By NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_PERSON_HAVE_5_PERCENTAGE_OWNERSHIP = By.xpath("//input[contains(@name,'Does any person have a 5% or greater ownership or control interest')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_ARE_THERE_ANY_OWNERS_WITHLESSTHAN_5=By.xpath("//input[contains(@name,'Are there any owners with less than 5%')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_ENTITY_HAVE_5_PERCENTAGE_OWNERSHIP = By.xpath("//input[contains(@name,'Does any entity have a 5% or greater ownership or control interest')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_PERSON_OR_ENTITY_HAVE_5_PERCENTAGE_INTEREST = By.xpath("//input[contains(@name,'Does any person or entity have a 5% or more interest in any mortgage')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_DOES_THE_ENROLLING_PROVIDER = By.xpath("//input[contains(@name,'Does the enrolling provider or its owners have any ownership')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_ENROLLING_PROVIDER_ORGANIZED_AS_A_PARTNERSHIP = By.xpath("//input[contains(@name,'Do any immediate family members of the provider')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_HAS_THE_ENROLLING_PROVIDER_CONTACTED_AS_ANY_MNGT_FUNCTION = By.xpath("//input[contains(@name,'Has the enrolling provider contracted or delegated any of its management functions')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP_DO_ANY_IMMEDIATE_FAMILY_MEMBER_HAVE_5PERCENTAGE_OWNERSHIP = By.xpath("//input[contains(@name,'Do any immediate family members of the provider or owner(s) have ownership of 5%')][@value='No']");
    public static final By NO_RADIOBUTTON_OWNERSHIP__DOES_ANY_PROVIDER_HAVE_CONTROL_INTEREST_ON_CURRENTLY_BILLING = By.xpath("//input[contains(@name,'9. Does the enrolling provider or its owners have any ownership or control interest in any entity that is currently billing or has billed Medicare')][@value='false']");




    public static final By TEXT_FIELD_EMPLOYEE_STATUS = By.xpath(".//label[contains(text(), 'Employee Status')]/parent::div//input/preceding-sibling::div");
    public static final By SELECT_TEXT_FIELD_EMPLOYEE_STATUS=By.xpath("//ul[@role='listbox']/li[text()='Managing Non-Convicted']");
    //    public static final By EFT_FINANCIAL_INSTITUTION = By.xpath("//input[contains(@id,'Name of the financial Institution')]");
//    public static final By EFT_ROUTING_NUMBER = By.xpath("//input[contains(@id,'Routing number of EFT')]");
    public static final By EFT_ROUTING_NUMBER = By.xpath("//div[@data-for='Routing Number of EFT']//input");
    public static final By ACCOUNT_HOLDER_NAME=By.xpath("//input[contains(@aria-label,'Name of the Account Holder')]");
    public static final By EFT_FINANCIAL_INSTITUTION = By.xpath("//input[contains(@aria-label,'Name of the Financial Institution')]");


    public static final By EFT_ACCOUNT_NUMBER = By.xpath("//div[@data-for='Account Number']//div//div//div//input");
    public static final By EFT_ACCOUNT_TYPE = By.xpath("//div[contains(@id,'Account Type')]");
    public static final By EFT_ACCOUNT_TYPE_LIST = By.xpath("//div[contains(@id,'react-auto')]/ul/li");
    public static final By MANDATORY_FIELDS = By.xpath("//div[@data-for='EFT Information']/following::label");
    public static final By CALANDER_START_DATE = By.xpath("//label[text()='" + Data.START_DATE + "']/following::div/input[@placeholder='MM/DD/YYYY']");
    public static final By CALANDER_EFFECTIVE_START_DATE = By.xpath("//label[text()='" + Data.EFFECTIVE_START_DATE + "']/following::div/input[@placeholder='MM/DD/YYYY']");


    public static final By TEXT_FIELD_ADDRESS = By.xpath("//div[contains(@data-for,'Address Line 1')]//following::input[@id='line1']");
    public static final By TEXT_FIELD_ADDRESS1 = By.xpath("//div[@data-for ='Address Line 1']//div[1]");


    //MAILING ADDRESSES
    public static final By TEXT_FIELD_MAILING_ADDRESS_CITY = By.xpath("//input[contains(@aria-label, 'City')]");




    //  public static final By DROP_DOWN_MAILING_ADDRESS_STATE = By.xpath("//div[@data-for='State']//input");
    public static final By DROP_DOWN_MAILING_ADDRESS_STATE = By.xpath("//input[contains(@name,'State')]");


    //  public static final By TEXT_FIELD_ZIP_CODE = By.xpath("//input[@id='zipPlusFour']");


    public static final By TEXT_FIELD_MAILING_ZIP_CODE = By.xpath("//div[contains(@label,'ZIP')]//input");


    ;
    public static final By TEXT_FIELD_MAILING_ZIP_CODE2 = By.xpath("//div[contains(@data-for,'Zip')]//input");


    //     public static final By TEXT_FIELD_MAILING_ZIP_CODE = By.xpath("//div[contains(@label,'Mailing Address Zip')]//input");


    // public static final By TEXT_MAILING_COUNTY_CODE = By.xpath("//label[contains(text(), 'County')]//ancestor::div[@role ='combobox']//input");
    public static final By TEXT_MAILING_COUNTY_CODE = By.xpath("//label[contains(text(), 'County')]//following::div[1]/input");
    //public static final By TEXT_MAILING_COUNTY_CODE = By.xpath("//div[contains(@label,'Mailing Address County Code')]//input");


//    public static final By DROP_DOWN_STATE_OF_BIRTH = By.xpath("(//label[@id='State']/following::div/div/div)[1]");


    public static final By DROP_DOWN_ADDRESS_STATE = By.xpath(" //label[(text() ='State')]//following::div[@role='button']");


    // (//label[(text() ='State')]//following::div/div/div)[1]


    //    public static final By TEXT_FIELD_MAILING_ADDRESS_CITY = By.xpath("//input[contains(@id,'Mailing Address City')]");
    public static final By TEXT_FIELD_ZIP_CODE = By.xpath("//div[@data-for='ZIP Code']//input");


    public static final By TEXT_FIELD_ZIP_CODE1 = By.xpath("//div[@data-for='Zip Code']//input");


//    public static final By TEXT_MAILING_COUNTY_CODE = By.xpath("//div[contains(@label,'Mailing Address County Code')]//input");


    //PRIMARY ADDRESSES
    public static final By TEXT_PRIMARY_COUNTY_CODE = By.xpath("//div[contains(@label,'Primary Service Location County')]//input");
    public static final By TEXT_FIELD_PRIMARY_ZIP_CODE = By.xpath("//div[contains(@label,'Primary Service Location ZIP')]//input");
    public static final By TEXT_FIELD_PRIMARY_ZIP_CODE2 = By.xpath("//div[contains(@label,'Primary Service Location Zip')]//input");


    public static final By DROP_DOWN_PRIMARY_ADDRESS_STATE = By.xpath("//input[@aria-label='Primary Service Location State']");
    public static final By TEXT_FIELD_PRIMARY_ADDRESS_CITY = By.xpath("//input[contains(@id,'Primary Service Location City')]");
    public static final By TEXT_ADDRESS_CITY = By.xpath("//input[contains(@aria-label,'City')]");


    public static final By TEXT_FIELD_CONTACT_ATTENTION_LINE = By.xpath("//input[contains(@aria-label, 'Attention Line')]");
    public static final By TEXT_FIELD_ZIP_CODE2 = By.xpath("//div[@label='Mailing - Service Location Zip']//input");
    public static final By TEXT_FIELD_CONTACT_FIRST_NAME = By.xpath("//input[contains(@aria-label, 'First Name')]");
    public static final By TEXT_FIELD_CONTACT_LAST_NAME = By.xpath("//input[contains(@aria-label, 'Last Name')]");
    public static final By TEXT_FIELD_CONTACT_PHONE = By.xpath("//div[@data-for='Phone']//input[contains(@placeholder, '(___)___-____')]");
    public static final By TEXT_FIELD_CONTACT_PERSON_EMAIL = By.xpath("//input[contains(@aria-label, 'Email')]");


    public static final By TEXT_LABEL_SUMMARY_HEADING = By.xpath("//h3[contains(.,'Summary')]");
    public static final By TEXT_LABEL_SUMMARY_VERBIAGE = By.xpath("//h3[contains(.,'Summary')]//following-sibling::p");




    public static final By CHECKBOX_SIGN_AND_AGREE_SUMMARY = By.xpath("//span[contains(text(), 'Sign and agree to Terms and Conditions')]/..//input[@type='checkbox']");


    public static final By TEXT_FIELD_LICENSE_NUMBER1_PHARMACY = By.xpath("(//input[contains(@id, 'License Number')])[1]");
    public static final By DROP_DOWN_LICENSE_EFFECTIVE_DATE1_PHARMACY = By.xpath("(//label[text()='License Effective Date *']/../div//div//button[@type='button'])[1]");
    public static final By TEXT_FIELD_LICENSE_NUMBER2_PHARMACY = By.xpath("(//input[contains(@id, 'License Number')])[2]");
    public static final By DROP_DOWN_LICENSE_ISSUE_STATE2_PHARMACY = By.xpath(".//label[contains(text(), 'State')]/parent::div//input/preceding-sibling::div");
    public static final By DROP_DOWN_LICENSE_EFFECTIVE_DATE2_PHARMACY = By.xpath("(//label[text()='License Effective Date *']/../div//div//button[@type='button'])[2]");




    //AUTHORIZED SIGNATURE
    public static final By TEXT_FIELD_TITLE_OF_PERSON = By.xpath("//input[contains(@aria-label, 'Title')]");
    public static final By TEXT_FIELD_NAME_OF_AUTHORIZED = By.xpath("//input[contains(@aria-label, 'Name of Authorized')]");
    public static final By LABEL_NAME_OF_AUTHORIZED_SIGNATURE = By.xpath("//label[contains(text(), 'Name of Authorized Individual Submitting Enrollment & Signing)]");
    public static final By LABEL_TITLE_OF_AUTHORIZED_SIGNATURE = By.xpath("//label[contains(text(), 'Title of Person Submitting Enrollment')]");
    public static final By VALIDATION_AUTHORIZED_SIGNATURE = By.xpath("//div[contains(@class,'section-group')]//ul/li");


    // PAYMENT
    public static final By BUTTON_GO_TO_PAYMENT = By.xpath("//span[contains(.,'Go To Payment')]");
    public static final By BUTTON_SUBMIT = By.xpath("//span[contains(.,'SUBMIT')]");
    public static final By TEXT_FIELD_BILLING_EMAIL = By.xpath("//span//input[@id='email']");
    public static final By TEXT_FIELD_BILLING_ZIP = By.xpath("//span//input[@id='billingPostalCode']");
    public static final By TEXT_FIELD_CARD_NUMBER = By.xpath("//span//input[@id='cardNumber']");
    public static final By TEXT_FIELD_CVC = By.xpath("//span//input[@id='cardCvc']");
    public static final By TEXT_FIELD_EXPIRATION_DATE = By.xpath("//span//input[@id='cardExpiry']");
    public static final By TEXT_FIELD_FULL_NAME_ON_CARD = By.xpath("//span//input[@id='billingName']");
    public static final By BUTTON_SUBMIT_CREDIT_CARD = By.xpath("//div[@class='SubmitButton-IconContainer']");


    // HELLO SIGN
    public static final By BUTTON_PROCEED_TO_SIGN = By.xpath("//span[contains(text() ,'PROCEED TO SIGN')]");
    public static final By BUTTON_GET_STARTED = By.xpath("(//div[contains(@class,'m-signature')])[3]/div/button/span[text()='Get started']");
    public static final By AUTHORIZED_OFFICIAL_NAME=By.xpath("//textarea[contains(@placeholder,'Authorized_Official_Name')]");
    public static final By TEXT_FIELD_FIRST_NAME_HELLO_SIGN = By.xpath("//div//textarea[@placeholder='Full Name']");
    public static final By SECTION_TYPE_IN = By.xpath("//li[@id='signature-modal-tab-T']"); //By.xpath("//ol//li[@title='Type it in']");
    public static final By SECTION_TYPE_SIGNATURE = By.xpath("//div[@data-qa-ref='hello-modal']//input");
    public static final By BUTTON_INSERT_HELLO_SIGN = By.xpath("//button[@data-qa-ref='singing-modal--insert-btn']");
    //    public static final By SECTION_SUMMARY = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Summary']");
    public static final By SECTION_SUMMARYY = By.xpath("(//div[contains(@class, 'menu')]//span[text() ='Summary'])[2]");
    public static final By SECTION_SUMMARY = By.xpath("//div[contains(@class,'menu-item')]//span[.='Summary']");




    public static final By SECTION_ADDRESS_DETAILS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Address Details']");
    public static final By SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX = By.xpath("//span[contains(., 'Sign and agree to Terms and Conditions')]/..//input");


    public static final By searchResultText = By.xpath("//div//h2[contains(text(),'Search results')]");
    public static final String tableInfo = "//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div";
    public static final By ENTITY_CODE_DROPDOWN = By.xpath("//div[@id='react-autowhatever-1']/ul/li");
    public static final By NPI_NUMBER_Error_MASSAGE = By.xpath("//p[text()='Enter valid NPI number']");
    public static final By REQUESTED_ENROLMENT_LABEL = By.xpath("//label[contains(text(),'Select Requested Enrollment Date')]");
    public static final By REQUESTED_ENROLMENT_ERROR_MESSAGE = By.xpath("//label[contains(text(),'Select Requested Enrollment Date')]//following::div//li");


    public static final By REQUESTED_ENROLMENT_DATE_FEILD = By.xpath("//label[contains(text(),'Select Requested Enrollment Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    //label[contains(text(),'Select Requested Enrollment Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']
    public static final By INPUT_FEILD_LEGAL_BUSINESS_NAME = By.xpath("//input[contains(@aria-label,'Legal Business Name')]");
    public static final By INPUT_FEILD_DBA = By.xpath("//input[contains(@aria-label,'DBA')]");
    //    public static final By FEIN_Number = By.xpath("//div[@label='FEIN']/input");
//    public static final By INPUT_FEILD_FEIN_NUMBER = By.xpath("//input[@aria-label='FEIN Number']");
    public static final By FEIN_NUM=By.xpath("//div[contains(@data-for,'FEIN Number')]//input");
    public static final By INPUT_FEILD_FEIN_NUMBER = By.xpath("//input[@placeholder='__-_______']");
    public static final By ADDRESS_LINE1 = By.xpath("//input[contains(@id,'line1')]");
    public static final By APPLICATION_CONTACT_EMAIL = By.xpath("//input[contains(@aria-label,'Application Contact Email')]");
    public static final String IDENTIFICATION_SECTION_DIFFERENT_DBA_NAME_RADIO_BTN_VALUE = "//input[contains(@name,'Have you used a different DBA Name/Legal Business Name?')][@value='No']";
    //  different DBA Name/Legal
    public static final String IDENTIFICATION_SECTION_APPLICATION_CHANGE_RADIO_BTN_VALUE = "//input[contains(@name,'Is this application due to a change of ownership/FEIN?')][@value='No']";


    public static final String IDENTIFICATION_SECTION_1099_TAX_EXEMPT_RADIO_BTN_VALUE = "//input[contains(@name,'Are you 1099 tax exempt')][@value='No']";


    public static final By CITY = By.xpath("//input[contains(@id,'City')]");
    public static final By STATE = By.xpath("//input[@name='State']");
    public static final By ZIP_CODE = By.xpath("//div[@data-for='ZIP Code']/input");
    public static final By COUNTY = By.xpath("//label[text()='County']/following::input");
    public static final By CLASSIFICATION_SECTION = By.xpath("//div[contains(@class, 'menu')]//span[text() ='Classification']");
    public static final By CLASSIFICATION_RADIO_BUTTONS = By.xpath("//div[@data-for='Classification']/following::label/span[2]");
    public static final By CLASSIFICATION_CLEARINGHOUSE = By.xpath("//input[@value='Clearinghouse']");
    public static final By NPI_RADIO_BUTTON_NO = By.xpath("//input[contains(@name,'Do you have an NPI') and @value='false']");
    public static final By NPI_RADIO_BUTTON_YES = By.xpath("//input[contains(@name,'Do you have an NPI') and @value='true']");
    public static final By DROPDOWN = By.xpath("//ul/li/ancestor::div[@role='document']");
    public static final By DROPDOWN2 = By.xpath("//li[@data-value='Managing Non Convicted']/ancestor::ul/li");
    public static final By DROPDOWN3 = By.xpath("//li[@data-value='United States']/ancestor::ul/li");
    public static final By DROPDOWN4 = By.xpath("//li[@data-value='Alabama']/ancestor::ul/li");
    public static final By VALIDATION_ERRORS = By.xpath("//div[contains(@style,'padding')]/p");
    public static final By EXCLUSION_SECTION_A_QUESTIONS = By.xpath("(//div[contains(@class,'section_section-group')])[1]//label[contains(@data-for,'.')]");
    public static final By EXCLUSION_SECTION_B_QUESTIONS = By.xpath("(//div[contains(@class,'section_section-group')])[2]//label[contains(@data-for,'.')]");
    public static final By EXCLUSION_SANCTION_QUESTIONS = By.xpath("//label[@data-tip='true']");
    public static final By TRADING_PARTNER_AGREEMENT_TEXT = By.xpath("//div[contains(@class, 'menu_menu-inner')]//span[10]");
    public static final String SECTION_OWNERSHIP_RADIO1 = "//input[contains(@name,'Have you ever had ownership in any entity that has billed')][@value='No']";
    public static final String SECTION_OWNERSHIP_RADIO2 = "//input[contains(@name,'Have you ever managed, directed, or controlled any entity')][@value='No']";
    public static final By OWNERSHIP_QUESTIONS = By.xpath("//label[@data-tip='true']");
    public static final By OWNERSHIP_SELECT_PROGRAM = By.xpath("//label[@id ='Select Program']//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By CLASSIFICATION_SEC_ENTITY_CODE_LABEL = By.xpath("//label[text()='Entity Code']");


    public static final By PEM_TEXT_FIELD_PHONE_NUMBER = By.xpath("//div[@data-for='Phone']//input");


    public static final By KEY_PERSONNEL_PARTNER_HEADER = By.xpath("//h2[text()='Partner']");


    //ENROLL PROVIDER INFORMATION FIELDS
    public static final By ENROLL_PROVIDER_EMAIL = By.xpath("//label[contains(text(),'Email')]/../div/div/textarea[3]");
    public static final By ENROLL_PROVIDER_FIRST_NAME = By.xpath("//label[contains(text(),'First Name')]/../div/div/textarea[3]");
    public static final By ENROLL_PROVIDER_LAST_NAME = By.xpath("//label[contains(text(),'Last Name')]/../div/div/textarea[3]");
    public static final By ENROLL_PROVIDER_PROCEED = By.xpath("//button[contains(.,'Proceed')]");
    public static final By ENROLL_PROVIDER_HAVE_EMAIL_NO_XPATH = By.xpath("//input[contains(@type, 'radio')][@value='false']");


    public static final By TXT_BOX_TITLE = By.xpath(".//div[@ data-field='Title']//textarea[@placeholder='Title']");
    public static final By BTN_CONTINUE = By.xpath(".//button[@data-btn='common']/span['Continue']");
    public static final By BTN_AGREE = By.xpath(".//button[@data-qa-ref='button-agree']");
    public static final By BTN_NEXT= By.xpath(".//div[contains(@class,'root_content')]/div/div/div[4]/button['Next']");
    public static final By MESSAGE_INBOX = By.xpath("//a[contains(@href, '/inbox')]//button");
    public static final By SELECT_VIEW_OPTION = By.xpath("(//li[@role='menuitem'])[1]");
    public static final By First_MESSAGE_IN_INBOX = By.xpath("(//div[contains(@class, 'letter-buttons')]//button[@aria-label='More'])[1]");
    public static final By MESSAGE_CONTENT_InBOX = By.xpath("(//div[contains(@class,'message-center')]/following::a)[1]");
    public static final By PROVIDER_DASHBOARD_REENROLLMENT_APPLICATION_BUTTON =  By.xpath("//button[contains(.,'RE-ENROLLMENT APPLICATION')]") ;
    public static final By SELECT_DO_U_WANT_TO_AFFILIATE_WITH_INDI=By.xpath("//span[text()='Yes']");
    public static final By HOME_CORP_OFFICE_ADDRESS=By.xpath("//input[contains(@name,'Is Home/Corp Office Address is same as the Pay To Address?')][@value='Yes']");
    public static final By HOME_OR_CORP_OFC_ADDRESS=By.xpath("//input[contains(@name,'Is Home/Corp Office Address is same as the Mailing Address')][@value='Yes']");


    public static final By HOME_OR_CORP_OFC_CONTACT_PERSON_DETAILS_PEM=By.xpath("//input[contains(@name,'Home/Corp Office Contact Person Details same as Mailing Contact Person Details')][@value='Yes']");
    public static final By SERVICE_LOC_OFC_ADDRESS=By.xpath("//input[contains(@name,'Is Service Location Office Address')][@value='Yes']");
    public static final By SERVICE_LOC_OFC_CONTACT_PERSON_DETAILS=By.xpath("//input[contains(@name,'Service Location Office Contact')][@value='Yes']");


    public static final By HOME_CORP_OFFICE_CONTACT_PERSON_DETAILS=By.xpath("//input[contains(@name,'Is Home/Corp Office Contact person details same as Pay to Address Contact person details?')][@value='Yes']");
    public static final By HOME_OR_CORP_OFC_CONTACT_PERSON_DETAILS=By.xpath("(//input[contains(@name,'Is Home/Corp Office')][@value='Yes'])[2]");
    public static final By HOME_CORP_OFFICE_ADDRESS_FOR_GRP=By.xpath("//input[contains(@name,'Is the Home/Corp Office Address is same as the Pay to Address?')][@value='Yes']");
    public static final By ADDRESS_DETAILS=By.xpath("//input[@id='line1']");


    public static final By PROVIDER_ID=By.xpath("//input[@aria-label='Provider ID']");
    public static final By APPLICATION_TYPE_DETERMINATION_OPTION_FOR_GRP=By.xpath("//input[contains(@value,'To ONLY participate in the network of a Medicaid health plan.')]");
    public static final By PRACTICE_TYPE_OPTION_FOR_GRP=By.xpath("//input[contains(@value,'Group')]");
    public static final By ADD_LINE=By.xpath("//button//span[contains(text(),'+ Add Line')]");
    public static final By OTHER_CREDENTIALING_INFO=By.xpath("//div[contains(@class, 'menu')]//span[text() ='Other Credentialing Information']");
//    public static final By OTHER_CREDENTIALING_INFO=By.xpath("//*[@class='menu-item active']");


    public static final By TYPE_OF_TRAINING=By.xpath("//div[contains(@id,'Type of Training')]");
    public static final By TYPE_OF_TRAINING_OPTION=By.xpath("//div//ul[@role='listbox']//li[text()='Internship']");
    public static final By ORGANIZATION_NAME=By.xpath("//input[@aria-label='Organization Name']");
    public static final By GRADUATION_TYPE=By.xpath("//div[contains(@aria-labelledby,'Graduation Type')]");
    public static final By GRADUATION_TYPE_OPTION=By.xpath("//div//ul[@role='listbox']//li[text()='Others']");
    public static final By PROFESSIONAL_SCHOOL_NAME=By.xpath("//input[@aria-label='Professional School Name']");
    //    public static final By PHYSICAL_SCHOOL_ADDRESS=By.xpath("//input[@aria-label='Professional School Address Line 1']");
    public static final By PHYSICAL_SCHOOL_ADDRESS=By.xpath("//*[@id=\"line1\"]");
    public static final By PROFFESIONAL_SCHOOL_CITY=By.xpath("//input[@aria-label='Professional School City']");
    //    public static final By PROFFESIONAL_SCHOOL_STATE=By.xpath("//input[@aria-label='Professional School State']");
    public static final By PROFFESIONAL_SCHOOL_STATE=By.xpath("//*[contains(@aria-labelledby, 'Professional School State')]");
    public static final By PROFFESIONAL_SCHOOL_COUNTY=By.xpath("//input[@aria-label='Professional School County']");
    public static final By PROFFESIONAL_SCHOOL_COUNTRY=By.xpath("//input[@aria-label='Professional School Country']");
    public static final By PLAN_LEGAL_NAME=By.xpath("//input[contains(@aria-label,'Plan Legal Name')]");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_PHONE=By.xpath("//div[contains(@data-for,'Application Contact Phone')]//div//input");
    public static final By TAX_ENTITY_TYPE=By.xpath("//input[contains(@name,'Tax Entity Type')]");


    // Click the "No" radio button
    public static final By noRadioButton = By.xpath("//*[@value='No']");


    //yes radio button for Employment Authorization Information tab
    public static final By yesRadioButton = By.xpath("//*[@value='Yes']");


    //xpath for Employment Authorization Information
//    public static final By EmpAuthInfo = By.xpath( "//*[@class='menu-item active']");
    public static final By EmpAuthInfo = By.xpath( "//div[contains(@class,'menu-item')]//span[.='Employment Authorization Information']");


    //next button for Other Credentialing Information
    public static final By NEXT_BUTTON_OCI=By.xpath("//*[@id='nextBtn']");


    public static final By UPLOAD_BUTTON = By.xpath("(//span[.='Upload Files'])[1]");


    //MCO Enrollment
    public static final By PlanLegalName = By.xpath("//input[@aria-label='Plan Legal Name']");
    public static final By PlanTypeOptions = By.xpath("//input[@name='Plan Type Options']");
    public static final By TaxEntityType = By.xpath("//input[@name='Tax Entity Type']");
    //    public static final By NPI_MCO = By.xpath("(//span[.='NPI Number'])[2]");
    public static final By NPI_MCO = By.xpath("//table//div[@role=\"combobox\"]");
    public static final By Add_Region_Link = By.xpath("//span[.='Add Region ']");
    public static final By Selct_Region_Dropdown = By.xpath("//div[contains(@class,'MuiDialog')]//div[contains(@id,'Select Region')]");
    public static final By Selct_Region_B = By.xpath("//div[contains(@class,'MuiMenu')]//ul[contains(@class,'MuiMenu')]//li[3]");
    public static final By Save_Region_Button = By.xpath("(//div[contains(@class,'MuiDialog')]//span[.='Save'])[2]");


    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public ProviderEnrollingPage(
            WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    /**
     * This method fills in Individual Identifying Information @ Medicaid Payment section, [Answer to the question, Will you receive payments directly from Medicaid?
     * (Yes or No)]"
     *
     * @param medicaidPayment
     */
    public void fillInMedicaidPaymentIdentifyingInformation(String medicaidPayment) {
        Reports.log("\nFilling the Medicaid Payment");


        javaWait(5);
        if (medicaidPayment.equalsIgnoreCase("Yes")) {
            ajaxClick(By.xpath("(//input[contains(@name,'Will you receive payment directly from Medicaid ')])[1]"));
        } else if (medicaidPayment.equalsIgnoreCase("No")) {
            ajaxClick(By.xpath("(//input[contains(@name,'Will you receive payment directly from Medicaid ')])[2]"));
        }
        Reports.log("Will you receive payment directly from Medicaid that will be reported to the IRS under your SSN?*" + medicaidPayment);
    }


    public void fillInApplicationTypeinIdentifyingInformation() {
        Reports.log("\nFilling the Application Type determination");
        javaWaitSec(25);
        driver.findElement(APPLICATION_TYPE_DET_FIRST).click();
//        driver.findElement(SELECT_APPLICATION_TYPE_DETERMINATION).click();
        javaWaitSec(10);
        driver.findElement(SELECT_PRACTICE_TYPE).click();


    }


    /**
     * This method verifies EFT section appearence based on the answer to the question Medicaid Payment. If "Yes", EFT section should display
     * and verification of alll mandatory fields will be done. If "No" EFT section should not display.
     */
    public void verifyEFTSectionBasedOnMedicaidPayment() {
//        Reports.log("Will you receive payment directly from Medicaid that will be reported to the IRS under your SSN?*" + Data.medicaidPaymentYes);
//        WebElement radioButton = driver.findElement(By.xpath("(//input[contains(@name,'Will you receive payment directly from Medicaid ')])[1]"));
//        ajaxClick(radioButton);
        sectionDisplayed = verifyThatElementIsDisplayed(SECTION_EFT_Information);
        Reports.log("Section EFT Information displayed: " + sectionDisplayed.toString());
        ajaxClick(SECTION_EFT_Information);
        Reports.log("Verifying all the mandatory fields in EFT section");
        checkAllTheFieldsWithSpecificData(MANDATORY_FIELDS, "*");
        javaWaitSec(2);


        driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(TAB);
        driver.findElement(EFT_ROUTING_NUMBER).sendKeys(TAB);
        driver.findElement(EFT_ACCOUNT_NUMBER).sendKeys(TAB);
        driver.findElement(EFT_ACCOUNT_TYPE).sendKeys(TAB);
        Reports.log("Verifying all fields with error message:" + Data.ERROR_FIELD_REQUIRED);
        checkAllTheFieldsWithSpecificData(By.xpath("//div[@data-for='EFT Information']/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        javaWaitSec(2);
        Reports.log("Verifying all fields with error message: " + Data.ERROR_DATE_REQUIRED);
        driver.findElement(By.xpath("//label[text()='" + Data.START_DATE + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(TAB);
        checkAllTheFieldsWithSpecificData(By.xpath("//div[@data-for='EFT Information']/following::li[text()='" + Data.ERROR_DATE_REQUIRED + "']"), Data.ERROR_DATE_REQUIRED);
        javaWaitSec(2);
        Reports.log("Verifying all accouunt types in drop down list: ");
        doublePerformClick(EFT_ACCOUNT_TYPE);


        ArrayList<String> accountType = new ArrayList<>(Arrays.asList("Savings", "Checking"));
        verifyListValue(By.xpath("//div[contains(@id,'react-auto')]/ul/li"), accountType, "Account Type");
        //checkAllTheFieldsWithSpecificData(By.xpath("//div[contains(@id,'react-auto')]/ul/li/div"), "account");
        Reports.log("Will you receive payment directly from Medicaid that will be reported to the IRS under your SSN?*" + Data.medicaidPaymentNo);
//        ajaxClick(SECTION_IDENTIFYING_Information);
//        ajaxClick(By.xpath("(//input[contains(@name,'Will you receive payment directly from Medicaid ')])[2]"));
        javaWaitSec(2);
        Reports.log("Section EFT Information displayed: " + verifyThatElementIsDisplayed(SECTION_EFT_Information));
    }


//    /**
//     * This method fills in Individual Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
//     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
//     *
//     * @param firstName
//     * @param lastName
//     * @param gender
//     * @param dob
//     * @param countryOfBirth
//     * @param stateOfBirth
//     * @param email
//     * @param ssn
//     * @param profitStatus
//     * @param enrollmentType
//     */
//    public void fillInIndividualIdentifyingInformation(String firstName, String lastName, String middleName, String gender, String dob, String countryOfBirth,
//                                                       String stateOfBirth, String email, String ssn, String profitStatus,
//                                                       String enrollmentType, String requestEnrollDate) {
////        String medicaidPayment ;
////        if(enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER)){
////            medicaidPayment = "Yes" ;
////        }else{ medicaidPayment = "No" ;}
//        fillInMedicaidPaymentIdentifyingInformation(medicaidPayment);
//        fillInRequestedEnrollmentDateInformation(requestEnrollDate);
//        fillInGeneralInformation(firstName, lastName, middleName, gender, dob, countryOfBirth, stateOfBirth, email, ssn, profitStatus, Data.INDIVIDUAL_PROVIDER);
//        if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER)) {
//            ajaxClick(RADIO_BTN_1099_TAX_EXEMPT_NO);
//
//            //TAX In
//            //Workaround for Defect PECS-1172, need to comment when the issue is fixed
//            Reports.log("\nFilling in Tax Information");
//            Reports.log("Type in Legal Business Name: " + Data.taxLegalBusinessName);
//            setFieldValueWithTabAndWait(TEXT_FIELD_LEGAL_BUSINESS_NAME, Data.taxLegalBusinessName
//            );
//        }
//
//    }


    /**
     * This method fills in Individual Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
     *
     * @param firstName
     * @param lastName
     * @param gender
     * @param dob
     * @param countryOfBirth
     * @param stateOfBirth
     * @param email
     * @param ssn
     * @param profitStatus
     * @param enrollmentType
     */
    public void fillInIndividualIdentifyingInformation(String firstName, String lastName, String middleName, String gender, String dob, String countryOfBirth,
                                                       String stateOfBirth, String email, String ssn,String applicationContactNo, String profitStatus,
                                                       String enrollmentType, String medicaidPayment, String requestEnrollDate) {
        javaWaitSec(20);
        fillInApplicationTypeinIdentifyingInformation();
//        fillInMedicaidPaymentIdentifyingInformation(medicaidPayment);
//        fillInRequestedEnrollmentDateInformation(requestEnrollDate);


        fillInGeneralInformation(firstName, lastName, middleName, gender, dob, countryOfBirth, stateOfBirth, email, ssn,applicationContactNo, profitStatus, Data.INDIVIDUAL_PROVIDER);
//        if (medicaidPayment.equals("Yes")) {
//            ajaxClick(RADIO_BTN_1099_TAX_EXEMPT_NO);
//
//            //TAX In
//            //Workaround for Defect PECS-1172, need to comment when the issue is fixed
//            Reports.log("\nFilling in Tax Information");
//            Reports.log("Type in Legal Business Name: " + Data.taxLegalBusinessName);
//            setFieldValueWithTabAndWait(TEXT_FIELD_LEGAL_BUSINESS_NAME, Data.taxLegalBusinessName
//            );
//        }
    }


    /**
     * This method fills in Individual Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
     *
     * @param requestEnrollDate
     */
    public void fillInRequestedEnrollmentDateInformation(String requestEnrollDate) {
        javaWaitSec(10);
        Reports.log("\nFilling Requested Enrollment Date section");
        fillInCalendar(requestEnrollDate, Data.requestedEnrollmentDate);
        Reports.log("Selected Select Requested Enrollment Date * : " + requestEnrollDate);


//        performClick(COMBOBOX_REASON_CODE);
        ajaxScrollUp();
        javaWaitSec(5);
        driver.findElement(By.xpath("//label[contains(.,'Reason Code')]//ancestor::div[@role='combobox']//input")).click();
        Reports.log("Selected a Reason Code");
        javaWaitSec(5);
        jsClick("//ul[@role='listbox']/li[@data-suggestion-index='3']");
        Reports.log("Selected a Reason Code");
        javaWaitSec(2);
    }


    /**
     * This method fills in MCO Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
     *
     * @param firstName
     * @param lastName
     * @param email
     */
    public void fillInMCOIdentifyingInformation(String firstName, String lastName,String email,String applicationContactNo)
    {
        javaWaitSec(15);
        setFieldValueWithTabAndWait(PlanLegalName, firstName);
        Reports.log("Type first name: " + firstName);


        javaWaitSec(5);
        Reports.log("Type FEIN: " + FEIN);
        driver.findElement(INPUT_FEILD_FEIN_NUMBER).sendKeys(generateNewNumber(9));


        javaWaitSec(5);
        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NAME, firstName + lastName);
        Reports.log("Application contact name: " + firstName + lastName);


        javaWaitSec(5);
        setFieldValueWithTabAndWait(APPLICATION_CONTACT_PHONE, applicationContactNo);
        Reports.log("Application contact email: " + applicationContactNo);


        javaWaitSec(5);
//        selectFirstOptionInDropdown(PlanTypeOptions);
//        Reports.log("Selected first option in PlanTypeOption Dropdown");
        driver.findElement(PlanTypeOptions).click();
        clickFirstOptionInList();


        javaWaitSec(5);
        selectFirstOptionInDropdown(TaxEntityType);
        Reports.log("Selected first option in TaxEntityType Dropdown");


        javaWaitSec(5);
        setFieldValueWithTabAndWait(APPLICATION_CONTACT_EMAIL_Email, email);
        Reports.log("Type Application contact email: " + email);
    }


    /**
     * This method fills in General Information under Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
     *
     * @param firstName
     * @param lastName
     * @param gender
     * @param dob
     * @param countryOfBirth
     * @param stateOfBirth
     * @param email
     * @param ssn
     * @param profitStatus
     * @param enrollmentType
     */
    public void fillInGeneralInformation(String firstName, String lastName, String middleName, String gender, String dob,
                                         String countryOfBirth, String stateOfBirth, String email, String ssn,String applicationContactNo,
                                         String profitStatus, String enrollmentType) {
        if (enrollmentType.contains(Data.TRADING_PARTNER)) {
            clickTradingPartnerTypeRadioButtonByValue("Individual");
        }


        Reports.log("\nFill in General Information");
        javaWaitSec(4);


        if (!enrollmentType.equalsIgnoreCase(Data.pemApplication)) {


            selectFirstOptionInDropdown(COMBOBOX_TITLE_PROVIDER);
            Reports.log("Entered Title: Dr.");
        }


        ajaxClick(TEXT_FIELD_FIRST_NAME_PROVIDER);
        driver.findElement(TEXT_FIELD_FIRST_NAME_PROVIDER).clear();
        setFieldValueWithTabAndWait(TEXT_FIELD_FIRST_NAME_PROVIDER, firstName);
        Reports.log("Type first name: " + firstName);


        setFieldValueWithTabAndWait(TEXT_FIELD_LAST_NAME_PROVIDER, lastName);
        Reports.log("Type in last name: " + lastName);


        setFieldValueWithTabAndWait(TEXT_FIELD_MIDDLE_NAME_PROVIDER, middleName);
        Reports.log("Type in Middle name: " + middleName);
        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NAME, firstName + lastName);
        Reports.log("Application contact name: " + firstName + lastName);


        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NUM, applicationContactNo);
        Reports.log("Application contact email: " + applicationContactNo);




        if (!enrollmentType.contains(Data.TRADING_PARTNER)) {
            selectFirstOptionInDropdown(COMBOBOX_GENDER);
            Reports.log("Type gender: " + gender);
        }


        if (!enrollmentType.contains(Data.pemApplication) && !enrollmentType.contains(Data.TRADING_PARTNER)) {
            String DOB= createRandomDateInSpecificYears(-18, -60);
            fillInCalendar(DOB, Data.dateOfBirthCalendar2);
            Reports.log("Set Date of Birth: " + DOB);
            javaWaitSec(1);


            selectFirstOptionInDropdown(DROP_DOWN_COUNTRY_OF_BIRTH);
            Reports.log("Type Country of birth: " + countryOfBirth);


            selectFirstOptionInDropdown(DROP_DOWN_STATE_OF_BIRTH);
            Reports.log("Type State of birth: " + stateOfBirth);
            driver.findElement(DROP_DOWN_STATE_OF_BIRTH).sendKeys(Keys.TAB);
            javaWaitSec(10);
        }


        if (!enrollmentType.contains(Data.pemApplication)) {
            ajaxClick(TEXT_FIELD_SSN);
            setFieldValueWithTabAndWait(TEXT_FIELD_SSN, ssn);
            Reports.log("Type SSN: " + ssn);
        }


        if (!enrollmentType.contains(Data.TRADING_PARTNER)) {
            setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_EMAIL, email);
            Reports.log("Type Application contact email: " + email);
        }


        if (!enrollmentType.contains(Data.pemApplication)
                && !enrollmentType.contains(Data.TRADING_PARTNER) && !enrollmentType.contains(Data.individualApplication)) {
            final By locator = By.xpath("//label[text()='" + "Profit Status" + "']//ancestor::div[@role='combobox']//input");
            selectFirstOptionInDropdown(locator);
        }


        if (enrollmentType.contains(Data.TRADING_PARTNER)) {
            final By locator = By.xpath("//label[text()='" + "Provider type" + "']//ancestor::div[@role='combobox']//input");
            selectFirstOptionInDropdown(locator);
        }
//        if (!enrollmentType.contains(Data.TRADING_PARTNER)) {
//            ajaxClick(setAndFindButton("Next"));
//        }


        if(enrollmentType.contains(Data.MCOApplication)){
            setFieldValueWithTabAndWait(PlanLegalName, firstName);
            Reports.log("Type first name: " + firstName);


            Reports.log("Type FEIN: " + FEIN);
            driver.findElement(INPUT_FEILD_FEIN_NUMBER).sendKeys(FEIN);
            javaWaitSec(5);


            setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NAME, firstName + lastName);
            Reports.log("Application contact name: " + firstName + lastName);


            setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NUM, applicationContactNo);
            Reports.log("Application contact email: " + applicationContactNo);


            selectFirstOptionInDropdown(PlanTypeOptions);
            Reports.log("Selected first option in PlanTypeOption Dropdown");


            selectFirstOptionInDropdown(TaxEntityType);
            Reports.log("Selected first option in TaxEntity Dropdown");
        }
    }


    /**
     * This method fills in General Information under Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
     *
     * @param updatedSSN
     */
    public void UpdateSSNInIdentificationInfoSec(String updatedSSN) {
        ajaxClick(TEXT_FIELD_SSN);
        ajaxClear(TEXT_FIELD_SSN);
        javaWaitSec(2);
        setFieldValueWithTabAndWait(TEXT_FIELD_SSN, updatedSSN);
        Reports.log("Updated SSN: " + updatedSSN);
    }
    public void UpdateApplicationContactNumInIdentificationInfoSec(String updatedApplicationContactNum) {
        ajaxClick(TEXT_FIELD_APPLICATION_CONTACT_NUM);
        ajaxClear(TEXT_FIELD_APPLICATION_CONTACT_NUM);
        javaWaitSec(2);
        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NUM, updatedApplicationContactNum);
        Reports.log("Updated Application Contact Num: " + updatedApplicationContactNum);
    }


    /**
     * This method fills in General Information under Identifying Information section using  Legal Business Name,Doing Business As ssn, profitStatus, enrollmentType arguments.
     * enrollmentType
     *
     * @param updatedLegalBusinessName
     */
    public void updateLegalBusinessInIdentificationInfoSec(String updatedLegalBusinessName) {
        ajaxClick(INPUT_FEILD_LEGAL_BUSINESS_NAME);
        ajaxClear(INPUT_FEILD_LEGAL_BUSINESS_NAME);
        javaWaitSec(2);
        setFieldValueWithTabAndWait(INPUT_FEILD_LEGAL_BUSINESS_NAME, updatedLegalBusinessName);
        Reports.log("Updated Legal Business Name: " + updatedLegalBusinessName);
    }




    public void fillInProviderIdentifyingInformationTP(String LegalBusiness, String DBABusiness,
                                                       String FEIN, String Address, String City,
                                                       String State, String Zip, String County, String MailingState, String email) {
        Reports.log("Type Legal Business Name: " + LegalBusiness);
        javaWaitSec(5);
        driver.findElement(INPUT_FEILD_LEGAL_BUSINESS_NAME).sendKeys(LegalBusiness);
        Reports.log("Type Doing Business As Name: " + DBABusiness);
        javaWaitSec(2);
        driver.findElement(INPUT_FEILD_DBA).sendKeys(DBABusiness);
        Reports.log("Type FEIN: " + FEIN);
        javaWaitSec(2);
        driver.findElement(By.xpath("//div[@data-for='FEIN']//input")).sendKeys(FEIN);
        Reports.log("Type Application Contact Email " + email);
        driver.findElement(APPLICATION_CONTACT_EMAIL).sendKeys(email);
        javaWaitSec(2);
        driver.findElement(APPLICATION_CONTACT_EMAIL).sendKeys(Keys.TAB);
        javaWaitSec(5);
//        Reports.log("Type Address line1: " + Address);
//        driver.findElement(By.xpath("//input[contains(@id,'line1')]")).sendKeys(Address);
//
//        Reports.log("Type City: " + City);
//        setFieldValueWithTabAndWait(TEXT_FIELD_MAILING_ADDRESS_CITY, City);
//
//        Reports.log("Type zip code: " + Zip);
//        setFieldValueWithTabAndWait(TEXT_FIELD_MAILING_ZIP_CODE2, Zip);
//
//        Reports.log("Type County Code: " + County);
//        setFieldValueWithTabAndWait(TEXT_MAILING_COUNTY_CODE, County);
//
//        driver.findElement(By.xpath("//input[@name='State']")).sendKeys("");
//        Reports.log("Select mailing state: " + MailingState);
//        ajaxClick(setSpecificStrongOptionInListbox(MailingState));
        ajaxClick(setAndFindButton("Next"));
    }




    public void fillInIdentifyingInfoForEntity(String LegalBusiness, String DBABusiness,
                                               String FEIN, String email, String Date) {


        // Requested Enrollment Date
        fillInApplicationTypeDeterminationInIF();
        practiceTypeForGrp();


        //General Information
        Reports.log("Type Legal Business Name: " + LegalBusiness);
        driver.findElement(INPUT_FEILD_LEGAL_BUSINESS_NAME).sendKeys(LegalBusiness);
        javaWaitSec(5);


        Reports.log("Type FEIN: " + FEIN);
        driver.findElement(INPUT_FEILD_FEIN_NUMBER).sendKeys(FEIN);
        javaWaitSec(5);


        Reports.log("Type Doing Business As Name: " + DBABusiness);
        driver.findElement(INPUT_FEILD_DBA).sendKeys(DBABusiness);
        javaWaitSec(5);


        Reports.log("Type Application Contact Email " + email);
//        ajaxSendKeys(APPLICATION_CONTACT_EMAIL, email);
        driver.findElement(APPLICATION_CONTACT_EMAIL).sendKeys(email);
        javaWaitSec(5);


        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NAME, LegalBusiness);
        javaWaitSec(2);
        driver.findElement(APPLICATION_CONTACT_PHONE).sendKeys(Data.phone);


        ajaxClick(By.xpath(IDENTIFICATION_SECTION_DIFFERENT_DBA_NAME_RADIO_BTN_VALUE));
        javaWaitSec(1);


        ajaxClick(By.xpath(IDENTIFICATION_SECTION_APPLICATION_CHANGE_RADIO_BTN_VALUE));
        javaWaitSec(1);
        driver.findElement(By.xpath("//input[@aria-label='Website Address']")).sendKeys("https://fl-dev-dyp-01.dyp.cloud");


        //Tax Information
        clickAndTypeAndSelectOptionInCombobox("Profit Status", "N", 0);
        ajaxClick(By.xpath(IDENTIFICATION_SECTION_1099_TAX_EXEMPT_RADIO_BTN_VALUE));
//        clickAndTypeAndSelectOptionInCombobox("Month", "D", 0);
//        clickAndTypeAndSelectOptionInCombobox("Date", "3", 2);
        ajaxClick(setAndFindButton("Next"));
    }






    /**
     * This method Clicks on continue button
     */
    public void ClickOnContinueBtn() {
        // driver.findElement(By.xpath("//span[contains(.,'Continue')]")).click();
        ajaxClick(By.xpath("//span[contains(.,'Continue')]"));
        Reports.log("Clicked on Continue Button");
        javaWaitSec(10);
    }


    public void fillInProviderIdentifierTP(String NPI) {
        javaWaitSec(2);
        Reports.log("Fill in NPI number: " + NPI);
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);


        ajaxClick(DO_YOU_HAVE_NPI_YES_RADIO);
        typeAndSelectNpiTextField(NPI);
        ajaxClick(setAndFindButton("Next"));
    }




    /**
     * This method fills in provider identifiers section using medicareParticipant, npi, enrollmentType, taxonomyCategory
     *
     * @param medicareParticipant
     * @param npi
     * @param enrollmentType
     */
    public void fillInIndividualProviderIdentifiersSection(String medicaidPayment, String medicareParticipant, String npi, String enrollmentType) {
//        if(enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER)){medicaidPayment = "Yes";}
//        else{medicaidPayment = "No";}
        javaWaitSec(5);
        Reports.log("\nFill in Provider Identifier Section");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        // driver.findElement(SECTION_PROVIDER_IDENTIFIERS).click();


        clickMedicareRadiobuttonByValue(medicareParticipant);
        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            clickDeaRadiobuttonByValue();
            clickLaboratoryNoValue();
            typeAndSelectNpiTextField(npi);
            return;
        }
// ******************* Issue with NPI Number field, Will uncommnet when the issus is fixed**********************//
//        fillInProviderIdentifiersSectionWithDifferentNpi(npi, enrollmentType);
        ajaxClick(YES_RADIOBUTTON_NPI_NUMBER);
        Reports.log("Do you have an NPI?*, Selected Yes");
        typeAndSelectNpiTextField(npi);
        ajaxScroll(setAndFindButton("Next"));
        javaWaitSec(1);
// ******************* ***************************************************************************************//


//        ajaxClick(NO_RADIOBUTTON_NPI_NUMBER); // Need to remove this line and Uncomment above code when the NPI issue is fixed




        if (medicaidPayment.equals("Yes")) {
            //Addition Information
            ajaxClick(SECTION_PROVIDER_IDENTIFIER_ADDITIONAL_INFO_GENERAL_LIABILITY_NO_RADIO_BTN);
            Reports.log("Do you have malpractice or general liability insurance?: No");


            javaWaitSec(1);
//            ajaxClick(COMBOBOX_CLAIM_SUBMISSION_METHOD);
            driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).click();
            WebElement claimSubmission = driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).findElement((DROP_DOWN_CLAIM_SUBMISSION_METHOD));
            claimSubmission.click();
            Reports.log("What claim Submission(s) do you use?: " + claimSubmission.getText());
            ajaxClick(setAndFindButton("Next"));
        }


        if(enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)){
            driver.findElement(LANGUAGE_SUPPORT_DROP_DOWN).click();
            ajaxClick(setSpecificOptionInListbox(Data.LANGUAGE_ENGLISH));
            Reports.log("Select Language Support: English");
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        }
    }


    /**
     * This method fills in provider identifiers section using medicareParticipant, npi, enrollmentType, taxonomyCategory
     *
     * @param medicareParticipant
     * @param npi
     * @param enrollmentType
     * @param taxonomyCategory
     */
    public void verifyAndFillingProviderIdentifiersSectionForIndvalEnrmt(String medicareParticipant, String npi, String enrollmentType, String taxonomyCategory) {
        javaWaitSec(5);
        Reports.log("\nFill in Provider Identifier Section");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);


        //  Provider Identifiers
        Reports.log("\nVerifying Provider Identifier sub-section");
        verifyThatElementIsDisplayed(SECTION_PROVIDER_IDENTIFIERS_LABEL, "Section");


        softAssert.assertTrue(verifyThatElementIsDisplayed(NPI_TEXT_LABEL, "Question"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(NPI_RADIO_BTNS, "Radio Buttons"));
        verifyNPIRadioBtn();


        verifyMedicareParticipant();
        clickMedicareRadiobuttonByValue(medicareParticipant);


        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            clickDeaRadiobuttonByValue();
            clickLaboratoryNoValue();
            typeAndSelectNpiTextField(npi);
            return;
        }


        javaWait(2);
        fillInProviderIdentifiersSectionWithDifferentNpi(npi, enrollmentType);
        typeAndSelectNpiTextField(npi);
        ajaxScroll(setAndFindButton("Next"));
        javaWaitSec(1);


        verifyMedicaidState();


        clickMedicareRadiobuttonByValue(medicareParticipant);


        //Addition Information
        softAssert.assertTrue(verifyThatElementIsDisplayed(SECTION_ADDITIONAL_INFO_LABEL), "Section");
        softAssert.assertTrue(verifyThatElementIsDisplayed(TEACHING_PROVIDER_QUESTION), "Question");
        softAssert.assertTrue(verifyThatElementIsDisplayed(TEACHING_PROVIDER_QUESTION_RADIO_BTN), "Radio Buttons");
        softAssert.assertTrue(verifyThatElementIsDisplayed(TREATING_PROVIDER_QUESTION), "Question");
        softAssert.assertTrue(verifyThatElementIsDisplayed(TREATING_PROVIDER_QUESTION_RADIO_BTN), "Radio Buttons");
        softAssert.assertAll();


        ajaxClick(SECTION_PROVIDER_IDENTIFIER_ADDITIONAL_INFO_GENERAL_LIABILITY_NO_RADIO_BTN);
        Reports.log("Do you have malpractice or general liability insurance?: No");


        ajaxClick(COMBOBOX_CLAIM_SUBMISSION_METHOD);
        WebElement claimSubmission = driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).findElement((DROP_DOWN_CLAIM_SUBMISSION_METHOD));
        claimSubmission.click();
        Reports.log("What claim Submission(s) do you use?: " + claimSubmission.getText());
    }


    /**
     * This method verifies and validates the NPI field based on the selected Radio button.
     * Selects 'No' radio button, verifies NPI input field not displayed.
     * Selects 'Yes' radio button, verifies NPI input field is displayed also verifies the error message.
     */
    public void verifyNPIRadioBtn() {


        //Selects 'No' radio button, verifies NPI input field not displayed.
        ajaxClick(NO_RADIOBUTTON_NPI_NUMBER);
        Reports.log("Do you have an NPI?*, Selected No");
        softAssert.assertFalse(verifyThatElementIsDisplayed(TEXT_FIELD_NEW_NPI, "NPI Input text"), "NPI Input text is displayed when Selected No Radio btn");
        javaWaitSec(1);


        //Selects 'Yes' radio button, verifies NPI input field is displayed also verifies the error message.
        ajaxClick(YES_RADIOBUTTON_NPI_NUMBER);
        Reports.log("Do you have an NPI?*, Selected Yes");
        ajaxScroll(SECTION_PROVIDER_IDENTIFIERS_LABEL);
        boolean isNPIFieldDisplayed = verifyThatElementIsDisplayed(LABEL_FIELD_NPI_NUM, "Input text");
        softAssert.assertTrue(isNPIFieldDisplayed);
//            driver.findElement(TEXT_FIELD_NEW_NPI).sendKeys(Keys.TAB);
//            checkAllTheFieldsWithSpecificData(NPI_NUMBER_Error_MASSAGE, Data.ERROR_MASSAGE_NPI);
//            checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        setFieldValueWithWaits(TEXT_FIELD_NEW_NPI, "");
        javaWaitSec(2);
        Assert.assertTrue(verifyThatElementIsDisplayed(NPI_RADIO_BTN_ERROR_MESG, "NPI Error Message"));
        checkAllTheFieldsWithSpecificData(NPI_NUMBER_Error_MASSAGE, Data.ERROR_MASSAGE_NPI);


    }




    /**
     * This method verifies and validates the NPI field based on the selected Radio button.
     * Selects 'No' radio button, verifies NPI input field not displayed.
     * Selects 'Yes' radio button, verifies NPI input field is displayed also verifies the error message.
     */
    public void verifyNPIRadioBtnForEntityEnrollment() {


        //Selects 'No' radio button, verifies NPI input field not displayed.
        ajaxClick(By.xpath(String.format(RADIOBUTTON_NPI_NUMBER, "No")));
        Reports.log("Do you have an NPI?*, Selected No");
        softAssert.assertFalse(verifyThatElementIsDisplayed(TEXT_FIELD_NEW_NPI, "NPI Input text"), "NPI Input text is displayed when Selected No Radio btn");
        javaWaitSec(1);


        //Selects 'N/A SD Provider' radio button, verifies NPI input field not displayed.
        ajaxClick(By.xpath(String.format(RADIOBUTTON_NPI_NUMBER, "N/A SD Provider")));
        Reports.log("Do you have an NPI?*, Selected N/A SD Provider");
        softAssert.assertFalse(verifyThatElementIsDisplayed(TEXT_FIELD_NEW_NPI, "NPI Input text"), "NPI Input text is displayed when Selected N/A SD Provider Radio btn");
        javaWaitSec(1);


        //Selects 'Yes' radio button, verifies NPI input field is displayed also verifies the error message


        ajaxClick(By.xpath(String.format(RADIOBUTTON_NPI_NUMBER, "Yes")));
        javaWaitSec(1);


        Reports.log("Do you have an NPI?*, Selected Yes");
        ajaxScroll(SECTION_PROVIDER_IDENTIFIERS_LABEL);
        boolean isNPIFieldDisplayed = verifyThatElementIsDisplayed(LABEL_FIELD_NPI_NUM, "Input text");
        softAssert.assertTrue(isNPIFieldDisplayed);
        driver.findElement(TEXT_FIELD_NEW_NPI).sendKeys(TAB);
//            checkAllTheFieldsWithSpecificData(NPI_NUMBER_Error_MASSAGE, Data.ERROR_MASSAGE_NPI);
//            checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
//        setFieldValueWithWaits(TEXT_FIELD_NEW_NPI, "");
        checkAllTheFieldsWithSpecificData(NPI_NUMBER_Error_MASSAGE, Data.ERROR_MASSAGE_NPI);
        javaWaitSec(2);
        Assert.assertTrue(verifyThatElementIsDisplayed(NPI_RADIO_BTN_ERROR_MESG, "NPI Error Message"));


    }


    /**
     * This method verifies and validates the Medicare Participant field based on the selected Radio button.
     * Selects 'Yes' radio button, verifies if system allows the user to enter Medicare Id, Effective start date, and End date.
     * Selects 'No' radio button, verifies no action performed
     */
    public void verifyMedicareParticipant() {
        // Selects 'No' radio button, verifies NPI input field not displayed.
        clickMedicareRadiobuttonByValue("No");
        softAssert.assertFalse(verifyThatElementIsDisplayed(PARTICIPANT_MEDICARE_ADD_LINE_TABLE, "MEDICARE"));
        softAssert.assertFalse(verifyThatElementIsDisplayed(PARTICIPANT_MEDICARE_ADD_LINE_BUTTON, "Button"));


        //Selects 'Yes' radio button, verifies if system allows the user to enter Medicare Id, Effective start date, and End date.
        clickMedicareRadiobuttonByValue("Yes");
        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_MEDICARE_ADD_LINE_BUTTON, "Button"));


        ajaxClick(PARTICIPANT_MEDICARE_ADD_LINE_BUTTON);
        javaWaitSec(5);
        Reports.log("Clicked on Add Line Button");


        ajaxClick(setAndFindButton(Data.TEXT_SAVE));
        javaWaitSec(2);


        String displayedErrorMsg = driver.findElement(VALIDATION_ERRORS_ON_POPUP_WINDOW).getText();
        Reports.log(" Displayed Error message: " + displayedErrorMsg);
        String expectedErrorMsg = Data.MEDICARE_ID_FIELD_IS_REQUIRED + "\n" + Data.EFFECTIVE_DATE_FIELD_IS_REQUIRED + "\n" + Data.END_DATE_FIELD_IS_REQUIRED;
        Assert.assertTrue(displayedErrorMsg.contains(expectedErrorMsg), "Missing an error message");
        javaWaitSec(1);
        softAssert.assertTrue(verifyThatElementIsDisplayed(SECTION_OTHER_MEDICAID_ERROR_POP_CLOSE_BTN), "Button ");
        ajaxClick(SECTION_OTHER_MEDICAID_ERROR_POP_CLOSE_BTN);
        javaWaitSec(2);


        String medicalId = medicalID();
        ajaxSendKeys(PARTICIPANT_MEDICARE_ID_INPUT, medicalId);
        Reports.log("Entered Medical Id: " + medicalId);
        fillInCalendar(getCurrentDate(), Data.effectiveDate);
        Reports.log("Entered Effective Start Date " + getCurrentDate());
        fillInCalendar(getCurrentDate() + 60, Data.endDateCalendar);
        Reports.log("Entered End Date " + getCurrentDate() + 60);
    }


    /**
     * This method verifies and validates the Medicaid State field based on the selected Radio button.
     * if selected 'Yes' radio button, verifies if system displayed and allow the users to enter the  mandatory field.
     * if selected 'No' radio button, verifies NPI input field not displayed.
     */
    public void verifyMedicaidState() {
        verifyThatElementIsDisplayed(SECTION_OTHER_MEDICAID_STATE_LABEL, "Section");
        softAssert.assertTrue(verifyThatElementIsDisplayed(MEDICAID_STATE_QUESTION), "Question");
        softAssert.assertTrue(verifyThatElementIsDisplayed(MEDICAID_STATE_QUESTION_RADIO_BTN), "Radio Buttons");


        javaWaitSec(2);


        clickMedicaidStateRadiobuttonByValue("false");
        softAssert.assertFalse(verifyThatElementIsDisplayed(PARTICIPANT_MEDICAID_STATE_ADD_LINE_BUTTON, "Button"));
        javaWaitSec(1);


        clickMedicaidStateRadiobuttonByValue("true");
        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_MEDICAID_STATE_ADD_LINE_BUTTON, "Button"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_MEDICARE_ADD_LINE_TABLE, "Table"));


        ajaxScrollUp();
        performMoveToElement(PARTICIPANT_MEDICARE_ADD_LINE_BUTTON);
        javaWaitSec(2);
        ajaxClick(PARTICIPANT_MEDICAID_STATE_ADD_LINE_BUTTON);


        Reports.log("Clicked on Add Line Button");
        ajaxScrollUp();
        performMoveToElement(setAndFindButton(Data.TEXT_SAVE));
        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_MEDICARE_SAVE_BTN), "Button");


        setAndFindButton(Data.TEXT_SAVE).click();
        javaWaitSec(2);
        ;


        String displayedErrorMsg = driver.findElement(VALIDATION_ERRORS_ON_POPUP_WINDOW).getText();
        Reports.log(" Displayed Error message: " + displayedErrorMsg);
        String expectedErrorMsg = Data.otherMedicaidStateFieldRequired + "\n" + Data.stateProgramFieldRequired + "\n" + Data.enrollmentBeginDateFieldIsRequired;
        Assert.assertTrue(displayedErrorMsg.contains(expectedErrorMsg), "Missing an error message");
        javaWaitSec(1);


        softAssert.assertTrue(verifyThatElementIsDisplayed(SECTION_OTHER_MEDICAID_ERROR_POP_CLOSE_BTN), "Button ");
        ajaxClick(SECTION_OTHER_MEDICAID_ERROR_POP_CLOSE_BTN);
        javaWaitSec(2);


        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_OTHER_MEDICAID_STATE_PRGM_DROPDOWN), "Other Medicaid State Dropdown ");
        ajaxClick(PARTICIPANT_OTHER_MEDICAID_STATE_PRGM_DROPDOWN);
        clickAnyOptionInList(2);
        javaWaitSec(2);


        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_MEDICAID_STATE_PRGM_DROPDOWN), "State Program Dropdown ");
        ajaxClick(PARTICIPANT_MEDICAID_STATE_PRGM_DROPDOWN);
        ArrayList<String> stateProgramDropdownValues = new ArrayList<>(Arrays.asList("Medicaid/CHIP", "Primary Care Provider (PCP)", "Health Home", "Birth to Three", "Medicare cross-over only", "ADLS waiver (DHS)", "CHOICES waiver (DHS)", "Family Support 360 waiver (DHS)", "HOPE waiver (DHS)", "SMA direction (use only when directed)"));
        verifyListValue(PARTICIPANT_DROPDOWN_LIST, stateProgramDropdownValues, "State Program");
        clickAnyOptionInList(2);


        fillInCalendar(getCurrentDate(), Data.enrollmentBeginDate);
        Reports.log("Entered Effective Start Date " + getCurrentDate());
        fillInCalendar(getCurrentDate() + 60, Data.endDateCalendar);
        Reports.log("Entered End Date " + getCurrentDate() + 60);
        setAndFindButton(Data.TEXT_SAVE).click();
        javaWaitSec(2);
    }


    /**
     * This method fills in provider identifiers section using medicareParticipant, npi, enrollmentType, taxonomyCategory
     *
     * @param medicareParticipant
     * @param npi
     * @param enrollmentType
     * @param taxonomyCategory
     */
    public void fillInProviderIdentifiersSection(String medicareParticipant, String npi, String enrollmentType, String taxonomyCategory) {
        javaWaitSec(5);
        Reports.log("\nFill in Provider Identifier Section");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        // driver.findElement(SECTION_PROVIDER_IDENTIFIERS).click();


        clickMedicareRadiobuttonByValue(medicareParticipant);


        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            clickDeaRadiobuttonByValue();
            clickLaboratoryNoValue();
            typeAndSelectNpiTextField(npi);
            return;
        }


        fillInProviderIdentifiersSectionWithDifferentNpi(npi, enrollmentType);
        typeAndSelectNpiTextField(npi);
        ajaxScroll(setAndFindButton("Next"));
        javaWaitSec(1);


        //Addition Information
        ajaxClick(SECTION_PROVIDER_IDENTIFIER_ADDITIONAL_INFO_GENERAL_LIABILITY_NO_RADIO_BTN);
        Reports.log("Do you have malpractice or general liability insurance?: No");


        javaWaitSec(2);
//        clickAndTypeAndSelectOptionInCombobox("What claim submission(s) do you use?", "P", 0);
        ajaxClick(COMBOBOX_CLAIM_SUBMISSION_METHOD);
        driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).click();
        WebElement claimSubmission = driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).findElement((DROP_DOWN_CLAIM_SUBMISSION_METHOD));
        claimSubmission.click();
        Reports.log("Selected What claim Submission(s) do you use?");
    }




    /**
     * This method fills in provider identifiers section with different Npi using npi, enrollmentType
     *
     * @param npi
     * @param enrollmentType
     */
    public void fillInProviderIdentifiersSectionWithDifferentNpi(String npi, String enrollmentType) {
        if (enrollmentType.contains(Data.BILLING_PROVIDER) || enrollmentType.contains(Data.SERVICING_PROVIDER)) {
            Reports.log("Click Yes in NPI radio-button");
            ajaxClick(YES_RADIOBUTTON_NPI_NUMBER);
        }
//        Reports.log("Select radio-button No in Bill Laboratory Services");
//        ajaxClick(RADIOBUTTON_BILL_LABORATORY_SERVICES);
    }




    /**
     * This method add line provider identifiers using index
     *
     * @param index
     */
    public void addLineProviderIdentifiers(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        ajaxScrollByCoordinate(100);
        ajaxScroll(COMBOBOX_TYPE_IDENTIFIERS);
        ajaxClick(COMBOBOX_TYPE_IDENTIFIERS);
        clickFirstOptionInList();
        ajaxClick(TEXT_FIELD_IDENTIFIER);
        driver.findElements(TEXT_FIELD_IDENTIFIER).get(index).sendKeys("111");
        fillInCalendar("09/04/2020", Data.effectiveDateCalendar2);
        fillInCalendar("09/05/2020", Data.endDateCalendar);
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
        javaWaitSec(3);
    }


    /**
     * This method fills in pharmacy provider identifiers section with different Npi using npi, ncpdp
     *
     * @param npi
     * @param ncpdp
     */
    public void fillInPharmacyProviderIdentifiersSectionWithDifferentNpi(String npi, String ncpdp) {
        Reports.log("Open Provider Identifier Number page");
        typeAndSelectNpiTextField(npi);
        Reports.log("Type NCPDP: " + ncpdp);
        setFieldValueWithTabAndWait(TEXT_FIELD_NCPDP, ncpdp);
    }


    /**
     * This method clicks Radio button by value
     */
    public void clickDeaRadiobuttonByValue() {
        Reports.log("Select value in DEA radio-button: No");
        ajaxClick(RADIOBUTTON_DEA_NUMBER);


    }


    public SDHomePage sdhomePage = new SDHomePage(driver, wait);


    /**
     * This method type and select Npi text field using NPI, taxonomyCategory
     *
     * @param npi
     */
    //Updated per Email received from Leonid on 12/30/2020.
    public void typeAndSelectNpiTextField(String npi) {
        for (int i = 0; i < 10; i++) {
            try {
                if (driver.findElement(By.xpath("//*[text()='Verified']")).isDisplayed()) {
                    String enteredNPINum = driver.findElement(TEXT_FIELD_NEW_NPI).getAttribute("value");
                    Reports.log("entered NPI: " + enteredNPINum);
                    break;
                }
            } catch (Exception e) {
            }
            Reports.log("Type NPI: " + npi + " attempt " + i);
            ajaxScroll(TEXT_FIELD_NEW_NPI);
            setFieldValueWithWaits(TEXT_FIELD_NEW_NPI, npi);
            try {
                if (driver.findElement(By.xpath("//p[contains(.,'Enter valid NPI number')]")).isDisplayed()) {
                    npi = sdhomePage.getRandomStringFromFile("SDNPI");
                    Reports.log("New NPI: " + npi);
                }
            } catch (Exception e) {
            }


            if (i >= 9) {
                Assert.fail("Entering an invalid NPI num");
            }
        }
    }




    public void typeAndSelectNpiTextFieldForGRP(String npi) {
        for (int i = 0; i < 10; i++) {
            try {
                if (driver.findElement(By.xpath("//*[text()='Verified']")).isDisplayed()) {
                    String enteredNPINum = driver.findElement(TEXT_FIELD_NEW_NPI).getAttribute("value");
                    Reports.log("entered NPI: " + enteredNPINum);
                    break;
                }
            } catch (Exception e) {
            }
            Reports.log("Type NPI: " + npi + " attempt " + i);
            ajaxScroll(TEXT_FIELD_NEW_NPI);
            setFieldValueWithWaits(TEXT_FIELD_NEW_NPI, npi);
            try {
                if (driver.findElement(By.xpath("//p[contains(.,'Enter valid NPI number')]")).isDisplayed()) {
                    npi = sdhomePage.getRandomStringFromFile("SDNPI");
                    Reports.log("New NPI: " + npi);
                }
            } catch (Exception e) {
            }


            if (i >= 9) {
                Assert.fail("Entering an invalid NPI num");
            }
        }
    }


    public void fillNPIInKeyPersonal(String npi){




    }


    /**
     * This method clicks medicare radio button by value
     *
     * @param value
     */
    public void clickMedicareRadiobuttonByValue(String value) {
        javaWaitSec(3);
        ajaxClick(By.xpath("//input[contains(@name, 'Medicare')][@value='" + value + "']"));
        Reports.log("Select value in Medicare radio-button: " + value);
    }
    public void clickCrossoverRadioButtonByValue(String value){
        ajaxClick(By.xpath("//input[contains(@name,'Is this a Crossover only application?')][@value='" + value + "']"));
        Reports.log("Selected value for CrossOver type application " + value);


    }


    /**
     * This method clicks medicare radio button by value
     *
     * @param value
     */
    public void clickMedicaidStateRadiobuttonByValue(String value) {
        ajaxClick(By.xpath("//input[contains(@name,'enrolled in Medicaid or CHIP in your home state?')][@value='" + value + "']"));
        Reports.log("Select value in Other Medicaid State radio-button: " + value);


    }


    /**
     * This method selects the Trading Partner Type
     */
    public void clickTradingPartnerTypeRadioButtonByValue(String value) {
        ajaxClick(By.xpath("//input[contains(@name,'If you bill services')][@value='" + value + "']"));
        Reports.log("Trading Partner Type selected: " + value);


    }


    /**
     * This method clicks Laboratory No Value
     */
    public void clickLaboratoryNoValue() {
        ajaxClick(By.xpath("//input[contains(@name, 'laboratory')][@value='false']"));
        Reports.log("Select value in Medicare radio-button: ");


    }


    /**
     * This method fills in address information using enrollmentType, physicalAdress, city, mailingState, zip, countyCode
     *
     * @param enrollmentType
     * @param physicalAdress
     * @param city
     * @param mailingState
     * @param zip
     * @param countyCode
     */
    public void fillInAddressInformation(String enrollmentType, String physicalAdress, String city, String mailingState, String zip, String countyCode) throws InterruptedException {
        Reports.log("\nFill in Address Detail Section");
        javaWaitSec(5);
        ajaxScrollUp();
        ajaxClick(SECTION_PROVIDER_ADDRESS_DETAILS);


        if (enrollmentType.contains(Data.pemApplication)) {
            setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_ATTENTION_LINE, "Dr");
            Reports.log("Typed Attention Line: Hello " + "Dr");
        }
        // driver.findElement(SECTION_PROVIDER_ADDRESS_DETAILS).click();
        fillInIndividualAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        javaWaitSec(2);
        fillInCalendar(getCurrentDate(), Data.effectiveStartDateCalendar, EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.effectiveEndDateCalendar, EFFECTIVE_END_DATE);
        javaWaitSec(2);




        javaWaitSec(2);
        Reports.log("\nfilling in Home/Corp Office Address");
        ajaxScrollDown();
        ajaxClick(HOME_CORP_OFFICE_ADDRESS_FOR_GRP);
        Reports.log("filling in Home/Corp Office Contact Person Details");
        ajaxClick(HOME_CORP_OFFICE_CONTACT_PERSON_DETAILS);


    }
    public void fillInAddressInformationForIndividual(String enrollmentType, String physicalAdress, String city, String mailingState, String zip, String countyCode,String email) throws InterruptedException {
        Reports.log("\nFill in Address Detail Section");
        javaWaitSec(2);
        ajaxScrollUp();
        ajaxClick(SECTION_PROVIDER_ADDRESS_DETAILS);


        if (enrollmentType.contains(Data.pemApplication)) {
            setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_ATTENTION_LINE, "Dr");
            Reports.log("Typed Attention Line: Hello " + "Dr");
        }
        // driver.findElement(SECTION_PROVIDER_ADDRESS_DETAILS).click();
        fillInIndividualAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInPaytoAddressContactPersonDetails(email);
        javaWaitSec(2);
        Reports.log("\nfilling in Home/Corp Office Address");
        ajaxScrollDown();
        ajaxClick(HOME_CORP_OFFICE_ADDRESS);
        Reports.log("filling in Home/Corp Office Contact Person Details");
        ajaxClick(HOME_CORP_OFFICE_CONTACT_PERSON_DETAILS);


    }


    public void fillInAddressInformationForTP(String enrollmentType, String physicalAdress, String city, String mailingState, String zip, String countyCode,String email) throws InterruptedException {
        Reports.log("\nFill in Address Detail Section");
        javaWaitSec(2);
        ajaxScrollUp();
        ajaxClick(SECTION_PROVIDER_ADDRESS_DETAILS);


        if (enrollmentType.contains(Data.pemApplication)) {
            setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_ATTENTION_LINE, "Dr");
            Reports.log("Typed Attention Line: Hello " + "Dr");
        }
        // driver.findElement(SECTION_PROVIDER_ADDRESS_DETAILS).click();
        fillInIndividualAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInPaytoAddressContactPersonDetails(email);
        javaWaitSec(2);
        Reports.log("\nfilling in Home/Corp Office Address");
        ajaxScrollDown();
        ajaxClick(HOME_OR_CORP_OFC_ADDRESS);
        Reports.log("filling in Home/Corp Office Contact Person Details");
        ajaxClick(HOME_OR_CORP_OFC_CONTACT_PERSON_DETAILS);
        javaWaitSec(2);
        ajaxClick(SERVICE_LOC_OFC_ADDRESS);
        javaWaitSec(2);
        ajaxClick(SERVICE_LOC_OFC_CONTACT_PERSON_DETAILS);
        javaWaitSec(2);
    }


    public void fillInAddressInformationForPEM(String enrollmentType, String physicalAdress, String city, String mailingState, String zip, String countyCode,String email) throws InterruptedException {
        Reports.log("\nFill in Address Detail Section");
        javaWaitSec(2);
        ajaxScrollUp();
        ajaxClick(SECTION_PROVIDER_ADDRESS_DETAILS);


        if (enrollmentType.contains(Data.pemApplication)) {
            setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_ATTENTION_LINE, "Dr");
            Reports.log("Typed Attention Line: Hello " + "Dr");
        }
        // driver.findElement(SECTION_PROVIDER_ADDRESS_DETAILS).click();
        fillInIndividualAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInPaytoAddressContactPersonDetails(email);
        javaWaitSec(2);
        Reports.log("\nfilling in Home/Corp Office Address");
        ajaxScrollDown();
//        ajaxClick(HOME_OR_CORP_OFC_ADDRESS);
//        Reports.log("filling in Home/Corp Office Contact Person Details");
//        ajaxClick(HOME_OR_CORP_OFC_CONTACT_PERSON_DETAILS_PEM);
//        Reports.log("\nService Location Office Contact Person Details");
//        ajaxClick(SERVICE_LOC_OFC_ADDRESS);
//        javaWaitSec(2);
//        ajaxClick(SERVICE_LOC_OFC_CONTACT_PERSON_DETAILS);
        javaWaitSec(2);
    }






    /**
     * This method fills in individual address details using physicalAdress, city, mailingState, zip, countyCode
     *
     * @param physicalAdress
     * @param city
     * @param mailingState
     * @param zip
     * @param countyCode
     */
    public void fillInIndividualAddressDetails(String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(findAnyElement(TEXT_FIELD_ADDRESS)));


            Reports.log("Type physical address: " + physicalAdress);
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, physicalAdress);
        } catch (ElementNotInteractableException e) {
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, physicalAdress);
        }


        Reports.log("Type City: " + city);
        setFieldValueWithTabAndWait(TEXT_FIELD_MAILING_ADDRESS_CITY, city);


//        if(enrollmentType.equalsIgnoreCase(Data.entityApplication))
//        {
//            setFieldValueWithTabAndWait(TEXT_FIELD_MAILING_ZIP_CODE2, zip);
//        }else {
//            setFieldValueWithTabAndWait(TEXT_FIELD_MAILING_ZIP_CODE, zip);
//        }
        Reports.log("Type zip code: " + zip);
        setFieldValueWithTabAndWait(TEXT_FIELD_MAILING_ZIP_CODE2, zip);


        Reports.log("Type County Code: " + countyCode);
        //ajaxClick(TEXT_COUNTY_CODE);
        //driver.findElement(TEXT_COUNTY_CODE).clear();
        setFieldValueWithTabAndWait(TEXT_MAILING_COUNTY_CODE, countyCode);


        driver.findElement(DROP_DOWN_MAILING_ADDRESS_STATE).sendKeys("");
        Reports.log("Select mailing state: " + mailingState);
        ajaxClick(setSpecificStrongOptionInListbox(mailingState));




        fillInCalendar(getCurrentDate(), Data.effectiveStartDateCalendar, EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.effectiveEndDateCalendar, EFFECTIVE_END_DATE);
        javaWaitSec(2);
    }
    public void fillInPaytoAddressContactPersonDetails(String email){
        Reports.log("Typed Attention Line: Hello Dr");
        setFieldValueWithTabAndWait(ATTENTION_LINE_IN_ADDRESS_DETAILS_SECTION, "Landmark");


        Reports.log("Typed Email: " + email);
        setFieldValueWithTabAndWait(CONTACT_PERSON_EMAIL_TEXT_FIELD, email);


        Reports.log("Type Phone: " + Data.phone);
        setFieldValueWithTabAndWait(PHONE_IN_ADDRESS_DETAILS_SECTION, Data.phone);






    }


    public void fillInAddressDetails(String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(findAnyElement(TEXT_FIELD_ADDRESS)));


            Reports.log("Type physical address: " + physicalAdress);
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, physicalAdress);
        } catch (ElementNotInteractableException e) {
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, physicalAdress);
        }


        Reports.log("Type City: " + city);
        setFieldValueWithTabAndWait(TEXT_ADDRESS_CITY, city);
        javaWaitSec(15);
        Reports.log("Type zip code: " + zip);
        if (enrollmentType.contains("Group")) {
            setFieldValueWithTabAndWait(TEXT_FIELD_ZIP_CODE1, zip);


        }
        if (enrollmentType.contains("Trading Partner") || enrollmentType.contains(Data.BILLING_PROVIDER)) {
            setFieldValueWithTabAndWait(TEXT_FIELD_ZIP_CODE, zip);
        }


        javaWait(1);


        Reports.log("Type County Code: " + countyCode);
        //ajaxClick(TEXT_COUNTY_CODE);
        //driver.findElement(TEXT_COUNTY_CODE).clear();
        setFieldValueWithTabAndWait(TEXT_COUNTY_CODE, countyCode);


        javaWait(1);
        driver.findElement(DROP_DOWN_ADDRESS_STATE).click();
        Reports.log("Select mailing state: " + mailingState);
        ajaxClick(setSpecificStrongOptionInListboxSD(mailingState));
    }




    /**
     * This method mailing address contact person using firstName, lastName, phone, email
     *
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     */
    public void mailingAddressContactPerson(String firstName, String lastName, String phone, String email) {
        Reports.log("\nFill in Mailing Address Contact Person Details");


//        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_FIRST_NAME, firstName);
//        Reports.log("Type First Name: " + firstName);
//
//        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_LAST_NAME, lastName);
//        Reports.log("Type Last Name: " + lastName);


        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_ATTENTION_LINE,firstName + " "+ lastName);
        Reports.log("Typed Attention Line: " + firstName + " "+ lastName);


        driver.findElement(TEXT_FIELD_CONTACT_PHONE).clear();
        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_PHONE, phone);
        Reports.log("Typed Phone: " + phone);


        driver.findElement(TEXT_FIELD_CONTACT_PERSON_EMAIL).clear();
        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_PERSON_EMAIL, email);
        Reports.log("Typed Email: " + email);
        javaWaitSec(3);


        driver.findElement(By.xpath(".//input[@name='Position']")).click();
        javaWaitSec(2);
        driver.findElement(By.xpath(".//li[@id=\"react-autowhatever-Position--item-0\"]/div")).click();
        javaWaitSec(2);




        ajaxScrollDown();
        ajaxClick(HOME_CORP_OFFICE_ADDRESS_FOR_GRP);
        Reports.log("filling in Home/Corp Office Contact Person Details");
        ajaxClick(HOME_CORP_OFFICE_CONTACT_PERSON_DETAILS);
        javaWaitSec(2);
    }


    /**
     * This method fills Taxonomy and License Information Section
     *
     * @param taxonomyCategory
     * @param taxonomy
     * @param enrollmentType
     */
    public void fillTaxonomyAndLicenseInformationSection(String taxonomyCategory, String taxonomy, String enrollmentType) {


        Reports.log("\nFill in Taxonomy/License Information Section");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_TAXONOMY));
        ajaxClick(SECTION_TAXONOMY);
        // driver.findElement(SECTION_TAXONOMY).click();
        if (enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            fillInLicensureInPharmacy(taxonomyCategory, taxonomy, 0, Data.pharmacyLicenseNumber);
            return;
        }
        fillInLicensure(taxonomyCategory, taxonomy, enrollmentType);




    }




    /**
     * This method fills in Licensure In Pharmacy
     *
     * @param pharmacyType
     * @param taxonomy
     * @param index
     * @param licenseNumber
     */
    public void fillInLicensureInPharmacy(String pharmacyType, String taxonomy, int index, String licenseNumber) {
        clickCheckboxByValue(pharmacyType);
        Reports.log("Type first numbers of taxonomy: " + taxonomy);
        driver.findElement(COMBOBOX_TAXONOMY_PHARAMACY).sendKeys("");
        clickFirstOptionInList();
        // License Number
        driver.findElement(TEXT_FIELD_LICENSE_NUMBER1_PHARMACY).sendKeys("78A186138");


        //License type
        ajaxClick(setAndFindCombobox("License Type"));
        setAndFindCombobox("License Type").sendKeys("License");
        clickFirstOptionInList();
        // License Issue State
        ajaxClick(setAndFindCombobox("License Issue State"));
        setAndFindCombobox("License Issue State").sendKeys("Wyoming");
        clickFirstOptionInList();


        // License Effective Date
        ajaxClick(DROP_DOWN_LICENSE_EFFECTIVE_DATE1_PHARMACY);
        Reports.log("Opened License Effective Start Date Calender");
        ajaxClick(CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE);
        Reports.log("Calendar Selected as the 1st of the month");
        javaWaitSec(1);
        WebElement calender = driver.findElement(By.xpath("(//input[@name='datepicker'])[2]"));
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        String date = changeYearInCurrentDate(3);
        Reports.log("Date is: " + date);
        calender.sendKeys(date);
        calender.sendKeys(TAB);
        javaWaitSec(1);


        addPharmacyLicenseLine(0);
    }


    /**
     * This method adds Pharmacy License Line
     *
     * @param index
     */
    public void addPharmacyLicenseLine(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);


        Reports.log("Entered License Number: 78A186138");
        driver.findElement(TEXT_FIELD_LICENSE_NUMBER2_PHARMACY).sendKeys("78A186138");


        Reports.log("Entered License Type: " + Data.licenseType);
        ajaxClick(DROP_DOWN_LICENSE_TYPE, index);
        clickLicenseInList();


        Reports.log("Entered License Issue State");
        ajaxClick(DROP_DOWN_LICENSE_ISSUE_STATE2_PHARMACY, index);
        clickLicenseStateInList();


        Reports.log("Entered License Effective Date");
        ajaxClick(DROP_DOWN_LICENSE_EFFECTIVE_DATE2_PHARMACY, (index));
        ajaxClick(CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE, index);
        Reports.log("Entered License Expiration Date");
        javaWaitSec(1);
        WebElement calender = driver.findElement(By.xpath("(//input[@name='datepicker'])[4]"));
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        String date = changeYearInCurrentDate(3);
        Reports.log("Date is: " + date);
        calender.sendKeys(date);
        calender.sendKeys(TAB);
        javaWaitSec(2);
        setAndFindButton(Data.TEXT_SAVE).click();
    }


    /**
     * This method fills in Licensure section
     *
     * @param speciality1
     * @param firstDigitsOfTaxonomy
     * @param enrollmentType
     */
    public void fillInLicensure(String speciality1, String firstDigitsOfTaxonomy, String enrollmentType) {
        Reports.log("Open Licensure Information");


        Reports.log("Click speciality option: " + speciality1);
        javaWaitSec(3);
        ajaxClick(spanInputValue(speciality1));
        //   performClick(spanInputValue(speciality1));


        //First taxonomy for Dental
        //   fillInTaxonomy(0, firstDigitsOfTaxonomy);
        fillInTaxonomy(0, "1");
        try {
            driver.findElement(By.xpath("//li[text()='This field is required']"));
            Assert.fail("Text field is required!");
        } catch (Exception e) {
        }
    }


    /**
     * This method fills in Taxonomy section
     *
     * @param index
     * @param taxonomy
     */
    public void fillInTaxonomy(int index, String taxonomy) {
        Reports.log("Click Taxonomy text field");
        ajaxClick(COMBOBOX_TAXONOMY, index);
        //selectValueInCombobox(taxonomy, COMBOBOX_TAXONOMY, index);
        driver.findElement(COMBOBOX_TAXONOMY).sendKeys("");
        ajaxScrollByCoordinate(100);
        ajaxScroll(setAndFindAnyTitle("Taxonomies", Data.h2));
        javaWaitSec(2);
        // ajaxScrollByCoordinate(100);
        clickFirstOptionInList();
        javaWaitSec(1);


        //Reports.log ("Debug");
    }
    /**
     * This method fills in Taxonomy section
     *
     */
    public void fillInTaxonomyForTP() {
        ajaxClick(ADD_TAXONOMY_BUTTON);
        javaWaitSec(3);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_ENDDate);
        javaWaitSec(1);
        ajaxClick(SAVE_BUTTON_INDEX1);
        javaWaitSec(1);
        ajaxClick(setAndFindButton("Next"));
    }




    /**
     * This method adds License Line
     *
     * @param index
     */
    public void addLicenseLine(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);


        Reports.log("Entered License Number: 78A186138");
        driver.findElements(TEXT_FIELD_LICENSE_NUMBER).get(index).sendKeys("78A186138");


        Reports.log("Entered License Type: " + Data.licenseType);
        clickLicenseInList();


        Reports.log("Entered License Issue State");
        ajaxClick(DROP_DOWN_LICENSE_ISSUE_STATE);
        clickLicenseStateInList();


        Reports.log("Entered License Effective Date");
        ajaxClick(CALENDER_LICENSE_EFFECTIVE_DATE2);
        ajaxClick(CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE);


        Reports.log("Entered License Expiration Date");
        javaWaitSec(1);
        WebElement calender = driver.findElement(By.xpath("(//input[@name='datepicker'])[2]"));
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        String date = changeYearInCurrentDate(3);
        Reports.log("Date is: " + date);
        calender.sendKeys(date);
        calender.sendKeys(TAB);
        javaWaitSec(1);


        ajaxScrollByCoordinate(200);
        ajaxScroll(setAndFindAnyTitle("License Information", Data.h2));
        setAndFindButton(Data.TEXT_SAVE).click();
    }


    /**
     * This method adds Certification Line
     *
     * @param index
     */
    public void addCertificationLine(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 1);


        Reports.log("Entered Certification Number: 78B187000");
        driver.findElements(TEXT_FIELD_CERTIFICATION_NUMBER).get(index).sendKeys("78B187000");


        Reports.log("Entered Certification Effective Date");
        ajaxClick(CALENDER_CERTIFICATION_EFFECTIVE_DATE);
        ajaxClick(CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE);


        ajaxScrollByCoordinate(200);
        ajaxScroll(setAndFindAnyTitle("Certification Information (Medicare/Board/Agency)", Data.h2));
        setAndFindButton(Data.TEXT_SAVE).click();
    }


    /**
     * This method fills in primary service location section using enrollmentType, firstName, lastName, newEmail, zipCode
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param newEmail
     * @param zipCode
     */
    public void fillInPrimaryServiceLocationSection(String enrollmentType, String firstName, String lastName, String newEmail, String zipCode, String state) {
        Reports.log("\nFill in Primary Service Location Section");
        ajaxClick(SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION);
        //    driver.findElement(SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION).click();
//        if(enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)){
//            addLinePharmacyKeyPersonal(0);
//        }
        fillInPrimaryServiceLocation(firstName, lastName, newEmail, zipCode, state, enrollmentType);
    }


    /**
     * This method fills in Service location section
     *
     * @param enrollmentType
     * @param email
     * @param zipCode
     */
    public void fillInServiceLocationSection(String enrollmentType, String email, String zipCode, String pgmParticipation, String taxonomy) {
        Reports.log("\nFill in Primary Service Location Section");
        ajaxClick(SECTION_PROVIDER__SERVICE_LOCATION);
        ajaxClick(ADD_LOCATION_BUTTON);


        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START);
        javaWaitSec(1);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_END);
        javaWaitSec(1);


        fillInLocationInformation(zipCode, email);
        javaWaitSec(1);
        if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)) {
            addLocationProgramParticipation(enrollmentType, pgmParticipation, taxonomy);
        }
//       // if(enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)){
//            fillInProgramParticipationEntity(enrollmentType);
//        }
        fillInClaimInformation();
        fillInMiscellaneousDetails();
        ajaxClick(SAVE_BUTTON_INDEX1);
        ajaxClick(setAndFindButton("Next"));
        javaWait(2);
    }


    public void fillInServiceLocationSectionforPEM(String enrollmentType, String email, String zipCode, String pgmParticipation, String taxonomy) {
        Reports.log("\nFill in Primary Service Location Section");
        ajaxClick(SECTION_PROVIDER__SERVICE_LOCATION);
        ajaxClick(ADD_LOCATION_BUTTON);


        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START);
        javaWaitSec(1);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_END);
        javaWaitSec(1);


        fillInLocationInformation(zipCode, email);
        javaWaitSec(1);
//        if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)) {
//            addLocationProgramParticipation(enrollmentType, pgmParticipation, taxonomy);
//        }
//       // if(enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)){
//            fillInProgramParticipationEntity(enrollmentType);
//        }
//        fillInClaimInformation();
//        fillInMiscellaneousDetails();
        ajaxClick(SAVE_BUTTON_INDEX1);
//        ajaxClick(setAndFindButton("Next"));
        javaWait(2);
    }


    public void fillInServiceLocationSectionforTP(String enrollmentType, String zipCode, String pgmParticipation, String taxonomy) {
        Reports.log("\nFill in Primary Service Location Section");
        ajaxClick(SECTION_PROVIDER__SERVICE_LOCATION);
        ajaxClick(ADD_LOCATION_BUTTON);


        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START);
        javaWaitSec(1);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_END);
        javaWaitSec(1);


        fillInLocationInformation(zipCode, email);
        javaWaitSec(1);


        // if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) ||
        //     enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER) ||
        //     enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)) {
        //     addLocationProgramParticipation(enrollmentType, pgmParticipation, taxonomy);
        // }


        // if(enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)) {
        //     fillInProgramParticipationEntity(enrollmentType);
        // }


        addLocationProgramParticipation(enrollmentType, pgmParticipation, taxonomy);
        fillInClaimInformation();


        // fillInMiscellaneousDetails();


        ajaxClick(SAVE_BUTTON_INDEX1);
        ajaxClick(setAndFindButton("Next"));
        javaWait(2);
    }






    public void fillInAuthorizedSignature(){
        javaWaitSec(5);
        Reports.log("\nFill in Authorized Signature Section");
        ajaxScroll(SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        ajaxClick(SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        javaWaitSec(5);
        driver.findElement(By.xpath("//input[contains(@name,'Authorized Signatory')]")).click();
        javaWaitSec(5);
        driver.findElement(By.xpath("(//div[contains(@id,'Authorized Signatory')]//ul//li//div)[1]")).click();
        javaWaitSec(2);
        ajaxClick(setAndFindButton("Next"));
        javaWaitSec(5);
    }




    public void fillInLocationInformation(String zipCode, String email) {
        Reports.log("Type Location Name: SD Test");
        setFieldValueWithTabAndWait(LOCATION_NAME_TEXT_FIELD, "SD Test");


        Reports.log("Type Location Address Line: " + Data.physicalAddress);
        setFieldValueWithTabAndWait(ADDRESS_LINE_TEXT_FIELD, Data.physicalAddress);


        Reports.log("Type City: " + Data.city);
        setFieldValueWithTabAndWait(SERVICES_LOCATION_CITY_TEXT_FIELD, Data.city);


        javaWaitSec(2);
        driver.findElement(SERVICES_LOCATION_STATE_DROPDOWN).click();
        Reports.log("Select State: " + Data.mailingState);
        ajaxClick(setSpecificOptionInListbox(Data.mailingState));
        javaWaitSec(2);


        Reports.log("Type Zip code: " + zipCode);
        //  driver.findElement(SERVICES_LOCATION_ZIP_CODE_TEXT_FIELD).clear();
        setFieldValueWithTabAndWait(SERVICES_LOCATION_ZIP_CODE_TEXT_FIELD, zipCode);


        Reports.log("Type County Code: " + Data.COUNTY_CODE_SD);
        //   driver.findElement(SERVICES_LOCATION_COUNTY_CODE_TEXT_FIELD).clear();
        driver.findElement(SERVICES_LOCATION_COUNTY_CODE_TEXT_FIELD).sendKeys("12086");
        clickFirstOptionInList();
        javaWaitSec(2);
        Reports.log("Typed Attention Line: Hello Dr");
        setFieldValueWithTabAndWait(CONTACT_ATTENTION_LINE_TEXT_FIELD, "Hello Dr");


        Reports.log("Typed Email: " + email);
        setFieldValueWithTabAndWait(CONTACT_PERSON_EMAIL_TEXT_FIELD, email);


        Reports.log("Type Phone: " + Data.phone);
        setFieldValueWithTabAndWait(CONTACT_PHONE_TEXT_FIELD, Data.phone);
        javaWaitSec(2);
        driver.findElement(MAILING_ADDRESS).click();
        javaWaitSec(2);


        driver.findElement(MAILING_ADDRESS_CONTACT_DETAILS).click();
        javaWaitSec(2);
    }




    public void fillInClaimInformation() {
        try {
            robotUploadDocument(UPLOAD_CLAIM_DOCUMENTS_BUTTON);
            javaWaitSec(4);


            ajaxClick(NO_RADIOBTN_TO_CLAIM_INCLUDE_PRIOR_AUTHZTN);
            Reports.log("Does your claim include prior authorization ? Selected No");
        }catch (Exception e){
            Reports.log("Claims Information is not needed");
        }
    }


    public void fillInMiscellaneousDetails() {
        javaWaitSec(5);
        driver.findElement(LANGUAGE_SUPPORT_DROP_DOWN).click();
        ajaxClick(setSpecificOptionInListbox(Data.LANGUAGE_ENGLISH));
        Reports.log("Select Language Support: English");
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        javaWaitSec(5);




        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(GENDER_SERVED_DROP_DOWN)).click().perform();


        javaWaitSec(3);
//        driver.findElement(GENDER_SERVED_DROP_DOWN).click();
        ajaxClick(setSpecificOptionInListbox(Data.genderMale));
        Reports.log("Select Language Support: Male");


        ajaxClick(ALL_AGE_CHECKBOX);
        Reports.log("Age Ranges Served :Checked, All Age");


        ajaxClick(NO_RADIOBTN_ACCEPTING_NEW_PATIENTS);
        Reports.log("Accepting new patients?, No");


        ajaxClick(NO_RADIOBTN_LOCATION_TTD_EQUIPPED);
        Reports.log("Is this location TTD/TTY equipped?, No");


        ajaxClick(COUNTY_RADIOBTN);
        Reports.log("County, all County");


        ajaxClick(YES_RADIOBTN_OPEN_LOCATION_24HOURS);
        Reports.log("Is this location Open 24 Hours?, Yes");


        ajaxClick(NO_RADIOBTN_PROVIDER_EMERGANCY_SERVICES_24HRS);
        Reports.log("Does this location provide emergency services after standard business hours?, No");


        ajaxClick(YES_RADIOBTN_STORES_PATIENT_RECORDS);
        Reports.log("Do you store patient records at this location?, Yes");


        ajaxClick(YES_RADIOBTN_STORES_PERSONAL_RECORDS);
        Reports.log("Do you store Personnel records at this location?, Yes");
        javaWaitSec(2);


        Reports.log("Type Phone: " + Data.phone);
        setFieldValueWithTabAndWait(PHONE_NUMBER_TEXT_FIELD, Data.phone);


        driver.findElement(MANNER_OF_SERVICES).click();
        Reports.log("Select : " + Data.MANNER_OF_SERVICES);
        ajaxClick(setSpecificOptionInListbox(Data.MANNER_OF_SERVICES));
        javaWaitSec(2);
        ajaxClick(NO_RADIOBTN_WHEELCHAIR_ACCESSABILITY);
        ajaxClick(NO_RADIOBTN_PARKING_SPACE);
        ajaxClick(NO_RADIOBTN_ASSISITIVE_SERVICES);
        ajaxClick(NO_RADIOBTN_ACCESIBLE_EXAM_ROOMS);
        javaWaitSec(2);


    }


    /**
     * This method fills in primary service location using firstName, lastName, newEmail, zip
     *
     * @param firstName
     * @param lastName
     * @param newEmail
     * @param zip
     */
    public void fillInPrimaryServiceLocation(String firstName, String lastName, String newEmail, String zip, String state, String enrollmentType) {
        if (state == Data.inState) {
            Reports.log("Type Primary Service Address: " + Data.physicalAddress);
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, Data.physicalAddress);


            Reports.log("Type City: " + Data.city);
            setFieldValueWithTabAndWait(TEXT_FIELD_PRIMARY_ADDRESS_CITY, Data.city);


            driver.findElement(DROP_DOWN_PRIMARY_ADDRESS_STATE).sendKeys("");
            Reports.log("Select mailing state: " + Data.mailingState);
            ajaxClick(setSpecificStrongOptionInListbox(Data.mailingState));


            Reports.log("Type zip: " + zip);
            if (enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER)
                    || enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)) {
                driver.findElement(TEXT_FIELD_PRIMARY_ZIP_CODE2).clear();
                setFieldValueWithTabAndWait(TEXT_FIELD_PRIMARY_ZIP_CODE2, zip);
            } else {
                //driver.findElement(TEXT_FIELD_SERVICE_LOCATION_ZIP).click();
                driver.findElement(TEXT_FIELD_PRIMARY_ZIP_CODE).clear();
                setFieldValueWithTabAndWait(TEXT_FIELD_PRIMARY_ZIP_CODE, zip);
            }


            Reports.log("Type County Code: " + Data.countyCodeSD);
            //  driver.findElement(TEXT_FIELD_SERVICE_LOCATION_COUNTY_CODE).click();
            driver.findElement(TEXT_PRIMARY_COUNTY_CODE).clear();
            setFieldValueWithTabAndWait(TEXT_PRIMARY_COUNTY_CODE, Data.countyCodeSD);


        } else if (state == Data.outState) {
            Reports.log("Type Primary Service Address: " + Data.physicalAddressCA);
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, Data.physicalAddressCA);


            Reports.log("Type City: " + Data.citySAC);
            setFieldValueWithTabAndWait(TEXT_FIELD_PRIMARY_ADDRESS_CITY, Data.citySAC);


            driver.findElement(DROP_DOWN_MAILING_ADDRESS_STATE).sendKeys("");
            Reports.log("Select mailing state: " + Data.mailingOutState);
            ajaxClick(setSpecificStrongOptionInListbox(Data.mailingOutState));


            Reports.log("Type zip: " + Data.zipCA);
            driver.findElement(TEXT_FIELD_PRIMARY_ZIP_CODE).clear();
            setFieldValueWithTabAndWait(TEXT_FIELD_PRIMARY_ZIP_CODE, Data.zipCA);


            Reports.log("Type County Code: " + Data.countyCodeSAC);
            driver.findElement(TEXT_PRIMARY_COUNTY_CODE).clear();
            setFieldValueWithTabAndWait(TEXT_PRIMARY_COUNTY_CODE, Data.countyCodeSAC);
        }


        Reports.log("Enter Contact Person");
        Reports.log("Type First Name: " + firstName);
        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_FIRST_NAME, firstName);


        Reports.log("Type Last Name: " + lastName);
        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_LAST_NAME, lastName);


        Reports.log("Type Phone: " + Data.phone);
        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_PHONE, Data.phone);


        Reports.log("Type EmailId Address: " + newEmail);
        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_PERSON_EMAIL, newEmail);


        if (enrollmentType.contains(Data.TRADING_PARTNER)) {
            ajaxClick(setAndFindButton("Next"));
        }
    }


    public static final By ATYPICALL_PROVIDER=By.xpath("//input[contains(@name,'Are you an Atypical Provider?')][@value='No']");
//    public static final By LANGUAGE_SUPORTED=By.xpath(".//div[contains (@id,'Language Supported (Select all that apply)')]");


    public void flFillInIndividualProviderIdentifierSection(String npi){
        javaWaitSec(2);
        Reports.log("\nFill In Provider Identifier");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        javaWaitSec(2);
//        ajaxClick(ATYPICALL_PROVIDER);
//        Reports.log("Are you an Atypical Provider?, selected No");
        typeAndSelectNpiTextField(npi);
//        ajaxScroll(setAndFindButton("Next"));
        javaWaitSec(5);
        selectAllRadioBtnForPI("No");
        javaWaitSec(5);
//        selectFirstOptionInDropdown(LANGUAGE_SUPORTED);
//        javaWaitSec(2);
        ajaxScroll(COMBOBOX_CLAIM_SUBMISSION_METHOD);
        driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).click();
        WebElement claimSubmission = driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).findElement((DROP_DOWN_CLAIM_SUBMISSION_METHOD));
        claimSubmission.click();
        Reports.log("What claim Submission(s) do you use?: " + claimSubmission.getText());
        ajaxClick(setAndFindButton("Next"));




    }


    public static final String HISTORICAL_NPI="//input[contains(@name,'Do you have historical NPI?')][@value='%s']";


    public static final String CROSSOVER_ANY_APPLICATION="//input[contains(@name,'Are you applying to submit Medicare Crossover claims only?')][@value='%s']";


    public void selectAllRadioBtnForPI(String radioButtonValue){


        ajaxClick(By.xpath(String.format(HISTORICAL_NPI, radioButtonValue)));
        javaWaitSec(2);


        ajaxClick(By.xpath(String.format(CROSSOVER_ANY_APPLICATION, radioButtonValue)));
        javaWaitSec(2);


    }
    public static final String HAVE_YOU_EVER_DENIED_PROFESSIONAL_LIABILITY_INSURANCE="//input[contains(@name,'1. Have you ever been denied professional liability insurance?')][@value='%s']";
    public static final String HAVE_YOUR_PROFESSIONAL_LIABILITY_INSURANCE_EVER_BEEN_CANCELLED="//input[contains(@name,'2. Have your professional liability insurance ever been canceled')][@value='%s']";
    public static final String WITHIN_THE_PAST_SEVEN_YEARS="//input[contains(@name,'3. Within the past seven years have you been a party to any malpractice actions?')][@value='%s']";
    public static final String UNFAVOURABLE_JUDGEMENT="//input[contains(@name,'4. Within the past seven years has any malpractice action been settled')][@value='%s']";
    public static final String TO_YOUR_KNOWLEDGE_ISANY_MALPRACTICE_ACTION="//input[contains(@name,'5. To your knowledge, is any malpractice action against you currently pending?')][@value='%s']";
    public static final String DO_YOU_HAVEA_MENTAL_HEALTH_CONDITION="//input[contains(@name,'6. Do you have a mental or physical health condition')][@value='%s']";
    public static final String MALPRACTICE_INSURANCE="//input[contains(@name,'Do you have malpractice or general liability insurance?')][@value='%s']";
    public static final String MALPRACTICE_INSURANCE_HISTORY="//input[contains(@name,'Do you ever have Malpractice insurance history?')][@value='%s']";
    public void selectAllRadioBtnForPLII(String radioButtonValue){
        ajaxClick(By.xpath(String.format(HAVE_YOU_EVER_DENIED_PROFESSIONAL_LIABILITY_INSURANCE, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(HAVE_YOUR_PROFESSIONAL_LIABILITY_INSURANCE_EVER_BEEN_CANCELLED, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(WITHIN_THE_PAST_SEVEN_YEARS, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(UNFAVOURABLE_JUDGEMENT, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(TO_YOUR_KNOWLEDGE_ISANY_MALPRACTICE_ACTION, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(DO_YOU_HAVEA_MENTAL_HEALTH_CONDITION, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(MALPRACTICE_INSURANCE, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(MALPRACTICE_INSURANCE_HISTORY, radioButtonValue)));


    }


    public void flFillInIndividualProfessionalLiabilityInsuranceInformationSection(){
        javaWaitSec(2);
        Reports.log("\nFill In Professional Liability Insurance Information");
        ajaxClick(SECTION_PROFESSIONAL_LIABILITY_INSURENCE_INFO);
        javaWaitSec(2);
        selectAllRadioBtnForPLII("No");


    }
    public void flFillInIndividualProfessionalLiabilityInsuranceInformationSectionForGrp(){
        javaWaitSec(2);
        Reports.log("\nFill In Professional Liability Insurance Information");
        ajaxClick(SECTION_PROFESSIONAL_LIABILITY_INSURENCE);
        javaWaitSec(2);
        selectAllRadioBtnForPLIIForGrp("No");
        ajaxClick(setAndFindButton("Next"));


    }




    /**
     * This method fills in Exclusion and Sanction Section
     */
    public void fillInExclusionAndSanctionSection() {
        javaWaitSec(2);
        Reports.log("\nFill in Exclusion and Sanction Section");
        ajaxClick(SECTION_PROVIDER_EXCLUSION);
        //driver.findElement(SECTION_PROVIDER_EXCLUSION).click();
        selectAllRadioBtnForExclusion("No");
    }


    /**
     * This method fills in EFT Information section
     */
    public void fillInEFTInformationSection(String enrollmentType, String firstName) {
        javaWaitSec(2);
        Reports.log("\nFill in EFT Information Section");
        ajaxClick(SECTION_EFT_Information);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        javaWaitSec(3);
        fillEFTInformationSectionFieldsForIndividual(enrollmentType,firstName);
    }


    public void fillInEFTInformationSectionForIndividual(String enrollmentType,String firstName){
        javaWaitSec(2);
        Reports.log("\nFill in EFT Information Section");
        ajaxClick(SECTION_EFT_Information);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        javaWaitSec(3);
        fillEFTInformationSectionFieldsForIndividual(enrollmentType,firstName);


    }


    public void fillInOwnershipSection(String enrollmentType) {
        javaWaitSec(2);
        Reports.log("\nFill in Ownership Section");
        ajaxClick(SECTION_PROVIDER_OWNERSHIP);
        if (enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)) {
            fillInOwnershipSectionEntityEnrollment();
        }
        if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER)) {
            fillInOwnershipSecForBillingProvider();
        } else {
            selectOwnershipRadioButtons();
        }
    }


    public void fillInOwnershipSectionForServiceProvider() {
        javaWaitSec(2);
        Reports.log("\nFill in Ownership Section");
        ajaxClick(SECTION_PROVIDER_OWNERSHIP);
        ajaxClick(RADIOBUTTON_OWNERSHIP_OWNERSHIP_ENTITY);
        javaWaitSec(1);
        ajaxClick(RADIOBUTTON_OWNERSHIP_MANAGED_DIRECTED_BY_ENTITY);
    }




    public void addLocationProgramParticipation(String enrollmentType, String pgmParticipation, String taxonomy) {
        javaWaitSec(2);
        Reports.log("\nAdding Location Program Participation");
        ajaxClick(ADD_PROGRAM_PARTICIPATION_LINK_BUTTON);
        javaWaitSec(2);
        driver.getWindowHandles();
        driver.findElement(SELECT_PROGRAM_PARTICIPATION_DROPDOWN_LOCATION).click();
//        ajaxClick(SELECT_PROGRAM_PARTICIPATION_DROPDOWN_LOCATION);
        Reports.log("Clicked on the ADD PROGRAM PARTICIPATION button");
//        ajaxClick(setSpecificOptionInListbox("Trading Partner - 999"));
        ajaxClick(setSpecificOptionInListbox(taxonomy));
        Reports.log("Selected Program Participation : " + pgmParticipation);
        //SELECT_TAXONOMY_CHECKBOX
        ajaxClick(By.xpath(String.format(SELECT_TAXONOMY_CHECKBOX, pgmParticipation)));
        Reports.log(taxonomy + "Checkbox checked");


        fillInCalendar(getCurrentDate(), Data.LOCATION_TAXONOMY_EFFECTIVE_START_DATE);
        Reports.log("Entered Location Taxonomy Effective Start Date" + getCurrentDate());
//        fillInCalendar(getCurrentDate() + 5, Data.LOCATION_TAXONOMY_EFFECTIVE_END_DATE);
//        Reports.log("Entered Location Taxonomy Effective End Date" + getCurrentDate() + 5);


        javaWaitSec(2);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON_IN_SERVICE_LOCATION);
        Reports.log("Clicked on the Save button");
        javaWaitSec(2);
        Reports.log("Clicked on Save button");
        ajaxScrollUp();
//        if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)) {
        try{
            ajaxClick(NO_RADIOBTN_ONLY_HOME_LOCATION);
            Reports.log("Are services provided only in a residential home, school, or daycare setting (i.e. no office location)?, No");
        }catch(Exception e){}
    }


    public void fillInProgramParticipation(String enrollmentType) {
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        if (enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)) {
            ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
            Reports.log("Clicked on Program Participation / Taxonomy / License / Certificate Information");
            addProgramParticipation(Data.INDV_MEDICAID_CHIP, Data.HOSPITALS_AND_UNITS, ADD_PROGRAM_PARTICIPATION_BUTTON);
        } else {
            addProgramParticipation(Data.INDV_MEDICAID_CHIP, Data.HOSPITALS_AND_UNITS, ADD_PROGRAM_PARTICIPATION_LINK_BUTTON);
        }
        addTaxonomy(Data.TAXONOMY_HOSPITAL_GENERAL_CAR);
        addLicense("Lic", Data.SOUTH_DAKOTA, Data.LICENSE_NUMBER);
        ajaxClick(CONFIRM_BUTTON);
        Reports.log("Clicked on Confirm button");


        javaWaitSec(3);
        if (enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)) {
            ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON);
            Reports.log("Clicked on Save button");
        } else {
            ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
            Reports.log("Clicked on Save button");
        }
        javaWaitSec(5);
        ajaxClick(setAndFindButton("Next"));
    }


    public void fillInProgramParticipation(String enrollmentType, String prgmParticipation, String speciality, String taxonomy, String LicenseType, String firstName, String lastName) {
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        if (enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) ||
                enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)||enrollmentType.equalsIgnoreCase(Data.ENTITY_REVALIDATION)
                ||enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER_REVALIDATION)||enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER_REVALIDATION)) {
            ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
            Reports.log("Clicked on Program Participation / Taxonomy / License / Certificate Information");
            addProgramParticipation(prgmParticipation, speciality, ADD_PROGRAM_PARTICIPATION_BUTTON);
        } else {
            addProgramParticipation(prgmParticipation, speciality, ADD_PROGRAM_PARTICIPATION_LINK_BUTTON);
        }
        addTaxonomy(taxonomy);
        switch(speciality){
            case ("School"):
            case ("Agencies (Not specified elsewhere)"):
            case ("Radiology Tech. & Physiological Lab"):
            case ("Medical Equipment & Supplies"):
            case ("Long-Term Services & Supports"):
            case ("End-Stage Renal"):
            case ("Clinics"):
            case ("Group"):
            case ("State Directed "):
                Reports.log("Speciality selected does not require a License therefore skipping Adding a License Step");
                break;
            default:
                addLicense(LicenseType, Data.SOUTH_DAKOTA, Data.LICENSE_NUMBER);
        }
//        //This is a temporary code
//        if (!enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)||enrollmentType.equalsIgnoreCase(Data.ENTITY_REVALIDATION)){
//        addLicense(LicenseType, Data.SOUTH_DAKOTA, Data.LICENSE_NUMBER);
//        }
        ajaxClick(CONFIRM_BUTTON);
        Reports.log("Clicked on Confirm button");


        javaWaitSec(4);
        if (enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) ||
                enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)||enrollmentType.equalsIgnoreCase(Data.ENTITY_REVALIDATION)
                ||enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER_REVALIDATION)||enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER_REVALIDATION)) {
            ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON);
            Reports.log("Clicked on Save button");
        } else {
            ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
            Reports.log("Clicked on Save button");
        }
        javaWaitSec(5);
        ajaxClick(setAndFindButton("Next"));


//        if(prgmParticipation.equalsIgnoreCase(Data.PRIMARY_CARE_PROVIDER)){
//            fillInPCPAddendumSection(firstName, lastName);
//        }
    }


    public void fillInTaxonomyForIndividual(String enrollmentType, String speciality, String LicenseType){
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
        Reports.log("Clicked on Program Participation / Taxonomy / License / Certificate Information");
        javaWaitSec(2);
        addProgramParticipationForIndividual(speciality);
        javaWaitSec(5);
//        addLicenseForIndiPP(LicenseType, Data.LICENSE_NUMBER);
        addLicense(LicenseType, Data.FLORIDA, Data.LICENSE_NUMBER);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
        Reports.log("Clicked on Save button");


    }


    public void fillInTaxonomyForGroup(String enrollmentType, String speciality,String LicenseType){
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
        Reports.log("Clicked on Program Participation / Taxonomy / License / Certificate Information");
        javaWaitSec(2);
        addTaxonomyForEntity(speciality);
        javaWaitSec(5);
//        addLicenseForIndiPP(LicenseType, Data.LICENSE_NUMBER);
        addLicense(LicenseType, Data.FLORIDA, Data.LICENSE_NUMBER);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
        Reports.log("Clicked on Save button");


    }




    public void fillInTaxonomyForMCO(){
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
        Reports.log("Clicked on Program Participation / Taxonomy / License / Certificate Information");
        javaWaitSec(2);
        addProgramParticipationForMCO();
        javaWaitSec(5);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
        Reports.log("Clicked on Save button");


    }


//    public void fillInAffiliationSection(String npi, String affiliationType)
//    {
//        javaWaitSec(2);
//        Reports.log("\nFill in Affiliation Section");
//        ajaxClick(SECTION_AFFILIATION);
//        Reports.log("Clicked on Affiliation Section");
//
//        ajaxClick(ADD_AFFILIATION_BTN);
//        Reports.log("Clicked on ADD AFFILIATION button");
//        javaWaitSec(2);
//
//        driver.findElement(AFFILIATION_PROVIDER_NAME_INPUT).sendKeys("4000048");
//        Reports.log("Entered NPI value "+"4000048");
//        javaWaitSec(1);
//        ajaxClick(AFFILIATION_SEARCH_BTN);
//        Reports.log("Clicked on the search Button");
//        javaWaitSec(1);
//
//        ajaxClick(AFFILIATION_ADD_BTN);
//        Reports.log("Clicked on ADD button");
//        javaWaitSec(2);
//
//        //Affiliation Dialog pop-up
////        performClick(AFFILIATION_TYPE_DROPDOWN);
//        javaWaitSec(2);
////        ajaxClick(By.xpath(String.format(AFFILIATION_TYPE_DROPDOWN_LIST, affiliationType)));
////        Reports.log("Selected Affiliation Type: "+affiliationType);
//
////        fillInCalendar(getCurrentDate(), Data.AFFILIATE_EFFECTIVE_START_DATE);
////        Reports.log("Affiliate Effective start date: "+getCurrentDate());
//
//        ajaxClick(YES_RADIOBTN_FOR_PRIMARY_SERVICE_LOC);
//        Reports.log("Do you want to affiliate with Primary service location ? Yes");
//        fillInCalendar(getCurrentDate(), Data.AFFILIATE_LOCATION_EFFECCTIVE_START_DATE);
//        Reports.log("Affiliate Location Effective start date: "+getCurrentDate());
//        javaWaitSec(5);
////        ajaxClick(SELECT_PROGRAM_CHECKBOX);
////        Reports.log("Checked and selected a Program Participation");
////        javaWaitSec(1);
////        fillInCalendar(getCurrentDate(), Data.AFFILIATE_TAXONOMY_EFFECCTIVE_START_DATE);
////        Reports.log("Affiliate Taxonomy Effective start date: "+getCurrentDate());
////        driver.switchTo().activeElement().sendKeys(TAB);
////        javaWaitSec(3);
//
////        ajaxClick(MANNER_OF_SERVICES_DROPDOWN);
////        driver.findElement(MANNER_OF_SERVICES_DROPDOWN).click();
////        javaWaitSec(2);
////        selectAndClickOptionOfStatus(Data.IN_PERSON);
//       // selectFirstOptionInDropdown(MANNER_OF_SERVICES_DROPDOWN);
////        Reports.log("Selected Manner of Service "+Data.IN_PERSON);
////        javaWaitSec(2);
////        ajaxClick(YES_RADIOBTN_FOR_HOMELOCATION);
////        Reports.log("Are services provided only in a residential home, school, or daycare setting (i.e. no office location)?, Yes");
//
    ////        ajaxClick(YES_RADIOBTN_FOR_ACCEPTING_NEW_PATIENTS);
    ////        Reports.log("Accepting new Patients?, Yes");
//
//        ajaxClick(AFFILIATION_POPUP_ADD_BUTTON);
//        Reports.log("Click on the ADD button");
//        javaWaitSec(3);
//    }


    public void fillInAffiliationSection(String npi, String affiliationType) {
        javaWaitSec(2);
        Reports.log("\nFill in Affiliation Section");
        ajaxClick(SECTION_AFFILIATION);
        Reports.log("Clicked on Affiliation Section");


        ajaxClick(ADD_AFFILIATION_BTN);
        Reports.log("Clicked on ADD AFFILIATION button");
        javaWaitSec(2);


        driver.findElement(AFFILIATION_PROVIDER_NAME_INPUT).sendKeys("4000048");
        Reports.log("Entered NPI value "+"4000048");
        javaWaitSec(1);
        ajaxClick(AFFILIATION_SEARCH_BTN);
        Reports.log("Clicked on the search Button");
        javaWaitSec(1);


        // Check which button is present and handle accordingly
        try {
            javaWaitSec(5);
            WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AFFILIATION_ADD_BTN));
            ajaxClick(addBtn);
            Reports.log("Clicked on ADD button");


            // Only execute these steps if we clicked ADD button
            ajaxClick(YES_RADIOBTN_FOR_PRIMARY_SERVICE_LOC);
            Reports.log("Do you want to affiliate with Primary service location ? Yes");
            fillInCalendar(getCurrentDate(), Data.AFFILIATE_LOCATION_EFFECCTIVE_START_DATE);
            Reports.log("Affiliate Location Effective start date: "+getCurrentDate());
            javaWaitSec(5);


            ajaxClick(AFFILIATION_POPUP_ADD_BUTTON);
            Reports.log("Click on the ADD button");
            javaWaitSec(3);


        } catch (TimeoutException e) {
            // Only click NEXT button if ADD wasn't found
            WebElement nextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(NEXT_AFFILIATION_Button));
            ajaxClick(nextBtn);
            Reports.log("ADD button not found within timeout, clicked on NEXT button instead");


            // Don't execute the additional steps when NEXT was clicked
            // (Add any NEXT-specific steps here if needed)
        }
    }


    public void fillInAffiliationSectionForGroup(String affiliationType){
        javaWaitSec(2);
        Reports.log("\nFill in Affiliation Section");
        ajaxClick(SECTION_AFFILIATION);
        Reports.log("Clicked on Affiliation Section");


        ajaxClick(ADD_AFFILIATION_BTN);
        Reports.log("Clicked on ADD AFFILIATION button");
        javaWaitSec(2);


//        ajaxClick(SELECT_DO_U_WANT_TO_AFFILIATE_WITH_INDI);


        driver.findElement(AFFILIATION_PROVIDER_NAME_INPUT).sendKeys("1063479426");
        Reports.log("Entered NPI value "+"1063479426");
        javaWaitSec(1);


        ajaxClick(AFFILIATION_SEARCH_BTN);
        Reports.log("Clicked on the search Button");
        javaWaitSec(1);


        ajaxClick(AFFILIATION_ADD_BTN);
        Reports.log("Clicked on ADD button");
        javaWaitSec(2);


        //Affiliation Dialog pop-up
        performClick(AFFILIATION_TYPE_DROPDOWN);
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(AFFILIATION_TYPE_DROPDOWN_LIST, affiliationType)));
        Reports.log("Selected Affiliation Type: "+affiliationType);


//        fillInCalendar(getCurrentDate(), Data.AFFILIATE_EFFECTIVE_START_DATE);
//        Reports.log("Affiliate Effective start date: "+getCurrentDate());




        ajaxClick(YES_RADIOBTN_FOR_PRIMARY_SERVICE_LOC);
        Reports.log("Do you want to affiliate with Primary service location ? Yes");
        fillInCalendar(getCurrentDate(), Data.AFFILIATE_LOCATION_EFFECCTIVE_START_DATE);
        Reports.log("Affiliate Location Effective start date: "+getCurrentDate());
        javaWaitSec(5);
//        ajaxClick(SELECT_PROGRAM_CHECKBOX);
//        Reports.log("Checked and selected a Program Participation");
//        javaWaitSec(1);
//        fillInCalendar(getCurrentDate(), Data.AFFILIATE_TAXONOMY_EFFECCTIVE_START_DATE);
//        Reports.log("Affiliate Taxonomy Effective start date: "+getCurrentDate());
//        driver.switchTo().activeElement().sendKeys(TAB);
//        javaWaitSec(15);


//        ajaxClick(MANNER_OF_SERVICES_DROPDOWN);
//        driver.findElement(MANNER_OF_SERVICES_DROPDOWN).click();
//        javaWaitSec(2);
//        selectAndClickOptionOfStatus(Data.IN_PERSON);
        // selectFirstOptionInDropdown(MANNER_OF_SERVICES_DROPDOWN);
//        Reports.log("Selected Manner of Service "+Data.IN_PERSON);


//        ajaxClick(YES_RADIOBTN_FOR_HOMELOCATION);
//        Reports.log("Are services provided only in a residential home, school, or daycare setting (i.e. no office location)?, Yes");


//        ajaxClick(YES_RADIOBTN_FOR_ACCEPTING_NEW_PATIENTS);
//        Reports.log("Accepting new Patients?, Yes");


        ajaxClick(AFFILIATION_POPUP_ADD_BUTTON);
        Reports.log("Click on the ADD button");
        javaWaitSec(3);




    }


    public void fillInPCPAddendumSection(String firstName, String lastName){
        javaWaitSec(5);
        Reports.log("\nFill in PCP Addendum Section");
        try {
            ajaxClick(SECTION_PCP_ADDENDUM);
            ajaxScroll(spanContainsText("AGREE AND SIGN"));
            javaWaitSec(2);
            ajaxClick(spanContainsText("AGREE AND SIGN"));
            javaWaitSec(10);
            Reports.log("Click on Agree And Sign button");


            signInHelloSignProviderAgreementSection(firstName, lastName);
            javaWaitSec(30);
        }catch (Exception e){
            Reports.log("\n No PCP Addendum is Available");
        }
    }


    public void fillInProgramParticipationEntity(String enrollmentType) {
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        addProgramParticipation(Data.CHOICES_WAIVER, Data.LONG_TERM_SERVICES, ADD_PROGRAM_PARTICIPATION_LINK_BUTTON);
        addTaxonomy(Data.TAXONOMY_INTERMEDIATE_CARE);
        addLicense("ICR/MR", Data.SOUTH_DAKOTA, Data.LICENSE_NUMBER);
        ajaxClick(CONFIRM_BUTTON);
        Reports.log("Clicked on Confirm button");
        javaWaitSec(3);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
        Reports.log("Clicked on Save button");
        javaWaitSec(3);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        ajaxScroll(NO_OF_BEDS_SECTION);
        ajaxClick(NO_OF_BEDS);
        driver.findElement(NO_OF_BEDS).sendKeys("12");
        javaWaitSec(3);
        ajaxClick(BED_TYPE);
        clickAnyOptionInList(2);
        javaWaitSec(4);
        ajaxClick(PROGRAM_ADD_LINE_SAVE);
        javaWaitSec(2);
    }


    public void fillInKeyPersonalSection(int index, String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType) throws InterruptedException {
        javaWaitSec(5);
        Reports.log("\nFill in Key Personnel Section");
        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");


        ajaxClick(TEXT_FIELD_LICENSE_FIRST_NAME);
        ajaxScroll(TEXT_FIELD_LICENSE_FIRST_NAME);
        String licenseFirstName =generateFirstName() ;
        Reports.log("Type License First Name :"+licenseFirstName);
        driver.findElements(TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(licenseFirstName);


        String licenseLastName =generateLastName() ;
        Reports.log("Type License Last Name :"+licenseLastName);
        driver.findElements(TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(licenseLastName);
        javaWaitSec(5);
        ajaxScrollUp();
        ajaxScrollUp();
//        ajaxClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
        driver.findElement(By.xpath(".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div")).click();
        Reports.log("Select Managing Employee Type");
        javaWaitSec(2);
//        driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value ='Director']")).click();
        performClick(SELECT_TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);


        javaWaitSec(5);
        performClick(TEXT_FIELD_EMPLOYEE_STATUS);
        javaWaitSec(2);
        jsClick("//ul[@role='listbox']/li[text()='Managing Non Convicted']");
        javaWaitSec(5);


        driver.findElement(TEXT_FIELD_COUNTRY_OF_BIRTH).click();
        Reports.log("Select country of Birth :"+Data.countryOfBirth);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.countryOfBirth));


        driver.findElement(DROP_DOWN_STATE_OF_BIRTH2).click();
        Reports.log("Select State of Birth :"+Data.FLORIDA );
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.FLORIDA ));


//        ajaxClick(TEXT_FIELD_COUNTRY_OF_BIRTH);
//        performClick(setSpecificOptionInListbox("United States"));


        String DOB = createRandomDateInSpecificYears(-18, -60);
        fillInCalendar(DOB, Data.dateOfBirthCalendar2);
        Reports.log("Date of birth is: "+ DOB);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);


        fillInAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);


        String ssn = generateANumberOfLength(10);
        Reports.log("Type SSN :"+ssn);
        performClick(TEXT_FIELD_SSN_PHARMACY);
        driver.findElements(TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(ssn);
        driver.findElement(RACE).click();
        javaWaitSec(5);
        Reports.log("Selected race:" + Data.ASIAN);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.ASIAN));
        javaWaitSec(3);
        driver.findElement(GENDER).click();
        Reports.log("Select Gender :" + Data.genderMale);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.genderMale));


        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
    }
    public void fillInKeyPersonalSectionForIndividual(int index,String gender, String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType,String npi) throws InterruptedException {
        javaWaitSec(5);
        Reports.log("\nFill in Key Personnel Section");
        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        ajaxScrollUp();
        ajaxScrollUp();
        javaWaitSec(5);
        performClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
//        driver.findElement(By.xpath(".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div")).click();
        Reports.log("Select Managing Employee Type");
        javaWaitSec(5);
//        driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value ='Director']")).click();
        ajaxClick(SELECT_TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);


        javaWaitSec(5);
        performClick(TEXT_FIELD_EMPLOYEE_STATUS);
        javaWaitSec(5);
        jsClick("//ul[@role='listbox']/li[text()='Managing Non Convicted']");


//        setFieldValueWithTabAndWait(PROVIDER_ID,Data.PROVIDER_ID);
        javaWaitSec(5);
        setFieldValueWithWaits(NPI_IN_KEY_PERSONAL, npi);
//        fillNPIInKeyPersonal(npi);
        ajaxClick(TEXT_FIELD_LICENSE_FIRST_NAME);
        javaWaitSec(5);
        ajaxScroll(TEXT_FIELD_LICENSE_FIRST_NAME);
        String licenseFirstName =generateFirstName() ;
        Reports.log("Type License First Name :"+licenseFirstName);
        driver.findElements(TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(licenseFirstName);
        javaWaitSec(5);


        String licenseLastName =generateLastName() ;
        javaWaitSec(5);
        Reports.log("Type License Last Name :"+licenseLastName);
        driver.findElements(TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(licenseLastName);
        javaWaitSec(5);






        driver.findElement(TEXT_FIELD_COUNTRY_OF_BIRTH).click();
        javaWaitSec(5);
        Reports.log("Select country of Birth :"+Data.countryOfBirth);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.countryOfBirth));
        javaWaitSec(5);


        driver.findElement(DROP_DOWN_STATE_OF_BIRTH2).click();
        javaWaitSec(5);
        Reports.log("Select State of Birth :"+Data.SOUTH_DAKOTA);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.SOUTH_DAKOTA));
        javaWaitSec(5);


//        ajaxClick(TEXT_FIELD_COUNTRY_OF_BIRTH);
//        performClick(setSpecificOptionInListbox("United States"));




        driver.findElement(RACE).click();
        javaWaitSec(5);
        Reports.log("Selected race:"+Data.ASIAN);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.ASIAN));


        javaWaitSec(3);
        driver.findElement(GENDER).click();
        javaWaitSec(5);
        Reports.log("Select Gender :"+ Data.genderMale);
        ajaxClick(setSpecificStrongOptionInListboxSD( Data.genderMale));
        javaWaitSec(5);


        String DOB = createRandomDateInSpecificYears(-18, -60);
        fillInCalendar(DOB, Data.dateOfBirthCalendar2);
        javaWaitSec(5);
        Reports.log("Date of birth is: "+ DOB);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(5);


        fillInAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        javaWaitSec(5);
        String ssn = generateANumberOfLength(10);
        Reports.log("Type SSN :"+ssn);
        performClick(TEXT_FIELD_SSN_PHARMACY);
        driver.findElements(TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(ssn);
        javaWaitSec(5);
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
    }
    public void fillInExclusionAndSanctionSectionForTP(){
        javaWaitSec(2);
        Reports.log("\nFill in Exclusion and Sanction Section");
        ajaxClick(SECTION_PROVIDER_EXCLUSION);
        //driver.findElement(SECTION_PROVIDER_EXCLUSION).click();
        selectAllRadioBtnForExclusionForTP("No");


    }
    public void  selectAllRadioBtnForExclusionForTP(String radioButtonValue){
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FRAUD_THEFT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FINANCIAL_MISCONDUCT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_PERJURY, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_ABUSE_NEGLECT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_OBSTRUCTION_CRIMINIAL, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_UNLAWFUL_MANUFACTURE, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_HEALTHCARE_RELATED_CRIME, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_CONVICTED_FELONY, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FAILED_GRANT_ACCESS, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FAILED_DISCLOSURE_INFORMATION, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_REVOCATION_OR_SUSPENSION_OF_A_LICENSE, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_REVOCATION_OR_SUSPENSION, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_SUSPENSION_EXCLUSION_DEBARMENT, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_CURRENT_PAYMENT_SUSPENSION, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_JUDGEMENT_FALSE_CLAIMS_ACT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_CURRENT_OVERPAYMENT, radioButtonValue)));
        javaWaitSec(1);
    }
    /**
     * This method selects Either All YES or ALL NO radio buttons in the Exclusion section
     */
    public void selectAllRadioBtnForExclusion(String radioButtonValue) {
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FRAUD_THEFT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FINANCIAL_MISCONDUCT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_PERJURY, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_ABUSE_NEGLECT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_OBSTRUCTION_CRIMINIAL, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_UNLAWFUL_MANUFACTURE, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_HEALTHCARE_RELATED_CRIME, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_CONVICTED_FELONY, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FAILED_GRANT_ACCESS, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FAILED_DISCLOSURE_INFORMATION, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_DISCIPLINARY_ACTION, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_REVOCATION_SUSPENSION_ACCREDITATION, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_SANCTION_SUSPENDED_PAYMENTS_FROM_MEDICARE, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_SANCTION_DENIED_ENROLLMENT, radioButtonValue)));
        javaWaitSec(1);




        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_JUDGEMENT_FALSE_CLAIMS_ACT, radioButtonValue)));
        javaWaitSec(1);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_OWES_MONEY, radioButtonValue)));
        javaWaitSec(1);
        if (radioButtonValue.equalsIgnoreCase("true")) {
            Reports.log("Selects “Yes” for all the questions in Exclusion/Sanction information");
        } else {
            Reports.log("Selects “No” for all the questions in Exclusion/Sanction information");
        }
    }




    public void fillEFTInformationSectionFields(String enrollmentType) {
        Reports.log("Fill in Name of financial institution" + Data.FINANCIAL_INSTITUTION_NAME);
//        if(enrollmentType.equalsIgnoreCase(Data.entityApplication)){
//
//            doublePerformClick(EFT_FINANCIAL_INSTITUTION);
//            javaWaitSec(2);
//            driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(Data.FINANCIAL_INSTITUTION_NAME);
//            Reports.log("Fill in Routing Number: " + Data.ROUTING_NUMBER);
//            javaWaitSec(2);
//            doublePerformClick(EFT_ROUTING_NUMBER_FOR_ENTITY);
//            driver.findElement(EFT_ROUTING_NUMBER_FOR_ENTITY).sendKeys(Data.ROUTING_NUMBER);
//
//        }else{
        doublePerformClick(EFT_FINANCIAL_INSTITUTION);
        javaWaitSec(2);
        driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(Data.FINANCIAL_INSTITUTION_NAME);
        Reports.log("Fill in Routing Number: " + Data.ROUTING_NUMBER);
        javaWaitSec(2);
        doublePerformClick(EFT_ROUTING_NUMBER);
        driver.findElement(EFT_ROUTING_NUMBER).sendKeys(Data.ROUTING_NUMBER);
//        }




        Reports.log("Fill in Account Number: " + Data.ACCOUNT_NUMBER);
        javaWaitSec(2);
        doublePerformClick(EFT_ACCOUNT_NUMBER);
        driver.findElement(EFT_ACCOUNT_NUMBER).sendKeys(Data.ACCOUNT_NUMBER);
        javaWait(1);
        Reports.log("Select Account Type: " + Data.ACCOUNT_TYPE_CHECKING);
        driver.findElement(EFT_ACCOUNT_TYPE).click();
        javaWait(1);
        List<WebElement> elements = driver.findElements(EFT_ACCOUNT_TYPE_LIST);
        ajaxClick(elements.get(0));
        javaWait(1);
        fillInCalendar(getCurrentDate(), Data.START_DATE);
        driver.findElement(By.xpath("//label[text()='" + Data.START_DATE + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(TAB);
    }


    public void fillEFTInformationSectionFieldsForIndividual(String enrollmentType, String firstName){
        Reports.log("Fill in Name of financial institution" + Data.FINANCIAL_INSTITUTION_NAME);
        javaWaitSec(1);
        driver.findElement(By.xpath("//div[contains(@id,'Name of the Authorized Person')]")).click();
        javaWaitSec(2);
        driver.findElement(By.xpath("//li[@role='option']")).click();
        javaWaitSec(1);
        doublePerformClick(EFT_FINANCIAL_INSTITUTION);
        javaWaitSec(2);
        driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(Data.FINANCIAL_INSTITUTION_NAME);
        Reports.log("Fill in Routing Number: " + Data.ROUTING_NUMBER);
        javaWaitSec(2);
        doublePerformClick(EFT_ROUTING_NUMBER);
        driver.findElement(EFT_ROUTING_NUMBER).sendKeys(Data.ROUTING_NUMBER);
        javaWaitSec(5);
        driver.findElement(ACCOUNT_HOLDER_NAME).sendKeys(firstName);
        javaWaitSec(3);
        Reports.log("Fill in Account Number: " + Data.ACCOUNT_NUMBER);
        javaWaitSec(2);
        doublePerformClick(EFT_ACCOUNT_NUMBER);
        driver.findElement(EFT_ACCOUNT_NUMBER).sendKeys(Data.ACCOUNT_NUMBER);
        javaWait(1);
        Reports.log("Select Account Type: " + Data.ACCOUNT_TYPE_CHECKING);
        driver.findElement(EFT_ACCOUNT_TYPE).click();
        javaWait(5);
        driver.findElement(By.xpath("//li[text()='Savings']")).click();
        javaWait(1);
        fillInCalendar(getCurrentDate(), Data.START_DATE);
        javaWaitSec(10);
        robotUploadDocument(UPLOAD_BUTTON);
        javaWaitSec(2);
        setAndFindButton(Data.TEXT_SAVE).click();
    }
    public void selectOwnershipRadioButtons() {
//        ajaxClick(RADIOBUTTON_OWNERSHIP_OWNERSHIP_ORGANIZATION);
        ajaxClick(RADIOBUTTON_OWNERSHIP_OWNERSHIP_ENTITY);
        javaWaitSec(1);
        ajaxClick(RADIOBUTTON_OWNERSHIP_Managed_directed);
        javaWaitSec(1);
        ajaxClick(RADIOBUTTON_OWNERSHIP_INTEREST);
        javaWaitSec(1);
        ajaxClick(RADIOBUTTON_OWNERSHIP_IMMIDIATE_FAMILY);
        javaWaitSec(1);
//        ajaxClick(RADIOBUTTON_OWNERSHIP_RELATIONSHIP_AGREEMENT);
        javaWaitSec(1);
    }


    public void fillInOwnershipSecForBillingProvider() {
        ajaxClick(RADIOBUTTON_OWNERSHIP_OWNERSHIP_ENTITY);
        javaWaitSec(1);


        ajaxClick(RADIOBUTTON_OWNERSHIP_MANAGED_DIRECTED_BY_ENTITY);
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_PERSON_OR_ENTITY_HAVE_5_PERCENTAGE_INTEREST));
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_HAS_THE_ENROLLING_PROVIDER_CONTACTED_AS_ANY_MNGT_FUNCTION));
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DO_ANY_IMMEDIATE_FAMILY_MEMBER_HAVE_5PERCENTAGE_OWNERSHIP));
        javaWaitSec(1);


    }


    /**
     * This method fills authorized signature section using firstName
     *
     * @param firstName
     */
    public void fillAuthorizedSignaturSection(String firstName) {
        Reports.log("\nFill in Authorized Signature Section");
        ajaxScroll(SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        ajaxClick(SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        fillAuthorizedSignature(firstName, "Mr");
    }


    /**
     * This method fills authorized signature using firstName, title
     *
     * @param firstName
     * @param title
     */
    public void fillAuthorizedSignature(String firstName, String title) {
//        Reports.log("\nFill in Authorized signature Section");
        driver.findElement(TEXT_FIELD_NAME_OF_AUTHORIZED).sendKeys(firstName);
        Reports.log("Enter Title of Person: " + title);
        driver.findElement(TEXT_FIELD_TITLE_OF_PERSON).sendKeys(title);
        driver.findElement(TEXT_FIELD_TITLE_OF_PERSON).sendKeys(TAB);
        javaWaitSec(15);
    }


    /**
     * This method uploads document section using enrollmentType
     *
     * @param enrollmentType
     */
    public void uploadDocumentSection(String enrollmentType) {


        Reports.log("\nFill in Upload Document Section");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_UPLOAD_DOCUMENTS));
        //  driver.findElement(SECTION_UPLOAD_DOCUMENTS).click();
        ajaxClick(SECTION_UPLOAD_DOCUMENTS);
        driver.findElement(SECTION_UPLOAD_DOCUMENTS).click();
        if (enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            ajaxUploadForEnrollment("Current License");
            return;
        }


        if (enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER)) {
            ajaxUploadForEnrollment("Upload supporting documents if needed (Optional)");
            return;
        }


        ajaxUploadForEnrollment("Current license");


        if (enrollmentType.equalsIgnoreCase(Data.individualApplication) ||
                enrollmentType.equalsIgnoreCase(Data.groupApplication) ||
                enrollmentType.equalsIgnoreCase(Data.facilityApplication) ||
                enrollmentType.equalsIgnoreCase(Data.GROUP_COC_APPLICATION)) {
            ajaxUploadForEnrollment("Applicable board certification (Medicare/Board/Agency)");
        }
    }


    public void verifyUploadDocumentSection(String enrollmentType) {
        Reports.log("\nVerifying the Upload Document Section");


        ajaxClick(SECTION_PROVIDER_EXCLUSION);
        selectAllRadioBtnForExclusion("false");
        javaWaitSec(1);
        ajaxClick(setAndFindButton("Next"));


        wait.until(ExpectedConditions.elementToBeClickable(SECTION_UPLOAD_DOCUMENTS));
        ajaxClick(SECTION_UPLOAD_DOCUMENTS);
//        softAssert.assertTrue(verifyThatElementIsDisplayed(EXCLUSION_SANCTION_UPLOAD_DOC_LABEL, "label"));
//        softAssert.assertTrue(verifyThatElementIsDisplayed(EXCLUSION_SANCTION_UPLOAD_DOC_BTN, "Button"));
//        softAssert.assertFalse(verifyThatElementIsDisplayed(EXCLUSION_SANCTION_UPLOAD_DOC_ERROR_MSG, "Error message"));
//        javaWaitSec(2);




        ajaxClick(SECTION_PROVIDER_EXCLUSION);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EXCLUSION_FRAUD_THEFT, true)));
        javaWaitSec(1);


        ajaxClick(setAndFindButton("Next"));


        wait.until(ExpectedConditions.elementToBeClickable(SECTION_UPLOAD_DOCUMENTS));
        ajaxClick(SECTION_UPLOAD_DOCUMENTS);
        javaWaitSec(1);
        softAssert.assertTrue(verifyThatElementIsDisplayed(EXCLUSION_SANCTION_UPLOAD_DOC_LABEL, "Label"), "Exclusion/Sanction Documents Label is not displayed");
        softAssert.assertTrue(verifyThatElementIsDisplayed(EXCLUSION_SANCTION_UPLOAD_DOC_BTN, "Button"), "UPLOAD FILES Button is not displayed");
        softAssert.assertTrue(verifyThatElementIsDisplayed(EXCLUSION_SANCTION_UPLOAD_DOC_ERROR_MSG, "Error message"), "This field is required Error message is not displayed");


        softAssert.assertAll();


        uploadDocumentSectionSD(enrollmentType, "Yes");
    }


    public void uploadDocumentSectionSD(String enrollmentType, String isAnyOfExclusionRadioSelectedYes) {


        Reports.log("\nFill in Upload Document Section");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_UPLOAD_DOCUMENTS));
        //  driver.findElement(SECTION_UPLOAD_DOCUMENTS).click();
        ajaxClick(SECTION_UPLOAD_DOCUMENTS);
        if (isAnyOfExclusionRadioSelectedYes.equalsIgnoreCase("Yes")) {
            driver.findElement(SECTION_UPLOAD_DOCUMENTS).click();
            ajaxUploadForEnrollment("Exclusion/Sanction Documents");
        }
    }


    /**
     * This method signs in provider agreement Form using enrollmentType, firstName, lastName
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     */
    public void signInProviderAgreementForm(String enrollmentType, String firstName, String lastName) {
        Reports.log("\n Fill in Provider Agreement Section");
        ajaxClick(SECTION_PROVIDER_PROVIDER_AGREEMENT);
        javaWaitSec(10);
//        driver.findElement(SECTION_PROVIDER_PROVIDER_AGREEMENT).click();
        if (enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.individualApplication) || enrollmentType.equalsIgnoreCase(Data.pemApplication)) {
            closeProviderAgreementpopUp();
        }
        clickAndAgreeProviderAgreement();
        signInHelloSignProviderAgreementSection(firstName, lastName);
        javaWaitSec(30);
    }


    public void signInProviderAgreementFormSD(String enrollmentType, String firstName, String lastName) {
        Reports.log("\n Fill in Provider Agreement Section");
        //driver.findElement(SECTION_PROVIDER_PROVIDER_AGREEMENT).click();
        ajaxClick(SECTION_PROVIDER_PROVIDER_AGREEMENT);
        clickAndAgreeProviderAgreement();
        signInHelloSignProviderAgreementSection(firstName, lastName);
        javaWaitSec(45);
    }

    /**
     * This method closes provider agreement popUp
     */
    public void closeProviderAgreementpopUp() {
        try {
            driver.findElement(By.xpath("//div[@role='document']//span[text()='Close']")).click();
            ajaxClick(SECTION_PROVIDER_PROVIDER_AGREEMENT);
        } catch (Exception e) {

        }
    }


    /**
     * This method signs in Hello Sign provider agreement section using firstName, lastName
     *
     * @param firstName
     * @param lastName
     */
    public void signInHelloSignProviderAgreementSection(String firstName, String lastName) {
        Reports.log("Wait Hello Sign page");
        try {
            advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 35, 2);
            Reports.log("Switch to Hello Sign page");
            driver.switchTo().frame(Data.helloSignIframe);

            javaWaitSec(5);
            Reports.log("Close pop up");
            clickAnyButton(Data.TEXT_OK);

            Reports.log("Get started");
            ajaxClick(BUTTON_GET_STARTED);
            //ajaxClick(spanContainsText("Get Started"));
            javaWait(3000);

            Reports.log("Click Signature input");
            ajaxClick(By.xpath("//div[text()= 'Click to sign']"));


            Reports.log("Click option Type it in");
            ajaxClick(SECTION_TYPE_IN);


            ajaxClick(BUTTON_INSERT_HELLO_SIGN);
            Reports.log("Click Insert button");
            javaWaitSec(5);
            driver.findElement(AUTHORIZED_OFFICIAL_NAME).sendKeys(firstName+" "+lastName);
            javaWaitSec(3);


//06/21/2023            Reports.log("Click Signature area");
//06/21/2023           ajaxClick(SECTION_TYPE_SIGNATURE);
            // performClick(SECTION_TYPE_SIGNATURE);
//06/23/2023
            if(verifyThatElementIsDisplayed(TXT_BOX_TITLE)){
                driver.findElement(TXT_BOX_TITLE).sendKeys("Mr");
                Reports.log("Entered the Title: Mr");
            }


//0621/2023            Reports.log("Click Signature area");
// 0621/2023           ajaxClick(SECTION_TYPE_SIGNATURE);
            // performClick(SECTION_TYPE_SIGNATURE);
//0621/2023


            wait.until(ExpectedConditions.elementToBeClickable(BTN_CONTINUE));
            ajaxClick(BTN_CONTINUE);


            wait.until(ExpectedConditions.elementToBeClickable(BTN_AGREE));
            ajaxClick(BTN_AGREE);


            wait.until(ExpectedConditions.elementToBeClickable(BTN_NEXT));
            ajaxClick(BTN_NEXT);
//0621/2023
//            wait.until(ExpectedConditions.elementToBeClickable(SECTION_TYPE_SIGNATURE));
//            driver.findElement(SECTION_TYPE_SIGNATURE).sendKeys(lastName);
//            Reports.log("Type signature");


//            ajaxClick(BUTTON_INSERT_HELLO_SIGN);
//            Reports.log("Click Insert button");
//            javaWaitSec(5);


            //Added Title section for Provider Agreement
//            try {


//            boolean rv = driver.findElement(By.xpath(".//div[@ data-field='Title']//textarea[@placeholder='Title']")).isDisplayed();
//            if(rv){
//                driver.findElement(By.xpath(".//div[@ data-field='Title']//textarea[@placeholder='Title']")).sendKeys("Mr");
//            }


//            driver.findElement(By.xpath(".//div[@ data-field='Title']//textarea[@placeholder='Title']")).sendKeys("Mr");


//                //driver.findElement(By.xpath("//textarea[@placeholder= 'Full Name']")).sendKeys("Provider Enrollment Manager");
//                driver.findElement(By.xpath("//textarea[@placeholder= 'Title']")).sendKeys("Mr");
//                javaWaitSec(2);
//                Reports.log("Entered the Title: Mr");
//            } catch (NoSuchElementException e) {
//                Reports.log("No Title field available for this application");
//            }
//            clickAnyButton(Data.TEXT_CONTINUE);
            javaWaitSec(1);
//06/22/2023            clickAnyButton2(Data.TEXT_I_AGREE, 0);
        } catch (Exception e) {


        }
    }




    /**
     * This method verifies the summary section
     * Verify that the system is allowing the user to enter First name and last name in the summary section.
     * Verify that the system is showing the mentioned verbiage
     */
    public void verifyAndSubmitSummarySection(String firstName, String lastName) {


        Reports.log("\nVerify the Summary Section ");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_SUMMARY));
        scrollToBottomOfPage();


        ajaxScroll(SECTION_SUMMARY);
        ajaxClick(SECTION_SUMMARY);
        Reports.log("Clicked on the Summary Section");


        softAssert.assertTrue(verifyThatElementIsDisplayed(TEXT_LABEL_SUMMARY_HEADING, "Heading"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(TEXT_LABEL_SUMMARY_VERBIAGE, "Verbiage"));


        softAssert.assertTrue(verifyThatElementIsDisplayed(TEXT_FIELD_CONTACT_FIRST_NAME, "First Name Input field"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(TEXT_FIELD_CONTACT_LAST_NAME, "Last Name Input field"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(CHECKBOX_SIGN_AND_AGREE_SUMMARY, "Sign and Agree CheckBox"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(BUTTON_SUBMIT, "Button"));


        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_FIRST_NAME, firstName);
        driver.findElement(TEXT_FIELD_CONTACT_FIRST_NAME).getAttribute("value");
        String getFirstName = driver.findElement(TEXT_FIELD_CONTACT_FIRST_NAME).getAttribute("value");
        softAssert.assertTrue(lastName.equalsIgnoreCase(getFirstName), "Expected LastName is :" + lastName + " but Actual is :" + getFirstName);
        Reports.log("Typed Last Name: " + getFirstName);


        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_LAST_NAME, lastName);
        String getLastName = driver.findElement(TEXT_FIELD_CONTACT_LAST_NAME).getAttribute("value");
        softAssert.assertTrue(lastName.equalsIgnoreCase(getLastName), "Expected LastName is :" + lastName + " but Actual is :" + getLastName);
        Reports.log("Typed Last Name: " + getLastName);


        ajaxClick(CHECKBOX_SIGN_AND_AGREE_SUMMARY);
        Reports.log("Selected the Sign and agree to Terms and Conditions checkbox ");


        ajaxClick(BUTTON_SUBMIT);
        Reports.log("Click Submit button");


        javaWaitSec(3);
        softAssert.assertTrue(verifyThatElementIsDisplayed(BUTTON_PROCEED_TO_SIGN, "PROCEED TO SIGN Button"));
        ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
        javaWaitSec(8);


        for (int i = 0; i < 5; i++) {
            try {
                try {
                    if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
                        clickAnyButton(Data.TEXT_SIGN);
                        break;
                    }
                } catch (Exception e) {
                    Reports.log("Page loading too long time, So Refreshing the summary page again");
                    driver.navigate().refresh();
                    javaWaitSec(5);
                    ajaxClick(setAndFindButton("Back"));
                    javaWaitSec(5);
                    scrollToBottomOfPage();
                    ajaxScroll(SECTION_SUMMARY);
                    driver.findElement(SECTION_SUMMARY).click();
                    javaWaitSec(3);
                    softAssert.assertTrue(verifyThatElementIsDisplayed(BUTTON_PROCEED_TO_SIGN, "PROCEED TO SIGN Button"));


                    ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
                    javaWaitSec(5);
                }
            } catch (Exception e) {
                if (driver.findElement(LINK_DASHBOARD).isDisplayed()) {
                    ajaxClick(LINK_DASHBOARD);
                    javaWaitSec(3);
                    softAssert.assertTrue(verifyThatElementIsDisplayed(BUTTON_PROCEED_TO_SIGN, "PROCEED TO SIGN Button"));
                    ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
                    javaWaitSec(8);
                    break;
                }
            }
            Reports.log("Reloading the Summary page, attempt " + i);
        }
        softAssert.assertAll();
        javaWaitSec(10);
    }


//    /**
//     * This method summaries section proceed to sign in
//     */
//    public void summarySectionProceedToSignIn(String firstName, String lastName, String buttonText) {
//
//        Reports.log("\nFill in Summary Section ");
//        wait.until(ExpectedConditions.elementToBeClickable(SECTION_SUMMARY));
//        scrollToBottomOfPage();
//
//        ajaxScroll(SECTION_SUMMARY);
////        driver.findElement(SECTION_SUMMARY).click();
//        ajaxClick(SECTION_SUMMARY);
////        Reports.log("Clicked on the Summary Section");
//
//        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_FIRST_NAME, firstName);
//        Reports.log("Typed First Name: " + firstName);
//
//        setFieldValueWithTabAndWait(TEXT_FIELD_CONTACT_LAST_NAME, lastName);
//        Reports.log("Typed Last Name: " + lastName);
//
//        ajaxClick(CHECKBOX_SIGN_AND_AGREE_SUMMARY);
//        Reports.log("Selected the Sign and agree to Terms and Conditions checkbox ");
//
////        ajaxClick(BUTTON_SUBMIT);
////        Reports.log("Click Submit button");
//
//        javaWaitSec(3);
//        ajaxClick(setAndFindButton(buttonText));
//        Reports.log("Click Submit button");
//
//        javaWaitSec(8);
//
//        for (int i = 0; i < 5; i++) {
//            try {
//                try {
//                    if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
//                        clickAnyButton(Data.TEXT_SIGN);
//                        break;
//                    }
//                } catch (Exception e) {
//                    Reports.log("Page loading too long time, So Refreshing the summary page again");
//                    driver.navigate().refresh();
//                    javaWaitSec(5);
//                    ajaxClick(setAndFindButton("Back"));
//                    javaWaitSec(5);
//                    scrollToBottomOfPage();
//                    ajaxScroll(SECTION_SUMMARY);
//                    driver.findElement(SECTION_SUMMARY).click();
//                    javaWaitSec(3);
//                    ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
//                    javaWaitSec(5);
//                }
//            } catch (Exception e) {
//                if (driver.findElement(LINK_DASHBOARD).isDisplayed()) {
//                    ajaxClick(LINK_DASHBOARD);
//                    javaWaitSec(3);
//                    ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
//                    javaWaitSec(8);
//                    break;
//                }
//            }
//            Reports.log("Reloading the Summary page, attempt " + i);
//        }
//        javaWaitSec(10);
//    }




    /**
     * This method clicks and agree provider agreement
     */
    public void clickAndAgreeProviderAgreement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Provider Agreement']")));
        ajaxClick(By.xpath("//h3[text()='Provider Agreement']"));
        try {
            try {
                ajaxScroll(spanContainsText("AGREE AND SIGN"));
                javaWaitSec(10);
                ajaxClick(spanContainsText("AGREE AND SIGN"));
                javaWaitSec(5);
                driver.findElement(By.xpath("//span[text()='YES']")).click();
                javaWaitSec(10);
                Reports.log("Click on Agree And Sign button");




            } catch (Exception e) {
                javaWaitSec(5);
                ajaxClick(setAndFindButton("Next"));
                javaWaitSec(5);
                scrollToBottomOfPage();
            }
        } catch (Exception e) {


        }
    }


    /**
     * This method fills in payment section using enrollmentType, paymentOption
     *
     * @param enrollmentType
     * @param paymentOption
     */
    public void fillInPaymentSection(String enrollmentType, String paymentOption, String email, String zipCode, String PhoneNo) {


        Reports.log("\n Fill in  Payment Section");
        ajaxScroll(SECTION_PAYMENT);
        driver.findElement(SECTION_PAYMENT).isDisplayed();
        javaWaitSec(3);
        ajaxClick(SECTION_PAYMENT);
        //  driver.findElement(SECTION_PAYMENT).click();
        javaWaitSec(5);
        String enrollmentFee = driver.findElement(ENROLLMENT_FEE).getText();
        Reports.log("Required enrollment fee: " + enrollmentFee);


        if (enrollmentType.equalsIgnoreCase(Data.individualApplication) || enrollmentType.equalsIgnoreCase(Data.orpApplication) || enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            if (!enrollmentFee.contains("$0") || enrollmentFee.isEmpty()) {
                if (paymentOption.contains("Offline")) {
                    downloadInvoicePayment();
                }
            }
        }


        try {
            Reports.log("'Go To Payment' button is Enabled");
            ajaxClick(BUTTON_GO_TO_PAYMENT);
            fillingPaymentInfo("4111111111111111", "04/22", "111",
                    "John Doe", email, zipCode);
        } catch (Exception e) {
            Reports.log("Exception :" + e);
        }
        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            downloadInvoicePayment();


        }
    }




    public void verifyAndFillIdentifyingInformationSectionForTradingPartnerEnrmt(String LegalBusiness, String DBABusiness,
                                                                                 String FEIN, String Address, String City,
                                                                                 String State, String Zip, String County, String MailingState, String email) {
        driver.findElement(INPUT_FEILD_LEGAL_BUSINESS_NAME).sendKeys(TAB);
        driver.findElement(INPUT_FEILD_DBA).sendKeys(TAB);
        driver.findElement(INPUT_FEILD_FEIN_NUMBER).sendKeys(TAB);
        driver.findElement(ADDRESS_LINE1).sendKeys(TAB);
        driver.findElement(CITY).sendKeys(TAB);
        driver.findElement(STATE).sendKeys(TAB);
        driver.findElement(ZIP_CODE).sendKeys(TAB);
        driver.findElement(COUNTY).sendKeys(TAB);
        Reports.log("Verifying all fields with error message:" + Data.ERROR_FIELD_REQUIRED);
        int FieldsWithErrorMessage = checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        Reports.log("Number of fields With Error Message: " + FieldsWithErrorMessage);
        int NoMandatoryFields = checkAllTheFieldsWithSpecificData(By.xpath("//span[contains(text(),'*')]"), "*");
        Reports.log("Number of fields that are mandatory: " + NoMandatoryFields);
        //Will remove +1 after defect PECS-1492 fix
        softAssert.assertTrue(FieldsWithErrorMessage + 1 == NoMandatoryFields);
        fillInProviderIdentifyingInformationTP(LegalBusiness, DBABusiness, FEIN, Address, City, State, Zip, County, MailingState, email );
    }


    /**
     * This method Verify and fills in the Identifying Information section
     * 1.Verify that the system is showing the sub sections in the Identifying information section.
     * 2.Verify that the fields are working according to the display conditions.
     * 3.Verify that the system is showing the validation messages.
     *
     * @param LegalBusiness
     * @param DBABusiness
     * @param FEIN
     * @param email
     */
    public void verifyAndFillIdentifyingInformationSectionForEntityEnrolment(String LegalBusiness, String DBABusiness,
                                                                             String FEIN, String email, String Date) {
        VerifyRequestEnrollmentDate();
        javaWaitSec(2);
        fillInCalendar(Helper.getCurrentDatestamp(), Data.requestedEnrollmentDate);  //  Just a workaround, To show up the errors needed to remove this line later
        driver.findElement(COMBOBOX_REASON_CODE).sendKeys(Keys.TAB);
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        javaWaitSec(2);
        ajaxClick(SECTION_IDENTIFYING_INFORMATION);


        Reports.log("Verifying all fields with error message:" + Data.ERROR_FIELD_REQUIRED);
        int FieldsWithErrorMessage = checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        Reports.log("Number of fields With Error Message: " + FieldsWithErrorMessage);
        int NoMandatoryFields = checkAllTheFieldsWithSpecificData(MANDATORY_FIELD, "*");
        Reports.log("Number of fields that are mandatory: " + NoMandatoryFields);


        Assert.assertTrue(FieldsWithErrorMessage == NoMandatoryFields);
        softAssert.assertAll();
        fillInIdentifyingInfoForEntity(LegalBusiness, DBABusiness, FEIN, email, Date);
    }


    /**
     * This method Verify and fills in the Request Enrollment Date sub-section under Identifying Information section
     * 1. Verifies if “Select Requested enrollment date” is displayed along with the date picker.
     * 2. Verifies the dropdown list of the Reason Codes
     * 3. Verify that the system is showing the validation messages.
     */
    public void VerifyRequestEnrollmentDate() {
        Reports.log("Verifying the fields on Request Enrollment Date Section");
        softAssert.assertTrue(verifyThatElementIsDisplayed(REQUESTED_ENROLMENT_LABEL, "Feild"), "Request Enrollment Date feild is not displayed");
        softAssert.assertTrue(verifyThatElementIsDisplayed(REQUESTED_ENROLMENT_DATE_FEILD, "Date Picker"), "Request Enrollment Date Picker is not displayed");
        driver.findElement(REQUESTED_ENROLMENT_DATE_FEILD).sendKeys(TAB);


        softAssert.assertTrue(verifyThatElementIsDisplayed(REQUESTED_ENROLMENT_ERROR_MESSAGE, "Error Message"), "Request Enrollment Date");
        softAssert.assertTrue(verifyThatElementIsDisplayed(COMBOBOX_REASON_CODE, "ComboBox"), "Request Enrollment,Date should not be less than or more than 100 years error message is not displayed");


        ArrayList<String> reasonCodes = new ArrayList<>(Arrays.asList("Retroactive - Claims Support", "Retroactive - DSS Administrative", "Future Eligibility", "Currently Eligible"));
        ajaxFocus(COMBOBOX_REASON_CODE);
        verifyListValue(REASON_CODE_LIST, reasonCodes, "Reason Codes");
    }




    public void verifyAndFillClassificationSectionTradingPartnerEnrollment() {
        javaWaitSec(2);
        Reports.log("\n Verifying and Fill in Classification Section");
        ajaxClick(CLASSIFICATION_SECTION);
        int FieldsInClassificationSection = checkAllTheFieldsWithSpecificData(CLASSIFICATION_RADIO_BUTTONS, "Self Submitter");


        softAssert.assertTrue(FieldsInClassificationSection == 4);
        doublePerformClick(driver.findElement(CLASSIFICATION_SEC_ENTITY_CODE_LABEL));
        ArrayList<String> EntityDropDownList = new ArrayList<>(Arrays.asList("Kermit", "TCP/IP", "MQseries", "WEB", "SNA", "YMODEM", "Cartridge", "ZMODEM", "XMODEM"));
        verifyListValue(ENTITY_CODE_DROPDOWN, EntityDropDownList, "Entity code");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        ajaxClick(CLASSIFICATION_SECTION);
        int MandatoryFieldsInClassificationSection = checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        Reports.log("Number of fields that are mandatory in Classification section: " + MandatoryFieldsInClassificationSection);
        ajaxClick(CLASSIFICATION_CLEARINGHOUSE);
        ajaxClick(setAndFindButton("Next"));
    }


    public static final String RADIOBUTTON_CLASSIFICATION_TYPE = "//input[@value='%s']";


    public void fillInClassificationSection(String classificationType) {
        javaWaitSec(2);
        Reports.log("\nFill in Classification Section");
        ajaxClick(CLASSIFICATION_SECTION);


        ajaxClick(By.xpath(String.format(RADIOBUTTON_CLASSIFICATION_TYPE, classificationType)));
        javaWaitSec(1);
        Reports.log("Selected The Classification Type:" + classificationType);
        ajaxClick(setAndFindButton("Next"));
    }




    /**
     * This method fills payment info section
     *
     * @param cardNumber
     * @param expirationDate
     * @param cvc
     * @param name
     * @param billingEmail
     * @param billingZip
     */
    public void fillingPaymentInfo(
            String cardNumber, String expirationDate, String cvc,
            String name, String billingEmail, String billingZip) {
        Reports.log("\nOpen  Payment info page");


        driver.getWindowHandle();
        javaWaitSec(5);
        Reports.log("Fill in Card Details as below");
        setFieldValueWithTabAndWait(TEXT_FIELD_BILLING_EMAIL, billingEmail);
        Reports.log("Type email: " + billingEmail);


        ajaxClick(TEXT_FIELD_CARD_NUMBER);
        setFieldValueWithTabAndWait(TEXT_FIELD_CARD_NUMBER, cardNumber);
        Reports.log("Type card number: " + cardNumber);


        setFieldValueWithTabAndWait(TEXT_FIELD_EXPIRATION_DATE, expirationDate);
        Reports.log("Type expiration date: " + expirationDate);


        setFieldValueWithTabAndWait(TEXT_FIELD_CVC, cvc);
        Reports.log("Type CVV: " + cvc);


        setFieldValueWithTabAndWait(TEXT_FIELD_FULL_NAME_ON_CARD, name);
        Reports.log("Type name on card: " + name);


        setFieldValueWithTabAndWait(TEXT_FIELD_BILLING_ZIP, billingZip);
        Reports.log("Type zip on card: " + billingZip);


        ajaxClick(BUTTON_SUBMIT_CREDIT_CARD);
        Reports.log("Click Submit button");
    }




    /**
     * This method downloads invoice payment
     */
    public void downloadInvoicePayment() {
        try {
            setAndFindButton(Data.TEXT_DOWNLOAD_INVOICE_PAYMENT).click();
            Reports.log("Invoice Downloaded");
            javaWaitSec(8);
        } catch (Exception e) {
        }
    }




    /**
     * This method summaries section proceed to sign in
     */
    public void summarySectionProceedToSignIn(String firstName, String lastName) {


        Reports.log("\nFill in Summary Section ");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_SUMMARYY));
        scrollToBottomOfPage();
        ajaxScroll(SECTION_SUMMARYY);
//        driver.findElement(SECTION_SUMMARY).click();
        ajaxClick(SECTION_SUMMARYY);
//        Reports.log("Clicked on the Summary Section");


//        driver.findElement(FIRST_NAME_SUMMARY).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), firstName);
//        driver.findElement(FIRST_NAME_SUMMARY).clear();
        ajaxClear(FIRST_NAME_SUMMARY);
        setFieldValueWithTabAndWait(FIRST_NAME_SUMMARY, firstName);
        Reports.log("Type first name: " + firstName);
        try {
            ajaxClear(TEXT_FIELD_LAST_NAME_PROVIDER);
            setFieldValueWithTabAndWait(TEXT_FIELD_LAST_NAME_PROVIDER, lastName);
            Reports.log("Type in last name: " + lastName);
//        driver.findElement(TEXT_FIELD_PROVIDER_NAME).sendKeys(firstName+ " " +lastName);
//        Reports.log("Provider name: " + firstName + " " + lastName) ;
        }
        catch (Exception e){
            Reports.log("Last name field is not there");
        }
        if (!driver.findElement(SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX).isSelected()) {
            ajaxClick(SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX);
            Reports.log("Checked, Sign and agree to Terms and Conditions checkbox");
        }


        javaWaitSec(5);
        ajaxClick(setAndFindButton(Data.TEXT_SUBMIT));
        Reports.log("Clicked on Submit button");
        javaWaitSec(10);
        ajaxClick(LINK_DASHBOARD);
        javaWaitSec(10);
        for (int i = 0; i < 5; i++) {
            try {
                try {
                    if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_PROCEED_TO_SIGN + "']")).isDisplayed()) {
                        clickAnyButton(Data.TEXT_PROCEED_TO_SIGN);
                        break;
                    }
                } catch (Exception e) {
                    if (driver.findElement(LINK_DASHBOARD).isDisplayed()) {
                        ajaxClick(LINK_DASHBOARD);
                        javaWaitSec(10);
                        ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
                        javaWaitSec(8);
                        break;
                    }
                }
            } catch (Exception e1) {
                Reports.log("Page loading too long time, So Refreshing the summary page again");
                driver.navigate().refresh();
                javaWaitSec(5);
                ajaxClick(setAndFindButton("Back"));
                javaWaitSec(5);
                scrollToBottomOfPage();
                ajaxScroll(SECTION_SUMMARY);
                driver.findElement(SECTION_SUMMARY).click();
                javaWaitSec(3);
                ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
                javaWaitSec(5);
            }
            Reports.log("Reloading the Summary page, attempt " + i);
        }
        javaWaitSec(5);
    }




    public void summarySection(String firstName, String lastName) {


        Reports.log("\nFill in Summary Section ");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_SUMMARY));
        scrollToBottomOfPage();


        ajaxScroll(SECTION_SUMMARY);
//        driver.findElement(SECTION_SUMMARY).click();
        ajaxClick(SECTION_SUMMARY);
//        Reports.log("Clicked on the Summary Section");


        ajaxClear(FIRST_NAME_SUMMARY);
        setFieldValueWithTabAndWait(FIRST_NAME_SUMMARY, firstName);
        Reports.log("Type first name: " + firstName);
        try {
            ajaxClear(TEXT_FIELD_LAST_NAME_PROVIDER);
            setFieldValueWithTabAndWait(TEXT_FIELD_LAST_NAME_PROVIDER, lastName);
            Reports.log("Type in last name: " + lastName);
            driver.findElement(TEXT_FIELD_PROVIDER_NAME).sendKeys(firstName+ " " +lastName);
            Reports.log("Provider name: " + firstName + " " + lastName) ;
        }
        catch (Exception e){


        }
        if (!driver.findElement(SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX).isSelected()) {
            javaWaitSec(5);
            ajaxClick(SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX);
//            performClick(SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX);
            Reports.log("Checked, Sign and agree to Terms and Conditions checkbox");
        }


        javaWaitSec(5);
        ajaxClick(setAndFindButton(Data.TEXT_SUBMIT));
        Reports.log("Clicked on Submit button");
        javaWaitSec(15);
//        ajaxClick(LINK_DASHBOARD);
        driver.findElement(LINK_DASHBOARD).click();
        Reports.log("Clicked on navigate to dashboard button");
        javaWaitSec(10);


    }






    /**
     * This method summaries section proceed to sign in
     */
    public void summarySectionProceedToSignIn() {


        Reports.log("\nFill in Summary Section ");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_SUMMARY));
        scrollToBottomOfPage();


        ajaxScroll(SECTION_SUMMARY);
//        driver.findElement(SECTION_SUMMARY).click();
        ajaxClick(SECTION_SUMMARY);
//        Reports.log("Clicked on the Summary Section");
        javaWaitSec(5);
        ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
        javaWaitSec(10);


        for (int i = 0; i < 5; i++) {
            try {
                try {
                    if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
                        clickAnyButton(Data.TEXT_SIGN);
                        break;
                    }
                } catch (Exception e) {
                    Reports.log("Page loading too long time, So Refreshing the summary page again");
                    driver.navigate().refresh();
                    javaWaitSec(5);
                    ajaxClick(setAndFindButton("Back"));
                    javaWaitSec(5);
                    scrollToBottomOfPage();
                    ajaxScroll(SECTION_SUMMARY);
                    driver.findElement(SECTION_SUMMARY).click();
                    javaWaitSec(3);
                    ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
                    javaWaitSec(5);
                }
            } catch (Exception e) {
                if (driver.findElement(LINK_DASHBOARD).isDisplayed()) {
                    ajaxClick(LINK_DASHBOARD);
                    javaWaitSec(3);
                    ajaxClick(setAndFindButton(Data.TEXT_SIGN));
                    javaWaitSec(8);
                    break;
                }
            }
            Reports.log("Reloading the Summary page, attempt " + i);
        }
        javaWaitSec(10);
    }


    public void verifySearchResult() {
        checkSearchResult("Status", "Approved", searchResultText, tableInfo);
    }


    public void verifyIdentifyingInformationSectionTradingPartnerEnrollment() {
        driver.findElement(INPUT_FEILD_LEGAL_BUSINESS_NAME).sendKeys(TAB);
        driver.findElement(INPUT_FEILD_DBA).sendKeys(TAB);
        driver.findElement(INPUT_FEILD_FEIN_NUMBER).sendKeys(TAB);
        driver.findElement(ADDRESS_LINE1).sendKeys(TAB);
        driver.findElement(CITY).sendKeys(TAB);
        driver.findElement(STATE).sendKeys(TAB);
        driver.findElement(ZIP_CODE).sendKeys(TAB);
        driver.findElement(COUNTY).sendKeys(TAB);
        Reports.log("Verifying all fields with error message:" + Data.ERROR_FIELD_REQUIRED);
        int FieldsWithErrorMessage = checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        Reports.log("Number of fields With Error Message: " + FieldsWithErrorMessage);
        int NoMandatoryFields = checkAllTheFieldsWithSpecificData(By.xpath("//span[contains(text(),'*')]"), "*");
        Reports.log("Number of fields that are mandatory: " + NoMandatoryFields);
        //Will remove +1 after defect PECS-1492 fix
        softAssert.assertTrue(FieldsWithErrorMessage + 1 == NoMandatoryFields);


    }


    public void verifyClassificationSectionTradingPartnerEnrollment() {
        javaWaitSec(2);
        Reports.log("\nFill in Classification Section");
        ajaxClick(CLASSIFICATION_SECTION);
        int FieldsInClassificationSection = checkAllTheFieldsWithSpecificData(CLASSIFICATION_RADIO_BUTTONS, "Self Submitter");


        softAssert.assertTrue(FieldsInClassificationSection == 4);
        doublePerformClick(driver.findElement(By.xpath("//label[text()='Entity Code']")));
        ArrayList<String> EntityDropDownList = new ArrayList<>(Arrays.asList("Kermit", "TCP/IP", "MQseries", "WEB", "SNA", "YMODEM", "Cartridge", "ZMODEM", "XMODEM"));
        verifyListValue(ENTITY_CODE_DROPDOWN, EntityDropDownList, "Entity code");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        ajaxClick(CLASSIFICATION_SECTION);
        int MandatoryFieldsInClassificationSection = checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        Reports.log("Number of fields that are mandatory in Classification section: " + MandatoryFieldsInClassificationSection);
        ajaxClick(CLASSIFICATION_CLEARINGHOUSE);
        ajaxClick(setAndFindButton("Next"));
    }


    public void verifyAndFillProviderIdentifierSectionTradingPartnerEnrmt(String npi) {
        javaWaitSec(2);
        Reports.log("\nFill in Provider Identifier Section");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        driver.findElement(TEXT_FIELD_NEW_NPI).sendKeys(TAB);
        checkAllTheFieldsWithSpecificData(NPI_NUMBER_Error_MASSAGE, Data.ERROR_MASSAGE_NPI);
        checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);
        Reports.log("Do you have an NPI?: No ");
        ajaxClick(driver.findElement(NPI_RADIO_BUTTON_NO));
        Assert.assertFalse(verifyThatElementIsDisplayed(TEXT_FIELD_NEW_NPI));
        Reports.log("NPI Number field does not display");
        ajaxClick(driver.findElement(NPI_RADIO_BUTTON_YES));
        fillInProviderIdentifierTP(npi);
    }


    /**
     * This method Verifies and fills in provider identifiers section
     * Verify that the system is showing the sub sections in the Provider Identifiers section.
     * Verify that the fields are working according to the display conditions.
     * Verify that the system is showing the validation messages.
     * Verify that the system is showing the mentioned dropdown values in respective fields.
     *
     * @param npi
     */
    public void verifyAndFillProviderIdentifierSectionEntityEnrmt(String npi) {
        javaWaitSec(2);
        Reports.log("\nVerifying Provider Identifier Section");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        checkAllTheFieldsWithSpecificData(By.xpath("//div/following::li[text()='" + Data.ERROR_FIELD_REQUIRED + "']"), Data.ERROR_FIELD_REQUIRED);


        //Provider Identifiers
        verifyThatElementIsDisplayed(SECTION_PROVIDER_IDENTIFIERS_LABEL, "Section");
        softAssert.assertTrue(verifyThatElementIsDisplayed(NPI_TEXT_LABEL, "Question"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(NPI_RADIO_BTNS, "Radio Buttons"));
        verifyNPIRadioBtnForEntityEnrollment();


        javaWait(2);
        fillInProviderIdentifiersSectionWithDifferentNpi(npi, Data.ENTITY_PROVIDER);
        typeAndSelectNpiTextField(npi);
        ajaxScroll(setAndFindButton("Next"));
        javaWaitSec(1);


        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_IN_MEDICARE_QUESTION, "Question"));
        softAssert.assertTrue(verifyThatElementIsDisplayed(PARTICIPANT_IN_MEDICARE_QUESTION_RADIO_BTNS, "Radio Buttons"));
        verifyMedicareParticipant();
        clickMedicareRadiobuttonByValue("No");


        //Other Medicaid State
        verifyThatElementIsDisplayed(SUB_SECTION_OTHER_MEDICAID_STATE_LABEL, "Sub Section");
        verifyMedicaidState();
        javaWaitSec(3);


        //Additional Information
        softAssert.assertTrue(verifyThatElementIsDisplayed(SECTION_ADDITIONAL_INFO_LABEL), "Sub Section");
        softAssert.assertTrue(verifyThatElementIsDisplayed(TEACHING_FACILITY_QUESTION), "Question");
        softAssert.assertTrue(verifyThatElementIsDisplayed(TEACHING_FACILITY_QUESTION_RADIO_BTN), "Radio Buttons");
        ajaxClick(By.xpath(String.format(RADIOBUTTON_ARE_YOU_TEACHING_FACILITY, "false")));


        ArrayList<String> claimSubmissionOptionList = new ArrayList<>(Arrays.asList("Paper", "Electronic", "Electronic Data Interchange EDI"));
        ajaxFocus(LABEL_CLAIM_SUBMISSION_METHOD);
        verifyListValue(CLAIM_SUBMISSION_COMBOBOX_LIST, claimSubmissionOptionList, "Claim submission(s) List");
        softAssert.assertTrue(verifyThatElementIsDisplayed(COMBOBOX_CLAIM_SUBMISSION_METHOD, "Combo Box"));
        clickAndTypeAndSelectOptionInCombobox("What claim submission(s) do you use?", "P", 0);


        softAssert.assertTrue(verifyThatElementIsDisplayed(INDIAN_HEALTH_SERVICES_QUESTION, "Question"), "Are you in Indian Health Services (IHS) / 638 Tribal Provider? Question missing");
        softAssert.assertTrue(verifyThatElementIsDisplayed(INDIAN_HEALTH_SERVICES_RADIO_BTN, "Radio Buttons"), "Are you in Indian Health Services (IHS) / 638 Tribal Provider? Radio buttons missing");
        softAssert.assertAll();
    }


    /**
     * This method fills in provider identifiers section for Entity Enrollment
     *
     * @param npi
     */
    public void fillProviderIdentifierSectionEntityEnrmt(String npi) {
        javaWaitSec(2);
        Reports.log("\nVerifying Provider Identifier Section");
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);


        //Provider Identifiers
        typeAndSelectNpiTextField(npi);
        ajaxScroll(setAndFindButton("Next"));
        javaWaitSec(1);
//        fillInNPITable(npi);


        clickMedicareRadiobuttonByValue("No");
        clickCrossoverRadioButtonByValue("No");




        //Additional Information
        driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).click();
        WebElement claimSubmission = driver.findElement(COMBOBOX_CLAIM_SUBMISSION_METHOD).findElement((DROP_DOWN_CLAIM_SUBMISSION_METHOD_FOR_GRP));
        claimSubmission.click();
        Reports.log("What claim Submission(s) do you use?: " + claimSubmission.getText());
        ajaxClick(setAndFindButton("Next"));
    }


    public void verifyOwnershipSectionTradingPartnerEnrmt() {
        javaWaitSec(2);
        Reports.log("\nFill in Ownership Section");
        ajaxClick(SECTION_PROVIDER_OWNERSHIP);
        ArrayList<String> sectionAQuestions = new ArrayList<>(Arrays.asList("Have you ever had ownership in any entity that has billed or is currently billing Medicare, any State Medicaid Agency, or another public health program in any state? *", "Have you ever managed, directed, or controlled any entity that has billed or is currently billing Medicare, any State Medicaid Agency, or another public health program in any state?"));
//        verifyListValue(OWNERSHIP_QUESTIONS, sectionAQuestions, "Ownership Questions");


//        int NoOfQuestions = checkAllTheFieldsWithSpecificData(MANDATORY_FIELD, "*");
//        Reports.log("Number of Questions in ownership section that are mandatory: " + NoOfQuestions);


        ajaxClick(By.xpath(SECTION_OWNERSHIP_RADIO1));
//        WebElement addline = driver.findElement(By.xpath("//span[text()='+ Add Line']"));
//        Assert.assertTrue(addline.isDisplayed(), "Add line button is not displayed");
//        Reports.log("Verification of entering the information if the user selects yes to the question is completed");
//        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
//        Reports.log("Click on +Add line Button");
//        ajaxClick(OWNERSHIP_SELECT_PROGRAM);
//        ArrayList<String> DropDownList = new ArrayList<>(Arrays.asList("Select\n" +
//                "Medicaid\n" +
//                "Medicare"));
//        verifyListValue(DROPDOWN, DropDownList, "Select program drop down");
//        doublePerformClick(INPUT_FEILD_LEGAL_BUSINESS_NAME);
//        javaWaitSec(1);
//        setAndFindButton(Data.TEXT_SAVE).click();
//        ArrayList<String> validationErrors = new ArrayList<>(Arrays.asList("Organization Legal Business Name field is required", "Doing Business as (DBA) field is required", "Effective Date field is required", "FEIN field is required", "Select Program field is required", "NPI field is required", "Address line1 field is required", "address-line1 field is Required", "City field is required", "State field is required", "Zip field is required", "County field is required"));
//        verifyListValue(VALIDATION_ERRORS, validationErrors, "Validation Errors");
//        ajaxClick(SECTION_OTHER_MEDICAID_ERROR_POP_CLOSE_BTN);


        javaWaitSec(2);
        ajaxClick(By.xpath(SECTION_OWNERSHIP_RADIO2));


//        ajaxClick(By.xpath(String.format(SECTION_OWNERSHIP_RADIO2, true)));
//        softAssert.assertTrue(addline.isDisplayed(), "Add line button is not displayed");
//        Reports.log("Verification of entering the information if the user selects yes to the question is completed");
    }




    public void fillInOwnershipSectionEntityEnrollment() {
        javaWaitSec(10);
        Reports.log("\nFill in Ownership Section");
        ajaxClick(SECTION_PROVIDER_OWNERSHIP);

        javaWaitSec(10);
//        selectFirstOptionInDropdown(INPUT_SELECT_OWNERSHIP_SECTION);
//        Reports.log("Selected a ownership section");
         driver.findElement(INPUT_SELECT_OWNERSHIP_SECTION).click();
         clickFirstOptionInList();



        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_PERSON_HAVE_5_PERCENTAGE_OWNERSHIP));
        javaWaitSec(1);
        ajaxClick(NO_RADIOBUTTON_OWNERSHIP_ARE_THERE_ANY_OWNERS_WITHLESSTHAN_5);
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_ENTITY_HAVE_5_PERCENTAGE_OWNERSHIP));
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DOES_ANY_PERSON_OR_ENTITY_HAVE_5_PERCENTAGE_INTEREST));
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DOES_THE_ENROLLING_PROVIDER));
        javaWaitSec(1);




        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_HAS_THE_ENROLLING_PROVIDER_CONTACTED_AS_ANY_MNGT_FUNCTION));
        javaWaitSec(1);


        ajaxClick((NO_RADIOBUTTON_OWNERSHIP_DO_ANY_IMMEDIATE_FAMILY_MEMBER_HAVE_5PERCENTAGE_OWNERSHIP));
        javaWaitSec(1);


    }


    public void verifyAndFillKeyPerssonelSectionTradingPartnerEnrmt(int index, String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType) throws InterruptedException {
        javaWaitSec(5);
        Reports.log("\nFill in Key Personnel Section");
        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");


        ajaxClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
        Reports.log("Select Managing Employee Type");
        ArrayList<String> DropDownList = new ArrayList<>(Arrays.asList("Select\n" +
                "Director\n" +
                "Supervisor\n" +
                "Manager\n" +
                "Officer\n" +
                "Agent\n" +
                "Administrator\n" +
                "Board Member"));
        verifyListValue(DROPDOWN, DropDownList, "Managing Employee Type");


        doublePerformClick(TEXT_FIELD_EMPLOYEE_STATUS);
        ajaxClick(TEXT_FIELD_EMPLOYEE_STATUS);
        ArrayList<String> EmployeeDropDownList = new ArrayList<>(Arrays.asList("Select", "Managing Non Convicted", "Managing Convicted", "Convicted Non-Managing"));
        verifyListValue(DROPDOWN2, EmployeeDropDownList, "Employee Status");
        javaWaitSec(2);
        doublePerformClick(TEXT_FIELD_COUNTRY_OF_BIRTH);
        ajaxClick(TEXT_FIELD_COUNTRY_OF_BIRTH);
        int ListOfCountries = checkAllTheFieldsWithSpecificData(DROPDOWN3, "United States");
        Reports.log("Number of countries in dropDown: " + ListOfCountries);
        javaWaitSec(1);
        doublePerformClick(TEXT_FIELD_LAST_NAME_PROVIDER);
        javaWaitSec(1);
        ajaxClick(TEXT_FIELD_LAST_NAME_PROVIDER);
        javaWaitSec(1);
        doublePerformClick(CALENDAR_DOB);
        javaWaitSec(1);
        String date = changeYearAndDayInCurrentDate(-100, 0, -1);
        Reports.log("Enter Date Of Birth: " + date);
        driver.findElement(CALENDAR_DOB).sendKeys(date);
        driver.findElement(CALENDAR_DOB).sendKeys(TAB);
        Reports.log("Enter Effective Start Date: " + date);
        driver.findElement(CALANDER_EFFECTIVE_START_DATE).sendKeys(date);
        driver.findElement(CALANDER_EFFECTIVE_START_DATE).sendKeys(TAB);
        int invalidDates = checkAllTheFieldsWithSpecificData(By.xpath("//span[contains(text(),'Date')]"), Data.ERROR_DATES);
        Reports.log("Number of invalid Dates : " + invalidDates);
        ajaxClick(TEXT_FIELD_STATE_OF_BIRTH);
        int ListOfStates = checkAllTheFieldsWithSpecificData(DROPDOWN4, "Alabama");
        Reports.log("Number of States in dropDown: " + ListOfStates);
        javaWaitSec(1);
        doublePerformClick(TEXT_FIELD_LAST_NAME_PROVIDER);
        javaWaitSec(1);
        driver.findElement(CALENDAR_DOB).clear();
        driver.findElement(CALENDAR_DOB).sendKeys(TAB);
        Reports.log("Clear Date Of Birth");
        driver.findElement(CALANDER_EFFECTIVE_START_DATE).clear();
        driver.findElement(CALANDER_EFFECTIVE_START_DATE).sendKeys(TAB);
        Reports.log("Clear Effective Start Date");
        setAndFindButton(Data.TEXT_SAVE).click();
        ArrayList<String> validationErrors = new ArrayList<>(Arrays.asList("Managing Employee Type field is required", "Employee Status field is required", "First Name field is required", "Last Name field is required", "SSN field is required", "Date of Birth field is required", "State of Birth field is required", "Effective Start Date field is required", "Address Line 1 field is required", "address-line-1 field is Required", "City field is required", "State field is required", "ZIP Code field is required", "County field is required"));
        verifyListValue(VALIDATION_ERRORS, validationErrors, "Validation Errors");
        Reports.log("List of validation errors: \n" + validationErrors.toString());
        int noOfMandatoryFeilds = checkAllTheFieldsWithSpecificData(VALIDATION_ERRORS, "field is required");
        Reports.log("Number of mandatory fields: " + noOfMandatoryFeilds);
        driver.navigate().refresh();
        fillInKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, zip, Data.countyCodeSD, enrollmentType);
    }


    /**
     * This method Verifies and fills in Exclusion Sanction Section
     * Verify that the system is showing all the questions in the section.
     * Verify that the questions are mandatory and have no default values.
     * Verify that the questions have numbers based on A and B.
     */
    public void verifyAndFillExclusionAndSectionEnrollment() {
        Reports.log("\nVerification Exclusion Sanction Section ");


        javaWaitSec(2);
        ajaxClick(SECTION_PROVIDER_EXCLUSION);


        Boolean radioButton = checkIfRadioButtonsSelected(By.xpath("//input[@type='radio']"));
        Assert.assertTrue(radioButton, "Radio Button is selectd by default");
        Reports.log("Verification of radio button successful\n");


        int ListOfMandatoryQuestionsSectionS = checkAllTheFieldsWithSpecificData(EXCLUSION_SANCTION_QUESTIONS, "*");
        Reports.log("Number of mandatory questions in Exclusion section: " + ListOfMandatoryQuestionsSectionS);


        int ListOfQuestionsSectionA = checkAllTheFieldsWithSpecificData(EXCLUSION_SECTION_A_QUESTIONS, "Perjury");
        Reports.log("Number of questions Under section A: " + ListOfQuestionsSectionA);
        int ListOfQuestionsSectionB = checkAllTheFieldsWithSpecificData(EXCLUSION_SECTION_B_QUESTIONS, "*");
        Reports.log("Number of questions Under section B: " + ListOfQuestionsSectionB);


        ArrayList<String> sectionAQuestions = new ArrayList<>(Arrays.asList("1. Fraud, theft, embezzlement, extortion, income tax evasion, or insurance fraud *",
                "2. Financial misconduct tied to delivery of health care not otherwise noted or breach of fiduciary responsibility *",
                "3. Perjury *",
                "4. Abuse or neglect of a patient, child, or elderly adult *",
                "5. Obstruction of a criminal investigation *",
                "6. Unlawful manufacture, distribution, prescription, or dispensing of any controlled substances *",
                "7. Health care related crime, not otherwise listed *"));
        verifyListValue(EXCLUSION_SECTION_A_QUESTIONS, sectionAQuestions, "section A Questions");


        ArrayList<String> sectionBQuestions = new ArrayList<>(Arrays.asList("1. Failed to grant immediate access and/or provide payment information *",
                "2. Failed to provide disclosure information *",
                "3. Revocation or suspension of a license to provide health care, including any license surrender while formal disciplinary actions were pending  *",
                "4. Revocation or suspension of accreditation *",
                "5. Suspension, exclusion, debarment, or sanction from participation by a Federal or State health care program or procurement program *",
                "6. Current payment suspension with Medicare or another State Medicaid agency *",
                "7. Judgment under the False Claims Act *",
                "8. Current overpayment with Medicare or another State Medicaid agency exceeding $1,500 *"));
        verifyListValue(EXCLUSION_SECTION_B_QUESTIONS, sectionBQuestions, "section B Questions");
        fillInExclusionAndSanctionSection();
    }


    /**
     * This method Verifies and fills in Provider Agreement Section
     * Verified the text for provider Agreement in the left section during Enrollment
     */
    public void verifyAndFillProviderAgreementSection(String enrollmentType, String firstName, String lastName) throws InterruptedException {
        if (enrollmentType.equalsIgnoreCase("Trading Partner (TP) Enrollment")) {
            ajaxScroll(TRADING_PARTNER_AGREEMENT_TEXT);
            String getTextTradingPartnerAgreement = driver.findElement(TRADING_PARTNER_AGREEMENT_TEXT).getText();
            Reports.log(getTextTradingPartnerAgreement);
            Assert.assertEquals(getTextTradingPartnerAgreement, Data.TRADING_PARTNER_AGREEMENT);
        }


        // this method can be extended in the future based on stories or requirements for provider agreement text
        if (enrollmentType.equalsIgnoreCase("Individual Enrollment")) {
        }
        signInProviderAgreementForm(enrollmentType, firstName, lastName);
    }


    /**
     * This method verifies and validates the  authorized signature fields
     */
    public void verifyAndFillAuthorizedSignatureSectionTradingPartnerEnrollment(String Name) {
        javaWaitSec(15);
        ajaxScroll(SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        ajaxClick(SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        verifyThatElementIsDisplayed(LABEL_NAME_OF_AUTHORIZED_SIGNATURE);
        verifyThatElementIsDisplayed(LABEL_TITLE_OF_AUTHORIZED_SIGNATURE);
        javaWaitSec(5);
        driver.findElement(TEXT_FIELD_NAME_OF_AUTHORIZED).click();
        javaWaitSec(5);
        driver.findElement(TEXT_FIELD_NAME_OF_AUTHORIZED).sendKeys(TAB);
        String validation_error = driver.findElement(VALIDATION_AUTHORIZED_SIGNATURE).getText();
        if (validation_error.equalsIgnoreCase("This field is required")) {
            Assert.assertTrue(true);
        }
        driver.findElement(TEXT_FIELD_NAME_OF_AUTHORIZED).sendKeys("TP");
        javaWaitSec(5);
        driver.findElement(TEXT_FIELD_TITLE_OF_PERSON).click();
        driver.findElement(TEXT_FIELD_TITLE_OF_PERSON).sendKeys(TAB);
        driver.findElement(VALIDATION_AUTHORIZED_SIGNATURE).getText();
        if (validation_error.equalsIgnoreCase("This field is required")) {
            Assert.assertTrue(true);
        }
        javaWaitSec(5);
        doublePerformClick(TEXT_FIELD_NAME_OF_AUTHORIZED);
        driver.findElement(TEXT_FIELD_NAME_OF_AUTHORIZED).sendKeys(Keys.DELETE);
        fillAuthorizedSignaturSection(Name);
    }




    public void fillInProviderIdentifyingInformationPEM(String firstName, String lastName, String phone_number, String gender, String dob,
                                                        String countryOfBirth, String stateOfBirth, String email, String ssn,
                                                        String profitStatus, String enrollmentType) {
        Reports.log("Identifying Information");
        javaWaitSec(2);


        ajaxClick(TEXT_FIELD_FIRST_NAME_PROVIDER);
        driver.findElement(TEXT_FIELD_FIRST_NAME_PROVIDER).clear();
        setFieldValueWithTabAndWait(TEXT_FIELD_FIRST_NAME_PROVIDER, firstName);
        Reports.log("Type first name: " + firstName);


        setFieldValueWithTabAndWait(TEXT_FIELD_LAST_NAME_PROVIDER, lastName);
        Reports.log("Type in last name: " + lastName);


        selectFirstOptionInDropdown(COMBOBOX_GENDER);
        Reports.log("Type gender: " + gender);


        setFieldValueWithTabAndWait(PEM_TEXT_FIELD_PHONE_NUMBER, phone_number);
        Reports.log("Type in phone number: " + phone_number);


        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_EMAIL, email);
        Reports.log("Type Application contact email: " + email);


        String DOB= createRandomDateInSpecificYears(-18, -60);
        fillInCalendar(DOB, Data.dateOfBirthCalendar2);
        Reports.log("Set Date of Birth: " + DOB);
        javaWaitSec(1);


        selectFirstOptionInDropdown(DROP_DOWN_COUNTRY_OF_BIRTH);
        Reports.log("Type Country of birth: " + countryOfBirth);


        selectFirstOptionInDropdown(DROP_DOWN_STATE_OF_BIRTH);
        Reports.log("Type State of birth: " + stateOfBirth);
        driver.findElement(DROP_DOWN_STATE_OF_BIRTH).sendKeys(Keys.TAB);


        ajaxClick(TEXT_FIELD_SSN);
        setFieldValueWithTabAndWait(TEXT_FIELD_SSN, ssn);
        Reports.log("Type SSN: " + ssn);


    }


    public void fillInKeyPersonalSectionEntity(int index, String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType, String npi) throws InterruptedException {


//        fillInKeyPersonalSection(index, physicalAdress,city, mailingState, zip, countyCode,enrollmentType);
//        javaWait(1);
//
//        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
//        javaWait(1);
//
//        //Partner Section
//        clickAnyButton2(Data.TEXT_ADD_LINE, 1);
//        Reports.log("Click on +Add line Button");
//
//
//        ajaxScroll(TEXT_FIELD_LICENSE_FIRST_NAME);
//        ajaxClick(TEXT_FIELD_LICENSE_FIRST_NAME);
//
//        driver.findElements(TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(generateFirstName());
//        driver.findElements(TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(generateLastName());
//
//
//        driver.findElements(TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(Data.ssn);
//        driver.findElement(TEXT_FIELD_COUNTRY_OF_BIRTH).click();
//        ajaxClick(setSpecificStrongOptionInListboxSD("United States"));
//
//        driver.findElement(DROP_DOWN_STATE_OF_BIRTH2).click();
//        ajaxClick(setSpecificStrongOptionInListboxSD("South Dakota"));
//
//        Reports.log("Selected a State of birth");
//
////        ajaxClick(TEXT_FIELD_COUNTRY_OF_BIRTH);
////        performClick(setSpecificOptionInListbox("United States"));
//
//        fillInCalendar(Data.dob, Data.dateOfBirthCalendar2);
//        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
//        fillInCalendar(changeYearInCurrentDate(1), Data.endDateCalendar);
//
//        fillInAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
//
//        javaWait(1);
//        ajaxClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
//        clickAnyOptionInList(1);
//        ajaxScrollByCoordinate(100);
//
//        ajaxClick(TEXT_FIELD_EMPLOYEE_STATUS);
//        clickAnyOptionInList(1);
//        ajaxScrollByCoordinate(100);
//
//
//        setAndFindButton(Data.TEXT_SAVE).click();
//        javaWait(1);
//
//
//        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
//        javaWait(1);


        //Other Managing Employee Type
        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
        ajaxScrollDown();
        clickAnyButton(Data.TEXT_ADD_LINE);
//        clickAnyButton(Data.TEXT_ADD_LINE);
        Reports.log("Click on +Add line Button");


        javaWaitSec(1);


        ajaxScroll(TEXT_FIELD_LICENSE_FIRST_NAME);
        ajaxClick(TEXT_FIELD_LICENSE_FIRST_NAME);


        String licenseFirstName =generateFirstName() ;
        Reports.log("Type License First Name :"+licenseFirstName);
        driver.findElements(TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(licenseFirstName);


        String licenseLastName =generateLastName() ;
        Reports.log("Type License Last Name :"+licenseLastName);
        driver.findElements(TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(licenseLastName);


        performClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
        Reports.log("Select Managing Employee Type");
        javaWaitSec(2);
        jsClick("//ul[@role='listbox']/li[text()='Director']");
        ajaxScrollByCoordinate(100);
        javaWaitSec(5);


        performClick(TEXT_FIELD_EMPLOYEE_STATUS);
        javaWaitSec(2);
        // jsClick("//ul[@role='listbox']/li[text()='Managing Non Convicted']");
        performClick(SELECT_TEXT_FIELD_EMPLOYEE_STATUS);
        javaWaitSec(2);


        driver.findElement(TEXT_FIELD_COUNTRY_OF_BIRTH).click();
        Reports.log("Select country of Birth :"+Data.countryOfBirth);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.countryOfBirth));


        driver.findElement(DROP_DOWN_STATE_OF_BIRTH2).click();
        Reports.log("Select State of Birth :"+Data.SOUTH_DAKOTA);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.SOUTH_DAKOTA));
        javaWaitSec(5);
        driver.findElement(RACE).click();
        javaWaitSec(5);
        Reports.log("Selected race:"+Data.ASIAN);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.ASIAN));


        javaWaitSec(3);
        driver.findElement(GENDER).click();
        Reports.log("Select Gender :"+ Data.genderMale);
        ajaxClick(setSpecificStrongOptionInListboxSD( Data.genderMale));
        javaWaitSec(5);


        String DOB = createRandomDateInSpecificYears(-18, -60);
        fillInCalendar(DOB, Data.dateOfBirthCalendar2);
        Reports.log("Date of birth is: "+ DOB);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        fillInCalendar(changeYearInCurrentDate(1), Data.endDateCalendar);


//        ajaxScrollUp();
//        javaWaitSec(2);
//        performClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
//        Reports.log("Select Managing Employee Type");
//        javaWaitSec(2);
//        jsClick("//ul[@role='listbox']/li[text()='Director']");
//        ajaxScrollByCoordinate(100);


//        fillInAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        driver.findElement(ADDRESS_DETAILS).sendKeys(physicalAdress);
        javaWaitSec(6);
        driver.findElement(By.xpath("(//div//ul//li[contains(@id,'react-autowhatever-address-id')]//div)[1]")).click();


        ajaxScrollUp();
        javaWaitSec(2);




//        setFieldValueWithTabAndWait(PROVIDER_ID,Data.PROVIDER_ID);
        setFieldValueWithWaits(NPI_IN_KEY_PERSONAL, npi);




        String ssn = generateANumberOfLength(10);
        Reports.log("Type SSN :"+ssn);
        performClick(TEXT_FIELD_SSN_ENTITY);
        driver.findElements(TEXT_FIELD_SSN_ENTITY).get(index).sendKeys(ssn);


//
//        ajaxClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
//        clickAnyOptionInList(1);
//        ajaxScrollByCoordinate(100);
//
//        ajaxClick(TEXT_FIELD_EMPLOYEE_STATUS);
//        clickAnyOptionInList(1);
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
        javaWait(1);
    }


    public void addProgramParticipation(String pgmPrtcpan, String speciality, By pgmParticipationLocation) {
        ajaxScroll(pgmParticipationLocation);
        ajaxClick(pgmParticipationLocation);
        Reports.log("Clicked on the ADD PROGRAM PARTICIPATION button");
        javaWaitSec(2);
        driver.findElement(SELECT_PROGRAM_PARTICIPATION_DROPDOWN).click();
//        ajaxClick(SELECT_PROGRAM_PARTICIPATION_DROPDOWN);
        ajaxClick(setSpecificOptionInListbox(pgmPrtcpan));
        Reports.log("Selected Program Participation : " + pgmPrtcpan);


        javaWaitSec(2);
        driver.findElement(SELECT_SPECIALITY_DROPDOWN).click();
        javaWaitSec(1);
        ajaxClick(setSpecificOptionInListbox(speciality));
//        clickAnyOptionInList(2);
        Reports.log("Selected Speciality");
    }
    public void addProgramParticipationForIndividual(String speciality){
        javaWaitSec(2);
        ajaxClick(ADD_TAXONOMY);
        Reports.log("Clicked on the ADD TAXONOMY button");
        javaWaitSec(2);
        clickAndTypeAndSelectOptionInCombobox("Select Taxonomy - Description", "2251000", 0);
//        driver.findElement(SELECT_SPECIALITY_DROPDOWN).click();
//        javaWaitSec(1);
//        ajaxClick(setSpecificOptionInListbox(speciality));
//        Reports.log("Selected Speciality");
        javaWaitSec(5);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE_START, TAXONOMY_EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.EFFECTIVE_END_DATE, TAXONOMY_EFFECTIVE_END_DATE);
        javaWaitSec(2);




    }


    public void addTaxonomyForEntity(String speciality){
        javaWaitSec(2);
        ajaxClick(ADD_TAXONOMY);
        Reports.log("Clicked on the ADD TAXONOMY button");
        javaWaitSec(2);
        clickAndTypeAndSelectOptionInCombobox("Select Taxonomy - Description", "2251000", 0);
        driver.findElement(SELECT_SPECIALITY_DROPDOWN).click();
        javaWaitSec(1);
        ajaxClick(setSpecificOptionInListbox(speciality));
        Reports.log("Selected Speciality");
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE_START, TAXONOMY_EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.EFFECTIVE_END_DATE, TAXONOMY_EFFECTIVE_END_DATE);
        javaWaitSec(2);
    }


    public void addProgramParticipationForMCO(){
        javaWaitSec(2);
        ajaxClick(ADD_TAXONOMY);
        Reports.log("Clicked on the ADD TAXONOMY button");
        javaWaitSec(2);
        clickAndTypeAndSelectOptionInCombobox("Select Taxonomy - Description", "305R00000X", 0);
        javaWaitSec(5);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE_START, TAXONOMY_EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.EFFECTIVE_END_DATE, TAXONOMY_EFFECTIVE_END_DATE);
        javaWaitSec(2);
    }


    public void addTaxonomy(String taxonomy) {
        ajaxClick(ADD_TAXONOMY_BUTTON);
        Reports.log("Clicked on Add Taxonomy Button");


        javaWaitSec(2);
        driver.findElement(SELECT_TAXONOMY_DROPDOWN).click();
        ajaxClick(setSpecificOptionInListbox(taxonomy));
//        clickAnyOptionInList(1);
        Reports.log("Selected Taxonomy : " + taxonomy);


        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE_START);
        javaWaitSec(1);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_END_DATE);
        javaWaitSec(1);
    }






    public void addLicense(String licenseType, String issueState, String number) {
        ajaxClick(ADD_LICENSE_BUTTON);
        Reports.log("Clicked on Add License Button");
        javaWaitSec(1);
        performClick(LICENSE_TYPE_DROPDOWN);
//        clickAnyOptionInList("Hospital - General Acute");
        ajaxClick(setSpecificOptionInListbox(licenseType));
        javaWaitSec(2);
        Reports.log("Selected License: " + licenseType);


        driver.findElement(LICENSE_ISSUER_DROPDOWN).click();
        ajaxClick(setSpecificOptionInListbox(issueState));
        javaWaitSec(2);
        Reports.log("Selected Program Participation: " + issueState);


        ajaxClick(LICENSE_NUMBER_INPUT);
        ajaxClear(LICENSE_NUMBER_INPUT);
        driver.findElement(LICENSE_NUMBER_INPUT).sendKeys(number);
        Reports.log("Typed License Number: " + number);
        javaWaitSec(2);


//        ajaxSendKeys(LICENSE_NUMBER_INPUT,Data.LICENSE_NUMBER);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE_START, LICENSE_EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.EFFECTIVE_END_DATE, LICENSE_EFFECTIVE_END_DATE);
        javaWaitSec(5);
        robotUploadDocument(UPLOAD_LICENSE_BUTTON);
        javaWaitSec(10);
        ajaxClick(ADD_BUTTON);
        javaWaitSec(2);
    }
    public void addLicenseForIndiPP(String licenseType, String number){
        ajaxClick(ADD_LICENSE_BUTTON);
        Reports.log("Clicked on Add License Button");
        javaWaitSec(5);
        performClick(LICENSE_TYPE_DROPDOWN);
//        driver.findElement(By.xpath("//label[contains(text(),'License/Certificate Type*')]")).click();
        ajaxClick(setSpecificOptionInListbox(licenseType));
        javaWaitSec(2);
        Reports.log("Selected License: " + licenseType);






        ajaxClick(LICENSE_NUMBER_INPUT);
        ajaxClear(LICENSE_NUMBER_INPUT);
        driver.findElement(LICENSE_NUMBER_INPUT).sendKeys(number);
        Reports.log("Typed License Number: " + number);
        javaWaitSec(2);


//        ajaxSendKeys(LICENSE_NUMBER_INPUT,Data.LICENSE_NUMBER);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE_START, LICENSE_EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.EFFECTIVE_END_DATE, LICENSE_EFFECTIVE_END_DATE);
        javaWaitSec(5);


        robotUploadDocument(UPLOAD_LICENSE_BUTTON);
        ajaxClick(ADD_BUTTON);
        javaWaitSec(2);


    }


    /**
     * This method fills in enroll Provider information
     *
     * @param enrolledProviderEmail
     * @param enrolledProviderFName
     * @param enrolledProviderLName
     */
    public void fillEnrollProviderInformation(String enrolledProviderHaveEmail, String enrolledProviderEmail, String enrolledProviderFName,
                                              String enrolledProviderLName){


        //Enter email based on Have Provider Email specified
        if (enrolledProviderHaveEmail.equalsIgnoreCase("YES")){
            driver.findElement(ENROLL_PROVIDER_EMAIL).sendKeys(enrolledProviderEmail);
            Reports.log("Enroll Provider Email Entered: " + enrolledProviderEmail);
        } else {
            ajaxClick(ENROLL_PROVIDER_HAVE_EMAIL_NO_XPATH);
            Reports.log("Enroll Provider Email Option 'No' Selected ");
        }


        //Enter First and Last Name
        driver.findElement(ENROLL_PROVIDER_FIRST_NAME).sendKeys(enrolledProviderFName);
        Reports.log("Entered Enrolled Provider First Name: " + enrolledProviderFName);


        driver.findElement(ENROLL_PROVIDER_LAST_NAME).sendKeys(enrolledProviderLName);
        Reports.log("Entered Enrolled Provider Last Name: " + enrolledProviderLName);


        //Click Proceed
        javaWaitSec(5);
        ajaxClick(ENROLL_PROVIDER_PROCEED);
        Reports.log("Enrolled Provider Created.\n");


    }




    public void navigateAndOpenToMessageCenter(){
        javaWaitSec(2);
        ajaxClick(MESSAGE_INBOX);
        Reports.log("Clicked on the Message Inbox");
        javaWaitSec(5);
        ajaxClick(First_MESSAGE_IN_INBOX);
        driver.findElement(SELECT_VIEW_OPTION).click();
        Reports.log("Opening the first Message in the inbox");
        javaWaitSec(2);
        ajaxClick(MESSAGE_CONTENT_InBOX);
        Reports.log("Clicked on the Link to Sign link to confirm the Affiliation ");
        javaWaitSec(15);


    }
    /**
     * This method clicks on ReEnrollment appeal button
     */
    public void clickOnReEnrollmentApplBtn(){
        ajaxClick(PROVIDER_DASHBOARD_REENROLLMENT_APPLICATION_BUTTON);
        javaWaitSec(20);
        Reports.log("Click on 'RE-ENROLLMENT APPLICATION' button");
    }


    public void fillInApplicationTypeDeterminationInIF(){
        javaWaitSec(35);
        driver.findElement(APPLICATION_TYPE_DETERMINATION_OPTION_FOR_GRP).click();
        javaWaitSec(2);
    }
    public void practiceTypeForGrp(){
        javaWaitSec(2);
        driver.findElement(PRACTICE_TYPE_OPTION_FOR_GRP).click();
        javaWaitSec(2);
    }
    public void fillInNPITable( String npi){
        javaWaitSec(2);
        clickAnyButton(Data.TEXT_ADD_LINE);
        javaWaitSec(5);
        ajaxScroll(TEXT_FIELD_NEW_NPI);
        setFieldValueWithWaits(NPI_FOR_TABLE, npi);
        javaWaitSec(2);
        fillInCalendar(getCurrentDate(), Data.effectiveStartDateCalendar, EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.effectiveEndDateCalendar, EFFECTIVE_END_DATE);
        javaWaitSec(5);
        ajaxScrollUp();
        setAndFindButton(Data.TEXT_SAVE).click();
//        clickAnyButton(Data.TEXT_SAVE);


        javaWaitSec(5);
    }




    public void selectAllRadioBtnForPLIIForGrp(String radioButtonValue){
        ajaxClick(By.xpath(String.format(HAVE_YOU_EVER_DENIED_PROFESSIONAL_LIABILITY_INSURANCE, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(HAVE_YOUR_PROFESSIONAL_LIABILITY_INSURANCE_EVER_BEEN_CANCELLED, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(WITHIN_THE_PAST_SEVEN_YEARS, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(UNFAVOURABLE_JUDGEMENT, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(TO_YOUR_KNOWLEDGE_ISANY_MALPRACTICE_ACTION, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(DO_YOU_HAVEA_MENTAL_HEALTH_CONDITION, radioButtonValue)));
        javaWaitSec(1);
        ajaxClick(By.xpath(String.format(MALPRACTICE_INSURANCE, radioButtonValue)));
        javaWaitSec(1);




    }


    public void fillInOtherCredentialingInfo(String organizationName, String schoolName, String address, String schoolCity, String mailingState, String countryOfBirth) {
        javaWaitSec(2);
        ajaxClick(OTHER_CREDENTIALING_INFO);
        javaWaitSec(5);
        fillInProfessionalTraining(organizationName);
        fillInEducationInformation(schoolName, address, schoolCity, mailingState, countryOfBirth);
    }


    public void EmploymentAuthorizationInformation(String enrollmentType ){


        javaWaitSec(5);
        ajaxClick(EmpAuthInfo);
        Reports.log("Clicked on Employment Authorization Information tab");
        javaWaitSec(5);
        ajaxClick(yesRadioButton);
        Reports.log("Clicked on 'YES' for Are you a U.S. citizen or lawful permanent resident? ");
        javaWaitSec(5);


    }


    public void fillInProfessionalTraining(String organizationName){
        ajaxScrollUp();
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        javaWaitSec(5);
        performClick(TYPE_OF_TRAINING);
        javaWaitSec(5);
        performClick(TYPE_OF_TRAINING_OPTION);
        driver.findElement(ORGANIZATION_NAME).sendKeys(organizationName);
        fillInCalendar(getCurrentDate(), Data.effectiveStartDateCalendar, EFFECTIVE_START_DATE);
        javaWaitSec(2);
        fillInCalendar(changeYearInCurrentDate(1), Data.effectiveEndDateCalendar, EFFECTIVE_END_DATE);
        javaWaitSec(2);
        robotUploadDocument(UPLOAD_DOC_FOR_PROFESSIONAL_TRAINING);
        javaWaitSec(2);
        setAndFindButton(Data.TEXT_SAVE).click();
        javaWaitSec(3);


    }
    public void fillInEducationInformation(String schoolName, String address, String schoolCity, String mailingState,String countryOfBirth){
        ajaxScrollDown();
        clickAnyButton2(Data.TEXT_ADD_LINE, 1);
        Reports.log("Click on +Add line Button");
        performClick(GRADUATION_TYPE);
        javaWaitSec(5);


        ajaxClick(noRadioButton);


        performClick(GRADUATION_TYPE_OPTION);
        javaWaitSec(5);
        driver.findElement(PROFESSIONAL_SCHOOL_NAME).sendKeys(schoolName);
        javaWaitSec(5);
        driver.findElement(PHYSICAL_SCHOOL_ADDRESS).sendKeys(address);
        javaWaitSec(5);
        driver.findElement(PROFFESIONAL_SCHOOL_CITY).sendKeys(schoolCity);
        javaWaitSec(10);
//        driver.findElement(PROFFESIONAL_SCHOOL_STATE).sendKeys(mailingState);
//        javaWaitSec(2);


        // 1. Click to open the dropdown
        driver.findElement(PROFFESIONAL_SCHOOL_STATE).click();
        javaWaitSec(2); // wait for dropdown to render


// 2. Select the 10th option (index 9)
        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        if (options.size() >= 10) {
            options.get(9).click(); // Index 9 = 10th element
        } else {
            System.out.println("Less than 10 options available.");
        }


        driver.findElement(PROFFESIONAL_SCHOOL_COUNTY).sendKeys(countryOfBirth);
        javaWaitSec(5);
        driver.findElement(PROFFESIONAL_SCHOOL_COUNTRY).sendKeys(countryOfBirth);
        ajaxScrollDown();
        javaWaitSec(5);
        setAndFindButton(Data.TEXT_SAVE).click();
        javaWaitSec(5);
        ajaxClick(NEXT_BUTTON_OCI);


    }
    public void uploadDocInUploadDocSection(){
        Reports.log("\nFill in Upload Document Section");
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_UPLOAD_DOCUMENTS));
        //  driver.findElement(SECTION_UPLOAD_DOCUMENTS).click();
        ajaxClick(SECTION_UPLOAD_DOCUMENTS);
        robotUploadDocument(UPLOAD_ADDITIONAL_DOC);


    }
    public void clickonenrollment(){


    }


}


