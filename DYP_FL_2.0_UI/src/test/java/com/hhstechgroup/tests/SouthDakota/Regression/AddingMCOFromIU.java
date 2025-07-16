package com.hhstechgroup.tests.SouthDakota.Regression;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hhstechgroup.common.Data.applicationContactNo;


@Listeners(VideoListener.class)
public class AddingMCOFromIU extends BaseClassUI {
    String npi;
    String zipCode;
    String firstName;
    String lastName;


    /**
     * This test method returns a DataProvider containing test parameters
     *
     * @param context
     * @return Data object
     */
    @DataProvider(name = "MCO Data")
    public Object[][] testData(ITestContext context) {
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");
        return new Object[][]{
                {testEnvironment, Data.ENTITY_PROVIDER,
                        HomePage.generateEmail("mco", "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName()},
        };
    }


    /**
     * This test method signs in as an internal user and adds a new MCO
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param newEmail
     * @param firstName
     * @param lastName
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "MCO Data", groups = {"AddMCO"})
    public void AddingMCO(String testEnvironment, String enrollmentType, String newEmail,
                          String firstName, String lastName) throws Exception {


        // Generate test data
        zipCode = sdhomePage.getRandomStringFromFile("SDZip");
        Reports.log("New Zip: " + zipCode);
        npi = sdhomePage.getRandomStringFromFile("SDNPI");
        Reports.log("New NPI: " + npi);


        // Sign in to the application using internal user credentials
        loginPage.signInToApp(internalUserEmail, internalUserPassword);


        landingPage.confirmAgreeAndSecureMessages();


        // click on add mCO
        dashboardPage.clickMCOTab();
        //add MCO
        IUMCOPage.clickonaddMCU();


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
        IUMCOPage.summarySectionMCO(firstName, lastName);


        // Log out
        dashboardPage.logOut();


    }
}


