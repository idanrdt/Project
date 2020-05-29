package com.project.hit.details;

import java.io.Serializable;

public abstract class Person implements Serializable{
	protected String id;
	protected String name;
	protected String address;
	
	public Person(String id, String name, String address) 
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}

	
	
	
}



	

