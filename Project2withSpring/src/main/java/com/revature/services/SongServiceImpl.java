package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Playlist;
import com.revature.models.Song;
import com.revature.repositories.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository sr;

	@Override
	public List<Song> findAllSongs() {
		return sr.findAll();
	}

	@Override
	public Song findSongById(Integer id) {
		return sr.getOne(id);
	}

	@Override
	public Song addSong(Song h) {
		return sr.save(h);
	}

	@Override
	public Song updateSong(Song h) {
		return sr.save(h);
	}

	@Override
	public Song deleteSong(Song h) {
		sr.delete(h);
		return h;
	}

	@Override
	public List<Song> findSongsByPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
