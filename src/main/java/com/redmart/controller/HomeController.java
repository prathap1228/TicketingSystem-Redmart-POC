package com.redmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello from HelloController at " + new Date() + ".";
	}
	
	@RequestMapping("/agents")
	@ResponseBody
	public String getAgents() {
		
		return "Hello from HelloController at " + new Date() + ".";
	}
}

