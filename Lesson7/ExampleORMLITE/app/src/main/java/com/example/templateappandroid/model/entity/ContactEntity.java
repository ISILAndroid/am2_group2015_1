package com.example.templateappandroid.model.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;

public class ContactEntity implements Serializable {

	public static final int CONTACTED=1;
	public static final int NOTCONTACTED=0;
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private int facebook_id;
	
	@DatabaseField
	private String name,lastname,email;
	
	@DatabaseField
	private String path_img;
	
	@DatabaseField
	private String job;

    @DatabaseField
	private String phone;
	
	@DatabaseField
	private int contacted; //0 - 1 contacted - not contacted
	
	public ContactEntity() {
		// TODO Auto-generated constructor stub
	}

	public ContactEntity(String name, String lastname, String email,
			String path_img, String job) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.path_img = path_img;
		this.job = job;
	}

    public ContactEntity(String name, String email,
                         String phone)
    {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ContactEntity(int id,String name, String email,
                         String phone)
    {
        super();
        this.id= id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

	public ContactEntity(int id, String name, String lastname, String email,
			String job) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.job = job;
	}

	public String getUserName()
	{
		return this.name+" "+ this.lastname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPath_img() {
		return path_img;
	}

	public void setPath_img(String path_img) {
		this.path_img = path_img;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getContacted() {
		return contacted;
	}

	public void setContacted(int contacted) {
		this.contacted = contacted;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", facebook_id=" + facebook_id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", path_img='" + path_img + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", contacted=" + contacted +
                '}';
    }
}