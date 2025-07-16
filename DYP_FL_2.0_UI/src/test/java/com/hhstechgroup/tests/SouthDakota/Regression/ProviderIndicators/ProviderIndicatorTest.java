

package com.hhstechgroup.tests.SouthDakota.Regression.ProviderIndicators;


import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelFileReading;
import org.testng.annotations.Test;


public class ProviderIndicatorTest extends BaseClassUI {



    @Video
    @Test(dataProvider = "getProviderForMCOProvNameEmailStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"MCOEnrollemntProviderSection"},
            groups = {"ProviderindicatorForEnrollments"})


    public void ProviderindicatorForEnrollments(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) {


        ExcelFileReading excel =new ExcelFileReading(providerInfoSheet,0);


        // Login Application as an internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);


        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Call Provider Indicator API
        providerIndicatorpage.callProviderIndicatorAPI();

        //Click on Providers tab
        dashboardPage.clickProvidersTab();

        //search with provider id for Providers tab
        providersPage.searchwithproviderid();


        //Navigate to provider indicator tab
        providerIndicatorpage.navigateToProviderIndicator();

        //verify the total number of indicators
        providerIndicatorpage.verifyindicatorstab();


    }
}
