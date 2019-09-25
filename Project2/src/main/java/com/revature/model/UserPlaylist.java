package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Embeddable
@Table (name="uspl", schema="proj2")
public class UserPlaylist {
	
	@ManyToMany
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany
	@JoinColumn(name="user_id")
	private Playlist playlist;
	
	@Column (name="is_playlist_owner")
	private boolean isPlaylistOwner;
	
	@Column (name="allow_edit")
	private boolean allowEdit;

}
