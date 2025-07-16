package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 *  This class contains tests for Revalidation under System Options.
 */
public class RevalidationsAndRemindersSystemOptionsTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Revalidations Title and
     * verifies base configurations for Revalidations and Reminders.
     */
    @Test
    public void verifyRevalidationsAndRemindersSystemOption() {
        Reports.log("This test is to verify the Revalidations and Reminders configuration under System Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyRevalidationsAndRemindersSystemOption();
        enrollmentPageInternalUser.logOut();
    }
}
