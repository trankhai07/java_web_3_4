package com.laptrinhweb.mapper;

import com.laptrinhweb.model.author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Author_mapper implements Row_mapper<author>{
    @Override
    public author mapRow(ResultSet rs) {
        try {
            author nauthor = new author();
            nauthor.setId_author(rs.getInt("id_author"));
            nauthor.setName(rs.getString("name"));
            nauthor.setInformation(rs.getString("information"));

            return nauthor;
        }catch (SQLException e){
            return null;
        }
    }
}
