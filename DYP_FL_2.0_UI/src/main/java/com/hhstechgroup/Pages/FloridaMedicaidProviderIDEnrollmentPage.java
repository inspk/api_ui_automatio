package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.hhstechgroup.common.Data.ProviderID;

public class FloridaMedicaidProviderIDEnrollmentPage extends BaseActions {
    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    protected SoftAssert softAssert = new SoftAssert();

    public FloridaMedicaidProviderIDEnrollmentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // XPATHS
    public static final By RightArrowButton = By.xpath("(//div[contains(@class,'MuiTabs-scrollButtons')])[2]");
    public static final By FloridaMedicaidProviderIdTab = By.xpath("//button[contains(@class,'MuiButtonBase-root')]//span[.='Florida Medicaid Provider ID']");
    public static final By BaseProviderId = By.xpath("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[1]");
    public static final By LocationProviderID = By.xpath("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[2]");
    public static final By StatusOfApplication = By.xpath("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[7]");
    public static final By MenuButton = By.xpath("//div[@class='expansion-panel-menu sc-eqIVtm gfpXD']//button");
    public static final By EditButton = By.xpath("//li[text()='Edit']");
    public static final By StatusDD = By.xpath("//label[text()='Status']/following-sibling::div");
    public static final By ReasonCode = By.xpath("//label[text()='Reason code']/following-sibling::div");
    public static final By updateBtn = By.xpath("//span[text()='Update']");
    //    public static final By confmMessage = By.xpath("//div[text()='Medicaid Provider has been updated successfully.']");
    public static final By confmMessage = By.xpath("//div[@role='alert']");
    public static final By EFFECTIVE_START_DATE = By.xpath("//label[text()[contains(., 'Effective Start Date')]]/following-sibling::div//input[@placeholder='MM/DD/YYYY']");

    public static final String successMsg = "Medicaid Provider has been updated successfully.";

    public static final By REQ_ID_FIELD=
            By.xpath("//label[contains(text(), 'Request ID')]/following::input[1]");

    public static final By SEARCH_BUTTON_ENROLMENT=
            By.xpath("//span[@class='MuiButton-label' and text()='Search']");

    public static final By TEXT_REQ_ID=
            By.xpath("(//div[contains(@class, 'tooltip-wrapper-content')]//p[contains(@class, 'sc-caSCKo guUgTN')])[5]");

    // METHODS
    public void navigateToProviderMedicaid() {
        javaWaitSec(10);
        ajaxClick(RightArrowButton);
        javaWaitSec(2);
        ajaxClick(FloridaMedicaidProviderIdTab);
        javaWaitSec(1);
    }

    public void editDateAndStatus() {
        javaWaitSec(10);
        ajaxClick(MenuButton);
        javaWaitSec(1);
        ajaxClick(EditButton);

        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_STARTDate);
        javaWaitSec(1);
        ajaxClear(EFFECTIVE_START_DATE);
        javaWaitSec(5);
        performSendKeys(EFFECTIVE_START_DATE, getCurrentDate());

        Reports.log("Filled date is : " + getCurrentDate());
        fillInCalendar(changeYearInCurrentDate(3), Data.EFFECTIVE_ENDDate);
        javaWaitSec(1);
        javaWaitSec(2);

//        driver.findElement(StatusDD).click();
//        Reports.log("Suspended");
//        ajaxClick(setSpecificOptionInListbox("Suspended"));
//
//        driver.findElement(ReasonCode).click();
//        Reports.log("MEDICAID AUTH");
//        ajaxClick(setSpecificOptionInListbox("MEDICAID AUTH"));

        javaWaitSec(2);
        ajaxClick(updateBtn);
        Reports.log("Clicked on update button");
        javaWaitSec(3);
        String confMSG = getElementText(confmMessage);
        Assert.assertEquals(successMsg, confMSG);
        Reports.log("Success message is displayed");

    }

    public void serchwithreqID(){
        javaWaitSec(10);
        performClick(REQ_ID_FIELD);
        javaWaitSec(2);
        performSendKeys(REQ_ID_FIELD, ProviderID);
        Reports.log("Entered tracking id is :"+ProviderID);
        javaWaitSec(5);
        ajaxClick(SEARCH_BUTTON_ENROLMENT);
        javaWaitSec(10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_REQ_ID));
        javaWaitSec(5);
        ProviderID = getElementText(TEXT_REQ_ID);
        Reports.log("Fetched Provider ID is: " + ProviderID);
        javaWaitSec(5);

        driver.findElement(By.xpath("//div[@class='table-text-wr']//div[@class='tooltip-wrapper-content']/p[text()='" + ProviderID + "']")).click();

    }

}
