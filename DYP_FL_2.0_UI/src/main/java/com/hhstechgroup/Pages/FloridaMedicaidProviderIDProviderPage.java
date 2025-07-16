package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.hhstechgroup.Pages.FloridaMedicaidProviderIDEnrollmentPage.EFFECTIVE_START_DATE;
import static com.hhstechgroup.Pages.FloridaMedicaidProviderIDEnrollmentPage.ReasonCode;

public class FloridaMedicaidProviderIDProviderPage extends BaseActions {

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public FloridaMedicaidProviderIDProviderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //XPATHS

    public static final By FloridaMedicaidProviderIdTab = By.xpath("//button[contains(@class,'MuiButtonBase-root')]//span[.='Florida Medicaid Provider ID']");
    public static final By BaseProviderId = By.xpath("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[1]");
    public static final By LocationProviderID = By.xpath("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[2]");
    public static final By StatusOfApplication = By.xpath("(//div[contains(@class,'tile-table-head-component')]/following-sibling::div[1]//div[contains(@class,'tile-table-row-summary')]//div[1]//p[1])[7]");
    public static final By MenuButton = By.xpath("//div[@class='expansion-panel-menu sc-eqIVtm gfpXD']//button");
    public static final By EditButton = By.xpath("//li[text()='Edit']");
    public static final By StatusDD = By.xpath("//label[text()='Status']/following-sibling::div");
    public static final By updateBtn = By.xpath("//span[text()='Update']");
    public static final By confmMessage = By.xpath("//div[@role='alert']");

    public static final String successMsg="Medicaid Provider has been updated successfully.";


    //METHODS
    public void navigateToProviderMedicaid() {

        ajaxClick(FloridaMedicaidProviderIdTab);
        javaWaitSec(4);
    }

    public void editDateAndStatus() {
        ajaxClick(MenuButton);
        javaWaitSec(1);
        ajaxClick(EditButton);


//        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_STARTDate);
//        javaWaitSec(1);
//        fillInCalendar(changeYearInCurrentDate(3), Data.EFFECTIVE_ENDDate);
//        javaWaitSec(1);
//        javaWaitSec(2);
//
//        driver.findElement(StatusDD).click();
//        Reports.log("Select status: " + "TERM - SV");
//        ajaxClick(setSpecificOptionInListbox("TERM - SV"));

        fillInCalendar(getCurrentDate(), Data.EFFECTIVE_STARTDate);
        javaWaitSec(1);
        ajaxClear(EFFECTIVE_START_DATE);
        javaWaitSec(5);
        performSendKeys(EFFECTIVE_START_DATE, getCurrentDate());

        Reports.log("Filled date is : " + getCurrentDate());
        fillInCalendar(changeYearInCurrentDate(3), Data.EFFECTIVE_ENDDate);
        javaWaitSec(1);
        javaWaitSec(2);

        driver.findElement(StatusDD).click();
        Reports.log("Suspended");
        ajaxClick(setSpecificOptionInListbox("Suspended"));

        driver.findElement(ReasonCode).click();
        Reports.log("MEDICAID AUTH");
        ajaxClick(setSpecificOptionInListbox("MEDICAID AUTH"));

        javaWaitSec(2);
        ajaxClick(updateBtn);
        Reports.log("Clicked on update button");
        javaWaitSec(3);
        String confMSG=getElementText(confmMessage);
        Assert.assertEquals(successMsg,confMSG);
        Reports.log("Success message is displayed");

    }
}

