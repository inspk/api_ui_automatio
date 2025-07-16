package com.hhstechgroup.utility;

import com.hhstechgroup.common.Providers;
import com.hhstechgroup.internal_user.AdditionalActions;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Helper class provides method to retrieve Npi information from npi file.
 */
public class Helper {
    /**
     * This method collects list of NPI using baseUrl
     * @param baseUrl
     */
    public static void collectListOfNPI(String baseUrl) {
        Set<Integer> npi = new HashSet<>();
        String endpoint;

        for (int i = 100; i < 199; i++) {
            endpoint = baseUrl + "/api/hummingbird/providersData/NPI/" + i;

            RequestSpecification httpRequest = RestAssured.given()
                    .relaxedHTTPSValidation()
                    .when();
            Response response = httpRequest.get(endpoint);
            String json = response.getBody().asString();
            DocumentContext context = JsonPath.parse(json);
            String npiStr = context.read("$.npi");
            npiStr = npiStr.replace("\"", "");
            npiStr = npiStr.substring(1, npiStr.length() - 1);
            Arrays.stream(npiStr.split(",")).mapToInt(Integer::parseInt).forEach((j) -> npi.add(j));
            Assert.assertEquals(200, response.getStatusCode());
        }
        try (PrintWriter out = new PrintWriter("npi.csv")) {
            npi.stream().forEach(i -> out.println(i));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * This method gets lists of Npi from file
     * @return
     */
    public static List<String> getListOfNpiFromFile() {
        try {
            return Files.readAllLines(Paths.get("npi.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load npi file");
        }
    }
    /**
     * This method sets unique Npi using baseUrl
     * @param baseUrl
     * @return
     */
    //Find unique NPI for new enrollment
    public static String setUniqueNpi(String baseUrl) {
        AdditionalActions additionalActions = new AdditionalActions();
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders(baseUrl);
        List<Providers> providersJS = outJS.stream().map(Providers::new).collect(Collectors.toList());
        Set<String> npiFromFile = new HashSet<>(getListOfNpiFromFile());
        providersJS.stream().forEach(p -> npiFromFile.remove(p.getNpi()));
        ArrayList<String> out = new ArrayList<>(npiFromFile);
        return out.get((int) (Math.random() * out.size()));
    }

    /**
     * This method sets unique Npi from data base using baseUrl
     * @param baseUrl
     * @return
     */
    //Find not duplicated NPI in DB For Group affiliation test cases
    public static String setUniqueNpiFromDB(String baseUrl) {
        AdditionalActions additionalActions = new AdditionalActions();
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders(baseUrl);
        List<String> npiJS = outJS.stream().map(Providers::new).map(Providers::getNpi).collect(Collectors.toList());
        List<String> uniqueNpiFromDB = npiJS.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() == 1L).map(e -> e.getKey()).collect(Collectors.toList());
        System.out.println(npiJS);
        System.out.println("---------------------------------------------------");
        System.out.println(uniqueNpiFromDB);
        return uniqueNpiFromDB.get((int) (Math.random() * uniqueNpiFromDB.size()));
    }
    /**
     * This method sets providers with unique Npi From data base
     * @param baseUrl
     * @return
     */
    public static Providers setProvidersWithUniqueNpiFromDB(String baseUrl) {
        AdditionalActions additionalActions = new AdditionalActions();
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders(baseUrl);
        List<Providers> providersJS = outJS.stream().map(Providers::new).collect(Collectors.toList());
        List<Providers> uniqueNpiFromDB = providersJS.stream().filter(p -> p.getNpi() != null).filter(p -> p.getFirstName() != null).filter(p -> p.getLastName() != null).filter(p -> p.getAuthorEmail().contains("wyoming.sit2")).collect(Collectors.groupingBy(Providers::getNpi)).entrySet().stream()
                .filter(e -> e.getValue().size() == 1).map(e -> e.getValue()).map(e -> e.get(0)).collect(Collectors.toList());
        System.out.println(uniqueNpiFromDB);
        return uniqueNpiFromDB.get((int) (Math.random() * uniqueNpiFromDB.size()));
    }
    /**
     * This method sets all providers with unique Npi from data base using baseUrl
     * @param baseUrl
     * @return
     */
    public static List<Providers> setAllProvidersWithUniqueNpiFromDB(String baseUrl) {
        AdditionalActions additionalActions = new AdditionalActions();
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders(baseUrl);
        List<Providers> providersJS = outJS.stream().map(Providers::new).collect(Collectors.toList());
        List<Providers> uniqueNpiFromDB = providersJS.stream().filter(p -> p.getNpi() != null).filter(p -> p.getFirstName() != null).filter(p -> p.getLastName() != null).filter(p -> p.getAuthorEmail().contains("wyoming.sit2")).collect(Collectors.groupingBy(Providers::getNpi)).entrySet().stream()
                .filter(e -> e.getValue().size() == 1).map(e -> e.getValue()).map(e -> e.get(0)).collect(Collectors.toList());
        System.out.println(uniqueNpiFromDB);
        return uniqueNpiFromDB;
    }
    /**
     * This method gets current time stamp
     * @return
     */
    public static String getCurrentTimestamp() {
        Format formatter = new SimpleDateFormat("MM-dd-YYYY_hh-mm");
        return formatter.format(new Date());
    }


    /**
     * This method gets current Date
     * @return
     */
    public static String getCurrentDatestamp() {
        Format formatter = new SimpleDateFormat("MM-dd-YYYY");
        return formatter.format(new Date());
    }
    /**
     * This method gets yesterday date
     * @return
     */
    public static String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY");
        System.out.println("Today's date is " + dateFormat.format(cal.getTime()));

       cal.add(Calendar.DATE, -1);
        System.out.println("Yesterday's date was " + dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime()) ;
    }
}
