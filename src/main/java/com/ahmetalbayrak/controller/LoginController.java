/**
 * 
 */
package com.ahmetalbayrak.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmet
 *
 */
@Controller
@EnableAutoConfiguration
public class LoginController {
	
	@RequestMapping("/hello")	
	public String login(){
		System.out.println("Test logine girdi");
		return "Ahmet A";
	}
	/*
	public static void main(String[] args) throws Exception {
		System.out.println("App a girdi");
		SpringApplication.run(LoginController.class, args);
	}*/
}
