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
public class SOAffiliations extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";

    //******************************************************************************************************************
    //
    //                                  MISC XPATH STRINGS DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String BACK_TO_ENROLLMENT_TYPES = "//h4[contains(text(),'Back to ')]";
    private static final String AFFILIATION_INDIVIDUAL_PROVIDERS = "Individual_//h3[contains(text(),'Individual')]/../../div[2]/i[@class='material-icons']";
    private static final String AFFILIATION_GROUP_PROVIDERS = "Group_//h3[contains(text(),'Group')]/../../div[2]/i[@class='material-icons']";
    private static final String AFFILIATION_PEM_PROVIDERS = "PEM_//h3[contains(text(),'Provider Enrollment Manager')]/../../div[2]/i[@class='material-icons']";
    private static final String AFFILIATION_TRADING_PARTNERS_PROVIDERS = "Trading Partner_//h3[contains(text(),'Trading Partners')]/../../div[2]/i[@class='material-icons']";

    //******************************************************************************************************************
    //
    // INDIVIDUAL PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String AFF_IND_FAC_SWITCH_TYPE = "Individual to Facility Allowed Types_false_//div[contains(text(),'Individual to Facility')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_FAC_SWITCH_SIG = "Individual to Facility Signature Required_false_//div[contains(text(),'Individual to Facility')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_IND_ORP_SWITCH_TYPE = "Individual to ORP Allowed Types_false_//div[contains(text(),'Individual to ORP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_ORP_SWITCH_SIG = "Individual to ORP Signature Required_false_//div[contains(text(),'Individual to ORP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_IND_PHA_SWITCH_TYPE = "Individual to Pharmacy Allowed Types_false_//div[contains(text(),'Individual to Pharmacy')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_PHA_SWITCH_SIG = "Individual to Pharmacy Signature Required_false_//div[contains(text(),'Individual to Pharmacy')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_IND_PEM_SWITCH_TYPE = "Individual to PEM Allowed Types_true_//div[contains(text(),'Individual to PEM')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_PEM_SWITCH_SIG = "Individual to PEM Signature Required_true_//div[contains(text(),'Individual to PEM')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_IND_TP_SWITCH_TYPE = "Individual to TP Allowed Types_true_//div[contains(text(),'Individual to TP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_TP_SWITCH_SIG = "Individual to TP Signature Required_true_//div[contains(text(),'Individual to TP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_IND_GRP_SWITCH_TYPE = "Individual to Group Allowed Types_true_//div[contains(text(),'Individual to Group')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_GRP_SWITCH_SIG = "Individual to Group Signature Required_true_//div[contains(text(),'Individual to Group')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_IND_IND_SWITCH_TYPE = "Individual to Individual Allowed Types_false_//div[contains(text(),'Individual to Individual')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_IND_IND_SWITCH_SIG = "Individual to Individual Signature Required_false_//div[contains(text(),'Individual to Individual')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // GROUP PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String AFF_GRP_FAC_SWITCH_TYPE = "Group to Facility Allowed Types_false_//div[contains(text(),'Group to Facility')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_FAC_SWITCH_SIG = "Group to Facility Signature Required_false_//div[contains(text(),'Group to Facility')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_ORP_SWITCH_TYPE = "Group to ORP Allowed Types_false_//div[contains(text(),'Group to ORP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_ORP_SWITCH_SIG = "Group to ORP Signature Required_false_//div[contains(text(),'Group to ORP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_PHA_SWITCH_TYPE = "Group to Pharmacy Allowed Types_false_//div[contains(text(),'Group to Pharmacy')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_PHA_SWITCH_SIG = "Group to Pharmacy Signature Required_false_//div[contains(text(),'Group to Pharmacy')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_PEM_SWITCH_TYPE = "Group to PEM Allowed Types_true_//div[contains(text(),'Group to PEM')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_PEM_SWITCH_SIG = "Group to PEM Signature Required_true_//div[contains(text(),'Group to PEM')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_TP_SWITCH_TYPE = "Group to TP Allowed Types_true_//div[contains(text(),'Group to TP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_TP_SWITCH_SIG = "Group to TP Signature Required_true_//div[contains(text(),'Group to TP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_GRP_SWITCH_TYPE = "Group to Group Allowed Types_false_//div[contains(text(),'Group to Group')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_GRP_SWITCH_SIG = "Group to Group Signature Required_false_//div[contains(text(),'Group to Group')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_IND_SWITCH_TYPE = "Group to Individual Allowed Types_true_//div[contains(text(),'Group to Individual')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_GRP_IND_SWITCH_SIG = "Group to Individual Signature Required_true_//div[contains(text(),'Group to Individual')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // PEM PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String AFF_PEM_FAC_SWITCH_TYPE = "PEM to Facility Allowed Types_false_//div[contains(text(),'PEM to Facility')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_FAC_SWITCH_SIG = "PEM to Facility Signature Required_false_//div[contains(text(),'PEM to Facility')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_ORP_SWITCH_TYPE = "PEM to ORP Allowed Types_false_//div[contains(text(),'PEM to ORP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_ORP_SWITCH_SIG = "PEM to ORP Signature Required_false_//div[contains(text(),'PEM to ORP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_PHA_SWITCH_TYPE = "PEM to Pharmacy Allowed Types_false_//div[contains(text(),'PEM to Pharmacy')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_PHA_SWITCH_SIG = "PEM to Pharmacy Signature Required_false_//div[contains(text(),'PEM to Pharmacy')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_PEM_SWITCH_TYPE = "PEM to PEM Allowed Types_true_//div[contains(text(),'PEM to PEM')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_PEM_SWITCH_SIG = "PEM to PEM Signature Required_true_//div[contains(text(),'PEM to PEM')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_TP_SWITCH_TYPE = "PEM to TP Allowed Types_false_//div[contains(text(),'PEM to TP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_TP_SWITCH_SIG = "PEM to TP Signature Required_false_//div[contains(text(),'PEM to TP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_GRP_SWITCH_TYPE = "PEM to Group Allowed Types_true_//div[contains(text(),'PEM to Group')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_GRP_SWITCH_SIG = "PEM to Group Signature Required_true_//div[contains(text(),'PEM to Group')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_IND_SWITCH_TYPE = "PEM to Individual Allowed Types_true_//div[contains(text(),'PEM to Individual')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_IND_SWITCH_SIG = "PEM to Individual Signature Required_true_//div[contains(text(),'PEM to Individual')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_PEM_AUTO_SWITCH_SIG = "PEM Auto affiliation with Individual Provider_true_//input[@aria-label='Enable Auto Affiliation Switch']";

    //******************************************************************************************************************
    //
    // TRADING PARTNER PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String AFF_TP_FAC_SWITCH_TYPE = "TP to Facility Allowed Types_false_//div[contains(text(),'TP to Facility')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_FAC_SWITCH_SIG = "TP to Facility Signature Required_false_//div[contains(text(),'TP to Facility')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_TP_ORP_SWITCH_TYPE = "TP to ORP Allowed Types_false_//div[contains(text(),'TP to ORP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_ORP_SWITCH_SIG = "TP to ORP Signature Required_false_//div[contains(text(),'TP to ORP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_TP_PHA_SWITCH_TYPE = "TP to Pharmacy Allowed Types_false_//div[contains(text(),'TP to Pharmacy')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_PHA_SWITCH_SIG = "TP to Pharmacy Signature Required_false_//div[contains(text(),'TP to Pharmacy')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_TP_PEM_SWITCH_TYPE = "TP to PEM Allowed Types_false_//div[contains(text(),'TP to PEM')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_PEM_SWITCH_SIG = "TP to PEM Signature Required_false_//div[contains(text(),'TP to PEM')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_TP_TP_SWITCH_TYPE = "TP to TP Allowed Types_false_//div[contains(text(),'TP to TP')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_TP_SWITCH_SIG = "TP to TP Signature Required_false_//div[contains(text(),'TP to TP')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_TP_GRP_SWITCH_TYPE = "TP to Group Allowed Types_true_//div[contains(text(),'TP to Group')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_GRP_SWITCH_SIG = "TP to Group Signature Required_true_//div[contains(text(),'TP to Group')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String AFF_TP_IND_SWITCH_TYPE = "TP to Individual Allowed Types_true_//div[contains(text(),'TP to Individual')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String AFF_TP_IND_SWITCH_SIG = "TP to Individual Signature Required_true_//div[contains(text(),'TP to Individual')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";

    /**
     * This method verifies the Affiliations System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param dashboardPage DashBoardPage reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyAffiliationsSO(WebDriver driver, DashboardPage dashboardPage, SoftAssert softAssert) {

        String xpathParse;
        String enrollmentTypeXpathParse;
        String enrollmentTypeParse;
        String configurationNameParse;
        String expectedValueParse;

        //Build a list of the Affiliation Enrollment types to be selected
        //Reports.log("Building an Arraylist of Enrollment Types displayed on Affiliation Configuration For page");
        ArrayList<ArrayList<String>> enrollmentTypeList = new ArrayList<>();
        enrollmentTypeList.add(new ArrayList<>(List.of(AFFILIATION_INDIVIDUAL_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(AFFILIATION_GROUP_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(AFFILIATION_PEM_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(AFFILIATION_TRADING_PARTNERS_PROVIDERS)));

        //Create an empty ArrayList that will contain the configurations and expected values
        ArrayList<ArrayList<String>> configurationList = new ArrayList<>();

        //Iterate through each Enrollment Type and verify the associated parameters using the Enrollment Types
        //ArrayList and the Configuration Parameters ArrayList
        for (ArrayList<String> strings : enrollmentTypeList) {

            //Get the Affiliation Configuration Enrollment Type read from the Enrollment Type ArrayList
            String enrollmentType = String.valueOf(strings.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] enrollmentTypeStringParts = enrollmentType.split(SEPARATOR);
            enrollmentTypeParse = enrollmentTypeStringParts[0];
            enrollmentTypeXpathParse = enrollmentTypeStringParts[1];

            Reports.log("\n********************************************************");
            Reports.log("Affiliation Configuration: "+ enrollmentTypeParse);
            Reports.log("********************************************************");


            //Build the configuration parameter lists based on the Enrollment Type
            switch (enrollmentType) {
                case AFFILIATION_INDIVIDUAL_PROVIDERS:
                    //Add the Individual configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: AFFILIATION_INDIVIDUAL_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_FAC_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_FAC_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_ORP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_ORP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_PHA_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_PHA_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_PEM_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_PEM_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_TP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_TP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_GRP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_GRP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_IND_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_IND_IND_SWITCH_SIG)));
                    break;
                case AFFILIATION_GROUP_PROVIDERS:
                    //Add the Group configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: AFFILIATION_GROUP_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_FAC_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_FAC_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_ORP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_ORP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_PHA_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_PHA_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_PEM_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_PEM_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_TP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_TP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_GRP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_GRP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_IND_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_GRP_IND_SWITCH_SIG)));
                    break;
                case AFFILIATION_PEM_PROVIDERS:
                    //Add the PEM configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: AFFILIATION_PEM_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_FAC_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_FAC_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_ORP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_ORP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_PHA_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_PHA_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_PEM_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_PEM_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_TP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_TP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_GRP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_GRP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_IND_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_IND_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_PEM_AUTO_SWITCH_SIG)));
                    break;
                case AFFILIATION_TRADING_PARTNERS_PROVIDERS:
                    //Add the Trading Partner configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: AFFILIATION_TRADING_PARTNERS_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_FAC_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_FAC_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_ORP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_ORP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_PHA_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_PHA_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_PEM_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_PEM_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_TP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_TP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_GRP_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_GRP_SWITCH_SIG)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_IND_SWITCH_TYPE)));
                    configurationList.add(new ArrayList<>(List.of(AFF_TP_IND_SWITCH_SIG)));
                    break;
            }

            //Click the Enrollment Type displayed on 'Affiliation Configuration for' page and refresh the page
            driver.findElement(By.xpath(enrollmentTypeXpathParse)).click();
            driver.navigate().refresh();

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
                booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
            }

            //Navigate back to Enrollment Types
            dashboardPage.ajaxScrollUp();
            driver.findElement(By.xpath(BACK_TO_ENROLLMENT_TYPES)).click();

            //Clear the Arraylist
            configurationList.clear();
        }
    }
}
