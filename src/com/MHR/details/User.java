package com.MHR.details;

public class User extends Person{
	private String username;
	private String password;
	private Boolean ismanager=false;
	private Boolean reportsystem=false;
	private Boolean managesupplieraccsess=false;
	private Boolean ordersystemaccsess=false;
	
	
	/**
	 * Constructor
	 * @param username-the users user name
 	 * @param password-the users password
	 * @param name- the users name
	 * @param address-the users address
	 * @param id-the use id
	 */
	public User(String username,String password,String name,String address,int id) {
		this.id=id;
		this.address=address;
		this.name=name;
	    this.username=username;
	    this.password=password;
	}

	/**
	 * set the access to the manager panel
	 * @param access-true for allow access and false for remove access
	 */
	public void setManagerAccess(Boolean access) {
		this.ismanager=access;
		
	}
	
	/**
	 * to check if there is an access to manager
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getManager() {
		return this.ismanager;
		
	}
	/**
	 * set the access to the report system
	 * @param access-true for allow access and false for remove access
	 */
	public void setreportsystem(Boolean access) {
		this.reportsystem=access;
		
	}
	/**
	 * to check if there is an access to the report system
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getreportsystem() {
		return this.reportsystem;
		
	}
	
	/**
	 * set the access manage supplier
	 * @param access-true for allow access and false for remove access
	 */
	public void setmanagesupplieraccsess(Boolean access) {
		this.managesupplieraccsess=access;
		
	}
	/**
	 * to check if there is an access to the manager supplier
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getmanagesupplieraccsess() {
		return this.managesupplieraccsess;
		
	}
	/**
	 * set the access order system
	 * @param access-true for allow access and false for remove access
	 */
	public void setordersystemaccsess(Boolean access) {
		this.ordersystemaccsess=access;
		
	}
	/**
	 * to check if there is an access to the order system
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getordersystemaccsess() {
		return this.ordersystemaccsess;
		
	}
	/**
	 * set the users name
	 * @param name-the user name
	 */
	public void setusername(String name ) {
		this.username=name;
		
	}
	
	
}
