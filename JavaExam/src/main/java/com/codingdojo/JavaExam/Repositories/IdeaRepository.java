package com.codingdojo.JavaExam.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.JavaExam.Models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	

}
