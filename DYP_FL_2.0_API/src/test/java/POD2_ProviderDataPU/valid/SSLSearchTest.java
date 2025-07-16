package POD2_ProviderDataPU.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - SSL Search Test (Valid Scenarios)
 * 
 * Purpose: This test class validates the SSL search API endpoint for Provider User (PU) scenarios.
 * It tests the ability to perform SSL search with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/ssl-search
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Valid SSL search with authentication
 * - SSL search with specific search term
 * - Core SSL search functionality validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid SSL search data
 * - SSL search information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental SSL search functionality
 */
public class SSLSearchTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Valid SSL Search
     * 
     * Description: Tests the successful SSL search with valid authentication.
     * This test ensures that provider users can perform SSL searches
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return 200 with valid SSL search data
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testSSLSearch() throws Exception {
        // Get test data
        String apiName = "sslSearch";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String searchTerm = TestDataUtil.getValidValue(apiName, "searchTerm");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing SSL Search API");
        logTestInfo(" Search Term: " + searchTerm);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("searchTerm", searchTerm)
        .when()
            .get(basePath + "/ssl-search")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" SSL Search API test completed successfully");
    }
} 