package POD1_Enrollments.valid;

import com.dyp.base.BaseTest;
import com.dyp.base.MongoDBUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_04Detailspptest extends BaseTest
{
    @BeforeClass
    public void setup()
    {
        setupPodTestData("POD1_EnrollmentsPU");
    }

    @Test
    public void getProgramParticipationDetails() {

        String userType = getUserTypeFromPod("POD1_EnrollmentsPU");
        String basePath = getBasePathFromPod("POD1_EnrollmentsPU");
        logTestInfo(" User Type: " + userType);

        // Get _id from MongoDB
        String objectId = MongoDBUtils.getObjectIdByRuntimeId(TC_01CustomSectionValidate.runtimeid);

        // If no ID found, fail test
        if (objectId == null) {
            throw new RuntimeException("No _id found in MongoDB for runtimeId: " + TC_01CustomSectionValidate.runtimeid);
        }

        Response response = given()
                .baseUri(getBaseUrl())
                .header("Content-Type", "application/json")
                .queryParam("id", objectId)
                .header("Cookie", "auth_token=" + getToken(userType))
                .queryParam("isProviderId", "false")
                .when()
                .get(basePath+"/programParticipation/details/"+TC_01CustomSectionValidate.runtimeid)
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response:\n" + response.asPrettyString());
    }
}
