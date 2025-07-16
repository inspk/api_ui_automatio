package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This method contains a test which uses a data provider to get an approved pharmacy enrollment, creates and denies an identifying information CoC
  */
@Listeners(VideoListener.class)
public class PharmacyProviderCocDenyProcessTest extends BaseClassUI {

    String enrollmentType = Data.PHARMACY_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as an approved pharmacy, clicks on Coc button, clicks on "Identifying Information".
     * Clears provider's name filed, sends a random name, submits and store the tracking number. Then logs in as an
     * internal user and denies the Coc. For verification searches in Coc section to verify the status has changed to "Denied" and
     * writes the data into ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Test(dataProvider = "getPharmacyProviderNameEmailTaxNPIWithActiveStatus", dataProviderClass = DataProviderForProviderInfo.class)
    public void createDenyCocIdentifyingInformation(String testEnvironment,String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC Identifying Information
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();

        coc.createCoCForEnrollment(Data.pharmacyApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING);
        coc.cocIdentifyingInformationGeneratedName();
        enrollmentsAndCoc.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String trackingNum = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of COC to denied
        homePage.signInToApp(internalUserEmail, internalUserPassword);

        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName+" "+lastName, trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplicationWithReason(Data.ApplicationStatusDenied);

        //Search For Denied CoC
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName+" "+lastName, trackingNum);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_DENIED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_DENIED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusDenied, trackingNum);
        excel.readExcel();
    }
}
