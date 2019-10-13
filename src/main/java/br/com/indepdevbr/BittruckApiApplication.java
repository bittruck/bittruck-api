package br.com.indepdevbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BittruckApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BittruckApiApplication.class, args);
	}

}
