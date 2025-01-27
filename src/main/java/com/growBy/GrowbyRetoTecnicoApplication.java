package com.growBy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.growBy"})
public class GrowbyRetoTecnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowbyRetoTecnicoApplication.class, args);
	}

}
