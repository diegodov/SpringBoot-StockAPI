package com.diegodov.Stockify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class StockifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockifyApplication.class, args);
	}

}
