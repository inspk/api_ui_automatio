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
public class SOUserDeactivation extends Configuration {

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
    private static final String INTERNAL_USER_INACTIVE_DAYS = "Internal User Inactive Days_180_(//h3[text()='Inactive Days']/parent::div/parent::div/parent::div/div/h2/span)[1]";
    private static final String INTERNAL_USER_INVITATION_NOT_ACCEPTED = "Internal User Invitation Not Accepted_30_(//h3[text()='Invitation not accepted user inactivity']/parent::div/parent::div/parent::div/div/h2/span)[1]";
    private static final String PROVIDER_USER_INACTIVE_DAYS = "Provider Inactive Days_180_(//h3[text()='Inactive Days']/parent::div/parent::div/parent::div/div/h2/span)[3]";
    private static final String PROVIDER_USER_INVITATION_NOT_ACCEPTED = "Provider Invitation Not Accepted_30_(//h3[text()='Invitation not accepted user inactivity']/parent::div/parent::div/parent::div/div/h2/span)[3]";

    /**
     * This method verifies the User Deactivation System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyUserDeactivationSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;
        
        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("User Deactivation Configuration");
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
                case INTERNAL_USER_INACTIVE_DAYS:
                case INTERNAL_USER_INVITATION_NOT_ACCEPTED:
                case PROVIDER_USER_INACTIVE_DAYS:
                case PROVIDER_USER_INVITATION_NOT_ACCEPTED:
                    //Compare expected and actual configuration values
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyUserDeactivationSO()
     *
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildParameterList() {
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(INTERNAL_USER_INACTIVE_DAYS)));
        parameterList.add(new ArrayList<>(List.of(INTERNAL_USER_INVITATION_NOT_ACCEPTED)));
        parameterList.add(new ArrayList<>(List.of(PROVIDER_USER_INACTIVE_DAYS)));
        parameterList.add(new ArrayList<>(List.of(PROVIDER_USER_INVITATION_NOT_ACCEPTED)));
        return parameterList;
    }
}
