package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.hhstechgroup.Pages.AddAlternateIdentifierPage.ReasonCOdeDropdown;
import static com.hhstechgroup.Pages.AddAlternateIdentifierPage.SaveButton;

public class EditAlternateIdentifierPage extends BaseActions {

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public EditAlternateIdentifierPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static final By ActionMenu = By.xpath("(//div[contains(@class,'expansion-panel')]//span[contains(@class,'MuiIconButton')])[2]");
    public static final By EditOption = By.xpath("//ul[contains(@class,MuiList)]//li[.='Edit']");
    public static final By StatusDropdown = By.xpath("//div[contains(@class,'MuiDialog')]//div[.='Active']");
    public static final By NotesField = By.xpath("//div[contains(@class,'MuiInputBase')]//textarea[@name='notes']");
    public static final By EditConfirmationPopup = By.xpath("(//div[.='Alternate Identifier has been updated successfully.'])[1]");

    public static final String EditConfirmationMessage = "Alternate Identifier has been updated successfully.";


    public void editAlternateIdentifier(String Reason_Code, String Status) {
        javaWaitSec(5);
        ajaxClick(ActionMenu);
        javaWaitSec(5);
        ajaxClick(EditOption);
        javaWaitSec(5);
        performClick(ReasonCOdeDropdown);
        javaWaitSec(2);
        setSpecificOptionInListbox(Reason_Code).click();
        Reports.log("Edited Reason Code");
        javaWaitSec(2);
        performClick(StatusDropdown);
        javaWaitSec(2);
        setSpecificOptionInListbox(Status).click();
        Reports.log("Edited Status");
        javaWaitSec(2);
        fillInCalendar(getCurrentDate(), Data.endDateCalendar);
        Reports.log("Entered End Date");
        javaWaitSec(2);
        driver.findElement(NotesField).sendKeys(generateRandomString());
        Reports.log("Entered text into notes field");
        javaWaitSec(2);
        performClick(SaveButton);
        Reports.log("Clicked on Save button");

    }

    public void VerifyConfirmationMessageForEditAlternateIdentifier() {
        javaWaitSec(2);
        String Confirmation_message = getElementText(EditConfirmationPopup);
        Assert.assertEquals(Confirmation_message, EditConfirmationMessage);
        Reports.log("The Confirmation Message received is :" + Confirmation_message);

    }

}
