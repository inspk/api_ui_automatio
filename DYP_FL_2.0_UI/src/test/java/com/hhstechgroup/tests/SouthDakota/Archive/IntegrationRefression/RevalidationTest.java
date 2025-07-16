package com.hhstechgroup.tests.SouthDakota.Archive.IntegrationRefression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.SDMongoDBHandler;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hhstechgroup.common.BaseActions.changeDayInCurrentDate;

@Listeners(VideoListener.class)
public class RevalidationTest extends BaseClassUI {
    protected String providerInfoSheet = "ProviderInfo.xlsx";

    /**
     * This test revalidates Billing Provider.
     * @param testEnvironment
     * @param applicationType
     * @param providerEmailId
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws Exception
     */

//    SIT	Trading Partner (TP) Enrollment	Kraig	Schulist	sd.test.provider+97013@gmail.com	Password1!	1144485509	Active	000-000-028
    String applicationType = Data.ENTITY_PROVIDER_INITIALS;

    String trackingNum = "000-000-328";

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void revalidateBillingProvider() throws Exception {

//        requestStatusChange.setToRevalidationStatus(testEnvironment,environmentUrl,applicationType,internalUserEmail,internalUserPassword,
//                firstName, lastName,trackingNum, providerEmailId,providerEmailPassword, Data.ApplicationStatusApprove);
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();


        String revalidationTimePeriod = "31";
        DataFiles data = new DataFiles();
        String filePath = ".\\src\\main\\java\\com\\hhstechgroup\\utility\\dataBaseconfig.properties";
        String dbName = data.getData("MongoDB_Database_Name", filePath);
        String dbName1 = data.getData("MongoDB_Database1_Name", filePath);
        String collection = data.getData("MongoDB_Collection_Name", filePath);

//         Navigates to Providers tab, Search and opens for a specific Provider.
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);
        String prov_id = iuEnrollmentPage.getProvidersID();
        iuEnrollmentPage.clickProvidersTab();
        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(applicationType, prov_id);
        String providerDataId = iuEnrollmentPage.getProviderDataId();

        //Get the Provider ID from the enrollment displayed in the search results
        String cookies = iuEnrollmentPage.collectCookies(environmentUrl.replace("https://", ""));
        iuEnrollmentPage.changeRevalidationDateAndVerify(environmentUrl, providerDataId, revalidationTimePeriod, cookies, changeDayInCurrentDate(Integer.parseInt(revalidationTimePeriod)));

        new SDMongoDBHandler().updateCollectionFieldValue(providerDataId, dbName, collection);
        new SDMongoDBHandler().updateCollectionFieldValue(providerDataId, dbName1, collection);

        iuEnrollmentPage.clickProvidersTab();
        String revalidationDate = iuEnrollmentPage.getProviderRevalidationDate(prov_id, "1st notification");
        iuEnrollmentPage.clickSearchResultRow();
        iuEnrollmentPage.navigateAndVerifyProvidersNextRevalidationStatus(revalidationDate);

    }
}
