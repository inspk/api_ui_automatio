package com.dyp.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentTestListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String className = result.getTestClass().getName();
        String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Create ExtentTest for this test method
        ExtentTest extentTest = extent.createTest(testName);
        extentTest.assignCategory(className);
        
        // Add test details with timestamps and emojis
        extentTest.info(" Test Started: " + startTime);
        extentTest.info(" Test Class: " + className);
        extentTest.info(" Test Method: " + testName);
        extentTest.info(" Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        extentTest.info(" Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        
        // Log environment information
       // ExtentReportManager.logEnvironmentInfo();
        
        // Set the ExtentTest in ThreadLocal
        ExtentReportManager.setTest(extentTest);
        
        // Console output
        System.out.println("[" + startTime + "] 🚀 Starting test: " + testName + " in " + className);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest currentTest = ExtentReportManager.getTest();
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        long duration = result.getEndMillis() - result.getStartMillis();
        
        if (currentTest != null) {
            currentTest.log(Status.PASS, MarkupHelper.createLabel(" Test passed successfully", ExtentColor.GREEN));
            currentTest.info(" Test Duration: " + duration + "ms");
            currentTest.info(" Test Completed: " + endTime);
            currentTest.info(" Status: PASSED");
            
            // Add screenshot for successful tests
            ExtentReportManager.addScreenshot(result.getMethod().getMethodName());
        }
        
        // Console output
        System.out.println("[" + endTime + "]  Test PASSED: " + result.getMethod().getMethodName() + " (Duration: " + duration + "ms)");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest currentTest = ExtentReportManager.getTest();
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        long duration = result.getEndMillis() - result.getStartMillis();
        
        if (currentTest != null) {
            currentTest.log(Status.FAIL, MarkupHelper.createLabel(" Test failed", ExtentColor.RED));
            currentTest.info(" Test Duration: " + duration + "ms");
            currentTest.info(" Test Completed: " + endTime);
            currentTest.info(" Status: FAILED");
            
            // Log the full stack trace with better formatting
            if (result.getThrowable() != null) {
                currentTest.fail(" Error Details:");
                currentTest.fail("🔍 Error Message: " + result.getThrowable().getMessage());
                currentTest.fail("📚 Stack Trace:");
                currentTest.fail(result.getThrowable());
            }
            
            // Add screenshot for failed tests
            ExtentReportManager.addScreenshot(result.getMethod().getMethodName());
        }
        
        // Console output
        System.out.println("[" + endTime + "]  Test FAILED: " + result.getMethod().getMethodName() + " (Duration: " + duration + "ms)");
        if (result.getThrowable() != null) {
            System.out.println("[" + endTime + "]  Error: " + result.getThrowable().getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest currentTest = ExtentReportManager.getTest();
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        long duration = result.getEndMillis() - result.getStartMillis();
        
        if (currentTest != null) {
            currentTest.log(Status.SKIP, MarkupHelper.createLabel("⏭ Test skipped", ExtentColor.YELLOW));
            currentTest.info(" Test Duration: " + duration + "ms");
            currentTest.info(" Test Completed: " + endTime);
            currentTest.info(" Status: SKIPPED");
            
            if (result.getThrowable() != null) {
                currentTest.skip(" Skip Reason: " + result.getThrowable().getMessage());
            }
        }
        
        // Console output
        System.out.println("[" + endTime + "] ⏭ Test SKIPPED: " + result.getMethod().getMethodName() + " (Duration: " + duration + "ms)");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentTest currentTest = ExtentReportManager.getTest();
        if (currentTest != null) {
            currentTest.log(Status.WARNING, MarkupHelper.createLabel(" Test failed but within success percentage", ExtentColor.ORANGE));
        }
    }

    @Override
    public void onStart(ITestContext context) {
        String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Console output
        System.out.println("[" + startTime + "]  Starting Test Suite: " + context.getName());
        System.out.println(" Report will be generated at: " + ExtentReportManager.getCurrentReportPath());
        System.out.println(" Screenshots will be saved at: " + ExtentReportManager.getScreenshotPath());
    }

    @Override
    public void onFinish(ITestContext context) {
        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Console output
        System.out.println("[" + endTime + "]  Test Suite Completed: " + context.getName());
        System.out.println(" Test Summary:");
        System.out.println("    Passed: " + context.getPassedTests().size());
        System.out.println("    Failed: " + context.getFailedTests().size());
        System.out.println("   ⏭ Skipped: " + context.getSkippedTests().size());
        
        // Flush the report
        ExtentReportManager.flush();
    }
} 