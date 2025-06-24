package APis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utlities.ConfigReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ApiHelper {


    private static final String BASE_URL = ConfigReader.get("base.url");
    private static final String API_KEY = ConfigReader.get("api.key");
    public static Response execute(String method, String endpoint, String jsonFileName) {
        RestAssured.baseURI = BASE_URL;
        System.out.println("Base URL: " + BASE_URL);
        System.out.println("Endpoint: " + endpoint);
        System.out.println("HTTP Method: " + method.toUpperCase());

        String jsonPayload = "";

        try {
            if (jsonFileName != null && !jsonFileName.isEmpty()) {
                String path = "src/main/resources/data/" + jsonFileName + ".json";
                jsonPayload = new String(Files.readAllBytes(Paths.get(path)));
                System.out.println("Loaded JSON payload from: " + path);
            }
        } catch (IOException e) {
            System.err.println("Failed to load JSON file: " + jsonFileName);
            e.printStackTrace();
            throw new RuntimeException("Failed to load JSON file: " + jsonFileName, e);
        }

        try {
            RequestSpecification request = RestAssured
                    .given()
                    .header("x-api-key", API_KEY)
                    .contentType(ContentType.JSON)
                    .log().all();

            if (!jsonPayload.isEmpty()) {
                request.body(jsonPayload);
            }

            switch (method.toLowerCase()) {
                case "post":
                    return request.post(endpoint);

                case "get":
                    return request.get(endpoint);

                case "put":
                    return request.put(endpoint);

                case "delete":
                    return request.delete(endpoint);

                default:
                    throw new IllegalArgumentException("Unsupported HTTP method: " + method);
            }

        } catch (Exception ex) {
            System.err.println("HTTP request failed:");
            ex.printStackTrace();
            throw new RuntimeException("API call failed for method: " + method + " and endpoint: " + endpoint, ex);
        }
    }

}
