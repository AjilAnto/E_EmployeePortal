package utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LoggerManager {

    void print(String loggerMessage);

    static void errorLogger (String loggerMessage, Object className) {
        final Logger logger = LoggerFactory.getLogger(String.valueOf(className));
         logger.error("error occurred:: {}", loggerMessage);
    }

    static void infoLogger (String loggerMessage, Object className) {
        final Logger logger = LoggerFactory.getLogger(String.valueOf(className));
        logger.info("info message:: {}", loggerMessage);
    }
}
