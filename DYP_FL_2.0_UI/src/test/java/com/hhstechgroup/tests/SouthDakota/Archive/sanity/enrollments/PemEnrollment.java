package com.hhstechgroup.tests.SouthDakota.Archive.sanity.enrollments;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class PemEnrollment extends BaseClassUI {
    DataFiles dataFiles = new DataFiles();
    String zipCode;
    public String providerEmail;
    public String testEnv;
    String testEmailAccount;


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

/* REFERENCE: {Data.[Application Type],sdhomePage.generateEmail("gmail.com"), sdhomePage.generateFirstName(),sdhomePage.generateLastName(),
"[Application Status (Approved/Denied)]", "[Payment Method]", [Only used for Group for affiliation purposes (Not built all the way at this time)],
"[Answer to the question, are you an enrolled Medicare Provider? (Yes or No)]"}*/
                {testEnvironment, testEmailAccount,Data.pemApplication, sdhomePage.generateEmail(providerEmailPrefix, "gmail.com"), sdhomePage.generateFirstName(), sdhomePage.generateLastName(), "Approved", "Offline", 1, "No", Data.specialityChiropractic, Data.chiropractorTaxonomy},

        };
    }

    @Video
    @Test(dataProvider = "Enrollment type", priority = 1)
    public void registerAnyTypeOfEnrollment(String testEnvironment,String testEmailAccount,String enrollmentType, String newEmail,
                                            String firstName, String lastName,
                                            String statusOfApplication, String paymentOption,
                                            int indexEnrollment, String medicareParticipant,
                                            String taxonomyCategory, String taxonomy) {
         /*
         Provider operations:
         Fill in required sections and fields
         Can switch Offline and Online payments
         Can select Approve and Deny
         Select index of internal user for next test cases: Coc, Appeals and Group Affiliation
          */
        email.deleteTestAccountEmails(testEmailAccount);

        driver.get(environmentUrl);

        zipCode = sdhomePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);

        sdhomePage.openRegistrationPage();
        sdhomePage.fillInNewRegistrationPage(
                newEmail,
                providerEmailPassword,
                Data.nameOfOrg,
                firstName,
                lastName,
                sdhomePage.generateNewNumber(10));
        providerEmail = newEmail;
        testEnv = testEnvironment;

        email.openGmailAndClickConformAccountLink(newEmail);

        sdhomePage.signInToApp(newEmail, providerEmailPassword);
        sdhomePage.clickAnyTitleByText(enrollmentType, Data.h2);

        //Identifying Information
        enrollmentPageProvider.fillInIndividualIdentifyingInformation(firstName, lastName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                Data.ssn, Data.profitStatusNonProfit, enrollmentType);

        // Address
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);

        //Provider  Agreement
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary
        enrollmentPageProvider.summarySectionProceedToSignIn();

        //HelloSign
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingId =enrollmentPageProvider.getProviderTrackingNumber();

        enrollmentPageInternalUser.logOut();

    /*Internal user operations:
     Search provider by first name
     Timer waits required status and click "Search" button with specific delay 10 times
     Verify that enrollment application has status "DOCUMENT REVIEW"
     Approve it
     Search provider by first name
     Timer waits required status and click "Search" button with specific delay 10 times
     Verify that enrollment application has status "UNDER SCREENING"
      Take request id
     Edit screening.xml and request id,
     Get cookies of internal user
    Send 1 API screening call with new request id
    Timer waits required status and click "Search" button with specific delay 10 times
    Verify that user Pending Approval
    Approve or Deny application
    If test has "Offline" option, click "Verify payment" and approve it
    Verify that application has status "APPROVED"
    Save first name, last, name, email and NPI to data file for next test cases
    */

        sdhomePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //PENDING APPROVAL
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName,lastName,"PENDING APPROVAL",trackingId);
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }
        enrollmentPageInternalUser.logOut();

        String newEnrollmentType = enrollmentType.split("\\s")[0];
        dataFiles.save("First_Name", firstName, newEnrollmentType + indexEnrollment, statusOfApplication);
        dataFiles.save("Email", newEmail, newEnrollmentType + indexEnrollment, statusOfApplication);
        dataFiles.save("Last_Name", lastName, newEnrollmentType + indexEnrollment, statusOfApplication);
    }


    @Test(dependsOnMethods = "registerAnyTypeOfEnrollment")
    public void newEnrollmentsPEMAffiliation() {
        // IndividualEnrollment individualEnrollment = new IndividualEnrollment();
        String firstName = sdhomePage.generateFirstName();
        String lastName = sdhomePage.generateLastName();
        String npi = sdhomePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = sdhomePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);

        String taxonomyCategory = Data.specialityInterpreter;
        String taxonomy = Data.interpreterTaxonomy;
        String newEmail = sdhomePage.generateEmail(providerEmailPrefix, "gmail.com");
        String enrollmentType = "Individual enrollment";
        String paymentOption = "Offline";
        String medicareParticipant = "No";
        String enrollmentFee;
        String statusOfApplication = "Approved";
        int indexEnrollment = 1;

        sdhomePage.javaWaitSec(10);
        sdhomePage.signInToApp(providerEmail, providerEmailPassword);
        sdhomePage.javaWaitSec(3);
        sdhomePage.clickAddEnrollProviderButton();
        sdhomePage.javaWaitSec(3);
        sdhomePage.clickAnyTitleByText(enrollmentType, Data.h2);
        sdhomePage.enterProviderInformationPopUp(newEmail, firstName, lastName);
        sdhomePage.javaWaitSec(10);

        //Identifying Information
        Reports.log("Open Section: Identifying Information");
        enrollmentPageProvider.fillInIndividualIdentifyingInformation(
                firstName, lastName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                Data.ssn, Data.profitStatusNonProfit, enrollmentType);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail Section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, sdhomePage.generateNewNumber(10), newEmail);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode, Data.inState);

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();


        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Payment Section
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstName, lastName);
        String trackingId = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageProvider.ajaxClick(driver.findElement(Locators.BACKTOPORTAL_BUTTON));
        enrollmentPageInternalUser.logOut();


    /*Internal user operations:
     Search provider by first name
     Timer waits required status and click "Search" button with specific delay 10 times
     Verify that enrollment application has status "DOCUMENT REVIEW"
     Approve it
     Search provider by first name
     Timer waits required status and click "Search" button with specific delay 10 times
     Verify that enrollment application has status "UNDER SCREENING"
      Take request id
     Edit screening.xml and request id,
     Get cookies of internal user
    Send 1 API screening call with new request id
    Timer waits required status and click "Search" button with specific delay 10 times
    Verify that user Pending Approval
    Approve or Deny application
    If test has "Offline" option, click "Verify payment" and approve it
    Verify that application has status "APPROVED"
    Save first name, last, name, email and NPI to data file for next test cases
    */

        sdhomePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstName, lastName, trackingId);

        //UNDER SCREENING
       // enrollmentPageInternalUser.enrollmentUnderScreen(testEnv,environmentUrl, firstName, lastName, trackingId,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstName, lastName, "PENDING REVIEW", trackingId);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName, lastName);
        }

        //PENDING APPROVAL
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }
        enrollmentPageInternalUser.getApplicationStatus();
        enrollmentPageInternalUser.logOut();
    }
}
