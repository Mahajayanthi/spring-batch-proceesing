package com.example.dbtod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.example.dbtod.primary","com.example.dbtod.secondary","com.example.dbtod.batchconfig","com.example.dbtod.dbconfig"})
public class DbtodApplication {
	public static void main(String[] args) {
		SpringApplication.run(DbtodApplication.class, args);
	}
}
