package com.mkyong.core;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        if(logger.isDebugEnabled()){
        	logger.debug("Testing");
        }
    
    }
}
