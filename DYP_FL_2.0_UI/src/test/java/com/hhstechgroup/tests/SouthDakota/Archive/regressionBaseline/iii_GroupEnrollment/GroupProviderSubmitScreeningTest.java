package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

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
 * This test class verifies changing the status of a Group enrollment from 'Under Screening' to 'Pending Review'.
 */
@Listeners(VideoListener.class)
public class GroupProviderSubmitScreeningTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method retrieves a Group enrollment with 'Under Screening' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, screens the enrollment, logs out as the Internal
     * User and writes the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithUnderScreeningStatus",
          dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyGroupEnrollmentSubmitScreening (String testEnvironment,String firstName, String lastName, String trackingNumber) throws Exception {

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
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.groupApplication,firstName,lastName,Data.ApplicationStatusPendingReview);
        excel.readExcel();
    }
}