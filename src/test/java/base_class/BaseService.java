package base_class;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import  io.restassured.specification.RequestSpecification;
import models.request.addObjects;
import org.testng.Assert;

public class BaseService {
    private static final String BASE_URL = "https://api.restful-api.dev/";

    public Response hitGetRequest(String endPoint){
        Response response = given().when().get(BASE_URL + endPoint);
        return response;
    }

    public Response hitPostRequest(Object payload, String endPoint){
        Response response = given().contentType("application/json").body(payload).when().post(BASE_URL+endPoint);
        return response;
    }

    public void validateResponseCode(Response response, int statusCode){
        Assert.assertEquals(response.getStatusCode(), statusCode, "status code is not correct");
    }

    public void validateResponseField(Response response, String path, String expectedValue){
        JsonPath js = new JsonPath(response.getBody().asString());
        Assert.assertEquals(js.getString(path), expectedValue, "response String is wrong");
    }
    public void validateSchema(Response response, String schemaFilePath) {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath(schemaFilePath));
    }
}

