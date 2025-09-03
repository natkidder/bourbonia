package com.bezkoder.spring.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class MediumConfig {
	
	@Primary
	@Bean
	public static String genMediumDestfile() {
		return "c:/Users/Computer/training/view_layer/product-list-app/src/assets/mediums.json";
	}
	
	
}
