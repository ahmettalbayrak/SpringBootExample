/**
 * 
 */
package com.ahmetalbayrak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ahmet
 *
 */
@Entity
@Table(name = "roles")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="roleId")
	private int roleId;
	@Column(name="role")
	private String role;
	
	public int getRole_id() {
		return roleId;
	}
	public void setRole_id(int role_id) {
		this.roleId = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}
