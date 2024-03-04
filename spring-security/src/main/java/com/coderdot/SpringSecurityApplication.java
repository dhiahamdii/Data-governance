package com.coderdot;

import com.coderdot.dto.EtatUser;
import com.coderdot.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class SpringSecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringSecurityApplication.class, args);

	}

}
