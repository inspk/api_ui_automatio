package com.dyp.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class TestDataUtil {
    private static JsonNode testData;

    public static void loadTestData(String podName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = "testdata/" + podName + ".json";
        File file = new File(fileName);
        
        if (!file.exists()) {
            throw new IOException("Test data file not found: " + fileName);
        }
        
        testData = mapper.readTree(file);
    }

    public static JsonNode getApiData(String apiName) {
        if (testData == null) {
            throw new RuntimeException("Test data not loaded. Call loadTestData() first.");
        }
        JsonNode apiData = testData.get(apiName);
        if (apiData == null) {
            throw new RuntimeException("API '" + apiName + "' not found in test data. Available APIs: " + getAvailableApis());
        }
        return apiData;
    }

    public static String getFeature(String apiName) {
        return getApiData(apiName).get("feature").asText();
    }

    public static String getDescription(String apiName) {
        return getApiData(apiName).get("description").asText();
    }

    public static JsonNode getValidData(String apiName) {
        JsonNode validData = getApiData(apiName).get("valid");
        if (validData == null) {
            throw new RuntimeException("Valid data not found for API: " + apiName);
        }
        return validData;
    }

    public static JsonNode getInvalidData(String apiName) {
        JsonNode invalidData = getApiData(apiName).get("invalid");
        if (invalidData == null) {
            throw new RuntimeException("Invalid data not found for API: " + apiName);
        }
        return invalidData;
    }

    public static String getValidValue(String apiName, String fieldName) {
        JsonNode validData = getValidData(apiName);
        JsonNode field = validData.get(fieldName);
        if (field == null) {
            throw new RuntimeException("Field '" + fieldName + "' not found in valid data for API: " + apiName);
        }
        return field.asText();
    }

    public static String getInvalidValue(String apiName, String fieldName) {
        JsonNode invalidData = getInvalidData(apiName);
        JsonNode field = invalidData.get(fieldName);
        if (field == null) {
            throw new RuntimeException("Field '" + fieldName + "' not found in invalid data for API: " + apiName);
        }
        return field.asText();
    }

    public static String getAvailableApis() {
        if (testData == null) {
            return "No test data loaded";
        }
        
        StringBuilder apis = new StringBuilder();
        Iterator<Map.Entry<String, JsonNode>> fields = testData.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            apis.append(field.getKey());
            if (fields.hasNext()) {
                apis.append(", ");
            }
        }
        return apis.toString();
    }

    public static boolean hasApi(String apiName) {
        return testData != null && testData.has(apiName);
    }

    public static void validateTestData(String apiName) {
        if (!hasApi(apiName)) {
            throw new RuntimeException("API '" + apiName + "' not found in test data. Available APIs: " + getAvailableApis());
        }
        
        JsonNode apiData = getApiData(apiName);
        if (!apiData.has("feature")) {
            throw new RuntimeException("Missing 'feature' field for API: " + apiName);
        }
        if (!apiData.has("description")) {
            throw new RuntimeException("Missing 'description' field for API: " + apiName);
        }
        if (!apiData.has("valid")) {
            throw new RuntimeException("Missing 'valid' data for API: " + apiName);
        }
        if (!apiData.has("invalid")) {
            throw new RuntimeException("Missing 'invalid' data for API: " + apiName);
        }
    }
} 