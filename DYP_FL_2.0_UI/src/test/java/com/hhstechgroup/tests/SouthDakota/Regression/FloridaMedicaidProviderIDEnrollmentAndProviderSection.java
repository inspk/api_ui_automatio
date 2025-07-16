package com.hhstechgroup.tests.SouthDakota.Regression;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.Pages.FloridaMedicaidProviderIDEnrollmentPage;
import com.hhstechgroup.Pages.IUEnrollmentPage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)
public class FloridaMedicaidProviderIDEnrollmentAndProviderSection extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String baseproviderId;
    String locationproviderID;
    String status;
    String testEmailAccount;


    @Test
    public void floridaMedicaidProviderId() throws IOException {

        //================================Enrollment section====================================//
        Reports.log("\tTP Medicaid");
        //login as internal user
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        //click on enrollment from dashboard
        dashboardPage.clickEnrollTab();
        //searches for enrollment and clicks on it
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.TPEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDEnrollment.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.BaseProviderId).getText();
        locationproviderID = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.LocationProviderID).getText();
        status = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDEnrollment.editDateAndStatus();


        Reports.log("\tPEM Medicaid");
        //click on enrollment from dashboard
        dashboardPage.clickEnrollTab();
        //searches for enrollment and clicks on it
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.PEMEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDEnrollment.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.BaseProviderId).getText();
        locationproviderID = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.LocationProviderID).getText();
        status = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDEnrollment.editDateAndStatus();

        Reports.log("\tEntity Medicaid");
        //click on enrollment from dashboard
        dashboardPage.clickEnrollTab();
        //searches for enrollment and clicks on it
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.EntityEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDEnrollment.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.BaseProviderId).getText();
        locationproviderID = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.LocationProviderID).getText();
        status = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDEnrollment.editDateAndStatus();

        Reports.log("Individual Medicaid");
        //click on enrollment from dashboard
        dashboardPage.clickEnrollTab();
        //searches for enrollment and clicks on it
        iuEnrollmentPage.searchproviderByEnrollmentType(IUEnrollmentPage.IndividualEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDEnrollment.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.BaseProviderId).getText();
        locationproviderID = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.LocationProviderID).getText();
        status = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDEnrollment.editDateAndStatus();

        //==========================================Provider section======================================//

        Reports.log("Provider section");
        //click on enrollment from dashboard
        dashboardPage.clickProvidersTab();
        //searches for enrollment and clicks on it
        providersPage.searchproviderByEnrollmentType(IUEnrollmentPage.IndividualEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDProvider.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(floridaMedicaidProviderIDProvider.BaseProviderId).getText();
        locationproviderID = driver.findElement(floridaMedicaidProviderIDProvider.LocationProviderID).getText();
        status = driver.findElement(floridaMedicaidProviderIDProvider.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        Reports.log("Entity enrollment");
        //click on enrollment from dashboard
        dashboardPage.clickProvidersTab();
        //searches for enrollment and clicks on it
        providersPage.searchproviderByEnrollmentType(IUEnrollmentPage.EntityEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDProvider.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(floridaMedicaidProviderIDProvider.BaseProviderId).getText();
        locationproviderID = driver.findElement(floridaMedicaidProviderIDProvider.LocationProviderID).getText();
        status = driver.findElement(floridaMedicaidProviderIDProvider.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        Reports.log("PEM enrollment");
        //click on enrollment from dashboard
        dashboardPage.clickProvidersTab();
        //searches for enrollment and clicks on it
        providersPage.searchproviderByEnrollmentType(IUEnrollmentPage.PEMEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDProvider.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(floridaMedicaidProviderIDProvider.BaseProviderId).getText();
        locationproviderID = driver.findElement(floridaMedicaidProviderIDProvider.LocationProviderID).getText();
        status = driver.findElement(floridaMedicaidProviderIDProvider.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        Reports.log("TP enrollment");
        //click on enrollment from dashboard
        dashboardPage.clickProvidersTab();
        //searches for enrollment and clicks on it
        providersPage.searchproviderByEnrollmentType(IUEnrollmentPage.TPEnrollment);
        //navigates to medicaid provider id section
        floridaMedicaidProviderIDProvider.navigateToProviderMedicaid();

        //fetching the datas and storing it in variables
        baseproviderId = driver.findElement(floridaMedicaidProviderIDProvider.BaseProviderId).getText();
        locationproviderID = driver.findElement(floridaMedicaidProviderIDProvider.LocationProviderID).getText();
        status = driver.findElement(floridaMedicaidProviderIDProvider.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDProvider.editDateAndStatus();

        //logout
        dashboardPage.logOut();
    }
}