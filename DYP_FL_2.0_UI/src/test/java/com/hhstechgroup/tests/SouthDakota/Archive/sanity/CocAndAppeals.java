package com.hhstechgroup.tests.SouthDakota.Archive.sanity;

import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviders;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class CocAndAppeals extends BaseClassUI {

    @Test(dataProvider = "coc", dataProviderClass = DataProviders.class, priority = 1)
    public void createApproveDenyCocAddress(String statusOfCoc, String firstName, String lastName, String email, String enrollmentType, String address) {

        //Create and submit COC address
        homePage.signInToApp(email, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.createCoCForEnrollment(enrollmentType, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_KEY_PERSONNEL);
        coc.cocAddKeyPersonnel();
        enrollmentsAndCoc.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String trackingNum = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of COC to APPROVED or DENIED
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName+" "+lastName, trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplicationWithReason(statusOfCoc);
        enrollmentPageInternalUser.logOut();
    }

    @Test(dataProvider = "appeals", dataProviderClass = DataProviders.class, priority = 2)
    public void createApproveDenyAppeals(String  statusOfAppeal, String firstName, String lastName, String email) {

        //Create and submit COC address
        homePage.signInToApp(email, providerEmailPassword);
        coc.closeAllPopUps();
        providerPortal.navigateToAppealAndClickAppealButton();
        providerPortal.uploadFileAndSubmit();
        enrollmentsAndCoc.navigateToAppealAndSearchForEnrollment();

        String trackingNum = coc.getProviderCoCID();

        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of APPEAL to APPROVED or DENIED
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToAppealAndSearchForTheProvider(firstName+" "+lastName, trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplication(statusOfAppeal);
        enrollmentPageInternalUser.logOut();
    }
}
