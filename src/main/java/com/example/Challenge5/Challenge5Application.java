package com.example.Challenge5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//command to run app in production mode
//java -jar target/Challenge5-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

@SpringBootApplication
public class Challenge5Application {

	public static void main(String[] args) {
        SpringApplication.run(Challenge5Application.class, args);
	}

}
