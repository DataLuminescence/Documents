package com.codingdojo.javabelt.models;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Verify title is not empty and of a certain size
    @NotBlank(message="Title of show is required!")
    @Size(min=4, max=40, message="Title must be between 4 and 20 characters")
    private String title;
    
    // Verify email doesn't already exist in database
    @NotBlank(message="Network the show is on is required!")
    @Size(min=2, max=30, message="Network must be between 2 and 10 characters")    
    private String network;
    
    // Verify email doesn't already exist in database
    @NotBlank(message="Description of the show are required!")
    @Size(min=15, max=1000, message="Description must be between 10 and 30 characters")    
    private String description;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
	// ------------------------------- CONSTRUCTORS -------------------------------   

	// Empty constructor
	
    public Show() {}
    
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}