package com.hhstechgroup.tests.SouthDakota.sanity;

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

@Listeners(VideoListener.class)
public class TradingPartnerEnrollmentProviderTest extends BaseClassUI {

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
     * @param providerEmail
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Enrollment Type", groups =  {"RegisterAndSubmitTradingPartnerProvider"})
    public void registerAndSubmitAsTradingPartnerEnrollment(String testEnvironment, String testEmailAccount,String enrollmentType,
                                                            String providerEmail, String firstName, String lastName, String classificationType) throws Exception {

        //Delete emails from test email account
        email.deleteTestAccountEmails(testEmailAccount);

        //Retrieve NPI
        npi = sdhomePage.getRandomStringFromFile("SDNPI");

        //Retrieve Zip
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");

        //Get the test environment URL
        //Retrieve Zip
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        String feinNum = sdhomePage.generateANumberOfLength(9);
        Reports.log("FEIN Number: " + feinNum);

        //Get the test environment URL
        driver.get(environmentUrl);

//        Register a new Provider
        providerRegistrationPage.openRegistrationPage();
        providerRegistrationPage.createNewProviderAccount(
                providerEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                sdhomePage.generateNewNumber(10)
        );

        //Confirm Email
        email.openGmailAndClickConformAccountLink(providerEmail);

        //Login Registered Provider
        loginPage.signInToApp(providerEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Create Trading Partner Enrollment
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        //Complete Identifying Information
        providerEnrollingPage.fillInProviderIdentifyingInformationTP(HomePage.generateLegalBusiness(),
               HomePage.generateDBABusiness(), feinNum, Data.physicalAddress, Data.city, Data.state, zipCode, Data.countyCodeSD, Data.mailingState, providerEmail);


//        providerEnrollingPage.fillInClassificationSection(classificationType);

        providerEnrollingPage.fillInTaxonomyForTP();

        //Complete Provider Identifiers
       providerEnrollingPage.fillInProviderIdentifierTP(npi);
        // Service Locations
        providerEnrollingPage.fillInServiceLocationSectionforTP(enrollmentType, zipCode, Data.TAXONOMY_PHYSICAL_THERAPIST, Data.Trading_Partner999);


        providerEnrollingPage.fillInClassificationSection(classificationType);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformationForTP(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD,providerEmail);


        //ownership
       providerEnrollingPage.verifyOwnershipSectionTradingPartnerEnrmt();


        //Key Personnel
       providerEnrollingPage.fillInKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType);

        //Exclusion and Sanction Section
        providerEnrollingPage.fillInExclusionAndSanctionSectionForTP();

        //Authorized Signature Section
        providerEnrollingPage.fillInAuthorizedSignature();

        //Provider Agreement Section
//        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySection(firstName, lastName);
//        dashboardPage.HelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, providerEmail, providerEmailPassword,"",npi, Data.APPLICATION_STATUS_SUBMITTED,trackingNum);
        excel.readExcel();
        Data.ProviderID= trackingNum;
        //Jira Linkage
        Reports.log("Test is linked to Jira Xray ID: PECS-1934");
    }
}