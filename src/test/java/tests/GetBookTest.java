package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class GetBookTest extends BaseTest {

    @Test
    public void getBook() {

        String body = """
        {
            "name":"Libro QA",
            "isbn":"qa123",
            "aisle":"456",
            "author":"Ximena"
        }
        """;

        // Crear libro
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .statusCode(200);

        // Consultarlo
        given()
                .queryParam("ID","qa123456")
                .when()
                .get("/Library/GetBook.php")
                .then()
                .statusCode(200);

    }
}