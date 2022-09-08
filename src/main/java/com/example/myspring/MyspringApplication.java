package com.example.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties
@ServletComponentScan
@SpringBootApplication
public class MyspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringApplication.class, args);
	}

}
