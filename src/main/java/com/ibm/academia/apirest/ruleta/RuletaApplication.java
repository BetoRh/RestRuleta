package com.ibm.academia.apirest.ruleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RuletaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuletaApplication.class, args);
	}

}
