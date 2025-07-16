package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.utility.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hhstechgroup.Pages.CocsPage.IDENTIFYING_INFO_XPATH_GENDER_INPUT;
import static io.restassured.RestAssured.given;

public class IUEnrollmentPage extends BaseActions {
    Assert softAssert;
    public static final By BUTTON_MORE_MENU = By.xpath("//button[@aria-label='More']");
    public static final By BUTTON_MORE = By.xpath("//svg[@aria-hidden='true']");

    public static final By POPUP_INNER_ENROLLMENT_STATUS = By.xpath("//div[contains(@class, 'requests_popup-inner')]");
    public static final By POPUP_CHANGE_STATUS = By.xpath("(//div[@role='button'])[2]");//
//public static final By POPUP_CHANGE_STATUS = By.xpath("//div[contains(@class,'MuiDialog')]//div[contains(@id,'Status')]");

    public static final By POPUP_PENDING_REVIEW_REASON = By.xpath("(//div[@role='button'])[2]");
    public static final By TEXT_FIELD_PROVIDER_ID = By.xpath("//input[@id='ProviderID']");
    public static final By TEXT_FIELD_REQUEST_ID = By.xpath("//input[@id='RequestID']");
    public static final By PART_OF_ENROLLMENT_INFO =
            By.xpath("//div[contains(@class, 'tile-table-column')]//p");
    public static final By PART_OF_ENROLLMENT_INFO_STATUS = By.xpath("(//div[contains(@class, 'tile-table-column')]//p)[4]");
    public static final By PART_OF_ENROLLMENT_PENDING_REVIEW =
            By.xpath("//div[contains(@class, 'tile-table-column')]//p[contains(text(), 'PENDING REVIEW')]");
    public static final By INDIVIDUAL_TYPE_ENROLLMENT_ROW = By.xpath("//div[contains(@class, 'tile-table-row')]");
    public static final By CREATE_SITE_VISIT_BUTTON = By.xpath("//span[contains(text() ,'Create Site Visit')]");
    public static final By WAIVE_THE_CREATE_SITE_YES_RADIO_BTN = By.xpath("//input[@value='true']");
    public static final By BUTTON_SITEVISIT = By.xpath("//span[contains(.,'Site visit')]");
    public static final By BUTTON_CREATE_SITEVISIT_POPUP = By.xpath("//span[contains(.,'Create')]");
    public static final By TEXTBOX_POPUP_CREATESITEVISIT_PROVIDERID = By.xpath("//input[@id='provider']");
    public static final By BUTTON_APPROVE_REASON = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");
    public static final By POPUP_IS_PAYMENT_RECEIVED = By.xpath("//input[contains(@name, 'paymentVerification')]");
    public static final By POPUP_SITEVISIT_SELECT_LOCATION_DROPDOWN = By.xpath("//div[contains(@id,'Please select locations to create site visit')]");
    public static final By SELECT_STATUS_DENIED = By.xpath(".//ul[@role='listbox']/li[contains(text(),'Denied')]");

    public static final By POPUP_SITEVISIT_DATE = By.xpath("//input[contains(@placeholder,'MM/DD/YYYY')]");
    //  public static final By POPUP_SITEVISIT_REASON = By.xpath("(//div[contains(@tabindex,'0')])[3]");
    // public static final By POPUP_SITEVISIT_REASON = By.xpath("(//div[contains(@role,'button')])[2]");
    public static final By POPUP_SITEVISIT_REASON = By.xpath("//div[contains(@id,'Select reason')]//../div");

    public static final By POPUP_Waive_SITEVISIT_REASON = By.xpath("(//div[contains(@role,'button')])[6]");
    public static final By TEXT_FIELD_PROVIDER_SITE_VISITS = By.cssSelector("input#ProviderSiteVisit");
    public static final By STATUS_ENROLLMENT_DETAILS = By.xpath("(//span[contains(.,'Status')]//following::div//div)[1]");
    public static final By ChangeStatus_Button = By.xpath("//span[.='Change status']");
    //FINGERPRINTING
    public static final By RADIOBUTTON_FINGERPRINTING_YES = By.xpath("//input[contains(@value ,'true')]");
    public static final By RADIOBUTTON_FINGERPRINTING_NO = By.xpath("//input[contains(@value ,'false')]");
    public static final By RADIOBUTTON_FINGERPRINTING_NOT_APPLICABLE = By.xpath("//input[contains(@value ,'na')]");

    public static final By AGENT_ID = By.xpath("(//textarea[@type='text'])[1]");
    public static final By NOTE_TO_PROVIDER = By.xpath("//div[contains(@class,'requests_select')]//label[text()='Notes to provider']");
    public static final By TEXT_FIELD_ENROLLMENT_TYPE = By.xpath("//div[text()='Enrollment Type']");
    public static final By TEXT_FIELD_PROVIDER_NAME_ID = By.cssSelector("input#providerName");

    public static final By PROVIDERS_SUMMARY_TAB = By.xpath("//span[contains(text(),'Summary')]");
    public static final By PROVIDERS_ROWS_IN_TABLE = By.xpath("//div[contains(@class, 'tile-table-row')]");

    public static final By COC_TAB = By.xpath("//a[contains(text(),'CoC')]");

    public static final By TYPE_SEARCH_INPUT = By.xpath("//div[contains(text(),'Type')]/parent::div/div/div/input");
    public static final By INPUT_TITLE_ENROLLMENT_DETAILS = By.xpath("//input[contains(@name,'Title')]");
    public static final By INPUT_DEGREE_ENROLLMENT_DETAILS = By.xpath("//h2[text()='Degree']");
    public static final By ENROLLMENT_SECTION = By.xpath("//div[contains(@class,'section_section-inner')]");
    public static final By TITLE_ENROLLMENT_DETAILS = By.xpath("//h2[text()='Title']//ancestor::div[contains(@class, 'field_readonly-field')]//div/div");
    public static final By DETAILED_MENU_PROVIDER_DETAILS = By.xpath("//div[contains(@class, 'detailed-panel-menu')]//button");
    public static final By SEARCH_BOX = By.xpath("//div[contains(@class, 'search-box')]");
    public static final By BUTTON_SEARCH = By.xpath("//button[contains(@class, 'search-box-action')]");
    public static final By ROW_IN_TABLE = By.xpath("//div[contains(@class, 'tile-table-row')]");
    public static final By SECTION_IDENTIFYING_INFORMATION = By.xpath("//div[contains(@class, 'menu_menu-item')]//span[text() ='Identifying Information']");
    public static final By ENROLLMENT_STATUS = By.xpath("(//p[contains(.,'Status')]//following::span)[1]");

    public static final By ENROLLMENT_STATUS_AFTER_APPEAL = By.xpath("(//p[contains(.,'Status')]//following::span)[1]");
    public static final By BUTTON_SELECT_ORIGINAL_REQUEST_STATUS = By.xpath("//label[contains(text(), 'Select original request status')]/following::div[@role='button']");

    public static final By APPEALS_TAB = By.xpath("//ul//li//a[contains(@href, '/appeal')]");
    public static final By ID_PROVIDER_DETAILS = By.xpath("//div[contains(@class,'expansion-panel-summary')]/div/div[3]/div/div[2]/p");
    public static final By PROVIDER_ID_RECONSIDERATION_TAB = By.xpath("//h1[contains(text(),'Request #')]");

    public static final By TEXT_FIELD_PROVIDER_ID1 = By.xpath("//input[contains(@id,'providerName')]");

    public static final By REVALIDATION_NOTIFICATON = By.xpath("//div[contains(@class,'expansion-panel-summary')]/div/div[6]/div/div/p");

    public static final By REVALIDATION_DATE = By.xpath("//div[contains(@class,'expansion-panel-summary')]/div/div[5]/div/div/p");

    public static final By APP_REVAL_DATE = By.xpath("//h2[text()='Next Revalidation Date']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p");

    public static final By REVAL_SECTION = By.xpath("//span[text()='Revalidation']//ancestor::button");

    public static final By NEXT_REVAL_DATE = By.xpath("//div[contains(@class,'revalidation_row-container')]/div[2]/p[2]");

    public static final By NEXT_REVALIDATION_DATE_ENROLLMENT = By.xpath("(//span[contains(.,'Next Revalidation Date')])[2]//following::div[contains(@class,'main-info-panel_value')]//div");
    public static final By SUFFIX_FIELD = By.xpath("//input[@name='Suffix']");

    public static final By HISTORY_TAB = By.xpath("//span[text()='History']//ancestor::button");
    public static final By VIEW_DETAILS = By.xpath("//a[text()='View details']");
    public static final By DATA_INFO = By.xpath("//div[contains(@class,'requests_col')]/div[2]");

    public static final By SearchButton = By.xpath("//span[.='Search']");
    public static final By SearchResult = By.xpath("(//div[contains(@class,'tile-table')]//div[contains(@class,'tile-table-row')])");

    //ENROLLMENT TABS
    public static final String IDENTIFYING_INFORMATION_TAB = "//span[text()='Identifying Information']";

    // IU - Identifying Information Field Identifiers
    public static final String IDENTIFYING_INFO_FIELD_FIRST_NAME = "First Name";
    public static final String IDENTIFYING_INFO_FIELD_MIDDLE_NAME = "Middle Name";
    public static final String IDENTIFYING_INFO_FIELD_LAST_NAME = "Last Name";
    public static final String IDENTIFYING_INFO_FIELD_GENDER = "Gender";
    public static final String IDENTIFYING_INFO_FIELD_ALT_EMAIL = "Alternate Email";
    public static final String IDENTIFYING_INFO_FIELD_WEBSITE = "Website Address";
    public static final String IDENTIFYING_INFO_FIELD_PHONE = "Phone Number";
    public static final String IDENTIFYING_INFO_FIELD_FAX = "Fax";

    //DATA CHANGE
    public static ArrayList<ArrayList<String>> iuProviderFieldsList = new ArrayList<>();
    public static String iuProviderMenuTabSection;

    //MISC
    private String switchCase = "";

    //Enrollment Span Table Info
    public static final By DATE = By.xpath("(//div[contains(@class,'table-text_tooltip')])[1]/p");
    public static final By STATUS = By.xpath("(//div[contains(@class,'table-text_tooltip')])[2]/p");
    public static final By EFFECTIVE_FROM_DATE = By.xpath("(//div[contains(@class,'table-text_tooltip')])[3]/p");
    public static final By EFFECTIVE_TO_DATE = By.xpath("(//div[contains(@class,'table-text_tooltip')])[4]/p");
    public static final String REQUESTED_ENROLLMENT_DATE = "//label[text()='Requested Enrollment Date']/following::input";

    public static final By UNDER_SCREENING_STATUS = By.xpath("//p[text()='UNDER SCREENING']");
    public static final By SEARCH_TAB = By.xpath("//div[contains(@class,'tile-table-body')]");

    public static final String IndividualEnrollment = "Individual";
    public static final String EntityEnrollment = "Entity";
    public static final String TPEnrollment = "TP";
    public static final String PEMEnrollment = "PEM";

    //options under Identifier Level dropdown -> AletrnateIdentifier
    public static final String NPI_Provider = "NPI/Provider";
    public static final String Key_Personnel = "Key Personnel";
    public static final String Provider_Medicaid_Id = "Provider Medicaid Id";

    //options under Identifier Type dropdown -> ALternateIdentifier
    public static final String Phone_Number = "Phone Number";
    public static final String COBA_ID = "COBA ID";
    public static final String TP_IP = "TP IP";

    //options under Reason Code dropdown -> Alternate Identifier
    public static final String New_Enrollment = "New Enrollment";
    public static final String CHOW = "CHOW";
    public static final String Provider_Management = "Provider Management";

    //options under Status dropdown -> Alternate Identifier
    public static final String InActive = "Inactive";


    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public IUEnrollmentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    /**
     * This method changes the Application Status from currentStatus to statusDropDownValue
     *
     * @param firstName
     * @param lastName
     * @param trackingNo
     * @param currentStatus
     * @param statusDropDownValue
     */
    public void changeEnrollmentApplicationTo(String firstName, String lastName, String trackingNo, String currentStatus, String statusDropDownValue) {
        Reports.log("\nChanging Enrollment status from " + currentStatus + " to " + statusDropDownValue + " for: " + firstName + " " + lastName);
        searchProvider(firstName + " " + lastName, trackingNo);
        searchSpecificEnrollmentAndClick(4, currentStatus);
        javaWaitSec(15);
        String applicationStatus = getApplicationStatus();
        Reports.log("Current application Status Application status is: " + applicationStatus);
        javaWaitSec(3);
        if (statusDropDownValue.equalsIgnoreCase(applicationStatus)) {
            navigateBackToEnrollment();
            Reports.log("Now Application status has changed to: " + applicationStatus);
            return;
        } else {
//            screening(Data.screeningFile100, Data.URI_SCREENING, "");
            javaWaitSec(5);
            clickAnyButton(Data.optionChangeStatus);
            javaWaitSec(5);
//            driver.findElement(ChangeStatus_Button);
//            ajaxClick(ChangeStatus_Button);
            javaWaitSec(5);
            driver.findElement(POPUP_CHANGE_STATUS).click();
            javaWaitSec(5);
//            clickAnyOptionInList(statusDropDownValue);
            clickFirstOptionInList();
            javaWaitSec(5);
            if (statusDropDownValue.equalsIgnoreCase(Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED) || statusDropDownValue.equalsIgnoreCase(Data.DROPDOWN_VALUE_UNDER_SCREENING) || statusDropDownValue.equalsIgnoreCase(Data.ApplicationStatusApprove)
                    || statusDropDownValue.equalsIgnoreCase(Data.REQUESTED_ADDITIONAL_INFORMATION)) {
//                fillInCalendar(getCurrentDate(),Data.EFFECTIVE_DATE);
                javaWaitSec(5);
                performClick(BUTTON_APPROVE_REASON);
                javaWaitSec(5);
//                jsClick("//ul[@role='listbox']/li[text()='Moving to Under screening']");
                clickFirstOptionInList();
            }
            javaWaitSec(5);
            clickAnyButton(Data.TEXT_APPLY);
            javaWaitSec(2);
            driver.navigate().refresh();
            javaWaitSec(15);
            applicationStatus = getApplicationStatus();
            Reports.log("Now Application status has changed to: " + applicationStatus);
            navigateBackToEnrollment();
        }

    }

    /**
     * This method changes the Application Status from currentStatus to statusDropDownValue
     *
     * @param firstName
     * @param lastName
     * @param trackingNo
     * @param currentStatus
     * @param statusDropDownValue
     */
    public void changeStatusPopupNoteFieldVerification(String firstName, String lastName, String trackingNo, String currentStatus, String statusDropDownValue) {
        Reports.log("\nChanging Enrollment status from " + currentStatus + " to " + statusDropDownValue + " for: " + firstName + " " + lastName);
        searchProvider(firstName + " " + lastName, trackingNo);
        searchSpecificEnrollmentAndClick(3, currentStatus);
        javaWaitSec(1);
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(POPUP_CHANGE_STATUS).click();
        if (currentStatus.contains(Data.statusPendingApproval)) {
            //driver.findElement(POPUP_CHANGE_STATUS).click();
            ajaxClick(POPUP_CHANGE_STATUS);
            javaWaitSec(1);
            clickAnyOptionInList(statusDropDownValue);
            Reports.log("Status: " + statusDropDownValue + " is selected");
            javaWaitSec(2);
            WebElement Note = driver.findElement(NOTE_TO_PROVIDER);
            Reports.log("Verifying Notes to provider section: ");
            Assert.assertTrue(Note.getText().contains("Notes to provider"));
            Reports.log(Note.getText() + " Is displayed");
            Assert.assertTrue(!Note.getText().contains("*"));
            Reports.log(Note.getText() + " is not mandatory\n");
            driver.navigate().refresh();
        } else {
            WebElement Note = driver.findElement(NOTE_TO_PROVIDER);
            Reports.log(Note.getText());
            Assert.assertTrue(Note.getText().contains("Notes to provider"));
            Reports.log(Note.getText() + " Is displayed");
            Assert.assertTrue(!Note.getText().contains("*"));
            Reports.log(Note.getText() + " is not mandatory");
            driver.navigate().refresh();
            clickAnyButton(Data.optionChangeStatus);
            driver.findElement(POPUP_CHANGE_STATUS).click();
            clickAnyOptionInList(statusDropDownValue);
            javaWaitSec(2);
            if (statusDropDownValue.equalsIgnoreCase(Data.DROPDOWN_VALUE_UNDER_SCREENING)) {
                ajaxClick(BUTTON_APPROVE_REASON);
                clickFirstOptionInList();
            }
            clickAnyButton(Data.TEXT_APPLY);
            javaWaitSec(3);
            driver.navigate().refresh();
            javaWaitSec(5);
            String applicationStatus = getApplicationStatus();
            Reports.log("Now Current Application status is: " + applicationStatus);
            navigateBackToEnrollment();
        }
    }

    /**
     * This method searches for provider
     *
     * @param nameOfProvider
     * @param TrackingNumber
     */
    public void searchProvider(String nameOfProvider, String TrackingNumber) {
        Reports.log("\nSearching for the provider");
        javaWaitSec(2);
        driver.navigate().refresh();


        //javaWaitSec(5);
        advanceFindElement(TEXT_FIELD_REQUEST_ID, 50, 2);

//        javaWaitSec(5);
        try {
            advanceFindElement(TEXT_FIELD_REQUEST_ID, 60, 2);

//        ajaxScroll(TEXT_FIELD_PROVIDER_ID);

//        //Provider Name
//        driver.findElement(TEXT_FIELD_PROVIDER_ID)
//                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        ajaxClear(TEXT_FIELD_PROVIDER_ID);
//        //  Reports.log("Clear provider if text field");
//        driver.findElement(TEXT_FIELD_PROVIDER_ID).sendKeys(nameOfProvider);
//        Reports.log("Provider name: " + nameOfProvider);

            //Request ID
            ajaxClick(TEXT_FIELD_REQUEST_ID);
        } catch (Exception e) {
            Reports.log("Re-loading Provider Search page is slow");
        }
        driver.findElement(TEXT_FIELD_REQUEST_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ajaxClear(TEXT_FIELD_REQUEST_ID);
//        ajaxSendKeys(TEXT_FIELD_REQUEST_ID,TrackingNumber);
        driver.findElement(TEXT_FIELD_REQUEST_ID).sendKeys(TrackingNumber);
        Reports.log("Tracking Number: " + TrackingNumber);

        // Provider Enrollment Manager
        performClick(setAndFindButton(Data.TEXT_SEARCH));
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        javaWaitSec(20);
    }

    /**
     * This method searches for provider
     * * @param TrackingNumber
     */
    public void searchProviderByTrackingNUm(String TrackingNumber) {
        Reports.log("\nSearching for the provider");
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(5);
        ajaxScroll(TEXT_FIELD_PROVIDER_ID);

        //Provider Name
        driver.findElement(TEXT_FIELD_PROVIDER_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ajaxClear(TEXT_FIELD_PROVIDER_ID);
        //Request ID
        ajaxClick(TEXT_FIELD_REQUEST_ID);
        driver.findElement(TEXT_FIELD_REQUEST_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ajaxClear(TEXT_FIELD_REQUEST_ID);
//        ajaxSendKeys(TEXT_FIELD_REQUEST_ID,TrackingNumber);
        driver.findElement(TEXT_FIELD_REQUEST_ID).sendKeys(TrackingNumber);
        Reports.log("Tracking Number: " + TrackingNumber);

        // Provider Enrollment Manager
        performClick(setAndFindButton(Data.TEXT_SEARCH));
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        javaWaitSec(10);
        performClick(SEARCH_TAB);
        javaWaitSec(20);
    }

    /**
     * This method searches specific enrollment and click
     *
     * @param delay
     * @param status1
     */
    public void searchSpecificEnrollmentAndClick(int delay, String status1) {
        for (int i = 0; i <= 2; i++) {
            Reports.log("Wait for " + delay + " seconds for application to load..");
            javaWaitSec(delay);
//            Reports.log("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            javaWaitSec(5);
            try {
                driver.findElements(PART_OF_ENROLLMENT_INFO).get(0).getText();
                if (anyStatusOfEnrollment(status1).isDisplayed()) {
                    String applicationStatus = anyStatusOfEnrollment(status1).getText();
                    Reports.log("Application Status is: " + applicationStatus);
                    break;
                }
            } catch (Exception e) {
                try {
                    if (i == 10) {
                        if (anyStatusOfEnrollment(Data.APPLICATION_STATUS_READY_FOR_SCREENING).isDisplayed()) {
                            String applicationStatus = anyStatusOfEnrollment(Data.APPLICATION_STATUS_UNDER_SCREENING).getText();
                            Reports.log("Application Status is: " + applicationStatus);
                            break;
                        } else {
                            Assert.fail("Time out Waiting for the application Status to be changed");
                        }
                    }
                } catch (Exception e1) {
                }
            }
            Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
        }
        javaWaitSec(10);
        ajaxScrollUp();
        javaWaitSec(2);
        WebElement enrollment = driver.findElements(INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        enrollment.click();
        javaWaitSec(3);
    }

    //Search provider by Enrollment Type
    public void searchproviderByEnrollmentType(String EnrollmentType) {
        Reports.log("Searching for the provider");
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(5);
        driver.findElement(By.xpath("//div[contains(@class,'css')]//div[contains(text(),'Enrollment ')]")).click();
        javaWaitSec(5);
        selectAndClickOptionOfEnrollment(EnrollmentType).click();
        Reports.log("\nClicked on Enrollment Type");
        javaWaitSec(5);
        ajaxClick(SearchButton);
        Reports.log("\nClicked on search button");
        javaWaitSec(5);
        waitAndClick(SearchResult);
        Reports.log("\nSelected one of the search result");
        javaWaitSec(5);
    }


    /**
     * This method searches an enrollment verify if Automatic Screening is performed
     *
     * @param firstName
     * @param lastName
     * @param enrollmentStatus
     * @param trackingNumber
     * @param delayTime
     */
    public boolean isVYEScreeningSuccessful(String firstName, String lastName, String enrollmentStatus, String trackingNumber, int delayTime) {
        closeAlert();
        clickBackToTop();
        searchProvider(firstName + " " + lastName, trackingNumber);
        javaWaitSec(5);
        int NomOfItr = 30;
        for (int i = 0; i <= NomOfItr; i++) {
            Reports.log("Wait for " + delayTime + " seconds for application to load..");
            javaWaitSec(delayTime);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            javaWaitSec(5);
            try {
                System.out.println("Enrollment Request Id : " + driver.findElements(PART_OF_ENROLLMENT_INFO).get(0).getText());
                if (anyStatusOfEnrollment(enrollmentStatus).isDisplayed()) {
                    String applicationStatus = anyStatusOfEnrollment(enrollmentStatus).getText();
                    Reports.log("Application Status is: " + applicationStatus);
                    break;
                }
            } catch (Exception e) {
                try {
                    if (i == NomOfItr) {
                        if (anyStatusOfEnrollment(Data.APPLICATION_STATUS_READY_FOR_SCREENING).isDisplayed()) {
                            String applicationStatus = anyStatusOfEnrollment(Data.APPLICATION_STATUS_READY_FOR_SCREENING).getText();
                            Reports.log("Application Status is: " + applicationStatus);
                            break;
//                        } else {
//                            Assert.fail("Time out Waiting for the application to finish the Screening");
                        }
                    }
                } catch (Exception e1) {
                    Reports.log("Time out Waiting for the application to finish the Screening");
                    return false;
                }
            }
            Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
        }
        javaWaitSec(10);
        ajaxScrollUp();
        javaWaitSec(2);
        WebElement enrollment = driver.findElements(INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        enrollment.click();
        javaWaitSec(3);
        return true;
    }


    /**
     * This method searches an enrollment verify if Automatic Screening is performed
     *
     * @param firstName
     * @param lastName
     * @param enrollmentStatus
     * @param trackingNumber
     * @param delayTime
     */
    public void verifyIfVYPScreeningIsDone(String firstName, String lastName, String enrollmentStatus, String trackingNumber, int delayTime) {
        closeAlert();
        clickBackToTop();
        searchProvider(firstName + " " + lastName, trackingNumber);
        javaWaitSec(5);
        for (int i = 0; i <= 10; i++) {
            Reports.log("Wait for " + delayTime + " seconds for application to load..");
            javaWaitSec(delayTime);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            javaWaitSec(5);
            try {
                driver.findElements(PART_OF_ENROLLMENT_INFO).get(0).getText();
                if (anyStatusOfEnrollment(enrollmentStatus).isDisplayed()) {
                    String applicationStatus = anyStatusOfEnrollment(enrollmentStatus).getText();
                    Reports.log("Application Status is: " + applicationStatus);
                    break;
                }
            } catch (Exception e) {
                System.out.println("I'm in 1st Catch block");
                try {
                    if (i == 10) {
                        if (anyStatusOfEnrollment(Data.APPLICATION_STATUS_READY_FOR_SCREENING).isDisplayed()) {
                            String applicationStatus = anyStatusOfEnrollment(Data.APPLICATION_STATUS_READY_FOR_SCREENING).getText();
                            Reports.log("Application Status is: " + applicationStatus);
                            break;
                        } else {
                            Assert.fail("Time out Waiting for the application to finish the Screening");
                        }
                    }
                } catch (Exception e1) {
                    Assert.fail("Time out Waiting for the Application ");
                }
            }
            Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
        }
        javaWaitSec(10);
        ajaxScrollUp();
        javaWaitSec(2);
        WebElement enrollment = driver.findElements(INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        enrollment.click();
        javaWaitSec(3);
    }

    /**
     * This method searches specific enrollment and verify if enrollment status is as expected
     * returns true the current application status
     *
     * @param expectedStatus
     */
    public String verifyAndGetIfEnrollmentStatusIs(String expectedStatus) {
        String applicationStatus = null;
        for (int i = 0; i <= 5; i++) {
            javaWaitSec(5);
            Reports.log("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            javaWaitSec(10);
            try {
                driver.findElements(PART_OF_ENROLLMENT_INFO).get(0).getText();
                if (anyStatusOfEnrollment(expectedStatus).isDisplayed()) {
                    applicationStatus = anyStatusOfEnrollment(expectedStatus).getText();
                    Reports.log("Application Status is: " + applicationStatus);
                    break;
                }
            } catch (Exception e) {
                if (i == 10) {
                    Reports.log("Application Status is not :" + expectedStatus);
                }
            }
            Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
        }
        return applicationStatus;
    }

    /**
     * This method navigates back to enrollment
     */
    public void navigateBackToEnrollment() {
        Reports.log("Navigate Back to Enrollment Page");
        clickAnyHeaderTitLe(Data.textEnrollmentTab);
        javaWaitSec(3);
//        searchProvider(firstName + " " + lastName, trackingNum);
    }

    /**
     * This method enrollment does Under Screening
     *
     * @param environmentUrl
     * @param firstName
     * @param lastName
     * @param trackingNum
     */
    public void enrollmentUnderScreen(String environment, String environmentUrl, String firstName, String lastName, String trackingNum, String status) {
        Reports.log("\nEnrollment is under screening");
        String currentApplicationStatus = searchAndGetProviderApplicationStatus(firstName, lastName, trackingNum);
        javaWaitSec(15);
        searchProvider(firstName + " " + lastName, trackingNum);
        javaWaitSec(10);
        if (!currentApplicationStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_READY_FOR_SCREENING)) {
            int requestId = getRequestIdFromSpecificEnrollment(15, Data.APPLICATION_STATUS_UNDER_SCREENING);
            String cookies = collectCookies(environmentUrl.replace("https://", ""));
            replaceRequestIdInScreeningFile(requestId, Data.screeningFile100);
            Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
            screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
            javaWaitSec(3);
            screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
//            pendingReviewFlowConfigaration(firstName, lastName, status, trackingNum, 10);
        } else {
            pendingReviewFlowConfigaration(firstName, lastName, status, trackingNum, 30);
            javaWaitSec(2);
            downloadScreeningDocument();
            javaWaitSec(5);
        }
    }

    /**
     * This method does Under Screening based on the selected ScreeningType(i.e, Automatic, Manual, Transmit)
     *
     * @param environmentUrl
     * @param firstName
     * @param lastName
     * @param trackingNum
     */
    public void performEnrollmentScreening(String screeningType, String environmentUrl, String firstName, String lastName, String trackingNum, String status) {

        switch (screeningType) {
            case "VYE":
                Reports.log("\nScreening is handled through VYE");
                Boolean isScreeningSuccessful = isVYEScreeningSuccessful(firstName, lastName, status, trackingNum, 30);
                if (isScreeningSuccessful) {
                    javaWaitSec(2);
                    downloadScreeningDocument();
                    javaWaitSec(2);
                    break;
                } else {
                    Assert.fail("Time out Waiting for the application to finish the Screening");
                }

            case "API":
                Reports.log("\nScreening is handled through API");
                changeEnrollmentApplicationTo(firstName, lastName, trackingNum, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
                searchProvider(firstName + " " + lastName, trackingNum);
                advanceFindElement(UNDER_SCREENING_STATUS, 60, 2);
                int requestId = getRequestIdFromSpecificEnrollment(0, Data.APPLICATION_STATUS_UNDER_SCREENING);
                String cookies = collectCookies(environmentUrl.replace("https://", ""));
                replaceRequestIdInScreeningFile(requestId, Data.screeningFile100);
                Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
                screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
                javaWaitSec(3);
                screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
//                pendingReviewFlowConfigaration(firstName, lastName, status, trackingNum, 10);
                break;

            case "VYE_TO_API":
                Reports.log("\nScreening is handled through VYE");
                Boolean isVYEScreeningSuccessful = isVYEScreeningSuccessful(firstName, lastName, status, trackingNum, 30);
                String enrollmentStatus = null;
                if (isVYEScreeningSuccessful) {
                    javaWaitSec(2);
                    downloadScreeningDocument();
                    javaWaitSec(2);
                } else {
                    navigateBackToEnrollment();
                    enrollmentStatus = searchAndGetProviderApplicationStatus(firstName, lastName, trackingNum);
                    Reports.log("\nCurrent Enrollment Status is: " + enrollmentStatus);
                    javaWaitSec(5);

                    Reports.log(" VYE Screening Failed, So Screening is handled through API");
                    if (enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_READY_FOR_SCREENING))
                        changeEnrollmentApplicationTo(firstName, lastName, trackingNum, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);

                    int requestId1 = getRequestIdFromSpecificEnrollment(15, Data.APPLICATION_STATUS_UNDER_SCREENING);
                    String cookies1 = collectCookies(environmentUrl.replace("https://", ""));
                    replaceRequestIdInScreeningFile(requestId1, Data.screeningFile100);
                    Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
                    javaWaitSec(3);
                    screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies1);
                    pendingReviewFlowConfigaration(firstName, lastName, status, trackingNum, 10);
                }
                break;
        }
    }


    /**
     * This method enrollment does Under Screening
     *
     * @param environmentUrl
     * @param firstName
     * @param lastName
     * @param trackingNum
     */
    public void enrollmentUnderScreen(String environmentUrl, String firstName, String lastName, String trackingNum, String status) {
        Reports.log("\nEnrollment is under screening");
        String currentApplicationStatus = searchAndGetProviderApplicationStatus(firstName, lastName, trackingNum);
        javaWaitSec(5);
        searchProvider(firstName + " " + lastName, trackingNum);
        javaWaitSec(5);
        if (!currentApplicationStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_READY_FOR_SCREENING)) {
            int requestId = getRequestIdFromSpecificEnrollment(15, Data.APPLICATION_STATUS_UNDER_SCREENING);
            String cookies = collectCookies(environmentUrl.replace("https://", ""));
            replaceRequestIdInScreeningFile(requestId, Data.screeningFile100);
            Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
            screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
            javaWaitSec(3);
            screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
            pendingReviewFlowConfigaration(firstName, lastName, status, trackingNum, 10);
        } else {
            pendingReviewFlowConfigaration(firstName, lastName, status, trackingNum, 30);
            javaWaitSec(2);
            downloadScreeningDocument();
            javaWaitSec(2);
        }
    }


    /**
     * This method get request Id from specific enrollment
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
                advanceFindElement(PART_OF_ENROLLMENT_INFO, 20, 2);
                requestId = driver.findElements(PART_OF_ENROLLMENT_INFO).get(0).getText();
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
     * This method replacesrRequest Id in Screening File
     *
     * @param requestId
     * @param screeningFile
     */
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

    /**
     * This method does the screening
     *
     * @param screeningFile
     * @param screeningEndpoint
     * @param cookies
     */
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

    /**
     * This method verifies pending Review Flow Configuration
     *
     * @param firstName
     * @param lastName
     * @param enrollmentStatus
     * @param trackingNumber
     */
    public void pendingReviewFlowConfigaration(String firstName, String lastName, String enrollmentStatus, String trackingNumber, int delayTime) {
        closeAlert();
        clickBackToTop();
        searchProvider(firstName + " " + lastName, trackingNumber);
        searchSpecificEnrollmentAndClick(delayTime, enrollmentStatus);
        javaWaitSec(10);
    }


    /**
     * This method creates site visit button verification for high risk taxonomy using textOfButton, taxonomy, fname, lName arguments
     *
     * @param textOfButton
     * @param fname
     * @param lName
     */
    public void verifyAndCreateSiteVisitForAnEnrollment(String textOfButton, String fname, String lName) {
        try {
            javaWaitSec(4);
            if (driver.findElement(CREATE_SITE_VISIT_BUTTON).isEnabled()) {
                Reports.log("Create Site Visit Button Available");
                clickAnyButton(textOfButton);
                javaWaitSec(2);
                ajaxScroll(POPUP_SITEVISIT_DATE);
                driver.findElement(POPUP_SITEVISIT_REASON).click();
                javaWaitSec(2);
                List<WebElement> elements = driver.findElements(By.xpath("(//li[@role='option'])"));
                ajaxClick(elements.get(2));
                javaWaitSec(2);
                ajaxClick(By.xpath("//button[contains(.,'Ok')]"));
                javaWaitSec(5);
                clickAnyHeaderTitLe(Data.textSiteVisitsTab);
                Reports.log("Click header tab: " + Data.textSiteVisitsTab);
                javaWaitSec(5);
            } else {
                Reports.log("Create Site Visit Button is not available");
            }
        } catch (Exception e) {
            Reports.log("Exception " + e);
        }
    }

    /**
     * This method creates site visit button verification for high risk taxonomy using textOfButton, taxonomy, fname, lName arguments
     * and waves it on Enrollment page by selecting "Yes" radio button for Do you want to waive the Site Visit?,on Create Site Visit popup window
     *
     * @param textOfButton
     */
    public void waveSiteVisitOnEnrollmentPage(String textOfButton) {
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

    /**
     * This method reviews and votes the enrollment
     *
     * @param firstName
     * @param lastName
     */
    public void reviewAndVoteTheEnrollment(String firstName, String lastName) {
        try {
            javaWaitSec(5);
            ajaxScrollUp();
            clickAnyButton("Approve");
            performClick(POPUP_PENDING_REVIEW_REASON);
            javaWaitSec(2);
            // driver.findElement(POPUP_PENDING_REVIEW_REASON).click();
            clickAnyOptionInList(1);
            javaWaitSec(2);
            ajaxClick(By.xpath("//textarea[@rows='1']"));
            driver.findElement(By.xpath("//textarea[@rows='1']")).sendKeys("Review Completed. Sanity Test for " + firstName + " " + lastName);
            javaWaitSec(2);
            Reports.log("Note Added: " + driver.findElement(By.xpath("//textarea[@rows='1']")).getText());
            clickAnyButton2("Approve", 1);
            javaWaitSec(5);
            ajaxScrollUp();
//            driver.navigate().refresh();
//            javaWaitSec(10);
        } catch (Exception e) {
            Reports.log("\n Approve button for Voter or Reviewer is not available ");
        }
    }

    /**
     * This method changes the status of enrollment
     *
     * @param statusOfApplication
     */
    public void changeStatusOfEnrollment(String statusOfApplication) {
        javaWaitSec(5);
        String applicationStatus = changeApplicationStatus(statusOfApplication);
        for (int i = 0; i < 3; i++) {
            try {
                applicationStatus = getApplicationStatus();
                Reports.log("Application Status: " + applicationStatus);
                if (i != 3 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
                    Reports.log("Application Status is Still under : " + applicationStatus + " so trying to re-change the application status again  Attempt# " + i);
                    changeApplicationStatus(statusOfApplication);
                } else {
                    break;
                }
            } catch (Exception e) {
                Reports.log("Application Status is Still under " + applicationStatus + ", retrying Again. Attempt# " + i);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }

        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
    }

    public String changeApplicationStatus(String statusOfApplication) {
        closeAlert();
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        // driver.findElement(POPUP_INNER_ENROLLMENT_STATUS).click();
        performClick(POPUP_CHANGE_STATUS);

        if (statusOfApplication.contains("Approved")) {
            clickAnyOptionInList(statusOfApplication);  // 0 Approved, 1 Denied
            fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE);

        } else if (statusOfApplication.contains("Denied")) {
            clickAnyOptionInList(statusOfApplication);  // 1 Denied
            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        } else {
            ajaxClick(setSpecificOptionInListbox(statusOfApplication));
        }

        // fillInCalendar(getCurrentDate(), Data.effectiveDateCalendar2);
        performClick(BUTTON_APPROVE_REASON);
//        driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
        javaWaitSec(2);
        Reports.log("Enter the reason ");
        jsClick("(.//ul[@role='listbox']/li)[2]");
        javaWaitSec(2);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(15);
        driver.navigate().refresh();
        javaWaitSec(10);

        String applicationStatus = null;
        for (int i = 0; i < 6; i++) {
            try {
                applicationStatus = getApplicationStatus();
                if (applicationStatus.equalsIgnoreCase(statusOfApplication) || applicationStatus.contains("SYNC FAILED")) {
                    break;
                } else {
                    driver.navigate().refresh();
                    Reports.log("Application Status is Still under : " + applicationStatus + " so Refreshing the page");
                    javaWaitSec(20);
                }
            } catch (Exception e) {
                Reports.log("Application Status is Still under" + applicationStatus);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }
        return applicationStatus;
    }

    public String changeApplicationStatus(String statusOfApplication, String enrollmentType) {
        closeAlert();
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        // driver.findElement(POPUP_INNER_ENROLLMENT_STATUS).click();
        driver.findElement(POPUP_CHANGE_STATUS).click();

        if (statusOfApplication.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
            fillInCalendar(getCurrentDate(), Data.EFFECTIVE_DATE);
            if (enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER) || enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER_REVALIDATION)) {
                String TPAgentID = generateNewNumber(8);
                Reports.log("Clear TP Agent ID text field");
                ajaxClick(By.xpath("(//textarea[@rows='1'])[1]"));
                driver.findElement(By.xpath("(//textarea[@rows='1'])[1]")).sendKeys(TPAgentID);
                Reports.log("Type TP Agent ID: " + TPAgentID);
            }
        } else if (statusOfApplication.contains("Denied")) {
//            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
            ajaxClick(SELECT_STATUS_DENIED);
//            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        } else {
            ajaxClick(setSpecificOptionInListbox(statusOfApplication));
        }

        // fillInCalendar(getCurrentDate(), Data.effectiveDateCalendar2);
        javaWaitSec(2);
        performClick(BUTTON_APPROVE_REASON);
//        driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
        javaWaitSec(2);
        Reports.log("Enter the reason ");
        jsClick("(.//ul[@role='listbox']/li)[2]");
        javaWaitSec(2);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(15);
        driver.navigate().refresh();
        javaWaitSec(10);

        String applicationStatus = null;
        for (int i = 0; i < 6; i++) {
            try {
                applicationStatus = getApplicationStatus();
                if (applicationStatus.equalsIgnoreCase(statusOfApplication) || applicationStatus.contains("SYNC FAILED")) {
                    break;
                } else {
                    driver.navigate().refresh();
                    Reports.log("Application Status is Still under : " + applicationStatus + " so Refreshing the page");
                    javaWaitSec(20);
                }
            } catch (Exception e) {
                Reports.log("Application Status is Still under" + applicationStatus);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }
        return applicationStatus;
    }

    /**
     * This method approves the application Retro_Actively by passing a parameter retroActiveDate.
     *
     * @param statusOfApplication
     * @param enrollmentType
     * @param retroActiveDate
     * @param applicationReason
     * @return
     */

    public String changeApplicationStatusRetroActively(String statusOfApplication, String enrollmentType, String retroActiveDate, String applicationReason) {
        closeAlert();
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(POPUP_CHANGE_STATUS).click();
        clickAnyOptionInList(statusOfApplication);
        fillInCalendar(retroActiveDate, Data.EFFECTIVE_DATE);

        switch (enrollmentType) {
            case Data.TRADING_PARTNER:
                CreateIDNum(AGENT_ID, 8);
                break;
            case Data.ENTITY_PROVIDER:
            case Data.SERVICING_PROVIDER:
            case Data.BILLING_PROVIDER:
                String requestedEnrollmentDate = driver.findElement(By.xpath(REQUESTED_ENROLLMENT_DATE)).getAttribute("value");
                Reports.log("Requested Enrollment Date is: " + requestedEnrollmentDate);
                Assert.assertEquals(requestedEnrollmentDate, retroActiveDate);
                Reports.log("Verification  of Requested Enrollment Date has been completed successfully");
        }
        ajaxClick(BUTTON_APPROVE_REASON);
        clickAnyOptionInList(applicationReason);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(15);
        driver.navigate().refresh();
        javaWaitSec(10);
        String applicationStatus = null;
        for (
                int i = 0;
                i < 6; i++) {
            try {
                applicationStatus = getApplicationStatus();
                if (applicationStatus.equalsIgnoreCase(statusOfApplication) || applicationStatus.contains("SYNC FAILED")) {
                    break;
                } else {
                    driver.navigate().refresh();
                    Reports.log("Application Status is Still under : " + applicationStatus + " so Refreshing the page");
                    javaWaitSec(20);
                }
            } catch (Exception e) {
                Reports.log("Application Status is Still under" + applicationStatus);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }
        return applicationStatus;
    }

    /**
     * This method gets application status
     *
     * @return
     */
    public String getApplicationStatus() {
        javaWaitSec(10);
        String applicationStatus = driver.findElement(STATUS_ENROLLMENT_DETAILS).getText();
        //Reports.log("Current Application Status :" + applicationStatus);
        return applicationStatus;
    }

    /**
     * This method gets application status by passing the locator
     *
     * @param Locator
     * @return
     */
    public String getApplicationStatus(By Locator) {
        javaWaitSec(5);
        String applicationStatus = driver.findElement(Locator).getText();
        //Reports.log("Current Application Status :" + applicationStatus);
        return applicationStatus;
    }


    /**
     * This method gets application status
     *
     * @return
     */
    public String searchAndGetProviderApplicationStatus(String firstName, String lastName, String trackingNum) {
        searchProvider(firstName + " " + lastName, trackingNum);
        javaWaitSec(10);
        WebElement enrollment = driver.findElements(INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        enrollment.click();
        javaWaitSec(15);
        String applicationStatus = getApplicationStatus();
        navigateBackToEnrollment();
        return applicationStatus;
    }

    /**
     * This method Verifies finger print button using firstName, lastName arguments
     *
     * @param firstName
     * @param lastName
     */
    public void VerifyFingerPrintButton(String firstName, String lastName) {
        // driver.navigate().refresh();
        javaWait(5);
        try {
            //javaWaitSec(3);
            fingerprintButton("Verify Fingerprint", firstName, lastName);
        } catch (NoSuchElementException e) {
            Reports.log("\nNo Fingerprinting button available");
        }
    }

    /**
     * This method does finger printing process using textOfButton, firstName, lastName
     *
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
                ajaxClick(RADIOBUTTON_FINGERPRINTING_YES);
                Reports.log("Selected 'Yes' for Are Provider Fingerprints verified as per available data?");
                javaWaitSec(1);
                ajaxClick(By.xpath("//textarea[@type='text']"));
                driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Fingerprints received. Sanity Test for " + firstName + " " + lastName);
                javaWaitSec(1);
                clickAnyButton("Ok");
            }
        } catch (Exception e) {

        }
    }

    public void downloadScreeningDocument() {
        try {
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
        } catch (Exception e) {
            Reports.log("Fail to display Screening Proof Document is  ");
        }

    }

    /**
     * This method verifies the status of application
     *
     * @param applicationStatus
     */
    public void verifyTheStatusOfApplication(String applicationStatus) {
        //wait.until(ExpectedConditions.visibilityOf(spanContainsText(applicationStatus)));
        for (int i = 0; i < 10; i++) {
            try {
                try {
                    javaWaitSec(10);
                    WebElement appStatusElement = spanContainsText(applicationStatus);
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
                javaWaitSec(10);
                Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
                if (i == 9) {
                    Assert.fail("Application Status is not: " + applicationStatus);
                }
            }
        }
    }

    /**
     * This method reactivates the enrollment application
     */
    public void reactivateTheEnrollmentApplication() {
        javaWaitSec(5);
        driver.findElement(DETAILED_MENU_PROVIDER_DETAILS).click();
        clickRequestMenuOption("Reactivate");
        fillInCalendar(getCurrentDate(), Data.reactivateFormCalendar);
        driver.findElement(BUTTON_APPROVE_REASON).click();
        clickSpecificOptionInListbox("Positive Voting Results");
        javaWaitSec(5);
        clickAnyButton(Data.TEXT_REACTIVATE);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(10);
        driver.navigate().refresh();
        javaWaitSec(5);
    }

    /**
     * This method terminates the enrollment application
     */
    public void terminateTheEnrollmentApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(DETAILED_MENU_PROVIDER_DETAILS));
        driver.findElement(DETAILED_MENU_PROVIDER_DETAILS).click();
        clickRequestMenuOption(Data.TEXT_TERMINATE);
        String date = changeDayInCurrentDate(+30);
        fillInCalendar(date, Data.TEXT_TERMINATE);
        driver.findElement(BUTTON_APPROVE_REASON).click();
        Reports.log("Click on Reason Code list");
        clickSpecificOptionInListbox("Other");
        clickAnyButton(Data.TEXT_TERMINATE2);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(2);
    }

    /**
     * This method sets the specified status and Status From Date of an enrollment
     *
     * @param status
     * @param days
     */
    public void iuProviderStatusChange(String status, int days) {
        wait.until(ExpectedConditions.elementToBeClickable(DETAILED_MENU_PROVIDER_DETAILS));
        driver.findElement(DETAILED_MENU_PROVIDER_DETAILS).click();
        clickRequestMenuOption(status);
        //String days = changeDayInCurrentDate(+30);
        fillInCalendar(String.valueOf(days), status);
        driver.findElement(BUTTON_APPROVE_REASON).click();
        Reports.log("Click on Reason Code list");
        clickSpecificOptionInListbox("Other");
        clickAnyButton(" " + status);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(2);
    }

    /**
     * This method sets the specified status and Status From Date of an enrollment
     *
     * @param menuStatus
     * @param buttonStatus
     * @param days
     */
    public void iuProviderStatusChange(String menuStatus, String buttonStatus, int days) {
        if (menuStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_SUSPENDED)) {
            javaWaitSec(5);
            driver.findElement(DETAILED_MENU_PROVIDER_DETAILS).click();
            Reports.log("Clicked on the elliptical");
            javaWaitSec(5);
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(DETAILED_MENU_PROVIDER_DETAILS));
            driver.findElement(DETAILED_MENU_PROVIDER_DETAILS).click();
            Reports.log("Clicked on the elliptical");

        }
        clickRequestMenuOption(menuStatus);
        String date = changeDayInCurrentDate(days);
        updateCalendar(date, menuStatus);
        Reports.log("Selected Effective Date is: " + date);
        driver.findElement(BUTTON_APPROVE_REASON).click();
        Reports.log("Click on Reason Code list");
        clickSpecificOptionInListbox("Other");
        clickAnyButton(buttonStatus);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(2);
    }

    /**
     * This method navigates to provider Tab and search for enrollment by provider
     *
     * @param enrollmentType
     * @param providerName
     */
    public void navigateToPrvdrTabAndSearchForEnrollmentbyProvider(String enrollmentType, String providerName) {
        ajaxScrollUp();
//        clickSpecificSearchFieldAndSendData("Enrollment Type", enrollmentType);
//        javaWaitSec(5);
//        driver.findElement(SEARCH_BOX).findElement(TEXT_FIELD_ENROLLMENT_TYPE).click();
//        clickSpecificOptionInListbox(enrollmentType);
        javaWaitSec(1);
        driver.findElement(SEARCH_BOX).findElement(TEXT_FIELD_PROVIDER_NAME_ID).sendKeys(providerName);
        Reports.log("Search for the Provider: " + providerName);
        javaWaitSec(5);
        //    driver.findElement(TEXT_FIELD_PROVIDER_ADDRESS).sendKeys(Data.physicalAddress);
        //  javaWaitSec(2);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(BUTTON_SEARCH);
        javaWaitSec(5);

        wait.until(ExpectedConditions.elementToBeClickable(ROW_IN_TABLE));
        driver.findElements(ROW_IN_TABLE).get(0).click();
        javaWaitSec(5);
    }

    /**
     * This method navigates to provider Tab and search for enrollment by providerID
     *
     * @param providerID
     */
    public void navigateToProviderTabAndSearchForEnrollmentByProviderID(String providerID) {
        ajaxScrollUp();
        javaWaitSec(1);
        driver.findElement(SEARCH_BOX).findElement(TEXT_FIELD_PROVIDER_NAME_ID).sendKeys(providerID);
        Reports.log("Search for the Provider: " + providerID);
        javaWaitSec(5);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(BUTTON_SEARCH);
        javaWaitSec(5);

        wait.until(ExpectedConditions.elementToBeClickable(ROW_IN_TABLE));
        driver.findElements(ROW_IN_TABLE).get(0).click();
        javaWaitSec(5);
    }

    public void clickSearchForProviders() {
        javaWaitSec(5);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        clickAnyButton(Data.TEXT_SEARCH);
        javaWaitSec(5);

        wait.until(ExpectedConditions.elementToBeClickable(PROVIDERS_ROWS_IN_TABLE));
        driver.findElements(PROVIDERS_ROWS_IN_TABLE).get(0).click();
        javaWaitSec(5);

    }

    public void verifySummaryTabDoesNotExists() {
        try {
            driver.findElement(PROVIDERS_SUMMARY_TAB).isDisplayed();
        } catch (NoSuchElementException e) {

            Reports.log("No Summary Tab in the Providers Module");
        }
    }

    /**
     * This method clicks providers tab
     */
    public void clickProvidersTab() {
        Reports.log("Click header tab: " + Data.textProvidersTab);
        clickAnyHeaderTitLe(Data.textProvidersTab);
        javaWaitSec(5);
    }

    /**
     * This method searches provider in providers
     *
     * @param nameOfProvider
     */
    public void searchProviderInProviders(String nameOfProvider) {
        Reports.log("Clear provider if text field");
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_NAME)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        Reports.log("Type provider name: " + nameOfProvider);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_NAME).sendKeys(nameOfProvider);

        Reports.log("Click button: " + Data.TEXT_SEARCH);
        performClick(setAndFindButton(Data.TEXT_SEARCH));
    }

    /**
     * This method suspends the enrollment application
     */
    public void suspendTheEnrollmentApplication() {
        javaWaitSec(5);
        driver.findElement(Locators.DETAILED_MENU_PROVIDER_DETAILS).click();
        javaWaitSec(5);
        clickRequestMenuOption("Suspended");

        fillInCalendar(getCurrentDate(), Data.suspendedFormCalendar);
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        clickAnyOptionInList(1);
        clickAnyButton(Data.TEXT_SUSPEND);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(10);
        driver.navigate().refresh();
        javaWaitSec(20);

    }

    /**
     * This method verifies provider's status
     */
    public void verifyProviderStatus() {
        spanContainsText("Active");
    }

    /**
     * This method verifies If Provider Data Modified Successfully
     *
     * @param expectedTitle
     */
    public void verifyIfProviderDataModifiedSuccessfully(String expectedTitle) {
        // scrollToBottomOfPage();
        // ajaxScroll(Locators.CONTACT_EMAIL_ENROLLMENT_DETAILS);
        ajaxScroll(By.xpath("//h2[text()='Application Contact Email']"));
        javaWaitSec(10);
        String currentTitle = driver.findElement((ENROLLMENT_SECTION)).findElement(TITLE_ENROLLMENT_DETAILS).getText();
        Reports.log("Current Title is: " + currentTitle);
        Assert.assertEquals(expectedTitle, currentTitle);
    }

    /**
     * This method selects provider from search results
     */
    public void selectProviderFromSearchResults() {
        closeRootNotification();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
        ajaxScroll(Locators.ROW_IN_TABLE, 0);
        javaWaitSec(5);
        driver.findElements(Locators.ROW_IN_TABLE).get(0).click();
        javaWaitSec(5);
    }

    /**
     * This method clicks enrollment details
     */
    public void clickEnrollmentDetails() {
        ajaxClick(spanContainsText("Enrollment Information"));
    }

    /**
     * This method clicks specified section displayed on the IU Provider
     * tab (i.e. Enrollment Information)
     */
    public void clickIUProviderSection(String iuProviderSection) {
        javaWaitSec(3);
        ajaxScroll(By.xpath(iuProviderSection));
        javaWaitSec(5);
    }

    /**
     * This method clicks On provider identifying information section
     */
    public void clickOnProviderIdentifyingInformationSection() {
        javaWaitSec(1);
        // scrollToBottomOfPage();
        ajaxScroll(SECTION_IDENTIFYING_INFORMATION);
//        driver.findElement(SECTION_IDENTIFYING_INFORMATION).click();
        javaWaitSec(1);
    }

    /**
     * This method finds move and activate editable text field
     *
     * @param textField
     */
    public void findMoveAndActivateEditableTextField(String textField) {
        closeNpiPoUp();
        By ICON_EDIT = By.xpath("//h2[text()='" + textField + "']/../..//*[local-name() = 'svg' and @aria-hidden='true']");
        //By ICON_EDIT = By.xpath("//svg[@aria-hidden='true']");

        WebElement element = driver.findElement((ENROLLMENT_SECTION))
                .findElement(By.xpath("//h2[text()='" + textField + "']"));
        // "//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]"));

        //   .findElement(By.xpath("//h4[text()='" + textField + "']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]"));

        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .clickAndHold(element)
                .build();
        mouseOverHome.perform();
        performClick(driver.findElement(ENROLLMENT_SECTION).findElement(ICON_EDIT));
    }

    /**
     * This method modifies provider details
     *
     * @param firstName
     * @param newTitle
     */
    public void modifyProviderDetails(String firstName, String newTitle) {
        //Add Title
        Reports.log("First Name: " + firstName);
        findMoveAndActivateEditableTextField(Data.TITLE_DATA_CHANGE);
        javaWaitSec(2);
        performClick(driver.findElement(ENROLLMENT_SECTION).findElement(INPUT_TITLE_ENROLLMENT_DETAILS));
        javaWaitSec(2);
        driver.findElement(ENROLLMENT_SECTION).findElement(INPUT_TITLE_ENROLLMENT_DETAILS).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        javaWaitSec(1);

        ajaxClick(INPUT_TITLE_ENROLLMENT_DETAILS);
        Reports.log("Select Another Title: " + newTitle);
        clickAnyOptionInList(newTitle);
        //   ajaxScrollByCoordinate(100);
        ajaxClick(INPUT_DEGREE_ENROLLMENT_DETAILS);
        //closeNpiPoUp();
    }


    /**
     * This method modifies provider details
     *
     * @param editValue
     */
    public void modifyTPProviderDetails(String editValue) {

        testfindMoveAndActivateEditableTextField(editValue);
        javaWaitSec(2);
        driver.findElement(ENROLLMENT_SECTION).findElement(By.xpath("//input[contains(@id,'" + editValue + "')]")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(ENROLLMENT_SECTION).findElement(By.xpath("//input[contains(@id,'" + editValue + "')]")).sendKeys("TEST");
        javaWaitSec(5);
    }

    /**
     * This method finds move and activate editable text field
     *
     * @param textField
     */
    public void testfindMoveAndActivateEditableTextField(String textField) {
        closeNpiPoUp();
        WebElement icon_edit = driver.findElement(By.xpath("//h2[contains(text(),'" + textField + "')]/following-sibling::div//span"));
        By ICON_EDIT = By.xpath("//h2[contains(text(),'" + textField + "')]/following-sibling::div//span");

        WebElement element = driver.findElement((ENROLLMENT_SECTION))
                .findElement(By.xpath("//h2[contains(text(),'" + textField + "')]"));
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .clickAndHold(element)
                .moveToElement(icon_edit)
                .build();
        mouseOverHome.perform();
        performClick(driver.findElement(ENROLLMENT_SECTION).findElement(ICON_EDIT));
    }


    /**
     * This method verifies If Provider Data Modified Successfully
     *
     * @param expectedTitle
     */
    public void testIfProviderDataModifiedSuccessfully(String expectedTitle) {
        // scrollToBottomOfPage();
        // ajaxScroll(Locators.CONTACT_EMAIL_ENROLLMENT_DETAILS);
        ajaxScroll(By.xpath("//h2[text()='Legal Business Name']"));
        javaWaitSec(10);
        String currentTitle = driver.findElement((ENROLLMENT_SECTION)).findElement(By.xpath("//h2[contains(text(),'Legal Business Name')]")).getText();
        Reports.log("currentTitle" + currentTitle);
        Assert.assertEquals(expectedTitle, currentTitle);
    }

    /**
     * This method clicks the row of the search result
     */
    public void clickSearchResultRow() {
        wait.until(ExpectedConditions.elementToBeClickable(ROW_IN_TABLE));
        driver.findElements(ROW_IN_TABLE).get(0).click();
        javaWaitSec(5);
    }


    /**
     * This method modifies provider details
     *
     * @param editValue
     */
    public void modifyEntityProviderDetails(String editValue) {

        enableEditablePen(editValue);
        javaWaitSec(2);
        fillInCalendar(Helper.getYesterdayDate(), Data.requestedEnrollmentDate);
        javaWaitSec(1);
    }

    /**
     * This method modifies General Information
     *
     * @param editValue
     */
    public void modifyEnrollmentInformationSectionDropDownValue(String editValue, String dropDownValue) {
        enableEditablePen(editValue);
        javaWaitSec(2);
        WebElement dropdown = driver.findElement(By.xpath("//input[@name='" + editValue + "']"));
        dropdown.click();
        dropdown.sendKeys(Keys.BACK_SPACE);
        dropdown.click();
        ajaxClick(setSpecificStrongOptionInListbox(dropDownValue));
        dropdown.sendKeys(Keys.ENTER);
    }

    /**
     * This method modifies General Information
     *
     * @param editValue
     */
    public void modifyEnrollmentInformationSectionFieldText(String editValue, String fieldTextValue, int index) {
        //clickHiddenEditButton(editValue,index);
        enableEditablePen(editValue);
        javaWaitSec(2);
        WebElement fieldText = driver.findElement(By.xpath("//input[contains(@aria-label,'" + editValue + "')]"));
        fieldText.click();
        fieldText.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ;
        fieldText.sendKeys(fieldTextValue);
        fieldText.sendKeys(Keys.TAB);
    }

    /**
     * This method finds move and activate editable text field
     *
     * @param textField
     */
    public void enableEditablePen(String textField) {
        WebElement icon_edit = driver.findElement(By.xpath("//h2[contains(text(),'" + textField + "')]/following-sibling::div//span"));
        By ICON_EDIT = By.xpath("//h2[contains(text(),'" + textField + "')]/following-sibling::div//span");

        WebElement element = driver.findElement((ENROLLMENT_SECTION)).findElement(By.xpath("//h2[contains(text(),'" + textField + "')]"));
        Reports.log("Click on Element " + element);
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .clickAndHold(element)
                .moveToElement(icon_edit)
                .build();
        mouseOverHome.perform();
        performClick(driver.findElement(ENROLLMENT_SECTION).findElement(ICON_EDIT));
    }

    /**
     * This method finds move and activate editable text field
     *
     * @param textField
     */
    public void enableEditablePen(String textField, String editFieldXpath) {
        WebElement icon_edit = driver.findElement(By.xpath("//h2[contains(text(),'" + textField + "')]/following-sibling::div//span"));
        By ICON_EDIT = By.xpath("//h2[contains(text(),'" + textField + "')]/following-sibling::div//span");

        WebElement element = driver.findElement(By.xpath((editFieldXpath)));
        Reports.log("Click on Element " + element);
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .clickAndHold(element)
                .moveToElement(icon_edit)
                .build();
        mouseOverHome.perform();
        performClick(driver.findElement(ENROLLMENT_SECTION).findElement(ICON_EDIT));
        Reports.log("Clicked on the Editable Pen");
    }


    /**
     * This method verifies If Provider Data Modified Successfully
     *
     * @param expectedTitle
     */
    public void testIfEntityProviderDataModifiedSuccessfully(String expectedTitle) {

        ajaxScroll(By.xpath("//h2[text()='Select Requested Enrollment Date']"));
        javaWaitSec(10);
        String currentTitle = driver.findElement((ENROLLMENT_SECTION)).findElement(By.xpath("//h2[contains(text(),'Select Requested Enrollment Date')]")).getText();
        Reports.log("currentTitle" + currentTitle);
        Assert.assertEquals(expectedTitle, currentTitle);
    }

    /**
     * This method verifies If Provider Data Modified Successfully
     *
     * @param expectedTitle
     */
    public void verifyIfDataModifiedSuccessfully(String editValue, String expectedTitle) {

        ajaxScroll(By.xpath("//h2[text()='" + editValue + "']"));
        javaWaitSec(2);
        String currentValue = driver.findElement((ENROLLMENT_SECTION)).findElement(
                By.xpath("//div[contains(@class,'field_readonly-field')]/h2[contains(text(),'" + editValue + "')]/following::div/div")).getText();
        Reports.log("Current " + editValue + " is: " + currentValue);
        Assert.assertEquals(expectedTitle, currentValue);
        Reports.log("Verification of data modification has been completed successfully ");
    }

    /**
     * This method gets providers ID
     *
     * @return
     */
    public String getProvidersID() {
        javaWaitSec(5);
        String providerId = driver.findElement(ID_PROVIDER_DETAILS).getText();
        Reports.log("Provider ID: " + providerId);
        javaWaitSec(2);
        return providerId;
    }

    /**
     * This method clicks on enrolment span in provider's tab
     */
    public void navigateAndVerifyProvidersEnrollmentSpanStatus(String status, int num) {
        ajaxClick(By.xpath(Locators.ENROLLMENT_SPAN));
        javaWaitSec(3);
        String Date = driver.findElement(DATE).getText();
        Reports.log("The Date is : " + Date);
        String CurrentDate = getCurrentDate();
        Assert.assertEquals(Date, CurrentDate);
        Reports.log("Verification of current Date has been completed successfully");
        String Status = driver.findElement(STATUS).getText();
        Reports.log("The Enrollment span section status : " + status);
        Assert.assertTrue(Status.equalsIgnoreCase(status));
        String effectiveFormatDate = driver.findElement(EFFECTIVE_FROM_DATE).getText();
        Reports.log("Effective from Date: " + effectiveFormatDate);
        String effectiveToDate = driver.findElement(EFFECTIVE_TO_DATE).getText();
        Reports.log("Effective to Date: " + effectiveToDate);
        String date = changeDayInCurrentDate(num);
        Reports.log("Effective from Date : " + date);
        Assert.assertEquals(effectiveFormatDate, date);
        Reports.log("Verification of Effective from Date has been completed successfully");
        Assert.assertEquals(effectiveToDate, "_");
        Reports.log("Verification  Effective End Date has been completed successfully");
    }

    public void navigateAndVerifyTheProviderHistoryInfo(String type, String date) {
        driver.findElement(HISTORY_TAB).click();
        ajaxScrollDown();
        javaWaitSec(2);
        driver.findElement(VIEW_DETAILS).click();
        String dateInfo = driver.findElement(DATA_INFO).getText();
        Reports.log("Termination or Revalidation History: " + dateInfo);
        Assert.assertTrue((dateInfo.contains(date)));
        javaWaitSec(2);
        ajaxScrollUp();
    }

    /**
     * This method gets providers ID from the Reconsideration Tab
     *
     * @return
     */
    public String getProvidersIDFromReconsideration() {
        javaWaitSec(5);
        String requestId = driver.findElement(PROVIDER_ID_RECONSIDERATION_TAB).getText();
        //Reports.log("Provider ID: " + requestId);
        String providerId = requestId.split("#")[1];
        Reports.log("Provider ID: " + providerId);
        javaWaitSec(2);
        return providerId;
    }

    /**
     * This method changes the Termination Request Status
     *
     * @return
     */
    public void approveTerminationRequestStatus(String statusOfApplication) {
        closeAlert();
        javaWaitSec(3);
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(POPUP_CHANGE_STATUS).click();
        clickAnyOptionInList(statusOfApplication);
        javaWaitSec(3);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(3);
    }

    /**
     * This method changes the Revalidation Date calling API methods using Restful,
     * and verify the changed providers Revalidation date
     */
    public void changeRevalidationDateAndVerify(String environmentUrl, String providerDataId, String
            revalidationTimePeriod, String cookies, String revalidationDate) {
        Reports.log("Revalidation Time Period :" + revalidationTimePeriod + 'd');
        Reports.log("Revalidation Date:" + revalidationDate);
        revalidation(environmentUrl + Data.URI_REVALIDATION, cookies, providerDataId, revalidationTimePeriod + 'd');
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(10);

        //Verify the revalidation is 30 days of the current date
        // String timeRevalidationsss = changeDayInCurrentDate(Integer.parseInt(revalidationTimePeriod));
        String AppRevalidationDate = driver.findElement(APP_REVAL_DATE).getText();
        Reports.log("Application Revalidation Date :" + AppRevalidationDate);
        Assert.assertTrue(revalidationDate.contains(AppRevalidationDate));
    }


    /**
     * This method gets the Provider Data id from the current URL
     */
    public String getProviderDataId() {
        String currentURL = driver.getCurrentUrl();
        Reports.log("Current URL: " + driver.getCurrentUrl());
        String uriStr = currentURL;
        URI uri = URI.create(uriStr);
        String query = uri.getPath();
        String providerDataId = query.substring(query.lastIndexOf('/') + 1);
        Reports.log("ProviderId: " + providerDataId);
        return providerDataId;
    }

    /**
     * This method Navigates to Revalidation tab under Provider details page,And Assert the next revalidation date
     */
    public void navigateAndVerifyProvidersNextRevalidationStatus(String revalidationYear) {
        driver.findElement(REVAL_SECTION).click();
        javaWaitSec(2);
        String nextRevalidationDate = driver.findElement(NEXT_REVAL_DATE).getText();
        Reports.log("Expected Next Revalidation Date: " + revalidationYear);
        Reports.log("Next Revalidation Date: " + nextRevalidationDate);
        Assert.assertTrue(nextRevalidationDate.contains(revalidationYear));
        javaWaitSec(1);
    }

    /**
     * This method searches for provider under Providers Tab without clicking search result
     * * @param providerID
     */
    public String getProviderRevalidationDate(String providerID, String notification) {
        Reports.log("\nSearching for the provider");
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(5);
        driver.findElement(TEXT_FIELD_PROVIDER_ID1).sendKeys(providerID);
        clickAnyButton(Data.TEXT_SEARCH);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        javaWaitSec(3);
        Assert.assertTrue(driver.findElement(REVALIDATION_NOTIFICATON).getText().contains(notification));
        Reports.log("Verification of notification has been completed successfully");
        return driver.findElement(REVALIDATION_DATE).getText();
    }

    /**
     * This method Navigates to Revalidation tab under Provider details page,And Assert the next revalidation date
     */
    public void verifyNextRevalidationYear(int NumOfYears) {
        javaWaitSec(2);
        String date = changeYearInCurrentDate(NumOfYears);
        Reports.log("Expected Next Revalidation Date: " + date);
        String nextRevalidationDate = driver.findElement(NEXT_REVALIDATION_DATE_ENROLLMENT).getText();
        Reports.log("Next Revalidation Date: " + nextRevalidationDate);
        Assert.assertTrue(nextRevalidationDate.contains(date));
        javaWaitSec(1);
    }

    /**
     * This method updates IU Provider Enrollment Information text entry fields based using a specified
     * Section tab and a list of fields and their corresponding XPaths
     *
     * @param iuProviderMenuTabSection
     * @param iuProviderFieldsList
     */
    public ArrayList<ArrayList<String>> updateIUProviderTextEntryFields(String iuProviderMenuTabSection, ArrayList<ArrayList<String>> iuProviderFieldsList) {

        //Click the specified Section tab
        clickIUProviderSection(iuProviderMenuTabSection);

        //Read the fields and XPaths from the iuProviderFieldsList array and updates values
        for (ArrayList<String> strings : iuProviderFieldsList) {
            for (int j = 0; j < strings.size() - 1; j++) {
                String iuProviderDataField = String.valueOf(strings.get(0));
                String iuProviderDataXpath = String.valueOf(strings.get(1));

                //For Debugging
                Reports.log("IU Provider field to be changed: " + iuProviderDataField);
                Reports.log("IU Provider field XPath: " + iuProviderDataXpath);

                if (iuProviderDataField.equalsIgnoreCase(IDENTIFYING_INFO_FIELD_GENDER)) {
                    enableEditablePen(iuProviderDataField, iuProviderDataXpath);
                    String newValue = setIdentifyingInformationFieldValue(iuProviderDataField, IDENTIFYING_INFO_XPATH_GENDER_INPUT);
                    strings.set(1, newValue);

                } else {

                    //Locate and click the edit icon to enable the field for editing
                    enableEditablePen(iuProviderDataField);

                    //Select the method to update the field based on the Section tab specified

                    if (iuProviderMenuTabSection.contains("Identifying Information")) {


                        String newValue = setIdentifyingInformationFieldValue(iuProviderDataField, iuProviderDataXpath);
                        strings.set(1, newValue);
                    }

                    //For Debugging
                    //Reports.log("Returned newValue: " + newValue);
                }
            }
        }
        return iuProviderFieldsList;
    }

    /**
     * This method updates a specified field value displayed in the Identifying Information section of the
     * IU Provider Enrollment Information tab
     *
     * @param iuProviderDataField
     * @param iuProviderDataXpath
     */
    public String setIdentifyingInformationFieldValue(String iuProviderDataField, String iuProviderDataXpath) {

        String newValue = null;
        String webSiteName = null;
        switchCase = iuProviderDataField;

        switch (switchCase) {
            case IDENTIFYING_INFO_FIELD_FIRST_NAME:
            case IDENTIFYING_INFO_FIELD_MIDDLE_NAME:
                newValue = generateFirstName();
                break;
            case IDENTIFYING_INFO_FIELD_LAST_NAME:
                newValue = generateLastName();
                break;
            case IDENTIFYING_INFO_FIELD_GENDER:
                newValue = "Female";
                break;
            case IDENTIFYING_INFO_FIELD_PHONE:
            case IDENTIFYING_INFO_FIELD_FAX:
                newValue = generateNewNumber(10);
                break;
            case IDENTIFYING_INFO_FIELD_WEBSITE:
                webSiteName = generateNewNumber(5);
                newValue = webSiteName + ".com/";
                break;
            case IDENTIFYING_INFO_FIELD_ALT_EMAIL:
                newValue = generateEmail("alt.test.provider", "gmail.com");
                break;
        }

        if (newValue != null) {
            if (iuProviderDataField != IDENTIFYING_INFO_FIELD_GENDER) {
                driver.findElement(By.xpath(iuProviderDataXpath)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), newValue);
                driver.findElement(By.xpath(iuProviderDataXpath)).sendKeys(Keys.TAB);
                javaWaitSec(2);
                Reports.log("Changed IU Provider  " + iuProviderDataField + " field to: " + newValue);
            } else {
                WebElement dropDown = driver.findElement(By.xpath(iuProviderDataXpath));
                dropDown.click();
                dropDown.sendKeys(Keys.BACK_SPACE);
                dropDown.click();
                clickAndTypeAndSelectOptionInCombobox("Gender", "F", 0);
                dropDown.sendKeys(Keys.ENTER);
                Reports.log("Changed IU Provider  " + iuProviderDataField + " field to: " + newValue);
            }
        }
        return newValue;
    }

    /**
     * This method verifies that the updated Enrollment Information Section field values displayed on the IU Portal
     * match the Enrollment Information Section field values displayed on the Provider Portal
     *
     * @param portal
     * @param iuProviderUpdatedFieldsList
     */
    public void verifyUpdatedEnrollmentInfoSectionFields(String portal, ArrayList<ArrayList<String>> iuProviderUpdatedFieldsList) {

        for (int i = 0; i < iuProviderUpdatedFieldsList.size(); i++) {
            for (int j = 0; j < iuProviderUpdatedFieldsList.get(i).size() - 1; j++) {
                String updatedFieldName = String.valueOf(iuProviderUpdatedFieldsList.get(i).get(0));
                String updatedFieldValue = String.valueOf(iuProviderUpdatedFieldsList.get(i).get(1));

                //Define variable used to address reformatting an updatedFieldValue if needed
                String compareFieldValue;

                //Define XPath Strings
                String xPathPrefix = "//div[contains(@class,'field_readonly-field')]/h2[contains(text(),'";
                String xPathSuffix = "')]/following::div/div";

                javaWaitSec(5);

                //Retrieve the specified field value displayed on the Enrollment Information Section
                String currentFieldValue = driver.findElement((ENROLLMENT_SECTION)).findElement(
                        By.xpath(xPathPrefix + updatedFieldName + xPathSuffix)).getText();

                //Reformat Phone Number updatedFieldValue
                if (updatedFieldName.equalsIgnoreCase(IDENTIFYING_INFO_FIELD_PHONE) || updatedFieldName.equalsIgnoreCase(IDENTIFYING_INFO_FIELD_FAX)) {
                    compareFieldValue = updatedFieldValue.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3");
                } else {
                    compareFieldValue = updatedFieldValue;
                }

                //For Debugging
                //Reports.log("Current "+portal+" "+updatedFieldName+" Field Value: " + currentFieldValue);
                //Reports.log("Updated "+portal+" "+updatedFieldName+" Field Value: " + compareFieldValue);

                //Assert updated field value matches the value displayed
                Assert.assertEquals(compareFieldValue, currentFieldValue);
                Reports.log("Current and Updated " + portal + " " + updatedFieldName + " field values verified");
            }
        }
    }

    /**
     * This method sets the Enrollment tab for Data Change
     *
     * @param sectionTab
     */
    public void setDataChangeEnrollmentTab(String sectionTab) {
        iuProviderMenuTabSection = sectionTab;
    }

    /**
     * This method builds a list of Data Change related fields
     *
     * @param fieldName
     * @param XPath
     */
    public void buildDataChangeFieldList(String fieldName, String XPath) {
        iuProviderFieldsList.add(new ArrayList<String>(Arrays.asList(fieldName, XPath)));
    }

}





