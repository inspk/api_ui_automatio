package com.hhstechgroup.common;

import com.hhstechgroup.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrRegisterNewProviderAccount extends BaseActions {

    public SDHomePage sdhomePage = new SDHomePage(driver,wait);
    public LoginPage loginPage = new LoginPage(driver,wait);
    public Email email =new Email(driver,wait);
    public ProviderRegistrationPage providerRegistrationPage =new ProviderRegistrationPage(driver,wait);

    /**
     * This is a parameterized constructor
     * @param driver
     * @param wait
     */
    public CreateOrRegisterNewProviderAccount(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    /**
     * This is a Methods creates/Registers a new provider
     * @param testEmailAccount
     * @param environmentUrl
     * @param providerEmail
     * @param providerEmailPassword
     * @param OrgName
     * @param ProviderFirstName
     * @param ProviderLastName
     *
     */
    public void createAndConfirmNewProviderAccount(String testEmailAccount, String environmentUrl, String providerEmail, String providerEmailPassword, String OrgName,
                                        String ProviderFirstName, String ProviderLastName) throws  Exception {

        //Gmail Delete
        email.deleteTestAccountEmails(testEmailAccount);
        driver.get(environmentUrl);

        Reports.log("\nGo to Environment and Start Registration of Provider");
        providerRegistrationPage.openRegistrationPage();
        providerRegistrationPage.createNewProviderAccount(
                providerEmail,
                providerEmailPassword,
                OrgName,
                ProviderFirstName,
                ProviderLastName,
                sdhomePage.generateNewNumber(10));

        //Confirm Email
        email.openGmailAndClickConformAccountLink(providerEmail);
    }

}
