package com.hhstechgroup.tests.SouthDakota.integrationRegression.entityProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



    /**
     * This test class verifies the Entity Enrollment RAI workflow
     */
    @Listeners(VideoListener.class)

    public class EntityEnrollmentRAITest extends BaseClassUI {

        String testEmailAccount;

        protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
        ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
        String trackingId;

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
                    {testEnvironment,testEmailAccount,Data.ENTITY_PROVIDER,
                            HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                            HomePage.generateFirstName(), HomePage.generateLastName()}
            };
        }


        /**
         * This test registers a Entity provider, submits an enrollment request and RAIs and approves the enrollment.
         *
         * @param testEnvironment
         * @param testEmailAccount
         * @param enrollmentType
         * @param providerEmailId
         * @param firstName
         * @param lastName
         * @throws Exception
         */
        @JiraDefectCreateIssue(isCreateIssue=true)
        @Video
        @Test(dataProvider = "Enrollment type", groups =  {"RegisterAndSubmitEntityProvider"})
        public void approveRAIForEntityProvider(String testEnvironment, String testEmailAccount,String enrollmentType,
                                             String providerEmailId, String firstName, String lastName) throws Exception {

            createProviderAccount.createAndConfirmNewProviderAccount(testEmailAccount, environmentUrl, providerEmailId, providerEmailPassword, Data.nameOfOrg, firstName,
                    lastName );

            requestSubmission.submitEnrollment(testEnvironment,enrollmentType,providerEmailId, providerEmailPassword, firstName,lastName,enrollmentFormElements);
             trackingId =  ProviderInformation.getTrackingNumber(providerInfoSheet,enrollmentType,Data.APPLICATION_STATUS_SUBMITTED);

            requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,enrollmentType,internalUserEmail,internalUserPassword,
                    firstName, lastName, trackingId, screeningType, providerEmailId, providerEmailPassword, Data.REQUESTED_ADDITIONAL_INFORMATION,enrollmentFormElements);

            // Login as Provider and Re-submit  the application
            requestSubmission.submitRAI(enrollmentType, firstName, lastName, providerEmailId,providerEmailPassword, Data.ApplicationStatusApprove);

            //Login as IU and Approve the application
            requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,enrollmentType,internalUserEmail,internalUserPassword,
                    firstName, lastName, trackingId, screeningType, providerEmailId, providerEmailPassword, Data.APPLICATION_STATUS_APPROVE_RAI, enrollmentFormElements);

        }
    }


