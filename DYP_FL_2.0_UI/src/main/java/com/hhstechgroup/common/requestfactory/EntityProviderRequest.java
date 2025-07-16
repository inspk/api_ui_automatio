package com.hhstechgroup.common.requestfactory;


import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.*;

import com.hhstechgroup.utility.Helper;

import static com.hhstechgroup.common.BaseActions.generateNewNumber;

public class EntityProviderRequest extends Request {

    public com.hhstechgroup.utility.Helper Helper= new Helper();


    public void entityProviderEnrollment(String enrollmentType, String providerEmailID, String firstName, String lastName, DashboardPage dashboardPage,
                                         ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements ) throws Exception {

        String npi =  enrollmentFormElements.formElements().get(Data.PROVIDER_NPI);
        String zipCode =  enrollmentFormElements.formElements().get(Data.ZIP_CODE);
        String date =  enrollmentFormElements.formElements().get(Data.ENROLLMENT_DATE);
        String legalBusiness = enrollmentFormElements.formElements().get(Data.LEGAL_BUSINESS);
        String business = enrollmentFormElements.formElements().get(Data.BUSINESS);
        String fein = enrollmentFormElements.formElements().get(Data.FEIN) ;
        String phoneNo = enrollmentFormElements.formElements().get(Data.PHONE_NUM);
        String applicationContactPhone=enrollmentFormElements.formElements().get(Data.APPLICATION_CONTACT_PHONE);

        dashboardPage.clickOnEnrollmentType(Data.ENTITY_PROVIDER);

        // filling Identifying Information section
        providerEnrollingPage.fillInIdentifyingInfoForEntity(legalBusiness, business,fein , providerEmailID, date);

        //Filling Provider Identifiers section
        providerEnrollingPage.fillProviderIdentifierSectionEntityEnrmt(npi);

        providerEnrollingPage.fillInOwnershipSectionEntityEnrollment();

        //Filling Key Personnel Section
        providerEnrollingPage.fillInKeyPersonalSectionEntity(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType, npi);

        // Verify Exclusion/Sanction and fill the Section
        providerEnrollingPage.fillInExclusionAndSanctionSection();

        //EFT Information Section
        providerEnrollingPage.fillInEFTInformationSection(Data.ENTITY_PROVIDER,firstName);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD);

        providerEnrollingPage.mailingAddressContactPerson(firstName, lastName, phoneNo, providerEmailID);

        // Program Participation Section
        providerEnrollingPage.fillInProgramParticipation(enrollmentType,Data.MEDICAID_CHIP, Data.MENTAL_HEALTH_AND_SUBSTANCE, Data.TAXONOMY_SUBSTANCE_USE_DISORDER, Data.LICENSE_TYPE_DSS_CERTIFICATION, firstName, lastName);

        // Service Location Section
        providerEnrollingPage.fillInServiceLocationSection(enrollmentType, providerEmailID, zipCode, Data.MEDICAID_CHIP, Data.TAXONOMY_SUBSTANCE_USE_DISORDER);

        //PCP Addendum Section
        providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //fill Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    /**
     * This method submits RAI request fpr Entity Provider,
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitRAI(String enrollmentType, String firstName, String lastName,DashboardPage dashboardPage,
                          ProviderEnrollingPage providerEnrollingPage) throws Exception {

        providerEnrollingPage.updateLegalBusinessInIdentificationInfoSec(Data.UPDATED_LBN);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    public void submitCOC(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                          CocsPage cocsPage, String[] categoryList) throws Exception {
        String cocCategoryList = String.valueOf(cocsPage.getCocCategoryList(categoryList));
        cocsPage.navigateAndClickCoC();
        cocsPage.selectProgramParticipationRadioBtn();

//        cocsPage.clickNextButtonOnCOCPopUP();
//        cocsPage.selectCoCFromCategorySelection(categoryList);
//        cocsPage.selectCoCFromCategorySelection(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_ADDRESS);

        cocsPage.clickCreateCocButton();
        if(cocCategoryList.contains(Data.COC_SELECT_CHECKBOX_PGRM_PARTICIPATION_OR_TAXONOMY_LICENSE)){
            cocsPage.cocProgramParticipationSection();}
        cocsPage.cocSummeryAndSubmit();
        dashboardPage.clickAnyButton(Data.TEXT_GO_TO_COC);

    }

    /**
     * This method submits Reconsideration request for Entity Provider,
     *
     * @param dashboardPage
     * @param reconsiderationPage
     * @throws Exception
     */

    public void submitReconsideration(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, ReconsiderationPage reconsiderationPage) throws Exception {
        dashboardPage.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        dashboardPage.ClickOnAppealButton();
        reconsiderationPage.uploadFileAndSubmit();
    }

    public void submitRevalidation(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage) throws Exception {

        dashboardPage.closeAllPopUps();
        dashboardPage.ajaxScrollUp();
        dashboardPage.verifyRevalidationMessage();
        dashboardPage.clicksOnCreateRevalidationButton();

        //Program Participation Section
//        providerEnrollingPage.fillInProgramParticipation(enrollmentType,Data.ADSL, Data.LONG_TERM_SERVICE, Data.TAXONOMY_COMMUNITY_SUPPORT,Data.LICENSE_TYPE, firstName, lastName);

        //Verify the green checkmarks displayed on the Revalidation request tab
        String[] entitySectionList = {Data.ENROLLMENT_IDEN_INF_SECTION,
                Data.ENROLLMENT_PROV_IDEN_SECTION,
                Data.ENROLLMENT_OWNRSHIP_SECTION,
                Data.ENROLLMENT_KEY_PER_SECTION,
                Data.ENROLLMENT_EXC_SANC_SECTION,
                Data.ENROLLMENT_EFT_INF_SECTION,
                Data.ENROLLMENT_ADDRESS_DET_SECTION,
                Data.ENROLLMENT_PROGRAM_PARTICIPATION_SECTION,
                Data.ENROLLMENT_SERV_LOC_SECTION,
                Data.ENROLLMENT_UPLOAD_SECTION,
                Data.ENROLLMENT_AFFILIATION_SECTION

                };

        dashboardPage.VerifyTabCheckMark(entitySectionList,enrollmentType);
        //dashboardPage.verifySectionsForRevalidation(enrollmentType);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    public EntityProviderRequest() {

    }

    public void submitTermination(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                  ProviderEnrollingPage providerEnrollingPage) throws Exception {
        dashboardPage.VerifyProviderApplicationStatusIs(Data.APPLICATION_STATUS_ACTIVE2);
        dashboardPage.createTerminationRequest();

    }
    /**
     * This method populates Entity Data Change request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerID
     * @throws Exception
     */
    public void submitProviderDataChange(String enrollmentType, String firstName, String lastName, String providerEmail,
                                         String providerEmailPassword, String providerID, IUEnrollmentPage iuEnrollmentPage, DashboardPage dashboardPage, SDHomePage sdhomePage) throws Exception {

        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.ENTITY_PROVIDER_INITIALS, providerID);
        iuEnrollmentPage.clickEnrollmentDetails();
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        String newDBA = HomePage.generateDBABusiness();
        Reports.log( "New DBA is: "+ newDBA);
        iuEnrollmentPage.modifyEnrollmentInformationSectionFieldText(Data.FIELD_TEXT_DBA_DATA_CHANGE, newDBA,1);
        //Return to Provider's Tab and verify that changes are saved
        iuEnrollmentPage.clickProvidersTab();
        iuEnrollmentPage.clickAnyButton(Data.TEXT_SEARCH);
        iuEnrollmentPage.clickSearchResultRow();
        //Will uncomment when necessary
        //iuEnrollmentPage.closeNpiPoUp();
        iuEnrollmentPage.clickEnrollmentDetails();
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.FIELD_TEXT_DBA_DATA_CHANGE, newDBA);
        dashboardPage.logOut();

        // Log in as provider and verify that changes are saved
        sdhomePage.signInToApp(providerEmail, providerEmailPassword);
        iuEnrollmentPage.closeAlert();
        dashboardPage.clickApprovedProviderTab(Data.textProviderDataTab);
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.FIELD_TEXT_DBA_DATA_CHANGE, newDBA);
        dashboardPage.logOut();
    }
    /**
     * This method submits ReEnrollment request for Entity Provider,
     *
     * @param dashboardPage
     * @throws Exception
     */

    public void submitReEnrollment(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {

        providerEnrollingPage.clickOnReEnrollmentApplBtn();
        // Requested Enrollment Date
        providerEnrollingPage.fillInRequestedEnrollmentDateInformation(HomePage.getCurrentDate());

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }
}
