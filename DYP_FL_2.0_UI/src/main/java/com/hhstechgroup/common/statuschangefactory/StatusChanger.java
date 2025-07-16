package com.hhstechgroup.common.statuschangefactory;

import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.EnrollmentFormElements;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

/**
 * This class creates status change factory objects based on Request type
 */
public class StatusChanger {
    StatusChangeFactory factory;

    /**
     * This is a parameterized class constructor
     *
     * @param factory
     */
    public StatusChanger(StatusChangeFactory factory) {
        this.factory = factory;
    }

    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set enrollment status method in the {@link StatusChanger} class
     *
     * @param testEnvironment
     * @param environmentUrl
     * @param enrollmentType
     * @param applicationStatus
     * @param iuEnrollmentPage
     * @throws InterruptedException
     */
    public void setEnrollmentStatus(String testEnvironment, String environmentUrl, String enrollmentType, EnrollmentFormElements enrollmentFormElements,
                                    String applicationStatus, IUEnrollmentPage iuEnrollmentPage) throws IOException {
        factory.setEnrollmentStatus(testEnvironment, environmentUrl, enrollmentType, enrollmentFormElements, applicationStatus, iuEnrollmentPage);
    }

   public void setProviderStatus(String enrollmentType, String applicationStatus, IUEnrollmentPage iuEnrollmentPage,String providerID,EnrollmentFormElements enrollmentFormElements ) throws IOException, InterruptedException {
        factory.setProviderStatus(enrollmentType, applicationStatus, iuEnrollmentPage, providerID, enrollmentFormElements);
    }

    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set CoC status method in the {@link StatusChanger} class
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
    public void setCoCStatus(String testEnvironment, String environmentUrl, String enrollmentType,
                             String internalUserEmail, String internalUserPassword,
                             String firstName, String lastName, String trackingId,
                             String providerEmailId, String providerPwd, String applicationStatus, IUEnrollmentPage iuEnrollmentPage, WebDriver driver, CocsPage cocsPage) throws InterruptedException {

        factory.setCoCStatus(environmentUrl, enrollmentType,
                internalUserEmail, internalUserPassword,
                firstName, lastName, trackingId,
                providerEmailId, providerPwd, applicationStatus, iuEnrollmentPage, driver, cocsPage);
    }

    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set reconsideration status method in the {@link StatusChanger} class
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
     * @param iuEnrollmentPage
     * @param loginPage
     * @param reconsiderationPage
     * @param dashboardPage
     * @param landingPage
     * @param driver
     * @param applicationStatus
     * @throws InterruptedException
     */
    public void setReconsiderationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                         String internalUserEmail, String internalUserPassword,
                                         String firstName, String lastName, String trackingNum,
                                         String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage,
                                         ReconsiderationPage reconsiderationPage, DashboardPage dashboardPage,
                                         LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        factory.setReconsiderationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage,
                reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
    }

    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set termination status method in the {@link StatusChanger} class
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
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setTerminationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                     String internalUserEmail, String internalUserPassword,
                                     String firstName, String lastName, String trackingNum,
                                     String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        factory.setTerminationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
    }

    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set termination status method in the {@link StatusChanger} class
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
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setStatusForTerminationRequest(String testEnvironment, String environmentUrl, String applicationType,
                                               String internalUserEmail, String internalUserPassword,
                                               String firstName, String lastName, String trackingNum,
                                               String newEmail, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        factory.setStatusForTerminationRequest(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
    }

    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set Provider status method in the {@link StatusChanger} class
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
     * @param iuEnrollmentPage
     * @param driver
     * @throws InterruptedException
     */
    public void setReactivateTerminatedProviderStatus(String testEnvironment, String environmentUrl, String enrollmentType,
                                                      String internalUserEmail, String internalUserPassword,
                                                      String firstName, String lastName, String trackingId,
                                                      String providerEmailId, String providerPwd, IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {

        factory.setReactivateTerminatedProviderStatus(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingId, providerEmailId, providerPwd, iuEnrollmentPage, loginPage, dashboardPage, landingPage, driver, applicationStatus);
    }


    /**
     * This method creates an object used by the {@link StatusChangeFactory} class that calls the associated
     * set revalidation status in the {@link StatusChanger} class
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

        factory.setRevalidationStatus(testEnvironment, environmentUrl, applicationType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingNum, newEmail, providerPwd, iuEnrollmentPage, loginPage, reconsiderationPage, dashboardPage, landingPage, driver, applicationStatus);
    }
}
