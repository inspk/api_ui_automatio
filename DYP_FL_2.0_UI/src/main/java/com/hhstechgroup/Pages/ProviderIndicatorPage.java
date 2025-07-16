package com.hhstechgroup.Pages;


import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.Arrays;
import java.util.List;


public class ProviderIndicatorPage extends BaseActions {


    public final By INDICATORS_TAB=
            By.xpath("//div[contains(@class,'tile-table-row-summary')]");

    /**
     * Class Name: ProviderIndicatorPage
     * <p>
     * Description:
     * This script covers the end-to-end flow for provider enrollment and indicator update.
     * <p>
     * Steps:
     * 1. Complete the UI flow: Submit → Approve → Generate Florida Medicaid ID
     * 2. Fetch Provider ID, Location ID, and Change Request ID from the UI
     * 3. Call the Provider Indicator API using these values (for 5 enrollments)
     * 4. Verify the API returns 200 OK and the indicator is updated correctly in the UI
     * 5. Go to the Provider module, search using the Provider ID,
     * check the Indicator tab, and verify all data and indicator types
     */


    public ProviderIndicatorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    // XPaths
    public static final By INDICATOR_TILE = By.xpath("//button[@role='tab' and span[text()='Indicators']]");




    //METHODS
    public void navigateToProviderIndicator() {


        ajaxClick(INDICATOR_TILE);
        javaWaitSec(4);
    }




    public void callProviderIndicatorAPI() {



        // Base URL
        String apiUrl = "http://htg-connect-qa.dev.hhstechgroup.com/htg-connect-api/api/v1/provider-indicators";


        // Loop through each indicatorType
        for (String indicatorType : Data.indicatorTypes) {
            String requestBody = String.format(
                    "{" +
                            "  \"indicatorLevel\": \"PROVIDER_ID\",\n" +
                            "  \"indicatorName\": \"%s\",\n" +
                            "  \"indicatorType\": \"%s\",\n" +
                            "  \"indicatorValue\": \"YES\",\n" +
                            "  \"reasonCode\": \"RC101\",\n" +
                            "  \"note\": \"External system flagged this provider as high risk\"\n" +
                            "}", Data.locationproviderID, indicatorType);




            Reports.log("\n--- Sending request for indicatorType: " + indicatorType);


            Response response = RestAssured
                    .given()
                    .header("apiKey", "e9a78d58-02d4-4f0e-8f8c-59bb174d59b8")
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post(apiUrl)
                    .then()
                    .log().body()
                    .extract()
                    .response();


            Reports.log("Status Code: " + response.getStatusCode());
        }
    }

    public void verifyindicatorstab() {
        javaWaitSec(10);
        List<WebElement> rows = driver.findElements(INDICATORS_TAB);
        Reports.log("Number of provider summary rows found: " + rows.size());
        Assert.assertEquals(rows.size(), 8, "Expected 8 provider summary rows, but found " + rows.size());
    }

}
