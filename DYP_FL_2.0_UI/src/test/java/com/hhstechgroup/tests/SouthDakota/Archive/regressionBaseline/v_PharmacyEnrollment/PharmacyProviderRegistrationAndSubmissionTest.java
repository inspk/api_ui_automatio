package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)
/**
 * This class contains a test which uses a data provider to register a new Provider, Creates and submits a pharmacy enrollment
 */

public class PharmacyProviderRegistrationAndSubmissionTest extends BaseClassUI {

    String npi;
    String zipCode;
    String testEmailAccount;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This method creates the "Enrollment Application Data" DataProvider containing the following:
     * {testEmailAccount, Data.[Application Type],HomePage.generateEmail("gmail.com"),
     * HomePage.generateFirstName(),HomePage.generateLastName(),"[Payment Method]",
     * [Only used for PEM for affiliation purposes (Not built all the way at this time)],
     * "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
     * @param context
     * @return
     */
    @DataProvider(name = "Enrollment Application Data")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");

        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{

                /*
                REFERENCE: {testEmailAccount,Data.[Application Type],HomePage.generateEmail("gmail.com"), HomePage.generateFirstName(),HomePage.generateLastName(),
                "[Application Status (Approved/Denied)]", "[Payment Method]", [Only used for Group for affiliation purposes (Not built all the way at this time)],
                "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
                */
                {testEnvironment,testEmailAccount,
                 Data.pharmacyApplication,
                 HomePage.generateEmail(providerEmailPrefix,"gmail.com"),
                 HomePage.generateFirstName(),
                 HomePage.generateLastName(),
                 Data.APPLICATION_STATUS_SUBMITTED,
                 "Offline",
                 "No",
                 Data.pharmacyType,
                 Data.primaryTaxonomyCode},
        };
    }

    /**
     * This method registers a new Provider. Creates and submits a pharmacy enrollment. The flow is first deletes all
     * the exiting emails in gmail and then open registration page. Fills in all the fields. Opens gmail, clicks on
     * registration link and confirms. Logs in with the email, selects the enrollment type (pharmacy) and completes all
     * the sections then signs the enrollment. At the end the info writes out to ProviderInfo.xlsx
     * @param testEmailAccount
     * @param enrollmentType
     * @param newEmail
     * @param firstName
     * @param lastName
     * @param statusOfApplication
     * @param paymentOption
     * @param medicareParticipant
     * @param taxonomyCategory
     * @param taxonomy
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "Enrollment Application Data", groups =  {"PharmacyRegisterAndSubmit"}, priority = 0)
    public void registerAndSubmitPharmacyEnrollment (String testEnvironment, String testEmailAccount,String enrollmentType, String newEmail,
                                                     String firstName, String lastName,
                                                     String statusOfApplication, String paymentOption,
                                                     String medicareParticipant,
                                                     String taxonomyCategory, String taxonomy) throws Exception {

        /*
        Provider operations:
        01. Fill in required sections and fields
        02. Can switch Offline and Online payments
        03. Can select Approve and Deny
         */

        //Gmail Delete
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        Reports.log("Go to Environment and Start Registration of Provider");
        driver.get(environmentUrl);
        npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);
        homePage.openRegistrationPage();
        homePage.fillInNewRegistrationPage(
                newEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                homePage.generateNewNumber(10));

        //Confirm Email
        email.openGmailAndClickRegistrationLink(newEmail);

        //Start Enrollment Application
        Reports.log("Starting Enrollment Process");
        homePage.signInToApp(newEmail, providerEmailPassword);
        homePage.clickAnyTitleByText(enrollmentType, Data.h2);

        //Identifying Information
        enrollmentPageProvider.fillInIdentifyingInformation(firstName, lastName, Data.fein, newEmail, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address
        enrollmentPageProvider.fillInIndividualAddressDetails(Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);

        //mailingAddress
        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode, Data.inState);

        //Key Personnel Section
        enrollmentsAndCoc.fillInKeyPersonalSection();

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        // enrollmentPageProvider.scrollToBottomOfPage();

        //Payment Section
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();

        //HelloSignIn
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getProviderTrackingNumber();

        //Logout
        enrollmentPageInternalUser.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi, statusOfApplication, trackingNum);
        excel.readExcel();

    }
}
