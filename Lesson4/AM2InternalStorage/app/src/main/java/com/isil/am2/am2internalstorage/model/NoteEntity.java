package com.isil.am2.am2internalstorage.model;

import java.io.Serializable;

public class NoteEntity implements Serializable {

	private int id ;
	private String name;
	private String desc;
	private String date;
	private String path;
	
	public NoteEntity() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+date;
	}

	
}
