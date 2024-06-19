import junit.framework.*;
import java.io.*;

public class TestObjectSandboxComposite extends TestCase {
	
    public static Test suite()  {
    	TestSuite testSuite = new TestSuite();
    	testSuite.addTestSuite(TestObjectSandbox.class);
    	testSuite.addTest(TestObjectSandboxSuite.suite());
    	return testSuite;
    }
}
