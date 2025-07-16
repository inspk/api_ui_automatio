package com.hhstechgroup.tests.SouthDakota.Archive.regression.internaluser;

import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class IUCoCModuleTest extends BaseClassUI {

    @Test
    public void verifyCoCSearchFieldsTest() throws Exception {

        Reports.log("The following Stories will be covered as part of this test: \nPECS-1133");

        //login Application as an Internal User
        loginPage.signInToApp(internalUserEmail, internalUserPassword);

        //confirmAgreeAndSecureMessages();
        landingPage.confirmAgreeAndSecureMessages();

        //verify CoC Search Fields
        cocPage.verifyIUCoCSearchFields();

    }
}
