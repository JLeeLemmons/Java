package com.codingdojo.loginreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginreg.models.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
	

}
