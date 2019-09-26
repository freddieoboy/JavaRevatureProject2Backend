package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Playlist;
import com.revature.models.Song;
import com.revature.models.User;

public interface SongRepository extends JpaRepository<Song, Integer> {

	public List<Song> findSongsByPlaylist(Playlist playlist);
	public List<Song> findSongsByPlaylistUser(User user);
	
}
