package com.hhstechgroup.common.requestfactory;


import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.EnrollmentFormElements;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.common.SDHomePage;
import com.hhstechgroup.utility.Helper;

import static com.hhstechgroup.common.BaseActions.generateANumberOfLength;

public class ServicingProviderRequest extends Request {

    public com.hhstechgroup.utility.Helper Helper= new Helper();
    String medicaidPaymentValue ="No" ;
    String taxonomy;

    public void servicingProviderEnrollment(String enrollmentType, String newEmail, String firstName, String lastName, String middleName, String npi, String zipCode,
                                            DashboardPage dashboardPage, ProviderEnrollingPage providerEnrollingPage, String Date, String epNPI) throws Exception {
        String ssn = generateANumberOfLength(10);
        String applicationContactNo=generateANumberOfLength(10);
        dashboardPage.clickOnEnrollmentType(Data.individualApplication);

        //Identifying Information and Provider Identifier Section for Individual Enrollment
        providerEnrollingPage.fillInIndividualIdentifyingInformation(
                firstName, lastName, middleName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                ssn,applicationContactNo, Data.profitStatusNonProfit, enrollmentType, medicaidPaymentValue,Date);

        //Provider Identifier Section
        providerEnrollingPage.fillInIndividualProviderIdentifiersSection(medicaidPaymentValue, "No", npi, enrollmentType);

        //Ownership
        providerEnrollingPage.fillInOwnershipSectionForServiceProvider();

        providerEnrollingPage.fillInExclusionAndSanctionSection();

        providerEnrollingPage.fillInProgramParticipation(enrollmentType,Data.INDV_MEDICAID_CHIP, Data.THERAPY, Data.TAXONOMY_PHYSICAL_THERAPIST,Data.LICENSE_PHYSICAL_THERAPY_PT, firstName, lastName);

        // TO DO: AFFLICTION SECTION
        providerEnrollingPage.fillInAffiliationSection(epNPI, Data.AFFILIATION_TYPE_IND_TO_GRP) ;

        //PCP Addendum Section
        providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementFormSD(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    /**
     * This method submits RAI request for Servicing Provider,
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitRAI(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                          ProviderEnrollingPage providerEnrollingPage) throws Exception {
        String newSSN = generateANumberOfLength(10);
        providerEnrollingPage.UpdateSSNInIdentificationInfoSec(newSSN);

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
        cocsPage.clickNextButtonOnCOCPopUP();
        cocsPage.selectCoCFromCategorySelection(categoryList);
        cocsPage.clickCreateCocButton();
        if(cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING)){
            cocsPage.cocGeneralInfoIdentifyingInformationSection();}
        if(cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PROV_IDENTIFY)){
            cocsPage.cocAddMedicareDetailsProviderIdentifierSection();}
        if(cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP)){
            cocsPage.cocOwnerShipSection();
        }
        cocsPage.cocSummeryAndSubmit();
        dashboardPage.clickAnyButton(Data.TEXT_GO_TO_COC);

    }

    public void submitReconsideration(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, ReconsiderationPage reconsiderationPage) throws Exception {
        dashboardPage.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        dashboardPage.ClickOnAppealButton();
        reconsiderationPage.uploadFileAndSubmit();
    }
    /**
     * This method populates Individual Servicing Data Change request information prior to the submission of the request.
     *
     * @param providerID
     * @throws Exception
     */
    public void submitProviderDataChange(String enrollmentType, String firstName, String lastName, String providerEmail, String providerEmailPassword,
                                         String providerID, IUEnrollmentPage iuEnrollmentPage, DashboardPage dashboardPage, SDHomePage sdhomePage) throws Exception {

        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.INDIVIDUAL_PROVIDER_INITIALS, providerID);
        iuEnrollmentPage.clickEnrollmentDetails();
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.modifyEnrollmentInformationSectionDropDownValue(Data.TITLE_DATA_CHANGE, Data.TITLE_DR_DATA_CHANGE);


        //Return to Provider's Tab and verify that changes are saved
        iuEnrollmentPage.clickProvidersTab();
        iuEnrollmentPage.clickAnyButton(Data.TEXT_SEARCH);
        iuEnrollmentPage.clickSearchResultRow();
        iuEnrollmentPage.clickEnrollmentDetails();
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
//        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.SUFFIX_DATA_CHANGE, Data.SUFFIX_DR_DATA_CHANGE);
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.TITLE_DATA_CHANGE, Data.TITLE_DR_DATA_CHANGE);

        dashboardPage.logOut();

        // Log in as provider and verify that changes are saved
        sdhomePage.signInToApp(providerEmail, providerEmailPassword);
        dashboardPage.clickApprovedProviderTab(Data.textProviderDataTab);
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.SUFFIX_DATA_CHANGE, Data.SUFFIX_DR_DATA_CHANGE);
        dashboardPage.logOut();
    }

    /**
     * This method populates Billing Revalidation request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitRevalidation(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                   ProviderEnrollingPage providerEnrollingPage) throws Exception {

        dashboardPage.closeAllPopUps();
        dashboardPage.ajaxScrollUp();
        dashboardPage.verifyRevalidationMessage();
        dashboardPage.clicksOnCreateRevalidationButton();

        //Program Participation Section
        providerEnrollingPage.fillInProgramParticipation(enrollmentType, Data.INDV_MEDICAID_CHIP, Data.THERAPY, Data.TAXONOMY_PHYSICAL_THERAPIST, Data.LICENSE_PHYSICAL_THERAPY_PT, firstName, lastName);

        //dashboardPage.verifySectionsForRevalidation(enrollmentType);
        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

    }


    public void servicingProviderEnrollment(String enrollmentType, String providerEmailID, String firstName, String lastName, DashboardPage dashboardPage,
                                            ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {
        dashboardPage.clickOnEnrollmentType(Data.individualApplication);

        String middleName = enrollmentFormElements.formElements().get(Data.MIDDLE_NAME) ;
        String npi = enrollmentFormElements.formElements().get(Data.PROVIDER_NPI) ;
        String date = enrollmentFormElements.formElements().get(Data.ENROLLMENT_DATE);
        String epNPI = enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_NPI);
        String ssn = enrollmentFormElements.formElements().get(Data.SSN);


        //Identifying Information and Provider Identifier Section for Individual Enrollment
//        providerEnrollingPage.fillInIndividualIdentifyingInformation(
//                firstName, lastName, middleName , Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, providerEmailID,
//                ssn, Data.profitStatusNonProfit, enrollmentType, medicaidPaymentValue,date);
        //Provider Identifier Section
        providerEnrollingPage.fillInIndividualProviderIdentifiersSection(medicaidPaymentValue, "No", npi, enrollmentType);

        //Ownership
        providerEnrollingPage.fillInOwnershipSectionForServiceProvider();

        providerEnrollingPage.fillInExclusionAndSanctionSection();

        providerEnrollingPage.fillInProgramParticipation(enrollmentType,Data.INDV_MEDICAID_CHIP, Data.THERAPY, Data.TAXONOMY_PHYSICAL_THERAPIST,Data.LICENSE_PHYSICAL_THERAPY_PT, firstName, lastName);

        // TO DO: AFFLICTION SECTION
        providerEnrollingPage.fillInAffiliationSection(epNPI, Data.AFFILIATION_TYPE_IND_TO_GRP) ;

        //PCP Addendum Section
        //providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementFormSD(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    /**
     * This method submits ReEnrollment request for Servicing Provider,
     *
     * @param dashboardPage
     * @throws Exception
     */

    public void submitReEnrollment(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                   ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {

        String epNPI = enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_NPI);

        providerEnrollingPage.clickOnReEnrollmentApplBtn();
        // Requested Enrollment Date
        providerEnrollingPage.fillInRequestedEnrollmentDateInformation(HomePage.getCurrentDate());

        //AFFLIATION SECTION
        providerEnrollingPage.fillInAffiliationSection(epNPI, Data.AFFILIATION_TYPE_IND_TO_GRP) ;

        //PCP Addendum Section
        providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

    }

    public ServicingProviderRequest() {

    }
}
