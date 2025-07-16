package com.hhstechgroup.tests.SouthDakota.Archive.sanity;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)
public class LandingPageTests extends BaseClassUI {

    @Test
    public void testAllLinksAndImagesHTTPConnection() {
        // test=extent.createTest("testAllLinksAndImagesHTTPConnection");
        homePage.verifyLinksOnWebPage();
    }

}
