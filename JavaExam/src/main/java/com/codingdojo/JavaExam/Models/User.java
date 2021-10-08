package com.codingdojo.JavaExam.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="You need an username")
    private String userName;
    
    @NotEmpty(message="You need an email")
    @Email(message="Email better silly!")
    private String email;
    
    @NotEmpty(message="You cannot leave the password empty")
    @Size(min=8, max=128, message="Password must be atleast 8 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password cannot be empty")
    @Size(min=8, max=128, message="Password must be atleast 8 characters")
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Idea> ideas;
    
    
    public User() {
    }
    
    
    public User(Long id, @NotEmpty(message = "You need an username") String userName,
			@NotEmpty(message = "You need an email") @Email(message = "Email better silly!") String email,
			@NotEmpty(message = "You cannot leave the password empty") @Size(min = 8, max = 128, message = "Password must be atleast 8 characters") String password,
			@NotEmpty(message = "Confirm Password cannot be empty") @Size(min = 8, max = 128, message = "Password must be atleast 8 characters") String passwordConfirmation,
			Date createdAt, Date updatedAt, List<Idea> ideas) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.ideas = ideas;
	}





	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	public List<Idea> getIdeas() {
		return ideas;
	}


	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
