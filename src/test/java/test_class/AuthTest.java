package test_class;

import base_class.AuthService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.request.ForgetPasswordReq;
import models.request.LoginRequest;
import models.response.ForgetPasswordRes;
import models.response.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthTest {

    @Test(testName = "Login Test with valid credentials", description = "This test validates the login functionality")
    public void loginTestWithValidCreds() {
        LoginRequest loginRequest = new LoginRequest("atul", "Destiny@8796");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.prettyPrint());
        String token = loginResponse.getToken();
        Assert.assertNotNull(token, "Token is null in the response");
    }

    @Test
    public void loginTestWithInvalidCreds() {
        LoginRequest loginRequest = new LoginRequest("invalidUser", "invalidPass");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        Assert.assertEquals(response.getStatusCode(), 401);
        System.out.println(response.prettyPrint());
        Assert.assertTrue(response.getBody().asString().contains("Invalid Credentials"), "Expected 'Unauthorized' message not found in the response");
        JsonPath js = new JsonPath(response.getBody().asString());
        Assert.assertEquals(js.getString("message"), "The username or password you entered is incorrect", "Error message is not correct");
        Assert.assertEquals(js.getString("solution"), "Please check your credentials and try again", "Solution message is not correct");
    }

    @Test
    public void verifyForgetPassword() {
        ForgetPasswordReq forgetPasswordReq = new ForgetPasswordReq("atul@gamil.com");
        AuthService authService = new AuthService();
        Response response = authService.forgetPass(forgetPasswordReq);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(response.getStatusCode() == 200, "request failed and showing status code " + response.getStatusCode());
        System.out.println(response.prettyPrint());
        ForgetPasswordRes forgetPasswordRes = response.as(ForgetPasswordRes.class);
        softAssert.assertTrue(forgetPasswordRes.getMessage().equals("If your email exists in our system, you will receive reset instructions."),
                "message is not same as per expected");
        softAssert.assertAll();

    }
}
