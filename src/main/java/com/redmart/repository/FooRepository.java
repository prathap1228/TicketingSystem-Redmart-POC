package com.redmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.redmart.domain.Foo;

/**
 * {@link Repository} that persists domain objects that are handed to business {@code Service}s.
 * 
 * @author prathap
 */
@Repository
public interface FooRepository extends CrudRepository<Foo, UUID>, MongoRepository<Foo, UUID> {

}
