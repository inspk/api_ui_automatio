package com.hhstechgroup.tests.SouthDakota.Archive.sanity;

import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataFiles;
import com.hhstechgroup.common.DataProviders;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class cSdn extends BaseClassUI {
    String currentUrl;
    DataFiles dataFiles = new DataFiles();

    @Test
    public void checkFolderNamesInRoot() {
        //First and Last Name of a Provider from ProviderData
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickAndNavigateToDocumentTab();
        enrollmentPageInternalUser.openRootFolder();
        enrollmentPageInternalUser.expandRootFolder();
        enrollmentPageInternalUser.verifyValuesInAnyListAndInFile(Data.ONE_ROOT_FOLDER, "csdnFolders.csv");
    }

    @Test
    public void findEnrollmentCocAndAppeal() {
        //First and Last Name of a Provider from ProviderData
        String firstName = dataFiles.getData("First_Name", "Individual1", "Approved");
        String lastName = dataFiles.getData("Last_Name", "Individual1", "Approved");

        //Login through as the internal user and go to Document Tab
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickAndNavigateToDocumentTab();
        enrollmentPageInternalUser.openRootFolder();
        enrollmentPageInternalUser.enterValueForSearch(firstName+"_"+lastName);
        enrollmentPageInternalUser.expandRootFolder();
        enrollmentPageInternalUser.validateTheEnrolment_Coc_Appeal_Applications(firstName,lastName);
    }

    @Test(dataProvider = "cSDNsections", dataProviderClass = DataProviders.class)
    public void verifyActionsFilesButtons(String section, ITestContext context) {
        String testNGEnvironmentParam = context.getCurrentXmlTest().getParameter("environment");

        //Login through as the internal user and go to Document Tab
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickAndNavigateToDocumentTab();

        if (section.contains(Data.SECTION_MANAGE_FILES)) {
            enrollmentPageInternalUser.clickOnManageFilesButton();
        } else if (section.contains(Data.SECTION_ARCHIVED_FILES)) {
            enrollmentPageInternalUser.clickOnArchivedFilesButton();
        }
        enrollmentPageInternalUser.enterValueForSearch(Data.medicaidFile);
        enrollmentPageInternalUser.collectCellsInDocumentsTableAndClickValid(section, Data.medicaidFile);
        if (section.contains(Data.SECTION_MANAGE_FILES)) {
          enrollmentPageInternalUser.downloadFile(1);
        } else if (section.contains(Data.SECTION_ARCHIVED_FILES)) {
            enrollmentPageInternalUser.collectCellsInDocumentsTableAndClickValid(section, Data.medicaidFile);
        }
        //View file
        enrollmentPageInternalUser.downloadFile(0);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        currentUrl = driver.getCurrentUrl();

        //Verify attachment file URL
        if (testNGEnvironmentParam.contains(Data.TESTNG_ENV_PARAM_UAT))
            Assert.assertTrue(currentUrl.contains(Data.URL_CONTENT_UAT),
                    "Attachment URL "+currentUrl+" is not valid for testNGEnvironmentParam "+testNGEnvironmentParam);
        else if (testNGEnvironmentParam.contains(Data.TESTNG_ENV_PARAM_SIT))
            Assert.assertTrue(currentUrl.contains(Data.URL_CONTENT_SIT),
                    "Attachment URL "+currentUrl+" is not valid for testNGEnvironmentParam "+testNGEnvironmentParam);
        else
            Assert.fail("Attachment URL "+currentUrl+" is not valid for testNGEnvironmentParam "+testNGEnvironmentParam);
    }

    @Test
    public void findEnrollmentFileInAttachments() {
        homePage.signInToApp(internalUserEmail, internalUserPassword);
        enrollmentPageInternalUser.clickAndNavigateToDocumentTab();
        enrollmentPageInternalUser.openRootFolder();
        enrollmentPageInternalUser.expandRootFolder();
        enrollmentPageInternalUser.verifyFileAttachment();

    }

}