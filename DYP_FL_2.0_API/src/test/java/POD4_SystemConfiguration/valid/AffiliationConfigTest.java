package POD4_SystemConfiguration.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD4_SystemConfiguration - AffiliationConfigTest (Valid Scenarios)
 * 
 * Purpose: This test class validates the affiliationConfig API endpoint for Internal User (IU) scenarios.
 * It tests the ability to retrieve data with valid authentication and parameters.
 * 
 * API Endpoint: /api/internal-user-api/v1/affiliationconfig
 * Method: GET
 * Authentication: Internal User (IU) Token
 * 
 * Test Scenarios:
 * - Valid affiliationConfig with authentication
 * - affiliationConfig with specific parameters
 * - Core affiliationConfig information validation
 * 
 * Expected Results:
 * - Status Code: 200
 * - Response contains valid data
 * - Information is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental affiliationConfig information
 */
public class AffiliationConfigTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD4_SystemConfiguration");
    }

    /**
     * Test: Valid affiliationConfig Retrieval
     * 
     * Description: Tests the successful affiliationConfig with valid authentication.
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
    public void testaffiliationConfig() throws Exception {
        // Get test data
        String apiName = "affiliationConfig";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String configId = TestDataUtil.getValidValue(apiName, "configId");
        String userType = getUserTypeFromPod("POD4_SystemConfiguration");
        String basePath = getBasePathFromPod("POD4_SystemConfiguration");
        
        logTestInfo("🎯 Testing affiliationConfig API");
        logTestInfo(" Configid: " + configId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("configId", configId)
        .when()
            .get(basePath + "/affiliationconfig")
        .then()
            .statusCode(200)
            .body("success", equalTo(true));
            
        logTestPass(" affiliationConfig API test completed successfully");
    }
}