package com.revature.dao;

import java.util.List;

import com.revature.model.Playlist;
import com.revature.model.User;

public interface PlaylistDao {

	public List<Playlist> getPlaylists();
	public List<Playlist> getPlaylistByUser(User u);
	
	public Playlist getPlaylistById(int id);
	
	public int createPlaylist(Playlist p);
	public void updatePlaylist(Playlist p);
	public void deletePlaylistById(int id);
	
}
