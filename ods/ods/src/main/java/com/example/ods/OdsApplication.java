package com.example.ods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages= {"com.example.ods.primary","com.example.ods.secondary","com.example.ods.batchconfig","com.example.ods.dbconfig","com.example.ods.teritary","com.example.ods.batchconfigstep1"})
public class OdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdsApplication.class, args);
	}

}
