package com.example.querydsl_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class QuerydslPracApplication {

	@PostConstruct
	public void setUp(){

	}
	public static void main(String[] args) {
		SpringApplication.run(QuerydslPracApplication.class, args);
	}

}
