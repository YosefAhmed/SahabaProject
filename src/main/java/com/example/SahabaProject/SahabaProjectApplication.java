package com.example.SahabaProject;

import com.example.SahabaProject.models.Sahabi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@EntityScan(basePackages = "com.example.SahabaProject.models")
public class SahabaProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SahabaProjectApplication.class, args);
	}

}
