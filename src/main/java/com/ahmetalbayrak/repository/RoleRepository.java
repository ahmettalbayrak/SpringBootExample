/**
 * 
 */
package com.ahmetalbayrak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmetalbayrak.model.Role;

/**
 * @author Ahmet
 *
 */
@Repository("roleRepository")
public interface RoleRepository extends BaseRepository<Role, Long>{

}
