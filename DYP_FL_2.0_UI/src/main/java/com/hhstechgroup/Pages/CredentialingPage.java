package com.hhstechgroup.Pages;




import com.hhstechgroup.common.BaseActions;
import com.hhstechgroup.common.Data;
import com.hhstechgroup.common.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class CredentialingPage extends BaseActions {




    /**
     * This ia a parameterized constructor
     *
     * @param driver
     * @param wait
     */
    public CredentialingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }




    //xpaths
    // Credentialing
    public static final By ADD_CREDENTIALING = By.xpath("(//*[contains(text(),'Credentialing')])[3]");
    // Search with NPI field
    public static final By SEARCH_WITH_NPI = By.xpath("//input[@id='provider']");
    // Search button for NPI field
    public static final By NPI_SEARCH_BUTTON = By.xpath("(//*[contains(@class, 'MuiButtonBase-root MuiIconButton-root jss')])[2]");
    public static final By CREATE_BUTTON = By.xpath("//span[contains(text(),' Create')]");
    public static final By CANCEL_BUTTON = By.xpath("//span[contains(text(),'Cancel')]");
    public static final By SECTION_CREDENTIALING_DETAILS = By.xpath("//*[@class='menu-item active']");
    public static final By SECTION_UPLOAD_CREDENTIALING_DOCUMENTS = By.xpath("//span[contains(text(),'Upload Credentialing Documents')]");
    public static final By LINK_CREDENTIALING = By.xpath("//span[contains(text(),'Go to Credentialing')]");




    //Credentialing
    public static final String RADIOBUTTON_LICENSE_VALIDITY = ("//input[contains(@name, '1. Is the provider')][@value='No']");
    public static final String RADIOBUTTON_MEDICARE_MEDICAID_ENROLLMENT = ("//input[contains(@name, '2. Is the provider currently enrolled and active in Medicare and Medicaid programs')][@value='No']");
    public static final String RADIOBUTTON_EDUCATION_TRAINING_VERIFICATION = ("//input[contains(@name, '3. Have all required education, training')][@value='No']");
    public static final String RADIOBUTTON_HOSPITAL_PRIVILEGES = ("//input[contains(@name, '4. Does the provider have verified hospital privileges')][@value='No']");
    public static final String RADIOBUTTON_MALPRACTICE_INSURANCE = ("//input[contains(@name, '5. Has the provider maintained adequate and continuous')][@value='No']");
    public static final String RADIOBUTTON_DISCIPLINARY_ACTIONS = ("//input[contains(@name, '6. Are there any final orders, disciplinary actions,')][@value='No']");
    public static final String RADIOBUTTON_PENDING_INVESTIGATIONS = ("//input[contains(@name, '7. Are there any pending investigations,')][@value='No']");
    public static final String RADIOBUTTON_HISTORY_DISCLOSURE = ("//input[contains(@name, '8. Has the provider truthfully disclosed all history related to sanctions,')][@value='No']");
    public static final String RADIOBUTTON_PEER_REFERENCES = ("//input[contains(@name, '9. Are professional peer references available and do they support the provider')][@value='No']");
    public static final String RADIOBUTTON_ESCALATION_MECHANISM = ("//input[contains(@name, '10. Is there an internal mechanism to escalate any ambiguous or incomplete')][@value='No']");




    //assigning credential
    public static final By NPI_SEARCH = By.xpath("//input[@id='NPI']");
    public static final By SEARCH_Button = By.xpath("//span[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'search']");
    public static final By SElECT_UNASSIGNED = By.xpath("(//p[text()='Unassigned'])[1]");
    public static final By SElECT_CVO_REVIEW_COMMITTE = By.xpath("//div[contains(p/text(), 'CVO REVIEW COMMITTEE')]/span");
    public static final By CVO_MEDICAL_DIRECTOR = By.xpath("//div[p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cvo medical director')]]");
    public static final By Click_ON_ASSIGN = By.xpath("//*[@class='MuiButton-label'][text()='Assign']");




    //approving the credentials
    public static final By Click_AGREE = By.xpath("//span[contains(text(), 'Agree')]");
    public static final By Click_CREDENTALING = By.xpath("//a[contains(@href, 'credentialing')]");
    public static final By NPI_SEARCH_CREDENTALING = By.xpath("//input[@id='NPI']");
    public static final By SEARCH_Button_CREDENTALING = By.xpath("//span[contains(text(), 'Search')]");
    public static final By Click_ON_NEW = By.xpath("(//p[contains(text(), 'NEW')])[1]");
    public static final By Click_ON_unassign = By.xpath("(//span[text()='Unassigned'])[1]");
    public static final By SElECT_CVO_REVIEW_COMMITTES = By.xpath("(//p[text()='Cvo review committee'])");
    public static final By Click_ON_ASSIGNG = By.xpath("//*[@class='MuiButton-label'][text()='Assign']");




    public static final By CLICK_ON_CHANGE_STATUS = By.xpath("//button[span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'change status')]]");
    public static final By CLICK_ON_NEW_POPUP = By.xpath("//*[contains(@class, 'MuiSvgIcon-root MuiSelect-icon MuiSelect-iconOutlined')]");
    public static final By CLICK_ON_CREDENTALING_FINAL = By.xpath("//li[contains(text(), 'Flag To CVO Medical Director')]");
    public static final By CLICK_ON_REASON = By.xpath("//div[contains(@class, 'MuiSelect-root') and contains(@id, 'Reason-')]");
    public static final By REASON_DROP_DOWN = By.xpath("//*[contains(text(), 'Need Review from CVO Medical Director')]");
    public static final By CLICK_ON_RESULT = By.xpath("//div[contains(@class, 'MuiSelect-root') and contains(@id, 'Result-')]");
    public static final By CLICK_ON_PASSED = By.xpath("//li[contains(@data-value, 'PASSED')]");
    public static final By CLICK_ON_APPLY = By.xpath("//span[contains(@class, 'MuiButton-label') and contains(text(), 'Apply')]");
    public static final By COMPLETED_SUCESSFUL = By.xpath("//p[contains(@class, 'MuiTypography-root') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'saved changes successfully')]");




    public static final By TEXT_INPUT_USERNAME = By.xpath("//input[@id='username']");
    public static final By TEXT_INPUT_PASSWORD = By.xpath("//input[@id='password']");




    public static final By ASSIGNEE = By.xpath("(//div[.//span[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'assignee')]]      //div[@class='details_action_1A_jL']/span)[1]");




    public static final By CREDENTIALING_REQ_ID =
            By.xpath("//div[@class='MuiCardHeader-content']//span[contains(text(),'Credentialing request')]");




    public static final By REQ_ID_SEARCH =
            By.xpath("//input[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'requestid']");




    public static final By FLAG_TO_MEDICAL_DIRECTOR =
            By.xpath("//div[@role='button' and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'flag to cvo medical director')]");


    public static final By ASSIGN_BUTTON_CVORC=
            By.xpath("//span[@class='MuiButton-label' and translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'assign']");


    public static final By CHANGE_STATUS_DROP_DOWN=
            By.xpath("//li[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'credentialing completed with findings']");


    public static final By REASON_DROPDOWN=
            By.xpath("//li[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'positive']");


    public static final By REASULT_DROPDOWN=
            By.xpath("//li[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'passed']");






    public void clickedonaddcredentialing() {
        javaWaitSec(5);
        ajaxClick(ADD_CREDENTIALING);
        Reports.log("User clicked on the Add Credentialing Button");
        javaWaitSec(10);
//        ajaxClick(SEARCH_WITH_NPI);
        javaWaitSec(5);


        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_WITH_NPI));
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_WITH_NPI));




        WebElement inputField = driver.findElement(SEARCH_WITH_NPI);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", inputField);
        inputField.sendKeys(Data.providerNPI);




//        ajaxSendKeys(SEARCH_WITH_NPI,Data.providerNPI);
//        driver.findElement(SEARCH_WITH_NPI).sendKeys(Data.providerNPI);
        Reports.log("Entered NPI number is : " + Data.providerNPI);
        javaWaitSec(5);
        Reports.log("User Sends the npi number: ");
        ajaxClick(NPI_SEARCH_BUTTON);
        Reports.log("User Clicked on the Search button after entering the NPI Number");
        //click on the create button
        javaWaitSec(5);
        ajaxClick(CREATE_BUTTON);
        Reports.log("User CLicked on the Create Button for Create Credentialing");
        //give wait for 5 sec
        javaWaitSec(5);
    }




    public void fillingCredentialinginformationEntity() {
        javaWaitSec(2);
        Reports.log("\nFill in Credentialing Investigation Form");
        ajaxClick(SECTION_CREDENTIALING_DETAILS);
        selectAllRatioBtnForCredentialingDetails("No");
        ajaxClick(SECTION_UPLOAD_CREDENTIALING_DOCUMENTS);
        ajaxClick(setAndFindButton(Data.TEXT_Submit));
        Reports.log("Click on the Submit button");
        javaWaitSec(10);
        driver.findElement(LINK_CREDENTIALING).click();
        Reports.log("Clicked on 'Navigate to Dashboard' button");
        javaWaitSec(10);
    }




    /**
     * This method selects Either All YES or ALL NO radio buttons in the Credentialing section
     */
    public void selectAllRatioBtnForCredentialingDetails(String radioButtonValue) {
        ajaxClick(By.xpath(String.format(RADIOBUTTON_LICENSE_VALIDITY, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_MEDICARE_MEDICAID_ENROLLMENT, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_EDUCATION_TRAINING_VERIFICATION, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_HOSPITAL_PRIVILEGES, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_MALPRACTICE_INSURANCE, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_DISCIPLINARY_ACTIONS, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_PENDING_INVESTIGATIONS, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_HISTORY_DISCLOSURE, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_PEER_REFERENCES, radioButtonValue)));
        javaWaitSec(2);
        ajaxClick(By.xpath(String.format(RADIOBUTTON_ESCALATION_MECHANISM, radioButtonValue)));
        javaWaitSec(2);
        if (radioButtonValue.equalsIgnoreCase("true")) {
            Reports.log("Selects “Yes” for all the questions in Credentialing Information");
        } else {
            Reports.log("Selects “No” for all the questions in Credentialing Information");
        }
    }


    public void performCoReviewAndMedicalDirectorActions() {
        driver.navigate().refresh();
        javaWaitSec(5);
        ajaxClick(NPI_SEARCH);
        Reports.log("user clicked on the NPI text field");
        javaWaitSec(5);
        ajaxSendKeys(NPI_SEARCH, Data.providerNPI);
        javaWaitSec(5);
        Reports.log("users sends the submited NPI");
        ajaxClick(NPI_SEARCH);
        ajaxClick(SEARCH_Button);
        javaWaitSec(10);
        Reports.log("user entered npi and clicked on search button ");




        //user clicks on unassigned
        ajaxClick(SElECT_UNASSIGNED);
        javaWaitSec(10);
        Reports.log("user clicke on the unassigned button");




        // user Clicks on SElECT_CVO_REVIEW_COMMITTE
        ajaxClick(SElECT_CVO_REVIEW_COMMITTE);
        javaWaitSec(5);
        Reports.log("user as clicked on CVO_REVIEW_COMMITTE");




        // user Clicks on Cvo_medical_director
//        ajaxClick(Cvo_medical_director);
//        javaWaitSec(5);
//        Reports.log("user as clicked on Cvo_medical_director");




        // user clicks on Click_ON_ASSIGN
        ajaxClick(Click_ON_ASSIGN);
        javaWaitSec(5);
        Reports.log("user has clicked on Assign button");
        javaWaitSec(10);
    }




    public void AssigningtoCVOMedicalDirectorActions() {
        javaWaitSec(5);
        javaWaitSec(10);
        ajaxClick(Click_CREDENTALING);
        Reports.log("Clicked Credentialing");


        javaWaitSec(5);
        performClick(NPI_SEARCH_CREDENTALING);
        Reports.log("Clicked NPI Search Credentialing");




        javaWaitSec(5);
        ajaxSendKeys(NPI_SEARCH_CREDENTALING, Data.providerNPI);
        Reports.log("Typed NPI in search");




        javaWaitSec(5);
        ajaxClick(SEARCH_Button_CREDENTALING);
        Reports.log("Clicked Search button in credentialing");




        javaWaitSec(5);
        ajaxClick(Click_ON_NEW);
        Reports.log("Clicked on NEW entry");
//




        //--------------------------------------
//        javaWaitSec(10);
//        ajaxClick(CLICK_ON_CHANGE_STATUS);
//        Reports.log("Clicked on NEW entry");
//
//
//
//
//        javaWaitSec(5);
////    ajaxClick(CLICK_ON_NEW_POPUP);
//        performClick(CLICK_ON_NEW_POPUP);
//        Reports.log("Clicked on NEW in popup");
//
//
//
//
//        javaWaitSec(5);
//        ajaxClick(CLICK_ON_CREDENTALING_FINAL);
//        Reports.log("Clicked on Credentialing Final");
//
//
//
//
//        javaWaitSec(5);
//        performClick(CLICK_ON_REASON);
//        Reports.log("Clicked on Reason");
//
//
//
//
//        javaWaitSec(5);
//        ajaxClick(REASON_DROP_DOWN);
//        Reports.log("Clicked on Need Review from CVO Medical Director");
//



//        javaWaitSec(5);
//        performClick(CLICK_ON_RESULT);
//        Reports.log("Click on Result");




//        javaWaitSec(5);
//        Reports.log("Click on Passed value");
//        ajaxClick(CLICK_ON_PASSED);




//        javaWaitSec(6);
//        ajaxClick(CLICK_ON_APPLY);
//        Reports.log("Clicked on Apply button");




        javaWaitSec(5);
        ajaxClick(ASSIGNEE);
        Reports.log("Clicked on Assignee");




        javaWaitSec(5);
        ajaxClick(CVO_MEDICAL_DIRECTOR);
        Reports.log("Assigned to CVO MEDICAL DIRECTOR");


        javaWaitSec(2);
        ajaxClick(ASSIGN_BUTTON_CVORC);
        Reports.log("Assigned to the CVO MEDICAL DIRECTOR");




        javaWaitSec(5);
        String fulltext = getElementText(CREDENTIALING_REQ_ID);
        String requestId = fulltext.replace("Credentialing request #", "").trim();
        String numericOnly = requestId.replaceAll("-", "").trim();
        Data.CredentialingrequestID = numericOnly;
        Reports.log("Fetched Request ID is: " + Data.CredentialingrequestID);




        javaWaitSec(5);
//        Assert.assertTrue(verifyThatElementIsDisplayed(COMPLETED_SUCESSFUL), "FAILED: Success message 'Saved Changes Successfully!' is not visible.");
    }




    public void crdentialingapprovalCVOMedicalDirector() {
        javaWaitSec(10);
        ajaxSendKeys(REQ_ID_SEARCH, Data.CredentialingrequestID);
        Reports.log("Entered Request ID is: " + Data.CredentialingrequestID);
        javaWaitSec(5);
        ajaxClick(SEARCH_Button);
        Reports.log("Clicked on Search Button");
        javaWaitSec(5);




        // Extract the last 3 digits from Credentialing request ID
        String requestId = Data.CredentialingrequestID; // e.g., "000000128"
        String lastThreeDigits = requestId.substring(requestId.length() - 3); // "128"




        // Build dynamic XPath using last three digits
        String dynamicXPath = "//div[contains(@class,'tile-table-row-summary')]//p[normalize-space(text())='" + lastThreeDigits + "']";




        javaWaitSec(3);
        // Example usage to click the element
        WebElement rowElement = driver.findElement(By.xpath(dynamicXPath));
        javaWaitSec(4);
        rowElement.click();
        Reports.log("Clicked on the Request ID: " + lastThreeDigits);
        javaWaitSec(5);
        ajaxClick(CLICK_ON_CHANGE_STATUS);
        Reports.log("Clicked on Change Status button");




        javaWaitSec(5);
        ajaxClick(FLAG_TO_MEDICAL_DIRECTOR);
        javaWaitSec(2);
        ajaxClick(CHANGE_STATUS_DROP_DOWN);
        Reports.log("Clicked on Credentialing Completed With Findings");




        javaWaitSec(5);
        ajaxClick(CLICK_ON_REASON);
        javaWaitSec(2);
        ajaxClick(REASON_DROPDOWN);
        Reports.log("Clicked on Positive");


        javaWaitSec(5);
        ajaxClick(CLICK_ON_RESULT);
        javaWaitSec(2);
        ajaxClick(REASULT_DROPDOWN);
        Reports.log("Clicked on Pass");


        javaWaitSec(5);
        ajaxClick(CLICK_ON_APPLY);
        Reports.log("Clicked on the Apply button");




        javaWaitSec(7);
        Assert.assertTrue(verifyThatElementIsDisplayed(COMPLETED_SUCESSFUL), "FAILED: Success message 'Saved Changes Successfully!' is not visible.");




    }




}


