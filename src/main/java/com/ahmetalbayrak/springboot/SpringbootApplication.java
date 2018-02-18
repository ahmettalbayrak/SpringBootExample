package com.ahmetalbayrak.springboot;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ahmetalbayrak.controller.HomeController;
import com.ahmetalbayrak.model.Books;
import com.ahmetalbayrak.model.User;
import com.ahmetalbayrak.model.UserBook;
import com.ahmetalbayrak.service.BooksService;
import com.ahmetalbayrak.service.UserService;

@SpringBootApplication
@RestController
@ComponentScan({"com.ahmetalbayrak.service"})
@EntityScan("com.ahmetalbayrak.model")
@EnableJpaRepositories("com.ahmetalbayrak.repository")
@EnableAutoConfiguration
public class SpringbootApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HomeController.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	
}
