package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test class verifies the submission and denial of a Facility Identifying Information CoC.
 */
@Listeners(VideoListener.class)
public class FacilityProviderCocDenyProcessTest extends BaseClassUI {

    String enrollmentType = Data.FACILITY_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test method retrieves a Facility Provider with 'Approved' status from ProviderInfo.xlsx, logs into DyP as the
     * Facility Provider, creates an Identity Information CoC request, logs out as the Facility Provider, logs into DyP
     * as an Internal User, executes a search for the Identity Information CoC request, denies the Identity Information
     * CoC request, verifies the status of the Identity Information CoC request, logs out as the Internal User and
     * writes the status of the Identity Information CoC request to ProviderInfo.xlsx.
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
    @Test(dataProvider = "getFacilityProviderNameEmailTaxNPIWithApprovedStatus", dataProviderClass = DataProviderForProviderInfo.class)
    //,dependsOnGroups = {"FacilityAppealApprove"})
    public void createDenyCocIdentifyingInformation(String testEnvironment,String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC Identifying Information
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoc(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING);
        coc.cocIdentifyingInformationGeneratedName();
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
        excel.writeTestData(testEnvironment,enrollmentType, firstName, lastName, emailID, providerEmailPassword, taxonomy, npi, Data.ApplicationStatusDenied, trackingNum);
        excel.readExcel();
    }
}
