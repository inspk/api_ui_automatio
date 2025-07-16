package com.hhstechgroup.internal_user;


import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class prints values displayed on the Provider information header panel
 */
public class ProviderDetails extends BaseActions {

    /**
     * This constructor method creates a ProviderDetails object using driver and wait arguments
     * @param driver
     * @param wait
     */
    public ProviderDetails(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method prints the Provider Name, Speciality, ID and Type values displayed on the Provider
     * information header panel (dataConversion and Sanity only)
     */
    public void verifyMainProviderDetails() {
        System.out.println(driver.findElement(Locators.FIRST_NAME_PROVIDER_DETAILS).getText());
        //System.out.println(driver.findElement(Locators.DOB_PROVIDER_DETAILS).getText());
        System.out.println(driver.findElement(Locators.SPECIALITY_PROVIDER_DETAILS).getText());
        System.out.println(driver.findElement(Locators.ID_PROVIDER_DETAILS).getText());
        //System.out.println(driver.findElement(Locators.GENDER_PROVIDER_DETAILS).getText());
        System.out.println(driver.findElement(Locators.TYPE_PROVIDER_DETAILS).getText());
    }
}
