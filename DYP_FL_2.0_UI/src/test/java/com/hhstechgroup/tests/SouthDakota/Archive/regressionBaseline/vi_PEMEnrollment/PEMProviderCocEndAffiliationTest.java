package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.vi_PEMEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(VideoListener.class)

/**
 * This class contains a test which uses a data provider to get an approved PEM and ends an affiliation.
 */
public class PEMProviderCocEndAffiliationTest extends BaseClassUI {

    /**
     * This method logs in as an approved PEM and clicks on Coc button and ends affiliation.The flow is to get all the rows in affiliation table
     * and check for individual one the click end and fill in required section and submit.Then logs in as an internal user and change the status
     * of Coc from "Pending Approval" to "ApproveD".For verification logs in as PEM to see if the ended affiliation is listed in "Ended affiliation table"
     * @param firstName
     * @param lastName
     * @param emailID
     * @param trackingNum
     * @throws IOException
     */
    @Test(dataProvider = "getPEMProviderNameEmailWithStatusApproved",
            dataProviderClass = DataProviderForProviderInfo.class, dependsOnGroups = {"ApprovePemEnrollment", "AddAffilliation"})

    public void PemEndAffiliationCoC(String testEnvironment,String firstName, String lastName, String emailID, String trackingNum) throws IOException {

        // login as provider enrollment manager and add individual provider to the affiliation
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();
        coc.clickAnyButton(Data.CHANGE_OF_CIRCUMSTANCE_TYPE_END);
        coc.ajaxScroll(coc.setAndFindButton(Data.TEXT_CREATE));
        coc.clickAnyButton(Data.TEXT_CREATE);
        coc.javaWaitSec(10);
        enrollmentPageProvider.endAffilliation();
        coc.javaWaitSec(20);
        coc.ajaxClick(Locators.POP_UP_DOCUMENT);
        coc.fillInCalendar(enrollmentPageProvider.getCurrentDate(), Data.effectiveEndDateCalendar);
        driver.findElement(Locators.BUTTON_APPROVE_REASON).click();
        driver.findElement(Locators.TEXT_FIELD_APPEAL_REASON).findElement(Locators.AFFILIATION_REASON_LIST).click();
        coc.javaWaitSec(5);
        coc.clickAnyButton(Data.END_Button);
        coc.javaWaitSec(3);
        driver.findElement(Locators.SECTION_SUMMARY).click();
        coc.javaWaitSec(3);
        coc.clickAnyButton(Data.TEXT_SUBMIT);
        coc.javaWaitSec(15);
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

        //login as provider enrollment manager for verification
        homePage.signInToApp(emailID, providerEmailPassword);
        enrollmentPageProvider.clickAffiliationButton();
        coc.javaWaitSec(3);
        Reports.log("Show only Ended Affiliations checkbox enabled");
        driver.findElement(Locators.CHECKBOX_AGREEMENT).click();
        enrollmentPageInternalUser.ajaxClick(Locators.BUTTON_SEARCH);
        coc.javaWaitSec(3);
        String affiliationInfo = driver.findElement(Locators.AFFILIATION_TABLE).getText();
        Assert.assertTrue(affiliationInfo.contains("individual"));
        Reports.log("verifying completed");
    }
}











