package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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
 * This test class verifies the submission and approval of a Facility Address Details CoC, and verifies the error
 * messages displayed when the creation of a Facility Ownership CoC or a Facility Program Participation CoC is attempted.
 */
@Listeners(VideoListener.class)
public class FacilityProviderCocProcessTest extends BaseClassUI {

    String enrollmentType = Data.FACILITY_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Facility Provider with 'Active' status from ProviderInfo.xlsx, logs into DyP as the
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
    @Test(dataProvider = "getFacilityProviderNameEmailTaxNPIWithApprovedStatus", dataProviderClass = DataProviderForProviderInfo.class)
    //dependsOnGroups = "FacilityAppealApprove")
    public void createApproveCoCKeyPersonnel(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit Key Personnel COC
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoCForEnrollment("facility", Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_KEY_PERSONNEL);
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
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_APPROVED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_APPROVED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment, enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusApprove, trackingNum);
        excel.readExcel();
    }


    /**
     * This test method retrieves a Facility Provider with 'Active' status from ProviderInfo.xlsx, logs into DyP as the
     * Facility Provider, creates Ownership CoC request, verifies the error message displayed, creates Program
     * Participation CoC request, verifies the error message displayed and logs out as the Facility Provider.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider="getFacilityProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    // dependsOnGroups = {"FacilityAppealApprove"})
    public void validateCOCErrorMsgForOwnershipAndPogromParticipant(String testEnvironment, String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_OWNERSHIP);
        coc.clickOnAddCOCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_PRGM_PARTICIPATION);
    }
}
