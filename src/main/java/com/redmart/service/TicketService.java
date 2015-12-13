package com.redmart.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.TicketDetailsDTO;
import com.redmart.DTO.TicketDetailsWithCommentsDTO;
import com.redmart.DTO.TicketDetailsWithCommentsDTO.TicketCommentsDTO;
import com.redmart.DTO.TicketsDTO;
import com.redmart.domain.Employee;
import com.redmart.domain.Ticket;
import com.redmart.domain.TicketComments;
import com.redmart.repository.TicketRepository;
import com.redmart.type.ApiResultType;
import com.redmart.type.MongoCounterCollectionType;
import com.redmart.type.TicketCategoryType;
import com.redmart.type.TicketStatusType;

/**
 * 
 * @author prathap
 *
 */
@Service
public class TicketService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Inject
	private TicketRepository ticketRepository;
	
	@Inject
	private CounterService counterService;
	
	@Inject
	private TicketCommentsService ticketCommentsService;
	
	@Inject
	private EmployeeService employeeService;
	
	@Inject 
	private MongoOperations mongo;
	
	public ApiResultDTO save(TicketDetailsDTO ticketDetailsDTO) {
		ApiResultDTO apiResultDTO = new ApiResultDTO();
		
		Ticket ticket = new Ticket();
		ticket.setAssignedTo(ticketDetailsDTO.getAssignedTo());
		ticket.setCategory(ticketDetailsDTO.getCategory());
		ticket.setContactNumber(ticketDetailsDTO.getContactNumber());
		ticket.setEmailId(ticketDetailsDTO.getEmailId());
		ticket.setLoggedAt(new Date().getTime());
		ticket.setName(ticketDetailsDTO.getName());
		ticket.setRaisedBy(ticketDetailsDTO.getRaisedBy());
		ticket.setStatus(ticketDetailsDTO.getStatus());
		ticket.setTid(counterService.getNextSequence(MongoCounterCollectionType.TICKETS.getName()));
		
		//set comments
		/*List<TicketCommentsDTO> ticketCommentsDTOs = ticketDetailsDTO.getTicketCommentsDTOs();
		if(ticketCommentsDTOs != null && !ticketCommentsDTOs.isEmpty()) {
			for(TicketCommentsDTO ticketCommentsDTO : ticketCommentsDTOs) {
				TicketComments ticketComment = new TicketComments();
				ticketComment.setAddedBy(ticketCommentsDTO.getAddedBy());
				ticketComment.setComment(ticketCommentsDTO.getComment());
				ticketComment.setCommentedDate(new Date().getTime());
				ticketComment.setTid(ticket.getTid());
				ticketCommentsService.save(ticketComment);
			}
		}*/
		
		TicketComments ticketComment = new TicketComments();
		ticketComment.setAddedBy(ticketDetailsDTO.getRaisedBy());
		ticketComment.setComment(ticketDetailsDTO.getComment());
		ticketComment.setCommentedDate(new Date().getTime());
		ticketComment.setTid(ticket.getTid());
		ticketCommentsService.save(ticketComment);
		
		ticketRepository.save(ticket);
		apiResultDTO.setStatusCode(ApiResultType.OK.getId());
		apiResultDTO.setMessage("success");
		return apiResultDTO;
	}

	public List<TicketsDTO> getAllTickets() {
		// TODO Auto-generated method stub
		List<TicketsDTO> TicketsDTOs = new ArrayList<TicketsDTO>();
		TicketsDTO ticketsDTO = null;
		
		List<Ticket> allTickets = ticketRepository.findAll();
		if(allTickets != null && !allTickets.isEmpty()) {
			SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
			for(Ticket ticket : allTickets) {
				ticketsDTO = new TicketsDTO();
				Employee assignedToEmployee = employeeService.getEmployeeById(ticket.getAssignedTo());
				if(assignedToEmployee != null)
					ticketsDTO.setAssignedTo(assignedToEmployee.getName());
				ticketsDTO.setCategory(TicketCategoryType.getById(ticket.getCategory()).getName());
				ticketsDTO.setId(ticket.getTid());
				ticketsDTO.setName(ticket.getName());
				ticketsDTO.setStatus(TicketStatusType.getById(ticket.getStatus()).getName());
				
				Employee raisedByEmployee = employeeService.getEmployeeById(ticket.getRaisedBy());
				if(raisedByEmployee != null)
					ticketsDTO.setRaisedBy(raisedByEmployee.getName());
				
				Date date = new Date(ticket.getLoggedAt());
				ticketsDTO.setLoggedAt(dateformat.format(date));
				TicketsDTOs.add(ticketsDTO);
			}
		}
		return TicketsDTOs;
	}

	public TicketDetailsWithCommentsDTO getTicketDetails(Integer ticketId) {
		// TODO Auto-generated method stub
		TicketDetailsWithCommentsDTO ticketDetailsWithCommentsDTO = null;
		Ticket ticket = getTicketDocByTicketId(ticketId);
		SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
		if(ticket != null) {
			ticketDetailsWithCommentsDTO = new TicketDetailsWithCommentsDTO();
			ticketDetailsWithCommentsDTO.setAssignedTo(ticket.getAssignedTo());
			ticketDetailsWithCommentsDTO.setCategory(ticket.getCategory());
			ticketDetailsWithCommentsDTO.setContactNumber(ticket.getContactNumber());
			ticketDetailsWithCommentsDTO.setEmailId(ticket.getEmailId());
			ticketDetailsWithCommentsDTO.setId(ticketId);
			if(ticket.getLoggedAt() != null) {
				Date date = new Date(ticket.getLoggedAt());
				ticketDetailsWithCommentsDTO.setLoggedAt(dateformat.format(date));	
			}
			ticketDetailsWithCommentsDTO.setName(ticket.getName());
			ticketDetailsWithCommentsDTO.setRaisedBy(ticket.getRaisedBy());
			ticketDetailsWithCommentsDTO.setStatus(ticket.getStatus());

			List<TicketCommentsDTO> ticketCommentsDTOs = new ArrayList<TicketCommentsDTO>();
			List<TicketComments> ticketComments = ticketCommentsService.getTicketCommentsByTicketId(ticketId);
			if(ticketComments != null && !ticketComments.isEmpty()) {
				for(TicketComments ticketComment : ticketComments) {
					TicketCommentsDTO ticketCommentsDTO = new TicketCommentsDTO();
					ticketCommentsDTO.setAddedBy(ticketComment.getAddedBy());
					ticketCommentsDTO.setComment(ticketComment.getComment());
					if(ticket.getLoggedAt() != null) {
						Date date = new Date(ticketComment.getCommentedDate());
						ticketCommentsDTO.setCommentedDate(dateformat.format(date));	
					}
					ticketCommentsDTO.setId(ticketId);
					ticketCommentsDTOs.add(ticketCommentsDTO);
				}
				ticketDetailsWithCommentsDTO.setTicketCommentsDTOs(ticketCommentsDTOs);
			}
		}
		return ticketDetailsWithCommentsDTO;
	}
	
	public Ticket getTicketDocByTicketId(Integer ticketId) {
		Ticket ticket = mongo.findOne(
			      query(where("tid").is(ticketId)), 
			      Ticket.class);
				return ticket;
	}

}
