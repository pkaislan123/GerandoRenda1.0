package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
public class GerandoRendaApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GerandoRendaApiApplication.class, args);
		System.out.println("Servidor online");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return (PasswordEncoder) encoder;
	}
}
