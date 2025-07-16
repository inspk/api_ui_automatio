package com.hhstechgroup.tests.base;

import com.aventstack.extentreports.ExtentTest;
import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.*;
import com.hhstechgroup.common.EnrollmentFormElements;
import com.hhstechgroup.internal_user.*;
import com.hhstechgroup.provider.EnrollmentPageProvider;
import com.hhstechgroup.provider.ProviderPortal;
import com.hhstechgroup.tests.SouthDakota.Regression.ProviderIndicators.ProviderIndicatorTestIndividual;
import com.hhstechgroup.tests.SouthDakota.Regression.RateSetting;
import com.hhstechgroup.utility.CsvFileReading;
import com.hhstechgroup.utility.ExcelFileReading;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.*;

/**
 * This class initializes the whole environment and settings for which other classes are derived.
 */
public class BaseClassUI {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected EnrollmentPageInternalUser enrollmentPageInternalUser;
    protected AdditionalActions additionalActions;
    protected EnrollmentDetails enrollmentDetails;
    protected MainTabs mainTabs;
    protected InboxIU inboxIU;
    protected MyAccountIU myAccountIU;
    protected SystemOptionsIE systemOptionsIE;

    protected EnrollmentPageProvider enrollmentPageProvider;
    protected ProviderPortal providerPortal;
    protected Coc coc;
    protected EnrollmentsAndCoc enrollmentsAndCoc;
    protected ProviderDetails providerDetails;
    protected Login login;
    protected Email email;
    protected SiteVisits siteVisits;
    protected CalendarPopUp calendarPopUp;
    protected ExcelFileReading excelFileReading;
    protected CsvFileReading csvFileReading;

    protected ExcelWrite excelWrite;
    protected SoftAssert softAssert = new SoftAssert();
    public SDHomePage sdhomePage;
    protected ProviderRegistrationPage providerRegistrationPage;
    protected LandingPage landingPage;
    protected DashboardPage dashboardPage;
    protected ProviderEnrollingPage providerEnrollingPage;
    protected LoginPage loginPage;
    protected ProvidersPage providersPage;
    protected CocsPage cocPage;
    protected IUMCOPage IUMCOPage;
    protected RateSetting RateSetting;

    protected ReconsiderationPage reconsiderationPage;
    protected AuditPage auditPage;
    protected IUEnrollmentPage iuEnrollmentPage;
    protected SiteVisitsPage siteVisitsPage;
    protected Reports Reports;
    protected String internalUserEmail;
    protected String internalUserPassword;
    protected String environmentUrl;
    protected String emailPrefix;
    protected String providerEmail;
    protected String providerPassword;

    protected String CVOReviewCommitteeEmail;
    protected String CVOReviewCommitteePassword;

    protected String filePath = "LoginTestData.xlsx"; // excel sheet file path
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    protected String filePathCsv = "LoginTestData.csv"; // csv file path
    protected String taxonomiesListSheet = "FinalizedTaxonomiesList.xlsx";

    protected String iuEmail;
    protected String iuPassword;
    protected String applicationUrl;
    protected String environment;
    protected String providerEmailPrefix;
    protected String providerEmailPassword;
    protected String regressionEmailPrefix;
    public static ExtentTest test;
    protected SystemOptions systemOptions;
    protected CreateOrRegisterNewProviderAccount createProviderAccount;
    protected RequestSubmission requestSubmission;
    protected ApproveOrDenyAnEnrollment approveOrDenyAnEnrollment;
    protected RequestStatusChange requestStatusChange;
    protected VerifyConfiguration verifyConfiguration;
    public static EnrollmentFormElements enrollmentFormElements;
    protected ProviderIndicatorPage providerIndicatorpage;

    protected AddAlternateIdentifierPage addAlternateIdentifierPage;
    protected EditAlternateIdentifierPage editAlternateIdentifier;
    protected FloridaMedicaidProviderIDEnrollmentPage floridaMedicaidProviderIDEnrollment;
    protected FloridaMedicaidProviderIDProviderPage floridaMedicaidProviderIDProvider;

    protected CredentialingPage credentialingPage;
    public static Map<String, String> addElements = new HashMap<String, String>();
    public String screeningType;

    /**
     * This method retrieves the environment and login data from LoginTestData.xlsx and will be executed
     * before first @Test method execution.
     * @param testEnvironment
     * @throws IOException
     */
    @BeforeClass
    @Parameters({"environment"})
    public void init(@Optional("SD") String testEnvironment) throws IOException {
        excelFileReading = new ExcelFileReading(filePath, 0);
        csvFileReading = new CsvFileReading(filePathCsv);
//        getLoginDetails(testEnvironment);
        getLoginDetailsFromCsv(testEnvironment);
        this.internalUserEmail = iuEmail;
        this.internalUserPassword = iuPassword;
        this.environmentUrl = applicationUrl;
        this.providerEmail = providerEmailPrefix;
        this.providerPassword = providerEmailPassword;
        this.emailPrefix = emailPrefix;
    }

    /**
     * This method sets up the browser, screenWidth, screenHeight and will be executed before
     * every @Test annotated method.
     *
     * @param browser
     * @param hubUrl
     * @param screenWidth
     * @param screenHeight
     * @param method
     * @throws IOException
     */
    @BeforeMethod
    @Parameters({"browser", "hubUrl", "screenWidth", "screenHeight", "screening"})
    public void setup(
            @Optional("chrome") String browser,
            @Optional("http://172.31.8.228:4444/wd/hub") String hubUrl,
            @Optional("Maximum") String screenWidth,
            @Optional("Maximum") String screenHeight,
            @Optional("API") String screening,
            Method method) throws IOException {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            Reports.log("Open Firefox");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {

            Reports.log("Open Chrome");
            System.out.println("User Dir:" + System.getProperty("user.dir"));
            Map<String, Object> prefs = new HashMap<String, Object>();
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
           System.setProperty("webdriver.chrome.driver", "C:/Automation/DYP_FL_Automation/acceptance-tests/Driver/chromedriver.exe");

            // Set the notification setting it will override the default setting
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("prefs", prefs);

            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("navigator.web-driver", false);

            prefs.put("download.prompt_for_download", "false");
            prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "DownloadFolder");
            prefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});

            // Set the experimental option
            options.setExperimentalOption("prefs", prefs);

            //options.addArguments("--user-data-dir=/home/{username}/.config/google-chrome");
            //load default profile
            //  options.addArguments("--profile-directory=Default");
            // Printing set download directory
            options.addArguments("--disable-web-security");
            options.addArguments("--remote-allow-origins=*");

            options.addArguments("--whitelisted-ips", "--no-sandbox", "--disable-extensions", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-popup-blocking", "--allow-running-insecure-content");
            driver = new ChromeDriver(options);
            driver.get("chrome://settings/clearBrowserData");
        } else if (browser.equalsIgnoreCase("remote")) {
            Reports.log("Connect to remote HUB");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--whitelisted-ips", "--no-sandbox", "--disable-extensions", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
            driver = new RemoteWebDriver(new URL(hubUrl), options);
            driver.get("chrome://settings/clearBrowserData");
        } else {
            Reports.log("Launching the Browser.....");
            Map<String, Object> prefs = new HashMap<String, Object>();
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // Set the notification setting it will override the default setting

            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("download.prompt_for_download", "false");
            prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "DownloadFolder");
            // disable flash and the PDF viewer
            prefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});
            // Set the experimental option
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-popup-blocking", "--allow-running-insecure-content", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--whitelisted-ips", "--no-sandbox", "--disable-extensions");
            driver = new ChromeDriver(options);
            driver.get("chrome://settings/clearBrowserData");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        homePage = new HomePage(driver, wait);
        sdhomePage = new SDHomePage(driver, wait);
        enrollmentPageInternalUser = new EnrollmentPageInternalUser(driver, wait);
        additionalActions = new AdditionalActions();
        enrollmentDetails = new EnrollmentDetails(driver, wait);
        mainTabs = new MainTabs(driver, wait);
        inboxIU = new InboxIU(driver, wait);
        myAccountIU = new MyAccountIU(driver, wait);
        systemOptionsIE = new SystemOptionsIE(driver, wait);
        providerPortal = new ProviderPortal(driver, wait);
        coc = new Coc(driver, wait);
        enrollmentsAndCoc = new EnrollmentsAndCoc(driver, wait);
        providerDetails = new ProviderDetails(driver, wait);
        login = new Login(driver, wait);
        email = new Email(driver, wait);
        enrollmentPageProvider = new EnrollmentPageProvider(driver, wait);
        siteVisits = new SiteVisits(driver, wait);
        calendarPopUp = new CalendarPopUp(driver, wait);
        providerRegistrationPage = new ProviderRegistrationPage(driver, wait);
        dashboardPage = new DashboardPage(driver, wait);
        landingPage = new LandingPage(driver, wait);
        providerEnrollingPage = new ProviderEnrollingPage(driver, wait);
        reconsiderationPage = new ReconsiderationPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        providersPage = new ProvidersPage(driver, wait);
        cocPage = new CocsPage(driver, wait);
        auditPage = new AuditPage(driver, wait);
        iuEnrollmentPage = new IUEnrollmentPage(driver, wait);
        siteVisitsPage = new SiteVisitsPage(driver, wait);
        systemOptions = new SystemOptions(driver, wait);
        createProviderAccount = new CreateOrRegisterNewProviderAccount(driver, wait);
        approveOrDenyAnEnrollment = new ApproveOrDenyAnEnrollment(driver, wait);
        enrollmentFormElements = new EnrollmentFormElements(driver, wait);

        addAlternateIdentifierPage = new AddAlternateIdentifierPage(driver,wait);
        editAlternateIdentifier = new EditAlternateIdentifierPage(driver,wait);
        floridaMedicaidProviderIDEnrollment= new FloridaMedicaidProviderIDEnrollmentPage(driver,wait);
        floridaMedicaidProviderIDProvider= new FloridaMedicaidProviderIDProviderPage(driver,wait);
        credentialingPage=new CredentialingPage(driver,wait);
        IUMCOPage = new IUMCOPage(driver,wait);
        providerIndicatorpage =new  ProviderIndicatorPage(driver,wait);


        //FOR REQUEST FACTORY PROOF OF CONCEPT
        //  enrollmentSubmission = new EnrollmentSubmission(driver, wait);
        requestSubmission = new RequestSubmission(driver, wait);
        requestStatusChange = new RequestStatusChange(driver, wait);
        verifyConfiguration = new VerifyConfiguration(driver, wait);
        screeningType = screening;

        /*SET SCREEN SIZE*/
        if (screenWidth.equalsIgnoreCase("Maximum") || screenHeight.equalsIgnoreCase("Maximum")) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(Integer.valueOf(screenWidth), Integer.valueOf(screenHeight)));
        }
        Reports.log("Load URL: " + environmentUrl);
        driver.get(environmentUrl);
    }

    /**
     * This method retrieves the data from LoginTestData.xlsx. It prints out the data related to
     * specific environment which passes to the method.
     *
     * @param env
     * @throws IOException
     */
    public void getLoginDetails(String env) throws IOException {
        List<String> excelData = excelFileReading.getExcelAsArray(env);
        for (int i = 0; i < excelData.size(); i++) {
            //System.out.println(excelData.get(i));
            if (i == 0) {
                environment = excelData.get(i);
                System.out.println("Environment : " + environment);
            }
            if (i == 1) {
                iuEmail = excelData.get(i);
                System.out.println("UserEmail :" + iuEmail);
            }
            if (i == 2) {
                iuPassword = excelData.get(i);
                System.out.println("Password : " + iuPassword);
            }
            if (i == 3) {
                applicationUrl = excelData.get(i);
                applicationUrl = applicationUrl.replaceAll("\\s", "");
                System.out.println("Testing URl : " + applicationUrl);
            }
            if (i == 4) {
                providerEmailPrefix = excelData.get(i);
                System.out.println("Provider Email Prefix : " + providerEmailPrefix);
            }
            if (i == 5) {
                providerEmailPassword = excelData.get(i);
                System.out.println("Provider Password : " + providerEmailPassword);
            }
            if (i == 6) {
                regressionEmailPrefix = excelData.get(i);
                System.out.println("Regression Email Prefix : " + regressionEmailPrefix);
            }
        }
    }

    /**
     * This method retrieves the data from DataFiles/Login.csv It prints out the data related to
     * specific environment which passes to the method.
     *
     * @param env
     * @throws IOException
     */
    public void getLoginDetailsFromCsv(String env) throws IOException {
                List<String> row = csvFileReading.getCsvAsArray(env);
                for (int i = 0; i < row.size() ; i++) {
                    if (i == 0) {
                        environment = row.get(i);
                        System.out.println("Environment : " + environment);
                    }
                    if (i == 1) {
                        iuEmail = row.get(i);
                        System.out.println("UserEmail :" + iuEmail);
                    }
                    if (i == 2) {
                        iuPassword = row.get(i);
                        System.out.println("Password : " + iuPassword);
                    }
                    if (i == 3) {
                        applicationUrl = row.get(i);
                        applicationUrl = applicationUrl.replaceAll("\\s", "");
                        System.out.println("Testing URl : " + applicationUrl);
                    }
                    if (i == 4) {
                        providerEmailPrefix = row.get(i);
                        System.out.println("Provider Email Prefix : " + providerEmailPrefix);
                    }
                    if (i == 5) {
                        providerEmailPassword = row.get(i);
                        System.out.println("Provider Password : " + providerEmailPassword);
                    }
                    if (i == 6) {
                        regressionEmailPrefix = row.get(i);
                        System.out.println("Regression Email Prefix : " + regressionEmailPrefix);
                    }
                }
                System.out.println(row);
            }

    /**
     * This method clears all the data from ProviderInfo.xlsx and it will be run before the execution
     * of all the test cases.
     *
     * @throws IOException
     */
//    @BeforeSuite
    public void clearProviderInfoData() throws IOException {
        System.out.println("clearing Provider Info Data....");
        FileInputStream fis = new FileInputStream(providerInfoSheet);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRows = sheet.getLastRowNum();
        if (numberOfRows > 0) {
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                if (sheet.getRow(i) != null) {
                    sheet.removeRow(sheet.getRow(i));
                } else {
                    System.out.println("Info: clean sheet='" + sheet.getSheetName() + "' ... skip line: " + i);
                }
            }
            System.out.println("All the rows are deleted successfully");
        } else {
            System.out.println("Info: clean sheet='" + sheet.getSheetName() + "' ... is empty");
        }
        fis.close();
        FileOutputStream outFile = new FileOutputStream(providerInfoSheet);
        workbook.write(outFile);
        outFile.close();
    }

    /**
     * This method logs any test which stops and will be invoked after the execution of each test method
     */
    @AfterMethod
    public void tearDownWebDriver() {
       // driver.quit();
        Reports.stop();
    }


    /**
     * This method logs the result of tests and takes screenshots if any failed test and will be invoked
     * after the execution of each test method
     *
     * @param result
     * @throws Throwable
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Throwable {
       Reports.getResult(result);
        if (ITestResult.FAILURE == result.getStatus()) {
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/TestResults";
                File destFile = new File((String) reportDirectory+"/failureScreenshots/"+Helper.getCurrentDatestamp()+"/"+
                        result.getName()+Helper.getCurrentTimestamp() + ".png");
                FileUtils.copyFile(source, destFile);
                Reports.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
                System.out.println("Screenshot taken for failure test");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}

