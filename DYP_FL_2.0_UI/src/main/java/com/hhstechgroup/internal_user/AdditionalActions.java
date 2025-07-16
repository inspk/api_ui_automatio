package com.hhstechgroup.internal_user;

import com.hhstechgroup.common.Reports;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * AdditionalActions class works for simplifying testing of restful services.
 * It provides methods for interacting with the API and do the screening.
 *
 */
public class AdditionalActions {

    /**
     * This method replaces request Id in screening file
     * @param requestId
     * @param screeningFile
     */
    public static void replaceRequestIdInScreeningFile(int requestId, String screeningFile) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).contains("<Request id=")) {
                    allLines.set(i, "        <Request id=\"" + requestId + "\">");
                }
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(screeningFile));
            for (int i = 0; i < allLines.size(); i++) {
                if (i > 0) {
                    out.newLine();
                }
                out.write(allLines.get(i));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method does the screening through medversantScreening API
     * @param screeningFile
     * @param screeningEndpoint
     * @param cookies
     */
    public void screening(String screeningFile, String screeningEndpoint, String cookies) {
        System.out.println(screeningEndpoint);
        // String fullCookies = "auth_token="+ cookies;
        System.out.println(cookies);
        given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "multipart/form-data")
                .cookie("auth_token", cookies)
                .multiPart(new File(screeningFile))
                .when()
                .post(screeningEndpoint)
                .then()
                .statusCode(200);
    }

    /**
     * This method gets all providers
     * @param baseUrl
     * @param email
     */
    public void getAllProviders(String baseUrl, String email) {
        String getAllProvidersEndpoint = baseUrl + "/api/hummingbird/public/providers?sortBy=createdDate&pageNumber=0&pageSize=50&getAll=true";
        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when();
        Response response = httpRequest.get(getAllProvidersEndpoint);


        String json = response.getBody().asString();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

        List<String> address = JsonPath.read(document, "$[?(@.author.email == '" + email + "')].provider.address.mailing.address.text");
        MatcherAssert.assertThat(address.get(0), Matchers.equalToIgnoringCase("609 S 2nd St, Laramie WY"));
    }

    /**
     * This method gets lists of providers through hummingbird API
     * @param baseUrl
     * @return
     */
    public List<LinkedHashMap<String, LinkedHashMap<String, Object>>> getListsProviders(String baseUrl) {
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> out = new ArrayList();
        int page = 0;
        int count = 0;
        do {
            String getAllProvidersEndpoint = baseUrl + "/api/hummingbird/public/providers?sortBy=createdDate&pageNumber=" + page + "&pageSize=50&getAll=false";
            RequestSpecification httpRequest = RestAssured.given()
                    .relaxedHTTPSValidation()
                    .header("Content-Type", "application/json")
                    .when();
            Response response = httpRequest.get(getAllProvidersEndpoint);

            String json = response.getBody().asString();
            Assert.assertEquals(response.getStatusCode(), 200);
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

            List providers = JsonPath.read(document, "$.[*]");
            count = providers.size();
            page++;
            out.addAll(providers);
            if (page > 1) {
                break;
            }
            System.out.println("Page!!!! " + page);
        } while (count > 0);
        return out;
    }


//    public List<LinkedHashMap<String, LinkedHashMap<String, Object>>> getListsProviderUsingApiKey(String baseUrl, String providerId) {
//        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> out = new ArrayList();
//
//        do {
//            String getAllProvidersEndpoint = baseUrl + "/public/providers/"+ providerId + "?apikey=0ec82ad3-47ca-4d05-9c77-02f5ceb7aabd";
//        RequestSpecification httpRequest = RestAssured.given()
//                .relaxedHTTPSValidation()
//                .header("Content-Type", "application/json")
//                .when();
//        Response response = httpRequest.get(getAllProvidersEndpoint);
//
//        String json = response.getBody().asString();
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

//        List providers = JsonPath.read(document, "$.[*]");
//        count = providers.size();
//        page++;
//        out.addAll(providers);
//        if(page > 1){
//                break;
//            }
//            System.out.println("Page!!!! " + page);
//    }while(count > 0);
//        return out;
//    }

    /**
     * This method does the revalidation through hummingbird API
     * @param endpoint
     * @param cookies
     * @param providerDataId
     * @param timeToRevalidation
     */
    public static void revalidation(String endpoint, String cookies, String providerDataId, String timeToRevalidation) {
        Reports.log(endpoint);
        String payload = "{ \"providerDataId\" : \"" + providerDataId + "\", \"timeToRevalidation\": \"" + timeToRevalidation + "\" }";
        RequestSpecification httpRequest = RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie("auth_token", cookies)
                .header("Content-Type", "application/json")
                .body(payload)
                .when();
        Response response = httpRequest.post(endpoint);
        Assert.assertEquals(200, response.getStatusCode());

    }

    /**
     * This method gets provider data Id through hummingbird API
     * @param environmentUrl
     * @param firstName
     * @param lastName
     * @return
     */
    public String getProviderDataId(String environmentUrl, String firstName, String lastName) {
        RestAssured.baseURI = environmentUrl;
        String uri = "/api/hummingbird/public/providers?" + "firstName=" + firstName + "&lastName=" + lastName;
        String endPoint = RestAssured.baseURI + uri;
        System.out.println("EndPoint: "+endPoint);

        RequestSpecification httpRequest = RestAssured.given()
                .header("Content-Type", "application/json;charset=UTF-8")
                .relaxedHTTPSValidation();
        System.out.println("httpRequest: "+httpRequest);
        Response response = httpRequest.get(uri);
        System.out.println(response);
        System.out.println(response.getBody().prettyPrint());
        System.out.println("response.getStatusCode() :" +response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
        List<Map<String, String>> jsonResponse = response.jsonPath().getList("$");
        System.out.println("jsonResponse :" +jsonResponse);
        String providerDataId = jsonResponse.get(0).get("id");
        Reports.log("Provider data ID: " + providerDataId);
        return providerDataId;
    }
}
