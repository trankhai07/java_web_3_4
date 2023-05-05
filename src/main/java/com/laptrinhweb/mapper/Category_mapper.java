package com.laptrinhweb.mapper;

import java.sql.SQLException;

import com.laptrinhweb.model.category;
import java.sql.ResultSet;


public class Category_mapper implements Row_mapper<category> {

	@Override
	public category mapRow(ResultSet rs) {
		category ct = new category();
		try {
			ct.setId_category(rs.getInt("id_category"));
			ct.setDescription(rs.getNString("description"));
			ct.setName(rs.getNString("name"));
			return ct;
		} catch (SQLException e) {
			return null;
		}
		
		
	}

}
