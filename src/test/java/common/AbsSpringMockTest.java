package common;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.TestContextManager;

/**
 * Created by Yuleen on 2016/12/25.
 */
public abstract class AbsSpringMockTest {
    @Before
    public void setUpContext() throws Exception {
        TestContextManager testContextManager;
        testContextManager = new TestContextManager(getClass());
        testContextManager.prepareTestInstance(this);
        MockitoAnnotations.initMocks(this);
    }
}
