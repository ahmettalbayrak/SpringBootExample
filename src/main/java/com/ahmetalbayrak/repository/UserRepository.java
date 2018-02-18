/**
 * 
 */
package com.ahmetalbayrak.repository;


import org.springframework.stereotype.Repository;

import com.ahmetalbayrak.model.User;

/**
 * @author Ahmet
 *
 */
@Repository("userRepository")
public interface UserRepository extends BaseRepository<User, Long>{

	User findByEmail(String email);	
	User findByPassword(String password);	
}
