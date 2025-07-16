package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 *  This class contains tests for Auto Archive configuration under System Options.
 */
public class AutoArchiveTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Auto Archive and
     * Verifies base configurations for Auto Archive Data and File set Periods
     */
    @Test
    public void VerifyAutoArchiveBaseConfigurations() {
        Reports.log("This test is to  verify base configuration for Auto Archive under System Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateAutoArchive();
        systemOptionsIE.verifyBaseConfigurationForAutoArchive();
    }

}
