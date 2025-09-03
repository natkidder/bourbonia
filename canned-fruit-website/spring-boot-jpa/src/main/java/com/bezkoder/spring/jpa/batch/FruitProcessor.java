package com.bezkoder.spring.jpa.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FruitProcessor implements ItemProcessor<String,String> {

	@Override
	public String process(String item) {
		System.out.println("FruitProcessor.process: item="+item); ///////
		if (item == null || item.isEmpty()) {
			return item;
		}
		return item.substring(0, 1).toUpperCase() + item.substring(1);
	}

}
