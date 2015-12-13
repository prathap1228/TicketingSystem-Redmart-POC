package com.redmart.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.TicketDetailsDTO;
import com.redmart.service.TicketService;

/**
 * 
 * @author prathap
 *
 */
@RequestMapping(value = "/ticket")
@Controller
public class TicketController {

	@Inject
	private TicketService ticketService;
	
	@RequestMapping(value = "/save", method = POST)
	@ResponseStatus(OK)
	@ResponseBody
	public ApiResultDTO save(@RequestBody TicketDetailsDTO ticketDetailsDTO) {
		return ticketService.save(ticketDetailsDTO);
	}
}
