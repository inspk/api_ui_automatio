package com.hhstechgroup.common;

import com.hhstechgroup.utility.ProviderInformation;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * This class utilizes DataProviders to pass Provider Info to tests scripts
 */
public class DataProviderForProviderInfo {

    String providerExcelPath = "ProviderInfo.xlsx" ;

    //*****************************************************************************************************************************************
    //Individual DATA PROVIDERS
    //*****************************************************************************************************************************************

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an Individual Enrollment with Submitted status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndBillingProviderNameWithStatusSubmitted")
    public Object[][] dataProviderForIndBillingProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.BILLING_PROVIDER,Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /* * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
            * an Individual Enrollment with Submitted status.
            * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getBillingProviderNameWithStatusSubmitted")
    public Object[][] dataProviderForBillingProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.individualApplication,Data.BILLING_PROVIDER).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for an Individual Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getBillingProviderNameEmailTaxNPIWithApprovedStatus")
    public Object[][] dataProviderForBillingProvNameEmailTaxNPIWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.BILLING_PROVIDER, Data.ApplicationStatusApprove).toArray()
        };
    }

    @DataProvider(name="getBillingProviderNameAndEmailWithStatusApproved")
    public Object[][] dataProviderForBillingProviderNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.BILLING_PROVIDER, Data.ApplicationStatusApprove).toArray()
        };
    }

    @DataProvider(name="getBillingProviderNameAndEmailWithStatusActive")
    public Object[][] dataProviderForBillingProviderNameStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.BILLING_PROVIDER, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }
    @DataProvider(name="getServicingProviderNameAndEmailWithStatusApproved")
    public Object[][] dataProviderForServicingProviderNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.SERVICING_PROVIDER, Data.ApplicationStatusApprove).toArray()
        };
    }

    @DataProvider(name="getServicingProviderNameAndEmailWithStatusActive")
    public Object[][] dataProviderForServicingProviderNameStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.SERVICING_PROVIDER, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an Individual Enrollment with Submitted status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndServicingProviderNameWithStatusSubmitted")
    public Object[][] dataProviderForIndServicesProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.SERVICING_PROVIDER,Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, Status, trackingNum
     * from ProviderInfo.xlsx for an Individual Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getServicingProviderNameAndEmailWithStatusDenied")
    public Object[][] dataProviderForServiceProvNameStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.SERVICING_PROVIDER,Data.APPLICATION_STATUS_DENIED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an Entity Enrollment with status Submitted.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameWithStatusSubmitted")
    public Object[][] dataProviderForEntityProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }


//    /**
//     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
//     * an Entity Enrollment with status Submitted.
//     * @return Data Object
//     * @throws IOException
//     */
//    @DataProvider(name="getSubmittedEntityApplicationForScreeningAndApprovalProcess")
//    public Object[][] dataProviderForEntityApplicationForScreeningAndApprovalProcess(ITestContext context) throws IOException {
//        String screeningType = context.getCurrentXmlTest().getParameter("screening");
//        if (screeningType.isBlank()) {
//            screeningType = Data.testEmailAccount;
//        } else {
//            screeningType = screeningType;
//        }
//        return new Object[][]{
//                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_SUBMITTED).toArray(),
//                screeningType
//        };
//    }



    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an Individual Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndProviderNameWithStatusApprove")
    public Object[][] dataProviderForIndProvNameStatusApprove() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.individualApplication,"Approved").toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for an Individual Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndProviderNameAndEmailWithStatusPendingReview")
    public Object[][] dataProviderForIndProvNameStatusPendingReview() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.BILLING_PROVIDER,Data.ApplicationStatusPendingReview).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for an Individual Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getServicingProviderNameAndEmailWithStatusPendingReview")
    public Object[][] dataProviderForServicingProvNameStatusPendingReview() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.SERVICING_PROVIDER,Data.ApplicationStatusPendingReview).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for an Entity Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameAndEmailWithStatusPendingReview")
    public Object[][] dataProviderForEntityProvNameStatusPendingReview() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.ENTITY_PROVIDER,Data.ApplicationStatusPendingReview).toArray()
        };
    }


    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx
     * for an Individual Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndProviderNameAndEmailWithStatusApproved")
    public Object[][] dataProviderForIndProvNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.individualApplication,Data.ApplicationStatusApprove).toArray()
        };
    }


    /**
     * This method returns a DataProvider object containing firstName, lastName, emailID, taxonomy, npi, tracking_num from ProviderInfo.xlsx for
     * a Servicing Individual Enrollment with Approved Status .
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndServicingProviderNameEmailTaxonomyNPIWithStatusApproved")
    public Object[][] dataProviderForIndServicingProvNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.individualApplication, Data.APPLICATION_STATUS_APPROVED_FOR_SR).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx
     * for an Individual Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndProviderNameAndEmailWithStatusActive")
    public Object[][] dataProviderForIndProvNameStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.individualApplication,Data.applicationStatusActive).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for an Individual Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndProviderNameEmailTaxNPIWithApprovedStatus")
    public Object[][] dataProviderForIndProvNameEmailTaxNPIWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.BILLING_PROVIDER, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for an Individual Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndBillingProviderNameEmailTaxNPIWithApprovedStatus")
    public Object[][] dataProviderForIndBillingProvNameEmailTaxNPIWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.INDIVIDUAL_APPLICATION_BILLING_PROVIDER, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, Status, trackingNum
     * from ProviderInfo.xlsx for an Individual Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getBillingProviderNameAndEmailWithStatusDenied")
    public Object[][] dataProviderForIndProvNameStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.BILLING_PROVIDER,Data.APPLICATION_STATUS_DENIED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for an Individual CoC request with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getIndProviderNameWithCOCStatusDenied")
    public Object[][] dataProviderForIndividualCOCStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.INDIVIDUAL_COC_APPLICATION, Data.ApplicationStatusDenied).toArray()
        };
    }




    //*****************************************************************************************************************************************
    //PEM DATA PROVIDERS
    //*****************************************************************************************************************************************

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a PEM Enrollment with blank status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPemProviderNameWithNoStatus")
    public Object[][] dataProvForProviderNameAndEmailStatusNull() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.pemApplication,"").toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a PEM Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameWithApprove")
    public Object[][] dataProviderForPEMProvNameStatusApprove() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.pemApplication,Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a PEM Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEmailWithStatusActive")
    public Object[][] dataProviderForPEMProvNameEmailStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pemApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing environment, applicationType,
     * firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx for a PEM Enrollment
     * with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEMailTypeActive")
    public Object[][] dataProviderForPEMProvNameEmailTypeActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.pemApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, Status, trackingNum
     * from ProviderInfo.xlsx for a PEM Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEmailWithStatusApproved")
    public Object[][] dataProviderForPEMProvNameEmailStatusApprove() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pemApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, Status, trackingNum
     * from ProviderInfo.xlsx for a PEM Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPemProviderNameAndEmailWithStatusDenied")
    public Object[][] dataProviderForPemNameStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pemApplication, Data.ApplicationStatusDenied).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a PEM Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEmailTaxNPIWithApprovedStatus")
    public Object[][] dataProviderForPEMProvNameEmailTaxNPIWithApprovedStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.pemApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi, Status,
     * trackingNum from ProviderInfo.xlsx for a PEM Enrollment with "Submitted" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEmailWithStatusSubmitted")
    public Object[][] dataProviderForPEMProvNameEmailStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pemApplication, Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a PEM Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEmailWithStatusDenied")
    public Object[][] dataProviderForPEMProvNameEmailStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.pemApplication, Data.APPLICATION_STATUS_DENIED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing environment, applicationType,
     * firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx for a PEM Enrollment
     * with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEMailTypeApproved")
    public Object[][] dataProviderForPEMProvNameEmailTypeApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.pemApplication, Data.ApplicationStatusApprove).toArray()
        };
    }
    /**
     * This method returns a DataProvider object containing environment, applicationType,
     * firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx for a PEM Enrollment
     * with "Suspended" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEMailTypeSuspended")
    public Object[][] dataProviderForPEMProvNameEmailTypeSuspended() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.pemApplication, Data.APPLICATION_STATUS_SUSPENDED).toArray()
        };
    }
    /**
     * This method returns a DataProvider object containing environment, applicationType,
     * firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx for a PEM Enrollment
     * with "Terminated" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPEMProviderNameEMailTypeTerminated")
    public Object[][] dataProviderForPEMProvNameEmailTypeTerminated() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.pemApplication, Data.APPLICATION_STATUS_TERMINATED).toArray()
        };
    }

    //*****************************************************************************************************************************************
    //GROUP DATA PROVIDERS
    //*****************************************************************************************************************************************

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Group Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGroupProviderNameAndEmailWithStatusApproved")
    public Object[][] dataProviderForGroupProvNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.groupApplication,Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Group Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameWithStatusDenied")
    public Object[][] dataProviderForGroupProvNameStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.groupApplication, Data.ApplicationStatusDenied).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Group Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameEmailWithStatusApproved")
    public Object[][] dataProviderForGroupProvNameEmailStatusApprove() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.groupApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Group Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameEmailWithStatusApproved")
    public Object[][] dataProviderForEntityProvNameEmailStatusApprove() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_APPROVED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Group Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameEmailWithStatusActive")
    public Object[][] dataProviderForGroupProvNameEmailStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.groupApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Group Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameEmailTaxNPIWithActiveStatus")
    public Object[][] dataProviderForGroupProvNameEmailTaxNPIWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.groupApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Group Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameEmailTaxNPIWithPendingReviewStatus")
    public Object[][] dataProviderForGroupProvNameEmailTaxNPIWithPendingReviewStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.groupApplication, Data.ApplicationStatusPendingReview).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Group Enrollment with "Under Screening" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameWithUnderScreeningStatus")
    public Object[][] dataProviderForGroupProvNameWithUnderScreeningStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.groupApplication, Data.APPLICATION_STATUS_UNDER_SCREENING).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Group Enrollment with "Reactivated" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameWithReactivatedStatus")
    public Object[][] dataProviderForGroupProvNameWithReactivatedStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.groupApplication, Data.APPLICATION_STATUS_REACTIVATED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Group Enrollment with blank status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameEmailTaxNPIWithNoStatus")
    public Object[][] dataProviderForGroupProvNameEmailTaxNPIWithNoStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.groupApplication, "").toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Group Enrollment with "Document Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameEmailTaxNPIWithDocumentReviewStatus")
    public Object[][] dataProviderForGroupProvNameEmailTaxNPIWithDocumentReviewStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.groupApplication, Data.APPLICATION_STATUS_DOCUMENT_REVIEW).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Entity Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameWithStatusApproved")
    public Object[][] dataProviderForGroupProvNameStatusApprove() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_APPROVED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Group Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameWithActiveStatus")
    public Object[][] dataProviderForGroupProvNameWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.groupApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Group Enrollment with "Submitted" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGrpProviderNameWithStatusSubmitted")
    public Object[][] dataProviderForGroupProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Entity Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameEmailWithStatusDenied")
    public Object[][] dataProviderForEntityProvNameEmailStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_DENIED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Entity Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameEmailTypeWithStatusApproved")
    public Object[][] dataProviderForEntityProvNameEmailStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_APPROVED_UPPERCASE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Entity Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getEntityProviderNameEmailTypeWithStatusActive")
    public Object[][] dataProviderForEntityProvNameEmailStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.ENTITY_PROVIDER, Data.APPLICATION_STATUS_ACTIVE2).toArray()
        };
    }



    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Group Enrollment with "Submitted" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getGroupProviderNameWithCOCStatusDenied")
    public Object[][] dataProviderForGroupCOCStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.GROUP_COC_APPLICATION, Data.ApplicationStatusDenied).toArray()
        };
    }
    //*****************************************************************************************************************************************
    //PHARMACY DATA PROVIDERS
    //*****************************************************************************************************************************************

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Pharmacy Enrollment with "Submitted" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameWithSubmittedStatus")
    public Object[][] dataProviderForPharmacyProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.pharmacyApplication, Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Pharmacy Enrollment with "Under Screening" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameWithUnderScreeningStatus")
    public Object[][] dataProviderForPharmacyProvNameStatusUnderScreening() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.pharmacyApplication, Data.APPLICATION_STATUS_UNDER_SCREENING).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi, Status,
     * trackingNum from ProviderInfo.xlsx for a Pharmacy Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameEmailTaxNPIWithPendingReviewStatus")
    public Object[][] dataProviderForPharmacyProvNameStatusPendingReview() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.pharmacyApplication, Data.ApplicationStatusPendingReview).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Pharmacy Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameWithDeniedStatus")
    public Object[][] dataProviderForPharmacyProvNameStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pharmacyApplication, Data.ApplicationStatusDenied).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Pharmacy Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameWithStatusApproved")
    public Object[][] dataProviderForPharmacyProvNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pharmacyApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Pharmacy Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameEmailTaxNPIWithActiveStatus")
    public Object[][] dataProviderForPharmacyProvNameEmailTaxNPIWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.pharmacyApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a Pharmacy Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameWithActiveStatus")
    public Object[][] dataProviderForPharmacyProvNameWithActiveStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.pharmacyApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, Status, trackingNum
     * from ProviderInfo.xlsx for a Pharmacy Enrollment with "Active" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameEmailWithStatusActive")
    public Object[][] dataProviderForPharmacyProvNameEmailStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.pharmacyApplication, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi, Status,
     * trackingNum from ProviderInfo.xlsx for a Pharmacy Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getPharmacyProviderNameWithCOCStatusDenied")
    public Object[][] dataProviderForPharmacyCOCStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.PHARMACY_COC_APPLICATION, Data.ApplicationStatusDenied).toArray()
        };
    }
    //*****************************************************************************************************************************************
    //Facility Data Providers
    //*****************************************************************************************************************************************

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Facility Enrollment with blank status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderNameEmailWithSubmitted")
    public Object[][] dataProviderForFacilityNameEmailWithNoStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.facilityApplication, Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Facility Enrollment with "Under Screening" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderNameEmailWithUnderScreeningStatus")
    public Object[][] dataProviderForFacilityProvNameEmailWithUnderScreeningStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.facilityApplication, Data.APPLICATION_STATUS_UNDER_SCREENING).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Facility Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderInfoWithStatusPendingReview")
    public Object[][] dataProviderForFacilityProvInfoWithStatusPendingReview() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.facilityApplication, Data.ApplicationStatusPendingReview).toArray()

        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Facility Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderInfoWithStatusDenied")
    public Object[][] dataProviderForFacilityProvInfoWithStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.facilityApplication, Data.ApplicationStatusDenied).toArray()

        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Facility Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderInfoWithStatusApproved")
    public Object[][] dataProviderForFacilityProvInfoWithStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.facilityApplication, Data.ApplicationStatusApprove).toArray()

        };
    }

    /**
     * This method  returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Facility Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderNameEmailTaxNPIWithApprovedStatus")
    public Object[][] dataProviderForFacilityProvNameEmailTaxNPIWithApprovedStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.facilityApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for a Facility Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderNameAndEmailWithStatusApproved")
    public Object[][] dataProviderForFacilityProvNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.facilityApplication,Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for a Facility Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getFacilityProviderNameWithCOCStatusDenied")
    public Object[][] dataProviderForFacilityCOCStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.FACILITY_COC_APPLICATION, Data.ApplicationStatusDenied).toArray()
        };
    }

    //*****************************************************************************************************************************************
    //ORP DATA PROVIDERS
    //*****************************************************************************************************************************************

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an ORP Enrollment with "Submitted" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameWithStatusSubmitted")
    public Object[][] dataProviderForORPProvNameStatusSubmit() throws IOException {
        return new Object[][]{
               ProviderInformation.getFNameAndLastName(providerExcelPath, Data.orpApplication, Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an ORP Enrollment with "Under Screening" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameWithStatusUnderScreening")
    public Object[][] dataProviderForORPProvNameStatusUnderScreening() throws IOException {
        return new Object[][]{
               ProviderInformation.getFNameAndLastName(providerExcelPath, Data.orpApplication, Data.APPLICATION_STATUS_UNDER_SCREENING).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for an ORP Enrollment with "Pending Approval" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameWithStatusPendingApproval")
    public Object[][] dataProviderForORPProvNameStatusPendingReview() throws IOException {
        return new Object[][]{
               ProviderInformation.getProviderNameEMail(providerExcelPath, Data.orpApplication, Data.pendingApprovalStatus).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, Status, trackingNum
     * from ProviderInfo.xlsx for an ORP Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameWithStatusDenied")
    public Object[][] dataProviderForORPProvNameStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.orpApplication, Data.ApplicationStatusDenied).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for an ORP Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameWithStatusApproved")
    public Object[][] dataProviderForORPProvNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.orpApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for an ORP Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameEmailTaxNPIWithApprovedStatus")
    public Object[][] dataProviderForORPProvNameEmailTaxNPIWithApprovedStatus() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.orpApplication, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi,
     * trackingNum from ProviderInfo.xlsx for an ORP CoC request with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getORPProviderNameWithCOCStatusDenied")
    public Object[][] dataProviderForORPCOCStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEmailTaxonomyNPI(providerExcelPath, Data.ORP_COC_APPLICATION, Data.ApplicationStatusDenied).toArray()
        };
    }
/************************************************************************************************************/

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx for
     * an Individual Enrollment with blank status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getTPNameWithStatusSubmitted")
    public Object[][] dataProviderForTPProvNameStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getFNameAndLastName(providerExcelPath, Data.TRADING_PARTNER,Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from
     * ProviderInfo.xlsx for an Individual Enrollment with "Pending Review" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getTPNameAndEmailWithStatusPendingApproval")
    public Object[][] dataProviderForTPNameStatusPendingApproval() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.TRADING_PARTNER,Data.statusPendingApproval).toArray()
        };
    }

    @DataProvider(name="getTPNameAndEmailWithStatusApproved")
    public Object[][] dataProviderForTPNameStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.TRADING_PARTNER, Data.APPLICATION_STATUS_APPROVED_UPPERCASE).toArray()
        };
    }
    @DataProvider(name="getTPNameAndEmailWithStatusActive")
    public Object[][] dataProviderForTPNameStatusActive() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.TRADING_PARTNER, Data.APPLICATION_STATUS_ACTIVE).toArray()
        };
    }

    @DataProvider(name="getTPNameAndEmailWithStatusTerminated")
    public Object[][] dataProviderForTPNameStatusTerminated() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.TRADING_PARTNER, Data.APPLICATION_STATUS_TERMINATED).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, trackingNum from ProviderInfo.xlsx
     * for a TP Enrollment with "Denied" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getTPProviderNameEmailWithStatusDenied")
    public Object[][] dataProviderForTPProvNameEmailStatusDenied() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMailType(providerExcelPath, Data.TRADING_PARTNER, Data.APPLICATION_STATUS_DENIED_UPPERCASE).toArray()
        };
    }


    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, trackingNum from ProviderInfo.xlsx
     * for an Individual Enrollment with "Approved" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getProviderNameAndEmailWithStatusApproved")
    public Object[][] dataProviderToGetAProviderNameWthStatusApproved() throws IOException {
        return new Object[][]{
                ProviderInformation.getProvider(providerExcelPath, Data.ApplicationStatusApprove).toArray()
        };
    }

    /**
     * This method returns a DataProvider object containing firstName, lastName, provideEmailID, taxonomy, npi, Status,
     * trackingNum from ProviderInfo.xlsx for MCO Enrollment with "Submitted" status.
     * @return Data Object
     * @throws IOException
     */
    @DataProvider(name="getProviderForMCOProvNameEmailStatusSubmitted")
    public Object[][] dataProviderForMCOProvNameEmailStatusSubmitted() throws IOException {
        return new Object[][]{
                ProviderInformation.getProviderNameEMail(providerExcelPath, Data.mcoApplication, Data.APPLICATION_STATUS_SUBMITTED).toArray()
        };
    }
}
