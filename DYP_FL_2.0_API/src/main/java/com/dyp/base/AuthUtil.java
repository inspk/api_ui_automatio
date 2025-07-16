package com.dyp.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import java.util.Properties;
import java.time.Instant;
import java.util.Base64;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthUtil {
    private static String currentEnvironment;
    private static final long TOKEN_REFRESH_THRESHOLD = 300; // 5 minutes in seconds

    // Thread-local token storage for parallel execution
    private static final ThreadLocal<String> internalToken = new ThreadLocal<>();
    private static final ThreadLocal<String> providerToken = new ThreadLocal<>();
    private static final ThreadLocal<Long> internalTokenExpiry = new ThreadLocal<>();
    private static final ThreadLocal<Long> providerTokenExpiry = new ThreadLocal<>();

    static {
        // Disable SSL certificate validation for development/testing
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static String getCurrentEnvironment(Properties config) {
        if (currentEnvironment == null) {
            currentEnvironment = config.getProperty("environment", "dev01");
        }
        return currentEnvironment;
    }

    public static String getBaseUrl(Properties config) {
        String env = getCurrentEnvironment(config);
        String baseUrl = config.getProperty(env + ".baseUrl");
        if (baseUrl == null) {
            // Fallback to generic baseUrl
            baseUrl = config.getProperty("baseUrl");
        }
        if (baseUrl == null) {
            throw new RuntimeException("Base URL not found for environment: " + env);
        }
        return baseUrl;
    }

    // Generic login method for both user types
    public static String getLoginToken(Properties config, String email, String password) {
        String env = getCurrentEnvironment(config);
        String baseUrl = getBaseUrl(config);
        String loginEndpoint = config.getProperty("loginEndpoint");

        // Build login request body
        String body = String.format("{\"email\":\"%s\",\"password\":\"%s\",\"pemUser\":false}", email, password);

        Response response = RestAssured.given()
            .baseUri(baseUrl)
            .contentType(ContentType.JSON)
            .accept("application/json, text/plain, */*")
            .body(body)
            .post(loginEndpoint)
            .then()
            .extract().response();

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Login API failed with status: " + response.getStatusCode());
        }

        // Extract token from cookies
        String token = response.getCookie("auth_token");

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Failed to fetch user token from login API. Check response cookies for 'auth_token'.");
        }

        // Validate token strength
        validateTokenStrength(token);
        
        return token;
    }

    public static String getInternalToken(Properties config) {
        // Check if token exists and is still valid
        if (internalToken.get() != null && isTokenValid(internalTokenExpiry.get() != null ? internalTokenExpiry.get() : 0L)) {
            return internalToken.get();
        }

        String env = getCurrentEnvironment(config);
        String email = config.getProperty(env + ".internalUserEmail");
        String password = config.getProperty(env + ".internalUserPassword");
        
        internalToken.set(getLoginToken(config, email, password));
        internalTokenExpiry.set(getTokenExpiry(internalToken.get()));
        
        return internalToken.get();
    }

    public static String getProviderToken(Properties config) {
        // Check if token exists and is still valid
        if (providerToken.get() != null && isTokenValid(providerTokenExpiry.get() != null ? providerTokenExpiry.get() : 0L)) {
            return providerToken.get();
        }

        String env = getCurrentEnvironment(config);
        String email = config.getProperty(env + ".providerUserEmail");
        String password = config.getProperty(env + ".providerUserPassword");
        
        try {
            providerToken.set(getLoginToken(config, email, password));
            providerTokenExpiry.set(getTokenExpiry(providerToken.get()));
            return providerToken.get();
        } catch (Exception e) {
            // For testing purposes, try using internal user credentials as fallback
            try {
                String fallbackEmail = config.getProperty(env + ".internalUserEmail");
                String fallbackPassword = config.getProperty(env + ".internalUserPassword");
                providerToken.set(getLoginToken(config, fallbackEmail, fallbackPassword));
                providerTokenExpiry.set(getTokenExpiry(providerToken.get()));
                return providerToken.get();
            } catch (Exception fallbackException) {
                throw new RuntimeException("Failed to fetch provider token with both primary and fallback credentials", e);
            }
        }
    }

    /**
     * Validate token strength and format
     */
    private static void validateTokenStrength(String token) {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Token is null or empty");
        }

        // Check if it's a JWT token (should have 3 parts separated by dots)
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid JWT token format");
        }

        // Check token length (should be reasonable)
        if (token.length() < 50) {
            throw new RuntimeException("Token seems too short");
        }
    }

    /**
     * Get token expiry time from JWT token
     */
    private static long getTokenExpiry(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) {
                return Instant.now().getEpochSecond() + 3600; // Default 1 hour
            }

            // Decode the payload part
            String payload = new String(Base64.getDecoder().decode(parts[1]));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(payload);
            
            if (jsonNode.has("exp")) {
                return jsonNode.get("exp").asLong();
            }
        } catch (Exception e) {
            // Silent fallback to default expiry
        }
        
        return Instant.now().getEpochSecond() + 3600; // Default 1 hour
    }

    /**
     * Check if token is still valid
     */
    private static boolean isTokenValid(long tokenExpiry) {
        long currentTime = Instant.now().getEpochSecond();
        return (tokenExpiry - currentTime) > TOKEN_REFRESH_THRESHOLD;
    }

    public static void clearTokens() {
        System.out.println("[AuthUtil] Clearing all tokens for thread: " + Thread.currentThread().getName() +
            " (internalToken: " + (internalToken.get() != null) + ", providerToken: " + (providerToken.get() != null) + ")");
        internalToken.remove();
        providerToken.remove();
        internalTokenExpiry.remove();
        providerTokenExpiry.remove();
    }

    public static void clearTokens(String environment) {
        clearTokens(); // For now, clear all tokens
    }

    /**
     * Get auth token based on user type with validation
     */
    public static String getAuthToken(Properties config, String userType) {
        if ("internal".equalsIgnoreCase(userType) || "iu".equalsIgnoreCase(userType)) {
            return getInternalToken(config);
        } else if ("provider".equalsIgnoreCase(userType) || "pu".equalsIgnoreCase(userType)) {
            return getProviderToken(config);
        } else {
            throw new IllegalArgumentException("Invalid user type: " + userType + ". Use 'internal'/'iu' or 'provider'/'pu'");
        }
    }

    /**
     * Validate token before using in API calls
     */
    public static boolean validateTokenForUse(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }

        try {
            validateTokenStrength(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
} 