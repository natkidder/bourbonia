/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestLargestDataFile extends TestCase {

  public TestLargestDataFile(String name) {
    super(name);
  }

  /* Run all the tests in testdata.txt (does not test
   * exception case). We'll get an error if any of the
   * file I/O goes wrong.
   * each line should have a space-delimited series of numbers, the largest of which should be first
   */

  public void testFromFile() throws Exception {

    String line;
    BufferedReader rdr = new BufferedReader(new FileReader("testdata.txt"));
    
    while ((line = rdr.readLine()) != null) {

      if (line.startsWith("#")) { // Ignore comments
        continue;
      }

      StringTokenizer st = new StringTokenizer(line);
      if (!st.hasMoreTokens()) {
        continue; // Blank line
      }

      // Get the expected value
      String val = st.nextToken();
      int expected = Integer.valueOf(val).intValue();
      //System.out.println("expected="+expected); /////

      // And the arguments to Largest
      ArrayList argument_list = new ArrayList();
      
      while (st.hasMoreTokens()) {
        argument_list.add(Integer.valueOf(st.nextToken()));
      }

      // Transfer object list into native array
      int[] arguments = new int[argument_list.size()];
      for (int i=0; i < argument_list.size(); i++) {
        arguments[i] = ((Integer)argument_list.
                        get(i)).intValue();
      }
      //System.out.println("expected="+expected+", largest="+Largest.largest(arguments)); ////

      // And run the assert
      assertEquals(expected, Largest.largest(arguments));
    }
  }
}
