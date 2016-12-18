package task4;

import org.slf4j.*;

/**
 * Created by Yuleen on 2016/12/17.
 */
public class LogTest {
    private static final Logger LOG1 = LoggerFactory.getLogger("dailyFile");
    private static final Logger LOG2 = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        LOG1.info("hello1");
        LOG2.debug("hello2");
    }
}
