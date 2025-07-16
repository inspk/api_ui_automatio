package com.hhstechgroup.common.configurationfactory;

import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the system option configuration.
 */
public class SOUsers extends Configuration {

    protected SoftAssert softAssert = new SoftAssert();

    public void verifyUsersSO(WebDriver driver) throws Exception{}


}
