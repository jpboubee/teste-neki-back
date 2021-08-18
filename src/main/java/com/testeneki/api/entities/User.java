package com.testeneki.api.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "`user`")
public class User {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="login", length = 12, nullable =  false)
	private String login;
	
	@Column (name = "password", length = 100, nullable = false)
	private String password;
	
	@Column (name = "last_login_date")
	private LocalDate lastLoginDate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String login, String password, LocalDate lastLoginDate) {
		super();
		this.login = login;
		this.password = password;
		this.lastLoginDate = lastLoginDate;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDate lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
}
