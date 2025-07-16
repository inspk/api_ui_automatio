package com.hhstechgroup.common;

import com.hhstechgroup.provider.EnrollmentPageProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * This class supports the creation, population and navigation of Provider Change Of Circumstance (CoC) requests.
 */

public class Coc extends BaseActions {

    EnrollmentsAndCoc enrollmentsAndCoc = new EnrollmentsAndCoc(driver, wait);
    EnrollmentPageProvider enrollmentPageProvider= new EnrollmentPageProvider(driver, wait);

    /**
     * This constructor method creates a Coc object using driver and wait arguments
     * @param driver
     * @param wait
     */
    public Coc(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    /**
     * This method populates the Mailing Address Contact Person Middle Name displayed on the COC Address Details tab
     * and submits the CoC request (Individual, Group, Facility, ORP enrollmentType arguments) OR clicks Yes for 'Is
     * Billing Address same as Mailing Address?' displayed on the COC Address Details tab and submits the CoC request
     * (PEM, Pharmacy enrollmentType arguments).
     * @param enrollmentType
     */
    public void fillInAddressChangesInCocForm(String enrollmentType) {
        javaWaitSec(3);
        ajaxClick(Locators.SECTION_PROVIDER_ADDRESS_DETAILS);
        checkInvalidDataEmailsInCoc();
        if (enrollmentType.contains("pem") || enrollmentType.contains("pharmacy")) {
            ajaxClick(By.xpath("//input[contains(@name, 'Mailing Address')][@value='true']"));
        } else {
            WebElement middleName = driver.findElement(Locators.COC_SECTION).findElement(Locators.TEXT_FIELD_MIDDLE_NAME);
            ajaxClear(middleName);
            ajaxSendKeys(middleName,generateFirstName() );
            // middleName.clear();
//            middleName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//            middleName.sendKeys(generateNewNumber(2));
        }
        javaWaitSec(3);
        driver.findElement(Locators.SECTION_SUMMARY).click();
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(3);
    }
//
//    //LK: Issue WYCSD-489 was opened (The address is not getting updated)
//    //10-07-21-MR: Updated method to fix element not intractable exception
//    public void cocAddressDetails() {
//        javaWaitSec(5);
//        WebElement address = driver.findElement(Locators.TEXT_FIELD_ADDRESS);
//        javaWaitSec(5);
//        ajaxClear(Locators.TEXT_FIELD_ADDRESS);
//        javaWaitSec(5);
//        //clearContent(Locators.TEXT_FIELD_ADDRESS);
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].value = Keys.chord(Keys.CONTROL), \"a\", Keys.DELETE;", driver.findElement(Locators.TEXT_FIELD_ADDRESS));
//          address.sendKeys(Keys.chord(Keys.CONTROL), "a", Keys.DELETE);
//        javaWaitSec(5);
//        //enrollmentPageProvider.setFieldValueWithWaits(Locators.TEXT_FIELD_ADDRESS,Data.cocAddress2);
//        ajaxSendKeys(Locators.TEXT_FIELD_ADDRESS,Data.cocAddress2);
//        Reports.log("Enter new address: "+Data.cocAddress2);
//        javaWaitSec(3);
//        ajaxClick(address);
//        //   ajaxSendKeys(address, Keys.SPACE);
//        address.sendKeys(Keys.SPACE);
//        javaWaitSec(5);
//        List<WebElement> addressChange = driver.findElements(By.xpath("//div[contains(@id,'react-autowhatever')]/ul/li"));
//        for (WebElement ele : addressChange) {
//            if (ele.getText().contains(Data.cocAddress2)) {
//                Reports.log("Matching address");
//                ajaxClick(ele);
//            } else {
//                Reports.log("No matching address");
//            }
//            javaWaitSec(3);
//        }
//        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
//        ajaxClick(Locators.SECTION_SUMMARY);
//        javaWaitSec(10);
//        clickAnyButton(Data.TEXT_SUBMIT);
//        javaWaitSec(10);
//    }

    /**
     * This method populates the Mailing Address on the COC Address Details tab with a SmartyStreets verified
     * address and submits the CoC request (Regression version).
     */
    //10-21-2021-MR Updated to failure when attempt is made to populate address field
    //10-21-2021-MR Original code is comment out above
    public void cocAddressDetails() {
        WebElement address = driver.findElement(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        ajaxClear(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        //address.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(2);
        address.sendKeys(Data.cocAddress2);
        javaWaitSec(5);
        ajaxClear(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        address.sendKeys(Data.cocAddress2);
        javaWaitSec(10);
        List<WebElement> addressChange = driver.findElements(By.xpath("//div[contains(@id,'react-autowhatever')]/ul/li"));
        for (WebElement ele : addressChange) {
            if (ele.getText().contains(Data.cocAddress2)) {
                Reports.log("Matching address");
                ajaxClick(ele);
            } else {
                Reports.log("No matching address");
            }
            javaWaitSec(3);
        }
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        javaWaitSec(10);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(10);
    }

    /**
     * This method populates the alternate email on the COC Identifying information tab and submits the CoC request.(Using clearContent method)
     * @param emailPrefix
     * @param domain
     */
    public void cocAlternateEmail(String emailPrefix, String domain){
        closeAlert();
        WebElement AltenateEmail = driver.findElement(Locators.ENROLLMENT_SECTION).findElement(Locators.TEXT_FIELD_ALTERNATE_EMAIL_ADDRESS);
        AltenateEmail.clear();
        javaWaitSec(5);
//        AltenateEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        javaWaitSec(1);
//        AltenateEmail.sendKeys(Keys.BACK_SPACE);
//        javaWaitSec(1);
        clearContent(AltenateEmail);
        AltenateEmail.sendKeys(generateEmail(emailPrefix,domain));
        Reports.log("Altenate Email: " + generateEmail(emailPrefix,domain));
        javaWaitSec(5);
        AltenateEmail.sendKeys(Keys.TAB);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(3);
    }

//    /**
//     * This method populates the alternate email on the COC Identifying information tab and submits the CoC request.(Without Using clearContent method)
//     * @param emailPrefix
//     * @param domain
//     */
//  public void cocAlternateEmail(String emailPrefix, String domain){
//        closeAlert();
//        javaWaitSec(1);
//        driver.findElement(Locators.ENROLLMENT_SECTION).findElement(Locators.TEXT_FIELD_ALTERNATE_EMAIL_ADDRESS).clear();
//        javaWaitSec(1);
//        WebElement field = driver.findElement(Locators.TEXT_FIELD_ALTERNATE_EMAIL_ADDRESS);
//        field.sendKeys(generateEmail(emailPrefix,domain));
//        javaWaitSec(1);
//        field.sendKeys(Keys.TAB);
//        javaWaitSec(1);
//        Reports.log("Altenate Email: " + generateEmail(emailPrefix,domain));
//        javaWaitSec(5);
//        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
//        ajaxClick(Locators.SECTION_SUMMARY);
//        clickAnyButton(Data.TEXT_SUBMIT);
//        javaWaitSec(3);
//    }
    public void cocProviderIdentifier(){
        closeAlert();
        Reports.log("Select radio-button yes in, Do you have a Medical Director?");
        driver.findElement(Locators.RADIOBUTTON_MEDICAL_SERVICES).click();
        WebElement medicalDirector = driver.findElement(Locators.COC_SECTION).findElement(Locators.TEXT_FIELD_MEDICAL_DIRECTOR);
        medicalDirector.clear();
        javaWaitSec(5);
        medicalDirector.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(5);
        medicalDirector.sendKeys(generateFirstName()+ " "+ generateLastName());
        Reports.log("Medical Director: " + generateFirstName()+ " "+ generateLastName());
        javaWaitSec(5);
        medicalDirector.sendKeys(Keys.TAB);
        javaWaitSec(3);
        Reports.log("Select radio-button yes in, Are you a Treating Provider?");
        driver.findElement(Locators.RADIOBUTTON_TREATING_PROVIDER).click();
        javaWaitSec(3);
        Reports.log("Select radio-button yes in, Do you have Electronic Data Interchange (EDI) or Trading partner Authorization?");
        driver.findElement(Locators. RADIOBUTTON_ELECTRONIC_DATA_INTERCHANGE).click();
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(3);
    }
    public void cocProviderKeyPersonnel(int index, String employeeType){
            clickAnyButton2(Data.TEXT_ADD_LINE, 0);
            ajaxClick(Locators.TEXT_FIELD_LICENSE_FIRST_NAME, index);
            ajaxScroll(Locators.TEXT_FIELD_LICENSE_FIRST_NAME, index);
            driver.findElements(Locators.TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(generateFirstName());
            Reports.log("First name: " + generateFirstName());
            driver.findElements(Locators.TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(generateLastName());
            Reports.log("Last name: " + generateLastName());
            ajaxClick(Locators.TEXT_FIELD_COUNTRY_OF_BIRTH);
            performClick(setSpecificOptionInListbox("United States"));
            fillInCalendar(Data.dob, Data.dateOfBirthCalendar2);
            driver.findElements(Locators.TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(Data.ssn);
            ajaxScrollByCoordinate(200);
            ajaxClick(Locators.TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
            clickAnyOptionInList(employeeType);
            ajaxScrollByCoordinate(100);
            setAndFindButton(Data.TEXT_SAVE).click();
            ajaxClick(setAndFindButton(Data.TEXT_NEXT));
            ajaxClick(Locators.SECTION_SUMMARY);
            clickAnyButton(Data.TEXT_SUBMIT);
            javaWaitSec(3);
        }

    public void cocRequestForRetroActive(String date){
        closeAlert();
        Reports.log("Open Section: Request Retroactive Adjustment Section");
        ajaxClick(Locators.SECTION_REQUEST_RETROACTIVE_ADJUSTMENT);
        javaWaitSec(1);
        WebElement radioButton = driver.findElement(Locators.RADIOBOX_REQUEST_RETROACTIVE);
        Reports.log("Selected Yes on Question 'Do you want to be approved retroactively?'");
        radioButton.click();
        WebElement justification = driver.findElement(Locators.JUSTIFICATION_REQUEST_RETROACTIVE_ADJUSTMENT);
        justification.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        justification.sendKeys("Retroactive Request");
        javaWaitSec(1);
        WebElement calender = driver.findElement(Locators.CALANDER_REQUEST_RETROACTIVE_ADJUSTMENT);
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
       // String date = changeDayInCurrentDate(-7);
        calender.sendKeys(date);
        calender.sendKeys(Keys.TAB);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        javaWaitSec(2);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(3);
    }

     /**
     * This method populates the Mailing Address on the COC Address Details tab with the cocAddress argument, selects
     * the SmartyStreets verified address and submits the CoC request (Sanity version).
     * @param cocAddress
     */
    //10-28-2021-MR Added method for Sanity CocAndAppeals
    public void cocAddressDetails(String cocAddress) {
        WebElement address = driver.findElement(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        ajaxClear(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        //address.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        address.sendKeys(cocAddress);
        javaWaitSec(5);
        ajaxClear(Locators.TEXT_FIELD_ADDRESS);
        javaWaitSec(5);
        address.sendKeys(cocAddress);
        javaWaitSec(10);
        List<WebElement> addressChange = driver.findElements(By.xpath("//div[contains(@id,'react-autowhatever')]/ul/li"));
        for (WebElement ele : addressChange) {
            if (ele.getText().contains(cocAddress)) {
                Reports.log("Matching address");
                ajaxClick(ele);
            } else {
                Reports.log("No matching address");
            }
            javaWaitSec(3);
        }
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        javaWaitSec(10);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(10);
    }

    /**
     * This method uploads a document on the COC Upload Documents tab and submits the CoC request.
     */
    public void uploadSupportingDocuments () {
        ajaxClick(Locators.SECTION_UPLOAD_DOCUMENTS);
        Reports.log("Click on Upload file Button");
        ajaxUploadFile(Locators.INPUT_UPLOAD_DOCUMENTS);
        javaWaitSec(5);
        Reports.log("Upload the file");
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(5);
    }

    /**
     * This method populates the Provider Middle Name on the COC Identifying Information tab with a randomly generated
     * name and submits the CoC request (Individual, ORP, PEM Enrollment Types).
     */
    public void cocIdentifyingInformation () {
//        MR-11-08-2021 Updated method to use generated Middle Name
//        ORIGINAL METHOD CODE
//        WebElement middleName = driver.findElement(Locators.COC_SECTION).findElement(Locators.TEXT_FIELD_MIDDLE_NAME);
//        middleName.clear();
//        javaWaitSec(5);
//        middleName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        javaWaitSec(5);
//        middleName.sendKeys("M");
//        middleName.sendKeys(Keys.TAB);
//        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
//        ajaxClick(Locators.SECTION_SUMMARY);
//        clickAnyButton(Data.TEXT_SUBMIT);
//        javaWaitSec(3);

        WebElement middleName = driver.findElement(Locators.COC_SECTION).findElement(Locators.TEXT_FIELD_MIDDLE_NAME);
        middleName.clear();
        javaWaitSec(5);
        middleName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(5);
        middleName.sendKeys(generateFirstName());
        javaWaitSec(5);
        middleName.sendKeys(Keys.TAB);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(3);
    }

    /**
     * This method populates the Provider Name on the COC Identifying Information tab with a randomly generated
     * name and submits the CoC request (Group, Facility, Pharmacy Enrollment Types).
     */
    //MR-Updated method to use generated name
    public void cocIdentifyingInformationGeneratedName() {
        javaWaitSec(3);
        ajaxClick(Locators.identifying_information);
        WebElement provider_Name = driver.findElement(Locators.Provider_Name);
        provider_Name.clear();
        javaWaitSec(5);
        provider_Name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(5);
        provider_Name.sendKeys(generateFirstName());
        javaWaitSec(5);
        provider_Name.sendKeys(Keys.TAB);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(10);
    }

    /**
     * This method adds an entry to the license table displayed on the CoC Taxonomy/License Information tab, adds a
     * document to the CoC Upload Documents tab and submits the CoC.
     * @param enrollmentType
     * @param index
     */
    public void cocAddLicenseInformation(String enrollmentType, int index) {
        closeAlert();
        enrollmentsAndCoc.addLicenseLine(index);
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(10);
    }

    /**
     * This method adds an entry to the Key Personnel table displayed on the Key Personnel tab and submits the CoC.
     */
    public void cocAddKeyPersonnel() {
        closeAlert();
        enrollmentsAndCoc.fillInKeyPersonalSection();
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(10);
    }
//        public void checkInvalidDataEmailsInCoc () {
//            List<WebElement> emails = driver.findElements(Locators.TEXT_FIELD_EMAIL_ADDRESS);
//            for (int i = 0; i < emails.size(); i++) {
//                String value = emails.get(i).getAttribute("value");
//                if (value.contains("INVALID DATA")) {
//                    emails.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//                    emails.get(i).sendKeys("11@gmail.com");
//                }
//            }
//            javaWaitSec(3);
//        }
//        ajaxClick(Locators.SECTION_SUMMARY);
//        clickAnyButton(Data.TEXT_SUBMIT);
//        javaWaitSec(3);
//    }

    /**
     * This method populates the Provider First Name and Last Name on the COC Identifying Information tab with randomly
     * generated names and submits the CoC request (PEM Enrollment Type).
     */
    public void fillInIdentifyingInCocFormPEM() {
        javaWaitSec(3);
        ajaxClick(Locators.identifying_information);
        WebElement first_Name= driver.findElement(By.xpath(Locators.first_name));
        ajaxClear(By.xpath(Locators.first_name));
        ajaxSendKeys(By.xpath(Locators.first_name),generateFirstName());
        WebElement last_name= driver.findElement(By.xpath(Locators.last_name));
        ajaxClear(By.xpath(Locators.last_name));
        ajaxSendKeys(By.xpath(Locators.last_name),generateLastName());
        ajaxClick(setAndFindButton(Data.TEXT_NEXT));
        javaWaitSec(1);
        ajaxClick(Locators.SECTION_SUMMARY);
        clickAnyButton(Data.TEXT_SUBMIT);
        javaWaitSec(3);
    }

    /**
     * This method checks for the value 'INVALID DATA' in the Mailing Address Contact Person Details section Email
     * field on the Address Details tab and replaces the value with with a proper email address if found.
     */
    public void checkInvalidDataEmailsInCoc() {
        List<WebElement> emails = driver.findElements(Locators.TEXT_FIELD_EMAIL_ADDRESS);
        for (int i = 0; i < emails.size(); i++) {
            String value = emails.get(i).getAttribute("value");
            if (value.contains("INVALID DATA")) {
                emails.get(i).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                emails.get(i).sendKeys("11@gmail.com");
            }
        }
    }

    /**
     * This method clicks the CoC link displayed on the menu bar, then clicks the '+Add Change of Circumstance' button
     * displayed on the CoC page.
     */
    public void navigateToCoCTabAndClickCoCButton () {
        ajaxClick(Locators.COC_TAB);
        Reports.log("Click on Add Change od Circumstance button under Enrollment info");
        clickAnyButton(Data.TEXT_ADD_COC);
        javaWaitSec(10);
    }

    /**
     * This method clicks the '+Add Change of Circumstance' button displayed on the CoC page.
     */
    public void clickOnAddCOCButton(){
        clickAnyButton(Data.TEXT_ADD_COC);
        javaWaitSec(5);
    }

    /**
     * This method clicks 'Next' on the CoC selection popup, selects the 'Address Details' category, then clicks
     * 'Create' (PEM, Individual, Group, Facility enrollmentType arguments) OR selects the 'Address Details' category on the
     * CoC selection popup, then clicks 'Create' (ORP, Pharmacy enrollmentType arguments).
     * @param enrollmentType
     */
    public void createCoCForEnrollment(String enrollmentType) {
        if (enrollmentType.contains("pem") || enrollmentType.contains("individual") || enrollmentType.contains("group") || enrollmentType.contains("facility")) {
            ajaxClick(driver.findElement(Locators.POP_UP_DOCUMENT).findElement(setLocatorOfAnyButton(Data.TEXT_NEXT)));
        }
        clickAnyButton(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_ADDRESS);
        if (enrollmentType.contains("pem") || enrollmentType.contains("individual") || enrollmentType.contains("group") || enrollmentType.contains("facility")) {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE));
            clickAnyButton(Data.TEXT_CREATE);
        } else {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE_COC));
            clickAnyButton(Data.TEXT_CREATE_COC);
        }
    }

    /**
     * This method clicks 'Next' on the CoC selection popup, selects the 'Address Details' category, then clicks
     * 'Create' (PEM, Individual, Group, Facility enrollmentType arguments) OR selects the 'Address Details' category on the
     * CoC selection popup, then clicks 'Create' (ORP, Pharmacy enrollmentType arguments).
     * @param enrollmentType
     * @param textOfButton
     */
    public void createCoCForEnrollment(String enrollmentType, String textOfButton) {
        if (enrollmentType.contains("pem") || enrollmentType.contains("individual") || enrollmentType.contains("group") || enrollmentType.contains("facility")) {
            ajaxClick(driver.findElement(Locators.POP_UP_DOCUMENT).findElement(setLocatorOfAnyButton(Data.TEXT_NEXT)));
        }
        javaWaitSec(1);
        clickAnyButton(textOfButton);
        if (enrollmentType.contains("pem") || enrollmentType.contains("individual") || enrollmentType.contains("group") || enrollmentType.contains("facility")) {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE));
            clickAnyButton(Data.TEXT_CREATE);
        //else if is needed because the 'Create CoC' button contains spaces when Ownership or Program Participation
        //CoC option is selected
        } else if (enrollmentType.contains(Data.pharmacyApplication) || enrollmentType.contains(Data.orpApplication) &&
                  (textOfButton.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP) ||
                  textOfButton.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN))) {
                    ajaxScroll(setAndFindButton(Data.TEXT_CREATE_COC_SPACED));
                    clickAnyButton(Data.TEXT_CREATE_COC_SPACED);
        } else {
            ajaxScroll(setAndFindButton(Data.TEXT_CREATE_COC));
            clickAnyButton(Data.TEXT_CREATE_COC);
        }
    }

    /**
     * This method clicks 'Next' on the CoC selection popup, selects the CoC category based on cocType argument, then
     * clicks 'Create'
     * @param cocType
     */
    public void createCoc(String cocType){
        ajaxClick(driver.findElement(Locators.POP_UP_DOCUMENT).findElement(setLocatorOfAnyButton(Data.TEXT_NEXT)));
        clickAnyButton(cocType);
        javaWaitSec(2);;
        Reports.log("Selected categories to change is "+cocType);
        ajaxScroll(setAndFindButton(Data.TEXT_CREATE));
        clickAnyButton(Data.TEXT_CREATE);
        javaWaitSec(3);;
    }

    /**
     * This method populates the Mailing Address Contact Person Middle Name displayed on the COC Address Details tab,
     * then clicks 'Go to Change of Circumstance' (All enrollmentType arguments).
     * @param enrollmentType
     */
    public void changeTheAddressForCoC(String enrollmentType) {
        fillInAddressChangesInCocForm(enrollmentType);
        clickAnyButton(Data.TEXT_GO_TO_COC);
        javaWaitSec(3);
    }


    /**
     * This method compares the text displayed on an Error Message popup with the errMsg argument specified
     * @param errMsg
     */
    public void verifyCocErrorMessageAs(String errMsg){
        //"//div[starts-with(@class,'auto-assign_empty')]
        javaWaitSec(3);
        String popUpErrorMsg =   driver.findElement(By.xpath("//div[starts-with(@class,'coc_popup-inner')]")).getText();
        ajaxClick(By.xpath("//span[contains(.,'OK')]"));
        Reports.log("Displayed Error Message: " +popUpErrorMsg);
        Reports.log("Clicked on Ok button on pop up window");
        Assert.assertTrue(errMsg.equalsIgnoreCase(popUpErrorMsg));
        javaWaitSec(3);

    }

    /**
     * This method retrieves the CoC Request ID from a CoC request listed on the Change of Circumstance Request History
     * @return CoC Request ID
     */
    //10-21-2021-MR Added method to capture CoC Application ID
    public String getProviderCoCID(){
        javaWaitSec(5);
        String cocID = driver.findElement(Locators.PROVIDER_COC_ID).getText();
        Reports.log("Providers Tracking Number:"+cocID);
        return cocID;
    }

//public void fillInLicensureChangesInCocForm(){
//  simpleClickAnyCheckbox("Licensure");
//  clickAnyButton(Data.TEXT_CREATE);
//  ajaxClick(Locators.SECTION_TAXONOMY);
//  clickAnyButton(Data.TEXT_NEXT);
//  scrollToBottomOfPage();
//  enrollmentsAndCoc.collectAndUnselectTaxonimiesSpecialties();
//  clickAnyButton("Next");
//  enrollmentsAndCoc.fillInLicensure(Data.specialityDental, Data.specialityPhysicalTherapy);
//  javaWaitSec(3);
//  driver.findElement(Locators.SECTION_SUMMARY).click();
//  clickAnyButton(Data.TEXT_SUBMIT);
//}
}
