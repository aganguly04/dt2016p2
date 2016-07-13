package com.collaborate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Friend implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String userOne;
	private String userTwo;
	public Friend()
	{
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userOne
	 */
	public String getUserOne() {
		return userOne;
	}
	/**
	 * @param userOne the userOne to set
	 */
	public void setUserOne(String userOne) {
		this.userOne = userOne;
	}
	/**
	 * @return the userTwo
	 */
	public String getUserTwo() {
		return userTwo;
	}
	/**
	 * @param userTwo the userTwo to set
	 */
	public void setUserTwo(String userTwo) {
		this.userTwo = userTwo;
	}
	
	
	
}
