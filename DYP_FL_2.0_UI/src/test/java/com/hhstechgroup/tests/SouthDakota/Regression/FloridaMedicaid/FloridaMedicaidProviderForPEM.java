package com.hhstechgroup.tests.SouthDakota.Regression.FloridaMedicaid;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.Pages.FloridaMedicaidProviderIDEnrollmentPage;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Test;

import java.io.IOException;

public class FloridaMedicaidProviderForPEM extends BaseClassUI {


    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String baseproviderId;
    String locationproviderID;
    String status;


    /**
     *
     * @param firstName
     * @param lastName
     * @param trackingId
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"ApprovePemEnrollment"},
            groups = {"PEMEnrollmentEnrolmentSection"})
    public void PEMEnrollmentEnrolmentSection(String testEnvironment, String firstName, String lastName, String emailID, String trackingId) throws IOException {

        Reports.log("PEM Enrollment Section");
        // Login Application as an internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        dashboardPage.clickEnrollTab();
        //searches for enrollment and clicks on it
//        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.PEMEnrollment);


        floridaMedicaidProviderIDEnrollment.serchwithreqID();

        //navigates to medicaid provider id section
        floridaMedicaidProviderIDEnrollment.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        Data.baseproviderId = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.BaseProviderId).getText();
        Data.locationproviderID = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.LocationProviderID).getText();
        status = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(Data.baseproviderId, Data.locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDEnrollment.editDateAndStatus();
    }

    @Video
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"PEMEnrollmentEnrolmentSection"},
            groups = {"PEMEnrollemntProviderSection"})
    public void PEMEnrollemntProviderSection(String testEnvironment, String firstName, String lastName, String emailID, String trackingId) throws IOException {

        Reports.log("PEM Enrollment Provider Section");
        // Login Application as an internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //click on enrollment from dashboard
        dashboardPage.clickProvidersTab();
        //searches for enrollment and clicks on it
//        providersPage.searchproviderByEnrollmentType(IUEnrollmentPage.PEMEnrollment);


        providersPage.searchwithproviderid();
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDProvider.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(floridaMedicaidProviderIDProvider.BaseProviderId).getText();
        locationproviderID = driver.findElement(floridaMedicaidProviderIDProvider.LocationProviderID).getText();
        status = driver.findElement(floridaMedicaidProviderIDProvider.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        floridaMedicaidProviderIDEnrollment.editDateAndStatus();
    }
}
