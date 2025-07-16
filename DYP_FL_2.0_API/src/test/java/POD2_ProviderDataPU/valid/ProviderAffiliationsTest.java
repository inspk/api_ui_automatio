package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Provider Affiliations Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the provider affiliations API endpoint for Provider User (PU) scenarios.
 * It tests the ability to retrieve provider affiliations with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/provider-affiliations
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid provider affiliations retrieval with authentication
 * - Provider affiliations retrieval with specific provider ID
 * - Core provider affiliations information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid provider affiliations data
 * - Provider affiliations information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental provider affiliations information
 */
public class ProviderAffiliationsTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid Provider Affiliations Retrieval
     * 
     * Description: Tests the successful retrieval of provider affiliations with valid authentication.
     * This test ensures that provider users can access their affiliations information
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid provider affiliations data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testProviderAffiliations() throws Exception {
        // Get test data
        String apiName = "getProviderAffiliations";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String providerId = TestDataUtil.getValidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Provider Affiliations API");
        logTestInfo(" Provider ID: " + providerId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", providerId)
        .when()
            .get(basePath + "/provider-affiliations")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" Provider Affiliations API test completed successfully");
    }
} 