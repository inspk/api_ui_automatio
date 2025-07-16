package com.hhstechgroup.common.requestfactory;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.*;
import com.hhstechgroup.utility.Helper;

import static com.hhstechgroup.common.BaseActions.generateANumberOfLength;

public class BillingProviderRequest extends Request {

    public com.hhstechgroup.utility.Helper Helper = new Helper();
    String medicaidPaymentValue = "Yes";
    String taxonomy;


    /**
     * This method creates a Billing Provider enrollment request,
     *
     * @param enrollmentType
     * @param providerEmailID
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws InterruptedException
     */
    public void billingProviderEnrollment(String enrollmentType, String providerEmailID, String firstName, String lastName, DashboardPage dashboardPage,
                                          ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {

        String middleName = enrollmentFormElements.formElements().get(Data.MIDDLE_NAME) ;
        String npi = enrollmentFormElements.formElements().get(Data.PROVIDER_NPI) ;
        String date = enrollmentFormElements.formElements().get(Data.ENROLLMENT_DATE);
        String ssn = enrollmentFormElements.formElements().get(Data.SSN);
        String applicationContactNo=enrollmentFormElements.formElements().get(Data.APLLICATION_CONTACT_NUM);
        String phoneNo = enrollmentFormElements.formElements().get(Data.PHONE_NUM);
        String zipCode = enrollmentFormElements.formElements().get(Data.ZIP_CODE);
        try{
            dashboardPage.clickOnEnrollmentType(Data.INDIVIDUAL_PROVIDER);

        }catch(Exception e){}

        //Identifying Information and Provider Identifier Section for Individual Enrollment
        providerEnrollingPage.fillInIndividualIdentifyingInformation(
                firstName, lastName, middleName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, providerEmailID,
                ssn, applicationContactNo,Data.profitStatusNonProfit, enrollmentType, medicaidPaymentValue,date);

        //Provider Identifier Section
        providerEnrollingPage.fillInIndividualProviderIdentifiersSection(medicaidPaymentValue, "No", npi, enrollmentType);

        //Ownership Section
        providerEnrollingPage.fillInOwnershipSection(enrollmentType);

        //Key Personnel
        providerEnrollingPage.fillInKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType);

        //Exclusion and Sanction Section
        providerEnrollingPage.fillInExclusionAndSanctionSection();

        //EFT Information Section
        providerEnrollingPage.fillInEFTInformationSection(Data.INDIVIDUAL_PROVIDER, firstName);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD);
        providerEnrollingPage.mailingAddressContactPerson(firstName, lastName, phoneNo, providerEmailID);

        //Program Participation Section
        providerEnrollingPage.fillInProgramParticipation(enrollmentType, Data.INDV_MEDICAID_CHIP, Data.THERAPY, Data.TAXONOMY_PHYSICAL_THERAPIST, Data.LICENSE_PHYSICAL_THERAPY_PT, firstName,lastName);

        // Service Location Section
        providerEnrollingPage.fillInServiceLocationSection(enrollmentType, providerEmailID, zipCode, Data.INDV_MEDICAID_CHIP, Data.TAXONOMY_PHYSICAL_THERAPIST);

        //Upload Document Section
        providerEnrollingPage.uploadDocumentSectionSD(enrollmentType, "No");

        //PCP Addendum Section
        //providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }


    /**
     * This method submits RAI request for Billing Provider,
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
        String applicationContactNo=generateANumberOfLength(10);
        providerEnrollingPage.UpdateApplicationContactNumInIdentificationInfoSec(applicationContactNo);


        //PCP Addendum Section
        providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

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
//        cocsPage.selectCoCFromCategorySelection(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_ADDRESS);
        cocsPage.clickCreateCocButton();

        if (cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING)) {
            cocsPage.cocGeneralInfoIdentifyingInformationSection();
        }

        if (cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_ADDRESS)) {
            cocsPage.cocMailingContactDetailsOfAddressDetailsSection(firstName, lastName);
        }

        if (cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP)) {
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
     * This method submits Termination request for Billing Provider,
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */

    public void submitTermination(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                  ProviderEnrollingPage providerEnrollingPage) throws Exception {
        dashboardPage.VerifyProviderApplicationStatusIs(Data.APPLICATION_STATUS_ACTIVE2);
        dashboardPage.createTerminationRequest();

    }

    /**
     * This method populates Individual Billing Data Change request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerID
     * @throws Exception
     */
    public void submitProviderDataChange(String enrollmentType, String firstName, String lastName, String providerEmail,
                                         String providerEmailPassword, String providerID, IUEnrollmentPage iuEnrollmentPage, DashboardPage dashboardPage, SDHomePage sdhomePage) throws Exception {

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
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.TITLE_DATA_CHANGE, Data.TITLE_DR_DATA_CHANGE);
        dashboardPage.logOut();

        // Log in as provider and verify that changes are saved
        sdhomePage.signInToApp(providerEmail, providerEmailPassword);
        dashboardPage.clickApprovedProviderTab(Data.textProviderDataTab);
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.TITLE_DATA_CHANGE, Data.TITLE_DR_DATA_CHANGE);
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
        Reports.log("enrollmentType: " + enrollmentType );

        //Verify the green checkmarks displayed on the Revalidation request tab
        String[] billingSectionList = {Data.ENROLLMENT_IDEN_INF_SECTION,
                Data.ENROLLMENT_PROV_IDEN_SECTION,
                Data.ENROLLMENT_OWNRSHIP_SECTION,
                Data.ENROLLMENT_KEY_PER_SECTION,
                Data.ENROLLMENT_EXC_SANC_SECTION,
                Data.ENROLLMENT_EFT_INF_SECTION,
                Data.ENROLLMENT_ADDRESS_DET_SECTION,
                Data.ENROLLMENT_PROGRAM_PARTICIPATION_SECTION,
                Data.ENROLLMENT_UPLOAD_SECTION,
                Data.ENROLLMENT_SERV_LOC_SECTION};

        dashboardPage.VerifyTabCheckMark(billingSectionList,enrollmentType);
        //dashboardPage.verifySectionsForRevalidation(enrollmentType);

        //PCP Addendum Section
        //providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

    }

    /**
     * This method submits ReEnrollment request for Billing Provider,
     *
     * @param dashboardPage
     * @throws Exception
     */

    public void submitReEnrollment(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                   ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {

        providerEnrollingPage.clickOnReEnrollmentApplBtn();
        // Requested Enrollment Date
        providerEnrollingPage.fillInRequestedEnrollmentDateInformation(HomePage.getCurrentDate());

        //PCP Addendum Section
        providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    public BillingProviderRequest() {

    }
}
