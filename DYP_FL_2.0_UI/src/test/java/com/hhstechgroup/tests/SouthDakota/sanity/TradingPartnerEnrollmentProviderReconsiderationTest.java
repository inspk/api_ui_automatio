package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class TradingPartnerEnrollmentProviderReconsiderationTest extends BaseClassUI {

    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String trackingNum;

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.TRADING_PARTNER,
     * HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(),
     * HomePage.generateLastName(),"[Payment Method]", "[Answer to the question, are you an enrolled Medicare Provider?
     * (Yes or No)]", Data.specialityInterpreter, Data.interpreterTaxonomy.
     *
     * @param context
     * @return Data object
     */
    @DataProvider(name = "Enrollment Type")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");
        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{
                {testEnvironment, testEmailAccount,Data.TRADING_PARTNER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.CLEARING_HOUSE },

        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits a Trading partner enrollment, logs out as the registered
     * Provider and writes the enrollment information to ProviderInfo.xlsx.
     *
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Enrollment Type")
    public void reconsiderTradingPartnerEnrollment(String testEnvironment, String testEmailAccount,String enrollmentType,
                                                            String newEmail, String firstName, String lastName, String classificationType) throws Exception {

        //Delete emails from test email account
        email.deleteTestAccountEmails(testEmailAccount);

        //Retrieve NPI
        npi = sdhomePage.getRandomStringFromFile("SDNPI");

        //Retrieve Zip
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        String feinNum = sdhomePage.generateANumberOfLength(9);
        Reports.log("FEIN Number: " + feinNum);

        //Get the test environment URL
        driver.get(environmentUrl);

        //Register a new Provider
        providerRegistrationPage.openRegistrationPage();
        providerRegistrationPage.createNewProviderAccount(
                newEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                sdhomePage.generateNewNumber(10)
        );

        //Confirm Email
        email.openGmailAndClickConformAccountLink(newEmail);

        //Login Registered Provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Create Trading Partner Enrollment
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        //Complete Identifying Information
        providerEnrollingPage.fillInProviderIdentifyingInformationTP(HomePage.generateLegalBusiness(),
                HomePage.generateDBABusiness(), feinNum, Data.physicalAddress, Data.city, Data.state, zipCode, Data.countyCodeSD, Data.mailingState, newEmail);

        providerEnrollingPage.fillInClassificationSection(classificationType);
        //Complete Provider Identifiers
        providerEnrollingPage.fillInProviderIdentifierTP(npi);

        //ownership
        providerEnrollingPage.verifyOwnershipSectionTradingPartnerEnrmt();

        //Key Personnel
        providerEnrollingPage.fillInKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType);

        //Exclusion and Sanction Section
        providerEnrollingPage.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        providerEnrollingPage.fillAuthorizedSignaturSection(firstName+ " " + lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
       // dashboardPage.signInHelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        //Log in as Internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingNum, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
        iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingNum, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);

        iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingNum, Data.statusPendingApproval);
        iuEnrollmentPage.changeApplicationStatus(Data.ApplicationStatusDenied, enrollmentType);
        dashboardPage.logOut();

        //Login Registered Provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();
        dashboardPage.VerifyApplicationStatusIs(Data.ApplicationStatusDenied);
        dashboardPage.ClickOnAppealButton();
        reconsiderationPage.uploadFileAndSubmit();
        //Get Reconsideration Request ID
        reconsiderationPage.clickAnyButton(Data.TEXT_NAVIGATE_TO_DASHBOARD);

        String reconsider_requestID = reconsiderationPage.getProviderReconsiderationTrackingID();
        dashboardPage.logOut();

        //Log in as Internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();

        reconsiderationPage.navigateToReconsiderationAndSearchForTheProvider("", reconsider_requestID);

        //Set the Reconsideration status
        reconsiderationPage.changeStatusWithReasonForReconsideration(Data.ApplicationStatusApprove);

        //Get the Provider ID from the Reconsideration
        String providersID = iuEnrollmentPage.getProvidersIDFromReconsideration();

        iuEnrollmentPage.navigateBackToEnrollment();
        iuEnrollmentPage.searchProviderByTrackingNUm(providersID);
        iuEnrollmentPage.clickSearchResultRow();

        String dashboardStatus = iuEnrollmentPage.getApplicationStatus();

        dashboardPage.logOut();

        //Write Reconsideration status to Provider Info
        excel.writeTestData(testEnvironment,Data.TRADING_PARTNER_RECONSIDERATION,firstName, lastName, newEmail, providerEmailPassword,"",npi,dashboardStatus,reconsider_requestID);

        excel.readExcel();

        //Verify the status displayed on the Provider dashboard
        dashboardPage.verifyProviderDashboardStatus(loginPage, landingPage, dashboardPage,
                Data.TRADING_PARTNER_RECONSIDERATION, newEmail, providerEmailPassword, dashboardStatus, Data.ApplicationStatusApprove);
    }
}