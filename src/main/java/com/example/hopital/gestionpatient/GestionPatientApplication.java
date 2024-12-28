package com.example.hopital.gestionpatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hopital")
public class GestionPatientApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionPatientApplication.class, args);
	}

}
