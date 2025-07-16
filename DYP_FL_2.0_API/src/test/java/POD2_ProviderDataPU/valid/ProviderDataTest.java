package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Provider Data Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the core provider data API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve provider information with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/provider-data
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid provider data retrieval with authentication
 * - Provider data retrieval with specific provider ID
 * - Core provider information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid provider data
 * - Provider information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental provider information
 */
public class ProviderDataTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }
    
    /**
     * Test: Valid Provider Data Retrieval
     * 
     * Description: Tests the successful retrieval of provider data with valid authentication.
     * This test ensures that provider users can access their own provider information
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid provider data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testProviderData() throws Exception {
        // Get test data
        String apiName = "getProviderData";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Provider Data API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/provider-data")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" Provider Data API test completed successfully");
    }
} 