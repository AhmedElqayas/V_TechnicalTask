package http.requests;

import org.json.simple.JSONObject;
import org.junit.Test;
import utils.ExcelTestData;
import utils.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequest extends TestBase{



    @Test
    public void postTest() {

        given().
                spec(setRequestSpecs()).body(setBody()).
                when().post("posts").
                then().
                spec(setResponseSpecs(201)).and().
                assertThat().
                body("title", equalTo(body[0][0])).
                body("body", equalTo(body[0][1])).
                body("userId", equalTo(body[0][2])).
                body("id", equalTo(101));
    }

}
