package com.codingdojo.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Validation imports


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class Language {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull (message = "Input must not be empty")
    @Size(min = 2, max = 20, message="Name must me more than 2 letters long and less that 20")
    private String name;
    
    @NotNull (message = "Input must not be empty")
    @Size(min = 2, max = 20, message="Creator must me more than 2 letters long and less that 20")
    private String creator;
    
    @NotNull (message = "Input must not be empty")
    @Min(value = 1, message="Version must at least 1")
    private Integer version;

	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ------------------------------- CONSTRUCTORS -------------------------------   
    
    // Empty constructor
    public Language() {}
    
//    // Overloaded constructor - API use
//    public Expense(String name, String vendor, Double amount) {
//        this.name = name;
//        this.vendor = vendor;
//        this.amount = amount;
//    }
    
    // Sets datetime when expense is created
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    // Sets datetime when expense is updated
    @PreUpdate
    protected void onUpdate(){
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

 	public String getCreator() {
 		return creator;
 	}

 	public void setCreator(String creator) {
 		this.creator = creator;
 	}

 	public Integer getVersion() {
 		return version;
 	}

 	public void setVersion(Integer version) {
 		this.version = version;
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
	
}

