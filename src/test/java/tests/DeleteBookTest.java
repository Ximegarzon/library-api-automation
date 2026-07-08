package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBookTest extends BaseTest {

    @Test
    public void deleteBook() {

        String body = """
        {
            "ID":"abc123789"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Library/DeleteBook.php")
                .then()
                .statusCode(200)
                .body("msg", equalTo("book is successfully deleted"));

    }
}