package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved pharmacy enrollment, creates and approves site visit.
 */
public class PharmacyProviderCreateAndApproveSiteVisitTest extends BaseClassUI {
    String enrollmentType ="Pharmacy" ;
    String providerID ;

    /**
     * This method signs in as an internal user, click on provider tab and searches for the pharmacy approved provider. Clicks
     * on the row in search result table. Get the provider id and stores it. Then Clicks on site visit tab, Clicks
     * on add site visit button to see a popup. Enters Provider id, Clicks on create button and clicks on next button
     * . Clicks on Upload Document Button and clicks on submit button. Clicks again on site visit tab, searches the provider id
     * and then clicks on the ellipses.Clicks on view option and changes the status of the site visit to "Approved".
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Test(dataProvider="getPharmacyProviderNameWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
    public void createSiteVisitAndApprove(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
       enrollmentPageInternalUser.clickProvidersTab();
        enrollmentPageInternalUser.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(enrollmentType,firstName+" "+lastName);
        providerID =  enrollmentPageInternalUser.getProvidersID();
        enrollmentPageInternalUser.NavigateToSiteVisitPage();
        enrollmentPageInternalUser.createSiteVisitForProvider(providerID);
        enrollmentPageInternalUser.searchProviderAndChangeStatusOfSiteVisit(providerID, Data.ApplicationStatusApprove);
    }
}
