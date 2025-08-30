package com.sstudies.saranbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(
		scanBasePackages = {
				"com.sstudies.saranbank.config",     // your security/config
				"com.sstudies.saranbank.controller" // <-- whatever package your controllers are in
		})
public class SaranBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaranBankBackendApplication.class, args);
	}

}
