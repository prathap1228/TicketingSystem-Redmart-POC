package com.redmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 
 * @author prathap
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/agents")
	@ResponseBody
	public String getAgents() {
		
		return "Hello from HelloController at " + new Date() + ".";
	}
}

