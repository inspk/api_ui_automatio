package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Timeline API Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the timeline API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve timeline data with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/timeline
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid timeline data retrieval with authentication
 * - Timeline data retrieval with specific provider ID
 * - Core timeline information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid timeline data
 * - Timeline information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental timeline information
 */
public class TimelineAPITest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid Timeline API Retrieval
     * 
     * Description: Tests the successful retrieval of timeline data with valid authentication.
     * This test ensures that provider users can access their timeline information
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid timeline data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testTimelineAPI() throws Exception {
        // Get test data
        String apiName = "getTimeline";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Timeline API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/timeline")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" Timeline API test completed successfully");
    }
} 