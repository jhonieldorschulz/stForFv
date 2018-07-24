package br.com.ultra.stforfv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.ultra.stforfv")
@EntityScan("br.com.ultra.stforfv")
public class StforfvApplication {

	public static void main(String[] args) {
		SpringApplication.run(StforfvApplication.class, args);
	}
}
