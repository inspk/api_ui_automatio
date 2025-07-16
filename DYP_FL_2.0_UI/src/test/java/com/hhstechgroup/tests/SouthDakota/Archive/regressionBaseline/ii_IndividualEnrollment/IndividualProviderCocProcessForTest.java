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

import java.io.IOException;

import static com.hhstechgroup.common.BaseActions.changeDayInCurrentDate;
@Listeners(VideoListener.class)
/**
 * This class contains a tests which uses the data provider to get a Approved Individual provider,
 * Creates a CoC for retro active adjustment and Approved it,
 * Creates a CoC for Identifying Information and Denies it and
 * Also verifies the COC Ownership and Program Participation tab messages
 */
public class IndividualProviderCocProcessForTest extends BaseClassUI {

    String enrollmentType ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     *  This method logs in as an Approved Individual Provider. Navigates to CoC tab, clicks on Coc button then "Retro Active Adjustment" and fills the required fields
     *  and submits the request.Gets and stores the application tracking number and logs out as provider.Then logs in as
     *  an internal user and Approves the CoC request. Navigates to CoC tab and searches for the provider and verifies if status has changed to "Approved". Verifies the
     *  enrollment span under provider tab.
     *  writes the data into ProviderInfo.xlsx
     *
     * @param firstName firstName column value from ProviderInfo.xlsx
     * @param lastName lastName column value from ProviderInfo.xlsx
     * @param emailID email column value from ProviderInfo.xlsx
     * @param taxonomy taxonomy column value from ProviderInfo.xlsx
     * @param npi npi column value from ProviderInfo.xlsx
     * @param trackingNumber trackingNum column value from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getIndProviderNameEmailTaxNPIWithApprovedStatus", dataProviderClass = DataProviderForProviderInfo.class
            ,dependsOnGroups = {"ApproveIndividualEnrollment"})
    public void createApproveCocRequestForRetroActive(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC address
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_RETRO_ACTIVE);
        coc.cocRequestForRetroActive(changeDayInCurrentDate(-7));
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

        //Verify the Enrollment Span of the Provider in the Provider Tab
       // enrollmentPageInternalUser.clickEnrollmentSpanInProvidersTab(Data.providerTypeIndividual,firstName, lastName);
        enrollmentPageInternalUser.ClickEnrollmentInfoAndRetroactiveInProviderInfo(Data.providerTypeIndividual,firstName, lastName);
        enrollmentPageInternalUser.navigateAndVerifyProvidersEnrollmentSpanStatus(Data.INDIVIDUAL_COC_APPLICATION, Locators.ENROLLMENT_SPAN_REASON,-7);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,Data.INDIVIDUAL_COC_APPLICATION,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusApprove, trackingNum);
        excel.readExcel();
    }

    /**
     *  This method logs in as an Approved Individual Provider. Navigates to CoC tab, clicks on Coc button and clicks on "Identifying Information" and clears providers Middle Name. Then Sends a new Middle Name
     *  and submits the request.Gets and stores the application tracking number and logs out as provider.Then logs in as an internal user and Denied the CoC request. Navigates to CoC tab and searches for
     *  the provider and verifies if status has changed to "Denied". writes the data into ProviderInfo.xlsx
     *
     * @param firstName firstName column value from ProviderInfo.xlsx
     * @param lastName lastName column value from ProviderInfo.xlsx
     * @param emailID email column value from ProviderInfo.xlsx
     * @param taxonomy taxonomy column value from ProviderInfo.xlsx
     * @param npi npi column value from ProviderInfo.xlsx
     * @param trackingNumber trackingNum column value from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getIndProviderNameEmailTaxNPIWithApprovedStatus", dataProviderClass = DataProviderForProviderInfo.class
            , dependsOnGroups = {"ApproveIndividualEnrollment"}, groups = {"IndividualCoCDenial"})
    public void createDenyCocIdentifyingInformation(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC Identifying Information
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING);
        coc.cocIdentifyingInformation();
        enrollmentsAndCoc.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String trackingNum = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of COC to denied
        homePage.signInToApp(internalUserEmail, internalUserPassword);

        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusDenied);

        //Search For Denied CoC
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_DENIED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_DENIED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,Data.INDIVIDUAL_COC_APPLICATION,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusDenied, trackingNum);
        excel.readExcel();
    }
    /**
     *  This method Login as the Approved Individual Provider. Goes to CoC Tab, clicks on the Coc button and add a new CoC for Ownership.Then Verifies and validates the error message.
     * Also Creates a new CoC for Program Participation and Verifies and validates the error message.
     *
     * @param firstName firstName column value from ProviderInfo.xlsx
     * @param lastName lastName column value from ProviderInfo.xlsx
     * @param emailID email column value from ProviderInfo.xlsx
     * @param trackingNum trackingNum column value from ProviderInfo.xlsx
     *
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class,
          dependsOnGroups = {"RegisterAndSubmitIndividualEnrollment","ApproveIndividualEnrollment"})
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
