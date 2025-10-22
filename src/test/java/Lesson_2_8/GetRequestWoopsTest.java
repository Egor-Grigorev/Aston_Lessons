package Lesson_2_8;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetRequestWoopsTest extends BaseClass {


    @Test
    public void testBody() {
        given()
                .log().all()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
}


