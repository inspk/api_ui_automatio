package com.hhstechgroup.tests.SouthDakota.sanity;

import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

import java.io.IOException;

public class CoCForEFTIndProvider extends BaseClassUI {

    @Test(dataProvider = "getBillingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void approvalAndVerifyingBillingCoC(String testEnvironment, String enrollmentType ,  String firstName, String lastName,
                                               String provideEmailID, String trackingId) throws IOException {

        //Login as Individual Billing Provider and submit a COC on EFT
        loginPage.signInToApp("martin.providers+61366@gmail.com", providerPassword);
        landingPage.confirmAgreeAndSecureMessages();
        cocPage.navigateAndClickCoC();
        cocPage.createCoCBasedOnEnrollmentType(Data.individualApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_EFT);
        cocPage.submitCoCForEFT();
        dashboardPage.clickAnyButton(Data.TEXT_GO_TO_COC);
        String cocID = cocPage.getCoCID();
        dashboardPage.logOut();

        //Login as Internal user and Approve the COC request
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        cocPage.navigateToCoCAndSearch(cocID);
        cocPage.changeCocApplicationTo(Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        cocPage.cocUnderScreen(environmentUrl, cocID);
        cocPage.navigateToCoCAndSearch(cocID);
        cocPage.changeCocApplicationTo(Data.APPLICATION_STATUS_UNDER_CLEARING_HOUSE_CHECK, Data.DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED);
        cocPage.navigateToCoCAndSearch(cocID);
        cocPage.waveSiteVisitOnCocPage(Data.CREATE_SITE_VISIT);
        cocPage.reviewAndVoteTheEnrollment(firstName, lastName);
        cocPage.changeStatusWithReason(Data.ApplicationStatusApprove);
       // cocPage.ChangeAndVerifyTheStatusOfApplication(Data.ApplicationStatusApprove);
        dashboardPage.logOut();

        //Login back as Individual provider and verify the coc status
        loginPage.signInToApp("martin.providers+61366@gmail.com", providerPassword);
        landingPage.confirmAgreeAndSecureMessages();
        cocPage.navigateToCoC();
        cocPage.verifyCocApplicationStatus(Data.APPLICATION_STATUS_APPROVED_UPPERCASE);
        dashboardPage.logOut();
    }
}
