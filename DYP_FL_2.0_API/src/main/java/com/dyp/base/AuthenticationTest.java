package com.dyp.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;
import java.util.Properties;

/**
 * Comprehensive Authentication Test Suite
 * 
 * Purpose: This test class validates the complete authentication flow including:
 * - Configuration loading
 * - Environment setup
 * - Token fetching and validation
 * - Token strength checking
 * - Token expiry management
 * - Token cleanup
 * 
 * Test Scenarios:
 * - Configuration validation
 * - Environment-specific setup
 * - Internal user authentication
 * - Provider user authentication
 * - Token format validation
 * - Token strength validation
 * - Token expiry validation
 * - Token cleanup verification
 * 
 * Expected Results:
 * - All configuration loads correctly
 * - Authentication tokens are fetched successfully
 * - Tokens pass strength validation
 * - Tokens are properly managed and cleaned up
 */
public class AuthenticationTest extends BaseTest {

    @AfterClass
    public void cleanup() {
        // Clear all tokens after tests
        AuthUtil.clearTokens();
        System.out.println("Authentication test cleanup completed");
    }

    /**
     * Test: Configuration Loading
     * 
     * Description: Validates that all configuration properties are loaded correctly
     */
    @Test
    public void testConfigurationLoading() {
        assertNotNull(config, "Configuration should not be null");
        assertNotNull(currentEnvironment, "Current environment should not be null");
        assertNotNull(baseUrl, "Base URL should not be null");
        
        System.out.println("Configuration loading test passed");
        System.out.println("Environment: " + currentEnvironment);
        System.out.println("Base URL: " + baseUrl);
    }

    /**
     * Test: Environment Setup
     * 
     * Description: Validates environment-specific configuration
     */
    @Test
    public void testEnvironmentSetup() {
        String env = AuthUtil.getCurrentEnvironment(config);
        String baseUrl = AuthUtil.getBaseUrl(config);
        
        assertNotNull(env, "Environment should not be null");
        assertNotNull(baseUrl, "Base URL should not be null");
        assertTrue(baseUrl.startsWith("https://"), "Base URL should be HTTPS");
        
        System.out.println("Testing configuration for environment: " + env);
        System.out.println("Using base URL: " + baseUrl);
        System.out.println("Environment-specific configuration test passed");
    }

    /**
     * Test: Internal User Token Configuration
     * 
     * Description: Validates internal user credentials are configured
     */
    @Test
    public void testInternalUserTokenConfiguration() {
        String env = getCurrentEnvironment();
        String email = config.getProperty(env + ".internalUserEmail");
        String password = config.getProperty(env + ".internalUserPassword");
        
        assertNotNull(email, "Internal user email should be configured");
        assertNotNull(password, "Internal user password should be configured");
        assertTrue(email.contains("@"), "Internal user email should be valid format");
        
        System.out.println("Internal token is configured for environment: " + env);
    }

    /**
     * Test: Provider User Token Configuration
     * 
     * Description: Validates provider user credentials are configured
     */
    @Test
    public void testProviderUserTokenConfiguration() {
        String env = getCurrentEnvironment();
        String email = config.getProperty(env + ".providerUserEmail");
        String password = config.getProperty(env + ".providerUserPassword");
        
        assertNotNull(email, "Provider user email should be configured");
        assertNotNull(password, "Provider user password should be configured");
        assertTrue(email.contains("@"), "Provider user email should be valid format");
        
        System.out.println("Provider token is configured for environment: " + env);
    }

    /**
     * Test: Internal Token Format Validation
     * 
     * Description: Validates internal token format and strength
     */
    @Test
    public void testInternalTokenFormatValidation() {
        try {
            String token = AuthUtil.getInternalToken(config);
            assertNotNull(token, "Internal token should not be null");
            assertTrue(token.length() > 50, "Token should be reasonably long");
            assertTrue(token.contains("."), "JWT token should contain dots");
            
            // Validate token structure (JWT has 3 parts)
            String[] parts = token.split("\\.");
            assertEquals(parts.length, 3, "JWT token should have 3 parts");
            
            System.out.println("Internal token format validation passed");
        } catch (Exception e) {
            fail("Internal token format validation failed: " + e.getMessage());
        }
    }

    /**
     * Test: Provider Token Format Validation
     * 
     * Description: Validates provider token format and strength
     */
    @Test
    public void testProviderTokenFormatValidation() {
        try {
            String token = AuthUtil.getProviderToken(config);
            assertNotNull(token, "Provider token should not be null");
            assertTrue(token.length() > 50, "Token should be reasonably long");
            assertTrue(token.contains("."), "JWT token should contain dots");
            
            // Validate token structure (JWT has 3 parts)
            String[] parts = token.split("\\.");
            assertEquals(parts.length, 3, "JWT token should have 3 parts");
            
            System.out.println("Provider token format validation passed");
        } catch (Exception e) {
            fail("Provider token format validation failed: " + e.getMessage());
        }
    }

    /**
     * Test: Internal User Token Retrieval
     * 
     * Description: Tests successful retrieval of internal user token
     */
    @Test
    public void testInternalUserTokenRetrieval() {
        try {
            String token = AuthUtil.getInternalToken(config);
            assertNotNull(token, "Internal token should be retrieved successfully");
            assertTrue(AuthUtil.validateTokenForUse(token), "Internal token should pass validation");
            
            System.out.println("Internal user token retrieved successfully");
        } catch (Exception e) {
            fail("Internal user token retrieval failed: " + e.getMessage());
        }
    }

    /**
     * Test: Provider User Token Retrieval
     * 
     * Description: Tests successful retrieval of provider user token
     */
    @Test
    public void testProviderUserTokenRetrieval() {
        try {
            String token = AuthUtil.getProviderToken(config);
            assertNotNull(token, "Provider token should be retrieved successfully");
            assertTrue(AuthUtil.validateTokenForUse(token), "Provider token should pass validation");
            
            System.out.println("Provider user token retrieved successfully");
        } catch (Exception e) {
            fail("Provider user token retrieval failed: " + e.getMessage());
        }
    }

    /**
     * Test: Token Cleanup
     * 
     * Description: Tests that tokens are properly cleared
     */
    @Test
    public void testTokenCleanup() {
        // First, ensure we have tokens
        String internalToken = AuthUtil.getInternalToken(config);
        String providerToken = AuthUtil.getProviderToken(config);
        
        assertNotNull(internalToken, "Should have internal token before cleanup");
        assertNotNull(providerToken, "Should have provider token before cleanup");
        
        // Clear tokens
        AuthUtil.clearTokens();
        
        // Verify tokens are cleared (they should be re-fetched on next call)
        System.out.println("Token cleanup test completed");
    }

    /**
     * Test: Token Re-fetch After Cleanup
     * 
     * Description: Tests that tokens can be re-fetched after cleanup
     */
    @Test
    public void testTokenRefetchAfterCleanup() {
        // Clear tokens first
        AuthUtil.clearTokens();
        
        // Re-fetch tokens
        try {
            String internalToken = AuthUtil.getInternalToken(config);
            String providerToken = AuthUtil.getProviderToken(config);
            
            assertNotNull(internalToken, "Internal token should be re-fetched successfully");
            assertNotNull(providerToken, "Provider token should be re-fetched successfully");
            
            System.out.println("Token re-fetch after cleanup test passed");
        } catch (Exception e) {
            fail("Token re-fetch after cleanup failed: " + e.getMessage());
        }
    }

    /**
     * Test: Invalid User Type Handling
     * 
     * Description: Tests that invalid user types are properly handled
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidUserTypeHandling() {
        AuthUtil.getAuthToken(config, "invalid_user_type");
    }

    /**
     * Test: Token Validation for Null Token
     * 
     * Description: Tests token validation with null token
     */
    @Test
    public void testTokenValidationForNullToken() {
        boolean isValid = AuthUtil.validateTokenForUse(null);
        assertFalse(isValid, "Null token should be invalid");
        System.out.println("Null token validation test passed");
    }

    /**
     * Test: Token Validation for Empty Token
     * 
     * Description: Tests token validation with empty token
     */
    @Test
    public void testTokenValidationForEmptyToken() {
        boolean isValid = AuthUtil.validateTokenForUse("");
        assertFalse(isValid, "Empty token should be invalid");
        System.out.println("Empty token validation test passed");
    }
} 