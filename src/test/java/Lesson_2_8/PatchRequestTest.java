package Lesson_2_8;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTest extends BaseClass {

    @Test
    public void testBody() {
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body("This is expected to be sent back as part of response body")
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", CoreMatchers.equalTo("This is expected to be sent back as part of response body"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}



