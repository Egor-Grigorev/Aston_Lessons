package Lesson_2_8;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTest {

   /* @Test
    public void testPatchResponseWithFluentAPI() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType(ContentType.TEXT)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200) // Проверка статус кода
                .body("data", equalTo("This is expected to be sent back as part of response body.")); // Проверка поля data
    }*/
   @Test
   public void status200() {
       given()
               .when()
               .patch("https://postman-echo.com/patch")
               .then()
               .statusCode(200);
   }
    @Test
    public void testBody(){
        given()
                .header("Content-Type", "application/json")
                .body("This is expected to be sent back as part of response body")
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .body("data", CoreMatchers.equalTo("This is expected to be sent back as part of response body"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}



