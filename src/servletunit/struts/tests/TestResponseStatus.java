package servletunit.struts.tests;

import servletunit.struts.MockStrutsTestCase;
import servletunit.HttpServletResponseSimulator;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by IntelliJ IDEA.
 * User: deryl
 * Date: May 20, 2003
 * Time: 5:16:57 PM
 * To change this template use Options | File Templates.
 */
public class TestResponseStatus extends MockStrutsTestCase {

    public TestResponseStatus(String testName) {
        super(testName);
    }

    public void setUp() throws Exception {
        super.setUp();
        setServletConfigFile("/WEB-INF/web.xml");
    }

    public void testResponseCode() {
        setRequestPathInfo("/badActionPath");
        try {
            actionPerform();
        } catch (AssertionFailedError afe) {
            int statusCode = ((HttpServletResponseSimulator) getResponse()).getStatusCode();
            // todo: backwards compatible with struts 1.1
            assertTrue(statusCode == 404 || statusCode == 400, "unexpected response code");
            return;
        }
        fail("expected some error code!");

    }


}
