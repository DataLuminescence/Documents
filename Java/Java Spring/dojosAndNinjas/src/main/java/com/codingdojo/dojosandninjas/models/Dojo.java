package com.codingdojo.dojosandninjas.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Validation imports

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull (message = "Message must not be empty")
    @Size(min = 2, max = 40, message="Name must me more than 2 letters long and less that 20")
    private String name;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    

// ------------------------------- CONSTRUCTORS -------------------------------   

// Empty constructor

	public Dojo() {

	}

	// Sets datetime when expense is created
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	// Sets datetime when expense is updated
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// ---------------------------- GETTERS & SETTERS ---------------------------

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

	public List<Ninja> getNinjas() {
		return ninjas;
	}
	
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
}
