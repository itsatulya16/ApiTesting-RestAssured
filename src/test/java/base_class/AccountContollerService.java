package base_class;

import io.restassured.response.Response;

public class AccountContollerService extends BaseService {

    private static final String BASE_PATH = "api/accounts/";

    public Response getUser() {
        return getRequest(BASE_PATH + "user");
    }

}
