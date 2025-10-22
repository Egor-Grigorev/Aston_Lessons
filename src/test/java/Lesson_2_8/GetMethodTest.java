package Lesson_2_8;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class GetMethodTest extends BaseClass {


    @Test
    public void testBody() {
        given()
                .log().all()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.foo1", CoreMatchers.equalTo("bar1"))
                .body("args.foo2", CoreMatchers.equalTo("bar2"));
    }


}
