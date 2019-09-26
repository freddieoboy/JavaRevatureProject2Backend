package com.revature.services;

import java.util.List;

import com.revature.models.Playlist;
import com.revature.models.Song;

public interface SongService {

	public List<Song> findAllSongs();
	public List<Song> findSongsByPlaylist(Playlist playlist);
	public Song findSongById(Integer id);
	public Song addSong(Song u);
	public Song updateSong(Song u);
	public Song deleteSong(Song u);
	
}
