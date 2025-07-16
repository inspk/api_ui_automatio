package com.hhstechgroup.common;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.WordUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * BaseAction is provided as an intermediate class for shared functionality between action and any
 * stock implementation provided in this package.
 */
public class BaseActions {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static SoftAssert softAssert = new SoftAssert();

    /**
     * This is a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    String cookies;

    public BaseActions() {

    }

    /**
     * This method returns a WebElement by passing a string as a part of xpath
     *
     * @param sectionName
     * @return WebElement
     */
    public WebElement setUpPermissionSectionElement(String sectionName) {
        WebElement sectionElement = driver.findElement(By.xpath("//span[text()='" + sectionName + "']//ancestor::div[contains(@class,'edit-view_controls')]//input"));
        return sectionElement;
    }

    /**
     * This method returns a WebElement by passing two strings as a part of xpath
     *
     * @param sectionName
     * @param typePermission
     * @return
     */
    public WebElement setUpPermissionElement(String sectionName, String typePermission) {
        WebElement permissionElement = driver.findElement(By.xpath("//span[text()='" + sectionName + "']//ancestor::div[contains(@class,'edit-view_menu')]//span[text()='" + typePermission + "']//ancestor::div[contains(@class, 'edit-view_action')]//input"));
        return permissionElement;
    }

    /**
     * This method clicks on a specific option in the list
     *
     * @param option
     */
    public void clickSpecificOptionInListbox(String option) {
        ajaxClick(setSpecificOptionInListbox(option));
        Reports.log("Select Option: " + option);
    }

    /**
     * This method returns a webElement of a specific option in the list
     *
     * @param option
     * @return
     */
    public WebElement setSpecificOptionInListbox(String option) {
        return driver.findElement(By.xpath("//ul[@role='listbox']//li[text()='" + option + "']"));
    }

    /**
     * This method returns a webElement of a specific option
     *
     * @param option
     * @return
     */
    public WebElement setSpecificOptionInTiles(String option) {
        return driver.findElement(By.xpath("//div[contains(@class, 'dashboard_link')]//p[text()='"+ option + "']"));
    }

    /**
     * This method returns a webElement of a specific option
     *
     * @param option
     * @return
     */
    public WebElement setSpecificStrongOptionInListbox(String option) {
        return driver.findElement(By.xpath("//ul[@role='listbox']//li//strong[text()='" + option + "']"));
    }

    public WebElement setSpecificStrongOptionInListboxSD(String option) {
        return driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option + "']"));
    }

    public WebElement selectAndClickOptionOfEnrollment(String EnrollmentType){
        return driver.findElement(By.xpath("//div[contains(@class,'css')]//div[text()='" + EnrollmentType + "']"));
    }

    public WebElement selectKeyPersonalListbox(String option) {
        return driver.findElement(By.xpath("//ul[@role='listbox']/li[text()='" + option + "']"));
    }

    public void mouseClickByLocator( String Locator ) {
        String locator = Locator;
        WebElement el = driver.findElement( By.cssSelector( locator ) );
        Actions builder = new Actions(driver);
        builder.moveToElement( el ).click( el );
        builder.perform();
    }

    public void jsClick(String Locator) {
//        String locator = Locator;
        WebElement el = driver.findElement(By.xpath(Locator));
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].click();", el);
    }

    /**
     * This method clicks on the first option in the list
     */
    public void clickFirstOptionInList() {
        javaWaitSec(3);
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        //MR-Added Wait
        javaWaitSec(5);
        ajaxClick(elements.get(0));
    }

    /**
     * This method clicks on the last option in the list by passing an integer
     *
     * @param getNumber
     */
    public void clickLastOptionInList(int getNumber) {
        javaWaitSec(3);
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        Reports.log("Click on: " + elements.get(getNumber));
        ajaxClick(elements.get(getNumber));
    }

    /**
     * This method clicks on an option in drop down license list
     */
    public void clickLicenseInList() {
        ajaxScrollUp();
        ajaxScroll(Locators.DROP_DOWN_LICENSE_TYPE);
        javaWaitSec(2);
        ajaxClick(Locators.DROP_DOWN_LICENSE_TYPE);
        clickAnyOptionInList(1);
    }

    /**
     * This method clicks on Wyoming state in the list
     */
    public void clickLicenseStateInList() {
        javaWaitSec(2);
        List<WebElement> elements = driver.findElements(By.xpath("//li[@data-value='Wyoming']"));
        ajaxClick(elements.get(0));
    }

    /**
     * This method clicks on specific option using the index
     *
     * @param index
     */
    public void clickAnyOptionInList(int index) {
        javaWaitSec(5);
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        Reports.log("Selected dropdown value: " + elements.get(index).getText());
        ajaxClick(elements.get(index));
    }

    /**
     * This method clicks on specific option using the value
     *
     * @param value
     */
    public void clickAnyOptionInList(String value) {
        javaWaitSec(3);
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement option : elements) {
            if (option.getText().contains(value)) {
                ajaxClick(option);
                break;
            }
        }
    }

    /**
     * This method returns list of webElements' size
     *
     * @param locator
     * @return
     */
    public int getSizeListOfWebElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        int numbers = elements.size();
        return numbers;
    }

    /**
     * This method returns a webElement by passing locator
     *
     * @param locator
     * @return
     */
    public WebElement findAnyElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    /**
     * This method clicks on any button in the page
     *
     * @param textOfButton
     */
    public void clickAnyButton(String textOfButton) {
        WebElement button = setAndFindButton(textOfButton);
        ajaxClick(button);
        Reports.log("Click on " + textOfButton + " button");

        //10-21-2021-MR Added wait time so that COC ID can be captured
        javaWaitSec(2);
    }

    /**
     * This method clicks on any button in the page
     *
     * @param textOfButton
     * @param index
     */
    public void clickAnyButton2(String textOfButton, int index) {
        WebElement button = setAndFindButton2(textOfButton, index);
        ajaxClick(button);
    }

    /**
     * This method clicks on hidden edit button in the page
     *
     * @param textOfButton
     * @param index
     */
    public void clickHiddenEditButton(String textOfButton, int index) {
        WebElement button = driver.findElement(By.xpath("(//h2[text()='" + textOfButton + "']/following::div[contains(@class,'field_icon-wrapper')])[" + index + "]"));
        button.click();
    }

    /**
     * This method clicks on any button in the page
     *
     * @param textOfButton
     */
    public void simpleClickAnyButton(String textOfButton) {
        WebElement button = setAndFindButton(textOfButton);

        Reports.log("Wait button " + textOfButton + " is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(button));

        Reports.log("Click button " + textOfButton);
        button.click();
    }

    /**
     * This method clicks on any checkbox in the page
     *
     * @param labelCheckbox
     */
    public void simpleClickAnyCheckbox(String labelCheckbox) {
        WebElement checkbox = setAndFindCheckbox(labelCheckbox);

        Reports.log("Wait checkbox " + labelCheckbox + " is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));

        Reports.log("Click checkbox " + labelCheckbox);
        checkbox.click();
    }

    /**
     * This method clicks on any button in the page
     *
     * @param textOfButton
     * @param index
     */
    public void clickAnyButton(String textOfButton, int index) {
        WebElement button = setAndFindButton(textOfButton, index);
        Reports.log("Wait button " + textOfButton + " is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(button));

        Reports.log("Scroll and click button " + textOfButton);
        ajaxScroll(button);
        ajaxClick(button);
    }

    /**
     * This method clicks on any button in the page
     *
     * @param textOfTitle
     * @param sizeOfTitle
     */
    public void clickAnyTitleByText(String textOfTitle, String sizeOfTitle) {

        WebElement title = setAndFindAnyTitle(textOfTitle, sizeOfTitle);

        //Reports.log("Wait title " + textOfTitle + " is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(title));

        Reports.log("Click on title " + textOfTitle);
        ajaxScroll(title);
        ajaxClick(title);
        javaWaitSec(3);
    }

    /**
     * This method clicks on any button that has a title only and no text
     *
     * @param textOfTitle
     */
    public void clickAnyButtonTitle(String textOfTitle) {

        WebElement title = setAndFindAnyButtonTitle(textOfTitle);

        Reports.log("Click on " + title);
        ajaxScroll(title);
        ajaxClick(title);
        javaWaitSec(3);
    }

    /**
     * This method clicks any header titLe
     *
     * @param textOfTitle
     */
    public void clickAnyHeaderTitLe(String textOfTitle) {
        WebElement title = setAndFindHeaderTitle(textOfTitle);

        Reports.log("Wait title " + textOfTitle + " is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(title));

        Reports.log("Wait and click " + textOfTitle + " on header");
        ajaxScroll(title);
        javaWaitSec(2);
        ajaxClick(title);
    }

    /**
     * This method clicks request menu option
     *
     * @param option
     */
    public void clickRequestMenuOption(String option) {
        javaWaitSec(2);
        WebElement menuOption = setElementOfEnrollmentMenu(option);

        //   Reports.log("Wait status menu option " + menuOption + " is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));

        Reports.log("Select " + option + " in menu option");
        ajaxScroll(menuOption);
        menuOption.click();
        javaWaitSec(2);
    }

    /**
     * This method selects first option in dropdown using locator
     *
     * @param locator
     */
    public void selectFirstOptionInDropdown(final By locator) {
        WebElement field = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", field);
        clickFirstOptionInList();
        javaWaitSec(1);
    }

    /**
     * This method sets field value with waits using locator, value
     *
     * @param locator
     * @param value   //
     */
    public void setFieldValueWithWaits(final By locator, final String value) {
        WebElement field = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", field);
        for (int j = 0; j < value.length(); j++) {
            javaWait(200);
            // ajaxSendKeys(field,value.substring(j, j + 1));
            field.sendKeys(value.substring(j, j + 1));
        }
        javaWaitSec(3);
        field.sendKeys(Keys.TAB);
        javaWaitSec(1);
    }

    /**
     * This method sets field value with tab and wait using locator and value arguments
     *
     * @param locator
     * @param value
     */
    public void setFieldValueWithTabAndWait(final By locator, final String value) {
        final WebElement field = driver.findElement(locator);
        field.sendKeys(value);
        field.sendKeys(Keys.TAB);
        javaWaitSec(2);
    }

    /**
     * This method sets and finds button
     *
     * @param textOfButton
     * @return
     */
    public WebElement setAndFindButton(String textOfButton) {
        javaWaitSec(2);
//        Reports.log("Wait until element button: " + textOfButton + " is present");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")));
//        Reports.log("Find button: " + textOfButton);
//        WebElement button = driver.findElement(By.xpath("//span[text() ='" + textOfButton + "']"));
        WebElement button = driver.findElement(By.xpath("//span[contains(text() ,'" + textOfButton + "')]"));

        return button;
    }

    /**
     * This method sets and find the provider button, based on ancestor value.
     * For example, If there are two identical buttons on the same page, we can claim that the button is under a specific heading (the ancestor)
     * <p>
     * clickButtonWithTextWithAncestor
     *
     * @param ancestorValue
     * @param textOfButton
     */
    public void clickButtonWithAncestorText(String ancestorValue, String textOfButton) {
        WebElement button = findButtonWithTextWithAncestor(ancestorValue, textOfButton);
        ajaxClick(button);
        Reports.log("Under " + ancestorValue + " Clicked on button: " + textOfButton);
        javaWaitSec(3);
    }

    /**
     * This method sets and finds button that is under a specific ancestor value like a heading or column
     *
     * @param ancestorValue
     * @param textOfButton
     * @return
     */
    public WebElement findButtonWithTextWithAncestor(String ancestorValue, String textOfButton) {
        javaWaitSec(2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ancestor::div[contains(text(), '" + ancestorValue + "')]//span[contains(text() ,'" + textOfButton + "')]")));
        Reports.log("Find the button " + textOfButton + " under the heading " + ancestorValue);
        WebElement button = driver.findElement(By.xpath("//ancestor::div[contains(text(), '" + ancestorValue + "')]//span[contains(text() ,'" + textOfButton + "')]"));
        return button;
    }

    /**
     * This method sets and finds provider button
     *
     * @param textOfButton
     * @return
     */
    public WebElement setAndFindProviderButton(String textOfButton) {
        By providerButton = By.xpath("//h3[text()='" + textOfButton + "']//ancestor::div[contains(@class, 'styles_approvalmain')]//i");
        wait.until(ExpectedConditions.presenceOfElementLocated(providerButton));
        Reports.log("Find button: " + textOfButton);
        WebElement button = driver.findElement(providerButton);
        return button;
    }

    /**
     * This method sets locator of any button
     *
     * @param textOfButton
     * @return
     */
    public By setLocatorOfAnyButton(String textOfButton) {
        Reports.log("Wait until element button: " + textOfButton + " is present");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")));
        Reports.log("Find button: " + textOfButton);
        By button = By.xpath("//span[text() ='" + textOfButton + "']");
        return button;
    }

    /**
     * This method sets and finds button
     *
     * @param textOfButton
     * @param index
     * @return
     */
    public WebElement setAndFindButton2(String textOfButton, int index) {
        //  Reports.log("Wait until element button: " + textOfButton + " is present");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")));
        //     Reports.log("Find button: " + textOfButton);
        WebElement button = driver.findElements(By.xpath("//span[contains(text() ,'" + textOfButton + "')]")).get(index);
        return button;
    }

    /**
     * This method sets and finds check box
     *
     * @param labelCheckbox
     * @return
     */
    public WebElement setAndFindCheckbox(String labelCheckbox) {
        Reports.log("Wait until element button: " + labelCheckbox + " is present");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '" + labelCheckbox + "']")));
        Reports.log("Find button: " + labelCheckbox);
        WebElement checkbox = driver.findElement(By.xpath("//span[text() = '" + labelCheckbox + "']"));
        return checkbox;
    }

    /**
     * This method selects and clicks option of status
     *
     * @param status
     */
    public void selectAndClickOptionOfStatus(String status) {
        performClick(By.xpath("//ul[@role='listbox']//li[text()='" + status + "']"));
    }

    /**
     * This method returns a webElement by passing a string as a part of xpath
     *
     * @param textOfButton
     * @param index
     * @return
     */
    public WebElement setAndFindButton(String textOfButton, int index) {
        Reports.log("Wait until element button: " + textOfButton + " is present");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '" + textOfButton + "']")));

        Reports.log("Find button: " + textOfButton);
        WebElement button = driver.findElements(By.xpath("//span[text() = '" + textOfButton + "']")).get(index);
        return button;
    }

    /**
     * This method returns a webElement using a text in the xpath
     *
     * @param textOfTitle
     * @param sizeOfTitle
     * @return
     */
    public WebElement setAndFindAnyTitle(String textOfTitle, String sizeOfTitle) {
        Reports.log("Wait title: " + textOfTitle + " is present");
        javaWaitSec(5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//" + sizeOfTitle + "[contains(text(), '" + textOfTitle + "')]")));

        Reports.log("Find title: " + textOfTitle);
        WebElement title = driver.findElement(By.xpath("//div//" + sizeOfTitle + "[contains(text(), '" + textOfTitle + "')]"));
        return title;
    }

    /**
     * This method returns a webElement using a text in the xpath
     *
     * @param textOfTitle
     * @return
     */
    public WebElement setAndFindAnyButtonTitle(String textOfTitle) {
//        Reports.log("Wait title: " + textOfTitle + " is present");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title= '" + textOfTitle + "']")));

//        Reports.log("Find title: " + textOfTitle);
        WebElement title = driver.findElement(By.xpath("//button[@title= '" + textOfTitle + "']"));
        return title;
    }

    /**
     * This method verifies element visibility
     *
     * @param locator
     */
    public void verifyElementVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOf(findAnyElement(locator)));
    }

    /**
     * This method verifies element is clickable
     *
     * @param locator
     */
    public void verifyElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(findAnyElement(locator)));

    }

    /**
     * This method returns a webElement using a title in the xpath
     *
     * @param title
     * @return
     */
    public WebElement setAndFindHeaderTitle(String title) {
        Reports.log("Wait title: " + title + " is present on header");
        wait.until(ExpectedConditions.presenceOfElementLocated(
               // By.xpath("//div[contains(@class, 'header_header')]//ul/li//a[text()='" + title + "']")));
//                By.xpath("//div[contains(@class, 'header_rl fl')]//ul/li//a[text()='" + title + "']")));
                By.xpath("//div[contains(@class, 'header_rl')]//ul/li//a[text()='" + title + "']")));



        Reports.log("Find title: " + title + " on header");
//        WebElement titleElement = driver.findElement(By.xpath("//div[contains(@class, 'header_header')]//ul/li//a[text()='" + title + "']"));
        WebElement titleElement = driver.findElement(By.xpath("//div[contains(@class, 'header_rl')]//ul/li//a[text()='" + title + "']"));
        return titleElement;
    }

    /**
     * This method returns a webElement using a text in the xpath
     *
     * @param text
     * @return
     */
    public WebElement spanContainsText(String text) {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), '" + text + "')]"));
        return element;
    }

    /**
     * This method returns a webElement using a text in the xpath
     *
     * @param text
     * @return
     */
    //MR-11-08-2021 Added Method for CoCs
    public WebElement divContainsText(String text) {
        WebElement element = driver.findElement(By.xpath("//div[contains(text(), '" + text + "')]"));
        return element;
    }

    /**
     * This method returns a webElement using a text in the xpath
     *
     * @param value
     * @return
     */
    public WebElement spanInputValue(String value) {
        Reports.log("Find input element: " + value);
        WebElement element = driver.findElement(By.xpath("//span//input[contains(@value, '" + value + "')]"));
        return element;
    }

    /**
     * This method returns a webElement using a text in the xpath
     *
     * @param value
     * @return
     */
    public WebElement setElementOfEnrollmentMenu(String value) {
        Reports.log("Find input element: " + value);
        WebElement element = driver.findElement(By.xpath("//ul[@role='menu']//li[text()='" + value + "']"));
        return element;
    }

    /**
     * This method returns a WebElement by passing a string as a part of xpath
     *
     * @param value
     * @return
     */
    public WebElement anyStatusOfEnrollment(String value) {
        //   Reports.log("Search for the element " + value);
        WebElement element = driver.findElement(By.xpath("//div//p[text()='" + value + "']"));
        return element;
    }

    /**
     * This method returns a WebElement by passing a text as a part of xpath
     *
     * @param value
     * @param index
     * @return
     */
    public WebElement anyStatusOfCoc(String value, int index) {
        Reports.log("Find input element: " + value);
        WebElement element = driver.findElements(By.xpath("//div//p[text()='" + value + "']")).get(0);
        return element;
    }

    /**
     * This method returns a WebElement by passing a string
     *
     * @param value
     * @return
     */
    public WebElement setElementStatusInEnrollmentInfo(String value) {
        Reports.log("Find input element: " + value);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Status')]//ancestor::p[contains(@class, 'styles_row')]//span[text()='" + value + "']"));
        return element;
    }

    /**
     * This method clicks Element by text
     *
     * @param text
     * @param locator
     */
    public void clickElementByText(String text, By locator) {
        WebElement element = driver.findElement(locator);
        if (element.getText().contains(text)) {
            element.click();
        }
    }

    /**
     * This method waits and the clicks on an element
     *
     * @param element
     */
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ajaxClick(element);
    }

    /**
     * This method waits and the clicks on an element
     *
     * @param by
     */
    public void waitAndClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        (driver.findElement(by)).click();
    }

    /**
     * This method clears using javascriptExecutor
     *
     * @param element
     */
    // Different varieties of Ajax click
    public void ajaxClear(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element);
    }

    /**
     * This method clears using javascriptExecutor
     *
     * @param locator
     */
    public void ajaxClear(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", driver.findElement(locator));
    }

    /**
     * This method clears the content
     *
     * @param webElement
     */
    public void clearContent(WebElement webElement) {
        //   WebElement input = driver.findElement(locator);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        //input.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        webElement.sendKeys(Keys.DELETE);
        javaWaitSec(1);
        webElement.sendKeys(Keys.BACK_SPACE);
    }

    /**
     * This method focuses on an element using JavascriptExecutor
     *
     * @param element
     */
    public void ajaxFocus(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("focus()", element);
    }

    /**
     * This method clicks on an element using JavascriptExecutor
     *
     * @param element
     */
    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * This method clicks on an element using JavascriptExecutor
     *
     * @param timeout
     * @param by
     */
    public void ajaxClick(int timeout, By by) {
        WebDriverWait changedWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        changedWait.until(ExpectedConditions.presenceOfElementLocated(by));
        ajaxClick(driver.findElement(by));
    }

    /**
     * This method clicks on an element using JavascriptExecutor
     *
     * @param by
     */
    public void ajaxClick(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ajaxClick(driver.findElement(by));
    }

    /**
     * This method clicks on an element using JavascriptExecutor
     *
     * @param by
     * @param index
     */
    public void ajaxClick(By by, int index) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    /**
     * This method clicks on an element using Actions class by passing a locator
     *
     * @param locator
     */
    public void performClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    /* This method Focus on an element using JavascriptExecutor by passing a locator
     * @param locator
     */
    public void ajaxFocus(By locator) {
        WebElement field = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", field);
        javaWaitSec(2);
    }

    /**
     * This method clicks on an element using Actions class by passing an element
     *
     * @param element
     */
    public void performClickOffset(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element, 0, 200).perform();
        actions.click().build().perform();
    }

    /**
     * This method clicks on an element using Actions class by getting a locator
     *
     * @param locator
     */
    public void performClickOffset(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator), 0, 200).perform();
        actions.click().build().perform();
    }

    /**
     * This method clicks on an element using Actions class by getting a locator and an index
     *
     * @param locator
     * @param index
     */
    public void performClick(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    /**
     * This method clicks on an element using Actions class by passing an element
     *
     * @param element
     */
    public void performClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    /**
     * This method double Clicks using Action class by getting an element
     *
     * @param element
     */
    public void doublePerformClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    /**
     * This method double Clicks using Action class by getting a locator
     *
     * @param locator
     */
    public void doublePerformClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(locator)).perform();
    }

    /**
     * This method sends keys using Actions class by getting an element and a text
     *
     * @param element
     * @param text
     */
    public void performSendKeys(WebElement element, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.sendKeys(text).build().perform();
    }

    /**
     * This method sends keys using Actions class by getting a locator and text
     *
     * @param locator
     * @param text
     */
    public void performSendKeys(By locator, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
        actions.sendKeys(text).build().perform();
    }

    /**
     * This method clicks unselected checkbox
     *
     * @param checkbox
     */
    public void clickUnselectedCheckbox(By checkbox) {
        WebElement currentCheckbox = driver.findElement(checkbox);
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    /**
     * This method clicks unselected checkbox
     *
     * @param currentCheckbox
     */
    public void clickUnselectedCheckbox(WebElement currentCheckbox) {
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    /**
     * This method clicks unselected checkbox by getting a checkbox and an index
     *
     * @param checkbox
     * @param index
     */
    public void clickUnselectedCheckbox(By checkbox, int index) {
        WebElement currentCheckbox = driver.findElements(checkbox).get(index);
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    /**
     * This method presses up keys
     */
    // Scrolls
    public void pressUpKeys() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_PAGE_UP);
    }

    /**
     * This method scrolls to the bottom of page using JavascriptExecutor
     */
    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * This method scrolls using JavascriptExecutor
     *
     * @param element
     */
    public void ajaxScroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method scrolls using JavascriptExecutor
     *
     * @param locator
     */
    public void ajaxScroll(By locator) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    /**
     * This method scrolls using JavascriptExecutor
     *
     * @param by
     * @param index
     */
    public void ajaxScroll(By by, int index) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ajaxScroll(driver.findElements(by).get(index));
    }

    /**
     * This method scrolls using JavascriptExecutor
     *
     * @param value
     */
    public void ajaxScrollByCoordinate(int value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])", value);
    }

    /**
     * This method scrolls up using JavascriptExecutor
     */
    public void ajaxScrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)", "");
    }

    /**
     * This method scrolls down using JavascriptExecutor
     */
    public void ajaxScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    /**
     * This method Moves to an element using Action class
     *
     * @param locator
     */
    public void performMoveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method Moves to an element using Action class
     *
     * @param element
     */
    public void performMoveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method Moves to an element using Action class by passing a locator and an index
     *
     * @param locator
     * @param index
     */
    public void performMoveToElement(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    //Common actions

    /**
     * This method generates a random number
     *
     * @param name
     * @param length
     * @return
     */
    public static String generateNewNumber(String name, int length) {

        return name + RandomStringUtils.random(length, "172984757");
    }

    /**
     * This method generates a random number
     *
     * @param length
     * @return
     */
    public static String generateNewNumber(int length) {

        return RandomStringUtils.random(length, "172984757");
    }

    /**
     * This method generates a random MedicalId using Faker class
     *
     * @return
     */
    public static String medicalID() {
        Faker faker = new Faker();
        return faker.numerify("#AM#AI#SD##");
    }

    /**
     * This method generates a random number for email
     *
     * @param min
     * @param max
     * @return
     */
    public static int generateRandomNumberForEmail(int min, int max) {
        int spread = max - min;
        return new Random().nextInt(spread + 1) + min;
    }

    /**
     * This method generates a random email
     *
     * @param emailPrefix
     * @param domain
     * @return
     */
    public static String generateEmail(String emailPrefix, String domain) {
        String emailNumber = Integer.toString(generateRandomNumberForEmail(10000, 100000));
        //return "wyoming.sit2+provider" + emailNumber + "@" + domain;
        //return "sanity.test.provider+" + emailNumber + "@" + domain;
        return emailPrefix + "+" + emailNumber + "@" + domain;
    }

    /**
     * This method generates a random name using Faker class
     *
     * @return
     */
    public static String generateNewWord() {
        Faker faker = new Faker();
        return faker.name().firstName();
        //return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");

    }

    /**
     * This method generates a random name using Faker class
     *
     * @return
     */
    public static String generateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }


    /**
     * This method generates a random name using Faker class
     *
     * @return
     */
    public static String generateLastName() {
        Faker faker = new Faker();
        return faker.name().lastName().replaceAll("'", "");
    }

    public static String generateLegalBusiness() {
        Faker faker = new Faker();
        String name = faker.medical().hospitalName().toLowerCase();
        return WordUtils.capitalize(name);
    }

    public static String generateDBABusiness() {
        Faker faker = new Faker();
        String name = faker.medical().hospitalName().toLowerCase();
        return WordUtils.capitalize(name);
    }


    public static String generateInstitutionName() {
        Faker faker = new Faker();
        String name = faker.company().name().toLowerCase();
        return WordUtils.capitalize(name);
    }


    /**
     * This method generates a random name
     *
     * @param word
     * @param length
     * @return
     */
    public static String generateNewWord(String word, int length) {
        return RandomStringUtils.random(length, "123456789") + word;
    }

    /**
     * This method selects an option in drop down
     *
     * @param element
     * @param index
     */
    public void getDropDownListByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * This method selects an option in drop down
     *
     * @param locator
     * @param index
     */
    public void getDropDownListByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    /**
     * This method selects an option in drop down
     *
     * @param element
     * @param text
     */
    public void getDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * This method selects an option in drop down
     *
     * @param locator
     * @param text
     */
    public void getDropDownListByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    /**
     * This method selects an option in drop down
     *
     * @param element
     * @param value
     */
    public void getDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * This method selects an option in drop down
     *
     * @param locator
     * @param value
     */
    public void getDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    /**
     * This method waits using Thread.sleep
     *
     * @param ms
     */
    public void javaWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method waits using Thread.sleep
     *
     * @param sec
     */
    public void javaWaitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sends key using JavascriptExecutor
     *
     * @param element
     * @param text
     */
    public void ajaxSendKeys(WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
    }

    /**
     * This method sends key using JavascriptExecutor
     *
     * @param locator
     * @param text
     */
    public void ajaxSendKeys(By locator, String text) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].value = '" + text + "';", driver.findElement(locator));
    }

    /**
     * This method uploads a file using JavascriptExecutor
     *
     * @param locator
     * @param index
     */
    public void ajaxUploadFile(By locator, int index) {
        //  WebElement element = setAndFindButton(Data.TEXT_UPLOAD_FILES);
        WebElement element = driver.findElements(locator).get(index);
        ((JavascriptExecutor) driver)
                .executeScript(("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";"), element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(new File("medicaid.png").getAbsolutePath());
    }

    /**
     * This method uploads a file using JavascriptExecutor
     *
     * @param title
     */
    public void ajaxUploadForEnrollment(String title) {
        Reports.log("Uploading " + title + " Document");
        By locator = By.xpath(".//h2[text() = '" + title + "']/../../div[contains(@class, 'upload_upload-controls')]/input");
        //    By locator = By.xpath(".//h4[text() = '" + title + "']/../../div[contains(@class, 'upload_upload-controls')]/input");
        //    By locator = By.xpath("//div[@data-for= '" + title + "']/div[contains(@class, 'upload_upload-controls')]/input");
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript(("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";"), element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(new File("SD_PECS.png").getAbsolutePath());
        javaWaitSec(3);
        Reports.log(title + " document uploaded successfully");
    }

    /**
     * This method uploads a file using robot
     *
     * @param locator
     */
    public void robotUploadDocument(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
        javaWaitSec(5);
        String filePath = new File("C:/Automation/DYP_FL_Automation/acceptance-tests/medicaid.png").getAbsolutePath();
        Reports.log("Upload File path: " + filePath);
        uploadFileWithRobot(filePath);
        Reports.log("Document uploaded successfully");
        javaWaitSec(6);
    }

    /**
     * This method uploads a file using JavascriptExecutor
     *
     * @param locator
     */
    public void ajaxUploadFile(By locator) {
        //WebElement element = setAndFindButton(Data.TEXT_UPLOAD_FILES);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript(("arguments[0].style = \"\"; arguments[0].style.display = \"block\"; arguments[0].style.visibility = \"visible\";"), element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(new File("medicaid.png").getAbsolutePath());

    }

    /**
     * This method uploads a file using JavascriptExecutor
     *
     * @param imagePath
     */
    public void uploadFileWithRobot(String imagePath) {
        StringSelection stringSelection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

//    public void uploadFileWithRobot(String imagePath) {
//        // Copy the path to clipboard
//        StringSelection stringSelection = new StringSelection(imagePath);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//
//        try {
//            Robot robot = new Robot();
//            robot.setAutoDelay(500); // delay between events
//
//            // Paste (Cmd+V)
//            robot.keyPress(KeyEvent.VK_META);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_META);
//
//            robot.delay(1000); // wait for file path to appear
//
//            // Press Enter
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//            Reports.log("Robot uploaded file successfully.");
//
//        } catch (AWTException e) {
//            e.printStackTrace();
//            Reports.log("Robot upload failed: " + e.getMessage());
//        }
//    }



    /**
     * This method generates a random string
     *
     * @return
     */
    public static String generateRandomString() {
        return new BigInteger(120, new SecureRandom()).toString(32);
    }


    /**
     * This method selects  a random option in drop down
     *
     * @param locator
     * @param dropDownName
     */
    // Method for random choice from dropdown list
    public void selectItemDropDownRandomOption(By locator, String dropDownName) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
            System.out.println(dropDownName + ": " + select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e) {
        }
    }

    /**
     * This method verifies if all the links on webPage is active
     *
     * @param tagElement
     * @param attribute
     */
    public void checkLinksOnWebPage(String tagElement, String attribute) {
        List<WebElement> links = driver.findElements(By.xpath(tagElement));
        Reports.log("Total links Available on the page are: " + links.size());
        //  System.out.println("I start taking  attributes on page");
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
            WebElement ele = links.get(i);
            String url = ele.getAttribute(attribute);
            verifyLinkActive(url);
        }
        //   System.out.println("Total links are " + links.size());
    }

    /**
     * This method verifies if all the links on webPage is active
     *
     * @param linkUrl
     */
    // Method for link verification
    public void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            } else if (httpURLConnect.getResponseCode() >= 400
                    && httpURLConnect.getResponseCode() <= 504) {
                System.out.println(
                        linkUrl
                                + " - "
                                + httpURLConnect.getResponseMessage()
                                + " - "
                                + httpURLConnect.getResponseMessage()
                );
            }

        } catch (Exception e) {
            //   e.printStackTrace();
        }
    }

    /**
     * This method gets teh Size of drop down list
     *
     * @param locator
     * @return
     */
    public int getSizeDropDownList(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size();

        } catch (NoSuchElementException e) {
            System.out.println("getSizedropDownList error");
        }
        return 0;
    }

    /**
     * This method clicks value Of lists
     *
     * @param locator
     * @param text
     */
    public void clickValueOfLists(By locator, String text) {

        Reports.log("Collect elements in list");
        List<WebElement> elements = driver.findElements(locator);

        Reports.log("Start using loop with size of list");
        for (int i = 0; i < elements.size(); i++) {

            Reports.log("Create new webelement of list");
            WebElement elementOfList = elements.get(i);

            Reports.log("Create new String with text from element of list");
            String value = elementOfList.getText();
            Reports.log("Value of list: " + value);

            if (value.contains(text)) {
                Reports.log("Wait element list is clickable");
                wait.until(ExpectedConditions.elementToBeClickable(elementOfList));

                Reports.log("Click list of elements");
                elementOfList.click();
            }
        }
    }

    /**
     * This method gets H1 title
     *
     * @return
     */
    public String getH1Title() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TITLE_H1)));
        String title = driver.findElement(Locators.TITLE_H1).getText();
        return title;
    }

    /**
     * This method fills in the calendar using javascriptExecutor
     *
     * @param date
     * @param label
     */
    public void fillInCalendar(String date, String label) {
        javaWaitSec(2);
        Reports.log("Wait until calendar is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'" + label + "')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']")));
        javaWaitSec(2);
//        Reports.log("Type : " + date);
        ajaxClick(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']"));
        javaWaitSec(2);
        ajaxClear(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']"));
        javaWaitSec(2);
        ajaxClick(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']"));
        javaWaitSec(2);
        driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(date);
        javaWaitSec(2);

    }
    /**
     * This method update the calendar using Selenium click, clear, send keys
     *
     * @param date
     * @param label
     */
    public void updateCalendar(String date, String label) {
        javaWaitSec(2);
        Reports.log("Wait until calendar is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'" + label + "')]/following-sibling::div/input[@placeholder='MM/DD/YYYY']")));

//        Reports.log("Type : " + date);
        driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']")).clear();
        driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(date);


    }

    /**
     * This method fills in the calendar
     *
     * @param date
     * @param label
     */
    public void fillInCalendar(String date, String label, By locator) {
        javaWaitSec(2);
        Reports.log("Wait until calendar is clickable");
        wait.until(ExpectedConditions.elementToBeClickable(locator));

//        Reports.log("Type : " + date);
        ajaxClick(locator);
        driver.findElement(locator).sendKeys(date);
    }

    /**
     * This method collects all cookies
     *
     * @param domain
     * @return
     */
    public String collectCookies(String domain) {
        try (BufferedWriter bwrite = new BufferedWriter(new FileWriter(new File("Cookies.txt"), false))) {
            for (Cookie ck : driver.manage().getCookies()) {
                bwrite.write(ck.getName() + "=" + ck.getValue() + "\n");

                if (ck.getName().contains("auth_token")) {
                    cookies = ck.getValue() + "; path=/; domain=." + domain + ";";
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("COOKIE: " + cookies);
        return cookies;
    }

    /**
     * This method closes Npi PopUp
     */
    public void closeNpiPoUp() {
        try {
            ajaxClick(By.xpath(".//div[contains(@class, 'details_notification')]//div[contains(@class, 'details_notification-close')]"));
        } catch (Exception e) {

        }
    }

    /**
     * This method closes root notification
     */
    public void closeRootNotification() {
        try {
            ajaxClick(By.xpath("//div[contains(@class, 'root_notification')]//i"));
        } catch (Exception e) {

        }
    }

    /**
     * This method closes all popUps
     */
    public void closeAllPopUps() {
        try {
            ajaxClick(3, Locators.BUTTON_CLOSE_INFO_MESSAGE);
        } catch (Exception e) {
        }

        try {
            ajaxClick(3, Locators.BUTTON_CLOSE_INFO_MESSAGE2);
        } catch (Exception e) {
        }
        try {
            ajaxClick(3, Locators.BUTTON_CLOSE_INFO_MESSAGE3);
        } catch (Exception e) {
        }

    }

    /**
     * This method closes info message button
     */
    public void closeInfoMessage() {
        try {
            ajaxClick(Locators.BUTTON_CLOSE_INFO_MESSAGE);
        } catch (Exception e) {
        }
    }

    /**
     * This method closes alert button
     */
    public void closeAlert() {
        try {
            ajaxClick(3, Locators.BUTTON_CLOSE_INFO_MESSAGE3);
        } catch (Exception e) {
        }
    }

    /**
     * This method closes prompt
     */
    public void closePrompt() {
        try {
            driver.findElement(By.name("submit")).submit();
        } catch (Exception e) {
        }
    }

    /**
     * This method skips tool tip if exists
     */
    public void skipTooltipIfExists() {

        if (driver.findElement(Locators.SKIP_HELP_TOUR).isDisplayed()) {
            // ajaxClick(Locators.SKIP_HELP_TOUR);
            ajaxClick(Locators.SKIP_HELP_TOUR);
        }

    }

    /**
     * This method selects billing state
     *
     * @param state
     * @return
     */
    public WebElement selectBillingState(String state) {
        WebElement element = driver.findElement(By.xpath("//ul[@class='multiselect__content']//li//span[text()='" + state + "']"));
        return element;
    }

    /**
     * This method clicks on back to top button
     */
    public void clickBackToTop() {
        try {
            driver.findElement(By.xpath("//div[text()='Back to top']")).click();
        } catch (Exception e) {

        }
    }

    /**
     * This method clicks Check box by value
     *
     * @param value
     */
    public void clickCheckboxByValue(String value) {
        Reports.log("Select value in checkbox: " + value);
        ajaxClick(By.xpath("//input[@type='checkbox'][@value='" + value + "']"));
    }

    /**
     * This method selects value in combo box
     *
     * @param value
     * @param locator
     * @param index
     */
    public void selectValueInCombobox(String value, By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        ((JavascriptExecutor) driver)
                .executeScript(("arguments[0].value = \"" + value + "\";"), element);
    }

    /**
     * This method is using fluent wait to find an element
     *
     * @param by
     * @param timeout
     * @param period
     * @return
     */
    public WebElement advanceFindElement(By by, long timeout, long period) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        try {         fluentWait.withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(period))
                    .ignoring(NoSuchElementException.class);
        } catch (Exception e) {
            Reports.log(by + " Element not found");
        }
        return fluentWait.until(d -> d.findElement(by));
    }

    /**
     * This method clicks And Types and select option in Combo box
     *
     * @param value
     * @param option
     * @param index
     */

    public void clickAndTypeAndSelectOptionInCombobox(String value, String option, int index) {
        Reports.log("Click text field: " + value);
        ajaxClick(setAndFindCombobox(value));

        Reports.log("Type value in text field " + value + " Selecting the Option: " + option);
        setAndFindCombobox(value).sendKeys(option);
        javaWaitSec(5);
        clickAnyOptionInList(index);
    }

    /**
     * This method sets and finds combo box
     *
     * @param labelCombobox
     * @return
     */
    public WebElement setAndFindCombobox(String labelCombobox) {
        Reports.log("Wait until element comobox: " + labelCombobox + " is present");
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//label[text()='" + labelCombobox + "']//ancestor::div[@role='combobox']//input")));

        Reports.log("Find combobox: " + labelCombobox);
        WebElement combobox = driver.findElement(By.xpath("//label[text()='" + labelCombobox + "']//ancestor::div[@role='combobox']//input"));
        return combobox;
    }

    /**
     * This method verifies values in menu List and in File
     *
     * @param nameOfFile
     */
    public void verifyValuesInMenuListAndInFile(String nameOfFile) {
        String[] expectedValues = null;
        try {
            expectedValues = Files.readAllLines(Paths.get("DataFiles", nameOfFile)).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("EXPECTED LIST");
        for (int j = 0; j < expectedValues.length; j++) {
            System.out.println(j + 1 + " " + expectedValues[j]);
            setSpecificOptionInListbox(expectedValues[j]);
        }

    }

    /**
     * This method verifies values in any list and in file
     *
     * @param locator
     * @param nameOfFile
     */
    public void verifyValuesInAnyListAndInFile(String locator, String nameOfFile) {
        String[] expectedValues = null;
        try {
            expectedValues = Files.readAllLines(Paths.get("DataFiles", nameOfFile)).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reports.log("Expected List");
        for (int j = 0; j < expectedValues.length; j++) {
            Reports.log(j + 1 + " " + expectedValues[j]);
            //System.out.println(j + 1 + " " + expectedValues[j]);
            try {
                driver.findElement(By.xpath(locator + "[text()='" + expectedValues[j] + "']"));
            } catch (Exception e) {
                ajaxScroll(By.xpath(locator + "[text()='" + expectedValues[j] + "']"));
            }
            //  setSpecificOptionInAnyListbox(locator, expectedValues[j]);
        }

    }

    /**
     * This method sets specific option in any list box
     *
     * @param locator
     * @param option
     * @return
     */
    public WebElement setSpecificOptionInAnyListbox(String locator, String option) {

        return driver.findElement(By.xpath(locator + "[text()='" + option + "']"));
    }

    /**
     * This method activates combo box and compares value
     *
     * @param nameOfCombobox
     * @param nameOfFile
     * @param enrollmentType
     */
    public void activateComboboxAndCompareValues(String nameOfCombobox, String nameOfFile, String enrollmentType) {
        javaWaitSec(1);
        setAndFindCombobox(nameOfCombobox).sendKeys("");
        javaWaitSec(4);
        compareStrongValuesInUiAndInFile(nameOfFile);
        // String.format(PRIMARY_TAXONOMY_OPTION, option);

    }

    /**
     * This method compares strong values in file
     *
     * @param nameOfFile
     */
    public void compareStrongValuesInUiAndInFile(String nameOfFile) {
        String[] expectedValues = null;
        try {
            expectedValues = Files.readAllLines(Paths.get("DataFiles", nameOfFile + ".csv")).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("EXPECTED LIST");
        for (int j = 0; j < expectedValues.length; j++) {
            System.out.println(j + 1 + " " + setSpecificStrongOptionInListbox(expectedValues[j]).getText());
        }
    }

    /**
     * This method compares values in file
     *
     * @param nameOfFile
     */
    public void compareValuesInUiAndInFile(String nameOfFile) {
        String[] expectedValues = null;
        try {
            expectedValues = Files.readAllLines(Paths.get("DataFiles", nameOfFile + ".csv")).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("EXPECTED LIST");
        for (int j = 0; j < expectedValues.length; j++) {
            System.out.println(j + 1 + " " + setSpecificOptionInListbox(expectedValues[j]).getText());
        }
    }

    /**
     * This method compares values in file
     *
     * @param nameOfFile
     */
    public void compareValuesInUiAndInFile2(String nameOfFile) {
        String[] expectedValues = null;
        try {
            expectedValues = Files.readAllLines(Paths.get("DataFiles", nameOfFile + ".csv")).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("EXPECTED LIST");
        for (int j = 0; j < expectedValues.length; j++) {
            System.out.println(j + 1 + " " + setSpecificOptionInTiles(expectedValues[j]).getText());
        }
    }

    /**
     * This method gets random string from file
     *
     * @param filename
     * @return
     */
    public String getRandomStringFromFile(String filename) {
        try {
            List<String> values = Files.readAllLines(Paths.get("DataFiles", filename + ".csv"));
            return values.get((int) (Math.random() * values.size()));
        } catch (IOException e) {
            throw new RuntimeException("Not possible to read String in file");
        }
    }

    /**
     * This method gets cookies form file
     *
     * @param filename
     * @return
     */
    public String getCookiesFormFile(String filename) {
        try {
            List<String> values = Files.readAllLines(Paths.get(filename + ".txt"));
            return values.get((int) (Math.random() * values.size()));
        } catch (IOException e) {
            throw new RuntimeException("Not possible to read String in file");
        }
    }

    /**
     * This method verifies that element is displayed
     *
     * @param locator
     * @return
     */
    public boolean verifyThatElementIsDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            String elementText = element.getText();
            Reports.log(elementText + " Tab is present");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method verifies that element is displayed
     *
     * @param locator
     * @return
     */
    public boolean verifyThatElementIsDisplayed(By locator, String locatorType) {
        try {
            WebElement element = driver.findElement(locator);
            String elementText = element.getText();
            Reports.log(elementText + " " + locatorType + " is displayed");
            return true;
        } catch (Exception e) {
            Reports.log(locatorType + " is not displayed");
            return false;
        }
    }

    /**
     * This method gets a current date
     *
     * @return
     */

    public static String getCurrentDate() {
        LocalDateTime ldt = LocalDateTime.now();
        String formattedDate = ldt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return formattedDate;
    }

    /**
     * This method gets an integer and if it is positive it will add it to the current day and if it is
     * negative it will subtract from current day
     *
     * @param n
     * @return
     */
    public static String changeDayInCurrentDate(int n) {
        DateFormat dateFormat = new SimpleDateFormat(("MM/dd/yyyy"));
        Calendar cal = Calendar.getInstance();
        System.out.println("Current Date is :" + dateFormat.format(cal.getTime()));
        cal.add(Calendar.DATE, n);
        String result = dateFormat.format(cal.getTime());
        System.out.println("Change Date is :" + result);
        return result;
    }

    /**
     * This method gets 3 integers and change the year, month and days of current date.
     *
     * @param nyear
     * @param dmonth
     * @param mday
     * @return
     */
    public static String changeYearAndDayInCurrentDate(int nyear, int dmonth, int mday) {
        DateFormat dateFormat = new SimpleDateFormat(("MM/dd/yyyy"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, nyear);
        cal.add(Calendar.DATE, mday);
        cal.add(Calendar.MONTH, dmonth);
        String result = dateFormat.format(cal.getTime());
        return result;
    }

    /**
     * This method gets an integer and if it is positive it will add it to the current month and if it is
     * negative it will subtract from current month
     *
     * @param n
     * @return
     */
    public static String changeMonthInCurrentDate(int n) {
        DateFormat dateFormat = new SimpleDateFormat(("MM/dd/yyyy"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, n);
        String result = dateFormat.format(cal.getTime());
        return result;
    }

    /**
     * This method gets an integer and if it is positive it will add it to the current year and if it is
     * negative it will subtract from current year
     *
     * @param n
     * @return
     */
    public static String changeYearInCurrentDate(int n) {
        DateFormat dateFormat = new SimpleDateFormat(("MM/dd/yyyy"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, n);
        String result = dateFormat.format(cal.getTime());
        System.out.println("Change Date is :" + result);
        return result;
    }

    /**
     * This method gets the text of an element
     *
     * @param locator
     * @return
     */
    public String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        String text = element.getText();
        return text;
    }

    /**
     * This method check if the image is displayed in a page
     *
     * @param Locator
     * @return
     */
    public Boolean checkVisibilityOfImg(By Locator) {
        WebElement ImageFile = driver.findElement(Locator);
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent) {
            System.out.println("Image not displayed.");
        } else {
            System.out.println("Image displayed.");
        }
        return ImagePresent;
    }

    /**
     * This method switch to specific window by its title while many windows are open
     *
     * @param WindowTitle
     * @param hList
     * @return
     */
    public boolean switchToSpecificWindow(String WindowTitle, List<String> hList) {
        for (String e : hList) {
            String title = driver.switchTo().window(e).getTitle();
            if (title.contains(WindowTitle)) {
                Reports.log("Found the specific window");
                return true;
            }
        }
        return false;
    }

    /**
     * This method switch to parent window
     *
     * @param parentWindowId
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method close other open windows except the parent window
     *
     * @param hList
     * @param parentWindowId
     */
    public void closeAllWindows(List<String> hList, String parentWindowId) {
        for (String e : hList) {
            if (!e.equals(parentWindowId)) {
                driver.switchTo().window(e).close();
            }
        }
    }

    public void clickSpecificSearchFieldAndSendData(String text, String data) {
        WebElement status = driver.findElement(By.xpath("//div[contains(text(),'" + text + "')]"));
        javaWaitSec(2);
        status.click();
        WebElement statusType = driver.findElement(By.xpath("//div[text()='" + text + "']/following::input[contains(@id,'react-select')]"));
        statusType.sendKeys(data);
        statusType.sendKeys(Keys.ENTER);
    }

    public void checkSearchResult(String text, String data, By locator, String tableInfo) {
        clickSpecificSearchFieldAndSendData(text, data);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
        javaWaitSec(20);
        String searchResult = driver.findElement(locator).getText();
        int value = Integer.parseInt(searchResult.replaceAll("[^0-6]", ""));
        System.out.println("Number displayed in search result is: " + value);
        List<WebElement> tableList = driver.findElements(By.xpath(tableInfo));
        int noOfRows = tableList.size();
        Reports.log("Number of rows " + noOfRows);
        for (int i = 1; i <= noOfRows; i++) {
            WebElement row = driver.findElement(By.xpath("(" + tableInfo + ")[" + i + "]"));
            String rowInfo = row.getText();
            if (rowInfo.contains(data)) {
            }
        }
        Reports.log("Search result has been verified\n");
    }

    public int checkAllTheFieldsWithSpecificData(By locator, String data) {
        List<WebElement> allFields = driver.findElements(locator);
        ArrayList<String> listOFfields = new ArrayList<String>();
        int noOfFields = allFields.size();
        //Reports.log("Number Of fields: " + noOfFields);
        for (int i = 0; i < noOfFields; i++) {
            listOFfields.add(allFields.get(i).getText());
        }
        //  Reports.log(listOFfields.toString());
        Assert.assertTrue(listOFfields.toString().contains(data), "Verification of Fields was not successful");
        Reports.log("Verification of all the fields completed");
        return noOfFields;
    }

    public void verifyListValue(By locator, ArrayList<String> listValues, String locatorName) {
        List<WebElement> listOfLabels = driver.findElements(locator);
        ArrayList<String> dropdownvalue = new ArrayList<String>();
        int noOfLabels = listOfLabels.size();
        for (int i = 0; i < noOfLabels; i++) {
            dropdownvalue.add(listOfLabels.get(i).getText());
        }
        Reports.log("Displayed dropdown values are:" + dropdownvalue);
        Reports.log("Expected dropdown values are:" + listValues);
        dropdownvalue.retainAll(listValues);
        Reports.log("RetainAll dropdown values are :" + dropdownvalue);

        Assert.assertTrue(dropdownvalue.containsAll(listValues), "values missing from the Dropdown menu");
        Reports.log(locatorName + " contains the all the expected values:" + listValues + "\n");
    }


    public Boolean checkIfRadioButtonsSelected(By locator) {
        List<WebElement> radioButtons = driver.findElements(locator);
        Boolean a = true;
        int Size = radioButtons.size();

        for (WebElement radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                a = false;
                Reports.log("One or more radioButtons are selected by default");

                break;
            }
        }
        return a;
    }

    public static String upperCaseAllFirstCharacter(String text) {
        String words[] = text.split("\\s");
        String capitalizeWord = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            capitalizeWord += first.toUpperCase() + afterfirst + " ";
        }
        return capitalizeWord.trim();
    }

    /**
     * This method creates a random date using number of +-years
     *
     * @param numOfYears
     * @param pattern
     * @return
     */
    public String createRandomDates(int numOfYears, String pattern) {
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.YEAR, numOfYears);
        int yearMinus = cal1.get(Calendar.YEAR);
        Calendar cal = Calendar.getInstance();
        int CurrentYear = cal.get(Calendar.YEAR);
        LocalDate randomDate = createRandomDate(yearMinus, CurrentYear);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return randomDate.format(formatter);
    }

    /**
     * This method creates a random date using start and end dates
     *
     * @param start
     * @param end
     * @return
     */
    public int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    /**
     * This method creates a random date using start year and end year dates
     *
     * @param startYear
     * @param endYear
     * @return
     */
    public LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    /**
     * This method does the revalidation through hummingbird API
     *
     * @param endpoint
     * @param cookies
     * @param providerDataId
     * @param timeToRevalidation
     */
    public static void revalidation(String endpoint, String cookies, String providerDataId, String timeToRevalidation) {
        Reports.log(endpoint);
        String payload = "{ \"providerDataId\" : \"" + providerDataId + "\", \"timeToRevalidation\": \"" + timeToRevalidation + "\" }";
        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());
    }

    /**
     * This method generates a random Phone number of specific length

     */
    public static String generateAPhoneNum() {

        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    /**
     * This method generates a random number of specific length
     *
     * @param numLength
     */
    public static String generateANumberOfLength(int numLength) {

        Faker faker = new Faker();
        return faker.number().digits(numLength);
    }

    /**
     * This method generates a random 5 digit number with a Character at 3rd place
     *
     */
    public static String generateALicenses() {

        Faker faker = new Faker();
        return faker.bothify("##?##").toUpperCase();
    }

    public String createRandomDateInSpecificYears(int startNumOfYear, int endNumOfYear) {
        String DOB1 = changeYearInCurrentDate(startNumOfYear);
        Reports.log("Start birth date is: " + DOB1);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = DOB1;
        LocalDate localDate1 = LocalDate.parse(date1, formatter1);
        int startYear = localDate1.getYear();
        String DOB2 = changeYearInCurrentDate(endNumOfYear);
        Reports.log("End birth Date is: " + DOB2);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date2 = DOB2;
        LocalDate localDate2 = LocalDate.parse(date2, formatter2);
        int endYear = localDate2.getYear();
        LocalDate randomDate = createRandomDate(startYear, endYear);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return randomDate.format(formatter);
    }

    /**
     * Supplemental method that will allow the user compare two distinct fields in a string, based on the xpath and attribute in the xpath.
     * The following are the parameters:
     *
     * @param driver           = driver
     * @param xpath            = xpath of the field on the screen being evaluated
     * @param attribute        = Attribute in the xpath that contains the value to be evaluated
     * @param expected         = Expected value
     * @param verificationText = Text message for verification and uniqueness of the message in Reports
     * @param softAssert       = SoftAssert object needed for softAssert.assertAll()
     */
    public static void stringTextCompareWithAttribute(WebDriver driver, String xpath, String attribute, String expected, String verificationText, SoftAssert softAssert) {

        try {
            String actual = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
            Reports.log("\t" + verificationText + ": the Actual value is: " + actual + " and the Expected is: " + expected);
            softAssert.assertEquals(actual, expected, verificationText);
        } catch (NoSuchElementException e){
            Reports.log("\t* FAIL: " +"\t" + verificationText + ": the Actual value is: not found and the Expected is: " + expected);
            softAssert.assertEquals("Not Found", expected, verificationText);
        }
    }

    /**
     * Supplemental method that will allow the user verify the checkbox or radio button on the screen. This method will take in the xpath
     * and will to compare expected results to the onscreen results. The following are the parameters:
     *
     * @param driver           = driver
     * @param xpath            = xpath of the field on the screen being evaluated
     * @param expected         = Expected value
     * @param verificationText = Text message for verification and uniqueness of the message in Reports
     * @param softAssert       = SoftAssert object needed for softAssert.assertAll()
     */
    public static void booleanTextCompare(WebDriver driver, String xpath, String expected, String verificationText, SoftAssert softAssert) {

        try {
            Boolean actual = driver.findElement(By.xpath(xpath)).isSelected();
            Reports.log("\t" + verificationText + ": the Actual value is: " + actual + " and the Expected is: " + expected);
            softAssert.assertEquals(String.valueOf(actual), expected, verificationText);
        } catch (NoSuchElementException e){
            Reports.log("\t* FAIL: " + "\t" + verificationText + ": the Actual value is: not found and the Expected is: " + expected);
            softAssert.assertEquals("Not Found", expected, verificationText);
        }
    }

    /**
     * Supplemental method that will allow the user compare two fields in a string, based on the xpath and the value on the screen without required Attributes.
     * The following are the parameters:
     *
     * @param driver           = driver
     * @param xpath            = xpath of the field on the screen being evaluated
     * @param expected         = Expected value
     * @param verificationText = Text message for verification and uniqueness of the message in Reports
     * @param softAssert       = SoftAssert object needed for softAssert.assertAll()
     */
    public static void stringTextCompareGetText(WebDriver driver, String xpath, String expected, String verificationText, SoftAssert softAssert) {

        try {
            String actual = driver.findElement(By.xpath(xpath)).getText();
            Reports.log("\t" + verificationText + ": the Actual value is: " + actual + " and the Expected is: " + expected);
            softAssert.assertEquals(actual, expected, verificationText);
        } catch (NoSuchElementException e){
            Reports.log("\t* FAIL: " +"\t" + verificationText + ": the Actual value is: not found and the Expected is: " + expected);
            softAssert.assertEquals("Not Found", expected, verificationText);
        }
    }

    /**
     * This method creates an n digit ID number by passing integer n parameter
     * @param xpath
     * @param n
     */
    public void CreateIDNum(By xpath, int n) {
        String IDNumber = generateNewNumber(n);
        Reports.log("Clear text field");
        ajaxClick(xpath);
        driver.findElement(xpath).sendKeys(IDNumber);
        Reports.log("Type ID number: " + IDNumber);
    }

}
