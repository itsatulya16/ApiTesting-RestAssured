package base_class;

import io.restassured.response.Response;

public class AuthService extends BaseService{
    private static final String BASE_PATH = "api/auth/";

    public Response login(String payload) {
      return postRequest(BASE_PATH + "login", payload);


    }
}
