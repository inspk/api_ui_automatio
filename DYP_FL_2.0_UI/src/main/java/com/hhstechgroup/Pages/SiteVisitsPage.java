package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SiteVisitsPage extends BaseActions {

    public static final By SITE_VISITIS_TAB = By.xpath("//ul/li/a[text()='Site visits']");
    public static final By TEXT_FIELD_PROVIDER_SITE_VISIT = By.cssSelector("input#ProviderSiteVisit");
//    public static final By TEXT_FIELD_PROVIDER_SITE_VISIT = By.xpath("//input[contains(@placeholder,'MM/DD/YYYY')]");

    public static final By POPUP_Waive_SITEVISIT_REASON = By.xpath("(//div[contains(@role,'button')])[3]");
    public static final By ELLIPSE_BUTTON = By.xpath("//div[contains(@class, 'tile-table-body')]//button[@aria-label='More']");
    public static final By SELECT_WAVIE_OPTION = By.xpath("(//li[@role='menuitem'])[4]");
    public static final By BUTTON_SEARCH = By.xpath("//button[contains(@class, 'search-box-action')]");
    public static final By APPLYBUTTON_WAVIE_POPUP = By.xpath("//button[contains(.,'Apply')]");
    public static final By OK_BUTTON_CONFIRMATION_POPUP = By.xpath("//button[contains(.,'OK')]");

    /**
     * This ia a parameterized constructor
     * @param driver
     * @param wait
     */
    public SiteVisitsPage(
            WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void searchForProvider(String fname, String lName){
        driver.findElement(TEXT_FIELD_PROVIDER_SITE_VISIT).sendKeys(fname + " " + lName);
        ajaxClick(BUTTON_SEARCH);
        javaWaitSec(5);
    }

    public void searchForProviderSiteVisitAndWave(String fname, String lName)
    {
        searchForProvider(fname,lName);
        ajaxClick(ELLIPSE_BUTTON);
        ajaxClick(SELECT_WAVIE_OPTION);
        javaWaitSec(3);

        driver.findElement(POPUP_Waive_SITEVISIT_REASON).click();
        List<WebElement> elements1 = driver.findElements(By.xpath("(//li[@role='option'])"));
        ajaxClick(elements1.get(1));
        javaWaitSec(3);
        ajaxClick(Locators.APPLYBUTTON_WAVIE_POPUP);
        javaWaitSec(5);
        ajaxClick(OK_BUTTON_CONFIRMATION_POPUP);
        javaWaitSec(5);
    }
}
