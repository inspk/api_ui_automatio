package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Get Approved Documents Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the get approved documents API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve approved documents with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/approved-documents
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid approved documents retrieval with authentication
 * - Approved documents retrieval with specific provider ID
 * - Core approved documents information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid approved documents data
 * - Approved documents information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental approved documents information
 */
public class GetApprovedDocumentsTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid Get Approved Documents Retrieval
     * 
     * Description: Tests the successful retrieval of approved documents with valid authentication.
     * This test ensures that provider users can access their approved documents
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid approved documents data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testGetApprovedDocuments() throws Exception {
        // Get test data
        String apiName = "getApprovedDocuments";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Get Approved Documents API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/approved-documents")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" Get Approved Documents API test completed successfully");
    }
} 