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

import static com.hhstechgroup.common.BaseActions.*;

@Listeners(VideoListener.class)
public class EntityEnrollmentRetroActiveSuspendReactivateTest extends BaseClassUI {

    /*1. Submission of the application and status verification on Provider Side
2. Internal user Workflow verification (all statuses per configuration and VyE)
3. Request Additional Information Verification (Internal user and Provider)
4. Resubmission of application process
5. Final Status Change verification (Approve the application)*/

    String testEmailAccount;
    String zipCode;
    String npi;
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.ENTITY_PROVIDER,
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
                {testEnvironment, testEmailAccount, Data.ENTITY_PROVIDER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(),  changeYearAndDayInCurrentDate(0, 0, -30)},
        };
    }

    @JiraDefectCreateIssue(isCreateIssue = true)
    @Video
    @Test(dataProvider = "Enrollment type", groups = {"ApprovingEntityProvider"})
    public void approvingRetroActivelySuspendReactivateEnrollment(String testEnvironment, String testEmailAccount, String enrollmentType,
                                                                    String providerEmailId, String firstName, String lastName, String enrollmentDate) throws Exception {

        createProviderAccount.createAndConfirmNewProviderAccount(testEmailAccount, environmentUrl, providerEmailId, providerEmailPassword, Data.nameOfOrg, firstName, lastName);
        addElements.put(Data.ENROLLMENT_DATE,enrollmentDate);
        enrollmentFormElements.setFormElements(addElements);

        requestSubmission.submitEnrollment(testEnvironment,enrollmentType,providerEmailId, providerEmailPassword, firstName,lastName,enrollmentFormElements);
        String trackingId = ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_SUBMITTED);

        requestStatusChange.enrollmentStatusChangeRetroActively(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, trackingId, screeningType, providerEmailId, providerEmailPassword, Data.APPLICATION_STATUS_APPROVE_RETROACTIVE, enrollmentFormElements);

        requestStatusChange.providerStatusChange(enrollmentType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingId, providerEmailId, providerEmailPassword, Data.APPLICATION_STATUS_SUSPENDED, enrollmentFormElements);

        requestStatusChange.providerStatusChange(enrollmentType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingId, providerEmailId, providerEmailPassword, Data.APPLICATION_STATUS_REACTIVATE_SUSPENDED, enrollmentFormElements);

    }
}