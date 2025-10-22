package Lesson_2_8;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class PostRawTextTest extends BaseClass {

    @Test
    public void testBody() {
        given()
                .log().all()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
