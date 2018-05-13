package com.vaesoft.imp.uim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "com.vaesoft.imp" })
@EnableTransactionManagement
@EnableSwagger2
public class UimApplication {

	public static void main(String[] args) {
		SpringApplication.run(UimApplication.class, args);
	}

}
