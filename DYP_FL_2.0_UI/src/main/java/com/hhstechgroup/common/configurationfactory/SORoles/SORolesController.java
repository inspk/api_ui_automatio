package com.hhstechgroup.common.configurationfactory.SORoles;


import com.hhstechgroup.Pages.DashboardPage;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.common.configurationfactory.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * Roles Controller method is used for Controlling all the Roles under SO Roles to collect all the roles under SORoles package
 */
public class SORolesController extends Configuration {

    //Xpaths
    private static final String BACK_TO_ROLES_PAGE = "//a[@href = '/system/roles']";

    public void rolesSystemOptions (WebDriver driver, DashboardPage dashboardPage, SoftAssert softAssert) throws Exception {

    //Read all the Roles that are on the screen and iterate when the Role name matched
        for(int i = 1; i<9; i++) {
            //Read the Roles from the Screen
            String role = driver.findElement(By.xpath("//a[contains(@href,'system/role')]["+i+"]/span[1]")).getText();
            Reports.log("Verifying Roles Configuration for: " + role);
            switch(role){
                case "Call Center Agent":
                    SORolesCallCenterAgent rolesCallCenterAgent = new SORolesCallCenterAgent();
                    rolesCallCenterAgent.verifyCallCenterAgent(driver, dashboardPage, softAssert);
                    break;
                case "Forensic Supervisor":
                    SORolesForensicSupervisor rolesForensicSupervisor = new SORolesForensicSupervisor();
                    rolesForensicSupervisor.verifyForensicSupervisor(driver, dashboardPage, softAssert);
                    break;
                case "Provider Admin":
                    SORolesProviderAdmin rolesProviderAdmin = new SORolesProviderAdmin();
                    rolesProviderAdmin.verifyProviderAdmin(driver, dashboardPage, softAssert);
                    break;
                case "Provider Analyst":
                    Reports.log("Breaking Provider Analyst");
                   SORolesProviderAnalyst rolesProviderAnalyst = new SORolesProviderAnalyst();
                   rolesProviderAnalyst.verifyProviderAnalyst(driver, dashboardPage, softAssert);
                    break;
                case "Provider Specialist":
                    SORolesProviderSpecialist rolesProviderSpecialist = new SORolesProviderSpecialist();
                    rolesProviderSpecialist.verifyProviderSpecialist(driver, dashboardPage, softAssert);
                    break;
                case "Provider Supervisor":
                    SORolesProviderSupervisor rolesProviderSupervisor = new SORolesProviderSupervisor();
                    rolesProviderSupervisor.verifyProviderSupervisor(driver, dashboardPage, softAssert);
                    break;
                case "Site Visit Investigator":
                    Reports.log("Breaking Site Visit Investigator");
                    /* To add this Role, we can copy the SORoles[RoleType]
                            Find and replace the following:
                            1. Beginning of the variable (for example 'PS_', 'CCA_', or 'PA_' to appropriate abbreviation of the role type)
                            2. Change the variable PROVIDER_TYPE (line 18) to match the Role Type
                            3. Add the correspondent Role in the Controller File (SORolesController)
                            4. Change the Expected per the configuration
                    */
                    break;
                case "Site Visit Supervisor":
                    Reports.log("Breaking Site Visit Supervisor");
                    /* To add this Role, we can copy the SORoles[RoleType]
                            Find and replace the following:
                            1. Beginning of the variable (for example 'PS_', 'CCA_', or 'PA_' to appropriate abbreviation of the role type)
                            2. Change the variable PROVIDER_TYPE (line 18) to match the Role Type
                            3. Add the correspondent Role in the Controller File (SORolesController)
                            4. Change the Expected per the configuration
                    */
                    break;
                default:
                    Reports.log("The Role '" +role+"'was not found. Therefore, test Failed" );
                    Assert.fail();
            }
            //Go back to Roles
            javaWaitSec(1);
            Reports.log("Going back to the System Options Roles Main Page");
            driver.findElement(By.xpath(BACK_TO_ROLES_PAGE)).click();
        }
    }
}
