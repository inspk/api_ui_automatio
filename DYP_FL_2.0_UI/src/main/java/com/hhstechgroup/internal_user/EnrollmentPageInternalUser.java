package com.hhstechgroup.internal_user;

import com.hhstechgroup.common.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * EnrollmentPageInternalUser class provides methods for verification in internal user page.
 */
public class EnrollmentPageInternalUser extends BaseActions {
    protected EnrollmentsAndCoc enrollmentsAndCoc;
    AdditionalActions additionalActions;

    /**
     * This is a parameterized constructor
     * @param driver
     * @param wait
     */
    public EnrollmentPageInternalUser(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method clicks on Help Tour
     */
    public void clickHelpTour() {
        javaWaitSec(2);
        Reports.log("Click On user Account");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Locators.HELPTOUR_USER)));
        ajaxClick(Locators.HELPTOUR_USER);

    }

    /**
     * This method navigates back to enrollment
     * @param firstName
     * @param lastName
     * @param trackingNum
     */
    public void navigateBackToEnrollment(String firstName, String lastName, String trackingNum) {
        clickEnrollTab();
        javaWaitSec(3);
        searchProvider(firstName + " " + lastName,trackingNum);
        searchSpecificEnrollmentAndClick(10, "PENDING REVIEW");
        javaWaitSec(10);
    }

    /**
     * This method clicks on my account tab
     */
    public void clickMyAccount() {

        Reports.log("Click My account");
        waitAndClick(spanContainsText(Data.TEXT_MY_ACCOUNT));
    }

    /**
     * This method clicks on system options tab
     */
    public void clickSystemOptions() {
        javaWaitSec(2);
        waitAndClick(spanContainsText(Data.TEXT_SYSTEM_OPTIONS));
        Reports.log("Click System options");
    }

    /**
     * This method clicks on log out button
     */
    public void clickLogOut() {
        javaWaitSec(2);
        waitAndClick(spanContainsText(Data.TEXT_LOG_OUT));
        Reports.log("Click Log out");
    }

    /**
     * This method opens system options
     */
    public void openSystemOptions() {
        clickHelpTour();
        clickSystemOptions();
    }

    /**
     * This method logs out
     */
    public void logOut() {
        clickHelpTour();
        clickLogOut();
        javaWaitSec(10);
    }

    /**
     * This method clicks on reports tab
     */
    public void clickReportsTab() {
        Reports.log("Click header tab: " + Data.textReportsTab);
        clickAnyHeaderTitLe(Data.textReportsTab);
    }

    /**
     * This method clicks on enrollment tab
     */
    public void clickEnrollTab() {
        Reports.log("Click header tab: " + Data.textEnrollmentTab);
        clickAnyHeaderTitLe(Data.textEnrollmentTab);
        javaWaitSec(10);
    }

    /**
     * This method clicks providers tab
     */
    public void clickProvidersTab() {
        Reports.log("Click header tab: " + Data.textProvidersTab);
        clickAnyHeaderTitLe(Data.textProvidersTab);
        javaWaitSec(5);
    }
    /**
     * This method clicks site visits tab
     */
    public void clickSiteVisitsTab() {
        Reports.log("Click header tab: " + Data.textSiteVisitsTab);
        clickAnyHeaderTitLe(Data.textSiteVisitsTab);
    }

//    public void searchProvider(String nameOfProvider) {
//        ajaxScroll(Locators.TEXT_FIELD_PROVIDER_ID);
//        Reports.log("Clear provider if text field");
//        ajaxClear(Locators.TEXT_FIELD_PROVIDER_ID);
//        // driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID)
//        //    .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        Reports.log("Type provider name: " + nameOfProvider);
//        ajaxSendKeys(Locators.TEXT_FIELD_PROVIDER_ID, nameOfProvider);
//        //  driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID).sendKeys(nameOfProvider);
//        javaWaitSec(10);
//        // Reports.log("Click button: " + Data.TEXT_SEARCH);
//        performClick(setAndFindButton(Data.TEXT_SEARCH));
//        javaWaitSec(10);
//    }

    /**
     * This method searches for provider
     * @param nameOfProvider
     */
    //10-21-2021-MR Updated to fx overwriting of Provider name label text
    //10-21-2021-MR Original method is commented out above
    public void searchProvider(String nameOfProvider) {
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(5);
        ajaxScroll(Locators.TEXT_FIELD_PROVIDER_ID);

        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        Reports.log("Clear provider if text field");

        //ajaxClear(Locators.TEXT_FIELD_PROVIDER_ID);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Reports.log("Type provider name: " + nameOfProvider);

        //ajaxSendKeys(Locators.TEXT_FIELD_PROVIDER_ID, nameOfProvider);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID).sendKeys(nameOfProvider);

        javaWaitSec(10);
        performClick(setAndFindButton(Data.TEXT_SEARCH));
        javaWaitSec(10);
    }

//    public void searchProvider(String nameOfProvider, String TrackingNumber) {
//        ajaxScroll(Locators.TEXT_FIELD_PROVIDER_ID);
////
//        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID)
//                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//  //      driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID).clear();
//
//        Reports.log("Clear provider if text field");
//        ajaxClear(Locators.TEXT_FIELD_PROVIDER_ID);
//        Reports.log("Type provider name: " + nameOfProvider);
//       // ajaxSendKeys(Locators.TEXT_FIELD_PROVIDER_ID,nameOfProvider);
//        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID).sendKeys(nameOfProvider);
//     //   driver.findElement(Locators.TEXT_FIELD_REQUEST_ID).clear();
//
//        driver.findElement(Locators.TEXT_FIELD_REQUEST_ID)
//                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//
//        ajaxClear(Locators.TEXT_FIELD_REQUEST_ID);
//     //   ajaxSendKeys(Locators.TEXT_FIELD_REQUEST_ID,TrackingNumber);
//        Reports.log("Tracking Number: " + TrackingNumber);
//       driver.findElement(Locators.TEXT_FIELD_REQUEST_ID).sendKeys(TrackingNumber);
//        // Provider Enrollment Manager
//        Reports.log("Click button: " + Data.TEXT_SEARCH);
//        performClick(setAndFindButton(Data.TEXT_SEARCH));
//
//    }

    /**
     * This method searches for provider
     * @param nameOfProvider
     * @param TrackingNumber
     */
    public void searchProvider(String nameOfProvider, String TrackingNumber) {
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(5);
        ajaxScroll(Locators.TEXT_FIELD_PROVIDER_ID);

        //Provider Name
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ajaxClear(Locators.TEXT_FIELD_PROVIDER_ID);
        Reports.log("Clear provider if text field");
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ID).sendKeys(nameOfProvider);
        Reports.log("Type provider name: " + nameOfProvider);

        //Request ID
        ajaxClick(Locators.TEXT_FIELD_REQUEST_ID);
        driver.findElement(Locators.TEXT_FIELD_REQUEST_ID)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ajaxClear(Locators.TEXT_FIELD_REQUEST_ID);
//        ajaxSendKeys(Locators.TEXT_FIELD_REQUEST_ID,TrackingNumber);
        driver.findElement(Locators.TEXT_FIELD_REQUEST_ID).sendKeys(TrackingNumber);
        Reports.log("Tracking Number: " + TrackingNumber);

        // Provider Enrollment Manager
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        performClick(setAndFindButton(Data.TEXT_SEARCH));

    }

    /**
     * This method searches provider in providers
     * @param nameOfProvider
     */
    public void searchProviderInProviders(String nameOfProvider) {
        Reports.log("Clear provider if text field");
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_NAME)
                .sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        Reports.log("Type provider name: " + nameOfProvider);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_NAME).sendKeys(nameOfProvider);

        Reports.log("Click button: " + Data.TEXT_SEARCH);
        performClick(setAndFindButton(Data.TEXT_SEARCH));
    }

    /**
     * This method Navigates to Providers tab, Search and opens for a specific Provider.
     */
    public void searchAndNavigateToProvidersPage(String providerName){
        clickProvidersTab();
        searchProviderInProviders(providerName);
        javaWaitSec(3);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
        ajaxScroll(Locators.ROW_IN_TABLE, 0);
        driver.findElements(Locators.ROW_IN_TABLE).get(0).click();
        javaWaitSec(5);
    }
    /**
     This method clicks on enrolment span in provider's tab
     */
    public void clickEnrollmentSpanInProvidersTab(String enrollmentType,String firstName , String lastName) {
        clickProvidersTab();
        navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType, firstName + " " + lastName);
        javaWaitSec(2);
        ajaxClick(By.xpath(Locators.ENROLLMENT_SPAN));
        javaWaitSec(3);
    }

    /**
     This method clicks on Enrollments Information tab and Request Retroactive Adjustments
     */
    public void ClickEnrollmentInfoAndRetroactiveInProviderInfo(String enrollmentType,String firstName , String lastName) {
        clickProvidersTab();
        navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType, firstName + " " + lastName);
        javaWaitSec(2);
        ajaxClick(spanContainsText("Enrollment Information"));
        javaWaitSec(1);
        ajaxScroll(By.xpath("(//div[contains(.,'Request Retroactive Adjustment')])[11]"));
        driver.findElement(By.xpath("(//div[contains(.,'Request Retroactive Adjustment')])[11]")).click();
        //String effectiveDate =  driver.findElement(By.xpath("//h2[contains(.,'Requested Retroactive Effective Date')]//following-sibling::div[2]//div")).getText();
        javaWaitSec(3);
    }

    /**
     * This method Navigates to History tab under Provider details page, Get the 1 row from the providers history
     * and Assert if history contains the given parameter
     */

    public void navigateAndVerifyTheProviderHistoryInfo(String type, String date, String requestID ) {
        driver.findElement(By.xpath("//span[text()='History']//ancestor::button")).click();
        ajaxScrollDown();
        javaWaitSec(2);
        String info = driver.findElement(By.xpath("(//div[contains(@class,'requests_table-body')]/div)[1]")).getText();
        Reports.log("Revalidation History: "+ info);
        Assert.assertTrue((info.contains(type)||info.contains(date)||info.contains(requestID)));
        javaWaitSec(1);
    }
    /**
     * This method Navigates to Timeline tab under Provider details page,And Assert the Revalidation Status and Request Id
     */
    public void navigateAndVerifyProvidersTimeLineRevalidationStatus(String Status, String requestID) {
        driver.findElement(By.xpath("(//span[text()='History']//ancestor::button/following::button)[5]")).click();
        javaWaitSec(2);
        driver.findElement(By.xpath("//span[text()='Timeline']")).click();
        ajaxScrollDown();
        javaWaitSec(2);
        String revalidationStatus = driver.findElement(By.xpath("//p[contains(text(),'REVALIDATION')]/following::div[1]")).getText();
        String revalidationRequestId = driver.findElement(By.xpath("//p[contains(text(),'REVALIDATION')]//span")).getText();
        Reports.log( "Revalidation RequestID: " + revalidationRequestId);
        Reports.log( "Revalidation Status: " + revalidationStatus);
        Assert.assertTrue(revalidationStatus.contains(Status));
        Assert.assertTrue(revalidationRequestId.contains(requestID));
        javaWaitSec(1);
    }
    /**
     * This method Navigates to Revalidation tab under Provider details page,And Assert the next revalidation date
     */
    public void navigateAndVerifyProvidersNextRevalidationStatus(String revalidationYear) {
        driver.findElement(By.xpath("//span[text()='Revalidation']//ancestor::button")).click();
        javaWaitSec(2);
        String nextRevalidationDate = driver.findElement(By.xpath("(//div[contains(@class,'revalidation_row-container')]/div)[2]/p[2]")).getText();
        Reports.log("Expected Next Revalidation Date: "+revalidationYear);
        Reports.log("Next Revalidation Date: " + nextRevalidationDate );
        Assert.assertTrue(nextRevalidationDate.contains(revalidationYear));
        javaWaitSec(1);
    }

    /**
     * This method Navigates to enrollment span tab under Provider details page,And Assert the next status
     * @param enrollmentType
     * @param loctaor
     * @param num
     */
    public void navigateAndVerifyProvidersEnrollmentSpanStatus(String enrollmentType, By loctaor, int num) {
       // String effectiveFormatDate= driver.findElement(Locators.AFFILIATION_INFRMATION_TABLE).getText();
       // String effectiveFormatDate =  driver.findElement(By.xpath("//h2[contains(.,'Requested Retroactive Effective Date')]//following-sibling::div[2]//div")).getText();
        String effectiveFormatDate =  driver.findElement(By.xpath("(//div[contains(@class,'table-text_tooltip')])[2]/p")).getText();
        Reports.log("Retroactive Effective Date: "+effectiveFormatDate);
        String date = changeDayInCurrentDate(num);
        Reports.log("The retroactive adjustment date selected as : " + date );
        Assert.assertEquals(effectiveFormatDate,date);
        String status= driver.findElement(loctaor).getText();
        Reports.log("The Enrollment span section status : " +status );
        if (enrollmentType.contains("CoC")) {
            Assert.assertTrue(status.contains("Retroactively updated based on the CoC"));
        }else{
            Assert.assertTrue(status.contains("Retroactively Approved to"));
            Reports.log("Verification completed" );
        }
    }

    /**
     * This method gets the Provider Data id from the current URL
     */
    public String getProviderDataId() {
        String currentURL = driver.getCurrentUrl();
        Reports.log("Current URL: "+driver.getCurrentUrl());
        String uriStr = currentURL;
        URI uri = URI.create(uriStr);
        String query = uri.getPath();
        String providerDataId = query.substring(query.lastIndexOf('/')+1);
        Reports.log("ProviderId: "+providerDataId);
        return providerDataId;
    }
    /**
     * This method closes documents Iframe
     */
    public void closeDocumentsIframe() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.CSDN_IFRAME)));
        WebElement csdnFrame = driver.findElement(Locators.CSDN_IFRAME);
        driver.switchTo().frame(csdnFrame);
        ajaxClick(Locators.BUTTON_ADANCED);
    }

    /**
     * This method changes the Revalidation Date calling API methods using Restful,
     * and verify the changed providers Revalidation date
     */
    public void changeRevalidationDateAndVerify( String environmentUrl, String providerDataId, String  revalidationTimePeriod, String cookies, String revalidationDate ){
        Reports.log("Revalidation Time Period :"+revalidationTimePeriod+'d');
        Reports.log("Revalidation Date:"+revalidationDate);
        revalidation(environmentUrl + Data.URI_REVALIDATION, cookies, providerDataId, revalidationTimePeriod+'d');
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(5);

        //Verify the revalidation is 30 days of the current date
        // String timeRevalidationsss = changeDayInCurrentDate(Integer.parseInt(revalidationTimePeriod));
        String AppRevalidationDate = driver.findElement(By.xpath("//h2[text()='Next Revalidation Date']//ancestor::div[contains(@class, 'detailed-panel-column col-auto')]//p")).getText();
        Reports.log("Application Revalidation Date :" + AppRevalidationDate);
        Assert.assertTrue(revalidationDate.contains(AppRevalidationDate));
    }

    public void scheduleUpcomingReValidationsAndVerifyStatus(String environmentUrl, String cookies) {
        javaWaitSec(3);
        Reports.log("Sending request to callScheduler API");
        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .when();
        Response response = httpRequest.get(environmentUrl+Data.URI_CallScheduler);
        Assert.assertEquals(200, response.getStatusCode());
        javaWaitSec(5);
        Reports.log("Sending request to scheduleUpcomingReValidations API");
        RequestSpecification httpRequest2 = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .when();
        Response response2 = httpRequest.get(environmentUrl+Data.URI_ScheduleUpcomingReValidations);
        Assert.assertEquals(200, response.getStatusCode());
        //searchProviderInProviders(firstName + " " + lastName);
    }

    /**
     * This method collects cells in documents table and click valid
     * @param section
     * @param nameOfFile
     */
    public void collectCellsInDocumentsTableAndClickValid(String section, String nameOfFile) {
        String cellText;
        List<WebElement> cellsInTable = driver.findElements(Locators.SPAN_IN_TABLE);
        for (int i = 0; i < cellsInTable.size(); i++) {
            cellText = cellsInTable.get(i).getText();
            System.out.println(cellText);
            if (cellText.contains(nameOfFile)) {
                ajaxClick(cellsInTable.get(i));
                break;
            } else if (cellsInTable.get(cellsInTable.size() - 1).getText().contains(nameOfFile)) {
                Assert.fail("No " + nameOfFile + " in " + section);
            }
            System.out.println(i);
            cellsInTable = driver.findElements(Locators.SPAN_IN_TABLE);
        }
        javaWaitSec(10);
    }

    /**
     * This method clicks on manage files button
     */
    public void clickOnManageFilesButton() {
        ajaxClick(Locators.BUTTON_FILES_MANAGEMENT);
    }

    /**
     * This method clicks on archived files button
     */
    public void clickOnArchivedFilesButton() {
        ajaxClick(Locators.BUTTON_ARCHIVED_FILES);
    }

    /**
     * This method verifies file attachment
     */
    public void verifyFileAttachment() {
        List<WebElement> folders = driver.findElements(By.xpath(Data.ONE_ROOT_FOLDER));
        for (int i = 0; i < folders.size(); i++) {
            System.out.println(i);
            String titleFolder = folders.get(i).getText();
            System.out.println("Titles: " + titleFolder);
            if (titleFolder.contains("Attach documents")) {

                ajaxClick(folders.get(i));
                String pathToFolder = folders.get(i).getText();
                System.out.println(pathToFolder + "!!!");
                if (!pathToFolder.contains(Data.medicaidFile)) {
                    Assert.fail("No " + Data.medicaidFile + " in folder");
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(Locators.EXPAND_ROOT_FOLDERS)).click();
            folders = driver.findElements(By.xpath(Data.ONE_ROOT_FOLDER));
        }
    }

    /**
     * This method downloads file
     * @param index
     */
    public void downloadFile(int index) {
        ajaxClick(driver.findElements(Locators.BUTTON_FILES_ACTION).get(index));
        Reports.log("File Downloaded");
        javaWaitSec(10);
    }

    /**
     * This method verifies payment for facility
     * @param firstName
     * @param lastName
     */
    public void verifyPaymentForFacility(String firstName, String lastName) {
        try {
            javaWait(2);
            clickAnyButton(Data.TEXT_VERIFY_PAYMENT);
            driver.findElement(Locators.POP_UP_DOCUMENT).findElement(Locators.POPUP_IS_PAYMENT_RECEIVED).click();
            Format f = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = f.format(new Date());
            fillInCalendar(strDate, Data.datepaymentreceived);
            ajaxClick(By.xpath("//textarea[@type='text']"));
            driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Payment Received. Sanity Test for " + firstName + " " + lastName);
            clickAnyButton(Data.TEXT_VERIFY);
        } catch (Exception e){
            Reports.log("Exception "+e);
        }
    }

    /**
     * This method searches specific enrollment and click
     * @param delay
     * @param status1
     */
    public void searchSpecificEnrollmentAndClick(int delay, String status1) {
        for (int i = 0; i <= 10; i++) {
            Reports.log("Wait for " + delay + " seconds for application to load..");
            javaWaitSec(delay);
            Reports.log("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            javaWaitSec(10);
            try{
                driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText();
                if (anyStatusOfEnrollment(status1).isDisplayed()) {
                    String applicationStatus = anyStatusOfEnrollment(status1).getText();
                    Reports.log("Application Status is: "+applicationStatus);
                    break;
                }
            } catch (Exception e) {
                if(i==10)
                {Assert.fail("Time out Waiting for the application Status to be changed");}
            }
            Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
        }

        javaWaitSec(10);
        ajaxScrollUp();
        //  ajaxScroll(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW);
        javaWaitSec(2);
        WebElement enrollment = driver.findElements(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW).get(0);
        // ajaxClick(enrollment);
        enrollment.click();
        //  performClick(Locators.INDIVIDUAL_TYPE_ENROLLMENT_ROW, 0);
    }

    /**
     * This method replacesrRequest Id in Screening File
     * @param requestId
     * @param screeningFile
     */
    public static void replaceRequestIdInScreeningFile(int requestId, String screeningFile) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).contains("<Request id=")) {
                    allLines.set(i, "        <Request id=\"" + requestId + "\">");
                }
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (i > 0) {
                    out.newLine();
                }
                out.write(allLines.get(i));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method does the screening
     * @param screeningFile
     * @param screeningEndpoint
     * @param cookies
     */
    public void screening(String screeningFile, String screeningEndpoint, String cookies) {
        System.out.println(screeningEndpoint);
        // String fullCookies = "auth_token="+ cookies;
        System.out.println(cookies);
        given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "multipart/form-data")
                .cookie("auth_token", cookies)

                .multiPart(new File(screeningFile))
                .when()
                .post(screeningEndpoint)
                .then()
                .statusCode(200);
    }

    /**
     * This method selects provider from search results
     */
    public void selectProviderFromSearchResults() {
        closeRootNotification();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
        ajaxScroll(Locators.ROW_IN_TABLE, 0);
        javaWaitSec(5);
        driver.findElements(Locators.ROW_IN_TABLE).get(0).click();
        javaWaitSec(5);
    }

    /**
     * This method verifies If Provider Data Modified Successfully
     * @param expectedTitle
     */
    public void verifyIfProviderDataModifiedSuccessfully(String expectedTitle) {
        // scrollToBottomOfPage();
        // ajaxScroll(Locators.CONTACT_EMAIL_ENROLLMENT_DETAILS);
        ajaxScroll(By.xpath("//h4[text()='Application contact email']"));
        javaWaitSec(10);
        String currentTitle = driver.findElement((Locators.ENROLLMENT_SECTION)).findElement(Locators.TITLE_OR_DEGREE_ENROLLMENT_DETAILS).getText();
        Reports.log("currentTitle" + currentTitle);
        Assert.assertEquals(expectedTitle, currentTitle);
    }

    /**
     * This method get request Id from specific enrollment
     * @param delay
     * @param status
     * @return
     */
    public Integer getRequestIdFromSpecificEnrollment(int delay, String status) {
        String requestId = null;

        for (int i = 0; i < 10; i++) {
            Reports.log("Wait " + delay + " seconds of application with status Under screening");
            javaWaitSec(delay);
            Reports.log("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(By.xpath("//button[contains(@class, 'search-box-action')]"));
            performClick(By.xpath("//button[contains(@class, 'search-box-action')]"));

            try {
                requestId = driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText();
                if (anyStatusOfEnrollment(status).isDisplayed()) {
                    break;
                } else {
                    Reports.log("Status is not displayed yet");
                }
            } catch (Exception e) {
                Reports.log("Request is not displayed yet");
            }

        }
        if (requestId == null) {
            Assert.fail();
        }
        Reports.log("Request id: " + requestId);
        Reports.log("Parse request id to integer");
        int numRequestId = Integer.parseInt(requestId);
        Reports.log("Parse was successful: " + numRequestId);

        return numRequestId;
    }

    /**
     * This method does the document Review
     * @param firstName
     * @param lastName
     * @param trackingNo
     */
    public void documentReview(String firstName, String lastName, String trackingNo) {
        Reports.log("Enrollment status is Document Review for: " + firstName + " " + lastName);
        searchProvider(firstName + " " + lastName, trackingNo);
        searchSpecificEnrollmentAndClick(20, Data.APPLICATION_STATUS_DOCUMENT_REVIEW);
        javaWaitSec(5);
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
        clickAnyOptionInList(Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
        //  clickAnyOptionInList(2);       // 2 Approved
        javaWaitSec(5);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(5);
    }

    /**
     * This method enrollment does Under Screening
     * @param environmentUrl
     * @param firstName
     * @param lastName
     * @param trackingNum
     */
    public void enrollmentUnderScreen(String environment, String environmentUrl, String firstName, String lastName,  String trackingNum, String status) {
        clickEnrollTab();
        javaWaitSec(10);
        searchProvider(firstName + " " + lastName,trackingNum);
//        if(environment.equalsIgnoreCase("UAT")) {
        int requestId = getRequestIdFromSpecificEnrollment(15, Data.APPLICATION_STATUS_UNDER_SCREENING);
        String cookies = collectCookies(environmentUrl.replace("https://", ""));
        replaceRequestIdInScreeningFile(requestId, Data.screeningFile100);
        Reports.log("Medversant screening URL : " + environmentUrl + Data.URI_SCREENING);
        screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
        javaWaitSec(3);
        screening(Data.screeningFile100, environmentUrl + Data.URI_SCREENING, cookies);
        pendingReviewFlowConfigaration(firstName,lastName,status,trackingNum, 20);
//        } else {
//            pendingReviewFlowConfigaration(firstName, lastName, Data.pendingReviewStatus, trackingNum, 30);
//            javaWaitSec(2);
//            downloadScreeningDocument();
//            javaWaitSec(2);
//        }
    }

    public void downloadScreeningDocument() {
        driver.findElement(By.xpath("(//span[contains(.,'Screening')])[5]")).click();
        javaWaitSec(2);
        Reports.log("Click on the Provider Screening Tile");
        driver.findElement(By.xpath("//a[contains(.,'Download Screening Proof Document')]")).click();
        javaWaitSec(5);
        Reports.log("Click on the Download Screening Proof Document button");
        File downloadFolder = new File(System.getProperty("user.dir") + File.separator + "DownloadFolder");
        File[] matches = downloadFolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("screening_proof_document") && name.endsWith(".pdf");
            }
        });
        ;
        if (matches == null) {
            Reports.log("No file found....");
        } else {
            for (int i = 0; i < matches.length; i++) {
                if (matches[i].renameTo(new File(System.getProperty("user.dir") + File.separator + "DownloadFolder" + File.separator + "ProofDocuments"+ File.separator + matches[i].getName()))) {
                    // if file copied successfully then delete the original file
                    matches[i].delete();
                    Reports.log("Screening Proof Document downloaded successfully and Save at location :"+matches[i]);
                } else {
                    System.out.println("Failed to move the file");
                }
            }
        }
    }


    /**
     * This method verifies pending Review Flow Configuration
     * @param firstName
     * @param lastName
     * @param enrollmentStatus
     * @param trackingNumber
     */
    public void pendingReviewFlowConfigaration(String firstName, String lastName, String enrollmentStatus, String trackingNumber) {
        closeAlert();
        clickBackToTop();
        searchProvider(firstName + " " + lastName, trackingNumber);
        searchSpecificEnrollmentAndClick(20, enrollmentStatus);
        javaWaitSec(10);
    }

    /**
     * This method verifies pending Review Flow Configuration
     * @param firstName
     * @param lastName
     * @param enrollmentStatus
     * @param trackingNumber
     */
    public void pendingReviewFlowConfigaration(String firstName, String lastName, String enrollmentStatus, String trackingNumber, int delayTime) {
        closeAlert();
        clickBackToTop();
        searchProvider(firstName + " " + lastName, trackingNumber);
        searchSpecificEnrollmentAndClick(delayTime, enrollmentStatus);
        javaWaitSec(10);
    }
    /**
     * This method gets application status
     * @return
     */
    public String getApplicationStatus() {
        String applicationStatus = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
        Reports.log("Current Application Status :" + applicationStatus);
        return applicationStatus;
    }

    /**
     * This method gets providers application status
     * @return
     */
    public String getProvidersApplicationStatus() {

        String applicationStatus = driver.findElement(Locators.STATUS_PROVIDER_DETAILS).getText();
        // Reports.log("Current Application Status :" + applicationStatus);
        return applicationStatus;
    }

    /**
     * This method reviews and votes the enrollment
     * @param firstName
     * @param lastName
     */
    //review and vote for this request
    public void reviewAndVoteTheEnrollment(String firstName, String lastName) {
        try {
            javaWaitSec(5);
            ajaxScrollUp();
            clickAnyButton("Approve");
            ajaxClick(Locators.POPUP_PENDING_REVIEW_REASON);
            javaWaitSec(2);
            // driver.findElement(Locators.POPUP_PENDING_REVIEW_REASON).click();
            clickAnyOptionInList(1);
            javaWaitSec(2);
            ajaxClick(By.xpath("//textarea[@type='text']"));
            driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Review Completed. Sanity Test for " + firstName + " " + lastName);
            javaWaitSec(2);
            Reports.log("Note Added: " + driver.findElement(By.xpath("//textarea[@type='text']")).getText());
            clickAnyButton2("Approve", 1);
            javaWaitSec(5);
            ajaxScrollUp();
//            driver.navigate().refresh();
//            javaWaitSec(10);
        } catch (Exception e) {
            Reports.log("Exception " + e);
        }
    }

    /**
     * This method navigates to CoC and search for the provider
     * @param firstName
     */
    public void navigateToCoCAndSearchForTheProvider(String firstName) {
        ajaxClick(Locators.COC_TAB);
        searchProvider(firstName);
    }

    /**
     * This method navigates to CoC and search for the provider
     * @param firstName
     * @param trackingNum
     */
    public void navigateToCoCAndSearchForTheProvider(String firstName, String trackingNum) {
        ajaxClick(Locators.COC_TAB);
        searchProvider(firstName, trackingNum);
    }

    /**
     * This method navigates to Appeal and search for the provider
     * @param firstName
     */
    public void navigateToAppealAndSearchForTheProvider(String firstName) {
        ajaxClick(Locators.APPEALS_TAB);
        searchProvider(firstName);
    }
    /**
     * This method navigates to Appeal and search for the provider
     * @param firstName
     * @param trackingNum
     */
    public void navigateToAppealAndSearchForTheProvider(String firstName, String trackingNum) {
        ajaxClick(Locators.APPEALS_TAB);
        searchProvider(firstName,trackingNum);
    }

    /**
     * This method searches provider and approve termination request
     * @param firstNameProvider
     * @param lastNameProvider
     */
    public void searchProviderAndApproveTerminationRequest(String firstNameProvider, String lastNameProvider) {
        searchProvider(firstNameProvider + " " + lastNameProvider);
        Reports.log("Search for the Provider: " + firstNameProvider + " " + lastNameProvider);
        searchSpecificEnrollmentAndClick(5, "NEW");
        javaWaitSec(3);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {

            javaWaitSec(3);
            clickAnyButton(Data.optionChangeStatus);
            driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
            //driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
            //Selecting the "Termination Approved" from the menu
            clickLastOptionInList(0);
            clickAnyButton(Data.TEXT_APPLY);
            javaWaitSec(3);
            driver.navigate().refresh();
            javaWaitSec(5);
            for (int i = 0; i < 5; i++) {
                String enrollmentStatus = driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText();
                try {
                    if (enrollmentStatus.equalsIgnoreCase("APPROVED")) {
                        Reports.log("Application Status :" + enrollmentStatus);
                        break;
                    }
                } catch (Exception e) {
                    Reports.log("Application Status is Still under" + enrollmentStatus);
                    driver.navigate().refresh();
                    javaWaitSec(5);
                }
            }
        }
    }

    /**
     * This method clicks and navigate to document tab
     */
    public void clickAndNavigateToDocumentTab() {
        javaWaitSec(5);
        driver.findElement(Locators.DOCUMENTS_TAB).click();
        Reports.log("Module selected: Document");
        closeDocumentsIframe();
        Reports.log("Close Pop-up Window");
    }

    /**
     * This method opens root folder
     */
    public void openRootFolder() {
        ajaxClick(Locators.ICON_OPEN_ROOT_FOLDERS);
        Reports.log("Open Side Menu");
        javaWaitSec(3);
    }

    /**
     * This method enters value for search
     * @param searchValue
     */
    public void enterValueForSearch(String searchValue) {
        Reports.log("Search for Name: " + searchValue);
        ajaxClick(Locators.TEXT_FIELD_SEARCH_DOCUMENTS);
        driver.findElement(Locators.TEXT_FIELD_SEARCH_DOCUMENTS).sendKeys(searchValue);
        javaWaitSec(5);
    }

    /**
     * This method expands root folder
     */
    public void expandRootFolder() {
        javaWaitSec(5);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.EXPAND_ROOT_FOLDERS)).click();
        Reports.log("Expanding the Root Folder");
        javaWaitSec(5);
    }

    /**
     * This method navigates to provider tab and search for enrollment
     * @param enrollmentType
     */
    public void navigateToProviderTabAndSearchForEnrollment(String enrollmentType) {
        clickProvidersTab();
        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_ENROLLMENT_TYPE).click();
        clickSpecificOptionInListbox(enrollmentType);
        javaWaitSec(1);
        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_PROVIDER_STATUS).click();
        clickSpecificOptionInListbox("Active");
        javaWaitSec(1);
        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ADDRESS).sendKeys(Data.physicalAddress);
        javaWaitSec(1);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(Locators.BUTTON_SEARCH);
        javaWaitSec(5);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
        driver.findElements(Locators.ROW_IN_TABLE).get(0).click();
        javaWaitSec(10);
    }

    /**
     * This method gets providers ID
     * @return
     */
    public String getProvidersID(){
        javaWaitSec(10);
        String providerId = driver.findElement(Locators.ID_PROVIDER_DETAILS).getText();
        Reports.log("Provider ID: "+providerId);
        return providerId;
    }

    /**
     * This method navigates to provider Tab and search for enrollment by provider
     * @param enrollmentType
     * @param providerName
     */
    public void navigateToPrvdrTabAndSearchForEnrollmentbyProvider(String enrollmentType, String providerName )
    {
        clickProvidersTab();
        driver.navigate().refresh();
        javaWaitSec(5);
        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_ENROLLMENT_TYPE).click();
        clickSpecificOptionInListbox(enrollmentType);
        javaWaitSec(1);
        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_PROVIDER_NAME_ID).sendKeys(providerName);
        Reports.log("Search for the Provider: "+providerName);
        javaWaitSec(5);
        //    driver.findElement(Locators.TEXT_FIELD_PROVIDER_ADDRESS).sendKeys(Data.physicalAddress);
        //  javaWaitSec(2);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(Locators.BUTTON_SEARCH);
        javaWaitSec(5);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
        driver.findElements(Locators.ROW_IN_TABLE).get(0).click();
        javaWaitSec(10);
    }

    /**
     * This method navigates to Site Visit Page
     */
    public void NavigateToSiteVisitPage(){
        clickAnyHeaderTitLe(Data.textSiteVisitsTab);
        Reports.log("Click header tab: " + Data.textSiteVisitsTab);
    }

    /**
     * This method create Site Visit for provider
     * @param providerID
     */
    public void createSiteVisitForProvider(String providerID) {
        ajaxClick(Locators.BUTTON_SITEVISIT);
        Reports.log("Click on Site Visit button");
        javaWaitSec(2);
        driver.findElement(Locators.TEXTBOX_POPUP_CREATESITEVISIT_PROVIDERID).sendKeys(providerID);
        Reports.log("Create Site Visit popup is displayed");
        Reports.log("Entered Provider id: "+providerID);
        driver.findElement(Locators.TEXTBOX_POPUP_CREATESITEVISIT_PROVIDERID).sendKeys(Keys.TAB);

        javaWaitSec(10);
        ajaxClick(Locators.BUTTON_CREATE_SITEVISIT_POPUP);
        Reports.log("Click on Create button");
        javaWaitSec(10);

        //Provider Enrollment Site Visit Checklist Instructions
        scrollToBottomOfPage();
        ajaxClick(Locators.BUTTON_NEXT_PROVIDERDETAILS);
        Reports.log("Click on Next Button");

        ajaxClick(Locators.BUTTON_UPLOAD_DOCUMNETS_APPLICATION);
        Reports.log("Click on Upload Document Button");
        clickAnyButton(Data.TEXT_Submit);
        Reports.log("Site Visit submitted successfully");
        javaWaitSec(10);
    }

    /**
     * This method search provider and change status Of Site Visit
     * @param providerId
     * @param status
     */
    public void searchProviderAndChangeStatusOfSiteVisit(String providerId, String status) {
        clickAnyHeaderTitLe(Data.textSiteVisitsTab);
        Reports.log("Click header tab: " + Data.textSiteVisitsTab);

        driver.findElement(Locators.TEXT_FIELD_PROVIDER_SITE_VISIT).sendKeys(providerId);
        Reports.log("Entered the Providerid:"+providerId);
        ajaxClick(Locators.BUTTON_SEARCH);
        Reports.log("Click on search button");
        javaWaitSec(5);

        for (int i = 0; i < 10; i++) {
            Reports.log("Wait for" + 10 + "seconds for application to load..");
            javaWaitSec(10);
            Reports.log ("Click button: " + Data.TEXT_SEARCH);
            ajaxClick(setAndFindButton(Data.TEXT_SEARCH));
            try {
                driver.findElements(Locators.PART_OF_ENROLLMENT_INFO).get(0).getText();
                try {
                    if (anyStatusOfEnrollment("PENDING APPROVAL").isDisplayed()) {
                        break;
                    }
                } catch (Exception e) {
                    Reports.log("Exception Found: " + e);
                }
                Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
            } catch (Exception e) {
                Reports.log("Request was not found");
            }
        }
        javaWaitSec(2);
        driver.findElement(Locators.ELLIPSE_BUTTON).click();
        Reports.log("Selected siteVise option : " + driver.findElement(Locators.SELECT_VIEW_OPTION).getText());
        driver.findElement(Locators.SELECT_VIEW_OPTION).click();
        javaWaitSec(3);
        changeStatusOfEnrollment(status);
    }
//    public void navigateToProviderTabAndSearchForEnrollment2(String enrollmentType )
//    {
//        clickProvidersTab();
//
//        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_ENROLLMENT_TYPE).click();
//        clickSpecificOptionInListbox(enrollmentType);
//        javaWaitSec(1);
//        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_PROVIDER_STATUS).click();
//        clickSpecificOptionInListbox("Active");
//        javaWaitSec(1);
//        driver.findElement(Locators.TEXT_FIELD_PROVIDER_ADDRESS).sendKeys(Data.physicalAddress);
//        javaWaitSec(1);
//        Reports.log("Click button: " + Data.TEXT_SEARCH);
//        ajaxClick(Locators.BUTTON_SEARCH);
//        javaWaitSec(5);
////        //add this see if that works
////        WebElement element = driver.findElement(new By.ByXPath("//div[contains(@class, 'tile-table-column')]//p"));
////        String npi= element.getText();
////        Reports.log("Npi is"+ npi);
////        //3 line above added
////        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
////        driver.findElements(Locators.ROW_IN_TABLE).get(1).click();
////        javaWaitSec(10);
//    }

    /**
     * This method validate the enrolment_Coc_Appeal_Applications
     * @param firstName
     * @param lastName
     */
    public void validateTheEnrolment_Coc_Appeal_Applications(String firstName, String lastName){
        List<WebElement> folders = driver.findElements(By.xpath(Data.ONE_ROOT_FOLDER));
        for (int i = 0; i < folders.size(); i++) {
            System.out.println(i);
            String titleFolder = folders.get(i).getText();
            //if (titleFolder.contains("ENROLLMENTAPPLICATION") || titleFolder.contains("COC_APPLICATION") || titleFolder.contains("ENROLLMENT_APPEAL")) {
            if (titleFolder.contains("ENROLLMENTAPPLICATION") || titleFolder.contains("COC_APPLICATION") || titleFolder.contains("ROOT`")) {
                ajaxClick(folders.get(i));
                javaWaitSec(3);
                List<WebElement> checkboxes = driver.findElements(By.xpath("//tr[@role='checkbox']"));
                if (checkboxes.size() == 0) {
                    Assert.fail("No files in list");
                }
                for (int j = 0; j < checkboxes.size(); j++) {
                    String checkboxTitle = checkboxes.get(j).getText();
                    Reports.log("checkboxTitle: "+checkboxTitle);
                    if (!checkboxTitle.contains(firstName) && !checkboxTitle.contains(lastName)) {
                        Assert.fail("No " + firstName + " and " + lastName + " in folder");
                    }
                }
            }
            folders = driver.findElements(By.xpath(Data.ONE_ROOT_FOLDER));
        }
    }

    /**
     * This method navigates to provider tab and search for enrollment
     */
    public void navigateToProviderTabAndSearchForEnrollment( ) {
        clickProvidersTab();
        driver.findElement(Locators.SEARCH_BOX).findElement(Locators.TEXT_FIELD_PROVIDER_STATUS).click();
        clickSpecificOptionInListbox("Active");
        javaWaitSec(1);
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        ajaxClick(Locators.BUTTON_SEARCH);
        javaWaitSec(5);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ROW_IN_TABLE));
        driver.findElements(Locators.ROW_IN_TABLE).get(1).click();
        javaWaitSec(10);
    }

    /**
     * This method suspends the enrollment application
     */
    public void suspendTheEnrollmentApplication(){
        javaWaitSec(5);
        driver.findElement(Locators.DETAILED_MENU_PROVIDER_DETAILS).click();
        javaWaitSec(5);
        clickRequestMenuOption("Suspended");

        fillInCalendar("03/11/2021", Data.suspendedFormCalendar);
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        clickAnyOptionInList(1);
        clickAnyButton(Data.TEXT_SUSPEND);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(10);
        driver.navigate().refresh();
        javaWaitSec(20);

    }

    /**
     * This method reactivates the enrollment application
     */
    public void reactivateTheEnrollmentApplication(){
        javaWaitSec(5);
        driver.findElement(Locators.DETAILED_MENU_PROVIDER_DETAILS).click();
        clickRequestMenuOption("Reactivate");
        fillInCalendar("03/11/2020", Data.reactivateFormCalendar);
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        clickSpecificOptionInListbox("Positive Voting Results");
        javaWaitSec(5);
        clickAnyButton(Data.TEXT_REACTIVATE);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(10);
        driver.navigate().refresh();
        javaWaitSec(5);
    }

    /**
     * This method terminates the enrollment application
     */
    public void terminateTheEnrollmentApplication(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DETAILED_MENU_PROVIDER_DETAILS));
        driver.findElement(Locators.DETAILED_MENU_PROVIDER_DETAILS).click();
        clickRequestMenuOption("Terminate");
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        Reports.log("Click on Reason Code list");
        clickSpecificOptionInListbox("Provider Requested Termination");
        clickAnyButton(Data.TEXT_TERMINATE);
        clickAnyButton(Data.TEXT_OK);
        javaWaitSec(2);
        driver.navigate().refresh();
        javaWaitSec(2);
    }

    /**
     * This method verifies the status of application
     * @param applicationStatus
     */
    public void verifyTheStatusOfApplication(String applicationStatus){
        //wait.until(ExpectedConditions.visibilityOf(spanContainsText(applicationStatus)));
        for (int i = 0; i < 10; i++) {
            try {
                try {
                    javaWaitSec(20);
                    WebElement appStatusElement = spanContainsText(applicationStatus);
                    String appStatus = appStatusElement.getText();
                    System.out.println("Application Status: " + appStatus);
                    if (appStatus.equals(applicationStatus)) {
                        break;
                    }
                } catch (Exception e) {
                    if(spanContainsText("SYNC_FAILED").isDisplayed()){
                        System.out.println("Application Status: SYNC_FAILED");
                        Assert.fail("Application Status: SYNC_FAILED");
                    }
                }
            }
            catch(Exception e){
                driver.navigate().refresh();
                javaWaitSec(10);
                Reports.log("Status is not displayed yet, retrying Again. Attempt# " + i);
                if(i==9){
                    Assert.fail("Application Status is not: "+applicationStatus);}
            }
        }
    }



    public void verifyTheStatusOfApplication(){
        javaWaitSec(5);
        closeAlert();
        String appStatus = driver.findElement(By.xpath("//span[contains(.,'Status')]/following::span")).getText();
        Reports.log("Application status:" + appStatus);
        Assert.assertTrue(appStatus.contains("ACTIVE"));
    }

    /**
     * This method changes the status of enrollment retro active
     * @param statusOfApplication
     */
    public void changeStatusOfEnrollmentRetroActive(String statusOfApplication) {
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();

        //select approve option
        if (statusOfApplication.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
        } else if (statusOfApplication.contains("Denied")) {
            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        }
        Reports.log("Open Request Retroactive Adjustment page");
        WebElement radionButton = driver.findElement(Locators.RADIOBOX_REQUEST_RETROACTIVE);
        Reports.log("Selected Yes on Question 'Do you want to be approved retroactively?'");
        radionButton.click();
        String date = changeDayInCurrentDate(-7);
        fillInCalendar(date ,Data.effectiveDateCalendar2);
        //Select approve Reason
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        // clickFirstOptionInList();
        clickAnyOptionInList(1);
        javaWaitSec(5);
        WebElement note = driver.findElement(Locators.POPUP_PENDING_REVIEW_NOTES);
//        note.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        javaWaitSec(1);
//        note.sendKeys(Keys.BACK_SPACE);
//        javaWaitSec(1);
        clearContent(note);
        note.sendKeys("Retroactively Approved to "+ date + "per client request");
        javaWaitSec(1);
        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(20);
        driver.navigate().refresh();
        javaWaitSec(10);
        //   if (statusOfApplication.contains("Approved")||statusOfApplication.contains("Denied")) {
        String applicationStatus = null;
        for(int j =0; j< 2; j++) {
            for (int i = 0; i < 5; i++) {
                try {
                    applicationStatus = getApplicationStatus();
                    if (applicationStatus.equalsIgnoreCase(statusOfApplication)||applicationStatus.contains("SYNC FAILED")) {
                        break;
                    }else {
                        driver.navigate().refresh();
                        Reports.log("Application Status is Still under : " + applicationStatus + "so Refreshing the page");
                        javaWaitSec(10);
                        if (j != 2) {
                            if (i == 9 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
                                Reports.log("Application Status is Still under : " + applicationStatus + "so trying to re-change the application status again");
                                changeStatusOfEnrollmentRetroActive(statusOfApplication);
                            }
                        }
                    }
                } catch (Exception e) {
                    Reports.log("Application Status is Still under" + applicationStatus);
                    driver.navigate().refresh();
                    javaWaitSec(20);
                }
            }
        }
        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
    }



    /**
     * This method changes the status of enrollment
     * @param statusOfApplication
     */
    public void changeStatusOfEnrollment(String statusOfApplication) {
        javaWaitSec(5);
        String applicationStatus =  changeApplicationStatus(statusOfApplication);
        for (int i = 0; i < 3; i++) {
            try {
                applicationStatus =  getApplicationStatus();
                Reports.log("Application Status: "+applicationStatus);
                if (i != 3 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
                    Reports.log("Application Status is Still under : " + applicationStatus + " so trying to re-change the application status again  Attempt# " + i);
                    changeApplicationStatus(statusOfApplication);
                }
                else {
                    break;
                }
            } catch (Exception e) {
                Reports.log("Application Status is Still under " + applicationStatus+", retrying Again. Attempt# " + i);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }
        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
    }

//        closeAlert();
//        javaWaitSec(10);
//        clickAnyButton(Data.optionChangeStatus);
//        driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
//
//        //select approve option
//        if (statusOfApplication.contains("Approved")) {
//            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
//        } else if (statusOfApplication.contains("Denied")) {
//            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
//            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
//        }
//        //Select approve Reason
//        // driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
//        ajaxClick(Locators.BUTTON_APPROVE_REASON);
//        clickFirstOptionInList();
//        clickAnyButton(Data.TEXT_APPLY);
//        javaWaitSec(20);
//        driver.navigate().refresh();
//        javaWaitSec(10);
//        //   if (statusOfApplication.contains("Approved")||statusOfApplication.contains("Denied")) {
//        String applicationStatus = null;
//            for (int i = 0; i < 6; i++) {
//                try {
//                    applicationStatus =  getApplicationStatus();
//                    if (applicationStatus.equalsIgnoreCase(statusOfApplication)||applicationStatus.contains("SYNC FAILED")) {
//                        break;
//                    }else {
//                        driver.navigate().refresh();
//                        Reports.log("Application Status is Still under : " + applicationStatus + " so Refreshing the page");
//                        javaWaitSec(20);
//                            if (i ==5 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
//                                Reports.log("Application Status is Still under : " + applicationStatus+ " so trying to re-change the application status again \n");
//                                changeStatusOfEnrollment(statusOfApplication);
//                            }
//                    }
//                } catch (Exception e) {
//                    Reports.log("Application Status is Still under" + applicationStatus);
//                    driver.navigate().refresh();
//                    javaWaitSec(20);
//                }
//            }
//        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
//    }

//    /**
//     * This method changes the status with reason
//     * @param statusOfApplication
//     */
//    public void changeStatusWithReason(String statusOfApplication) {
//        changeApplicationStatus(statusOfApplication);
//        String applicationStatus = null;
//
//        for (int i = 0; i < 3; i++) {
//            try {
//                if (i == 3 && !applicationStatus.equalsIgnoreCase(statusOfApplication)) {
//                    Reports.log("Application Status is Still under : " + applicationStatus + " so trying to re-change the application status again \n");
//                    changeApplicationStatus(statusOfApplication);
//                }
//            } catch(Exception e){
//                Reports.log("Application Status is Still under" + applicationStatus);
//                driver.navigate().refresh();
//                javaWaitSec(20);
//            }
//        }
//        Assert.assertTrue(statusOfApplication.equalsIgnoreCase(applicationStatus));
//
//    }

    public String changeApplicationStatus(String statusOfApplication){
        closeAlert();
        javaWaitSec(10);
        clickAnyButton(Data.optionChangeStatus);
       // driver.findElement(Locators.POPUP_INNER_ENROLLMENT_STATUS).click();
        driver.findElement(Locators.POPUP_CHANGE_STATUS).click();

        if (statusOfApplication.contains("Approved")) {
            clickAnyOptionInList(0);  // 0 Approved, 1 Denied
        } else if (statusOfApplication.contains("Denied")) {
            clickAnyOptionInList(1);  // 0 Approved, 1 Denied
            boolean status = driver.findElement(By.xpath("//label[text()='Status']//ancestor::div[contains(@class, 'requests')]//div[contains(text(),'" + "Denied" + "')]")).isDisplayed();
        }else {
            ajaxClick(setSpecificOptionInListbox(statusOfApplication));
        }


        ajaxClick(Locators.BUTTON_APPROVE_REASON);
        clickFirstOptionInList();

        clickAnyButton(Data.TEXT_APPLY);
        javaWaitSec(15);
        driver.navigate().refresh();
        javaWaitSec(10);

        String applicationStatus = null;
        for (int i = 0; i < 6; i++) {
            try {
                applicationStatus =  getApplicationStatus();
                if (applicationStatus.equalsIgnoreCase(statusOfApplication)||applicationStatus.contains("SYNC FAILED")) {
                    break;
                }else {
                    driver.navigate().refresh();
                    Reports.log("Application Status is Still under : " + applicationStatus + " so Refreshing the page");
                    javaWaitSec(20);
                }
            } catch (Exception e) {
                Reports.log("Application Status is Still under" + applicationStatus);
                driver.navigate().refresh();
                javaWaitSec(20);
            }
        }
        return applicationStatus ;
    }
}
