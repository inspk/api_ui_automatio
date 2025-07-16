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
 * This class contains a test which uses a data provider to get an approved PEM and submits and approves an ORP enrollment.
 */
public class PemSubmitAndApproveORPEnrollmentTest extends BaseClassUI {
    String zipCode;
    String statusOfApplication ;

    /**
     * This method calls a dataProvider to get an approved PEM provider and logs in. Then clicks on enroll provider button and clicks on the ORP enrollment and
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
    public void pemSubmitAndApproveOrp(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {
        String firstNameORP = HomePage.generateFirstName();
        String lastNameORP = HomePage.generateLastName();
        String newEmailORP = HomePage.generateEmail(providerEmailPrefix, "gmail.com");
        String npi = homePage.getRandomStringFromFile("WyNPI");
        Reports.log("New NPI: " + npi);
        zipCode = homePage.getRandomStringFromFile("WyZip");
        Reports.log("New Zip: " + zipCode);
        statusOfApplication = Data.ApplicationStatusApprove;

        String taxonomyCategory = Data.specialityAudiology;
        String taxonomy = "231H00000X";
        String enrollmentType = Data.orpAffApplication;
        String paymentOption = "Offline";
        String medicareParticipant = "No";

        homePage.signInToApp(emailID, providerEmailPassword);
        homePage.javaWaitSec(3);
        homePage.clickAddEnrollProviderButton();
        homePage.javaWaitSec(3);
        homePage.clickAnyTitleByText(Data.orpAffApplication, Data.h2);
        homePage.enterProviderInformationPopUp(newEmailORP, firstNameORP, lastNameORP);
        homePage.javaWaitSec(10);
        driver.navigate().refresh();
        //Identifying Information
        enrollmentPageProvider.fillInIndividualIdentifyingInformation(
                firstNameORP, lastNameORP, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmailORP,
                Data.ssn, Data.profitStatusNonProfit,Data.orpApplication);

        //Provider Identifier Section
        enrollmentPageProvider.fillInProviderIdentifiersSection(medicareParticipant, npi, enrollmentType, taxonomyCategory);

        //Address Detail Section
        enrollmentPageProvider.fillInAddressInformation(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeWY);
        enrollmentPageProvider.mailingAddressContactPerson(firstNameORP, lastNameORP, homePage.generateNewNumber(10), newEmailORP);

        //Taxonomy/ License Information Section
        enrollmentsAndCoc.fillTaxonomyAndLicenseInformationSection(taxonomyCategory, taxonomy, enrollmentType);

        //Primary Service Location Section
        enrollmentPageProvider.fillInPrimaryServiceLocationSection(enrollmentType, firstNameORP, lastNameORP, newEmailORP, zipCode,Data.inState);

        //Exclusion and Sanction Section
        enrollmentsAndCoc.fillInExclusionAndSanctionSection();

        //Authorized Signature Section
        enrollmentPageProvider.fillAuthorizedSignaturSection(firstNameORP);

        //Upload Document Section
        enrollmentPageProvider.uploadDocumentSection(enrollmentType);

        //Provider Agreement Section
        enrollmentPageProvider.signInProviderAgreementForm(enrollmentType, firstNameORP, lastNameORP);

        //Payment Section
        enrollmentPageProvider.fillInPaymentSection(enrollmentType, paymentOption);

        //Summary Section
        enrollmentPageProvider.summarySectionProceedToSignIn();
        enrollmentPageProvider.signInHelloSign(firstNameORP, lastNameORP);
        String trackingNumber = enrollmentPageProvider.getProviderTrackingNumber();
        enrollmentPageProvider.ajaxClick(driver.findElement(Locators.BACKTOPORTAL_BUTTON));
        enrollmentPageInternalUser.logOut();

        //Internal user approve an ORP which enrolled by a PEM

        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickEnrollTab();

        //DOCUMENT REVIEW
        enrollmentPageInternalUser.documentReview(firstNameORP,lastNameORP,trackingNumber);

        //UNDER SCREENING
        enrollmentPageInternalUser.enrollmentUnderScreen(testEnvironment,environmentUrl,firstNameORP,lastNameORP,trackingNumber,Data.statusPendingApproval);

        //PENDING APPROVAL
       // enrollmentPageInternalUser.pendingReviewFlowConfigaration(firstNameORP,lastNameORP,"PENDING APPROVAL",trackingNumber);

        if (!driver.findElement(Locators.STATUS_ENROLLMENT_DETAILS).getText().contains("APPROVED")) {
            enrollmentPageInternalUser.changeStatusOfEnrollment(statusOfApplication);
        }
        enrollmentPageInternalUser.logOut();
    }}
