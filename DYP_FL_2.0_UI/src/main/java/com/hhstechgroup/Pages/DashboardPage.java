package com.hhstechgroup.Pages;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.hhstechgroup.Pages.ProviderEnrollingPage.*;

public class DashboardPage extends BaseActions {
    protected SoftAssert softAssert = new SoftAssert();
    public IUEnrollmentPage iuEnrollmentPage = new IUEnrollmentPage(driver, wait);

    //    public static final By PROVIDER_TRACKING_NUMBER = By.xpath("//span[contains(.,'Tracking')]//following::div");
    public static final By PROVIDER_TRACKING_NUMBER = By.xpath("//span[contains(text(), 'Tracking number')]/ancestor::span/following-sibling::div[@class='value']");
    public static final By TEXT_FIELD_FIRST_NAME_HELLO_SIGN = By.xpath("//div//textarea[@placeholder='Full Name']");
    public static final By SECTION_TYPE_IN = By.xpath(".//div[contains(@class,'dig-Tabs-tabs')]//li[@aria-label='Type in your signature']//span//div");  //By.xpath("//ol//li[@title='Type it in']");
    public static final By SECTION_TYPE_SIGNATURE = By.xpath("//div[@data-qa-ref='hello-modal']//input");
    public static final By BUTTON_INSERT_HELLO_SIGN = By.xpath("//button[@data-qa-ref='singing-modal--insert-btn']");
    public static final By LINK_DASHBOARD = By.xpath("//a[@href='/dashboard']");
    // public static final By HELPTOUR_USER = By.xpath(".//div[contains(@class, 'header_user_')]/div");
    public static final By HELPTOUR_USER = By.xpath("//div//img[contains(@class,\"user-anonym-imgg\")]");


    public static final By HELP_CENTER = By.xpath("//a/p[contains(text(),'Help Center')]");
    public static final By TILES = By.xpath("//div[contains(@class,'link-box_link')]");
    public static final By ROCKETCHAT_MINIMIZE = By.xpath("//div[contains(@class, 'rocketchat')]//button[contains(@title, 'Minimize')]");
    public static final By ROCKETCHAT_MAXIMIZE = By.xpath("//div[contains(@class, 'rocketchat')]//button[contains(@title, 'Maximize')]");
    public static final By PROVIDER_NAME_FIELD = By.cssSelector("input#providerName");
    public static final By PROVIDER_ID_FIELD = By.xpath("//input[@id='ProviderID']");
    public static final By USER_NAME_FIELD = By.cssSelector("input#userName");
    public static final By PAYMENT_ID_FIELD = By.cssSelector("input#paymentId");
    public static final By TCN_FIELD = By.cssSelector("input#tcn");
    public static final By PROVIDER_ID_1099_FIELD = By.cssSelector("input#providerId");
    public static final By REPORTS_TITLE = By.xpath("//div[contains(text(),'Reports')]");
    public static final By SITE_VISITS_TITLE = By.xpath("//div[text()='Site visits']");
    public static final By VOTING_TITLE = By.xpath("//div[contains(text(),'Voting requests')]");
    public static final By HELPCENTER_TITLE = By.xpath("//a[@title='Help Center']");
    public static final By CSDN_IFRAME = By.xpath("//iframe[@title='C-SDN']");
    public static final By ANY_HEADER_MAIN_TAB = By.xpath("//div[contains(@class, 'header')]//ul/li/a");
    public static final By PROVIDER_DATA_TOP_SECTION_LABELS = By.xpath("//div[contains(@class, 'main-info-panel_content')]//div/span/span");
    public static final By PROVIDER_Dashboard_LABELS = By.xpath("(//div[contains(@style,'padding')])[2]/div/div");

    public static final String CURRENT_URL_MSG = "Current URL: ";
    public static final String TAB_DISPLAYED_MSG = "Tab Displayed: ";
    public static final String TAB_NOT_DISPLAYED_MSG = "Tab is not displayed or expected: ";
    public static final String TABS_CURRENTLY_OPENED_MSG = "Number of Tabs Currently Opened: ";
    public static final String ITERATION_MSG = "Iteration: ";
    public static final By ANY_MAIN_TITLE = By.xpath("//div[contains(@class, 'root_content')]"); // Root content
    public static final By DOCUMENT_MAIN_TITLE = By.xpath("//a[@href='/csdn-redirect'][contains(.,'Documents')]"); // Root content

    public static final By APPRVD_PROV_VIEW_DETAILS = By.xpath("//span[contains(text(),'View details')]/parent::p/following-sibling::div");
    public static final By SECONDARY_SERVICE_LOCATION_TAB = By.xpath("//span[contains(text(),'Secondary Service Location')]");

    public static final By PROVIDER_DASHBOARD_RECONSIDERATION_BUTTON = By.xpath("//span[contains(.,'Reconsideration')]");

    public static final By PROVIDER_DASHBOARD_STATUS = By.xpath("//span[contains(.,'Status')]//following::div[2]");
    public static final By PROVIDER_DASHBOARD_STATUS2 = By.xpath("//p[contains(.,'Status')]//following::span");
    public static final By PROVIDER_DASHBOARD_STATUS3 = By.xpath("//span[contains(.,'Status')]//following::div[1]");

    public static final By PROVIDER_DASHBOARD_REQUEST_TERMINATION_BTN = By.xpath("//span[contains(.,'Request Termination')]");

    public static final By PROVIDER_DASHBOARD_REQUEST_TERMINATION_LINK = By.xpath("//span[contains(text(),'Request Termination')]");

    public static final By BUTTON_REASON_TERMINATION = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");

    public static final By REQUEST_TERMINATION_NOTE = By.xpath("//textarea[3]");

    public static final By PROVIDER_ID = By.xpath("//p[contains(.,'Provider ID')]//following::span[1]");

    public static final By TERMINATION_TRACKING_NUMBER = By.xpath("//span[contains(.,'Tracking Number')]//following::div");


    public static final By CREATE_REVALIDATION_BUTTON = By.xpath("//span[contains(.,'CREATE REVALIDATION')]");

    public static final String LEFT_SIDE_CHECKMARK = ".//span[contains(text(),'%s')]/../div/*[contains(@class, 'menu_green')]";
    public static final By REVALIDATION_MESSAGE = By.xpath("//div[contains(@class,'styles_ico')]/following::p[1]");

    public static final By ADDAffiliation_ENROLLPROVIDER_BUTTON = By.xpath("//span[contains(.,'+ Enroll Provider')]");
    public static final By AFFILIATED_PROVIDER_NAME_OR_NPI_INPUT_SEARCH = By.xpath("//input[contains(@id,'providerNameNpi')]");
    public static final By AFFILIATED_PROVIDER_SEARCH_BTN = By.xpath("//button//span[contains(.,'Search')]");

    public static final By PROVIDERINFO_POPUP_Email = By.xpath("//label[contains(., 'Email')]//following-sibling::div//textarea[@type='text']");
    public static final By PROVIDERINFO_POPUP_FirstName = By.xpath("//label[contains(., 'First Name')]//following-sibling::div//textarea[@type='text']");
    public static final By PROVIDERINFO_POPUP_LastName = By.xpath("//label[contains(., 'Last Name')]//following-sibling::div//textarea[@type='text']");
    public static final By PROVIDERINFO_POPUP_ProceedButton = By.xpath("//button[contains(.,'Proceed')]");
    public static final By NO_RADIOBTN_FOR_DO_YOU_HAVE_EMAILID = By.xpath("//span[contains(.,'Do you have the Email-ID of the provider?')]//following::div//input[@value='false']");

    private BaseActions providerEnrollingPage;

    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public DashboardPage(
            WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method clicks On Enrollment Type
     *
     * @param enrollmentType
     */
    public void clickOnEnrollmentType(String enrollmentType) {
        clickAnyTitleByText(enrollmentType, Data.h2);
        javaWaitSec(20);
    }

    /**
     * This method gets provider tracking number
     *
     * @return
     */
    public String getProviderTrackingNumber() {
        javaWaitSec(10);
        String trackingNum = driver.findElement(PROVIDER_TRACKING_NUMBER).getText();
        Reports.log("Providers Tracking Number:" + trackingNum);

        return trackingNum;
    }

    public void ProccedToSignHelloSign(String firstName, String lastName) {
        Reports.log("\n Wait Hello Sign page");

// Check if "PROCEED TO SIGN" button is present
        try {
            if (driver.findElement(By.xpath("//button//span[text()='" + Data.TEXT_PROCEED_TO_SIGN + "']")).isDisplayed()) {
                Reports.log("Proceed to Sign button is available, clicking it");
                ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
            }
        } catch (Exception e) {
            Reports.log("Proceed to Sign button not found, continuing");
        }

        for (int i = 0; i <= 2; i++) {
            try {
                try {
                    advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                    Reports.log("Switch to Hello Sign page");
                    driver.switchTo().frame(Data.helloSignIframe);
                    Reports.log("Close pop-up");
                    clickAnyButton(Data.TEXT_OK);
                    break;
                } catch (Exception e) {
                    Reports.log("Hello Sign page is loading....! Refreshing the page");
                    driver.navigate().refresh();
                    javaWaitSec(5);
                    if (i == 5) {
                        if (driver.findElement(By.xpath("//span[text()='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
                            clickAnyButton(Data.TEXT_SIGN);
                            advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                            Reports.log("Switch to Hello Sign page");
                            driver.switchTo().frame(Data.helloSignIframe);
                            Reports.log("Close pop-up");
                            clickAnyButton(Data.TEXT_OK);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                Reports.log("Unable to load the Hello Sign page, retrying");
                javaWaitSec(8);
            }
        }

        Reports.log("Get started");
        ajaxClick(BUTTON_GET_STARTED);
        javaWait(3000);
        Reports.log("Click Signature input");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Click to sign']")));
        ajaxClick(By.xpath("//div[text()='Click to sign']"));
        Reports.log("Clicked on Signature input");
        javaWaitSec(5);
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_TYPE_IN));
        Reports.log("Click option Type it in");
        ajaxClick(SECTION_TYPE_IN);

        Reports.log("Click Insert button");
        ajaxClick(BUTTON_INSERT_HELLO_SIGN);

        clickAnyButton(Data.TEXT_CONTINUE);
        clickAnyButton2(Data.TEXT_I_AGREE, 0);
        javaWaitSec(30);
        ajaxClick(LINK_DASHBOARD);
        javaWaitSec(10);

    }

    /**
     * This method signs in Hello Sign using firstName, lastName
     *
     * @param firstName
     * @param lastName
     */
    public void signInHelloSign(String firstName, String lastName) {
        Reports.log("\n Wait Hello Sign page");
        for (int i = 0; i <= 5; i++) {
            try {
                try {
                    advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                    Reports.log("Switch to Hello Sign page");
                    driver.switchTo().frame(Data.helloSignIframe);
                    Reports.log("Close pop up");
                    clickAnyButton(Data.TEXT_OK);
                    break;
                } catch (Exception e) {
                    Reports.log("Hello sign page is loading....! so Refreshing the page");
                    driver.navigate().refresh();
                    javaWaitSec(5);
                    if (i == 5) {
                        if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
                            clickAnyButton(Data.TEXT_SIGN);
                            advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                            Reports.log("Switch to Hello Sign page");
                            driver.switchTo().frame(Data.helloSignIframe);
                            Reports.log("Close pop up");
                            clickAnyButton(Data.TEXT_OK);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
//                Reports.log("Unable to load the hello sign page");
                javaWaitSec(8);
            }
        }

        Reports.log("Wait full name text field");
//        advanceFindElement(TEXT_FIELD_FIRST_NAME_HELLO_SIGN, 20, 2);

//        Reports.log("Type full name: " + firstName + " " + lastName);

        Boolean staleElement = true;
        while (staleElement) {
            try {
                javaWaitSec(10);
                driver.findElement(TEXT_FIELD_FIRST_NAME_HELLO_SIGN).sendKeys(firstName + " " + lastName);
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }

        Reports.log("Click Signature input");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-qa-ref = 'signature-input']")));
        javaWaitSec(10);
        ajaxClick(By.xpath("//div[@data-qa-ref = 'signature-input']"));
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_TYPE_IN));
        Reports.log("Click option Type it in");
        ajaxClick(SECTION_TYPE_IN);

        Reports.log("Click Signature area");
//06/21/2023        wait.until(ExpectedConditions.elementToBeClickable(SECTION_TYPE_SIGNATURE));
//06/21/2023        performClick(SECTION_TYPE_SIGNATURE);

        Reports.log("Type signature");
//06/21/2023        driver.findElement(SECTION_TYPE_SIGNATURE).sendKeys("OL");

//        Reports.log("Click option Type it in");
//        ajaxClick(SECTION_TYPE_IN);

        Reports.log("Click Insert button");
        ajaxClick(BUTTON_INSERT_HELLO_SIGN);

        clickAnyButton(Data.TEXT_CONTINUE);
        clickAnyButton2(Data.TEXT_I_AGREE, 0);
        javaWaitSec(10);
        ajaxClick(LINK_DASHBOARD);
        javaWaitSec(10);
    }

    public void HelloSign(String firstName, String lastName) {
        Reports.log("\n Wait Hello Sign page");
        for (int i = 0; i <= 5; i++) {
            try {
                try {
                    advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                    Reports.log("Switch to Hello Sign page");
                    driver.switchTo().frame(Data.helloSignIframe);
                    Reports.log("Close pop up");
                    clickAnyButton(Data.TEXT_OK);
                    break;
                } catch (Exception e) {
                    Reports.log("Hello sign page is loading....! so Refreshing the page");
                    driver.navigate().refresh();
                    javaWaitSec(5);
                    if (i == 5) {
                        if (driver.findElement(By.xpath("//span[text() ='" + Data.TEXT_SIGN + "']")).isDisplayed()) {
                            clickAnyButton(Data.TEXT_SIGN);
                            advanceFindElement(By.cssSelector("#" + Data.helloSignIframe), 50, 2);
                            Reports.log("Switch to Hello Sign page");
                            driver.switchTo().frame(Data.helloSignIframe);
                            Reports.log("Close pop up");
                            clickAnyButton(Data.TEXT_OK);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                ajaxClick(setAndFindButton(Data.TEXT_PROCEED_TO_SIGN));
//                Reports.log("Unable to load the hello sign page");
                javaWaitSec(8);
            }
        }
        Reports.log("Get started");
        ajaxClick(BUTTON_GET_STARTED);
        //ajaxClick(spanContainsText("Get Started"));
        javaWait(3000);
        Reports.log("Click Signature input");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Click to sign']")));
        ajaxClick(By.xpath("//div[text()= 'Click to sign']"));
        Reports.log("Clicked on Signature input");
        javaWaitSec(5);
        wait.until(ExpectedConditions.elementToBeClickable(SECTION_TYPE_IN));
        Reports.log("Click option Type it in");
        ajaxClick(SECTION_TYPE_IN);

        Reports.log("Click Signature area");
//06/21/2023        wait.until(ExpectedConditions.elementToBeClickable(SECTION_TYPE_SIGNATURE));
//06/21/2023        performClick(SECTION_TYPE_SIGNATURE);

        Reports.log("Type signature");
//06/21/2023        driver.findElement(SECTION_TYPE_SIGNATURE).sendKeys("OL");

//        Reports.log("Click option Type it in");
//        ajaxClick(SECTION_TYPE_IN);

        Reports.log("Click Insert button");
        ajaxClick(BUTTON_INSERT_HELLO_SIGN);

        clickAnyButton(Data.TEXT_CONTINUE);
        clickAnyButton2(Data.TEXT_I_AGREE, 0);
        javaWaitSec(30);
        ajaxClick(LINK_DASHBOARD);
        javaWaitSec(10);

    }

    /**
     * This method logs out
     */
    public void logOut() {
        clickHelpTour();
        clickLogOut();
        javaWaitSec(25);
    }

    /**
     * This method clicks on Help Tour
     */
    public void clickHelpTour() {
        javaWaitSec(2);
        Reports.log("Click On user Account");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(HELPTOUR_USER)));
        ajaxClick(HELPTOUR_USER);
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
     * This method clicks on system options tab
     */
    public void clickSystemOptions() {
        javaWaitSec(2);
        waitAndClick(spanContainsText(Data.TEXT_SYSTEM_OPTIONS));
        Reports.log("\nClick System options");
    }

    /**
     * This method verify all the tiles(enrollment types) in provider landing page
     */
    public void verifyTiles() {
        Reports.log("\nVerifying Tiles: \n");
        javaWaitSec(5);
        List<WebElement> tiles = driver.findElements(TILES);
        for (int i = 0; i < tiles.size(); i++) {
            System.out.println(tiles.get(i).getText() + "\n");
        }
    }

    /**
     * This method verifies help center
     */
    public void verifyHelpCenter() {
        driver.findElement(HELP_CENTER).click();
        String parentWindowId = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if (switchToSpecificWindow("Help Center", hList)) {
            Reports.log("CurrentUrl is:" + driver.getCurrentUrl() + "\n" + "Title is : " + driver.getTitle());
            Reports.log("Help center has been verified\n");
        }
        closeAllWindows(hList, parentWindowId);
        switchToParentWindow(parentWindowId);
        Reports.log("CurrentUrl is:" + driver.getCurrentUrl() + "\n" + "Title is : " + driver.getTitle());
    }

    /**
     * This method verifies Rocket Chat
     */
    public void verifyRocketChat() {
        maximizeRocketChat();
        minimizeRocketChat();
    }

    /**
     * This method maximizes the Rocket Chat Live Chat
     * window
     */
    public void maximizeRocketChat() {
        try {
            WebElement rocketChatMaxButton = driver.findElement(DashboardPage.ROCKETCHAT_MAXIMIZE);
            ajaxClick(rocketChatMaxButton);
        } catch (NoSuchElementException e) {
            Assert.fail("RocketChat maximization failed");
        }
        Reports.log("RocketChat window maximized");
    }

    /**
     * This method minimizes the Rocket Chat Live Chat
     * window
     */
    public void minimizeRocketChat() {
        try {
            WebElement rocketChatMinButton = driver.findElement(DashboardPage.ROCKETCHAT_MINIMIZE);
            ajaxClick(rocketChatMinButton);
        } catch (NoSuchElementException e) {
            Assert.fail("RocketChat minimization failed");
        }
        Reports.log("RocketChat window minimized");
    }

    public void verifyMainTabOnInternalUserDashbordPage() {
        List<WebElement> listOfTabs = driver.findElements(ANY_HEADER_MAIN_TAB);
        int noOfTabs = listOfTabs.size();
        String parentWindow = driver.getWindowHandle();

        Reports.log("No Of  Main Tabs Available on Dashboard page are: " + noOfTabs);
        for (int i = 1; i <= noOfTabs; i++) {
            By tabXpath = By.xpath("(//div[contains(@class, 'header_rl fl')]//ul/li)[" + i + "]");

            String tabName = driver.findElement(tabXpath).getText();
            Reports.log("\n" + i + ":" + tabName);


            if (tabName.equalsIgnoreCase("Documents")) {
                ajaxClick(DOCUMENT_MAIN_TITLE);
//                driver.findElement(DOCUMENT_MAIN_TITLE).click();
                javaWaitSec(2);
            } else {
                driver.findElement(tabXpath).click();
            }

            //Get the number of open Windows (tabs)
            ArrayList<String> openTabs = new ArrayList<String>(driver.getWindowHandles());
            Reports.log(TABS_CURRENTLY_OPENED_MSG + openTabs.size());

            //The following if block checks to see if a new Window (tab) has been opened due to the
            //selection of the DyP Help Center link. If so, the new opened Window (tab) is selected
            //the Current url value is set to the Help Center url of the new Window (tab).
            if (openTabs.size() > 1) {
                openTabs.remove(parentWindow);
                switchToParentWindow(openTabs.get(0));
            }

            String currentUrl = driver.getCurrentUrl();
            Reports.log("Current            String currentUrl = driver.getCurrentUrl(); URL:" + currentUrl);
            if (currentUrl.contains(Data.LINK_PROVIDERS)) {
                verifyFieldOnPage(Data.LINK_PROVIDERS, PROVIDER_NAME_FIELD, Data.expectedTitleProviders);
            } else if (currentUrl.contains(Data.LINK_ENROLLMENT)) {
                verifyFieldOnPage(Data.LINK_ENROLLMENT, PROVIDER_ID_FIELD, Data.expectedTitleEnrollment);
            } else if (currentUrl.contains(Data.LINK_COC)) {
                verifyFieldOnPage(Data.LINK_COC, PROVIDER_ID_FIELD, Data.expectedTitleCoc);
            } else if (currentUrl.contains(Data.LINK_APPEALS)) {
                verifyFieldOnPage(Data.LINK_APPEALS, PROVIDER_ID_FIELD, Data.expectedTitleReconsideration);
            } else if (currentUrl.contains(Data.LINK_AUDIT)) {
                verifyFieldOnPage(Data.LINK_AUDIT, USER_NAME_FIELD, Data.expectedTitleAudit);
            } else if (currentUrl.contains(Data.LINK_PAYMENTS)) {
                verifyFieldOnPage(Data.LINK_PAYMENTS, PAYMENT_ID_FIELD, Data.expectedTitlePayments);
            } else if (currentUrl.contains(Data.LINK_CLAIMS)) {
                verifyFieldOnPage(Data.LINK_CLAIMS, TCN_FIELD, Data.expectedTitleClaims);
            } else if (currentUrl.contains(Data.LINK_1099LINK)) {
                verifyFieldOnPage(Data.LINK_1099LINK, PROVIDER_ID_1099_FIELD, Data.expectedTitle1099);
            } else if (currentUrl.contains(Data.LINK_REPORTS)) {
//                verifyFieldOnPage(Data.LINK_REPORTS, REPORTS_TITLE, Data.expectedTitleSiteReports);
            } else if (currentUrl.contains(Data.LINK_SITE_VISIT)) {
                verifyFieldOnPage(Data.LINK_SITE_VISIT, SITE_VISITS_TITLE, Data.expectedTitleSiteVisits);
            } else if (currentUrl.contains(Data.LINK_VOTING)) {
                verifyFieldOnPage(Data.LINK_VOTING, VOTING_TITLE, Data.expectedTitleVoting);
            }
            if (currentUrl.contains(Data.LINK_HELPCENTER)) {
                verifyFieldOnPage(Data.LINK_HELPCENTER, HELPCENTER_TITLE, "Knowledge Base");
                driver.close();
                switchToParentWindow(parentWindow);
                javaWaitSec(2);
            } else if (currentUrl.contains(Data.LINK_DOCUMENTS)) {
                verifyFieldOnPage(Data.LINK_DOCUMENTS, CSDN_IFRAME, "");
            }
        }
    }

    public void verifyFieldOnPage(String page, By field, String title) {
        String currentUrl = driver.getCurrentUrl();
        Reports.log("Current Url :" + currentUrl);
        Assert.assertTrue(currentUrl.contains(page));
        verifyElementVisibility(field);
        if (!currentUrl.contains(Data.LINK_HELPCENTER)
                || currentUrl.contains(Data.LINK_DOCUMENTS)) {
            String currentTitle = driver.findElement(ANY_MAIN_TITLE).getText();
            Assert.assertTrue(currentTitle.contains(title));
            Reports.log("Current Page Title " + title);
        }
    }


    /**
     * This method clicks on enrollment tab
     */
    public void clickEnrollTab() {
        Reports.log("Click header tab: " + Data.textEnrollmentTab);
        clickAnyHeaderTitLe(Data.textEnrollmentTab);
        javaWaitSec(4);
    }

    /**
     * This method clicks on credentialing tab
     */
    public void clickcredentialingTab() {
        Reports.log("Click header tab: " + Data.textcredentialingTab);
        clickAnyHeaderTitLe(Data.textcredentialingTab);
        javaWaitSec(4);
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
     * This method clicks on MCO tab
     */
    public void clickMCOTab() {
        Reports.log("Click header tab: " + Data.textMCOTab);
        clickAnyHeaderTitLe(Data.textMCOTab);
        javaWaitSec(4);
    }


    /**
     * This method clicks a specified tab displayed on the approved Provider top menu
     *
     * @param approvedProviderTab
     */
    public void clickApprovedProviderTab(String approvedProviderTab) {
        clickAnyHeaderTitLe(approvedProviderTab);
        Reports.log("Clicked Approved Provider tab: " + approvedProviderTab);
        javaWaitSec(1);
    }


    /**
     * This method verifies the tabs which should be displayed or not
     *
     * @return
     */
    public void verifyProviderTabsOnDashboard() {
        List<WebElement> listOfTabs = driver.findElements(ANY_HEADER_MAIN_TAB);
        ArrayList<String> tabs = new ArrayList<String>();
        //{ "Dashboard","Appeals", "CoC", "Provider Data", "Help center" };
        int noOfTabs = listOfTabs.size();
        Reports.log("Number Of Main Tabs Available on Dashboard page is: " + noOfTabs);
        for (int i = 0; i < noOfTabs; i++) {
            tabs.add(listOfTabs.get(i).getText());
        }
        Reports.log("Displayed Tabs are:" + tabs);
        softAssert.assertTrue(tabs.contains(Data.TITLE_DASHBOARD), "Dashboard tab Missing");
        softAssert.assertTrue(tabs.contains(Data.cocApplication), "CoC tab Missing");
        softAssert.assertTrue(tabs.contains(Data.textAffiliationsTab), "Affiliations tab Missing");
        softAssert.assertTrue(tabs.contains(Data.textProviderDataTab), "Provider Data tab Missing");
        softAssert.assertTrue(tabs.contains(Data.textHelpCenterTab), "Help center tab Missing");
        softAssert.assertAll();
    }

    public void verifyAllTabsForApprovedProviderOnDashboard() {
        List<WebElement> listOfTabs = driver.findElements(ANY_HEADER_MAIN_TAB);
        ArrayList<String> tabs = new ArrayList<String>();
        //{ "Dashboard","Appeals", "CoC", "Provider Data", "Help center" };
        int noOfTabs = listOfTabs.size();
        Reports.log("Number Of Main Tabs Available on Dashboard page is: " + noOfTabs);
        for (int i = 0; i < noOfTabs; i++) {
            tabs.add(listOfTabs.get(i).getText());
        }
        Reports.log("Displayed Tabs are:" + tabs);
        softAssert.assertTrue(!tabs.contains(Data.TITLE_ELIGIBILITY), "Eligibility tab is displayed");
        Reports.log("Eligibility is not displayed");
        softAssert.assertTrue(!tabs.contains(Data.TITLE_AUTHORIZATION), "Authorization tab is displayed");
        Reports.log("Authorization is not displayed");
        softAssert.assertTrue(!tabs.contains(Data.expectedTitleClaims), "Claims tab is displayed");
        Reports.log("Claims is not displayed");
        softAssert.assertTrue(!tabs.contains(Data.expectedTitle10992), "1099 tab is displayed");
        Reports.log("1099 is not displayed");
        softAssert.assertTrue(!tabs.contains(Data.TITLE_MEDIBOOK), "Medi book tab is displayed");
        Reports.log("MediBook is not displayed");
        softAssert.assertTrue(!tabs.contains(Data.TITLE_PAYERS), "Payers tab is displayed");
        Reports.log("payers is not displayed");
        softAssert.assertTrue(!tabs.contains(Data.TITLE_EDI), "EDI tab is displayed");
        Reports.log("EDI is not displayed");
        softAssert.assertAll();
    }

    /**
     * This method clicks the Provider Data tab and verifies the labels displayed
     * and not displayed in the top section panel
     */
    public void verifyProviderDataTopSectionLabels() {
        clickApprovedProviderTab(Data.textProviderDataTab);
        List<WebElement> listOfLabels = driver.findElements(PROVIDER_DATA_TOP_SECTION_LABELS);
        ArrayList<String> labels = new ArrayList<String>();
        int noOfLabels = listOfLabels.size();
        Reports.log("Number Of Labels Displayed on Top Section panel is: " + noOfLabels);
        for (int i = 0; i < noOfLabels; i++) {
            labels.add(listOfLabels.get(i).getText());
        }
        Reports.log("Displayed Top Section Labels are:" + labels);
        softAssert.assertTrue(labels.contains(Data.TITLE_NPI), "NPI label is Not displayed");
        Reports.log("NPI Label is displayed");
        softAssert.assertTrue(!labels.contains(Data.TITLE_DOB), "DOB label is displayed");
        Reports.log("DOB Label is not displayed");
        softAssert.assertTrue(!labels.contains(Data.TITLE_SPECIALITY), "Speciality label is displayed");
        Reports.log("Speciality Label is not displayed");
        softAssert.assertTrue(!labels.contains(Data.TITLE_GENDER), "Gender label is displayed");
        Reports.log("Gender Label is not displayed");
    }

    public void verifyDashboardLabelsForApprovedProvider(String status) {
        checkAllTheFieldsWithSpecificData(PROVIDER_Dashboard_LABELS, status);
    }

    public static final By REASON_CODE_DROPDOWN = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");
    public static final By TERMINATION_NOTE = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");
    public static final By REQUEST_TERMINATION_BTN = By.xpath("//label[contains(text(), 'Reason')]/following::div[@role='button']");

    public void requestForTermination() {
        javaWaitSec(2);
        ajaxClick(PROVIDER_DASHBOARD_REQUEST_TERMINATION_BTN);

        ajaxClick(REASON_CODE_DROPDOWN);
        clickLastOptionInList(0);
        driver.findElement(TERMINATION_NOTE).sendKeys("Provider Request to Termination the Enrollment");

        ajaxClick(REQUEST_TERMINATION_BTN);
        clickAnyButton(Data.TEXT_OK);

    }


    /**
     * This method Verifies provider enrollment status using expectedStatus argument
     *
     * @param expectedStatus
     */
    public void VerifyProviderApplicationStatusIs(String expectedStatus) {
        javaWaitSec(10);
        String enrollmentStatus;
        if (expectedStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_ACTIVE) || expectedStatus.equalsIgnoreCase(Data.ApplicationStatusApprove)) {
            enrollmentStatus = driver.findElement(PROVIDER_DASHBOARD_STATUS2).getText();
            Reports.log("Enrollment Status is :" + enrollmentStatus);
            Assert.assertTrue(enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_ACTIVE), "Expected Application status is " + Data.APPLICATION_STATUS_ACTIVE +
                    " ,But Actual status is: " + enrollmentStatus);
        } else if (expectedStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_SUSPENDED)) {
            enrollmentStatus = driver.findElement(PROVIDER_DASHBOARD_STATUS2).getText();
            Reports.log("Enrollment Status is :" + enrollmentStatus);
            Assert.assertTrue(enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_SUSPENDED), "Expected Application status is " + Data.APPLICATION_STATUS_SUSPENDED +
                    " ,But Actual status is: " + enrollmentStatus);
        } else if (expectedStatus.equalsIgnoreCase(Data.TEXT_TERMINATE)) {
            enrollmentStatus = driver.findElement(PROVIDER_DASHBOARD_STATUS2).getText();
            Reports.log("Enrollment Status is :" + enrollmentStatus);
            Assert.assertTrue(enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_TERMINATED2), "Expected Application status is " + Data.APPLICATION_STATUS_TERMINATED2 +
                    " ,But Actual status is: " + enrollmentStatus);
        } else {
            enrollmentStatus = driver.findElement(PROVIDER_DASHBOARD_STATUS).getText();
            Reports.log("Provider Enrollment Status: " + enrollmentStatus);
            Assert.assertTrue(expectedStatus.equalsIgnoreCase(enrollmentStatus), "Expected Application status is " + expectedStatus +
                    " But Actual status is: " + enrollmentStatus);
        }

        Reports.log(" Verifying application status has been successfully completed");
    }

    /**
     * This method Verifies provider enrollment status using enrollmentType and expectedStatus arguments.  It
     * performs the same as method {@link #VerifyProviderApplicationStatusIs(String)}, but is used by Trading
     * Partner and PEM enrollment requests.
     *
     * @param enrollmentStatus
     */
    public void verifyProviderApplicationStatusIsAlt(String enrollmentStatus) {

        String actualDashboardStatus;
        String expectedDashboardStatus;

        //Set the expected dashboard status based on the enrollment status
        if ((enrollmentStatus.equalsIgnoreCase(Data.ApplicationStatusApprove))
                || (enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_ACTIVE))
                || (enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_APPROVED_UPPERCASE))) {
            expectedDashboardStatus = Data.APPLICATION_STATUS_ACTIVE2;

        } else if (enrollmentStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_SUSPENDED)) {
            expectedDashboardStatus = Data.APPLICATION_STATUS_SUSPENDED_UPPERCASE;

        } else if (enrollmentStatus.equalsIgnoreCase(Data.TEXT_TERMINATE)) {
            expectedDashboardStatus = Data.APPLICATION_STATUS_TERMINATED2;

        } else {
            expectedDashboardStatus = Data.APPLICATION_STATUS_DENIED_UPPERCASE;

        }
        //Close any popups and reposition the Provider dashboard
        closeAllPopUps();
        ajaxScrollUp();
        ajaxScrollUp();

        //Retrieve the status displayed on the Provider dashboard and compare to the status that is expected
        actualDashboardStatus = driver.findElement(PROVIDER_DASHBOARD_STATUS3).getText();
        Reports.log("Expected Dashboard Status: " + expectedDashboardStatus);
        Reports.log("Actual Dashboard Status: " + actualDashboardStatus);
        Assert.assertTrue(expectedDashboardStatus.equalsIgnoreCase(actualDashboardStatus),
                "Expected Dashboard status is " + expectedDashboardStatus + " But Actual Dashboard status is: " + actualDashboardStatus);

        Reports.log(" Verifying application status has been successfully completed");
    }

    /**
     * This method verifies application status with the expected status
     *
     * @param ActualStatus
     * @param expectedStatus
     */
    public void verifyProviderDashboardStatus(String ActualStatus, String expectedStatus) {
        Reports.log("Actual Status of application is: " + ActualStatus);
        Assert.assertTrue(ActualStatus.equalsIgnoreCase(expectedStatus));
        Reports.log(" Verifying application status has been successfully completed");
    }

    /**
     * This method verifies secondary service location tab is not displayed in the Providers Data Module
     */
    public void verifyNoSecondaryServiceLocationTab() {
        javaWaitSec(5);
        try {
            driver.findElement(SECONDARY_SERVICE_LOCATION_TAB).isDisplayed();
            Assert.assertFalse(false, "Secondary Service Location exists");
        } catch (NoSuchElementException e) {

            Assert.assertTrue(true, "Secondary Service Location does not exist");
            Reports.log("No Secondary Service Location Tab for Service Providers");

        }
    }

    /**
     * This method clicks the View Details link on the Provider's Dashboard
     */
    public void clickViewDetailsOnProviderDashboard() {
        javaWaitSec(5);
        ajaxClick(APPRVD_PROV_VIEW_DETAILS);
        Reports.log("Clicking on the View Details link on Quick Links.");

    }

    /**
     * This method Verifies application status using expectedStatus argument
     *
     * @param ExpectedStatus
     */
    public void VerifyApplicationStatusIs(String ExpectedStatus) {
        javaWaitSec(20);
        String appStatus = null;
        for (int i = 0; i < 10; i++) {
            appStatus = driver.findElement(PROVIDER_DASHBOARD_STATUS).getText();
            if (!appStatus.equalsIgnoreCase(ExpectedStatus)) {
                driver.navigate().refresh();
                javaWaitSec(15);
            }
        }
        Reports.log("Application Status: " + appStatus);
        Assert.assertTrue(ExpectedStatus.equalsIgnoreCase(appStatus), "Expected Status is " + ExpectedStatus + " But Actual Status is : " + appStatus);
        // Assert.assertEquals(appStatus,ExpectedStatus);
    }

    /**
     * This method Verifies application status using expectedStatus argument
     *
     * @param ExpectedStatus
     */
    public void VerifyApplicationStatusIs(String ExpectedStatus, String locator) {
        javaWaitSec(20);
        String appStatus = null;
        for (int i = 0; i < 10; i++) {
            appStatus = driver.findElement(By.xpath(locator)).getText();
            if (!appStatus.equalsIgnoreCase(ExpectedStatus)) {
                driver.navigate().refresh();
                javaWaitSec(15);
            }
        }
        Reports.log("Application Status: " + appStatus);
        Assert.assertTrue(ExpectedStatus.equalsIgnoreCase(appStatus));
        // Assert.assertEquals(appStatus,ExpectedStatus);
    }


    /**
     * This method clicks on Reconsideration button
     */
    public void ClickOnAppealButton() {
        javaWaitSec(2);
        ajaxClick(PROVIDER_DASHBOARD_RECONSIDERATION_BUTTON);
        Reports.log("Clicked on Reconsideration Button");
        javaWaitSec(3);
    }

    /**
     * This method sets the expected dashboard status. It was created mainly to address
     * reactivate status changes because the application status used to make the status change
     * is different from the final status that is displayed in the dashboard.
     *
     * @param applicationStatus
     * @return initialApplicationStatus
     */
    public String setDashboardStatus(String applicationStatus) {
        String dashboardStatus;

        if (applicationStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_REACTIVATE_TERMINATED)) {
            dashboardStatus = Data.APPLICATION_STATUS_ACTIVE;

        } else if (applicationStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_REACTIVATE_SUSPENDED)) {
            dashboardStatus = Data.APPLICATION_STATUS_ACTIVE;

        } else if (applicationStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_APPROVE_RAI)) {
            dashboardStatus = Data.APPLICATION_STATUS_ACTIVE;

        } else {
            dashboardStatus = applicationStatus;
        }

        return dashboardStatus;
    }

    /**
     * This method sets the status written to Provider Info. It was created mainly to address
     * RAI related status changes because the application status used to make the status change
     * is different from the final status that is written to Provider Info.
     *
     * @param applicationStatus
     * @return statusOfApplication
     */
    public String setProviderInfoStatus(String statusOfApplication, String applicationStatus) {
        String providerInfoStatus;

        if (applicationStatus.equalsIgnoreCase(Data.APPLICATION_STATUS_APPROVE_RAI) ||
                applicationStatus.equalsIgnoreCase(Data.ApplicationStatusApprove)) {
            providerInfoStatus = Data.APPLICATION_STATUS_ACTIVE;

        } else {
            providerInfoStatus = statusOfApplication;
        }

        return providerInfoStatus;
    }

    public void verifyProviderDashboardStatus(LoginPage loginPage, LandingPage landingPage, DashboardPage dashboardPage,
                                              String enrollmentType, String providerEmailId, String providerPwd,
                                              String providerInfoStatus, String applicationStatus) {
        if (!applicationStatus.equalsIgnoreCase(Data.REQUESTED_ADDITIONAL_INFORMATION)) {

            //Login Application as provider
            loginPage.signInToApp(providerEmailId, providerPwd);

            //confirmAgreeAndSecureMessages();
            landingPage.confirmAgreeAndSecureMessages();

            //Verify status displayed on Provider's dashboard
            if ((enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER) ||
                    enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER_RECONSIDERATION) ||
                    enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER_REVALIDATION) ||
                    enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER) ||
                    enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER_RECONSIDERATION) ||
                    enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER_REVALIDATION))) {
                dashboardPage.verifyProviderApplicationStatusIsAlt(providerInfoStatus);
            } else {
                dashboardPage.VerifyProviderApplicationStatusIs(providerInfoStatus);
            }
            dashboardPage.verifyProviderTabsOnDashboard();
            dashboardPage.logOut();
        }
    }

    /**
     * This method gets providers ID from the Provider Dashboard using an xpath locator
     *
     * @param locator
     * @return
     */
    public String getProviderIDFromDashboard(String locator) {
        javaWaitSec(5);
        String providerID = driver.findElement(By.xpath(locator)).getText();
        Reports.log("Provider ID: " + providerID);
        javaWaitSec(2);
        return providerID;
    }


    /**
     * This method clicks on Request termination and submits the request
     */
    public void createTerminationRequest() {
        javaWaitSec(2);
        ajaxClick(PROVIDER_DASHBOARD_REQUEST_TERMINATION_LINK);
        Reports.log("Clicked On Request Termination link");
        javaWaitSec(2);
        String terminationEffectiveDate = Data.EFFECTIVE_DATE;
        fillInCalendar(getCurrentDate(), terminationEffectiveDate);
        Reports.log("Selected Effective Data:" + terminationEffectiveDate);

        ajaxClick(BUTTON_REASON_TERMINATION);
        clickAnyOptionInList(Data.PROVIDER_TERMINATION_REQUEST_REASON);
        Reports.log("Selected Reason Code" + Data.PROVIDER_TERMINATION_REQUEST_REASON);
        javaWaitSec(1);

        clickAnyButton(Data.TEXT_REQUEST_TERMINATION);
        Reports.log("Clicked on " + Data.TEXT_REQUEST_TERMINATION + " button");

        javaWaitSec(1);
        ajaxClick(spanContainsText(Data.TEXT_OK));
        Reports.log("Click Ok Button on Request Termination Confirmation popup");
        javaWaitSec(10);
        driver.navigate().refresh();
    }

    /**
     * This method gets provider ID
     *
     * @return
     */
    public String getProviderID() {
        javaWaitSec(4);
        String ID = driver.findElement(PROVIDER_ID).getText();
        Reports.log("Providers ID:" + ID);
        return ID;
    }

    /**
     * This method gets Termination Request ID
     *
     * @return
     */
    public String getTerminationOrRevalidationRequestID() {
        javaWaitSec(10);
        String ID = driver.findElement(TERMINATION_TRACKING_NUMBER).getText();
        Reports.log("Termination/Revalidation Tracking ID:" + ID);
        return ID;
    }


    /**
     * This method clicks Create Revalidation Button No Value
     */
    public void clicksOnCreateRevalidationButton() {
        ajaxClick(CREATE_REVALIDATION_BUTTON);
        Reports.log("Click on Create Revalidation button");
        javaWaitSec(5);
        driver.navigate().refresh();
        javaWaitSec(5);
    }


    /**
     * This method checks for green check mark on the enrollment sections for its completion
     *
     * @param section_name
     */

    public void verifyGreenCheckmarkForSection(String section_name) {
        javaWait(5);
        ajaxScroll(driver.findElement(By.xpath(String.format(".//span[contains(text(),section_name)]"))));
        if (!driver.findElement(By.xpath(String.format(LEFT_SIDE_CHECKMARK, section_name))).isDisplayed()) {
            Assert.fail("No Green checkmark found for the section");
            javaWaitSec(1);
        }
    }

    /**
     * This method verifies sections for Revalidation
     *
     * @param requestType
     */
    public void VerifyTabCheckMark(String[] sectionList, String requestType) {

        switch (requestType) {
            case Data.ENTITY_REVALIDATION:
                javaWaitSec(5);
                ajaxScroll(SECTION_PROVIDER_PROVIDER_AGREEMENT);
                ajaxClick(SECTION_PROVIDER_PROVIDER_AGREEMENT);
                javaWaitSec(5);
                ajaxScroll(SECTION_IDENTIFYING_INFORMATION);
                for (String section : sectionList) {
                    verifyGreenCheckmarkForSection(section);
                }
                Reports.log("Verification of all Entity Revalidation sections with green check mark has been completed successfully");
                break;

            case Data.TRADING_PARTNER_REVALIDATION:
                javaWaitSec(5);
                ajaxScroll(SECTION_PROVIDER_PROVIDER_AGREEMENT);
                ajaxClick(SECTION_PROVIDER_PROVIDER_AGREEMENT);
                javaWaitSec(5);
                ajaxScroll(SECTION_IDENTIFYING_INFORMATION);
                for (String section : sectionList) {
                    verifyGreenCheckmarkForSection(section);
                }
                Reports.log("Verification of all Trading Partner Revalidation sections with green check mark has been completed successfully");
                break;

            case Data.PEM_PROVIDER_REVALIDATION:
                javaWaitSec(5);
                ajaxScroll(SECTION_ADDRESS_DETAILS);
                By[] pemajaxClickList = {SECTION_ADDRESS_DETAILS, SECTION_UPLOAD_DOCUMENTS, SECTION_AFFILIATION, SECTION_SUMMARY};

                for (int i = 0; i < sectionList.length; i++) {
                    ajaxClick(pemajaxClickList[i]);
                    verifyGreenCheckmarkForSection(sectionList[i]);
                }
                Reports.log("Verification of all PEM Revalidation sections with green check mark has been completed successfully");
                break;

            case Data.BILLING_PROVIDER_REVALIDATION:
//                  javaWaitSec(5);
//                  ajaxScroll(SECTION_PCP_ADDENDUM);
//                  ajaxClick(SECTION_PCP_ADDENDUM);
                javaWaitSec(5);
                ajaxScroll(SECTION_PROVIDER_PROVIDER_AGREEMENT);
                ajaxClick(SECTION_PROVIDER_PROVIDER_AGREEMENT);
                javaWaitSec(5);
                ajaxScroll(SECTION_IDENTIFYING_INFORMATION);
                for (String section : sectionList) {
                    verifyGreenCheckmarkForSection(section);
                }
                Reports.log("Verification of all Billing Revalidation sections with green check mark has been completed successfully");
                break;
        }
    }

    public void verifyRevalidationMessage() {
        String revalidationMessage = driver.findElement(REVALIDATION_MESSAGE).getText();
        Reports.log("revalidation Message: " + revalidationMessage);
        softAssert.assertTrue(revalidationMessage.contains("3 months"));
        Reports.log("Verification of Re-validation message completed successfully");
        javaWaitSec(2);
    }

    /**
     * This method clicks on Add enrolls provider button
     */
    public void clickAddEnrollProviderButton() {
        ajaxClick(ADDAffiliation_ENROLLPROVIDER_BUTTON);
        Reports.log("Clicked on Enroll Provider Button");

    }

    public static final By BACKTOPORTAL_BUTTON = By.xpath("//span[contains(@class,'header_backtoportal')]");

    /**
     * This method clicks on Add enrolls provider button
     */
    public void clickOnBackToPortalButton() {
        ajaxClick(BACKTOPORTAL_BUTTON);
        javaWaitSec(1);
        Reports.log("Clicked on Enroll Provider Button");

    }

    /**
     * This method enters provider information popUp
     *
     * @param providerEmailID
     * @param firstName
     * @param lastName
     */
    public void fillInProviderInformationPopUp(String providerEmailID, String firstName, String lastName) {

        javaWaitSec(2);

        ajaxClick(NO_RADIOBTN_FOR_DO_YOU_HAVE_EMAILID);
        Reports.log("Do you have the Email-ID of the provider? 'No' Selected ");
        javaWaitSec(1);

//        Reports.log("Type Email: " + providerEmailID);
//        driver.findElement(PROVIDERINFO_POPUP_Email).sendKeys(providerEmailID);

        Reports.log("Type First Name: " + firstName);
        driver.findElement(PROVIDERINFO_POPUP_FirstName).sendKeys(firstName);

        Reports.log("Type Last Name: " + lastName);
        driver.findElement(PROVIDERINFO_POPUP_LastName).sendKeys(lastName);

        ajaxClick(PROVIDERINFO_POPUP_ProceedButton);
        Reports.log("Clicked on proceed button");
    }

    public static final By SEARCH_RESULTS = By.xpath("//div[contains(@class, 'tile-table-row')]");

    public void verifyAffiliatedProvidersStatus(String providerNameOrNPI, String providerInfoStatus, String enrollmentType) {

        driver.findElement(AFFILIATED_PROVIDER_NAME_OR_NPI_INPUT_SEARCH).sendKeys(providerNameOrNPI);
        ajaxClick(AFFILIATED_PROVIDER_SEARCH_BTN);
        javaWaitSec(2);
        WebElement enrollment = driver.findElements(SEARCH_RESULTS).get(0);
        enrollment.click();
        javaWaitSec(3);
        //Verify status displayed on Provider's dashboard
        if ((enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER) ||
                enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER_RECONSIDERATION) ||
                enrollmentType.equalsIgnoreCase(Data.PEM_PROVIDER_REVALIDATION) ||
                enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER) ||
                enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER_RECONSIDERATION) ||
                enrollmentType.equalsIgnoreCase(Data.TRADING_PARTNER_REVALIDATION))) {
            verifyProviderApplicationStatusIsAlt(providerInfoStatus);
        } else {
            VerifyProviderApplicationStatusIs(providerInfoStatus);
        }

    }
}