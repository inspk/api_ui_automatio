package com.hhstechgroup.internal_user;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * EnrollmentDetails class provides methods for verification in enrollment
 */
public class EnrollmentDetails extends BaseActions {

    /**
     * This is a parameterized constructor
     * @param driver
     * @param wait
     */
    public EnrollmentDetails(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method clicks enrollment details
     */
    public void clickEnrollmentDetails() {
        ajaxClick(spanContainsText("Enrollment Information"));
    }

    /**
     * This method verifies identifying info enrollment
     */
    public void verifyIdentifyingInfoEnrollment() {
        closeNpiPoUp();
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.FIRST_NAME_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.LAST_NAME_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.GENDER_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.DOB_ENROLLMENT_DETAILS).getText());
    }

    /**
     * This method verifies summary provider
     */
    public void verifySummaryProvider() {
        ajaxClick(spanContainsText("Summary"));
    }

    /**
     * This method verifies add file provider
     */
    public void verifyAddFileProvider() {

        ajaxClick(spanContainsText("Files and documents"));

    }

    /**
     * This method verifies history provider
     */
    public void verifyHistoryProvider() {
        ajaxClick(spanContainsText("History"));
//   ajaxClick(By.xpath("//div[@class='wr']//h3"));
//    String titleHistoryProvider = driver.findElement(By.xpath("//div[@class='wr']//h3")).getText();
//    if(!titleHistoryProvider.contains("Provider data history")){
//      Assert.fail();
//    }
    }

    /**
     * This method verifies Time line provider
     */
    public void verifyTimelineProvider() {
        ajaxClick(spanContainsText("Timeline"));
        ajaxClick(By.xpath("//div[contains(@class, 'timeline_sort-list-wr')]"));
        driver.findElement(By.xpath("//div[contains(@class, 'timeline_select-types')]"));


    }

    /**
     * This method verifies revalidation provider
     */
    public void verifyRevalidationProvider() {
        ajaxClick(spanContainsText("Revalidation"));
        driver.findElement(By.xpath("//p[contains(@class, 'revalidation_revalidation-title')]"));


    }

    /**
     * This method verifies messages provider
     */
    public void verifyMessagesProvider() {
        ajaxClick(spanContainsText("Messages"));
        driver.findElement(By.xpath("//div[contains(text(), 'Messages history with provider')]"));


    }

    /**
     * This method verifies site visits provider
     */
    public void verifySiteVisitsProvider() {
        ajaxClick(spanContainsText("Site visits"));
        javaWaitSec(3);

    }

    /**
     * This method verifies provider's status
     */
    public void verifyProviderStatus() {
        spanContainsText("Active");
    }

    /**
     * This method verifies address details
     */
    public void verifyAddressDetails() {
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.ANY_ADDRESS1_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.BUILDING_SUITE_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.ZIP_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.EMAIL_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.PHONE_ENROLLMENT_DETAILS).getText());
        System.out.println(driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.LAST_NAME_ADDRESS_ENROLLMENT_DETAILS).getText());
    }

    /**
     * This method finds move and activate editable text field
     * @param textField
     */
    public void findMoveAndActivateEditableTextField(String textField) {
        closeNpiPoUp();
        By ICON_EDIT = By.xpath("//h4[text()='" + textField + "']/../..//*[local-name() = 'svg' and @aria-hidden='true']");
        //By ICON_EDIT = By.xpath("//svg[@aria-hidden='true']");

        WebElement element = driver.findElement((Locators.ENROLLMENT_SECTION))
                .findElement(By.xpath("//h4[text()='" + textField + "']" ));
                       // "//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]"));

             //   .findElement(By.xpath("//h4[text()='" + textField + "']//ancestor::div[contains(@class, 'field_readonly-field')]//div[contains(@class, 'sc-cQFLBn')]"));

        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .clickAndHold(element)
                .build();
        mouseOverHome.perform();
        performClick(driver.findElement(Locators.ENROLLMENT_SECTION).findElement(ICON_EDIT));
    }

    /**
     * This method gets Parameter value From Enrollment
     * @param label
     * @return
     */
    public String getParamaterValueFromEnrollment(String label) {
        String text = driver.findElement(By.xpath("//h4[text()='" + label + "']//ancestor::div[contains(@class, 'field_readonly-field')]")).getText();
        String value = text.replace(label, "").trim();
        return value;
    }

    /**
     * This method clicks On provider identifying information section
     */
    public void  clickOnProviderIdentifyingInformationSection() {
        javaWaitSec(3);
        scrollToBottomOfPage();
        driver.findElement(Locators.SECTION_IDENTIFYING_INFORMATION).click();
        javaWaitSec(5);
    }

    /**
     * This method modifies provider details
     * @param firstName
     * @param newTitle
     */
    public void modifyProviderDetails( String firstName, String newTitle){
        //Add Title
        Reports.log("First Name: " + firstName);
        findMoveAndActivateEditableTextField("Title or Degree");
        performClick(driver.findElement(Locators.ENROLLMENT_SECTION).findElement(Locators.INPUT_TITLE_OR_DEGREE_ENROLLMENT_DETAILS));

        driver.findElement(Locators.ENROLLMENT_SECTION).findElement(Locators.INPUT_TITLE_OR_DEGREE_ENROLLMENT_DETAILS).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(Locators.ENROLLMENT_SECTION).findElement(Locators.INPUT_TITLE_OR_DEGREE_ENROLLMENT_DETAILS).sendKeys(newTitle);

        driver.findElement(Locators.ENROLLMENT_SECTION).findElement(Locators.INPUT_TITLE_OR_DEGREE_ENROLLMENT_DETAILS).click();
        //closeNpiPoUp();
    }

}
