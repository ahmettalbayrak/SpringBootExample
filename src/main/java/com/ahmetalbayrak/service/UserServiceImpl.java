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
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getTable(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
