package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)
/**
 * This class contains a test that uses a data provider to get a Denied Individual provider, Creates an appeal request for that provider and approves it.
 */

public class IndividualProviderAppealApproveProcessTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    /**
     * This method logs in as a Denied Individual provider. Creates an Appeal request by clicking on the on appeal button. Fills in the section, uploads document
     * and submits the application. Login the Application as Internal user. Navigates to Appeal tabs, search for the provider
     * and changes the status of appeal to Approve and updates ProviderInfo.xlsx
     * @param firstName firstName column value from ProviderInfo.xlsx
     * @param lastName lastName column value from ProviderInfo.xlsx
     * @param emailID email column value from ProviderInfo.xlsx
     * @param trackingNum trackingNum column value from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusDenied", dataProviderClass = DataProviderForProviderInfo.class,
           dependsOnGroups = "requestForAdditionalInfo")
    public void enrollmentAppealAndApprove(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.individualApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}
