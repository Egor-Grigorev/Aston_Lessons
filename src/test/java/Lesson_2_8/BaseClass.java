package Lesson_2_8;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public class BaseClass {

    @BeforeAll
    public static void setup() {
        baseURI = "https://postman-echo.com";
        enableLoggingOfRequestAndResponseIfValidationFails();
        useRelaxedHTTPSValidation();
    }
}
