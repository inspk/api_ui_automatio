package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iii_GroupEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)
/**
 * This test class sets the Systems Option configuration for Group Provider.
 */
public class GroupProviderPreConditionSetupTest extends BaseClassUI {
    String providerType = "Group Providers" ;

    /**
     * This test method logs into DyP as an Internal user and sets the Systems Option configuration for a Group Provider
     * as 1 Approver and 1 Reviewer (Enrollment, Re-Enrollment and Revalidation) and 1 Approver and 0 Reviewers
     * (CoC, Appeal and SiteVisits).
     */
    @Video
    @Test
    public void GroupProviderPreConditionSetup() {
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

