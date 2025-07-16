package com.hhstechgroup.common;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.requestfactory.RequestFactory;
import com.hhstechgroup.common.requestfactory.RequestSubmitter;
import com.hhstechgroup.utility.CsvFileReading;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import com.hhstechgroup.utility.ProviderInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import static com.hhstechgroup.common.Data.*;

/**
 * This class contains request submission methods called by the {@link RequestSubmitter} class
 */
public class RequestSubmission extends BaseActions {
    public IUEnrollmentPage iuEnrollmentPage = new IUEnrollmentPage(driver, wait);
    public SDHomePage sdhomePage = new SDHomePage(driver, wait);
    public LoginPage loginPage = new LoginPage(driver, wait);
    public LandingPage landingPage = new LandingPage(driver, wait);
    public DashboardPage dashboardPage = new DashboardPage(driver, wait);
    public ProviderEnrollingPage providerEnrollingPage = new ProviderEnrollingPage(driver, wait);
    public ReconsiderationPage reconsiderationPage = new ReconsiderationPage(driver, wait);
    public HomePage homePage = new HomePage(driver, wait);
    public CocsPage cocsPage = new CocsPage(driver, wait);
    public ProvidersPage providersPage = new ProvidersPage(driver, wait);
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite("ProviderInfo.xlsx", 0);
    //CsvFileReading csvFileReading = new CsvFileReading("ProviderInfo.csv");

    RequestFactory factory = new RequestFactory();
    RequestSubmitter request = new RequestSubmitter(factory);

    public com.hhstechgroup.utility.Helper Helper = new Helper();
    String trackingNum;
    String zipCode;
    String npi;
    String medicaidPaymentValue;
    String legalBusiness;
    String Business;
    String taxonomy;

    String taxonomyCategory;

    /**
     * This is a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public RequestSubmission(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method is called by the {@link RequestSubmitter} class and submits an enrollment request
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param ProviderEmailId
     * @param providerEmailPassword
     * @param firstName
     * @param lastName
     * @throws Exception
     */
    public void submitEnrollment(String testEnvironment, String enrollmentType, String ProviderEmailId, String providerEmailPassword,
                                 String firstName, String lastName, EnrollmentFormElements enrollmentFormElements) throws Exception {

        npi = enrollmentFormElements.formElements().get(Data.PROVIDER_NPI);

        //Login Application with newly Registered provider
        loginPage.signInToApp(ProviderEmailId, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Starting Enrollment Process
        request.submitEnrollment(enrollmentType, ProviderEmailId, firstName,lastName,dashboardPage,providerEnrollingPage,enrollmentFormElements);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        if(enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)){
            loginPage.signInToApp(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_EMAILID), providerEmailPassword);
            landingPage.confirmAgreeAndSecureMessages();
            providerEnrollingPage.navigateAndOpenToMessageCenter();
            dashboardPage.signInHelloSign(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_FIRST_NAME) + " " + enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_LAST_NAME), "");
            javaWaitSec(10);
            dashboardPage.logOut();
        }

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, ProviderEmailId, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        excel.readExcel();

    }


    /**
     * This method is called by the {@link RequestSubmitter} class and submits a Requested Additional Information request
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void submitRAI(String enrollmentType,
                          String firstName, String lastName, String providerEmailId, String providerPwd, String applicationStatus) throws Exception {

        // Login as Provider and Re-submit  the application
        loginPage.signInToApp(providerEmailId, providerPwd);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.VerifyProviderApplicationStatusIs(Data.REQUESTED_ADDITIONAL_INFORMATION);
        providerEnrollingPage.ClickOnContinueBtn();

        request.submitRAI(enrollmentType, firstName, lastName, providerEmailId, providerPwd, applicationStatus, dashboardPage, providerEnrollingPage);

        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, Data.APPLICATION_STATUS_SUBMITTED);
        excel.readExcel();
    }

    /**
     *  This method is called by the {@link RequestSubmitter} class and submits a CoC request
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param provideEmailID
     * @param providerEmailPassword
     * @param firstName
     * @param lastName
     * @param categoryList
     * @throws Exception
     */
    public void submitCoC(String testEnvironment , String enrollmentType, String provideEmailID, String providerEmailPassword, String firstName, String lastName, String[] categoryList) throws Exception {

        // Login as Provider and submit a coc the application
        loginPage.signInToApp(provideEmailID, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        request.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);

        String cocID = cocsPage.getCoCID();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, provideEmailID, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, cocID);
        excel.readExcel();
    }

    /**
     * This method is called by the {@link RequestSubmitter} class and submits a Reconsideration request
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void submitReconsideration(String testEnvironment,String enrollmentType,
                                      String firstName, String lastName, String providerEmailId, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(providerEmailId, providerPwd);
        landingPage.confirmAgreeAndSecureMessages();

        request.submitReconsideration(enrollmentType, firstName, lastName, providerEmailId, providerPwd, applicationStatus, dashboardPage, providerEnrollingPage,reconsiderationPage);

        //Get Reconsideration Request ID
        reconsiderationPage.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);

        String reconsider_requestID = reconsiderationPage.getProviderReconsiderationTrackingID();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment,enrollmentType, firstName, lastName, providerEmailId, providerPwd, taxonomy, npi, applicationStatus, reconsider_requestID);
        excel.readExcel();

    }

    /**
     * This method is called by the {@link RequestSubmitter} class and submits a Provider Termination request
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void submitProviderTerminationRequest(String testEnvironment,String enrollmentType,
                                                 String firstName, String lastName, String providerEmailId, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(providerEmailId, providerPwd);
        landingPage.confirmAgreeAndSecureMessages();

        //Termination Request
        request.submitTermination(enrollmentType, firstName, lastName, providerEmailId, providerPwd, applicationStatus, dashboardPage, providerEnrollingPage);

        //Get Termination request IDew
        String termination_requestID = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment,enrollmentType, firstName, lastName, providerEmailId, providerPwd, taxonomy, npi, applicationStatus, termination_requestID);
        excel.readExcel();

    }

    public void submitRevalidationEnrollment(String testEnvironment,String enrollmentType,
                                             String firstName, String lastName, String providerEmailId, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(providerEmailId, providerPwd);
        landingPage.confirmAgreeAndSecureMessages();
        request.submitRevalidation(enrollmentType, firstName, lastName, providerEmailId, providerPwd, applicationStatus, dashboardPage, providerEnrollingPage);
        String trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, providerEmailId, providerPwd,"","", Data.APPLICATION_STATUS_SUBMITTED,trackingNum);
        excel.readExcel();
    }



    /**
     * This method is called by the {@link RequestSubmitter} class and submits a PEM Enroll Provider request
     *
     * @param testEnvironment
     * @param enrolledProviderType
     * @param PEMEmail
     * @param PEMEmailPassword
     * @param enrolledProviderFName
     * @param enrolledProviderLName
     * @param enrolledProviderHaveEmail
     * @param enrolledProviderEmail
     * @param zipCode
     * @throws Exception
     */
    public void submitPEMEnrollProvider(String testEnvironment, String enrolledProviderType,
                                        String PEMEmail, String PEMEmailPassword, String enrolledProviderFName,
                                        String enrolledProviderLName, String enrolledProviderHaveEmail, String enrolledProviderEmail, String zipCode) throws Exception {

        //Login as the PEM Provider
        loginPage.signInToApp(PEMEmail, PEMEmailPassword);

        //ConfirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Click +Enroll Provider
        clickAnyButton(Data.TEXT_ENROLL_PROVIDER);

        //Submit PEM Enroll Provider request
        request.submitPEMEnrollProvider(enrolledProviderType, enrolledProviderFName, enrolledProviderLName,
                enrolledProviderHaveEmail, enrolledProviderEmail, zipCode, dashboardPage, providerEnrollingPage);

        //Retrieve Tracking Number from dashboard
        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        //excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, newEmail, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        //excel.readExcel();
    }

    /**
     * This method is called by the {@link RequestSubmitter} class and submits a Provider Data Change request
     *
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param providerEmail
     * @param providerEmailPassword
     * @param trackingNum
     * @throws Exception
     */
    public void submitProviderDataChange(String enrollmentType, String internalUserEmail,
                                         String internalUserPassword, String firstName, String lastName, String providerEmail,
                                         String providerEmailPassword, String trackingNum) throws Exception {

        //Login as an Internal User
        sdhomePage.signInToApp(internalUserEmail, internalUserPassword);

        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);

        //Get the Provider ID from the enrollment displayed in the search results
        String providerID = iuEnrollmentPage.getProvidersID();

        //click the Providers tab
        dashboardPage.clickProvidersTab();

        //Submit Provider Data Change
        request.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage,dashboardPage,sdhomePage);
    }
    private String switchCase = "";
    /**
     * This method is called by the {@link RequestSubmitter} class and submits an enrollment request
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param providerEmailId
     * @param providerEmailPassword
     * @param firstName
     * @param lastName
     * @throws Exception
     */
    public void pemEnrollingOtherProvider(String testEnvironment, String enrollmentType, String providerEmailId, String enrollingProviderEmailID,String providerEmailPassword,
                                 String firstName, String lastName, EnrollmentFormElements enrollmentFormElements) throws Exception {

        npi = enrollmentFormElements.formElements().get(Data.PROVIDER_NPI);

        //Login as the PEM Provider and ConfirmAgreeAndSecureMessages
        loginPage.signInToApp(providerEmailId, providerEmailPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickAddEnrollProviderButton();

        switchCase =  enrollmentType;

        switch(switchCase) {
            case Data.PEM_PROVIDER:
                dashboardPage.clickOnEnrollmentType(Data.PEM_PROVIDER_INITIALS);
                break;
            case Data.SERVICING_PROVIDER:
            case Data.BILLING_PROVIDER:
                dashboardPage.clickOnEnrollmentType(Data.INDIVIDUAL_PROVIDER);
                break;
            case Data.TRADING_PARTNER:
                dashboardPage.clickOnEnrollmentType(Data.TRADING_PARTNER);
                break;
            case Data.ENTITY_PROVIDER:
                dashboardPage.clickOnEnrollmentType(Data.ENTITY_PROVIDER);
                break;
        }
        dashboardPage.fillInProviderInformationPopUp(enrollingProviderEmailID,firstName,lastName);

        //Starting Enrollment Process
        request.submitEnrollment(enrollmentType, enrollingProviderEmailID, firstName,lastName,dashboardPage,providerEnrollingPage,enrollmentFormElements);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.clickOnBackToPortalButton();
        dashboardPage.logOut();

        if(enrollmentType.equalsIgnoreCase(Data.SERVICING_PROVIDER)){
            loginPage.signInToApp(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_EMAILID), providerEmailPassword);
            landingPage.confirmAgreeAndSecureMessages();
            providerEnrollingPage.navigateAndOpenToMessageCenter();
            dashboardPage.signInHelloSign(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_FIRST_NAME) + " " + enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_LAST_NAME), "");
            javaWaitSec(10);
            dashboardPage.logOut();
        }


        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, enrollingProviderEmailID, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        excel.readExcel();
    }
    /**
     * This method is called by the {@link RequestSubmitter} class and submits a Reconsideration request
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void submitReEnrollment(String testEnvironment,String enrollmentType,
                                      String firstName, String lastName, String providerEmailId, String providerPwd, String applicationStatus, EnrollmentFormElements enrollmentFormElements) throws Exception {

        npi = enrollmentFormElements.formElements().get(Data.PROVIDER_NPI);

        loginPage.signInToApp(providerEmailId, providerPwd);
        landingPage.confirmAgreeAndSecureMessages();

        request.submitReEnrollment(enrollmentType, firstName, lastName, providerEmailId, providerPwd, applicationStatus, dashboardPage, providerEnrollingPage, enrollmentFormElements);

        //Get ReEnrollment Tracking number
        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        if(enrollmentType.equalsIgnoreCase(Data.SERVICING_RE_ENROLLMENT)){
            loginPage.signInToApp(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_EMAILID), providerPwd);
            landingPage.confirmAgreeAndSecureMessages();
            providerEnrollingPage.navigateAndOpenToMessageCenter();
            dashboardPage.signInHelloSign(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_FIRST_NAME) + " " + enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_LAST_NAME), "");
            javaWaitSec(10);
            dashboardPage.logOut();
        }

        excel.writeTestData(testEnvironment,enrollmentType, firstName, lastName, providerEmailId, providerPwd, taxonomy, npi, applicationStatus, trackingNum);
        excel.readExcel();

    }



}

