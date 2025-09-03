package com.bezkoder.spring.jpa.batch;

import org.springframework.batch.core.ItemReadListener;

import com.bezkoder.spring.jpa.model.Medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class SbjItemReadListener implements ItemReadListener<String> {
	  public static final Logger logger = LoggerFactory.getLogger(SbjItemReadListener.class);

	  @Override
	  public void beforeRead() {
	    System.out.println("Reading records");
	  }

	  public void afterRead(String input) {
	    logger.info("New Medium record read : " + input);
	  }

	  @Override
	  public void onReadError(Exception e) {
	    logger.error("Error in reading the person record : " + e);
	  }
}
