package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.internal_user.AdditionalActions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URI;
import java.util.List;

import static com.hhstechgroup.common.Data.ProviderID;

public class ProvidersPage extends BaseActions {

//    public static final By SEARCH_RESULT_TEXT= By.xpath("//div[contains(@class,'styles_search-box-container')]/following::h2");
    public static final By SEARCH_RESULT_TEXT= By.xpath("//div//h2[contains(text(),'Search results')]");
    public static final String TABLE_INFO = "(//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div)[1]";

    public static final By SearchButton = By.xpath("//span[.='Search']");
    public static final By SearchResult = By.xpath("(//div[contains(@class,'tile-table')]//div[contains(@class,'tile-table-row')])[1]");
    public static final By PROVIDER_NAME =
            By.xpath("//input[contains(@class, 'MuiInputBase-input') and @id='providerName']");



    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public ProvidersPage(
            WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifySearchResult() {
        javaWaitSec(5);
        checkSearchResult("Provider Status", "Active", SEARCH_RESULT_TEXT, TABLE_INFO);
    }
    /**
     * Searches for provider by the enrollment
     *
     * @param EnrollmentType
     */
    public void searchproviderByEnrollmentType(String EnrollmentType)
    {
        Reports.log("\nSearching for the provider");
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(5);
//        ajaxClick(EnrollemtTypeDropdown);
        driver.findElement(By.xpath("//div[contains(@class,'css')]//div[text()='Enrollment Type']")).click();
        javaWait(5);
        selectAndClickOptionOfEnrollment(EnrollmentType).click();
        Reports.log("\nClicked on Enrollment Type");
        javaWait(10);
        ajaxClick(SearchButton);
        Reports.log("\nClicked on search button");
        javaWait(10);
        waitAndClick(SearchResult);
        Reports.log("\nSelected one of the search result");
        javaWaitSec(20);
    }

    public void searchwithproviderid(){
        javaWaitSec(10);
        performClick(PROVIDER_NAME);
        Reports.log("Clicked on Provider Name text field");
        javaWaitSec(5);
        performSendKeys(PROVIDER_NAME, ProviderID);
        Reports.log("Entered Provider name or PES ID is :"+ProviderID);
        javaWaitSec(5);
        ajaxClick(SearchButton);
        javaWaitSec(10);

        driver.findElement(By.xpath("//div[@class='table-text-wr']//div[@class='tooltip-wrapper-content']/p[text()='" + ProviderID + "']")).click();


    }


}
