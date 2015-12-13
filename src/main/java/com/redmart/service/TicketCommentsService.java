package com.redmart.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.redmart.domain.TicketComments;
import com.redmart.repository.TicketCommentsRepository;

@Service
public class TicketCommentsService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Inject
	private TicketCommentsRepository ticketCommentsRepository;
	
	public TicketComments save(TicketComments ticketComments) {
		return ticketCommentsRepository.save(ticketComments);
	}
}
