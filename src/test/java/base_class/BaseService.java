package base_class;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import  io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import test_class.AuthTest;

public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080/";
    private RequestSpecification requestSpecification;
    private static String token;

    public static void setToken(String tokenValue) {
        token = tokenValue;
    }

    public static String getToken() {
        return token;
    }

    public BaseService() {
        this.requestSpecification = given()
                .filter(new AllureRestAssured())
                .baseUri(BASE_URL)
                .contentType("application/json").header("Authorization","Bearer "+getToken());
    }

    protected Response postRequest(String endPoint, Object payload) {
        return requestSpecification
                .body(payload)
                .when()
                .post(endPoint);
    }

    protected Response getRequest(String endPoint) {
        return requestSpecification
                .when()
                .get(endPoint);
    }
}

