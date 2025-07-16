package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved PEM and creates and approves an alternate email change CoC.
  */
public class PEMProviderCocProcessTest extends BaseClassUI {

    String enrollmentType = Data.PEM_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);


    /**
     * This method logs in as an approved PEM and clicks on Coc button and then clicks on "Identifying Information"
     * and clears "Alternate email" and sends a new email. Then submits and store the tracking number. Logs in
     * as an internal user and approves the Coc. For verification searches in Coc section to verify the status
     * has changed to "Approved" and writes the data into ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */

    @Video
    @Test(dataProvider = "getPEMProviderNameEmailTaxNPIWithApprovedStatus",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"ApprovePemEnrollment"})
    public void createApproveCocAlternateEmail(String testEnvironment,String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC address
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING);
        coc.cocAlternateEmail(providerEmailPrefix,"gmail.com");
        enrollmentsAndCoc.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String trackingNum = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of COC to APPROVED
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName + " " + lastName, trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplicationWithReason(Data.ApplicationStatusApprove);

        //Search For Approved CoC
       // enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName + " " + lastName, trackingNum);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_APPROVED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_APPROVED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType, firstName, lastName, emailID, providerEmailPassword, taxonomy, npi, Data.ApplicationStatusApprove, trackingNum);
        excel.readExcel();
    }
}


