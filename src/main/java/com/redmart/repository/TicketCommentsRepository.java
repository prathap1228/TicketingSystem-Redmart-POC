package com.redmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.redmart.domain.TicketComments;

@Repository
public interface TicketCommentsRepository extends CrudRepository<TicketComments, String>, MongoRepository<TicketComments, String> {

}
