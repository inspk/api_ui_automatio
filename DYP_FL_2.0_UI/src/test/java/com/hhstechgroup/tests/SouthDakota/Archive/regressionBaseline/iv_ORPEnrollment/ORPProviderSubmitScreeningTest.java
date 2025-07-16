package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

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
 * This class contains a test that performs under screens an ORP enrollment using a data provider
 */
public class ORPProviderSubmitScreeningTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method logs in as an internal user. Clicks on enrollment tab, searches
     * for the provider and does the under screening. For verification checks the status
     * to see if it is in "Pending Approval". At the end the info writes out to ProviderInfo.xlsx.
     * @param firstName
     * @param lastName
     * @param trakingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getORPProviderNameWithStatusUnderScreening",
            dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = "ORPDocumentReview", groups = "ORPScreening")
    public void verifyORPEnrollmentSubmitScreening (String testEnvironment,String firstName, String lastName,String trakingNumber) throws Exception {

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        String providerName = firstName + " " + lastName;
        enrollmentPageInternalUser.searchProvider(providerName,trakingNumber);

        //SCREEN ENROLLMENT
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trakingNumber,Data.statusPendingApproval);
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING APPROVAL",trakingNumber);
        String applicationStatus = enrollmentPageInternalUser.getApplicationStatus();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.orpApplication,firstName,lastName,Data.pendingApprovalStatus);
        excel.readExcel();
    }
}