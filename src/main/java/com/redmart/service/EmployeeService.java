package com.redmart.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.redmart.domain.Counter;
import com.redmart.domain.Employee;
import com.redmart.domain.Foo;
import com.redmart.repository.EmployeeRepository;

/**
 * 
 * @author prathap
 *
 */
@Service
public class EmployeeService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Inject
	private EmployeeRepository employeeRepository;

	@Inject 
	private MongoOperations mongo;
	
	public Employee getEmployeeById(int eid) {
		Employee employee = mongo.findOne(
	      query(where("eid").is(eid)), 
	      Employee.class);
		return employee;
	}
	
}
