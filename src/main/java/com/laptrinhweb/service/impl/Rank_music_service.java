package com.laptrinhweb.service.impl;

import com.laptrinhweb.dao.IRank_music_Dao;
import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.IRank_music_Service;

import javax.inject.Inject;
import java.util.List;

public class Rank_music_service implements IRank_music_Service {
    @Inject
    private IRank_music_Dao rkdao;
    @Override
    public rank_music save(rank_music rk) {
        Integer id_rank = rkdao.save(rk);
        return rkdao.findone(id_rank);
    }

    @Override
    public rank_music findone(Integer id) {
        return rkdao.findone(id);
    }

    @Override
    public rank_music findone_amount(Integer amountadd) {
        return rkdao.findone_amount(amountadd);
    }

    @Override
    public List<rank_music> findAll(PageRequest pageRequest) {
        return rkdao.findAll(pageRequest);
    }

    @Override
    public Integer gettotalitem() {
       return rkdao.gettotalitem();
    }

    @Override
    public void delete(Integer[] ids) {
        for(int i = 0;i < ids.length;i ++){
            rkdao.delete(ids[i]);
        }
    }
}
