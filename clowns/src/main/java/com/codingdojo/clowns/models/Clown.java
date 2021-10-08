package com.codingdojo.clowns.models;

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
@Table(name="clowns")
public class Clown {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotEmpty(message="Your clown must have a name!")
	private String name;
	
	@NotEmpty(message="What color are your sneakers?")
	private String shoeColor;
	
	@NotNull
	@Min(3)
	private int pinsJuggle;
	
	@NotNull
	@Min(10)
	private int childrenLaughed; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "circus_id")
	private Circus circus; 

	public Clown() {
		
	}

	public Clown(Long id, @NotEmpty(message = "Your clown must have a name!") String name,
			@NotEmpty(message = "What color are your sneakers?") String shoeColor, @NotNull @Min(3) int pinsJuggle,
			@NotNull @Min(10) int childrenLaughed) {
		super();
		this.id = id;
		this.name = name;
		this.shoeColor = shoeColor;
		this.pinsJuggle = pinsJuggle;
		this.childrenLaughed = childrenLaughed;
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

	public String getShoeColor() {
		return shoeColor;
	}

	public void setShoeColor(String shoeColor) {
		this.shoeColor = shoeColor;
	}

	public int getPinsJuggle() {
		return pinsJuggle;
	}

	public void setPinsJuggle(int pinsJuggle) {
		this.pinsJuggle = pinsJuggle;
	}
	public int getChildrenLaughed() {
		return childrenLaughed;
	}

	public void setChildrenLaughed(int childrenLaughed) {
		this.childrenLaughed = childrenLaughed;
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
	
	
	public Circus getCircus() {
		return circus;
	}

	public void setCircus(Circus circus) {
		this.circus = circus;
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
