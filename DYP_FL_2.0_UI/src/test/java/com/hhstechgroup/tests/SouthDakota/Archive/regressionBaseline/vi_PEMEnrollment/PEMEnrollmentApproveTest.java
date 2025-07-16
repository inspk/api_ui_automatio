package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get a submitted PEM and approves it.
 */
public class PEMEnrollmentApproveTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as an internal user and clicks on enrollment tab. Then searches for the provider and clicks
     * on the row in search result. Clicks on change status and selects "Approved" to change the status of a PEM enrollment
     * from "PENDING APPROVAL" to "Approved" and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPemProviderNameWithNoStatus"  ,
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"RegisterAndSubmitPEMEnrollment"}, groups = {"ApprovePemEnrollment"})
    public void approveEnrollmentApplication (String testEnvironment,String firstName, String lastName, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING APPROVAL",trackingNum);
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusApprove);
        }

        //Write To ProviderInfo
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus() ;
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet,Data.pemApplication,firstName,lastName,statusOfApplication);
        excel.readExcel();
    }
}

