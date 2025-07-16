package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProviderRegistrationPage extends BaseActions {

    public static final By LINK_TEXT_CREATE_ACCOUNT = By.xpath("//a[contains(.,'Create Account')]");

    public static final By TEXT_INPUT_EMAIL = By.xpath("//input[@id='email']");
    public static final By TEXT_FIELD_PASSWORD = By.xpath("//input[@id='password']");
    public static final By BUTTON_CONTINUE = By.xpath("//button[@type='button'][contains(.,'CONTINUE')]");
    public static final By BUTTON_CREATE_ACCOUNT = By.xpath("//button[contains(.,'CREATE ACCOUNT')]");

    public static final By TEXT_FIELD_ORG_NAME = By.cssSelector("input#orgName");
    public static final By TEXT_FIELD_FIRST_NAME = By.cssSelector("input#firstName");
    public static final By TEXT_FIELD_LAST_NAME = By.cssSelector("input#lastName");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input#phone");
    public static final By TEXT_LABEL_ACCOUNT = By.xpath("//h6[contains(.,'CONFIRM ACCOUNT')]");

    /**
     * This ia a parameterized constructor
     * @param driver
     * @param wait
     */
    public ProviderRegistrationPage(WebDriver driver, WebDriverWait wait) { super(driver, wait); }

    /**
     * This method opens registration page
     */
    public void openRegistrationPage() {
        ajaxClick(LINK_TEXT_CREATE_ACCOUNT);
        Reports.log("Click Create Account link ");
    }

    /**
     * This method fills and submits new provider registration form
     * @param email
     * @param password
     * @param nameOfOrganization
     * @param firstName
     * @param lastName
     * @param phoneNumber
     */
    public void createNewProviderAccount(
            String email,
            String password,
            String nameOfOrganization,
            String firstName,
            String lastName,
            String phoneNumber) {
        javaWaitSec(5);

        //Account Information

        driver.findElement(TEXT_INPUT_EMAIL).sendKeys(email);
        Reports.log("Entered email: " + email);

        driver.findElement(TEXT_FIELD_PASSWORD).sendKeys(password);
        Reports.log("Entered password: " + password);

        driver.findElement(BUTTON_CONTINUE).click();
        Reports.log("Clicked on the Continue button \n");

        //Organization Information

        driver.findElement(TEXT_FIELD_ORG_NAME).sendKeys(nameOfOrganization);
        Reports.log("Entered organization name: " + nameOfOrganization);

        driver.findElement(BUTTON_CONTINUE).click();
        Reports.log("Clicked on the Continue button \n");

        //Personal Information
        driver.findElement(TEXT_FIELD_FIRST_NAME).sendKeys(firstName);
        Reports.log("Entered first name: " + firstName);

        driver.findElement(TEXT_FIELD_LAST_NAME).sendKeys(lastName);
        Reports.log("Entered last Name: " + lastName);

        driver.findElement(TEXT_FIELD_PHONE).sendKeys(phoneNumber);
        Reports.log("Entered Phone Number:" + phoneNumber);

        javaWaitSec(5);
        driver.findElement(BUTTON_CREATE_ACCOUNT).click();
        Reports.log("Clicked on the Create Account button \n");

        // WebElement iframeCaptcha = driver.findElement(By.xpath("//iframe[contains(@src, 'https://www.google.com/recaptcha/api2/anchor')]"));
        // driver.switchTo().frame(iframeCaptcha);

        ///  driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();

//        javaWaitSec(8);
//        ajaxClick(BUTTON_CREATE_ACCOUNT);

//       if(!verifyThatElementIsDisplayed(TEXT_LABEL_ACCOUNT))
//       {ajaxClick(BUTTON_CREATE_ACCOUNT);}

        Reports.log("Registration Submitted.\n");
    }
}
