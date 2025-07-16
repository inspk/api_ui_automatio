package com.hhstechgroup.common.statuschangefactory;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.EnrollmentFormElements;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

/**
 * This utilizes status change objects created by the {@link StatusChanger} class to set the status of a
 * Request
 */
public class StatusChangeFactory {

    IndividualStatusChangeRequest individualStatusChangeRequest = new IndividualStatusChangeRequest();
    TradingPartnerStatusChangeRequest tradingPartnerStatusChangeRequest = new TradingPartnerStatusChangeRequest();
    EntityStatusChangeRequest entityStatusChangeRequest = new EntityStatusChangeRequest();
    PEMStatusChangeRequest pemProviderStatusChange = new PEMStatusChangeRequest();


    /**
     * This method sets the status of an Enrollment request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     * {@link TradingPartnerStatusChangeRequest}
     * {@link PEMStatusChangeRequest}
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param enrollmentType    //     * @param internalUserEmail
     *                          //     * @param internalUserPassword
     *                          //     * @param firstName
     *                          //     * @param lastName
     *                          //     * @param trackingId
     *                          //     * @param providerEmailId
     *                          //     * @param providerPwd
     * @param applicationStatus
     * @param iuEnrollmentPage  //     * @param driver
     * @throws InterruptedException
     */
    public void setEnrollmentStatus(String testEnvironment, String environmentUrl, String enrollmentType, EnrollmentFormElements enrollmentFormElements,
                                    String applicationStatus, IUEnrollmentPage iuEnrollmentPage) throws IOException {

        switch (enrollmentType) {
            case Data.ENTITY_PROVIDER:
            case Data.ENTITY_REVALIDATION:
            case Data.ENTITY_RE_ENROLLMENT:
                entityStatusChangeRequest.setStatusForEnrollment(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);
                break;
            case Data.BILLING_PROVIDER:
            case Data.BILLING_PROVIDER_REVALIDATION:
            case Data.BILLING_RE_ENROLLMENT:
            case Data.SERVICING_PROVIDER:
            case Data.SERVICING_PROVIDER_REVALIDATION:
            case Data.SERVICING_RE_ENROLLMENT:
                individualStatusChangeRequest.setStatusForEnrollment(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);
                break;
            case Data.TRADING_PARTNER:
            case Data.TRADING_PARTNER_REVALIDATION:
                tradingPartnerStatusChangeRequest.setStatusForEnrollment(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);
                break;
            case Data.PEM_PROVIDER:
            case Data.PEM_PROVIDER_REVALIDATION:
                pemProviderStatusChange.setStatusForEnrollment(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);
                break;
        }
    }

    /**
     * This method sets the status of a Provider file based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     *
     * @param enrollmentType
     * @param applicationStatus
     * @param iuEnrollmentPage
     * @param providerID
     * @param enrollmentFormElements
     * @throws IOException
     * @throws InterruptedException
     */

    public void setProviderStatus(String enrollmentType, String applicationStatus, IUEnrollmentPage iuEnrollmentPage, String providerID,
                                  EnrollmentFormElements enrollmentFormElements) throws IOException, InterruptedException {

        switch (enrollmentType) {
            case Data.ENTITY_PROVIDER:
            case Data.ENTITY_RE_ENROLLMENT:
                entityStatusChangeRequest.setStatusForProvider(applicationStatus, iuEnrollmentPage, providerID, enrollmentFormElements);
                break;
            case Data.BILLING_PROVIDER:
            case Data.BILLING_RE_ENROLLMENT:
            case Data.SERVICING_PROVIDER:
            case Data.SERVICING_RE_ENROLLMENT:
                individualStatusChangeRequest.setStatusForProvider(applicationStatus, iuEnrollmentPage, providerID, enrollmentFormElements);
                break;
            case Data.PEM_PROVIDER:
                pemProviderStatusChange.setStatusForProvider(applicationStatus, iuEnrollmentPage, providerID, enrollmentFormElements);
                break;
            case Data.TRADING_PARTNER:
                tradingPartnerStatusChangeRequest.setStatusForProvider(applicationStatus, iuEnrollmentPage, providerID, enrollmentFormElements);
                break;
        }
       }

    /**
     * This method sets the status of a CoC request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     * {@link TradingPartnerStatusChangeRequest}
     * {@link PEMStatusChangeRequest}
     * <p>
     * <p>
     * //     * @param testEnvironment
     *
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
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setCoCStatus(String environmentUrl, String enrollmentType,
                             String internalUserEmail, String internalUserPassword,
                             String firstName, String lastName, String trackingId,
                             String providerEmailId, String providerPwd, String applicationStatus, IUEnrollmentPage iuEnrollmentPage, WebDriver driver, CocsPage cocsPage) throws InterruptedException {

        switch (enrollmentType) {
            case Data.BILLING_PROVIDER_COC:
            case Data.SERVICING_PROVIDER_COC:
                individualStatusChangeRequest.setStatusForCoC(environmentUrl, enrollmentType,
                        internalUserEmail, internalUserPassword, firstName, lastName, trackingId, providerEmailId,
                        providerPwd, applicationStatus, iuEnrollmentPage, driver, cocsPage);
                break;
            case Data.TRADING_PARTNER_COC:
                tradingPartnerStatusChangeRequest.setStatusForCoC(environmentUrl, firstName, lastName, trackingId, applicationStatus, cocsPage);
                break;
            case Data.ENTITY_PROVIDER_COC:
                entityStatusChangeRequest.setStatusForCoC(environmentUrl, enrollmentType,
                        internalUserEmail, internalUserPassword, firstName, lastName, trackingId, providerEmailId,
                        providerPwd, applicationStatus, iuEnrollmentPage, driver, cocsPage);
                break;
            case Data.PEM_PROVIDER_COC:
                pemProviderStatusChange.setStatusForCoC(environmentUrl, enrollmentType,
                        internalUserEmail, internalUserPassword, firstName, lastName, trackingId, providerEmailId,
                        providerPwd, applicationStatus, iuEnrollmentPage, driver, cocsPage);
                break;
        }
    }

    /**
     * This method sets the status of a Reconsideration request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     * {@link TradingPartnerStatusChangeRequest}
     * {@link PEMStatusChangeRequest}
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param providerPwd
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setReconsiderationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                         String internalUserEmail, String internalUserPassword,
                                         String firstName, String lastName, String trackingNum,
                                         String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage,
                                         ReconsiderationPage reconsiderationPage, DashboardPage dashboardPage,
                                         LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {
        switch (applicationType) {
            case Data.BILLING_PROVIDER_RECONSIDERATION:
            case Data.SERVICING_PROVIDER_RECONSIDERATION:
                individualStatusChangeRequest.setStatusForReconsideration(testEnvironment, environmentUrl, applicationType,
                        internalUserEmail, internalUserPassword, firstName, lastName, trackingNum, newEmail,
                        providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver,
                        applicationStatus);
                break;
            case Data.TRADING_PARTNER_RECONSIDERATION:
                tradingPartnerStatusChangeRequest.setStatusForReconsideration(firstName, lastName, trackingNum, iuEnrollmentPage, reconsiderationPage, applicationStatus);
                break;
            case Data.ENTITY_PROVIDER_RECONSIDERATION:
                entityStatusChangeRequest.setStatusForReconsideration(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
            case Data.PEM_PROVIDER_RECONSIDERATION:
                pemProviderStatusChange.setStatusForReconsideration(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage,
                        reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
        }
    }

    /**
     * This method sets the status of a Termination request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param providerPwd
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setTerminationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                     String internalUserEmail, String internalUserPassword,
                                     String firstName, String lastName, String trackingNum,
                                     String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        switch (applicationType) {
            case Data.ENTITY_PROVIDER:
                entityStatusChangeRequest.setStatusForTerminationRequest(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
        }
    }

    /**
     * This method sets the status of a Termination request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param providerPwd
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setStatusForTerminationRequest(String testEnvironment, String environmentUrl, String applicationType,
                                               String internalUserEmail, String internalUserPassword,
                                               String firstName, String lastName, String trackingNum,
                                               String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        switch (applicationType) {
            case Data.ENTITY_PROVIDER_REQUEST_TERMINATION:
                entityStatusChangeRequest.setStatusForTerminationRequest(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
            case Data.BILLING_PROVIDER_REQUEST_TERMINATION:
                individualStatusChangeRequest.setStatusForTerminationRequest(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
        }
    }

    /**
     * This method sets the status of a Termination request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param providerPwd
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setReactivateTerminatedProviderStatus(String testEnvironment, String environmentUrl, String applicationType,
                                                      String internalUserEmail, String internalUserPassword,
                                                      String firstName, String lastName, String trackingNum,
                                                      String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        switch (applicationType) {
            case Data.BILLING_PROVIDER_REQUEST_TERMINATION:
                individualStatusChangeRequest.setReactivateTerminatedProviderStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
            case Data.ENTITY_PROVIDER_REQUEST_TERMINATION:
                entityStatusChangeRequest.setReactivateTerminatedProviderStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
        }
    }

    /**
     * This method sets the status of a Revalidation request based on Enrollment type by creating a status change
     * object from one of the following classes and calling the object's status change method:
     * {@link IndividualStatusChangeRequest}
     * {@link EntityStatusChangeRequest}
     * {@link TradingPartnerStatusChangeRequest}
     * {@link PEMStatusChangeRequest}
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param internalUserEmail
     * @param internalUserPassword
     * @param firstName
     * @param lastName
     * @param providerPwd
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setRevalidationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                      String internalUserEmail, String internalUserPassword,
                                      String firstName, String lastName, String trackingNum,
                                      String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage,
                                      ReconsiderationPage reconsiderationPage, DashboardPage dashboardPage,
                                      LandingPage landingPage, WebDriver driver, String applicationStatus) throws Exception {

        switch (applicationType) {
            case Data.ENTITY_PROVIDER:
                entityStatusChangeRequest.setRevalidationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
            case Data.TRADING_PARTNER:
                tradingPartnerStatusChangeRequest.setRevalidationStatus(environmentUrl, trackingNum, iuEnrollmentPage, dashboardPage);
                break;
            case Data.PEM_PROVIDER:
                pemProviderStatusChange.setRevalidationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
            case Data.BILLING_PROVIDER:
            case Data.SERVICING_PROVIDER:
                individualStatusChangeRequest.setRevalidationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                        firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
                break;
        }
    }
}
