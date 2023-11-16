package TestApiBookStore;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestApiAccountBookStore {
    @Test
    public void testApiAccount() {
        RestAssured.baseURI = "https://demoqa.com/";
                 RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"userName\": \"muravlova90\",\n" +
                        "  \"password\": \"K12345k&\"\n" +
                        "}")
                .when()
                .post("/Account/v1/Authorized").then().log().all().assertThat().statusCode(200);
    }
}