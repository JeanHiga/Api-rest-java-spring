package com.spring.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@EnableCaching
@SpringBootApplication
public class CrudUsersApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudUsersApplication.class, args);

	}

}
