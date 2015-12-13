package com.redmart.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.redmart.DTO.EmployeeDetailsDTO;
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

	public List<EmployeeDetailsDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeDetailsDTO> employeeDetailsDTOs = new ArrayList<EmployeeDetailsDTO>();
		List<Employee> employees = employeeRepository.findAll();
		if(employees != null && !employees.isEmpty()) {
			EmployeeDetailsDTO employeeDetailsDTO = null;
			for(Employee employee : employees) {
				employeeDetailsDTO = new EmployeeDetailsDTO();
				employeeDetailsDTO.setEmployeeId(employee.getEid());
				employeeDetailsDTO.setEmployeeName(employee.getName());
				employeeDetailsDTOs.add(employeeDetailsDTO);
			}
		}
		return employeeDetailsDTOs;
	}
	
}
