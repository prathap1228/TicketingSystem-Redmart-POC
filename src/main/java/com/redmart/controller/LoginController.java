package com.redmart.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.LoginCredentialsDTO;
import com.redmart.service.LoginService;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

	@Inject
	private LoginService loginService;

	@RequestMapping(value = "/login", method = POST)
	@ResponseStatus(OK)
	@ResponseBody
	public ApiResultDTO login(@RequestBody LoginCredentialsDTO loginCredentialsDTO) {
		return loginService.login(loginCredentialsDTO);
	}
}