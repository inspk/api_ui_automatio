package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.i_SystemOption;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;


/**
 *  This class contains tests for Payment & Fee configuration under System Options.
 */

public class PaymentsAndFeesSystemOptionsTest extends BaseClassUI {

    /**
     * This method logs in as Internal User. Goes to System Options and clicks on 'Payment and Fee' title and
     * verifies base configurations for Payment and Fee for the providers
     */
    @Test
    public void verifyPaymentAndFeesSystemOptions() {
        Reports.log("This test is to verify the Payments and Fees configuration under System Options");
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyPaymentAndFeeSystemOptions();
        enrollmentPageInternalUser.logOut();
    }
}


