package com.dyp.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String reportPath;
    private static String screenshotPath;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Create date-based report directory
            String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
            
            // Create reports directory if it doesn't exist
            File reportsDir = new File("test-output/reports/" + currentDate);
            if (!reportsDir.exists()) {
                reportsDir.mkdirs();
            }
            
            // Create screenshots directory
            File screenshotsDir = new File("test-output/screenshots/" + currentDate);
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }
            
            // Create report file with date and time
            String reportFileName = "ExtentReport_" + currentDate + "_" + currentTime + ".html";
            reportPath = "test-output/reports/" + currentDate + "/" + reportFileName;
            screenshotPath = "test-output/screenshots/" + currentDate + "/";
            
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            
            // Enhanced configuration
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("DYP FL 2.0 API Test Report - " + currentDate);
            spark.config().setReportName("API Automation Test Results - " + currentDate + " " + currentTime);
            spark.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
            
            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            // Enhanced system information
            extent.setSystemInfo("OS", System.getProperty("os.name") + " " + System.getProperty("os.version"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Environment", System.getProperty("test.environment", "dev01"));
            extent.setSystemInfo("Test Date", currentDate);
            extent.setSystemInfo("Test Time", currentTime);
            extent.setSystemInfo("Report Generated", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            extent.setSystemInfo("Framework", "DYP FL 2.0 API Automation");
            extent.setSystemInfo("Browser", "REST Assured");
            extent.setSystemInfo("Test Tool", "TestNG + ExtentReports");
            
            System.out.println("ExtentReport will be generated at: " + reportPath);
            System.out.println("Screenshots will be saved at: " + screenshotPath);
        }
        return extent;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static void logRequest(String method, String url, String headers, String body) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.info(MarkupHelper.createLabel("=== REQUEST DETAILS [" + timestamp + "] ===", ExtentColor.BLUE));
            currentTest.info("Method: " + method);
            currentTest.info("URL: " + url);
            if (headers != null && !headers.isEmpty()) {
                currentTest.info("Headers: " + headers);
            }
            if (body != null && !body.isEmpty()) {
                currentTest.info("Body: " + body);
            }
        }
    }

    public static void logResponse(int statusCode, String responseBody, long responseTime) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.info(MarkupHelper.createLabel("=== RESPONSE DETAILS [" + timestamp + "] ===", ExtentColor.GREEN));
            currentTest.info("Status Code: " + statusCode);
            currentTest.info("Response Time: " + responseTime + "ms");
            if (responseBody != null && !responseBody.isEmpty()) {
                // Truncate long response bodies for better readability
                String truncatedBody = responseBody.length() > 1000 ? 
                    responseBody.substring(0, 1000) + "... [truncated]" : responseBody;
                currentTest.info("Response Body: " + truncatedBody);
            }
        }
    }

    public static void logInfo(String message) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.info("[" + timestamp + "] " + message);
        }
    }

    public static void logPass(String message) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.pass("[" + timestamp + "] " + message);
        }
    }

    public static void logFail(String message) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.fail("[" + timestamp + "] " + message);
        }
    }

    public static void logWarning(String message) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.warning("[" + timestamp + "] " + message);
        }
    }

    public static void logError(String message, Throwable throwable) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            currentTest.fail("[" + timestamp + "] " + message);
            if (throwable != null) {
                currentTest.fail(throwable);
            }
        }
    }

    public static void addScreenshot(String testName) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            try {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
                String screenshotName = testName + "_" + timestamp + ".png";
                String screenshotPath = ExtentReportManager.screenshotPath + screenshotName;
                
                // Create a simple HTML screenshot placeholder
                String screenshotHtml = "<div style='background-color: #f0f0f0; padding: 20px; border: 1px solid #ccc;'>" +
                    "<h4>Screenshot: " + screenshotName + "</h4>" +
                    "<p>Captured at: " + timestamp + "</p>" +
                    "<p>Path: " + screenshotPath + "</p>" +
                    "<div style='background-color: white; padding: 10px; border: 1px solid #ddd;'>" +
                    "<p><strong>API Response Screenshot</strong></p>" +
                    "<p>This would contain the actual screenshot in a real browser automation scenario.</p>" +
                    "</div></div>";
                
                currentTest.info("Screenshot captured: " + screenshotName);
                currentTest.info(screenshotHtml);
                
            } catch (Exception e) {
                currentTest.warning("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    public static void logTestData(String testData) {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            currentTest.info(MarkupHelper.createLabel("=== TEST DATA ===", ExtentColor.ORANGE));
            currentTest.info("Test Data: " + testData);
        }
    }
    
    public static String getCurrentReportPath() {
        return reportPath;
    }

    public static String getScreenshotPath() {
        return screenshotPath;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
            System.out.println("ExtentReport generated at: " + reportPath);
            System.out.println("Screenshots saved at: " + screenshotPath);
        }
    }
} 