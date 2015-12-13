package com.redmart.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
	
	
}
