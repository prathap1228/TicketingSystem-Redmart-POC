package com.redmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.redmart.domain.Counter;

/**
 * 
 * @author prathap
 *
 */
@Repository
public interface CounterRepository extends CrudRepository<Counter, String>, MongoRepository<Counter, String> {
	
}
