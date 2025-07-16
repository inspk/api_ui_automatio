package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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
 * This test class verifies approving the appeal of a denied Facility CoC.
 */
@Listeners(VideoListener.class)
public class FacilityProviderCoCAndAppealApprovalProcessTest extends BaseClassUI {

    String enrollmentType = Data.FACILITY_APPEAL_APPLICATION;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test method retrieves a Facility CoC with 'Denied' status from ProviderInfo.xlsx, logs into DyP as the
     * Facility Provider, creates a CoC appeal request, logs out as the Facility Provider, logs into DyP as an Internal
     * User, executes a search for the CoC appeal request, approves the CoC appeal request, verifies the status of the
     * approved CoC appeal request, logs out as the Internal User and writes the status of the CoC appeal request to
     * ProviderInfo.xlsx.
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
    @Test(dataProvider = "getFacilityProviderNameWithCOCStatusDenied", dataProviderClass = DataProviderForProviderInfo.class)
    public void createFacilityEnrollmentCoCProcessApproveAppealTest(String testEnvironment, String firstName, String lastName, String emailID,String taxonomy, String npi, String trackingNumber) throws Exception {

        //Login as a provider to verify the coc Denied status and submit an Appeal
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.javaWaitSec(5);
        coc.ajaxClick(Locators.COC_TAB);
        coc.javaWaitSec(5);
        coc.ajaxScroll(Locators.PART_OF_ENROLLMENT_INFO);

        //Get the Denied COC with the trackingNumber and appeal
        enrollmentsAndCoc.getSpecificCocAndAppeal(trackingNumber);

        providerPortal.uploadFileAndSubmit();
        enrollmentsAndCoc.navigateToAppealAndSearchForEnrollment();
        Reports.log("Click button: " + Data.TEXT_SEARCH);
        enrollmentPageInternalUser.ajaxClick(Locators.BUTTON_SEARCH);
        coc.javaWaitSec(3);
        String trackingNumAppeal = coc.getProviderCoCID();
        enrollmentPageInternalUser.logOut();

        //login as internal user to approve the COC Appeal
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName + " " + lastName, trackingNumAppeal);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_APPROVED_UPPERCASE);

        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, emailID, providerEmailPassword,taxonomy,npi, Data.ApplicationStatusApprove, trackingNumAppeal);
        excel.readExcel();
        }
    }


