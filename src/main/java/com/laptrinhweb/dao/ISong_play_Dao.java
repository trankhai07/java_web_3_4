package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.model.song_play;
import com.laptrinhweb.paging.PageRequest;

public interface ISong_play_Dao extends Generic_Dao<song_play>{
	List<song_play> findCategoryId(Integer id);
	List<song_play> findAll(PageRequest pageRequest);
	Integer gettotalitem();
	song_play findone(Integer id);
	void save(song_play songplay);
	void delete(Integer id);
}
