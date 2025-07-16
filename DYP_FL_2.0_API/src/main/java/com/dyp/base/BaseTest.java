package com.dyp.base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.JsonNode;

public class BaseTest {
    protected static Properties config;
    protected static String currentEnvironment;
    protected static String baseUrl;
    protected static String currentPodName;


    private static boolean isInitialized = false;

    @BeforeSuite
    public void setup() throws IOException {
        initializeConfiguration();
    }

    @BeforeClass
    public void setupClass() throws IOException {
        // Ensure configuration is initialized for individual test classes
        if (!isInitialized) {
            initializeConfiguration();
        }
    }

    @AfterClass
    public void cleanupClass() {
        // No longer needed: tokens are now cleared after each test method
        logTestInfo("Test class cleanup completed");
    }

    @AfterMethod
    public void afterMethod() {
        // Clear tokens after each test
        AuthUtil.clearTokens();
    }

    private void initializeConfiguration() throws IOException {
        if (isInitialized) {
            return;
        }

        config = new Properties();
        config.load(BaseTest.class.getClassLoader().getResourceAsStream("config/base_config.properties"));
        
        // Get current environment and base URL
        currentEnvironment = AuthUtil.getCurrentEnvironment(config);
        baseUrl = AuthUtil.getBaseUrl(config);
        
        // Configure REST Assured with response logging
        useRelaxedHTTPSValidation();
        RestAssured.filters(new ResponseLoggingFilter());
        
        isInitialized = true;
    }

    @BeforeMethod
    public void beforeMethod() {
        // Validate tokens before each test
        validateTokensBeforeTest();
    }

    /**
     * Validate tokens before test execution
     */
    private void validateTokensBeforeTest() {
        // No longer needed: tokens are now managed by AuthUtil's thread-local
    }

    /**
     * Setup method for POD-specific test classes
     * This should be called in @BeforeClass of each POD test class
     */
    protected void setupPodTestData(String podName) {
        try {
            currentPodName = podName;
            TestDataUtil.loadTestData(podName);
        } catch (Exception e) {
            logTestFail("Failed to load test data for POD " + podName + ": " + e.getMessage());
            throw new RuntimeException("Test data setup failed", e);
        }
    }

    /**
     * Get token based on user type with validation
     */
    protected String getToken(String userType)
    {
        String token = null;
        
        if ("internal".equalsIgnoreCase(userType) || "iu".equalsIgnoreCase(userType)) {
            token = AuthUtil.getInternalToken(config);
        } else if ("provider".equalsIgnoreCase(userType) || "pu".equalsIgnoreCase(userType)) {
            token = AuthUtil.getProviderToken(config);
        } else {
            throw new IllegalArgumentException("Invalid user type: " + userType + ". Use 'internal'/'iu' or 'provider'/'pu'");
        }

        // Final validation before returning token
        if (!AuthUtil.validateTokenForUse(token)) {
            throw new RuntimeException("Token validation failed for user type: " + userType);
        }

        return token;
    }

    protected String getCurrentEnvironment() {
        return currentEnvironment;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Helper method to log test information
     */
    protected void logTestInfo(String message) {
        ExtentReportManager.logInfo(message);
    }

    /**
     * Helper method to log test success
     */
    protected void logTestPass(String message) {
        ExtentReportManager.logPass(message);
    }

    /**
     * Helper method to log test failure
     */
    protected void logTestFail(String message) {
        ExtentReportManager.logFail(message);
    }

    /**
     * Helper method to log test warning
     */
    protected void logTestWarning(String message) {
        ExtentReportManager.logWarning(message);
    }

    /**
     * Helper method to log test data information
     */
    protected void logTestDataInfo(String apiName) {
        try {
            String feature = TestDataUtil.getFeature(apiName);
            String description = TestDataUtil.getDescription(apiName);
            
            logTestInfo("API Feature: " + feature);
            logTestInfo("Description: " + description);
            
        } catch (Exception e) {
            logTestFail("Failed to log test data info for API " + apiName + ": " + e.getMessage());
        }
    }

    /**
     * Helper method to validate test data before test execution
     */
    protected void validateTestData(String apiName) {
        try {
            TestDataUtil.validateTestData(apiName);
            logTestInfo("Test data validation passed for API: " + apiName);
        } catch (Exception e) {
            logTestFail("Test data validation failed for API " + apiName + ": " + e.getMessage());
            throw e;
        }
    }

    /**
     * Helper method to get user type from POD name
     */
    protected String getUserTypeFromPod(String podName) {
        if (podName.contains("PU")) {
            return "provider";
        } else if (podName.contains("IU")) {
            return "internal";
        } else if (podName.contains("SystemConfiguration")) {
            return "internal"; // System configuration uses internal user
        } else
        {
            throw new IllegalArgumentException("Cannot determine user type from POD name: " + podName);
        }
    }

    /**
     * Helper method to get base path from POD name
     */
    protected String getBasePathFromPod(String podName) {
        if (podName.contains("PU")) {
            return "/api/provider-api/v1";
        } else if (podName.contains("IU")) {
            return "/api/internal-user-api/v1";
        } else if (podName.contains("SystemConfiguration")) {
            return "/api/system-configuration/v1"; // System configuration API path
        } else {
            throw new IllegalArgumentException("Cannot determine base path from POD name: " + podName);
        }
    }
} 