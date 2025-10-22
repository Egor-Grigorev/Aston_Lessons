package Lesson_2_8;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutRequestTestVer2 extends BaseClass {


    @Test
    public void testBody() {
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body("This is expected to be sent back as part of response body")
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
