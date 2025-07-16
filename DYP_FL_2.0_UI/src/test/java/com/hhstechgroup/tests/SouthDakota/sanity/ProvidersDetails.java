package com.hhstechgroup.tests.SouthDakota.sanity;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners(VideoListener.class)
public class ProvidersDetails extends BaseClassUI {
  //  String enrollmentType = Data.StatusValueIndividual;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    @Video
    @Test(dataProvider = "getProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class, priority = 0)
    public void verifyAllProvidersTabsAndLabels(String enrollmentType, String firstName, String lastName, String emailID, String trackingNum ) {

        sdhomePage.signInToApp(emailID, providerPassword);
        //Verify all the labels
        dashboardPage.verifyDashboardLabelsForApprovedProvider(Data.APPLICATION_STATUS_ACTIVE2);

        //Verify all the tabs
        dashboardPage.verifyAllTabsForApprovedProviderOnDashboard();
        dashboardPage.logOut();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1931");
    }

    @Video
    @Test(dataProvider = "getProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class, priority = 1)
    public void suspendedAndReactivationFlows(String enrollmentType, String firstName, String lastName, String emailID, String trackingNum) throws IOException {

        sdhomePage.signInToApp(internalUserEmail, internalUserPassword);

        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);

        //Get the Provider ID from the enrollment displayed in the search results
        String providerID = iuEnrollmentPage.getProvidersID();

        //click the Providers tab
        landingPage.clickProvidersTab();
        iuEnrollmentPage.navigateToProviderTabAndSearchForEnrollmentByProviderID(providerID);
        iuEnrollmentPage.suspendTheEnrollmentApplication();
        iuEnrollmentPage.verifyTheStatusOfApplication(Data.applicationStatusSuspended);
        iuEnrollmentPage.reactivateTheEnrollmentApplication();
        iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
        dashboardPage.logOut();

        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,Data.APPLICATION_STATUS_ACTIVE);
        excel.readExcel();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1931");
    }

    @Video
    @Test(dataProvider = "getProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class, priority = 3)
    public void terminateProvider(String enrollmentType, String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        sdhomePage.signInToApp(internalUserEmail, internalUserPassword);

        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);

        //Get the Provider ID from the enrollment displayed in the search results
        String providerID = iuEnrollmentPage.getProvidersID();

        //click the Providers tab
        landingPage.clickProvidersTab();
        iuEnrollmentPage.navigateToProviderTabAndSearchForEnrollmentByProviderID(providerID);
        iuEnrollmentPage.terminateTheEnrollmentApplication();
        iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_TERMINATED);
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,enrollmentType,firstName,lastName,Data.APPLICATION_STATUS_TERMINATED);
        excel.readExcel();
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1931");
    }

}

