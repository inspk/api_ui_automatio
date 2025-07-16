package com.hhstechgroup.common.configurationfactory;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

/**
 * This concrete class extends the {@link Configuration} class and contains methods called
 * by the {@link ConfigurationFactory} class to verify the system option configuration.
 */
public class SOBuilder extends Configuration {

    protected SoftAssert softAssert = new SoftAssert();

    public void verifyBuilderSO(WebDriver driver) throws Exception{}


}
