package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LandingPage extends BaseActions {

    public static final By AGREE_BUTTON = By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[1]");
    public static final By DISAGREE_BUTTON = By.xpath("(//button[contains(@class,'MuiButtonBase-root')])[2]");
    public static final By SECURE_MESSAGE = By.xpath("//div[contains(@class,'landing-new_card')]");
    public static final By AUTHORIZED_MESSAGE = By.xpath("(//div[contains(@class,'landing-new_card')]/following::p)[2]");

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public LandingPage(
            WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method confirms Agree and Secure Messages
     */
    public void confirmAgreeAndSecureMessages() {
        javaWaitSec(10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Agree')]")));
        ajaxClick(By.xpath("//button[contains(.,'Agree')]"));
        javaWaitSec(2);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Update')]")));
            ajaxClick(By.xpath("//span[contains(.,'Update')]"));
            javaWaitSec(2);
        }catch (Exception e){}

        Reports.log("Click on Agreed to Secure Message");
        javaWaitSec(5);

    }

    /**
     * This method verifies if agree and disAgree buttons are displayed
     */
    public void verifyAgreeDisagreeButtons() {
        Reports.log("\nVerifying Agree and DisAgree buttons");
        String agreeButton = driver.findElement(AGREE_BUTTON).getText();
        Reports.log(agreeButton + " button is displayed");
        String disAgreeButton = driver.findElement(DISAGREE_BUTTON).getText();
        Reports.log(disAgreeButton + " button is displayed\n");
    }

    /**
     * This method clicks on agree button and System navigate to the next screen(Dashboard page)
     */

    public void verifyAgreeButtonFunctionality() {
        driver.findElement(AGREE_BUTTON).click();
        Boolean  verifyAgreeButton = driver.getCurrentUrl().equalsIgnoreCase("https://sit-01.sd.hhstechgroup.com/dashboard");
        Assert.assertTrue(verifyAgreeButton);
        Reports.log("User is in dashboard page");
    }

    /**
     * This method clicks on disagree button and System navigate to the next screen(login page)
     */

    public void verifyDisagreeButtonFunctionality() {
        driver.findElement(DISAGREE_BUTTON).click();
        Boolean verifyDisagreeButton = driver.getCurrentUrl().equalsIgnoreCase("https://sit-01.sd.hhstechgroup.com/landing");
        Assert.assertTrue(verifyDisagreeButton);
        Reports.log("User is in login page");
    }


    /**
     * This method verifies secure messages in landing page
     */
    public void VerifySecureMessages() {
       String message = driver.findElement(SECURE_MESSAGE).getText();
       // Reports.log("message is: " + message);
        String authorizeMessage = driver.findElement(AUTHORIZED_MESSAGE).getText();
        Reports.log("authorizeMessage is: " + authorizeMessage);
        Assert.assertTrue(authorizeMessage.contains("Florida"));
        Reports.log("authorizeMessage contains South Dakota");
        Assert.assertTrue(authorizeMessage.contains(Data.SD_CONTENT));
        Reports.log("authorizeMessage contains South Dakota content");
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
     * This method clicks on enrollment tab
     */
    public void clickEnrollmentTab() {
        Reports.log("Click header tab: " + Data.textEnrollmentTab);
        clickAnyHeaderTitLe(Data.textEnrollmentTab);
        javaWaitSec(10);
    }

    public void clickCocTab() {
        Reports.log("Click header tab: " + "Coc");
        clickAnyHeaderTitLe("CoC");
        javaWaitSec(10);
    }

    /**
     * This method clicks on Reconsideration tab
     */
    public void clickReconsiderationTab() {
        Reports.log("Click header tab: " + "Reconsideration");
        clickAnyHeaderTitLe("Reconsideration");
        javaWaitSec(10);
    }

    public void clickAuditTab() {
        Reports.log("Click header tab: " + "Audit");
        clickAnyHeaderTitLe("Audit");
        javaWaitSec(10);
    }

    public void clickSearchButtonAndVerifyNumberOfRows() {
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
        javaWaitSec(4);
        String searchResult = driver.findElement(By.xpath("//div[contains(@class,'styles_search-box-container')]/following::h2")).getText();
        int value = Integer.parseInt(searchResult.replaceAll("[^0-9]", ""));
        System.out.println(value);
        System.out.println("Number of records displayed in search result is: " + value);
        List<WebElement> tableList = driver.findElements(By.xpath("//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div"));
        int noOfRows = tableList.size();
        Reports.log("Number of rows in first page " + noOfRows);
        Assert.assertTrue(noOfRows > 0);
        Reports.log("Number of rows has been verified");
    }
}