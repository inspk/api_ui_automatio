package com.hhstechgroup.internal_user;


import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Locators;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class utilizes WebDriver to retrieve System information
 */
public class MyAccountIU extends BaseActions {

    /**
     * This constructor method creates a MyAccountIU object using driver and wait arguments
     * @param driver
     * @param wait
     */
    public MyAccountIU(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method collects account system information
     * @return System Information
     */
    public String getSystemInformation() {

        Reports.log("Collect System information");
        String systemInformation =
                driver.findElement(Locators.BLOCK_SYSTEM_INFORMATION_MY_ACCOUNT).getText();

        Reports.log("System information: " + systemInformation);
        return systemInformation;
    }
}
