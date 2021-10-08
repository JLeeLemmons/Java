package com.codingdojo.clowns.models;

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
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="circus")

public class Circus {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    
	    private String name;
	    
	    
	    @Column(updatable=false)
	    private Date createdAt;
	    
	    private Date updatedAt;
	    
	    @OneToMany(mappedBy="circus", fetch = FetchType.LAZY)
	    private List<Clown> clowns;
	    
	    public Circus() {
	        
	    }

		public Circus(@NotEmpty(message="Circus must have a name!") String name) {
			super();
			this.name = name;
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

		public List<Clown> getClowns() {
			return clowns;
		}

		public void setClowns(List<Clown> clowns) {
			this.clowns = clowns;
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
