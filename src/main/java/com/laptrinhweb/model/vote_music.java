package com.laptrinhweb.model;

public class vote_music {
	private int id_vote;
	public int getId_vote() {
		return id_vote;
	}
	public void setId_vote(int id_vote) {
		this.id_vote = id_vote;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_music() {
		return id_music;
	}
	public void setId_music(int id_music) {
		this.id_music = id_music;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	private int id_user;
	private int id_music;
	private int vote;
	
}
