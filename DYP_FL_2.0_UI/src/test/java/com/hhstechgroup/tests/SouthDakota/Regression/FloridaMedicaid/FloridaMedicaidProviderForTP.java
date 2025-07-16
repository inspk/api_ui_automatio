package com.hhstechgroup.tests.SouthDakota.Regression.FloridaMedicaid;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.Pages.FloridaMedicaidProviderIDEnrollmentPage;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Test;

import java.io.IOException;

public class FloridaMedicaidProviderForTP extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String baseproviderId;
    String locationproviderID;
    String status;


    /**
     *
     * @param firstName
     * @param lastName
     * @param trackingNum
     * @throws IOException
     */
    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusPendingApproval",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"ApproveTPEnrollment"},
            groups = {"TPEnrollmentEnrolmentSection"})
    public void TPEnrollmentEnrolmentSection(String testEnvironment, String applicationType, String firstName, String lastName, String email,
                                             String trackingNum) throws IOException {

        Reports.log("TP Enrollment Section");
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
        baseproviderId = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.BaseProviderId).getText();
        locationproviderID = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.LocationProviderID).getText();
        status = driver.findElement(FloridaMedicaidProviderIDEnrollmentPage.StatusOfApplication).getText();

        //writing it to excel and reading it
        excel.writeData(baseproviderId, locationproviderID, status);
        excel.readExcel();

        //clicks on edit and updates start date,end date and status
        floridaMedicaidProviderIDEnrollment.editDateAndStatus();
    }

    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusPendingApproval",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = {"TPEnrollmentEnrolmentSection"},
            groups = {"TPEnrollemntProviderSection"})
    public void TPEnrollemntProviderSection(String testEnvironment, String applicationType, String firstName, String lastName, String email,
                                            String trackingNum) throws IOException {

        Reports.log("TP Enrollment Provider Section");
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
