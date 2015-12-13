package com.redmart.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.redmart.DTO.LoginCredentialsDTO;
import com.redmart.DTO.LoginResultDTO;
import com.redmart.service.LoginService;
import com.redmart.type.ApiResultType;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

	@Inject
	private LoginService loginService;

	@RequestMapping(value = "/login", method = POST)
	@ResponseStatus(OK)
	@ResponseBody
	public LoginResultDTO login(@RequestBody LoginCredentialsDTO loginCredentialsDTO) {
		LoginResultDTO loginResultDTO = null;
		try {
			loginResultDTO = loginService.login(loginCredentialsDTO);
			if(loginResultDTO != null)
				return loginResultDTO;
		}catch(Exception e) {
			e.printStackTrace();
		}
		loginResultDTO = new LoginResultDTO();
		loginResultDTO.setStatusCode(ApiResultType.NOT_AUTHORISED.getId());
		loginResultDTO.setMessage("Error! Please try again later!!");
		return loginResultDTO;
	}
}