package com.laptrinhweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.dao.ICategory_Dao;
import com.laptrinhweb.model.category;
import com.laptrinhweb.paging.PageRequest;
import com.laptrinhweb.service.ICategory_Service;

public class Category_Service implements ICategory_Service {

	@Inject
	private ICategory_Dao ctdao;
	
	@Override
	public List<category> findAll(PageRequest pageRequest) {
		return ctdao.findAll(pageRequest);
	}

	@Override
	public category save(category cate) {
		Integer id = ctdao.save(cate);
		return ctdao.findone(id);
	}

	@Override
	public category findone(Integer id) {
		return ctdao.findone(id);
	}

	@Override
	public Integer gettotalitem() {
		return ctdao.gettotalitem();
	}

	@Override
	public Integer gettotalitembyname(String name) {
		return ctdao.getotalitembyname(name);
	}

	@Override
	public void delete(Integer[] ids) {
		for(int i = 0; i < ids.length;i ++){
			ctdao.delete(ids[i]);
		}
	}

	@Override
	public List<category> findAllbyname(PageRequest pageRequest, String name) {
		return ctdao.findAllbyname(pageRequest,name);
	}


}
