package com.hhstechgroup.common.configurationfactory.SOApprovals;

import com.hhstechgroup.Pages.DashboardPage;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.common.configurationfactory.Configuration;
import com.hhstechgroup.common.configurationfactory.ConfigurationFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the TradingPartner Approvals system option configuration.
 */
public class SOPEMApprovals extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";
    private static final String CONFIGURATION_SWITCH  = "Switch";
    private static final String CONFIGURATION_VALUE  = "Field";

    private static final String ENROLLMENT_REQUEST = "Enrollment";
    private static final String REVALIDATION_REQUEST = "Revalidation";
    private static final String RECONSIDERATION_REQUEST = "Reconsideration";
    private static final String COC_REQUEST = "Change of Circumstance";
    private static final String SITE_VISIT_REQUEST = "Site Visit";
    private static final String RE_ENROLLMENT_REQUEST = "Re Enrollment";

    //******************************************************************************************************************
    //
    //                                  MISC XPATH STRINGS DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String BACK_TO_ENROLLMENT_TYPES = "//h4[contains(text(),'Back to ')]";
    private static final String BACK_TO_APPROVALS_LIST = "//span[contains(.,'← Back to Approvals list')]";
    private static final String XPATH_PREFIX  = "//div[contains(text(),'";
    private static final String XPATH_MIDDLE  = "')]/../div//h3[contains(text(),'";
    private static final String XPATH_SUFFIX  = "')]/../../div[3]/button[@type='button']";
    private static final String PROVIDER_IDENTIFIER = "Provider Enrollment Manager_//h3[contains(text(),'Provider Enrollment Manager')]/../../div[2]/i[@class='material-icons']";

    //******************************************************************************************************************
    //
    // ENROLLMENT CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    // NOTE: Additional String Declarations can be copied from SOIndividualApprovals.java and updated for use in this
    // section as needed.
    //******************************************************************************************************************
    private static final String ENROLL_AUTO_APPROVE_SW = "PEM Enrollment Auto Approve_false_//input[@aria-label='Auto Switch']";
    private static final String ENROLL_NUM_APPROVALS_REQUIRED_VAL = "PEM Enrollment Number of approvals required_1_//h4[contains(text(),'Number of approvals')]/../span";
    private static final String ENROLL_WHO_CAN_APPROVE_01_VAL = "PEM Enrollment Who Can Approve 1_Provider supervisor_//p[contains(text(),'Provider supervisor')]";
    private static final String ENROLL_WHO_CAN_APPROVE_TYPE_01_VAL = "PEM Enrollment Who Can Approve Type 1_Role_//p[contains(text(),'Provider supervisor')]/../../../../div[2]/descendant::p";
    private static final String ENROLL_WHO_CAN_APPROVE_02_VAL = "PEM Enrollment Who Can Approve 2_Provider specialist_//p[contains(text(),'Provider specialist')]";
    private static final String ENROLL_WHO_CAN_APPROVE_TYPE_02_VAL = "PEM Enrollment Who Can Approve Type 2_Role_//p[contains(text(),'Provider specialist')]/../../../../div[2]/descendant::p";
    private static final String ENROLL_WHO_CAN_APPROVE_03_VAL = "PEM Enrollment Who Can Approve 3_Call center agent_//p[contains(text(),'Call center agent')]";
    private static final String ENROLL_WHO_CAN_APPROVE_TYPE_03_VAL = "PEM Enrollment Who Can Approve Type 3_Role_//p[contains(text(),'Call center agent')]/../../../../div[2]/descendant::p";
    private static final String ENROLL_WHO_CAN_APPROVE_04_VAL = "PEM Enrollment Who Can Approve 4_Forensic supervisor_//p[contains(text(),'Forensic supervisor')]";
    private static final String ENROLL_WHO_CAN_APPROVE_TYPE_04_VAL = "PEM Enrollment Who Can Approve Type 4_Role_//p[contains(text(),'Forensic supervisor')]/../../../../div[2]/descendant::p";
    private static final String ENROLL_WHO_CAN_APPROVE_05_VAL = "PEM Enrollment Who Can Approve 5_Provider analyst_//p[contains(text(),'Provider analyst')]";
    private static final String ENROLL_WHO_CAN_APPROVE_TYPE_05_VAL = "PEM Enrollment Who Can Approve Type 5_Role_//p[contains(text(),'Provider analyst')]/../../../../div[2]/descendant::p";
    private static final String ENROLL_CONFIG_CVO_SW = "PEM Enrollment Configure CVO committee to vote for request approval_false_//h3[contains(text(),'Configure CVO')]/../descendant::input";
    private static final String ENROLL_CONFIG_REVIEWERS_SW = "PEM Enrollment Configure reviewers to vote for request approval_false_//h3[contains(text(),'Configure reviewers')]/../descendant::input";
    private static final String ENROLL_REQUEST_STARTS_NEW_SW = "PEM Enrollment Request starts with status New_true_//h3[contains(text(),'Request starts')]/../..//input[@type='checkbox']";
    private static final String ENROLL_ASSIGNEE_CONFIG_SW = "PEM Enrollment Assignee Configuration_true_//h3[contains(text(),'Assignee')]/../../../div/div[3]/label/span/span/span/input[@type='checkbox']";
    private static final String ENROLL_SYS_ASSIGNS_BACK_SW = "PEM Enrollment System assigns back_true_//h3[contains(text(), 'System assigns back')]/../../..//input[@type='checkbox']";
    private static final String ENROLL_TEMP_APPROVAL_SW = "PEM Enrollment Temporary Approval_false_//h3[contains(text(), 'Temporary')]/../../..//input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // REVALIDATION CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    // NOTE: Additional String Declarations can be copied from SOIndividualApprovals.java and updated for use in this
    // section as needed.
    //******************************************************************************************************************
    private static final String REVAL_AUTO_APPROVE_SW = "PEM Revalidation Auto Approve_false_//input[@aria-label='Auto Switch']";
    private static final String REVAL_NUM_APPROVALS_REQUIRED_VAL = "PEM Revalidation Number of approvals required_1_//h4[contains(text(),'Number of approvals')]/../span";
    private static final String REVAL_WHO_CAN_APPROVE_01_VAL = "PEM Revalidation Who Can Approve 1_Provider supervisor_//p[contains(text(),'Provider supervisor')]";
    private static final String REVAL_WHO_CAN_APPROVE_TYPE_01_VAL = "PEM Revalidation Who Can Approve Type 1_Role_//p[contains(text(),'Provider supervisor')]/../../../../div[2]/descendant::p";
    private static final String REVAL_WHO_CAN_APPROVE_02_VAL = "PEM Revalidation Who Can Approve 2_Provider specialist_//p[contains(text(),'Provider specialist')]";
    private static final String REVAL_WHO_CAN_APPROVE_TYPE_02_VAL = "PEM Revalidation Who Can Approve Type 2_Role_//p[contains(text(),'Provider specialist')]/../../../../div[2]/descendant::p";
    private static final String REVAL_WHO_CAN_APPROVE_03_VAL = "PEM Revalidation Who Can Approve 3_Call center agent_//p[contains(text(),'Call center agent')]";
    private static final String REVAL_WHO_CAN_APPROVE_TYPE_03_VAL = "PEM Revalidation Who Can Approve Type 3_Role_//p[contains(text(),'Call center agent')]/../../../../div[2]/descendant::p";
    private static final String REVAL_WHO_CAN_APPROVE_04_VAL = "PEM Revalidation Who Can Approve 4_Forensic supervisor_//p[contains(text(),'Forensic supervisor')]";
    private static final String REVAL_WHO_CAN_APPROVE_TYPE_04_VAL = "PEM Revalidation Who Can Approve Type 4_Role_//p[contains(text(),'Forensic supervisor')]/../../../../div[2]/descendant::p";
    private static final String REVAL_WHO_CAN_APPROVE_05_VAL = "PEM Revalidation Who Can Approve 5_Provider analyst_//p[contains(text(),'Provider analyst')]";
    private static final String REVAL_WHO_CAN_APPROVE_TYPE_05_VAL = "PEM Revalidation Who Can Approve Type 5_Role_//p[contains(text(),'Provider analyst')]/../../../../div[2]/descendant::p";
    private static final String REVAL_CONFIG_CVO_SW = "PEM Revalidation Configure CVO committee to vote for request approval_false_//h3[contains(text(),'Configure CVO')]/../descendant::input";
    private static final String REVAL_CONFIG_REVIEWERS_SW = "PEM Revalidation Configure reviewers to vote for request approval_false_//h3[contains(text(),'Configure reviewers')]/../descendant::input";
    private static final String REVAL_REQUEST_STARTS_NEW_SW = "PEM Revalidation Request starts with status New_true_//h3[contains(text(),'Request starts')]/../..//input[@type='checkbox']";
    private static final String REVAL_ASSIGNEE_CONFIG_SW = "PEM Revalidation Assignee Configuration_true_//h3[contains(text(),'Assignee')]/../../../div/div[3]/label/span/span/span/input[@type='checkbox']";
    private static final String REVAL_SYS_ASSIGNS_BACK_SW = "PEM Revalidation System assigns back_true_//h3[contains(text(), 'System assigns back')]/../../..//input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // RECONSIDERATION CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    // NOTE: Additional String Declarations can be copied from SOIndividualApprovals.java and updated for use in this
    // section as needed.
    //******************************************************************************************************************
    private static final String RECON_AUTO_APPROVE_SW = "PEM Reconsideration Auto Approve_false_//input[@aria-label='Auto Switch']";
    private static final String RECON_NUM_APPROVALS_REQUIRED_VAL = "PEM Reconsideration Number of approvals required_1_//h4[contains(text(),'Number of approvals')]/../span";
    private static final String RECON_WHO_CAN_APPROVE_01_VAL = "PEM Reconsideration Who Can Approve 1_Provider supervisor_//p[contains(text(),'Provider supervisor')]";
    private static final String RECON_WHO_CAN_APPROVE_TYPE_01_VAL = "PEM Reconsideration Who Can Approve Type 1_Role_//p[contains(text(),'Provider supervisor')]/../../../../div[2]/descendant::p";
    private static final String RECON_WHO_CAN_APPROVE_02_VAL = "PEM Reconsideration Who Can Approve 2_Provider specialist_//p[contains(text(),'Provider specialist')]";
    private static final String RECON_WHO_CAN_APPROVE_TYPE_02_VAL = "PEM Reconsideration Who Can Approve Type 2_Role_//p[contains(text(),'Provider specialist')]/../../../../div[2]/descendant::p";
    private static final String RECON_CONFIG_REVIEWERS_VOTE_SW = "PEM Reconsideration Configure reviewers to vote for request approval_false_//h3[contains(text(),'Configure reviewers')]/../descendant::input";
    private static final String RECON_ASSIGNEE_CONFIG_SW = "PEM Reconsideration Assignee Configuration_false_//h3[contains(text(),'Assignee')]/../../../div/div[3]/label/span/span/span/input[@type='checkbox']";
//    private static final String RECON_SYS_ASSIGNS_BACK_SW = "PEM Revalidation System assigns back_true_//h3[contains(text(), 'System assigns back')]/../../..//input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // COC CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    // NOTE: Additional String Declarations can be copied from SOIndividualApprovals.java and updated for use in this
    // section as needed.
    //******************************************************************************************************************
    private static final String COC_AUTO_APPROVE_SW = "PEM COC Auto Approve_true_//p[contains(text(),'Request is automatically approved')]/../../div[3]/label/span/span/span/input[@type='checkbox']";
    private static final String COC_AUTO_APPROVE_AFFILIATION_SW = "PEM COC Affiliation Auto Approve_true_//input[@aria-label='Auto Switch']";
    private static final String COC_NUM_APPROVALS_REQUIRED_VAL = "PEM COC Number of approvals required_1_//h4[contains(text(),'Number of approvals')]/../span";
    private static final String COC_WHO_CAN_APPROVE_01_VAL = "PEM COC Who Can Approve 1_Provider supervisor_//p[contains(text(),'Provider supervisor')]";
    private static final String COC_WHO_CAN_APPROVE_TYPE_01_VAL = "PEM COC Who Can Approve Type 1_Role_//p[contains(text(),'Provider supervisor')]/../../../../div[2]/descendant::p";
    private static final String COC_WHO_CAN_APPROVE_02_VAL = "PEM COC Who Can Approve 2_Provider specialist_//p[contains(text(),'Provider specialist')]";
    private static final String COC_WHO_CAN_APPROVE_TYPE_02_VAL = "PEM COC Who Can Approve Type 2_Role_//p[contains(text(),'Provider specialist')]/../../../../div[2]/descendant::p";
    private static final String COC_WHO_CAN_APPROVE_03_VAL = "PEM COC Who Can Approve 3_Call center agent_//p[contains(text(),'Call center agent')]";
    private static final String COC_WHO_CAN_APPROVE_TYPE_03_VAL = "PEM COC Who Can Approve Type 3_Role_//p[contains(text(),'Call center agent')]/../../../../div[2]/descendant::p";
    private static final String COC_WHO_CAN_APPROVE_04_VAL = "PEM COC Who Can Approve 4_Forensic supervisor_//p[contains(text(),'Forensic supervisor')]";
    private static final String COC_WHO_CAN_APPROVE_TYPE_04_VAL = "PEM COC Who Can Approve Type 4_Role_//p[contains(text(),'Forensic supervisor')]/../../../../div[2]/descendant::p";
    private static final String COC_WHO_CAN_APPROVE_05_VAL = "PEM COC Who Can Approve 5_Provider analyst_//p[contains(text(),'Provider analyst')]";
    private static final String COC_WHO_CAN_APPROVE_TYPE_05_VAL = "PEM COC Who Can Approve Type 5_Role_//p[contains(text(),'Provider analyst')]/../../../../div[2]/descendant::p";
    private static final String COC_CONFIG_REVIEWERS_SW = "PEM COC Configure reviewers to vote for request approval_false_//h3[contains(text(),'Configure reviewers')]/../descendant::input";
    private static final String COC_ASSIGNEE_CONFIG_SW = "PEM COC Assignee Configuration_true_//h3[contains(text(),'Assignee')]/../../../div/div[3]/label/span/span/span/input[@type='checkbox']";
    private static final String COC_SYS_ASSIGNS_BACK_SW = "PEM COC System assigns back_true_//h3[contains(text(), 'System assigns back')]/../../..//input[@type='checkbox']";
    private static final String COC_SCREENING_CONFIG_SW = "PEM COC Screening Configuration_false_//h3[contains(text(), 'COC Screening Configuration')]/../../..//input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // SITE VISIT CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    // NOTE: Additional String Declarations can be copied from SOIndividualApprovals.java and updated for use in this
    // section as needed.
    //******************************************************************************************************************
    private static final String SITEVISIT_AUTO_APPROVE_SW = "PEM Site Visit Auto Approve_false_//input[@aria-label='Auto Switch']";
    private static final String SITEVISIT_NUM_APPROVALS_REQUIRED_VAL = "PEM Site Visit Number of approvals required_1_//h4[contains(text(),'Number of approvals')]/../span";
    private static final String SITEVISIT_WHO_CAN_APPROVE_01_VAL = "PEM Site Visit Who Can Approve 1_Provider supervisor_//p[contains(text(),'Provider supervisor')]";
    private static final String SITEVISIT_WHO_CAN_APPROVE_TYPE_01_VAL = "PEM Site Visit Who Can Approve Type 1_Role_//p[contains(text(),'Provider supervisor')]/../../../../div[2]/descendant::p";
    private static final String SITEVISIT_CONFIG_REVIEWERS_SW = "PEM Site Visit Configure reviewers to vote for request approval_false_//h3[contains(text(),'Configure reviewers')]/../descendant::input";
    private static final String SITEVISIT_ASSIGNEE_CONFIG_SW = "PEM Site Visit Assignee Configuration_false_//h3[contains(text(),'Assignee')]/../../../div/div[3]/label/span/span/span/input[@type='checkbox']";
    private static final String SITEVISIT_SIGNATURE_INTERNAL_USER_SW = "PEM Site Visit Signature from Internal user_true_//p[contains(text(),'signature from Internal user')]/../../../div/div[2]/label/span/span/span/input[@type='checkbox']";
    private static final String SITEVISIT_SIGNATURE_PROVIDER_SW = "PEM Site Visit Signature from Internal user_true_//p[contains(text(),'signature from Provider')]/../../../div/div[2]/label/span/span/span/input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // RE ENROLLMENT CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    // NOTE: Additional String Declarations can be copied from SOIndividualApprovals.java and updated for use in this
    // section as needed.
    //******************************************************************************************************************
    private static final String REENROLL_AUTO_APPROVE_SW = "PEM Re-enrollment required for TP providers_false_//input[@aria-label='Auto Switch']";

    /**
     * This method verifies the Approvals System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param dashboardPage DashBoardPage reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyApprovalsSO(WebDriver driver, DashboardPage dashboardPage, SoftAssert softAssert) {

        //Build a list of the Request types using REQUEST TYPES constants
        ArrayList<ArrayList<String>> requestTypeList = buildRequestTypeList();

        //Define empty configuration switch and configuration value lists
        ArrayList<ArrayList<String>> switchConfigurationList = null;
        ArrayList<ArrayList<String>> valueConfigurationList = null;

        //Parse the name of the configuration to be verified and the associated Xpath from the provider string
        String[] providerIdentifierStringParts = PROVIDER_IDENTIFIER.split(SEPARATOR);
        String providerConfiguration = providerIdentifierStringParts[0];
        String providerXPath = providerIdentifierStringParts[1];

        //Click the Provider displayed on 'Approval Configuration for' page
        clickApprovalConfigurationProvider(driver, providerXPath);

        //Iterate through the Request Type List
        for (ArrayList<String> requests : requestTypeList) {

            //Get the Request Type from the Request Type list
            String request = String.valueOf(requests.get(0));

            //Click the Request type
            dashboardPage.ajaxScrollUp();
            driver.findElement(By.xpath(XPATH_PREFIX + providerConfiguration + XPATH_MIDDLE + request + XPATH_SUFFIX)).click();

            switch (request) {
                case ENROLLMENT_REQUEST:
                case REVALIDATION_REQUEST:
                case RECONSIDERATION_REQUEST:
                case COC_REQUEST:
//                case SITE_VISIT_REQUEST: REMOVED FROM EXECUTION UNTIL CONFIGURATION IS FINALIZED
                case RE_ENROLLMENT_REQUEST:
                    Reports.log("\n********************************************************");
                    Reports.log("Approval Configurations: PEM " + request);
                    Reports.log("********************************************************");

                    //Build a list of SWITCH configuration parameters and expected values
                    switchConfigurationList = buildSwitchConfigurationList(request);

                    //Build a list of FIELD configuration parameters and expected values
                    valueConfigurationList = buildFieldConfigurationList(request);

                    //Verify SWITCH configuration parameters
                    //Reports.log("\nVerifying "+ request +" SWITCH configuration parameters");
                    verifyConfigurationParameters(driver, switchConfigurationList,CONFIGURATION_SWITCH, softAssert);

                    //Verify FIELD configuration parameters
                    //Reports.log("\nVerifying "+ request +" FIELD configuration parameters");
                    verifyConfigurationParameters(driver, valueConfigurationList, CONFIGURATION_VALUE, softAssert);
                    break;
            }

            //Navigate back to Approvals List
            dashboardPage.ajaxScrollUp();
            driver.findElement(By.xpath(BACK_TO_APPROVALS_LIST)).click();

            //Clear the SWITCH configuration parameter list
            if (switchConfigurationList != null) {
                switchConfigurationList.clear();
            }

            //Clear the FIELD configuration parameter list
            if (valueConfigurationList != null) {
                valueConfigurationList.clear();
            }
        }

        //Navigate back to Enrollment Types page
        dashboardPage.ajaxScrollUp();
        driver.findElement(By.xpath(BACK_TO_ENROLLMENT_TYPES)).click();
    }

    /**
     * This private method iterates through the Configurations list and verifies the associated value
     *
     * @param driver WebDriver reference variable
     * @param configurationList List containing the SWITCH and FIELD configuration xpaths and expected values
     */
    private void verifyConfigurationParameters(WebDriver driver, ArrayList<ArrayList<String>> configurationList, String configType, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Verify the configuration parameters associated with the Enrollment Type case
        for (ArrayList<String> stringArrayList : configurationList) {

            //Retrieve Configuration and expected value from the ArrayList
            String configurationString = String.valueOf(stringArrayList.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            configurationNameParse = configurationStringParts[0];
            expectedValueParse = configurationStringParts[1];
            xpathParse = configurationStringParts[2];

            //Compare expected and actual configuration values
            switch (configType) {
                case CONFIGURATION_SWITCH:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case  CONFIGURATION_VALUE:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This private method clicks the Provider displayed on 'Approval Configuration for' page
     */
    private void clickApprovalConfigurationProvider(WebDriver driver, String providerConfigXPath) {
        driver.findElement(By.xpath(providerConfigXPath)).click();
        driver.navigate().refresh();
    }

    /**
     * This private method builds a list of the Request types
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildRequestTypeList () {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(ENROLLMENT_REQUEST)));
        parameterList.add(new ArrayList<>(List.of(REVALIDATION_REQUEST)));
        parameterList.add(new ArrayList<>(List.of(RECONSIDERATION_REQUEST)));
        parameterList.add(new ArrayList<>(List.of(COC_REQUEST)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_REQUEST)));
        parameterList.add(new ArrayList<>(List.of(RE_ENROLLMENT_REQUEST)));

        return parameterList;
    }

    /**
     * This private method builds a list of the SWITCH configurations and expected values types
     *
     * @param request Used by the Case statements to determine which SWITCH parameters are added to the Parameter list
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildSwitchConfigurationList(String request) {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();

        switch (request) {
            case ENROLLMENT_REQUEST:
                parameterList.add(new ArrayList<>(List.of(ENROLL_AUTO_APPROVE_SW)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_CONFIG_CVO_SW)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_CONFIG_REVIEWERS_SW)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_REQUEST_STARTS_NEW_SW)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_ASSIGNEE_CONFIG_SW)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_SYS_ASSIGNS_BACK_SW)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_TEMP_APPROVAL_SW)));
                break;
            case REVALIDATION_REQUEST:
                parameterList.add(new ArrayList<>(List.of(REVAL_AUTO_APPROVE_SW)));
                parameterList.add(new ArrayList<>(List.of(REVAL_CONFIG_CVO_SW)));
                parameterList.add(new ArrayList<>(List.of(REVAL_CONFIG_REVIEWERS_SW)));
                parameterList.add(new ArrayList<>(List.of(REVAL_REQUEST_STARTS_NEW_SW)));
                parameterList.add(new ArrayList<>(List.of(REVAL_ASSIGNEE_CONFIG_SW)));
                parameterList.add(new ArrayList<>(List.of(REVAL_SYS_ASSIGNS_BACK_SW)));
                break;
            case RECONSIDERATION_REQUEST:
                parameterList.add(new ArrayList<>(List.of(RECON_AUTO_APPROVE_SW)));
                parameterList.add(new ArrayList<>(List.of(RECON_CONFIG_REVIEWERS_VOTE_SW)));
                parameterList.add(new ArrayList<>(List.of(RECON_ASSIGNEE_CONFIG_SW)));
//                parameterList.add(new ArrayList<>(List.of(RECON_SYS_ASSIGNS_BACK_SW)));
                break;
            case COC_REQUEST:
                parameterList.add(new ArrayList<>(List.of(COC_AUTO_APPROVE_SW)));
                parameterList.add(new ArrayList<>(List.of(COC_AUTO_APPROVE_AFFILIATION_SW)));
                parameterList.add(new ArrayList<>(List.of(COC_CONFIG_REVIEWERS_SW)));
                parameterList.add(new ArrayList<>(List.of(COC_ASSIGNEE_CONFIG_SW)));
                parameterList.add(new ArrayList<>(List.of(COC_SYS_ASSIGNS_BACK_SW)));
                parameterList.add(new ArrayList<>(List.of(COC_SCREENING_CONFIG_SW)));
                break;
            case SITE_VISIT_REQUEST:
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_AUTO_APPROVE_SW)));
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_CONFIG_REVIEWERS_SW)));
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_ASSIGNEE_CONFIG_SW)));
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_SIGNATURE_INTERNAL_USER_SW)));
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_SIGNATURE_PROVIDER_SW)));
                break;
            case RE_ENROLLMENT_REQUEST:
                parameterList.add(new ArrayList<>(List.of(REENROLL_AUTO_APPROVE_SW)));
                break;
        }
        return parameterList;
    }

    /**
     * This private method builds a list of the FIELD configurations and expected values types
     *
     * @param request Used by the Case statements to determine which FIELD configuration
     *                parameters are added to the Parameter list
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildFieldConfigurationList(String request) {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();

        switch (request) {
            case ENROLLMENT_REQUEST:
                parameterList.add(new ArrayList<>(List.of(ENROLL_NUM_APPROVALS_REQUIRED_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_TYPE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_TYPE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_03_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_TYPE_03_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_04_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_TYPE_04_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_05_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENROLL_WHO_CAN_APPROVE_TYPE_05_VAL)));
                break;
            case REVALIDATION_REQUEST:
                parameterList.add(new ArrayList<>(List.of(REVAL_NUM_APPROVALS_REQUIRED_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_TYPE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_TYPE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_03_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_TYPE_03_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_04_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_TYPE_04_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_05_VAL)));
                parameterList.add(new ArrayList<>(List.of(REVAL_WHO_CAN_APPROVE_TYPE_05_VAL)));
                break;
            case RECONSIDERATION_REQUEST:
                parameterList.add(new ArrayList<>(List.of(RECON_NUM_APPROVALS_REQUIRED_VAL)));
                parameterList.add(new ArrayList<>(List.of(RECON_WHO_CAN_APPROVE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(RECON_WHO_CAN_APPROVE_TYPE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(RECON_WHO_CAN_APPROVE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(RECON_WHO_CAN_APPROVE_TYPE_02_VAL)));
                break;
            case COC_REQUEST:
                parameterList.add(new ArrayList<>(List.of(COC_NUM_APPROVALS_REQUIRED_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_TYPE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_TYPE_02_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_03_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_TYPE_03_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_04_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_TYPE_04_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_05_VAL)));
                parameterList.add(new ArrayList<>(List.of(COC_WHO_CAN_APPROVE_TYPE_05_VAL)));
                break;
            case SITE_VISIT_REQUEST:
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_NUM_APPROVALS_REQUIRED_VAL)));
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_WHO_CAN_APPROVE_01_VAL)));
                parameterList.add(new ArrayList<>(List.of(SITEVISIT_WHO_CAN_APPROVE_TYPE_01_VAL)));
                break;
        }
        return parameterList;
    }
}
