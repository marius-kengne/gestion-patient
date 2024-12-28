package com.example.hopital.gestion_patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hopital.gestion_patient")
public class GestionPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPatientApplication.class, args);
	}

}
