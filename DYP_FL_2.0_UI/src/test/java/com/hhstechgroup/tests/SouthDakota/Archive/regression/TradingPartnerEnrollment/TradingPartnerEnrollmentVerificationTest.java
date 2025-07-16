package com.hhstechgroup.tests.SouthDakota.Archive.regression.TradingPartnerEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hhstechgroup.common.BaseActions.generateANumberOfLength;

@Listeners(VideoListener.class)

public class TradingPartnerEnrollmentVerificationTest extends BaseClassUI {

    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String trackingNum;
    String legalBusiness;
    String Business;

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.IndividualApplication,
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
                {testEnvironment, testEmailAccount, Data.TRADING_PARTNER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName()},

        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits a Trading partner  enrollment as  Billing Provider, logs out as the registered
     * Provider and writes the enrollment information to ProviderInfo.xlsx.
     *
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Enrollment Type", groups = {"RegisterAndSubmitTradingPartnerProvider"})
    public void registerAndSubmitAsTradingPartnerEnrollment(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                            String newEmail, String firstName, String lastName) throws Exception {

        Reports.log("The following Stories will be covered as part of this Test: \nPECS-842, PECS-843, PECS-844, PECS-847, PECS-848, PECS-849, PECS-850, PECS-852");

        //Delete emails from test email account
        email.deleteTestAccountEmails(testEmailAccount);

        //Retrieve NPI
        npi = sdhomePage.getRandomStringFromFile("SDNPI");

        //Retrieve Zip
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        String fein = generateANumberOfLength(9);

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
                sdhomePage.generateNewNumber(10));

        //Confirm Email
        email.openGmailAndClickConformAccountLink(newEmail);

        //Login Registered Provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        //Verify secure message, Authorize message
        landingPage.VerifySecureMessages();

        // Verify Agree and disagree buttons
        landingPage.verifyAgreeDisagreeButtons();

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Create Trading Partner Enrollment
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        // Verify Identifying Information section and fill the section
        legalBusiness = HomePage.generateLegalBusiness();
        Business = HomePage.generateDBABusiness();
        providerEnrollingPage.verifyAndFillIdentifyingInformationSectionForTradingPartnerEnrmt(legalBusiness,
                Business,fein , Data.physicalAddress, Data.city, Data.state, zipCode, Data.countyCodeSD, Data.mailingState, newEmail);

        // Verify Classification and fill the section
        providerEnrollingPage.verifyAndFillClassificationSectionTradingPartnerEnrollment();

        //verify Provider Identifiers and fill the section
        providerEnrollingPage.verifyAndFillProviderIdentifierSectionTradingPartnerEnrmt(npi);

        // Verify ownership section
        providerEnrollingPage.verifyOwnershipSectionTradingPartnerEnrmt();

        // Verify key personnel and fill the section
        providerEnrollingPage.verifyAndFillKeyPerssonelSectionTradingPartnerEnrmt(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType);

        // Verify Exclusion/Sanction and fill the Section
        providerEnrollingPage.verifyAndFillExclusionAndSectionEnrollment();

        // verifying the upload document Section and upload the document
        providerEnrollingPage.verifyUploadDocumentSection(enrollmentType);

        //Verify Authorized Signature and fill Section
        providerEnrollingPage.verifyAndFillAuthorizedSignatureSectionTradingPartnerEnrollment(firstName + " " + lastName);

        //Verify and fill Provider Agreement Section
        providerEnrollingPage.verifyAndFillProviderAgreementSection(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.verifyAndSubmitSummarySection(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, newEmail, providerEmailPassword, "", npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        excel.readExcel();
    }
}



