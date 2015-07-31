package com.oguchok.isite.persistence.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@ManyToMany
	@JoinTable(name="user_roles",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id"))
	private Collection<Role> roles;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean enabled;
	
	public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
