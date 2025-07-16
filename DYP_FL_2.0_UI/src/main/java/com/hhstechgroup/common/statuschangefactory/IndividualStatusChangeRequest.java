package com.hhstechgroup.common.statuschangefactory;


import com.hhstechgroup.Pages.*;
import com.hhstechgroup.common.*;
import com.hhstechgroup.utility.ExcelWrite;
import com.hhstechgroup.utility.ProviderInformation;
import com.hhstechgroup.utility.SDMongoDBHandler;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

import static com.hhstechgroup.common.BaseActions.changeDayInCurrentDate;

/**
 * This class represents a PEM enrollment Approval status change request
 */
public class IndividualStatusChangeRequest extends StatusChange {
    private String switchCase = "";
    protected String providerInfoSheet = "ProviderInfo.xlsx";
    ExcelWrite excel = new ExcelWrite(providerInfoSheet, 0);


    /**
     * This method performs Individual provider status changes.
     *
     * @param applicationStatus
     * @param iuEnrollmentPage
     * @throws InterruptedException
     */
    public void setStatusForProvider(String applicationStatus, IUEnrollmentPage iuEnrollmentPage, String providerID, EnrollmentFormElements enrollmentFormElements) throws IOException {

        int suspendOrTerminateDays = Integer.parseInt(enrollmentFormElements.formElements().get(Data.DAYS_TO_TERMINATE_SUSPEND));
        int reactiveDays = Integer.parseInt(enrollmentFormElements.formElements().get(Data.DAYS_TO_REACTIVATE));

        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.providerTypeIndividual, providerID);

        switch (applicationStatus) {
            case Data.APPLICATION_STATUS_SUSPENDED:
                //System.out.println("Suspend case: "+ applicationStatus);
//                    iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
                iuEnrollmentPage.iuProviderStatusChange(Data.APPLICATION_STATUS_SUSPENDED, Data.TEXT_SUSPEND, suspendOrTerminateDays);
                iuEnrollmentPage.clickProvidersTab();
                iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.providerTypeIndividual, providerID);
                iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_SUSPENDED);
                iuEnrollmentPage.navigateAndVerifyProvidersEnrollmentSpanStatus(Data.APPLICATION_STATUS_SUSPENDED, suspendOrTerminateDays);
                break;

            case Data.TEXT_TERMINATE:
                //System.out.println("Terminate case: "+ applicationStatus);
                iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
                iuEnrollmentPage.iuProviderStatusChange(Data.TEXT_TERMINATE, Data.TEXT_TERMINATE2, suspendOrTerminateDays);
                iuEnrollmentPage.clickProvidersTab();
                iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.providerTypeIndividual, providerID);
                iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_TERMINATED);
                iuEnrollmentPage.navigateAndVerifyProvidersEnrollmentSpanStatus(Data.APPLICATION_STATUS_TERMINATED, suspendOrTerminateDays);
                break;

            case Data.APPLICATION_STATUS_REACTIVATE_SUSPENDED:
                //System.out.println("Reactivate Suspend case: "+ applicationStatus);
//                    iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_REACTIVATE_SUSPENDED.substring(0, 9));
                iuEnrollmentPage.iuProviderStatusChange(Data.TEXT_REACTIVATE2, Data.TEXT_REACTIVATE, reactiveDays);
                iuEnrollmentPage.clickProvidersTab();
                iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.providerTypeIndividual, providerID);
                iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
                iuEnrollmentPage.navigateAndVerifyProvidersEnrollmentSpanStatus(Data.APPLICATION_STATUS_ACTIVE, reactiveDays);
                break;

            case Data.APPLICATION_STATUS_REACTIVATE_TERMINATED:
                //System.out.println("Reactivate Terminate case: "+ applicationStatus);
                iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_REACTIVATE_TERMINATED.substring(0, 10));
                iuEnrollmentPage.iuProviderStatusChange(Data.TEXT_REACTIVATE2, Data.TEXT_REACTIVATE, reactiveDays);
                iuEnrollmentPage.clickProvidersTab();
                iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.providerTypeIndividual, providerID);
                iuEnrollmentPage.verifyTheStatusOfApplication(Data.APPLICATION_STATUS_ACTIVE);
                iuEnrollmentPage.navigateAndVerifyProvidersEnrollmentSpanStatus(Data.APPLICATION_STATUS_ACTIVE, reactiveDays);
                break;
        }
    }

    public void setStatusForCoC(String environmentUrl, String enrollmentType,
                                String internalUserEmail, String internalUserPassword,
                                String firstName, String lastName, String trackingId,
                                String providerEmailId, String providerPwd, String applicationStatus,
                                IUEnrollmentPage iuEnrollmentPage, WebDriver driver, CocsPage cocsPage) throws InterruptedException {

        cocsPage.navigateToCoCAndSearchForTheProvider(trackingId);
        cocsPage.changeCocApplicationTo(Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
        cocsPage.cocUnderScreen(environmentUrl, trackingId);
        cocsPage.reviewAndVoteTheEnrollment(firstName, lastName);
        cocsPage.changeStatusWithReason(applicationStatus);
    }


    public void setStatusForReconsideration(String testEnvironment, String environmentUrl, String enrollmentType,
                                            String internalUserEmail, String internalUserPassword,
                                            String firstName, String lastName, String trackingNum,
                                            String newEmailId, String providerPwd,
                                            IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, ReconsiderationPage
                                                    reconsiderationPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String
                                                    applicationStatus) throws InterruptedException {

        switch (applicationStatus) {
            case Data.ApplicationStatusApprove:
                reconsiderationPage.navigateToReconsiderationAndSearchForTheProvider("", trackingNum);

                //Set the Reconsideration status
                reconsiderationPage.changeStatusWithReasonForReconsideration(applicationStatus);

                //Get the Provider ID from the Reconsideration
                String providersID = iuEnrollmentPage.getProvidersIDFromReconsideration();

                //Search for the Provider and set the application status
                iuEnrollmentPage.navigateBackToEnrollment();
                iuEnrollmentPage.searchProviderByTrackingNUm(providersID);
                iuEnrollmentPage.clickSearchResultRow();
                //  iuEnrollmentPage.changeStatusOfEnrollment(applicationStatus);

                //Update the status of the original denied enrollment based on the approval of the Reconsideration
                try {
                    ProviderInformation.updateProviderData(providerInfoSheet, Data.ENROLLMENT_APPLICATION_TYPE, firstName, lastName,
                            Data.APPLICATION_STATUS_ACTIVE, Data.ENROLLMENT_REQUEST_NO);
                    excel.readExcel();
                } catch (IOException e) {
                    Reports.log("IOException Found during Provider Info update for Individual Reconsideration: " + e);
                }
                break;

            case Data.ApplicationStatusDenied:
                //***********************************************************************************//
                //* TO DO: This case statement is not currently working and will need to be updated
                //* once the Deny Reconsideration functionality has been finalized
                //***********************************************************************************//

                //System.out.println("Approve Reconsideration case: "+ applicationStatus);.
                reconsiderationPage.navigateToReconsiderationAndSearchForTheProvider("", trackingNum);

                //Set the Reconsideration status
                reconsiderationPage.changeStatusWithReasonForReconsideration(applicationStatus);
                break;

        }

    }

    public void setReactivateTerminatedProviderStatus(String testEnvironment, String environmentUrl, String
            applicationType,
                                                      String internalUserEmail, String internalUserPassword,
                                                      String firstName, String lastName, String trackingNum,
                                                      String newEmailId, String providerPwd,
                                                      IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage
                                                              landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {
        iuEnrollmentPage.reactivateTheEnrollmentApplication();


    }

    public void setStatusForTerminationRequest(String testEnvironment, String environmentUrl, String
            applicationType,
                                               String internalUserEmail, String internalUserPassword,
                                               String firstName, String lastName, String trackingNum,
                                               String newEmailId, String providerPwd,
                                               IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, DashboardPage dashboardPage, LandingPage
                                                       landingPage, WebDriver driver, String applicationStatus) throws InterruptedException {


        //Internal user Operations..  ..
        iuEnrollmentPage.approveTerminationRequestStatus(Data.ApplicationStatusApprove);
    }

    public void setRevalidationStatus(String testEnvironment, String environmentUrl, String applicationType,
                                      String internalUserEmail, String internalUserPassword,
                                      String firstName, String lastName, String trackingNum,
                                      String newEmailId, String providerPwd,
                                      IUEnrollmentPage iuEnrollmentPage, LoginPage loginPage, ReconsiderationPage
                                              reconsiderationPage, DashboardPage dashboardPage, LandingPage landingPage, WebDriver driver, String
                                              applicationStatus) throws Exception {

        String revalidationTimePeriod = Data.revalAndRem1STNotificationDays;
        DataFiles data = new DataFiles();
        String filePath = ".\\src\\main\\java\\com\\hhstechgroup\\utility\\dataBaseconfig.properties";
        String dbName = data.getData("MongoDB_Database_Name", filePath);
        String dbName1 = data.getData("MongoDB_Database1_Name", filePath);
        String collection = data.getData("MongoDB_Collection_Name", filePath);

//         Navigates to Providers tab, Search and opens for a specific Provider.
        dashboardPage.clickEnrollTab();
        iuEnrollmentPage.searchProvider("", trackingNum);
        String prov_id = iuEnrollmentPage.getProvidersID();
        iuEnrollmentPage.clickProvidersTab();
        iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.INDIVIDUAL_PROVIDER_INITIALS, prov_id);
        String providerDataId = iuEnrollmentPage.getProviderDataId();

        //Get the Provider ID from the enrollment displayed in the search results
        String cookies = iuEnrollmentPage.collectCookies(environmentUrl.replace("https://", ""));
        iuEnrollmentPage.changeRevalidationDateAndVerify(environmentUrl, providerDataId, revalidationTimePeriod, cookies, changeDayInCurrentDate(Integer.parseInt(revalidationTimePeriod)));

        new SDMongoDBHandler().updateCollectionFieldValue(providerDataId, dbName, collection);
        new SDMongoDBHandler().updateCollectionFieldValue(providerDataId, dbName1, collection);

        iuEnrollmentPage.clickProvidersTab();
        String revalidationDate = iuEnrollmentPage.getProviderRevalidationDate(prov_id, "1st notification");
        iuEnrollmentPage.clickSearchResultRow();
        iuEnrollmentPage.navigateAndVerifyProvidersNextRevalidationStatus(revalidationDate);
    }


    public void setStatusForEnrollment(String testEnvironment, String environmentUrl, String enrollmentType, EnrollmentFormElements enrollmentFormElements,
                                       String applicationStatus, IUEnrollmentPage iuEnrollmentPage) throws IOException {


        String firstName = enrollmentFormElements.formElements().get(Data.FIRST_NAME);
        String lastName = enrollmentFormElements.formElements().get(Data.LAST_NAME);
        String trackingId = enrollmentFormElements.formElements().get(Data.TRACKING_ID);
        String retroactiveDate = enrollmentFormElements.formElements().get(Data.RETROACTIVE_DATE);
        String screeningType = enrollmentFormElements.formElements().get(Data.SCREENING_TYPE);


        switch (applicationStatus) {
            case Data.REQUESTED_ADDITIONAL_INFORMATION:
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId,
                        Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
                iuEnrollmentPage.searchProvider(firstName + " " + lastName, trackingId);
                iuEnrollmentPage.searchSpecificEnrollmentAndClick(3, Data.APPLICATION_STATUS_DOCUMENT_REVIEW);
                iuEnrollmentPage.changeStatusOfEnrollment(applicationStatus);
                break;

            case Data.APPLICATION_STATUS_APPROVE_RAI:
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
                iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.ApplicationStatusPendingReview);

//                //Change Status from Ready for Screening to Under Screening
//                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
//                //UnderScreening process
//                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.pendingReviewStatus);

                //Wave Site Visit
                iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);

                //Fingerprinting Workflow
                iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

                //Pending Review Workflow
                iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);
                iuEnrollmentPage.changeStatusOfEnrollment(Data.APPLICATION_STATUS_APPROVE_RAI.substring(0, 8));
                break;

            case Data.ApplicationStatusApprove:
            case Data.ApplicationStatusDenied:
                //System.out.println("Approve/Deny Enrollment case: "+ applicationStatus);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);

                iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.ApplicationStatusPendingReview);

//                //Change Status from Ready for Screening to Under Screening
//                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
//
//                //UnderScreening process
//                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.pendingReviewStatus);

                //Wave Site Visit
                iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);

                //Fingerprinting Workflow
                iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

                //Pending Review Workflow
                iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);

                iuEnrollmentPage.changeStatusOfEnrollment(applicationStatus);
                break;

            case Data.APPLICATION_STATUS_APPROVE_REVALIDATION:
                //System.out.println("Approve Revalidation Enrollment: "+ applicationStatus);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId,
                        Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
                iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.ApplicationStatusPendingReview);

//                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
//                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);

                //Wave Site Visit
                iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);

                //Fingerprinting Workflow
                iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);

                iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);
                iuEnrollmentPage.changeStatusOfEnrollment(Data.APPLICATION_STATUS_APPROVE_REVALIDATION.substring(0, 8));
                iuEnrollmentPage.verifyNextRevalidationYear(4);
                break;

            case Data.APPLICATION_STATUS_APPROVE_RETROACTIVE:
                //System.out.println("Approve/Deny Enrollment case: "+ applicationStatus);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId,
                        Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId,
                        Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
                iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.ApplicationStatusPendingReview);

//                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
//                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.pendingReviewStatus);

                iuEnrollmentPage.waveSiteVisitOnEnrollmentPage(Data.CREATE_SITE_VISIT);
                iuEnrollmentPage.VerifyFingerPrintButton(firstName, lastName);
                iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);
                iuEnrollmentPage.changeApplicationStatusRetroActively(Data.APPLICATION_STATUS_APPROVE_RETROACTIVE.substring(0, 8), enrollmentType, retroactiveDate, Data.APPROVED_RETROACTIVELY);
                iuEnrollmentPage.navigateBackToEnrollment();
                iuEnrollmentPage.searchProviderByTrackingNUm(trackingId);
                String prov_id = iuEnrollmentPage.getProvidersID();
                iuEnrollmentPage.clickProvidersTab();
                iuEnrollmentPage.navigateToPrvdrTabAndSearchForEnrollmentbyProvider(Data.INDIVIDUAL_PROVIDER_INITIALS, prov_id);
                iuEnrollmentPage.navigateAndVerifyProvidersEnrollmentSpanStatus(Data.APPLICATION_STATUS_ACTIVE,-30);
                break;

            case Data.APPLICATION_STATUS_APPROVE_RE_ENROLLMENT:
                //System.out.println("Approve Revalidation Enrollment: "+ applicationStatus);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId,
                        Data.APPLICATION_STATUS_NEW, Data.DROPDOWN_VALUE_DOC_REVIEW);
                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId,
                        Data.APPLICATION_STATUS_DOCUMENT_REVIEW, Data.DROPDOWN_VALUE_DOC_REVIEW_APPROVED);
                iuEnrollmentPage.performEnrollmentScreening(screeningType, environmentUrl, firstName, lastName, trackingId, Data.ApplicationStatusPendingReview);


//                iuEnrollmentPage.changeEnrollmentApplicationTo(firstName, lastName, trackingId, Data.APPLICATION_STATUS_READY_FOR_SCREENING, Data.DROPDOWN_VALUE_UNDER_SCREENING);
//                iuEnrollmentPage.enrollmentUnderScreen(testEnvironment, environmentUrl, firstName, lastName, trackingId, Data.statusPendingApproval);
//
                iuEnrollmentPage.reviewAndVoteTheEnrollment(firstName, lastName);
                iuEnrollmentPage.changeStatusOfEnrollment(Data.APPLICATION_STATUS_APPROVE_RE_ENROLLMENT.substring(0, 8));
                break;
        }
    }
    /**
     * This is a constructor
     */
    public IndividualStatusChangeRequest() {

    }

}
