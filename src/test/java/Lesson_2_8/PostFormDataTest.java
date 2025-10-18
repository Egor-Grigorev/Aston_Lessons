package Lesson_2_8;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostFormDataTest {

    @Test
    public void testResponseStatusCodeIs200() {
        given()
                .body("qwerty")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBody() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

}
