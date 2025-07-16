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
@Listeners(VideoListener.class)

/**
 * This test class verifies the Group enrollment 'Document Review' status.
 */
public class GroupProviderVerifyDocumentReviewTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);

    /**
     * This test method retrieves a Group enrollment with 'Submitted' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, verifies the enrollment 'Document Review' status
     * and writes the status of the enrollment to ProviderInfo.xlsx.
     *
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getGrpProviderNameWithStatusSubmitted",
          dataProviderClass = DataProviderForProviderInfo.class)
    public void verifyGroupEnrollmentDocumentReviewStatus (String testEnvironment, String firstName, String lastName, String trackingNumber) throws Exception {

    /*
        Internal user operations:
        01. Search provider by name
        02. Timer waits required status and click "Search" button with specific delay 10 times
        03. Verify that enrollment application has status "DOCUMENT REVIEW"
     */

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNumber);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.groupApplication,firstName,lastName,Data.APPLICATION_STATUS_UNDER_SCREENING);
        excel.readExcel();
    }
}