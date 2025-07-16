package com.hhstechgroup.tests.SouthDakota.Archive.regression.ProviderVerificationTest;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

/**
 * This class logs in as an approved Provider, confirms the Agree and Secure message, verifies the labels displayed in
 * the Provider Data tab main panel, and logs out.
 */
public class ProviderCoCTopSectionVerificationTest extends BaseClassUI {

    @Video
    @Test(dataProvider = "getIndProviderNameEmailTaxNPIWithApprovedStatus", dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyCoCTabLabels(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy , String npi, String tracking_num) {

        Reports.log("The following Story will be covered as part of this Test: PECS-995");

        //Login Application as an Approved Provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Navigate and verify CoC Labels
        cocPage.verifyCoCTopSectionLabelsAsProvider(npi,firstName, lastName);

        dashboardPage.logOut();


    }
}


