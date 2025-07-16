package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualBillingProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.HomePage;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.hhstechgroup.common.BaseActions.getCurrentDate;

@Listeners(VideoListener.class)
public class BillingProviderRegistrationAndSubmissionTest extends BaseClassUI {

    String testEmailAccount;
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);
    Map<String, String> addElements =  new HashMap<String, String>();

    /**
     * This test method returns a DataProvider containing testEmailAccount, Data.BILLING_PROVIDER,
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
                {testEnvironment,testEmailAccount,Data.BILLING_PROVIDER,
                        HomePage.generateEmail(providerEmailPrefix, "gmail.com"),
                        HomePage.generateFirstName(), HomePage.generateLastName(), Data.middleName, getCurrentDate()},
        };
    }


    @Video
    @Test(dataProvider = "Enrollment type", groups =  {"RegisterAndSubmitIndividualBillingProvider"}, invocationCount=3)
    public void enrollIndividualAsBillingProvider(String testEnvironment, String testEmailAccount,String enrollmentType,
                                                  String providerEmailId, String firstName, String lastName, String middleName, String date) throws Exception {

        createProviderAccount.createAndConfirmNewProviderAccount(testEmailAccount, environmentUrl, providerEmailId, providerEmailPassword, Data.nameOfOrg, firstName,
                lastName );

        addElements.put(Data.ENROLLMENT_DATE,date);
        enrollmentFormElements.setFormElements(addElements);

        requestSubmission.submitEnrollment(testEnvironment,enrollmentType,providerEmailId, providerEmailPassword, firstName,lastName,enrollmentFormElements);
    }
}
