package com.codingdojo.dojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo,Long> {
	List<Dojo> findAll();

}
