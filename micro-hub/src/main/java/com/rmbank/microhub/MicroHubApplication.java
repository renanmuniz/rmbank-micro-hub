package com.rmbank.microhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
// @EnableSwagger2 FIXME Swagger nao esta deixando a aplicacao subir!
public class MicroHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroHubApplication.class, args);
	}

}
