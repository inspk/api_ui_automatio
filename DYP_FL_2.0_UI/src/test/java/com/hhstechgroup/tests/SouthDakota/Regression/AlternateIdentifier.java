package com.hhstechgroup.tests.SouthDakota.Regression;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.Pages.IUEnrollmentPage;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hhstechgroup.Pages.IUEnrollmentPage.CHOW;
import static com.hhstechgroup.Pages.IUEnrollmentPage.InActive;

@Listeners(VideoListener.class)
public class AlternateIdentifier extends BaseClassUI {

    /**
     * Alternate Identifier for Enrollment module
     * Both add and edit
     */
    @Test
    public void AlternateIdentifierEnrollmentModule() {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        dashboardPage.clickEnrollTab();

        // Alternate Identifier for Individual Enrollment
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.IndividualEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

        //Alternate Identifier foe Entity Enrollment
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.EntityEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

        //Alternate Identifier for TP Enrollment
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.TPEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

        //Alternate Identifier for PEM Enrollment
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.PEMEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();
    }

    /**
     * Alternate Identifier for Provider module
     * Both add and edit
     */
    @Test
    public void AlternateIdentifierProviderModule() {
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        dashboardPage.clickProvidersTab();

        //Alternate Identifier for Individual Enrollment
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.IndividualEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

        //Alternate Identifier for Entity Enrollment
        dashboardPage.clickProvidersTab();
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.EntityEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

        //Alternate Identifier for TP Enrollment
        dashboardPage.clickProvidersTab();
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.TPEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

        //Alternate Identifier for PEM Enrollment
        dashboardPage.clickProvidersTab();
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.PEMEnrollment);
        addAlternateIdentifierPage.ClickAddAlternateIdentifier();
        addAlternateIdentifierPage.FillAlternateIdentifierForm(IUEnrollmentPage.Provider_Medicaid_Id, IUEnrollmentPage.Phone_Number, IUEnrollmentPage.New_Enrollment);
        addAlternateIdentifierPage.VerifyConfirmationMessageForAddAlternateIdentifier();

        editAlternateIdentifier.editAlternateIdentifier(CHOW, InActive);
        editAlternateIdentifier.VerifyConfirmationMessageForEditAlternateIdentifier();

    }
}
