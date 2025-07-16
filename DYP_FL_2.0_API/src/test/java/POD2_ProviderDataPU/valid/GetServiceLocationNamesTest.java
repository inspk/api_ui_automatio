package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Get Service Location Names Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the get service location names API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve service location names with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/service-location-names
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid service location names retrieval with authentication
 * - Service location names retrieval with specific provider ID
 * - Core service location names information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid service location names data
 * - Service location names information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental service location names information
 */
public class GetServiceLocationNamesTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid Get Service Location Names Retrieval
     * 
     * Description: Tests the successful retrieval of service location names with valid authentication.
     * This test ensures that provider users can access their service location names
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid service location names data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testGetServiceLocationNames() throws Exception {
        // Get test data
        String apiName = "getServiceLocationNames";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Get Service Location Names API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/service-location-names")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" Get Service Location Names API test completed successfully");
    }
} 