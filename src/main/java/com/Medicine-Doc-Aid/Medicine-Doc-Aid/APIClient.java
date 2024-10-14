package com.Medicine_Doc_Aid.Medicine_Doc_Aid;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class APIClient {

    private static final String API_URL = "http://localhost:8082/generate";

    // Static method to call the API with the prompt and return the message
    public static String callGemini(String prompt) {
        try {
            // Prepare the request body with the prompt
            String requestBody = "{\"prompt\": \"" + prompt + "\"}";

            // Create the HttpClient
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // Create the HttpRequest with POST method and JSON body
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                    .build();

            // Send the request and receive a response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Extract and return the "message" from the JSON response
            if (response.statusCode() == 200) {
                // Assuming the response body is JSON like {"message": "Cardiology", "status": 200}
                String responseBody = response.body();
                return extractMessage(responseBody);
            } else {
                return "Error: Received status code " + response.statusCode();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Helper method to extract the "message" field from the JSON response
    private static String extractMessage(String jsonResponse) {
        try {
            // Initialize Jackson's ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON string into a JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            // Extract and return the "message" field
            return jsonNode.get("message").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error extracting message: " + e.getMessage();
        }
    }
}
