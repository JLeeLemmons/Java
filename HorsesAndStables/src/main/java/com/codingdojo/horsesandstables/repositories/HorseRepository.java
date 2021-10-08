package com.codingdojo.horsesandstables.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.horsesandstables.models.Horse;

@Repository
public interface HorseRepository extends CrudRepository<Horse, Long> {
	List<Horse> findAll();

}
