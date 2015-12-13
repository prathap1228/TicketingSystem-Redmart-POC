package com.redmart.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author prathap
 *
 */
@Document(collection = "counters")
public class Counter {

	@Id private String id;
	
	private int seq;
	
	public Counter(String id, int seq) {
		this.id = id;
		this.seq = seq;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

}
