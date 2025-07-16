package com.hhstechgroup.common.configurationfactory;

import com.hhstechgroup.common.Reports;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the system option configuration.
 */
public class SOScreening extends Configuration {

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
    private static final String SCREENING_ALLOW_PERIODIC_MONITORING = "Allow Periodic Monitoring_false_//input[@aria-label='Monitoring Frequency']";
    private static final String SCREENING_CUSTOM_SCREENING_THRESHOLDS = "Custom Screening Threshold_true_//*[contains(@class,'radio-group')]/label[2]/span/span/input";
    private static final String SCREENING_FIELD_NPI_INVALID_VALUE = "NPI Invalid Type/Deactivated Value_10_//div[contains(text(),'NPI invalid')]/../div[2]";
    private static final String SCREENING_SWITCH_NPI_INVALID_AUTO = "NPI Invalid Type/Deactivated Auto Deny_true_//div[contains(text(),'NPI invalid')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_NPI_INVALID_MANUAL = "NPI Invalid Type/Deactivated Manual_false_//div[contains(text(),'NPI invalid')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_NPI_ENUM_VALUE = "NPI Enumeration Timing Value_2_//div[contains(text(),'NPI enumeration')]/../div[2]";
    private static final String SCREENING_SWITCH_NPI_ENUM_AUTO = "NPI Enumeration Timing Auto Deny_false_//div[contains(text(),'NPI enumeration')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_NPI_ENUM_MANUAL = "NPI Enumeration Timing Manual_true_//div[contains(text(),'NPI enumeration')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_FEIN_VALUE = "FEIN Invalid Value_10_//div[contains(text(),'FEIN invalid')]/../div[2]";
    private static final String SCREENING_SWITCH_FEIN_AUTO = "FEIN Invalid Auto Deny_true_//div[contains(text(),'FEIN invalid')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_FEIN_MANUAL = "FEIN Invalid Manual_false_//div[contains(text(),'FEIN invalid')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_NAME_MISMATCH_VALUE = "Name Mismatch Value_3_//div[contains(text(),'Name mismatch')]/../div[2]";
    private static final String SCREENING_SWITCH_NAME_MISMATCH_AUTO = "Name Mismatch Auto Deny_false_//div[contains(text(),'Name mismatch')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_NAME_MISMATCH_MANUAL = "Name Mismatch Manual_false_//div[contains(text(),'Name mismatch')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_LICENSE_INVALID_VALUE = "License/Certificate Invalid Value_10_//div[contains(text(),'License/Certificate # invalid')]/../div[2]";
    private static final String SCREENING_SWITCH_LICENSE_INVALID_AUTO = "License/Certificate Invalid Auto Deny_false_//div[contains(text(),'License/Certificate # invalid')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_LICENSE_INVALID_MANUAL = "License/Certificate Invalid Manual_false_//div[contains(text(),'License/Certificate # invalid')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_LICENSE_EXPIRED_VALUE = "License/Certificate Expired Value_9_//div[contains(text(),'License/Certificate expired/invalid type')]/../div[2]";
    private static final String SCREENING_SWITCH_LICENSE_EXPIRED_AUTO = "License/Certificate Expired Auto Deny_false_//div[contains(text(),'License/Certificate expired/invalid type')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_LICENSE_EXPIRED_MANUAL = "License/Certificate Expired Manual_false_//div[contains(text(),'License/Certificate expired/invalid type')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_LICENSE_ISSUER_VALUE = "License Issuer Value_4_//div[contains(text(),'License issuer/location mismatch')]/../div[2]";
    private static final String SCREENING_SWITCH_LICENSE_ISSUER_AUTO = "License Issuer Auto Deny_false_//div[contains(text(),'License issuer/location mismatch')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_LICENSE_ISSUER_MANUAL = "License Issuer Expired Manual_false_//div[contains(text(),'License issuer/location mismatch')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_CLIA_VALUE = "CLIA Value_9_//div[contains(text(),'CLIA # invalid/expired')]/../div[2]";
    private static final String SCREENING_SWITCH_CLIA_AUTO = "CLIA Auto Deny_false_//div[contains(text(),'CLIA # invalid/expired')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_CLIA_MANUAL = "CLIA Manual_true_//div[contains(text(),'CLIA # invalid/expired')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_DEA_VALUE = "DEA Value_9_//div[contains(text(),'DEA')]/../div[2]";
    private static final String SCREENING_SWITCH_DEA_AUTO = "DEA Auto Deny_false_//div[contains(text(),'DEA')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_DEA_MANUAL = "DEA Manual_true_//div[contains(text(),'DEA')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_DMF_VALUE = "Death checks (DMF & other sources) Value_10_//div[contains(text(),'DMF')]/../div[2]";
    private static final String SCREENING_SWITCH_DMF_AUTO = "Death checks (DMF & other sources) Auto Deny_true_//div[contains(text(),'DMF')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_DMF_MANUAL = "Death checks (DMF & other sources) Manual_false_//div[contains(text(),'DMF')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_OIG_LEIE_VALUE = "Excluded Individuals/Entities (OIG LEIE) Value_10_//div[contains(text(),'Excluded Individuals/Entities (OIG LEIE)')]/../div[2]";
    private static final String SCREENING_SWITCH_OIG_LEIE_AUTO = "Excluded Individuals/Entities (OIG LEIE) Auto Deny_false_//div[contains(text(),'Excluded Individuals/Entities (OIG LEIE)')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_OIG_LEIE_MANUAL = "Excluded Individuals/Entities (OIG LEIE) Manual_true_//div[contains(text(),'Excluded Individuals/Entities (OIG LEIE)')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_SAM_VALUE = "System for Award Management (SAM) Value_10_//div[contains(text(),'Award Management (SAM)')]/../div[2]";
    private static final String SCREENING_SWITCH_SAM_AUTO = "System for Award Management (SAM) Auto Deny_false_//div[contains(text(),'Award Management (SAM)')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_SAM_MANUAL = "System for Award Management (SAM) Manual_true_//div[contains(text(),'Award Management (SAM)')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_DEX_ADVERSE_VALUE = "DEX-Adverse Action Report Value_10_//div[contains(text(),'DEX- Adverse Action Report')]/../div[2]";
    private static final String SCREENING_SWITCH_DEX_ADVERSE_AUTO = "DEX-Adverse Action Report Auto Deny_false_//div[contains(text(),'DEX- Adverse Action Report')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_DEX_ADVERSE_MANUAL = "DEX-Adverse Action Report Manual_true_//div[contains(text(),'DEX- Adverse Action Report')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_DEX_MEDICARE_VALUE = "DEX-Medicare Exclusions Value_3_//div[contains(text(),'DEX- Medicare Exclusions')]/../div[2]";
    private static final String SCREENING_SWITCH_DEX_MEDICARE_AUTO = "DEX-Medicare Exclusions Auto Deny_false_//div[contains(text(),'DEX- Medicare Exclusions')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_DEX_MEDICARE_MANUAL = "DEX-Medicare Exclusions Manual_true_//div[contains(text(),'DEX- Medicare Exclusions')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_HISTORICAL_EXCLUSIONS_VALUE = "Historical exclusion (OIG LEIE, SAM, DEX) Value_4_//div[contains(text(),'Historical exclusion record found (OIG LEIE, SAM, DEX)')]/../div[2]";
    private static final String SCREENING_SWITCH_HISTORICAL_EXCLUSIONS_AUTO = "Historical exclusion (OIG LEIE, SAM, DEX) Auto Deny_false_//div[contains(text(),'Historical exclusion record found (OIG LEIE, SAM, DEX)')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_HISTORICAL_EXCLUSIONS_MANUAL = "Historical exclusion (OIG LEIE, SAM, DEX) Manual_false_//div[contains(text(),'Historical exclusion record found (OIG LEIE, SAM, DEX)')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_PECOS_VALUE = "PECOS Ownership mismatch Value_2_//div[contains(text(),'PECOS Ownership mismatch')]/../div[2]";
    private static final String SCREENING_SWITCH_PECOS_AUTO = "PECOS Ownership mismatch Auto Deny_false_//div[contains(text(),'PECOS Ownership mismatch')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_PECOS_MANUAL = "PECOS Ownership mismatch Manual_false_//div[contains(text(),'PECOS Ownership mismatch')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_ADDRESS_MISMATCH_VALUE = "Address mismatch Value_2_//div[contains(text(),'Address mismatch')]/../div[2]";
    private static final String SCREENING_SWITCH_ADDRESS_MISMATCH_AUTO = "Address mismatch Auto Deny_false_//div[contains(text(),'Address mismatch')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_ADDRESS_MISMATCH_MANUAL = "Address mismatch Manual_false_//div[contains(text(),'Address mismatch')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_INVALID_PRACTICE_VALUE = "Invalid Practice Location Value_0_//div[contains(text(),'Invalid Practice Location')]/../div[2]";
    private static final String SCREENING_SWITCH_INVALID_PRACTICE_AUTO = "Invalid Practice Location Auto Deny_false_//div[contains(text(),'Invalid Practice Location')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_INVALID_PRACTICE_MANUAL = "Invalid Practice Location Manual_false_//div[contains(text(),'Medicare Enrollment Condition of Participation')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_MEDICARE_ENROLLMENT_VALUE = "Medicare Enrollment Value_0_//div[contains(text(),'Medicare Enrollment Condition of Participation')]/../div[2]";
    private static final String SCREENING_SWITCH_MEDICARE_ENROLLMENT_AUTO = "Medicare Enrollment Auto Deny_false_//div[contains(text(),'Medicare Enrollment Condition of Participation')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_MEDICARE_ENROLLMENT_MANUAL = "Medicare Enrollment Manual_false_//div[contains(text(),'Medicare Enrollment Condition of Participation')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String SCREENING_FIELD_NEGATIVE_BALANCE_VALUE = "Negative Balance Flag Value_0_//div[contains(text(),'Negative Balance Flag')]/../div[2]";
    private static final String SCREENING_SWITCH_NEGATIVE_BALANCE_AUTO = "Negative Balance Flag Auto Deny_false_//div[contains(text(),'Negative Balance Flag')]/../div[2]/label/span[1]/span/span/input[@type='checkbox']";
    private static final String SCREENING_SWITCH_NEGATIVE_BALANCE_MANUAL = "Negative Balance Flag Manual_false_//div[contains(text(),'Negative Balance Flag')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";

    /**
     * This method verifies the Screening System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyScreeningSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Screening configuration");
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
                case SCREENING_ALLOW_PERIODIC_MONITORING:
                case SCREENING_CUSTOM_SCREENING_THRESHOLDS:
                case SCREENING_SWITCH_NPI_INVALID_AUTO:
                case SCREENING_SWITCH_NPI_INVALID_MANUAL:
                case SCREENING_SWITCH_NPI_ENUM_AUTO:
                case SCREENING_SWITCH_NPI_ENUM_MANUAL:
                case SCREENING_SWITCH_FEIN_AUTO:
                case SCREENING_SWITCH_FEIN_MANUAL:
                case SCREENING_SWITCH_NAME_MISMATCH_AUTO:
                case SCREENING_SWITCH_NAME_MISMATCH_MANUAL:
                case SCREENING_SWITCH_LICENSE_INVALID_AUTO:
                case SCREENING_SWITCH_LICENSE_INVALID_MANUAL:
                case SCREENING_SWITCH_LICENSE_EXPIRED_AUTO:
                case SCREENING_SWITCH_LICENSE_EXPIRED_MANUAL:
                case SCREENING_SWITCH_LICENSE_ISSUER_AUTO:
                case SCREENING_SWITCH_LICENSE_ISSUER_MANUAL:
                case SCREENING_SWITCH_CLIA_AUTO:
                case SCREENING_SWITCH_CLIA_MANUAL:
                case SCREENING_SWITCH_DEA_AUTO:
                case SCREENING_SWITCH_DEA_MANUAL:
                case SCREENING_SWITCH_DMF_AUTO:
                case SCREENING_SWITCH_DMF_MANUAL:
                case SCREENING_SWITCH_OIG_LEIE_AUTO:
                case SCREENING_SWITCH_OIG_LEIE_MANUAL:
                case SCREENING_SWITCH_SAM_AUTO:
                case SCREENING_SWITCH_SAM_MANUAL:
                case SCREENING_SWITCH_DEX_ADVERSE_AUTO:
                case SCREENING_SWITCH_DEX_ADVERSE_MANUAL:
                case SCREENING_SWITCH_DEX_MEDICARE_AUTO:
                case SCREENING_SWITCH_DEX_MEDICARE_MANUAL:
                case SCREENING_SWITCH_HISTORICAL_EXCLUSIONS_AUTO:
                case SCREENING_SWITCH_HISTORICAL_EXCLUSIONS_MANUAL:
                case SCREENING_SWITCH_PECOS_AUTO:
                case SCREENING_SWITCH_PECOS_MANUAL:
                case SCREENING_SWITCH_ADDRESS_MISMATCH_AUTO:
                case SCREENING_SWITCH_ADDRESS_MISMATCH_MANUAL:
                case SCREENING_SWITCH_INVALID_PRACTICE_AUTO:
                case SCREENING_SWITCH_INVALID_PRACTICE_MANUAL:
                case SCREENING_SWITCH_MEDICARE_ENROLLMENT_AUTO:
                case SCREENING_SWITCH_MEDICARE_ENROLLMENT_MANUAL:
                case SCREENING_SWITCH_NEGATIVE_BALANCE_AUTO:
                case SCREENING_SWITCH_NEGATIVE_BALANCE_MANUAL:
                    //Compare expected and actual configuration values
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case SCREENING_FIELD_NPI_INVALID_VALUE:
                case SCREENING_FIELD_NPI_ENUM_VALUE:
                case SCREENING_FIELD_FEIN_VALUE:
                case SCREENING_FIELD_NAME_MISMATCH_VALUE:
                case SCREENING_FIELD_LICENSE_INVALID_VALUE:
                case SCREENING_FIELD_LICENSE_EXPIRED_VALUE:
                case SCREENING_FIELD_LICENSE_ISSUER_VALUE:
                case SCREENING_FIELD_CLIA_VALUE:
                case SCREENING_FIELD_DEA_VALUE:
                case SCREENING_FIELD_DMF_VALUE:
                case SCREENING_FIELD_OIG_LEIE_VALUE:
                case SCREENING_FIELD_SAM_VALUE:
                case SCREENING_FIELD_DEX_ADVERSE_VALUE:
                case SCREENING_FIELD_DEX_MEDICARE_VALUE:
                case SCREENING_FIELD_HISTORICAL_EXCLUSIONS_VALUE:
                case SCREENING_FIELD_PECOS_VALUE:
                case SCREENING_FIELD_ADDRESS_MISMATCH_VALUE:
                case SCREENING_FIELD_INVALID_PRACTICE_VALUE:
                case SCREENING_FIELD_MEDICARE_ENROLLMENT_VALUE:
                case SCREENING_FIELD_NEGATIVE_BALANCE_VALUE:
                    //Compare expected and actual configuration values
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyScreeningSystemOptions()
     *
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildParameterList () {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(SCREENING_ALLOW_PERIODIC_MONITORING)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_CUSTOM_SCREENING_THRESHOLDS)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_NPI_INVALID_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NPI_INVALID_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NPI_INVALID_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_NPI_ENUM_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NPI_ENUM_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NPI_ENUM_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_FEIN_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_FEIN_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_FEIN_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_NAME_MISMATCH_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NAME_MISMATCH_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NAME_MISMATCH_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_LICENSE_INVALID_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_LICENSE_INVALID_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_LICENSE_INVALID_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_LICENSE_EXPIRED_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_LICENSE_EXPIRED_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_LICENSE_EXPIRED_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_LICENSE_ISSUER_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_LICENSE_ISSUER_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_LICENSE_ISSUER_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_CLIA_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_CLIA_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_CLIA_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_DEA_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DEA_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DEA_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_DMF_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DMF_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DMF_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_OIG_LEIE_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_OIG_LEIE_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_OIG_LEIE_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_SAM_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_SAM_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_SAM_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_DEX_ADVERSE_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DEX_ADVERSE_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DEX_ADVERSE_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_DEX_MEDICARE_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DEX_MEDICARE_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_DEX_MEDICARE_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_HISTORICAL_EXCLUSIONS_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_HISTORICAL_EXCLUSIONS_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_HISTORICAL_EXCLUSIONS_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_PECOS_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_PECOS_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_PECOS_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_ADDRESS_MISMATCH_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_ADDRESS_MISMATCH_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_ADDRESS_MISMATCH_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_INVALID_PRACTICE_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_INVALID_PRACTICE_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_INVALID_PRACTICE_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_MEDICARE_ENROLLMENT_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_MEDICARE_ENROLLMENT_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_MEDICARE_ENROLLMENT_MANUAL)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_FIELD_NEGATIVE_BALANCE_VALUE)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NEGATIVE_BALANCE_AUTO)));
        parameterList.add(new ArrayList<>(List.of(SCREENING_SWITCH_NEGATIVE_BALANCE_MANUAL)));
        return parameterList;
    }

}
