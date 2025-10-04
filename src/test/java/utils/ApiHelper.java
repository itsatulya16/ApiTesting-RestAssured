package utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Random;

public class ApiHelper {
    public static String generateRandomUserName(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static String generateRandomMobileNumber(){
        String number = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(number.length());
            sb.append(number.charAt(index));
        }
        return sb.toString();
    }

    public static void validateStatusCode(Response response, int expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "status code not matched, actua status code is "+ response.getStatusCode());
    }
}
