package com.ctwyrth.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//import com.ctwyrth.bookclub.models.Book;

@Entity
@Table(name="users")
public class User {
    // -------------------variables-------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 charcaters.")
    private String name;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters.")
    private String confirm;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Book> books;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Book> borrowed;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // -------------------constructors (include an empty one)-------------------
    public User() {}

    // -------------------methods-------------------
    // These tie to the mandatory variables above:
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    // -------------------getters & setters-------------------
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
    
    public String getConfirm() {
    	return confirm;
    }
    public void setConfirm(String confirm) {
    	this.confirm = confirm;
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

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(List<Book> borrowed) {
		this.borrowed = borrowed;
	}

}