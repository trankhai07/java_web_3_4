package com.laptrinhweb.mapper;

import com.laptrinhweb.model.Roleid;
import com.laptrinhweb.model.song_play;
import com.laptrinhweb.model.user;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usermapper implements Row_mapper<user>{
    @Override
    public user mapRow(ResultSet rs) {
        try {
            user mode = new user();
            mode.setId_user(rs.getInt("id_user"));
            mode.setName(rs.getString("name"));
            mode.setAge(rs.getInt("age"));
            mode.setSex(rs.getString("sex"));
            mode.setId_category(rs.getInt("id_category"));
            mode.setUsername(rs.getString("username"));
            mode.setPassword(rs.getString("password"));
            mode.setAvatar("");

            try {
                Roleid roleid = new Roleid();
                roleid.setId_role(rs.getInt("id_role"));
                roleid.setRole_code(rs.getString("role_code"));
                roleid.setRole_name(rs.getString("role_name"));

                mode.setRoleid(roleid);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return  mode;
        } catch (SQLException e) {
            return null;
        }
    }
}
