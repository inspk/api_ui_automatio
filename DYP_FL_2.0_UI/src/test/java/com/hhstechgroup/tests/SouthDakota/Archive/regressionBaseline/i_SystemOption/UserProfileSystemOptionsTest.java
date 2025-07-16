package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 *  This class contains tests for User Profile configuration under System Options.
 */
public class UserProfileSystemOptionsTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on User Profile Title and
     * verifies base configurations for User Profile
     */
    @Test
    public void verifyUserProfileSystemOptions() {
        Reports.log("This test is to verify the User Profile configuration under System Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptions.userProfileTileVerification();
        enrollmentPageInternalUser.logOut();
    }
}
