package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment.AddEnrollmentAffiliation;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.*;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)
/**
 * This class contains a test which uses a data provider to get an approved PEM and submits and approves a Facility enrollment.
 */
public class PemSubmitAndApproveFacilityEnrollmentTest extends BaseClassUI {
    String zipCode;
    String statusOfApplication;

    /**
     * This method calls a dataProvider to get an approved PEM provider and logs in. Then clicks on enroll provider button and
     * clicks on the Facility enrollment and fills all the fields in the enrollment section and submits the enrollment
     * then logins in as an internal user to approve the enrollment.
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusApproved",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"ApprovePemEnrollment"})
    public void pemSubmitAndApproveFacility(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        String firstNameFacility = HomePage.generateFirstName();
        Reports.log("Provider first name: " +firstNameFacility);
        String lastNameFacility = HomePage.generateLastName();
        Reports.log("Provider last name: "+ lastNameFacility);
        String newEmailFacility = HomePage.generateEmail(providerEmailPrefix, "gmail.com");
        Reports.log("Provider email address: "+ newEmailFacility);
        String npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);
        statusOfApplication = Data.ApplicationStatusApprove;

        String taxonomyCategory = Data.specialityHomeHealth;
        String taxonomy = Data.HomeHealthRequiredPaymentTaxonomy;
        String enrollmentType = Data.facilityAffApplication;
        String paymentOption = "Offline";
        String medicareParticipant = "No";

        homePage.signInToApp(emailID, providerEmailPassword);
        homePage.javaWaitSec(3);
        homePage.clickAddEnrollProviderButton();
        homePage.javaWaitSec(3);
        homePage.clickAnyTitleByText(Data.facilityAffApplication, Data.h2);
        homePage.enterProviderInformationPopUp(newEmailFacility, firstNameFacility, lastNameFacility);
        homePage.javaWaitSec(10);
        driver.navigate().refresh();
        //Identifying Information
        enrollmentPageProvider.fillInIdentifyingInformation(firstNameFacility, lastNameFacility, Data.fein, newEmailFacility, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail Section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        enrollmentPageProvider.mailingAddressContactPerson(firstNameFacility, lastNameFacility, homePage.generateNewNumber(10), newEmailFacility);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstNameFacility, lastNameFacility, newEmailFacility, zipCode, Data.inState);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstNameFacility);

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstNameFacility, lastNameFacility);
        if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
            //Payment Section
            enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);
        }
        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        //Hello Sign
        enrollmentPageProvider.signInHelloSign(firstNameFacility, lastNameFacility);
        String trackingNumber = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageProvider.ajaxClick(driver.findElement(Locators.BACKTOPORTAL_BUTTON));
        enrollmentPageInternalUser.logOut();

        //Internal user approve a Facility which enrolled by a PEM

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstNameFacility,lastNameFacility, trackingNumber);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstNameFacility,lastNameFacility,trackingNumber,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstNameFacility,lastNameFacility,"PENDING REVIEW",trackingNumber);;
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstNameFacility, lastNameFacility);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerificationForHighRiskTaxonomy("Create Site Visit", taxonomy, firstNameFacility, lastNameFacility);
            enrollmentPageInternalUser.navigateBackToEnrollment(firstNameFacility,lastNameFacility, trackingNumber);

            //Pending Review Workflow
            //review and vote for this request
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstNameFacility,lastNameFacility);

            //Pending Approval
            //Verify Payment
            if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
                if (taxonomy.contains(Data.nursingRequiredPaymentTaxonomy) || taxonomy.contains(Data.HomeHealthRequiredPaymentTaxonomy)) {
                    enrollmentPageInternalUser.verifyPaymentForFacility(firstNameFacility,lastNameFacility);
                }
                enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
            }
            enrollmentPageInternalUser.logOut();
    }
}}

