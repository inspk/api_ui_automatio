package com.hhstechgroup.tests.SouthDakota.Archive.IntegrationRefression;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hhstechgroup.common.BaseActions.*;

/**
 * This test class verifies the PEM Enroll Provider workflow
 */
@Listeners(VideoListener.class)

public class PEMEnrollPEMProviderTest extends BaseClassUI {
    String testEmailAccount;;

    protected String providerInfoSheet = "ProviderInfo.xlsx";

//    /**
//     * This test creates a PEM Enrolled Provider and approves it
//     *
//     * @param testEnvironment
//     //* @param testEmailAccount
//     //* @param enrollmentType
//     //* @param newEmail
//     //* @param PEMFirstName
//     //* @param PEMLastName
//     //* @param PEMMiddleName
//     * @throws Exception
//     */
//    @JiraDefectCreateIssue(isCreateIssue=true)
//    @Video
//    @Test(dataProvider = "getPEMProviderNameEMailTypeActive", dataProviderClass = DataProviderForProviderInfo.class)
//    public void submitPEMEnrolledProvider(String testEnvironment, String enrollmentType ,  String firstName, String lastName,
//                                          String PEMEmail, String trackingId) throws Exception {
//
//        String enrolledProviderEmail = HomePage.generateEmail(providerEmailPrefix, "gmail.com");
//        String enrolledProviderFName = HomePage.generateFirstName();
//        String enrolledProviderLName = HomePage.generateLastName();
//        String zipCode = sdhomePage.getRandomStringFromFile("SDZip");
//        String enrolledProviderHaveEmail = "NO";
//
//       //Submit the PEM Enrolled Provider request
//       requestSubmission.submitPEMEnrollProvider(testEnvironment, Data.PEM_PROVIDER, PEMEmail, providerEmailPassword,
//               enrolledProviderFName, enrolledProviderLName, enrolledProviderHaveEmail, enrolledProviderEmail, zipCode);
//
//        //Get the ID of the submitted PEM Enrolled Provide from the Provider Info sheet
//        String enrolledProviderTrackingID =  ProviderInformation.getTrackingNumber(providerInfoSheet, Data.PEM_PROVIDER,
//                Data.APPLICATION_STATUS_SUBMITTED);
//
//        //Set the status of the Enrolled Provider to 'Approved'
//        requestStatusChange.enrollmentStatusChange(testEnvironment, environmentUrl, Data.PEM_PROVIDER, internalUserEmail, internalUserPassword,
//                enrolledProviderFName, enrolledProviderLName, enrolledProviderTrackingID, enrolledProviderEmail, providerEmailPassword,
//                Data.ApplicationStatusApprove, enrollmentFormElements);
//
//    }

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.PEM_PROVIDER,
     * HomePage.generateEmail(providerEmailPrefix, "gmail.com"), HomePage.generateFirstName(),
     * HomePage.generateLastName(), and  Data.middleName
     *
     * @param context
     * @return Data object
     */
    @DataProvider(name = "Enrollment type")
    public Object[][] testSearchFeature(ITestContext context) {
        String testNGEmailAccount = context.getCurrentXmlTest().getParameter("testEmailAccount");
        String testEnvironment = context.getCurrentXmlTest().getParameter("environment");
        if (testNGEmailAccount.isBlank()) {
            testEmailAccount = Data.testEmailAccount;
        } else {
            testEmailAccount = testNGEmailAccount;
        }
        return new Object[][]{
                {testEnvironment,Data.PEM_PROVIDER,
                        generateEmail(providerEmailPrefix, "gmail.com"), generateFirstName(), generateLastName(),
                },
        };
    }


    /**
     * This test registers a PEM provider, submits an enrollment request and approves the enrollment.
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param enrollingProviderEmailId
     * @param enrollingProviderFirstName
     * @param enrollingProviderLastName
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "Enrollment type", groups =  {"PEMEnrollingBillingProvider"},dependsOnGroups = {"ApprovePEMProvider"}
    )
    public void pemEnrollingPEMProvider(String testEnvironment,String enrollmentType,
                                            String enrollingProviderEmailId, String enrollingProviderFirstName, String enrollingProviderLastName) throws Exception {

        String pemProviderEmailId = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.PEM_PROVIDER,Data.APPLICATION_STATUS_ACTIVE).get("ProviderEmailId");

        requestSubmission.pemEnrollingOtherProvider(testEnvironment,enrollmentType,pemProviderEmailId,enrollingProviderEmailId,providerPassword,enrollingProviderFirstName,enrollingProviderLastName,enrollmentFormElements);

//        Get the ID of the submitted PEM Enrolled Provide from the Provider Info sheet
        String enrolledProviderTrackingID =  ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_SUBMITTED);

        //Set the status of the Enrolled Provider to 'Approved'
        requestStatusChange.pemEnrollingOtherProviderStatusChange(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                pemProviderEmailId, enrollingProviderEmailId, enrollingProviderFirstName, enrollingProviderLastName,
                enrolledProviderTrackingID, screeningType, providerEmailPassword, Data.ApplicationStatusApprove);

    }
}
