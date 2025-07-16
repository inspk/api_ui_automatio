package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

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
 * This class contains a test which uses a data provider to get an approved ORP provider, Creates and approves an alternate email change CoC.
 */

public class ORPProviderCoCProcessTest extends BaseClassUI {

    String enrollmentType = Data.ORP_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     *  This method logs in as an approved ORP provider. Clicks on Coc button, clicks on "Provider Identifiers"
     * ,clears "Alternate email" and sends a new email. stores the tracking number. Then logs in as an internal
     * user and approves the Coc. For verification searches in Coc section to verify the status has changed to
     * "Approved" and writes the data into ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getORPProviderNameEmailTaxNPIWithApprovedStatus",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = "ORPAppealApprove")
    public void createApproveCocAddress(String  testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC address
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoCForEnrollment(Data.orpApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PROV_IDENTIFY);
        coc.cocProviderIdentifier();
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
        //enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
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
     * This method logs in as an approved ORP and clicks on Coc button and then clicks on "Ownership" and clicks on create coc.
     * Then verifies that popup message "Cannot change ownership, please submit new enrollment" shows up and clicks ok.
     * Clicks again on Coc button and then clicks on "Program Participation" and clicks on create coc.
     * Then verifies that popup message "Cannot change program participation. Please contact helpdesk." shows up and clicks ok.
     * and click ok.
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */

    @Test(dataProvider="getORPProviderNameWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = "ORPAppealApprove")
       public void validateCOCErrorMsgForOwnershipAndPogromParticipant(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        //coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP);
        coc.createCoCForEnrollment(Data.orpApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_OWNERSHIP);
        coc.clickOnAddCOCButton();
        //coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN);
        coc.createCoCForEnrollment(Data.orpApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN);
        coc.verifyCocErrorMessageAs(Data.COC_ERROR_MSG_CANT_CHANGE_PRGM_PARTICIPATION);
    }
}
