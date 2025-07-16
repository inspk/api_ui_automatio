package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This test class sets the Systems Option configuration for PEM Provider.
 */


public class PEMProviderPreConditionSetupTest extends BaseClassUI {

    String providerType = "Provider Enrollment Manager" ;

    /**
     * This test method logins as Internal user and sets the Systems Option configuration for PEM Provider as,
     * 1 Approver and 0 Reviewer for Enrollment, Re-Enrollment, Revalidation, CoC, Appeal and SiteVisits
     */
    @Test
    public void pemProviderPreConditionSetupTest() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.navigateToProverApvlConfiguration(providerType);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.ENROLLMENT,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.RE_ENROLLMENT,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.REVALIDATION,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.APPEAL,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.CHANGE_OF_CIRCUMSTANCE,1,false);
        systemOptionsIE.VerifyProverApvlConfiguration(Data.SITE_VISIT,1,false);
    }
}
