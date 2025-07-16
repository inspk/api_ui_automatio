package com.hhstechgroup.tests.SouthDakota.Regression.Credentialing;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.io.IOException;


@Listeners(VideoListener.class)
public class CredentialingIdVerificationTestForEntity extends BaseClassUI {
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);


    @Video
    @Test(dataProvider = "getEntityProviderNameAndEmailWithStatusPendingReview",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "ApproveEntityEnrollmentApplication", groups = "credentialingForEntity"
    )
    public void credentialingForEntity(String testEnvironment, String firstName, String lastName, String trackingId) throws IOException {
//        SignIn to the application as internal User


        loginPage.signInToApp(internalUserEmail, internalUserPassword);


        //Agree the Secure Message
        landingPage.confirmAgreeAndSecureMessages();


        //Clicking On Credentialing page
        dashboardPage.clickcredentialingTab();


        //Adding the credentialing
        credentialingPage.clickedonaddcredentialing();


        credentialingPage.fillingCredentialinginformationEntity();
        credentialingPage.performCoReviewAndMedicalDirectorActions();
        dashboardPage.logOut();


    }


    @Test(dataProvider = "getEntityProviderNameAndEmailWithStatusPendingReview",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "credentialingForEntity", groups = "assigningCredentialing")
    public void assigningCredentialing(String testEnvironment, String firstName, String lastName, String trackingId) {


        loginPage.signInToApp("cvocommitteereview.user.dyp+cd@gmail.com", internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        credentialingPage.AssigningtoCVOMedicalDirectorActions();
        dashboardPage.logOut();


    }


    @Test(dataProvider = "getIndBillingProviderNameWithStatusSubmitted",
            dataProviderClass = DataProviderForProviderInfo.class,
            dependsOnGroups = "assigningCredentialing")
    public void approvingCredentialing(String testEnvironment, String firstName, String lastName, String trackingId) {


        loginPage.signInToApp("cvomedicaldirector.user.dyp+cd@gmail.com", internalUserPassword);
        landingPage.confirmAgreeAndSecureMessages();
        dashboardPage.clickcredentialingTab();
        credentialingPage.crdentialingapprovalCVOMedicalDirector();
        dashboardPage.logOut();


    }


}


