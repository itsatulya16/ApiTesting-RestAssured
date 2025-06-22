package test_class;

import base_class.BaseService;
import io.restassured.response.Response;
import models.request.addObjects;
import models.request.data;
import models.response.addObjectsResponse;
import org.testng.annotations.Test;

public class postTest extends BaseService {
    @Test
    public void testPostRequest(){
        addObjects add = new addObjects("os system", new data("1849.99", "2025", "Intel Core i10", "1 TB"));
        Response response = hitPostRequest(add,"objects");
        validateResponseCode(response,200);
        System.out.println("Response Body dekh : "+ response.getBody().asPrettyString());
        validateResponseField(response, "name", "os system");
        validateSchema(response, "postObject.json");
        addObjectsResponse loginResponse = response.as(addObjectsResponse.class);
        System.out.println("Response object is : " + loginResponse.getId());
    }
}
