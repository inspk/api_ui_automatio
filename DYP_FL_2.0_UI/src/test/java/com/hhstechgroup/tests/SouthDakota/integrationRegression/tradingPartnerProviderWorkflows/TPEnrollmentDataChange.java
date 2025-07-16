package com.hhstechgroup.tests.SouthDakota.integrationRegression.tradingPartnerProviderWorkflows;

import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Test;

public class TPEnrollmentDataChange extends BaseClassUI {

    /*1. Submission of the application and status verification on Provider Side
2. Internal user Workflow verification (all statuses per configuration and VyE)
3. Approve the Enrollment
4. Internal user makes the data change
 */

    @Video
    @Test(dataProvider = "getTPNameAndEmailWithStatusActive", dataProviderClass = DataProviderForProviderInfo.class, priority = 3)
    public void modifyProviderDataAndVerify(String testEnvironment, String enrollmentType, String firstName, String lastName, String emailID, String trackingNum) throws Exception {

        requestSubmission.submitProviderDataChange(enrollmentType, internalUserEmail, internalUserPassword, firstName,
                lastName, emailID, providerEmailPassword, trackingNum);
    }
}
