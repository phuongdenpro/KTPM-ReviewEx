package com.example.resilience4jretryratelimitercircuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Resilience4jRetryRatelimiterCircuitbreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jRetryRatelimiterCircuitbreakerApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
