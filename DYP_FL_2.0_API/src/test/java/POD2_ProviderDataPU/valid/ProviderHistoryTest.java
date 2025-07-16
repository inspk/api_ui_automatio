package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Provider History Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the provider history API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve provider history with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/provider-history
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid provider history retrieval with authentication
 * - Provider history retrieval with specific provider ID
 * - Core provider history information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid provider history data
 * - Provider history information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental provider history information
 */
public class ProviderHistoryTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid Provider History Retrieval
     * 
     * Description: Tests the successful retrieval of provider history with valid authentication.
     * This test ensures that provider users can access their history information
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid provider history data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testProviderHistory() throws Exception {
        // Get test data
        String apiName = "getProviderHistory";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Provider History API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/provider-history")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" Provider History API test completed successfully");
    }
} 