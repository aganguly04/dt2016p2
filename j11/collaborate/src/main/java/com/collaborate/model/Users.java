package com.collaborate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity

class Users implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name="userid")
	private int userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userPhone;
    @Transient
	private MultipartFile file;
	private String userPhoto;
	private String userHobby;
	private String userAddress;
	private String userLoction;
	private boolean enabled;

	
	
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}




	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}




	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}




	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}




	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}




	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}




	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}




	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}




	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}




	/**
	 * @return the userPhoto
	 */
	public String getUserPhoto() {
		return userPhoto;
	}




	/**
	 * @param userPhoto the userPhoto to set
	 */
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}




	/**
	 * @return the userHobby
	 */
	public String getUserHobby() {
		return userHobby;
	}




	/**
	 * @param userHobby the userHobby to set
	 */
	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}




	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}




	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}




	/**
	 * @return the userLoction
	 */
	public String getUserLoction() {
		return userLoction;
	}




	/**
	 * @param userLoction the userLoction to set
	 */
	public void setUserLoction(String userLoction) {
		this.userLoction = userLoction;
	}




	public Users()
	{
	}
	// parameterised constructor
	// getter setter
	// validation
}

 
