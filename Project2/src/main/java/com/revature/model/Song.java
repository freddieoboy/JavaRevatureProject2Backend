package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (schema = "proj2")
public class Song implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="song_id")
	private int songId;
	
	@ManyToOne
	@JoinColumn(name="playlist_id")
	private Playlist playlist;
	
	@Column(name="spotify_song_id", length=350)
	private String spotifySongId;
	
	public Song() {
		super();
	}
	
	public Song(int id) {
		this.songId = id;
	}

	public Song(int songId, Playlist playlist, String spotifySongId) {
		super();
		this.songId = songId;
		this.playlist = playlist;
		this.spotifySongId = spotifySongId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		result = prime * result + songId;
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
		if (songId != other.songId)
			return false;
		if (spotifySongId == null) {
			if (other.spotifySongId != null)
				return false;
		} else if (!spotifySongId.equals(other.spotifySongId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", playlist=" + playlist + ", spotifySongId=" + spotifySongId + "]";
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
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