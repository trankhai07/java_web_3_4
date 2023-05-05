package com.laptrinhweb.dao;

import com.laptrinhweb.model.author;
import com.laptrinhweb.paging.PageRequest;

import java.util.List;

public interface IAuthor_Dao {
    List<author> findAll(PageRequest pageRequest);
    author findone(Integer id);
    author find_name(String name);
    Integer gettotalitem();
    Integer save(author at);
    void delete(Integer id);
}
