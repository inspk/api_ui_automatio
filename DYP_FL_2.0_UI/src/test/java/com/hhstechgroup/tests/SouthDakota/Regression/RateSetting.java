package com.hhstechgroup.tests.SouthDakota.Regression;

import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class RateSetting extends BaseClassUI {
    /**
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @throws Exception
     */
    @Test(dataProvider = "Enrollment Type", groups = {"RegisterAndSubmitEntityProvider"})
    public void ratesettings(String testEnvironment, String testEmailAccount, String enrollmentType,
                             String newEmail, String firstName, String lastName, String taxonomyCategory, String taxonomy, String enrollmentDate){

        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.openSystemOptions();

        systemOptions.navigateToProverApvlConfiguration(enrollmentType);

        systemOptions.clickonApprovalconfigurationforGroupProvider(Data.GROUP_CONFIGURATION_Enrollment);

        systemOptions.verifyRateSettings();

        dashboardPage.logOut();

    }

}
