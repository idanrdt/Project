package com.project.hit.details;

import java.io.Serializable;

public class User extends Person implements Serializable{
	private String userName;
	private String password;
	private Boolean isManager=false;
	private Boolean reportSystem=false;
	private Boolean manageSupplierAccsess=false;
	private Boolean orderSystemAccsess=false;
	
	
	/**
	 * Constructor
	 * @param username-the users user name
 	 * @param password-the users password
	 * @param name- the users name
	 * @param address-the users address
	 * @param id-the users id
	 */
	public User(String username,String password,String name,String address,String id)
	{
		super(id,name,address);
	    this.userName=username;
	    this.password=password;
	}

	/**
	 * set the access to the manager panel
	 * @param access-true for allow access and false for remove access
	 */
	public void setManagerAccess(Boolean access) {
		this.isManager=access;
		
	}
	
	/**
	 *  check if there is an access to manager
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getManager() {
		return this.isManager;
		
	}
	/**
	 * set the access to the report system
	 * @param access-true for allow access and false for remove access
	 */
	public void setReportSystem(Boolean access) {
		this.reportSystem=access;
		
	}
	/**
	 *  check if there is an access to the report system
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getReportSystem() {
		return this.reportSystem;
		
	}
	
	/**
	 * set the access manage supplier
	 * @param access-true for allow access and false for remove access
	 */
	public void setManageSupplierAccsess(Boolean access) {
		this.manageSupplierAccsess=access;
		
	}
	/**
	 *  check if there is an access to the manager supplier
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getManageSupplierAccsess() {
		return this.manageSupplierAccsess;
		
	}
	/**
	 * set the access order system
	 * @param access-true for allow access and false for remove access
	 */
	public void setOrderSysteMaccsess(Boolean access) {
		this.orderSystemAccsess=access;
		
	}
	/**
	 * check if there is an access to the order system
	 * @return-true if there is  access and false if there is no access
	 */
	public boolean getOrderSystemAccsess() {
		return this.orderSystemAccsess;
		
	}
	/**
	 * set the users name
	 * @param name-the user name
	 */
	public void setUsername(String name ) {
		this.userName=name;
		
	}
	/**
	 * get the user name
	 * @return-the users user name
	 */
	public String getUserName()
	{
		return this.userName;
	}
	
	
	/**
	 * get the users password
	 * @return-users password
	 */
	public String getpassword()
	{
		return this.password;
		
	}
	
}
