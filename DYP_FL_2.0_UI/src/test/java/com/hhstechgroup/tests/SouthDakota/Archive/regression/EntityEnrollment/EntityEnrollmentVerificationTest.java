package com.hhstechgroup.tests.SouthDakota.Archive.regression.EntityEnrollment;

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

public class EntityEnrollmentVerificationTest extends BaseClassUI {

    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String trackingNum;
    String legalBusiness;
    String Business;

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.entityApplication,
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
                {testEnvironment, testEmailAccount, Data.ENTITY_PROVIDER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.specialityInterpreter,
                        Data.interpreterTaxonomy },
        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits an Entity enrollment, logs out as the registered
     * Provider and writes the enrollment information to ProviderInfo.xlsx.
     *
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Enrollment Type", groups = {"RegisterAndSubmitEntityProvider"})
    public void enrollmentFormVerificationAndSubmissionTest(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                            String newEmail, String firstName, String lastName, String taxonomyCategory, String taxonomy, String enrollmentDate) throws Exception {

        Reports.log("The following Stories will be covered as part of this Test: " +
                "\nPECS-999 : Identifying information Section" +
                "\nPECS-1000 : Provider identifiers" +
                "\nPECS-1003 : Exclusion/sanction Information" +
//               "\nPECS-1005 : Address details" +
                "\nPECS-1009 : Provider agreement"+
                "\nPECS-698 : Summary information");

        //Retrieve NPI, ZIP
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        legalBusiness = HomePage.generateLegalBusiness();
        Business = HomePage.generateDBABusiness();
        //Delete emails from test email account
        email.deleteTestAccountEmails(testEmailAccount);

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

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Create Trading Partner Enrollment
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        // Verify Identifying Information section and fill the section
        providerEnrollingPage.verifyAndFillIdentifyingInformationSectionForEntityEnrolment(legalBusiness, Business, Data.fein, newEmail, enrollmentDate);

        //verify Provider Identifiers and fill the section
        providerEnrollingPage.verifyAndFillProviderIdentifierSectionEntityEnrmt(npi);

        // Verify Exclusion/Sanction and fill the Section
        providerEnrollingPage.verifyAndFillExclusionAndSectionEnrollment();

        //EFT Information Section
        providerEnrollingPage.fillInEFTInformationSection(Data.ENTITY_PROVIDER, firstName);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD);
        providerEnrollingPage.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        // verifying the upload document Section and upload the document
        providerEnrollingPage.verifyUploadDocumentSection(enrollmentType);

        //Taxonomy/ License Information Section
        providerEnrollingPage.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        providerEnrollingPage.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode,Data.inState);

        //Verify and fill Provider Agreement Section
        providerEnrollingPage.verifyAndFillProviderAgreementSection(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.verifyAndSubmitSummarySection(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, newEmail, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        excel.readExcel();
    }
}



