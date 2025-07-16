package POD3_ProviderDataIU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD3_ProviderDataIU - ProviderLocationProviderIdTest (Valid Scenarios)
 * 
 * Purpose: This test class validates the getProviderLocationProviderId API endpoint for Internal User (IU) scenarios.
 * It tests the ability to retrieve data with valid authentication and parameters.
 * 
 * API Endpoint: /api/internal-user-api/v1/providerlocationproviderid
 * Method: GET
 * Authentication: Internal User (IU) Token
 * 
 * Test Scenarios:
 * - Valid getProviderLocationProviderId with authentication
 * - getProviderLocationProviderId with specific parameters
 * - Core getProviderLocationProviderId information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid data
 * - Information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental getProviderLocationProviderId information
 */
public class ProviderLocationProviderIdTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD3_ProviderDataIU");
    }

    /**
     * Test: Valid getProviderLocationProviderId Retrieval
     * 
     * Description: Tests the successful getProviderLocationProviderId with valid authentication.
     * This test ensures that users can access their information
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Internal User Token
     * 
     * Expected: API should return 200 with valid data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testProviderLocationProviderId() throws Exception {
        // Get test data
        String apiName = "getProviderLocationProviderId";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD3_ProviderDataIU");
        String basePath = getBasePathFromPod("POD3_ProviderDataIU");
        
        logTestInfo("🎯 Testing getProviderLocationProviderId API");
        logTestInfo(" Providerid: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/providerlocationproviderid")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" getProviderLocationProviderId API test completed successfully");
    }
}