package com.llajournade.myreddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyredditApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyredditApplication.class, args);
	}

}
