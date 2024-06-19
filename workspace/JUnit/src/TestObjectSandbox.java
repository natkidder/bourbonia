import junit.framework.*;
import java.io.*;

import javax.management.timer.Timer;

public class TestObjectSandbox extends TestCase {
	
	private ObjectSandbox os;
	
	public TestObjectSandbox(String thing)  {
		super(thing);
		os = new ObjectSandbox();
	}
	
	public void testNull()  {
		assertNull(os.setCal(false));
		assertNotNull(os.setCal(true));
	}
	
	public void testSame()  {
		os.sb1.append("this");
		assertSame(os.sb1, os.sb2);
		String str = "blue";
		String str2 = str;
		//str += "";
		assertSame(str, str2);
	}
	
	public void testEquals()  {
		assertEquals(1, os.getDayOfWeek());
	}
	
	public void testTrue()  {
		assertTrue(os.getDelay() < 5);
	}
	
	public void testFail()  {
		try {
			os.provokeException();
			fail("should have thrown an exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}

}
