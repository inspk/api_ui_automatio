package com.hhstechgroup.tests.SouthDakota.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.Helper;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class IndividualEnrollmentAsServicingProviderTest extends BaseClassUI {

    DataFiles dataFiles = new DataFiles();
    String testEmailAccount;
    String npi;
    String zipCode;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String trackingNum;

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
                {testEnvironment, testEmailAccount, Data.SERVICING_PROVIDER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.middleName, "Offline",
                        "No", Data.specialityInterpreter, Data.interpreterTaxonomy},
        };
    }

    /**
     * This test method deletes existing test emails, registers a new Provider, confirms the registration email, logs
     * into DyP as the registered provider, creates and submits a Individual  enrollment as  Billing Provider, logs out as the registered
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
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Enrollment type", groups = {"RegisterAndSubmitIndividualEnrollmentAsServicingProvider"}
//            , dependsOnGroups = "ApproveEntityEnrollmentApplication"
    )
    public void enrollIndividualAsServicingProvider(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                  String newEmail, String firstName, String lastName, String middleName, String paymentOption,
                                                  String medicareParticipant, String taxonomyCategory, String taxonomy) throws Exception {

        //Gmail Delete
        email.deleteTestAccountEmails(testEmailAccount);

        //Registration
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        Reports.log("New NPI: " + npi);
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        Reports.log("New Zip: " + zipCode);
        String ssnNum = sdhomePage.generateANumberOfLength(10);
        Reports.log("SSN Number: " + ssnNum);
        String applicationContactNo=sdhomePage.generateANumberOfLength(10);
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

        //Confirm Email
        email.openGmailAndClickConformAccountLink(newEmail);

        //Login Application with newly Registered provider
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //Starting Individual Enrollment Process
        dashboardPage.clickOnEnrollmentType(Data.individualApplication);


        //Identifying Information
        //  providerEnrollingPage.fillInMedicaidPaymentIdentifyingInformation("No");
        providerEnrollingPage.fillInIndividualIdentifyingInformation(
                firstName, lastName, middleName, Data.genderMale, Data.dob, Data.countryOfBirth, Data.stateOfBirth, newEmail,
                ssnNum,applicationContactNo, Data.profitStatusNonProfit, enrollmentType, Data.medicaidPaymentNo, Helper.getCurrentDatestamp());

        //Provider Identifier Section
//        providerEnrollingPage.fillInIndividualProviderIdentifiersSection(Data.medicaidPaymentNo,medicareParticipant, npi, enrollmentType);
        providerEnrollingPage.flFillInIndividualProviderIdentifierSection(npi);

        //Ownership
        providerEnrollingPage.fillInOwnershipSectionForServiceProvider();

        providerEnrollingPage.fillInExclusionAndSanctionSection();

        providerEnrollingPage.fillInProgramParticipation(enrollmentType,Data.INDV_MEDICAID_CHIP, Data.THERAPY, Data.TAXONOMY_PHYSICAL_THERAPIST,Data.LICENSE_PHYSICAL_THERAPY_PT, firstName, lastName);

        // TO DO: AFFLICTION SECTION
        providerEnrollingPage.fillInAffiliationSection(entityProviderNPI, Data.AFFILIATION_TYPE_IND_TO_GRP) ;

        //PCP Addendum Section
        providerEnrollingPage.fillInPCPAddendumSection(firstName,lastName);

        //Provider Agreement Section
        providerEnrollingPage.signInProviderAgreementFormSD(enrollmentType, firstName, lastName);

        //Summary Section
        providerEnrollingPage.summarySectionProceedToSignIn(firstName, lastName);
//        dashboardPage.signInHelloSign(firstName, lastName);
//
//        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        loginPage.signInToApp("dyp.provider+goldberg@gmail.com", providerEmailPassword);
        landingPage.confirmAgreeAndSecureMessages();
        providerEnrollingPage.navigateAndOpenToMessageCenter();
        dashboardPage.signInHelloSign(enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_FIRST_NAME) + " " + enrollmentFormElements.formElements().get(Data.ENTITY_PROVIDER_LAST_NAME), "");

        dashboardPage.logOut();
        loginPage.signInToApp(newEmail, providerEmailPassword);

        // confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.signInHelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment, enrollmentType, firstName, lastName, newEmail, providerEmailPassword, taxonomy, npi, Data.APPLICATION_STATUS_SUBMITTED, trackingNum);
        excel.readExcel();
    }
}


