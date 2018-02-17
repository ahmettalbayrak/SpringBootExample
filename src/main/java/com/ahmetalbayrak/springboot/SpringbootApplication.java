package com.ahmetalbayrak.springboot;

import org.aspectj.weaver.patterns.PerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmetalbayrak.controller.LoginController;
import com.ahmetalbayrak.model.Role;
import com.ahmetalbayrak.model.User;
import com.ahmetalbayrak.service.RoleService;
import com.ahmetalbayrak.service.UserService;

@SpringBootApplication
@RestController
@ComponentScan({"com.ahmetalbayrak.service"})
@EntityScan("com.ahmetalbayrak.model")
@EnableJpaRepositories("com.ahmetalbayrak.repository")
@EnableAutoConfiguration
public class SpringbootApplication extends SpringBootServletInitializer{

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService<User> userService;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LoginController.class);
	}

	
	public static void main(String[] args) {
		System.out.println("App a girdi");
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@RequestMapping("/")	
	public String login(){
		
		Role role = new Role();
		role.setRole("admin");
		roleService.save(role);
		
		
		User user = new User();
		user.setFirstName("Ahmet");
		user.setLastName("Albayrak");
		user.setPassword("123456");
		user.setEmail("ahmet@albayrak.com");
		user.setUser_role(role);
		userService.save(user);
		 
		
		
		return "Ahmet A";
	}
}
