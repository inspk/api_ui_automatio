package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)
/**
 * This class contains a test which uses a data provider to get a Coc denied of a PEM provider and appeals and deny it.
 */
public class PEMProviderCoCAndAppealDenialProcessTest extends BaseClassUI {

    String enrollmentType = Data.PEM_APPEAL_APPLICATION;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This method logs in as an approved PEM and clicks on Coc tab and gets list from Coc table and click on
     * the one which contains tracking number of denied Coc. Then clicks on appeal button. Fills in appeal section
     * and uploads document and submits.Then logs in as an internal user and changes the status of appeal
     * to "denied".For verification checks the status to verify it has changed to "Denied" and writes the data into ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Test(dataProvider = "getPEMProviderNameWithCOCStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class)
    //, dependsOnGroups = {""})
    public void createPEMEnrollmentCoCProcessDenialAppealTest(String testEnvironment,String firstName, String lastName, String emailID,String taxonomy, String npi, String trackingNumber) throws Exception {

        //Login as a provider to verify the coc Denied status and submit an Appeal
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.javaWaitSec(5);
        coc.ajaxClick(Locators.COC_TAB);
        coc.javaWaitSec(5);
        coc.ajaxScroll(Locators.PART_OF_ENROLLMENT_INFO);

        // Get the Denied COC with the trackingNumber and appeal
        enrollmentsAndCoc.getSpecificCocAndAppeal(trackingNumber);

        providerPortal.uploadFileAndSubmit();
        enrollmentsAndCoc.navigateToAppealAndSearchForEnrollment();
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        enrollmentPageInternalUser.ajaxClick(Locators.BUTTON_SEARCH);
        coc.javaWaitSec(3);
        String trackingNumAppeal = coc.getProviderCoCID();
        enrollmentPageInternalUser.logOut();

        // login as internal user to approve the COC Appeal
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName + " " + lastName, trackingNumAppeal);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusDenied);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_DENIED_UPPERCASE);
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusDenied, trackingNumAppeal);
        excel.readExcel();
    }
}


