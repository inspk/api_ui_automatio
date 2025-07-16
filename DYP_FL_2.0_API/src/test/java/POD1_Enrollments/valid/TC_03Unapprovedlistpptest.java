package POD1_Enrollments.valid;

import com.dyp.base.BaseTest;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_03Unapprovedlistpptest extends BaseTest
{
    @BeforeClass
    public void setup()
    {
        setupPodTestData("POD1_EnrollmentsPU");
    }
    @Test
    public void testGetProgramParticipationList() {

        // Define query parameters
        String direction = ""; // Can be "asc" or "desc" if applicable
        int page = 0;
        int size = 10;
        String sortBy = "effectiveEndDate";
        boolean isProviderId = false;

        String userType = getUserTypeFromPod("POD1_EnrollmentsPU");
        String basePath = getBasePathFromPod("POD1_EnrollmentsPU");
        logTestInfo(" User Type: " + userType);


        // Perform the GET request
        Response response = given()
                .baseUri(getBaseUrl())
                .header("Content-Type", "application/json")
                .header("Cookie", "auth_token=" + getToken(userType))
                .queryParam("direction", direction)
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("sortBy", sortBy)
                .queryParam("isProviderId", isProviderId)
                .when()
                .get(basePath+"/programParticipation/list/"+TC_01CustomSectionValidate.runtimeid )
                .then()
                .statusCode(200) // Assert that the status code is 200 OK
                .extract().response();
        System.out.println("programparticipationapiTest Response is " + response);

    }
}

