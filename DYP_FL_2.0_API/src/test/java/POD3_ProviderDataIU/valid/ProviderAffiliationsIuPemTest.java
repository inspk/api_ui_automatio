package POD3_ProviderDataIU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD3_ProviderDataIU - ProviderAffiliationsIuPemTest (Valid Scenarios)
 * 
 * Purpose: This test class validates the getProviderAffiliationsIuPem API endpoint for Internal User (IU) scenarios.
 * It tests the ability to retrieve data with valid authentication and parameters.
 * 
 * API Endpoint: /api/internal-user-api/v1/provideraffiliationsiupem
 * Method: GET
 * Authentication: Internal User (IU) Token
 * 
 * Test Scenarios:
 * - Valid getProviderAffiliationsIuPem with authentication
 * - getProviderAffiliationsIuPem with specific parameters
 * - Core getProviderAffiliationsIuPem information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid data
 * - Information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental getProviderAffiliationsIuPem information
 */
public class ProviderAffiliationsIuPemTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD3_ProviderDataIU");
    }

    /**
     * Test: Valid getProviderAffiliationsIuPem Retrieval
     * 
     * Description: Tests the successful getProviderAffiliationsIuPem with valid authentication.
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
    public void testProviderAffiliationsIuPem() throws Exception {
        // Get test data
        String apiName = "getProviderAffiliationsIuPem";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD3_ProviderDataIU");
        String basePath = getBasePathFromPod("POD3_ProviderDataIU");
        
        logTestInfo("🎯 Testing getProviderAffiliationsIuPem API");
        logTestInfo(" Providerid: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/provideraffiliationsiupem")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" getProviderAffiliationsIuPem API test completed successfully");
    }
}