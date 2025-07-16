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
 * This class contains a test that does the document review of an ORP enrollment using a data provider.
 */
public class ORPProviderVerifyDocumentReviewTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet,0);

    /**
     * This method logs in as an internal user, clicks on enrollment tab and searches
     * for the provider. Then clicks on the row in the search result and clicks on change status button.
     * selects "Document Review Approved" from the list, clicks apply button and logs out. At the end
     * updates ProviderInfo.xlsx.
     * @param firstName
     * @param lastName
     * @param trakingNumber
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getORPProviderNameWithStatusSubmitted",
          dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = "RegisterAndSubmitORPEnrollment", groups = "ORPDocumentReview")
    public void verifyORPEnrollmentDocumentReviewStatus (String testEnvironment,String firstName, String lastName,String trakingNumber) throws Exception {

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trakingNumber);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write To ProviderInfo
        ProviderInformation.updateProviderData(providerInfoSheet,  Data.orpApplication,firstName,lastName,Data.APPLICATION_STATUS_UNDER_SCREENING);
        excel.readExcel();
    }
}