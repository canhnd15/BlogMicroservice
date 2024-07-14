package com.davidblog.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneralApplication.class, args);
	}

}
