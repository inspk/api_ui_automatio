package com.hhstechgroup.common.requestfactory;


import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.EnrollmentFormElements;
import com.hhstechgroup.common.SDHomePage;

import java.util.ArrayList;

import static com.hhstechgroup.Pages.CocsPage.*;

/**
 * This concrete class extends the {@link Request} class and contains methods called
 * by the {@link RequestFactory} class.
 */
public class PEMProviderRequest extends Request {

    /**
     * This method populates PEM enrollment request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param providerEmailID
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws InterruptedException
     */
    public void pemProviderEnrollment(String enrollmentType, String providerEmailID, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {

        String ssn = enrollmentFormElements.formElements().get(Data.SSN);
        String phoneNo = enrollmentFormElements.formElements().get(Data.PHONE_NUM);
        String zipCode = enrollmentFormElements.formElements().get(Data.ZIP_CODE);


        //Starting Enrollment Process
        dashboardPage.clickOnEnrollmentType(Data.PEM_PROVIDER_INITIALS);

        // Provider Identifier Section for PEM Provider
        providerEnrollingPage.fillInProviderIdentifyingInformationPEM(
                firstName, lastName,phoneNo, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, providerEmailID,
                ssn, Data.profitStatusNonProfit, enrollmentType);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    /**
     * This method populates PEM CoC request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @throws Exception
     */
    public void submitCOC(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                          CocsPage cocsPage, String[] categoryList) throws Exception {

        //This array contains a list of Identifying Information tab fields to be modified
        String [] identifyingInfoFields = {IDENTIFYING_INFO_FIELD_FIRST_NAME
                                            ,IDENTIFYING_INFO_FIELD_LAST_NAME
                                            ,IDENTIFYING_INFO_FIELD_PHONE
                                            ,IDENTIFYING_INFO_FIELD_FAX
                                            ,IDENTIFYING_INFO_FIELD_WEBSITE
                                            ,IDENTIFYING_INFO_FIELD_ALT_EMAIL
                                            };

        //This array contains a list of Address Details tab fields to be modified
        String [] addressDetailsFields = {ADDRESS_DETAILS_FIELD_ATTENTION};

        //Navigate to the CoC Popup
        cocsPage.navigateAndClickCoC();
        cocsPage.clickNextButtonOnCOCPopUP();

        //Select the tabs contained in the Category List and create the CoC
        cocsPage.selectCoCFromCategorySelection(categoryList);
        cocsPage.clickCreateCocButton();

        //Update the fields of the tabs selected
        cocsPage.cocUpdateAddressDetailsFields(addressDetailsFields);
        cocsPage.cocUpdateIdentifyingInformationFields(identifyingInfoFields);

        //Submit the CoC
        cocsPage.cocSummeryAndSubmit();
        dashboardPage.clickAnyButton(Data.TEXT_GO_TO_COC);
    }

    /**
     * This method populates PEM Reconsideration request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitReconsideration(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, ReconsiderationPage reconsiderationPage) throws Exception {

        dashboardPage.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        dashboardPage.ClickOnAppealButton();
        reconsiderationPage.uploadFileAndSubmit();

    }

    /**
     * This method populates PEM RAI request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws InterruptedException
     */
    public void submitRAI(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                          ProviderEnrollingPage providerEnrollingPage) throws InterruptedException {

        //Upload Document
        providerEnrollingPage.uploadDocumentSection(enrollmentType);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    /**
     * This method populates PEM Enroll Provider request information prior to the submission of the request.
     *
     * @param enrolledProviderType
     * @param enrolledProviderFName
     * @param enrolledProviderLName
     * @param enrolledProviderHaveEmail
     * @param enrolledProviderEmail
     * @param zipCode
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitPEMEnrollProvider(String enrolledProviderType, String enrolledProviderFName, String enrolledProviderLName,
                                        String enrolledProviderHaveEmail, String enrolledProviderEmail, String zipCode, DashboardPage dashboardPage,
                                        ProviderEnrollingPage providerEnrollingPage) throws Exception {
        String ssn = generateANumberOfLength(10);

        switch(enrolledProviderType) {
            case Data.PEM_PROVIDER:
                //Select PEM enrollment tile
                dashboardPage.clickOnEnrollmentType(Data.PEM_PROVIDER_INITIALS);

                //Enter Enrolled Provider Popup Information
                providerEnrollingPage.fillEnrollProviderInformation(enrolledProviderHaveEmail, enrolledProviderEmail,
                        enrolledProviderFName, enrolledProviderLName);

                // Provider Identifier Section for PEM Provider
                providerEnrollingPage.fillInProviderIdentifyingInformationPEM(enrolledProviderFName, enrolledProviderLName,
                        Data.phone, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, enrolledProviderEmail,
                        ssn, Data.profitStatusNonProfit, enrolledProviderType);

                //Address Detail Section
                providerEnrollingPage.fillInAddressInformation(enrolledProviderType, Data.physicalAddress, Data.city,
                        Data.mailingState, zipCode, Data.countyCodeSD);

                //Summary Section
                providerEnrollingPage.summarySectionProceedToSignIn(enrolledProviderFName, enrolledProviderLName);
                dashboardPage.signInHelloSign(enrolledProviderFName, enrolledProviderLName);
            break;

            case Data.SERVICING_PROVIDER:
                //System.out.println("Enroll Servicing Provider case: "+ enrolledProviderType)

                //***********************************************************************************//
                //* TO DO: This case statement will be updated when PECS-2122 is assigned
                //***********************************************************************************//

            break;

            case Data.ENTITY_PROVIDER:
                //System.out.println("Enroll Servicing Provider case: "+ enrolledProviderType)

                //***********************************************************************************//
                //* TO DO: This case statement will be updated when PECS-2125 is assigned
                //***********************************************************************************//

           break;

            case Data.BILLING_PROVIDER:
                //System.out.println("Enroll Servicing Provider case: "+ enrolledProviderType)

                //***********************************************************************************//
                //* TO DO: This case statement will be updated when PECS-2123 is assigned
                //***********************************************************************************//

            break;

        }
    }

    /**
     * This method populates PEM Revalidation request information prior to the submission of the request.
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

        //Close popups and re-position the Dashboard page
        dashboardPage.closeAllPopUps();
        dashboardPage.ajaxScrollUp();

        //Verify Revalidation status displayed on Dashboard page
        dashboardPage.verifyRevalidationMessage();

        //Click the Create Revalidation button
        dashboardPage.clicksOnCreateRevalidationButton();

        //Verify the green checkmarks displayed on the Revalidation request tab
        String[] pemSectionList = {Data.ENROLLMENT_IDEN_INF_SECTION,
                Data.ENROLLMENT_ADDRESS_DET_SECTION,
                Data.ENROLLMENT_UPLOAD_SECTION,
                Data.ENROLLMENT_AFFILIATION_SECTION};
        dashboardPage.VerifyTabCheckMark(pemSectionList,enrollmentType);


        //Complete Summary section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);

        //Complete the request signing
        dashboardPage.signInHelloSign(firstName, lastName);

    }

    /**
     * This method populates PEM Data Change request information prior to the submission of the request.
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerID
     * @throws Exception
     */
    public void submitProviderDataChange(String enrollmentType, String firstName, String lastName, String providerEmail,
                                         String providerEmailPassword, String providerID, IUEnrollmentPage iuEnrollmentPage,
                                         DashboardPage dashboardPage, SDHomePage sdHomePage) throws Exception {

        //Search for the Provider
        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.PEM_PROVIDER_INITIALS, providerID);

        //Uncomment if needed to close Duplicate NPI Popup
        //closeNpiPoUp();

        //Click the Enrollment Information tab displayed under the IU Provider Dashboard
        iuEnrollmentPage.clickEnrollmentDetails();

        //Update the Enrollment Information fields based on the section and an array of fields and XPaths and return
        //an array of updated fields and values
        ArrayList<ArrayList<String>> iuProviderUpdatedFieldsList = iuEnrollmentPage.updateIUProviderTextEntryFields(IUEnrollmentPage.iuProviderMenuTabSection, IUEnrollmentPage.iuProviderFieldsList);

        //Click the Provider tab and search for the updated Provider
        iuEnrollmentPage.clickProvidersTab();
        iuEnrollmentPage.clickAnyButton(Data.TEXT_SEARCH);
        iuEnrollmentPage.clickSearchResultRow();

        //Uncomment if needed to close Duplicate NPI Popup
        //closeNpiPoUp();

        //Click the Enrollment Information tab displayed under the IU Provider Dashboard
        iuEnrollmentPage.clickEnrollmentDetails();

        //Click the specified Enrollment Information Section tab
        iuEnrollmentPage.clickIUProviderSection(IUEnrollmentPage.iuProviderMenuTabSection);

        //Iterate through the iuProviderUpdatedFieldsList array and verify the updated field values are displayed
        //on the INTERNAL USER Portal
        iuEnrollmentPage.verifyUpdatedEnrollmentInfoSectionFields(Data.INTERNAL_USER_PORTAL, iuProviderUpdatedFieldsList);

        //Logout the Internal User
        dashboardPage.logOut();

        //Login as the Provider
        sdHomePage.signInToApp(providerEmail, providerEmailPassword);

        //Navigate to the Provider Data tab
        dashboardPage.clickApprovedProviderTab(Data.textProviderDataTab);

        //Click the specified Section with updates fields
        iuEnrollmentPage.clickIUProviderSection(IUEnrollmentPage.iuProviderMenuTabSection);

        //Iterate through the iuProviderUpdatedFieldsList array and verify the updated field values are displayed
        //on the PROVIDER Portal
        iuEnrollmentPage.verifyUpdatedEnrollmentInfoSectionFields(Data.PROVIDER_PORTAL, iuProviderUpdatedFieldsList);

        //Logout the Provider
        dashboardPage.logOut();
    }

    /**
     * This is a constructor
     */
    public PEMProviderRequest() {

    }
}
