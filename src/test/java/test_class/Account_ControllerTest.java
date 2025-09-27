package test_class;

import base_class.AccountContollerService;
import io.restassured.response.Response;
import models.request.CreateAccReq;
import models.response.CreateAccRes;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ResponseLogger;


public class Account_ControllerTest extends TestBase {

    @Test
    public void verifyGetUserApiTest(){
        AccountContollerService accountContollerService = new AccountContollerService();
        Response response = accountContollerService.getUser();
        ResponseLogger.logIfFailed(response);
        Assert.assertTrue(response.getStatusCode()==200);

    }

    @Test
    public void createAccount(){
        CreateAccReq createAccReq = new CreateAccReq("SALARY", "NORTH");
        AccountContollerService accountContollerService = new AccountContollerService();
        Response response = accountContollerService.createAccount(createAccReq);
        System.out.println(response.prettyPrint());
        CreateAccRes createAccRes = response.as(CreateAccRes.class);
        Assert.assertEquals(200, response.getStatusCode());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("SALARY", createAccRes.getAccountType());
        softAssert.assertEquals("NORTH", createAccRes.getBranch());
        softAssert.assertEquals("atul ambade", createAccRes.getOwnerName());

    }
}
