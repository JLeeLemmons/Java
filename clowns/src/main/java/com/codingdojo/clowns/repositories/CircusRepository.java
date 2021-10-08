package com.codingdojo.clowns.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.clowns.models.Circus;

@Repository
public interface CircusRepository extends CrudRepository<Circus, Long>{
	List<Circus> findAll();

}
