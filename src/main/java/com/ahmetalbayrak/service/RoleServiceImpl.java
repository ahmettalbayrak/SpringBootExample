/**
 * 
 */
package com.ahmetalbayrak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmetalbayrak.model.Role;
import com.ahmetalbayrak.repository.RoleRepository;

/**
 * @author Ahmet
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void delete(int id) {
		roleRepository.delete(id);
		
	}

	@Override
	public void save(Role entity) {
		roleRepository.save((Role)entity);		
	}
	

}
