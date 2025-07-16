package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class AddAlternateIdentifierPage extends BaseActions {

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public AddAlternateIdentifierPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //xpaths
    public static final By RightArrowButton = By.xpath("(//div[contains(@class,'MuiTabs-scrollButtons')])[2]");
    public static final By AlternateIdentifierTab = By.xpath("//button[contains(@class,'MuiButtonBase-root')]//span[.='Alternate Identifier']");
    public static final By AlternateIdentifierButton = By.xpath("//button[contains(@class,'MuiButtonBase-root')]//span[.='+Add Alternate Identifier']");
    public static final By IdentifierLevelDropdown = By.xpath("//div[contains(@class,'MuiDialog')]//div[@id='identifierlevel']");
    public static final By IdentifierNameDropdown = By.xpath("//div[contains(@class,'MuiDialog')]//div[@id='identifiername']");
    public static final By IdentifierTypeDropdown = By.xpath("//div[contains(@class,'MuiDialog')]//div[@id='identifiertype']");
    public static final By IdentifierValueTextField = By.xpath("//div[contains(@class,'MuiDialog')]//input[@name='identifierValue']");
    public static final By ReasonCOdeDropdown = By.xpath("//div[contains(@class,'MuiDialog')]//div[@id='reasoncode']");
    public static final By SaveButton = By.xpath("//div[contains(@class,'MuiDialog')]//span[.='Save']");
    public static final By AddConfirmationPopup = By.xpath("(//div[.='Alternate Identifier has been added successfully.'])[1]");

    public static final String AddConfirmationMessage = "Alternate Identifier has been added successfully.";

    public void ClickAddAlternateIdentifier() {
        javaWaitSec(5);
        ajaxClick(RightArrowButton);
        Reports.log("\nClicked on right arrow button");
        javaWaitSec(5);
        ajaxClick(AlternateIdentifierTab);
        Reports.log("\nClicked on Alternate Identifier tab");
        javaWaitSec(5);
        ajaxClick(AlternateIdentifierButton);
        Reports.log("\nClicked on Alternate Identifier button");
        javaWaitSec(5);
    }

    public void FillAlternateIdentifierForm(String Identifier_Level, String Identifier_Type, String Reason_Code) {
        javaWaitSec(5);
        performClick(IdentifierLevelDropdown);
        javaWaitSec(5);
        setSpecificOptionInListbox(Identifier_Level).click();
        Reports.log("\nSelected Identifier Level ");
        javaWaitSec(5);
        performClick(IdentifierNameDropdown);
        javaWaitSec(5);
        clickAnyOptionInList(1);
        Reports.log("\nSelected Identifier Name");
        javaWaitSec(5);
        performClick(IdentifierTypeDropdown);
        javaWaitSec(5);
        setSpecificOptionInListbox(Identifier_Type).click();
        javaWaitSec(5);
        Reports.log("\nSelected Identifier Type");
        driver.findElement(IdentifierValueTextField).sendKeys(generateAPhoneNum());
        javaWaitSec(5);
        Reports.log("\nFilled data in Identifier Value");
        performClick(ReasonCOdeDropdown);
        Reports.log("\nSelected Reason Code");
        javaWaitSec(5);
        setSpecificOptionInListbox(Reason_Code).click();
        javaWaitSec(5);
        fillInCalendar(getCurrentDate(), Data.START_DATE);
        javaWaitSec(5);
        ajaxClick(SaveButton);
        Reports.log("Clicked on Save button");
    }

    public void VerifyConfirmationMessageForAddAlternateIdentifier() {
        javaWaitSec(2);
        String Confirmation_message = getElementText(AddConfirmationPopup);
        Assert.assertEquals(Confirmation_message, AddConfirmationMessage);
        Reports.log("The Confirmation Message received is :" + Confirmation_message);
    }
}
