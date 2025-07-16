package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test class verifies the Facility enrollment 'Document Review' status.
 */
@Listeners(VideoListener.class)
public class FacilityEnrollmentSubmitDocumentReview extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);

    /**
     * This test method retrieves a Facility enrollment with no status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, verifies the enrollment 'Document Review' status
     * and writes the status of the enrollment to ProviderInfo.xlsx
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param trackingId
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getFacilityProviderNameEmailWithSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
           dependsOnGroups = "FacilityRegisterAndSubmit",
      groups = "FacilityDocumentReview")
    public void verifyFacilityEnrollmentDocumentReviewStatus (String testEnvironment,String firstName, String lastName, String email, String trackingId) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "DOCUMENT REVIEW"
     */

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingId);

        //Get application current status
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.facilityApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }

}
