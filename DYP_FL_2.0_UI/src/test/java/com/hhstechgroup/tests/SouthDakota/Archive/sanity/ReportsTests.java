package com.hhstechgroup.tests.SouthDakota.Archive.sanity;

import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class ReportsTests extends BaseClassUI {

    @Test
    public void checkCannedReports() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        homePage.clickUpdatePopUpForNewUser();
        enrollmentPageInternalUser.clickReportsTab();
        enrollmentPageInternalUser.ajaxClick(enrollmentPageInternalUser.spanContainsText(Data.cannedTab));
        enrollmentPageInternalUser.javaWaitSec(15);
        WebElement iframeWidget = driver.findElement(By.xpath("//iframe[contains(@src, '/api/sso/sisense?return_to=https://sisense.dyp.cloud/app/main')]"));
        driver.switchTo().frame(iframeWidget);
        enrollmentPageInternalUser.ajaxClick(By.xpath("//div[@data-slider-panel-class='dash-scrollpane']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='highcharts-background widget-body']")));
        driver.findElement(By.xpath("//div[@id='editor-container']//*[text()='Historical Information']"));
        driver.findElement(By.xpath("//div[@id='editor-container']//*[text()='Providers']"));
        enrollmentPageInternalUser.ajaxFocus(driver.findElement(By.xpath("//button[@title='Options']")));
        enrollmentPageInternalUser.ajaxClick(driver.findElement(By.xpath("//button[@title='Options']")));
        driver.findElement(By.xpath("//div[text()='Download']"));
        enrollmentPageInternalUser.performClick(By.xpath("//span[@class='mi-arrow app-icon app-icon--general-arrow-right']"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Image')]"))));
        driver.findElement(By.xpath("//div[contains(text(),'Image')]"));
        driver.findElement(By.xpath("//div[contains(text(),'PDF')]"));
        enrollmentPageInternalUser.javaWaitSec(10);

    }


    @Test
    public void checkAdhocReports() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        homePage.clickUpdatePopUpForNewUser();
        enrollmentPageInternalUser.clickReportsTab();
        enrollmentPageInternalUser.ajaxClick(enrollmentPageInternalUser.spanContainsText(Data.adHocTab));
        enrollmentPageInternalUser.javaWaitSec(5);
        enrollmentPageInternalUser.ajaxClick(enrollmentPageInternalUser.spanContainsText(Data.cannedTab));
        enrollmentPageInternalUser.javaWaitSec(5);
        enrollmentPageInternalUser.ajaxClick(enrollmentPageInternalUser.spanContainsText(Data.adHocTab));
        enrollmentPageInternalUser.javaWaitSec(15);
        //  enrollmentPageInternalUser.ajaxClick(By.xpath("//div[@data-pane='left']//div[@class='trillapser-container  left']"));
        enrollmentPageInternalUser.ajaxClick(By.xpath("//div[@class='root-folder-folders-container']"));
        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='list-item-folder-header']//div[@class='title-holder']"));
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(titles.get(i).getText());
        }

//        List<WebElement> nameOfColumnsInTable = driver.findElements(By.xpath("//div[@class='tablewidget-widget-content user-select']//table//th"));
//        for (int i = 0; i <nameOfColumnsInTable.size() ; i++) {
//            System.out.println(nameOfColumnsInTable.get(i).getText());
//        }
    }
}
