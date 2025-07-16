package com.hhstechgroup.tests.SouthDakota.regressionBaseline.i_SystemOption;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;


/**
 *  This class contains tests for Request Additional Information under System Options.
 */
public class RequestAdditionalInfoSystemOptionsTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Request Additional Information Title and
     * verifies base configurations for Request Additional Information.
     */
   @Test
    public void verifyRequestAdditionalInfoSystemOptions() {
        Reports.log("This test is to verify the Request Additional Info configuration under System Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyDeactivationSystemOptions();
        enrollmentPageInternalUser.logOut();

    }

}
