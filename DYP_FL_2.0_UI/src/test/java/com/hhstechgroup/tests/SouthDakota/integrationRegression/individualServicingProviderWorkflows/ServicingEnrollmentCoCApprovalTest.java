package com.hhstechgroup.tests.SouthDakota.integrationRegression.individualServicingProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ProviderInformation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

public class ServicingEnrollmentCoCApprovalTest extends BaseClassUI {
    /*1. Submission of the CoC and status verification on Provider Side
        a. Have a scenario to add a primary service location
        b. Have a sceanrio to change a license data
        c. Have a scenario for identifying information change (Change last name).
      2. Internal user Workflow verification (all statuses per configuration and VyE)
      3. Approval Verification*/

    protected String providerInfoSheet = "ProviderInfo.xlsx";

    @Video
    @Test(dataProvider = "getServicingProviderNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void approvalAndVerifyingServicingProvCoC(String testEnvironment, String enrollmentType ,  String firstName,String lastName, String provideEmailID, String trackingId) throws Exception {

      String[] categoryList = {Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING,Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PROV_IDENTIFY};
        enrollmentType = Data.SERVICING_PROVIDER_COC;

        requestSubmission.submitCoC(testEnvironment, enrollmentType, provideEmailID, providerEmailPassword, firstName,lastName, categoryList);

        String cocID =  ProviderInformation.getTrackingNumber(providerInfoSheet, enrollmentType, Data.APPLICATION_STATUS_SUBMITTED);
         requestStatusChange.cocStatusChange(testEnvironment, environmentUrl, enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, cocID, provideEmailID, providerEmailPassword, Data.ApplicationStatusApprove);
    }
}
