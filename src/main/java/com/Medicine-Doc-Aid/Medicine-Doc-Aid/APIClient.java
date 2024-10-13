//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpRequest.BodyPublishers;
//
//public class APIClient {
//
//
//    public static callAPI() {
//        // Create an HttpClient instance
//        HttpClient client = HttpClient.newHttpClient();
//
//        // Define the data to post
//        String jsonData = "{ \"name\": \"John Doe\", \"age\": 29 }";
//
//        // Build a request
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.example.com/data"))
//                .header("Content-Type", "application/json")
//                .POST(BodyPublishers.ofString(jsonData))
//                .build();
//
//        // Send the request and get the response
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Print the response
//        System.out.println(response.body());
//    }
//}