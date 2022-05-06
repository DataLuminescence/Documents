package com.codingdojo.dojosandninjas.models;

import java.sql.Date;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull (message = "Message must not be empty")
    @Size(min = 2, max = 20, message="First name must me more than 2 letters long and less that 20")
    private String firstName;
    
    @NotNull (message = "Message must not be empty")
    @Size(min = 2, max = 20, message="Last name must me more than 2 letters long and less that 20")
    private String lastName;
    
    @NotNull (message = "Message must not be empty")
    @Min(value = 1, message="Amount must at least 1")
    private Integer age;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

 // ------------------------------- CONSTRUCTORS -------------------------------   

 // Empty constructor
    
    public Ninja() {
        
    }
 
	// Sets datetime when expense is created
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(age);
	}

	// Sets datetime when expense is updated
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date(age);
	}
	
	// ---------------------------- GETTERS & SETTERS ---------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
	
}

