package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption.securityPolicyTest;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 *  This class contains tests for Login Time out configuration for Security policy under System Options.
 */
public class LoginTimoutVerificationTest extends BaseClassUI {


    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Security policy and
     * verifies base configurations for Login Time out
     */
    @Test
    public void VerifyLoginTimeoutBaseConfigurations() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateSecurityPolicy();
        systemOptionsIE.verifyBaseConfigurationForLoginTimeout();
    }
}
