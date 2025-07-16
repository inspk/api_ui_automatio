package com.hhstechgroup.common;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.statuschangefactory.StatusChangeFactory;
import com.hhstechgroup.common.statuschangefactory.StatusChanger;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import com.hhstechgroup.utility.ProviderInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains status change methods called by the {@link StatusChanger} class
 */
public class RequestStatusChange extends BaseActions {
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    public IUEnrollmentPage iuEnrollmentPage = new IUEnrollmentPage(driver, wait);
    public LoginPage loginPage = new LoginPage(driver, wait);
    public LandingPage landingPage = new LandingPage(driver, wait);
    public DashboardPage dashboardPage = new DashboardPage(driver, wait);
    public ReconsiderationPage reconsiderationPage = new ReconsiderationPage(driver, wait);
    public CocsPage cocsPage = new CocsPage(driver, wait);
    public SDHomePage sdhomePage = new SDHomePage(driver, wait);
    protected EnrollmentFormElements enrollmentFormElements = new EnrollmentFormElements(driver,wait);
    public ProviderEnrollingPage providerEnrollingPage = new ProviderEnrollingPage(driver, wait);
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    StatusChangeFactory factory = new StatusChangeFactory();
    StatusChanger statusChanger = new StatusChanger(factory);

    String dashboardStatus;
    String providerStatusXpath;
    String providerInfoStatus;

    public Helper Helper = new Helper();

    /**
     * This is a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public RequestStatusChange(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of an enrollment request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingId
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
//    public void enrollmentStatusChange(String testEnvironment, String environmentUrl, String enrollmentType,
//                                       String internalUserEmail, String internalUserPassword,
//                                       String firstName, String lastName, String trackingId,
//                                       String providerEmailId, String providerPwd, String applicationStatus, String date) throws Exception {
//
//        Map<String, String> providerInformation = new HashMap<String, String>() ;
//
//        //Login as an Internal User
//        loginPage.signInToApp(internalUserEmail, internalUserPassword);
//        landingPage.confirmAgreeAndSecureMessages();
//
//        //click the Enrollment tab
//        dashboardPage.clickEnrollTab();
//
//        //Building the Map
//        providerInformation.put(Data.FIRST_NAME,firstName);
//        providerInformation.put(Data.LAST_NAME,lastName);
//        providerInformation.put(Data.TRACKING_ID,trackingId);
//        providerInformation.put(Data.PROVIDER_EMAILID, providerEmailId);
//        providerInformation.put(Data.PROVIDER_PASSWORD ,providerPwd);
//        providerInformation.put(Data.DATE, date) ;
//
//        enrollmentFormElements.setFormElements(providerInformation);
//
//        //Set enrollment status
//        statusChanger.setEnrollmentStatus(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);
//
//        //Retrieve the final status displayed
//        String statusOfApplication = iuEnrollmentPage.getApplicationStatus();
//
//        //Set the status written to Provider Info based on the original applicationStatus and
//        //the statusOfApplication displayed on the enrollment.  It addresses the need to have an
//        //Active status written to ProviderInfo if needed
//        providerInfoStatus = dashboardPage.setProviderInfoStatus(statusOfApplication, applicationStatus);
//
//        //Logout and write the enrollment information to Provider info
//        dashboardPage.logOut();
//        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, providerInfoStatus);
//        excel.readExcel();
//
//        //Verify the status displayed on the Provider dashboard
//        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage, enrollmentType,
//                providerEmailId, providerPwd, providerInfoStatus, applicationStatus);
//    }

    public void enrollmentStatusChangeRetroActively(String testEnvironment, String environmentUrl, String enrollmentType,
                                       String internalUserEmail, String internalUserPassword,
                                       String firstName, String lastName, String trackingId, String screeningType,
                                       String providerEmailId, String providerPwd, String applicationStatus, EnrollmentFormElements enrollmentFormElements) throws Exception {

        Map<String, String> providerInformation = new HashMap<String, String>() ;

        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //click the Enrollment tab
        dashboardPage.clickEnrollTab();

        //Building the Map
        providerInformation.put(Data.FIRST_NAME,firstName);
        providerInformation.put(Data.LAST_NAME,lastName);
        providerInformation.put(Data.TRACKING_ID,trackingId);
        providerInformation.put(Data.PROVIDER_EMAILID, providerEmailId);
        providerInformation.put(Data.PROVIDER_PASSWORD ,providerPwd);
        enrollmentFormElements.setFormElements(providerInformation);
        providerInformation.put(Data.SCREENING_TYPE ,screeningType);

        statusChanger.setEnrollmentStatus(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);

        //Set enrollment status
//        statusChanger.setEnrollmentStatus(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
//                firstName, lastName, trackingId, providerEmailId, providerPwd, applicationStatus, iuEnrollmentPage, driver, Date);

        //Logout and write the enrollment information to Provider info
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, Data.ApplicationStatusApprove);
        excel.readExcel();

    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Provider
     *
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingId
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @param enrollmentFormElements
     * @throws Exception
     */
    public void providerStatusChange(String enrollmentType, String internalUserEmail, String internalUserPassword,
                                     String firstName, String lastName, String trackingId,
                                     String providerEmailId, String providerPwd, String applicationStatus, EnrollmentFormElements enrollmentFormElements) throws Exception {
        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();


        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingId);

        //Get the Provider ID from the enrollment displayed in the search results
        String providerID = iuEnrollmentPage.getProvidersID();

        //click the Providers tab
        dashboardPage.clickProvidersTab();

        //Set the expected dashboard status
        dashboardStatus = dashboardPage.setDashboardStatus(applicationStatus);

        //Change the Provider file status based on the initial and final statuses
        statusChanger.setProviderStatus(enrollmentType,applicationStatus,iuEnrollmentPage,providerID, enrollmentFormElements);

        //Retrieve the final status displayed
        providerStatusXpath = "//span[contains(text(), '" + dashboardStatus + "')]";
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus(By.xpath(providerStatusXpath));

        Reports.log("Status of the Application : "+statusOfApplication);

        //Logout and write the enrollment information to Provider info
        dashboardPage.logOut();
//        Reports.log("Status of the Application After Logout: "+statusOfApplication);
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, statusOfApplication);
        excel.readExcel();

        //Login as the Provider and verify the Status displayed on the dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage,
                enrollmentType, providerEmailId, providerPwd, dashboardStatus, applicationStatus);
    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a CoC request
     *
     * @param internalUserEmail
     * @param internalUserPassword
     * @param trackingId
     * @param applicationStatus
     * @throws Exception
     */
    public void cocStatusChange(String testEnvironment, String environmentUrl, String enrollmentType,
                                String internalUserEmail, String internalUserPassword,
                                String firstName, String lastName, String trackingId,
                                String providerEmailId, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        statusChanger.setCoCStatus(testEnvironment, environmentUrl, enrollmentType,
                internalUserEmail, internalUserPassword,
                firstName, lastName, trackingId,
                providerEmailId, providerPwd, applicationStatus, iuEnrollmentPage, driver, cocsPage);

        dashboardPage.logOut();

        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, applicationStatus
                , trackingId);
        excel.readExcel();
    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Reconsideration request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param applicationType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @param newEmail
     * @param providerPwd
     * @throws Exception
     */
    public void reconsiderationStatusChange(String testEnvironment, String environmentUrl, String applicationType,
                                            String internalUserEmail, String internalUserPassword,
                                            String firstName, String lastName, String trackingNum,
                                            String newEmail, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //  Starting Reconsideration Status process
        statusChanger.setReconsiderationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);

        String dashboardStatus = iuEnrollmentPage.getApplicationStatus();

        dashboardPage.logOut();

        //Write Reconsideration status to Provider Info
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType, firstName, lastName, applicationStatus, trackingNum);
        excel.readExcel();

        //Verify the status displayed on the Provider dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage,
                applicationType, newEmail, providerPwd, dashboardStatus, applicationStatus);
        //dashboardPage.verifyProviderTabsOnDashboard();

    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Termination request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param applicationType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @param providerPwd
     * @throws Exception
     */
    public void terminationStatusChange(String testEnvironment, String environmentUrl, String applicationType,
                                        String internalUserEmail, String internalUserPassword,
                                        String firstName, String lastName, String email, String providerPwd, String trackingNum, String applicationStatus) throws Exception {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);

        //Get the Provider ID from the enrollment displayed in the search results
        String prov_id = iuEnrollmentPage.getProvidersID();

        //Search the Provider under Enroll tab
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", prov_id);
        iuEnrollmentPage.clickSearchResultRow();

        //  Starting Request For Termination Approval Status process
        statusChanger.setTerminationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, email, providerPwd, trackingNum, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);

        dashboardPage.logOut();
        //Login Application with Registered provider
        // verifying status as provider and dashboard tabs
        //Verify the status displayed on the Provider dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage, applicationType,
                email, providerPwd, Data.APPLICATION_STATUS_ACTIVE, Data.ApplicationStatusApprove);
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType, firstName, lastName, Data.TEXT_TERMINATE);
        excel.readExcel();
    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Termination request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param applicationType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @param providerPwd
     * @throws Exception
     */
    public void approveProviderTerminationRequest(String testEnvironment, String environmentUrl, String applicationType,
                                                  String internalUserEmail, String internalUserPassword,
                                                  String firstName, String lastName, String email, String providerPwd, String trackingNum, String applicationStatus) throws Exception {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //Click the enrollment tab and search using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);
        iuEnrollmentPage.clickSearchResultRow();

        //  Set the Termination Request Status to Approved
        statusChanger.setStatusForTerminationRequest(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, email, providerPwd, trackingNum, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);

        dashboardPage.logOut();
        //Login Application with Registered provider
        // verifying status as provider and dashboard tabs
        //Verify the status displayed on the Provider dashboard
        ProviderInformation.updateProviderData(providerInfoSheet, applicationType, firstName, lastName, applicationStatus);
        excel.readExcel();


    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Reactivate Terminated
     * Provider request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingId
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void reactivateTerminatedProvider(String testEnvironment, String environmentUrl, String enrollmentType,
                                             String internalUserEmail, String internalUserPassword,
                                             String firstName, String lastName, String trackingId,
                                             String providerEmailId, String providerPwd, String applicationStatus) throws Exception {
        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingId);

        //Get the Provider ID from the enrollment displayed in the search results
        String prov_id = iuEnrollmentPage.getProvidersID();

        //click the Providers tab and search provider
        dashboardPage.clickProvidersTab();
        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.ENROLLMENT_APPLICATION_TYPE, prov_id);

        //Change the Provider file status based on the initial and final statuses
        statusChanger.setReactivateTerminatedProviderStatus(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingId, providerEmailId, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);

        //Set the expected dashboard status
        dashboardStatus = dashboardPage.setDashboardStatus(applicationStatus);
        //Retrieve the final status displayed
        providerStatusXpath = "//span[contains(text(), '" + dashboardStatus + "')]";
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus(By.xpath(providerStatusXpath));

        //Logout and write the enrollment information to Provider info
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, statusOfApplication);
        excel.readExcel();

        //Login as the Provider and verify the Status displayed on the dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage,
                enrollmentType, providerEmailId, providerPwd, dashboardStatus, Data.APPLICATION_STATUS_ACTIVE);
    }


    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Revalidation request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param applicationType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @param newEmail
     * @param providerPwd
     * @throws Exception
     */
    public void setToRevalidationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                        String internalUserEmail, String internalUserPassword,
                                        String firstName, String lastName, String trackingNum,
                                        String newEmail, String providerPwd, String applicationStatus) throws Exception {

        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        statusChanger.setRevalidationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);

        dashboardPage.logOut();
    }


    /**
     * This method is called by the {@link StatusChanger} class and changes the status of an enrollment request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingId
     * @param screeningType
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void enrollmentStatusChange(String testEnvironment, String environmentUrl, String enrollmentType,
                                       String internalUserEmail, String internalUserPassword,
                                       String firstName, String lastName, String trackingId, String screeningType,
                                       String providerEmailId, String providerPwd, String applicationStatus, EnrollmentFormElements enrollmentFormElements) throws Exception {

        Map<String, String> providerInformation = new HashMap<String, String>() ;

        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //click the Enrollment tab
        dashboardPage.clickEnrollTab();

        //Building the Map
        providerInformation.put(Data.FIRST_NAME,firstName);
        providerInformation.put(Data.LAST_NAME,lastName);
        providerInformation.put(Data.TRACKING_ID,trackingId);
        providerInformation.put(Data.PROVIDER_EMAILID, providerEmailId);
        providerInformation.put(Data.PROVIDER_PASSWORD ,providerPwd);
        providerInformation.put(Data.SCREENING_TYPE ,screeningType);

        enrollmentFormElements.setFormElements(providerInformation);

        //Set enrollment status
        statusChanger.setEnrollmentStatus(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);

        //Retrieve the final status displayed
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus();

        //Set the status written to Provider Info based on the original applicationStatus and
        //the statusOfApplication displayed on the enrollment.  It addresses the need to have an
        //Active status written to ProviderInfo if needed
        providerInfoStatus = dashboardPage.setProviderInfoStatus(statusOfApplication, applicationStatus);

        //Logout and write the enrollment information to Provider info
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, providerInfoStatus);
        excel.readExcel();

        //Verify the status displayed on the Provider dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage, enrollmentType,
                providerEmailId, providerPwd, providerInfoStatus, applicationStatus);
    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of a Provider
     *
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param applicationStatus
     * @throws Exception
     */
    public void providerStatusChange(String enrollmentType,
                                     String internalUserEmail, String internalUserPassword, String applicationStatus,
                                     EnrollmentFormElements enrollmentFormElements) throws Exception {

        String firstName = enrollmentFormElements.formElements().get(Data.FIRST_NAME) ;
        String lastName = enrollmentFormElements.formElements().get(Data.lastName) ;
        String providerEmailId = enrollmentFormElements.formElements().get(Data.PROVIDER_EMAILID) ;
        String providerPwd = enrollmentFormElements.formElements().get(Data.PROVIDER_PASSWORD) ;
        String trackingId = enrollmentFormElements.formElements().get(Data.TRACKING_ID) ;


        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //Click the enrollment tab and or the enrollment using the Request ID
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingId);

        //Get the Provider ID from the enrollment displayed in the search results
        String providerID = iuEnrollmentPage.getProvidersID();

        //click the Providers tab
        dashboardPage.clickProvidersTab();

        //Set the expected dashboard status
        dashboardStatus = dashboardPage.setDashboardStatus(applicationStatus);

        statusChanger.setProviderStatus(enrollmentType,applicationStatus,iuEnrollmentPage,providerID,enrollmentFormElements);


        //Retrieve the final status displayed
        providerStatusXpath = "//span[contains(text(), '" + dashboardStatus + "')]";
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus(By.xpath(providerStatusXpath));
        ;

        //Logout and write the enrollment information to Provider info
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, statusOfApplication);
        excel.readExcel();

        //Login as the Provider and verify the Status displayed on the dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage,
                enrollmentType, providerEmailId, providerPwd, dashboardStatus, applicationStatus);
    }

    /**
     * This method is called by the {@link StatusChanger} class and changes the status of an enrollment request
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param enrollmentType
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param trackingId
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @throws Exception
     */
    public void pemEnrollingOtherProviderStatusChange(String testEnvironment, String environmentUrl, String enrollmentType,
                                                      String internalUserEmail, String internalUserPassword, String pemProviderEmailID,
                                                      String providerEmailId,String firstName, String lastName, String trackingId, String screeningType,
                                                      String providerPwd, String applicationStatus) throws Exception {

        Map<String, String> providerInformation = new HashMap<String, String>() ;

        //Login as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        //click the Enrollment tab
        dashboardPage.clickEnrollTab();

        //Building the Map
        providerInformation.put(Data.FIRST_NAME,firstName);
        providerInformation.put(Data.LAST_NAME,lastName);
        providerInformation.put(Data.TRACKING_ID,trackingId);
        providerInformation.put(Data.PROVIDER_EMAILID, providerEmailId);
        providerInformation.put(Data.PROVIDER_PASSWORD ,providerPwd);
        providerInformation.put(Data.SCREENING_TYPE ,screeningType);
        enrollmentFormElements.setFormElements(providerInformation);

        //Set enrollment status
        statusChanger.setEnrollmentStatus(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);

        //Retrieve the final status displayed
        String statusOfApplication = iuEnrollmentPage.getApplicationStatus();

        //Set the status written to Provider Info based on the original applicationStatus and
        //the statusOfApplication displayed on the enrollment.  It addresses the need to have an
        //Active status written to ProviderInfo if needed
        providerInfoStatus = dashboardPage.setProviderInfoStatus(statusOfApplication, applicationStatus);

        //Logout and write the enrollment information to Provider info
        dashboardPage.logOut();
        ProviderInformation.updateProviderData(providerInfoSheet, enrollmentType, firstName, lastName, providerInfoStatus);
        excel.readExcel();

        loginPage.signInToApp(pemProviderEmailID, providerPwd);
        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        String providerName = firstName +" "+lastName ;

        // As a workaround for Defect - PECS-3552 , Passing an NPI value for Affiliated providers search for now. And this may not be applicable for PEM and TO
        String npi= ProviderInformation.getProviderIdAndNPI(providerInfoSheet, enrollmentType,Data.APPLICATION_STATUS_ACTIVE).get("ProviderNPI");

        //Verify the status displayed on the Provider dashboard
        dashboardPage.verifyAffiliatedProvidersStatus(npi,  providerInfoStatus, enrollmentType)  ;
    }
}