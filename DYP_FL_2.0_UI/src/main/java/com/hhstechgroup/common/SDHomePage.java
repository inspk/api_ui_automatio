package com.hhstechgroup.common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * HomePage class provides all the functionalities in the home page of DYP application
 */
public class SDHomePage extends BaseActions {
    public static final By LINK_TEXT_CREATE_ACCOUNT = By.xpath("//a[contains(.,'Create Account')]");
    public static final By TEXT_INPUT_USERNAME = By.xpath("//input[@id='username']");
    public static final By TEXT_INPUT_PASSWORD = By.xpath("//input[@id='password']");
    //public static final By  LINK_TEXT_FORGOT_PASSWORD = By.xpath("//a[@href='/reset-password'][contains(.,'Forgot password?')]");
    public static final By TEXT_INPUT_EMAIL = By.xpath("//input[@id='email']");
    public static final By TEXT_FIELD_PASSWORD = By.xpath("//input[@id='password']");
    public static final By BUTTON_CONTINUE = By.xpath("//button[@type='button'][contains(.,'CONTINUE')]");
    public static final By BUTTON_CREATE_ACCOUNT = By.xpath("//button[contains(.,'CREATE ACCOUNT')]");
    public static final By TEXT_FIELD_USERNAME = By.cssSelector("input#username");
    public static final By TEXT_FIELD_PASSWORD_LOGIN = By.xpath("//div[contains(@class, 'login')]//input[@autocomplete='current-password']");
    public static final By  LINK_TEXT_FORGOT_PASSWORD = By.xpath("//a[@href='/reset-password'][contains(.,'Forgot password?')]");
    public static final By TEXT_FIELD_PASSWORD_REGISTRATION = By.xpath("//div[contains(@class, 'registration_registration')]//input[@autocomplete='current-password']");
    public static final By BUTTON_REGISTRATION = By.xpath("//div[contains(@class, 'registration_registration')]//span[text() = 'Register']");
    // public static final By ERROR_ALERT_DIALOG_MESSAGE = By.xpath("//span[contains(.,'Incorrect email address or password')]");
    public static final By TEXT_FIELD_ORG_NAME = By.cssSelector("input#orgName");
    public static final By TEXT_FIELD_FIRST_NAME = By.cssSelector("input#firstName");
    public static final By TEXT_FIELD_LAST_NAME = By.cssSelector("input#lastName");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input#phone");
    //Reset Password
    public static final By TEXT_FIELD_RESET_EMAIL = By.xpath("//input[@id='email']");
    public static final By BUTTON_RESET_PASSWORD= By.xpath("//span[contains(.,'Reset Password')]");

    public static final By TEXT_FIELD_NEW_PASSWORD = By.xpath("//input[@id='newPassword']");
    public static final By TEXT_FIELD_COMPARE_PASSWORD = By.xpath("//input[@id='newPasswordToCompare']");
    public static final By BUTTON_CHANGE_PASSWORD = By.xpath("//button[@type='submit']");
    public static final By BUTTON_PWD_RESET_SUCCESSFUL_BACKTOLOGIN = By.xpath("//span[contains(.,'BACK TO LOG IN')]");

    public static final By ERROR_ALERT_DIALOG_MESSAGE = By.xpath("//div[@role='alertdialog']//div[1]//span");
    public static final By ERROR_MESSAGE_FOR_INVALID_CREDENTIALS= By.xpath("//div[starts-with(@class,'utils_field-errors_')]//div");
    public static final By BUTTON_BACKTOLOGIN = By.xpath("//span[contains(@class, 'jss136')]");
    public static final By ADDAffiliation_ENROLLPROVIDER_BUTTON = By.xpath("//span[contains(.,'+ Enroll Provider')]");
    public static final By PROVIDERINFO_POPUP_Email = By.xpath("(//textarea[@type='text'])[1]");
    public static final By PROVIDERINFO_POPUP_FirstName = By.xpath("(//textarea[@type='text'])[2]");
    public static final By PROVIDERINFO_POPUP_LastName = By.xpath("(//textarea[@type='text'])[3]");
    public static final By PROVIDERINFO_POPUP_ProceedButton = By.xpath("//button[contains(.,'Proceed')]");
    public static final By TEXT_FIELD_PROVIDER_ID = By.xpath("//input[@id='ProviderID']");
    public static final By COC_TAB = By.xpath("//ul//li//a[@href='/coc-list']");
    public static final By ENROLLMENT_TAB = By.xpath("//ul/li/a[text()='Enrollment']");
    public static final By APPEALS_TAB = By.xpath("//ul//li//a[contains(@href, '/appeal')]");
    public static final By AUDIT_TAB = By.xpath("//ul/li/a[text()='Audit']");
    public static final By REPORTS_TAB = By.xpath("//ul/li/a[text()='Reports']");
    public static final By SITE_VISITIS_TAB = By.xpath("//ul/li/a[text()='Site visits']");
    public static final By VOTING_TAB = By.xpath("//ul/li/a[text()='Voting']");
    public static final By HELPING_CENTER_TAB = By.xpath("//ul/li/a[text()='Help center']");
    public static final By DOCUMENTS_TAB = By.xpath("//div[contains(@class, 'header_header')]//ul/li/a[text()='Documents']");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");

    /**
     * This is a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public SDHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void signInToApp(String email, String password) {
        javaWaitSec(2);
        Reports.log("Type username: " + email);
        driver.findElement(TEXT_INPUT_USERNAME).sendKeys(email);
        javaWaitSec(1);
        Reports.log("Type password: " + password);
        driver.findElement(TEXT_INPUT_PASSWORD).sendKeys(password);
        javaWaitSec(2);
        Reports.log("Click login button");
        clickAnyButton(Data.LOGIN_TEXT);
        confirmAgreeAndSecureMessages();
        javaWaitSec(1);
    }



    /**
     * This method signs in to application by passing a username and password
     * @param email
     * @param password
     */
    public void enterLoginCredentials(String email, String password) {

        Reports.log("Click Sign in / Register button");
        clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
        Reports.log("Type username: " + email);
        driver.findElement(TEXT_FIELD_USERNAME).sendKeys(email);

        Reports.log("Type password: " + password);
        driver.findElement(TEXT_FIELD_PASSWORD_LOGIN).sendKeys(password);
        javaWaitSec(2);
        clickAnyButton(Data.TEXT_LOGIN);
        Reports.log("Click login button");

    }

    /**
     * This method clicks on Sign in/ Register button
     */
    public void clickOnSignInOrRegisterButton() {
        Reports.log("Click Sign in / Register button");
        clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
    }

    /**
     * This method enters a user name
     * @param email
     */
    public void enterUserName(String email) {
        Reports.log("Type username: " + email);
        driver.findElement(TEXT_FIELD_USERNAME).sendKeys(email);
    }

    /**
     * This method clicks on forgot password button
     */
    public void clickOnForgotPassword() {
        Reports.log("Click on Forgot Password button");
        ajaxClick(LINK_TEXT_FORGOT_PASSWORD);
    }

    /**
     * This email enters email and clicks on reset password button
     * @param email
     */
    public void enterEmailIdAndClickOnResetPwdBtn(String email) {
        javaWaitSec(3);
        driver.findElement(TEXT_FIELD_RESET_EMAIL).sendKeys(email);
        Reports.log("Enter Reset  emailId as: " + email);

        ajaxClick(BUTTON_RESET_PASSWORD);
        Reports.log("Clicked on  Reset Password button");
    }

    /**
     * This method enters new password and confirms password
     * @param newPassword
     */
    public void enterNewPasswordAndConfirmPassword(String newPassword) {
        javaWaitSec(3);
        driver.findElement(TEXT_FIELD_NEW_PASSWORD).sendKeys(newPassword);
        Reports.log("Enter new password as: " + newPassword);

        driver.findElement(TEXT_FIELD_COMPARE_PASSWORD).sendKeys(newPassword);
        Reports.log("Enter Re-enter new password as: " + newPassword);

        ajaxClick(BUTTON_CHANGE_PASSWORD);
        Reports.log("Clicked on  Change Password button");

        javaWaitSec(2);
        ajaxClick(BUTTON_PWD_RESET_SUCCESSFUL_BACKTOLOGIN);
        Reports.log("Password has changed Successfully!!!");
    }

    /**
     * This method gets Alert Error Message
     * @return
     */
    public String getAlertErrorMessage(){
        String alertMessage = driver.findElement(ERROR_ALERT_DIALOG_MESSAGE).getText();
        String errorMessage = driver.findElement(ERROR_MESSAGE_FOR_INVALID_CREDENTIALS).getText();
        Reports.log("Displayed Error message "+alertMessage);
        //    Reports.log("Displayed Error message "+errorMessage);
        return alertMessage;
    }

    /**
     * This method verifies the Alert Message
     * @param actualErrorMessage
     * @param expectErrorMessage
     */
    public void verifyTheAlertMessage(String actualErrorMessage, String expectErrorMessage) {
        javaWaitSec(1);
        Assert.assertTrue(actualErrorMessage.equalsIgnoreCase(expectErrorMessage));
        // Assert.assertEquals(actualErrorMessage, expectErrorMessage);

    }

    /**
     * This method confirms Agree and Secure Messages
     */
    public void confirmAgreeAndSecureMessages() {
        javaWaitSec(2);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Agree')]")));
        ajaxClick(By.xpath("//button[contains(.,'Agree')]"));
        javaWaitSec(2);
        try{
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-type='close']")));
            ajaxClick(By.xpath("//button[@data-type='close']"));
        }catch (Exception e){}

        Reports.log("Click on Agreed to Secure Message");
        javaWaitSec(2);
    }

    /**
     * This method clicks Update PopUp For NewUser
     */
    public void clickUpdatePopUpForNewUser() {
        try {
            driver.findElement(By.xpath("//span[text() = '" + Data.TEXT_UPDATE + "']")).click();
            driver.findElement(By.xpath("//span[text() = '" + Data.TEXT_OK + "']")).click();


        } catch (Exception e) {

        }
    }

    /**
     * This method opens registration page
     */
    public void openRegistrationPage() {
        Reports.log("Click Create Account link ");
        ajaxClick(LINK_TEXT_CREATE_ACCOUNT);
    }

    /**
     * This method confirms registration
     */
    public void confirmRegistration() {
        Reports.log("Confirmation Completed.");
        ajaxClick(BUTTON_BACKTOLOGIN);
    }

    /**
     * This method clicks on Add enrolls provider button
     */
    public void clickAddEnrollProviderButton() {
        Reports.log("Clicked on Enroll Provider Button");
        ajaxClick(ADDAffiliation_ENROLLPROVIDER_BUTTON);
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
    public void fillInNewRegistrationPage(
            String email,
            String password,
            String nameOfOrganization,
            String firstName,
            String lastName,
            String phoneNumber) {
        javaWaitSec(5);

        //Account Information
        Reports.log("Fill in email: " + email);
        driver.findElement(TEXT_INPUT_EMAIL).sendKeys(email);

        Reports.log("Fill in password: " + password);
        driver.findElement(TEXT_FIELD_PASSWORD).sendKeys(password);

        Reports.log("Click on the Continue button");
        driver.findElement(BUTTON_CONTINUE).click();

        //Organization Information
        Reports.log("Fill in organization name: " + nameOfOrganization);
        driver.findElement(TEXT_FIELD_ORG_NAME).sendKeys(nameOfOrganization);
        Reports.log("Click on the Continue button");
        driver.findElement(BUTTON_CONTINUE).click();

        //Personal Information
        Reports.log("Fill in first name: " + firstName);
        driver.findElement(TEXT_FIELD_FIRST_NAME).sendKeys(firstName);

        Reports.log("Fill in last Name: " + lastName);
        driver.findElement(TEXT_FIELD_LAST_NAME).sendKeys(lastName);

        Reports.log("Fill in Phone Number:" + phoneNumber);
        driver.findElement(TEXT_FIELD_PHONE).sendKeys(phoneNumber);

        // WebElement iframeCaptcha = driver.findElement(By.xpath("//iframe[contains(@src, 'https://www.google.com/recaptcha/api2/anchor')]"));
        // driver.switchTo().frame(iframeCaptcha);

        ///  driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        javaWaitSec(10);
        ajaxClick(BUTTON_CREATE_ACCOUNT);
        javaWaitSec(10);
        Reports.log("Registration Submitted.");
    }
    /**
     * This method verifies duplication of email
     * @param email
     */
    public void verifyDuplicationOfEmail(String email) {
        try {
            if (driver.findElement(By.xpath("//span[text()='User with such email address already exists']")).isDisplayed()) {
                Reports.log("Fill in email: " + email);
                driver.findElement(TEXT_FIELD_EMAIL).sendKeys(email);
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method enters provider information popUp
     * @param email
     * @param fname
     * @param lname
     */
    public void enterProviderInformationPopUp(String email, String fname, String lname) {

        Reports.log("Type Email: " + email);
        driver.findElement(PROVIDERINFO_POPUP_Email).sendKeys(email);

        Reports.log("Type First Name: " + fname);
        driver.findElement(PROVIDERINFO_POPUP_FirstName).sendKeys(fname);

        Reports.log("Type Last Name: " + lname);
        driver.findElement(PROVIDERINFO_POPUP_LastName).sendKeys(lname);

        ajaxClick(PROVIDERINFO_POPUP_ProceedButton);
        Reports.log("Clicked on proceed button");
    }

    /**
     * This method verifies that if all links on Web Page are active
     */
    public void verifyLinksOnWebPage(){
        javaWaitSec(10);
        checkLinksOnWebPage("//a", "href");
        checkLinksOnWebPage("//img", "src");
        driver.findElement(By.xpath("//a[@href='/info-for-providers']")).click();
        Reports.log("Click On Info for Providers Link");
        checkLinksOnWebPage("//a", "href");
        checkLinksOnWebPage("//img", "src");
        driver.findElement(By.xpath("//a[@href='/provider-search']")).click();
        Reports.log("Click On Provider Search Link");
        checkLinksOnWebPage("//a", "href");
        checkLinksOnWebPage("//img", "src");
    }

    /**
     * This method verifies links on HomePage
     */
    public void verifyLinkOnHomePage(){
        javaWaitSec(10);
        Reports.log("Verifying the link on the Home Page");
        checkLinksOnWebPage("//a", "href");
        Reports.log("Verifying the Images on the Page");
        checkLinksOnWebPage("//img", "src");
        Reports.log("*************************************************************************************************************");
    }

    /**
     * This method verifies links on Provider Search Page
     */
    public void  verifyLinkOnProviderSearchPage() {
        driver.findElement(By.xpath("//a[@href='/provider-search']")).click();
        Reports.log("Click On Provider Search Link");
        Reports.log("Verifying the link on the Page");
        checkLinksOnWebPage("//a", "href");
        Reports.log("Verifying the Images on the Page");
        checkLinksOnWebPage("//img", "src");
        Reports.log("*************************************************************************************************************");

    }

    /**
     * This method verifies Links on Info for Providers
     */
    public  void verifyLinkOnInfoForProviders() {
        javaWaitSec(5);
        driver.findElement(By.xpath("//a[@href='/info-for-providers']")).click();
        Reports.log("Click On Info for Providers Link");
        Reports.log("Verifying the link on the Page");
        checkLinksOnWebPage("//a", "href");
        Reports.log("Verifying the Images on the Page");
        checkLinksOnWebPage("//img", "src");
    }

    /**
     * This method clicks On Enrollment Type
     * @param enrollmentType
     */
    public void clickOnEnrollmentType(String enrollmentType){
        clickAnyTitleByText(enrollmentType, Data.h2);
        javaWaitSec(3);
    }

    /**
     * This method verifies if all Tabs are displayed for new user
     */
    public void verifyAllTabsAreDisplayedForNewUser(){
        Reports.log("Verifying all the tabs are present for the active user");
        verifyThatElementIsDisplayed(TEXT_FIELD_PROVIDER_ID);
        verifyThatElementIsDisplayed(COC_TAB);
        verifyThatElementIsDisplayed(ENROLLMENT_TAB);
        verifyThatElementIsDisplayed(APPEALS_TAB);
        verifyThatElementIsDisplayed(AUDIT_TAB);
        verifyThatElementIsDisplayed(REPORTS_TAB);
        verifyThatElementIsDisplayed(SITE_VISITIS_TAB);
        verifyThatElementIsDisplayed(VOTING_TAB);
        verifyThatElementIsDisplayed(HELPING_CENTER_TAB);
        verifyThatElementIsDisplayed(DOCUMENTS_TAB);
        javaWaitSec(5);
        Reports.log("new user Logged out successfully");
    }
}
