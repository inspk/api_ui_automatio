package com.hhstechgroup.tests.SouthDakota.Archive.regressionBaseline.iv_ORPEnrollment;

import com.automation.remarks.testng.VideoListener;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.tests.base.BaseClassUI;
import com.hhstechgroup.utility.ExcelWrite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

/**
 * This method contains a test which uses a data provider to get an approved ORP provider, Creates and denies an identifying information CoC.
 */

public class ORPProviderCoCDenyProcessTest extends BaseClassUI {

    String enrollmentType = Data.ORP_COC_APPLICATION;
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);


    /**
     * This method logs in as an approved ORP provider.Clicks on Coc button. then clicks on "Identifying Information"
     * , clears middle name filed, sends a random name and submits and store the tracking number. Then logs in as an
     * internal user and denies the Coc. For verification searches in Coc section to verify the status has changed to "Denied" and
     * writes the data into ProviderInfo.xlsx
     * @param firstName
     * @param lastName
     * @param emailID
     * @param taxonomy
     * @param npi
     * @param trackingNumber
     * @throws Exception
     */
    @Test(dataProvider = "getORPProviderNameEmailTaxNPIWithApprovedStatus",
            dataProviderClass = DataProviderForProviderInfo.class,dependsOnGroups = "ORPAppealApprove",groups = "ORPCocDeny")
    public void createDenyCocIdentifyingInformation(String testEnvironment, String firstName, String lastName, String emailID, String taxonomy, String npi, String trackingNumber) throws Exception {

        //Create and submit COC Identifying Information
        homePage.signInToApp(emailID, providerEmailPassword);
        coc.navigateToCoCTabAndClickCoCButton();

        coc.createCoCForEnrollment(Data.orpApplication, Data.COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING);
        coc.cocIdentifyingInformation();
        enrollmentsAndCoc.clickAnyButton(Data.TEXT_GO_TO_COC);

        //Get CoC ID
        String trackingNum = coc.getProviderCoCID();

        //Logout
        enrollmentPageInternalUser.logOut();

        //Login as Internal user and Change status of COC to denied
        homePage.signInToApp(internalUserEmail, internalUserPassword);

        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
        enrollmentsAndCoc.searchAndChangeStatusOFApplicationWithReason(Data.ApplicationStatusDenied);

        //Search For Denied CoC
        enrollmentPageInternalUser.navigateToCoCAndSearchForTheProvider("", trackingNum);
        enrollmentsAndCoc.searchSpecificEnrollmentAndClick(5, Data.pendingApproval, Data.APPLICATION_STATUS_DENIED_UPPERCASE);
        enrollmentsAndCoc.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_DENIED_UPPERCASE);

        //Logout
        enrollmentPageInternalUser.logOut();

        //Write Info to ProviderInfo
        excel.writeTestData(testEnvironment,enrollmentType, firstName, lastName, emailID, providerEmailPassword, taxonomy, npi, Data.ApplicationStatusDenied, trackingNum);
        excel.readExcel();
    }
}
