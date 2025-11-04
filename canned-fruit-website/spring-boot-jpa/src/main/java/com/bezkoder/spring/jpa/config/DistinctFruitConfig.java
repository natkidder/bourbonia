package com.bezkoder.spring.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration  //contains a @Bean method and is automatically a @Component
@Component
public class DistinctFruitConfig {

	@Bean
	public static String genDistinctFruitDestfile() {
		return "c:/Users/Computer/training/view_layer/product-list-app/src/assets/distinctFruits.json";
	}
	
}
