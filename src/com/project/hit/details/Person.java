package com.project.hit.details;

import java.io.Serializable;

public abstract class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String id;
	protected String name;
	protected String address;
	
	public Person(String id, String name, String address) 
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}

	/**
	 * Gets this {@link Person} id.
	 * @return the id of the {@link Person}.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets this {@link Person} id.
	 * @param id - The id of the {@link Person}.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets this {@link Person} name.
	 * @return the name of the {@link Person}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets this {@link Person} name.
	 * @param name - The name of the {@link Person}.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets this {@link Person} address.
	 * @return the address of the {@link Person}.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets this {@link Person} address.
	 * @param address - The address of the {@link Person}.
	 */
	public void setAddress(String address) {
		this.address = address;
	}	
}



	

