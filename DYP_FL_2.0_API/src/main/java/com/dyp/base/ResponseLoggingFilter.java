package com.dyp.base;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Response Logging Filter
 * 
 * Purpose: Provides clean and concise logging for API requests and responses
 * 
 * Features:
 * - Request method and URL logging
 * - Response status code logging
 * - Response time logging
 * - Truncated response body logging
 * - Clean formatting without emojis
 */
public class ResponseLoggingFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                         FilterableResponseSpecification responseSpec,
                         FilterContext ctx) {
        
        // Log request
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + timestamp + "] REQUEST:");
        System.out.println("   Method: " + requestSpec.getMethod());
        System.out.println("   URL: " + requestSpec.getURI());
        
        // Log response
        Response response = ctx.next(requestSpec, responseSpec);
        
        System.out.println("[" + timestamp + "] RESPONSE:");
        System.out.println("   Status Code: " + response.getStatusCode());
        System.out.println("   Response Time: " + response.getTime() + "ms");
        
        // Log response body (truncated if too long)
        String responseBody = response.getBody().asString();
        if (responseBody.length() > 500) {
            responseBody = responseBody.substring(0, 500) + "... [truncated]";
        }
        System.out.println("   Response Body: " + responseBody);
        
        // Log success/failure
        if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
            System.out.println("   API call successful with status code: " + response.getStatusCode());
        } else {
            System.out.println("   API call failed with status code: " + response.getStatusCode());
        }
        
        // Create separator line
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            separator.append("─");
        }
        System.out.println("   " + separator.toString());
        
        return response;
    }
} 