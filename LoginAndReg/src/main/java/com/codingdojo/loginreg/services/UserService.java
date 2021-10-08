package com.codingdojo.loginreg.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.loginreg.models.Menu;
import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.repositories.MenuRepository;
import com.codingdojo.loginreg.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MenuRepository menuRepo;
    
    public UserService(UserRepository userRepository, MenuRepository menuRepo) {
        this.userRepository = userRepository;
        this.menuRepo = menuRepo; 
    }
    
    public Menu create(Menu menu) {
    	return menuRepo.save(menu);
    }
    
    public List<Menu> getAllMenus(){
    	return (List<Menu>) menuRepo.findAll(); 
    }
    
    public Menu getMenu(Long id) {
    	Optional<Menu> m = menuRepo.findById(id);
    		
    	if(m.isPresent()) {
            return m.get();
    	} else {
    	    return null;
    	}
    }
    
    public Menu updateMenu(Menu menu) {
    	return menuRepo.save(menu);
    }
    
    public Menu updatingThisMenu(Long id, String name, String description) {
    	Menu toUpdate = menuRepo.findById(id).orElse(null);
    	if(toUpdate == null) {
    		return null; 
    	}else {
    		toUpdate.setName(name);
    		toUpdate.setDescription(description);
    		
    		return this.menuRepo.save(toUpdate); 
    	}
    }
    
    public void deleteMenu(Long id){
    	this.menuRepo.deleteById(id);
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
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
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
