package com.isil.am2.am2examplesqlite.model.entity;

import java.io.Serializable;

public class ContactEntity implements Serializable {

	private int id;
	private String name;
    private String email;
	private String phone_number;
	
	
	public ContactEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactEntity(String name, String phone_number) {
		super();
		this.name = name;
		this.phone_number = phone_number;
	}
	public ContactEntity(int id, String name, String phone_number) {
		super();
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
	}

    public ContactEntity(int id, String name, String email, String phone_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
