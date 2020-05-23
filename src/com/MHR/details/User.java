package com.MHR.details;

public class User extends Person{
	private String username;
	private String password;
	private Boolean ismanager=false;
	private Boolean reportsystem=false;
	private Boolean managesupplieraccsess=false;
	private Boolean ordersystemaccsess=false;
	
	
	
	public User(String username,String password,String name,String address,int id) {
		this.id=id;
		this.address=address;
		this.name=name;
	    this.username=username;
	    this.password=password;
	}

	
	public void setManagerAccess(Boolean access) {
		this.ismanager=access;
		
	}
	public boolean getManager() {
		return this.ismanager;
		
	}
	
	
}
