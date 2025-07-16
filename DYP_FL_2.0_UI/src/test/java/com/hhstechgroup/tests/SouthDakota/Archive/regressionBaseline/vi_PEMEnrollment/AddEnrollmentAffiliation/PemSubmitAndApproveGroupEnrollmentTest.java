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
 *This class contains a test which uses a data provider to get an approved PEM and submits and approves a Group enrollment.
 */
public class PemSubmitAndApproveGroupEnrollmentTest extends BaseClassUI {
    String zipCode;
    String statusOfApplication ;

    /**
     * This method calls a dataProvider to get an approved PEM provider. Then clicks on enroll provider button and clicks on the Group enrollment and fills all
     * the fields in enrollment section and submits the enrollment then logins in as internal user to approve the enrollment.
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPEMProviderNameEmailWithStatusApproved"  ,
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"ApprovePemEnrollment"})
    public void pemSubmitAndApproveGroup(String testEnvironment, String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        String firstNameGroup = HomePage.generateFirstName();
        Reports.log("Provider first name: " + firstNameGroup);
        String lastNameGroup = HomePage.generateLastName();
        Reports.log("Provider last name: "+ lastNameGroup);
        String newEmailGroup= HomePage.generateEmail(providerEmailPrefix, "gmail.com");
        Reports.log("Provider email address: "+ newEmailGroup);
        String npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);
        statusOfApplication = Data.ApplicationStatusApprove;

        String taxonomyCategory = Data.specialityInterpreter;
        String taxonomy = Data.interpreterTaxonomy;
        String enrollmentType = Data.groupAffApplication;
        String paymentOption = "Offline";
        String medicareParticipant = "No";

        homePage.signInToApp(emailID,providerEmailPassword );
        homePage.javaWaitSec(3);
        homePage.clickAddEnrollProviderButton();
        homePage.javaWaitSec(3);
        homePage.clickAnyTitleByText(Data.groupAffApplication, Data.h2);
        homePage.enterProviderInformationPopUp(newEmailGroup, firstNameGroup, lastNameGroup);
        homePage.javaWaitSec(10);
        driver.navigate().refresh();

        //Identifying Information
        enrollmentPageProvider.fillInIdentifyingInformation(firstNameGroup, lastNameGroup, Data.fein,newEmailGroup, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail Section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        enrollmentPageProvider.mailingAddressContactPerson(firstNameGroup, lastNameGroup, homePage.generateNewNumber(10), newEmailGroup);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstNameGroup, lastNameGroup, newEmailGroup, zipCode,Data.inState);
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstNameGroup);

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstNameGroup, lastNameGroup);

        //Payment Section
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);
        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstNameGroup, lastNameGroup);
        String trackingNumber = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageProvider.ajaxClick(driver.findElement(Locators.BACKTOPORTAL_BUTTON));
        enrollmentPageInternalUser.logOut();

        //Internal user approve a Group which enrolled by a PEM

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstNameGroup,lastNameGroup,trackingNumber);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstNameGroup,lastNameGroup,trackingNumber,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstNameGroup,lastNameGroup,"PENDING REVIEW",trackingNumber);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {
            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstNameGroup, lastNameGroup);

            //Verify Payment Workflow
            enrollmentPageProvider.VerifyPaymentButton(firstNameGroup, lastNameGroup);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit", taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstNameGroup, lastNameGroup);
        }

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.javaWaitSec(3);
            //Verify Payment Workflow
            enrollmentPageProvider.VerifyPaymentButton(firstNameGroup, lastNameGroup);
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }
        enrollmentPageInternalUser.logOut();
    }
}