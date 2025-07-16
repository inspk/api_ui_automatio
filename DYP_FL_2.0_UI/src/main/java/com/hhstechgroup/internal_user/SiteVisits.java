package com.hhstechgroup.internal_user;

import com.hhstechgroup.common.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class provides Site Visit related interactions
 */
public class SiteVisits extends BaseActions {

    /**
     * This constructor method creates a SiteVisits object using driver and wait arguments
     * @param driver
     * @param wait
     */
    public SiteVisits(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

}
