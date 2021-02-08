package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;

import static org.hamcrest.CoreMatchers.hasItems;

public class TestBase {

    private RequestSpecification requestSpecs;
    private ResponseSpecification responseSpecs;

    private String url ="https://jsonplaceholder.typicode.com/";
    private String header1Name = "Content-Type";
    private String header1Value = "application/json";

    protected String bodyAttribute = "nisi error delectus possimus ut eligendi vitae\nplaceat eos harum cupiditate facilis reprehenderit voluptatem beatae\nmodi ducimus quo illum voluptas eligendi\net nobis quia fugit";
    protected String title = "id nihil consequatur molestias animi provident";

    protected String[][] body = ExcelTestData.collectData("body");


    public RequestSpecification setRequestSpecs() {
        if(url != null) {
            requestSpecs = new RequestSpecBuilder().setBaseUri(url).
                    addHeader(header1Name, header1Value).build();
        }
        else
            System.out.println("Invalid URL");

        return requestSpecs;
    }

    public ResponseSpecification setResponseSpecs(int statusCode){
        responseSpecs = new ResponseSpecBuilder().expectStatusCode(statusCode).build();

        return responseSpecs;
    }

    public ResponseSpecification setResponseSpecs(int statusCode, String path){
         responseSpecs = new ResponseSpecBuilder().expectStatusCode(statusCode).
                 expectBody(path, hasItems()).build();

         return responseSpecs;
    }

    public String setBody(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", body[0][0]);
        requestBody.put("body", body[0][1]);
        requestBody.put("userId", body[0][2]);

        return requestBody.toJSONString();
    }




}
