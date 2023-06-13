package com.example.todoapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at", "updated_at"},allowGetters = true)
public class Todo 
{	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String title;
	private String description;

	@Column(columnDefinition = "boolean default false")
	private boolean completed;

		@ManyToOne
    @JoinColumn(name="user_id")
		private User user;

		// private Long user_id;

	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;
    
    public Todo() {
    	
    }
    
	public Todo(String title, String description, boolean completed, Long user_id) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
		// this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	  // public Long getUserId() {
	  //     return user_id;
	  // }

	  // public void setUserId(Long user_id) {
	  //     this.user_id = user_id;
	  // }

	// public User getUser() {
  //       return user;
  //   }

  //   public void setUser(User user) {
  //       this.user = user;
  //   }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean getCompleted() {
		return completed;
	}

	public Date getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updated_at = updated_at;
	}    
}
