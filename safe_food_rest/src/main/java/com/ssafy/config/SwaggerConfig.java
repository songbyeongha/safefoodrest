package com.ssafy.config;	

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket getApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("HRM api")
				.apiInfo(apiInfo()).select().paths(PathSelectors.ant("/api/**")).build();
	}
	
	public ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("HRM API")
				.description("HRM API reference for developer").version("1.0").build();
	}
}
