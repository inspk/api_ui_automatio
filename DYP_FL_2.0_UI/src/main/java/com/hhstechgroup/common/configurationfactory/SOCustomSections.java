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
public class SOCustomSections extends Configuration {

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
    private static final String CUSTOM_SECTIONS_INDIVIDUAL_PROVIDERS = "Individual_//h3[contains(text(),'Individual')]/../../div[2]/i[@class='material-icons']";
    private static final String CUSTOM_SECTIONS_GROUP_PROVIDERS = "Group_//h3[contains(text(),'Group')]/../../div[2]/i[@class='material-icons']";
    private static final String CUSTOM_SECTIONS_PEM_PROVIDERS = "PEM_//h3[contains(text(),'Provider Enrollment Manager')]/../../div[2]/i[@class='material-icons']";
    private static final String CUSTOM_SECTIONS_TRADING_PARTNERS_PROVIDERS = "Trading Partner_//h3[contains(text(),'Trading Partners')]/../../div[2]/i[@class='material-icons']";

    //******************************************************************************************************************
    //
    // INDIVIDUAL PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String CUSTOM_IND_ALL_SWITCH = "Individual All Sections_false_//div[contains(text(),'All sections')]/../div[2]/div/div/p/span/span/span/input[@type='checkbox']";
    private static final String CUSTOM_IND_SSL_SWITCH = "Individual Secondary Service Location_true_//div[contains(text(),'Secondary service location')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_IND_AFFILIATION_SWITCH = "Individual Affiliation_true_//div[contains(text(),'Affiliation')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_IND_PAYMENT_SWITCH = "Individual Payment_false_//div[contains(text(),'Payment')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_IND_PROVIDER_AGREE_SWITCH = "Individual Provider Agreement_true_//div[contains(text(),'Provider agreement')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_IND_HELLO_SIGN_SWITCH = "Individual Hello Sign_true_//div[contains(text(),'Hello sign')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_IND_SUMMARY_SWITCH = "Individual Summary_true_//div[contains(text(),'Summary')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // GROUP PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String CUSTOM_GRP_ALL_SWITCH = "Group All Sections_true_//div[contains(text(),'All sections')]/../div[2]/div/div/p/span/span/span/input[@type='checkbox']";
    private static final String CUSTOM_GRP_SSL_SWITCH = "Group Secondary Service Location_true_//div[contains(text(),'Secondary service location')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_GRP_AFFILIATION_SWITCH = "Group Affiliation_true_//div[contains(text(),'Affiliation')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_GRP_PAYMENT_SWITCH = "Group Payment_true_//div[contains(text(),'Payment')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_GRP_PROVIDER_AGREE_SWITCH = "Group Provider Agreement_true_//div[contains(text(),'Provider agreement')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_GRP_HELLO_SIGN_SWITCH = "Group Hello Sign_true_//div[contains(text(),'Hello sign')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_GRP_SUMMARY_SWITCH = "Group Summary_true_//div[contains(text(),'Summary')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // PEM PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String CUSTOM_PEM_ALL_SWITCH = "PEM All Sections_false_//div[contains(text(),'All sections')]/../div[2]/div/div/p/span/span/span/input[@type='checkbox']";
    private static final String CUSTOM_PEM_SSL_SWITCH = "PEM Secondary Service Location_false_//div[contains(text(),'Secondary service location')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_PEM_AFFILIATION_SWITCH = "PEM Affiliation_true_//div[contains(text(),'Affiliation')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_PEM_PAYMENT_SWITCH = "PEM Payment_false_//div[contains(text(),'Payment')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_PEM_PROVIDER_AGREE_SWITCH = "PEM Provider Agreement_false_//div[contains(text(),'Provider agreement')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_PEM_HELLO_SIGN_SWITCH = "PEM Hello Sign_true_//div[contains(text(),'Hello sign')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_PEM_SUMMARY_SWITCH = "PEM Summary_true_//div[contains(text(),'Summary')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";

    //******************************************************************************************************************
    //
    // TRADING PARTNER PROVIDER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string is
    // parsed using the '_' SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String CUSTOM_TP_ALL_SWITCH = "Trading Partners All Sections_false_//div[contains(text(),'All sections')]/../div[2]/div/div/p/span/span/span/input[@type='checkbox']";
    private static final String CUSTOM_TP_SSL_SWITCH = "Trading Partners Secondary Service Location_false_//div[contains(text(),'Secondary service location')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_TP_AFFILIATION_SWITCH = "Trading Partners Affiliation_true_//div[contains(text(),'Affiliation')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_TP_PAYMENT_SWITCH = "Trading Partners Payment_false_//div[contains(text(),'Payment')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_TP_PROVIDER_AGREE_SWITCH = "TTrading Partners Provider Agreement_true_//div[contains(text(),'Provider agreement')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_TP_HELLO_SIGN_SWITCH = "Trading Partners Hello Sign_true_//div[contains(text(),'Hello sign')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";
    private static final String CUSTOM_TP_SUMMARY_SWITCH = "Trading Partners Summary_true_//div[contains(text(),'Summary')]/../div[2]/div/div/p/span[1]/span/span/input[@type='checkbox']";

    /**
     * This method verifies the Custom Sections System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param dashboardPage DashBoardPage reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyCustomSectionsSO(WebDriver driver, DashboardPage dashboardPage, SoftAssert softAssert) {

        String xpathParse;
        String enrollmentTypeXpathParse;
        String enrollmentTypeParse;
        String configurationNameParse;
        String expectedValueParse;

        //Build a list of the Custom Sections Enrollment types to be selected
        //Reports.log("Building an Arraylist of Enrollment Types displayed on Custom Sections Configuration For page");
        ArrayList<ArrayList<String>> enrollmentTypeList = new ArrayList<>();
        enrollmentTypeList.add(new ArrayList<>(List.of(CUSTOM_SECTIONS_INDIVIDUAL_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(CUSTOM_SECTIONS_GROUP_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(CUSTOM_SECTIONS_PEM_PROVIDERS)));
        enrollmentTypeList.add(new ArrayList<>(List.of(CUSTOM_SECTIONS_TRADING_PARTNERS_PROVIDERS)));

        //Create an empty ArrayList that will contain the configurations and expected values
        ArrayList<ArrayList<String>> configurationList = new ArrayList<>();

        //Iterate through each Enrollment Type and verify the associated parameters using the Enrollment Types
        //ArrayList and the Configuration Parameters ArrayList
        for (ArrayList<String> strings : enrollmentTypeList) {

            //Get the Custom Sections Configuration Enrollment Type read from the Enrollment Type ArrayList
            String enrollmentType = String.valueOf(strings.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] enrollmentTypeStringParts = enrollmentType.split(SEPARATOR);
            enrollmentTypeParse = enrollmentTypeStringParts[0];
            enrollmentTypeXpathParse = enrollmentTypeStringParts[1];

            Reports.log("\n********************************************************");
            Reports.log("Custom Sections Configuration: "+ enrollmentTypeParse);
            Reports.log("********************************************************");

            //Build the configuration parameter lists based on the Enrollment Type
            switch (enrollmentType) {
                case CUSTOM_SECTIONS_INDIVIDUAL_PROVIDERS:
                    //Reports.log("\nCase: CUSTOM_SECTIONS_INDIVIDUAL_PROVIDERS");
                    //Add the Individual configuration parameters and expected values to the empty ArrayList
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_ALL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_SSL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_AFFILIATION_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_PAYMENT_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_PROVIDER_AGREE_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_HELLO_SIGN_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_IND_SUMMARY_SWITCH)));

                    break;
                case CUSTOM_SECTIONS_GROUP_PROVIDERS:
                    //Add the Group configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: CUSTOM_SECTIONS_GROUP_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_ALL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_SSL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_AFFILIATION_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_PAYMENT_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_PROVIDER_AGREE_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_HELLO_SIGN_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_GRP_SUMMARY_SWITCH)));
                    break;
                case CUSTOM_SECTIONS_PEM_PROVIDERS:
                    //Add the PEM configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: CUSTOM_SECTIONS_PEM_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_ALL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_SSL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_AFFILIATION_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_PAYMENT_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_PROVIDER_AGREE_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_HELLO_SIGN_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_PEM_SUMMARY_SWITCH)));
                    break;
                case CUSTOM_SECTIONS_TRADING_PARTNERS_PROVIDERS:
                    //Add the Trading Partner configuration parameters and expected values to the empty ArrayList
                    //Reports.log("\nCase: CUSTOM_SECTIONS_TRADING_PARTNERS_PROVIDERS");
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_ALL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_SSL_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_AFFILIATION_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_PAYMENT_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_PROVIDER_AGREE_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_HELLO_SIGN_SWITCH)));
                    configurationList.add(new ArrayList<>(List.of(CUSTOM_TP_SUMMARY_SWITCH)));
                    break;
            }

            //Click the Enrollment Type displayed on 'Custom Sections Configuration for' page and refresh the page
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
