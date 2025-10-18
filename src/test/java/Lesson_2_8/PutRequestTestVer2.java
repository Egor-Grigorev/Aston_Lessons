package Lesson_2_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutRequestTestVer2 {


    @Test
    public void status200() {
        given()
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200);
    }
    @Test
    public void testBody(){
        given()
                .header("Content-Type", "application/json")
                .body("This is expected to be sent back as part of response body")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .body("data", equalTo("This is expected to be sent back as part of response body"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
