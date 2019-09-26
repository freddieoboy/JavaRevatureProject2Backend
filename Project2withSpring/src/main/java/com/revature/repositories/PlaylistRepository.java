package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Playlist;
import com.revature.models.User;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	public List<Playlist> findPlaylistsByUser(User user);
}
