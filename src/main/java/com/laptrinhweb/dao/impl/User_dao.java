package com.laptrinhweb.dao.impl;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.mapper.Usermapper;
import com.laptrinhweb.model.user;

import java.util.List;

public class User_dao extends Abstract_Dao<user> implements IUserDao {
    @Override
    public user findusernameandpassword(String username, String password) {
        StringBuilder sql = new StringBuilder("SELECT *FROM user AS u");
        sql.append(" INNER JOIN roleid AS ro ON u.id_role = ro.id_role");
//        sql.append(" WHERE username ="+username+" AND password ="+password+"");
        sql.append(" WHERE username = ? AND password = ?");
        List<user> lst = query(sql.toString(),new Usermapper(),username,password);

        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public Integer save(user us) {
        String sql="INSERT INTO user(name,username,password,id_role) VALUES(?,?,?,?)";
        return insert(sql,us.getName(),us.getUsername(),us.getPassword(),us.getId_role());
    }

    @Override
    public user check_user_password(String username,String password) {
        StringBuilder sql = new StringBuilder("SELECT *FROM user");
        sql.append(" WHERE username = ? AND password = ?");
        List<user> lst = query(sql.toString(),new Usermapper(),username,password);
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM user Where id_user = ?";
        update(sql,id);
    }
}
