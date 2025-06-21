package test_class;

import base_class.BaseService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTest extends BaseService {
    @Test
    public void testGetAPI(){
       Response response = hitGetRequest("objects/7");
       validateResponseCode(response, 200);
       System.out.println("response body is :"+ response.getBody().asString());
       validateSchema(response, "getObject.json");

    }
}
