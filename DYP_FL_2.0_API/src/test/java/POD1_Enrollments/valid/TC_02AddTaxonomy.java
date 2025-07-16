package POD1_Enrollments.valid;

import com.dyp.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class TC_02AddTaxonomy extends BaseTest
{

    @BeforeClass
    public void setup()
    {
        setupPodTestData("POD1_EnrollmentsPU");
    }

    @Test
    public void addtaxonomyapi() throws IOException
        {
            String jsonBody = new String(Files.readAllBytes(Paths.get("testdata/POD1_EnrollmentsAddTaxonomyPU.json")));
            String userType = getUserTypeFromPod("POD1_EnrollmentsPU");
            String basePath = getBasePathFromPod("POD1_EnrollmentsPU");
            logTestInfo(" User Type: " + userType);

            Response addtaxonomy = given()
                    .baseUri(getBaseUrl())
                    .header("Content-Type", "application/json")
                    .header("Cookie", "auth_token=" + getToken(userType))
                    .body(jsonBody)
                    .when()
                    .post(basePath+"/programParticipation/addTaxonomy")
                    .then()
                    .statusCode(201)
                    .extract().response();

        }
}

