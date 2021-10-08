package com.codingdojo.JavaExam.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.JavaExam.Models.Idea;
import com.codingdojo.JavaExam.Models.User;
import com.codingdojo.JavaExam.Repositories.IdeaRepository;
import com.codingdojo.JavaExam.Repositories.UserRepository;



@Service
public class UserService {
    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;
    
    public UserService(UserRepository userRepository, IdeaRepository ideaRepository) {
        this.userRepository = userRepository;
        this.ideaRepository = ideaRepository; 
    }
    
    //See all IDEAS
    public ArrayList<Idea> getAll(){
    	return (ArrayList<Idea>) ideaRepository.findAll();
    }
    
    //Create an IDEA
    public Idea create(Idea newIdea) {
    	return ideaRepository.save(newIdea);
    }
    
    //update an IDEA
    public Idea updateIdea(Long id, String conceptName, User user) {
    	Idea toUpdate = this.ideaRepository.findById(id).orElse(null);
    	if(toUpdate == null) {
    		return null;
    	}else {
    		toUpdate.setConceptName(conceptName);
    		toUpdate.setUser(user);
    		return this.ideaRepository.save(toUpdate); 
    	}
    }
    
    // You stayed up late, got it done, congrats on your red belt!
    
    public Idea updateIdea(Idea idea) {
    	return this.ideaRepository.save(idea); 
    }
    
    //View an individual IDEA
    public Idea getIdea(Long id) {
    	Optional<Idea> optionalIdea = this.ideaRepository.findById(id);
    	if(optionalIdea.isPresent()) {
    		return optionalIdea.get();
    	}else {
    		return null; 
    	}
    }
    
    //delete an IDEA
    public void deleteIdea (Long id) {
    	this.ideaRepository.deleteById(id);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }


}
