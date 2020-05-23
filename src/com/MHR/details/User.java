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
	
	public void setreportsystem(Boolean access) {
		this.reportsystem=access;
		
	}
	public boolean getreportsystem() {
		return this.reportsystem;
		
	}
	
	
	public void setmanagesupplieraccsess(Boolean access) {
		this.managesupplieraccsess=access;
		
	}
	public boolean getmanagesupplieraccsess() {
		return this.managesupplieraccsess;
		
	}
	
	public void setordersystemaccsess(Boolean access) {
		this.ordersystemaccsess=access;
		
	}
	public boolean getordersystemaccsess() {
		return this.ordersystemaccsess;
		
	}
	
	public void setusername(String name ) {
		this.username=name;
		
	}
	
	
}
