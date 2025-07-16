package com.hhstechgroup.common.requestfactory;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.EnrollmentFormElements;
import com.hhstechgroup.common.SDHomePage;
import com.hhstechgroup.common.statuschangefactory.*;

/**
 * This utilizes Request objects created by the {@link RequestSubmitter} class to submit a
 * Request
 */
public class RequestFactory {

    ServicingProviderRequest servicingProviderEnrollment = new ServicingProviderRequest();
    BillingProviderRequest billingProviderRequest = new BillingProviderRequest();
    TradingProviderRequest tradingProviderRequest = new TradingProviderRequest();
    PEMProviderRequest pemProviderRequest = new PEMProviderRequest();
    EntityProviderRequest entityproviderrequest = new EntityProviderRequest();

    /**
     * This method submits an Enrollment request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link TradingProviderRequest}
     * {@link PEMProviderRequest}
     * {@link EntityProviderRequest}
     *
     * @param enrollmentType
     * @param providerEmailId
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @param formElements
      * @throws InterruptedException
     */
    public void submitEnrollment(String enrollmentType, String providerEmailId, String firstName, String lastName,
                                 DashboardPage dashboardPage, ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements formElements) throws Exception {

        switch(enrollmentType) {
            case Data.SERVICING_PROVIDER:
                servicingProviderEnrollment.servicingProviderEnrollment(enrollmentType, providerEmailId, firstName, lastName, dashboardPage,providerEnrollingPage,formElements);
                break;
            case Data.ENTITY_PROVIDER:
                entityproviderrequest.entityProviderEnrollment(enrollmentType, providerEmailId, firstName, lastName, dashboardPage,providerEnrollingPage,formElements);
                break;
            case Data.BILLING_PROVIDER:
                billingProviderRequest.billingProviderEnrollment(enrollmentType, providerEmailId, firstName, lastName, dashboardPage,providerEnrollingPage,formElements);
                break;
            case Data.TRADING_PARTNER:
                tradingProviderRequest.tradingProviderProviderEnrollment(enrollmentType, providerEmailId, firstName, lastName, dashboardPage,providerEnrollingPage,formElements);
                break;
            case Data.PEM_PROVIDER:
                pemProviderRequest.pemProviderEnrollment(enrollmentType, providerEmailId, firstName, lastName, dashboardPage,providerEnrollingPage,formElements);
                break;
        }
    }

    /**
     * This method submits an RAI request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link TradingProviderRequest}
     * {@link PEMProviderRequest}
     * {@link EntityProviderRequest}
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

        switch(enrollmentType){
            case Data.SERVICING_PROVIDER:
                servicingProviderEnrollment.submitRAI(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.BILLING_PROVIDER:
                billingProviderRequest.submitRAI(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.TRADING_PARTNER:
                tradingProviderRequest.submitRAI(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.PEM_PROVIDER:
                pemProviderRequest.submitRAI(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.ENTITY_PROVIDER:
                entityproviderrequest.submitRAI(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
        }
    }

    /**
     * This method submits a CoC request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link TradingProviderRequest}
     * {@link PEMProviderRequest}
     * {@link EntityProviderRequest}
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param cocsPage
     * @throws Exception
     */
    public void submitCOC(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                          CocsPage cocsPage, String[] categoryList) throws Exception {

        switch(enrollmentType) {
            case Data.SERVICING_PROVIDER_COC:
                servicingProviderEnrollment.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);
                break;
            case Data.BILLING_PROVIDER_COC:
                billingProviderRequest.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);
                break;
            case Data.TRADING_PARTNER_COC:
                tradingProviderRequest.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);
                break;
            case Data.PEM_PROVIDER_COC:
                pemProviderRequest.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);
                break;
            case Data.ENTITY_PROVIDER_COC:
                entityproviderrequest.submitCOC(enrollmentType, firstName, lastName, dashboardPage, cocsPage, categoryList);
                break;
        }
    }

    /**
     * This method submits a Reconsideration request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link TradingProviderRequest}
     * {@link PEMProviderRequest}
     * {@link EntityProviderRequest}
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @param reconsiderationPage
     * @throws Exception
     */
    public void submitReconsideration(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, ReconsiderationPage reconsiderationPage) throws Exception {

        switch(enrollmentType) {
            case Data.SERVICING_PROVIDER_RECONSIDERATION:
                servicingProviderEnrollment.submitReconsideration(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
                break;
            case Data.BILLING_PROVIDER_RECONSIDERATION:
                billingProviderRequest.submitReconsideration(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
                break;
            case Data.TRADING_PARTNER_RECONSIDERATION:
                tradingProviderRequest.submitReconsideration(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
                break;
            case Data.PEM_PROVIDER_RECONSIDERATION:
                pemProviderRequest.submitReconsideration(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
                break;
            case Data.ENTITY_PROVIDER_RECONSIDERATION:
                entityproviderrequest.submitReconsideration(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
                break;
        }
    }

    /**
     * This method submits a Termination request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link EntityProviderRequest}
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

        switch(enrollmentType) {
            case Data.BILLING_PROVIDER_REQUEST_TERMINATION:
            case Data.SERVICING_PROVIDER_REQUEST_TERMINATION:
                billingProviderRequest.submitTermination(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.ENTITY_PROVIDER_REQUEST_TERMINATION:
                entityproviderrequest.submitTermination(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
//            case Data.SERVICING_PROVIDER:
//                servicingProviderEnrollment.submitTermination(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, reconsiderationPage);
//                break;
        }
    }


    /**
     * This method submits a Revalidation request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link TradingProviderRequest}
     * {@link PEMProviderRequest}
     * {@link EntityProviderRequest}
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

        switch(enrollmentType){
            case Data.ENTITY_REVALIDATION:
                entityproviderrequest.submitRevalidation(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.TRADING_PARTNER_REVALIDATION:
                tradingProviderRequest.submitRevalidation(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.PEM_PROVIDER_REVALIDATION:
                pemProviderRequest.submitRevalidation(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.BILLING_PROVIDER_REVALIDATION:
                billingProviderRequest.submitRevalidation(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
            case Data.SERVICING_PROVIDER_REVALIDATION:
                servicingProviderEnrollment.submitRevalidation(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage);
                break;
        }
    }

    /**
     * This method submits a PEM Enroll Provider request by creating a Request
     * object from the following class and calling the object's submit method:
     * {@link PEMProviderRequest}
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

        pemProviderRequest.submitPEMEnrollProvider(enrolledProviderType, enrolledProviderFName, enrolledProviderLName,
                enrolledProviderHaveEmail, enrolledProviderEmail, zipCode, dashboardPage, providerEnrollingPage);

    }

    /**
     * This method submits a Provider Data Change request by creating a Request
     * object from the following class and calling the object's submit method:
     * {@link PEMProviderRequest}
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
                                         String providerEmailPassword, String providerID, IUEnrollmentPage iuEnrollmentPage, DashboardPage dashboardPage, SDHomePage sdHomePage) throws Exception {
        switch(enrollmentType) {
            case Data.SERVICING_PROVIDER:
                servicingProviderEnrollment.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage, dashboardPage, sdHomePage);
                break;
            case Data.BILLING_PROVIDER:
                billingProviderRequest.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage, dashboardPage, sdHomePage);
                break;
            case Data.TRADING_PARTNER:
                tradingProviderRequest.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage, dashboardPage, sdHomePage);
                break;
            case Data.PEM_PROVIDER:
                pemProviderRequest.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage, dashboardPage, sdHomePage);
                break;
            case Data.ENTITY_PROVIDER:
                entityproviderrequest.submitProviderDataChange(enrollmentType, firstName, lastName, providerEmail, providerEmailPassword, providerID, iuEnrollmentPage, dashboardPage, sdHomePage);
                break;
        }
    }
    /**
     * This method submits a Re_Enrollment request based on Enrollment type by creating a Request
     * object from one of the following classes and calling the object's submit method:
     * {@link ServicingProviderRequest}
     * {@link BillingProviderRequest}
     * {@link EntityProviderRequest}
     *
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param dashboardPage
     * @param providerEnrollingPage
     * @throws Exception
     */
    public void submitReEnrollment(String enrollmentType, String firstName, String lastName, DashboardPage dashboardPage,
                                      ProviderEnrollingPage providerEnrollingPage, EnrollmentFormElements formElements) throws Exception {

        if (enrollmentType.equalsIgnoreCase(Data.ENTITY_RE_ENROLLMENT)) {
            entityproviderrequest.submitReEnrollment(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, formElements);
        }
        if (enrollmentType.equalsIgnoreCase(Data.BILLING_RE_ENROLLMENT)) {
            billingProviderRequest.submitReEnrollment(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, formElements);
        }
        if (enrollmentType.equalsIgnoreCase(Data.SERVICING_RE_ENROLLMENT)) {
            servicingProviderEnrollment.submitReEnrollment(enrollmentType, firstName, lastName, dashboardPage, providerEnrollingPage, formElements);
        }

    }

}
