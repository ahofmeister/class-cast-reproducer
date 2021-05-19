import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class TestCase {

    @Test
    public void test() {
        given().contentType(ContentType.JSON).body("  {\n" +
                "       \"containerId\": \"9f465367-aee1-4b1f-9a55-ce87b1cfb567\"\n" +
                "     }\n").post("records").prettyPrint();

    }

}
