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

public class SOReminders extends Configuration {

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
    private static final String REMINDERS_TO_REVIEWERS_1ST_NOTIFICATION_DAYS = "Reminder 1st Notification_3_//div[contains(text(),'1st notification')]/../div[2]/span[1]";
    private static final String REMINDERS_TO_REVIEWERS_2ND_NOTIFICATION_DAYS = "Reminder 2nd Notification_5_//div[contains(text(),'2nd notification')]/../div[2]/span[1]";
    private static final String REMINDERS_TO_REVIEWERS_3RD_NOTIFICATION_DAYS = "Reminder 3rd Notification_10_//div[contains(text(),'3rd notification')]/../div[2]/span[1]";

    /**
     * This method verifies the Reminder to Reviewers System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyRemindersSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Reminders to Reviewers Configuration");
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
                case REMINDERS_TO_REVIEWERS_1ST_NOTIFICATION_DAYS:
                case REMINDERS_TO_REVIEWERS_2ND_NOTIFICATION_DAYS:
                case REMINDERS_TO_REVIEWERS_3RD_NOTIFICATION_DAYS:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyRemindersSO()
     *
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildParameterList() {
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(REMINDERS_TO_REVIEWERS_1ST_NOTIFICATION_DAYS)));
        parameterList.add(new ArrayList<>(List.of(REMINDERS_TO_REVIEWERS_2ND_NOTIFICATION_DAYS)));
        parameterList.add(new ArrayList<>(List.of(REMINDERS_TO_REVIEWERS_3RD_NOTIFICATION_DAYS)));
        return parameterList;
    }
}
