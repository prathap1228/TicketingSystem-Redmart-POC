package com.redmart.service;


import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.redmart.domain.Counter;
import com.redmart.repository.CounterRepository;

/**
 * 
 * @author prathap
 *
 */
@Service
public class CounterService {

	@Inject 
	private MongoOperations mongo;
	
	@Inject
	private CounterRepository counterRepository;
	
	public int getNextSequence(String collectionName) {
	    Counter counter = mongo.findAndModify(
	      query(where("_id").is(collectionName)), 
	      new Update().inc("seq", 1),
	      options().returnNew(true),
	      Counter.class);
	     
	    if(counter == null) {
	    	counterRepository.save(new Counter(collectionName, 0));
	    	return 0;
	    }
	    return counter.getSeq();
	  }
}
