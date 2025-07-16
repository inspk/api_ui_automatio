package com.hhstechgroup.Pages;
import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IUMCOPage extends BaseActions {


    protected WebDriver driver;
    protected WebDriverWait wait;
    private ProviderEnrollingPage providerEnrollingPage; // Moved to instance variable


    public IUMCOPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        this.providerEnrollingPage = new ProviderEnrollingPage(driver, wait); // Initialize here
    }


//    public IUMCOPage(WebDriver driver, WebDriverWait wait) {
//    }


    public static final By ADD_MCU_BUTTON = By.xpath("//i[contains(@class, 'icon_white_Phs1r')]");
    public static final By MCU_CLICK_BUTTON = By.xpath("//a[contains(@href, '/mco') and contains(text(), 'MCO')]");
    public static final By PLAN_LEGAL_NAME = By.xpath("//input[contains(@aria-label,'Plan Legal Name')]");
    public static final By IDENTIFIER_INFO_TAB = By.xpath("//div[contains(@class, 'menu-item') and contains(@class, 'active')]//span[contains(text(), 'Identifying Information')]");


    public static final By FEIN_NUM = By.xpath("//input[contains(@class, 'MuiInputBase-input') and contains(@placeholder, '__-_______')]");
    public static final By TAX_ENTITY_TYPE = By.xpath("//input[contains(@name,'Tax Entity Type')]");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_NAME = By.xpath("//input[contains(@aria-label, 'Contact Name')]");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_NUM = By.xpath("//input[contains(@placeholder, '(___)') and contains(@class, 'MuiInputBase-input')]");
    public static final By TEXT_FIELD_APPLICATION_CONTACT_EMAIL = By.xpath("//input[contains(@aria-label, 'email')]");
    public static final By NEXT_BUTTON = By.xpath("//button[contains(@class, 'newColorButton') and .//span[contains(text(), 'Next')]]");


    public static final By SECTION_PROVIDER_PROGRAM_PARTICIPATION = By.xpath("//div[contains(@class, 'menu-item')]//span[contains(text(), 'Taxonomy')]");


    public static final By PROGRAM_PARTICIPATION_SAVE_BUTTON2 = By.xpath("(//button[contains(@class, 'MuiButton') and .//span[contains(text(), 'Save')]])[2]");


    public static final By ADD_LOCATION_BUTTON = By.xpath("//button[contains(@class, 'MuiButton') and .//span[contains(text(), 'Add Location')]]");


    public static final By ADD_REGION_BUTTON = By.xpath("//button[contains(@class, 'MuiButton') and .//span[contains(text(), 'Add Region')]]");


    public static final By ADD_REGION_DROPDOWN = By.xpath("//div[contains(@class, 'MuiSelect') and contains(@id, 'Select Region')]");


    public static final By SAVE_ADD_REGION = By.xpath("(//span[text()='Save']/ancestor::div[contains(@class, 'MuiDialogActions-root')]//button[.//span[text()='Save']])[2]");


    public static final By SELECT_OWNERSHIP_CODE_INPUT = By.xpath("//input[contains(@aria-label, 'Select Ownership Code')]");


    public static final By SECTION_OWNERSHIP = By.xpath("//div[contains(@class, 'menu-item') and .//span[text()='Ownership']]");


    public static final By NO_RADIO_BUTTON_ARE_THERE_ANY_OWNERR_QUS_2 =
            By.xpath("//input[@name[contains(., 'Are there any owners with less than 5%')] and @value='No']");


    public static final By NO_RADIO_BUTTON_DOES_ANY_PERSION_HAVE_QUS_3 =
            By.xpath("//input[@name[contains(., '3. Does any person have a 5% or greater ownership or control interest')] and @value='No']");


    public static final By NO_RADIO_BUTTON_DOES_ANY_ENTITY_HAV_QUS_4 =
            By.xpath("//input[@name[contains(., '4. Does any entity have a 5% or greater ownership or')] and @value='No']");


    public static final By NO_RADIO_BUTTON_DOES_ANY_PERSION_OR_ENTITY_HAVE_QUS_5 =
            By.xpath("//input[@name[contains(., '5. Does any person or entity have a 5% or')] and @value='No']");


    public static final By NO_RADIO_BUTTON_HAS_THE_ENROLLING_PROVIDER_QUS_6 =
            By.xpath("//input[@name[contains(., '6. Has the enrolling provider contracted or delegated any of its management')] and @value='No']");


    public static final By NO_RADIO_BUTTON_DO_ANY_IMMEDIATE_FAMILY_MEMBER_QUS_7 =
            By.xpath("//input[@name[contains(., '7. Do any immediate family members of')] and @value='No']");


    public static final By NO_RADIO_BUTTON_DOES_THE_ENROLLING_PROVIDER_OR_ITS_OWNER_QUS_8 =
            By.xpath("//input[@name[contains(., '8. Does the enrolling provider or its owners have any ownership or control')] and @value='No']");


    public static final By SECTION_PROVIDER__SERVICE_LOCATION =
            By.xpath("//div[contains(@class, 'menu-item') and contains(@data-tip, 'true')][.//span[contains(text(), 'Service Location')]]");


    public static final By ADD_REGION_DD_OPTION =
            By.xpath("//li[contains(@class, 'MuiMenuItem-root') and contains(text(), 'Region A')]");


    public static final By BILLING_ADDRESS =
            By.xpath("//input[contains(@name, 'Is Billing Address is same as the Home/Corp Office Address?') and @type='radio' and @value='Yes']");


    public static final By BILLING_ADDRESS_CONTACT_PERSON =
            By.xpath("//input[contains(@name, 'Is Billing Address Contact person details is same as the Home/Corp Office Address Contact') and @type='radio' and @value='Yes']");


    public static final By TEXT_FIELD_COUNTRY_OF_BIRTH =
            By.xpath("//label[contains(., 'Country Of Birth')]//ancestor::div[contains(@class, 'sc-bxivhb')]//div[@role='button']");


    public static final By DROP_DOWN_ADDRESS_STATE =
            By.xpath("//label[(text() ='State ')]//following::div[@role='button']");


    public static final By TEXT_FIELD_ZIP_CODE =
            By.xpath("//div[contains(@data-for, 'Zip code')]//input[@type='text']");


    public static final By GET_FIRST_NAME_TEXT =
            By.xpath("//input[@aria-label='First Name']");


    public static final By LINK_DASHBOARD =
            By.xpath("//span[contains(text(), 'Go to MCO')]");


    public static final By PROVIDER_NAME_ID =
            By.xpath("//input[@id='ProviderID']");


    public static final By SEARCH_BUTTON =
            By.xpath("//button[.//span[text()='Search']]");


    public static final By TAXONOMY_EFFECTIVE_START_DATE =
            By.xpath("//label[contains(text(),'Effective Start Date *')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");


    public static final By TAXONOMY_EFFECTIVE_END_DATE =
            By.xpath("//label[contains(text(),'Effective End Date')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']");
//    ProviderEnrollingPage providerEnrollingPage = new ProviderEnrollingPage(driver, wait);


    public void clickonaddMCU() {
        javaWaitSec(5);
        Reports.log("Click on Coc main Tab ");
        clickAnyButton(Data.textMCOTab);
        javaWaitSec(5);

    }

    public void fillIdentifyingInformation(String LegalBusiness, String firstName, String lastName, String applicationContactNo, String email, String phone) {
        ajaxClick(IDENTIFIER_INFO_TAB);
        javaWaitSec(5);
        performClick(PLAN_LEGAL_NAME);
        javaWaitSec(2);
        performSendKeys(PLAN_LEGAL_NAME, LegalBusiness);
        Reports.log("Typed PLAN LEGAL NAME: " + LegalBusiness);
        javaWaitSec(5);
        performClick(FEIN_NUM);
        javaWaitSec(3);
        performSendKeys(FEIN_NUM, generateNewNumber(9));
        Reports.log("Typed FEIN: ");
        javaWaitSec(5);
        ajaxSendKeys(TAX_ENTITY_TYPE, "Corporation/Professional Organization");
        javaWaitSec(2);
        selectFirstOptionInDropdown(TAX_ENTITY_TYPE);
        javaWaitSec(5);
        Reports.log("Typed TAX ENTITY TYPE: " + TAX_ENTITY_TYPE);
        javaWaitSec(5);


        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NAME, firstName + " " + lastName);
        Reports.log("Application contact name: " + firstName + lastName);
        javaWaitSec(5);


        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_NUM, applicationContactNo);
        Reports.log("Application contact Phone: " + applicationContactNo);


        javaWaitSec(5);
        setFieldValueWithTabAndWait(TEXT_FIELD_APPLICATION_CONTACT_EMAIL, email);
        Reports.log("Type Application contact email: " + email);
        javaWaitSec(5);
        performClick(NEXT_BUTTON);
        javaWaitSec(5);


    }

    public void fillInTaxonomyForMCO(String enrollmentType, String speciality, String LicenseType) {
        javaWaitSec(2);
        Reports.log("\nFill in Program Participation Section");
        ajaxClick(SECTION_PROVIDER_PROGRAM_PARTICIPATION);
        Reports.log("Clicked on Program Participation / Taxonomy / License / Certificate Information");
        javaWaitSec(2);
        addProgramParticipationForMCO(speciality);
        javaWaitSec(5);
//        addLicenseForIndiPP(LicenseType, Data.LICENSE_NUMBER);
//        providerEnrollingPage.addLicense(LicenseType, Data.FLORIDA, Data.LICENSE_NUMBER);
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
        Reports.log("Clicked on Save button");


    }

    public void addProgramParticipationForMCO(String speciality) {
        javaWaitSec(2);
        ajaxClick(ProviderEnrollingPage.ADD_TAXONOMY);
        Reports.log("Clicked on the ADD TAXONOMY button");
        javaWaitSec(2);
        clickAndTypeAndSelectOptionInCombobox("Select Taxonomy - Description", "133N0000", 0);
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


    public void fillInServiceLocationSection(String enrollmentType, String email, String zipCode, String pgmParticipation, String taxonomy) {
        Reports.log("\nFill in Primary Service Location Section");
        ajaxClick(SECTION_PROVIDER__SERVICE_LOCATION);
        ajaxClick(ADD_LOCATION_BUTTON);


        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START);
        javaWaitSec(1);
        fillInCalendar(changeYearInCurrentDate(2), Data.EFFECTIVE_END);
        javaWaitSec(1);


        providerEnrollingPage.fillInLocationInformation(zipCode, email);
        javaWaitSec(1);
//        if (enrollmentType.equalsIgnoreCase(Data.BILLING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER) || enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)) {
//            providerEnrollingPage.addLocationProgramParticipation(enrollmentType, pgmParticipation, taxonomy);
//        }
//       // if(enrollmentType.equalsIgnoreCase(Data.ENTITY_PROVIDER)){
//            fillInProgramParticipationEntity(enrollmentType);
//        }
//        providerEnrollingPage.fillInClaimInformation();
//        providerEnrollingPage.fillInMiscellaneousDetails();


        //add region button
        performClick(ADD_REGION_BUTTON);
        javaWaitSec(5);
        //click on region button
        //select region from the option
        performClick(ADD_REGION_DROPDOWN);
        javaWaitSec(2);
        performClick(ADD_REGION_DD_OPTION);
//        getDropDownListByIndex(ADD_REGION_DROPDOWN,1);
        javaWaitSec(3);


        //select start date
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE_MCO_IU);
        //Effective start date *
        //click on save for the popup
        performClick(SAVE_ADD_REGION);


        //click on save for that tab
        ajaxClick(PROGRAM_PARTICIPATION_SAVE_BUTTON2);
        //click on next
        ajaxClick(setAndFindButton("Next"));
        javaWaitSec(5);
    }

    public void fillInAddressInformationForMCO(String enrollmentType, String physicalAdress, String city, String mailingState, String zip, String countyCode, String email) throws InterruptedException {
        Reports.log("\nFill in Address Detail Section");
        javaWaitSec(2);
        ajaxScrollUp();
        ajaxClick(ProviderEnrollingPage.SECTION_PROVIDER_ADDRESS_DETAILS);


        if (enrollmentType.contains(Data.pemApplication)) {
            setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_FIELD_CONTACT_ATTENTION_LINE, "Dr");
            Reports.log("Typed Attention Line: Hello " + "Dr");
        }
        // driver.findElement(SECTION_PROVIDER_ADDRESS_DETAILS).click();
        providerEnrollingPage.fillInIndividualAddressDetails(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);
        javaWaitSec(1);
        providerEnrollingPage.fillInPaytoAddressContactPersonDetails(email);
        javaWaitSec(2);
        Reports.log("\nfilling in Home/Corp Office Address");
        ajaxScrollDown();
        ajaxClick(BILLING_ADDRESS);
        javaWaitSec(2);


        Reports.log("filling in Billing Address Details");
        ajaxClick(BILLING_ADDRESS_CONTACT_PERSON);


    }


    public void fillInOwnershipMCO() {


        javaWaitSec(5);
        performClick(SECTION_OWNERSHIP);
        Reports.log("Clicked on 'Ownership' section");
        javaWaitSec(5);


        performClick(SELECT_OWNERSHIP_CODE_INPUT);
        Reports.log("Clicked on 'Select Ownership Code' input field");
        javaWaitSec(5);


        performSendKeys(SELECT_OWNERSHIP_CODE_INPUT, "Government - City");
        Reports.log("Entered 'Government - City' in the Ownership Code input field");


        ajaxClick(NO_RADIO_BUTTON_ARE_THERE_ANY_OWNERR_QUS_2);
        Reports.log("Clicked on 'No' radio button for Question 2: Are there any owners with less than 5%");
        javaWaitSec(2);


        ajaxClick(NO_RADIO_BUTTON_DOES_ANY_PERSION_HAVE_QUS_3);
        Reports.log("Clicked on 'No' radio button for Question 3: Does any person have a 5% or greater ownership or control interest");
        javaWaitSec(2);


        ajaxClick(NO_RADIO_BUTTON_DOES_ANY_ENTITY_HAV_QUS_4);
        Reports.log("Clicked on 'No' radio button for Question 4: Does any entity have a 5% or greater ownership or control interest");
        javaWaitSec(2);


        ajaxClick(NO_RADIO_BUTTON_DOES_ANY_PERSION_OR_ENTITY_HAVE_QUS_5);
        Reports.log("Clicked on 'No' radio button for Question 5: Does any person or entity have a 5% or greater indirect ownership or control");
        javaWaitSec(2);


        ajaxClick(NO_RADIO_BUTTON_HAS_THE_ENROLLING_PROVIDER_QUS_6);
        Reports.log("Clicked on 'No' radio button for Question 6: Has the enrolling provider delegated any of its management functions");
        javaWaitSec(2);


        ajaxClick(NO_RADIO_BUTTON_DO_ANY_IMMEDIATE_FAMILY_MEMBER_QUS_7);
        Reports.log("Clicked on 'No' radio button for Question 7: Do any immediate family members of owners have control interest");
        javaWaitSec(2);


        ajaxClick(NO_RADIO_BUTTON_DOES_THE_ENROLLING_PROVIDER_OR_ITS_OWNER_QUS_8);
        Reports.log("Clicked on 'No' radio button for Question 8: Does the enrolling provider or its owners have any other ownership or control");
        javaWaitSec(2);
        performClick(NEXT_BUTTON);
        javaWaitSec(5);


    }


    public void fillInKeyPersonalSectionForMCO(int index, String gender, String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType, String npi) throws InterruptedException {
        javaWaitSec(5);
        Reports.log("\nFill in Key Personnel Section");
        ajaxClick(ProviderEnrollingPage.SECTION_PROVIDER_KEY_PERSONNEL);
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        Reports.log("Click on +Add line Button");
        ajaxScrollUp();
        ajaxScrollUp();
        javaWaitSec(5);
        performClick(ProviderEnrollingPage.TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
        Reports.log("Clicked on Managing Employee Type");
//        driver.findElement(By.xpath(".//label[contains(text(), 'Managing Employee Type')]/parent::div//input/preceding-sibling::div")).click();
        Reports.log("Select Managing Employee Type");
        javaWaitSec(5);
//        driver.findElement(By.xpath("//ul[@role='listbox']/li[@data-value ='Director']")).click();
        ajaxClick(ProviderEnrollingPage.SELECT_TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);


        javaWaitSec(5);
        performClick(ProviderEnrollingPage.TEXT_FIELD_EMPLOYEE_STATUS);
        javaWaitSec(5);
        jsClick("//ul[@role='listbox']/li[text()='Managing Non Convicted']");


        setFieldValueWithTabAndWait(ProviderEnrollingPage.PROVIDER_ID, Data.PROVIDER_ID);
        javaWaitSec(5);
        setFieldValueWithWaits(ProviderEnrollingPage.NPI_IN_KEY_PERSONAL, npi);
//        fillNPIInKeyPersonal(npi);
        ajaxClick(ProviderEnrollingPage.TEXT_FIELD_LICENSE_FIRST_NAME);
        ajaxScroll(ProviderEnrollingPage.TEXT_FIELD_LICENSE_FIRST_NAME);
        String licenseFirstName = generateFirstName();
        Reports.log("Type License First Name :" + licenseFirstName);
        driver.findElements(ProviderEnrollingPage.TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(licenseFirstName);


        String licenseLastName = generateLastName();
        Reports.log("Type License Last Name :" + licenseLastName);
        driver.findElements(ProviderEnrollingPage.TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(licenseLastName);


        driver.findElement(TEXT_FIELD_COUNTRY_OF_BIRTH).click();
        Reports.log("Select country of Birth :" + Data.countryOfBirth);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.countryOfBirth));


        driver.findElement(ProviderEnrollingPage.DROP_DOWN_STATE_OF_BIRTH2).click();
        Reports.log("Select State of Birth :" + Data.SOUTH_DAKOTA);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.SOUTH_DAKOTA));


//        ajaxClick(TEXT_FIELD_COUNTRY_OF_BIRTH);
//        performClick(setSpecificOptionInListbox("United States"));


//        driver.findElement(ProviderEnrollingPage.RACE).click();
//        javaWaitSec(5);
//        Reports.log("Selected race:"+Data.ASIAN);
//        ajaxClick(setSpecificStrongOptionInListboxSD(Data.ASIAN));


        javaWaitSec(3);
        driver.findElement(ProviderEnrollingPage.GENDER).click();
        Reports.log("Select Gender :" + Data.genderMale);
        ajaxClick(setSpecificStrongOptionInListboxSD(Data.genderMale));


        String DOB = createRandomDateInSpecificYears(-18, -60);
        fillInCalendar(DOB, Data.dateOfBirthCalendar2);
        Reports.log("Date of birth is: " + DOB);
        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_START_DATE);


        fillInAddressDetailsMCO(physicalAdress, city, mailingState, zip, countyCode, enrollmentType);
        javaWaitSec(5);
        String ssn = generateANumberOfLength(10);
        Reports.log("Type SSN :" + ssn);
        performClick(ProviderEnrollingPage.TEXT_FIELD_SSN_PHARMACY);
        driver.findElements(ProviderEnrollingPage.TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(ssn);
        javaWaitSec(5);
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
    }


    public void fillInAddressDetailsMCO(String physicalAdress, String city, String mailingState, String zip, String countyCode, String enrollmentType) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(findAnyElement(ProviderEnrollingPage.TEXT_FIELD_ADDRESS)));


            Reports.log("Type physical address: " + physicalAdress);
            setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_FIELD_ADDRESS, physicalAdress);
        } catch (ElementNotInteractableException e) {
            setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_FIELD_ADDRESS, physicalAdress);
        }


        Reports.log("Type City: " + city);
        setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_ADDRESS_CITY, city);
        javaWaitSec(15);
        Reports.log("Type zip code: " + zip);
//        if (enrollmentType.contains("Group")) {
        setFieldValueWithTabAndWait(TEXT_FIELD_ZIP_CODE, zip);


//        }
//        if (enrollmentType.contains("Trading Partner") || enrollmentType.contains(Data.BILLING_PROVIDER)) {
//            setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_FIELD_ZIP_CODE, zip);
//        }


        javaWait(1);


        Reports.log("Type County Code: " + countyCode);
        //ajaxClick(TEXT_COUNTY_CODE);
        //driver.findElement(TEXT_COUNTY_CODE).clear();
        setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_COUNTY_CODE, countyCode);


        javaWait(1);
        driver.findElement(DROP_DOWN_ADDRESS_STATE).click();
        Reports.log("Select mailing state: " + mailingState);
        ajaxClick(setSpecificStrongOptionInListboxSD(mailingState));
    }


    public void summarySectionMCO(String firstName, String lastName) {


        Reports.log("\nFill in Summary Section ");
//        wait.until(ExpectedConditions.elementToBeClickable(ProviderEnrollingPage.SECTION_SUMMARYY));
        javaWaitSec(5);
        scrollToBottomOfPage();
//        ajaxScroll(ProviderEnrollingPage.SECTION_SUMMARYY);
//        driver.findElement(SECTION_SUMMARY).click();
        javaWaitSec(3);
        ajaxClick(ProviderEnrollingPage.SECTION_SUMMARYY);
        Reports.log("Clicked on the Summary Section");


//        ajaxClear(ProviderEnrollingPage.FIRST_NAME_SUMMARY);
//        setFieldValueWithTabAndWait(ProviderEnrollingPage.FIRST_NAME_SUMMARY, firstName);
//        Reports.log("Type first name: " + firstName);


        String text = driver.findElement(GET_FIRST_NAME_TEXT).getAttribute("value");
        Reports.log("Entered First Name is :" + text);
        String expectedText = text.replace("MCO ", "");


        try {
            ajaxClear(ProviderEnrollingPage.TEXT_FIELD_LAST_NAME_PROVIDER);
            setFieldValueWithTabAndWait(ProviderEnrollingPage.TEXT_FIELD_LAST_NAME_PROVIDER, lastName);
            Reports.log("Type in last name: " + lastName);
            driver.findElement(ProviderEnrollingPage.TEXT_FIELD_PROVIDER_NAME).sendKeys(firstName + " " + lastName);
            Reports.log("Provider name: " + firstName + " " + lastName);
        } catch (Exception e) {


        }


        if (!driver.findElement(ProviderEnrollingPage.SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX).isSelected()) {
            ajaxClick(ProviderEnrollingPage.SECTION_SUMMARY_SIGN_AND_AGREE_CHECKBOX);
            Reports.log("Checked, Sign and agree to Terms and Conditions checkbox");
        }


        javaWaitSec(5);
        ajaxClick(setAndFindButton(Data.TEXT_SUBMIT));
        Reports.log("Clicked on Submit button");
        javaWaitSec(10);
        ajaxClick(LINK_DASHBOARD);
//        driver.findElement(LINK_DASHBOARD).click();
        Reports.log("Clicked on GO TO MCO button");
        javaWaitSec(10);


//        performClick(PROVIDER_NAME_ID);
//        Reports.log("Clicked On Provider Name & ID");
//        javaWaitSec(2);
//        ajaxSendKeys(PROVIDER_NAME_ID, expectedText);
        driver.findElement(PROVIDER_NAME_ID).sendKeys(expectedText);
        Reports.log("Entered Provider Name & Id :" + expectedText);
        javaWaitSec(3);
        ajaxClick(SEARCH_BUTTON);
        Reports.log("Clicked on Search Button");
        javaWaitSec(5);
        // Locate element with partial text match
        WebElement resultBlock =
                driver.findElement(By.xpath("//div[contains(@class,'tile-table-row-summary')]//p[contains(text(),'" + expectedText + "')]"));


        javaWaitSec(6);
        // Assert directly that the element is displayed
        Assert.assertTrue("Expected value not found in search results: " + expectedText, resultBlock.isDisplayed());


    }


}
