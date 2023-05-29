package com.example.pazaSautiDb;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@ComponentScan("com.webservice")
@SpringBootApplication
public class PazaSautiDbApplication {

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setFieldMatchingEnabled(true).setAmbiguityIgnored(true);
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(PazaSautiDbApplication.class, args);
	}

}
