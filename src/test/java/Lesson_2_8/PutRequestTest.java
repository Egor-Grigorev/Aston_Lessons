package Lesson_2_8;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequestTest extends BaseClass {


    @Test
    public void testPutRequestBody() {
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body("{ \"data\": \"This is expected to be sent back as part of response body.\"}")
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.data", equalTo("This is expected to be sent back as part of response body."));
    }
}