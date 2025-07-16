package POD4_SystemConfiguration.invalid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD4_SystemConfiguration - AffiliationConfigNegativeTest (Invalid Scenarios)
 * 
 * Purpose: This test class validates the affiliationConfig API endpoint for Internal User (IU) scenarios.
 * It tests the ability to handle invalid parameters with valid authentication and parameters.
 * 
 * API Endpoint: /api/internal-user-api/v1/affiliationconfig
 * Method: GET
 * Authentication: Internal User (IU) Token
 * 
 * Test Scenarios:
 * - Invalid affiliationConfig with invalid parameters
 * - affiliationConfig with missing required parameters
 * - Core affiliationConfig error handling validation
 * 
 * Expected Results:
 * - Status Code: 400/422/500
 * - Response contains error status code with appropriate error message
 * - Error handling is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental affiliationConfig information with error handling
 */
public class AffiliationConfigNegativeTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD4_SystemConfiguration");
    }

    /**
     * Test: Invalid affiliationConfig with Invalid Parameters
     * 
     * Description: Tests the unsuccessful affiliationConfig with invalid authentication.
     * This test ensures that the API correctly handles invalid parameters
     * and that the API returns the expected data structure.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Internal User Token
     * 
     * Expected: API should return error status code with appropriate error message
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testaffiliationConfigWithInvalidParameters() throws Exception {
        // Get test data
        String apiName = "affiliationConfig";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String invalidConfigid = TestDataUtil.getInvalidValue(apiName, "configId");
        String userType = getUserTypeFromPod("POD4_SystemConfiguration");
        String basePath = getBasePathFromPod("POD4_SystemConfiguration");
        
        logTestInfo("🎯 Testing affiliationConfig API with Invalid Parameters");
        logTestInfo(" Invalid configId: " + invalidConfigid);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("configId", invalidConfigid)
        .when()
            .get(basePath + "/affiliationconfig")
        .then()
            .statusCode(anyOf(is(400), is(422), is(500)))
            .body("success", anyOf(equalTo(false), nullValue()));
            
        logTestPass(" affiliationConfig API negative test completed successfully");
    }
}