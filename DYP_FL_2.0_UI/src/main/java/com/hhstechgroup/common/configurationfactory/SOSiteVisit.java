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
public class SOSiteVisit extends Configuration {

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
    private static final String RADIO_BUTTON_BASED_ON_TAXONOMY = "Based on Taxonomy_true_//input[@value='basedOnTaxonomy']";
    private static final String RADIO_BUTTON_SCREENING_SCORE = "Based on Screening Score_false_//input[@value='basedOnScreeningScore']";
    private static final String RADIO_BUTTON_HIGHER_OF_TWO_RISK_LEVELS = "Based on Higher of the two Risk Levels_false_//input[@value='higherOftheTwoRiskLevels']";
    private static final String RADIO_BUTTON_INSTATE = "Instate Providers_false_//input[@value='instate']";
    private static final String RADIO_BUTTON_OUTSTATE = "Outstate Providers_false_//input[@value='outstate']";
    private static final String RADIO_BUTTON_BOTH = "Both_true_//input[@value='both']";
    private static final String SITE_VISIT_TABLE_RISK_LEVEL_1 = "Site Visit Table Row No.1 and Column No.1_High_//tr[1]/td[1]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_1 = "Site Visit Table Row No.1 and Column No.2_Yes_//tr[1]/td[2]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_1 = "Site Visit Table Row No.1 and Column No.3_5_//tr[1]/td[3]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_1 = "Site Visit Table Row No.1 and Column No.4_  - _//tr[1]/td[4]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_1 = "Site Visit Table Row No.1 and Column No.5_   - _//tr[1]/td[5]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_1 = "Site Visit Table Row No.1 and Column No.6_   - _//tr[1]/td[6]/pre";
    private static final String SITE_VISIT_TABLE_RISK_LEVEL_2 = "Site Visit Table Row No.2 and Column No.1_Moderate_//tr[2]/td[1]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_2 = "Site Visit Table Row No.2 and Column No.2_Yes_//tr[2]/td[2]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_2 = "Site Visit Table Row No.2 and Column No.3_5_//tr[2]/td[3]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_2 = "Site Visit Table Row No.2 and Column No.4_  - _//tr[2]/td[4]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_2 = "Site Visit Table Row No.2 and Column No.5_   - _//tr[2]/td[5]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_2 = "Site Visit Table Row No.2 and Column No.6_   - _//tr[2]/td[6]/pre";
    private static final String SITE_VISIT_TABLE_RISK_LEVEL_3 = "Site Visit Table Row No.3 and Column No.1_Limited_//tr[3]/td[1]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_3 = "Site Visit Table Row No.3 and Column No.2_No_//tr[3]/td[2]/span";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_3 = "Site Visit Table Row No.3 and Column No.3_     - _//tr[3]/td[3]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_3 = "Site Visit Table Row No.3 and Column No.4_  - _//tr[3]/td[4]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_3 = "Site Visit Table Row No.3 and Column No.5_   - _//tr[3]/td[5]/pre";
    private static final String SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_3 = "Site Visit Table Row No.3 and Column No.6_   - _//tr[3]/td[6]/pre";

    /**
     * This method verifies the Site Visit System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifySiteVisitSO(WebDriver driver, SoftAssert softAssert) {

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Site Visit Configuration");
        Reports.log("********************************************************");

        for (ArrayList<String> strings : parameterList) {

            //Retrieve arraylist values
            String configurationString = String.valueOf(strings.get(0));

            //Parse the Configuration Name, Expected Value and Xpath from the configuration string
            String[] configurationStringParts = configurationString.split(SEPARATOR);
            String configurationNameParse = configurationStringParts[0];
            String expectedValueParse = configurationStringParts[1];
            String xpathParse = configurationStringParts[2];

            switch (configurationString) {
                case RADIO_BUTTON_BASED_ON_TAXONOMY:
                case RADIO_BUTTON_SCREENING_SCORE:
                case RADIO_BUTTON_HIGHER_OF_TWO_RISK_LEVELS:
                case RADIO_BUTTON_INSTATE:
                case RADIO_BUTTON_OUTSTATE:
                case RADIO_BUTTON_BOTH:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
                case SITE_VISIT_TABLE_RISK_LEVEL_1:
                case SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_1:
                case SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_1:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_1:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_1:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_1:
                case SITE_VISIT_TABLE_RISK_LEVEL_2:
                case SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_2:
                case SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_2:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_2:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_2:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_2:
                case SITE_VISIT_TABLE_RISK_LEVEL_3:
                case SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_3:
                case SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_3:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_3:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_3:
                case SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_3:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifySiteVisitSO()
     *
     * @return parameterList
     */
    public ArrayList<ArrayList<String>> buildParameterList () {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(RADIO_BUTTON_BASED_ON_TAXONOMY)));
        parameterList.add(new ArrayList<>(List.of(RADIO_BUTTON_SCREENING_SCORE)));
        parameterList.add(new ArrayList<>(List.of(RADIO_BUTTON_HIGHER_OF_TWO_RISK_LEVELS)));
        parameterList.add(new ArrayList<>(List.of(RADIO_BUTTON_INSTATE)));
        parameterList.add(new ArrayList<>(List.of(RADIO_BUTTON_OUTSTATE)));
        parameterList.add(new ArrayList<>(List.of(RADIO_BUTTON_BOTH)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_RISK_LEVEL_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_RISK_LEVEL_2)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_1)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_2)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_2)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_2)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_2)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_RISK_LEVEL_3)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REQUIRED_3)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_SCHEDULE_3)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_FIRST_3)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_SECOND_3)));
        parameterList.add(new ArrayList<>(List.of(SITE_VISIT_TABLE_SITE_VISIT_REMINDER_THIRD_3)));
        return parameterList;
    }
}
