package com.hhstechgroup.common.requestfactory;


import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.*;
import com.hhstechgroup.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TradingProviderRequest extends Request {

    public com.hhstechgroup.utility.Helper Helper = new Helper();

    private WebDriver driver;
    private WebDriverWait wait;
    public SDHomePage sdhomePage = new SDHomePage(driver, wait);

    public void tradingProviderProviderEnrollment(String enrollmentType, String providerEmailID, String firstName, String lastName, DashboardPage dashboardPage,
                                                  ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {

        String npi = enrollmentFormElements.formElements().get(Data.PROVIDER_NPI) ;
        String fein = enrollmentFormElements.formElements().get(Data.FEIN) ;
        String business = enrollmentFormElements.formElements().get(Data.BUSINESS) ;
        String zipCode= enrollmentFormElements.formElements().get(Data.ZIP_CODE) ;
        try {
            dashboardPage.clickOnEnrollmentType(Data.TRADING_PARTNER);

        }catch(Exception e){}

        //Complete Identifying Information
        providerEnrollingPage.fillInProviderIdentifyingInformationTP(HomePage.generateLegalBusiness(),
                business,fein , Data.physicalAddress, Data.city, Data.state, zipCode, Data.countyCodeSD, Data.mailingState, providerEmailID);

        providerEnrollingPage.fillInClassificationSection(Data.CLEARING_HOUSE);
        //Complete Provider Identifiers
        providerEnrollingPage.fillInProviderIdentifierTP(npi);

        //Key Personnel
        providerEnrollingPage.fillInKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType);

        //Exclusion and Sanction Section
        providerEnrollingPage.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        providerEnrollingPage.fillAuthorizedSignaturSection(firstName + " " + lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);
    }

    /**
     * This method submits RAI request Trading Partner,
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

        // TO DO: Need to add step for updating any feild on the enrollment form
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
        if (cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING)) {
            cocsPage.coCIdentifyingInformationSection();
        }
        if (cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_CLASSIFICATION)) {
            cocsPage.coCClassificationSection();
        }
        if (cocCategoryList.contains(Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_KEY_PERSONNEL)) {
            cocsPage.cocKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, Data.countyCodeSD);
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

    public void submitRevalidation(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                   ProviderEnrollingPage providerEnrollingPage) throws Exception {

        dashboardPage.closeAllPopUps();
        dashboardPage.ajaxScrollUp();
        dashboardPage.verifyRevalidationMessage();
        dashboardPage.clicksOnCreateRevalidationButton();

        String[] tradingPartnerSectionList = {Data.ENROLLMENT_IDEN_INF_SECTION,
                Data.ENROLLMENT_CLASSIFICATION_SECTION,
                Data.ENROLLMENT_PROV_IDEN_SECTION,
                Data.ENROLLMENT_OWNRSHIP_SECTION,
                Data.ENROLLMENT_KEY_PER_SECTION,
                Data.ENROLLMENT_EXC_SANC_SECTION,
                Data.ENROLLMENT_UPLOAD_SECTION};
        dashboardPage.VerifyTabCheckMark(tradingPartnerSectionList,enrollmentType);
        //dashboardPage.verifySectionsForRevalidation(enrollmentType);
        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

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
    public void submitProviderDataChange(String enrollmentType, String firstName, String lastName, String providerEmail, String providerEmailPassword,
                                         String providerID, IUEnrollmentPage iuEnrollmentPage, DashboardPage dashboardPage, SDHomePage sdhomePage) throws Exception {

        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.TP_PROVIDER_INITIALS, providerID);
        iuEnrollmentPage.clickEnrollmentDetails();
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        String newLBN = HomePage.generateLegalBusiness();
        Reports.log("New Legal Business name is: " + newLBN);
        iuEnrollmentPage.modifyEnrollmentInformationSectionFieldText(Data.FIELD_TEXT_LBN_DATA_CHANGE, newLBN, 1);

        //Return to Provider's Tab and verify that changes are saved
        iuEnrollmentPage.clickProvidersTab();
        iuEnrollmentPage.clickAnyButton(Data.TEXT_SEARCH);
        iuEnrollmentPage.clickSearchResultRow();
        iuEnrollmentPage.clickEnrollmentDetails();
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.FIELD_TEXT_LBN_DATA_CHANGE, newLBN);
        dashboardPage.logOut();

        // Log in as provider and verify that changes are saved
        sdhomePage.signInToApp(providerEmail, providerEmailPassword);
        iuEnrollmentPage.closeAlert();
        dashboardPage.clickApprovedProviderTab(Data.textProviderDataTab);
        iuEnrollmentPage.clickOnProviderIdentifyingInformationSection();
        iuEnrollmentPage.verifyIfDataModifiedSuccessfully(Data.FIELD_TEXT_LBN_DATA_CHANGE, newLBN);
        dashboardPage.logOut();

    }

    public TradingProviderRequest() {

    }
}
