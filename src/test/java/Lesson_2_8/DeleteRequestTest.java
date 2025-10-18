package Lesson_2_8;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestTest {

    @Test
    public void testDeleteCode200() {
        given()
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                //.statusCode(200) //
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}