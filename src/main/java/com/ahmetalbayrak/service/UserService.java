package com.ahmetalbayrak.service;

import java.util.List;

/**
 * @author Ahmet
 *
 */
public interface UserService<User> extends BaseService<User>{
	
	public List<User> getTable(User entity);
            
    public void update(User entity, int id);
    
    public User findUserByEmail(String email);
}
