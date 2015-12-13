package com.redmart.DTO;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class TicketDetailsWithCommentsDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String name;

	private String contactNumber;

	private String emailId;

	private Byte category;

	private Short status;
	
	private String loggedAt;

	private Integer assignedTo;

	private Integer raisedBy;
	
	private List<TicketCommentsDTO> ticketCommentsDTOs;
	
	@JsonIgnoreType(value = true)
	public static class TicketCommentsDTO implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Integer id;
		
		private String comment;
		
		private String commentedDate;
		
		private Integer addedBy;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getCommentedDate() {
			return commentedDate;
		}

		public void setCommentedDate(String commentedDate) {
			this.commentedDate = commentedDate;
		}

		public Integer getAddedBy() {
			return addedBy;
		}

		public void setAddedBy(Integer addedBy) {
			this.addedBy = addedBy;
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getLoggedAt() {
		return loggedAt;
	}

	public void setLoggedAt(String loggedAt) {
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


	public List<TicketCommentsDTO> getTicketCommentsDTOs() {
		return ticketCommentsDTOs;
	}

	public void setTicketCommentsDTOs(List<TicketCommentsDTO> ticketCommentsDTOs) {
		this.ticketCommentsDTOs = ticketCommentsDTOs;
	}
	


}
