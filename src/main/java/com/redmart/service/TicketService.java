package com.redmart.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.redmart.DTO.ApiResultDTO;
import com.redmart.DTO.TicketDetailsDTO;
import com.redmart.DTO.TicketDetailsDTO.TicketCommentsDTO;
import com.redmart.domain.Sequence;
import com.redmart.domain.Ticket;
import com.redmart.domain.TicketComments;
import com.redmart.repository.CounterRepository;
import com.redmart.repository.TicketRepository;
import com.redmart.type.MongoCounterCollectionType;

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
		List<TicketCommentsDTO> ticketCommentsDTOs = ticketDetailsDTO.getTicketCommentsDTOs();
		if(ticketCommentsDTOs != null && !ticketCommentsDTOs.isEmpty()) {
			for(TicketCommentsDTO ticketCommentsDTO : ticketCommentsDTOs) {
				TicketComments ticketComment = new TicketComments();
				ticketComment.setAddedBy(ticketCommentsDTO.getAddedBy());
				ticketComment.setComment(ticketCommentsDTO.getComment());
				ticketComment.setCommentedDate(new Date().getTime());
				ticketComment.setTid(ticket.getTid());
				ticketCommentsService.save(ticketComment);
			}
		}
		
		ticketRepository.save(ticket);
		return apiResultDTO;
	}
}
