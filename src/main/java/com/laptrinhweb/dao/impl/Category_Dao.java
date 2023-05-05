package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.ICategory_Dao;

import com.laptrinhweb.mapper.Category_mapper;
import com.laptrinhweb.model.category;
import com.laptrinhweb.paging.PageRequest;

public class Category_Dao extends Abstract_Dao<category> implements ICategory_Dao {


	@Override
	public List<category> findAll(PageRequest pageRequest) {

		StringBuilder sp = new StringBuilder("SELECT *FROM category");
		String sortName = pageRequest.getSorter().getSortName();
		String sortBy = pageRequest.getSorter().getSortBy();
		Integer offset = pageRequest.getOffset();
		Integer limit = pageRequest.getLimit();
		if(sortName != null && sortBy != null ) sp.append(" ORDER BY "+sortName+" "+sortBy+"");
		if(offset != null && limit != null){
			sp.append(" LIMIT " + offset + ", "+limit+"");

		}
		return query(sp.toString(), new Category_mapper());
	}

	@Override
	public Integer save(category cate) {
		
			String sql = "INSERT INTO category(name,description) VALUES(?,?)";
		   return insert(sql, cate.getName(),cate.getDescription());
	}

	@Override
	public category findone(Integer id) {
		String sql = "SELECT *FROM category Where id_category = ?";
		List<category> lst = query(sql, new Category_mapper(),id);
		return lst.isEmpty() ? null:lst.get(0);
	}

	@Override
	public category find_name(String name) {
		String sql = "SELECT *FROM category Where name = ?";
		List<category> lst = query(sql, new Category_mapper(),name);
		return lst.isEmpty() ? null:lst.get(0);
	}

	@Override
	public Integer gettotalitem() {
		String sql = "SELECT count(*) FROM category ";
		return count(sql);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM category Where id_category = ?";
		update(sql,id);
	}

	@Override
	public List<category> findAllbyname(PageRequest pageRequest, String name) {
		StringBuilder sp = new StringBuilder("SELECT *FROM category Where name = ?");
		String sortName = pageRequest.getSorter().getSortName();
		String sortBy = pageRequest.getSorter().getSortBy();
		Integer offset = pageRequest.getOffset();
		Integer limit = pageRequest.getLimit();
		if(sortName != null && sortBy != null ) sp.append(" ORDER BY "+sortName+" "+sortBy+"");
		if(offset != null && limit != null){
			sp.append(" LIMIT " + offset + ", "+limit+"");

		}
		return query(sp.toString(), new Category_mapper(),name);
	}

	@Override
	public Integer getotalitembyname(String name) {
		String sql = "SELECT count(*) FROM category Where name = ?";
		return count(sql,name);
	}


}
