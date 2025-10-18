package Lesson_2_8;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetRequestWoopsTest {


    @ Test
    public void testResponseStatusCodeIs200() {

        given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBody() {
        given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1" , equalTo("bar1"))
                .body("args.foo2" , equalTo("bar2"));
    }
}


