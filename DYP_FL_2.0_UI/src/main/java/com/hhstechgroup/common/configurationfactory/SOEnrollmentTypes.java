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
public class SOEnrollmentTypes extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "~";
    private static final String ATTRIBUTE_VALUE = "value";

    //******************************************************************************************************************
    //
    // INDIVIDUAL CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String INDIVIDUAL_TILE_SW = "Individual tile will be shown in the system~true~//div[contains(text(),'Individual')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'individual')]";
    private static final String INDIVIDUAL_PEM_CREATE_ENROLL_SW = "Individual Enable PEM to create an enrollment~true~//div[contains(text(),'Individual')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'individual')]";
    private static final String INDIVIDUAL_NAME_VAL = "Individual Enrollment Type Name~Individual Enrollment~//div[contains(text(),'Individual')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'individual')]";
    private static final String INDIVIDUAL_ENROLL_DESC_VAL = "Individual Enrollment Description~Individual / Sole proprietorship using SSN~//div[contains(text(),'Individual')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'individual')]";
    private static final String INDIVIDUAL_RUNTIME_APP_NAME_VAL = "Individual Runtime Application Name~provider~//div[contains(text(),'Individual')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'individual')]";

    //******************************************************************************************************************
    //
    // GROUP CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String GROUP_TILE_SW = "Group tile will be shown in the system~true~//div[contains(text(),'Group')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'group')]";
    private static final String GROUP_PEM_CREATE_ENROLL_SW = "Group Enable PEM to create an enrollment~true~//div[contains(text(),'Group')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'group')]";
    private static final String GROUP_NAME_VAL = "Group Enrollment Type Name~Entity Enrollment~//div[contains(text(),'Group')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'group')]";
    private static final String GROUP_ENROLL_DESC_VAL = "Group Enrollment Description~Facility / Agency / Pharmacy / Organization~//div[contains(text(),'Group')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'group')]";
    private static final String GROUP_RUNTIME_APP_NAME_VAL = "Group Runtime Application Name~provider_group~//div[contains(text(),'Group')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'group')]";

    //******************************************************************************************************************
    //
    // FACILITY CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String FACILITY_TILE_SW = "Facility tile will be shown in the system~false~//div[contains(text(),'Facility')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'facility')]";
    private static final String FACILITY_PEM_CREATE_ENROLL_SW = "Facility Enable PEM to create an enrollment~false~//div[contains(text(),'Facility')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'facility')]";
    private static final String FACILITY_NAME_VAL = "Facility Enrollment Type Name~Facility Provider Enrollment Application~//div[contains(text(),'Facility')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'facility')]";
    private static final String FACILITY_ENROLL_DESC_VAL = "Facility Enrollment Description~~//div[contains(text(),'Facility')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'facility')]";
    private static final String FACILITY_RUNTIME_APP_NAME_VAL = "Facility Runtime Application Name~facility~//div[contains(text(),'Facility')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'facility')]";

    //******************************************************************************************************************
    //
    // ORP CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String ORP_TILE_SW = "ORP tile will be shown in the system~false~//div[contains(text(),'ORP')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'ORP')]";
    private static final String ORP_PEM_CREATE_ENROLL_SW = "ORP Enable PEM to create an enrollment~false~//div[contains(text(),'ORP')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'ORP')]";
    private static final String ORP_NAME_VAL = "ORP Enrollment Type Name~Ordering/Referring/ Prescribing Provider Enrollment~//div[contains(text(),'ORP')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'ORP')]";
    private static final String ORP_ENROLL_DESC_VAL = "ORP Enrollment Description~~//div[contains(text(),'ORP')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'ORP')]";
    private static final String ORP_RUNTIME_APP_NAME_VAL = "ORP Runtime Application Name~orp~//div[contains(text(),'ORP')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'ORP')]";

    //******************************************************************************************************************
    //
    // PEM CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String PEM_TILE_SW = "PEM tile will be shown in the system~true~//div[contains(text(),'PEM')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'PEM')]";
    private static final String PEM_PEM_CREATE_ENROLL_SW = "PEM Enable PEM to create an enrollment~false~//div[contains(text(),'PEM')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'PEM')]";
    private static final String PEM_NAME_VAL = "PEM Enrollment Type Name~Provider Enrollment Manager (PEM)~//div[contains(text(),'PEM')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'PEM')]";
    private static final String PEM_ENROLL_DESC_VAL = "PEM Enrollment Description~Managing others' Enrollments~//div[contains(text(),'PEM')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'PEM')]";
    private static final String PEM_RUNTIME_APP_NAME_VAL = "PEM Runtime Application Name~provider_enrollment_manager~//div[contains(text(),'PEM')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'PEM')]";

    //******************************************************************************************************************
    //
    // TRADING PARTNER CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String TP_TILE_SW = "Trading Partner tile will be shown in the system~true~//div[contains(text(),'TP')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'TP')]";
    private static final String TP_PEM_CREATE_ENROLL_SW = "Trading Partner Enable PEM to create an enrollment~false~//div[contains(text(),'TP')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'TP')]";
    private static final String TP_NAME_VAL = "Trading Partner Enrollment Type Name~Trading Partner (TP) Enrollment~//div[contains(text(),'TP')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'TP')]";
    private static final String TP_ENROLL_DESC_VAL = "Trading Partner Enrollment Description~EDI self-submitters & TPs~//div[contains(text(),'TP')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'TP')]";
    private static final String TP_RUNTIME_APP_NAME_VAL = "Trading Partner Runtime Application Name~trading_partner~//div[contains(text(),'TP')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'TP')]";

    //******************************************************************************************************************
    //
    // PHARMACY CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String PHARMACY_TILE_SW = "Pharmacy tile will be shown in the system~false~//div[contains(text(),'Pharmacy')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'pharmacy')]";
    private static final String PHARMACY_PEM_CREATE_ENROLL_SW = "Pharmacy Enable PEM to create an enrollment~false~//div[contains(text(),'Pharmacy')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'pharmacy')]";
    private static final String PHARMACY_NAME_VAL = "Pharmacy Enrollment Type Name~Pharmacy Enrollment~//div[contains(text(),'Pharmacy')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'pharmacy')]";
    private static final String PHARMACY_ENROLL_DESC_VAL = "Pharmacy Enrollment Description~~//div[contains(text(),'Pharmacy')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'pharmacy')]";
    private static final String PHARMACY_RUNTIME_APP_NAME_VAL = "Pharmacy Runtime Application Name~pharmacy~//div[contains(text(),'Pharmacy')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'pharmacy')]";

    //******************************************************************************************************************
    //
    // MCO CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    private static final String MCO_TILE_SW = "MCO tile will be shown in the system~false~//div[contains(text(),'MCO')][1]/../../div[2]/div/label[contains(@class,'switch-setting_')]//input[contains(@name,'MCO')]";
    private static final String MCO_PEM_CREATE_ENROLL_SW = "MCO Enable PEM to create an enrollment~false~//div[contains(text(),'MCO')][1]/../../div[2]/div/label[contains(@class,'switch-setting-pem')]//input[contains(@name,'MCO')]";
    private static final String MCO_NAME_VAL = "MCO Enrollment Type Name~Managed Care Organisation Enrollment~//div[contains(text(),'MCO')][1]/../descendant::div[contains(text(),'Type Name')]/descendant::input[contains(@name,'MCO')]";
    private static final String MCO_ENROLL_DESC_VAL = "MCO Enrollment Description~~//div[contains(text(),'MCO')][1]/../descendant::div[contains(text(),'Description')]/descendant::input[contains(@name,'MCO')]";
    private static final String MCO_RUNTIME_APP_NAME_VAL = "MCO Runtime Application Name~mco~//div[contains(text(),'MCO')][1]/../descendant::div[contains(text(),'Runtime')]/descendant::input[contains(@name,'MCO')]";

    /**
     * This method verifies the Enrollment Types System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyEnrollmentTypesSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Enrollment Types Configuration");
        Reports.log("********************************************************");

        for (ArrayList<String> strings : parameterList) {

            //Retrieve Configuration and expected value from the ArrayList
            String configurationString = String.valueOf(strings.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            configurationNameParse = configurationStringParts[0];
            expectedValueParse = configurationStringParts[1];
            xpathParse = configurationStringParts[2];

            switch (configurationString) {
                case INDIVIDUAL_TILE_SW:
                case INDIVIDUAL_PEM_CREATE_ENROLL_SW:
                case GROUP_TILE_SW:
                case GROUP_PEM_CREATE_ENROLL_SW:
                case FACILITY_TILE_SW:
                case FACILITY_PEM_CREATE_ENROLL_SW:
                case ORP_TILE_SW:
                case ORP_PEM_CREATE_ENROLL_SW:
                case PEM_TILE_SW:
                case PEM_PEM_CREATE_ENROLL_SW:
                case TP_TILE_SW:
                case TP_PEM_CREATE_ENROLL_SW:
                case PHARMACY_TILE_SW:
                case PHARMACY_PEM_CREATE_ENROLL_SW:
                case MCO_TILE_SW:
                case MCO_PEM_CREATE_ENROLL_SW:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case INDIVIDUAL_NAME_VAL:
                case INDIVIDUAL_ENROLL_DESC_VAL:
                case INDIVIDUAL_RUNTIME_APP_NAME_VAL:
                case GROUP_NAME_VAL:
                case GROUP_ENROLL_DESC_VAL:
                case GROUP_RUNTIME_APP_NAME_VAL:
                case FACILITY_NAME_VAL:
                case FACILITY_ENROLL_DESC_VAL:
                case FACILITY_RUNTIME_APP_NAME_VAL:
                case ORP_NAME_VAL:
                case ORP_ENROLL_DESC_VAL:
                case ORP_RUNTIME_APP_NAME_VAL:
                case PEM_NAME_VAL:
                case PEM_ENROLL_DESC_VAL:
                case PEM_RUNTIME_APP_NAME_VAL:
                case TP_NAME_VAL:
                case TP_ENROLL_DESC_VAL:
                case TP_RUNTIME_APP_NAME_VAL:
                case PHARMACY_NAME_VAL:
                case PHARMACY_ENROLL_DESC_VAL:
                case PHARMACY_RUNTIME_APP_NAME_VAL:
                case MCO_NAME_VAL:
                case MCO_ENROLL_DESC_VAL:
                case MCO_RUNTIME_APP_NAME_VAL:
                    stringTextCompareWithAttribute(driver, xpathParse, ATTRIBUTE_VALUE, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This private method builds a list of the configurations and expected values types
     *
     * @return parameterList
     */
    public ArrayList<ArrayList<String>> buildParameterList () {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(INDIVIDUAL_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(GROUP_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(GROUP_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(GROUP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(GROUP_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(GROUP_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(FACILITY_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(FACILITY_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(FACILITY_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(FACILITY_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(FACILITY_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(ORP_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(ORP_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(ORP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(ORP_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(ORP_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(PEM_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(PEM_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(PEM_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(PEM_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(PEM_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(TP_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(TP_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(TP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(TP_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(TP_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(PHARMACY_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(PHARMACY_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(PHARMACY_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(PHARMACY_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(PHARMACY_RUNTIME_APP_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(MCO_TILE_SW)));
        parameterList.add(new ArrayList<>(List.of(MCO_PEM_CREATE_ENROLL_SW)));
        parameterList.add(new ArrayList<>(List.of(MCO_NAME_VAL)));
        parameterList.add(new ArrayList<>(List.of(MCO_ENROLL_DESC_VAL)));
        parameterList.add(new ArrayList<>(List.of(MCO_RUNTIME_APP_NAME_VAL)));
        return parameterList;
    }
}
