package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Playlist;
import com.revature.services.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

	@Autowired
	private PlaylistService ps;

	@GetMapping
	public List<Playlist> getAll() {

		return ps.findAllPlaylists();
	}

	@GetMapping("/{id}")
	public Playlist getPlaylistById(@PathVariable("id") Integer id) {
		return ps.findPlaylistById(id);
	}

	@PostMapping
	public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist Playlist) {
		ps.addPlaylist(Playlist);
		return new ResponseEntity<Playlist>(Playlist, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Playlist updatePlaylist(@PathVariable("id") Integer id, @RequestBody Playlist Playlist) {
		Playlist.setPlaylistId(id);
		return ps.updatePlaylist(Playlist);
	}

	@DeleteMapping("/{id}")
	public Playlist deletePlaylist(@PathVariable("id") Integer id) {
		return ps.deletePlaylist(new Playlist(id));
	}
}
