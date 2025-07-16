package com.hhstechgroup.tests.SouthDakota.Regression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class MCOProviderTest extends BaseClassUI {
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
                {testEnvironment,testEmailAccount,Data.MCOApplication,
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
    @Test(dataProvider = "Enrollment type", groups =  {"RegisterAndSubmitMCOProvider"})
    public void enrollMCOProvider(String testEnvironment, String testEmailAccount,String enrollmentType,
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
        String entityProviderNPI = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_APPROVED_UPPERCASE).get("ProviderNPI");
        String entityProviderEmailID = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_APPROVED_UPPERCASE).get("ProviderEmailId");
        System.out.println("Entity Provider EmailId is: " + entityProviderEmailID + " NPI: " + entityProviderNPI);


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
        dashboardPage.clickOnEnrollmentType(Data.MCOApplication);

        // Fill identifying information
        providerEnrollingPage.fillInMCOIdentifyingInformation(firstName, lastName,newEmail,applicationContactNo);

        // Fill taxonomy information
        IUMCOPage.fillInTaxonomyForMCO(enrollmentType, Data.PHYSICAL_THERAPIST_SPECIALITY,
                Data.LICENSE_FOR_PHYSICAL_THERAPIST_SPECIALITY);


        // Fill service location section
        IUMCOPage.fillInServiceLocationSection(enrollmentType, newEmail, zipCode,
                Data.TAXONOMY_PHYSICAL_THERAPIST, Data.PHYSICAL_THERAPIST_SPECIALITY);


        // Fill address information
        IUMCOPage.fillInAddressInformationForMCO(enrollmentType, Data.physicalAddress, Data.city,
                Data.mailingState, zipCode, Data.countyCodeSD, newEmail);


        // Fill ownership section
        IUMCOPage.fillInOwnershipMCO();


        // Fill key personnel section (assuming this method exists in IUMCOPage)
        IUMCOPage.fillInKeyPersonalSectionForMCO(0, Data.genderMale, Data.physicalAddress, Data.city,
                Data.mailingState, zipCode, Data.countyCodeSD, enrollmentType, npi);


        // Fill exclusion and sanction section (assuming this method exists in IUMCOPage)
        providerEnrollingPage.fillInExclusionAndSanctionSection();


        // Complete summary section
        providerEnrollingPage.summarySection(firstName, lastName);
//        dashboardPage.HelloSign(firstName, lastName);

        trackingNum = dashboardPage.getProviderTrackingNumber();
        dashboardPage.logOut();

        excel.writeTestData(testEnvironment,enrollmentType,firstName, lastName, newEmail, providerEmailPassword,"",npi, Data.APPLICATION_STATUS_SUBMITTED,trackingNum);
        Data.givenproviderEmail= newEmail;
        Data.providerNPI= npi;

        Data.ProviderID= trackingNum;
        Reports.log("Verification email is :"+newEmail);
        Reports.log("Verification NPI is :"+npi);
        excel.readExcel();
    }

}
