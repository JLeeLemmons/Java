package com.codingdojo.JavaExam.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.JavaExam.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);

}
