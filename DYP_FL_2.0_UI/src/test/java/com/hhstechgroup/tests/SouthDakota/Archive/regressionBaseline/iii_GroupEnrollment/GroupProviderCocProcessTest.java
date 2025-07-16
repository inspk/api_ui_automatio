package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)

/**
 * This test class verifies the submission and approval of a Group Address Details CoC, and verifies the error messages
 * displayed when the creation of a Group Ownership CoC or a Group Program Participation CoC is attempted.
 */
public class GroupProviderCocProcessTest extends BaseClassUI {

    String enrollmentType = Data.GROUP_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Group Provider with 'Active' status from ProviderInfo.xlsx, logs into DyP as the
     * Group Provider, creates an Taxonomy/License CoC request, logs out as the Group Provider, logs into DyP as an
     * Internal User, executes a search for the Taxonomy/License  CoC request, approves the Taxonomy/License CoC
     * request, verifies the status of the Taxonomy/License CoC request, logs out as the Internal User and writes the
     * status of the Taxonomy/License CoC request to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameEmailTaxNPIWithActiveStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void createApproveCoCTaxonomy(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit License CoC
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_TAXONOMY);
        coc.cocAddLicenseInformation(enrollmentType, 0);
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
        excel.writeTestData(testEnvironment, enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusApprove, trackingNum);
        excel.readExcel();

    }
    /**
     * This test method retrieves a Group Provider with 'Active' status from ProviderInfo.xlsx, logs into DyP as the
     * Group Provider, creates Ownership CoC request, verifies the error message displayed, creates Program
     * Participation CoC request, verifies the error message displayed and logs out as the Group Provider.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNumber
     * @throws Exception
     */
    @Test(dataProvider="getGrpProviderNameEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void validateCOCErrorMsgForOwnershipAndProgramParticipant(String testEnvironment, String firstName, String lastName, String emailID, String trackingNumber) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_OWNERSHIP);
        coc.clickOnAddCOCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_PRGM_PARTICIPATION);

        //Logout
        enrollmentPageInternalUser.logOut();
    }
}

