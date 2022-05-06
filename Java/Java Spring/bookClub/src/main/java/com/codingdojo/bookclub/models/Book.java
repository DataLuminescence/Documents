package com.codingdojo.bookclub.models;
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
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Verify title is not empty and of a certain size
    @NotBlank(message="Title is required!")
    @Size(min=8, max=40, message="Title must be between 8 and 40 characters")
    private String title;
    
    // Verify email doesn't already exist in database
    @NotBlank(message="Author is required!")
    @Size(min=5, max=30, message="Author must be between 5 and 30 characters")    
    private String author;
    
    // Verify email doesn't already exist in database
    @NotBlank(message="Thoughts on the book are required!")
    @Size(min=10, max=1000, message="Thoughts must be between 10 and 30 characters")    
    private String thoughts;

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
	
    public Book() {}
    
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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