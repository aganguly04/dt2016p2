package com.collaborate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class UserRoles  implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name="roleid")
	private int roleId;
	private String userName;
	private String roleName;
	

	
	
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}




	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}




	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}




	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}




	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}




	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}




	public UserRoles()
	{
	}
	// parameterised constructor
	// getter setter
	
}

 