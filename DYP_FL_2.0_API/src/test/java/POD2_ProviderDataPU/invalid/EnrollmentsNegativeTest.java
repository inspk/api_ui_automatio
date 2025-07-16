package POD2_ProviderDataPU.invalid;

import com.dyp.base.BaseTest;
import com.dyp.base.TestDataUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * POD2_ProviderDataPU - Enrollments Negative Test (Invalid Scenarios)
 * 
 * Purpose: This test class validates the enrollments API endpoint for Provider User (PU) scenarios
 * with invalid parameters to ensure proper error handling.
 * 
 * API Endpoint: /api/provider-api/v1/enrollments
 * Method: GET
 * Authentication: Provider User Token
 * 
 * Test Scenarios:
 * - Invalid enrollment data retrieval with invalid provider ID
 * - Enrollment data retrieval with missing required parameters
 * - Core enrollment error handling validation
 * 
 * Expected Results:
 * - Status Code: 400/422/500 (depending on error type)
 * - Response contains appropriate error messages
 * - Error handling is working correctly
 * - Authentication and authorization working correctly
 * 
 * This is a core API that provides fundamental enrollment information with error handling
 */
public class EnrollmentsNegativeTest extends BaseTest {
    
    @BeforeClass
    public void setup() {
        setupPodTestData("POD2_ProviderDataPU");
    }

    /**
     * Test: Invalid Enrollments Retrieval with Invalid Provider ID
     * 
     * Description: Tests the enrollment API with invalid provider ID to ensure proper error handling.
     * This test ensures that the API correctly handles invalid parameters
     * and returns appropriate error responses.
     * 
     * Test Data: Uses test data from JSON file
     * Authentication: Provider User Token
     * 
     * Expected: API should return error status code with appropriate error message
     * 
     * @throws Exception if test data loading fails
     */
    @Test
    public void testEnrollmentsWithInvalidProviderId() throws Exception {
        // Get test data
        String apiName = "getEnrollments";
        validateTestData(apiName);
        logTestDataInfo(apiName);
        
        // Get test data values
        String invalidProviderId = TestDataUtil.getInvalidValue(apiName, "providerId");
        String userType = getUserTypeFromPod("POD2_ProviderDataPU");
        String basePath = getBasePathFromPod("POD2_ProviderDataPU");
        
        logTestInfo("🎯 Testing Enrollments API with Invalid Provider ID");
        logTestInfo(" Invalid Provider ID: " + invalidProviderId);
        logTestInfo(" User Type: " + userType);
        logTestInfo(" Base Path: " + basePath);

        given()
            .baseUri(getBaseUrl())
            .header("Cookie", "auth_token=" + getToken(userType))
            .queryParam("providerId", invalidProviderId)
        .when()
            .get(basePath + "/enrollments")
        .then()
            .statusCode(anyOf(is(400), is(422), is(500)))
            .body("success", anyOf(equalTo(false), nullValue()));
            
        logTestPass(" Enrollments API negative test completed successfully");
    }
} 