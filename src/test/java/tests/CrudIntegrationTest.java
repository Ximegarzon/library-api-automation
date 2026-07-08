package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CrudIntegrationTest extends BaseTest {

    @Test
    public void crudFlow() {

        String body = """
        {
            "name":"API Automation Book",
            "isbn":"ximena",
            "aisle":"001",
            "author":"Ximena Espinosa"
        }
        """;

        // Agregar libro
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Library/Addbook.php")
                .then()
                .statusCode(200);

        // Consultar libro
        given()
                .queryParam("ID", "ximena001")
                .when()
                .get("/Library/GetBook.php")
                .then()
                .statusCode(200);

        // Eliminar libro
        String deleteBody = """
        {
            "ID":"ximena001"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(deleteBody)
                .when()
                .post("/Library/DeleteBook.php")
                .then()
                .statusCode(200);
    }
}