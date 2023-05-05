package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.model.category;
import com.laptrinhweb.paging.PageRequest;
import com.opensymphony.module.sitemesh.Page;

public interface ICategory_Service {
	List<category> findAll(PageRequest pageRequest);
	category save (category cate);

	category findone(Integer id);
	Integer gettotalitem();
	Integer gettotalitembyname(String name);
	void delete(Integer[] ids);
	List<category>findAllbyname(PageRequest pageRequest,String name);
}
