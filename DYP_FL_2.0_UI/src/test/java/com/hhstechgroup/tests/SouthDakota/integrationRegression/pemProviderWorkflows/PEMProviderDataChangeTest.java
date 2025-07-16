package com.hhstechgroup.tests.SouthDakota.integrationRegression.pemProviderWorkflows;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.hhstechgroup.Pages.IUEnrollmentPage;
import com.hhstechgroup.common.DataProviderForProviderInfo;
import com.hhstechgroup.jira.JiraDefectCreateIssue;
import com.hhstechgroup.tests.base.BaseClassUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.hhstechgroup.Pages.CocsPage.*;

@Listeners(VideoListener.class)
public class PEMProviderDataChangeTest extends BaseClassUI {

    /**
     * This test performs a PEM Provider data change as an Internal User
     *
     * @param testEnvironment
     * @param enrollmentType
     * @param firstName
     * @param lastName
     * @param providerEmail
     * @param trackingNum
     * @throws Exception
     */
    @JiraDefectCreateIssue(isCreateIssue=true)
    @Video
    @Test(dataProvider = "getPEMProviderNameEMailTypeActive", dataProviderClass = DataProviderForProviderInfo.class)
    public void dataChangePEMProvider(String testEnvironment, String enrollmentType, String firstName, String lastName,
                                      String providerEmail, String trackingNum) throws Exception {

        //Set the IU Provider Enrollment Information section that contains the fields to be updated
        iuEnrollmentPage.setDataChangeEnrollmentTab(IUEnrollmentPage.IDENTIFYING_INFORMATION_TAB);

        //Build a list of fields to be updated and their corresponding XPaths
//        iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_FIRST_NAME, IDENTIFYING_INFO_XPATH_FIRST_NAME);
//        iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_LAST_NAME, IDENTIFYING_INFO_XPATH_LAST_NAME);
//        iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_PHONE, IDENTIFYING_INFO_XPATH_PHONE);
//        iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_FAX, IDENTIFYING_INFO_XPATH_FAX);
//        iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_ALT_EMAIL, IDENTIFYING_INFO_XPATH_ALT_EMAIL);
        iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_GENDER, IDENTIFYING_INFO_XPATH_GENDER);
        //iuEnrollmentPage.buildDataChangeFieldList(IDENTIFYING_INFO_FIELD_WEBSITE, IDENTIFYING_INFO_XPATH_WEBSITE);

        //Submit Data Change request
        requestSubmission.submitProviderDataChange(enrollmentType, internalUserEmail, internalUserPassword,
                firstName, lastName, providerEmail, providerEmailPassword, trackingNum);

    }
}
