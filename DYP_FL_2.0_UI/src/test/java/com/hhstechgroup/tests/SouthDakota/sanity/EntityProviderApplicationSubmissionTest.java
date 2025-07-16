package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EntityProviderApplicationSubmissionTest extends BaseClassUI {

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
                        Data.interpreterTaxonomy, HomePage.getCurrentDate()},
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
    @JiraDefectCreateIssue(isCreateIssue = true)
    @Video
    @Test(dataProvider = "Enrollment Type", groups = {"RegisterAndSubmitEntityProvider"})
    public void registerAndSubmitAsEntityEnrollment(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                    String newEmail, String firstName, String lastName, String taxonomyCategory, String taxonomy, String enrollmentDate) throws Exception {
        //Retrieve NPI, ZIP
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        legalBusiness = HomePage.generateLegalBusiness();
        String applicationContactPhone = sdhomePage.generateANumberOfLength(10);

        Business = HomePage.generateDBABusiness();
        String feinNum = sdhomePage.generateANumberOfLength(9);
        Reports.log("FEIN Number: " + feinNum);
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

        //Create Entity Enrollment
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        // filling Identifying Information section
        providerEnrollingPage.fillInIdentifyingInfoForEntity(legalBusiness, Business, feinNum, newEmail, enrollmentDate);

        //Program Participation Section
        providerEnrollingPage.fillInTaxonomyForGroup(enrollmentType, Data.PHYSICAL_THERAPIST_SPECIALITY, Data.LICENSE_FOR_PHYSICAL_THERAPIST_SPECIALITY);


        //Filling Provider Identifiers section
        providerEnrollingPage.fillProviderIdentifierSectionEntityEnrmt(npi);

        //Professional Liability Insurance Information
        providerEnrollingPage.flFillInIndividualProfessionalLiabilityInsuranceInformationSectionForGrp();

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD);
        providerEnrollingPage.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);
        // Service Location Section
        providerEnrollingPage.fillInServiceLocationSection(enrollmentType, newEmail, zipCode, Data.TAXONOMY_PHYSICAL_THERAPIST, Data.PHYSICAL_THERAPIST_SPECIALITY);

        //Add affiliation
//        providerEnrollingPage.fillInAffiliationSectionForGroup(Data.AFFILIATION_TYPE_GRP_TO_IND) ;


        providerEnrollingPage.fillInOwnershipSectionEntityEnrollment();
//        providerEnrollingPage.fillInOtherCredentialingInfo(Data.ORGANIZATIONAME,Data.PROFFESIONALSCHOOLNAME,Data.physicalAddress,Data.proffesionalschoolcity,Data.mailingState,Data.countryOfBirth);

        //Filling Key Personnel Section
        providerEnrollingPage.fillInKeyPersonalSectionEntity(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType, npi);

        // Verify Exclusion/Sanction and fill the Section
        providerEnrollingPage.fillInExclusionAndSanctionSection();

        //EFT Information Section
        providerEnrollingPage.fillInEFTInformationSection(Data.ENTITY_PROVIDER, firstName);

//        //Taxonomy/ License Information Section
//       // providerEnrollingPage.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);
//
//        //Primary Service Location Section
//       // providerEnrollingPage.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode,Data.inState);
        providerEnrollingPage.fillInAuthorizedSignature();
//        //fill Provider Agreement Section
//        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySection(firstName, lastName);
//        dashboardPage.logOut();
//
//        loginPage.signInToApp("johny.providers+4098@gmail.com", providerEmailPassword);
//        landingPage.confirmAgreeAndSecureMessages();
//        providerEnrollingPage.navigateAndOpenToMessageCenter();
//        dashboardPage.ProccedToSignHelloSign(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_FIRST_NAME) + " " + enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_LAST_NAME), "");
//        dashboardPage.logOut();
//
//         //Login Registered Provider
//        loginPage.signInToApp(newEmail, providerEmailPassword);
//
//          // confirmAgreeAndSecureMessages();
//        landingPage.confirmAgreeAndSecureMessages();
//
//        dashboardPage.ProccedToSignHelloSign(firstName, lastName);
        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, newEmail, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        Data.givenproviderEmail= newEmail;
        Data.providerNPI= npi;
        Data.ProviderID= trackingNum;
        excel.readExcel();
    }
}
