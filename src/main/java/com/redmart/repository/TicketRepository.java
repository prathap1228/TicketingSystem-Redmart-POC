package com.redmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.redmart.domain.Ticket;

/**
 * 
 * @author prathap
 *
 */
@Repository
public interface TicketRepository extends CrudRepository<Ticket, String>, MongoRepository<Ticket, String> {

}
