package com.hhstechgroup.common.configurationfactory.SORoles;

import com.hhstechgroup.Pages.DashboardPage;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.common.configurationfactory.Configuration;
import com.hhstechgroup.common.configurationfactory.SORoles.Constant.SORolesConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;

public class SORolesForensicSupervisor extends Configuration {
    private static final String SPLITTER = "_";
    private static final String PROVIDER_TYPE = "Forensic Supervisor";
    //Xpath Strings can be found under the SORolesConstant Class

    //XPath Strings
    //***NOTE: Each string contains two parts, a Parameter identifier (before the '_') and the XPath (after the '_').
    //***NOTE: Both parts are parsed prior to the Switch and used by the Case statements
    private static final By ROLE_FORENSIC_SUPERVISOR = By.xpath("//span[text() = '" + PROVIDER_TYPE + "']//parent::a");
    //*****************************************************************************************************************

    //Expected Values
    //*****************************************************************************************************************

    //General Section
    private static final String FS_GENERAL_SWITCH_EXPECTED = "true";
    private static final String FS_GENERAL_READ_EXPECTED = "true";
    private static final String FS_GENERAL_EDIT_EXPECTED = "true";
    private static final String FS_GENERAL_CREATE_EXPECTED = "false";
    private static final String FS_GENERAL_DELETE_EXPECTED = "false";
    private static final String FS_GENERAL_PHI_READ_EXPECTED = "true";
    private static final String FS_GENERAL_PHI_EDIT_EXPECTED = "true";
    private static final String FS_GENERAL_PHI_CREATE_EXPECTED = "false";
    private static final String FS_GENERAL_PHI_DELETE_EXPECTED = "false";
    private static final String FS_GENERAL_PII_READ_EXPECTED = "true";
    private static final String FS_GENERAL_PII_EDIT_EXPECTED = "true";
    private static final String FS_GENERAL_PII_CREATE_EXPECTED = "false";
    private static final String FS_GENERAL_PII_DELETE_EXPECTED = "false";
    private static final String FS_GENERAL_FTI_READ_EXPECTED = "true";
    private static final String FS_GENERAL_FTI_EDIT_EXPECTED = "true";
    private static final String FS_GENERAL_FTI_CREATE_EXPECTED = "false";
    private static final String FS_GENERAL_FTI_DELETE_EXPECTED = "false";
    //*****************************************************************************************************************

    //Dashboard Section
    private static final String FS_DASHBOARD_SWITCH_EXPECTED = "true";
    private static final String FS_DASHBOARD_DISPLAY_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_DISPLAY_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_DISPLAY_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_DISPLAY_DELETE_EXPECTED = "false";
    private static final String FS_DASHBOARD_ENROLLMENTS_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_ENROLLMENTS_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_ENROLLMENTS_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_ENROLLMENTS_DELETE_EXPECTED = "false";
    private static final String FS_DASHBOARD_APPEALS_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_APPEALS_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_APPEALS_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_APPEALS_DELETE_EXPECTED = "false";
    private static final String FS_DASHBOARD_COC_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_COC_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_COC_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_COC_DELETE_EXPECTED = "false";
    private static final String FS_DASHBOARD_SITE_VISIT_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_SITE_VISIT_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_SITE_VISIT_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_SITE_VISIT_DELETE_EXPECTED = "false";
    private static final String FS_DASHBOARD_ALL_REQUESTS_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_ALL_REQUESTS_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_ALL_REQUESTS_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_ALL_REQUESTS_DELETE_EXPECTED = "false";
    private static final String FS_DASHBOARD_CHARTS_READ_EXPECTED = "true";
    private static final String FS_DASHBOARD_CHARTS_EDIT_EXPECTED = "false";
    private static final String FS_DASHBOARD_CHARTS_CREATE_EXPECTED = "false";
    private static final String FS_DASHBOARD_CHARTS_DELETE_EXPECTED = "false";
    //*****************************************************************************************************************

    // Provider Section
    private static final String FS_PROVIDER_SWITCH_EXPECTED = "true";
    private static final String FS_PROVIDER_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_SUMMARY_PAGE_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_DISPLAY_SUMMARY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_SUMMARY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_DISPLAY_SUMMARY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_AFFILIATION_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_AFFILIATION_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_AFFILIATION_INFORMATION_CREATE_EXPECTED= "true";
    private static final String FS_PROVIDER_AFFILIATION_INFORMATION_DELETE_EXPECTED= "true";
    private static final String FS_PROVIDER_FILES_AND_DOCUMENTS_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_FILES_AND_DOCUMENTS_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_FILES_AND_DOCUMENTS_CREATE_EXPECTED= "true";
    private static final String FS_PROVIDER_FILES_AND_DOCUMENTS_DELETE_EXPECTED= "true";
    private static final String FS_PROVIDER_SUSPEND_PROVIDER_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_SUSPEND_PROVIDER_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_SUSPEND_PROVIDER_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_SUSPEND_PROVIDER_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_TERMINATE_PROVIDER_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_TERMINATE_PROVIDER_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_TERMINATE_PROVIDER_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_TERMINATE_PROVIDER_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_DEATH_DATE_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_DEATH_DATE_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_DEATH_DATE_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_DEATH_DATE_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_TRADING_PARTNER_AGENT_ID_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_TRADING_PARTNER_AGENT_ID_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_TRADING_PARTNER_AGENT_ID_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_TRADING_PARTNER_AGENT_ID_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_REACTIVATE_PROVIDER_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_REACTIVATE_PROVIDER_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_REACTIVATE_PROVIDER_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_REACTIVATE_PROVIDER_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_RETROACTIVATE_PROVIDER_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_RETROACTIVATE_PROVIDER_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_RETROACTIVATE_PROVIDER_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_RETROACTIVATE_PROVIDER_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_EDIT_AFFILIATION_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_EDIT_AFFILIATION_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_EDIT_AFFILIATION_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_EDIT_AFFILIATION_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_SERVICE_LOCATION_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_SERVICE_LOCATION_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_SERVICE_LOCATION_CREATE_EXPECTED= "true";
    private static final String FS_PROVIDER_SERVICE_LOCATION_DELETE_EXPECTED= "true";
    private static final String FS_PROVIDER_MONITORING_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_MONITORING_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_MONITORING_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_MONITORING_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_ENROLLMENT_SPAN_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_ENROLLMENT_SPAN_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_ENROLLMENT_SPAN_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_ENROLLMENT_SPAN_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_HISTORY_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_HISTORY_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_HISTORY_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_HISTORY_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_TIMELINE_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_TIMELINE_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_TIMELINE_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_TIMELINE_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_REVALIDATION_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_REVALIDATION_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_REVALIDATION_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_REVALIDATION_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_MESSAGES_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_MESSAGES_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_MESSAGES_CREATE_EXPECTED= "true";
    private static final String FS_PROVIDER_MESSAGES_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_SITE_VISITS_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_SITE_VISITS_EDIT_EXPECTED= "false";
    private static final String FS_PROVIDER_SITE_VISITS_CREATE_EXPECTED= "false";
    private static final String FS_PROVIDER_SITE_VISITS_DELETE_EXPECTED= "false";
    private static final String FS_PROVIDER_NOTES_READ_EXPECTED= "true";
    private static final String FS_PROVIDER_NOTES_EDIT_EXPECTED= "true";
    private static final String FS_PROVIDER_NOTES_CREATE_EXPECTED= "true";
    private static final String FS_PROVIDER_NOTES_DELETE_EXPECTED= "true";
    //*****************************************************************************************************************

    //Enrollments Section
    private static final String FS_ENROLLMENT_SWITCH_EXPECTED = "true";
    private static final String FS_ENROLLMENT_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_APPLICATION_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_APPLICATION_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_APPLICATION_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_APPLICATION_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_SCREENING_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_SCREENING_EDIT_EXPECTED= "false";
    private static final String FS_ENROLLMENT_SCREENING_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_SCREENING_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_FILES_AND_DOCUMENTS_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_FILES_AND_DOCUMENTS_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_FILES_AND_DOCUMENTS_CREATE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_FILES_AND_DOCUMENTS_DELETE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_NOTES_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_NOTES_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_NOTES_CREATE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_NOTES_DELETE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_EDIT_AFFILIATION_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_EDIT_AFFILIATION_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_EDIT_AFFILIATION_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_EDIT_AFFILIATION_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CREATE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_DELETE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_CREATE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_DELETE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_SERVICE_LOCATION_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_SERVICE_LOCATION_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_SERVICE_LOCATION_CREATE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_SERVICE_LOCATION_DELETE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_CREATE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_DELETE_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED= "true";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED= "false";
    private static final String FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED= "false";

    //*****************************************************************************************************************

    //COC Section
    private static final String FS_COC_SWITCH_EXPECTED = "true";
    private static final String FS_COC_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_COC_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_COC_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_COC_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_COC_APPLICATION_READ_EXPECTED= "true";
    private static final String FS_COC_APPLICATION_EDIT_EXPECTED= "true";
    private static final String FS_COC_APPLICATION_CREATE_EXPECTED= "false";
    private static final String FS_COC_APPLICATION_DELETE_EXPECTED= "false";
    private static final String FS_COC_SCREENING_READ_EXPECTED= "true";
    private static final String FS_COC_SCREENING_EDIT_EXPECTED= "false";
    private static final String FS_COC_SCREENING_CREATE_EXPECTED= "false";
    private static final String FS_COC_SCREENING_DELETE_EXPECTED= "false";
    private static final String FS_COC_FILES_AND_DOCUMENTS_READ_EXPECTED= "true";
    private static final String FS_COC_FILES_AND_DOCUMENTS_EDIT_EXPECTED= "true";
    private static final String FS_COC_FILES_AND_DOCUMENTS_CREATE_EXPECTED= "true";
    private static final String FS_COC_FILES_AND_DOCUMENTS_DELETE_EXPECTED= "true";
    private static final String FS_COC_NOTES_READ_EXPECTED= "true";
    private static final String FS_COC_NOTES_EDIT_EXPECTED= "true";
    private static final String FS_COC_NOTES_CREATE_EXPECTED= "true";
    private static final String FS_COC_NOTES_DELETE_EXPECTED= "true";
    private static final String FS_COC_MESSAGES_READ_EXPECTED= "true";
    private static final String FS_COC_MESSAGES_EDIT_EXPECTED= "true";
    private static final String FS_COC_MESSAGES_CREATE_EXPECTED= "true";
    private static final String FS_COC_MESSAGES_DELETE_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_CREATE_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_DELETE_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED= "true";
    private static final String FS_COC_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED= "false";
    private static final String FS_COC_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_CREATE_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_DELETE_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_NEW_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_DENIED_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_ASSIGNEE_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_CREATE_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_DELETE_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED= "true";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED= "false";
    private static final String FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED= "false";
    private static final String FS_COC_REQUESTS_AVAILABILITY_READ_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_EDIT_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_CREATE_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DELETE_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_READ_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_EDIT_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_CREATE_EXPECTED= "false";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_DELETE_EXPECTED= "false";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_READ_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Authorization Section
    private static final String FS_AUTHORIZATION_SWITCH_EXPECTED = "true";
    private static final String FS_AUTHORIZATION_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_APPLICATION_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_APPLICATION_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_APPLICATION_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_APPLICATION_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_SCREENING_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_SCREENING_EDIT_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_SCREENING_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_SCREENING_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_FILES_AND_DOCUMENTS_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_FILES_AND_DOCUMENTS_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_FILES_AND_DOCUMENTS_CREATE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_FILES_AND_DOCUMENTS_DELETE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_NOTES_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_NOTES_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_NOTES_CREATE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_NOTES_DELETE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_ADD_REQUEST_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_ADD_REQUEST_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_ADD_REQUEST_CREATE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_ADD_REQUEST_DELETE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_CREATE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_DELETE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_CREATE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_DELETE_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED= "true";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED= "false";
    private static final String FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Reconsideration Section
    private static final String FS_RECONSIDERATION_SWITCH_EXPECTED = "true";
    private static final String FS_RECONSIDER_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_RECONSIDER_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_APPLICATION_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_APPLICATION_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_APPLICATION_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_APPLICATION_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_SCREENING_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_SCREENING_EDIT_EXPECTED= "false";
    private static final String FS_RECONSIDER_SCREENING_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_SCREENING_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_FILES_AND_DOCUMENTS_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_FILES_AND_DOCUMENTS_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_FILES_AND_DOCUMENTS_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_FILES_AND_DOCUMENTS_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_NOTES_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_NOTES_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_NOTES_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_NOTES_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_HEARING_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_HEARING_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_HEARING_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_HEARING_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_NEW_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_CREATE_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DELETE_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_DELETE_EXPECTED= "false";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_READ_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Payment Section
    private static final String FS_PAYMENTS_SWITCH_EXPECTED = "true";
    private static final String FS_PAYMENTS_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_PAYMENTS_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_PAYMENTS_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_PAYMENTS_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_PAYMENTS_DISPLAY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_PAYMENTS_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_PAYMENTS_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_PAYMENTS_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_READ_EXPECTED= "true";
    private static final String FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_EDIT_EXPECTED= "false";
    private static final String FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_CREATE_EXPECTED= "false";
    private static final String FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_DELETE_EXPECTED= "false";
    private static final String FS_PAYMENTS_RA_DOCUMENT_PRINT_READ_EXPECTED= "true";
    private static final String FS_PAYMENTS_RA_DOCUMENT_PRINT_EDIT_EXPECTED= "false";
    private static final String FS_PAYMENTS_RA_DOCUMENT_PRINT_CREATE_EXPECTED= "false";
    private static final String FS_PAYMENTS_RA_DOCUMENT_PRINT_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Claims Section
    private static final String FS_CLAIM_SWITCH_EXPECTED = "true";
    private static final String FS_CLAIMS_DISPLAY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_CLAIMS_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_CLAIMS_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_CLAIMS_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_READ_EXPECTED= "true";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_EDIT_EXPECTED= "false";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_CREATE_EXPECTED= "false";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_DELETE_EXPECTED= "false";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_PRINT_READ_EXPECTED= "true";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_PRINT_EDIT_EXPECTED= "false";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_PRINT_CREATE_EXPECTED= "false";
    private static final String FS_CLAIMS_DETAILS_DOCUMENT_PRINT_DELETE_EXPECTED= "false";

//*****************************************************************************************************************

    //1099 Section
    private static final String FS_1099_SWITCH_EXPECTED = "true";
    private static final String FS_1099_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_1099_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_1099_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_1099_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_1099_DISPLAY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_1099_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_1099_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_1099_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_1099_DETAILS_DOCUMENT_DOWNLOAD_READ_EXPECTED= "true";
    private static final String FS_1099_DETAILS_DOCUMENT_DOWNLOAD_EDIT_EXPECTED= "false";
    private static final String FS_1099_DETAILS_DOCUMENT_DOWNLOAD_CREATE_EXPECTED= "false";
    private static final String FS_1099_DETAILS_DOCUMENT_DOWNLOAD_DELETE_EXPECTED= "false";
    private static final String FS_1099_DETAILS_DOCUMENT_PRINT_READ_EXPECTED= "true";
    private static final String FS_1099_DETAILS_DOCUMENT_PRINT_EDIT_EXPECTED= "false";
    private static final String FS_1099_DETAILS_DOCUMENT_PRINT_CREATE_EXPECTED= "false";
    private static final String FS_1099_DETAILS_DOCUMENT_PRINT_DELETE_EXPECTED= "false";

//*****************************************************************************************************************

    //Message Box Section
    private static final String FS_MESSAGEBOX_SWITCH_EXPECTED = "true";
    private static final String FS_MESSAGEBOX_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_MESSAGE_READ_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_MESSAGE_EDIT_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_MESSAGE_CREATE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_MESSAGE_DELETE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_ATTACHMENT_READ_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_ATTACHMENT_EDIT_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_ATTACHMENT_CREATE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_SEND_ATTACHMENT_DELETE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_ARCHIVE_MESSAGE_READ_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_ARCHIVE_MESSAGE_EDIT_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_ARCHIVE_MESSAGE_CREATE_EXPECTED= "true";
    private static final String FS_MESSAGEBOX_ARCHIVE_MESSAGE_DELETE_EXPECTED= "true";

//*****************************************************************************************************************

    //Reports Section
    private static final String FS_REPORTS_SWITCH_EXPECTED = "true";
    private static final String FS_REPORTS_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_REPORTS_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_CANNED_PAGE_READ_EXPECTED= "true";
    private static final String FS_REPORTS_DISPLAY_CANNED_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_CANNED_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_CANNED_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_LETTER_PAGE_READ_EXPECTED= "true";
    private static final String FS_REPORTS_DISPLAY_LETTER_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_LETTER_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_LETTER_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_REPORTS_DISPLAY_AD_HOC_PAGE_READ_EXPECTED= "true";
    private static final String FS_REPORTS_DISPLAY_AD_HOC_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_REPORTS_DISPLAY_AD_HOC_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_REPORTS_DISPLAY_AD_HOC_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_REPORTS_AD_HOC_REPORTS_READ_EXPECTED= "true";
    private static final String FS_REPORTS_AD_HOC_REPORTS_EDIT_EXPECTED= "false";
    private static final String FS_REPORTS_AD_HOC_REPORTS_CREATE_EXPECTED= "false";
    private static final String FS_REPORTS_AD_HOC_REPORTS_DELETE_EXPECTED= "false";

//*****************************************************************************************************************

    //Site Visit Section
    private static final String FS_SITE_VISIT_SWITCH_EXPECTED = "true";
    private static final String FS_SITE_VISIT_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_DISPLAY_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_SEARCH_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_SEARCH_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_SEARCH_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_SEARCH_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_REQUEST_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_REQUEST_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_REQUEST_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_REQUEST_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_ADD_SITE_VISIT_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_ADD_SITE_VISIT_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_ADD_SITE_VISIT_CREATE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_ADD_SITE_VISIT_DELETE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_FILES_AND_DOCUMENTS_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_FILES_AND_DOCUMENTS_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_FILES_AND_DOCUMENTS_CREATE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_FILES_AND_DOCUMENTS_DELETE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_NOTES_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_NOTES_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_NOTES_CREATE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_NOTES_DELETE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_CREATE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_DELETE_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_AVAILABILITY_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_AVAILABILITY_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_AVAILABILITY_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_AVAILABILITY_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_DELETE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_READ_EXPECTED= "true";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_EDIT_EXPECTED= "true";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_CREATE_EXPECTED= "false";
    private static final String FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_DELETE_EXPECTED= "false";

//*****************************************************************************************************************

    //Help Center Section
    private static final String FS_HELP_CENTER_SWITCH_EXPECTED = "true";
    private static final String FS_HELPCENTER_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_HELPCENTER_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_HELPCENTER_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_HELPCENTER_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_HELPCENTER_LINK_READ_EXPECTED= "true";
    private static final String FS_HELPCENTER_LINK_EDIT_EXPECTED= "false";
    private static final String FS_HELPCENTER_LINK_CREATE_EXPECTED= "false";
    private static final String FS_HELPCENTER_LINK_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Chat Section
    private static final String FS_CHAT_SWITCH_EXPECTED = "true";
    private static final String FS_CHAT_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_CHAT_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_CHAT_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_CHAT_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_CHAT_SEND_FILES_READ_EXPECTED= "true";
    private static final String FS_CHAT_SEND_FILES_EDIT_EXPECTED= "false";
    private static final String FS_CHAT_SEND_FILES_CREATE_EXPECTED= "false";
    private static final String FS_CHAT_SEND_FILES_DELETE_EXPECTED= "false";

//*****************************************************************************************************************

    //System Properties Section
    private static final String FS_SYSTEM_PROPERTIES_SWITCH_EXPECTED = "true";
    private static final String FS_SYS_PROP_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_DISPLAY_EDIT_EXPECTED= "false";
    private static final String FS_SYS_PROP_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_USERS_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USERS_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_ROLES_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_ROLES_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_APPROVALS_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_APPROVALS_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_APPROVALS_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_APPROVALS_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_BUILDER_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_BUILDER_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_BUILDER_DISPLAY_PAGE_CREATE_EXPECTED= "true";
    private static final String FS_SYS_PROP_BUILDER_DISPLAY_PAGE_DELETE_EXPECTED= "true";
    private static final String FS_SYS_PROP_BUILDER_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_BUILDER_DETAILS_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_SYS_PROP_BUILDER_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_BUILDER_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_LICENSURE_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_LICENSURE_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_LICENSURE_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_LICENSURE_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_READ_EXPECTED= "true";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Voting Section
    private static final String FS_VOTING_SWITCH_EXPECTED = "true";
    private static final String FS_VOTING_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_VOTING_DISPLAY_EDIT_EXPECTED= "false";
    private static final String FS_VOTING_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_VOTING_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_VOTING_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_VOTING_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_VOTING_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_VOTING_DISPLAY_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Audit Section
    private static final String FS_AUDIT_SWITCH_EXPECTED = "true";
    private static final String FS_AUDIT_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_AUDIT_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_AUDIT_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_AUDIT_DISPLAY_PAGE_DELETE_EXPECTED= "false";
    private static final String FS_AUDIT_SEARCH_READ_EXPECTED= "true";
    private static final String FS_AUDIT_SEARCH_EDIT_EXPECTED= "false";
    private static final String FS_AUDIT_SEARCH_CREATE_EXPECTED= "false";
    private static final String FS_AUDIT_SEARCH_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //EDI Section
    private static final String FS_EDI_SWITCH_EXPECTED = "true";
    private static final String FS_EDI_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_EDI_DISPLAY_EDIT_EXPECTED= "false";
    private static final String FS_EDI_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_EDI_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_EDI_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_EDI_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_EDI_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_EDI_DISPLAY_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Mediboook
    private static final String FS_MEDIBOOK_SWITCH_EXPECTED = "true";
    private static final String FS_MEDIBOOK_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_MEDIBOOK_DISPLAY_EDIT_EXPECTED= "false";
    private static final String FS_MEDIBOOK_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_MEDIBOOK_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_MEDIBOOK_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_MEDIBOOK_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_MEDIBOOK_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_MEDIBOOK_DISPLAY_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Payers Section
    private static final String FS_PAYERS_SWITCH_EXPECTED = "true";
    private static final String FS_PAYER_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_PAYER_DISPLAY_EDIT_EXPECTED= "false";
    private static final String FS_PAYER_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_PAYER_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_PAYER_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_PAYER_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_PAYER_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_PAYER_DISPLAY_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    //Affiliation Section
    private static final String FS_AFFILIATION_SWITCH_EXPECTED = "true";
    private static final String FS_AFFILIATION_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_AFFILIATION_DISPLAY_EDIT_EXPECTED= "true";
    private static final String FS_AFFILIATION_DISPLAY_CREATE_EXPECTED= "true";
    private static final String FS_AFFILIATION_DISPLAY_DELETE_EXPECTED= "true";
    private static final String FS_AFFILIATION_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_AFFILIATION_DISPLAY_PAGE_EDIT_EXPECTED= "true";
    private static final String FS_AFFILIATION_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_AFFILIATION_DISPLAY_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    // Documents Section
    private static final String FS_DOCUMENTS_SWITCH_EXPECTED = "true";
    private static final String FS_DOCUMENTS_DISPLAY_READ_EXPECTED= "true";
    private static final String FS_DOCUMENTS_DISPLAY_EDIT_EXPECTED= "false";
    private static final String FS_DOCUMENTS_DISPLAY_CREATE_EXPECTED= "false";
    private static final String FS_DOCUMENTS_DISPLAY_DELETE_EXPECTED= "false";
    private static final String FS_DOCUMENTS_DISPLAY_PAGE_READ_EXPECTED= "true";
    private static final String FS_DOCUMENTS_DISPLAY_PAGE_EDIT_EXPECTED= "false";
    private static final String FS_DOCUMENTS_DISPLAY_PAGE_CREATE_EXPECTED= "false";
    private static final String FS_DOCUMENTS_DISPLAY_PAGE_DELETE_EXPECTED= "false";
//*****************************************************************************************************************

    /**
     * This method verifies the Forensic Supervisor Role in System Option Roles configuration
     *
     * @param driver        = driver
     * @param softAssert    = soft assert
     * @throws Exception    = Exception
     */
    public void verifyForensicSupervisor(WebDriver driver, DashboardPage dashboardPage, SoftAssert softAssert) throws Exception {

        //On the Roles page, click on the Forensic Supervisor Role
        dashboardPage.ajaxScrollUp();
        driver.findElement(ROLE_FORENSIC_SUPERVISOR).click();
        javaWaitSec(1);
        Reports.log("\n***************************************************************************");
        Reports.log("Verifying the Role Configuration for " + ROLE_FORENSIC_SUPERVISOR);
        Reports.log("***************************************************************************");

        //Create an Arraylist of Xpath/Expected values
        ArrayList<ArrayList<String>> generalConfigurationList =  generalBuildExpectedList();
        ArrayList<ArrayList<String>> dashboardConfigurationList = dashboardBuildExpectedList();
        ArrayList<ArrayList<String>> providersConfigurationList = providersBuildExpectedList();
        ArrayList<ArrayList<String>> enrollmentConfigurationList = enrollmentBuildExpectedList();
        ArrayList<ArrayList<String>> cocConfigurationList = cocBuildExpectedList();
        ArrayList<ArrayList<String>> authorizationConfigurationList = authorizationBuildExpectedList();
        ArrayList<ArrayList<String>> reconsiderationConfigurationList = reconsiderationBuildExpectedList();
        ArrayList<ArrayList<String>> paymentConfigurationList = paymentBuildExpectedList();
        ArrayList<ArrayList<String>> claimsConfigurationList = claimsBuildExpectedList();
        ArrayList<ArrayList<String>> p1099ConfigurationList = p1099BuildExpectedList();
        ArrayList<ArrayList<String>> messageBoxConfigurationList = messageBoxBuildExpectedList();
        ArrayList<ArrayList<String>> reportsConfigurationList = reportsBuildExpectedList();
        ArrayList<ArrayList<String>> siteVisitConfigurationList = siteVisitBuildExpectedList();
        ArrayList<ArrayList<String>> helpConfigurationList = helpBuildExpectedList();
        ArrayList<ArrayList<String>> chatConfigurationList = chatBuildExpectedList();
        ArrayList<ArrayList<String>> systemPropertiesConfigurationList = systemPropertiesBuildExpectedList();
        ArrayList<ArrayList<String>> votingConfigurationList = votingBuildExpectedList();
        ArrayList<ArrayList<String>> auditConfigurationList = auditBuildExpectedList();
        ArrayList<ArrayList<String>> ediConfigurationList = ediBuildExpectedList();
        ArrayList<ArrayList<String>> memberConfigurationList = memberBuildExpectedList();
        ArrayList<ArrayList<String>> payerConfigurationList = payerBuildExpectedList();
        ArrayList<ArrayList<String>> affiliationsConfigurationList = affiliationsBuildExpectedList();
        ArrayList<ArrayList<String>> documentsConfigurationList = documentsBuildExpectedList();

        //Send the Lists to the method that will verify the configurations against Expected
        verifyConfigurationParameters(driver, generalConfigurationList, softAssert);
        verifyConfigurationParameters(driver, dashboardConfigurationList, softAssert);
        verifyConfigurationParameters(driver, providersConfigurationList, softAssert);
        verifyConfigurationParameters(driver, enrollmentConfigurationList, softAssert);
        verifyConfigurationParameters(driver, cocConfigurationList, softAssert);
        verifyConfigurationParameters(driver, authorizationConfigurationList, softAssert);
        verifyConfigurationParameters(driver, reconsiderationConfigurationList, softAssert);
        verifyConfigurationParameters(driver, paymentConfigurationList, softAssert);
        verifyConfigurationParameters(driver, claimsConfigurationList, softAssert);
        verifyConfigurationParameters(driver, p1099ConfigurationList, softAssert);
        verifyConfigurationParameters(driver, messageBoxConfigurationList, softAssert);
        verifyConfigurationParameters(driver, reportsConfigurationList, softAssert);
        verifyConfigurationParameters(driver, siteVisitConfigurationList, softAssert);
        verifyConfigurationParameters(driver, helpConfigurationList, softAssert);
        verifyConfigurationParameters(driver, chatConfigurationList, softAssert);
        verifyConfigurationParameters(driver, systemPropertiesConfigurationList, softAssert);
        verifyConfigurationParameters(driver, votingConfigurationList, softAssert);
        verifyConfigurationParameters(driver, auditConfigurationList, softAssert);
        verifyConfigurationParameters(driver, ediConfigurationList, softAssert);
        verifyConfigurationParameters(driver, memberConfigurationList, softAssert);
        verifyConfigurationParameters(driver, payerConfigurationList, softAssert);
        verifyConfigurationParameters(driver, affiliationsConfigurationList, softAssert);
        verifyConfigurationParameters(driver, documentsConfigurationList, softAssert);
    }

    /**
     * Private method to be used by the Roles Method to set the parameters and iterates through and parses out the
     * String and xpaths indicated at the beginning of the class
     * @param driver                = driver
     * @param configurationList     = configuration list name to be passed
     * @param softAssert            = soft assert
     */
    private static void verifyConfigurationParameters(WebDriver driver, ArrayList<ArrayList<String>> configurationList, SoftAssert softAssert){

        String xpath;
        String configurationName;

        //Verify the configuration parameters associated with the Enrollment Type case
        for (ArrayList<String> stringArrayList : configurationList) {

            //Retrieve Configuration and expected value from the ArrayList
            String xpathString = String.valueOf(stringArrayList.get(0));
            String expectedValue = String.valueOf(stringArrayList.get(1));

            //Parse the name of the configuration to be verified and the associated Xpath from the
            //configuration Xpath string
            String[] configurationStringParts = xpathString.split(SPLITTER);
            configurationName = configurationStringParts[0];
            xpath = configurationStringParts[1];

            booleanTextCompare(driver, xpath, expectedValue, PROVIDER_TYPE + " " + configurationName, softAssert);
        }
    }

    /**
     * Parameter list for General Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> generalBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_SWITCH, FS_GENERAL_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_READ, FS_GENERAL_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_EDIT, FS_GENERAL_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_CREATE, FS_GENERAL_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_DELETE, FS_GENERAL_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PHI_READ, FS_GENERAL_PHI_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PHI_EDIT, FS_GENERAL_PHI_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PHI_CREATE, FS_GENERAL_PHI_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PHI_DELETE, FS_GENERAL_PHI_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PII_READ, FS_GENERAL_PII_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PII_EDIT, FS_GENERAL_PII_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PII_CREATE, FS_GENERAL_PII_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_PII_DELETE, FS_GENERAL_PII_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_FTI_READ, FS_GENERAL_FTI_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_FTI_EDIT, FS_GENERAL_FTI_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_FTI_CREATE, FS_GENERAL_FTI_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.GENERAL_FTI_DELETE, FS_GENERAL_FTI_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Dashboard Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> dashboardBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_SWITCH, FS_DASHBOARD_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_DISPLAY_READ, FS_DASHBOARD_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_DISPLAY_EDIT, FS_DASHBOARD_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_DISPLAY_CREATE, FS_DASHBOARD_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_DISPLAY_DELETE, FS_DASHBOARD_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ENROLLMENTS_READ, FS_DASHBOARD_ENROLLMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ENROLLMENTS_EDIT, FS_DASHBOARD_ENROLLMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ENROLLMENTS_CREATE, FS_DASHBOARD_ENROLLMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ENROLLMENTS_DELETE, FS_DASHBOARD_ENROLLMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_COC_READ, FS_DASHBOARD_COC_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_COC_EDIT, FS_DASHBOARD_COC_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_COC_CREATE, FS_DASHBOARD_COC_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_COC_DELETE, FS_DASHBOARD_COC_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_APPEALS_READ, FS_DASHBOARD_APPEALS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_APPEALS_EDIT, FS_DASHBOARD_APPEALS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_APPEALS_CREATE, FS_DASHBOARD_APPEALS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_APPEALS_DELETE, FS_DASHBOARD_APPEALS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ALL_REQUESTS_READ, FS_DASHBOARD_ALL_REQUESTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ALL_REQUESTS_EDIT, FS_DASHBOARD_ALL_REQUESTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ALL_REQUESTS_CREATE, FS_DASHBOARD_ALL_REQUESTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_ALL_REQUESTS_DELETE, FS_DASHBOARD_ALL_REQUESTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_CHARTS_READ, FS_DASHBOARD_CHARTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_CHARTS_EDIT, FS_DASHBOARD_CHARTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_CHARTS_CREATE, FS_DASHBOARD_CHARTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_CHARTS_DELETE, FS_DASHBOARD_CHARTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_SITE_VISIT_READ, FS_DASHBOARD_SITE_VISIT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_SITE_VISIT_EDIT, FS_DASHBOARD_SITE_VISIT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_SITE_VISIT_CREATE, FS_DASHBOARD_SITE_VISIT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DASHBOARD_SITE_VISIT_DELETE, FS_DASHBOARD_SITE_VISIT_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Providers Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> providersBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SWITCH, FS_PROVIDER_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_PAGE_READ, FS_PROVIDER_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_PAGE_EDIT, FS_PROVIDER_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_PAGE_CREATE, FS_PROVIDER_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_PAGE_DELETE, FS_PROVIDER_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_DETAILS_PAGE_READ, FS_PROVIDER_DISPLAY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_DETAILS_PAGE_EDIT, FS_PROVIDER_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_DETAILS_PAGE_CREATE, FS_PROVIDER_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_DETAILS_PAGE_DELETE, FS_PROVIDER_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_SUMMARY_PAGE_READ, FS_PROVIDER_DISPLAY_SUMMARY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_SUMMARY_PAGE_EDIT, FS_PROVIDER_DISPLAY_SUMMARY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_SUMMARY_PAGE_CREATE, FS_PROVIDER_DISPLAY_SUMMARY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DISPLAY_SUMMARY_PAGE_DELETE, FS_PROVIDER_DISPLAY_SUMMARY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_AFFILIATION_INFORMATION_READ, FS_PROVIDER_AFFILIATION_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_AFFILIATION_INFORMATION_EDIT, FS_PROVIDER_AFFILIATION_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_AFFILIATION_INFORMATION_CREATE, FS_PROVIDER_AFFILIATION_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_AFFILIATION_INFORMATION_DELETE, FS_PROVIDER_AFFILIATION_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_FILES_AND_DOCUMENTS_READ, FS_PROVIDER_FILES_AND_DOCUMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_FILES_AND_DOCUMENTS_EDIT, FS_PROVIDER_FILES_AND_DOCUMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_FILES_AND_DOCUMENTS_CREATE, FS_PROVIDER_FILES_AND_DOCUMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_FILES_AND_DOCUMENTS_DELETE, FS_PROVIDER_FILES_AND_DOCUMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SUSPEND_PROVIDER_READ, FS_PROVIDER_SUSPEND_PROVIDER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SUSPEND_PROVIDER_EDIT, FS_PROVIDER_SUSPEND_PROVIDER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SUSPEND_PROVIDER_CREATE, FS_PROVIDER_SUSPEND_PROVIDER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SUSPEND_PROVIDER_DELETE, FS_PROVIDER_SUSPEND_PROVIDER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TERMINATE_PROVIDER_READ, FS_PROVIDER_TERMINATE_PROVIDER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TERMINATE_PROVIDER_EDIT, FS_PROVIDER_TERMINATE_PROVIDER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TERMINATE_PROVIDER_CREATE, FS_PROVIDER_TERMINATE_PROVIDER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TERMINATE_PROVIDER_DELETE, FS_PROVIDER_TERMINATE_PROVIDER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DEATH_DATE_READ, FS_PROVIDER_DEATH_DATE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DEATH_DATE_EDIT, FS_PROVIDER_DEATH_DATE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DEATH_DATE_CREATE, FS_PROVIDER_DEATH_DATE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_DEATH_DATE_DELETE, FS_PROVIDER_DEATH_DATE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TRADING_PARTNER_AGENT_ID_READ, FS_PROVIDER_TRADING_PARTNER_AGENT_ID_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TRADING_PARTNER_AGENT_ID_EDIT, FS_PROVIDER_TRADING_PARTNER_AGENT_ID_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TRADING_PARTNER_AGENT_ID_CREATE, FS_PROVIDER_TRADING_PARTNER_AGENT_ID_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TRADING_PARTNER_AGENT_ID_DELETE, FS_PROVIDER_TRADING_PARTNER_AGENT_ID_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REACTIVATE_PROVIDER_READ, FS_PROVIDER_REACTIVATE_PROVIDER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REACTIVATE_PROVIDER_EDIT, FS_PROVIDER_REACTIVATE_PROVIDER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REACTIVATE_PROVIDER_CREATE, FS_PROVIDER_REACTIVATE_PROVIDER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REACTIVATE_PROVIDER_DELETE, FS_PROVIDER_REACTIVATE_PROVIDER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_RETROACTIVATE_PROVIDER_READ, FS_PROVIDER_RETROACTIVATE_PROVIDER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_RETROACTIVATE_PROVIDER_EDIT, FS_PROVIDER_RETROACTIVATE_PROVIDER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_RETROACTIVATE_PROVIDER_CREATE, FS_PROVIDER_RETROACTIVATE_PROVIDER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_RETROACTIVATE_PROVIDER_DELETE, FS_PROVIDER_RETROACTIVATE_PROVIDER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_EDIT_AFFILIATION_READ, FS_PROVIDER_EDIT_AFFILIATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_EDIT_AFFILIATION_EDIT, FS_PROVIDER_EDIT_AFFILIATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_EDIT_AFFILIATION_CREATE, FS_PROVIDER_EDIT_AFFILIATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_EDIT_AFFILIATION_DELETE, FS_PROVIDER_EDIT_AFFILIATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SERVICE_LOCATION_READ, FS_PROVIDER_SERVICE_LOCATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SERVICE_LOCATION_EDIT, FS_PROVIDER_SERVICE_LOCATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SERVICE_LOCATION_CREATE, FS_PROVIDER_SERVICE_LOCATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SERVICE_LOCATION_DELETE, FS_PROVIDER_SERVICE_LOCATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MONITORING_READ, FS_PROVIDER_MONITORING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MONITORING_EDIT, FS_PROVIDER_MONITORING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MONITORING_CREATE, FS_PROVIDER_MONITORING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MONITORING_DELETE, FS_PROVIDER_MONITORING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_ENROLLMENT_SPAN_READ, FS_PROVIDER_ENROLLMENT_SPAN_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_ENROLLMENT_SPAN_EDIT, FS_PROVIDER_ENROLLMENT_SPAN_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_ENROLLMENT_SPAN_CREATE, FS_PROVIDER_ENROLLMENT_SPAN_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_ENROLLMENT_SPAN_DELETE, FS_PROVIDER_ENROLLMENT_SPAN_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_HISTORY_READ, FS_PROVIDER_HISTORY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_HISTORY_EDIT, FS_PROVIDER_HISTORY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_HISTORY_CREATE, FS_PROVIDER_HISTORY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_HISTORY_DELETE, FS_PROVIDER_HISTORY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TIMELINE_READ, FS_PROVIDER_TIMELINE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TIMELINE_EDIT, FS_PROVIDER_TIMELINE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TIMELINE_CREATE, FS_PROVIDER_TIMELINE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_TIMELINE_DELETE, FS_PROVIDER_TIMELINE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REVALIDATION_READ, FS_PROVIDER_REVALIDATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REVALIDATION_EDIT, FS_PROVIDER_REVALIDATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REVALIDATION_CREATE, FS_PROVIDER_REVALIDATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_REVALIDATION_DELETE, FS_PROVIDER_REVALIDATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MESSAGES_READ, FS_PROVIDER_MESSAGES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MESSAGES_EDIT, FS_PROVIDER_MESSAGES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MESSAGES_CREATE, FS_PROVIDER_MESSAGES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_MESSAGES_DELETE, FS_PROVIDER_MESSAGES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SITE_VISITS_READ, FS_PROVIDER_SITE_VISITS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SITE_VISITS_EDIT, FS_PROVIDER_SITE_VISITS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SITE_VISITS_CREATE, FS_PROVIDER_SITE_VISITS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_SITE_VISITS_DELETE, FS_PROVIDER_SITE_VISITS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_NOTES_READ, FS_PROVIDER_NOTES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_NOTES_EDIT, FS_PROVIDER_NOTES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_NOTES_CREATE, FS_PROVIDER_NOTES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PROVIDER_NOTES_DELETE, FS_PROVIDER_NOTES_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Enrollment Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> enrollmentBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SWITCH, FS_ENROLLMENT_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DISPLAY_PAGE_READ, FS_ENROLLMENT_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DISPLAY_PAGE_EDIT, FS_ENROLLMENT_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DISPLAY_PAGE_CREATE, FS_ENROLLMENT_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DISPLAY_PAGE_DELETE, FS_ENROLLMENT_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_APPLICATION_READ, FS_ENROLLMENT_APPLICATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_APPLICATION_EDIT, FS_ENROLLMENT_APPLICATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_APPLICATION_CREATE, FS_ENROLLMENT_APPLICATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_APPLICATION_DELETE, FS_ENROLLMENT_APPLICATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SCREENING_READ, FS_ENROLLMENT_SCREENING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SCREENING_EDIT, FS_ENROLLMENT_SCREENING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SCREENING_CREATE, FS_ENROLLMENT_SCREENING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SCREENING_DELETE, FS_ENROLLMENT_SCREENING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_FILES_AND_DOCUMENTS_READ, FS_ENROLLMENT_FILES_AND_DOCUMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_FILES_AND_DOCUMENTS_EDIT, FS_ENROLLMENT_FILES_AND_DOCUMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_FILES_AND_DOCUMENTS_CREATE, FS_ENROLLMENT_FILES_AND_DOCUMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_FILES_AND_DOCUMENTS_DELETE, FS_ENROLLMENT_FILES_AND_DOCUMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_NOTES_READ, FS_ENROLLMENT_NOTES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_NOTES_EDIT, FS_ENROLLMENT_NOTES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_NOTES_CREATE, FS_ENROLLMENT_NOTES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_NOTES_DELETE, FS_ENROLLMENT_NOTES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_EDIT_AFFILIATION_READ, FS_ENROLLMENT_EDIT_AFFILIATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_EDIT_AFFILIATION_EDIT, FS_ENROLLMENT_EDIT_AFFILIATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_EDIT_AFFILIATION_CREATE, FS_ENROLLMENT_EDIT_AFFILIATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_EDIT_AFFILIATION_DELETE, FS_ENROLLMENT_EDIT_AFFILIATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_ENROLLMENT_TYPE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE, FS_ENROLLMENT_DOCUMENT_REVIEW_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_READ, FS_ENROLLMENT_READY_FOR_SCREENING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_EDIT, FS_ENROLLMENT_READY_FOR_SCREENING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_CREATE, FS_ENROLLMENT_READY_FOR_SCREENING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_DELETE, FS_ENROLLMENT_READY_FOR_SCREENING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_READ, FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_EDIT, FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_CREATE, FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_DELETE, FS_ENROLLMENT_READY_FOR_SCREENING_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_READ, FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_EDIT, FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_CREATE, FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_DELETE, FS_ENROLLMENT_READY_FOR_SCREENING_DOCUMENT_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_READ, FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_EDIT, FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_CREATE, FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_DELETE, FS_ENROLLMENT_READY_FOR_SCREENING_UNDER_SCREENING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_READ, FS_ENROLLMENT_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_EDIT, FS_ENROLLMENT_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_CREATE, FS_ENROLLMENT_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_DELETE, FS_ENROLLMENT_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_READ, FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_EDIT, FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_CREATE, FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_DELETE, FS_ENROLLMENT_PENDING_REVIEW_VERIFY_FINGERPRINT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_READ, FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_EDIT, FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_CREATE, FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_DELETE, FS_ENROLLMENT_PENDING_REVIEW_CREATE_SITE_VISIT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_READ, FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_EDIT, FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_CREATE, FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_DELETE, FS_ENROLLMENT_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_READ, FS_ENROLLMENT_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_EDIT, FS_ENROLLMENT_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_CREATE, FS_ENROLLMENT_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_DELETE, FS_ENROLLMENT_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_NEW_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_NEW_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_NEW_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_NEW_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_TERMINATED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_FUTURE_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_APPROVED_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_APPROVED_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_APPROVED_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_APPROVED_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DENIED_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DENIED_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DENIED_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DENIED_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_DOCUMENT_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_TEMPORARY_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_W9_PROCESSING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_PAYMENT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_AGENCY_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_READ, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_EDIT, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_CREATE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_DELETE, FS_ENROLLMENT_CHANGE_STATUS_TO_PENDING_PROVIDER_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SERVICE_LOCATION_READ, FS_ENROLLMENT_SERVICE_LOCATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SERVICE_LOCATION_EDIT, FS_ENROLLMENT_SERVICE_LOCATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SERVICE_LOCATION_CREATE, FS_ENROLLMENT_SERVICE_LOCATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_SERVICE_LOCATION_DELETE, FS_ENROLLMENT_SERVICE_LOCATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_READ, FS_ENROLLMENT_CHANGE_ASSIGNEE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_EDIT, FS_ENROLLMENT_CHANGE_ASSIGNEE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_CREATE, FS_ENROLLMENT_CHANGE_ASSIGNEE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_DELETE, FS_ENROLLMENT_CHANGE_ASSIGNEE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_READ, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_EDIT, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_CREATE, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_DELETE, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_READ, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE, FS_ENROLLMENT_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for CoC Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> cocBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_SWITCH, FS_COC_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_DISPLAY_PAGE_READ, FS_COC_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_DISPLAY_PAGE_EDIT, FS_COC_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_DISPLAY_PAGE_CREATE, FS_COC_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_DISPLAY_PAGE_DELETE, FS_COC_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_APPLICATION_READ, FS_COC_APPLICATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_APPLICATION_EDIT, FS_COC_APPLICATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_APPLICATION_CREATE, FS_COC_APPLICATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_APPLICATION_DELETE, FS_COC_APPLICATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_SCREENING_READ, FS_COC_SCREENING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_SCREENING_EDIT, FS_COC_SCREENING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_SCREENING_CREATE, FS_COC_SCREENING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_SCREENING_DELETE, FS_COC_SCREENING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_FILES_AND_DOCUMENTS_READ, FS_COC_FILES_AND_DOCUMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_FILES_AND_DOCUMENTS_EDIT, FS_COC_FILES_AND_DOCUMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_FILES_AND_DOCUMENTS_CREATE, FS_COC_FILES_AND_DOCUMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_FILES_AND_DOCUMENTS_DELETE, FS_COC_FILES_AND_DOCUMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_NOTES_READ, FS_COC_NOTES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_NOTES_EDIT, FS_COC_NOTES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_NOTES_CREATE, FS_COC_NOTES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_NOTES_DELETE, FS_COC_NOTES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_MESSAGES_READ, FS_COC_MESSAGES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_MESSAGES_EDIT, FS_COC_MESSAGES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_MESSAGES_CREATE, FS_COC_MESSAGES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_MESSAGES_DELETE, FS_COC_MESSAGES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_READ, FS_COC_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_EDIT, FS_COC_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_CREATE, FS_COC_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_DELETE, FS_COC_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_APPROVE_DENY_READ, FS_COC_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_APPROVE_DENY_EDIT, FS_COC_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_APPROVE_DENY_CREATE, FS_COC_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_PENDING_REVIEW_APPROVE_DENY_DELETE, FS_COC_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_READ, FS_COC_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_EDIT, FS_COC_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_CREATE, FS_COC_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_DELETE, FS_COC_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_NEW_READ, FS_COC_CHANGE_STATUS_TO_NEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_NEW_EDIT, FS_COC_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_NEW_CREATE, FS_COC_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_NEW_DELETE, FS_COC_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_UNDER_REVIEW_READ, FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT, FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE, FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE, FS_COC_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ, FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT, FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE, FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE, FS_COC_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_APPROVAL_READ, FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT, FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE, FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE, FS_COC_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_REVIEW_READ, FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT, FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE, FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE, FS_COC_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_APPROVED_READ, FS_COC_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_APPROVED_EDIT, FS_COC_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_APPROVED_CREATE, FS_COC_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_APPROVED_DELETE, FS_COC_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_DENIED_READ, FS_COC_CHANGE_STATUS_TO_DENIED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_DENIED_EDIT, FS_COC_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_DENIED_CREATE, FS_COC_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_DENIED_DELETE, FS_COC_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_CANCELLED_READ, FS_COC_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_CANCELLED_EDIT, FS_COC_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_CANCELLED_CREATE, FS_COC_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_STATUS_TO_CANCELLED_DELETE, FS_COC_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_READ, FS_COC_CHANGE_ASSIGNEE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_EDIT, FS_COC_CHANGE_ASSIGNEE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_CREATE, FS_COC_CHANGE_ASSIGNEE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_DELETE, FS_COC_CHANGE_ASSIGNEE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ME_READ, FS_COC_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ME_EDIT, FS_COC_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ME_CREATE, FS_COC_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ME_DELETE, FS_COC_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ANY_USER_READ, FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT, FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE, FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE, FS_COC_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_READ, FS_COC_REQUESTS_AVAILABILITY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_EDIT, FS_COC_REQUESTS_AVAILABILITY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_CREATE, FS_COC_REQUESTS_AVAILABILITY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DELETE, FS_COC_REQUESTS_AVAILABILITY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_READ, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_EDIT, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_CREATE, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_DELETE, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_READ, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_EDIT, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_CREATE, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_DELETE, FS_COC_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Authorization Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> authorizationBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_SWITCH, FS_AUTHORIZATION_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_PAGE_READ, FS_AUTHORIZATION_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_PAGE_EDIT, FS_AUTHORIZATION_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_PAGE_CREATE, FS_AUTHORIZATION_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_PAGE_DELETE, FS_AUTHORIZATION_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_DETAILS_PAGE_READ, FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_DETAILS_PAGE_EDIT, FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_DETAILS_PAGE_CREATE, FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_DISPLAY_DETAILS_PAGE_DELETE, FS_AUTHORIZATION_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_APPLICATION_READ, FS_AUTHORIZATION_APPLICATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_APPLICATION_EDIT, FS_AUTHORIZATION_APPLICATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_APPLICATION_CREATE, FS_AUTHORIZATION_APPLICATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_APPLICATION_DELETE, FS_AUTHORIZATION_APPLICATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_SCREENING_READ, FS_AUTHORIZATION_SCREENING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_SCREENING_EDIT, FS_AUTHORIZATION_SCREENING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_SCREENING_CREATE, FS_AUTHORIZATION_SCREENING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_SCREENING_DELETE, FS_AUTHORIZATION_SCREENING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_FILES_AND_DOCUMENTS_READ, FS_AUTHORIZATION_FILES_AND_DOCUMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_FILES_AND_DOCUMENTS_EDIT, FS_AUTHORIZATION_FILES_AND_DOCUMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_FILES_AND_DOCUMENTS_CREATE, FS_AUTHORIZATION_FILES_AND_DOCUMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_FILES_AND_DOCUMENTS_DELETE, FS_AUTHORIZATION_FILES_AND_DOCUMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_NOTES_READ, FS_AUTHORIZATION_NOTES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_NOTES_EDIT, FS_AUTHORIZATION_NOTES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_NOTES_CREATE, FS_AUTHORIZATION_NOTES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_NOTES_DELETE, FS_AUTHORIZATION_NOTES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_ADD_REQUEST_READ, FS_AUTHORIZATION_ADD_REQUEST_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_ADD_REQUEST_EDIT, FS_AUTHORIZATION_ADD_REQUEST_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_ADD_REQUEST_CREATE, FS_AUTHORIZATION_ADD_REQUEST_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_ADD_REQUEST_DELETE, FS_AUTHORIZATION_ADD_REQUEST_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_READ, FS_AUTHORIZATION_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_NEW_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_NEW_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_NEW_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_NEW_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_DENIED_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_DENIED_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_DENIED_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_DENIED_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_READ, FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_EDIT, FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_CREATE, FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_DELETE, FS_AUTHORIZATION_CHANGE_STATUS_TO_PARTIALLY_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_READ, FS_AUTHORIZATION_CHANGE_ASSIGNEE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_EDIT, FS_AUTHORIZATION_CHANGE_ASSIGNEE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_CREATE, FS_AUTHORIZATION_CHANGE_ASSIGNEE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_DELETE, FS_AUTHORIZATION_CHANGE_ASSIGNEE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_READ, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_EDIT, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_CREATE, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_DELETE, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_READ, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE, FS_AUTHORIZATION_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Reconsideration Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> reconsiderationBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDERATION_SWITCH, FS_RECONSIDERATION_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_DISPLAY_PAGE_READ, FS_RECONSIDER_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_DISPLAY_PAGE_EDIT, FS_RECONSIDER_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_DISPLAY_PAGE_CREATE, FS_RECONSIDER_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_DISPLAY_PAGE_DELETE, FS_RECONSIDER_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_APPLICATION_READ, FS_RECONSIDER_APPLICATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_APPLICATION_EDIT, FS_RECONSIDER_APPLICATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_APPLICATION_CREATE, FS_RECONSIDER_APPLICATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_APPLICATION_DELETE, FS_RECONSIDER_APPLICATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_SCREENING_READ, FS_RECONSIDER_SCREENING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_SCREENING_EDIT, FS_RECONSIDER_SCREENING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_SCREENING_CREATE, FS_RECONSIDER_SCREENING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_SCREENING_DELETE, FS_RECONSIDER_SCREENING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_FILES_AND_DOCUMENTS_READ, FS_RECONSIDER_FILES_AND_DOCUMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_FILES_AND_DOCUMENTS_EDIT, FS_RECONSIDER_FILES_AND_DOCUMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_FILES_AND_DOCUMENTS_CREATE, FS_RECONSIDER_FILES_AND_DOCUMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_FILES_AND_DOCUMENTS_DELETE, FS_RECONSIDER_FILES_AND_DOCUMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_NOTES_READ, FS_RECONSIDER_NOTES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_NOTES_EDIT, FS_RECONSIDER_NOTES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_NOTES_CREATE, FS_RECONSIDER_NOTES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_NOTES_DELETE, FS_RECONSIDER_NOTES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_HEARING_READ, FS_RECONSIDER_HEARING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_HEARING_EDIT, FS_RECONSIDER_HEARING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_HEARING_CREATE, FS_RECONSIDER_HEARING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_HEARING_DELETE, FS_RECONSIDER_HEARING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_READ, FS_RECONSIDER_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_EDIT, FS_RECONSIDER_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_CREATE, FS_RECONSIDER_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_DELETE, FS_RECONSIDER_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_APPROVE_DENY_READ, FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_APPROVE_DENY_EDIT, FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_APPROVE_DENY_CREATE, FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_PENDING_REVIEW_APPROVE_DENY_DELETE, FS_RECONSIDER_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_READ, FS_RECONSIDER_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_EDIT, FS_RECONSIDER_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_CREATE, FS_RECONSIDER_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_DELETE, FS_RECONSIDER_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_NEW_READ, FS_RECONSIDER_CHANGE_STATUS_TO_NEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_NEW_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_NEW_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_NEW_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_READ, FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ, FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_READ, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_READ, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_APPROVED_READ, FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_APPROVED_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_APPROVED_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_APPROVED_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_DENIED_READ, FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_DENIED_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_DENIED_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_DENIED_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_CANCELLED_READ, FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_CANCELLED_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_CANCELLED_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_CANCELLED_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_CANCELLED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_READ, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_EDIT, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_CREATE, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_DELETE, FS_RECONSIDER_CHANGE_STATUS_TO_PENDING_HEARING_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_READ, FS_RECONSIDER_CHANGE_ASSIGNEE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_EDIT, FS_RECONSIDER_CHANGE_ASSIGNEE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_CREATE, FS_RECONSIDER_CHANGE_ASSIGNEE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_DELETE, FS_RECONSIDER_CHANGE_ASSIGNEE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ME_READ, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ME_EDIT, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ME_CREATE, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ME_DELETE, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_READ, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE, FS_RECONSIDER_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_READ, FS_RECONSIDER_REQUESTS_AVAILABILITY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_EDIT, FS_RECONSIDER_REQUESTS_AVAILABILITY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_CREATE, FS_RECONSIDER_REQUESTS_AVAILABILITY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DELETE, FS_RECONSIDER_REQUESTS_AVAILABILITY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_READ, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_EDIT, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_CREATE, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_DELETE, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ALL_REQUESTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_READ, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_EDIT, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_CREATE, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_DELETE, FS_RECONSIDER_REQUESTS_AVAILABILITY_DISPLAY_ONLY_REQUESTS_ASSIGNED_TO_ME_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Payment Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> paymentBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_SWITCH, FS_PAYMENTS_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_PAGE_READ, FS_PAYMENTS_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_PAGE_EDIT, FS_PAYMENTS_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_PAGE_CREATE, FS_PAYMENTS_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_PAGE_DELETE, FS_PAYMENTS_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_DETAILS_PAGE_READ, FS_PAYMENTS_DISPLAY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_DETAILS_PAGE_EDIT, FS_PAYMENTS_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_DETAILS_PAGE_CREATE, FS_PAYMENTS_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_DISPLAY_DETAILS_PAGE_DELETE, FS_PAYMENTS_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_DOWNLOAD_READ, FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_DOWNLOAD_EDIT, FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_DOWNLOAD_CREATE, FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_DOWNLOAD_DELETE, FS_PAYMENTS_RA_DOCUMENT_DOWNLOAD_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_PRINT_READ, FS_PAYMENTS_RA_DOCUMENT_PRINT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_PRINT_EDIT, FS_PAYMENTS_RA_DOCUMENT_PRINT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_PRINT_CREATE, FS_PAYMENTS_RA_DOCUMENT_PRINT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYMENTS_RA_DOCUMENT_PRINT_DELETE, FS_PAYMENTS_RA_DOCUMENT_PRINT_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Claims Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> claimsBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIM_SWITCH, FS_CLAIM_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DISPLAY_DETAILS_PAGE_READ, FS_CLAIMS_DISPLAY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DISPLAY_DETAILS_PAGE_EDIT, FS_CLAIMS_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DISPLAY_DETAILS_PAGE_CREATE, FS_CLAIMS_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DISPLAY_DETAILS_PAGE_DELETE, FS_CLAIMS_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_READ, FS_CLAIMS_DETAILS_DOCUMENT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_EDIT, FS_CLAIMS_DETAILS_DOCUMENT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_CREATE, FS_CLAIMS_DETAILS_DOCUMENT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_DELETE, FS_CLAIMS_DETAILS_DOCUMENT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_PRINT_READ, FS_CLAIMS_DETAILS_DOCUMENT_PRINT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_PRINT_EDIT, FS_CLAIMS_DETAILS_DOCUMENT_PRINT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_PRINT_CREATE, FS_CLAIMS_DETAILS_DOCUMENT_PRINT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CLAIMS_DETAILS_DOCUMENT_PRINT_DELETE, FS_CLAIMS_DETAILS_DOCUMENT_PRINT_DELETE_EXPECTED)));

        return parameterList;
    }
    /**
     * Parameter list for 1099 Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> p1099BuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_SWITCH, FS_1099_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_PAGE_READ, FS_1099_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_PAGE_EDIT, FS_1099_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_PAGE_CREATE, FS_1099_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_PAGE_DELETE, FS_1099_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_DETAILS_PAGE_READ, FS_1099_DISPLAY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_DETAILS_PAGE_EDIT, FS_1099_DISPLAY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_DETAILS_PAGE_CREATE, FS_1099_DISPLAY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DISPLAY_DETAILS_PAGE_DELETE, FS_1099_DISPLAY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_DOWNLOAD_READ, FS_1099_DETAILS_DOCUMENT_DOWNLOAD_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_DOWNLOAD_EDIT, FS_1099_DETAILS_DOCUMENT_DOWNLOAD_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_DOWNLOAD_CREATE, FS_1099_DETAILS_DOCUMENT_DOWNLOAD_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_DOWNLOAD_DELETE, FS_1099_DETAILS_DOCUMENT_DOWNLOAD_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_PRINT_READ, FS_1099_DETAILS_DOCUMENT_PRINT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_PRINT_EDIT, FS_1099_DETAILS_DOCUMENT_PRINT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_PRINT_CREATE, FS_1099_DETAILS_DOCUMENT_PRINT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.P1099_DETAILS_DOCUMENT_PRINT_DELETE, FS_1099_DETAILS_DOCUMENT_PRINT_DELETE_EXPECTED)));

        return parameterList;
    }
    /**
     * Parameter list for Message Box Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> messageBoxBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SWITCH, FS_MESSAGEBOX_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_DISPLAY_PAGE_READ, FS_MESSAGEBOX_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_DISPLAY_PAGE_EDIT, FS_MESSAGEBOX_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_DISPLAY_PAGE_CREATE, FS_MESSAGEBOX_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_DISPLAY_PAGE_DELETE, FS_MESSAGEBOX_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_MESSAGE_READ, FS_MESSAGEBOX_SEND_MESSAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_MESSAGE_EDIT, FS_MESSAGEBOX_SEND_MESSAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_MESSAGE_CREATE, FS_MESSAGEBOX_SEND_MESSAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_MESSAGE_DELETE, FS_MESSAGEBOX_SEND_MESSAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_ATTACHMENT_READ, FS_MESSAGEBOX_SEND_ATTACHMENT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_ATTACHMENT_EDIT, FS_MESSAGEBOX_SEND_ATTACHMENT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_ATTACHMENT_CREATE, FS_MESSAGEBOX_SEND_ATTACHMENT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_SEND_ATTACHMENT_DELETE, FS_MESSAGEBOX_SEND_ATTACHMENT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_ARCHIVE_MESSAGE_READ, FS_MESSAGEBOX_ARCHIVE_MESSAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_ARCHIVE_MESSAGE_EDIT, FS_MESSAGEBOX_ARCHIVE_MESSAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_ARCHIVE_MESSAGE_CREATE, FS_MESSAGEBOX_ARCHIVE_MESSAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MESSAGEBOX_ARCHIVE_MESSAGE_DELETE, FS_MESSAGEBOX_ARCHIVE_MESSAGE_DELETE_EXPECTED)));

        return parameterList;
    }
    /**
     * Parameter list for Reports Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> reportsBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_SWITCH, FS_REPORTS_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_PAGE_READ, FS_REPORTS_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_PAGE_EDIT, FS_REPORTS_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_PAGE_CREATE, FS_REPORTS_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_PAGE_DELETE, FS_REPORTS_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_CANNED_PAGE_READ, FS_REPORTS_DISPLAY_CANNED_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_CANNED_PAGE_EDIT, FS_REPORTS_DISPLAY_CANNED_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_CANNED_PAGE_CREATE, FS_REPORTS_DISPLAY_CANNED_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_CANNED_PAGE_DELETE, FS_REPORTS_DISPLAY_CANNED_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_LETTER_PAGE_READ, FS_REPORTS_DISPLAY_LETTER_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_LETTER_PAGE_EDIT, FS_REPORTS_DISPLAY_LETTER_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_LETTER_PAGE_CREATE, FS_REPORTS_DISPLAY_LETTER_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_LETTER_PAGE_DELETE, FS_REPORTS_DISPLAY_LETTER_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_AD_HOC_PAGE_READ, FS_REPORTS_DISPLAY_AD_HOC_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_AD_HOC_PAGE_EDIT, FS_REPORTS_DISPLAY_AD_HOC_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_AD_HOC_PAGE_CREATE, FS_REPORTS_DISPLAY_AD_HOC_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_DISPLAY_AD_HOC_PAGE_DELETE, FS_REPORTS_DISPLAY_AD_HOC_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_AD_HOC_REPORTS_READ, FS_REPORTS_AD_HOC_REPORTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_AD_HOC_REPORTS_EDIT, FS_REPORTS_AD_HOC_REPORTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_AD_HOC_REPORTS_CREATE, FS_REPORTS_AD_HOC_REPORTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.REPORTS_AD_HOC_REPORTS_DELETE, FS_REPORTS_AD_HOC_REPORTS_DELETE_EXPECTED)));

        return parameterList;
    }
    /**
     * Parameter list for Site Visit Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> siteVisitBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITEVISIT_SWITCH, FS_SITE_VISIT_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_DISPLAY_READ, FS_SITE_VISIT_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_DISPLAY_EDIT, FS_SITE_VISIT_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_DISPLAY_CREATE, FS_SITE_VISIT_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_DISPLAY_DELETE, FS_SITE_VISIT_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_READ, FS_SITE_VISIT_SEARCH_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_EDIT, FS_SITE_VISIT_SEARCH_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_CREATE, FS_SITE_VISIT_SEARCH_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_DELETE, FS_SITE_VISIT_SEARCH_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_DISPLAY_PAGE_READ, FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_DISPLAY_PAGE_EDIT, FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_DISPLAY_PAGE_CREATE, FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_DISPLAY_PAGE_DELETE, FS_SITE_VISIT_SEARCH_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_READ, FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_EDIT, FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_CREATE, FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_DELETE, FS_SITE_VISIT_SEARCH_BASED_ON_INVESTIGATOR_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_REQUEST_READ, FS_SITE_VISIT_REQUEST_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_REQUEST_EDIT, FS_SITE_VISIT_REQUEST_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_REQUEST_CREATE, FS_SITE_VISIT_REQUEST_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_REQUEST_DELETE, FS_SITE_VISIT_REQUEST_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_ADD_SITE_VISIT_READ, FS_SITE_VISIT_ADD_SITE_VISIT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_ADD_SITE_VISIT_EDIT, FS_SITE_VISIT_ADD_SITE_VISIT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_ADD_SITE_VISIT_CREATE, FS_SITE_VISIT_ADD_SITE_VISIT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_ADD_SITE_VISIT_DELETE, FS_SITE_VISIT_ADD_SITE_VISIT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_RESCHEDULE_SITE_VISIT_READ, FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_RESCHEDULE_SITE_VISIT_EDIT, FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_RESCHEDULE_SITE_VISIT_CREATE, FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_RESCHEDULE_SITE_VISIT_DELETE, FS_SITE_VISIT_RESCHEDULE_SITE_VISIT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_FILES_AND_DOCUMENTS_READ, FS_SITE_VISIT_FILES_AND_DOCUMENTS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_FILES_AND_DOCUMENTS_EDIT, FS_SITE_VISIT_FILES_AND_DOCUMENTS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_FILES_AND_DOCUMENTS_CREATE, FS_SITE_VISIT_FILES_AND_DOCUMENTS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_FILES_AND_DOCUMENTS_DELETE, FS_SITE_VISIT_FILES_AND_DOCUMENTS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_NOTES_READ, FS_SITE_VISIT_NOTES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_NOTES_EDIT, FS_SITE_VISIT_NOTES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_NOTES_CREATE, FS_SITE_VISIT_NOTES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_NOTES_DELETE, FS_SITE_VISIT_NOTES_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_READ, FS_SITE_VISIT_PENDING_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_EDIT, FS_SITE_VISIT_PENDING_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_CREATE, FS_SITE_VISIT_PENDING_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_DELETE, FS_SITE_VISIT_PENDING_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_READ, FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_EDIT, FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_CREATE, FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_DELETE, FS_SITE_VISIT_PENDING_REVIEW_APPROVE_DENY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_READ, FS_SITE_VISIT_CHANGE_ASSIGNEE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_EDIT, FS_SITE_VISIT_CHANGE_ASSIGNEE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_CREATE, FS_SITE_VISIT_CHANGE_ASSIGNEE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_DELETE, FS_SITE_VISIT_CHANGE_ASSIGNEE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_READ, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_EDIT, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_CREATE, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_DELETE, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ME_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_READ, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE, FS_SITE_VISIT_CHANGE_ASSIGNEE_TO_ANY_USER_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_READ, FS_SITE_VISIT_CHANGE_STATUS_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_EDIT, FS_SITE_VISIT_CHANGE_STATUS_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_CREATE, FS_SITE_VISIT_CHANGE_STATUS_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_DELETE, FS_SITE_VISIT_CHANGE_STATUS_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_NEW_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_NEW_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_NEW_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_NEW_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_NEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_UNDER_REVIEW_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_REQUESTED_ADDITIONAL_INFORMATION_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_PENDING_APPROVAL_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_APPROVED_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_APPROVED_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_APPROVED_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_APPROVED_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_APPROVED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_DENIED_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_DENIED_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_DENIED_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_DENIED_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_DENIED_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_READ, FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_EDIT, FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_CREATE, FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_DELETE, FS_SITE_VISIT_CHANGE_STATUS_TO_SCHEDULE_SITE_VISIT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_READ, FS_SITE_VISIT_AVAILABILITY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_EDIT, FS_SITE_VISIT_AVAILABILITY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_CREATE, FS_SITE_VISIT_AVAILABILITY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DELETE, FS_SITE_VISIT_AVAILABILITY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_READ, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_EDIT, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_CREATE, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_DELETE, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ALL_SITE_VISIT_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_READ, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_EDIT, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_CREATE, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_DELETE, FS_SITE_VISIT_AVAILABILITY_DISPLAY_ONLY_SITE_VISIT_ASSIGNED_TO_ME_DELETE_EXPECTED)));

        return parameterList;
    }
    /**
     * Parameter list for Help Center Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> helpBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_SWITCH, FS_HELP_CENTER_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_DISPLAY_PAGE_READ, FS_HELPCENTER_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_DISPLAY_PAGE_EDIT, FS_HELPCENTER_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_DISPLAY_PAGE_CREATE, FS_HELPCENTER_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_DISPLAY_PAGE_DELETE, FS_HELPCENTER_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_LINK_READ, FS_HELPCENTER_LINK_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_LINK_EDIT, FS_HELPCENTER_LINK_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_LINK_CREATE, FS_HELPCENTER_LINK_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.HELPCENTER_LINK_DELETE, FS_HELPCENTER_LINK_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Chat Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> chatBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_SWITCH, FS_CHAT_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_DISPLAY_PAGE_READ, FS_CHAT_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_DISPLAY_PAGE_EDIT, FS_CHAT_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_DISPLAY_PAGE_CREATE, FS_CHAT_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_DISPLAY_PAGE_DELETE, FS_CHAT_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_SEND_FILES_READ, FS_CHAT_SEND_FILES_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_SEND_FILES_EDIT, FS_CHAT_SEND_FILES_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_SEND_FILES_CREATE, FS_CHAT_SEND_FILES_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.CHAT_SEND_FILES_DELETE, FS_CHAT_SEND_FILES_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for System Properties Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> systemPropertiesBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYSTEMPROPERTIES_SWITCH, FS_SYSTEM_PROPERTIES_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DISPLAY_READ, FS_SYS_PROP_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DISPLAY_EDIT, FS_SYS_PROP_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DISPLAY_CREATE, FS_SYS_PROP_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DISPLAY_DELETE, FS_SYS_PROP_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DISPLAY_PAGE_READ, FS_SYS_PROP_USERS_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DISPLAY_PAGE_EDIT, FS_SYS_PROP_USERS_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DISPLAY_PAGE_CREATE, FS_SYS_PROP_USERS_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DISPLAY_PAGE_DELETE, FS_SYS_PROP_USERS_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DETAILS_PAGE_READ, FS_SYS_PROP_USERS_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DETAILS_PAGE_EDIT, FS_SYS_PROP_USERS_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DETAILS_PAGE_CREATE, FS_SYS_PROP_USERS_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USERS_DETAILS_PAGE_DELETE, FS_SYS_PROP_USERS_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DISPLAY_PAGE_READ, FS_SYS_PROP_ROLES_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DISPLAY_PAGE_EDIT, FS_SYS_PROP_ROLES_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DISPLAY_PAGE_CREATE, FS_SYS_PROP_ROLES_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DISPLAY_PAGE_DELETE, FS_SYS_PROP_ROLES_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DETAILS_PAGE_READ, FS_SYS_PROP_ROLES_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DETAILS_PAGE_EDIT, FS_SYS_PROP_ROLES_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DETAILS_PAGE_CREATE, FS_SYS_PROP_ROLES_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_ROLES_DETAILS_PAGE_DELETE, FS_SYS_PROP_ROLES_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_READ, FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_EDIT, FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_CREATE, FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_DELETE, FS_SYS_PROP_SCREENING_MONITORING_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_READ, FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_EDIT, FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_CREATE, FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_DELETE, FS_SYS_PROP_SCREENING_MONITORING_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_READ, FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_EDIT, FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_CREATE, FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_DELETE, FS_SYS_PROP_AUTOASSIGN_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DETAILS_PAGE_READ, FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DETAILS_PAGE_EDIT, FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DETAILS_PAGE_CREATE, FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTOASSIGN_DETAILS_PAGE_DELETE, FS_SYS_PROP_AUTOASSIGN_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_READ, FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_EDIT, FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_CREATE, FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_DELETE, FS_SYS_PROP_DATA_CHANGE_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DETAILS_PAGE_READ, FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DETAILS_PAGE_EDIT, FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DETAILS_PAGE_CREATE, FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DATA_CHANGE_DETAILS_PAGE_DELETE, FS_SYS_PROP_DATA_CHANGE_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DISPLAY_PAGE_READ, FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DISPLAY_PAGE_EDIT, FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DISPLAY_PAGE_CREATE, FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DISPLAY_PAGE_DELETE, FS_SYS_PROP_APPROVALS_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DETAILS_PAGE_READ, FS_SYS_PROP_APPROVALS_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DETAILS_PAGE_EDIT, FS_SYS_PROP_APPROVALS_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DETAILS_PAGE_CREATE, FS_SYS_PROP_APPROVALS_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_APPROVALS_DETAILS_PAGE_DELETE, FS_SYS_PROP_APPROVALS_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DISPLAY_PAGE_READ, FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DISPLAY_PAGE_EDIT, FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DISPLAY_PAGE_CREATE, FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DISPLAY_PAGE_DELETE, FS_SYS_PROP_REVALIDATION_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DETAILS_PAGE_READ, FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DETAILS_PAGE_EDIT, FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DETAILS_PAGE_CREATE, FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REVALIDATION_DETAILS_PAGE_DELETE, FS_SYS_PROP_REVALIDATION_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DISPLAY_PAGE_READ, FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DISPLAY_PAGE_EDIT, FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DISPLAY_PAGE_CREATE, FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DISPLAY_PAGE_DELETE, FS_SYS_PROP_SITEVISIT_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DETAILS_PAGE_READ, FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DETAILS_PAGE_EDIT, FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DETAILS_PAGE_CREATE, FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SITEVISIT_DETAILS_PAGE_DELETE, FS_SYS_PROP_SITEVISIT_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_READ, FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_EDIT, FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_CREATE, FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_DELETE, FS_SYS_PROP_EXTERNALISATION_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DETAILS_PAGE_READ, FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DETAILS_PAGE_EDIT, FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DETAILS_PAGE_CREATE, FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_EXTERNALISATION_DETAILS_PAGE_DELETE, FS_SYS_PROP_EXTERNALISATION_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_READ, FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_EDIT, FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_CREATE, FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_DELETE, FS_SYS_PROP_USER_DEACTIVATION_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_READ, FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_EDIT, FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_CREATE, FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_DELETE, FS_SYS_PROP_USER_DEACTIVATION_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_READ, FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_EDIT, FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_CREATE, FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_DELETE, FS_SYS_PROP_SECURITY_POLICY_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_READ, FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_EDIT, FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_CREATE, FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_DELETE, FS_SYS_PROP_SECURITY_POLICY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_READ, FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_EDIT, FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_CREATE, FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_DELETE, FS_SYS_PROP_AUTO_ARCHIVE_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_READ, FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_EDIT, FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_CREATE, FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_DELETE, FS_SYS_PROP_AUTO_ARCHIVE_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_READ, FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_EDIT, FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_CREATE, FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_DELETE, FS_SYS_PROP_PAYMENTS_FEES_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_READ, FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_EDIT, FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_CREATE, FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_DELETE, FS_SYS_PROP_PAYMENTS_FEES_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DISPLAY_PAGE_READ, FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DISPLAY_PAGE_EDIT, FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DISPLAY_PAGE_CREATE, FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DISPLAY_PAGE_DELETE, FS_SYS_PROP_USER_PROFILE_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DETAILS_PAGE_READ, FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DETAILS_PAGE_EDIT, FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DETAILS_PAGE_CREATE, FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_USER_PROFILE_DETAILS_PAGE_DELETE, FS_SYS_PROP_USER_PROFILE_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DISPLAY_PAGE_READ, FS_SYS_PROP_BUILDER_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DISPLAY_PAGE_EDIT, FS_SYS_PROP_BUILDER_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DISPLAY_PAGE_CREATE, FS_SYS_PROP_BUILDER_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DISPLAY_PAGE_DELETE, FS_SYS_PROP_BUILDER_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DETAILS_PAGE_READ, FS_SYS_PROP_BUILDER_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DETAILS_PAGE_EDIT, FS_SYS_PROP_BUILDER_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DETAILS_PAGE_CREATE, FS_SYS_PROP_BUILDER_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_BUILDER_DETAILS_PAGE_DELETE, FS_SYS_PROP_BUILDER_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DISPLAY_PAGE_READ, FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DISPLAY_PAGE_EDIT, FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DISPLAY_PAGE_CREATE, FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DISPLAY_PAGE_DELETE, FS_SYS_PROP_LICENSURE_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DETAILS_PAGE_READ, FS_SYS_PROP_LICENSURE_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DETAILS_PAGE_EDIT, FS_SYS_PROP_LICENSURE_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DETAILS_PAGE_CREATE, FS_SYS_PROP_LICENSURE_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_LICENSURE_DETAILS_PAGE_DELETE, FS_SYS_PROP_LICENSURE_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DISPLAY_PAGE_READ, FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DISPLAY_PAGE_EDIT, FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DISPLAY_PAGE_CREATE, FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DISPLAY_PAGE_DELETE, FS_SYS_PROP_DUPLICITY_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DETAILS_PAGE_READ, FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DETAILS_PAGE_EDIT, FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DETAILS_PAGE_CREATE, FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_DUPLICITY_DETAILS_PAGE_DELETE, FS_SYS_PROP_DUPLICITY_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_READ, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_EDIT, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_CREATE, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_DELETE, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_READ, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_EDIT, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_CREATE, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_DELETE, FS_SYS_PROP_REMINDERS_TO_REVIEWERS_DETAILS_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_READ, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_EDIT, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_CREATE, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_DELETE, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_READ, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_EDIT, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_CREATE, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_DELETE, FS_SYS_PROP_REQUEST_ADDITIONAL_INFORMATION_DETAILS_PAGE_DELETE_EXPECTED)));

        return parameterList;
    }
    /**
     * Parameter list for Voting Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> votingBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_SWITCH, FS_VOTING_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_READ, FS_VOTING_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_EDIT, FS_VOTING_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_CREATE, FS_VOTING_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_DELETE, FS_VOTING_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_PAGE_READ, FS_VOTING_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_PAGE_EDIT, FS_VOTING_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_PAGE_CREATE, FS_VOTING_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.VOTING_DISPLAY_PAGE_DELETE, FS_VOTING_DISPLAY_PAGE_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Audit Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> auditBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_SWITCH, FS_AUDIT_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_DISPLAY_PAGE_READ, FS_AUDIT_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_DISPLAY_PAGE_EDIT, FS_AUDIT_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_DISPLAY_PAGE_CREATE, FS_AUDIT_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_DISPLAY_PAGE_DELETE, FS_AUDIT_DISPLAY_PAGE_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_SEARCH_READ, FS_AUDIT_SEARCH_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_SEARCH_EDIT, FS_AUDIT_SEARCH_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_SEARCH_CREATE, FS_AUDIT_SEARCH_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AUDIT_SEARCH_DELETE, FS_AUDIT_SEARCH_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for EDI Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> ediBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_SWITCH, FS_EDI_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_READ, FS_EDI_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_EDIT, FS_EDI_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_CREATE, FS_EDI_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_DELETE, FS_EDI_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_PAGE_READ, FS_EDI_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_PAGE_EDIT, FS_EDI_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_PAGE_CREATE, FS_EDI_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.EDI_DISPLAY_PAGE_DELETE, FS_EDI_DISPLAY_PAGE_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Members Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> memberBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_SWITCH, FS_MEDIBOOK_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_READ, FS_MEDIBOOK_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_EDIT, FS_MEDIBOOK_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_CREATE, FS_MEDIBOOK_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_DELETE, FS_MEDIBOOK_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_PAGE_READ, FS_MEDIBOOK_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_PAGE_EDIT, FS_MEDIBOOK_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_PAGE_CREATE, FS_MEDIBOOK_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.MEDIBOOK_DISPLAY_PAGE_DELETE, FS_MEDIBOOK_DISPLAY_PAGE_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Payer Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> payerBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYERS_SWITCH, FS_PAYERS_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_READ, FS_PAYER_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_EDIT, FS_PAYER_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_CREATE, FS_PAYER_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_DELETE, FS_PAYER_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_PAGE_READ, FS_PAYER_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_PAGE_EDIT, FS_PAYER_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_PAGE_CREATE, FS_PAYER_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.PAYER_DISPLAY_PAGE_DELETE, FS_PAYER_DISPLAY_PAGE_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Affiliation Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> affiliationsBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_SWITCH, FS_AFFILIATION_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_READ, FS_AFFILIATION_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_EDIT, FS_AFFILIATION_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_CREATE, FS_AFFILIATION_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_DELETE, FS_AFFILIATION_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_PAGE_READ, FS_AFFILIATION_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_PAGE_EDIT, FS_AFFILIATION_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_PAGE_CREATE, FS_AFFILIATION_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.AFFILIATION_DISPLAY_PAGE_DELETE, FS_AFFILIATION_DISPLAY_PAGE_DELETE_EXPECTED)));
        return parameterList;
    }
    /**
     * Parameter list for Documents Section of Roles
     * @return  = return
     */
    public ArrayList<ArrayList<String>> documentsBuildExpectedList () {
        //Create a list for the roles that needs to be verified.
        ArrayList<ArrayList<String>> parameterList = new ArrayList<>();
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_SWITCH, FS_DOCUMENTS_SWITCH_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_READ, FS_DOCUMENTS_DISPLAY_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_EDIT, FS_DOCUMENTS_DISPLAY_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_CREATE, FS_DOCUMENTS_DISPLAY_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_DELETE, FS_DOCUMENTS_DISPLAY_DELETE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_PAGE_READ, FS_DOCUMENTS_DISPLAY_PAGE_READ_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_PAGE_EDIT, FS_DOCUMENTS_DISPLAY_PAGE_EDIT_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_PAGE_CREATE, FS_DOCUMENTS_DISPLAY_PAGE_CREATE_EXPECTED)));
        parameterList.add(new ArrayList<>(Arrays.asList(SORolesConstants.DOCUMENTS_DISPLAY_PAGE_DELETE, FS_DOCUMENTS_DISPLAY_PAGE_DELETE_EXPECTED)));
        return parameterList;
    }
}
