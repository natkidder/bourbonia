import junit.framework.*;
import java.io.*;

public class TestObjectSandboxSuite extends TestCase {
	
	private ObjectSandbox os;
	
	protected void setUp()  {
		System.out.println("setting up");
	}
	
	protected void tearDown() {
		System.out.println("tearing down");
	}
	
	public TestObjectSandboxSuite(String thing)  {
		super(thing);
		os = new ObjectSandbox();
	}
	
	public void testNull_2()  {
		assertNull(os.setCal(false));
		assertNotNull(os.setCal(true));
	}
	
	public void testTrue_2()  {
		assertTrue(os.getDelay() < 5);
	}
	
	public void testFail_2()  {
		try {
			os.provokeException();
			fail("should have thrown an exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	
	public void assertEqualTolerance(double amt1, double amt2, double tolerance)  {
		assertEquals("outside of tolerance", Math.abs(amt1 - amt2), 0.0, tolerance);
	}
	
	public void testEqualTolerance()  {
		assertEqualTolerance(os.getDbl_1(), os.detDbl_2(), 0.00000001);
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new TestObjectSandboxSuite("testNull_2"));
		suite.addTest(new TestObjectSandboxSuite("testTrue_2"));
		suite.addTest(new TestObjectSandboxSuite("testFail_2"));
		suite.addTest(new TestObjectSandboxSuite("testEqualTolerance"));
		return suite;
	}

}
