package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vii_FacilityEnrollment;

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

/**
 * This test class verifies the submission of a Facility enrollment.
 */
@Listeners(VideoListener.class)
public class FacilityProviderRegistrationAndSubmissionTest extends BaseClassUI {
    String npi;
    String zipCode;
    String testEmailAccount;
    String statusOfApplication;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.facilityApplication,
     * HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(),
     * HomePage.generateLastName(),"[Payment Method]", "[Answer to the question, are you an enrolled Medicare Provider?
     * (Yes or No)]", Data.specialityHomeHealth, Data.HomeHealthRequiredPaymentTaxonomy.
     *
     * @param context
     * @return Data object
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
                REFERENCE: {testEmailAccount, Data.[Application Type],HomePage.generateEmail("gmail.com"),
                HomePage.generateFirstName(),HomePage.generateLastName(),
                "[Payment Method]",
                [Only used for Group for affiliation purposes (Not built all the way at this time)],
                "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
                */
                {testEnvironment,testEmailAccount,
                        Data.facilityApplication,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(),
                        "Offline",
                        "No",
                        Data.specialityHomeHealth,
                        Data.HomeHealthRequiredPaymentTaxonomy},

                };
    }


    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits a Facility enrollment, logs out as the registered
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
    @Test(dataProvider = "Enrollment Application Data", groups =  {"FacilityRegisterAndSubmit"}, priority = 0)
    public void registerAndSubmitFacilityEnrollment (String testEnvironment,String testEmailAccount, String enrollmentType, String newEmail,String firstName, String lastName,
                                                  String paymentOption, String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {

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
        npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);

        driver.get(environmentUrl);
        Reports.log("Go to Environment and Start Registration of Provider");
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
        homePage.signInToApp(newEmail, providerEmailPassword);

        //Click on Facility Enrollment
        homePage.clickOnEnrollmentType(enrollmentType);

        //Identifying Information
        enrollmentPageProvider.fillInIdentifyingInformation(firstName, lastName, Data.fein, newEmail, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail Section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode,Data.inState);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
        if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
            //Payment Section
            enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);
        }
        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();

        //Hello Sign
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getProviderTrackingNumber();
      //  enrollmentPageInternalUser.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi, Data.APPLICATION_STATUS_SUBMITTED,trackingNum);
        excel.readExcel();

    }
}
