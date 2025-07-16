package com.hhstechgroup.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hhstechgroup.utility.CsvFileReading;
import com.hhstechgroup.utility.ExcelFileReading;
import com.hhstechgroup.utility.Helper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.hhstechgroup.common.BaseActions.*;
import static com.hhstechgroup.common.BaseActions.getCurrentDate;

/**
 * Reports class is used to generate HTML reports.
 */
public class Reports  extends BaseActions {
    private static final boolean jenkinsOption = true;
    public static ExtentHtmlReporter htmlReporter;

    public static ExtentReports extent;
    private static ExtentTest currentTest;
    private static String lastAction;
    private static final String ROOT_PATH = "TestResults/";
    private static String currentTestSuiteResultsPath;
    private static String environment  ;


    static {
        createReportFolder();
        createDownloadFolder();
        LocalDateTime ldt = LocalDateTime.now();
        String formatttedDate = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        if (jenkinsOption) {
            currentTestSuiteResultsPath = "Automation Test Results/";
        } else {
            currentTestSuiteResultsPath = "Automation Test Results " + formatttedDate + "/";
        }

//        new File(ROOT_PATH + currentTestSuiteResultsPath).mkdir();
//        htmlReporter = new ExtentHtmlReporter(ROOT_PATH + currentTestSuiteResultsPath + "report.html");

        String extentReportName = ROOT_PATH + Helper.getCurrentTimestamp() + "_TestReports.html";
        //   + "_RegressionTestReport.html";
        htmlReporter = new ExtentHtmlReporter(extentReportName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", "Windows 10 Enterprise");
        extent.setSystemInfo("Host Name", "UserLocalMachine");
     //   extent.setSystemInfo("Environment", "TST");
        extent.setSystemInfo("Environment", environment);

        extent.setSystemInfo("User Name", "LocalUser");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Provider Application Automation Results Report");
        htmlReporter.config().setReportName("Automation Test Results Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.getTestList();
    }

    public Reports(WebDriver driver, WebDriverWait wait) {
    }

    /**
     * This method is called when any test starts
     *
     * @param testName
     */
    public static void start(String testName) {
        currentTest = extent.createTest(testName);
    }

    /**
     * This method is called when any test stops
     */
    public static void stop() {
        extent.flush();
    }

    /**
     * This method logs the status of each test step onto the HTML report being generated
     *
     * @param message
     */
    public static void log(String message) {
        currentTest.log(Status.PASS, message);
        System.out.println(message);
        lastAction = message;
    }

    /**
     * This method is called on the failure of any test
     *
     * @param driver
     * @param methodName
     */
    public static void fail(WebDriver driver, String methodName) {
        try {
            currentTest.fail("Failed step: " + lastAction);
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dstpath = Paths.get(ROOT_PATH + currentTestSuiteResultsPath + "fail_" + methodName + ".png");
            Files.copy(imageFile.toPath(), dstpath, StandardCopyOption.REPLACE_EXISTING);
            currentTest.addScreenCaptureFromPath(dstpath.toFile().getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * This method creates report folder
     */
    public static void createReportFolder() {
        Path path = Paths.get("TestResults");
        //if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
    }

    /**
     * This method create Download Folder
     */
    public static void createDownloadFolder() {
        Path downloadPath = Paths.get("DownloadFolder");
        //if directory exists?
        if (!Files.exists(downloadPath)) {
            try {
                Files.createDirectories(downloadPath);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
        Path screeningProofDocPath = Paths.get(downloadPath + File.separator + "ProofDocuments");
        //if directory exists?
        if (!Files.exists(screeningProofDocPath)) {
            try {
                Files.createDirectories(screeningProofDocPath);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }
    }

    /**
     * This method gets results of a test
     *
     * @param result
     * @throws Throwable
     */
    public static void getResult(ITestResult result) throws Throwable {

        if (result.getStatus() == ITestResult.FAILURE) {
            currentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            currentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            currentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            currentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.YELLOW));
            currentTest.skip(result.getThrowable());
        }
    }

    @Parameters({"environment"})
    public static void getTestEnvironment(@Optional("SD") String testEnvironment) throws IOException {
      environment = testEnvironment ;
    }

}
