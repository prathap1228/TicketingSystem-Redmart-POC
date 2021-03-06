package com.redmart.DTO;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.redmart.DTO.TicketDetailsWithCommentsDTO.TicketCommentsDTO;

@JsonIgnoreType(value = true)
public class TicketDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String name;

	private String contactNumber;

	private String emailId;

	private String category;

	private String status;
	
	private Long loggedAt;

	private Integer assignedTo;

	private Integer raisedBy;
	
	private String comment;
	
	private List<TicketCommentsDTO> ticketCommentsDTOs;
	//private List<TicketCommentsDTO> ticketCommentsDTOs;
	
	/*@JsonIgnoreType(value = true)
	public static class TicketCommentsDTO implements Serializable{
		
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = 1L;

		private Integer id;
		
		private String comment;
		
		private Long commentedDate;
		
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

		public Long getCommentedDate() {
			return commentedDate;
		}

		public void setCommentedDate(Long commentedDate) {
			this.commentedDate = commentedDate;
		}

		public Integer getAddedBy() {
			return addedBy;
		}

		public void setAddedBy(Integer addedBy) {
			this.addedBy = addedBy;
		}
		
	}*/

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<TicketCommentsDTO> getTicketCommentsDTOs() {
		return ticketCommentsDTOs;
	}

	public void setTicketCommentsDTOs(List<TicketCommentsDTO> ticketCommentsDTOs) {
		this.ticketCommentsDTOs = ticketCommentsDTOs;
	}

	/*public List<TicketCommentsDTO> getTicketCommentsDTOs() {
		return ticketCommentsDTOs;
	}

	public void setTicketCommentsDTOs(List<TicketCommentsDTO> ticketCommentsDTOs) {
		this.ticketCommentsDTOs = ticketCommentsDTOs;
	}*/
	

}	
