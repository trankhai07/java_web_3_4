package com.laptrinhweb.dao.impl;

import com.laptrinhweb.dao.IRank_music_Dao;
import com.laptrinhweb.mapper.Songplay_mapper;
import com.laptrinhweb.mapper.rank_mapper;
import com.laptrinhweb.model.rank_music;
import com.laptrinhweb.paging.PageRequest;

import java.util.List;

public class Rank_music_dao extends Abstract_Dao<rank_music> implements IRank_music_Dao {
    @Override
    public Integer save(rank_music rm) {
        String sql="INSERT INTO rank_music(amount_add) VALUES(?)";
        return insert(sql,rm.getAmount_add());
    }

    @Override
    public rank_music findone(Integer id) {
        String sql="SELECT *FROM rank_music Where id_music = ?";
        List<rank_music> lst = query(sql,new rank_mapper(),id);
        return lst.isEmpty()?null:lst.get(0);
    }

    @Override
    public List<rank_music> findAll(PageRequest pageRequest) {
        StringBuilder sp = new StringBuilder("SELECT *FROM rank_music");
        String sortName = pageRequest.getSorter().getSortName();
        String sortBy = pageRequest.getSorter().getSortBy();
        Integer offset = pageRequest.getOffset();
        Integer limit = pageRequest.getLimit();
        if(sortName != null && sortBy != null ) sp.append(" ORDER BY "+sortName+" "+sortBy+"");
        if(offset != null && limit != null){
            sp.append(" LIMIT " + offset + ", "+limit+"");

        }
        return query(sp.toString(), new rank_mapper());
    }

    @Override
    public Integer gettotalitem() {
        String sql = "SELECT count(*) FROM rank_music";
        return count(sql);
    }

    @Override
    public rank_music findone_amount(Integer amountadd) {
         String sql = "SELECT *FROM rank_music Where amount_add = ?";
         List<rank_music> lst = query(sql,new rank_mapper(),amountadd);
         return lst.isEmpty()?null:lst.get(0);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM rank_music where id_music = ?";
        update(sql,id);
    }
}
