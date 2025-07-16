package com.hhstechgroup.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * InboxIU class provides the functionality of internal user message section
 */
public class InboxIU extends BaseActions {

    /**
     * This is a parameterized constructor
     * @param driver
     * @param wait
     */
    public InboxIU(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * This method Opens Inbox and verifies each section in the message center
     */
    public void verifyMessageCenter(){
        Reports.log("Click Inbox tab");
        ajaxClick(Locators.MESSAGE_INBOX);

        Reports.log("Check Inbox tab");
        spanContainsText(Data.inboxTab);

        Reports.log("Check Sent tab");
        spanContainsText(Data.sentTab);

        Reports.log("Check Drafts tab");
        spanContainsText(Data.draftsTab);

        Reports.log("Check Archive tab");
        spanContainsText(Data.archiveTab);

        Reports.log("Check New message button");
        setAndFindButton(Data.TEXT_NEW_MESSAGE);

        driver.findElement(Locators.MESSAGE_INBOX);

    }

}
