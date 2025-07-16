package com.hhstechgroup.Pages;

import com.hhstechgroup.common.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FilenameFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.openqa.selenium.Keys.TAB;

public class CocsPage extends BaseActions {

    protected SoftAssert softAssert = new SoftAssert();

    // Provider CoC
   // public static final By searchResultText = By.xpath("//div[contains(@class,'styles_search-box-container')]/following::h2");
    public static final By searchResultText = By.xpath("//div//h2[contains(text(),'Search results')]");
    public static final String tableInfo = "//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div";
    public static final By coc_top_section_labels = By.xpath("//div[contains(@class, 'main-info-panel_content')]//div/span/span");
    public static final By coc_provider_name = By.xpath("//div[contains(@class, 'main-info-panel_column')]/div[2]/p[2]");
    public static final By coc_npi = By.xpath("//div[contains(@class, 'main-info-panel_item')][2]/div");
    public static final By coc_menu_tab = By.xpath("//ul//li//a[@href='/coc-list']");
    public static final By TEXT_FIELD_MIDDLE_NAME_PROVIDER = By.xpath("//input[contains(@aria-label, 'Middle Name')]");
    public static final By TEXT_FIELD_Last_NAME_PROVIDER = By.xpath("//input[contains(@aria-label, 'Last Name')]");
    public static final By TEXT_FIELD_Email_PROVIDER = By.xpath("//input[contains(@aria-label, 'Email')]");
    public static final By COC_PROGRAM_PARTICIPATION_RADIO_BTN = By.xpath("//input[@value='programParticipation/taxonomy/licenseAndServiceLocation']");


    // Provider CoC - Identifying Information Field Identifiers
    public static final String IDENTIFYING_INFO_FIELD_FIRST_NAME = "First Name";
    public static final String IDENTIFYING_INFO_FIELD_MIDDLE_NAME = "Middle Name";
    public static final String IDENTIFYING_INFO_FIELD_LAST_NAME = "Last Name";
    public static final String IDENTIFYING_INFO_FIELD_GENDER = "Gender";
    public static final String IDENTIFYING_INFO_FIELD_ALT_EMAIL = "Alternate Email";
    public static final String IDENTIFYING_INFO_FIELD_WEBSITE = "Website Address";
    public static final String IDENTIFYING_INFO_FIELD_PHONE = "Phone Number";
    public static final String IDENTIFYING_INFO_FIELD_FAX = "Fax";


    // Provider CoC - Identifying Information Xpath Identifiers
    public static final String IDENTIFYING_INFO_XPATH_FIRST_NAME = "//input[contains(@aria-label, 'First Name')]";
    public static final String IDENTIFYING_INFO_XPATH_MIDDLE_NAME = "//input[contains(@id, 'Middle Name')]";
    public static final String IDENTIFYING_INFO_XPATH_LAST_NAME = "//input[contains(@aria-label, 'Last Name')]";
    public static final String IDENTIFYING_INFO_XPATH_GENDER_INPUT = "//input[contains(@name, 'Gender')]";

    public static final String IDENTIFYING_INFO_XPATH_GENDER = "//h2[contains(@class,'sc-')][contains(.,'Gender')]";

    public static final String IDENTIFYING_INFO_XPATH_ALT_EMAIL = "//input[contains(@aria-label, 'Alternate Email')]";
    public static final String IDENTIFYING_INFO_XPATH_WEBSITE = "//input[contains(@aria-label, 'Website Address')]";
    public static final String IDENTIFYING_INFO_XPATH_PHONE = "//div[contains(@label,'Phone Number')]/input[contains(@placeholder, '(___)')]";
    public static final String IDENTIFYING_INFO_XPATH_FAX = "//div[contains(@label,'Fax')]/input[contains(@placeholder, '(___)')]";
    public static final String IDENTIFYING_INFO_XPATH_NEXT = "//button/span[contains(text(),'Next')]";

    // Provider CoC - Address Details Field Identifiers
    public static final String ADDRESS_DETAILS_FIELD_ATTENTION = "Attention Line";
    public static final String ADDRESS_DETAILS_FIELD_EMAIL = "Email";

    // Provider CoC - Address Details Xpath Identifiers
    public static final String ADDRESS_DETAILS_XPATH_ATTENTION = "//input[contains(@aria-label, 'Attention Line')]";
    public static final String ADDRESS_DETAILS_XPATH_EMAIL = "//input[contains(@id, 'Middle Name')]";

    // Internal User CoC
    public static final By coc_iu_search_label_npi = By.xpath("//label[contains(text(),'NPI')]");
    public static final By coc_iu_search_label_ssn = By.xpath("//label[contains(text(),'FEIN/SSN')]");
    public static final By coc_iu_search_label_assignee = By.xpath("//label[contains(text(),'Assignee')]");

    public static final By coc_iu_input_npi = By.xpath("//input[@id='NPI']");
    public static final By coc_iu_input_ssn = By.xpath("//input[@id='FeinSSN']");
    public static final By coc_iu_input_assignee = By.xpath("//input[@id='Assignee']");

    public static final By COC_ID = By.xpath("//div[contains(@class, 'tooltip')]//p");

    public static final By COC_REQUEST_RESULTS_RED_TEXT = By.xpath("//div[contains(@class, 'expansion-panel-summary')]/div");
    public static final By DOWNLOAD_BUTTON = By.xpath("//a[contains(text(),'Download')]");

    public static final By FIN_INST_INPUT = By.xpath("//label[contains(text(),'Financial Institution')]/following-sibling::div/input");
    public static final By COC_TAB = By.xpath("//a[contains(text(),'CoC')]");
    public static final By TYPE_SEARCH_INPUT = By.xpath("//div[contains(text(),'Type')]/parent::div/div/div/input");
    public static final By EFT_FINANCIAL_INSTITUTION = By.xpath("//input[contains(@aria-label,'Name of the Financial Institution')]");
    public static final By CLASSIFICATION_SECTION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Classification']");
    public static final By ENTITY_FIELD = By.xpath("//input[@name='Entity Code']");
    public static final By TEXT_FIELD_REQUEST_ID = By.xpath("//input[@id='RequestID']");
    public static final By SOFTWARE_VENDOR_NAME = By.xpath("//input[contains(@aria-label,'Software Vendor Name')]");
    public static final By SOFTWARE_NAME = By.xpath("//input[contains(@aria-label,'Software Name')]");
    public static final By VERSION_ID = By.xpath("//input[contains(@aria-label,'Version ID')]");
    public static final By IDENTIFYING_INFORMATION = By.xpath("//span[text()='Identifying Information']");
    public static final By TEXT_FIELD_ADDRESS = By.xpath("//div[@data-for ='Address Line 1']//input");
    public static final By ADDRESS_LIST = By.xpath("//div[contains(@id,'react-autowhatever')]/ul/li");
    public static final By COMBOBOX_TITLE_PROVIDER = By.xpath("//input[@name='Title']");
    public static final By SECTION_PROVIDER_ADDRESS_DETAILS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Address Details']");
    public static final By TEXT_FIELD_CONTACT_ATTENTION_LINE = By.xpath("//input[contains(@aria-label, 'Attention Line')]");

    public static final By COC_STATUS_DETAILS = By.xpath("(//span[contains(.,'Status')])[3]//following::div[contains(@class,'main-info-panel_value')][1]//div[1]");
    public static final By POPUP_CHANGE_STATUS = By.xpath("(//div[@role='button'])[2]");
    public static final By BUTTON_APPROVE_REASON = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");

    public static final By POPUP_PENDING_REVIEW_REASON = By.xpath("(//div[@role='button'])[2]");
    public static final By PARTICIPANT_MEDICARE_RADIO_BTN_YES   = By.xpath("//input[contains(@name, 'Medicare')][@value='Yes']");

    public static final By SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Primary Service Location Information']");
    public static final By ADDRESS_LINE_2 = By.xpath("//div[contains(@data-for,'Primary Service Location Address Line 2')]//input");
    public static final By SECTION_TAXONOMY = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[contains(text(), 'Taxonomy')]");
    public static final By DEA_NUM = By.xpath("//div[contains(@data-for,'DEA Num')]//input");


    public static final By PARTICIPANT_MEDICARE_ADD_LINE_BUTTON   = By.xpath("(//span[contains(.,'+ Add Line')])[2]");
    public static final By PARTICIPANT_MEDICARE_ID_INPUT   = By.xpath("//input[contains(@aria-label,'Medicare Id')]");
    public static final By SECTION_PROVIDER_IDENTIFIERS = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Provider Identifiers']");
    public static final By YES_RADIOBUTTON_OWNERSHIP_OWNERSHIP_ENTITY = By.xpath("//input[contains(@name, 'ownership in any entity that has billed')][@value='true']");
    public static final By SECTION_PROVIDER_KEY_PERSONNEL = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Key Personnel']");
    public static final By TEXT_FIELD_LICENSE_FIRST_NAME = By.xpath("//input[contains(@aria-label, 'First Name')]");
    public static final By TEXT_FIELD_LICENSE_LAST_NAME = By.xpath("//input[contains(@aria-label, 'Last Name')]");
    public static final By TEXT_FIELD_SSN_PHARMACY = By.xpath("//div[@data-for='SSN']//input");
    public static final By TEXT_FIELD_COUNTRY_OF_BIRTH = By.xpath("//label[contains(., 'Country of Birth')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By DROP_DOWN_STATE_OF_BIRTH2 = By.xpath("//label[contains(., 'State of Birth')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By TEXT_FIELD_MANAGING_EMPLOYEE_TYPE = By.xpath("//label[contains(., 'Managing Employee Type')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By TEXT_FIELD_EMPLOYEE_STATUS = By.xpath("//label[contains(., 'Employee Status')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By TEXT_ADDRESS_CITY = By.xpath("//input[contains(@aria-label,'City')]");
    public static final By TEXT_FIELD_ZIP_CODE1 = By.xpath("//div[contains(@label,'ZIP')]//input");
    public static final By INPUT_FEILD_LEGAL_BUSINESS_NAME = By.xpath("//input[contains(@aria-label,'Legal Business Name')]");
    public static final By INPUT_FEILD_DBA = By.xpath("//input[contains(@aria-label,'DBA')]");
    public static final By INPUT_FEILD_FEIN_NUMBER = By.xpath("//div[@label='FEIN']/input");
    public static final By OWNERSHIP_SELECT_PROGRAM = By.xpath("//label[contains(., 'Select Program')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");
    public static final By TEXT_FIELD_CITY = By.xpath("//input[contains(@aria-label, 'City')]");
    public static final By TEXT_FIELD_ADDRESS1 = By.xpath("//input[contains(@id,'line1')]");
    public static final By DROP_DOWN_STATE = By.xpath("(//label[@id='State']/following::div/div/div)[1]");
    public static final By TEXT_FIELD_ZIP_CODE = By.xpath("//div[contains(@label,'Zip Code')]//input");
    public static final By TEXT_COUNTY_CODE = By.xpath("//input[contains(@aria-label,'County')]");
    public static final By DROP_DOWN_ADDRESS_STATE = By.xpath("//label[(text() ='State')]//following::div[@role='button']");
    public static final By SECTION_PROVIDER_PROGRAM_PARTICIPATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Program Participation / Taxonomy / License / Certificate Information']");
    public static final By ELLIPTICAL_PROVIDER_PROGRAM_PARTICIPATION  = By.xpath("//button[@aria-label='More']") ;
    public static final By ELLIPTICAL_EDIT_MENU_ITEM = By.xpath("//li[@role='menuitem'][contains(.,'Edit')]") ;
    public static final By EDIT_BTN_WITH_INDEX_TWO= By.xpath("(//span[contains(.,'Edit')])[2]") ;
    public static final By POPUP_SITEVISIT_SELECT_LOCATION_DROPDOWN = By.xpath("//div[contains(@id,'Please select locations to create site visit')]");

    public static final By WAIVE_THE_CREATE_SITE_YES_RADIO_BTN = By.xpath("//input[@value='true']");
    public static final By POPUP_SITEVISIT_DATE = By.xpath("//input[contains(@placeholder,'MM/DD/YYYY')]");
    //  public static final By POPUP_SITEVISIT_REASON = By.xpath("(//div[contains(@tabindex,'0')])[3]");
    // public static final By POPUP_SITEVISIT_REASON = By.xpath("(//div[contains(@role,'button')])[2]");
    public static final By POPUP_SITEVISIT_REASON = By.xpath("//div[contains(@id,'Select reason')]//../div");


    private String switchCase = "";


    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public CocsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CocsPage() {
        super();
    }

    public void verifySearchResult() {
        checkSearchResult("Request status", "Approved", searchResultText, tableInfo);
    }

    /**
     * This method clicks the CoC tab and verifies the labels and npi displayed
     **/
    public void verifyCoCTopSectionLabelsAsProvider(String npi, String firstName, String lastName) {

        //navigate to the COC menu tab
        ajaxClick(coc_menu_tab);
        javaWaitSec(5);
        //get the top section labels
        List<WebElement> listOfLabels = driver.findElements(coc_top_section_labels);
        javaWaitSec(5);
        ArrayList<String> labels = new ArrayList<String>();
        int noOfLabels = listOfLabels.size();
        Reports.log("Number Of Labels Displayed on Top Section panel is: " + noOfLabels);
        javaWaitSec(5);
        for (int i = 0; i < noOfLabels; i++) {
            labels.add(listOfLabels.get(i).getText());
        }
        Reports.log("Displayed Top Section Labels are:" + labels);
        softAssert.assertTrue(labels.contains(Data.TITLE_NPI), "NPI label is Not displayed");
        Reports.log("NPI Label is displayed");
        javaWaitSec(5);
        System.out.println("npi is " + driver.findElement(coc_npi).getText());
        Assert.assertEquals(driver.findElement(coc_npi).getText(), npi);
        softAssert.assertTrue(labels.contains(Data.TITLE_REVALIDATION_DUE_DATE), "Revalidation Due Date label is Not displayed");
        Reports.log("Revalidation Due Date is displayed");
        javaWaitSec(5);
        Reports.log(driver.findElement(coc_provider_name).getText());
        javaWaitSec(5);
        //get the provider name and assert
        String provider_name = driver.findElement(coc_provider_name).getText();
        Assert.assertEquals(provider_name, firstName + " " + lastName);
        softAssert.assertAll();

    }

    /**
     * This method clicks the CoC tab as Internal User and verifies the search parameters
     **/
    public void verifyIUCoCSearchFields() {
        //navigate to the COC menu tab
        ajaxClick(coc_menu_tab);
        javaWaitSec(5);
        //verify the npi in search criteria
        Assert.assertTrue(verifyThatElementIsDisplayed(coc_iu_search_label_npi));
        driver.findElement(By.xpath("//label[contains(text(),'NPI')]/ancestor::div[@class='search-box-i']")).click();
        javaWaitSec(2);
        Assert.assertTrue(verifyThatElementIsDisplayed(coc_iu_input_npi));
        // verify FEIN/SSN is displayed in search criteria
        Assert.assertTrue(verifyThatElementIsDisplayed(coc_iu_search_label_ssn));
        driver.findElement(By.xpath("//label[contains(text(),'FEIN/SSN')]/ancestor::div[@class='search-box-i']")).click();
        javaWaitSec(2);
        Assert.assertTrue(verifyThatElementIsDisplayed(coc_iu_input_ssn));
        // verify Assignee is displayed in search criteria
        Assert.assertTrue(verifyThatElementIsDisplayed(coc_iu_search_label_assignee));
        driver.findElement(By.xpath("//label[contains(text(),'Assignee')]/ancestor::div[@class='search-box-i']")).click();
        javaWaitSec(2);
        Assert.assertTrue(verifyThatElementIsDisplayed(coc_iu_input_assignee));

    }

    /**
     * This method navigates to the CoC tab and clicks CoC
     **/
    public void navigateAndClickCoC() {
        //navigate to the COC menu tab
        ajaxClick(coc_menu_tab);
        javaWaitSec(2);
        Reports.log("Click on Coc main Tab ");
        clickAnyButton(Data.TEXT_ADD_COC);
    }


    /**
     * This method Selects Program Participation Radio Btn on COC popup
     **/
    public void selectProgramParticipationRadioBtn() {
        //navigate to the COC menu tab
        ajaxClick(COC_PROGRAM_PARTICIPATION_RADIO_BTN);
        javaWaitSec(1);
        Reports.log("Select Program Participation Radio Btn ");
        clickAnyButton(Data.TEXT_ADD_COC);
    }


    /**
     * This method creates the CoC based on the Enrollment Type and type of the CoC
     *
     * @param enrollmentType
     * @param cocType
     */
    public void createCoCBasedOnEnrollmentType(String enrollmentType, String cocType) {
        javaWaitSec(2);
        if (enrollmentType.contains("pem") || enrollmentType.contains("Individual") || enrollmentType.contains("group") || enrollmentType.contains("facility")) {
            javaWaitSec(5);
            ajaxClick(driver.findElement(Locators.POP_UP_DOCUMENT).findElement(setLocatorOfAnyButton(Data.TEXT_NEXT)));
        }
        javaWaitSec(3);
        clickAnyButton(cocType);
        if (enrollmentType.contains("pem") || enrollmentType.contains("Individual") || enrollmentType.contains("group") || enrollmentType.contains("facility")) {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE));
            clickAnyButton(Data.TEXT_CREATE);
            //else if is needed because the 'Create CoC' button contains spaces when Ownership or Program Participation
            //CoC option is selected
        } else if (enrollmentType.contains(Data.pharmacyApplication) || enrollmentType.contains(Data.orpApplication) &&
                (cocType.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP) ||
                        cocType.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN))) {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE_COC_SPACED));
            clickAnyButton(Data.TEXT_CREATE_COC_SPACED);
        } else {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE_COC));
            clickAnyButton(Data.TEXT_CREATE_COC);
        }
    }

    /**
     * This method adds an entry to the EFT and submits the CoC.
     */
    public void submitCoCForEFT() {
        closeAlert();
//        ajaxClick(FIN_INST_INPUT);

        javaWaitSec(20 );
        driver.findElement(By.xpath("(//span[@class='assist-table-ico'])[1]")).click();
        javaWaitSec(5);
        doublePerformClick(EFT_FINANCIAL_INSTITUTION);
        javaWaitSec(2);
        clearContent(driver.findElement(EFT_FINANCIAL_INSTITUTION));
//        driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(generateRandomString());
        driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(generateInstitutionName());

        driver.findElement(EFT_FINANCIAL_INSTITUTION).sendKeys(Keys.TAB);
        javaWaitSec(5);
        fillInCalendar(getCurrentDate(), Data.START_DATE);
        driver.findElement(By.xpath("//label[text()='" + Data.START_DATE + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(TAB);
        javaWaitSec(5);
        setAndFindButton(Data.TEXT_SAVE).click();
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        javaWaitSec(2);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        javaWaitSec(2);
        ajaxClick(setAndFindButton(Data.TEXT_SUBMIT));
        javaWaitSec(20);

    }

//    /**
//     * This method selects options from CoC category list
//     *
//     * @param option1
//     * @param option2
//     */
//    public void selectCoCFromCategorySelection(String option1, String option2) {
////        closeAlert();
////        ajaxClick(driver.findElement(Locators.POP_UP_DOCUMENT).findElement(setLocatorOfAnyButton(Data.TEXT_NEXT)));
////        javaWaitSec(3);
//        clickAnyButton(option1);
//        clickAnyButton(option2);
//        javaWaitSec(1);
//        ajaxScroll(setAndFindButton(Data.TEXT_CREATE));
//        ajaxClick(setAndFindButton(Data.TEXT_CREATE));
//        javaWaitSec(2);
//    }

    public void clickNextButtonOnCOCPopUP(){
        closeAlert();
        ajaxClick(driver.findElement(Locators.POP_UP_DOCUMENT).findElement(setLocatorOfAnyButton(Data.TEXT_NEXT)));
        javaWaitSec(3);
        Reports.log("Clicked on Next button on CoC pop-up window");
    }

    /**
     * This method selects options from CoC category list
     *
     * @param option
     */
    public void selectCoCFromCategorySelection(String option) {
        javaWaitSec(3);
        clickAnyButton(option);
        Reports.log("Selected Coc category: "+option);

    }

    /**
     * This method selects options from CoC category list
     *
     * @param obj
     */
    public void selectCoCFromCategorySelection(Object... obj) {
        javaWaitSec(3);
        for(int i= 0; i<obj.length;i++) {
            String category = String.valueOf(obj[i]);
            ajaxClick(setAndFindButton(category));
            javaWaitSec(1);
            Reports.log("Selected Coc category: " + category);
        }
    }

    public List<String> getCocCategoryList(String... list) {
        List<String> category = new ArrayList<String>();
        javaWaitSec(3);
        for (int i = 0; i < list.length; i++) {
            String categoryType = String.valueOf(list[i]);
            category.add(categoryType);
        }
        Reports.log("Coc category list : " + category);
        return category;
    }

    public void clickCreateCocButton(){
        javaWaitSec(1);
        ajaxScroll(setAndFindButton(Data.TEXT_CREATE));
        ajaxClick(setAndFindButton(Data.TEXT_CREATE));
        Reports.log("Clicked on Create button on CoC pop-up window");

    }

    /**
     * This method Fills in classification section
     */
    public void coCClassificationSection() {
        ajaxClick(CLASSIFICATION_SECTION);
        driver.findElement(SOFTWARE_VENDOR_NAME).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), Data.SOFTWARE_VENDOR);
        javaWaitSec(1);
        driver.findElement(SOFTWARE_NAME).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), Data.SOFTWARE_NAME);
        javaWaitSec(1);
        String versionID = generateNewNumber(3);
        driver.findElement(VERSION_ID).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), versionID);
        javaWaitSec(2);
        driver.findElement(ENTITY_FIELD).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(2);
        ajaxClick(ENTITY_FIELD);
        ajaxClick(setSpecificStrongOptionInListbox(Data.ENTITY_OPTION));
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
    }

    /**
     * This method Fills in Identifying Information section
     */
    public void coCIdentifyingInformationSection() {
        javaWaitSec(1);
        driver.findElement(IDENTIFYING_INFORMATION).click();
        javaWaitSec(1);
        cocAddressDetails();
    }


    /**
     * This method Fills in Identifying Information section
     */
    public void cocGeneralInfoIdentifyingInformationSection() {
        javaWaitSec(3);
        driver.findElement(IDENTIFYING_INFORMATION).click();
        javaWaitSec(1);
        //Changing the Middle Name
        String MiddleName = generateNewWord();
        driver.findElement(TEXT_FIELD_MIDDLE_NAME_PROVIDER).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), MiddleName);
        javaWaitSec(2);
        driver.findElement(TEXT_FIELD_Last_NAME_PROVIDER).click();
        javaWaitSec(1);
        Reports.log("Changing Middle name: "+MiddleName);
    }



    public void cocAddMedicareDetailsProviderIdentifierSection() {
        ajaxClick(SECTION_PROVIDER_IDENTIFIERS);
        javaWaitSec(1);
        Reports.log("Adding Participant Medicare ");
        ajaxClick(PARTICIPANT_MEDICARE_RADIO_BTN_YES);
        Reports.log("Select value in Medicare radio-button: Yes ");
        ajaxClick(PARTICIPANT_MEDICARE_ADD_LINE_BUTTON);
        javaWaitSec(5);
        Reports.log("Clicked on Add Line Button");

        String medicalId =medicalID() ;
        ajaxSendKeys(PARTICIPANT_MEDICARE_ID_INPUT, medicalId);
        Reports.log("Entered Medical Id: "+medicalId);
        fillInCalendar(getCurrentDate(), Data.effectiveDate);
        Reports.log("Entered Effective Start Date "+getCurrentDate());
        fillInCalendar(getCurrentDate()+60, Data.endDateCalendar);
        Reports.log("Entered End Date "+getCurrentDate()+60);

        ajaxClick(setAndFindButton(Data.TEXT_SAVE));
        javaWaitSec(2) ;
    }

    /**
     *  This method fills the Identifying Information tab using a specified list of fields
     *
     * @param obj List if fields to be updated
     */
    public void cocUpdateIdentifyingInformationFields(Object... obj) {

        String newValue = null;
        String xpathIdentifier = null;
        String webSiteName;

        javaWaitSec(1);
        driver.findElement(IDENTIFYING_INFORMATION).click();
        javaWaitSec(1);

        for (Object o : obj) {

            String fieldIdentifier = String.valueOf(o);

            switch (fieldIdentifier) {
                case IDENTIFYING_INFO_FIELD_FIRST_NAME:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_FIRST_NAME;
                    newValue = generateFirstName();
                    break;
                case IDENTIFYING_INFO_FIELD_MIDDLE_NAME:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_MIDDLE_NAME;
                    newValue = generateFirstName();
                    break;
                case IDENTIFYING_INFO_FIELD_LAST_NAME:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_LAST_NAME;
                    newValue = generateLastName();
                    break;
                case IDENTIFYING_INFO_FIELD_PHONE:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_PHONE;
                    newValue = generateNewNumber(10);
                    break;
                case IDENTIFYING_INFO_FIELD_FAX:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_FAX;
                    newValue = generateNewNumber(10);
                    break;
                case IDENTIFYING_INFO_FIELD_WEBSITE:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_WEBSITE;
                    webSiteName = generateDBABusiness();
                    newValue = "https://" + webSiteName + ".com/";
                    break;
                case IDENTIFYING_INFO_FIELD_ALT_EMAIL:
                    xpathIdentifier = IDENTIFYING_INFO_XPATH_ALT_EMAIL;
                    newValue = generateEmail("alt.test.provider", "gmail.com");
                    break;
            }

            driver.findElement(By.xpath(xpathIdentifier)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), newValue);
            driver.findElement(By.xpath(xpathIdentifier)).sendKeys(Keys.TAB);
            javaWaitSec(2);
            Reports.log("Changed " + fieldIdentifier + " field to: " + newValue + "\n");
        }
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
    }

    /**
     *  This method fills the Address Details Information tab using a specified list of fields
     *
     * @param obj List if fields to be updated
     */
    public void cocUpdateAddressDetailsFields(Object... obj) {

        String newValue = null;
        String xpathIdentifier = null;

        javaWaitSec(1);
        ajaxClick(SECTION_PROVIDER_ADDRESS_DETAILS);
        javaWaitSec(1);

        for (Object o : obj) {

            String fieldIdentifier = String.valueOf(o);

            switch (fieldIdentifier) {
                case ADDRESS_DETAILS_FIELD_ATTENTION:
                    xpathIdentifier = ADDRESS_DETAILS_XPATH_ATTENTION;
                    newValue = generateFirstName() + " " + generateLastName();
                    break;
                case ADDRESS_DETAILS_FIELD_EMAIL:
                    xpathIdentifier = ADDRESS_DETAILS_XPATH_EMAIL;
                    newValue = generateEmail("alt.test.provider", "gmail.com");
                    break;
            }

            driver.findElement(By.xpath(xpathIdentifier)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), newValue);
            driver.findElement(By.xpath(xpathIdentifier)).sendKeys(Keys.TAB);
            javaWaitSec(2);
            Reports.log("Changed " + fieldIdentifier + " field to: " + newValue+"\n");
        }
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
    }

    /**
     * This method Fills in Identifying Information section
     */
    public void cocMailingContactDetailsOfAddressDetailsSection(String firstName, String lastName) {
        javaWaitSec(1);
        ajaxClick(SECTION_PROVIDER_ADDRESS_DETAILS);
        javaWaitSec(1);
        String attentionLine =  firstName+" "+lastName;

        driver.findElement(TEXT_FIELD_CONTACT_ATTENTION_LINE).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), attentionLine);
        driver.findElement(TEXT_FIELD_Email_PROVIDER).click();
        javaWaitSec(1);
        Reports.log("Changed Attention Line to: " +attentionLine);

        ajaxClick(setAndFindButton(Data.TEXT_NEXT));

    }



    /**
     * This method Fills in Identifying Information section
     */
    public void cocOwnerShipSection() {
        String legalBusinessName = generateLegalBusiness();
        String businessDBA = generateDBABusiness();
        String zipCode = getRandomStringFromFile("SDZip");

        javaWaitSec(1);

        driver.getWindowHandle();
        ajaxClick(setAndFindButton("No"));
        Reports.log("Do you need to do add a New Owner, end date an Existing Owner, or change the Legal name, Tax Identifier, Relationship," +
                " or Percentage of an Existing Owner?");
        Reports.log("Selected No");
        javaWaitSec(1);

        Reports.log("\nFill in Ownership Section");
        ajaxClick(YES_RADIOBUTTON_OWNERSHIP_OWNERSHIP_ENTITY);

        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");


        driver.findElement(INPUT_FEILD_LEGAL_BUSINESS_NAME).sendKeys(legalBusinessName);
        Reports.log("Entered Legal Business Name: " + legalBusinessName);

        driver.findElement(INPUT_FEILD_DBA).sendKeys(businessDBA);
        Reports.log("Entered DBA: " + businessDBA);

        driver.findElement(INPUT_FEILD_FEIN_NUMBER).sendKeys( Data.fein);
        Reports.log("Entered FEIN: " +  Data.fein);

//        selectFirstOptionInDropdown(OWNERSHIP_SELECT_PROGRAM);
        driver.findElement(OWNERSHIP_SELECT_PROGRAM).click();
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.MEDICARE));

        fillInCalendar(getCurrentDate(), Data.effectiveDate);

        Reports.log("Type Address line1: " + Data.physicalAddress);
        driver.findElement(TEXT_FIELD_ADDRESS1).sendKeys(Data.physicalAddress);

        Reports.log("Type City: " +  Data.city);
        setFieldValueWithTabAndWait(TEXT_FIELD_CITY,  Data.city);

        Reports.log("Type zip code: " +  zipCode);
        setFieldValueWithTabAndWait(TEXT_FIELD_ZIP_CODE, zipCode);

        Reports.log("Type County Code: " + Data.countyCodeSD);
        setFieldValueWithTabAndWait(TEXT_COUNTY_CODE, Data.countyCodeSD);

        driver.findElement(DROP_DOWN_ADDRESS_STATE).click();
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.SOUTH_DAKOTA));

        Reports.log("Select mailing state: " + Data.SOUTH_DAKOTA);

        ajaxClick(setAndFindButton(Data.TEXT_SAVE));
        javaWaitSec(2);

        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
    }

    /**
     * This method changes the Primary Service Location
     */
    public void cocPrimaryServiceLocationSection() {
        javaWaitSec(1);
        Reports.log("Fill in Primary Service Location Section");
        ajaxClick(SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION);
        javaWaitSec(1);
        driver.findElement(ADDRESS_LINE_2).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), generateNewNumber(5));
        driver.findElement(ADDRESS_LINE_2).sendKeys(Keys.TAB);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));

    }

    /**
     * This method changes the Taxonomy Section
     */
    public void cocTaxonomySection() {
        javaWaitSec(1);
        Reports.log("Taxonomy License Section");
        ajaxClick(SECTION_TAXONOMY);
        javaWaitSec(2);
        ajaxScrollDown();
        driver.findElement(DEA_NUM).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), "AS"+generateNewNumber(7));
        driver.findElement(DEA_NUM).sendKeys(Keys.TAB);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));

    }

    public static final By LICENSE_NUMBER_INPUT = By.xpath("//input[contains(@id,'lNum')]");
    public static final By LICENSE_EFFECTIVE_START_DATE = By.xpath("(//label[contains(text(),'Effective start Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY'])");
    public static final By LICENSE_EFFECTIVE_END_DATE = By.xpath("(//label[contains(text(),'Effective end Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY'])");
    public static final By ADD_BUTTON = By.xpath("(//div[contains(@class, 'programParticipation')]//span[contains(.,'Add')])[2]");
    public static final By PROGRAM_PARTICIPATION_SAVE_BUTTON = By.xpath("(//span[contains(.,'Save')])[2]");

    /**
     * This method changes the Taxonomy Section
     */
    public void cocProgramParticipationSection() {
        String license = generateALicenses();

        javaWaitSec(1);
        Reports.log("Click on Program Participation Section");
        ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
        javaWaitSec(1);

        ajaxClick(ELLIPTICAL_PROVIDER_PROGRAM_PARTICIPATION);
        javaWaitSec(1);
        Reports.log("Click on Elliptical button");

        ajaxClick(ELLIPTICAL_EDIT_MENU_ITEM);
        javaWaitSec(1);
        Reports.log("Clicked on Edit button from the list ");

        ajaxClick(EDIT_BTN_WITH_INDEX_TWO);
        javaWaitSec(1);
        Reports.log("Clicked on Edit button for Licences ");

        ajaxClick(LICENSE_NUMBER_INPUT);
        driver.findElement(LICENSE_NUMBER_INPUT).clear();
        javaWaitSec(1);
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

        ajaxClick(LICENSE_NUMBER_INPUT);
        ajaxSendKeys(LICENSE_NUMBER_INPUT,license);
//        driver.findElement(LICENSE_NUMBER_INPUT).sendKeys(license);
        Reports.log("Typed License Number: " + license);
        javaWaitSec(2);
//        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

        ajaxSendKeys(LICENSE_NUMBER_INPUT,Data.LICENSE_NUMBER);
        ajaxClear(LICENSE_EFFECTIVE_START_DATE);
        fillInCalendar(changeDayInCurrentDate(2), Data.EFFECTIVE_DATE_START, LICENSE_EFFECTIVE_START_DATE);
        javaWaitSec(2);

        ajaxClear(LICENSE_EFFECTIVE_END_DATE);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_END_DATE, LICENSE_EFFECTIVE_END_DATE);
        javaWaitSec(2);

        ajaxClick(ADD_BUTTON);
        javaWaitSec(1);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON);
    }


    /**
     * This method fills in address field
     */
    public void cocAddressDetails() {
        WebElement address = driver.findElement(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        ajaxClear(TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        address.sendKeys(Data.cocAddress2);
        javaWaitSec(5);
        ajaxClear(TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        address.sendKeys(Data.cocAddress2);
        javaWaitSec(10);
        List<WebElement> addressChange = driver.findElements(ADDRESS_LIST);
        for (WebElement ele : addressChange) {
            if (ele.getText().contains(Data.cocAddress2)) {
                Reports.log("Matching address");
                ajaxClick(ele);
                break;
            } else {
                Reports.log("No matching address");
            }
            javaWaitSec(3);
        }
        javaWaitSec(5);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
    }
    public void cocKeyPersonalSection(int index, String physicalAddress, String city, String mailingState, String countyCode) throws InterruptedException {
        javaWaitSec(5);
        Reports.log("\nFill in Key Personnel Section");
        ajaxClick(SECTION_PROVIDER_KEY_PERSONNEL);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        ajaxClick(TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
        Reports.log("Select Managing Employee Type");
        //clickAnyOptionInList(2);
        javaWaitSec(1);
        clickAnyOptionInList("Supervisor");
        ajaxScrollByCoordinate(100);
        ajaxClick(TEXT_FIELD_EMPLOYEE_STATUS);
       // clickAnyOptionInList(2);
        javaWaitSec(1);
        clickAnyOptionInList("Managing Convicted");
        ajaxScrollByCoordinate(100);
        ajaxClick(TEXT_FIELD_LICENSE_FIRST_NAME);
        ajaxScroll(TEXT_FIELD_LICENSE_FIRST_NAME);

        driver.findElements(TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(generateFirstName());
        javaWaitSec(1);
        driver.findElements(TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(generateLastName());
        javaWaitSec(1);
        String SSN= generateNewNumber(9);
        Reports.log("SSN: " + SSN);
        driver.findElements(TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(SSN);
        driver.findElement(TEXT_FIELD_COUNTRY_OF_BIRTH).click();
        ajaxClick(setSpecificStrongOptionInListboxSD("United States"));

        driver.findElement(DROP_DOWN_STATE_OF_BIRTH2).click();
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.SOUTH_DAKOTA));

        Reports.log("Selected a State of birth");

        String DOB= createRandomDates(-50, "MM/dd/yyyy");
        Reports.log("DOB: "+ DOB);
        fillInCalendar(DOB, Data.dateOfBirthCalendar2);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        String zipCode = getRandomStringFromFile("SDZip");
        Reports.log("New Zip: " + zipCode);
        fillInAddressDetails(physicalAddress, city, mailingState, zipCode, countyCode);

        setAndFindButton(Data.TEXT_SAVE).click();
    }

    public void fillInAddressDetails(String physicalAdress, String city, String mailingState, String zip, String countyCode) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(findAnyElement(TEXT_FIELD_ADDRESS)));

            Reports.log("Type physical address: " + physicalAdress);
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, physicalAdress);
        } catch (ElementNotInteractableException e) {
            setFieldValueWithTabAndWait(TEXT_FIELD_ADDRESS, physicalAdress);
        }

        Reports.log("Type City: " + city);
        setFieldValueWithTabAndWait(TEXT_ADDRESS_CITY, city);

        Reports.log("Type zip code: " + zip);
       setFieldValueWithTabAndWait(TEXT_FIELD_ZIP_CODE1, zip);
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
     * This method clicks on summery section and submits a coc
     */
    public void cocSummeryAndSubmit() {
        ajaxClick(Locators.SECTION_SUMMARY);
        Reports.log("Navigating to Summary Section");
        javaWaitSec(10);
        clickAnyButton(Data.TEXT_SUBMIT);
        Reports.log("Clicked on the Submit button");
        javaWaitSec(10);
    }

    /**
     * This method retrieves the CoC Request ID from a CoC request listed on the Change of Circumstance Request History
     *
     * @return CoC Request ID
     */
    public String getCoCID() {
        javaWaitSec(20);
        String cocID = driver.findElement(COC_ID).getText();
        Reports.log("Providers CoC Tracking Number:" + cocID);
        return cocID;
    }

    /**
     * This method verifies the red color of the text and clicks the results
     */
    public void verifyAndClickRedTextForSearchResultsCoCEFT() {
        javaWaitSec(5);
        Assert.assertTrue(findAnyElement(COC_REQUEST_RESULTS_RED_TEXT).getAttribute("style").contains("red"), "The text is red");
        ajaxClick(COC_REQUEST_RESULTS_RED_TEXT);
        javaWaitSec(10);
    }

    /**
     * This method verifies the download and the file downloaded
     */
    public void verifyDownloadCoCDoc() {
        Reports.log("Click on the Download button");
        ajaxClick(DOWNLOAD_BUTTON);
        javaWaitSec(2);
        try {
            File downloadFolder = new File(System.getProperty("user.dir") + File.separator + "DownloadFolder");
            File[] matches = downloadFolder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.contains("COC") && name.endsWith(".pdf");
                }
            });
            ;
            if (matches == null) {
                Reports.log("No file found....");
            } else {
                for (int i = 0; i < matches.length; i++) {
                    if (matches[i].renameTo(new File(System.getProperty("user.dir") + File.separator + "DownloadFolder" + File.separator + "CoCDocs" + File.separator + matches[i].getName()))) {
                        // if file copied successfully then delete the original file
                        matches[i].delete();
                        Assert.assertEquals(matches[i].getName().contains("COC"), "COC");
                        Reports.log("CoC Document downloaded successfully and saved at the location :" + matches[i]);
                    } else {
                        System.out.println("Failed to move the file");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method navigates to CoC and search for the CoC based on CoC ID
     */
    public void navigateToCoCAndSearch(String trackingNum) {
        IUEnrollmentPage iuEnrollmentpage = new IUEnrollmentPage(driver, wait);
        ajaxClick(COC_TAB);
        javaWaitSec(2);
        driver.findElement(TYPE_SEARCH_INPUT).sendKeys("EFT Info" + Keys.ARROW_DOWN, Keys.RETURN);
        Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'Type')]/parent::div/div/div/div/div")).getText(), "EFT Information");
        javaWaitSec(1);
        iuEnrollmentpage.searchProviderByTrackingNUm(trackingNum);
    }


    public static final By CHANGE_STATUS_POPUP_STATUS_DROPDOWN = By.xpath("//div[contains(@class, 'requests_popup-inner')]");
    public static final By CHANGE_STATUS_POPUP_REASON_DROPDOWN = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");
    public static final By COC_APPLICATION_STATUS_LABEL = By.xpath("(//span[contains(.,'Status')])[3]//following::div[contains(@class,'main-info-panel_value')]");

    /**
     * This method changes Status Of CoC Application
     *
     * @param givenStatus
     */
    public String changeStatusOfApplication(String givenStatus) {
        String applicationStatus = null;
        closeAlert();
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        javaWaitSec(2);
        performClick(CHANGE_STATUS_POPUP_STATUS_DROPDOWN);
        javaWaitSec(2);
        if (givenStatus.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
        }
        if (givenStatus.contains("Denied")) {
            clickAnyOptionInList(1);  // 0 Approved, 1 Denied

            driver.findElement(CHANGE_STATUS_POPUP_REASON_DROPDOWN).click();
            clickFirstOptionInList();
            javaWaitSec(2);
            clickAnyButton(Data.TEXT_APPLY);
            javaWaitSec(5);
            driver.navigate().refresh();
            javaWaitSec(7);

            ajaxClick(COC_APPLICATION_STATUS_LABEL);
            applicationStatus = driver.findElement(COC_APPLICATION_STATUS_LABEL).getText();
            Reports.log("Application Status: " + applicationStatus);
        }
        return applicationStatus;
    }

    /**
     * This method verifies the Status Of Application
     *
     * @param statusOfApplication
     */
    public void ChangeAndVerifyTheStatusOfApplication(String statusOfApplication) {
        javaWaitSec(5);
        String applicationStatus = changeStatusOfApplication(statusOfApplication);
        for (int i = 0; i < 3; i++) {
            try {
                applicationStatus = driver.findElement(COC_APPLICATION_STATUS_LABEL).getText();
                Reports.log("Application Status: " + applicationStatus);
                if (i != 3 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
                    Reports.log("Application Status is Still under : " + applicationStatus + " so trying to re-change the application status again  Attempt# " + i);
                    changeStatusOfApplication(statusOfApplication);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (applicationStatus.equalsIgnoreCase("SYNC_FAILED")) {
                    Reports.log("Application Status: SYNC_FAILED");
                    Assert.fail("Application Status: SYNC_FAILED");
                }
                Reports.log("Application Status is Still under " + applicationStatus + ", retrying Again. Attempt# " + i);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }

        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
    }

    /**
     * This method sets the status of enrollments that require a screening
     * @param Status
     * @param environmentUrl
     * @param trackingID
     */
    public void searchAndChangeStatusOFApplicationWithReason(String Status, String environmentUrl, String trackingID) {
        // searchSpecificEnrollmentAndClick(10, "PENDING APPROVAL");
        changeCocApplicationTo(Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        cocUnderScreen(environmentUrl, trackingID);
        javaWaitSec(10);
        changeStatusWithReason(Status);
    }

    /**
     * This method sets the status of enrollments that DO NOT require a screening
     * @param Status
     */
    public void searchAndChangeStatusOFApplicationWithReason(String Status) {
        searchSpecificEnrollmentAndClick(10, "PENDING APPROVAL");
        javaWaitSec(10);
        changeStatusWithReason(Status);
    }

    public void searchSpecificEnrollmentAndClick(int delay, String status1) {
        for (int i = 0; i < 10; i++) {
            Reports.log("Wait for" + delay + "seconds for application to load..");
            javaWaitSec(delay);
            Reports.log("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            try {
                driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText();
                try {
                    if (anyStatusOfEnrollment(status1).isDisplayed()) {
                        break;
                    }
                } catch (Exception e) {
                    Reports.log("Exception Found: " + e);
                }
                Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
            } catch (Exception e) {
                Reports.log("Request was not found");
            }
        }
//        javaWaitSec(10);
//        ajaxScroll(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW);
//        performClick(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW, 0);
        javaWaitSec(10);
        ajaxScrollUp();
        javaWaitSec(2);
        WebElement enrollment = driver.findElements(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        enrollment.click();
    }

    public void changeStatusWithReason(String statusOfApplication) {
        javaWaitSec(15);
        clickAnyButton(Data.optionChangeStatus);
        javaWaitSec(5);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();

        if (statusOfApplication.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
        } else if (statusOfApplication.contains("Denied")) {
            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        }
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        javaWaitSec(5);
        clickFirstOptionInList();
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(15);

        String applicationStatus = null;
        for (int j = 0; j < 2; j++)
            for (int i = 0; i < 10; i++) {
                try {
                    //  applicationStatus =  driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
                    applicationStatus = driver.findElement(By.xpath("(//span[contains(.,'Status')])[4]//following::div[contains(@class,'main-info-panel_value')]")).getText();

                    if (applicationStatus.equalsIgnoreCase(statusOfApplication) || applicationStatus.contains("SYNC FAILED")) {
                        break;
                    } else {
                        driver.navigate().refresh();
                        Reports.log("Application Status is Still under : " + applicationStatus + " so Refreshing the page");
                        javaWaitSec(5);
                        if (j != 2) {
                            if (i == 9 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
                                Reports.log("Application Status is Still under : " + applicationStatus + "so trying to re-change the application status again");
                                changeStatusWithReason(statusOfApplication);
                            }
                        }
                    }
                } catch (Exception e) {
                    Reports.log("Application Status is Still under" + applicationStatus);
                    driver.navigate().refresh();
                    javaWaitSec(10);
                }
            }
        javaWaitSec(15);
        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
        Reports.log("Application status is: " + applicationStatus);
    }

    public void navigateToCoCAndSearchForTheProvider(String trackingNum) {
        ajaxClick(COC_TAB);
        searchProvider(trackingNum);
    }

    /**
     * This method reviews and votes the enrollment
     * @param firstName
     * @param lastName
     */
    public void reviewAndVoteTheEnrollment(String firstName, String lastName) {
        try {
            javaWaitSec(15);
            ajaxScrollUp();
            clickAnyButton("Approve");
           // ajaxClick(POPUP_PENDING_REVIEW_REASON);

            javaWaitSec(2);
            driver.findElement(POPUP_PENDING_REVIEW_REASON).click();
           // clickAnyOptionInList(1);
            driver.findElement(By.xpath("//div//ul[@role='listbox']//li[text()='Consistent Billing History']")).click();
            javaWaitSec(4);
            ajaxClick(By.xpath("//textarea[@aria-invalid='false']"));
            driver.findElement(By.xpath("//textarea[@aria-invalid='false']")).sendKeys("Review Completed. Sanity Test for " + firstName + " " + lastName);
            javaWaitSec(2);
            Reports.log("Note Added: " + driver.findElement(By.xpath("//textarea[@aria-invalid='false']")).getText());
            clickAnyButton2("Approve", 1);
            javaWaitSec(5);
            ajaxScrollUp();
          driver.navigate().refresh();
           javaWaitSec(10);
        } catch (Exception e) {
            Reports.log("Exception " + e);
        }
    }


    public void searchProvider(String TrackingNumber) {
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(5);
        ajaxClick(TEXT_FIELD_REQUEST_ID);
        driver.findElement(TEXT_FIELD_REQUEST_ID).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ajaxClear(TEXT_FIELD_REQUEST_ID);
        driver.findElement(TEXT_FIELD_REQUEST_ID).sendKeys(TrackingNumber);
        Reports.log("Tracking Number: " + TrackingNumber);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        performClick(setAndFindButton(Data.TEXT_SEARCH));
    }

    public void waveSiteVisitOnCocPage(String textOfButton) {
        try {
            Reports.log("Verifying the Site Visit Button Visibility");
            clickAnyButton(textOfButton);
            Reports.log(textOfButton + " Button is available");
            Reports.log("Clicked on the " + textOfButton);
            javaWaitSec(2);

            driver.findElement(POPUP_SITEVISIT_SELECT_LOCATION_DROPDOWN).click();
            clickAnyOptionInList(0);
            javaWaitSec(2);
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

            ajaxScroll(POPUP_SITEVISIT_DATE);
            ajaxClick(WAIVE_THE_CREATE_SITE_YES_RADIO_BTN);
            Reports.log("Do you want to waive the Site Visit?, Selected Yes ");
            javaWaitSec(1);
            driver.findElement(POPUP_SITEVISIT_REASON).click();
            javaWaitSec(2);
            List<WebElement> elements = driver.findElements(By.xpath("(//li[@role='option'])"));
            ajaxClick(elements.get(2));
            Reports.log("Selected a Waive Reason ");
            javaWaitSec(3);
            ajaxClick(By.xpath("//button[contains(.,'Ok')]"));
            Reports.log("Clicked on the Ok button");
            javaWaitSec(5);
            Reports.log("Successfully Waived the Site Visit");

        } catch (Exception e) {
            Reports.log("\nCreate Site Visit Button is not available");
        }
    }

    public void changeCocApplicationTo(String currentStatus, String statusDropDownValue) {
        Reports.log("\nChanging Enrollment status from " + currentStatus + " to " + statusDropDownValue);
//        searchSpecificEnrollmentAndClick(20, currentStatus);
        javaWaitSec(10);
        String applicationStatus = getCocApplicationStatus();
        Reports.log("Current application Status Application status is: " + applicationStatus);
        javaWaitSec(10);
        if (statusDropDownValue.equalsIgnoreCase(applicationStatus)) {
            return;
        } else {
            clickAnyButton(Data.optionChangeStatus);
            javaWaitSec(20);
            driver.findElement(POPUP_CHANGE_STATUS).click();
            clickAnyOptionInList(statusDropDownValue);
            javaWaitSec(20);
            if (statusDropDownValue.equalsIgnoreCase(Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED ) ||statusDropDownValue.equalsIgnoreCase(Data.DROPDOWN_VALUE_UNDER_SCREENING) || statusDropDownValue.equalsIgnoreCase(Data.ApplicationStatusApprove)
                    || statusDropDownValue.equalsIgnoreCase(Data.REQUESTED_ADDITIONAL_INFORMATION)) {
//                ajaxClick(BUTTON_APPROVE_REASON);
//                clickFirstOptionInList();
                driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
                javaWaitSec(2);
//        jsClick("//label[contains(text(), 'Reason')]/following::div[@role='button']");
//        javaWaitSec(2);
                Reports.log("Enter the reason ");
                jsClick("(.//ul[@role='listbox']/li)[1]");
                javaWaitSec(2);
            }
            clickAnyButton(Data.TEXT_APPLY);
            javaWaitSec(2);
            driver.navigate().refresh();
            javaWaitSec(10);
            applicationStatus = getCocApplicationStatus();
            Reports.log("Now Application status has changed to: " + applicationStatus);
        }
    }

//    /**
//     * This method gets application status
//     *
//     * @return
//     */
//    public String getApplicationStatus() {
//        String applicationStatus = driver.findElement(STATUS_ENROLLMENT_DETAILS).getText();
//        //Reports.log("Current Application Status :" + applicationStatus);
//        return applicationStatus;
//    }

    /**
     * This method gets application status
     *
     * @return
     */
    public String getCocApplicationStatus() {
        javaWaitSec(20);
        String applicationStatus = driver.findElement(COC_STATUS_DETAILS).getText();
        //Reports.log("Current Application Status :" + applicationStatus);
        javaWaitSec(1);
        return applicationStatus;
    }

    public void cocUnderScreen(String environmentUrl, String trackingNum) {
        Reports.log("\nEnrollment is under screening");
        String cookies = collectCookies(environmentUrl.replace("https://", ""));
        int id = Integer.valueOf(trackingNum);
        replaceRequestIdInScreeningFile(id, Data.screeningFile100);
        Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
        screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(15);
        driver.navigate().refresh();
        javaWaitSec(15);
    }

    // TODO:Need to update more once the VYE screening get into scope for COC's
//    /**
//     * This method does Under Screening based on the selected ScreeningType(i.e, Automatic, Manual, Transmit)
//     *
//     * @param environmentUrl
//     * @param firstName
//     * @param lastName
//     * @param trackingNum
//     */
//    public void performCoCScreening(String screeningType, String environmentUrl, String firstName, String lastName, String trackingNum, String status) {
//        switch (screeningType) {
//            case "VYE":
//                Reports.log("\nScreening is handled through VYE");
//                Boolean isScreeningSuccessful = isVYEScreeningSuccessful(firstName, lastName, status, trackingNum, 30);
//                if (isScreeningSuccessful) {
//                    javaWaitSec(2);
//                    downloadScreeningDocument();
//                    javaWaitSec(2);
//                    break;
//                } else {
//                    Assert.fail("Time out Waiting for the application to finish the Screening");
//                }
//
//            case "API":
//                Reports.log("\nScreening is handled through API");
//                String cookies = collectCookies(environmentUrl.replace("https://", ""));
//                int id = Integer.valueOf(trackingNum);
//                replaceRequestIdInScreeningFile(id, Data.screeningFile100);
//                Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
//                screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
//                javaWaitSec(2);
//                driver.navigate().refresh();
//                break;
//
//            case "VYE_TO_API":
//                Reports.log("\nScreening is handled through VYE");
//                Boolean isVYEScreeningSuccessful = isVYEScreeningSuccessful(firstName, lastName, status, trackingNum, 30);
//                String enrollmentStatus = null;
//                if (isVYEScreeningSuccessful) {
//                    javaWaitSec(2);
//                    downloadScreeningDocument();
//                    javaWaitSec(2);
//                } else {
//                    Reports.log("\nScreening is handled through API");
//                    String cookies1 = collectCookies(environmentUrl.replace("https://", ""));
//                    int requestID = Integer.valueOf(trackingNum);
//                    replaceRequestIdInScreeningFile(requestID, Data.screeningFile100);
//                    Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
//                    screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies1);
//                    javaWaitSec(2);
//                    driver.navigate().refresh();
//                    break;
//                }
//                break;
//        }
//    }


    public static void replaceRequestIdInScreeningFile(int requestId, String screeningFile) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).contains("<Request id=")) {
                    allLines.set(i, "        <Request id=\"" + requestId + "\">");
                }
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (i > 0) {
                    out.newLine();
                }
                out.write(allLines.get(i));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void screening(String screeningFile, String screeningEndpoint, String cookies) {
        System.out.println(screeningEndpoint);
        // String fullCookies = "auth_token="+ cookies;
        System.out.println(cookies);
        given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "multipart/form-data")
                .cookie("auth_token", cookies)

                .multiPart(new File(screeningFile))
                .when()
                .post(screeningEndpoint)
                .then()
                .statusCode(200);
    }
    public void navigateToCoC() {
        //navigate to the COC menu tab
        ajaxClick(coc_menu_tab);
        javaWaitSec(2);
        Reports.log("Click on Coc main Tab ");
        javaWaitSec(10);
    }
    public void verifyCocApplicationStatus(String cocApprovedStatus) {
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(20);
        String cocStatus=driver.findElement(By.xpath("(//p[@class='sc-caSCKo eSEEbi'])[1]")).getText();
        if(cocStatus.equals(cocApprovedStatus)){
            System.out.println("COC status is:"+cocStatus);
        }
        else{
            driver.navigate().refresh();
            javaWaitSec(10);
        }

    }

    public void downloadScreeningDocument() {
        driver.findElement(By.xpath("(//span[contains(.,'Screening')])[5]")).click();
        javaWaitSec(2);
        Reports.log("Click on the Provider Screening Tile");
        driver.findElement(By.xpath("//a[contains(.,'Download Screening Proof Document')]")).click();
        javaWaitSec(5);
        Reports.log("Click on the Download Screening Proof Document button");
        File downloadFolder = new File(System.getProperty("user.dir") + File.separator + "DownloadFolder");
        File[] matches = downloadFolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("screening_proof_document") && name.endsWith(".pdf");
            }
        });
        ;
        if (matches == null) {
            Reports.log("No file found....");
        } else {
            for (int i = 0; i < matches.length; i++) {
                if (matches[i].renameTo(new File(System.getProperty("user.dir") + File.separator + "DownloadFolder" + File.separator + "ProofDocuments" + File.separator + matches[i].getName()))) {
                    // if file copied successfully then delete the original file
                    matches[i].delete();
                    Reports.log("Screening Proof Document downloaded successfully and Save at location :" + matches[i]);
                } else {
                    System.out.println("Failed to move the file");
                }
            }
        }
    }
}












