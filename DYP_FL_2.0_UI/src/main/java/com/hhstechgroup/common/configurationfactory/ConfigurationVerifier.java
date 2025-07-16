package com.hhstechgroup.common.configurationfactory;

import com.hhstechgroup.Pages.DashboardPage;
import org.openqa.selenium.WebDriver;

/**
 *  This class creates the Configuration Verifier factory object
 */
public class ConfigurationVerifier {
    ConfigurationFactory factory;

    public ConfigurationVerifier(ConfigurationFactory factory) {this.factory = factory;}

    public void verifySystemOption(WebDriver driver, String systemOption, DashboardPage dashboardPage) throws Exception {
        factory.verifySystemOption(driver, systemOption, dashboardPage);
    }

}

