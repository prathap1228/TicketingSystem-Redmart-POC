package com.redmart.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author prathap
 *
 */
@Document(collection = "employees")
public class Employee {

	private int eid;
	
	private String name;
	
	private String email;
	
	private String password;

	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
