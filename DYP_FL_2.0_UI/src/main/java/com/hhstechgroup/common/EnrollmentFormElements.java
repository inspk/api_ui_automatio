package com.hhstechgroup.common;

import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import com.hhstechgroup.utility.ProviderInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnrollmentFormElements extends BaseActions {
    protected String providerInfoSheet = "ProviderInfo.xlsx"; // provider infor excel sheet file path
    Map<String, String> addFormElements ;
    private final String npi = getRandomStringFromFile("SDNPI");
    private final String zipCode = getRandomStringFromFile("SDZip");
    private final  String legalBusiness = generateLegalBusiness();
    private final  String business = generateDBABusiness();
    private final String fein = generateANumberOfLength(9);
    private final  String ssn = generateANumberOfLength(10);
    private final String phoneNum = generateANumberOfLength(10);
    private final String enrollmentDate = getCurrentDate();
    private final String terminateSuspendDays = "-15";
    private final String retroactiveDate = changeYearAndDayInCurrentDate(0, 0, -30);

    public EnrollmentFormElements(WebDriver driver, WebDriverWait wait) {
    }


    public   Map<String ,String> formElements() throws IOException {
        Map<String, String> formElements = new HashMap<String, String>();
        String entityProviderEmailId = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_ACTIVE).get("ProviderEmailId");
        String entityProviderNPI = ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_ACTIVE).get("ProviderNPI");

        // **** This parameter will be used only by servicing Provider ****
        formElements.put(Data.ENTITY_PROVIDER_EMAILID, entityProviderEmailId);
        formElements.put(Data.ENTITY_PROVIDER_NPI, entityProviderNPI);
        formElements.put(Data.ENTITY_PROVIDER_FIRST_NAME,ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_ACTIVE).get(Data.FIRST_NAME));
        formElements.put(Data.ENTITY_PROVIDER_LAST_NAME,ProviderInformation.getProviderIdAndNPI(providerInfoSheet, Data.ENTITY_PROVIDER,Data.APPLICATION_STATUS_ACTIVE).get(Data.LAST_NAME ));

        formElements.put(Data.MIDDLE_NAME,Data.middleName);
        formElements.put(Data.PROVIDER_NPI, npi);
        formElements.put(Data.ZIP_CODE, zipCode);
        formElements.put(Data.PHONE_NUM, phoneNum);
        formElements.put(Data.LEGAL_BUSINESS,legalBusiness);
        formElements.put(Data.BUSINESS,business);
        formElements.put(Data.FEIN,fein);
        formElements.put(Data.SSN,ssn);
        formElements.put(Data.DAYS_TO_TERMINATE_SUSPEND,terminateSuspendDays);
        formElements.put(Data.DAYS_TO_REACTIVATE,"-7");
        formElements.put(Data.ENROLLMENT_DATE, enrollmentDate);
        formElements.put(Data.RETROACTIVE_DATE, retroactiveDate);

        try{
            formElements.putAll(addFormElements);
        }catch (Exception e){
        }

//        Reports.log("All Form Elements : "+formElements);

        return formElements;
    }

    public   Map<String ,String> setFormElements( Map<String, String> additionFormElements ) throws IOException {
        addFormElements= additionFormElements;
        formElements().entrySet();
        return additionFormElements;
    }


}
