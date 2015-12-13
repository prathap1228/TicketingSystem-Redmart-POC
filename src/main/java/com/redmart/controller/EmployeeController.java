package com.redmart.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.redmart.DTO.EmployeeDetailsDTO;
import com.redmart.service.EmployeeService;

@RequestMapping(value = "/employees")
@Controller
public class EmployeeController {

	@Inject
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/all", method = GET)
	@ResponseStatus(OK)
	@ResponseBody
	public List<EmployeeDetailsDTO> allEmployees() {
		return employeeService.getAllEmployees();
	}
}
