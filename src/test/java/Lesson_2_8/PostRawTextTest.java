package Lesson_2_8;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class PostRawTextTest {


    @Test
    public void testResponseStatusCodeIs200() {
        given()
                .body("")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBody() {
        given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
