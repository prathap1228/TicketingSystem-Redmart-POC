package com.redmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.redmart.domain.Employee;

/**
 * 
 * @author prathap
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>, MongoRepository<Employee, String> {

}
