package com.testeneki.api.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "user_skill")
public class UserSkill {
	@Column(name = "id")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	
	private User user;
	
	@ManyToOne
	
	private Skill skill;
	
	@Column(name = "knowledge_level", nullable = false)
	private Integer knowledgeLevel;
	
	@Column (name = "created_at", nullable = false)
	private LocalDate createdAt;
	
	@Column (name = "updated_at")
	private LocalDate updatedAt;
	
	public UserSkill() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}

	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
