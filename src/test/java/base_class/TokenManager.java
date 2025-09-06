package base_class;

import models.request.LoginRequest;
import models.response.LoginResponse;

public class TokenManager {

    private static String token;

    public static String getToken() {
        if (token == null) {
            AuthService authService = new AuthService();
            LoginRequest loginRequest = new LoginRequest("atul", "Destiny@8796");
            LoginResponse loginResponse = authService.login(loginRequest).as(LoginResponse.class);
            token = loginResponse.getToken();
        }
        return token;
    }
}
