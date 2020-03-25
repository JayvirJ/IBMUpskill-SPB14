package com.training.bean;

public class StRegisterBean {

	private String firstName;
	private String lastName;
	private String eMail;
	private String userName;
	private String pass;
	private String confPass;
	private String phone;
	private String language;
	

	public StRegisterBean() {
	}

	public StRegisterBean(String firstName, String lastName, String eMail, String userName, String pass, String confPass, String phone, String language) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.userName = userName;
		this.pass = pass;
		this.confPass = confPass;
		this.phone = phone;
		this.language = language;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return eMail;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	public String getConfirmPassword() {
		return confPass;
	}

	public void setConfirmPassword(String confPass) {
		this.confPass = confPass;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "StRegisterBean [firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail + ", userName=" + userName + ", pass=" + pass + ", confPass=" + confPass + ", language=" + language + "]";
	}
}
