package com.hhstechgroup.tests.SouthDakota.Archive.regression;

import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

import java.io.IOException;

public class CoCForEFTIndProvider extends BaseClassUI {


    @Test(dataProvider = "getIndProviderNameEmailTaxNPIWithApprovedStatus", dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyEFTInCoCPopUpTest(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy , String npi, String tracking_num)  throws IOException {
        Reports.log("The following story will be covered as part of this Test: PECS-841");

        //Login Application as an Approved Provider
        loginPage.signInToApp(emailID, providerPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Navigate and click CoC
        cocPage.navigateAndClickCoC();

        //Create CoC Based on Enrollment Type and CoC Type is EFT
        cocPage.createCoCBasedOnEnrollmentType(Data.individualApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_EFT);

        //CoC Type EFT is created and submitted
        cocPage.submitCoCForEFT();

        // click the Change of Circumstance button on Providers Dashboard
        dashboardPage.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String cocID = cocPage.getCoCID();

        dashboardPage.logOut();

        //Login as Internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        landingPage.confirmAgreeAndSecureMessages();

        //Navigate to CoC and search the CoC
        cocPage.navigateToCoCAndSearch(cocID);

        //Verify red text of the search results and click the search result
        cocPage.verifyAndClickRedTextForSearchResultsCoCEFT();

       //Download Coc Document
        cocPage.verifyDownloadCoCDoc();
    }
}
