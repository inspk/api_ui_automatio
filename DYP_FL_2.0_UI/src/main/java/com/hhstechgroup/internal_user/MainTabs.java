package com.hhstechgroup.internal_user;


import com.hhstechgroup.common.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class utilizes WebDriver to identify fields displayed on the Internal User portal Main Menu tabs
 */
public class MainTabs extends BaseActions {

    /**
     * This constructor method creates a MainTabs object using driver and wait arguments
     * @param driver
     * @param wait
     */
    public MainTabs(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


}
