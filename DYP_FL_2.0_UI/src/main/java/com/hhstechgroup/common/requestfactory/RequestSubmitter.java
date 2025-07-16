package com.hhstechgroup.common.requestfactory;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.EnrollmentFormElements;
import com.hhstechgroup.common.SDHomePage;

/**
 *  This class creates request objects based on Request type
 */
public class RequestSubmitter {
    RequestFactory factory;

    /**
     * This is a parameterized class constructor
     *
     * @param factory
     */
    public RequestSubmitter(RequestFactory factory){
        this.factory = factory;
    }

//    /**
//     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
//     * enrollment request method in the {@link com.hhstechgroup.common.RequestSubmission} class
//     *
//     * @param enrollmentType
//     * @param newEmail
//     * @param firstName
//     * @param lastName
//     * @param middleName
//     * @param npi
//     * @param zipCode
//     * @param dashboardPage
//     * @param providerEnrollingPage
//     * @param sdhomePage
//     * @param legalBusiness
//     * @param Business
//     * @throws InterruptedException
//     */
//    public void submitEnrollment(String enrollmentType, String newEmail, String firstName, String lastName,
//                                 String middleName, String npi, String zipCode, DashboardPage dashboardPage, ProviderEnrollingPage providerEnrollingPage,
//                                 SDHomePage sdhomePage, String legalBusiness, String Business, String Date, String epNPI) throws Exception {
//
//        factory.submitEnrollment (enrollmentType, newEmail, firstName, lastName, middleName, npi, zipCode, dashboardPage, providerEnrollingPage, sdhomePage,
//                legalBusiness, Business, Date, epNPI);
//    }

    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * CoC request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @throws Exception
     */
    public void submitCOC(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                          CocsPage cocsPage, String[] categoryList) throws Exception {

        factory.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);
    }

    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * RAI request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitRAI(String enrollmentType, String firstName, String lastName,
                                   String providerEmailId, String providerPwd, String applicationStatus,DashboardPage dashboardPage,
                                   ProviderEnrollingPage providerEnrollingPage) throws Exception {
        factory.submitRAI(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
    }

    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * Reconsideration request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitReconsideration(String enrollmentType, String firstName, String lastName,
                                      String providerEmailId, String providerPwd, String applicationStatus, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, ReconsiderationPage reconsiderationPage) throws Exception {
        factory.submitReconsideration(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
    }

    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * Termination request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitTermination(String enrollmentType, String firstName, String lastName,
                                  String providerEmailId, String providerPwd, String applicationStatus, DashboardPage dashboardPage,
                                  ProviderEnrollingPage providerEnrollingPage) throws Exception {
        factory.submitTermination(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
    }



    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * Revalidation request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitRevalidation(String enrollmentType, String firstName, String lastName,
                                      String providerEmailId, String providerPwd, String applicationStatus, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage) throws Exception {
        factory.submitRevalidation(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
    }

    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * PEM Enroll Provider request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     //* @param enrollmentType
     //* @param firstName
     //* @param lastName
     * @param dashboardPage
     * @throws Exception
     */
    public void submitPEMEnrollProvider(String enrolledProviderType, String enrolledProviderFName,
                                        String enrolledProviderLName, String enrolledProviderHaveEmail, String enrolledProviderEmail, String zipCode,
                                        DashboardPage dashboardPage, ProviderEnrollingPage providerEnrollingPage) throws Exception {

        factory.submitPEMEnrollProvider(enrolledProviderType, enrolledProviderFName, enrolledProviderLName,
                        enrolledProviderHaveEmail, enrolledProviderEmail, zipCode, dashboardPage, providerEnrollingPage);
    }

    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * Data Change request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmail
     * @param providerEmailPassword
     * @param providerID
     * @param iuEnrollmentPage
     * @throws Exception
     */
    public void submitProviderDataChange(String enrollmentType, String firstName, String lastName, String providerEmail,
                                         String providerEmailPassword, String providerID, IUEnrollmentPage iuEnrollmentPage, DashboardPage dashboardPage, SDHomePage sdHomePage ) throws Exception {

        factory.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage,dashboardPage,sdHomePage);
    }


    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * enrollment request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param providerEmailId
     * @param firstName
     * @param lastName
     */
    public void submitEnrollment(String enrollmentType, String providerEmailId, String firstName, String lastName, DashboardPage dashboardPage, ProviderEnrollingPage providerEnrollingPage,
                                 EnrollmentFormElements enrollmentFormElements ) throws Exception {

        factory.submitEnrollment (enrollmentType, providerEmailId, firstName, lastName, dashboardPage, providerEnrollingPage, enrollmentFormElements);
    }
    /**
     * This method creates an object used by the {@link RequestFactory} class that calls the associated submit
     * ReEnrollment request method in the {@link com.hhstechgroup.common.RequestSubmission} class
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmailId
     * @param providerPwd
     * @param applicationStatus
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitReEnrollment(String enrollmentType, String firstName, String lastName,
                                      String providerEmailId, String providerPwd, String applicationStatus, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements enrollmentFormElements) throws Exception {
        factory.submitReEnrollment(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, enrollmentFormElements);
    }
}
