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
public class SONotification extends Configuration {

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
    private static final String NOTIFICATION_SWITCH_ENROLL_MSG = "Enrollments Message Center_true_//div[contains(text(),'Enrollments')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REVAL_MSG = "Revalidation Request Message Center_true_//div[contains(text(),'Revalidation')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REENROLL_MSG = "Re Enrollment Message Center_true_//div[contains(text(),'Re Enrollment')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_COC_MSG = "Change of Circumstance Message Center_true_//div[contains(text(),'Change of Circumstance')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_RECONSIDER_MSG = "Reconsideration Message Center_true_//div[contains(text(),'Reconsideration')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_SITE_VISIT_MSG = "Site visit Message Center_false_//div[contains(text(),'Site visit')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_TERM_MSG = "Termination Message Center_true_//div[text()='Termination']/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_RAI_MSG = "Request Additional Information Reminders Message Center_true_//div[contains(text(),'Request Additional Information')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REVAL_REM_MSG = "Revalidation Reminders Message Center_true_//div[contains(text(),'Revalidation')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_LIC_EXP_REM_MSG = "Licensure Expiration Reminders Message Center_true_//div[contains(text(),'Licensure Expiration')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_SUSP_MSG = "Suspension Message Center_true_//div[contains(text(),'Suspension')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_TERM_REQ_MSG = "Termination Request Message Center_true_//div[text()='Termination Request']/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REACT_MSG = "Re Activation Message Center_true_//div[contains(text(),'Re Activation')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_DAT_CHG_MSG = "Data change Message Center_true_//div[contains(text(),'Data change')]/../div[2]/label[1]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_ENROLL_EMAIL= "Enrollments Email_true_//div[contains(text(),'Enrollments')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REVAL_EMAIL = "Revalidation Request Email_true_//div[contains(text(),'Revalidation')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REENROLL_EMAIL = "Re Enrollment Email_true_//div[contains(text(),'Re Enrollment')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_COC_EMAIL = "Change of Circumstance Email_true_//div[contains(text(),'Change of Circumstance')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_RECONSIDER_EMAIL = "Reconsideration Email_true_//div[contains(text(),'Reconsideration')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_SITE_VISIT_EMAIL = "Site visit Email_false_//div[contains(text(),'Site visit')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_TERM_EMAIL = "Termination Email_true_//div[text()='Termination']/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_RAI_EMAIL = "Request Additional Information Reminders Email_true_//div[contains(text(),'Request Additional Information')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REVAL_REM_EMAIL = "Revalidation Reminders Email_true_//div[contains(text(),'Revalidation')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_LIC_EXP_REM_EMAIL = "Licensure Expiration Reminders Email_true_//div[contains(text(),'Licensure Expiration')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_SUSP_EMAIL = "Suspension Email_true_//div[contains(text(),'Suspension')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_TERM_REQ_EMAIL = "Termination Request Email_true_//div[text()='Termination Request']/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REACT_EMAIL = "Re Activation Email_true_//div[contains(text(),'Re Activation')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_DAT_CHG_EMAIL = "Data change Email_true_//div[contains(text(),'Data change')]/../div[2]/label[2]/span/span/span/input[@type='checkbox']";
    private static final String NOTIFICATION_SWITCH_REG_EMAIL = "Trigger all the E-mail communications to registered E-mail ID_false_//input[@name='RegisteredEmailTrigger']";
    private static final String NOTIFICATION_SWITCH_APP_CONTACT_EMAIL = "Trigger all the E-mail communications to Application Contact E-mail ID_true_//input[@name='ApplicationEmailTrigger']";

    /**
     * This method verifies the Notification Engine System Option configuration values
     *
     * @param driver WebDriver reference variable
     * @param softAssert SoftAssert reference variable
     */
    public void verifyNotificationSO(WebDriver driver, SoftAssert softAssert) {

        String xpathParse;
        String configurationNameParse;
        String expectedValueParse;

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> parameterList = buildParameterList();

        Reports.log("\n********************************************************");
        Reports.log("Notification Configuration");
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
                case NOTIFICATION_SWITCH_ENROLL_MSG:
                case NOTIFICATION_SWITCH_REVAL_MSG:
                case NOTIFICATION_SWITCH_REENROLL_MSG:
                case NOTIFICATION_SWITCH_COC_MSG:
                case NOTIFICATION_SWITCH_RECONSIDER_MSG:
                case NOTIFICATION_SWITCH_SITE_VISIT_MSG:
                case NOTIFICATION_SWITCH_TERM_MSG:
                case NOTIFICATION_SWITCH_RAI_MSG:
                case NOTIFICATION_SWITCH_REVAL_REM_MSG:
                case NOTIFICATION_SWITCH_LIC_EXP_REM_MSG:
                case NOTIFICATION_SWITCH_SUSP_MSG:
                case NOTIFICATION_SWITCH_TERM_REQ_MSG:
                case NOTIFICATION_SWITCH_REACT_MSG:
                case NOTIFICATION_SWITCH_DAT_CHG_MSG:
                case NOTIFICATION_SWITCH_ENROLL_EMAIL:
                case NOTIFICATION_SWITCH_REVAL_EMAIL:
                case NOTIFICATION_SWITCH_REENROLL_EMAIL:
                case NOTIFICATION_SWITCH_COC_EMAIL:
                case NOTIFICATION_SWITCH_RECONSIDER_EMAIL:
                case NOTIFICATION_SWITCH_SITE_VISIT_EMAIL:
                case NOTIFICATION_SWITCH_TERM_EMAIL:
                case NOTIFICATION_SWITCH_RAI_EMAIL:
                case NOTIFICATION_SWITCH_REVAL_REM_EMAIL:
                case NOTIFICATION_SWITCH_LIC_EXP_REM_EMAIL:
                case NOTIFICATION_SWITCH_SUSP_EMAIL:
                case NOTIFICATION_SWITCH_TERM_REQ_EMAIL:
                case NOTIFICATION_SWITCH_REACT_EMAIL:
                case NOTIFICATION_SWITCH_DAT_CHG_EMAIL:
                case NOTIFICATION_SWITCH_REG_EMAIL:
                case NOTIFICATION_SWITCH_APP_CONTACT_EMAIL:
                    booleanTextCompare(driver, xpathParse, expectedValueParse, configurationNameParse, softAssert);
                    break;
            }
        }
    }

    /**
     * This method builds an Arraylist of XPath/Expected Values used by verifyNotificationSO()
     *
     * @return parameterList
     */
    public ArrayList<ArrayList<String>> buildParameterList () {

        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_ENROLL_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REVAL_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REENROLL_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_COC_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_RECONSIDER_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_SITE_VISIT_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_TERM_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_RAI_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REVAL_REM_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_LIC_EXP_REM_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_SUSP_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_TERM_REQ_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REACT_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_DAT_CHG_MSG)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_ENROLL_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REVAL_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REENROLL_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_COC_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_RECONSIDER_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_SITE_VISIT_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_TERM_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_RAI_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REVAL_REM_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_LIC_EXP_REM_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_SUSP_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_TERM_REQ_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REACT_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_DAT_CHG_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_REG_EMAIL)));
        parameterList.add(new ArrayList<>(List.of(NOTIFICATION_SWITCH_APP_CONTACT_EMAIL)));

        return parameterList;
    }
}
