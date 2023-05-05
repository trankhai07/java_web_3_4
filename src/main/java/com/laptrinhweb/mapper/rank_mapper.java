package com.laptrinhweb.mapper;

import com.laptrinhweb.model.rank_music;

import java.sql.ResultSet;
import java.sql.SQLException;

public class rank_mapper implements  Row_mapper<rank_music>{
    @Override
    public rank_music mapRow(ResultSet rs) {
        try {
            rank_music rm =  new rank_music();
            rm.setId_music(rs.getInt("id_music"));
            rm.setAmount_add(rs.getInt("amount_add"));
            return rm;
        } catch (SQLException e) {
            return null;
        }

    }
}
