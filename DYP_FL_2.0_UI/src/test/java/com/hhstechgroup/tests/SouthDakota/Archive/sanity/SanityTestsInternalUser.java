package com.hhstechgroup.tests.SouthDakota.Archive.sanity;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.tests.base.BaseClassUI;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(VideoListener.class)
public class SanityTestsInternalUser extends BaseClassUI {
    String currentUrl;
    String currentTitle;
    String systemInformation;

    @Video
    @Description("Test all main tabs")
   @Test
    public void checkMainTabsPortal() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);

        wait.until(ExpectedConditions.elementToBeClickable(Locators.ANY_HEADER_MAIN_TAB));
        List<WebElement> listOfTabs = driver.findElements(Locators.ANY_HEADER_MAIN_TAB);

        for (int i = 0; i < listOfTabs.size(); i++) {
            enrollmentPageInternalUser.ajaxClick(listOfTabs.get(i));

            System.out.println("Iteration: " + i);
            currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);

            if (!currentUrl.contains(Data.LINK_HELPCENTER)) {
                currentTitle = driver.findElement(Locators.ANY_MAIN_TITLE).getText();
                Reports.log(currentTitle + " tab is displayed");
            }

            if (currentUrl.contains(Data.LINK_PROVIDERS)) {
                wait.until(
                        ExpectedConditions.visibilityOf(
                                mainTabs.findAnyElement(Locators.TEXT_FIELD_PROVIDER_NAME)));
            } else if (currentUrl.contains(Data.LINK_REQUESTS)
                    || currentUrl.contains(Data.LINK_COC)
                    || currentUrl.contains(Data.LINK_APPEALS)) {
                wait.until(
                        ExpectedConditions.visibilityOf(
                                mainTabs.findAnyElement(Locators.TEXT_FIELD_PROVIDER_ID)));
            } else if (currentUrl.contains(Data.LINK_AUDIT)) {
                wait.until(
                        ExpectedConditions.visibilityOf(
                                mainTabs.findAnyElement(Locators.TEXT_FIELD_USER_NAME)));
            } else if (currentUrl.contains(Data.LINK_SITE_VISIT)) {
                wait.until(
                        ExpectedConditions.visibilityOf(
                                mainTabs.findAnyElement(Locators.TEXT_FIELD_PROVIDER_SITE_VISITS)));
            }

            if (currentUrl.contains(Data.LINK_PROVIDERS)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_PROVIDERS));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleProviders));
            } else if (currentUrl.contains(Data.LINK_REQUESTS)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_REQUESTS));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleEnrollment));
            } else if (currentUrl.contains(Data.LINK_COC)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_COC));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleCoc));
            } else if (currentUrl.contains(Data.LINK_APPEALS)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_APPEALS));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleReconsideration));
            } else if (currentUrl.contains(Data.LINK_AUDIT)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_AUDIT));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleAudit));
            } else if (currentUrl.contains(Data.LINK_REPORTS)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_REPORTS));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleSiteReports));
                enrollmentPageInternalUser.spanContainsText(Data.cannedTab);
                // enrollmentPageInternalUser.spanContainsText(Data.letterTab);
                enrollmentPageInternalUser.spanContainsText(Data.adHocTab);

            } else if (currentUrl.contains(Data.LINK_SITE_VISIT)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_SITE_VISIT));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleSiteVisits));
            } else if (currentUrl.contains(Data.LINK_PAYMENTS)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_PAYMENTS));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitlePayments));
            }  else if (currentUrl.contains(Data.LINK_CLAIMS)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_CLAIMS));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleClaims));
            }
            else if (currentUrl.contains(Data.LINK_1099LINK)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_1099LINK));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitle1099));
            }



            else if (currentUrl.contains(Data.LINK_VOTING)) {
                Assert.assertTrue(currentUrl.contains(Data.LINK_VOTING));
                Assert.assertTrue(currentTitle.contains(Data.expectedTitleVoting));

            } else if (currentUrl.contains(Data.LINK_HELPCENTER)) {
                Assert.assertTrue(driver.findElement(Locators.HELPCENTER_TITLE).isDisplayed());
                //  driver.findElements(Locators.BACK_TO_PROVIDER_PORTAL).get(1).click();
            } else if (currentUrl.contains(Data.LINK_DOCUMENTS)) {
                //WebElement csdnFrame = driver.findElement(Locators.CSDN_IFRAME);
                //  driver.switchTo().frame(csdnFrame);
            } else {
                Reports.log(currentUrl + " is not displayed or not expected");
                Assert.fail(currentUrl + " is not displayed  or not expected");
            }
            listOfTabs = driver.findElements(Locators.ANY_HEADER_MAIN_TAB);
        }
    }


   @Test
    public void inbox() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        inboxIU.verifyMessageCenter();
        enrollmentPageInternalUser.logOut();
    }

    @Test
    public void systemOptions() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);

        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyUsersSystemOptions();
        systemOptionsIE.verifyUserRolesSystemOptions();
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyScreeningSystemOptions();
        systemOptionsIE.verifyAutoAssignSystemOptions();
        systemOptionsIE.verifyDataChangeSystemOptions();
        systemOptionsIE.verifyApprovalIndividualsSystemOptions();
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyApprovalGroupsSystemOptions();
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyRevalidationSystemOptions();
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyLicenseSystemOptions();
        enrollmentPageInternalUser.openSystemOptions();
        systemOptionsIE.verifyExternalizationSystemOptions();
        systemOptionsIE.verifyDeactivationSystemOptions();
        systemOptionsIE.verifyPaymentAndFeeSystemOptions();
        systemOptionsIE.VerifyAutoArchiveSystemOption();
        systemOptionsIE.verifyDuplicitySystemOption();
        systemOptionsIE.verifyRequestAdditionalInfoSystemOptions();
        enrollmentPageInternalUser.logOut();
    }
}
