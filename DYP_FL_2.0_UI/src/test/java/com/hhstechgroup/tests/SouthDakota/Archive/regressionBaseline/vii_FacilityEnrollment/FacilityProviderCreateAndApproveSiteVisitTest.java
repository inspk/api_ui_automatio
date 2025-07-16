package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This test class verifies a Facility Site Visit approval.
 */
@Listeners(VideoListener.class)
public class FacilityProviderCreateAndApproveSiteVisitTest extends BaseClassUI {
    String enrollmentType ="Facility" ;
    String providerID ;

    /**
     * This test method retrieves a Facility enrollment with 'Approved' status from ProviderInfo.xlsx, logs into DyP
     * as an Internal User, executes a search for the enrollment, retrieves the Provider ID, navigates to the Site
     * Visit page, creates a Site Visit and approves the Site Visit.
     *
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getFacilityProviderInfoWithStatusApproved", dataProviderClass = DataProviderForProviderInfo.class)
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
