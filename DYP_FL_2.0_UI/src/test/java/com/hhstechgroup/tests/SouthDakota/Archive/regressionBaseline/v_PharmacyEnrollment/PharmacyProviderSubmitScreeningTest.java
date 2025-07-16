package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This class contains a test that under screens a pharmacy enrollment using a data provider.
 */
public class PharmacyProviderSubmitScreeningTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as an internal user, clicks on enrollment tab and searches
     * for the provider. Then does the under screening. For verification checks the status
     * to see if it is in "Pending Approval". At the end the info writes out to ProviderInfo.xlsx.
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getPharmacyProviderNameWithUnderScreeningStatus",
            dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyPharmacyEnrollmentSubmitScreening (String testEnvironment, String firstName, String lastName, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "UNDER SCREENING"
        04. Take request id
        05. Edit screening.xml and request id,
        06. Get cookies of internal user
        07. Send 1 API screening call with new request id
        08. Timer waits required status and click "Search" button with specific delay 10 times
     */

        homePage.signInToApp(internalUserEmail, internalUserPassword);

        //SCREEN ENROLLMENT
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNumber,Data.pendingReviewStatus);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.pharmacyApplication,firstName,lastName,Data.ApplicationStatusPendingReview);
        excel.readExcel();
    }
}
