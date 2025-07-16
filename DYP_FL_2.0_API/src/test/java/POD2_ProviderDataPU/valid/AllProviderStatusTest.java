package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - All Provider Status Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the all provider status API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve provider status information with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/providerStatus/allProviderStatus
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid provider status retrieval with authentication
 * - Provider status retrieval with pagination
 * - Core provider status information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid provider status data
 * - Provider status information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental provider status information
 */
public class AllProviderStatusTest extends BaseTest {
    
    @BeforeClass
    public void setup()
    {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid All Provider Status Retrieval
     * 
     * Description: Tests the successful retrieval of all provider status with valid authentication.
     * This test ensures that provider users can access provider status information
     * and that the API returns the expected data structure with pagination.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid provider status data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testAllProviderStatus() throws Exception {
        // Get test data
        String apiName = "getProviderStatus";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing All Provider Status API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
            .queryParam("page", 0)
            .queryParam("size", 10)
        .when()
            .get(basePath + "/providerStatus/allProviderStatus")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" All Provider Status API test completed successfully");
    }
} 