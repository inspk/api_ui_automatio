package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This test class verifies approving the appeal of a denied Facility enrollment.
 */
@Listeners(VideoListener.class)
public class FacilityProviderAppealApprovalProcessTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a denied Facility enrollment from ProviderInfo.xlsx, logs into DyP as the Facility
     * Provider, creates an enrollment appeal request, logs out as the Facility Provider, logs into DyP as an Internal
     * User, executes a search for the enrollment appeal request, approves the enrollment appeal request and logs out as
     * the Internal User, logs into DyP as the Facility Provider, verifies the appeal status and writes the status of
     * the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNumber
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getFacilityProviderInfoWithStatusDenied"  ,
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"RequestForAdditionalInfoAndDenyApplication"},
            groups = "FacilityAppealApprove")
    public void FacilityEnrollmentAppealAndApprove(String testEnvironment, String firstName, String lastName, String emailID, String trackingNumber) throws IOException {
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        enrollmentPageProvider.ClickOnAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentPageProvider.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);
        enrollmentPageProvider.javaWaitSec(10);
        String requestID = enrollmentPageProvider.getRequestID();
        System.out.print(requestID);
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName+" "+lastName);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(Data.ApplicationStatusApprove);
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus();
        enrollmentPageInternalUser.logOut();


        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.javaWaitSec(10);
        String currentStatusCoc = driver.findElement(Locators.ENROLLMENT_INFO_STATUS).getText();
        Assert.assertTrue(currentStatusCoc.contains("ACTIVE"));
        Reports.log("Status is Approved");

        ProviderInformation.updateProviderData(providerInfoSheet, Data.facilityAffApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}
