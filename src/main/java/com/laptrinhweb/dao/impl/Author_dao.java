package com.laptrinhweb.dao.impl;

import com.laptrinhweb.dao.IAuthor_Dao;
import com.laptrinhweb.mapper.Author_mapper;
import com.laptrinhweb.mapper.rank_mapper;
import com.laptrinhweb.model.author;
import com.laptrinhweb.paging.PageRequest;

import java.util.List;

public class Author_dao extends Abstract_Dao<author> implements IAuthor_Dao {
    @Override
    public List<author> findAll(PageRequest pageRequest) {
        StringBuilder sp = new StringBuilder("SELECT *FROM author");
        String sortName = pageRequest.getSorter().getSortName();
        String sortBy = pageRequest.getSorter().getSortBy();
        Integer offset = pageRequest.getOffset();
        Integer limit = pageRequest.getLimit();
        if(sortName != null && sortBy != null ) sp.append(" ORDER BY "+sortName+" "+sortBy+"");
        if(offset != null && limit != null){
            sp.append(" LIMIT " + offset + ", "+limit+"");

        }
        return query(sp.toString(), new Author_mapper());

    }

    @Override
    public author findone(Integer id) {
        String sql = "SELECT *FROM author Where id_author = ?";
        List<author> lst = query(sql,new Author_mapper(),id);
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public author find_name(String name) {
        String sql = "SELECT *FROM author Where name = ?";
        List<author> lst = query(sql,new Author_mapper(),name);
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public Integer gettotalitem() {
        String sql = "SELECT count(*) FROM author";
        return count(sql);
    }

    @Override
    public Integer save(author at) {
            String sql = "INSERT INTO author(name,information) VALUES(?,?)";
            return insert(sql,at.getName(),at.getInformation());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM author Where id_author = ?";
        update(sql,id);
    }
}
