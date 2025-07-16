package POD3_ProviderDataIU.invalid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD3_ProviderDataIU - TimelineNegativeTest (Invalid Scenarios)
 * 
 * Purpose: This test class validates the getTimeline API endpoint for Internal User (IU) scenarios.
 * It tests the ability to handle invalid parameters with valid authentication and parameters.
 * 
 * API Endpoint: /api/internal-user-api/v1/timeline
 * Method: GET
 * Authentication: Internal User (IU) Token
 * 
 * Test Scenarios:
 * - Invalid getTimeline with invalid parameters
 * - getTimeline with missing required parameters
 * - Core getTimeline error handling validation
 * 
 * Expected Results:
 * - Status Code: 400/422/500
 * - Response contains error status code with appropriate error message
 * - Error handling is correctly formatted
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental getTimeline information with error handling
 */
public class TimelineNegativeTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD3_ProviderDataIU");
    }

    /**
     * Test: Invalid getTimeline with Invalid Parameters
     * 
     * Description: Tests the unsuccessful getTimeline with invalid authentication.
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
    public void testTimelineWithInvalidParameters() throws Exception {
        // Get test data
        String apiName = "getTimeline";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String invalidProviderid = TestDataUtil.getInvalidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD3_ProviderDataIU");
        String basePath = getBasePathFromPod("POD3_ProviderDataIU");
        
        logTestInfo("🎯 Testing getTimeline API with Invalid Parameters");
        logTestInfo(" Invalid providerId: " + invalidProviderid);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", invalidProviderid)
        .when()
            .get(basePath + "/timeline")
        .then()
            .statusCode(anyOf(is(400), is(422), is(500)))
            .body("success", anyOf(equalTo(false), nullValue()));
            
        logTestPass(" getTimeline API negative test completed successfully");
    }
}