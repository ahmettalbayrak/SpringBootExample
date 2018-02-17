package com.ahmetalbayrak.springboot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ahmetalbayrak.controller.LoginController;
import com.ahmetalbayrak.model.Books;
import com.ahmetalbayrak.model.Role;
import com.ahmetalbayrak.model.User;
import com.ahmetalbayrak.service.BooksService;
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
	private UserService userService;
	@Autowired 
	private BooksService bookService;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LoginController.class);
	}

	
	public static void main(String[] args) {
		System.out.println("App a girdi");
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView createNewUser() {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView homePage(){
		
		Role role = new Role();
		role.setRole("admin");
		roleService.save(role);
		
		Role role2 = new Role();
		role.setRole("use");
		roleService.save(role2);
		
		Set<Role> setRole = new HashSet<Role>();
		setRole.add(role);
		setRole.add(role2);
		
		User user = new User();
		user.setFirstName("Ahmet");
		user.setLastName("Albayrak");
		user.setPassword("123456");
		user.setEmail("ahmet@albayrak.com");
		user.setUser_role(setRole);
		userService.save(user);
		
		User user2 = new User();
		List<User> arrList = new ArrayList<User>();
		//userService.findUserByEmail("ahmet@albayrak.com","123456");
	
		System.out.println(user2.getFirstName());
		
		/*
		for(int i=0;i<=arrList.size();i++) {
			System.out.println(arrList.get(i).getFirstName());
			System.out.println(arrList.get(i).getLastName());
			System.out.println(arrList.get(i).getEmail());
			break;	
		}
		
		Books book = new Books();
		book.setBookName("Kürk Mantolu Madonna");
		bookService.save(book);*/
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
