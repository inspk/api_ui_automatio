package com.hhstechgroup.common.configurationfactory;

import com.hhstechgroup.Pages.DashboardPage;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the system option configuration.
 */
public class SORevalidation extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";
    private static final String CONFIGURATION_SWITCH  = "Switch";
    private static final String CONFIGURATION_VALUE  = "Field";

    //******************************************************************************************************************
    //
    //                                  MISC XPATH STRINGS DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String BACK_TO_ENROLLMENT_TYPES = "//h4[contains(text(),'Back to ')]";
    private static final String INDIVIDUAL_PROVIDERS = "Individual_(//i[contains(text(),'right')])[1]";
    private static final String ENTITY_PROVIDERS = "Entity_(//i[contains(text(),'right')])[2]";
    private static final String TRADING_PARTNER_PROVIDERS = "Trading Partner_(//i[contains(text(),'right')])[7]";
    private static final String PEM_PROVIDERS = "PEM_(//i[contains(text(),'right')])[5]";

    //******************************************************************************************************************
    //
    // INDIVIDUAL CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String INDIVIDUAL_REVALIDATION_SW = "Individual Revalidation Required for individual providers_true_//div[contains(text(),'Revalidation Required for')]/ancestor::div/div/div/label/span/span/span/input";
    private static final String INDIVIDUAL_REVALIDATION_BASIS_VAL = "Individual Revalidation Date basis_Enrollment Approved Date_//div[text()='Revalidation date basis']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String INDIVIDUAL_REVALIDATION_DATE_CALC_VAL = "Individual Revalidation date calculation_4_//div[text()='Revalidation date calculation']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String INDIVIDUAL_REVALIDATION_DATE_CALC_EXACT_DATE_SW = "Individual Date calculation Exact Date_true_(//div[@role = 'radiogroup']/label/span/span/input)[1]";
    private static final String INDIVIDUAL_REVALIDATION_DATE_CALC_END_OF_MONTH_SW = "Individual Date calculation End of Month_false_(//div[@role = 'radiogroup']/label/span/span/input)[2]";
    private static final String INDIVIDUAL_REVALIDATION_1ST_NOTIFICATION_VAL = "Individual 1st Notification Reminder_90_//div[text()='1st notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String INDIVIDUAL_REVALIDATION_2ND_NOTIFICATION_VAL = "Individual 2nd Notification Reminder_60_//div[text()='2nd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String INDIVIDUAL_REVALIDATION_3RD_NOTIFICATION_VAL = "Individual 3rd Notification Reminder_30_//div[text()='3rd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String INDIVIDUAL_REVALIDATION_OUTSTANDING_REVALIDATION_VAL = "Individual Group Outstanding Reminder_15_//div[text()='Group provider:outstanding revalidations']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String INDIVIDUAL_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL = "Individual After Revalidation Period_0_//div[text()='After revalidation period']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";

    //******************************************************************************************************************
    //
    // ENTITY CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String ENTITY_REVALIDATION_SW = "Entity Revalidation Required for individual providers _true_//div[contains(text(),'Revalidation Required for')]/ancestor::div/div/div/label/span/span/span/input";
    private static final String ENTITY_REVALIDATION_BASIS_VAL = "Entity Revalidation date basis_Enrollment Approved Date_//div[text()='Revalidation date basis']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String ENTITY_REVALIDATION_DATE_CALC_VAL = "Entity Revalidation date calculation_4_//div[text()='Revalidation date calculation']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String ENTITY_REVALIDATION_DATE_CALC_EXACT_DATE_SW = "Entity Date calculation Exact Date_true_(//div[@role = 'radiogroup']/label/span/span/input)[1]";
    private static final String ENTITY_REVALIDATION_DATE_CALC_END_OF_MONTH_SW = "Entity Date calculation End of Month_false_(//div[@role = 'radiogroup']/label/span/span/input)[2]";
    private static final String ENTITY_REVALIDATION_1ST_NOTIFICATION_VAL = "Entity 1st Notification Reminder_90_//div[text()='1st notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String ENTITY_REVALIDATION_2ND_NOTIFICATION_VAL = "Entity 2nd Notification Reminder_60_//div[text()='2nd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String ENTITY_REVALIDATION_3RD_NOTIFICATION_VAL = "Entity 3rd Notification Reminder_30_//div[text()='3rd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String ENTITY_REVALIDATION_OUTSTANDING_REVALIDATION_VAL = "Entity Group Outstanding Reminder_15_//div[text()='Group provider:outstanding revalidations']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String ENTITY_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL = "Entity After Revalidation Period_0_//div[text()='After revalidation period']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";

    //******************************************************************************************************************
    //
    // TRADING PARTNER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String TRADING_PARTNER_REVALIDATION_SW = "Trading Partner Revalidation Required for individual providers_true_//div[contains(text(),'Revalidation Required for')]/ancestor::div/div/div/label/span/span/span/input";
    private static final String TRADING_PARTNER_REVALIDATION_BASIS_VAL = "Trading Partner Revalidation date basis_Enrollment Approved Date_//div[text()='Revalidation date basis']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String TRADING_PARTNER_REVALIDATION_DATE_CALC_VAL = "Trading Partner Revalidation date calculation_4_//div[text()='Revalidation date calculation']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String TRADING_PARTNER_REVALIDATION_DATE_CALC_EXACT_DATE_SW = "Trading Partner Date calculation Exact Date_true_(//div[@role = 'radiogroup']/label/span/span/input)[1]";
    private static final String TRADING_PARTNER_REVALIDATION_DATE_CALC_END_OF_MONTH_SW = "Trading Partner Date calculation End of Month_false_(//div[@role = 'radiogroup']/label/span/span/input)[2]";
    private static final String TRADING_PARTNER_REVALIDATION_1ST_NOTIFICATION_VAL = "Trading Partner 1st Notification Reminder_90_//div[text()='1st notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String TRADING_PARTNER_REVALIDATION_2ND_NOTIFICATION_VAL = "Trading Partner 2nd Notification Reminder_60_//div[text()='2nd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String TRADING_PARTNER_REVALIDATION_3RD_NOTIFICATION_VAL = "Trading Partner 3rd Notification Reminder_30_//div[text()='3rd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String TRADING_PARTNER_REVALIDATION_OUTSTANDING_REVALIDATION_VAL = "Trading Partner Group Outstanding Reminder_0_//div[text()='Group provider:outstanding revalidations']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String TRADING_PARTNER_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL = "Trading Partner After Revalidation Period_30_//div[text()='After revalidation period']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";


    //******************************************************************************************************************
    //
    // PEM CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String PEM_REVALIDATION_SW = "PEM Revalidation Required for individual providers_true_//div[contains(text(),'Revalidation Required for')]/ancestor::div/div/div/label/span/span/span/input";
    private static final String PEM_REVALIDATION_BASIS_VAL = "PEM Revalidation date basis_Enrollment Approved Date_//div[text()='Revalidation date basis']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String PEM_REVALIDATION_DATE_CALC_VAL = "PEM Revalidation date calculation_3_//div[text()='Revalidation date calculation']/ancestor::div/div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String PEM_REVALIDATION_DATE_CALC_EXACT_DATE_SW = "PEM Date calculation Exact Date_true_(//div[@role = 'radiogroup']/label/span/span/input)[1]";
    private static final String PEM_REVALIDATION_DATE_CALC_END_OF_MONTH_SW = "PEM Date calculation End of Month_false_(//div[@role = 'radiogroup']/label/span/span/input)[2]";
    private static final String PEM_REVALIDATION_1ST_NOTIFICATION_VAL = "PEM 1st Notification Reminder_90_//div[text()='1st notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String PEM_REVALIDATION_2ND_NOTIFICATION_VAL = "PEM 2nd Notification Reminder_60_//div[text()='2nd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String PEM_REVALIDATION_3RD_NOTIFICATION_VAL = "PEM 3rd Notification Reminder_30_//div[text()='3rd notification']//following-sibling::div/div/div/div/div/div[@role = 'button']";
    private static final String PEM_REVALIDATION_OUTSTANDING_REVALIDATION_VAL = "PEM Group Outstanding Reminder_0_//div[text()='Group provider:outstanding revalidations']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";
    private static final String PEM_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL = "PEM After Revalidation Period_0_//div[text()='After revalidation period']//parent::div/../following-sibling::div/div/div/div/div/div/div/div[@role = 'button']";

    /**
     * This method verifies the Revalidations System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param dashboardPage DashBoardPage reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyRevalidationSO(WebDriver driver, DashboardPage dashboardPage, SoftAssert softAssert) {

        //Build a list of the Enrollment types
        //Reports.log("Building an Arraylist of Enrollment Types displayed on Revalidation Configuration For page");
        ArrayList<ArrayList<String>> enrollmentTypeList = new ArrayList<>();
        enrollmentTypeList.add(new ArrayList<>(List.of(INDIVIDUAL_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(ENTITY_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(TRADING_PARTNER_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(PEM_PROVIDERS)));

        //Create an empty ArrayList that will contain the configurations and expected values
        ArrayList<ArrayList<String>> switchConfigurationList = new ArrayList<>();
        ArrayList<ArrayList<String>> valueConfigurationList = new ArrayList<>();

        //Iterate through each Enrollment Type and verify the associated parameters using the Enrollment Types
        //ArrayList and the Configuration Parameters ArrayList
        for (ArrayList<String> strings : enrollmentTypeList) {

            //Get the Revalidation Configuration Enrollment Type read from the Enrollment Type ArrayList
            String enrollmentType = String.valueOf(strings.get(0));

            //Parse the name of the configuration to be verified and the associated Xpath from the provider string
            String[] providerIdentifierStringParts = enrollmentType.split(SEPARATOR);
            String enrollmentTypeParse = providerIdentifierStringParts[0];
            String xpathParse = providerIdentifierStringParts[1];

            //Click the Enrollment type
            javaWaitSec(2);
            driver.findElement(By.xpath(xpathParse)).click();

            //Build the configuration parameter lists based on the Enrollment Type
            switch (enrollmentType) {
                case INDIVIDUAL_PROVIDERS:
                case ENTITY_PROVIDERS:
                case TRADING_PARTNER_PROVIDERS:
                case PEM_PROVIDERS:
                    Reports.log("\n********************************************************");
                    Reports.log("Revalidation Configurations: " + enrollmentTypeParse);
                    Reports.log("********************************************************");

                    //Build a list of SWITCH configuration parameters and expected values
                    //Reports.log("\nBuild a list of SWITCH configuration parameters and expected values");
                    switchConfigurationList = buildSwitchConfigurationList(enrollmentType);

                    //Build a list of FIELD configuration parameters and expected values
                    //Reports.log("\nBuild a list of FIELD configuration parameters and expected values");
                    valueConfigurationList = buildFieldConfigurationList(enrollmentType);

                    //Verify SWITCH configuration parameters
                    //Reports.log("\nVerifying "+ enrollmentTypeParse +" SWITCH configuration parameters");
                    verifyConfigurationParameters(driver, switchConfigurationList,CONFIGURATION_SWITCH, softAssert);

                    //Verify FIELD configuration parameters
                    //Reports.log("\nVerifying "+ enrollmentTypeParse +" FIELD configuration parameters");
                    verifyConfigurationParameters(driver, valueConfigurationList, CONFIGURATION_VALUE, softAssert);

                break;
            }

            //Navigate back to Enrollment Types page
            dashboardPage.ajaxScrollUp();
            driver.findElement(By.xpath(BACK_TO_ENROLLMENT_TYPES)).click();

            //Clear the SWITCH and FIELD configuration parameter lists
            switchConfigurationList.clear();
            valueConfigurationList.clear();
        }
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
     * This private method builds a list of the SWITCH configurations and expected values types
     *
     * @param enrollmentType Used by the Case statements to determine which SWITCH parameters are added to the Parameter list
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildSwitchConfigurationList(String enrollmentType) {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();

        switch (enrollmentType) {
            case INDIVIDUAL_PROVIDERS:
                //Reports.log("\nBuild INDIVIDUAL list of SWITCH configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_SW)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_DATE_CALC_EXACT_DATE_SW)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_DATE_CALC_END_OF_MONTH_SW)));
                break;
            case ENTITY_PROVIDERS:
                //Reports.log("\nBuild ENTITY list of SWITCH configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_SW)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_DATE_CALC_EXACT_DATE_SW)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_DATE_CALC_END_OF_MONTH_SW)));
                break;
            case TRADING_PARTNER_PROVIDERS:
                //Reports.log("\nBuild TRADING PARTNER list of SWITCH configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_SW)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_DATE_CALC_EXACT_DATE_SW)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_DATE_CALC_END_OF_MONTH_SW)));
                break;
            case PEM_PROVIDERS:
                //Reports.log("\nBuild PEM list of SWITCH configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_SW)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_DATE_CALC_EXACT_DATE_SW)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_DATE_CALC_END_OF_MONTH_SW)));
                break;
        }
        return parameterList;
    }

    /**
     * This private method builds a list of the FIELD configurations and expected values types
     *
     * @param enrollmentType Used by the Case statements to determine which SWITCH parameters are added to the Parameter list
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildFieldConfigurationList(String enrollmentType) {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();

        switch (enrollmentType) {
            case INDIVIDUAL_PROVIDERS:
                //Reports.log("\nBuild INDIVIDUAL list of FIELD configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_BASIS_VAL)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_DATE_CALC_VAL)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_1ST_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_2ND_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_3RD_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_OUTSTANDING_REVALIDATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL)));
                break;
            case ENTITY_PROVIDERS:
                //Reports.log("\nBuild ENTITY list of FIELD configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_BASIS_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_DATE_CALC_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_1ST_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_2ND_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_3RD_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_OUTSTANDING_REVALIDATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(ENTITY_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL)));
                break;
            case TRADING_PARTNER_PROVIDERS:
                //Reports.log("\nBuild TRADING PARTNER list of FIELD configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_BASIS_VAL)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_DATE_CALC_VAL)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_1ST_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_2ND_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_3RD_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_OUTSTANDING_REVALIDATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(TRADING_PARTNER_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL)));
                break;
            case PEM_PROVIDERS:
                //Reports.log("\nBuild PEM list of FIELD configuration parameters and expected values");
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_BASIS_VAL)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_DATE_CALC_VAL)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_1ST_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_2ND_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_3RD_NOTIFICATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_OUTSTANDING_REVALIDATION_VAL)));
                parameterList.add(new ArrayList<>(List.of(PEM_REVALIDATION_AFTER_REVALIDATION_PERIOD_VAL)));
                break;
        }
        return parameterList;
    }
}