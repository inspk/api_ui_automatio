package com.hhstechgroup.tests.SouthDakota.configurationRegression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class SystemOptionsExternalizationVerificationTest extends BaseClassUI {
    /**
     * This method logs in as Internal User. Goes to System Options and clicks on Externalization Title and
     * verifies base configurations for each subsection
     */
    ExcelWrite excel = new ExcelWrite(taxonomiesListSheet,0);
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void taxonomyExternalizationConfiguration() throws Exception {
        //Sample for verifying the spreadsheets
        Reports.log("The Test will verify the configuration of System Options -> Externalization, for Taxonomy's");
        Reports.log("Logging in as the Internal User");
        loginPage.signInToApp(internalUserEmail, internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        Reports.log("Go to System Options -> User Profile and download the Configuration");
        dashboardPage.openSystemOptions();
        systemOptions.downloadConfigurationExcel(Data.titleExternalization);
        // excel.verifyTwoDifferentExcelSpreadsheets(
        //         "DataFiles/ExpectedFiles/UserProfile-ExpectedConfiguration-2022-08-26.xlsx",
        //         "User Profile",
        //         "DownloadFolder/ConfigurationActual/UserProfile-UserProfileConfiguration-"+ LocalDate.now()+".xlsx",
        //         "User Profile");
        enrollmentPageInternalUser.logOut();

    }

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void errorMessagesExternalizationConfiguration() {
        Reports.log("The Test will verify the configuration of System Options -> Externalization, for Error Messages");

    }

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void dropdownExternalizationConfiguration() {
        Reports.log("The Test will verify the configuration of System Options -> Externalization, for Dropdown Menu's");

    }
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void auditEventNameExternalizationConfiguration() {
        Reports.log("The Test will verify the configuration of System Options -> Externalization, for Audit Event Name's");

    }

    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void auditTagsExternalizationConfiguration() {
        Reports.log("The Test will verify the configuration of System Options -> Externalization, for Audit Tags");

    }


    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test
    public void appPendingDaysExternalizationConfiguration() {
        Reports.log("The Test will verify the configuration of System Options -> Externalization, for Application Pending Days Configuraiton");

    }

}
