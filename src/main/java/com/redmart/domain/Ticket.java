package com.redmart.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author prathap
 *
 */
@Document(collection = "tickets")
public class Ticket {

	private int tid;

	private String name;

	private String contactNumber;

	private String emailId;

	private Byte category;

	private Short status;
	
	private Long loggedAt;

	private Integer assignedTo;

	private Integer raisedBy;


	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Byte getCategory() {
		return category;
	}

	public void setCategory(Byte category) {
		this.category = category;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Long getLoggedAt() {
		return loggedAt;
	}

	public void setLoggedAt(Long loggedAt) {
		this.loggedAt = loggedAt;
	}

	public Integer getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Integer assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Integer getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Integer raisedBy) {
		this.raisedBy = raisedBy;
	}

}
