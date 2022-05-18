package com.cebem.transformatolotu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class TransformatolotuApplicationTests {

	@Bean
	public RestTemplate getresttemplate(){
		return new RestTemplate();
	}


	@Test
	void contextLoads() {
	}

}
