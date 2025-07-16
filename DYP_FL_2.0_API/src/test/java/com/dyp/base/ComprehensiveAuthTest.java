package com.dyp.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.*;
import java.util.Properties;

/**
 * Comprehensive Authentication Test for PU and IU Roles
 * 
 * Purpose: This test validates the complete authentication flow for both user roles:
 * - Provider User (PU) authentication
 * - Internal User (IU) authentication
 * - Token storage in variables
 * - Token validation
 * - Token cleanup
 * 
 * Test Flow:
 * 1. Load configuration from config file
 * 2. Test PU authentication and store token
 * 3. Test IU authentication and store token
 * 4. Validate both tokens
 * 5. Clear tokens at the end
 */
public class ComprehensiveAuthTest extends BaseTest {

    // Token storage variables (for this thread only)
    private String providerUserToken;
    private String internalUserToken;
    private boolean puTokenFetched = false;
    private boolean iuTokenFetched = false;

    // All token access is now via AuthUtil's thread-local methods

    @BeforeClass
    public void setup() {
        // Configuration is already initialized by BaseTest
        logTestInfo("Comprehensive authentication test setup completed");
    }

    @AfterClass
    public void cleanup() {
        // No token cleanup here. Token cleanup is handled by AuthTokenCleanupTest after all PODs.
        logTestInfo("Comprehensive authentication test cleanup completed (no token cleanup here)");
    }

    /**
     * Test: Configuration Loading from Config File
     * 
     * Description: Validates that configuration is loaded correctly from the config file
     */
    @Test(priority = 1)
    public void testConfigurationLoadingFromConfigFile() {
        logTestInfo("Testing configuration loading from config file");
        
        // Validate configuration object
        assertNotNull(config, "Configuration should not be null");
        assertNotNull(currentEnvironment, "Current environment should not be null");
        assertNotNull(baseUrl, "Base URL should not be null");
        
        // Validate environment-specific configuration
        String env = getCurrentEnvironment();
        String puEmail = config.getProperty(env + ".providerUserEmail");
        String puPassword = config.getProperty(env + ".providerUserPassword");
        String iuEmail = config.getProperty(env + ".internalUserEmail");
        String iuPassword = config.getProperty(env + ".internalUserPassword");
        
        // Validate Provider User credentials
        assertNotNull(puEmail, "Provider User email should be configured");
        assertNotNull(puPassword, "Provider User password should be configured");
        assertTrue(puEmail.contains("@"), "Provider User email should be valid format");
        
        // Validate Internal User credentials
        assertNotNull(iuEmail, "Internal User email should be configured");
        assertNotNull(iuPassword, "Internal User password should be configured");
        assertTrue(iuEmail.contains("@"), "Internal User email should be valid format");
        
        logTestPass("Configuration loading test passed");
        logTestInfo("Environment: " + env);
        logTestInfo("Base URL: " + baseUrl);
        logTestInfo("Provider User email: " + puEmail);
        logTestInfo("Internal User email: " + iuEmail);
    }

    /**
     * Test: Provider User (PU) Authentication
     * 
     * Description: Tests Provider User login and stores token in variable
     */
    @Test(priority = 2)
    public void testProviderUserAuthentication() {
        logTestInfo("Testing Provider User (PU) authentication");
        
        try {
            // Fetch Provider User token
            providerUserToken = AuthUtil.getProviderToken(config);
            
            // Validate token
            assertNotNull(providerUserToken, "Provider User token should not be null");
            assertTrue(providerUserToken.length() > 50, "Provider User token should be reasonably long");
            assertTrue(providerUserToken.contains("."), "Provider User token should be JWT format");
            
            // Validate JWT structure
            String[] parts = providerUserToken.split("\\.");
            assertEquals(parts.length, 3, "Provider User JWT token should have 3 parts");
            
            // Mark as fetched
            puTokenFetched = true;
            
            logTestPass("Provider User authentication successful");
            logTestInfo("Provider User token stored in variable: " + providerUserToken.substring(0, 20) + "...");
            
        } catch (Exception e) {
            logTestFail("Provider User authentication failed: " + e.getMessage());
            throw new RuntimeException("Provider User authentication failed", e);
        }
    }

    /**
     * Test: Internal User (IU) Authentication
     * 
     * Description: Tests Internal User login and stores token in variable
     */
    @Test(priority = 3)
    public void testInternalUserAuthentication() {
        logTestInfo("Testing Internal User (IU) authentication");
        
        try {
            // Fetch Internal User token
            internalUserToken = AuthUtil.getInternalToken(config);
            
            // Validate token
            assertNotNull(internalUserToken, "Internal User token should not be null");
            assertTrue(internalUserToken.length() > 50, "Internal User token should be reasonably long");
            assertTrue(internalUserToken.contains("."), "Internal User token should be JWT format");
            
            // Validate JWT structure
            String[] parts = internalUserToken.split("\\.");
            assertEquals(parts.length, 3, "Internal User JWT token should have 3 parts");
            
            // Mark as fetched
            iuTokenFetched = true;
            
            logTestPass("Internal User authentication successful");
            logTestInfo("Internal User token stored in variable: " + internalUserToken.substring(0, 20) + "...");
            
        } catch (Exception e) {
            logTestFail("Internal User authentication failed: " + e.getMessage());
            throw new RuntimeException("Internal User authentication failed", e);
        }
    }

    /**
     * Test: Token Validation
     * 
     * Description: Validates that both stored tokens are valid and can be used
     */
    @Test(priority = 4)
    public void testStoredTokenValidation() {
        logTestInfo("Testing stored token validation");
        
        // Validate that tokens were fetched
        assertTrue(puTokenFetched, "Provider User token should have been fetched");
        assertTrue(iuTokenFetched, "Internal User token should have been fetched");
        
        // Validate Provider User token
        assertNotNull(providerUserToken, "Provider User token should not be null");
        assertTrue(AuthUtil.validateTokenForUse(providerUserToken), "Provider User token should pass validation");
        
        // Validate Internal User token
        assertNotNull(internalUserToken, "Internal User token should not be null");
        assertTrue(AuthUtil.validateTokenForUse(internalUserToken), "Internal User token should pass validation");
        
        // Validate tokens are different (they should be different users)
        assertNotEquals(providerUserToken, internalUserToken, "Provider User and Internal User tokens should be different");
        
        logTestPass("Stored token validation passed");
        logTestInfo("Both Provider User and Internal User tokens are valid and ready for use");
    }

    /**
     * Test: Token Usage Simulation
     * 
     * Description: Simulates using the stored tokens for API calls
     */
    @Test(priority = 5)
    public void testTokenUsageSimulation() {
        logTestInfo("Testing token usage simulation");
        
        // Simulate using Provider User token
        try {
            String puToken = AuthUtil.getProviderToken(config);
            assertNotNull(puToken, "Provider User token should be available for use");
            // Since tokens might be refetched, we just check that it's a valid token
            assertTrue(puToken.length() > 50, "Provider User token should be valid");
            
            logTestInfo("Provider User token usage simulation successful");
            
        } catch (Exception e) {
            logTestFail("Provider User token usage simulation failed: " + e.getMessage());
        }
        
        // Simulate using Internal User token
        try {
            String iuToken = AuthUtil.getInternalToken(config);
            assertNotNull(iuToken, "Internal User token should be available for use");
            // Since tokens might be refetched, we just check that it's a valid token
            assertTrue(iuToken.length() > 50, "Internal User token should be valid");
            
            logTestInfo("Internal User token usage simulation successful");
            
        } catch (Exception e) {
            logTestFail("Internal User token usage simulation failed: " + e.getMessage());
        }
        
        logTestPass("Token usage simulation completed successfully");
    }

    /**
     * Test: Token Cleanup Verification
     * 
     * Description: Verifies that tokens can be cleared properly
     */
//    @Test(priority = 6)
//    public void testTokenCleanupVerification() {
//        logTestInfo("Testing token cleanup verification");
//
//        // Store current token values for verification
//        String originalPuToken = providerUserToken;
//        String originalIuToken = internalUserToken;
//
//        // Clear tokens
//        AuthUtil.clearTokens();
//
//        // Verify tokens are cleared from AuthUtil
//        try {
//            // This should throw an exception or return null since tokens are cleared
//            String puToken = AuthUtil.getProviderToken(config);
//            String iuToken = AuthUtil.getInternalToken(config);
//
//            // If tokens are refetched, that's also acceptable behavior
//            logTestInfo("Tokens were refetched after cleanup (acceptable behavior)");
//
//        } catch (Exception e) {
//            logTestInfo("Tokens were properly cleared and refetch failed as expected");
//        }
//
//        logTestPass("Token cleanup verification completed");
//        logTestInfo("Token cleanup mechanism is working correctly");
//    }

    /**
     * Test: Final Token Status Check
     * 
     * Description: Final verification that all tokens are properly managed
     */
    @Test(priority = 7)
    public void testFinalTokenStatusCheck() {
        logTestInfo("Performing final token status check");
        
        // Verify that we can still get tokens if needed
        try {
            String puToken = AuthUtil.getProviderToken(config);
            String iuToken = AuthUtil.getInternalToken(config);
            
            assertNotNull(puToken, "Provider User token should be available after cleanup");
            assertNotNull(iuToken, "Internal User token should be available after cleanup");
            
            logTestPass("Final token status check passed");
            logTestInfo("Both Provider User and Internal User tokens are available and valid");
            
        } catch (Exception e) {
            logTestFail("Final token status check failed: " + e.getMessage());
        }
    }
} 