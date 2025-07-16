package com.hhstechgroup.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * EnrollmentsAndCoc class provides functionalities related to enrollments and change of circumstances.
 */
public class EnrollmentsAndCoc extends BaseActions {

    /**
     * This a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public EnrollmentsAndCoc(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method scrolls to specialties Section
     */
    public void scrollToSpecialtiesSection() {
        try {
            if (driver.findElement(By.xpath("//h4")).getText().contains("Specialties")) {
                Reports.log("Scroll to Specialties section");
                ajaxScroll(By.xpath("//h4"));
            }
        } catch (Exception e) {
        }
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
        fillInTaxonomy(0, firstDigitsOfTaxonomy);

        try {
            driver.findElement(By.xpath("//li[text()='This field is required']"));
            Assert.fail("Text field is required!");
        } catch (Exception e) {
        }
    }

    /**
     * This method adds line pharmacy key personal
     *
     * @param index
     */
    public void addLinePharmacyKeyPersonal(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);

        // ajaxScrollByCoordinate(100);

        ajaxClick(Locators.TEXT_FIELD_LICENSE_FIRST_NAME, index);
        ajaxScroll(Locators.TEXT_FIELD_LICENSE_FIRST_NAME, index);
        driver.findElements(Locators.TEXT_FIELD_LICENSE_FIRST_NAME).get(index).sendKeys(generateFirstName());
        driver.findElements(Locators.TEXT_FIELD_LICENSE_LAST_NAME).get(index).sendKeys(generateLastName());
        ajaxClick(Locators.TEXT_FIELD_COUNTRY_OF_BIRTH);
        performClick(setSpecificOptionInListbox("United States"));
        fillInCalendar(Data.dob, Data.dateOfBirthCalendar2);
        driver.findElements(Locators.TEXT_FIELD_SSN_PHARMACY).get(index).sendKeys(Data.ssn);
        ajaxScrollByCoordinate(200);
        ajaxClick(Locators.TEXT_FIELD_MANAGING_EMPLOYEE_TYPE);
        clickAnyOptionInList(1);
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
    }

    /**
     * This method fills in Exclusion and Sanction Section
     */
    public void fillInExclusionAndSanctionSection() {
        javaWaitSec(10);
        Reports.log("Open Section: Exclusion and Sanction Section");
        ajaxClick(Locators.SECTION_PROVIDER_EXCLUSION);
        //driver.findElement(Locators.SECTION_PROVIDER_EXCLUSION).click();

        selectExclusionRadioButtons();
    }

    /**
     * This method selects Exclusion Radio Buttons
     */
    public void selectExclusionRadioButtons() {
        ajaxClick(Locators.RADIOBUTTON_EXCLUSION_CRIMINAL_OFFENCE);
        javaWaitSec(2);
        ajaxClick(Locators.RADIOBUTTON_EXCLUSION_LICENSE_SANCTIONED);
        javaWaitSec(2);
        ajaxClick(Locators.RADIOBUTTON_EXCLUSION_CIVIL_MONEY_PENALTIES);
        javaWaitSec(2);
        ajaxClick(Locators.RADIOBUTTON_EXCLUSION_DEBARRED);
        javaWaitSec(2);
    }

    /**
     * This method adds License Line
     *
     * @param index
     */
    public void addLicenseLine(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);

        Reports.log("Entered License Number: 78A186138");
        driver.findElements(Locators.TEXT_FIELD_LICENSE_NUMBER).get(index).sendKeys("78A186138");

        Reports.log("Entered License Type: " + Data.licenseType);
        clickLicenseInList();

        Reports.log("Entered License Issue State");
        ajaxClick(Locators.DROP_DOWN_LICENSE_ISSUE_STATE);
        clickLicenseStateInList();

        Reports.log("Entered License Effective Date");
        ajaxClick(Locators.CALENDER_LICENSE_EFFECTIVE_DATE2);
        ajaxClick(Locators.CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE);

        Reports.log("Entered License Expiration Date");
        javaWaitSec(1);
        WebElement calender = driver.findElement(By.xpath("(//input[@name='datepicker'])[2]"));
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        String date = changeYearInCurrentDate(3);
        Reports.log("Date is: " + date);
        calender.sendKeys(date);
        calender.sendKeys(Keys.TAB);
        javaWaitSec(1);
//        driver.findElements(Locators.CALENDER_LICENSE_EXPIRATION_DATE2).get(index).click();
//        driver.findElements(Locators.CALENDER_SELECT_28_LICENSE_EXPIRATION_DATE).get(index).click();
//
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
        driver.findElements(Locators.TEXT_FIELD_CERTIFICATION_NUMBER).get(index).sendKeys("78B187000");

        Reports.log("Entered Certification Effective Date");
        ajaxClick(Locators.CALENDER_CERTIFICATION_EFFECTIVE_DATE);
        ajaxClick(Locators.CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE);

        ajaxScrollByCoordinate(200);
        ajaxScroll(setAndFindAnyTitle("Certification Information (Medicare/Board/Agency)", Data.h2));
        setAndFindButton(Data.TEXT_SAVE).click();
    }

    /**
     * This line adds line
     *
     * @param index
     */
    public void addLine(int index) {
        clickAnyButton2(Data.TEXT_ADD_LINE, 0);
        driver.findElements(Locators.TEXT_FIELD_LICENSE_NUMBER).get(index).sendKeys("111");
        ajaxScrollByCoordinate(100);
        setAndFindButton(Data.TEXT_SAVE).click();
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
        driver.findElement(Locators.COMBOBOX_TAXONOMY_PHARAMACY).sendKeys("");
        clickFirstOptionInList();
        // License Number
        driver.findElement(Locators.TEXT_FIELD_LICENSE_NUMBER1_PHARMACY).sendKeys("78A186138");

        //License type
        ajaxClick(setAndFindCombobox("License Type"));
        setAndFindCombobox("License Type").sendKeys("License");
        clickFirstOptionInList();
        // License Issue State
        ajaxClick(setAndFindCombobox("License Issue State"));
        setAndFindCombobox("License Issue State").sendKeys("Wyoming");
        clickFirstOptionInList();

        // License Effective Date
        ajaxClick(Locators.DROP_DOWN_LICENSE_EFFECTIVE_DATE1_PHARMACY);
        Reports.log("Opened License Effective Start Date Calender");
        ajaxClick(Locators.CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE);
        Reports.log("Calendar Selected as the 1st of the month");
        javaWaitSec(1);
        WebElement calender = driver.findElement(By.xpath("(//input[@name='datepicker'])[2]"));
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        String date = changeYearInCurrentDate(3);
        Reports.log("Date is: " + date);
        calender.sendKeys(date);
        calender.sendKeys(Keys.TAB);
        javaWaitSec(1);

//        //License Expiration Date
//        ajaxClick(Locators.DROP_DOWN_LICENSE_EXPIRY_DATE1_PHARMACY);
//        Reports.log("Opened License Effective End Date Calender");
//        wait.until(ExpectedConditions.elementToBeClickable(Locators.CALENDER_SELECT_28_LICENSE_EXPIRATION_DATE));
//        int counter = 0;
//        while (true) {
//            javaWaitSec(1);
//            counter++;
//            if (counter == 5) {
//                throw new RuntimeException("Calender date was not available to be selected");
//            }
//            try {
//                ajaxClick(Locators.CALENDER_SELECT_28_LICENSE_EXPIRATION_DATE);
//                break;
//            } catch (Exception e) {
//                Reports.log("Unable to select the date, trying again. Attempt# " + counter);
//            }
//            Reports.log("Calendar Selected as the 28th of the month");
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//center//h3/a")));
//        ajaxScroll(setAndFindAnyTitle("Pharmacy License information", Data.h4));
//        ajaxScrollByCoordinate(100);

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
        driver.findElement(Locators.TEXT_FIELD_LICENSE_NUMBER2_PHARMACY).sendKeys("78A186138");

        Reports.log("Entered License Type: " + Data.licenseType);
        ajaxClick(Locators.DROP_DOWN_LICENSE_TYPE, index);
        clickLicenseInList();

        Reports.log("Entered License Issue State");
        ajaxClick(Locators.DROP_DOWN_LICENSE_ISSUE_STATE2_PHARMACY, index);
        clickLicenseStateInList();

        Reports.log("Entered License Effective Date");
        ajaxClick(Locators.DROP_DOWN_LICENSE_EFFECTIVE_DATE2_PHARMACY, (index));
        ajaxClick(Locators.CALENDER_SELECT_1_LICENSE_EFFECTIVE_DATE, index);
        Reports.log("Entered License Expiration Date");
        javaWaitSec(1);
        WebElement calender = driver.findElement(By.xpath("(//input[@name='datepicker'])[4]"));
        calender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);
        String date = changeYearInCurrentDate(3);
        Reports.log("Date is: " + date);
        calender.sendKeys(date);
        calender.sendKeys(Keys.TAB);
        javaWaitSec(2);
        setAndFindButton(Data.TEXT_SAVE).click();
//        driver.findElements(Locators.DROP_DOWN_LICENSE_EXPIRY_DATE2_PHARMACY).get(index).click();
//        driver.findElements(Locators.CALENDER_SELECT_28_LICENSE_EXPIRATION_DATE).get(index).click();
//        ajaxScrollByCoordinate(200);
    }
    /**
     * This method collects and unselect Taxonomies Specialties
     */
    public void collectAndUnselectTaxonimiesSpecialties() {
        javaWaitSec(5);
        List<WebElement> specialties = driver.findElements(Locators.CHECKBOX_TAXONOMY_SPECIALTY);
        for (int i = 0; i < specialties.size(); i++) {
            if (specialties.get(i).isSelected()) {
                Reports.log("Unselect taxonomy specialties checkboxes");
                javaWait(500);
                ajaxClick(specialties.get(i));
            }
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
        ajaxClick(Locators.COMBOBOX_TAXONOMY, index);
        //selectValueInCombobox(taxonomy, Locators.COMBOBOX_TAXONOMY, index);
        driver.findElement(Locators.COMBOBOX_TAXONOMY).sendKeys("");
        ajaxScrollByCoordinate(100);
        ajaxScroll(setAndFindAnyTitle("Taxonomies", Data.h2));
        javaWaitSec(2);
        // ajaxScrollByCoordinate(100);
        clickFirstOptionInList();
        javaWaitSec(1);

        //Reports.log ("Debug");
    }

    /**
     * This method fills in Key Personal Section
     */
    public void fillInKeyPersonalSection() {
        Reports.log("Open Section: Key Personnel Section");
        // driver.findElement(Locators.SECTION_PROVIDER_KEY_PERSONNEL).click();
        ajaxClick(Locators.SECTION_PROVIDER_KEY_PERSONNEL);
        addLinePharmacyKeyPersonal(0);

    }

    /**
     * This method searches Specific Enrollment and Clicks
     *
     * @param delay
     * @param status1
     * @param status2
     */
    public void searchSpecificEnrollmentAndClick(int delay, String status1, String status2) {


        for (int i = 0; i < 10; i++) {
            Reports.log("Wait " + delay + " seconds of application");
            javaWaitSec(delay);

            Reports.log("Click button: " + Data.TEXT_SEARCH);
            performClick(setAndFindButton(Data.TEXT_SEARCH));

            try {
                driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText();
                try {
                    if (anyStatusOfEnrollment(status1).isDisplayed()) {
                        break;
                    }
                } catch (Exception e) {
                }
                try {
                    if (anyStatusOfEnrollment(status2).isDisplayed()) {
                        break;
                    }
                } catch (Exception e) {
                }
                Reports.log("Status is not displayed yet");

            } catch (Exception e) {
                Reports.log("Request is not displayed yet");
            }
        }
        javaWaitSec(3);
        driver.findElements(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0).click();
    }

    /**
     * This method searches Specific Enrollment and Clicks
     *
     * @param delay
     * @param status1
     */
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

    /**
     * This method fills Taxonomy and License Information Section
     *
     * @param taxonomyCategory
     * @param taxonomy
     * @param enrollmentType
     */
    public void fillTaxonomyAndLicenseInformationSection(String taxonomyCategory, String taxonomy, String enrollmentType) {

        Reports.log("Open Section: Taxonomy/License Information Section");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SECTION_TAXONOMY));
        ajaxClick(Locators.SECTION_TAXONOMY);
        // driver.findElement(Locators.SECTION_TAXONOMY).click();
        if (enrollmentType.equalsIgnoreCase(Data.pharmacyApplication)) {
            fillInLicensureInPharmacy(taxonomyCategory, taxonomy, 0, Data.pharmacyLicenseNumber);
            return;
        }
        fillInLicensure(taxonomyCategory, taxonomy, enrollmentType);

        if (enrollmentType.equalsIgnoreCase(Data.orpApplication)) {
            addLicenseLine(0);
            return;
        }
        if (enrollmentType.equalsIgnoreCase(Data.facilityApplication)) {
            addLicenseLine(0);
            if (taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                addCertificationLine(0);
            }
            return;
        }


    }

    /**
     * This method searches Specific Enrollment
     *
     * @param delay
     * @param status1
     */
    public void searchSpecificEnrollment(int delay, String status1) {
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
        javaWaitSec(10);
        ajaxScroll(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW);
        ////div[contains(@class, 'tile-table-row')]

        Reports.log(driver.findElement(By.xpath("//button[@aria-label='More'])[1]")).getText());
        driver.findElement(By.xpath("//button[@aria-label='More'])[1]")).click();

    }

    /**
     * This method searches Coc With Specific Status in Provider Portal
     *
     * @param delay
     * @param status1
     */
    public void searchCocWithSpecificStatusInProviderPortal(int delay, String status1) {
        Reports.log("Wait " + delay + " seconds of application with status: " + status1);
        javaWaitSec(delay);
        for (int i = 0; i < 2; i++) {
            Reports.log("Wait " + delay + " seconds of application with status: " + status1);
            javaWaitSec(delay);
            driver.navigate().refresh();

            try {
                System.out.println(driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText());
                try {
                    if (anyStatusOfCoc(status1, 0).isDisplayed()) {
                        break;
                    }
                } catch (Exception e) {
                }

                Reports.log("Status is not displayed yet");

            } catch (Exception e) {
                Reports.log("Status is not displayed yet");
            }

        }
        javaWaitSec(3);
        Reports.log("Status is " + status1);
        driver.findElements(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0).click();
    }

    /**
     * This method get Request Id From Specific Enrollment
     *
     * @param delay
     * @param status
     * @return
     */
    public Integer getRequestIdFromSpecificEnrollment(int delay, String status) {
        String requestId = null;

        for (int i = 0; i < 10; i++) {
            Reports.log("Wait " + delay + " seconds of application with status Under screening");
            javaWaitSec(delay);
            Reports.log("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(By.xpath("//button[contains(@class, 'search-box-action')]"));
            performClick(By.xpath("//button[contains(@class, 'search-box-action')]"));

            try {
                requestId = driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText();
                if (anyStatusOfEnrollment(status).isDisplayed()) {
                    break;
                } else {
                    Reports.log("Status is not displayed yet");
                }
            } catch (Exception e) {
                Reports.log("Request is not displayed yet");
            }

        }
        if (requestId == null) {
            Assert.fail();
        }
        Reports.log("Request id: " + requestId);
        Reports.log("Parse request id to integer");
        int numRequestId = Integer.parseInt(requestId);
        Reports.log("Parse was successful: " + numRequestId);

        return numRequestId;
    }

    /**
     * This method changes Status of application
     *
     * @param status
     */
    public void changeStatus(String status) {
        closeNpiPoUp();
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
        if (status.equalsIgnoreCase("Approved")) {
            clickAnyOptionInList(0);
        } else if (status.equalsIgnoreCase("Denied")) {
            clickAnyOptionInList(1);
            if (ifStatus("Denied")) {
                driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
                clickFirstOptionInList();
            }
        } else if (status.equalsIgnoreCase("Requested additional information")) {
            driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
            clickFirstOptionInList();
        }


        clickAnyButton(Data.TEXT_APPLY);
    }

    /**
     * This method Returns a boolean checking if the status is displayed
     *
     * @param statusText
     * @return
     */
    public boolean ifStatus(String statusText) {
        boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + statusText + "')]")).isDisplayed();
        return status;
    }

    /**
     * This method searches and Change Status OF Application
     *
     * @param Status
     */
    public void searchAndChangeStatusOFApplication(String Status) {
        searchSpecificEnrollmentAndClick(10, "PENDING APPROVAL");
        javaWaitSec(10);
        changeStatusOfApplication(Status);
    }

    /**
     * This method searches and Change Status OF Application With Reason
     *
     * @param Status
     */
    //10-21-2021 MR
    public void searchAndChangeStatusOFApplicationWithReason(String Status) {
        searchSpecificEnrollmentAndClick(10, "PENDING APPROVAL");
        javaWaitSec(10);
        changeStatusWithReason(Status);
    }

    /**
     * This method navigates to Appeal And Search For Enrollment
     */
    public void navigateToAppealAndSearchForEnrollment() {
        clickAnyButton(Data.TEXT_GO_TO_APPEALS);

        //10-27-2021-MR Commented this line because it appears no to be needed
        //10-27-2021-MR and may be permanently removed at some point
        //searchSpecificEnrollmentAndClick(5, "UNDER_REVIEW");
    }

    /**
     * This method changes Status Of Application
     *
     * @param givenStatus
     */
    public void changeStatusOfApplication(String givenStatus) {
        closeAlert();
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        javaWaitSec(2);
        // ajaxClick(Locators.POPUP_INNER_ENROLLMENT_STATUS);
        performClick(Locators.POPUP_INNER_ENROLLMENT_STATUS);
        javaWaitSec(2);
        // driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();

        if (givenStatus.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
        }
        if (givenStatus.contains("Denied")) {
            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
            ifStatus("Denied");
            driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
            clickFirstOptionInList();
        }
        //    driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        javaWaitSec(5);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(7);

        ajaxClick(Locators.STATUS_ENROLLMENT_DETAILS);
        String applicationStatus = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
        Reports.log("Application Status: " + applicationStatus);
    }

    /**
     * This method changes Status With Reason
     *
     * @param statusOfApplication
     */
    public void changeStatusWithReason(String statusOfApplication) {
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();

        if (statusOfApplication.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
        } else if (statusOfApplication.contains("Denied")) {
            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        }
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        clickFirstOptionInList();
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(20);
        driver.navigate().refresh();
        javaWaitSec(10);

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
                        javaWaitSec(10);
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
                    javaWaitSec(15);
                }
            }
        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));

//
    }

    /**
     * This method verifies the Status Of Application
     *
     * @param applicationStatus
     */
    //MR-1108-2021 Added to verify the status of CoC
    public void verifyTheStatusOfApplication(String applicationStatus) {
        //wait.until(ExpectedConditions.visibilityOf(spanContainsText(applicationStatus)));
        for (int i = 0; i < 10; i++) {
            try {
                try {
                    javaWaitSec(20);
                    WebElement appStatusElement = divContainsText(applicationStatus);
                    String appStatus = appStatusElement.getText();
                    System.out.println("Application Status: " + appStatus);
                    if (appStatus.equals(applicationStatus)) {
                        break;
                    }
                } catch (Exception e) {
                    if (spanContainsText("SYNC_FAILED").isDisplayed()) {
                        System.out.println("Application Status: SYNC_FAILED");
                        Assert.fail("Application Status: SYNC_FAILED");
                    }
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
                if (i == 9) {
                    Assert.fail("Application Status is not: " + applicationStatus);
                }
            }
        }
    }

    /**
     * This method gets Specific Coc And Appeal
     *
     * @param TrackNum
     */
    public void getSpecificCocAndAppeal(String TrackNum) {
        List<WebElement> cocList = driver.findElements(By.xpath("//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div"));
        int noOfCoc = cocList.size();
        Reports.log("No of Cocs " + noOfCoc);
        for (int i = 1; i <= noOfCoc; i++) {
            WebElement coc = driver.findElement(By.xpath("(//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div)[" + i + "]"));
            String cocInfo = coc.getText();
            if (cocInfo.contains(TrackNum)) {
                Reports.log("cocInfo contains  " + cocInfo);
                driver.findElement(By.xpath("(//div[contains(@class, 'tile-table-body')]//button[@aria-label='More'])[" + i + "]")).click();
                javaWaitSec(1);
                driver.findElement(Locators.SELECT_APPEAL_OPTION).click();
                javaWaitSec(1);
                break;
            }
        }
    }
}
