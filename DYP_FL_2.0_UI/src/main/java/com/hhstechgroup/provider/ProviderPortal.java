package com.hhstechgroup.provider;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ProviderPortal class provies methods to complete tasks in provider portal
*/
public class ProviderPortal extends BaseActions {

    /**
     * This constructor method creates a ProviderPortal object
     * @param driver
     * @param wait
     */
    public ProviderPortal(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method navigates to appeal and click appeal button
     */
    public void navigateToAppealAndClickAppealButton() {
        ajaxClick(Locators.APPEALS_TAB);
        Reports.log("Click on Appeal Tab");
        clickAnyButton(Data.TEXT_APPEAL);
        Reports.log("Click On Appeal button, On Appeal page");
        javaWaitSec(5);
        ajaxClick(Locators.APPEALS_ROW);

    }

    /**
     * This method uploads file and submit
     */
    public void uploadFileAndSubmit() {
        ajaxScroll(setAndFindButton((Data.TEXT_UPLOAD_FILES)));
        Reports.log("Click on Upload file Button");
        ajaxUploadFile(Locators.INPUT_UPLOAD_DOCUMENTS);
        Reports.log("Upload the file");
        ajaxClick(Locators.TEXT_FIELD_APPEAL_REASON);
        driver.findElement(Locators.TEXT_FIELD_APPEAL_REASON).sendKeys("Reason");
        driver.findElement(Locators.TEXT_FIELD_APPEAL_FIRST_NAME).sendKeys("Team");
        driver.findElement(Locators.TEXT_FIELD_APPEAL_LAST_NAME).sendKeys("Tester");
        driver.findElement(Locators.CHECKBOX_AGREEMENT).click();
        javaWaitSec(1);
        ajaxScrollUp();
        javaWaitSec(1);
        clickAnyButton(Data.TEXT_Submit);
        javaWaitSec(10);

    }

    /**
     * This method terminates request
     */
    public void terminationRequest(){
        javaWaitSec(1);
        ajaxClick(By.xpath("//div[contains(@class, 'helptour_info')]//span[contains(text(), '" + Data.TEXT_Request_Termination + "')]"));
        Reports.log("Clicked On Request Termination link");
        javaWaitSec(1);
        driver.findElement(Locators.REQUEST_TERMINATION_NOTE).sendKeys(Data.TEXT_REQUEST_TERMINATION);
        javaWaitSec(1);
        ajaxClick(spanContainsText(Data.TEXT_REQUEST_TERMINATION));
        javaWaitSec(1);
        ajaxClick(spanContainsText(Data.TEXT_OK));
        Reports.log("Click Ok Button on Request Termination Confirmation popup");
        javaWaitSec(10);

    }

    }