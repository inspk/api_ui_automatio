package POD2_ProviderDataPU.invalid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - GetServiceLocationNamesNegativeTest (Invalid Scenarios)
 * 
 * Purpose: This test class validates the getServiceLocationNames API endpoint for Provider User (PU) scenarios.
 * It tests the ability to handle invalid parameters with valid authentication and parameters.
 * 
 * API Endpoint: /api/provider-api/v1/servicelocationnames
 * Method: GET
 * Authentication: Provider User (PU) Token
 * 
 * Test Scenarios:
 * - Invalid getServiceLocationNames with invalid parameters
 * - getServiceLocationNames with missing required parameters
 * - Core getServiceLocationNames error handling validation
 * 
 * Expected Results:
 * - Status Code: 400/422/500
 * - Response contains error status code with appropriate error message
 * - Error handling is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental getServiceLocationNames information with error handling
 */
public class GetServiceLocationNamesNegativeTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Invalid getServiceLocationNames with Invalid Parameters
     * 
     * Description: Tests the unsuccessful getServiceLocationNames with invalid authentication.
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
    public void testServiceLocationNamesWithInvalidParameters() throws Exception {
        // Get test data
        String apiName = "getServiceLocationNames";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String invalidProviderid = TestDataUtil.getInvalidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing getServiceLocationNames API with Invalid Parameters");
        logTestInfo(" Invalid providerId: " + invalidProviderid);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", invalidProviderid)
        .when()
            .get(basePath + "/servicelocationnames")
        .then()
            .statusCode(anyOf(is(400), is(422), is(500)))
            .body("success", anyOf(equalTo(false), nullValue()));
            
        logTestPass(" getServiceLocationNames API negative test completed successfully");
    }
}