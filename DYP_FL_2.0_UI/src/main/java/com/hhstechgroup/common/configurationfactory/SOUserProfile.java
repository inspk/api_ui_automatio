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
public class SOUserProfile extends Configuration {

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
    private static final String USER_PROFILE_EXPECTED_SWITCH = "Enable Auto Deny Switch_true_//input[@name='logoutSwitch']";
    private static final String USER_PROFILE_EXPECTED_DAYS = "User Profile Update Notification_1_//span[text()='1']";

    /**
     * This method verifies the Reminder to Reviewers System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyUserProfileSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;
        
        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("User Profile Configuration");
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
                case USER_PROFILE_EXPECTED_SWITCH:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;

                case USER_PROFILE_EXPECTED_DAYS:
                    //Compare expected and actual configuration values
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }        
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyUserProfileSO()
     *
     * @return parameterList
     */
        private ArrayList<ArrayList<String>> buildParameterList() {

            ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
            parameterList.add(new ArrayList<>(List.of(USER_PROFILE_EXPECTED_SWITCH)));
            parameterList.add(new ArrayList<>(List.of(USER_PROFILE_EXPECTED_DAYS)));
            return parameterList;
        }
    }
