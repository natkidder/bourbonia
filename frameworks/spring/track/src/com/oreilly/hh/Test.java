package com.oreilly.hh;

import org.springframework.transaction.annotation.Transactional;

/**
* A common interface for our sample classes;  We'll need this because TestHarness needs to cast CreateTest, QueryTest or AlbumTest to a 
* common interface after it retrieves the bean from the Spring application context.
*/

public interface Test {
	/**
	* Runs a simple example
	*/
	@Transactional(readOnly=false)
	public void run();
}
