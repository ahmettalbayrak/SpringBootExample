package com.ahmetalbayrak.service;

import java.util.List;

import com.ahmetalbayrak.model.User;

/**
 * @author Ahmet
 *
 */
public interface UserService<User> extends BaseService<User>{
	
	public List<User> getUsers();
            
    public void update(User entity, int id);
    
    public User findUserByEmail(String email);
    
    public User findUserByPassword(String password);
       
}
