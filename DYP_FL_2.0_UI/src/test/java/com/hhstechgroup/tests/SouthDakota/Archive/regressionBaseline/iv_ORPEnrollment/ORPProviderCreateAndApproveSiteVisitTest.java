package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved ORP provider and creates and approves site visit.
 */
public class ORPProviderCreateAndApproveSiteVisitTest extends BaseClassUI {
    String enrollmentType ="ORP" ;
    String providerID ;

    /**
     * This method signs in as an internal user and click on provider tab. Then searches for the ORP approved provider, clicks on
     * the row in search result table. Get the provider id and stores it. Then Clicks on site visit tab and Clicks
     * on add site visit button so a popup displayed. Enters Provider id and Clicks on create button, clicks on next button
     * , clicks on Upload Document Button and clicks on submit button. Clicks again on site visit tab, searches the provider id
     * and clicks on the ellipses Then clicks on view option and changes the status of the site visit to "Approved".
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Test(dataProvider="getORPProviderNameWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void CreateSiteVisitAndApprove(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
       enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        providerID =  enrollmentPageInternalUser.getProvidersID();
        enrollmentPageInternalUser.NavigateToSiteVisitPage();
        enrollmentPageInternalUser.createSiteVisitForProvider(providerID);
        enrollmentPageInternalUser.searchProviderAndChangeStatusOfSiteVisit(providerID, Data.ApplicationStatusApprove);
    }
}
