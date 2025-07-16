package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)
/**
 * This class contains a test that uses a data provider to get a Approved Individual provider, Creates an Site Visit for that provider and approves it.
 */


public class IndividualProviderCreateAndApproveSiteVisitTest extends BaseClassUI {
    String enrollmentType ="Individual" ;
    String providerID ;

    /**
     * This method logs in as Internal user. Navigate to the Provider Tab. Searches for the Approved Individual provider and gets the ProviderID
     * Goes to Site Visit tab and creates and submits the site visits. Searches for the Provider and changes the status to Approve
     * @param firstName firstName column value  from ProviderInfo.xlsx
     * @param lastName lastName column value  from ProviderInfo.xlsx
     * @param emailID trackingNum column value  from ProviderInfo.xlsx
     * @param trackingNum trackingNum column value  from ProviderInfo.xlsx
     *
     * @throws Exception
     */
    @Video
    @Test(dataProvider="getIndProviderNameAndEmailWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void createSiteVisitAndApprove(String testEnvironment, String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
       enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        providerID =  enrollmentPageInternalUser.getProvidersID();
        enrollmentPageInternalUser.NavigateToSiteVisitPage();
        enrollmentPageInternalUser.createSiteVisitForProvider(providerID);
        enrollmentPageInternalUser.searchProviderAndChangeStatusOfSiteVisit(providerID, Data.ApplicationStatusApprove);
    }
}
