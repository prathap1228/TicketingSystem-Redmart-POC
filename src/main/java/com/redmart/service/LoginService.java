package com.redmart.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.LoginCredentialsDTO;
import com.redmart.domain.Employee;
import com.redmart.domain.Foo;
import com.redmart.domain.User;
import com.redmart.repository.EmployeeRepository;
import com.redmart.type.ApiResultType;

/**
 * 
 * @author prathap
 *
 */
@Service
public class LoginService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Inject
	private EmployeeRepository employeeRepository;

	@Inject 
	private MongoOperations mongo;
	
	public ApiResultDTO login(LoginCredentialsDTO loginCredentialsDTO) {

		LOGGER.debug("login request with cred", loginCredentialsDTO);

		ApiResultDTO loginResultDTO = new ApiResultDTO();
		
		if(loginCredentialsDTO != null) {
			Employee employee = mongo.findOne(
				      query(where("email").is(loginCredentialsDTO.getUid())), 
				      Employee.class);
			if(employee != null) {
				if(employee.getPassword() != null && employee.getPassword().equals(loginCredentialsDTO.getPassword())) {
					loginResultDTO.setStatusCode(ApiResultType.OK.getId());
					loginResultDTO.setMessage("success");
					return loginResultDTO;
				}
			}
		}

		loginResultDTO.setStatusCode(ApiResultType.NOT_AUTHORISED.getId());
		loginResultDTO.setMessage("Wrong Credentials!");
	
		return loginResultDTO;
	}
}
