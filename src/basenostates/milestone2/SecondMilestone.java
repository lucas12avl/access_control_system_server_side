package basenostates.milestone2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondMilestone {
    private static Logger logger = LoggerFactory.getLogger(SecondMilestone.class);

    public static void fun() {
        logger.info("This is a Info message");
        logger.debug("This is a Debug message");
        logger.warn("This is a Warn message");
        logger.error("This is an Error message");
    }

}
