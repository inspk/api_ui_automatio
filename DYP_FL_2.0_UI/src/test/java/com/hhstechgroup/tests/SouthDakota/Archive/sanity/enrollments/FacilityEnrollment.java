package com.hhstechgroup.tests.SouthDakota.Archive.sanity.enrollments;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.*;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class FacilityEnrollment extends BaseClassUI {
    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;


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
                        HomePage.generateFirstName(), HomePage.generateLastName(), "Approved",
                        "Offline", 1, "No",
                        //Data.specialityHomeHealth,Data.HomeHealthRequiredPaymentTaxonomy,
                        "Audiology", "332S00000X"},

        };
    }
//Audiology

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
    public void registerAndSubmitFacilityEnrollment (String testEnvironment,String testEmailAccount, String enrollmentType,
                                                     String newEmail,String firstName, String lastName,
                                                     String statusOfApplication, String paymentOption,  int indexEnrollment,
                                                     String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {

         /*
         Provider operations:
         Fill in required sections and fields
         Can switch Offline and Online payments
         Can select Approve and Deny
         Select index of internal user for next test cases: Coc, Appeals and Group Affiliation
          */

        //Gmail Delete
        Reports.log("Log-in to Gmail and Delete existing email from e-mail box.");
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        npi = sdhomePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);


        driver.get(environmentUrl);
        Reports.log("Go to Environment and Start Registration of Provider");
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

        //Start Enrollment Application
        loginPage.signInToApp(newEmail, providerEmailPassword);

       // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Click on Facility Enrollment
        dashboardPage.clickOnEnrollmentType(enrollmentType);

//        //Identifying Information
//        enrollmentPageProvider.fillInIdentifyingInformation(firstName, lastName, Data.fein, newEmail, enrollmentType, Data.profitStatusNonProfit);
//
//        //Provider Identifier
//        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);
//
//        //Address Detail Section
//        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
//        enrollmentPageProvider.mailingAddressContactPerson(firstName, lastName, sdhomePage.generateNewNumber(10), newEmail);
//
//        //Primary Service Location Section
//        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstName, lastName, newEmail, zipCode,Data.inState);
//
//        //Taxonomy/ License Information Section
//        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);
//
//        //Exclusion and Sanction Section
//        enrollmentsAndCoc.fillInExclusionAndSanctionSection();
//
//        //Authorized Signature Section
//        enrollmentPageProvider.fillAuthorizedSignaturSection(firstName);
//
//        //Upload Document Section
//        enrollmentPageProvider.uploadDocumentSection(enrollmentType);
//
//        //Provider Agreement Section
//        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstName, lastName);
////        if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
////            //Payment Section
////            enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);
////        }
//
//        //Payment Section
//        // enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);
//
//        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption, newEmail, zipCode,Data.phone);
//
//
//        //Summary Section
//        enrollmentPageProvider.summarySectionProceedToSignIn();
//        //Hello Sign
//        enrollmentPageProvider.signInHelloSign(firstName, lastName);
//        String trackingId =enrollmentPageProvider.getProviderTrackingNumber();
//        enrollmentPageInternalUser.logOut();
//
//    /*Internal user operations:
//     Search provider by first name
//     Timer waits required status and click "Search" button with specific delay 10 times
//     Verify that enrollment application has status "DOCUMENT REVIEW"
//     Approve it
//     Search provider by first name
//     Timer waits required status and click "Search" button with specific delay 10 times
//     Verify that enrollment application has status "UNDER SCREENING"
//      Take request id
//     Edit screening.xml and request id,
//     Get cookies of internal user
//    Send 1 API screening call with new request id
//    Timer waits required status and click "Search" button with specific delay 10 times
//    Verify that user Pending Approval
//    Approve or Deny application
//    If test has "Offline" option, click "Verify payment" and approve it
//    Verify that application has status "APPROVED"
//    Save first name, last, name, email and NPI to data file for next test cases
//    */
//        sdhomePage.signInToApp(internalUserEmail, internalUserPassword);
//        enrollmentPageInternalUser.clickEnrollTab();
//
//        //DOCUMENT REVIEW
//        enrollmentPageInternalUser.documentReview(firstName,lastName,trackingId);
//
//        //UNDER SCREENING
//        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstName,lastName,trackingId,"PENDING APPROVAL");
//
//        //Adding Pending Review Flow Per Configuration
//        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
//
//            //Fingerprinting Workflow
//            enrollmentPageProvider.VerifyFingerPrintButton(firstName, lastName);
//
//            //Verify Site Visit Button Available
//            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstName, lastName);
//            enrollmentPageInternalUser.navigateBackToEnrollment(firstName,lastName,trackingId);
//
//            //Pending Review Workflow
//            //review and vote for this request
//            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstName,lastName);
//
//            //Pending Approval
//            //Verify Payment
//            if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
//                if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
//                    enrollmentPageInternalUser.verifyPaymentForFacility(firstName,lastName);
//                }
//                enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
//            }
//            enrollmentPageInternalUser.logOut();
//            String newEnrollmentType = enrollmentType.split("\\s")[0];
//            dataFiles.save("First_Name", firstName, newEnrollmentType + indexEnrollment, statusOfApplication);
//            dataFiles.save("Email", newEmail, newEnrollmentType + indexEnrollment, statusOfApplication);
//            dataFiles.save("Last_Name", lastName, newEnrollmentType + indexEnrollment, statusOfApplication);
//            if (!enrollmentType.contains(Data.pemApplication)) {
//                dataFiles.save("NPI", npi, newEnrollmentType + indexEnrollment, statusOfApplication);
//            }
//        }
    }
}