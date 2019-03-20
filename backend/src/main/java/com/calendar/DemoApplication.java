package com.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration

@RestController
@SpringBootApplication
public class DemoApplication {


	//@RequestMapping("/hello")
	//public String index(){
	//	return "Hello World";
	//}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
