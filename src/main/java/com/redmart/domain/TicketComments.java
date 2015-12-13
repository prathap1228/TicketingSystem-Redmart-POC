package com.redmart.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ticket_comments")
public class TicketComments {

	private int tid;
	
	private String comment;
	
	private Integer addedBy;
	
	private Long commentedDate;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Integer addedBy) {
		this.addedBy = addedBy;
	}

	public Long getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Long commentedDate) {
		this.commentedDate = commentedDate;
	}
	
}
