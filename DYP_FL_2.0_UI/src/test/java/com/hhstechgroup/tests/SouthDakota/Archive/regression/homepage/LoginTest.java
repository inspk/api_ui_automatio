package com.hhstechgroup.tests.SouthDakota.Archive.regression.homepage;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassUI {

    /**
     * This test method verifies the all the links on the webPage
     */

    @Video
    @Test
    public void verifyLinksOnLoginPage() {
        Reports.log("The following Stories will be covered as part of this Test: \n PECS-675 \n PECS-679 \n PECS-759 ");
        loginPage.verifyKeyResourcesLinks();
        loginPage.verifyFooterLinksOnLoginPage() ;
        loginPage.verifyAndClickOnLink(Data.STATE_HOME_PAGE_LINK_BTN, Data.LINK_STATE_HOME_PAGE, Data.STATE_HOME_PAGE_LINK_URL);
        loginPage.verifyAndClickOnLink(Data.DISCLAIMER_LINK_BTN, Data.LINK_DISCLAIMER, Data.DISCLAIMER_LINK_URL);
        loginPage.verifyAndClickOnLink(Data.ACCESSIBILITY_LINK_BTN, Data.LINK_ACCESSIBILITY, Data.ACCESSIBILITY_LINK_URL );
        loginPage.verifyAndClickOnLink(Data.PRIVACY_LINK_BTN, Data.LINK_PRIVACY, Data.PRIVACY_LINK_URL );
        loginPage.verifyAndClickOnLink(Data.HIPAA_LINK_BTN, Data.LINK_HIPAA, Data.HIPAA_LINK_URL);
        loginPage.verifyContactUsLink();
    }
}
