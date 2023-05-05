package com.laptrinhweb.service;

import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.paging.PageRequest;

import java.util.List;

public interface IRank_music_Service {
    rank_music save(rank_music rk);
    rank_music findone(Integer id);
    rank_music findone_amount(Integer amountadd);
    List<rank_music> findAll(PageRequest pageRequest);
    Integer gettotalitem();
    void delete (Integer[]ids);
}
