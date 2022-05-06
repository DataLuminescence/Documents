package com.codingdojo.edittravels.models;

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
@Table(name="expenses")
public class Expense {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull (message = "Message must not be empty")
    @Size(min = 5, max = 200, message="Name must me more than 5 letters long and less that 200")
    private String name;
    
    @NotNull (message = "Message must not be empty")
    @Size(min = 5, max = 200, message="Vendor must me more than 5 letters long and less that 200")
    private String vendor;
    
    @NotNull (message = "Message must not be empty")
    @Min(value = 1, message="Amount must at least 1")
    private Integer amount;
    
    @NotNull (message = "Message must not be empty")
    @Size(min = 5, max = 200, message="Description must me more than 5 letters long and less that 200")
    private String description;
    
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ------------------------------- CONSTRUCTORS -------------------------------   
    
    // Empty constructor
    public Expense() {}
    
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

	
}

