package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment.AddEnrollmentAffiliation;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.*;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(VideoListener.class)
/**
 * This class contains a test which uses a data provider to get an approved PEM and submits and approves a Pharmacy enrollment.
 */
public class PemSubmitAndApprovePharmacyEnrollmentTest extends BaseClassUI {
    String zipCode;
    String statusOfApplication ;

    /**
     * This method calls a dataProvider to get an approved PEM provider and logs in.Then clicks on enroll provider button and clicks on the Pharmacy enrollment and
     * fills all the fields in enrollment section and submits the enrollment then logs in as an internal user to approve the enrollment.
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider="getPEMProviderNameEmailWithStatusApproved"  ,
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"ApprovePemEnrollment"})
    public void pemSubmitAndApprovePharmacy(String testEnvironment, String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        String firstNamePharmacy = HomePage.generateFirstName();
        Reports.log("Provider first name: " + firstNamePharmacy);
        String lastNamePharmacy = HomePage.generateLastName();
        Reports.log("Provider last name: "+ lastNamePharmacy);
        String newEmailPharmacy = HomePage.generateEmail(providerEmailPrefix, "gmail.com");
        Reports.log("Provider email address: "+ newEmailPharmacy);
        String npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);
        statusOfApplication = Data.ApplicationStatusApprove;

        String taxonomyCategory = Data.pharmacyType;
        String taxonomy = Data.primaryTaxonomyCode;
        String enrollmentType = Data.pharmacyAffApplication;
        String paymentOption = "Offline";
        String medicareParticipant = "No";

        homePage.signInToApp(emailID, providerEmailPassword);
        homePage.javaWaitSec(3);
        homePage.clickAddEnrollProviderButton();
        homePage.javaWaitSec(3);
        homePage.clickAnyTitleByText(Data.pharmacyAffApplication, Data.h2);
        homePage.enterProviderInformationPopUp(newEmailPharmacy, firstNamePharmacy, lastNamePharmacy);
        homePage.javaWaitSec(10);
        driver.navigate().refresh();

        //Identifying Information
        Reports.log("Open Section: Identifying Information");
        enrollmentPageProvider.fillInIdentifyingInformation(firstNamePharmacy, lastNamePharmacy, Data.fein, newEmailPharmacy, enrollmentType, Data.profitStatusNonProfit);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, Data.pharmacyApplication, taxonomyCategory);

        //Address
        enrollmentPageProvider.fillInIndividualAddressDetails(Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        //mailingAddress
        enrollmentPageProvider.mailingAddressContactPerson(firstNamePharmacy, lastNamePharmacy, homePage.generateNewNumber(10), newEmailPharmacy);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, Data.pharmacyApplication);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstNamePharmacy, lastNamePharmacy, newEmailPharmacy, zipCode, Data.inState);

        //Key Personnel Section
        enrollmentsAndCoc.fillInKeyPersonalSection();

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(Data.pharmacyApplication);

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstNamePharmacy);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstNamePharmacy, lastNamePharmacy);
        // enrollmentPageProvider.scrollToBottomOfPage();

        //Payment Section
        enrollmentPageProvider.fillInPaymentSection(Data.pharmacyApplication, paymentOption);

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();

        //HelloSignIn
        enrollmentPageProvider.signInHelloSign(firstNamePharmacy, lastNamePharmacy);
        String trackingNumber = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageProvider.ajaxClick(driver.findElement(Locators.BACKTOPORTAL_BUTTON));
        enrollmentPageInternalUser.logOut();

        //Internal user approve a Group which enrolled by a PEM
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstNamePharmacy, lastNamePharmacy,trackingNumber);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstNamePharmacy,lastNamePharmacy,trackingNumber,Data.pendingReviewStatus);

        //Adding Pending Review Flow Per Configuration
        //enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstNamePharmacy, lastNamePharmacy, "PENDING REVIEW",trackingNumber);
        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("PENDING APPROVAL")) {

            //Fingerprinting Workflow
            enrollmentPageProvider.VerifyFingerPrintButton(firstNamePharmacy, lastNamePharmacy);

            //Verify Site Visit Button Available
            enrollmentPageProvider.createSiteVisitButtonVerification("Create Site Visit", taxonomy);

            //Pending Review Workflow
            enrollmentPageInternalUser.reviewAndVoteTheEnrollment(firstNamePharmacy, lastNamePharmacy);
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
    }}
