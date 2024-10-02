package com.koyote.kollie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class KollieApplication {

	public static void main(String[] args) {
		SpringApplication.run(KollieApplication.class, args);
	}

}
