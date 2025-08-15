package base_class;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import  io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080/";
    private RequestSpecification requestSpecification;

    public BaseService() {
        this.requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(String endPoint, Object payload) {
        return requestSpecification.contentType("application/json")
                .body(payload)
                .when()
                .post(endPoint);
    }

//    public Response hitGetRequest(String endPoint){
//        Response response = given().when().get(BASE_URL + endPoint);
//        return response;
//    }
//
//    public Response hitPostRequest(Object payload, String endPoint){
//        Response response = given().contentType("application/json").body(payload).when().post(BASE_URL+endPoint);
//        return response;
//    }
//
//    public void validateResponseCode(Response response, int statusCode){
//        Assert.assertEquals(response.getStatusCode(), statusCode, "status code is not correct");
//    }
//
//    public void validateResponseField(Response response, String path, String expectedValue){
//        JsonPath js = new JsonPath(response.getBody().asString());
//        Assert.assertEquals(js.getString(path), expectedValue, "response String is wrong");
//    }
//    public void validateSchema(Response response, String schemaFilePath) {
//        response.then().assertThat()
//                .body(matchesJsonSchemaInClasspath(schemaFilePath));
//    }
}

