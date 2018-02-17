/**
 * 
 */
package com.ahmetalbayrak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmetalbayrak.model.User;
import com.ahmetalbayrak.repository.UserRepository;

/**
 * @author Ahmet
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService<User>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User entity) {
		userRepository.save(entity);
		
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
		
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void update(User entity, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByEmail(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email, password);
	}

	
	
	

}
