package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class IndividualEnrollmentProviderSubmissionTest extends BaseClassUI {
    String testEmailAccount;
    String npi;
    String zipCode;
    String ssnNum ;
    ExcelWrite excel = new ExcelWrite( providerInfoSheet,0);
    String trackingNum;
    String medicaidPaymentValue = "Yes" ;


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
                {testEnvironment,testEmailAccount,Data.BILLING_PROVIDER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.middleName, "Offline",
                        "No", Data.specialityInterpreter, Data.interpreterTaxonomy},
        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits an Individual  enrollment as  Billing Provider, logs out as the registered
     * Provider and writes the enrollment information to ProviderInfo.xlsx.
     *
     * @param testEnvironment
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
    @Test(dataProvider = "Enrollment type", groups =  {"RegisterAndSubmitIndividualBillingProvider"})
    public void enrollIndividualAsBillingProvider(String testEnvironment, String testEmailAccount,String enrollmentType,
                                                  String newEmail, String firstName, String lastName, String middleName, String paymentOption,
                                                  String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {
        //Gmail Delete
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        Reports.log("New NPI: " + npi);
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        Reports.log("New Zip: " + zipCode);
        ssnNum = sdhomePage.generateANumberOfLength(10);
        Reports.log("SSN Number: " + ssnNum);
        String applicationContactNo = sdhomePage.generateANumberOfLength(10);
        Reports.log("Application Contact Number: " + applicationContactNo);
        String entityProviderNPI = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_APPROVED_UPPERCASE).get("ProviderNPI");
        String entityProviderEmailID = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_APPROVED_UPPERCASE).get("ProviderEmailId");
        System.out.println("Entity Provider EmailId is: "+entityProviderEmailID +" NPI: "+entityProviderNPI);


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

//        //Confirm Email
        email.openGmailAndClickConformAccountLink(newEmail);

        //Login Application with newly Registered provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Starting Individual Enrollment Process
        dashboardPage.clickOnEnrollmentType(Data.individualApplication);

        //Identifying Information and Provider Identifier Section for Individual Enrollment
        providerEnrollingPage.fillInIndividualIdentifyingInformation(
                firstName, lastName, middleName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                ssnNum, applicationContactNo,Data.profitStatusNonProfit, enrollmentType,medicaidPaymentValue, Helper.getCurrentDatestamp());

        //Program Participation Section
        providerEnrollingPage.fillInTaxonomyForIndividual(enrollmentType,Data.PHYSICAL_THERAPIST_SPECIALITY,Data.LICENSE_FOR_PHYSICAL_THERAPIST_SPECIALITY );
        //Provider Identifier Section
//        providerEnrollingPage.fillInIndividualProviderIdentifiersSection(medicaidPaymentValue, medicareParticipant, npi, enrollmentType);
        providerEnrollingPage.flFillInIndividualProviderIdentifierSection(npi);

        providerEnrollingPage.fillInOtherCredentialingInfo(Data.ORGANIZATIONAME, Data.PROFFESIONALSCHOOLNAME, Data.physicalAddress, Data.proffesionalschoolcity, Data.city, Data.state);

//Employment Authorization Information
        providerEnrollingPage.EmploymentAuthorizationInformation(enrollmentType);

        //Professional Liability Insurance Information
        providerEnrollingPage.flFillInIndividualProfessionalLiabilityInsuranceInformationSection();

        //Address Detail Section
        providerEnrollingPage.fillInAddressInformationForIndividual(enrollmentType, Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD,newEmail);

        // Service Location Section
        providerEnrollingPage.fillInServiceLocationSection(enrollmentType, newEmail, zipCode, Data.TAXONOMY_PHYSICAL_THERAPIST, Data.PHYSICAL_THERAPIST_SPECIALITY);

        // TO DO: AFFLICTION SECTION
//        providerEnrollingPage.fillInAffiliationSection(entityProviderNPI, Data.AFFILIATION_TYPE_IND_TO_GRP) ;

        //Ownership Section
        providerEnrollingPage.fillInOwnershipSection(enrollmentType);

        //Key Personnel
        providerEnrollingPage.fillInKeyPersonalSectionForIndividual(0, Data.genderMale,Data.physicalAddress, Data.city, Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType,npi);

        //Exclusion and Sanction Section
        providerEnrollingPage.fillInExclusionAndSanctionSection();

        //EFT Information Section
//        providerEnrollingPage.fillInEFTInformationSectionForIndividual(Data.INDIVIDUAL_PROVIDER,firstName);

        //Upload Document Section
//        providerEnrollingPage.uploadDocumentSectionSD(enrollmentType, "No");

        providerEnrollingPage.fillInAuthorizedSignature();

        //Provider Agreement Section
//        providerEnrollingPage.signInProviderAgreementForm(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySection(firstName, lastName);
//        dashboardPage.logOut();
//
//        loginPage.signInToApp("johny.providers+71309@gmail.com", providerEmailPassword);
//        landingPage.confirmAgreeAndSecureMessages();
//        providerEnrollingPage.navigateAndOpenToMessageCenter();
//        dashboardPage.ProccedToSignHelloSign(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_FIRST_NAME) + " " + enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_LAST_NAME), "");
//        dashboardPage.logOut();
//
//
//        //Login Application with newly Registered provider
//        loginPage.signInToApp(newEmail, providerEmailPassword);
//
//        // confirmAgreeAndSecureMessages();
//        landingPage.confirmAgreeAndSecureMessages();
//        dashboardPage.ProccedToSignHelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();


        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,taxonomy,npi,Data.APPLICATION_STATUS_SUBMITTED,trackingNum);
        Data.givenproviderEmail= newEmail;
        Data.providerNPI= npi;
        Data.ProviderID= trackingNum;
        Reports.log("Verification email is :"+newEmail);
        Reports.log("Verification NPI is :"+npi);



        excel.readExcel();
    }
}
