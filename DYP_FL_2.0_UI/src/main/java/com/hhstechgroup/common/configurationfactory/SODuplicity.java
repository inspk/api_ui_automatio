package com.hhstechgroup.common.configurationfactory;

import com.hhstechgroup.common.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the system option configuration.
 */
public class SODuplicity extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";

    //******************************************************************************************************************
    //
    // CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String DUPLICITY_FIELD_PERCENTAGE_VALUE = "Cut Off Percentage Value_45_//div[contains(text(),'Cut Off Percentage')]/../div[2]/div/div";
    private static final String DUPLICITY_SWITCH_DUPLICITY_CHECK = "Duplicity Check _false_//div[contains(text(),'Duplicity Check')]/../div[2]/div/div/p/span/span/span/input[@type='checkbox']";
    private static final String DUPLICITY_FIELD_NPI_VALUE = "NPI Invalid Type/Deactivated Value_10_//div[contains(text(),'National Provider')]/../div[2]";
    private static final String DUPLICITY_FIELD_SSN_FEIN_VALUE = "SSN/FEIN Value_9_//div[contains(text(),'SSN / FEIN')]/../div[2]";
    private static final String DUPLICITY_FIELD_TAXONOMY_VALUE = "Taxonomy Value_7_//div[contains(text(),'Taxonomy')]/../div[2]";
    private static final String DUPLICITY_FIELD_DBA_VALUE = "Name/DBA Value_6_//div[contains(text(),'Name / Doing Business as (DBA)')]/../div[2]";
    private static final String DUPLICITY_FIELD_ZIP_VALUE = "Zip Value_6_//div[contains(text(),'Zip')]/../div[2]";
    private static final String DUPLICITY_FIELD_DOB_VALUE = "Date of Birth Value_7_//div[contains(text(),'Date of Birth')]/../div[2]";
    private static final String DUPLICITY_FIELD_DEA_VALUE = "DEA Number Value_3_//div[contains(text(),'DEA Number')]/../div[2]";

    /**
     * This method verifies the Duplicity System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyDuplicitySO(WebDriver driver, SoftAssert softAssert)  {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Duplicity Configuration");
        Reports.log("********************************************************");

        for (ArrayList<String> strings : parameterList) {

            //Retrieve Configuration and expected value from the ArrayList
            String configurationString = String.valueOf(strings.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            configurationNameParse = configurationStringParts[0];
            expectedValueParse = configurationStringParts[1];
            xpathParse = configurationStringParts[2];

            //Execute configuration verification cases
            switch (configurationString) {
                case DUPLICITY_SWITCH_DUPLICITY_CHECK:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case DUPLICITY_FIELD_PERCENTAGE_VALUE:
                case DUPLICITY_FIELD_NPI_VALUE:
                case DUPLICITY_FIELD_SSN_FEIN_VALUE:
                case DUPLICITY_FIELD_TAXONOMY_VALUE:
                case DUPLICITY_FIELD_DBA_VALUE:
                case DUPLICITY_FIELD_ZIP_VALUE:
                case DUPLICITY_FIELD_DOB_VALUE:
                case DUPLICITY_FIELD_DEA_VALUE:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;

            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyDuplicitySystemOptions()
     *
     * @return parameterList
     */
    public ArrayList<ArrayList<String>> buildParameterList () {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_PERCENTAGE_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_SWITCH_DUPLICITY_CHECK)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_NPI_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_SSN_FEIN_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_TAXONOMY_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_DBA_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_ZIP_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_DOB_VALUE)));
        parameterList.add(new ArrayList<>(List.of(DUPLICITY_FIELD_DEA_VALUE)));

        return parameterList;
    }

}
