package com.redmart.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.TicketDetailsDTO;
import com.redmart.DTO.TicketDetailsWithCommentsDTO;
import com.redmart.DTO.TicketsDTO;
import com.redmart.service.TicketService;
import com.redmart.type.ApiResultType;
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
		ApiResultDTO apiResultDTO = null;
		try {
			apiResultDTO = ticketService.save(ticketDetailsDTO);	
		}catch(Exception e) {
			e.printStackTrace();
			apiResultDTO = new ApiResultDTO();
			apiResultDTO.setMessage("Error! Please try again later!!");
			apiResultDTO.setStatusCode(ApiResultType.INTERNAL_SERVER_ERROR.getId());
		}
		return apiResultDTO;
	}
	
	@RequestMapping(value = "/all", method = GET)
	@ResponseStatus(OK)
	@ResponseBody
	public List<TicketsDTO> allTickets() {
		List<TicketsDTO> ticketsDTOs = null;
		try {
			ticketsDTOs = ticketService.getAllTickets();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ticketsDTOs;
	}
	
	@RequestMapping(value = "/details/{ticket_id}", method = GET)
	@ResponseStatus(OK)
	@ResponseBody
	public TicketDetailsWithCommentsDTO ticketDetails(@PathVariable("ticket_id") Integer ticketId) {
		TicketDetailsWithCommentsDTO ticketDetailsWithCommentsDTO = null;
		try {
			ticketDetailsWithCommentsDTO = ticketService.getTicketDetails(ticketId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ticketDetailsWithCommentsDTO; 
	}
}
