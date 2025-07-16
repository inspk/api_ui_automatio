package com.hhstechgroup.provider;

import com.hhstechgroup.common.*;
import com.hhstechgroup.internal_user.EnrollmentPageInternalUser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * EnrollmentPageProvider class provides methods to complete provider enrollments
 */
public class EnrollmentPageProvider extends BaseActions {
    protected EnrollmentPageInternalUser enrollmentPageInternalUser;
    protected EnrollmentsAndCoc enrollmentsAndCoc;

    /**
     * This constructor method creates an EnrollmentPageProvider object
     * @param driver
     * @param wait
     */
    public EnrollmentPageProvider(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method returns to previous page and verifies data
     * @param locator
     * @param value
     */
    public void returnToPreviousPageAndVerifyData(By locator, String value) {
        WebElement element = driver.findElement(locator);
        if (!element.getAttribute("value").equals(value)) {
            Reports.log("Text field doesn't have value: " + value);

            Reports.log("Clear text field");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

            Reports.log("Type value " + value + " again");
            element.sendKeys(value);
        }
    }

    CalendarPopUp calendarPopUp = new CalendarPopUp(driver, wait);

    /**
     * This method fills in Individual Identifying Information section using  firstName, lastName, gender, dob, countryOfBirth
     * stateOfBirth, email, ssn, profitStatus, enrollmentType arguments.
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
    public void fillInIndividualIdentifyingInformation(
            String firstName, String lastName, String gender, String dob, String countryOfBirth, String stateOfBirth, String email, String ssn,
            String profitStatus, String enrollmentType) {

        Reports.log("Click first name text field");
        javaWaitSec(4);
        ajaxClick(Locators.TEXT_FIELD_FIRST_NAME_PROVIDER);
        Reports.log("Type first name: " + firstName);
        driver.findElement(Locators.TEXT_FIELD_FIRST_NAME_PROVIDER).clear();
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_FIRST_NAME_PROVIDER, firstName);

        Reports.log("Type in last name: " + lastName);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_LAST_NAME_PROVIDER, lastName);

        Reports.log("Type gender: " + gender);
        selectFirstOptionInDropdown(Locators.COMBOBOX_GENDER);

        if (!enrollmentType.contains(Data.pemApplication)) {
            Reports.log("Set Date of Birth");
            fillInCalendar(dob, Data.dateOfBirthCalendar);
        }

        if (!enrollmentType.contains(Data.pemApplication)) {
            Reports.log("Type Country of birth: " + countryOfBirth);
            selectFirstOptionInDropdown(Locators.DROP_DOWN_COUNTRY_OF_BIRTH);

            Reports.log("Type State of birth: " + stateOfBirth);
            selectFirstOptionInDropdown(Locators.DROP_DOWN_STATE_OF_BIRTH);
        }

        if (!enrollmentType.contains(Data.pemApplication)) {
            Reports.log("Type SSN: " + ssn);
            ajaxClick(Locators.TEXT_FIELD_SSN);
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_SSN, ssn);
        }

        Reports.log("Type Application contact email: " + email);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_APPLICATION_CONTACT_EMAIL, email);

        if (!enrollmentType.contains(Data.pemApplication) && !enrollmentType.contains(Data.orpApplication)) {
            final By locator = By.xpath("//label[text()='" + "Profit Status" + "']//ancestor::div[@role='combobox']//input");
            selectFirstOptionInDropdown(locator);
        }
    }

//    /**
//     * This method sets field value with tab and wait using locator and value arguments
//     * @param locator
//     * @param value
//     */
//    private void setFieldValueWithTabAndWait(final By locator, final String value) {
//        final WebElement field = driver.findElement(locator);
//        field.sendKeys(value);
//        field.sendKeys(Keys.TAB);
//        javaWaitSec(1);
//    }

//    /**
//     * This method selects first option in dropdown using locator
//     * @param locator
//     */
//    private void selectFirstOptionInDropdown(final By locator) {
//        WebElement field = driver.findElement(locator);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", field);
//        clickFirstOptionInList();
//        javaWaitSec(1);
//    }
//        performClick(Locators.COMBOBOX_TYPE_BUSINESS);
//
//        Reports.log("Type in type business: " + "Individual Recipient");
//        performSendKeys(Locators.COMBOBOX_TYPE_BUSINESS, "Ind");
//        clickFirstOptionInList();


//        driver.findElement(Locators.SECTION_IDENTIFYING_INFORMATION).click();
//
//        Reports.log("Check that First name text field have value: " + firstName);
//        returnToPreviousPageAndVerifyData(Locators.TEXT_FIELD_FIRST_NAME_PROVIDER, firstName);
//
//        Reports.log("Check that Last name text field have value: " + lastName);
//        returnToPreviousPageAndVerifyData(Locators.TEXT_FIELD_LAST_NAME_PROVIDER, lastName);
//
//        Reports.log("Check that Gender combobox have value: " + gender);
//        returnToPreviousPageAndVerifyData(Locators.COMBOBOX_GENDER, gender);

    /**
     * This method fills in identifying information using firstName, lastName, fein, email, enrollmentType, profitStatus arguments
     * @param firstName
     * @param lastName
     * @param fein
     * @param email
     * @param enrollmentType
     * @param profitStatus
     */
    public void fillInIdentifyingInformation(String firstName, String lastName, String fein, String email, String enrollmentType, String profitStatus) {
        Reports.log("Open Section: Identifying Information");
        ajaxClick(Locators.TEXT_FIELD_GROUP_PROVIDER_NAME);

        Reports.log("Type Provider name: " + firstName + " " + lastName);
        //Added the word Group at the end
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_GROUP_PROVIDER_NAME, firstName + " " + lastName);

        Reports.log("Click FEIN text field");
        ajaxClick(Locators.TEXT_FIELD_GROUP_FEIN);

        Reports.log("Type FEIN: " + fein);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_GROUP_FEIN, fein);


        Reports.log("Type contact email: " + email);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_EMAIL, email);

        clickAndTypeAndSelectOptionInCombobox("Profit Status", profitStatus, 0);

        if (enrollmentType.contains(Data.facilityApplication) || enrollmentType.contains(Data.pharmacyApplication)) {
            Reports.log("Type taxt entity type: " + Data.taxEntityType);
            selectFirstOptionInDropdown(Locators.TEXT_FIELD_TAX_ENTITY_TYPE);
        }
    }

    /**
     * This method fills in pharmacy identifying information using groupName, fein, email arguments
     * @param groupName
     * @param fein
     * @param email
     */
    public void fillInPharmacyIdentifyingInformation(String groupName, String fein, String email) {
        Reports.log("Open Group Identifying information page");

        Reports.log("Click Group name text field");
        ajaxClick(Locators.TEXT_FIELD_GROUP_PROVIDER_NAME);

        Reports.log("Type group name: " + groupName);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_GROUP_PROVIDER_NAME, groupName);

        Reports.log("Click FEIN text field");
        ajaxClick(Locators.TEXT_FIELD_GROUP_FEIN);

        Reports.log("Type FEIN: " + fein);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_GROUP_FEIN, fein);


        Reports.log("Type contact email: " + email);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_EMAIL, email);

    }

    /**
     * This method fills in provider identifier number using Npi
     * @param npi
     */
    public void fillInProviderIdentifierNumber(String npi) {
        Reports.log("Open Provider Identifier Number page");

        Reports.log("Click NPI text field");
        ajaxClick(Locators.TEXT_FIELD_NPI);

        Reports.log("Type NPI: " + npi);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_NPI, npi);
        clickAnyOptionInList(0);
    }

    /**
     * This method fills in provider identifiers section using Npi
     * @param npi
     */
    public void fillInProviderIdentifiersSection(String npi) {
        Reports.log("Open Provider Identifier Number page");
        Reports.log("Click NPI text field");
        ajaxClick(Locators.TEXT_FIELD_NEW_NPI);

        Reports.log("Type NPI: " + npi);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_NEW_NPI, npi);
        clickAnyOptionInList(0);
//        try {
//            Reports.log("Select radio-button No in DEA number");
//            driver.findElement(Locators.RADIOBUTTON_DEA_NUMBER).click();
//        }catch (Exception e){
//
//        }
        Reports.log("Select radio-button No in Bill Laboratory Services");
        driver.findElement(Locators.RADIOBUTTON_BILL_LABORATORY_SERVICES).click();
    }

    /**
     * This method fills in provider identifiers section with different Npi using npi, enrollmentType
     * @param npi
     * @param enrollmentType
     */
    public void fillInProviderIdentifiersSectionWithDifferentNpi(String npi, String enrollmentType) {
        if (enrollmentType.contains(Data.individualApplication)) {
            Reports.log("Click Yes in NPI radio-button");
            ajaxClick(Locators.RADIOBUTTON_NPI_NUMBER);
        }
        Reports.log("Select radio-button No in Bill Laboratory Services");
        ajaxClick(Locators.RADIOBUTTON_BILL_LABORATORY_SERVICES);

    }

    /**
     * This method add line provider identifiers using index
     * @param index
     */
    public void addLineProviderIdentifiers(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        ajaxScrollByCoordinate(100);
        ajaxScroll(Locators.COMBOBOX_TYPE_IDENTIFIERS);
        ajaxClick(Locators.COMBOBOX_TYPE_IDENTIFIERS);
        clickFirstOptionInList();
        ajaxClick(Locators.TEXT_FIELD_IDENTIFIER);
        driver.findElements(Locators.TEXT_FIELD_IDENTIFIER).get(index).sendKeys("111");
        fillInCalendar("09/04/2020", Data.effectiveDateCalendar2);
        fillInCalendar("09/05/2020", Data.endDateCalendar);
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
        javaWaitSec(3);
    }

    /**
     * This method fills in pharmacy provider identifiers section with different Npi using npi, ncpdp
     * @param npi
     * @param ncpdp
     */
    public void fillInPharmacyProviderIdentifiersSectionWithDifferentNpi(String npi, String ncpdp) {
        Reports.log("Open Provider Identifier Number page");
        typeAndSelectNpiTextField(npi, Data.pharmacyType);
        Reports.log("Type NCPDP: " + ncpdp);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_NCPDP, ncpdp);

    }

    /**
     * This method clicks medicare radio button by value
     * @param value
     */
    public void clickMedicareRadiobuttonByValue(String value) {
        Reports.log("Select value in Medicare radio-button: " + value);
        ajaxClick(By.xpath("//input[contains(@name, 'Medicare')][@value='" + value + "']"));
    }

    /**
     * This method clicks Laboratory No Value
     */
    public void clickLaboratoryNoValue() {
        Reports.log("Select value in Medicare radio-button: ");
        ajaxClick(By.xpath("//input[contains(@name, 'laboratory')][@value='false']"));
    }

    /**
     * This method clicks Create Revalidation Button No Value
     */
    public void clicksOnCreateRevalidationButton() {
        ajaxClick(Locators.CREATE_REVALIDATION_BUTTON);
        Reports.log("Click on Create Revalidation button");
        javaWaitSec(5);
    }


    /**
     * This method clicks affiliation button
     */
    public void clickAffiliationButton() {
        Reports.log("Clicked on Affiliation button ");
        ajaxClick(Locators.AFFILIATION_TAB);
    }

    /**
     * This method searches affiliate provider using nameOfProvider
     * @param nameOfProvider
     */
    public void searchAffiliateProvider(String nameOfProvider) {
        ajaxScroll(Locators.AFFILIATION_PROVIDERINFO_TEXTBOX);
        Reports.log("Clear provider if text field");
        driver.findElement(Locators.AFFILIATION_PROVIDERINFO_TEXTBOX)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        Reports.log("Type provider name: " + nameOfProvider);
        driver.findElement(Locators.AFFILIATION_PROVIDERINFO_TEXTBOX).sendKeys(nameOfProvider);

        Reports.log("Click button: " + Data.TEXT_SEARCH);
        performClick(setAndFindButton(Data.TEXT_SEARCH));
    }

    /**
     * This method clicks Radio button by value
     */
    public void clickDeaRadiobuttonByValue() {
        Reports.log("Select value in DEA radio-button: No");
        ajaxClick(Locators.RADIOBUTTON_DEA_NUMBER);

    }

    /**
     * This method type and select Npi text field using NPI, taxonomyCategory
     * @param npi
     * @param taxonomyCategory
     */
    //Updated per Email received from Leonid on 12/30/2020.
    public void typeAndSelectNpiTextField(String npi, String taxonomyCategory) {
        for (int i = 0; i < 10; i++) {
            try {
                if (driver.findElement(By.xpath("//*[text()='Verified']")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
            }
            Reports.log("Type NPI: " + npi + " attempt " + i);
            setFieldValueWithWaits(Locators.TEXT_FIELD_NEW_NPI, npi);
            if(i>=9){Assert.fail("Entering an invalid NPI num");}
        }
    }

//    /**
//     * This method sets field value with waits using locator, value
//     * @param locator
//     * @param value
//     */
//    public void setFieldValueWithWaits(final By locator, final String value) {
//        WebElement field = driver.findElement(locator);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", field);
//        for (int j = 0; j < value.length(); j++) {
//            javaWait(200);
//            // ajaxSendKeys(field,value.substring(j, j + 1));
//            field.sendKeys(value.substring(j, j + 1));
//        }
//        javaWaitSec(3);
//        field.sendKeys(Keys.TAB);
//        javaWaitSec(1);
//    }

    /**
     * This methd types Npi Once using npi
     * @param npi
     */
    public void typeNpiOnce(String npi) {
        Reports.log("Click NPI text field");
        ajaxClick(Locators.TEXT_FIELD_NEW_NPI);

        Reports.log("Type NPI: " + npi);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_NEW_NPI, npi);
        javaWaitSec(5);
        driver.findElement(Locators.TEXT_FIELD_NEW_NPI).sendKeys(Keys.TAB);
        javaWaitSec(1);
    }

    /**
     * This method fills in first name and last names using firstName, lastName, index
     * @param firstName
     * @param lastName
     * @param index
     */
    public void fillInFirstNameAndLastNames(String firstName, String lastName, int index) {
        Reports.log("Type first name: " + firstName);
        driver.findElements(Locators.TEXT_FIELD_FIRST_NAME_ENROLLMENT).get(index).sendKeys(firstName);

        Reports.log("Type last name: " + lastName);
        driver.findElements(Locators.TEXT_FIELD_LAST_NAME_ENROLLMENT).get(index).sendKeys(lastName);
    }

    /**
     * This method types common address using firstName, lastName, phone, email, index
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param index
     */
    public void typeCommonAddress(String firstName, String lastName, String phone, String email, int index) {
        fillInFirstNameAndLastNames(firstName, lastName, index);

        driver.findElements(Locators.TEXT_FIELD_LAST_NAME_ADDRESS).get(index).sendKeys(lastName);
        Reports.log("Type phone: " + phone);
        driver.findElements(Locators.TEXT_FIELD_PHONE_ADDRESS).get(index).sendKeys(phone);
        Reports.log("Type email: " + email);
        driver.findElements(Locators.TEXT_FIELD_EMAIL_ADDRESS).get(index).sendKeys(email);
    }

    /**
     * This method fills in group address details using physicalAdress, buildingSuite, zipCode
     * @param physicalAdress
     * @param buildingSuite
     * @param zipCode
     */
    public void fillInGroupAddressDetails(String physicalAdress, String buildingSuite, String zipCode) {
        Reports.log("Type address: " + physicalAdress);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_PHYSICAL_ADDRESS, physicalAdress);

        Reports.log("Type building suite: " + buildingSuite);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_BUILDING_SUITE, buildingSuite);

        Reports.log("Type zip code: " + zipCode);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ZIP_CODE1, zipCode);

    }

    /**
     * This method fills in individual address details using physicalAdress, city, mailingState, zip, countyCode
     * @param physicalAdress
     * @param city
     * @param mailingState
     * @param zip
     * @param countyCode
     */
    public void fillInIndividualAddressDetails(String physicalAdress, String city, String mailingState, String zip, String countyCode) {

        Reports.log("Type physical address: " + physicalAdress);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ADDRESS, physicalAdress);

        Reports.log("Type City: " + city);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ADDRESS_CITY, city);

        Reports.log("Type County Code: " + countyCode);
        driver.findElement(Locators.TEXT_COUNTY_CODE).clear();
        setFieldValueWithTabAndWait(Locators.TEXT_COUNTY_CODE, countyCode);

        Reports.log("Type zip code: " + zip);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ZIP_CODE1, zip);

        driver.findElement(Locators.DROP_DOWN_MAILING_ADDRESS_STATE).sendKeys("");
        Reports.log("Select mailing state: " + mailingState);

        ajaxClick(setSpecificStrongOptionInListbox(mailingState));
        //setSpecificStrongOptionInListbox(mailingState);

    }

    /**
     * This method fills in address information using enrollmentType, physicalAdress, city, mailingState, zip, countyCode
     * @param enrollmentType
     * @param physicalAdress
     * @param city
     * @param mailingState
     * @param zip
     * @param countyCode
     */
    public void fillInAddressInformation(String enrollmentType, String physicalAdress, String city, String mailingState, String zip, String countyCode) {
        Reports.log("Open Section: Address Detail Section");
        driver.findElement(Locators.SECTION_PROVIDER_ADDRESS_DETAILS).click();
        fillInIndividualAddressDetails(physicalAdress, city, mailingState, zip, countyCode);
        javaWaitSec(20);
    }

    /**
     * This method signs in provider agreement Form using enrollmentType, firstName, lastName
     * @param enrollmentType
     * @param firstName
     * @param lastName
     */
    public void signInProviderAgreementForm(String enrollmentType, String firstName, String lastName) {
        Reports.log("Open Section: Provider Agreement Section");
        driver.findElement(Locators.SECTION_PROVIDER_PROVIDER_AGREEMENT).click();
        if (enrollmentType.equalsIgnoreCase(Data.groupApplication) || enrollmentType.equalsIgnoreCase(Data.individualApplication) || enrollmentType.equalsIgnoreCase(Data.pemApplication)) {
            closeProviderAgreementpopUp();
        }
        clickAndAgreeProviderAgreement();
        signInHelloSignProviderAgreementSection(firstName, lastName);
        javaWaitSec(45);
    }

    /**
     * This method fills in primary service location section using enrollmentType, firstName, lastName, newEmail, zipCode
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param newEmail
     * @param zipCode
     */
    public void fillInPrimaryServiceLocationSection(String enrollmentType, String firstName, String lastName, String newEmail, String zipCode, String state) {
        Reports.log("Open Section: Primary Service Location Section");
        ajaxClick(Locators.SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION);
        //    driver.findElement(Locators.SECTION_PROVIDER_PRIMARY_SERVICE_LOCATION).click();
//        if(enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)){
//            addLinePharmacyKeyPersonal(0);
//        }

        fillInPrimaryServiceLocation(firstName, lastName, newEmail, zipCode, state);
    }

    /**
     * This method fills in request retroactive adjustment section
     */
    public void fillInRequestRetroactiveAdjustmentSection() {
        Reports.log("Open Section: Request Retroactive Adjustment Section");
        ajaxClick(Locators.SECTION_REQUEST_RETROACTIVE_ADJUSTMENT);
        javaWaitSec(1);
        WebElement radionButton = driver.findElement(Locators.RADIOBOX_REQUEST_RETROACTIVE);
        Reports.log("Selected Yes on Question 'Do you want to be approved retroactively?'");
        radionButton.click();
        WebElement justification = driver.findElement(Locators.JUSTIFICATION_REQUEST_RETROACTIVE_ADJUSTMENT);
//        justification.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        javaWaitSec(1);
        clearContent(justification);
        justification.sendKeys("Retroactive Request");
        javaWaitSec(1);
        WebElement calander = driver.findElement(Locators.CALANDER_REQUEST_RETROACTIVE_ADJUSTMENT);
//        calander.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        javaWaitSec(1);
        clearContent(calander);
        String date = changeDayInCurrentDate(-7);
        calander.sendKeys(date);
        calander.sendKeys(Keys.TAB);
        // fillInCalendar(date ,Data.Retroactive);
        // ajaxClick(calander);
        javaWaitSec(1);
        clickAnyButton(Data.TEXT_NEXT);
        javaWaitSec(5);
    }

    /**
     * This method uploads document section using enrollmentType
     * @param enrollmentType
     */
    public void uploadDocumentSection(String enrollmentType) {

        Reports.log("Open Section: Upload Document Section");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_UPLOAD_DOCUMENTS));
        //  driver.findElement(Locators.SECTION_UPLOAD_DOCUMENTS).click();
        ajaxClick(Locators.SECTION_UPLOAD_DOCUMENTS);
        driver.findElement(Locators.SECTION_UPLOAD_DOCUMENTS).click();
        if (enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            ajaxUploadForEnrollment("Current License");
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

    /**
     * This method downloads invoice payment
     */
    public void downloadInvoicePayment() {
        try{
            setAndFindButton(Data.TEXT_DOWNLOAD_INVOICE_PAYMENT).click();
            Reports.log("Invoice Downloaded");
            javaWaitSec(10);
        }  catch(Exception e){}
    }


    /**
     * This method fills in payment section using enrollmentType, paymentOption
     * @param enrollmentType
     * @param paymentOption
     */
    public void fillInPaymentSection(String enrollmentType, String paymentOption) {

        Reports.log("Open Section: Payment Section");
        ajaxScroll(Locators.SECTION_PAYMENT);
        driver.findElement(Locators.SECTION_PAYMENT).isDisplayed();
        javaWaitSec(3);
        ajaxClick(Locators.SECTION_PAYMENT);
        //  driver.findElement(Locators.SECTION_PAYMENT).click();
        javaWaitSec(20);
        String enrollmentFee = driver.findElement(Locators.ENROLLMENT_FEE).getText();
        // Reports.log("Required enrollment fee: " + enrollmentFee);

        if (enrollmentType.equalsIgnoreCase(Data.individualApplication) || enrollmentType.equalsIgnoreCase(Data.orpApplication) || enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            if (!enrollmentFee.contains("$0") || enrollmentFee.isEmpty()) {
                if (paymentOption.contains("Offline")) {
                    downloadInvoicePayment();
                }
            }
            return;
        }
        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            downloadInvoicePayment();

        }
    }


    /**
     * This method fills in payment section using enrollmentType, paymentOption
     * @param enrollmentType
     * @param paymentOption
     */
    public void fillInPaymentSection(String enrollmentType, String paymentOption, String email, String zipCode, String PhoneNo) {

        Reports.log("Open Section: Payment Section");
        ajaxScroll(Locators.SECTION_PAYMENT);
        driver.findElement(Locators.SECTION_PAYMENT).isDisplayed();
        javaWaitSec(3);
        ajaxClick(Locators.SECTION_PAYMENT);
        //  driver.findElement(Locators.SECTION_PAYMENT).click();
        javaWaitSec(10);
        String enrollmentFee = driver.findElement(Locators.ENROLLMENT_FEE).getText();
        Reports.log("Required enrollment fee: " + enrollmentFee);

        if (enrollmentType.equalsIgnoreCase(Data.individualApplication) || enrollmentType.equalsIgnoreCase(Data.orpApplication) || enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            if (!enrollmentFee.contains("$0") || enrollmentFee.isEmpty()) {
                if (paymentOption.contains("Offline")) {
                    downloadInvoicePayment();
                }
            }
        }

        try{
            Reports.log("Go To Payment button is Enabled");
            ajaxClick(Locators.BUTTON_GO_TO_PAYMENT);
            fillingPaymentInfo("4111111111111111","04/22", "111",
                    "John Doe",email, zipCode);
        }catch(Exception e){
            Reports.log("Exception :"+e);
        }

        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            downloadInvoicePayment();
        }
    }


    /**
     * This method verifies payment details using expectedEnrollmentFee
     * @param expectedEnrollmentFee
     */
    public void verifyPaymentDetails(String expectedEnrollmentFee){
        String actualEnrollmentFee =  driver.findElement(Locators.ENROLLMENT_FEE).getText();
        Reports.log("Expected Enrollment Fee: $"+expectedEnrollmentFee+ "\n Actual Enrollment Fee: "+actualEnrollmentFee);
        Assert.assertTrue(actualEnrollmentFee.contains(expectedEnrollmentFee));
    }

    /**
     * This method summaries section proceed to sign in
     */
    public void summarySectionProceedToSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_SUMMARY));
        scrollToBottomOfPage();
        ajaxScroll(Locators.SECTION_SUMMARY);
//        driver.findElement(Locators.SECTION_SUMMARY).click();
        ajaxClick(Locators.SECTION_SUMMARY);
        javaWaitSec(30);
        ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
        javaWaitSec(30);

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
                    ajaxScroll(Locators.SECTION_SUMMARY);
                    driver.findElement(Locators.SECTION_SUMMARY).click();
                    javaWaitSec(5);
                    ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
                    javaWaitSec(5);
                }
            }catch(Exception e){
                if(driver.findElement(Locators.LINK_DASHBOARD).isDisplayed()) {
                    ajaxClick(Locators.LINK_DASHBOARD);
                    javaWaitSec(10);
                    ajaxClick(setAndFindButton(Data.TEXT_SIGN));
                    javaWaitSec(10);
                    break;
                }
            }
            Reports.log("Reloading the Summary page, attempt " + i);
        }
        javaWaitSec(15);
    }

    /**
     * This method fills in provider identifiers section using medicareParticipant, npi, enrollmentType, taxonomyCategory
     * @param medicareParticipant
     * @param npi
     * @param enrollmentType
     * @param taxonomyCategory
     */
    public void fillInProviderIdentifiersSection(String medicareParticipant, String npi, String enrollmentType, String taxonomyCategory) {
        javaWaitSec(5);
        Reports.log("Open Section: Provider Identifier Section");
        ajaxClick(Locators.SECTION_PROVIDER_IDENTIFIERS);
        // driver.findElement(Locators.SECTION_PROVIDER_IDENTIFIERS).click();

        if (enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            fillInPharmacyProviderIdentifiersSectionWithDifferentNpi(npi, Data.ncpdp);
            //driver.findElement(Locators.SECTION_PROVIDER_ADDRESS_DETAILS).click();
            ajaxClick(Locators.SECTION_PROVIDER_ADDRESS_DETAILS);
            return;
        }
        clickMedicareRadiobuttonByValue(medicareParticipant);

        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            clickDeaRadiobuttonByValue();
            clickLaboratoryNoValue();
            typeAndSelectNpiTextField(npi, taxonomyCategory);
            return;
        }

        fillInProviderIdentifiersSectionWithDifferentNpi(npi, enrollmentType);
        typeAndSelectNpiTextField(npi, taxonomyCategory);
    }

    /**
     * This method fills authorized signature section using firstName
     * @param firstName
     */
    public void fillAuthorizedSignaturSection(String firstName) {
        Reports.log("Open Section: Authorized Signature Section");
        ajaxScroll(Locators.SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        ajaxClick(Locators.SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        fillAuthorizedSignature(firstName, "Mr");
    }

    /**
     * This method mailing address contact person using firstName, lastName, phone, email
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     */
    public void mailingAddressContactPerson(String firstName, String lastName, String phone, String email) {
        Reports.log("Go to Mailing Address Contact Person Details");

        Reports.log("Type First Name: " + firstName);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_FIRST_NAME, firstName);

        Reports.log("Type Last Name: " + lastName);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_LAST_NAME, lastName);

        Reports.log("Type Phone: " + phone);
        driver.findElement(Locators.TEXT_FIELD_CONTACT_PHONE).clear();
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_PHONE, phone);

        Reports.log("Type Email: " + email);
        driver.findElement(Locators.TEXT_FIELD_CONTACT_PERSON_EMAIL).clear();
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_PERSON_EMAIL, email);
        javaWaitSec(5);
    }

    /**
     * This method fills in primary service location using firstName, lastName, newEmail, zip
     * @param firstName
     * @param lastName
     * @param newEmail
     * @param zip
     */
    public void fillInPrimaryServiceLocation(String firstName, String lastName, String newEmail, String zip, String state) {
        if(state == Data.inState) {
            Reports.log("Type Primary Service Address: " + Data.physicalAddress);
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ADDRESS, Data.physicalAddress);

            Reports.log("Type City: " + Data.city);
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ADDRESS_CITY, Data.city);

            driver.findElement(Locators.DROP_DOWN_MAILING_ADDRESS_STATE).sendKeys("");
            Reports.log("Select mailing state: " + Data.mailingState);
            ajaxClick(setSpecificStrongOptionInListbox(Data.mailingState));

            Reports.log("Type zip: " + zip);
            //driver.findElement(Locators.TEXT_FIELD_SERVICE_LOCATION_ZIP).click();
            driver.findElement(Locators.TEXT_FIELD_ZIP_CODE1).clear();
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ZIP_CODE1, zip);

            Reports.log("Type County Code: " + Data.countyCodeWY);
            //  driver.findElement(Locators.TEXT_FIELD_SERVICE_LOCATION_COUNTY_CODE).click();
            driver.findElement(Locators.TEXT_COUNTY_CODE).clear();
            setFieldValueWithTabAndWait(Locators.TEXT_COUNTY_CODE, Data.countyCodeWY);

        } else if(state == Data.outState){
            Reports.log("Type Primary Service Address: " + Data.physicalAddressCA);
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ADDRESS, Data.physicalAddressCA);

            Reports.log("Type City: " + Data.citySAC);
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ADDRESS_CITY, Data.citySAC);

            driver.findElement(Locators.DROP_DOWN_MAILING_ADDRESS_STATE).sendKeys("");
            Reports.log("Select mailing state: " + Data.mailingOutState);
            ajaxClick(setSpecificStrongOptionInListbox(Data.mailingOutState));

            Reports.log("Type zip: " + Data.zipCA);
            driver.findElement(Locators.TEXT_FIELD_ZIP_CODE1).clear();
            setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ZIP_CODE1, Data.zipCA);

            Reports.log("Type County Code: " + Data.countyCodeSAC);
            driver.findElement(Locators.TEXT_COUNTY_CODE).clear();
            setFieldValueWithTabAndWait(Locators.TEXT_COUNTY_CODE, Data.countyCodeSAC);
        }

        Reports.log("Enter Contact Person");
        Reports.log("Type Primary Serivce Address: " + firstName);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_FIRST_NAME, firstName);

        Reports.log("Type Primary Serivce Address: " + lastName);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_LAST_NAME, lastName);

        Reports.log("Type Primary Serivce Address: " + Data.phone);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_PHONE, Data.phone);

        Reports.log("Type Primary Serivce Address: " + newEmail);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CONTACT_PERSON_EMAIL, newEmail);
    }



    /**
     * This method fills authorized signature using firstName, title
     * @param firstName
     * @param title
     */
    public void fillAuthorizedSignature(String firstName, String title) {
        driver.findElement(Locators.TEXT_FIELD_NAME_OF_AUTHORIZED).sendKeys(firstName);
        Reports.log("Enter Title of Person: " + title);
        driver.findElement(Locators.TEXT_FIELD_TITLE_OF_PERSON).sendKeys(title);
        driver.findElement(Locators.TEXT_FIELD_TITLE_OF_PERSON).sendKeys(Keys.TAB);
        javaWaitSec(15);
    }

    /**
     * This method types zip and county code
     */
    public void typeZipAnDCountyCode() {
        driver.findElement(Locators.TEXT_FIELD_SERVICE_LOCATION_ZIP).clear();
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_SERVICE_LOCATION_ZIP, Data.zipWY);

        Reports.log("Type County Code: " + Data.countyCodeWY);
        //  driver.findElement(Locators.TEXT_FIELD_SERVICE_LOCATION_COUNTY_CODE).click();
        driver.findElement(Locators.TEXT_FIELD_SERVICE_LOCATION_COUNTY_CODE).clear();
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_SERVICE_LOCATION_COUNTY_CODE, Data.countyCodeWY);
    }

    /**
     * This method authorizes signature section using title
     * @param title
     */
    public void authorizedSignatureSection(String title) {
        scrollToBottomOfPage();
        ajaxScroll(Locators.SECTION_PROVIDER_AUTHORIZED_SIGNATURE);
        Reports.log("Wait to Authorized Signature Available to click");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_PROVIDER_AUTHORIZED_SIGNATURE));
        Reports.log("Click on Authorized Signature");
        driver.findElement(Locators.SECTION_PROVIDER_AUTHORIZED_SIGNATURE).click();
        Reports.log("Enter Title of Person: " + title);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_TITLE_OF_PERSON, title);
    }
    /**
     * This method request retroactive adjustment
     */
    public void requestRetroactiveAdjustment() {
        Reports.log("Open Request Retroactive Adjustment page");
        WebElement radionButton = driver.findElement(Locators.RADIOBOX_REQUEST_RETROACTIVE);
        Reports.log("Selected No on Question 'Do you want to be approved retroactively?'");
        radionButton.click();
    }

    /**
     * This method fills in ZipCode in communication preferences using zip
     * @param zip
     */
    public void fillInZipCodeInCommunicationPreferences(String zip) {
        Reports.log("Open  Communication Preferences page");

        Reports.log("Clear zip code");
        driver.findElement(Locators.TEXT_FIELD_ZIP_CODE2).clear();

        Reports.log("Type zip code: " + zip);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_ZIP_CODE2, zip);
    }

    /**
     * This method skips section using index
     * @param index
     */
    public void skipSection(int index) {
        for (int i = 0; i < index; i++) {
            clickAnyButton(Data.TEXT_NEXT);
        }
    }
    /**
     * This method fills payment info section
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
        Reports.log("Open  Payment info page");

        Reports.log("Type email: " + billingEmail);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_BILLING_EMAIL, billingEmail);

        Reports.log("Click Card number text field");
        ajaxClick(Locators.TEXT_FIELD_CARD_NUMBER);

        Reports.log("Type card number: " + cardNumber);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CARD_NUMBER, cardNumber);

        Reports.log("Type expiration date: " + expirationDate);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_EXPIRATION_DATE, expirationDate);

        Reports.log("Type CVV: " + cvc);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_CVC, cvc);

        Reports.log("Type name on card: " + name);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_FULL_NAME_ON_CARD, name);

        Reports.log("Type zip on card: " + billingZip);
        setFieldValueWithTabAndWait(Locators.TEXT_FIELD_BILLING_ZIP, billingZip);

        Reports.log("Click Submit button");
        ajaxClick(Locators.BUTTON_SUBMIT_CREDIT_CARD);
    }

//    public void clickEnrollProviderBtn_AddAffiliatedProvider(){
//        Reports.log("Click Enroll Provider button, Under Affiliated provider");
//        ajaxClick(Locators.ADDAffiliation_ENROLLPROVIDER_BUTTON);
//    }

    /**
     * This method clicks back to dashboard button
     */
    public void clickBackToDashBoardButton() {
        Reports.log("Click back to dashboard button");
        ajaxClick(Locators.PEMAFFILIATION_BACKTODASHBOARD_BUTTON);
    }

    /**
     * This method signs in Hello Sign using firstName, lastName
     * @param firstName
     * @param lastName
     */
    public void signInHelloSign(String firstName, String lastName) {
        Reports.log("Wait Hello Sign page");
        for(int i=0; i<=5 ;i++) {
            try {
                try {
                    advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                    Reports.log("Switch to Hello Sign page");
                    driver.switchTo().frame(Data.helloSignIframe);
                    Reports.log("Close pop up");
                    clickAnyButton(Data.TEXT_OK);
                    break;
                } catch (Exception e) {
                    Reports.log("Hello sign page is loading....! so Refreshing the page");
                    driver.navigate().refresh();
                    javaWaitSec(5);
                    if (i == 5) {
                        if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
                            clickAnyButton(Data.TEXT_SIGN);
                            advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                            Reports.log("Switch to Hello Sign page");
                            driver.switchTo().frame(Data.helloSignIframe);
                            Reports.log("Close pop up");
                            clickAnyButton(Data.TEXT_OK);
                            break;
                        }} }
            }
            catch (Exception e) {
                Reports.log("Unable to load the hello sign page");
            }
        }

        Reports.log("Wait full name text field");
        advanceFindElement(Locators.TEXT_FIELD_FIRST_NAME_HELLO_SIGN, 20, 2);

        Reports.log("Type full name: " + firstName + " " + lastName);

        Boolean staleElement = true;
        while(staleElement){
            try{
                driver.findElement(Locators.TEXT_FIELD_FIRST_NAME_HELLO_SIGN).sendKeys(firstName + " " + lastName);
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }

        Reports.log("Click Signature input");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa-ref = 'signature-input']")));
        javaWaitSec(10);
        ajaxClick(By.xpath("//div[@data-qa-ref = 'signature-input']"));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_TYPE_IN));
        Reports.log("Click option Type it in");
        ajaxClick(Locators.SECTION_TYPE_IN);

        Reports.log("Click Signature area");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_TYPE_SIGNATURE));
        performClick(Locators.SECTION_TYPE_SIGNATURE);

        Reports.log("Type signature");
        driver.findElement(Locators.SECTION_TYPE_SIGNATURE).sendKeys("OL");

        Reports.log("Click Insert button");
        ajaxClick(Locators.BUTTON_INSERT_HELLO_SIGN);

        ajaxClick(Locators.BTN_CONTINUE);
//        clickAnyButton(Data.TEXT_CONTINUE);
        clickAnyButton2(Data.TEXT_I_AGREE, 1);
        javaWaitSec(10);
        ajaxClick(Locators.LINK_DASHBOARD);
        javaWaitSec(10);
    }

    /**
     * This method gets provider tracking number
     * @return
     */
    public String getProviderTrackingNumber(){
        javaWaitSec(10);
        String trackingNum = driver.findElement(Locators.PROVIDER_TRACKING_NUMBER).getText();
        Reports.log("Providers Tracking Number:"+trackingNum);
        return trackingNum;
    }

    /**
     * This method signs in Hello Sign provider agreement section using firstName, lastName
     * @param firstName
     * @param lastName
     */
    public void signInHelloSignProviderAgreementSection(String firstName, String lastName) {
        Reports.log("Wait Hello Sign page");
        try {
            advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 30, 2);
            Reports.log("Switch to Hello Sign page");
            driver.switchTo().frame(Data.helloSignIframe);

            javaWaitSec(5);
            Reports.log("Close pop up");
            clickAnyButton(Data.TEXT_OK);

            Reports.log("Get started");
            ajaxClick(spanContainsText("Get Started"));
            javaWait(3000);
            Reports.log("Click Signature input");
            ajaxClick(By.xpath("//div[text()= 'Click to sign']"));

            Reports.log("Click option Type it in");
            ajaxClick(Locators.SECTION_TYPE_IN);

            Reports.log("Click Signature area");
            ajaxClick(Locators.SECTION_TYPE_SIGNATURE);
            // performClick(Locators.SECTION_TYPE_SIGNATURE);

            wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_TYPE_SIGNATURE));
            driver.findElement(Locators.SECTION_TYPE_SIGNATURE).sendKeys(lastName);
            Reports.log("Type signature");

            ajaxClick(Locators.BUTTON_INSERT_HELLO_SIGN);
            Reports.log("Click Insert button");
            javaWaitSec(2);

            //Added Title section for Provider Agreement
            try {
                //driver.findElement(By.xpath("//textarea[@placeholder= 'Full Name']")).sendKeys("Provider Enrollment Manager");
                driver.findElement(By.xpath("//textarea[@placeholder= 'Title']")).sendKeys("Provider Enrollment Manager");
                javaWaitSec(2);
                Reports.log("Entered the Title: Provider Enrollment Manager");
            } catch (NoSuchElementException e) {
                Reports.log("No Title field available for this application");
            }
            clickAnyButton(Data.TEXT_CONTINUE);
            clickAnyButton2(Data.TEXT_I_AGREE, 1);
        }catch (Exception e) {
        }

    }

    /**
     * This method adds affiliation to Group Enrollment using npi
     * @param npi
     */
    public void addAffiliationToGroupEnrollment(String npi) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_NPI_AFFILIATION));
        driver.findElement(Locators.TEXT_FIELD_NPI_AFFILIATION).clear();
        javaWaitSec(3);
        driver.findElement(Locators.TEXT_FIELD_NPI_AFFILIATION).sendKeys(npi);
        driver.findElement(Locators.BUTTON_SEARCH_NPI_AFFILIATION).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_ADD_NPI_AFFILIATION));
        driver.findElement(Locators.BUTTON_ADD_NPI_AFFILIATION).click();
        driver.findElement(Locators.BUTTON_AFFILIATION_TYPE).click();
        clickFirstOptionInList();
        ajaxClick(Locators.POP_UP_DOCUMENT);
        //calendarPopUp.setEndEffectiveDate();
        fillInCalendar(getCurrentDate(), Data.effectiveStartDateCalendar);
        driver.findElement(By.xpath("//label[text()='" + Data.effectiveStartDateCalendar + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(Keys.TAB);
        ajaxClick(Locators.BUTTON_ADD_AFFILIATION);
    }

    /**
     * This method adds affiliation to Pem enrollment using npi
     * @param npi
     */
    public void addAffiliationToPemEnrollment(String npi) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TEXT_FIELD_NPI_AFFILIATION));
        javaWaitSec(2);
        ajaxClick(Locators.TEXT_FIELD_NPI_AFFILIATION);
        javaWaitSec(2);
        WebElement npiFeild = driver.findElement(Locators.TEXT_FIELD_NPI_AFFILIATION);
        javaWaitSec(3);
        npiFeild.sendKeys(Keys.chord(npi, Keys.TAB));
        javaWaitSec(3);
        ajaxClick(Locators.BUTTON_SEARCH_NPI_AFFILIATION);
        javaWaitSec(1);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_ADD_NPI_AFFILIATION));
        ajaxClick(Locators.BUTTON_ADD_NPI_AFFILIATION);
        driver.findElement(Locators.BUTTON_AFFILIATION_TYPE).click();
        driver.findElement(Locators.BUTTON_AFFILIATION_PEMTOINDIV).click();
        ajaxClick(Locators.POP_UP_DOCUMENT);
        //calendarPopUp.setEndEffectiveDate();
        fillInCalendar(getCurrentDate(), Data.effectiveStartDateCalendar);
        driver.findElement(By.xpath("//label[text()='" + Data.effectiveStartDateCalendar + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(Keys.TAB);
        ajaxClick(Locators.BUTTON_ADD_AFFILIATION);
    }

    /**
     * This method gets tracking number
     * @return
     */
    public String getTrackingNumber(){
        javaWaitSec(5);
        WebElement element = driver.findElement(Locators.Tracking_Number);
        String trackingNumber=element.getText();
        return trackingNumber;
    }


    /**
     * This method gets tracking number in ReEnrollment
     * @return
     */
    public String getTrackingNumberInReEnrollment(){
        WebElement element = driver.findElement(Locators.Tracking_Number_ReEnrollment);
        String trackingNumber=element.getText();
        Reports.log("Application Tracking Number: " +trackingNumber);
        return trackingNumber;
    }

    /**
     * This method gets RequestID
     * @return
     */
    public String getRequestID(){
        WebElement element = driver.findElement(Locators.REQUEST_ID);
        String RequestID=element.getText();
        return RequestID;
    }

    /**
     * This method gets RequestID by locator
     * @param locator
     * @return
     */
    public String getRequestID(Object locator) {
        javaWaitSec(10);
        String requestID = null;
        for (int i = 0; i <= 10; i++) {
            try {
                requestID = driver.findElement((By) locator).getText();
                break;
            } catch (Exception e) {
                Reports.log("Page is still loading so refreshing the page.....");
                driver.navigate().refresh();
                javaWaitSec(5);
                requestID = driver.findElement((By) locator).getText();
                javaWaitSec(2);
            }
            Reports.log("Request ID: " + requestID);
        }
        return requestID;
    }


    /**
     * This method clicks and agree provider agreement
     */
    public void clickAndAgreeProviderAgreement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Provider Agreement']")));
        ajaxClick(By.xpath("//h3[text()='Provider Agreement']"));
        try {
            try{
                ajaxScroll(spanContainsText("AGREE AND SIGN"));
                javaWaitSec(2);
                ajaxClick(spanContainsText("AGREE AND SIGN"));
                Reports.log("Click on Agree And Sign button");
            } catch (Exception e) {
                javaWaitSec(5);
                ajaxClick(setAndFindButton("Next"));
                javaWaitSec(5);
                scrollToBottomOfPage();
            }}
        catch (Exception e) {

        }
    }

    /**
     * This method closes provider agreement popUp
     */
    public void closeProviderAgreementpopUp() {
        try {
            driver.findElement(By.xpath("//div[@role='document']//span[text()='Close']")).click();
        } catch (Exception e) {

        }
    }

    /**
     * This method type Notes In PopUp using notes
     * @param notes
     */
    public void typeNotesInPopUp(String notes) {
        for (int i = 0; i < 10; i++) {
            try {
                if (driver.findElement(By.xpath("//textarea[@type='text']")).isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                Reports.log("Exception Found: " + e);
            }
            setFieldValueWithWaits(Locators.POPUP_PENDING_REVIEW_NOTES, notes);
            Reports.log("Type Notes: " + notes);
        }
    }

    /**
     * This method Verifies finger print button using firstName, lastName arguments
     * @param firstName
     * @param lastName
     */
    public void VerifyFingerPrintButton(String firstName, String lastName)
    {
        // driver.navigate().refresh();
        javaWait(5);
        try {
            //javaWaitSec(3);
            fingerprintButton("Verify Fingerprint", firstName, lastName);
        } catch (NoSuchElementException e) {
            Reports.log("No Fingerprinting button available");
        }
    }

    /**
     * This method Verifies payment button using firstName, lastName arguments
     * @param firstName
     * @param lastName
     */
    public void VerifyPaymentButton(String firstName, String lastName)
    {
        try {
            javaWaitSec(3);
            verifyPaymentButton("Verify Payment", firstName, lastName);
        } catch (NoSuchElementException e) {
        }
        javaWaitSec(3);
    }

    /**
     * This method does finger printing process using textOfButton, firstName, lastName
     * @param textOfButton
     * @param firstName
     * @param lastName
     */
    public void fingerprintButton(String textOfButton, String firstName, String lastName) {
        try {
            if (driver.findElement(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")).isEnabled()) {
                clickAnyButton("Verify Fingerprint");
                javaWaitSec(1);
                Reports.log("Clicked on Fingerprinting Button");
                ajaxClick(Locators.RADIOBUTTON_FINGERPRINTING_YES);
                Reports.log("Selected 'Yes' for Are Provider Fingerprints verified as per available data?");
                javaWaitSec(1);
                ajaxClick(By.xpath("//textarea[@type='text']"));
                driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Fingerprints received. Sanity Test for " + firstName + " " + lastName);
                javaWaitSec(1);
                clickAnyButton("Ok");
            }
        }
        catch (Exception e){

        }
    }

    /**
     * This method verifies payment button using textOfButton, firstName, lastName
     * @param textOfButton
     * @param firstName
     * @param lastName
     */
    public void verifyPaymentButton(String textOfButton, String firstName, String lastName) {
        try {
            if (driver.findElement(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")).isEnabled()) {
                clickAnyButton(Data.TEXT_VERIFY_PAYMENT);
                javaWaitSec(1);
                Reports.log("Clicked on Verify Payment Button");
                driver.findElement(Locators.POP_UP_DOCUMENT).findElement(Locators.POPUP_IS_PAYMENT_RECEIVED).click();
                Format f = new SimpleDateFormat("MM/dd/yyyy");
                String strDate = f.format(new Date());
                fillInCalendar(strDate, Data.datepaymentreceived);
                ajaxClick(By.xpath("//textarea[@type='text']"));
                driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Payment Received. Sanity Test for " + firstName + " " + lastName);
                Reports.log("Added Notes: Payment Received. Sanity Test for " + firstName + " " + lastName);
                clickAnyButton(Data.TEXT_VERIFY);
            }
        }catch (Exception e){
            Reports.log("Verify Payment button is disabled");
        }

    }

    /**
     * This method creates site visit button verification using textOfButton, taxonomy
     * @param textOfButton
     * @param taxonomy
     */
    public void createSiteVisitButtonVerification(String textOfButton, String taxonomy) {
        try{
            if (driver.findElement(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")).isEnabled()) {
                Reports.log("Create Site Visit Button Available for taxonomy: " + taxonomy);
            } else {
                Reports.log("Create Site Visit Button is not available");
            }
        }
        catch (Exception e){
        }

    }

    /**
     * This method creates site visit button verification for high risk taxonomy using textOfButton, taxonomy, fname, lName arguments
     * @param textOfButton
     * @param taxonomy
     * @param fname
     * @param lName
     */
    public void createSiteVisitButtonVerificationForHighRiskTaxonomy(String textOfButton, String taxonomy, String fname, String lName) {
        try {
            javaWaitSec(4);
            if (driver.findElement(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")).isEnabled()) {
                Reports.log("Create Site Visit Button Available for taxonomy: " + taxonomy);

                clickAnyButton(textOfButton);
                javaWaitSec(2);
                ajaxScroll(Locators.POPUP_SITEVISIT_DATE);
                driver.findElement(Locators.POPUP_SITEVISIT_REASON).click();
                //  ajaxClick(Locators.POPUP_SITEVISIT_REASON);
                javaWaitSec(3);
                List<WebElement> elements = driver.findElements(By.xpath("(//li[@role='option'])"));
                ajaxClick(elements.get(2));
                javaWaitSec(3);
                ajaxClick(By.xpath("//button[contains(.,'Ok')]"));
                javaWaitSec(5);
                clickAnyHeaderTitLe(Data.textSiteVisitsTab);
                Reports.log("Click header tab: " + Data.textSiteVisitsTab);


                driver.findElement(Locators.TEXT_FIELD_PROVIDER_SITE_VISIT).sendKeys(fname + " " + lName);
                ajaxClick(Locators.BUTTON_SEARCH);
                javaWaitSec(5);

                //sorting the search result as per the date
                driver.findElement(Locators.TABLETITLE_SCHEDULEDATE_SORTBUTTON).click();
                javaWaitSec(1);
                driver.findElement(Locators.TABLETITLE_SCHEDULEDATE_SORTBUTTON).click();
                javaWaitSec(2);

                // scrollToBottomOfPage();
                ajaxClick(Locators.ELLIPSE_BUTTON);
                //driver.findElement(Locators.ELLIPSE_BUTTON).click();
                //Reports.log("Selected siteVise option : " +ajaxGetText(Locators.SELECT_WAVIE_OPTION));
                //+ driver.findElement(Locators.SELECT_WAVIE_OPTION).getText());
                ajaxClick(Locators.SELECT_WAVIE_OPTION);
                //  driver.findElement(Locators.SELECT_WAVIE_OPTION).click();
                javaWaitSec(3);

                driver.findElement(Locators.POPUP_Waive_SITEVISIT_REASON).click();
                List<WebElement> elements1 = driver.findElements(By.xpath("(//li[@role='option'])"));
                ajaxClick(elements1.get(1));
                javaWaitSec(3);
                ajaxClick(Locators.APPLYBUTTON_WAVIE_POPUP);
                javaWaitSec(5);
                ajaxClick(Locators.OK_BUTTON_CONFIRMATION_POPUP);
                javaWaitSec(5);
            } else {
                Reports.log("Create Site Visit Button is not available");
            }
        }
        catch (Exception e){
            Reports.log("Exception "+e);
        }
    }

    /**
     * This method Verifies application status using expectedStatus argument
     * @param ExpectedStatus
     */
    public void VerifyApplicationStatusIs(String ExpectedStatus){
        javaWaitSec(20);
        String appStatus = null;
        for (int i = 0; i < 10; i++) {
            appStatus = driver.findElement(Locators.PROVIDER_DASHBOARD_STATUS).getText();
            if (!appStatus.equalsIgnoreCase(ExpectedStatus)) {
                driver.navigate().refresh();
                javaWaitSec(15);
            }
        }
        Reports.log("Application Status: "+appStatus);
        Assert.assertTrue(ExpectedStatus.equalsIgnoreCase(appStatus));
        // Assert.assertEquals(appStatus,ExpectedStatus);
    }

    /**
     * This method clicks on ReEnrollment appeal button
     */
    public void clickOnReEnrollmentApplBtn(){
        ajaxClick(Locators.PROVIDER_DASHBOARD_REENROLLMENT_APPLICATION_BUTTON);
        javaWaitSec(20);
        Reports.log("Click on 'RE-ENROLLMENT APPLICATION' button");
    }

    /**
     * This method Verifies provider enrollment status using expectedStatus argument
     * @param ExpectedStatus
     */
    public void VerifyProviderEnrollmentStatusIs(String ExpectedStatus){
        javaWaitSec(10);
        String enrollmentStatus = null;
        for (int i = 0; i < 10; i++) {
            enrollmentStatus = driver.findElement(Locators.PROVIDER_ENROLLMENT_STATUS).getText();
            // enrollmentStatus = driver.findElement(Locators.PROVIDER_DASHBOARD_STATUS).getText();
            if (!enrollmentStatus.equalsIgnoreCase(ExpectedStatus)) {
                driver.navigate().refresh();
                javaWaitSec(15);
            }
        }
        Reports.log("Provider Enrollment Status: "+enrollmentStatus);
        Assert.assertTrue(ExpectedStatus.equalsIgnoreCase(enrollmentStatus));
        // Assert.assertEquals(appStatus,ExpectedStatus);
    }

    /**
     * This method Clicks on continue button
     */
    public void ClickOnContinueBtn(){
        // driver.findElement(By.xpath("//span[contains(.,'Continue')]")).click();
        ajaxClick(By.xpath("//span[contains(.,'Continue')]"));
        Reports.log("Clicked on Continue Button");
        javaWaitSec(10);
    }

    /**
     * This method clicks on appeal button
     */
    public void ClickOnAppealButton(){
        javaWaitSec(5);
        ajaxClick(Locators.PROVIDER_DASHBOARD_APPEAL_BUTTON);
        Reports.log("Clicked on Appeal Button");
        javaWaitSec(10);
    }

    /**
     * This method ends affiliation
     */
    public void endAffilliation(){

        List<WebElement> afficationList = driver.findElements(Locators.AFFILIATION_LIST);
        int noOfprovider = afficationList.size();
        Reports.log("No of Provider "+noOfprovider);
        for(int i=1; i<=noOfprovider;i++){
            WebElement affiatedProvider = driver.findElement(By.xpath("(//div[starts-with(@class,'affiliation_provider-list-item_')])["+i+"]"));
            String providerInfo = affiatedProvider.getText();

            if(providerInfo.contains("individual")) {
                Reports.log("providerInfo is     " + providerInfo);
                driver.findElement(By.xpath("(//div[starts-with(@class,'affiliation_table')]/div//following::button)[" + i + "]")).click();
                driver.findElement(By.xpath("(//span[contains(.,'End')])[" + i + "]")).click();
                break;
            }}
    }}