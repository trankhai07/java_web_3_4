package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.mapper.Row_mapper;

public interface Generic_Dao<T> {
	<T> List <T> query (String sql, Row_mapper<T> rowmapper, Object... parameters);
	Integer insert(String sql, Object... parametes);
	void insert_1(String sql,Object... parametes);
	void update (String sql, Object... parameters);

	Integer count(String sql,Object... parameters);
}
