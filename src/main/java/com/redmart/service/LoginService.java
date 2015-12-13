package com.redmart.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Calendar;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.LoginCredentialsDTO;
import com.redmart.DTO.LoginResultDTO;
import com.redmart.DTO.LoginResultDTO.LoginDataDTO;
import com.redmart.domain.Employee;
import com.redmart.repository.EmployeeRepository;
import com.redmart.type.ApiResultType;
import com.redmart.util.DateUtil;

/**
 * 
 * @author prathap
 *
 */
@Service
public class LoginService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Inject 
	private MongoOperations mongo;
	
	public LoginResultDTO login(LoginCredentialsDTO loginCredentialsDTO) throws Exception{
		LoginResultDTO loginResultDTO = null;
		LOGGER.debug("login request with credentials:", loginCredentialsDTO);

		if(loginCredentialsDTO != null) {
			Employee employee = mongo.findOne(
				      query(where("email").is(loginCredentialsDTO.getUid())), 
				      Employee.class);
			if(employee != null) {
				if(employee.getPassword() != null && employee.getPassword().equals(loginCredentialsDTO.getPassword())) {
					loginResultDTO = new LoginResultDTO();
					loginResultDTO.setStatusCode(ApiResultType.OK.getId());
					loginResultDTO.setMessage("success");
					LoginDataDTO loginDataDTO = new LoginDataDTO();
					loginDataDTO.setEmployeeId(employee.getEid());
					loginDataDTO.setWelcomeMessage(DateUtil.getWelcomeMessageBasedOnTime()+" "+employee.getName()+"!");
					loginResultDTO.setData(loginDataDTO);
					return loginResultDTO;
				}
			}
		}
		return loginResultDTO;
	}
}
