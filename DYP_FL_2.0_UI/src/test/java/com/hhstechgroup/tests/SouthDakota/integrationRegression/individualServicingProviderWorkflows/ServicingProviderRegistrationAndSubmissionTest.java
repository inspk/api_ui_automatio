package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualServicingProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.hhstechgroup.common.BaseActions.*;
import static com.hhstechgroup.common.BaseActions.generateLastName;

@Listeners(VideoListener.class)
public class ServicingProviderRegistrationAndSubmissionTest extends BaseClassUI {

    String testEmailAccount;
    String zipCode;
    String npi;
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    String trackingNum;
    Map<String, String> addElements =  new HashMap<String, String>();

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.SERVICING_PROVIDER,
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
                {testEnvironment,testEmailAccount,Data.SERVICING_PROVIDER,
                        generateEmail(providerEmailPrefix, "gmail.com"),
                        generateFirstName(),generateLastName(), getCurrentDate()},
        };
    }

    @Video
    @Test(dataProvider = "Enrollment type", groups = {"SubmittedServicingEnrollmentApplication"}
//         ,   dependsOnGroups = {"ApprovedEntityProvider"}
    )
    public void approvingAndVerifyingServicingEnrollment(String testEnvironment, String testEmailAccount,String enrollmentType,
                                                         String providerEmailId, String firstName, String lastName, String date) throws Exception {

        createProviderAccount.createAndConfirmNewProviderAccount(testEmailAccount, environmentUrl, providerEmailId, providerEmailPassword, Data.nameOfOrg, firstName,lastName );
        requestSubmission.submitEnrollment(testEnvironment,enrollmentType,providerEmailId, providerEmailPassword, firstName,lastName,enrollmentFormElements);

    }
}
