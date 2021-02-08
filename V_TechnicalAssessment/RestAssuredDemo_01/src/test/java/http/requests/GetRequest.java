package http.requests;

import org.junit.Test;
import utils.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest extends TestBase {

    @Test
    public void getTest() {
        given().
                spec(setRequestSpecs()).
                when().get("posts").
                then().
                spec(setResponseSpecs(200)).and().
                assertThat().
                body("size()", is(100));
    }
}
