package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This class contains a test which uses a data provider to get an approved pharmacy enrollment and creates and approves a change address CoC.
  */
@Listeners(VideoListener.class)
public class PharmacyProviderCocProcessTest extends BaseClassUI {

    String enrollmentType = Data.PHARMACY_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Group Provider with 'Active' status from ProviderInfo.xlsx, logs into DyP as the
     * Pharmacy Provider, creates a Key Personnel CoC request, logs out as the Pharmacy Provider, logs into DyP as an
     * Internal User, executes a search for the Key Personnel  CoC request, approves the Key Personnel CoC
     * request, verifies the status of the Key Personnel request, logs out as the Internal User and writes the
     * status of the Key Personnel CoC request to ProviderInfo.xlsx.
     *     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getPharmacyProviderNameEmailTaxNPIWithActiveStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void createApproveCoCKeyPersonnel(String testEnvironment,String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit Key Personnel COC
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoCForEnrollment(Data.pharmacyApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_KEY_PERSONNEL);
        coc.cocAddKeyPersonnel();
        enrollmentsAndCoc.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String trackingNum = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of COC to APPROVED
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName+" "+lastName, trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplicationWithReason(Data.ApplicationStatusApprove);

        //Search For Approved CoC
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName+" "+lastName, trackingNum);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_APPROVED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_APPROVED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusApprove, trackingNum);
        excel.readExcel();
    }

    /**
     * This test method retrieves a Pharmacy Provider with 'Active' status from ProviderInfo.xlsx, logs into DyP as the
     * Pharmacy Provider, creates Ownership CoC request, verifies the error message displayed, creates Program
     * Participation CoC request, verifies the error message displayed and logs out as the Pharmacy Provider.
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNumber
     * @throws IOException
     */
    @Test(dataProvider="getPharmacyProviderNameEmailTaxNPIWithActiveStatus", dataProviderClass = DataProviderForProviderInfo.class)
    public void validateCOCErrorMsgForOwnershipAndPogromParticipant(String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoCForEnrollment(Data.pharmacyApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_OWNERSHIP);
        coc.clickOnAddCOCButton();
        coc.createCoCForEnrollment(Data.pharmacyApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_PRGM_PARTICIPATION);
    }
}
