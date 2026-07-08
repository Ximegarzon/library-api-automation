package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AddBookTest extends BaseTest {

    @Test
    public void addBook() {

        String body = """
        {
            "name":"Learn Selenium Automation with Java",
            "isbn":"abc123",
            "aisle":"789",
            "author":"Ximena Espinosa"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .statusCode(200)
                .body("Msg", equalTo("successfully added"))
                .body("ID", notNullValue())
                .time(lessThan(5000L));

    }
}