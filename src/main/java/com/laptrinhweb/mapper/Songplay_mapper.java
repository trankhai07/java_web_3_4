package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.song_play;

public class Songplay_mapper implements Row_mapper<song_play>{

	@Override
	public song_play mapRow(ResultSet rs) {
		try {
			song_play song_p = new song_play();
			song_p.setId_author(rs.getInt("id_author"));
			song_p.setId_category(rs.getInt("id_category"));
			song_p.setId_music(rs.getInt("id_music"));
			song_p.setName(rs.getNString("name"));
			song_p.setFilemusic(rs.getNString("file_music"));
			return song_p;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
