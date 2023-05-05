package com.laptrinhweb.service.impl;

import com.laptrinhweb.dao.IAuthor_Dao;
import com.laptrinhweb.model.author;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.IAuthor_service;

import javax.inject.Inject;
import java.util.List;

public class Author_service implements IAuthor_service {
    @Inject
    private IAuthor_Dao authordao;
    @Override
    public List<author> findAll(PageRequest pageRequest) {
        return authordao.findAll(pageRequest);
    }

    @Override
    public author findone(Integer id) {
        return authordao.findone(id);
    }

    @Override
    public Integer gettotalitem() {
        return authordao.gettotalitem();
    }

    @Override
    public author save(author at) {
        Integer id_at = authordao.save(at);
        return authordao.findone(id_at);
    }

    @Override
    public void delete(Integer[] ids) {
        for(int i = 0;i < ids.length;i ++){
            authordao.delete(ids[i]);
        }
    }
}
