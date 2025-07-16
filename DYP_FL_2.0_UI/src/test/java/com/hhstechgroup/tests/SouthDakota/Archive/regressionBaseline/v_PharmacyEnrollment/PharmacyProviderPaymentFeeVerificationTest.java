package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.v_PharmacyEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to register a new Provider and, creates and submits an pharmacy enrollment
 */
public class PharmacyProviderPaymentFeeVerificationTest extends BaseClassUI {
    String npi;
    String testEmailAccount;
    String zipCode;
    String statusOfApplication = Data.ApplicationStatusApprove ;
    ExcelWrite excel =
            new ExcelWrite( providerInfoSheet,0);

    /**
     * This method creates the "Enrollment Application Data" DataProvider containing the following:
     * {testEmailAccount, Data.[Application Type],HomePage.generateEmail("gmail.com"),
     * HomePage.generateFirstName(),HomePage.generateLastName(),"[Payment Method]",
     * [Only used for PEM for affiliation purposes (Not built all the way at this time)],
     * "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
     * @param context
     * @return
     */
    @DataProvider(name = "Pharmacy Enrollment Application Data")
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
                "[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}
                */
                {testEnvironment,testEmailAccount, Data.pharmacyApplication, HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(), HomePage.generateLastName(),
                        "Offline", "No", Data.pharmacyType, Data.primaryTaxonomyCode},
        };
    }

    /**
     * This method registers a new Provider, creates and submits a pharmacy enrollment. The flow is first deletes
     * all the exiting emails in gmail and then open registration page and fills all the fields. Opens gmail and clicks
     * on registration link and confirm. Logs in with the email, selects the enrollment type (pharmacy enrollment), completes
     * all the sections and verifies the "in state" payment fee and signs the enrollment. Logs in as an internal user, does the
     * document review and under screening. Changes the status of enrollment from "PENDING APPROVAL" to "Approved".
     * At the end the info writes out to ProviderInfo.xlsx
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
    @Test(dataProvider = "Pharmacy Enrollment Application Data")
    public void instatePaymentFeesVerificationForPharmacyPrvdr (String testEnvironment,String testEmailAccount,String enrollmentType, String newEmail, String firstName, String lastName,
                                                                String paymentOption, String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {
        /*
         Provider operations:
         Fill in required sections and fields
         Can switch Offline and Online payments,
      Primary Service Location = WY, Taxonomy: Required Fees.
          */

        //Gmail Delete
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        email.deleteEmails();

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
        Reports.log("Open Section: Identifying Information");
        enrollmentPageProvider.fillInIdentifyingInformation(firstName, lastName, Data.fein, newEmail, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        //mailingAddress
        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode,Data.inState);

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
        enrollmentPageProvider.verifyPaymentDetails(Data.inStateEnrollmentFeeForPharmacy);

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit", taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        //Verify Payment
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            if (paymentOption.contains("Offline")) {
                enrollmentPageInternalUser.clickAnyButton(Data.TEXT_VERIFY_PAYMENT);
                driver.findElement(Locators.POP_UP_DOCUMENT).findElement(Locators.POPUP_IS_PAYMENT_RECEIVED).click();
                enrollmentPageInternalUser.fillInCalendar("03/20/2020", Data.datepaymentreceived);
                driver.findElement(By.xpath("//label[text()='" + Data.datepaymentreceived + "']/following::div/input[@placeholder='MM/DD/YYYY']")).sendKeys(Keys.TAB);
                enrollmentPageInternalUser.clickAnyButton(Data.TEXT_VERIFY);
            }
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }
        enrollmentPageInternalUser.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi, statusOfApplication,trackingNum);
        excel.readExcel();

    }

    /**
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
    @Test(dataProvider = "Pharmacy Enrollment Application Data", groups = "PharmacyOutStatePaymentApproval")
    public void outStatePaymentFeesVerificationForPharmacyPrvdr (String testEnvironment, String testEmailAccount, String enrollmentType, String newEmail, String firstName, String lastName,
                                                              String paymentOption, String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {
        /*
         Provider operations:
         Fill in required sections and fields
         Can switch Offline and Online payments
         Can select Approve and Deny
         Select index of internal user for next test cases: Coc, Appeals and Group Affiliation
          */

        //Gmail Delete
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        email.deleteEmails();

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
        Reports.log("Open Section: Identifying Information");
        enrollmentPageProvider.fillInIdentifyingInformation(firstName, lastName, Data.fein, newEmail, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddressCA, Data.citySAC, Data.mailingOutState, Data.zipCA, Data.countyCodeSAC);
        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, homePage.generateNewNumber(10), newEmail);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode, Data.outState);

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
        enrollmentPageProvider.verifyPaymentDetails(Data.outStateEnrollmentFeeForPharmacy);
        //     }

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingNum = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageInternalUser.logOut();

        //Internal user Operations....

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingNum);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingNum,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING REVIEW",trackingNum);
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit", taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
        }

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
            }
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }

        enrollmentPageInternalUser.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi, statusOfApplication,trackingNum);
        excel.readExcel();
    }
}
