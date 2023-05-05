package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.model.song_play;
import com.laptrinhweb.paging.PageRequest;

public interface ISong_play_Service {
	List<song_play> findCategoryId(Integer id);
	List<song_play> findAll(PageRequest pageRequest);

	Integer gettotalitem();
	song_play findone(Integer id);
	void save(song_play songplay);
	void delete(Integer[]ids);
}
