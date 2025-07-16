package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualServicingProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.hhstechgroup.common.BaseActions.*;

@Listeners(VideoListener.class)
public class ServicingEnrollmentApprovalTest extends BaseClassUI {

    /*1. Submission of the application and status verification on Provider Side
2. Internal user Workflow verification (all statuses per configuration and VyE)
3. Request Additional Information Verification (Internal user and Provider)
4. Resubmission of application process
5. Final Status Change verification (Approve the application)*/

    String testEmailAccount;
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String trackingId;
    Map<String, String> addElements =  new HashMap<String, String>();;

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.SERVICING_PROVIDER,
     * generateEmail(providerEmailPrefix, "gmail.com"), generateFirstName(),
     * generateLastName(), and  Data.middleName
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
                {testEnvironment,testEmailAccount,Data.SERVICING_PROVIDER,
                       generateEmail(providerEmailPrefix, "gmail.com"),
                       generateFirstName(),generateLastName(), getCurrentDate()},
        };
    }

    @Video
    @Test(dataProvider = "Enrollment type", groups = {"ApprovingServicingProvider"}
//         ,   dependsOnGroups = {"ApprovedEntityProvider"}
            )
    public void approvingAndVerifyingServicingEnrollment(String testEnvironment, String testEmailAccount,String enrollmentType,
                                                         String providerEmailId, String firstName, String lastName, String date) throws Exception {

        createProviderAccount.createAndConfirmNewProviderAccount(testEmailAccount, environmentUrl, providerEmailId, providerEmailPassword, Data.nameOfOrg, firstName,lastName );

        requestSubmission.submitEnrollment(testEnvironment,enrollmentType,providerEmailId, providerEmailPassword, firstName,lastName,enrollmentFormElements);

        trackingId =  ProviderInformation.getTrackingNumber(providerInfoSheet,enrollmentType,Data.APPLICATION_STATUS_SUBMITTED);

        requestStatusChange.enrollmentStatusChange(testEnvironment,environmentUrl,enrollmentType,internalUserEmail,internalUserPassword,
                firstName, lastName, trackingId, screeningType, providerEmailId, providerEmailPassword, Data.ApplicationStatusApprove, enrollmentFormElements);
    }
}
