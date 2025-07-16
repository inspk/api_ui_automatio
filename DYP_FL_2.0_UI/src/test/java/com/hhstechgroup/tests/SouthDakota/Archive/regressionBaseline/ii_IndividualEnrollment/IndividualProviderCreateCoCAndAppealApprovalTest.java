package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This class contains a test that uses a data provider to get a Coc denied for an Individual Provider, Creates an appeal request for that provider and approves it.
*/
@Listeners(VideoListener.class)
public class IndividualProviderCreateCoCAndAppealApprovalTest extends BaseClassUI {

    String enrollmentType = Data.INDIVIDUAL_APPEAL_APPLICATION;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This method logs in as an approved Individual Provider. Navigated to Coc tab and gets the tracking Number of Denied Coc from the Search list. Clicks on appeal button.
     * Fills in appeal section and uploads document and submits.Then logs in as an internal user and changes the status of appeal to "Approve".
     * Navigates to appeal tab and searches for the provider and verifies if status has changed to "Approved". writes the data into ProviderInfo.xlsx
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
    @Test(dataProvider = "getIndProviderNameWithCOCStatusDenied",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"IndividualCoCDenial"})
    public void createIndividualEnrollmentCoCProcessAppealApprovalTest(String testEnvironment,String firstName, String lastName, String emailID,String taxonomy, String npi, String trackingNumber) throws Exception {

        //Login as a provider to verify the coc Denied status and submit an Appeal
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.javaWaitSec(5);
        coc.ajaxClick(Locators.COC_TAB);
        coc.javaWaitSec(5);
        coc.ajaxScroll(Locators.PART_OF_ENROLLMENT_INFO);

        // Get the Denied COC trackingNumber
        enrollmentsAndCoc.getSpecificCocAndAppeal(trackingNumber);

        //Create and submit the Appeal
        providerPortal.uploadFileAndSubmit();
        enrollmentPageProvider.clickAnyButton(Data.TEXT_GO_TO_APPEALS);

        //Get Request ID
        String requestID = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of Appeal to Approved
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider("", requestID);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);

        //Search For Approved Appeal
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider("", requestID);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_APPROVED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_APPROVED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusApprove, requestID);
        excel.readExcel();
    }
}
