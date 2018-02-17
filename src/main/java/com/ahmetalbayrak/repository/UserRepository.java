/**
 * 
 */
package com.ahmetalbayrak.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ahmetalbayrak.model.User;

/**
 * @author Ahmet
 *
 */
@Repository("userRepository")
public interface UserRepository extends BaseRepository<User, Long>{

	User findUserByEmail(String email,String password);
}
