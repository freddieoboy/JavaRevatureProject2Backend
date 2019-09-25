package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (schema = "proj2")
public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="playlist_id")
	private int playlistId;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="is_private")
	private Boolean isPrivate;
	
	@Column(name="creation_date")
	private Timestamp creationDate;
	
	@Column(name="last_listen")
	private Timestamp lastListen;
	
	public Playlist() {
		super();
	}
	
	public Playlist(int id) {
		this.playlistId = id;
	}
	
	public Playlist(int playlistId, String name, Boolean isPrivate, Timestamp creationDate, Timestamp lastListen) {
		super();
		this.playlistId = playlistId;
		this.name = name;
		this.isPrivate = isPrivate;
		this.creationDate = creationDate;
		this.lastListen = lastListen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((isPrivate == null) ? 0 : isPrivate.hashCode());
		result = prime * result + ((lastListen == null) ? 0 : lastListen.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + playlistId;
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
		Playlist other = (Playlist) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (isPrivate == null) {
			if (other.isPrivate != null)
				return false;
		} else if (!isPrivate.equals(other.isPrivate))
			return false;
		if (lastListen == null) {
			if (other.lastListen != null)
				return false;
		} else if (!lastListen.equals(other.lastListen))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playlistId != other.playlistId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Playlist [playlistId=" + playlistId + ", name=" + name + ", isPrivate=" + isPrivate + ", creationDate="
				+ creationDate + ", lastListen=" + lastListen + "]";
	}

	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastListen() {
		return lastListen;
	}

	public void setLastListen(Timestamp lastListen) {
		this.lastListen = lastListen;
	}

	}