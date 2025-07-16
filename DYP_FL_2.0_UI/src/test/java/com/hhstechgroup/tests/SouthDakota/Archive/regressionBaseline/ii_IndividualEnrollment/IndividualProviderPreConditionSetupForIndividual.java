package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.ii_IndividualEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * This test class sets the Systems Option configuration for Individual Provider.
 */

@Listeners(VideoListener.class)
public class IndividualProviderPreConditionSetupForIndividual extends BaseClassUI {
    String providerType = "Individual Providers" ;

    /**
     * This test method logins as Internal user and sets the Systems Option configuration for Individual Provider as,
     * 1 Approver and 1 Reviewer for Enrollment, Re-Enrollment, Revalidation
     * 1 Approver and 0 Reviewer for CoC, Appeal and SiteVisits
     */
    @Video
    @Test
    public void IndividualProviderPreConditionSetupTest() {
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
