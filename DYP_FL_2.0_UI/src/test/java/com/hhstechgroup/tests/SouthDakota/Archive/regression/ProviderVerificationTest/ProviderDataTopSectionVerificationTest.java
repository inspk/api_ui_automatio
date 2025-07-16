package com.hhstechgroup.tests.SouthDakota.Archive.regression.ProviderVerificationTest;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)
/**
 * This class logs in as an approved Provider, confirms the Agree and Secure message, verifies the labels displayed in
 * the Provider Data tab main panel, and logs out.
 */
public class ProviderDataTopSectionVerificationTest extends BaseClassUI {


    @Video
    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyProviderDataLabelsForApprovedProvider(String testEnvironment, String firstName, String lastName, String emailID, String trackingNumber) {

        Reports.log("The following Stories will be covered as part of this Test: \nPECS-794");

        //Login Application as an Approved Provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Verify Provider Data Labels
        dashboardPage.verifyProviderDataTopSectionLabels();

        dashboardPage.logOut();
    }

    @Test(dataProvider = "getIndServicesProviderNameEmailTaxonomyNPIWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyNoSecondaryServiceLocationTabTest(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String tracking_num) {

        Reports.log("The following story will be covered as part of this Test: PECS-795");


        //Login Application as an Approved Provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //click View Details on dashboard and verify no secondary service location tab
        dashboardPage.clickViewDetailsOnProviderDashboard();
        dashboardPage.verifyNoSecondaryServiceLocationTab();

    }
}


