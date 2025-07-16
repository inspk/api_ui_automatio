package com.hhstechgroup.tests.SouthDakota.Archive.regression.internaluser;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class IUProviderModuleTest extends BaseClassUI {

    @Test
    public void verifySummaryTabDoesNotExistsTest() throws Exception {

        Reports.log("The following Stories will be covered as part of this test: \nPECS-1013");

        //login Application as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //confirmAgreeAndSecureMessages
        landingPage.confirmAgreeAndSecureMessages();

        //navigate to Providers Tab and click SEARCH button
        landingPage.clickProvidersTab();
        iuEnrollmentPage.clickSearchForProviders();

        //verify Summary Tab does not exist
        iuEnrollmentPage.verifySummaryTabDoesNotExists();

    }
}
