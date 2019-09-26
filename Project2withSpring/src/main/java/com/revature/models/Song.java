package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (schema = "project2")
public class Song implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer songId;
	
	@ManyToOne
	@JoinColumn(name="playlist_id")
	private Playlist playlist;
	
	@Column(length=50)
	private String spotifySongId;
	
	public Song() {
		super();
	}
	
	public Song(Integer id) {
		super();
	}

	public Song(Integer songId, Playlist playlist, String spotifySongId) {
		super();
		this.songId = songId;
		this.playlist = playlist;
		this.spotifySongId = spotifySongId;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", playlist=" + playlist + ", spotifySongId=" + spotifySongId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		result = prime * result + ((songId == null) ? 0 : songId.hashCode());
		result = prime * result + ((spotifySongId == null) ? 0 : spotifySongId.hashCode());
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
		Song other = (Song) obj;
		if (playlist == null) {
			if (other.playlist != null)
				return false;
		} else if (!playlist.equals(other.playlist))
			return false;
		if (songId == null) {
			if (other.songId != null)
				return false;
		} else if (!songId.equals(other.songId))
			return false;
		if (spotifySongId == null) {
			if (other.spotifySongId != null)
				return false;
		} else if (!spotifySongId.equals(other.spotifySongId))
			return false;
		return true;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public String getSpotifySongId() {
		return spotifySongId;
	}

	public void setSpotifySongId(String spotifySongId) {
		this.spotifySongId = spotifySongId;
	}

	
	
}