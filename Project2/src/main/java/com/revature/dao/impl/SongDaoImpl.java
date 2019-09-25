package com.revature.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.SongDao;
import com.revature.model.Playlist;
import com.revature.model.Song;
import com.revature.util.HibernateUtil;

public class SongDaoImpl implements SongDao {

	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Song> getSongs() {
		List<Song> songs = null;
		try (Session s = HibernateUtil.getSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Song> cq = cb.createQuery(Song.class);

			cq.select(cq.from(Song.class));

			Query<Song> query = s.createQuery(cq);
			songs = query.list();
			log.info("getting all users");
		}
		return songs;
	}

	@Override
	public List<Song> getSongsByPlaylist(Playlist p) {
		List<Song> songs = null;
		try (Session s = HibernateUtil.getSession()) {
			CriteriaQuery<Song> c = s.getCriteriaBuilder().createQuery(Song.class);
			Root<Song> from = c.from(Song.class);

			c.select(from);
			c.where(s.getCriteriaBuilder().equal(from.get("playlist_id"), p.getPlaylistId()));
			songs = s.createQuery(c).getResultList(); 	
		}
		return songs;
	}

	@Override
	public Song getSongById(int id) {
		try (Session s = HibernateUtil.getSession()) {
			Song song = s.get(Song.class, id);
			log.info("getting User" + song);
			return song;
		}
	}

	@Override
	public int createSong(Song song) {
		int pk = 0;
		try (Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			pk = (int) s.save(song);
			tx.commit();
		}
		return pk;
	}

	@Override
	public void updateSong(Song song) {
		try (Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.update(song);
			tx.commit();
		}
	}

	@Override
	public void deleteSongById(int id) {
		try (Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(new Song(id));
			tx.commit();
		}
	}

}
