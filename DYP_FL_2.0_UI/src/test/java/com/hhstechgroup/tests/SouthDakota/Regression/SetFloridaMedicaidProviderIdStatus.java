package com.hhstechgroup.tests.SouthDakota.Regression;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class SetFloridaMedicaidProviderIdStatus extends BaseClassUI {

    /**
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @throws Exception
     */

    @Test(dataProvider = "Enrollment Type",dependsOnGroups = "approveMCOEnrollmentTest",
            groups = {"verifyAndSetFloridaMedicaidProviderIdStatus"})
    public void verifyAndSetFloridaMedicaidProviderIdStatus(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                            String newEmail, String firstName, String lastName, String taxonomyCategory,
                                                            String taxonomy, String enrollmentDate){

        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.openSystemOptions();

        systemOptions.navigateToProverApvlConfiguration(enrollmentType);

        systemOptions.clickonApprovalconfigurationforGroupProvider(enrollmentType);

        systemOptions.verifyAndSetFloridaMedicaidProviderIdStatus();

        dashboardPage.logOut();


    }
}
