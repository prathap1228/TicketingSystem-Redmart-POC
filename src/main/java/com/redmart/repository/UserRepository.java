package com.redmart.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.redmart.domain.User;

/**
 * 
 * @author prathap
 *
 */
@Repository
public interface UserRepository  extends CrudRepository<User, UUID>, MongoRepository<User, UUID> {

}
