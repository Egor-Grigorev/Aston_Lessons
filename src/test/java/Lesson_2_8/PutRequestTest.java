package Lesson_2_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequestTest {

    @Test
    public void testStatusCode() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"data\": \"This is expected to be sent back as part of response body.\"}")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPutRequestBody() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"data\": \"This is expected to be sent back as part of response body.\"}")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .body("json.data", equalTo("This is expected to be sent back as part of response body."));
    }
}