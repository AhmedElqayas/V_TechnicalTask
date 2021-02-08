package http.requests;

import org.junit.Test;
import utils.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetByIdRequest extends TestBase {



    @Test
    public void getByIdTest() {



        given().
                spec(setRequestSpecs()).
                when().get("posts/35").
                then().
                spec(setResponseSpecs(200)).and().
                assertThat().
                body("userId", equalTo(4)).
                body("id", equalTo(35)).
                body("title", equalTo(title)).
                body("body", equalTo(bodyAttribute));
    }
}
