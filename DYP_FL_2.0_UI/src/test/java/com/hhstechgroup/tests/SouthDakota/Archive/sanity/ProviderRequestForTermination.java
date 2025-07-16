package com.hhstechgroup.tests.SouthDakota.Archive.sanity;

import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class ProviderRequestForTermination extends BaseClassUI {
    DataFiles dataFiles = new DataFiles();
    String providerEmail = dataFiles.getData("Email", "Individual1", "Approved");
    String firstNameProvider = dataFiles.getData("First_Name", "Individual1", "Approved");
    String lastNameProvider = dataFiles.getData("Last_Name", "Individual1", "Approved");

    @Test(priority = 1)
    public void createTerminationRequest() {
        homePage.signInToApp(providerEmail, providerEmailPassword);
        providerPortal.terminationRequest();
        enrollmentPageInternalUser.logOut();
    }

    @Test(priority = 2)
    public void approveTerminationRequest() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();
        enrollmentPageInternalUser.searchProviderAndApproveTerminationRequest(firstNameProvider, lastNameProvider);
        enrollmentPageInternalUser.logOut();
    }
}
