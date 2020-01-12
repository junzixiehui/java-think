package com.junzixiehui.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication(scanBasePackages = {"com"})
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@RestController
	public class ApiController {

		@PostMapping("/ping")
		public String ping(HttpServletRequest request) {
			return "pong";
		}
	}
}
