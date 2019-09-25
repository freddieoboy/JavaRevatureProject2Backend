package com.revature.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.PlaylistDao;
import com.revature.model.Playlist;
import com.revature.model.Song;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class PlaylistDaoImpl implements PlaylistDao {

	private static Logger log = Logger.getRootLogger();
	
	@Override
	public List<Playlist> getPlaylists() {
		List<Playlist> playlists = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Playlist> cq = cb.createQuery(Playlist.class);
			
			cq.select(cq.from(Playlist.class));
			
			Query<Playlist> query = s.createQuery(cq);
			playlists = query.list();
			log.info("getting all Playlistz");
		}
		return playlists;
	}

	@Override
	public List<Playlist> getPlaylistByUser(User u) {
		List<Playlist> playlists = null;
		try (Session s = HibernateUtil.getSession()) {
			CriteriaQuery<Playlist> c = s.getCriteriaBuilder().createQuery(Playlist.class);
			Root<Playlist> from = c.from(Playlist.class);

			c.select(from);
			c.where(s.getCriteriaBuilder().equal(from.get("user_id"), u.getUserId()));
			playlists = s.createQuery(c).getResultList(); 	
		}
		return playlists;
	}

	@Override
	public Playlist getPlaylistById(int id) {
		try(Session s = HibernateUtil.getSession()){
			Playlist p = s.get(Playlist.class, id);
			log.info("getting Playlist"+p);
			return p;
		}
	}

	@Override
	public int createPlaylist(Playlist p) {
		int pk =0;
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			pk = (int) s.save(p);
			tx.commit();
		}
		return pk;
	}

	@Override
	public void updatePlaylist(Playlist p) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(p);
			tx.commit();
		}		
	}

	@Override
	public void deletePlaylistById(int id) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(new Playlist(id));
			tx.commit();
		}		
	}

}
