package test_class;

import base_class.BaseService;
import base_class.TokenManager;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite
    public void beforeSuite() {
        String token = TokenManager.getToken();
        BaseService baseService = new BaseService();
        baseService.setToken(token);
        System.out.println("Token successfully set in BaseService");
    }
}
