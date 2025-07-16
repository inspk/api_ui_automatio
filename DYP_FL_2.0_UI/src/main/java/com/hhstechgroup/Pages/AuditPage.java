package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AuditPage extends BaseActions {

//    public static final By SEARCH_RESULT= By.xpath("//div[contains(@class,'styles_search-box-container')]/following::h2");
     public static final By SEARCH_RESULT= By.xpath("//div//h2[contains(text(),'Search results')]");
     public static final By TABLE_INFO = By.xpath("//div[starts-with(@class,'tile-table-column')]/ancestor::div[contains(@class,'tile-table-body')]/div");

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public AuditPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifySearchResult() {
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
        javaWaitSec(4);
        String searchResult = driver.findElement(SEARCH_RESULT).getText();
        int value = Integer.parseInt(searchResult.replaceAll("[^0-9]", ""));
        System.out.println("Number displayed in search result is: " + value);
        List<WebElement> tableList = driver.findElements(TABLE_INFO);
        int noOfRows = tableList.size();
        Reports.log("Number of rows in first page " + noOfRows);
        Assert.assertTrue(noOfRows > 0);
        Reports.log("Number of rows has been verified\n");
    }
}