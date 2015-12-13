package com.redmart.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.redmart.domain.Ticket;
import com.redmart.domain.TicketComments;
import com.redmart.repository.TicketCommentsRepository;

@Service
public class TicketCommentsService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TicketCommentsRepository ticketCommentsRepository;
	
	@Inject 
	private MongoOperations mongo;
	
	public TicketComments save(TicketComments ticketComments) {
		return ticketCommentsRepository.save(ticketComments);
	}
	
	public List<TicketComments> getTicketCommentsByTicketId(Integer ticketId) {
		List<TicketComments> ticketComments = mongo.find(
			      query(where("tid").is(ticketId)), 
			      TicketComments.class);
				return ticketComments;
	}

}
