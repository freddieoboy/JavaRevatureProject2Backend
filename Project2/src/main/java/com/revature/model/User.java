package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "User", schema = "proj2")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	int userId;
	
	@Column(name="first_name")
	String firstname;
	
	@Column(name="last_name")
	String lastname;
	
	@Column(name="username", unique = true, nullable = false)
	String username;
	
	@Column(name="email", unique = true, nullable = false)
	String email;
	
	@Column(name="password", nullable = false)
	String password;
	
	@Column(name="last_login")
	Timestamp lastLogin;
	
	@Column(name="is_private")
	boolean isPrivate;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="user_playlist",
			schema="proj2",
			joinColumns={@JoinColumn(name="user_id")},
			inverseJoinColumns={@JoinColumn(name="playlist_id")})
	private List<Playlist> playlists = new ArrayList<>();
	
	public User() {
		super();
	}
	
	public User(int id) {
		this.userId = id;
	}
	
	public User(String firstname, String lastname, String username, String email, String password,
			Timestamp lastLogin, boolean isPrivate) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.lastLogin = lastLogin;
		this.isPrivate = isPrivate;
	}

	public User(int userId, String firstname, String lastname, String username, String email, String password,
			Timestamp lastLogin, boolean isPrivate) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.lastLogin = lastLogin;
		this.isPrivate = isPrivate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (isPrivate ? 1231 : 1237);
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (isPrivate != other.isPrivate)
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", email=" + email + ", password=" + password + ", lastLogin=" + lastLogin + ", isPrivate="
				+ isPrivate + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	
}
