package com.laptrinhweb.dao;

import com.laptrinhweb.model.user;

public interface IUserDao extends Generic_Dao<user>{
    user findusernameandpassword(String username,String password);
    Integer save(user us);
    user check_user_password(String username,String password);
    void delete(Integer id);
}
