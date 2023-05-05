package com.laptrinhweb.dao;

import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.paging.PageRequest;

import java.util.List;

public interface IRank_music_Dao {
    Integer save(rank_music rm);
    rank_music findone(Integer id);
    List<rank_music> findAll(PageRequest pageRequest);
    Integer gettotalitem();
    rank_music findone_amount(Integer amountadd);
    void delete (Integer id);
}
