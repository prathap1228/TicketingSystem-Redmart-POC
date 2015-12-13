package com.redmart.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author prathap
 *
 */
@Document(collection = "counters")
public class Sequence {

	@Id
	protected final String name;
	protected Long counter;

	public Sequence(String name, Long counter) {
		this.name = name;
		this.counter = counter;
	}
	public String getName() {
		return name;
	}
	public Long getCounter() {
		return counter;
	}
	public void setCounter(Long counter) {
		this.counter = counter;
	}

}
