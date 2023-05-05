package com.laptrinhweb.service;

import com.laptrinhweb.model.user;

public interface IUser_service {
    user findusernameandpassword(String username, String password);
//    Integer check_user_password(String username,String password);
    Integer save(user us);
    user check_user_password(String username,String password);
    void delete(Integer[]ids);
}
