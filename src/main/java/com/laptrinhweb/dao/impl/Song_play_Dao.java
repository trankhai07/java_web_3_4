package com.laptrinhweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.dao.ISong_play_Dao;
import com.laptrinhweb.mapper.Songplay_mapper;
import com.laptrinhweb.model.song_play;
import com.laptrinhweb.paging.PageRequest;

public class Song_play_Dao extends Abstract_Dao<song_play> implements ISong_play_Dao {

	

	@Override
	public List<song_play> findCategoryId(Integer id) {
		
		String sql = "SELECT *FROM song_play WHERE id_category = ?";
		return query(sql, new Songplay_mapper(), id);
	}

	@Override
	public List<song_play> findAll(PageRequest pageRequest) {

		StringBuilder sp = new StringBuilder("SELECT *FROM song_play");
		String sortName = pageRequest.getSorter().getSortName();
		String sortBy = pageRequest.getSorter().getSortBy();
		Integer offset = pageRequest.getOffset();
		Integer limit = pageRequest.getLimit();
		if(sortName != null && sortBy != null ) sp.append(" ORDER BY "+sortName+" "+sortBy+"");
		if(offset != null && limit != null){
			sp.append(" LIMIT " + offset + ", "+limit+"");

		}
		return query(sp.toString(), new Songplay_mapper());

	}

	@Override
	public Integer gettotalitem() {
		String sql = "SELECT count(*) FROM song_play;";
		return count(sql);
	}

	@Override
	public song_play findone(Integer id) {
		String sql = "SELECT * FROM song_play Where id_music = ?";
		List<song_play> lst = query(sql,new Songplay_mapper(),id);
		return lst.isEmpty() ? null : lst.get(0);
	}

	@Override
	public void save(song_play songplay) {
		StringBuilder sql = new StringBuilder("INSERT INTO song_play(id_music,id_author,id_category,name,file_music ");
		sql.append("VALUES(?,?,?,?,?)");

		insert_1(sql.toString(),songplay.getId_music(),songplay.getId_author(),songplay.getId_category()
		,songplay.getName(),songplay.getFilemusic());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM song_play Where id_music = ?";
		update(sql,id);
	}


}
