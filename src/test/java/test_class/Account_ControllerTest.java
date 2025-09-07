package test_class;

import base_class.AccountContollerService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ResponseLogger;


public class Account_ControllerTest extends TestBase {

    @Test
    public void verifyGetUserApiTest(){
        System.out.println("Get User API Test");
        AccountContollerService accountContollerService = new AccountContollerService();
        Response response = accountContollerService.getUser();
        ResponseLogger.logIfFailed(response);
        Assert.assertTrue(response.getStatusCode()==200);

    }
}
