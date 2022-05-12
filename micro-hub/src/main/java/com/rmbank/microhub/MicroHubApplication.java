package com.rmbank.microhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class MicroHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroHubApplication.class, args);
    }

}
