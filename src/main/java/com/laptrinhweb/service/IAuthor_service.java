package com.laptrinhweb.service;

import com.laptrinhweb.model.author;
import com.laptrinhweb.paging.PageRequest;

import java.util.List;

public interface IAuthor_service {
    List<author> findAll(PageRequest pageRequest);
    author findone(Integer id);
    Integer gettotalitem();
    author save(author at);
    void delete(Integer[]ids);
}
