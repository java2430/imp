package com.vaesoft.imp.uim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.vaesoft.imp" })
public class UimApplication {

	public static void main(String[] args) {
		SpringApplication.run(UimApplication.class, args);
	}

}
