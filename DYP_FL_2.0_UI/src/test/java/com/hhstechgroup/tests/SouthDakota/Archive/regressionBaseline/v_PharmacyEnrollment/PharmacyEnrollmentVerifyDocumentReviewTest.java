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




/**
 * This class contains a test that does the document review of a pharmacy enrollment using a data provider.
  */
@Listeners(VideoListener.class)
public class PharmacyEnrollmentVerifyDocumentReviewTest extends BaseClassUI{

    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);

    /**
     * This method logs in as an internal user, clicks on enrollment tab and searches for the provider.
     * Then clicks on the row in the search result, clicks on change status button and selects "Document
     * Review Approved" from the list. Clicks apply button and logs out. At the end updates ProviderInfo.xlsx.
     * @param firstName
     * @param lastName
     * @param trackingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getPharmacyProviderNameWithSubmittedStatus",
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
        enrollmentPageInternalUser.documentReview(firstName,lastName, trackingNumber);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.pharmacyApplication,firstName,lastName,Data.APPLICATION_STATUS_UNDER_SCREENING);
        excel.readExcel();
    }
}
