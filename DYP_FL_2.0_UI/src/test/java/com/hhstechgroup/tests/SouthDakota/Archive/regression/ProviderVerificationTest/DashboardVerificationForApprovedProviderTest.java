package com.hhstechgroup.tests.SouthDakota.Archive.regression.ProviderVerificationTest;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)
public class DashboardVerificationForApprovedProviderTest extends BaseClassUI {


    @Video
    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void DashboardTabVerificationForApprovedProvider(String testEnvironment, String firstName, String lastName, String emailID, String trackingNumber) throws Exception {

        Reports.log("The following Stories will be covered as part of this Test: \nPECS-763");

        //Login Application as an Approved Provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Verify all the tabs
        dashboardPage.verifyAllTabsForApprovedProviderOnDashboard();

        dashboardPage.logOut();
    }

    @Video
    @Test(dataProvider = "getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void DashboardLabelsVerificationForApprovedProvider(String testEnvironment, String firstName, String lastName, String emailID, String trackingNumber) throws Exception {

        //Login Application as an Approved Provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Verify all the labels
        dashboardPage.verifyDashboardLabelsForApprovedProvider(Data.APPLICATION_STATUS_ACTIVE2);

        dashboardPage.logOut();
    }
}

