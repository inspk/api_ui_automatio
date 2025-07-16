package com.hhstechgroup.tests.SouthDakota.Archive.regression.IndividualEnrollment;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndividualEnrollmentFormVerificationTest extends BaseClassUI {

    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String trackingNum;

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.IndividualApplication,
     * HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(),
     * HomePage.generateLastName(),"[Payment Method]", "[Answer to the question, are you an enrolled Medicare Provider?
     * (Yes or No)]", Data.specialityInterpreter, Data.interpreterTaxonomy.
     *
     * @param context
     * @return Data object
     */
    @DataProvider(name = "Enrollment type")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");
        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{
                {testEnvironment, testEmailAccount, Data.individualApplication,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.middleName, "Offline",
                        "No", Data.specialityInterpreter, Data.interpreterTaxonomy},
        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits a Individual  enrollment as  Billing Provider, logs out as the registered
     * Provider and writes the enrollment information to ProviderInfo.xlsx.
     *
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @param firstName
     * @param lastName
     * @param paymentOption
     * @param medicareParticipant
     * @param taxonomyCategory
     * @param taxonomy
     * @throws Exception
     */

    @Video
    @Test(dataProvider = "Enrollment type", groups = {"RegisterAndSubmitIndividualProvider"})
    public void enrollmentFormVerificationAndSubmissionTest(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                            String newEmail, String firstName, String lastName, String middleName, String paymentOption,
                                                            String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {
        Reports.log("The following Stories will be covered as part of this Test:\nPECS-669, \nPECS-690");

        //Gmail Delete
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        Reports.log("New NPI: " + npi);
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        Reports.log("New Zip: " + zipCode);

        driver.get(environmentUrl);

        Reports.log("\nGo to Environment and Start Registration of Provider");
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

        //Login Application with newly Registered provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Starting Individual Enrollment Process
        dashboardPage.clickOnEnrollmentType(enrollmentType);

        //Identifying Information
        providerEnrollingPage.fillInIndividualIdentifyingInformation(
                firstName, lastName, middleName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                Data.ssn, Data.applicationContactNo,Data.profitStatusNonProfit, enrollmentType, Data.medicaidPaymentYes, Helper.getCurrentDatestamp());

        //Provider Identifier Section
        providerEnrollingPage.verifyAndFillingProviderIdentifiersSectionForIndvalEnrmt(medicareParticipant, npi, enrollmentType, taxonomyCategory);
        providerEnrollingPage.fillInKeyPersonalSection(0, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType);

        //EFT Information Section
        providerEnrollingPage.verifyEFTSectionBasedOnMedicaidPayment();
        providerEnrollingPage.fillInEFTInformationSection(enrollmentType, firstName);

//       //Exclusion and Sanction Section
//        providerEnrollingPage.fillInExclusionAndSanctionSection();

        // verifying the upload document Section and upload the document
        providerEnrollingPage.verifyUploadDocumentSection(enrollmentType);

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD);
        providerEnrollingPage.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        //Primary Service Location Section
        providerEnrollingPage.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode,Data.inState);

        //Taxonomy/ License Information Section
        providerEnrollingPage.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Ownership
        providerEnrollingPage.fillInOwnershipSection(enrollmentType);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.verifyAndSubmitSummarySection(firstName, lastName);
        dashboardPage.signInHelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi, Data.APPLICATION_STATUS_SUBMITTED_FOR_BP,trackingNum);
        excel.readExcel();
    }
}
