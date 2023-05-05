package com.laptrinhweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.dao.IAuthor_Dao;
import com.laptrinhweb.dao.ICategory_Dao;
import com.laptrinhweb.dao.IRank_music_Dao;
import com.laptrinhweb.dao.ISong_play_Dao;
import com.laptrinhweb.model.author;
import com.laptrinhweb.model.category;
import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.model.song_play;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.IRank_music_Service;
import com.laptrinhweb.service.ISong_play_Service;

public class Song_play_Service implements ISong_play_Service{

	@Inject 
	private ISong_play_Dao songplaydao;
	@Inject
	private ICategory_Dao categoryDao;
	@Inject
	private IAuthor_Dao authorDao;
	@Inject
	private IRank_music_Dao rkdao;
	
	@Override
	public List<song_play> findCategoryId(Integer id) {
		return songplaydao.findCategoryId(id);
	}



	@Override
	public List<song_play> findAll(PageRequest pageRequest) {
		return songplaydao.findAll(pageRequest);
	}

	@Override
	public Integer gettotalitem() {
		return songplaydao.gettotalitem();
	}

	@Override
	public song_play findone(Integer id) {
		song_play newsongplay =  songplaydao.findone(id);
		category newcategory = categoryDao.findone(newsongplay.getId_category());
		author newauthor = authorDao.findone(newsongplay.getId_author());
		newsongplay.setAuthor_name(newauthor.getName());
		newsongplay.setCategorycode(newcategory.getName());
		 return newsongplay;
	}

	@Override
	public void save(song_play songplay) {
		category newcategory = categoryDao.find_name(songplay.getCategorycode());
		author newauthor = authorDao.find_name(songplay.getAuthor_name());
//		rank_music rkm = rkdao.findone_amount(songplay.getAmount_add());
		songplay.setId_music(songplay.getAmount_add());
		songplay.setId_category(newcategory.getId_category());
		songplay.setId_author(newauthor.getId_author());
		songplaydao.save(songplay);

	}

	@Override
	public void delete(Integer[] ids) {
		for(int i = 0; i < ids.length;i ++){
			songplaydao.delete(ids[i]);
		}
	}

}
