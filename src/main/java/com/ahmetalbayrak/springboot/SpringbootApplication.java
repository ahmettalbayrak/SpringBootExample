package com.ahmetalbayrak.springboot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

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
import org.springframework.validation.BindingResult;
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
	private UserService<User> userService;
	@Autowired 
	private BooksService bookService;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LoginController.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid User user, BindingResult bindingResult) {
		User email = new User();
		User pass = new User();
		email=userService.findUserByEmail(user.getEmail());
		pass=userService.findUserByPassword(user.getPassword());
		loginControl(email, pass);		
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid User formUser, BindingResult bindingResult) {
		User user = new User();
		user.setEmail(formUser.getEmail());
		user.setFirstName(formUser.getFirstName());
		user.setLastName(formUser.getLastName());
		user.setPassword(formUser.getPassword());
		if(user!=null) {
			userService.save(user);
			modelAndView.setViewName("login");
			return modelAndView;
		}
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(){
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView homePage(){
		//testData();
		
		if(modelAndView.getModel().containsKey("user") == true ) {
			modelAndView.setViewName("book");
		}else {
			modelAndView.setViewName("index");
		}
		
		return modelAndView;
	}
	
	void testData() {
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
		user.setPassword("1");
		user.setEmail("ahmet@albayrak.com");
		//user.setUser_role(setRole);
		userService.save(user);
		
	
		
		Books book = new Books();
		book.setBookName("Kürk Mantolu Madonna");
		bookService.save(book);
	}
	void loginControl(User email, User pass) {
		if(email == pass && email!=null) {
			modelAndView.addObject("successMessage", "Giriş Başarılı");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("book");
		}else {		
			modelAndView.addObject("errorMessage", "Kullanıcı adı veya şifre Başarısız");
			modelAndView.setViewName("registration");
		}
	}	
}
