package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Playlist;
import com.revature.models.User;
import com.revature.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistRepository pr;

	@Override
	public List<Playlist> findAllPlaylists() {
		return pr.findAll();
	}

	@Override
	public Playlist findPlaylistById(Integer id) {
		return pr.getOne(id);
	}

	@Override
	public Playlist addPlaylist(Playlist h) {
		return pr.save(h);
	}

	@Override
	public Playlist updatePlaylist(Playlist h) {
		return pr.save(h);
	}

	@Override
	public Playlist deletePlaylist(Playlist h) {
		pr.delete(h);
		return h;
	}

	@Override
	public List<Playlist> findPlaylistsByUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
