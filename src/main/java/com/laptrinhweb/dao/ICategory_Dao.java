package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.model.category;
import com.laptrinhweb.paging.PageRequest;

public interface ICategory_Dao extends Generic_Dao<category> {
	List<category> findAll(PageRequest pageRequest);
	Integer save(category cate);
	category findone(Integer id);
	category find_name(String name);
	Integer gettotalitem();
	void delete(Integer id);
	List<category> findAllbyname(PageRequest pageRequest , String name);
	Integer getotalitembyname(String name);

}
