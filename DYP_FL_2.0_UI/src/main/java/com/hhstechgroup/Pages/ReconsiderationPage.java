package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReconsiderationPage extends BaseActions {
    protected SoftAssert softAssert = new SoftAssert();
    public IUEnrollmentPage iuEnrollmentPage = new IUEnrollmentPage(driver, wait);

    public static final By PROVIDER_RECONSIDER_TRACKING_NUMBER = By.xpath("//span[contains(.,'Request ID')]//following::div");
    public static final By INPUT_UPLOAD_DOCUMENTS = By.xpath(".//input[@type=\'file\']");
    public static final By TEXT_FIELD_APPEAL_REASON = By.xpath("//input[contains(@aria-label, 'Reason')]");
    public static final By TEXT_FIELD_APPEAL_FIRST_NAME = By.xpath(".//input[contains(@aria-label, 'First name')]");
    public static final By TEXT_FIELD_APPEAL_LAST_NAME = By.xpath(".//input[contains(@aria-label, 'Last name')]");
    public static final By CHECKBOX_AGREEMENT = By.xpath(".//input[@type='checkbox']");
    public static final By APPEAL_STATUS = By.xpath("//span[text()='Enrollment appeal request']//following::div[contains(@class,'main-info-panel_content')]");
    public static final By ENROLLMENT_STATUS_AFTER_APPEAL = By.xpath("(//p[contains(.,'Status')]//following::span)[1]");
    public static final By BUTTON_SELECT_ORIGINAL_REQUEST_STATUS = By.xpath("//label[contains(text(), 'Select original request status')]/following::div[@role='button']");

    public static final By RECONSIDERATION_TAB = By.xpath("//ul//li//a[contains(@href, '/appeal')]");
    public static final By POPUP_INNER_ENROLLMENT_STATUS = By.xpath("//div[contains(@class, 'requests_popup-inner')]");
    public static final By BUTTON_APPROVE_REASON = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");
    public static final By INDIVIDUAL_TYPE_ENROLLMENT_ROW = By.xpath("//div[contains(@class, 'tile-table-row')]");
    public static final By SELECT_STATUS_DENIED = By.xpath(".//ul[@role='listbox']/li[contains(text(),'Denied')]");
    public static final By SEARCH_RESULT= By.xpath("//div//h2[contains(text(),'Search results')]");
    public static final  String TABLE_INFO = "//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div";


    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
//    public ReconsiderationPage(
//            WebDriver driver, WebDriverWait wait) {
//        super(driver, wait);
//    }


    public ReconsiderationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public  void verifySearchResult() {
        checkSearchResult("Request status", "Approved", SEARCH_RESULT, TABLE_INFO);
    }

    /**
     * This method uploads file and submit
     */
    public void uploadFileAndSubmit() {
        ajaxScroll(setAndFindButton((Data.TEXT_UPLOAD_FILES)));
        Reports.log("Click on Upload file Button");
        ajaxUploadFile(INPUT_UPLOAD_DOCUMENTS);
        Reports.log("Upload the file");
        ajaxClick(TEXT_FIELD_APPEAL_REASON);
        driver.findElement(TEXT_FIELD_APPEAL_REASON).sendKeys("Reason");
        driver.findElement(TEXT_FIELD_APPEAL_FIRST_NAME).sendKeys("Team");
        driver.findElement(TEXT_FIELD_APPEAL_LAST_NAME).sendKeys("Tester");
        driver.findElement(CHECKBOX_AGREEMENT).click();
        javaWaitSec(1);
        ajaxScrollUp();
        javaWaitSec(1);
        clickAnyButton(Data.TEXT_Submit);
        javaWaitSec(10);

    }

    /**
     * This method gets provider reconsideration tracking number
     *
     * @return
     */
    public String getProviderReconsiderationTrackingID() {
        javaWaitSec(5);
        String trackingNum = driver.findElement(PROVIDER_RECONSIDER_TRACKING_NUMBER).getText();
        Reports.log("Providers Reconsider Tracking Number:" + trackingNum);
        return trackingNum;
    }


    /**
     * This method navigates to Reconsideration and search for the provider
     * @param firstName
     * @param trackingNum
     */
    public void navigateToReconsiderationAndSearchForTheProvider(String firstName, String trackingNum) {
        ajaxClick(RECONSIDERATION_TAB);
        iuEnrollmentPage.searchProvider(firstName, trackingNum);
        javaWaitSec(5);
        WebElement reconsider_row = driver.findElements(INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        javaWaitSec(5);
        reconsider_row.click();

    }

    /**
     * This method changes Status With Reason
     *
     * @param statusOfApplication
     */
    public void changeStatusWithReasonForReconsideration(String statusOfApplication) {
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        performClick(POPUP_INNER_ENROLLMENT_STATUS);

        if (statusOfApplication.contains("Approved")) {
            Reports.log("Select Status of application: " + statusOfApplication );
            clickAnyOptionInList(statusOfApplication);
            driver.findElement(BUTTON_SELECT_ORIGINAL_REQUEST_STATUS).click();
        } else if (statusOfApplication.contains("Denied")) {
            clickAnyOptionInList(Data.ApplicationStatusDenied);
            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        }
        Reports.log("Select original request status: " + statusOfApplication );
        clickAnyOptionInList(statusOfApplication);
        driver.findElement(BUTTON_APPROVE_REASON).click();
        Reports.log("Select Reason from dropdown: " + Data.APPROVED_SPECIAL_REQUEST );
        clickAnyOptionInList(Data.APPROVED_SPECIAL_REQUEST);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(20);
        driver.navigate().refresh();
        javaWaitSec(10);
    }

    /**
     * This method gets application status
     *
     * @return
     */
    public String getEnrollmentStatusAfterAppeal() {
        String applicationStatus = driver.findElement(ENROLLMENT_STATUS_AFTER_APPEAL).getText();

        //Reports.log("Current Application Status :" + applicationStatus);
        return applicationStatus;
    }

    public void checkSearchResult(String text, String data, By locator, String tableInfo) {
        clickSpecificSearchFieldAndSendData(text, data);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
        javaWaitSec(20);
        String searchResult = driver.findElement(locator).getText();
        int value = Integer.parseInt(searchResult.replaceAll("[^0-6]", ""));
        System.out.println("Number displayed in search result is: " + value);
        List<WebElement> tableList = driver.findElements(By.xpath(tableInfo));
        int noOfRows = tableList.size();
        Reports.log("Number of rows " + noOfRows);
        for (int i = 1; i <= noOfRows; i++) {
            WebElement row = driver.findElement(By.xpath("(" + tableInfo + ")[" + i + "]"));
            String rowInfo = row.getText();
            if (rowInfo.contains(data)) {
            }
        }
        Reports.log("Search result has been verified\n");
    }

}