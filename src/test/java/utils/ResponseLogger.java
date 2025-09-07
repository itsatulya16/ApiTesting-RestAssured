package utils;

import io.restassured.response.Response;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;


public class ResponseLogger {

    private static final Logger logger = getLogger(ResponseLogger.class);

    public static void logIfFailed(Response response){
        if (response.getStatusCode() != 200){
            logger.error("api failed status code: {}, response: {}", response.getStatusCode(), response.print());
        }
    }
}
