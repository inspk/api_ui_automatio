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
public class SOLicensure extends Configuration {

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
    private static final String LICENSURE_1ST_NOTIFICATION_DAYS = "Reminder 1st Notification_45_//div[contains(text(),'1st notification')]/../div[2]/span[1]";
    private static final String LICENSURE_2ND_NOTIFICATION_DAYS = "Reminder 1st Notification_30_//div[contains(text(),'2nd notification')]/../div[2]/span[1]";
    private static final String LICENSURE_3RD_NOTIFICATION_DAYS = "Reminder 1st Notification_15_//div[contains(text(),'3rd notification')]/../div[2]/span[1]";

    /**
     * This method verifies the Licensure System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyLicensureSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Licensure Configuration");
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
                case LICENSURE_1ST_NOTIFICATION_DAYS:
                case LICENSURE_2ND_NOTIFICATION_DAYS:
                case LICENSURE_3RD_NOTIFICATION_DAYS:
                    stringTextCompareGetText(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyLicensureSO()
     *
     * @return parameterList
     */
    private ArrayList<ArrayList<String>> buildParameterList () {
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(LICENSURE_1ST_NOTIFICATION_DAYS)));
        parameterList.add(new ArrayList<>(List.of(LICENSURE_2ND_NOTIFICATION_DAYS)));
        parameterList.add(new ArrayList<>(List.of(LICENSURE_3RD_NOTIFICATION_DAYS)));
        return parameterList;
    }
}
