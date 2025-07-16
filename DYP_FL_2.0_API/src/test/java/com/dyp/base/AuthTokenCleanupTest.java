package com.dyp.base;

import org.testng.annotations.Test;

public class AuthTokenCleanupTest extends BaseTest {
    @Test
    public void clearAuthTokens() {
        AuthUtil.clearTokens();
        logTestInfo("Auth tokens cleared after POD test group.");
    }
} 