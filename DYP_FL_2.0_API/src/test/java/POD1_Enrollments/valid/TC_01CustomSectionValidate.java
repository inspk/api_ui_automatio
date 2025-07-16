package POD1_Enrollments.valid;

import com.dyp.base.BaseTest;
import io.restassured.response.Response;
import java.util.Arrays;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static io.restassured.RestAssured.given;


public class TC_01CustomSectionValidate extends BaseTest

{
    public static String runtimeid;

    @BeforeClass
    public void setup()
    {
        setupPodTestData("POD1_EnrollmentsPU");
    }

    @Test
    public void CustomSectionValidate() throws IOException
    {
        String jsonBody = new String(Files.readAllBytes(Paths.get("testdata/POD1_EnrollmentsPU.json")));
        String userType = getUserTypeFromPod("POD1_EnrollmentsPU");
        String basePath = getBasePathFromPod("POD1_EnrollmentsPU");
        logTestInfo(" User Type: " + userType);

        Response runtimeID = given()
                .baseUri(getBaseUrl())
                .header("Content-Type", "application/json")
                .header("Cookie", "auth_token=" + getToken(userType))
                .body(jsonBody)
                .when()
                .post("/api/hummingbird/runtimeApplications")
                .then()
                .statusCode(201) // Change this to expected status
                .extract().response();


        // Get the status code
        int statusCode = runtimeID.statusCode();
        System.out.println("POST Response Status Code: " + statusCode);
        runtimeid = runtimeID.path("id");
        System.out.println("Created runtimeid is  " + runtimeid);



        List<String> sectionNames = Arrays.asList("sl", "pp", "aff"); // Use a List for multiple values
        boolean isSNPI = true;
        boolean isProvider = false;

        Response response = given()
                .baseUri(getBaseUrl())
                .header("Content-Type", "application/json")
                .header("Cookie", "auth_token=" + getToken(userType)) // Include if authentication is required
                .queryParam("isSNPI", isSNPI)
                .queryParam("runtimeApplicationId", runtimeid)
                // RestAssured automatically handles multiple values for the same query parameter name
                .queryParam("sectionName", sectionNames) // Pass the List here
                .queryParam("isProvider", isProvider)
                .when()
                .get(basePath+ "/customSection/validate")
                .then()
                .statusCode(200) // Expecting 200 for a successful validation
                .extract().response();
                System.out.println(response);
    }

}





