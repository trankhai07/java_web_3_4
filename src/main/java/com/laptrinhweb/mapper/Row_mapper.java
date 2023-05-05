package com.laptrinhweb.mapper;

import java.sql.ResultSet;

public interface Row_mapper<T> {
	T mapRow(ResultSet rs);
}
