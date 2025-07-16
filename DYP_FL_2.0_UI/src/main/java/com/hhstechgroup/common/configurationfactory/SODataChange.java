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
public class SODataChange extends Configuration {

    //******************************************************************************************************************
    //
    //                                  MISC CONSTANT DECLARATIONS
    //
    //******************************************************************************************************************
    private static final String SEPARATOR = "_";
    public static final String ATTRIBUTE_VALUE = "value";

    //******************************************************************************************************************
    //
    // CONFIGURATION STRING DECLARATIONS
    //
    // Each string contains three parts, a Parameter identifier, an Expected Value and the XPath. The string part is
    // parsed using the SEPARATOR.
    //
    //******************************************************************************************************************
    public static final String ENROLLMENT_NOTIFICATION_SWITCH = "Enrollment Notification_true_(//input[@name='Notification'])[1]";
    public static final String ENROLLMENT_CONFIRMATION_SWITCH = "Enrollment Confirmation_false_(//input[@name='Confirmation'])[1]";
    public static final String ENROLLMENT_OVERRIDE_SWITCH = "Enrollment Override_false_(//input[@name='Override'])[1]";
    public static final String PROVIDER_DATA_NOTIFICATION_SWITCH = "Provider Data Notification_true_(//input[@name='Notification'])[2]";
    public static final String PROVIDER_DATA_CONFIRMATION_SWITCH = "Provider Data Confirmation_false_(//input[@name='Confirmation'])[2]";
    public static final String PROVIDER_DATA_OVERRIDE_SWITCH = "Provider Data Override_false_(//input[@name='Override'])[2]";
    public static final String PHI_NOTIFICATION_SWITCH = "PHI Notification_false_(//input[@name='Notification'])[3]";
    public static final String PHI_CONFIRMATION_SWITCH = "PHI Confirmation_true_(//input[@name='Confirmation'])[3]";
    public static final String PHI_OVERRIDE_SWITCH = "PHI Override_true_(//input[@name='Override'])[3]";
    public static final String PII_NOTIFICATION_SWITCH = "PII Notification_false_(//input[@name='Notification'])[4]";
    public static final String PII_CONFIRMATION_SWITCH = "PII Confirmation_true_(//input[@name='Confirmation'])[4]";
    public static final String PII_OVERRIDE_SWITCH = "PII Override_true_(//input[@name='Override'])[4]";
    public static final String FTI_NOTIFICATION_SWITCH = "FTI Notification_false_(//input[@name='Notification'])[5]";
    public static final String FTI_CONFIRMATION_SWITCH = "FTI Confirmation_true_(//input[@name='Confirmation'])[5]";
    public static final String FTI_OVERRIDE_SWITCH = "FTI Override_true_(//input[@name='Override'])[5]";
    public static final String NOTIFICATION_PROVIDER_SWITCH="Notification Provider Switch_true_//input[@name='Providers']";
    public static final String NOTIFICATION_PROVIDER_PERIOD="Notification Provider Period_Summary once a day_(//div[contains(@class, 'select-settings')]//input)[1]";
    public static final String NOTIFICATION_PROVIDER_TIME="Notification Provider Time_08:00 AM_(//div[contains(@class, 'time-settings')]//div[@role='button'])[1]";
    public static final String NOTIFICATION_IU_SWITCH="Notification Internal User Switch_true_//input[@name='Internal Users']";
    public static final String NOTIFICATION_IU_PERIOD="Notification Internal User Period_On each request_(//div[contains(@class, 'select-settings')]//input)[2]";
    public static final String NOTIFICATION_IU_TIME="Notification Provider Time_08:00 PM_(//div[contains(@class, 'time-settings')]//div[@role='button'])[2]";
    public static final String NOTIFICATION_PEM_AFFILIATE_SWITCH="Notification PEM Affiliates Switch_true_//input[@name='PEM Affiliates']";

    /**
     * This method verifies the Data Change System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyDataChangeSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Data Change Configuration");
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
                case ENROLLMENT_NOTIFICATION_SWITCH:
                case ENROLLMENT_CONFIRMATION_SWITCH:
                case ENROLLMENT_OVERRIDE_SWITCH:
                case PROVIDER_DATA_NOTIFICATION_SWITCH:
                case PROVIDER_DATA_CONFIRMATION_SWITCH:
                case PROVIDER_DATA_OVERRIDE_SWITCH:
                case PHI_NOTIFICATION_SWITCH:
                case PHI_CONFIRMATION_SWITCH:
                case PHI_OVERRIDE_SWITCH:
                case PII_NOTIFICATION_SWITCH:
                case PII_CONFIRMATION_SWITCH:
                case PII_OVERRIDE_SWITCH:
                case FTI_NOTIFICATION_SWITCH:
                case FTI_CONFIRMATION_SWITCH:
                case FTI_OVERRIDE_SWITCH:
                case NOTIFICATION_PROVIDER_SWITCH:
                case NOTIFICATION_IU_SWITCH:
                case NOTIFICATION_PEM_AFFILIATE_SWITCH:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case NOTIFICATION_PROVIDER_PERIOD:
                case NOTIFICATION_IU_PERIOD:
                    stringTextCompareWithAttribute(driver, xpathParse, ATTRIBUTE_VALUE, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case NOTIFICATION_PROVIDER_TIME:
                case NOTIFICATION_IU_TIME:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
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
        parameterList.add(new ArrayList<>(List.of(ENROLLMENT_NOTIFICATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(ENROLLMENT_CONFIRMATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(ENROLLMENT_OVERRIDE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PROVIDER_DATA_NOTIFICATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PROVIDER_DATA_CONFIRMATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PROVIDER_DATA_OVERRIDE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PHI_NOTIFICATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PHI_CONFIRMATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PHI_OVERRIDE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PII_NOTIFICATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PII_CONFIRMATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(PII_OVERRIDE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(FTI_NOTIFICATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(FTI_CONFIRMATION_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(FTI_OVERRIDE_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_PROVIDER_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_PROVIDER_PERIOD)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_PROVIDER_TIME)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_IU_SWITCH)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_IU_PERIOD)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_IU_TIME)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_PEM_AFFILIATE_SWITCH)));

        return parameterList;
    }
}
