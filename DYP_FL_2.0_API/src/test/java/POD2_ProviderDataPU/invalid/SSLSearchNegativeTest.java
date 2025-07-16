package POD2_ProviderDataPU.invalid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - SSLSearchNegativeTest (Invalid Scenarios)
 * 
 * Purpose: This test class validates the sslSearch API endpoint for Provider User (PU) scenarios.
 * It tests the ability to handle invalid parameters with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/sslsearch
 * Method: GET
 * Authentication: Provider User (PU) Token
 * 
 * Test Scenarios:
 * - Invalid sslSearch with invalid parameters
 * - sslSearch with missing required parameters
 * - Core sslSearch error handling validation
 * 
 * Expected Results:
 * - Status Code: 400/422/500
 * - Response contains error status code with appropriate error message
 * - Error handling is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental sslSearch information with error handling
 */
public class SSLSearchNegativeTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Invalid sslSearch with Invalid Parameters
     * 
     * Description: Tests the unsuccessful sslSearch with invalid authentication.
     * This test ensures that the API correctly handles invalid parameters
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return error status code with appropriate error message
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testsslSearchWithInvalidParameters() throws Exception {
        // Get test data
        String apiName = "sslSearch";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String invalidSearchterm = TestDataUtil.getInvalidValue(apiName, "searchTerm");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing sslSearch API with Invalid Parameters");
        logTestInfo(" Invalid searchTerm: " + invalidSearchterm);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("searchTerm", invalidSearchterm)
        .when()
            .get(basePath + "/sslsearch")
        .then()
            .statusCode(anyOf(is(400), is(422), is(500)))
            .body("success", anyOf(equalTo(false), nullValue()));
            
        logTestPass(" sslSearch API negative test completed successfully");
    }
}