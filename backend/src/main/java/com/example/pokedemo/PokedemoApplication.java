package com.example.pokedemo;

import com.example.pokedemo.config.AppConfig;
import com.example.pokedemo.exception.ApiErrorHandler;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class PokedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedemoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		String rootUri = SpringContext.getBean(AppConfig.class).getBaseUrl();
		return builder
				.rootUri(rootUri)
				.errorHandler(new ApiErrorHandler())
				.build();
	}
}
