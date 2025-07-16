package com.hhstechgroup.common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * HomePage class provides all the functionalities in the home page of DYP application
 */
public class HomePage extends BaseActions {
    /**
     * This ia a parameterized constructor
     * @param driver
     * @param wait
     */
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    /**
//     * This method signs in to application by passing a username and password
//     * @param email
//     * @param password
//     */
//    public void signInToApp(String email, String password) {
//        Reports.log("Click Sign in / Register button");
//        javaWaitSec(10);
//        clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
//        Reports.log("Type username: " + email);
//        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(email);
//
//        Reports.log("Type password: " + password);
//        driver.findElement(Locators.TEXT_FIELD_PASSWORD_LOGIN).sendKeys(password);
//
//        javaWaitSec(3);
//        Reports.log("Click login button");
//        clickAnyButton(Data.TEXT_LOGIN);
//        javaWaitSec(3);
//        Reports.log("Agreed to Secure Message");
//        confirmAgreeAndSecureMessages();
//        javaWaitSec(3);
//    }

    public void signInToApp(String email, String password) {
        Reports.log("Click Sign in / Register button");
        javaWaitSec(5);
        for(int i=0; i<=5;i++) {
            try {
                clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
                break;
            } catch (Exception e) {
                Reports.log("Page is still loading so refreshing the page.....");
                driver.navigate().refresh();
                javaWaitSec(5);
            }
        }

        Reports.log("Type username: " + email);
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(email);
        javaWaitSec(1);
        Reports.log("Type password: " + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD_LOGIN).sendKeys(password);
        javaWaitSec(2);
        Reports.log("Click login button");
        clickAnyButton(Data.TEXT_LOGIN);
        javaWaitSec(5);
        confirmAgreeAndSecureMessages();
        javaWaitSec(3);
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
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(email);

        Reports.log("Type password: " + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD_LOGIN).sendKeys(password);
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
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(email);
    }

    /**
     * This method clicks on forgot password button
     */
    public void clickOnForgotPassword() {
        Reports.log("Click on Forgot Password button");
        ajaxClick(Locators.LINK_TEXT_FORGOT_PASSWORD);
    }

    /**
     * This email enters email and clicks on reset password button
     * @param email
     */
    public void enterEmailIdAndClickOnResetPwdBtn(String email) {
        javaWaitSec(3);
        driver.findElement(Locators.TEXT_FIELD_RESET_EMAIL).sendKeys(email);
        Reports.log("Enter Reset  emailId as: " + email);

        ajaxClick(Locators.BUTTON_RESET_PASSWORD);
        Reports.log("Clicked on  Reset Password button");
    }

    /**
     * This method enters new password and confirms password
     * @param newPassword
     */
    public void enterNewPasswordAndConfirmPassword(String newPassword) {
        javaWaitSec(3);
        driver.findElement(Locators.TEXT_FIELD_NEW_PASSWORD).sendKeys(newPassword);
        Reports.log("Enter new password as: " + newPassword);

        driver.findElement(Locators.TEXT_FIELD_COMPARE_PASSWORD).sendKeys(newPassword);
        Reports.log("Enter Re-enter new password as: " + newPassword);

        ajaxClick(Locators.BUTTON_CHANGE_PASSWORD);
        Reports.log("Clicked on  Change Password button");

        javaWaitSec(2);
        ajaxClick(Locators.BUTTON_PWD_RESET_SUCCESSFUL_BACKTOLOGIN);
        Reports.log("Password has changed Successfully!!!");
    }

    /**
     * This method gets Alert Error Message
     * @return
     */
    public String getAlertErrorMessage(){
        String alertMessage = driver.findElement(Locators.ERROR_ALERT_DIALOG_MESSAGE).getText();
        String errorMessage = driver.findElement(Locators.ERROR_MESSAGE_FOR_INVALID_CREDENTIALS).getText();
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
        javaWaitSec(5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = '" + Data.TEXT_AGREE + "']")));
        ajaxClick(By.xpath("//span[text() = '" + Data.TEXT_AGREE + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']")));
        ajaxClick(By.xpath("//button[@aria-label='Close']"));
        Reports.log("Click on Agreed to Secure Message");
        javaWaitSec(5);
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
        Reports.log("Click Sign in / Register button");
        try {
            clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
            wait.until(ExpectedConditions.elementToBeClickable(setAndFindButton(Data.TEXT_REGISTER, 1)));
        } catch (Exception e) {
            Reports.log("Page is still loading so refreshing the page.....");
            driver.navigate().refresh();
            javaWaitSec(5);
            clickAnyButton(Data.TEXT_SIGN_IN_REGISTER);
            javaWaitSec(5);
        }
        clickAnyButton(Data.TEXT_REGISTER, 1);
        Reports.log("Click Register button");
    }
        /**
         * This method confirms registration
         */
        public void confirmRegistration() {
            Reports.log("Confirmation Completed.");
            ajaxClick(Locators.BUTTON_BACKTOLOGIN);
        }

        /**
         * This method clicks on Add enrolls provider button
         */
        public void clickAddEnrollProviderButton() {
            Reports.log("Clicked on Enroll Provider Button");
            ajaxClick(Locators.ADDAffiliation_ENROLLPROVIDER_BUTTON);
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
            javaWaitSec(10);
            Reports.log("Fill in email: " + email);
            driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);

            Reports.log("Fill in password: " + password);
            driver.findElement(Locators.TEXT_FIELD_PASSWORD_REGISTRATION).sendKeys(password);

            Reports.log("Fill in confirmation of password: " + password);
            driver.findElement(Locators.TEXT_FIELD_VALIDATE_PASSWORD).sendKeys(password);

            Reports.log("Fill in organization name: " + nameOfOrganization);
            driver.findElement(Locators.TEXT_FIELD_ORG_NAME).sendKeys(nameOfOrganization);

            Reports.log("Fill in first name: " + firstName);
            driver.findElement(Locators.TEXT_FIELD_FIRST_NAME).sendKeys(firstName);

            Reports.log("Fill in last Name: " + lastName);
            driver.findElement(Locators.TEXT_FIELD_LAST_NAME).sendKeys(lastName);

            Reports.log("Fill in Phone Number:" + phoneNumber);
            driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phoneNumber);

            // WebElement iframeCaptcha = driver.findElement(By.xpath("//iframe[contains(@src, 'https://www.google.com/recaptcha/api2/anchor')]"));
            // driver.switchTo().frame(iframeCaptcha);

            ///  driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
            javaWaitSec(20);
            ajaxClick(Locators.BUTTON_REGISTRATION);
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
                    driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);
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
            driver.findElement(Locators.PROVIDERINFO_POPUP_Email).sendKeys(email);

            Reports.log("Type First Name: " + fname);
            driver.findElement(Locators.PROVIDERINFO_POPUP_FirstName).sendKeys(fname);

            Reports.log("Type Last Name: " + lname);
            driver.findElement(Locators.PROVIDERINFO_POPUP_LastName).sendKeys(lname);

            ajaxClick(Locators.PROVIDERINFO_POPUP_ProceedButton);
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
            verifyThatElementIsDisplayed(Locators.TEXT_FIELD_PROVIDER_ID);
            verifyThatElementIsDisplayed(Locators.COC_TAB);
            verifyThatElementIsDisplayed(Locators.ENROLLMENT_TAB);
            verifyThatElementIsDisplayed(Locators.APPEALS_TAB);
            verifyThatElementIsDisplayed(Locators.AUDIT_TAB);
            verifyThatElementIsDisplayed(Locators.REPORTS_TAB);
            verifyThatElementIsDisplayed(Locators.SITE_VISITIS_TAB);
            verifyThatElementIsDisplayed(Locators.VOTING_TAB);
            verifyThatElementIsDisplayed(Locators.HELPING_CENTER_TAB);
            verifyThatElementIsDisplayed(Locators.DOCUMENTS_TAB);
            javaWaitSec(5);
            Reports.log("new user Logged out successfully");
        }
    }
