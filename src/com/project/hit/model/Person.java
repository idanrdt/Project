package com.project.hit.model;

public abstract class Person {

    protected String firstName, lastName, id, address;

    public Person(String firstName, String lastName, String id, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
    }

    public abstract String getFirstName();

    public abstract void setFirstName(String firstName);

    public abstract String getLastName();

    public abstract void setLastName(String lastName);

    public abstract String getId();

    public abstract void setId(String id);

    public abstract String getAddress();

    public abstract void setAddress(String address);
}
