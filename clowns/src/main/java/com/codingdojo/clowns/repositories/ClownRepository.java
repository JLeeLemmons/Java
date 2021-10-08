package com.codingdojo.clowns.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.clowns.models.Clown;

@Repository
public interface ClownRepository extends CrudRepository<Clown, Long> {
	List<Clown> findAll();
	

}
