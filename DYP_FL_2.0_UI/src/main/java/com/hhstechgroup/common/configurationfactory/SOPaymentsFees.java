package com.hhstechgroup.common.configurationfactory;

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
public class SOPaymentsFees extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String EXPECTED_VALUE_PARSE_TRUE = "true";
    private static final String EXPECTED_VALUE_PARSE_FALSE = "false";

    //******************************************************************************************************************
    //
    //                                  MISC XPATH STRINGS DECLARATIONS
    //
    //******************************************************************************************************************
    private static final By ENTITY_EDIT_BUTTON_XPATH = By.xpath("(//span[contains(text(), 'Edit')])[2]");

    //******************************************************************************************************************
    //
    // CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String INDIVIDUAL_ENROLLMENT_FEE_SWITCH = "Collect Fees For Individual Provider Enrollment Switch_false_//span[text()='Collect Fees For Individual Provider Enrollment']/ancestor::label/span/span/span/input";
    private static final String FACILITY_ENROLLMENT_FEE_SWITCH = "Collect Fees For Facility Provider Enrollment Switch_false_//span[text()='Collect Fees For Facility Provider Enrollment']/ancestor::label/span/span/span/input";
    private static final String PHARMACY_ENROLLMENT_FEE_SWITCH = "Collect Fees For Pharmacy Enrollment Switch_false_//span[text()='Collect Fees For Pharmacy Enrollment']/ancestor::label/span/span/span/input";
    private static final String PEM_ENROLLMENT_FEE_SWITCH = "Collect Fees For Provider Enrollment Manager Enrollment Switch_false_//span[text()='Collect Fees For Provider Enrollment Manager Enrollment']/ancestor::label/span/span/span/input";
    private static final String ORP_ENROLLMENT_FEE_SWITCH = "Collect Fees For Ordering/Referring/Prescribing Provider Enrollment Switch_false_//span[text()='Collect Fees For Ordering/Referring/Prescribing Provider Enrollment']/ancestor::label/span/span/span/input";
    private static final String TP_ENROLLMENT_FEE_SWITCH = "Collect Fees For Trading Partner Enrollment Switch_false_//span[text()='Collect Fees For Trading Partner Enrollment']/ancestor::label/span/span/span/input";
    private static final String ENTITY_ENROLLMENT_FEE_SWITCH = "Collect Fees For Group Provider Enrollment Switch_true_//span[text()='Collect Fees For Group Provider Enrollment']/ancestor::label/span/span/span/input";
    private static final String ENTITY_PAYMENT_TYPE_FOR_ENROLLMENT_FEES = "Entity Enrollment Online Payment_false_(//span[text()='Enable Online Payment'])[1]//ancestor::label/span/span/input";
    private static final String ENTITY_PAYMENT_TYPE_FOR_IN_STATE_FEES = "Entity In-State Online Payment_false_(//span[text()='Enable Online Payment'])[2]//ancestor::label/span/span/input";
    private static final String ENTITY_PAYMENT_TYPE_FOR_OUT_OF_STATE_FEES = "Entity Out-of-State Online Payment_false_(//span[text()='Enable Online Payment'])[3]//ancestor::label/span/span/input";
    private static final String ENTITY_ENROLLMENT_FEES_CHARGED = "Entity Enrollment Fees Charged_0_(//input[contains(@id,'group-amount')])[1]";
    private static final String ENTITY_IN_STATE_FEES_CHARGED = "Entity In-State Fee Charged_688_(//input[contains(@id,'group-amount')])[2]";
    private static final String ENTITY_OUT_OF_STATE_FEES_CHARGED = "Entity Out-of-State Charged_688_(//input[contains(@id,'group-amount')])[3]";

    /**
     * This method verifies the Payment Fees System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyPaymentsFeesSO(WebDriver driver, SoftAssert softAssert) {

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Payment and Fees Configuration");
        Reports.log("********************************************************");

        for (ArrayList<String> stringArrayList : parameterList) {

            //Retrieve arraylist values
            String configurationString = String.valueOf(stringArrayList.get(0));

            //Parse the name of the configuration to be verified, expected value and the associated Xpath
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            String configurationNameParse = configurationStringParts[0];
            String expectedValueParse = configurationStringParts[1];
            String xpathParse = configurationStringParts[2];

            switch (configurationString) {
                case INDIVIDUAL_ENROLLMENT_FEE_SWITCH:
                case FACILITY_ENROLLMENT_FEE_SWITCH:
                case PHARMACY_ENROLLMENT_FEE_SWITCH:
                case PEM_ENROLLMENT_FEE_SWITCH:
                case ORP_ENROLLMENT_FEE_SWITCH:
                case TP_ENROLLMENT_FEE_SWITCH:
                case ENTITY_ENROLLMENT_FEE_SWITCH:
                    //Verify configuration parameters
                    //Reports.log("\nVerifying configuration parameters");
                    verifyConfigurationParameters(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This private method iterates through the Configurations list and verifies the main swicth configuration and
     * edit configuration values
     *
     * @param driver WebDriver reference variable
     * @param xpathParse Parsed Xpath value
     * @param expectedValueParse Parsed expected value
     * @param configurationNameParse Parsed configuration name value
     * @param softAssert SoftAssert reference variable
     *
     */
    private void verifyConfigurationParameters(WebDriver driver, String xpathParse, String expectedValueParse, String configurationNameParse, SoftAssert softAssert) {

        switch (expectedValueParse){
            case EXPECTED_VALUE_PARSE_FALSE:
                //Verify DISABLED configuration parameters
                //Reports.log("\nVerifying DISABLED configuration parameters");
                booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                break;
            case EXPECTED_VALUE_PARSE_TRUE:
                //Verify ENABLED and EDIT configuration parameters
                //Reports.log("\nVerifying DISABLED configuration parameters");
                booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                verifyEditConfigurationParameters(driver, softAssert);
            break;
        }
    }

    /**
     * This private method iterates through the Edit Configurations list and verifies the associated value
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    private void verifyEditConfigurationParameters(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //build the parameter list of things to verify when clicking the Edit button
        ArrayList<ArrayList<String>> configurationEditList = buildParameterEditList();

        //click Edit button and verify the configuration and verify the values
        driver.findElement(ENTITY_EDIT_BUTTON_XPATH).click();

        //Verify the configuration parameters associated with the Enrollment Type case
        for (ArrayList<String> stringArrayList : configurationEditList){

            //Retrieve EDIT Configuration and expected value from the ArrayList
            String configurationString = String.valueOf(stringArrayList.get(0));

            //Parse the name of the configuration to be verified, expected value and the associated Xpath
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            configurationNameParse = configurationStringParts[0];
            expectedValueParse = configurationStringParts[1];
            xpathParse = configurationStringParts[2];

            switch (configurationString){
                case ENTITY_PAYMENT_TYPE_FOR_ENROLLMENT_FEES:
                case ENTITY_PAYMENT_TYPE_FOR_IN_STATE_FEES:
                case ENTITY_PAYMENT_TYPE_FOR_OUT_OF_STATE_FEES:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case ENTITY_ENROLLMENT_FEES_CHARGED:
                case ENTITY_IN_STATE_FEES_CHARGED:
                case ENTITY_OUT_OF_STATE_FEES_CHARGED:
                    stringTextCompareWithAttribute(driver, xpathParse, ATTRIBUTE_VALUE, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyPaymentsFeesSO()
     *
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildParameterList() {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_ENROLLMENT_FEE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(FACILITY_ENROLLMENT_FEE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PHARMACY_ENROLLMENT_FEE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PEM_ENROLLMENT_FEE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(ORP_ENROLLMENT_FEE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(TP_ENROLLMENT_FEE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(ENTITY_ENROLLMENT_FEE_SWITCH)));
        return parameterList;
    }

    /**
     * This method builds an Arraylist of EDIT configuration XPath/Expected Values used by verifyPaymentsFeesSO()
     *
     * @return parameterEditList
     */
    private ArrayList<ArrayList<String>> buildParameterEditList() {

        ArrayList<ArrayList<String>> parameterEditList = new ArrayList<>();
        parameterEditList.add(new ArrayList<>(List.of(ENTITY_PAYMENT_TYPE_FOR_ENROLLMENT_FEES)));
        parameterEditList.add(new ArrayList<>(List.of(ENTITY_PAYMENT_TYPE_FOR_IN_STATE_FEES)));
        parameterEditList.add(new ArrayList<>(List.of(ENTITY_PAYMENT_TYPE_FOR_OUT_OF_STATE_FEES)));
        parameterEditList.add(new ArrayList<>(List.of(ENTITY_ENROLLMENT_FEES_CHARGED)));
        parameterEditList.add(new ArrayList<>(List.of(ENTITY_IN_STATE_FEES_CHARGED)));
        parameterEditList.add(new ArrayList<>(List.of(ENTITY_OUT_OF_STATE_FEES_CHARGED)));
        return parameterEditList;
    }
}

