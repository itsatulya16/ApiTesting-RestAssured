package base_class;

import io.restassured.response.Response;
import models.request.LoginRequest;

public class AuthService extends BaseService{
    private static final String BASE_PATH = "api/auth/";

    public Response login(Object payload) {
      return postRequest(BASE_PATH + "login", payload);
    }
    public Response forgetPass(Object payload){
        return postRequest(BASE_PATH + "forgot-password", payload);
    }

    public Response signUp(Object payload){
        return postRequest(BASE_PATH + "signup", payload);
    }
}
