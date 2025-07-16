package com.hhstechgroup.tests.SouthDakota.Regression;

import com.hhstechgroup.Pages.FloridaMedicaidProviderIDEnrollmentPage;
import com.hhstechgroup.Pages.IUEnrollmentPage;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;

import java.io.IOException;

public class FloridaMedicaidProviderIDTPMedicaid extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String baseproviderId;
    String locationproviderID;
    String status;




    public void floridaMedicaidProviderIdforTPMedicaid() throws IOException {

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

    }


}
