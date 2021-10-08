package com.codingdojo.horsesandstables.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.horsesandstables.models.Stable;

@Repository
public interface StableRepository extends CrudRepository<Stable, Long> {
	List<Stable> findAll();

}
