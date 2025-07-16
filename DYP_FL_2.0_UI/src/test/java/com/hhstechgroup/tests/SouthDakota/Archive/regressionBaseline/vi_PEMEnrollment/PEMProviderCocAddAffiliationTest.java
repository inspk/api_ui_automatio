package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved PEM and adds an affiliation.
 */
public class PEMProviderCocAddAffiliationTest extends BaseClassUI {

    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String providerExcelPath = "ProviderInfo.xlsx";

    /**
     * This method logs in as an approved PEM and clicks on Coc button and adds affiliation using Affiliated provider(Individual) NPI from ProviderInfo.xlsx.
     * Then logs in as an affiliated provider and checks the message center and signs the agreement of being affiliated.Then logs in as an internal user and
     * approves the Coc.For verification logs in as PEM to see if the affiliation is listed.
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws Exception
     */
    @Video
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusApproved",
            dataProviderClass = DataProviderForProviderInfo.class
    ,dependsOnGroups = {"ApprovePemEnrollment"},groups={"AddAffilliation"})

    public void PemAddAffiliationCoC(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws Exception {

        List<Object> provideInformation = Arrays.asList(ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.individualApplication, "APPROVED").toArray());
        String providerName = provideInformation.get(0).toString();
        Reports.log("provider firstName is : " + providerName);
        String providerLastName = provideInformation.get(1).toString();
        Reports.log("provider lastName is : " + providerLastName);
        String providerEmail = provideInformation.get(2).toString();
        Reports.log("provider email is : " + providerEmail);
        String providerNpi = provideInformation.get(4).toString();
        Reports.log("provider Npi is : " + providerNpi);

        // login as provider enrollment manager and add individual provider to the affiliation
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.clickAnyButton(Data.CHANGE_OF_CIRCUMSTANCE_TYPE_ADD);
        coc.ajaxScroll(coc.setAndFindButton(Data.TEXT_CREATE));
        coc.clickAnyButton(Data.TEXT_CREATE);
        enrollmentPageProvider.addAffiliationToPemEnrollment(providerNpi);
        coc.javaWaitSec(5);
        coc.clickAnyButton(Data.TEXT_NEXT);
        coc.javaWaitSec(3);
        coc.ajaxClick(Locators.SECTION_SUMMARY);
        coc.javaWaitSec(2);
        coc.ajaxClick(Locators.AFFILIATION_SUBMIT_SIGN);
        coc.javaWaitSec(2);
        enrollmentPageProvider.signInHelloSign(providerName + " " + providerLastName, "");
        coc.javaWaitSec(10);
        enrollmentPageInternalUser.logOut();

        // login as individual provider to sign the affiliation
        homePage.signInToApp(providerEmail, providerEmailPassword);
        Reports.log("Openning the Message inbox");
        enrollmentPageInternalUser.ajaxClick(Locators.MESSAGE_INBOX);
        coc.javaWaitSec(5);
        Reports.log("Openning the first Message in the inbox");
        coc.javaWaitSec(3);
        coc.ajaxClick(Locators.First_MESSAGE_IN_INBOX);
        driver.findElement(Locators.SELECT_VIEW_OPTION).click();
        coc.javaWaitSec(2);
        coc.ajaxClick(Locators.MESSAGE_CONTENT_InBOX);
        coc.javaWaitSec(2);
        enrollmentPageProvider.signInHelloSign(providerName + " " + providerLastName, "");
        coc.javaWaitSec(10);
        enrollmentPageInternalUser.logOut();

        // login as internal user
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider(firstName);
        coc.javaWaitSec(10);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, "PENDING APPROVAL");
        enrollmentsAndCoc.changeStatusWithReason(Data.ApplicationStatusApprove);
        driver.navigate().refresh();
        coc.javaWaitSec(20);
        String statusOfApplication = enrollmentPageInternalUser.getApplicationStatus();
        Reports.log("Status of application is: " + statusOfApplication);
        enrollmentPageInternalUser.logOut();

        //login as PEM and verify that the new NPI request is added in the list
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.clickAffiliationButton();
        coc.javaWaitSec(10);
        enrollmentPageProvider.searchAffiliateProvider(providerName);
        coc.javaWaitSec(5);
        String affiliationInfo = driver.findElement(Locators.AFFILIATION_TABLE).getText();
        Reports.log(affiliationInfo);
        Assert.assertTrue(affiliationInfo.contains(providerNpi));
        Reports.log("verifying completed");
    }
}




