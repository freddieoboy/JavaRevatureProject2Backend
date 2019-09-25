package com.revature.dao;

import java.util.List;

import com.revature.model.Playlist;
import com.revature.model.Song;

public interface SongDao {

	public List<Song> getSongs();
	public List<Song> getSongsByPlaylist(Playlist p);
	
	public Song getSongById(int id);
	
	public int createSong(Song s);
	public void updateSong(Song s);
	public void deleteSongById(int id);
	
}
