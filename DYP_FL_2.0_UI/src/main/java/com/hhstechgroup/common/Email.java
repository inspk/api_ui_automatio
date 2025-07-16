package com.hhstechgroup.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Email class provides all the functionality of email configuration
 */
public class Email extends BaseActions {

    //Gmail
    public static final By PASSWORD_GMAIL = By.xpath("//input[contains(@type, 'password')]");
    public static final By EMAIL_GMAIL = By.xpath(".//input[contains(@id, 'identifierId')]");
    public static final By EMAIL_NEXT_BUTTON = By.xpath(".//div[contains(@id, 'identifierNext')]");
    public static final By PASSWORD_NEXT_BUTTON = By.xpath(".//div[contains(@id, 'passwordNext')]");
    public static final By GOOGLE_APPS = By.xpath(".//a[@aria-label='Google apps']/../a");
    public static final By GOOGLE_APPS_IFRAME = By.xpath("//iframe[contains(@id, 'I0')]");
    public static final By GMAIL_ICON = By.xpath("//span[@pid='23']");
    public static final By SEARCH_INPUT = By.xpath(".//form[@role='search']//input[@type='text']/../input");
    public static final By SEARCH_BUTTON = By.xpath(".//button[@aria-label='Search mail']");
    public static final By SELECT_CHECKBOX = By.xpath("//div[contains(@aria-label,'Select')]//span[contains(@role,'checkbox')]");
    public static final By DELETE_BUTTON = By.xpath("//div[contains(@aria-label,'Delete')]");
//    public static final By BUTTON_BACKTOLOGIN = By.xpath("//span[contains(@class, 'jss136')]");
    public static final By BUTTON_BACKTOLOGIN = By.xpath("//span[contains(@class, 'MuiButton-label')]");

    public static final By BUTTON_SEARCH = By.xpath("//button[contains(@class, 'search-box-action')]");
    public static final By ELLIPSE_BUTTON = By.xpath("//div[contains(@class, 'tile-table-body')]//button[@aria-label='More']");
    //public static final By CONFIRM_LINK= By.xpath("//a[contains(.,'confirm')]");
   public static final By CONFIRM_LINK= By.xpath("//a[contains(.,'Confirm Account')]");

    /**
     * This is a parameterized constructor
     * @param driver
     * @param wait
     */
    public Email(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method opens Gmail
     */
    public void openGmail() {
        //String providerGmail = "wyoming.sit2@gmail.com";
        String providerGmail = "somatha21@gmail.com";

        driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");

        Reports.log("Type email: " + providerGmail);
        driver.findElement(EMAIL_GMAIL).sendKeys(providerGmail);

        Reports.log("Click Next button");
        driver.findElement(EMAIL_NEXT_BUTTON).click();

        //  mainPageIU.ajaxClick(By.xpath("//div[contains(@aria-label, 'Switch account')]"));

        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_GMAIL));
        driver.findElement(PASSWORD_GMAIL).sendKeys(Data.password);
        Reports.log("Entered Password: " + Data.password);
        driver.findElement(PASSWORD_NEXT_BUTTON).click();
        Reports.log("Click Next button");
    }

    /**
     * This method accesses the test email account using the TestNG Parameter 'testEmailAccount' to delete existing test emails
     * @param testEmailAccount
     */
    /*This method is called by deleteTestAccountEmails. It accesses the test email account
      using the TestNG Parameter 'testEmailAccount' to delete existing test emails        */
    public void openTestEmailAccount(String testEmailAccount) {
        String emailAccount = testEmailAccount;

        driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");

//        javaWaitSec(5);
        try {
        advanceFindElement(EMAIL_GMAIL, 20, 2);
        } catch (Exception e) {
            Reports.log("Opening Gmail page is slow");
        }
        Reports.log("Type email: " + emailAccount);
        driver.findElement(EMAIL_GMAIL).sendKeys(emailAccount);

        Reports.log("Click Next button");
        driver.findElement(EMAIL_NEXT_BUTTON).click();

        //  mainPageIU.ajaxClick(By.xpath("//div[contains(@aria-label, 'Switch account')]"));

        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_GMAIL));
        driver.findElement(PASSWORD_GMAIL).sendKeys(Data.password);
        Reports.log("Entered Password: " + Data.password);
        driver.findElement(PASSWORD_NEXT_BUTTON).click();
        Reports.log("Click Next button");
    }

    /**
     * This method opens Gmail and click ConfirmcAccount Link link
     * @param newProviderEmail
     */
    public void openGmailAndClickConformAccountLink(String newProviderEmail) {
        Reports.log("Going to email box and Confirming Email Registration");
        openGmailWithoutRegistration();
        waitAndClickConfirmAccountLink(newProviderEmail);

        Reports.log("Confirmation Completed.");
        javaWaitSec(5);
        ajaxClick(BUTTON_BACKTOLOGIN);
    }



    /**
     * This method waits and Clicks registration Link
     * @param newProviderEmail
     */
    public void  waitAndClickConfirmAccountLink(String newProviderEmail) {
        Reports.log("Entering Email Address for searching");
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        int counter = 0;
        while (true) {
            javaWaitSec(3);
            counter++;
            if (counter == 10) {
                throw new RuntimeException("Not found registration link in many attempts");
            }
            driver.findElement(SEARCH_INPUT).sendKeys(newProviderEmail);
            javaWaitSec(1);
            driver.findElement(SEARCH_BUTTON).click();
            try {
//               ajaxClick(By.xpath("//td//span[contains(text(),'Registration in ProviderPortal')]"));
                ajaxClick(By.xpath("(//td//span//span[contains(text(),'Registration in Provider Portal')])[2]"));
                break;
            } catch (Exception e) {
                Reports.log("Registration Email Not found, " + counter + " time");
            }
            driver.findElement(SEARCH_INPUT).clear();
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_LINK));
            javaWaitSec(2);
            ajaxClick(CONFIRM_LINK);
        } catch(Exception e){
            By CONFIRM_LINK= By.xpath(" //a[contains(.,'Confirm Account')]");
            wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_LINK));
            javaWaitSec(2);
            ajaxClick(CONFIRM_LINK);
        }


        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        //driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    /**
     * This method waits and Clicks registration Link
     * @param newProviderEmail
     */
    public void waitAndClickRegistrationLink(String newProviderEmail) {
        Reports.log("Entering Email Address for searching");
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        int counter = 0;
        while (true) {
            javaWaitSec(3);
            counter++;
            if (counter == 10) {
                throw new RuntimeException("Not found registration link in many attempts");
            }
            driver.findElement(SEARCH_INPUT).sendKeys(newProviderEmail);
            driver.findElement(SEARCH_BUTTON).click();
            try {
                ajaxClick(By.xpath("//td//span[contains(text(),'Registration in ProviderPortal')]"));
                break;
            } catch (Exception e) {
                Reports.log("Registration Email Not found, " + counter + " time");
            }
            driver.findElement(SEARCH_INPUT).clear();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//center//h3/a")));
        //ajaxScroll(By.xpath(".//center//h3/a"));
        javaWaitSec(3);
        ajaxClick(By.xpath(".//center//h3/a"));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        //driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    /**
     * This method waits and Clicks registration Link
     * @param newProviderEmail
     */
    public void waitAndClickResetPasswordLink(String newProviderEmail) {
        Reports.log("Entering Email Address for searching");
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        int counter = 0;
        while (true) {
            javaWaitSec(3);
            counter++;
            if (counter == 10) {
                throw new RuntimeException("Not found registration link in many attempts");
            }
            driver.findElement(SEARCH_INPUT).sendKeys(newProviderEmail);
            driver.findElement(SEARCH_BUTTON).click();
            try {
                ajaxClick(By.xpath("//td//span[contains(text(),'Reset Password for ProviderPortal')]"));
                break;
            } catch (Exception e) {
                Reports.log("Reset Password for ProviderPortal, " + counter + " time");
            }
            driver.findElement(SEARCH_INPUT).clear();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//center//h3/a")));
        //ajaxScroll(By.xpath(".//center//h3/a"));
        javaWaitSec(3);
        ajaxClick(By.xpath(".//center//h3/a"));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        //driver.close();
        driver.switchTo().window(tabs2.get(2));
    }

    /**
     * This method waits and Clicks registration Link
     * @param newProviderEmail
     */
    public void findAndClickREgistrationLinkOnGmail(String newProviderEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        javaWaitSec(20);
        driver.findElement(SEARCH_INPUT).sendKeys(newProviderEmail);
        driver.findElement(SEARCH_BUTTON).click();
        ajaxClick(By.xpath("//td//span[contains(text(),'Registration in ProviderPortal')]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//center//h3/a")));
        ajaxClick(By.xpath(".//center//h3/a"));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        //driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    /**
     * This method waits and Clicks registration Link
     * @param newProviderEmail
     */
    public void findAndClickRegistrationLinkOnGmailInternalUser(String newProviderEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        javaWaitSec(20);
        driver.findElement(SEARCH_INPUT).sendKeys(newProviderEmail);
        driver.findElement(SEARCH_BUTTON).click();
        ajaxClick(By.xpath("//td//span[contains(text(),'Registration in IU Portal')]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//center//h3/a")));
        ajaxClick(By.xpath(".//center//h3/a"));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        //driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    /**
     * This method opens Gmail without registration
     */
    public void openGmailWithoutRegistration() {
        // openGmail();
        javaWaitSec(5);
        Reports.log("Opening Email");
        driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");

//        driver.findElement(By.partialLinkText("Sign in")).click();
//        Reports.log("Clicked on Sign in button");
//
//        String oldTab = driver.getWindowHandle();
//        Reports.log("Active Window old Name :" + oldTab);
//        javaWaitSec(5);
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        Reports.log("Active Window New Name :" + newTab);
//        newTab.remove(oldTab);
//        Reports.log(newTab.get(0));
//        // change focus to new tab
//       driver.switchTo().window(newTab.get(0));
    }

    /**
     * This method deletes existing emails
     */
    public void deleteEmails() {
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        openGmail();
        selectDeleteCheckboxInGmail();
        javaWaitSec(10);
    }

    /**
     * This method uses the TestNG Parameter 'testEmailAccount' to delete existing test emails
     * @param testEmailAccount
     */
    /*This method uses the TestNG Parameter 'testEmailAccount' to delete existing test emails*/
    public void deleteTestAccountEmails(String testEmailAccount) {
        Reports.log("Log-in to the email account and delete existing emails from inbox.");
        String emailAccount = testEmailAccount;
        openTestEmailAccount(emailAccount);
        selectDeleteCheckboxInGmail();
        javaWaitSec(10);
    }

    /**
     * This method selects delete Checkbox in Gmail
     */
    public void selectDeleteCheckboxInGmail() {
        try {

            advanceFindElement(SELECT_CHECKBOX , 20, 1);

            Reports.log("Select All Email checkbox");
            ajaxClick(SELECT_CHECKBOX);
            javaWaitSec(1);
            driver.findElement(DELETE_BUTTON).click();
            javaWaitSec(3);
            Reports.log("Deleted all emails from mailbox");
        } catch (Exception e) {
            Reports.log("Already Existing Gmails are Deleted");
        }
    }

    /**
     * This method opens Gmail and click registration link
     * @param newProviderEmail
     */
    public void openGmailAndClickRegistrationLink(String newProviderEmail) {
        Reports.log("Going to email box and Confirming Email Registration");
        openGmailWithoutRegistration();
        waitAndClickRegistrationLink(newProviderEmail);

        Reports.log("Confirmation Completed.");
        ajaxClick(BUTTON_BACKTOLOGIN);
    }

    /**
     * This method opens Gmail and click registration link
     * @param newProviderEmail
     */
    public void openGmailAndClickResetPasswordLink(String newProviderEmail) {
        Reports.log("Going to email box and Confirming Email Registration");
        openGmailWithoutRegistration();
        waitAndClickResetPasswordLink(newProviderEmail);
        Reports.log("Confirmation Completed.");
    }

    /**
     * This method sets password for new email registration
     * @param newPassword
     */
    public void setPasswordForNewEmailRegistration(String newPassword) {
        javaWaitSec(5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='enterPassword']"))));
        Reports.log("Entering new password");
        // ajaxClick(By.xpath("//input[@id='enterPassword']"));
        driver.findElement(By.xpath("//input[@id='enterPassword']")).sendKeys(newPassword);
        // ajaxSendKeys(newpassword);

        Reports.log("Confirmming new password");
        // ajaxClick(By.xpath("//div[contains(@class,'iELTvK')]/following::input"));
        driver.findElement(By.xpath("//div[contains(@class,'iELTvK')]/following::input")).sendKeys(newPassword);

        Reports.log("click on set password");
        ajaxClick(By.xpath(" //span[text()='Set Password']/ancestor::button"));

        Reports.log("Click on Back to login ");
        ajaxClick(By.xpath("//span[contains(text(),'Back To Log In')]/ancestor::a"));
    }

    /**
     * This method searches user by email
     * @param email
     */
        public void searchUserByEmail(String email) {
            Reports.log("Search for the user by entering the email");
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(email);
            ajaxClick(BUTTON_SEARCH);
            javaWaitSec(2);
            driver.findElement(ELLIPSE_BUTTON).click();
            javaWaitSec(2);

    }
}
