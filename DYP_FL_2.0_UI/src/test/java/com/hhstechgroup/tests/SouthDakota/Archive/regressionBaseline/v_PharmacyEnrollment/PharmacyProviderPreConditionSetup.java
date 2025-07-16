package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test class sets the Systems Option configuration for Pharmacy Provider.
 */

@Listeners(VideoListener.class)
public class PharmacyProviderPreConditionSetup extends BaseClassUI {
    int noOfApprovers = 1;
    Boolean reviewSwitchStatus = false ;
    String providerType = "Pharmacy" ;

    /**
     * This test method logins as Internal user and sets the Systems Option configuration for Pharmacy Provider as,
     * 1 Approver and 1 Reviewer for Enrollment, Re-Enrollment, Revalidation
     * 1 Approver and 0 Reviewer for CoC, Appeal and SiteVisits
     */
    @Test
    public void pharmacyProviderPreConditionSetupTest() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.ENROLLMENT,1,true);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.RE_ENROLLMENT,1,true);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.REVALIDATION,1,true);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.APPEAL,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.CHANGE_OF_CIRCUMSTANCE,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.SITE_VISIT,1,false);
    }
}
