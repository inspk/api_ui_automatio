package com.hhstechgroup.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Login class is provided as an intermediate class for shared functionality between action and any
 * stock implementation provided in this package.
 */
public class Login extends BaseActions {
    /**
     * This is a parameterized constructor
     * @param driver
     * @param wait
     */
    public Login(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method signs in
     */
    public void signIn() {
    }
}
