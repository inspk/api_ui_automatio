package com.hhstechgroup.tests.SouthDakota.Archive.sanity;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviders;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//Use these test cases after all sanity tests, because created providers are required for these tests

@Listeners(VideoListener.class)
public class ProvidersDetails extends BaseClassUI {
    DataProviders dataProviders = new DataProviders();

    //USE THESE TESTS ONLY FOR CONVERSION ENV
    @Video
    @Test(dataProvider = "suspendAndReactivateTerminate", dataProviderClass = DataProviders.class, priority = 4)
    public void suspendedAndReactivationFlows(String enrollmentType) {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        homePage.clickUpdatePopUpForNewUser();
        enrollmentPageInternalUser.navigateToProviderTabAndSearchForEnrollment(enrollmentType);
        enrollmentPageInternalUser.suspendTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication("Suspended");
        enrollmentPageInternalUser.reactivateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication("Active");
        enrollmentPageInternalUser.logOut();
    }

    @Test(dataProvider = "suspendAndReactivateTerminate", dataProviderClass = DataProviders.class, priority = 3)
    public void terminateProvider(String enrollmentType) {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToProviderTabAndSearchForEnrollment(enrollmentType);
        enrollmentPageInternalUser.terminateTheEnrollmentApplication();
        enrollmentPageInternalUser.verifyTheStatusOfApplication("Terminated");
        enrollmentPageInternalUser.logOut();
    }

    @Test(priority = 2)
    public void verifyAllProvidersTabs() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToProviderTabAndSearchForEnrollment();
        providerDetails.verifyMainProviderDetails();
        enrollmentDetails.verifyProviderStatus();
        enrollmentDetails.verifySummaryProvider();
        enrollmentDetails.clickEnrollmentDetails();
        enrollmentDetails.verifyAddFileProvider();
        enrollmentDetails.verifyHistoryProvider();
        enrollmentDetails.verifyTimelineProvider();
        enrollmentDetails.verifyRevalidationProvider();
        enrollmentDetails.verifyMessagesProvider();
        enrollmentDetails.verifySiteVisitsProvider();
        enrollmentPageInternalUser.logOut();
    }


    @Video
  @Test(priority = 1)
    public void modifyProviderData() {
        String newTitle = "Mr";
        String newGenderServed = "Male";
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        homePage.clickUpdatePopUpForNewUser();
        enrollmentPageInternalUser.navigateToProviderTabAndSearchForEnrollment("Individual");
        enrollmentDetails.verifyProviderStatus();
        enrollmentDetails.clickEnrollmentDetails();
        enrollmentDetails.clickOnProviderIdentifyingInformationSection();
        String firstName = enrollmentDetails.getParamaterValueFromEnrollment("First Name");
        enrollmentDetails.modifyProviderDetails(firstName,newTitle);

        //Click other Coc tab and click search button
        driver.findElement(Locators.COC_TAB).click();
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        enrollmentPageInternalUser.ajaxClick(Locators.BUTTON_SEARCH);

        //Return to Provider and verify that changes are saved
        enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.searchProviderInProviders(firstName);
        enrollmentPageInternalUser.selectProviderFromSearchResults();
        enrollmentDetails.verifyProviderStatus();
        enrollmentDetails.clickEnrollmentDetails();
        enrollmentPageInternalUser.verifyIfProviderDataModifiedSuccessfully(newTitle);
        enrollmentPageInternalUser.logOut();
    }
}

