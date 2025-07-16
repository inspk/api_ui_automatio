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

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get a submitted PEM and deny it.
 */
public class PEMEnrollmentDenyTest extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This method changes the status of a PEM enrollment from "PENDING APPROVAL" to "Denied" and updates ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getPemProviderNameWithNoStatus",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = "RegisterAndSubmitPEMEnrollment", groups = "DenyPemEnrollment")
    public void denialEnrollmentApplication(String testEnvironment,String firstName, String lastName,String trackingNum) throws Exception {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName, lastName, "PENDING APPROVAL",trackingNum);
        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(Data.ApplicationStatusDenied);
        }
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus();
        enrollmentPageInternalUser.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, Data.pemApplication, firstName, lastName, statusOfApplication);
        excel.readExcel();
    }
}

