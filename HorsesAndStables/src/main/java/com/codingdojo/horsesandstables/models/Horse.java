package com.codingdojo.horsesandstables.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="horses")
public class Horse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="horses must have a name")
	private String name; 
	
	@NotEmpty(message="The horse color cannot be blank")
	private String horseColor;
	
	@NotEmpty(message="Please provide the size of the horse")
	private String sizeOfHorse;
	
	@NotNull
	@Min(3)
	private int numOfFriends;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stable_id")
	private Stable stable;
	
	
	//constructor method
	public Horse() {

	}
	
	public Horse(Long id, @NotEmpty(message = "horses must have a name") String name,
			@NotEmpty(message = "The horse color cannot be blank") String horseColor,
			@NotEmpty(message = "Please provide the size of the horse") String sizeOfHorse,
			@NotNull @Min(3) int numOfFriends, Date createdAt, Date updatedAt, Stable stable) {
		super();
		this.id = id;
		this.name = name;
		this.horseColor = horseColor;
		this.sizeOfHorse = sizeOfHorse;
		this.numOfFriends = numOfFriends;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.stable = stable;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHorseColor() {
		return horseColor;
	}

	public void setHorseColor(String horseColor) {
		this.horseColor = horseColor;
	}

	public String getSizeOfHorse() {
		return sizeOfHorse;
	}

	public void setSizeOfHorse(String sizeOfHorse) {
		this.sizeOfHorse = sizeOfHorse;
	}

	public int getNumOfFriends() {
		return numOfFriends;
	}

	public void setNumOfFriends(int numOfFriends) {
		this.numOfFriends = numOfFriends;
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

	public Stable getStable() {
		return stable;
	}

	public void setStable(Stable stable) {
		this.stable = stable;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); 
	}


	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}
	
	
}
