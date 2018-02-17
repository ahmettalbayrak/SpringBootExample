/**
 * 
 */
package com.ahmetalbayrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmetalbayrak.model.Role;
import com.ahmetalbayrak.repository.RoleRepository;

/**
 * @author Ahmet
 *
 */
@Service("roleService")
//public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void delete(Long id) {
		roleRepository.delete(id);;
		
	}

	@Override
	public void save(Role entity) {
		roleRepository.save((Role)entity);		
	}
	

}
