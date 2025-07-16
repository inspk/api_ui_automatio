package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 *  This class contains tests for Duplicity  configuration under System Options.
 */

public class DuplicitySystemOptionsTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Duplicity Tile and
     * verifies base configurations for Duplicity & Data Matching
     */
    @Test
    public void verifyDuplicitySystemOption() {
        Reports.log("This test is to verify the Duplicity configuration under System Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyDuplicitySystemOption();
        enrollmentPageInternalUser.logOut();
    }
}
