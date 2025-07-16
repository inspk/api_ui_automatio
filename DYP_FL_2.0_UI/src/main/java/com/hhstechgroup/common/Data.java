package com.hhstechgroup.common;


import java.util.Arrays;
import java.util.List;

/**
 * Data class contains all the public static final Strings available to all instances of the class and to other
 * objects using the Data class
 */
public class Data {

    public static final String URL_SIT = "https://sit-dyp.hhstechgroup.com";
    public static final String URL_CONVERSION = "https://conversion-dyp.hhstechgroup.com";
    public static final String URL_TRAINING = "https://training.presm.hhstechgroup.com";
    public static final String URL_DEV3_HHS = "https://dev3-dyp.hhstechgroup.com";
    public static final String URL_DEV2_HHS = "https://dev2-dyp.hhstechgroup.com";
    public static final String URL_DEV1_HHS = "https://dev1-dyp.hhstechgroup.com";
    public static final String URL_CONTENT = "https://content.dev.presm.hhstechgroup.com";
    public static final String URL_CONTENT_SIT = "https://content.sit-wyoming.hhstechgroup.com";
    public static final String URL_CONTENT_UAT = "https://content.uat.wyoming.dyp.cloud";

    public static final String URL_UAT = "https://uat.presm.hhstechgroup.com";
    public static final String URL_PROD = "https://prod.presm.hhstechgroup.com";

    public static final String URL_iUAT = "https://iuat.presm.hhstechgroup.com";

    //TESTNG ENVIRONMENT PARAMETERS
    public static final String TESTNG_ENV_PARAM_SIT = "SIT";
    public static final String TESTNG_ENV_PARAM_UAT = "UAT";

    //PRODUCT ENVIRONMENTS
    public static final String URL_DEV4_HHS = "https://dev-04.hhs-dev.hhstechgroup.com";
    public static final String URL_DEV4 = "https://us-dev4.dyp.cloud";
    public static final String URL_DEV3 = "https://us-dev3.dyp.cloud";
    public static final String URL_DEV5 = "https://us-dev5.dyp.cloud";
    public static final String URL_DEV7 = "http://dev-07.hhs-dev.hhstechgroup.com";

    //Invalid Login Cred
    public static final String invalidEmailId = "invalidTestEmail@gmail.com" ;
    public static final String invalidPassword = "invalidPwd" ;
    public static final String invalidLoginErrorMessage= "Incorrect email address or password" ;
    public static final String ERROR_FIELD_REQUIRED = "This field is required" ;
    public static final String ERROR_DATE_REQUIRED = "Date should not be less than or more than 100 years" ;
    public static final String ERROR_MASSAGE_NPI = "Enter valid NPI number" ;
    public static final String ERROR_DATES = "Date should not be less than or more than 100 years" ;

    //Application Status
    public static final String ApplicationStatusApprove = "Approved";
    public static final String APPROVED_RETROACTIVELY =  "Approved Retroactively";
    public static final String APPROVED_SPECIAL_REQUEST =  "Approve Special Request";


    //    public static final String APPLICATION_STATUS_APPROVED = "Approved";
    public static final String ApplicationStatusPendingAgencyReview = "Pending Agency Review";
    public static final String ApplicationStatusPendingAW9Processing = "Pending W9 Processing";
    public static final String ApplicationStatusPendingProviderPayment = "Pending Provider Payment";
    public static final String ApplicationStatusPendingProviderInformation = "Pending Provider Information";

    public static final String ApplicationStatusDenied = "Denied";
    public static final String ApplicationStatusReqAdditionalInfo = "REQUESTED ADDITIONAL INFORMATION" ;
    public static final String ApplicationStatusPendingReview = "PENDING REVIEW" ;
    public static final String APPLICATION_STATUS_SUSPENDED = "Suspended";
    public static final String APPLICATION_STATUS_UNDER_SCREENING = "UNDER SCREENING";
    public static final String APPLICATION_STATUS_NEW = "NEW";

    public static final String APPLICATION_STATUS_DOCUMENT_REVIEW = "DOCUMENT REVIEW";
    public static final String APPLICATION_STATUS_READY_FOR_SCREENING = "READY FOR SCREENING";
    public static final String APPLICATION_STATUS_UNDER_CLEARING_HOUSE_CHECK="UNDER CLEARING HOUSE CHECK";

    public static final String APPLICATION_STATUS_ACTIVE = "Active";
    public static final String APPLICATION_STATUS_DENIED = "Denied";
    public static final String APPLICATION_STATUS_REACTIVATE_TERMINATED = "Terminated_React";
    public static final String APPLICATION_STATUS_REACTIVATE_SUSPENDED = "Suspended_React";
    public static final String APPLICATION_STATUS_APPROVE_RAI = "Approved_RAI";
    public static final String APPLICATION_STATUS_APPROVE_RETROACTIVE = "Approved_RetroActive";
    public static final String APPLICATION_STATUS_APPROVE_REVALIDATION = "Approved_Revalidation";
    public static final String APPLICATION_STATUS_APPROVE_RE_ENROLLMENT = "Approved_ReEnrollment";

    public static final String APPLICATION_STATUS_ACTIVE2 = "ACTIVE";

    public static final String APPLICATION_STATUS_TERMINATED = "Terminated";
    public static final String APPLICATION_STATUS_TERMINATED2 = "TERMINATED";
    public static final String APPLICATION_STATUS_REACTIVATED = "Reactivated";
    public static final String APPLICATION_STATUS_SUBMITTED = "Submitted";
    public static final String APPLICATION_STATUS_SUBMITTED_FOR_BP = "Submitted_BillingProvider";
    public static final String APPLICATION_STATUS_SUBMITTED_FOR_SR = "Submitted_ServiceProvider";
    public static final String COC_APPLICATION_STATUS_SUBMITTED = "Coc Submitted";
    public static final String COC_APPLICATION_STATUS_APPROVED = "Coc Approved";
    public static final String COC_APPLICATION_STATUS_DENIED = "Coc Denied";

    public static final String APPLICATION_STATUS_APPROVED_FOR_SR = "Approved_ServiceProvider";
    public static final String APPLICATION_STATUS_DENIED_UPPERCASE = "DENIED";
    public static final String APPLICATION_STATUS_APPROVED_UPPERCASE = "APPROVED";
    public static final String APPLICATION_STATUS_SUSPENDED_UPPERCASE = "SUSPENDED";

    // REGISTRATION
    public static final String email = "543@gmail.com";
    public static final String testEmailAccount = "provideruser543@gmail.com";

    // public static final String email = "seniorqaautomation100@gmail.com";
    public static final String password = "Internaluser1!"; //"Emirates@2019"; "Aa123321!","Internaluser1!";
    public static final String conversionPassword = "asdqwe123@A";
    public static final String nameOfOrg = "HHS";
    public static final String firstName = "Bill";
    public static final String lastName = "Kopp";
    public static final String medicaidFile = "medicaid.png";
    public static final String providerTypeIndividual = "Individual";
    public static final String PROVIDER_TYPE_ORP = "ORP";
    public static final String providerTypeHospital = "Hospital";
    public static final String providerTypeSchool = "School";
    public static final String fein = "123456789";
    public static final String taxEntityType = "Corporation";
    public static final String program = "Medicaid";
    public static final String SPECIALITY_WAIVER = "Waiver";
    public static final String TAXONOMY_WAIVER = "251C00000X";
    public static final String specialityGastroenterology = "Gastroenterology";
    public static final String specialityDermatology = "Dermatology";
    public static final String specialityChiropractic = "Chiropractic";
    public static final String specialityInterpreter = "Interpreter";
    public static final String chiropractorTaxonomy = "111";
    public static final String middleName = "NMN";
    public static final String interpreterTaxonomy = "171R00000X";
    public static final String specialityAudiology = "Audiology";
    public static final String specialityNursingFacility = "Nursing Facility";
    public static final String nursingRequiredPaymentTaxonomy = "314000000X";
    public static final String specialityHomeHealth = "Home Health and Hospice";
    public static final String HomeHealthRequiredPaymentTaxonomy = "251E00000X";
    public static final String audiologyTaxonomy = "332";
    public static final String nursingTaxonomy = "314";
    public static final String specialityNeurology = "Neurology";
    public static final String specialityPhysicalTherapy = "Therapy";
    public static final String pharmacyType = "Mail Order";
    public static final String primaryTaxonomyCode = "333";
    public static final String pharmacyLicenseNumber = "3939393";
    public static final String taxonomyOption = "225100000X";
    public static final String taxonomyDescriptionPhysicalTherapist = "Physical";
    public static final String pathToTaxonomyFile = "Taxonomies.csv";
    public static final String pathToTaxonomyCategoriesFile = "TaxonomyCategories.csv";
    public static final String npi = "14";

    public static final String physicalAddress = "2500 SW 107th Ave Ste 39";
    public static final String proffesionalschoolcity="Key West";
    public static final String city = "Miami";
    public static final String state = "SD";

    public static final String inState  = "InState" ;
    public static final String outState  = "OutState" ;


    public static final String physicalAddressCA = "2537 River PLz dr";
    //    public static final String zipOutState = "95835";
    public static final String zipCA = "95833-3264";
    public static final String countyCodeSAC = "06067";
    public static final String stateCA = "California";
    public static final String citySAC = "Sacramento";
    public static final String mailingOutState = "California";

    public static final String physicalBillingAddressWY = "1233 E 2nd St";
    public static final String buildingApt = "200";
    public static final String zip = "82601-2926";
    public static final String zipWY = "82601-2926";
    public static final String countyCodeWY = "56025";
    public static final String countyCodeSD = "46003";

    public static final String phone = "1234567890";
    public static final String title = "Mr";
    public static final String ncpdp = "2883733737";
    public static final String inStateEnrollmentFeeForIndividual = "0";
    public static final String outStateEnrollmentFeeForIndividual = "0";
    public static final String inStateEnrollmentFeeForPEM = "0";
    public static final String outStateEnrollmentFeeForPEM = "0";
    public static final String inStateEnrollmentFeeForORP = "0";
    public static final String outStateEnrollmentFeeForORP = "0";
    public static final String inStateEnrollmentFeeForGroup = "0";
    public static final String outStateEnrollmentFeeForGroup = "0" ;
    public static final String inStateEnrollmentFeeForFacility = "631";
    public static final String outStateEnrollmentFeeForFacility = "0" ;
    public static final String inStateEnrollmentFeeForPharmacy = "631";
    public static final String outStateEnrollmentFeeForPharmacy = "0" ;


    //Screening Rankings
    public static final String ssnScreeningRanking = "10";
    public static final String licenseExpired = "10";
    public static final String NPIInvalidOrExpired = "10";
    public static final String TINFEINInvalidExpired = "10";
    public static final String deathIndicators = "10";
    public static final String lEIERecord = "10";
    public static final String ePLSRecords = "10";
    public static final String dex = "10";
    public static final String denNumber = "10";




    public static final String mailingState = "Florida";
    public static final String FLORIDA = "Florida";
    public static final String cardNumber = "4000056655665556";
    public static final String expirationDate = "0222";
    public static final String fullNameOnCard = "John Doe";
    public static final String cvv = "111";
    public static final String helloSignIframe = "hsEmbeddedFrame";

    //Trainings
    public static final String trainingRequired1 = "Training Required 1";
    public static final String trainingRequired2 = "Training Required 2";
    public static final String trainingRequired3 = "Training Required 3";
    public static final String trainingRequired4 = "Training Required 4";
    public static final String trainingRequired5 = "Training Required 5";

    public static final String taxLegalBusinessName = "TestLegalName";


    // Trading partner enrollment
    public static final String softwareVendorName = "Soft IT";
    public static final String softwareName = "Soft";
    public static final String versionId = "1.0";
    public static final String enityCode = "37373737";
    public static final String SOFTWARE_VENDOR = "HHS Technology Group";
    public static final String SOFTWARE_NAME = "DYP";
    public static final String VERSION_ID = "V.1.0";

    // TEXT MAIN TABS
    public static final String textEnrollmentTab = "Enrollment";
    public static final String textProvidersTab = "Providers";
    public static final String textProviderDataTab = "Provider Data";
    public static final String textSiteVisitsTab = "Site visits";
    public static final String textAffiliationsTab = "Affiliations";
    public static final String textReportsTab = "Reports";
    public static final String textHelpCenterTab = "Help center";
    public static final String textcredentialingTab = "Credentialing";
    public static final String textMCOTab= "MCO";
    // TEXT ENROLLMENT MENU OPTION
    public static final String optionChangeStatus = "Change status";
    public static final String optionSign = "Sign";
    public static final String pendingApprovalStatus = "Pending approval";
    public static final String pendingReviewStatus = "PENDING REVIEW";
    public static final String statusPendingApproval  ="PENDING APPROVAL";
    public static final String TEXT_VERIFY_PAYMENT = "Verify Payment";
    public static final String TEXT_CREATE_SITEVISIT = "Create Site Visit";
    public static final String DROPDOWN_VALUE_DOC_REVIEW = "Document Review";
    public static final String DROPDOWN_VALUE_DOC_REVIEW_APPROVED = "Document Review Approved";
    public static final String DROPDOWN_VALUE_CLEARING_HOUSE_CHECK_COMPLETED="Clearing House Check Completed";
    public static final String DROPDOWN_VALUE_UNDER_SCREENING = "Under Screening";



    // TEXT OF BUTTONS
    public static final String TEXT_SIGN_IN_REGISTER = "Sign In / Register";
    public static final String TEXT_REGISTER = "Register";
    public static final String TEXT_LOGIN = "Log in";
    public static final String TEXT_SEARCH = "Search";
    public static final String TEXT_NEW_MESSAGE = "NEW MESSAGE";
    public static final String TEXT_MY_ACCOUNT = "My Account";
    public static final String TEXT_ADD_USER = "Add User";
    public static final String TEXT_CANCEL = "Cancel";
    public static final String TEXT_CANCEL2 = "CANCEL";
    public static final String TEXT_MORE = "More";
    public static final String TEXT_OK = "OK";
    public static final String TEXT_Ok = "Ok";
    public static final String TEXT_EXIT = "EXIT";
    public static final String TEXT_Exit = "Exit";
    public static final String TEXT_AGREE = " AGREE";
    public static final String TEXT_VIEW = "VIEW";
    public static final String TEXT_ADD = "Add";
    public static final String TEXT_ADD_NEW = "Add new";
    public static final String TEXT_EDIT = "Edit";
    public static final String TEXT_EDIT2 = " Edit";
    public static final String TEXT_CREATE_RULE = "Create rule";
    public static final String TEXT_LEAVE_PAGE = "Leave page";
    public static final String TEXT_NEXT = "Next";
    public static final String TEXT_SAVE = "Save";
    public static final String TEXT_VERIFY = "Verify";
    public static final String TEXT_ADD_LINE = "+ Add Line";
    public static final String TEXT_BACK = "Back";
    public static final String TEXT_GO_TO_PAYMENT = "Go To Payment";
    public static final String TEXT_DOWNLOAD_INVOICE_PAYMENT = "Download Invoice";
    public static final String TEXT_CONTINUE_BILLING_INFORMATION = "Continue to Billing Information";
    public static final String TEXT_CONTINUE_PAYMENT_METHOD = "Continue to Payment Method";
    public static final String TEXT_SUBMIT_BUTTON = "Submit Payment";
    public static final String TEXT_SUBMIT = "SUBMIT";
    public static final String TEXT_Submit = "Submit";
    public static final String TEXT_PROCEED_TO_SIGN = "PROCEED TO SIGN";
    public static final String TEXT_SIGN = "SIGN";
    public static final String TEXT_Sign = "Sign";
    public static final String TEXT_NAVIGATE_TO_DASHBOARD = "Navigate to dashboard";
    public static final String TEXT_CLICK_TO_SIGN = "Click to sign";
    public static final String TEXT_TYPE_IT_IN = "Type it in";
    public static final String TEXT_INSERT = "Insert";
    public static final String TEXT_CONTINUE = "Continue";
    public static final String TEXT_I_AGREE = "I agree";
    public static final String TEXT_UPDATE = "Update";
    public static final String TEXT_APPLY = "Apply";
    public static final String TEXT_APPROVE = "Approve";
    public static final String TEXT_SUSPEND = " Suspend";
    public static final String TEXT_REACTIVATE = " Reactivate";
    public static final String TEXT_REACTIVATE2 = "Reactivate";
    public static final String TEXT_TERMINATE = "Terminate";
    public static final String TEXT_TERMINATE2 = " Terminate";
    public static final String TEXT_CREATE_REVALIDATION = "CREATE REVALIDATION";
    public static final String TEXT_ADD_COC = "Add Change of Circumstance";
    public static final String TEXT_CREATE = "Create";
    public static final String TEXT_CREATE_COC = "Create CoC";
    public static final String TEXT_CREATE_COC_SPACED = " Create CoC ";
    public static final String TEXT_GO_TO_COC = "Go to Change of Circumstance";
    public static final String TEXT_GO_TO_APPEALS = "Go to Appeals";
    public static final String TEXT_APPEAL = "Appeal";
    public static final String TEXT_UPLOAD_FILES = "Upload Files";
    public static final String TEXT_SITE_VISIT = "Site visit";
    public static final String TEXT_RESTORE = "Restore";
    public static final String TEXT_PURGE = "Purge";
    public static final String TEXT_Request_Termination = "Request Termination";
    public static final String TEXT_REQUEST_TERMINATION = "REQUEST TERMINATION";
    public static final String TEXT_DEACTIVATE = "DEACTIVATE";
    public static final String TEXT_UPPERCASE_REACTIVATE = "REACTIVE";
    public static final String TEXT_ENROLL_PROVIDER = "Enroll Provider";


    // ADMIN OPTIONS
    public static final String TEXT_SYSTEM_OPTIONS = "System Options";
    public static final String TEXT_LOG_OUT = "Log out";
   // public static final String TEXT_USERPROFILE = "Provider Admin (External User)";

    // MAIN TABS END-POINTS
    public static final String LINK_PROVIDERS = "/providers-list";
    public static final String LINK_ENROLLMENT = "/requests";
    public static final String LINK_REQUESTS = "/requests";
    public static final String LINK_COC = "/coc-list";
    public static final String LINK_APPEALS = "/appeal-list";
    public static final String LINK_AUDIT = "/audit";
    public static final String LINK_REPORTS = "/reports";
    public static final String LINK_SITE_VISIT = "/site-visit";
    public static final String LINK_PAYMENTS = "/payments";
    public static final String LINK_CLAIMS = "/claims";
    public static final String LINK_1099LINK = "/1099-list";

    public static final String LINK_VOTING = "/voting";
    public static final String LINK_HELPCENTER = "/helpcenter/";
    public static final String LINK_DOCUMENTS = "/csdn-redirect";
    public static final String LINK_MY_ACCOUNT = "/my-account";
    public static final String LINK_USERS = "/system/users";
    public static final String LINK_ROLES = "/system/roles";
    public static final String LINK_SCREENING = "/system/screening";
    public static final String LINK_RULE_EDITOR = "/system/rule-editor";
    public static final String LINK_AUTO_ASSIGN_RULES = "/system/auto-assign-rules";
    public static final String LINK_RULES = "/system/rules";
    public static final String LINK_DATA_CHANGE_ACTIONS = "/system/data-change-actions";
    public static final String LINK_DUPLICITY = "/system/duplicity";
    public static final String LINK_NOTIFICATION_ENGINE = "/system/notification-Engine-actions";


    public static final String LINK_APPROVALS_TYPE = "/system/approvals-type";
    public static final String LINK_APPROVALS_INDIVIDUAL = "/system/approvals/individual";
    public static final String LINK_APPROVALS_GROUP = "/system/approvals/group";
    public static final String LINK_APPROVALS_PHARMACY = "/system/approvals/pharmacy";
    public static final String LINK_APPROVALS_ORP = "/system/approvals/ORP";
    public static final String LINK_APPROVALS_PEM = "/system/approvals/PEM";
    public static final String LINK_APPROVALS_FACILITY = "/system/approvals/facility";
    public static final String LINK_REMINDER_TO_REVIEWERS = "system/reminders-to-reviewers";


    public static final String LINK_APPROVALS_REQUEST = "/system/approval/request";
    public static final String LINK_REVALIDATION = "/system/revalidation";
    public static final String LINK_ERROR_MESSAGES = "/system/error-message-dropdowns";
    public static final String LINK_USER_PROFILE = "/system/userprofile";
    public static final String LINK_USER_DEACTIVATION = "/system/userdeactivation";
    public static final String LINK_PASSWORD_POLICY = "/system/passwordpolicy";
    public static final String LINK_PAYMENT_FEES = "/system/paymentsandfees";
    public static final String LINK_AFFILIATIONS = "/system/affiliations";

    public static final String LINK_AUTOARCHIVE = "/system/autoarchive";
    public static final String LINK_BUILDER_INDIVIDUAL = "/builder/provider";
    public static final String LINK_BUILDER_GROUP = "/builder/provider_group";
    public static final String LINK_BUILDER_FACILITY = "/builder/facility";
    public static final String LINK_BUILDER_ORP = "/builder/orp";
    public static final String LINK_BUILDER_PHARMACY = "/builder/Pharmacy";
    public static final String LINK_CUSTOM_SECTIONS = "/system/custom-sections";


    // TITLES MAIN TABS
    public static final String expectedTitleProviders = "Providers Inquiry";
    public static final String expectedTitleEnrollment = "Enrollment";
    public static final String expectedTitleCoc = "Change of Circumstance";
    public static final String expectedTitleReconsideration = "Reconsideration";
    public static final String expectedTitleAudit = "Audit";
    public static final String expectedTitlePayments = "Payments";
    public static final String expectedTitleClaims = "Claims";
    public static final String expectedTitle1099 = "Form 1099";
    public static final String expectedTitle10992 = "1099";
    public static final String expectedTitleSiteVisits = "Site visits";
    public static final String expectedTitleSiteReports = "Reports";
    public static final String expectedTitleVoting = "Voting requests";
    public static final String titleMyAccount = "My account";
    public static final String titleUsers = "Users";
    public static final String titleManagement = "User Management";
    public static final String titleAddNewUser = "Add New User";
    public static final String titleRoles = "Roles";
    public static final String titleRoleManagement = "Role Management";
    public static final String titleAddNewRole = " Add New Role";
    public static final String titleBackToDashboard = "←Back to dashboard";
    public static final String titleScreening = "Screening";
    public static final String titleScreeningIssuesRanking = "Screening Issues Ranking";
    public static final String TITLE_MEDIBOOK = "MediBook";
    public static final String TITLE_PAYERS = "payers";
    public static final String TITLE_EDI = "EDI";
    public static final String TITLE_ELIGIBILITY = "eligibility";
    public static final String TITLE_AUTHORIZATION = "authorization";
    public static final String TITLE_DASHBOARD = "Dashboard";
    public static final String TITLE_NPI = "NPI";
    public static final String TITLE_DOB = "DOB";
    public static final String TITLE_SPECIALITY = "Speciality";
    public static final String TITLE_GENDER = "Gender";
    public static final String TITLE_REVALIDATION_DUE_DATE = "Revalidation Due Date";

    public static final String titleRules = "Rules";
    public static final String systemOptionRuleAssignment = "Rule Assignment";
    public static final String systemOptionRuleEditor = "Rule Editor";
    public static final String pageTitleRuleEditor = "Rules Editor";

    public static final String systemOptionTitleAutoAssign = "Auto Assign";
    public static final String systemOptionTitleDataChange = "Data Change";
    public static final String systemOptionTitleSecurityPolicy = "Security Policy";
    public static final String systemOptionTitleSiteVisit = "Site Visit";
    public static final String systemOptionTitlePaymentsFees = "Payments & Fees";
    public static final String systemOptionAutoArchive = "Auto Archive";
    public static final String titleAutoAssign = "Auto assign";
    public static final String titleNewRule = "New rule";
    public static final String titleBuilder = "Builder";
    public static final String titleNotificationEngine = "Notification Engine";

    public static final String titleApprovals = "Approvals";
    public static final String titleRevalidation = "Revalidation";
    public static final String titleRevalidationGroupProvider = "Revalidation- Group provider:outstanding revalidations";

    public static final String titleAffiliations = "Affiliations";
    public static final String titleCustomSections = "Custom Sections";

    public static final String titleExternalization = "Externalization";
    public static final String titleDeactivation = "User Deactivation";
    public static final String titleErrorMessagesAndDropdowns = "Error Messages and Dropdowns";
    public static final String titleAuditEventNamesAndTags = "Audit Event Names and Tags";
    public static final String titleSystemDowntimeMessages = "System Downtime Messages";
    public static final String titleUserInactivity = "User Inactivity";
    public static final String titlePasswordPolicy = "Password Policy";
    public static final String titleLoginTimeout = "Login Timeout";

    //ENROLLMENTS MENU OPTIONS
    public static final String addressDetails = "Address Details";
    public static final String summary = "Summary";
    public static final String licenseType = "License";
    public static final String licenseIssueType = "Wyoming";

    // DATA CHANGE
    public static final String titleActionsDataChange = "Actions on data change";

    // PAYMENTS FEE AND CONFIGURATIONS
    public static final String titlePaymentAndFeesConfigurations = "Payments and Fees Configuration";
    public static final String titleIndividualProviderEnrollmentFees ="Individual Provider Enrollment Fees";
    public static final String titleGroupProviderEnrollmentFees = "Group Provider Enrollment Fees";
    public static final String titleFacilityProviderEnrollmentFees = "Facility Provider Enrollment Fees";
    public static final String titlePharmacyProviderEnrollmentFees = "Pharmacy Enrollment Fees";
    public static final String titlePEMProviderEnrollmentFees = "Provider Enrollment Manager Enrollment Fees";
    public static final String titleORPProviderEnrollmentFees = "Ordering/Referring/Prescribing Provider Enrollment Fees";
    public static final String titleInStateInstitutionalEnrollmentFees = "In-State";
    public static final String titleOutStateInstitutionalEnrollmentFees = "Out of state";
    public static final String titleExit = "Exit";
    public static final String titleBack = "Back to";
    public static final String pymtFeesIndivFeeCharged = "100";
    public static final String pymtFeesIndivInState = "200";
    public static final String pymtFeesIndivOutOfState = "250";
    public static final String pymtFeesGroupFeeCharged = "100";
    public static final String pymtFeesGroupInState = "100";
    public static final String pymtFeesGroupOutOfState = "100";
    public static final String pymtFeesFacilityFeeCharged = "0";
    public static final String pymtFeesFacilityInState = "599";
    public static final String pymtFeesFacilityOutOfState = "0";
    public static final String pymtFeesPharmacyFeeCharged = "0";
    public static final String pymtFeesPharmacyInState = "599";
    public static final String pymtFeesPharmacyOutOfState = "0";
    public static final String pymtFeesPEMFeeCharged = "0";
    public static final String pymtFeesPEMInState = "595";
    public static final String pymtFeesPEMOutOfState = "0";
    public static final String pymtFeesORPFeeCharged = "0";
    public static final String pymtFeesORPInState = "595";
    public static final String pymtFeesORPOutOfState = "0";

    // CONFIGURE AUTOARCHIVE
    public static final String titleAutoArchiveData = "Auto Archive Data";
    public static final String titleAutoArchiveFiles = "Auto Archive Files";

    //APPROVALS
    public static final String titleEnrollmentApproval = "Enrollment Approval";

    //DUPLICITY SYSTEM OPTIONS
    public static final String titleDuplicity = "Duplicity";
    public static final String duplicityCutOffPercentage = "60";
    public static final String duplicityNPI = "9";
    public static final String duplicitySSNFEIN = "9";
    public static final String duplicityTaxonomy = "7";
    public static final String duplicityDBA = "6";
    public static final String duplicityZip = "6";
    public static final String duplicityDOB = "6";
    public static final String duplicityDEANumber = "6";

    //LICENSURE SYSTEMS OPTIONS
    public static final String titleLicensure = "Licensure";
    public static final String licensure1STNotificationDays = "90";
    public static final String licensure2NDNotificationDays = "60";
    public static final String licensure3RDNotificationDays = "30";

    //REMINDER TO REVIEWERS
    public static final String reminderToReviewerTitle = "Reminders to Reviewers";
    public static final String remindersToReviewers1STNotificationDays = "3";
    public static final String remindersToReviewers2NDNotificationDays = "5";
    public static final String remindersToReviewers3RDNotificationDays = "10";

    //REQUEST ADDITIONAL INFORMATION SYSTEM OPTIONS
    public static final String titleRequestAdditionalInfo = "Request additional Information";
    public static final String REQUESTED_ADDITIONAL_INFORMATION = "Requested Additional Information";
    public static final String reqAddInfo1STNotificationDays = "3";
    public static final String reqAddInfo2NDNotificationDays = "10";
    public static final String reqAddInfo3RDNotificationDays = "30";

    //REVALIDATIONS AND REMINDERS
    public static final String revalAndRemRevalDateDays = "Enrollment Approved Date";
    public static final String revalAndRem1STNotificationDays = "90";
    public static final String revalAndRem2NDNotificationDays = "60";
    public static final String revalAndRem3RDNotificationDays = "30";
    public static final String revalAndRemGroupRevalDays = "15";
    public static final String pemrevalAndRemGroupRevalDays = "1";
    public static final String revalAndRemAfterRevalPeriod = "1";


    //REMINDERS to REVIEWERS

    //USER PROFILE SYSTEM OPTIONS
    public static final String titleUserProfile = "User Profile";

    // Providers
    public static final int expectedNumberOfTextFieldsProviders = 7;
    public static final int expectedNumberOfLists = 2;
    public static final int DAYS_SUSPENDED_MINUS_15 = -15;
    public static final int DAYS_TERMINATED_MINUS_30 = -30;
    public static final int DAYS_TERMINATED_MINUS_16 = -16;

    //USER DEACTIVATION
    public static final String userDeactInactiveDays = "180";
    public static final String userDeactInviteNotAccepted = "30";

    // PASSWORD POLICY
    public static final String passPolicyRegPassLength = "8";
    public static final String passPolicyPrivPassLength = "8";
    public static final String passPolicyPreventPassReuse = "24";
    public static final String passPolicyPreventPassResets = "12";
    public static final String passPolicyEnablePassExpireReg = "90";
    public static final String passPolicyEnablePassExpirePriv = "90";
    public static final String passPolicyEnableLockForLogin = "10";
    public static final String passPolicyAcctLockoutPeriod = "2";

    //ENROLLMENT TYPE
    public static final String titleEnrollmentType = "Enrollment Types";

    //Screening
    public static final String monitoringFrequency = "30";

    // Reports
    public static final String cannedTab = "Canned";
    public static final String letterTab = "Letter";
    public static final String adHocTab = "Ad hoc";

    // Inbox
    public static final String inboxTab = "Inbox";
    public static final String sentTab = "Sent";
    public static final String draftsTab = "Drafts";
    public static final String archiveTab = "Archive";
    // ANY TITLE
    public static final String h1 = "h1";
    public static final String h2 = "h2";
    public static final String h3 = "h3";
    public static final String h4 = "h4";
    public static final String h6 = "h6";

    // Auto Assign rule
    //********************************************************************************************************************
    //Application Types
    public static final String cocApplication = "CoC";
    public static final String enrollmentApplication = "Enrollment";
    //If Parameter
    public static final String status = "Status";
    public static final String Parameter_Enrollment = "Enrollment Type";

    //Operator
    public static final String equals = "Equals";

    //StatusValue
    public static final String pendingApproval = "Pending Approval";
    public static final String StatusValueIndividual= "Individual";
    public static final String StatusValueGrp= "Group";

    //Assign to
    public static final String role = "Role";

    //Assign Value
    public static final String enrollmentSupervisor = "Enrollment Supervisor";
    public static final String DoValueCallCenterSprvsr = "Call Center Supervisor";

    // PROVIDER

    //********************************************************************************************************************
    //MODIFIED THE FOLLOWING on 08/14 PER SP34 PART 2 CHANGES
    public static final String individualApplication = "Individual Enrollment";
    public static final String MCOApplication = "Managed Care Organisation Enrollment";
    public static final String MCO_Provider = "MCO";
    public static final String INDIVIDUAL_APPLICATION_BILLING_PROVIDER = "Individual Billing Provider";
    public static final String groupApplication = "Entity Enrollment";
    public static final String pharmacyApplication = "Pharmacy";
    public static final String facilityApplication = "Facility";
    public static final String orpApplication = "Prescribing Provider Enrollment";
    public static final String pemApplication = "Provider Enrollment Manager";
    public static final String mcoApplication = "MCO";
    public static final String PHARMACY_COC_APPLICATION = "Pharmacy CoC Application";
    public static final String GROUP_COC_APPLICATION = "Group CoC Application";
    public static final String FACILITY_COC_APPLICATION = "Facility CoC Application";
    public static final String ORP_COC_APPLICATION = "ORP CoC Application";
    public static final String PEM_COC_APPLICATION = "PEM CoC Application";
    public static final String INDIVIDUAL_COC_APPLICATION = "Individual CoC Application";
    public static final String PHARMACY_APPEAL_APPLICATION = "Pharmacy APPEAL Application";
    public static final String GROUP_APPEAL_APPLICATION = "Group APPEAL Application";
    public static final String FACILITY_APPEAL_APPLICATION = "Facility APPEAL Application";
    public static final String ORP_APPEAL_APPLICATION = "ORP APPEAL Application";
    public static final String PEM_APPEAL_APPLICATION = "PEM APPEAL Application";
    public static final String INDIVIDUAL_APPEAL_APPLICATION = "Individual APPEAL Application";
    public static final String TRADING_PARTNER = "Trading Partner Enrollment";
    public static final String MCO="Managed Care Organisation Enrollment";
    public static final String TRADING_PARTNER_AGREEMENT = "Trading partner Agreement";
//    public static final String entityApplication = "Entity Enrollment" ;
    // public static final String pemApplication = "Provider enrollment manager";

    //********************************************************************************************************************

    // PROVIDER@Affiliation

    public static final String CHANGE_OF_CIRCUMSTANCE_TYPE_ADD = "Add Affiliation";
    public static final String CHANGE_OF_CIRCUMSTANCE_TYPE_END= "End Affiliation";

    //********************************************************************************************************************
    public static final String individualAffApplication = "Individual enrollment";
    public static final String groupAffApplication = "Group enrollment";
    public static final String pharmacyAffApplication = "Pharmacy enrollment";
    public static final String facilityAffApplication = "Facility";
    public static final String orpAffApplication = "prescribing provider enrollment";


    //********************************************************************************************************************
    public static final String genderMale = "Male";
    public static final String genderFemale = "Female";
    public static final String countryOfBirth = "United States";
    public static final String stateOfBirth = "South Dakota";
    public static final String dob = "04/04/1981";
    public static final String ssn = "727238484";
    public static final String applicationContactNo="1234567890";
    public static final String profitStatusNonProfit = "Non-Profit";
    public static final String profitStatusNonProfit501 = "Non-Profit 501(C)(3)";

    public static final String typeBusiness = "Healthcare";
    public static final String medicaidPaymentYes = "Yes";
    public static final String medicaidPaymentNo = "No";

    public static final String LANGUAGE_ENGLISH = "English";

    // SCREENING AND REVALIDATION
    public static final String screeningFile100 = "100screening.xml";

    public static final String URI_SCREENING = "api/screening/import/medversantScreening";
    public static final String URI_REVALIDATION = "/api/hummingbird/test/revalidate";
    public static final String URI_CallScheduler = "/api/hummingbird/revalidation-settings/callScheduler";
    public static final String URI_ScheduleUpcomingReValidations = "/api/hummingbird/scheduler/scheduleUpcomingReValidations";
    public static final String timeToRevalidationMinus30d = "-30d";
    public static final String timeToRevalidationMinus29d = "-29d";
    public static final String timeToRevalidationMinus1d = "-1d";
    public static final String timeToRevalidationPlus1d = "1d";
    public static final String timeToRevalidationPlus29d = "29d";
    //public static final String timeToRevalidationPlus30d = "30d";
    public static final String timeToRevalidationPlus30d = "30";
    public static final String timeToRevalidationPlus5y = "5";
    public static final String timeToRevalidationPlus60d = "60d";
    //    public static final String timeToRevalidationPlus90d = "90d";
    public static final String timeToRevalidationPlus91d = "91d";
    public static final String terminationMessage = "Enrollment will be terminated in ";
    public static final String revalidationMessage = "Be informed, your enrollment revalidation is in ";
    public static final String termination23d = "23 hours";
    public static final String termination28d = "28 days";
    public static final String revalidation1d = "day";
    public static final String revalidation1m = "month";
    public static final String revalidation2m = "2 months";
    public static final String revalidation3m = "3 months";
    public static final String applicationStatusTerminated = "Terminated";
    public static final String applicationStatusActive = "Active";
    public static final String applicationStatusSuspended = "Suspended" ;

    // SYSTEM OPTIONS
    public static final String expectedTaxonomytitle = "Add Taxonomy";

    //CALENDAR
    // public static final String effectiveDateCalendar = "Effective Date *";
    public static final String EFFECTIVE_DATE = "Effective Date *";

    public static final String effectiveStartDateCalendar = "Effective start date *";
    public static final String effectiveStartDate = "Effective Start Date";
    public static final String effectiveDate = "Effective";
    public static final String EFFECTIVE_START_DATE = "Effective Start Date *";
    public static final String LOCATION_TAXONOMY_EFFECTIVE_START_DATE = "Location Taxonomy Effective Start Date";
    public static final String LOCATION_TAXONOMY_EFFECTIVE_END_DATE = "Location Taxonomy Effective End Date";

    public static final String START_DATE = "Start Date *";
    public static final String effectiveEndDateCalendar = "Effective end date *";
    public static final String effectiveDateCalendar2 = "Effective Date";

    public static final String endDateCalendar = "End Date";
    public static final String dateOfBirthCalendar = "Date of birth *";
    public static final String dateOfBirthCalendar2 = "Date of Birth";
    public static final String suspendedFormCalendar = "Suspended from *";
    public static final String reactivateFormCalendar = "Reactivate from *";
    public static final String datepaymentreceived = "Date Payment received";
    public static final String dateFirstVisit = "Date of First Visit *";
    public static final String PROFFESIONALSCHOOLNAME="Little flowers";

    public static final String requestedEnrollmentDate = "Select Requested Enrollment Date *";
    public static final String enrollmentBeginDate = "Enrollment Begin Date *" ;
    public static final String otherMedicaidStateFieldRequired = "Other Medicaid State field is required" ;
    public static final String stateProgramFieldRequired = "State Program field is required" ;
    public static final String enrollmentBeginDateFieldIsRequired = "Enrollment Begin Date field is required" ;
    public static final String MEDICARE_ID_FIELD_IS_REQUIRED= "Medicare Id field is required";
    public static final String EFFECTIVE_DATE_FIELD_IS_REQUIRED = "Effective Date field is required";
    public static final String END_DATE_FIELD_IS_REQUIRED = "End Date field is required" ;
    public static final String MEDICARE= "Medicare";

    //PERMISSIONS
    public static final String generalPermissions = "General";

    //CALENDAR
    public static final String CALENDAR = "//div[@role='document']";
    public static final String YEAR_HEADER = ".//div/h3";
    public static final String YEAR = ".//div[text() = '%s']";
    public static final String MONTH = ".//span[text() = 'keyboard_arrow_left']/ancestor::div[not(@class)]//p";
    public static final String MONTH_ARROW_RIGHT = ".//span[text() = 'keyboard_arrow_right']";
    public static final String MONTH_ARROW_LEFT = ".//span[text() = 'keyboard_arrow_left']";
    public static final String DAY_OF_MONTH = ".//div[@role = 'presentation']/button[@tabindex = '0']//span[text() ='%s']";
    public static final String OK_BUTTON = ".//button[span[text() = 'OK']]";
    public static final String CLICK_TIME_CLOCK = ".//button//span[contains(text(),'access_time')]";
    //   private static final String CLICK_HOURSORMINUTES="..//span[contains(text(),'%s')]";
    public static final String CLICK_HOURSORMINUTES = ".//div[@role='menu']";
    public static final String YEAR1 = ".//div/h3[text() = '%s']";
    public static final String CALENDAR_POP_UP = ".//div[@role='document']";
    public static final String DATE_OF_BIRTH = "//div[@data-for ='Date of birth']//div//button";
    public static final String EFFECTIVE_DATE_CALENDAR = "//div[contains(@class, 'datepicker')]//button";
    public static final String END_EFFECTIVE_DATE_CALENDAR = "//div[@data-for='Effective end date']//button";

    //coc type
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_ADDRESS ="Address Details" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_IDENTIFYING = "Identifying Information" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_OWNERSHIP ="Ownership" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PGRM_PARTCPTN ="Program Participation" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PROV_IDENTIFY ="Provider Identifiers" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_TAXONOMY ="Taxonomy / License Information" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_PRIMARY_SERVICE_LOCATION ="Primary Service Location Information" ;
    public static final String COC_SELECT_CHECKBOX_PGRM_PARTICIPATION_OR_TAXONOMY_LICENSE = "Program Participation / Taxonomy / License and Service location" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_KEY_PERSONNEL ="Key Personnel" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_EFT ="EFT Information" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_RETRO_ACTIVE ="Request Retroactive Adjustment" ;
    public static final String COC_ENROLLMENT_DATA_SELECT_CHECKBOX_CLASSIFICATION ="Classification" ;

    //CoC error messages
    public static final String COC_ERROR_MSG_CANT_CHANGE_OWNERSHIP =  "Cannot change ownership, please submit new enrollment" ;
    public static final String COC_ERROR_MSG_CANT_CHANGE_PRGM_PARTICIPATION =  "Cannot change program participation. Please contact helpdesk.";

    //CSDN Documents
    public static final String SECTION_MANAGE_FILES = "Manage files";
    public static final String SECTION_ARCHIVED_FILES = "Archived files";
    public static final String ONE_ROOT_FOLDER = "//div[@type='Folder']//span";

    //PRIMARY TAXONOMY
    public static final String PRIMARY_TAXONOMY_THERAPY = "Therapy";
    public static final String PRIMARY_TAXONOMY_PODIATRY = "Podiatry";
    public static final String PRIMARY_TAXONOMY_PHYSICIAN = "Physician";
    public static final String PRIMARY_TAXONOMY_VISION = "Vision";
    public static final String PRIMARY_TAXONOMY_PHARMACIST = "Pharmacist";
    public static final String PRIMARY_TAXONOMY_AMBULANCE = "Ambulance";
    public static final String PRIMARY_TAXONOMY_DHCF_ALLOWANCE = "DHCF Allowance";
    public static final String PRIMARY_TAXONOMY_SPECIALTY_CLINIC = "Specialty Clinic";

    //MongoDB Database Names and CollectionNames
    public static final String MONGODB_DBNAME_FOR_PRDMGNT = "providermgmt";
    public static final String MONGODB_COLLECTION_FOR_TAXONOMY = "taxonomy";
    public static final String MONGODB_COLLECTION_FOR_PROVIDER_DATA = "providersData";


    // COC address change
    public static final String cocAddress2 = "2001 Dewar Dr ";
    public static final String COC_ADDRESS_3 = "10 Aspen ";
    public static final String cocZip2 = "82901";
    public static final String cocZipWY2 = "82901-5773";
    public static final String cocCountyCodeWY = "56037";
    public static final String cocCity2 = " Rock Springs";

    public static final String END_Button = "END";
    public static final String Retroactive = "Requested Retroactive Effective Date *";

    //Roles
    public static final String SUPER_ADMIN_ROLE = "Super Admin";
    public static final String Enrollment_SUPERVISOR_ROLE = "Enrollment Supervisor";
    public static final String CALL_CENTER_SUPERVISOR_ROLE = "Call Center Supervisor";

    //Approval Configurations Tye
    public static final String ENROLLMENT = "Enrollment";
    public static final String APPEAL = "Appeal";
    public static final String CHANGE_OF_CIRCUMSTANCE = "Change of Circumstance";
    public static final String SITE_VISIT = "Site Visit";
    public static final String RE_ENROLLMENT = "Re Enrollment";
    public static final String REVALIDATION = "Revalidation";
    public static final String LOGIN_TEXT = "Login";

    public static final String SD_CONTENT = "This system contains U.S. Government and State of Florida information." +
            " By accessing and using this computer system you are consenting to system monitoring" +
            " for law enforcement, auditing, and other purposes. Unauthorized use of, or access to," +
            " this computer system may subject your to state and federal. criminal prosecution and penalties," +
            " as well as civil penalties. Unauthorized use of the system is prohibited.";


    public static final String KEY_RESOURCES_SD_MEDICAID_HOME = "South Dakota Medicaid Home";
    public static final String KEY_RESOURCES_SD_MEDICAID_PROVIDER_ENROLLMENT_HOME = "SD Medicaid Provider Enrollment Home";
    public static final String KEY_RESOURCES_PROVIDER_FEE_SCHEDULES = "Provider Fee Schedules";
    public static final String KEY_RESOURCES_PROVIDER_BILLING_MANUALS = "Provider Billing Manuals";
    public static final String KEY_RESOURCES_MEDICAID_ONLINE_PORTAL = "Medicaid Online Portal (Look-up for remits, recipient eligibility, and claim entry)";
    public static final String KEY_RESOURCES_LISTSERV_SIGNUP = "ListServ sign-up";
    public static final String KEY_RESOURCES_SD_ADMINISTRATIVE_RULES = "SD Administrative Rules";
    public static final String KEY_RESOURCES_SD_CODIFIED_LAWS = "SD Codified Laws";


    public static final String STATE_HOME_PAGE_LINK_BTN = "State Home page";
    public static final String DISCLAIMER_LINK_BTN = "Disclaimer";
    public static final String ACCESSIBILITY_LINK_BTN = "Accessibility";
    public static final String PRIVACY_LINK_BTN = "Privacy Policy";
    public static final String HIPAA_LINK_BTN = "HIPAA";
    public static final String CONTACT_US_LINK_BTN = "Contact Us";
    public static final String PROVIDER_SEARCH = "Provider Search";
    public static final String CREATE_ACCOUNT = "Create Account";
    public static final String FORGOT_PASSWORD = "Forgot Password?";
    public static final String SHOW_MORE = "Show more";
    public static final String SUPPORT_EMAIL = "support@emailaddress.com";
//    public static final String HOME = "Home";
    public static final String HOME = "Home";
    public static final String TERMS_CONDITION="Terms & Conditions";
    public static final String LOGO = "South Dakota Portal logo";

    public static final String EXCLUSION_SANCTION_UPLOAD_DOC = "Exclusion/Sanction Documents" ;

    public static final String LINK_STATE_HOME_PAGE = "/cs";
    public static final String LINK_DISCLAIMER = "/disclaim.aspx";
    public static final String LINK_ACCESSIBILITY = "/accpolicy.aspx";
    public static final String LINK_PRIVACY = "/privacy.aspx";
    public static final String LINK_HIPAA = "/hipaa/";
    public static final String LINK_PROVIDER_SEARCH = "provider-search";

    public static final String STATE_HOME_PAGE_LINK_URL = "https://www.sd.gov/cs";
    public static final String DISCLAIMER_LINK_URL = "https://sd.gov/disclaim.aspx";
    public static final String ACCESSIBILITY_LINK_URL = "https://sd.gov/accpolicy.aspx";
    public static final String PRIVACY_LINK_URL = "https://sd.gov/privacy.aspx";
    public static final String HIPAA_LINK_URL = "https://dss.sd.gov/keyresources/hipaa/";
    public static final String CONTACT_US_MAIL_ID = "mailto:sdmedxsecurity@state.sd.us";
    public static final String PROVIDER_SEARCH_URL = "sit-01.sd.hhstechgroup.com/provider-search";


    //EFT Information
    public static final String FINANCIAL_INSTITUTION_NAME = "Financial Institution";
    public static final String ROUTING_NUMBER = "123456789";
    public static final String ACCOUNT_NUMBER = "1234567890";
    public static final String ACCOUNT_TYPE_CHECKING = "Checking account";
    public static final String ACCOUNT_TYPE_SAVING = "Saving account";

    //Classification Types
    public static final String CLEARING_HOUSE = "Clearinghouse";
    public static final String ENTITY_OPTION =  "Kermit";

    public static final String INDIVIDUAL_PROVIDER = "Individual Enrollment";

    public static final String SERVICING_PROVIDER = "Servicing Enrollment";
    public static final String BILLING_PROVIDER = "Billing Enrollment";
    public static final String ENTITY_PROVIDER = "Entity Enrollment" ;
    public static final String PEM_PROVIDER = "Provider Enrollment Manager";
    public static final String PEM_PROVIDER_INITIALS = "PEM";
    public static final String TP_PROVIDER_INITIALS = "TP";
    public static final String INDIVIDUAL_PROVIDER_INITIALS = "Individual";

    public static final String ENTITY_PROVIDER_INITIALS = "Group";

    //Provider Info Enrollment Types - Begin
    public static final String SERVICING_PROVIDER_COC = "Servicing CoC";
    public static final String BILLING_PROVIDER_COC = "Billing CoC";
    public static final String ENTITY_PROVIDER_COC = "Entity CoC" ;
    public static final String TRADING_PARTNER_COC = "Trading Partner (TP) CoC";
    public static final String PEM_PROVIDER_COC = "Provider Enrollment Manager CoC";

    public static final String SERVICING_PROVIDER_RECONSIDERATION = "Servicing Reconsideration";
    public static final String BILLING_PROVIDER_RECONSIDERATION = "Billing Reconsideration";
    public static final String ENTITY_PROVIDER_RECONSIDERATION = "Entity Reconsideration" ;
    public static final String TRADING_PARTNER_RECONSIDERATION = "Trading Partner (TP) Reconsideration";
    public static final String PEM_PROVIDER_RECONSIDERATION = "Provider Enrollment Manager Reconsideration";

    public static final String TRADING_PARTNER_REVALIDATION = "Trading Partner (TP) Revalidation";
    public static final String BILLING_PROVIDER_REVALIDATION = "Billing Revalidation";
    public static final String SERVICING_PROVIDER_REVALIDATION = "Servicing Revalidation";


    //
    public static final String ENTITY_REVALIDATION = "Entity Revalidation";
    public static final String PEM_PROVIDER_REVALIDATION = "Provider Enrollment Manager Revalidation";
    public static final String ENTITY_RE_ENROLLMENT = "Entity Re_Enrollment";
    public static final String BILLING_RE_ENROLLMENT = "Billing Re_Enrollment";
    public static final String SERVICING_RE_ENROLLMENT = "Servicing Re_Enrollment";
    //Provider Info Enrollment Types - End

    public static final String CREATE_SITE_VISIT = "Create Site Visit";
    public static final String REQUESTED_ADDITIONAL_INFORMATION_STATUS = "REQUESTED ADDITIONAL INFORMATION";
    public static final String UPDATED_SSN = "897238484";

    public static final String UPDATED_LBN = "SDProvider";
    public static final String INDV_MEDICAID_CHIP = "Medicaid/CHIP" ;
    public static final String ADSL  = "ADLS waiver (DHS)" ;

    //Need to refactor this after IUAT4 efforts(Farhan 5/19)
    public static final String ENT_MEDICAID_CHIP = "Medicaid/CHIP" ;

    public static final String AFFILIATION_TYPE_GRP_TO_IND="Entity to Individual";

    public static final String MEDICAID_CHIP = "Medicaid/CHIP" ;

    public static final String CHOICES_WAIVER = "CHOICES waiver (DHS)" ;
    public static final String TAXONOMY_HOSPITAL_GENERAL_CAR = "282N00000X - Hospital - General Acute Care" ;
    public static final String TAXONOMY_SUBSTANCE_USE_DISORDER = "261QR0405X - Substance Use Disorder - Outpatient" ;
    public static final String TAXONOMY_PHYSICAL_THERAPIST = "225100000X - PHYSICAL THERAPIST" ;
    public static final String PHYSICAL_THERAPIST_SPECIALITY="PHYSICAL THERAPIST - 091";
    public static final String Trading_Partner999="Trading Partner - 999";
    public static final String LICENSE_FOR_PHYSICAL_THERAPIST_SPECIALITY="Other";
    public static final String TAXONOMY_COMMUNITY_SUPPORT = "251X00000X - Community Transition Supports" ;
    public static final String GROUP_SINGLE_SPECIALTY = "193200000X - Group - Multi-Specialty" ;
    public static final String MCOTaxonomy="305R00000X - PREFERRED PROVIDER ORGANIZATION";
    public static final String LICENSE_PHYSICAL_THERAPY_PT = "Physical Therapy (PT)" ;
    public static final String LICENSE_TYPE= "null" ;
    public static final String LICENSE_TYPE_DSS_CERTIFICATION = "SD DSS Certification" ;
    public static final String TAXONOMY_INTERMEDIATE_CARE = "315P00000X - Intermediate Care - Disabled (ICF-IID)" ;
    public static final String HOSPITALS_AND_UNITS = "Hospitals & Units" ;
    public static final String PHYSICIAN_ASSISTANT_AND_ADVANCED_PRACTICE_NURSE  = "Physician Assistant & Advanced Practice Nurse" ;
    public static final String THERAPY = "Therapy" ;
    public static final String LONG_TERM_SERVICE = "Long-Term Services & Supports";
    public static final String MENTAL_HEALTH_AND_SUBSTANCE = "Mental Health & Substance Treatment Facilities" ;
    public static final String GROUP = "Group" ;
    public static final String AFFILIATION_TYPE_IND_TO_GRP = "Individual to Entity" ;

    public static final String PROVIDER_ID="4000000";
    public static final String LONG_TERM_SERVICES = "Long-Term Services & Supports" ;
    public static final String EFFECTIVE_END_DATE = "Effective end Date";
    public static final String EFFECTIVE_DATE_START = "Effective start Date";
    public static final String SOUTH_DAKOTA = "South Dakota";
    public static final String ASIAN="ASIAN";
    public static final String LICENSE_NUMBER  = "78A186138" ;
    public static final String EFFECTIVE_END = "Effective end";
    public static final String EFFECTIVE_ENDDate = "Effective End Date";
    public static final String EFFECTIVE_START = "Effective start";
    public static final String EFFECTIVE_START_DATE_MCO_IU="Effective start date *";
    public static final String EFFECTIVE_STARTDate = "Effective Start Date";
    public static final String COUNTY_CODE_SD = "57224";
    public static final String MANNER_OF_SERVICES =  "In-Person";


    //Provider History
    public static final String PROVIDER_HISTORY_SUSPENSION = "Provider Suspension";
    public static final String PROVIDER_HISTORY_TERMINATION = "Provider Terminated";
    public static final String PROVIDER_HISTORY_REACTIVATION = "Reactivation";

    public static String ENROLLMENT_REQUEST_NO;
    public static String ENROLLMENT_APPLICATION_TYPE;

    public static final String ENTITY_PROVIDER_REQUEST_TERMINATION = "Entity Request Termination" ;
    public static final String BILLING_PROVIDER_REQUEST_TERMINATION = "Billing Request Termination" ;
    public static final String SERVICING_PROVIDER_REQUEST_TERMINATION = "Servicing Request Termination" ;

    //Enrollment type
    public static final String ENROLLMENT_ADDRESS_DET_SECTION ="Address Details" ;
    public static final String ENROLLMENT_PROV_IDEN_SECTION = "Provider Identifiers" ;
    public static final String ENROLLMENT_IDEN_INF_SECTION = "Identifying Information" ;
    public static final String ENROLLMENT_OWNRSHIP_SECTION ="Ownership" ;
    public static final String ENROLLMENT_TAX_LIC_SECTION ="Taxonomy / License Information" ;
    public static final String ENROLLMENT_PRI_SERV_LOC_SECTION ="Primary Service Location Information" ;
    public static final String ENROLLMENT_SERV_LOC_SECTION ="Service Location" ;
    public static final String ENROLLMENT_PROGRAM_PARTICIPATION_SECTION ="Program Participation / Taxonomy / License / Certificate Information" ;
    public static final String ENROLLMENT_KEY_PER_SECTION ="Key Personnel" ;
    public static final String ENROLLMENT_EFT_INF_SECTION ="EFT Information" ;
    public static final String ENROLLMENT_UPLOAD_SECTION ="Upload Documents" ;
    public static final String ENROLLMENT_AFFILIATION_SECTION ="Affiliation" ;
    public static final String ENROLLMENT_EXC_SANC_SECTION = "Exclusion/Sanction Information";
    public static final String ENROLLMENT_CLASSIFICATION_SECTION = "Classification";
    public static final String PROVIDER_TERMINATION_REQUEST_REASON = "Provider Requested Termination" ;

    public static final String TITLE_DATA_CHANGE=  "Title";
    public static final String TITLE_DR_DATA_CHANGE=  "Dr.";
    public static final String SUFFIX_DATA_CHANGE=  "Suffix";
    public static final String SUFFIX_DR_DATA_CHANGE=  "JR";
    public static final String FIELD_TEXT_DBA_DATA_CHANGE=  "Doing Business As (DBA) Name";
    public static final String FIELD_TEXT_LBN_DATA_CHANGE=  "Legal Business Name";

    //Portals
    public static final String INTERNAL_USER_PORTAL = "Internal User Portal";
    public static final String PROVIDER_PORTAL = "Provider Portal";

    public static final String AFFILIATE_EFFECTIVE_START_DATE = "Affiliation Effective start date" ;

    public static final String AFFILIATE_LOCATION_EFFECCTIVE_START_DATE = "Affiliate Location Effective start date" ;
    public static final String AFFILIATE_TAXONOMY_EFFECCTIVE_START_DATE = "Affiliate Taxonomy Effective Start Date" ;
    public static final String IN_PERSON = "In-Person" ;

    public static final String FIRST_NAME = "FirstName" ;
    public static final String LAST_NAME = "LastName" ;
    public static final String TRACKING_ID = "TrackingID" ;
    public static final String PROVIDER_NPI = "ProviderNPI" ;
    public static final String PROVIDER_EMAILID = "ProviderEmailId" ;
    public static final String PROVIDER_PASSWORD = "providerPwd" ;
    public static final String ZIP_CODE = "ZipCode" ;
    public static final String LEGAL_BUSINESS= "legalBusiness" ;
    public static final String BUSINESS= "Business" ;
    public static final String PHONE_NUM= "PhoneNo" ;
    public static final String APPLICATION_CONTACT_PHONE="Application Contact Phone";

    public static final String FEIN= "Fein" ;
    public static final String SSN= "ssn" ;
    public static final String APLLICATION_CONTACT_NUM="Application Contact Number";
    public static final String ORGANIZATIONAME="Klinic Institution";


    public static final String MIDDLE_NAME = "MiddleName" ;
//    public static final String DATE = "Date" ;
    public static final String DAYS_TO_TERMINATE_SUSPEND = "NoOfDaysToTerminateOrSuspendAProvider" ;
    public static final String DAYS_TO_REACTIVATE = "NoOfDaysToReactivateAProvider" ;
    public static final String ENROLLMENT_DATE = "EnrollmentDate" ;
    public static final String RETROACTIVE_DATE = "RetroactiveDate" ;
    public static final String SCREENING_TYPE = "ScreeningType" ;

    public static final String ENTITY_PROVIDER_EMAILID = "EntityProviderEmailId" ;

    public static final String ENTITY_PROVIDER_NPI = "EntityProviderNPI" ;
    public static final String ENTITY_PROVIDER_LAST_NAME = "EntityProviderLastName" ;
    public static final String ENTITY_PROVIDER_FIRST_NAME = "EntityProviderFirstName" ;

    public static String givenproviderEmail;
    public static String providerNPI;
    public static String CredentialingrequestID;
    public static String ProviderID;
    public static String baseproviderId;
    public static String locationproviderID;

    public static final String GROUP_CONFIGURATION_Enrollment="Enrollment";
    public static final String GROUP_CONFIGURATION_Revalidation="Revalidation";
    public static final String GROUP_CONFIGURATION_Reconsideration="Reconsideration";
    public static final String GROUP_CONFIGURATION_COC="Change of Circumstance";
    public static final String GROUP_CONFIGURATION_SiteVisit="Site Visit";
    public static final String GROUP_CONFIGURATION_ReEnrollment="Re Enrollment";


    public static final List<String> indicatorTypes = Arrays.asList(
            "PMT_RES_UNDELIVERABLE_MAIL",
            "PMT_RES_FIRST_B_NOTICE_1099",
            "PMT_RES_UNDELIVERABLE_RE_ENROLLMENT_PACKET",
            "PMT_RES_UNDELIVERABLE_1099",
            "PMT_RES_B_NOTICE_1099",
            "PMT_RES_SECOND_B_NOTICE_1099",
            "PMT_RES_UNDELIVERABLE_CHECK"
    );

}
