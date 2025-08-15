package test_class;

import base_class.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {

    @Test
    public void loginTest() {
        AuthService authService = new AuthService();
        Response response = authService.login("{\"username\":\"atul\",\"password\":\"Destiny@8796\"}");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response Body: " + response.prettyPrint());


    }

}
