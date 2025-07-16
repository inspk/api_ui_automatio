package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.xml.sax.Locator;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BaseActions {
    protected SoftAssert softAssert = new SoftAssert();

    public static final By TEXT_INPUT_USERNAME = By.xpath("//input[@id='username']");
    public static final By TEXT_INPUT_PASSWORD = By.xpath("//input[@id='password']");
    //public static final By  LINK_TEXT_FORGOT_PASSWORD = By.xpath("//a[@href='/reset-password'][contains(.,'Forgot password?')]");
    public static final By PROVIDER_SEARCH = By.xpath("//a[@href='/provider-search']");
    public static final By IMAGE = By.xpath("//div[contains(@class,'landing-new_container')]/a/img");
    public static final By EMAIL = By.cssSelector("a[href*='@email']");

    public static final By FOOTER_LINKS = By.xpath("//div[contains(@class,'landing-new_text-right')]/a");
    public static final By CONTACT_US_LINK_BTN = By.xpath("//a[contains(.,'Contact Us')]");

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method Sign In to the DYP Application
     * @param email
     * @param password
     */
    public void signInToApp(String email, String password) {
        javaWaitSec(5);
        driver.navigate().refresh();
        Reports.log("Type username: " + email);
        javaWaitSec(10);
        driver.findElement(TEXT_INPUT_USERNAME).sendKeys(email);
        javaWaitSec(2);
        Reports.log("Type password: " + password);
        driver.findElement(TEXT_INPUT_PASSWORD).sendKeys(password);
        javaWaitSec(5);
        clickAnyButton(Data.LOGIN_TEXT);
        javaWaitSec(5);
    }
    /**
     * This method Verifies the Links on the Login Page
     * @param tagElement
     * @param attribute
     */
    public void verifyLinksOnPage(String tagElement, String attribute) {
        checkLinksOnWebPage(tagElement, attribute);
        Reports.log("All the links as been verified");
    }

    /**
     * This method Verifies the Key Resources Links on the Login page
     *
     */
    public void verifyKeyResourcesLinks() {
        Reports.log("Verifying Key Resources Links on the Login page");
        verifyTheLink(Data.KEY_RESOURCES_SD_MEDICAID_HOME);
        verifyTheLink(Data.KEY_RESOURCES_SD_MEDICAID_PROVIDER_ENROLLMENT_HOME);
        verifyTheLink(Data.KEY_RESOURCES_PROVIDER_FEE_SCHEDULES);
        verifyTheLink(Data.KEY_RESOURCES_PROVIDER_BILLING_MANUALS);
        verifyTheLink(Data.KEY_RESOURCES_MEDICAID_ONLINE_PORTAL);
        verifyTheLink(Data.KEY_RESOURCES_LISTSERV_SIGNUP);
        verifyTheLink(Data.KEY_RESOURCES_SD_ADMINISTRATIVE_RULES);
        verifyTheLink(Data.KEY_RESOURCES_SD_CODIFIED_LAWS);
    }

    /**
     * This method Verifies the links on Footer
     *
     * @return
     */
    public void verifyFooterLinksOnLoginPage() {
        Reports.log("\n Verifying the links on Footer ");
        List<WebElement> listOfTabs = driver.findElements(FOOTER_LINKS);
        ArrayList<String> tabs = new ArrayList<String>();
        //{ "Dashboard","Appeals", "CoC", "Provider Data", "Help center" };
        int noOfTabs = listOfTabs.size();
        Reports.log("Number Of Footer links Available on login page is: " + noOfTabs);
        for (int i = 0; i < noOfTabs; i++) {
            tabs.add(listOfTabs.get(i).getText());
        }
        Reports.log("The Linked are:" + tabs);
//        softAssert.assertTrue(tabs.contains(Data.STATE_HOME_PAGE_LINK_BTN), Data.STATE_HOME_PAGE_LINK_BTN + " link Missing");
//        softAssert.assertTrue(tabs.contains(Data.DISCLAIMER_LINK_BTN), Data.DISCLAIMER_LINK_BTN + " link Missing");
//        softAssert.assertTrue(tabs.contains(Data.ACCESSIBILITY_LINK_BTN), Data.ACCESSIBILITY_LINK_BTN + " link Missing");
        softAssert.assertTrue(tabs.contains(Data.PRIVACY_LINK_BTN), Data.PRIVACY_LINK_BTN + " link Missing");
        softAssert.assertTrue(tabs.contains(Data.TERMS_CONDITION), Data.TERMS_CONDITION + " link Missing");
//        softAssert.assertTrue(tabs.contains(Data.CONTACT_US_LINK_BTN), Data.CONTACT_US_LINK_BTN + " link Missing");
        softAssert.assertAll();
    }

    /**
     * This method Verifies and clicks the Page links and URLs on the Login page
     *
     * @return
     */

    public void verifyAndClickOnLink(String linkName, String pageLink, String pageURL) {
        String parentWindow = driver.getWindowHandle();
        Reports.log("\nVerifying " + linkName + " Link on the Login page");
//        verifyTheLink("Privacy");
        javaWaitSec(1);
        WebElement link = driver.findElement(By.xpath("//a[contains(.,'" + linkName + "')]"));
        ajaxScroll(link);
        Assert.assertTrue(link.isDisplayed());
        String displayedLinkName = link.getText();
        Assert.assertEquals(displayedLinkName, linkName);

        link.click();
        javaWaitSec(1);
//        String pageURL = driver.getCurrentUrl();
        ArrayList<String> openTabs = new ArrayList<String>(driver.getWindowHandles());
        if (openTabs.size() > 1) {
            openTabs.remove(parentWindow);
            switchToParentWindow(openTabs.get(0));
        }
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains(pageLink)) {
            Reports.log("Current URL:" + currentUrl);
            Reports.log("Current Page Title: " + driver.getTitle());
            Assert.assertEquals(currentUrl, pageURL);
            driver.close();
            switchToParentWindow(parentWindow);
            javaWaitSec(1);
        }
    }
    /**
     * This method Verifies Contact Us links on the Login page
     *
     * @return
     */
    public void verifyContactUsLink() {
        Reports.log("\nVerify the link for: " + "Contact Us");
        javaWaitSec(2);
        WebElement link = driver.findElement(CONTACT_US_LINK_BTN);
        ajaxScroll(link);
        Assert.assertTrue(link.isDisplayed());
        String displayedLinkName = link.getText();
        Assert.assertEquals(displayedLinkName, Data.CONTACT_US_LINK_BTN);
        String mailId = link.getAttribute("href");
        Assert.assertEquals(mailId, Data.CONTACT_US_MAIL_ID);
        Reports.log("Contact Us Mail ID:" + mailId);
    }

    public void verifyTheLink(String linkName) {
        javaWaitSec(2);
        WebElement link = driver.findElement(By.xpath("//a[contains(.,'" + linkName + "')]"));
        Reports.log(linkName +"Link is"+ link);
        ajaxScroll(link);
        Assert.assertTrue(link.isDisplayed());
        String displayedLinkName = link.getText();
        Assert.assertEquals(displayedLinkName, linkName);

        Reports.log("\nVerify the link for: " + linkName);
        verifyLinkActive(link.getAttribute("href"));
    }

    public void verifyProviderSearchPageLink(String linkName) {
        javaWaitSec(5);
        ajaxScrollUp();
        WebElement link = driver.findElement(By.xpath("//a[text()='" + linkName + "']"));
        Reports.log(linkName +"Link is"+ link);
        ajaxScroll(link);
        Assert.assertTrue(link.isDisplayed());
        String displayedLinkName = link.getText();
        Assert.assertEquals(displayedLinkName, linkName);

        Reports.log("\nVerify the link for: " + linkName);
        verifyLinkActive(link.getAttribute("href"));
    }

    public void verifyVisibilityOfImg(String image) {
        Boolean imageDisplayed = checkVisibilityOfImg(IMAGE);
        if(imageDisplayed == true) {
            Reports.log(image + " image is displayed\n");
        } else {
            Reports.log(image + " image is not displayed\n");
        }
    }            public void verifySupportEmail () {
        String emailAddress = driver.findElement(EMAIL).getAttribute("href");
        Reports.log(emailAddress);
        verifyLinkActive(emailAddress);
        Reports.log("Support Email Address Link has been Verified");
    }

    public void clickOnProviderSearchButton () {
        javaWaitSec(2);
        driver.findElement(PROVIDER_SEARCH).click();
        Reports.log("\nClick On Provider Search Link");

    }
}