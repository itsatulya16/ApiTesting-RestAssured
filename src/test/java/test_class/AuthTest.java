package test_class;

import base_class.AuthService;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.request.ForgetPasswordReq;
import models.request.LoginRequest;
import models.response.ForgetPasswordRes;
import models.response.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ResponseLogger;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})

public class AuthTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthTest.class);

    @Test(testName = "Login Test with valid credentials", description = "This test validates the login functionality")
    public void loginTestWithValidCreds() {
        Allure.step("hit login request");
        LoginRequest loginRequest = new LoginRequest("atul", "Destiny@8796");
        AuthService authService = new AuthService();
        logger.info("Sending login request for user: {}", loginRequest.getUsername());
        Response response = authService.login(loginRequest);
        Allure.step("validate response code is 200");
        Assert.assertEquals(response.getStatusCode(), 200);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        ResponseLogger.logIfFailed(response);
        String token = loginResponse.getToken();
        Allure.step("validate token is not null");
        Assert.assertNotNull(token, "Token is null in the response");
        logger.info("Login test completed successfully ✅");
    }

    @Test
    public void loginTestWithInvalidCreds() {
        LoginRequest loginRequest = new LoginRequest("invalidUser", "invalidPass");
        AuthService authService = new AuthService();
        logger.info("Sending login request with invalid credentials");
        Response response = authService.login(loginRequest);
        Assert.assertEquals(response.getStatusCode(), 401);
        Assert.assertTrue(response.getBody().asString().contains("Invalid Credentials"), "Expected 'Unauthorized' message not found in the response");
        JsonPath js = new JsonPath(response.getBody().asString());
        Assert.assertEquals(js.getString("message"), "The username or password you entered is incorrect", "Error message is not correct");
        Assert.assertEquals(js.getString("solution"), "Please check your credentials and try again", "Solution message is not correct");
        logger.info("Login test invalid credentials completed successfully ✅");
    }

    @Test
    public void verifyForgetPassword() {
        ForgetPasswordReq forgetPasswordReq = new ForgetPasswordReq("atul@gamil.com");
        AuthService authService = new AuthService();
        logger.info("Sending forget password request for email: {}", forgetPasswordReq.getEmail());
        Response response = authService.forgetPass(forgetPasswordReq);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "status code is not correct");
        ResponseLogger.logIfFailed(response);
        ForgetPasswordRes forgetPasswordRes = response.as(ForgetPasswordRes.class);
        softAssert.assertTrue(forgetPasswordRes.getMessage().equals("If your email exists in our system, you will receive reset instructions."),
                "message is not same as per expected");
        softAssert.assertAll();
        logger.info("Forget password test completed successfully ✅");

    }
}
